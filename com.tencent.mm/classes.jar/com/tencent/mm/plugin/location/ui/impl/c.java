package com.tencent.mm.plugin.location.ui.impl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.location.ui.MyPoiPoint;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.PoiPoint;
import com.tencent.mm.plugin.location.ui.PoiPoint.a;
import com.tencent.mm.plugin.location.ui.PoiPoint.b;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.SimpleImageView.a;
import com.tencent.mm.protocal.protobuf.axp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends b
  implements com.tencent.mm.al.g
{
  private static int sVc = 11;
  private static int sVd = 12;
  private static int sVe = 13;
  private static int sVf = 14;
  private com.tencent.mm.modelgeo.b.a fjJ;
  private String hpg;
  private double lat;
  private double lng;
  private String sOK;
  private int sOL;
  PoiPoint.a sRu;
  private MMLoadMoreListView sUA;
  private e sUB;
  private e sUC;
  private View sUD;
  private ImageButton sUE;
  private com.tencent.mm.plugin.location.model.i sUF;
  private View sUG;
  private View sUH;
  private TextView sUI;
  private LinearLayout sUJ;
  private MyPoiPoint sUK;
  private double sUL;
  private double sUM;
  private boolean sUN;
  private int sUO;
  private RelativeLayout sUP;
  private int sUQ;
  private int sUR;
  private int sUS;
  private boolean sUT;
  private boolean sUU;
  private boolean sUV;
  private FrameLayout sUW;
  private int sUX;
  private long sUY;
  private long sUZ;
  private FrameLayout sUo;
  private PoiHeaderView sUx;
  private PickPoi sUy;
  private MMLoadMoreListView sUz;
  private boolean sVA;
  private InputPanelFrameLayout sVB;
  private long sVa;
  private int sVb;
  private boolean sVg;
  private boolean sVh;
  private int[] sVi;
  private int[] sVj;
  private View sVk;
  private int sVl;
  private View sVm;
  private View sVn;
  private EditText sVo;
  private ImageView sVp;
  private View sVq;
  private View.OnTouchListener sVr;
  private PoiPoint sVs;
  private Map<String, PoiPoint> sVt;
  private boolean sVu;
  private f sVv;
  private boolean sVw;
  private boolean sVx;
  private boolean sVy;
  private boolean sVz;
  private View sss;
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56033);
    this.sUF = null;
    this.lat = -85.0D;
    this.lng = -1000.0D;
    this.sUL = -85.0D;
    this.sUM = -1000.0D;
    this.sOK = "";
    this.sUN = false;
    this.hpg = "";
    this.sUO = 0;
    this.sUT = true;
    this.sUU = false;
    this.sUV = false;
    this.sUX = 0;
    this.sUY = -1L;
    this.sUZ = -1L;
    this.sVa = -1L;
    this.sVb = -1;
    this.sVg = false;
    this.sOL = 1;
    this.sVi = new int[] { 24, 24 };
    this.sVt = new HashMap();
    this.sVv = new f();
    this.sVw = false;
    this.fjJ = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(182065);
        if (!paramAnonymousBoolean)
        {
          if ((!c.Q(c.this)) && (!com.tencent.mm.modelgeo.d.axU()))
          {
            c.R(c.this);
            com.tencent.mm.ui.base.h.a(c.this.activity, c.this.activity.getString(2131760082), c.this.activity.getString(2131755906), c.this.activity.getString(2131760598), c.this.activity.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(182064);
                com.tencent.mm.modelgeo.d.cv(c.this.activity);
                AppMethodBeat.o(182064);
              }
            }, null);
          }
          AppMethodBeat.o(182065);
          return false;
        }
        if (!c.S(c.this))
        {
          AppMethodBeat.o(182065);
          return true;
        }
        String str;
        if ((c.e(c.this) == -85.0D) || (c.f(c.this) == -1000.0D))
        {
          ad.d("MicroMsg.MMPoiMapUI", "init my location.");
          str = (int)(1000000.0F * paramAnonymousFloat2) + "," + (int)(1000000.0F * paramAnonymousFloat1);
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FjH, str);
          c.c(c.this, paramAnonymousFloat2);
          c.d(c.this, paramAnonymousFloat1);
          c.b(c.this).m(c.e(c.this), c.f(c.this));
          c.n(c.this).m(c.e(c.this), c.f(c.this));
          if (c.T(c.this))
          {
            c.U(c.this);
            AppMethodBeat.o(182065);
            return true;
          }
          c.a(c.this, c.e(c.this));
          c.b(c.this, c.f(c.this));
          c.a(c.this).l(c.i(c.this), c.j(c.this));
          c.this.sSd.getIController().animateTo(c.e(c.this), c.f(c.this), com.tencent.mm.plugin.location.ui.d.cJD());
          if (!c.g(c.this)) {
            c.l(c.this);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(182065);
          return true;
          if ((c.e(c.this) != paramAnonymousFloat2) || (c.f(c.this) != paramAnonymousFloat1))
          {
            ad.d("MicroMsg.MMPoiMapUI", "update lat/lng.");
            str = (int)(1000000.0F * paramAnonymousFloat2) + "," + (int)(1000000.0F * paramAnonymousFloat1);
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.FjH, str);
            c.c(c.this, paramAnonymousFloat2);
            c.d(c.this, paramAnonymousFloat1);
          }
        }
      }
    };
    this.sVx = false;
    this.sVy = false;
    this.sVz = false;
    this.sVA = false;
    AppMethodBeat.o(56033);
  }
  
  private String a(double paramDouble, String paramString)
  {
    AppMethodBeat.i(56042);
    paramString = (int)(paramDouble * 1000000.0D) + "_" + (int)(this.lng * 1000000.0D) + "_" + paramString;
    AppMethodBeat.o(56042);
    return paramString;
  }
  
  private void a(final c.c paramc)
  {
    AppMethodBeat.i(56037);
    if (((c.c.sVJ == paramc) && (this.sUV)) || ((c.c.sVI == paramc) && (!this.sUV)))
    {
      AppMethodBeat.o(56037);
      return;
    }
    if (this.sVk.getVisibility() != 0) {
      this.sVk.setVisibility(0);
    }
    this.sUT = false;
    int i;
    a locala2;
    a locala1;
    if (c.c.sVJ == paramc)
    {
      ad.d("MicroMsg.MMPoiMapUI", "pennqin play open animation, getListTopMargin(): %d, openedTopMargin: %d.", new Object[] { Integer.valueOf(cKp()), Integer.valueOf(this.sUR) });
      i = cKp() - this.sUR;
      ad.d("MicroMsg.MMPoiMapUI", "pennqin play open animation (getListTopMargin() - openedTopMargin): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(-i);
      locala1 = new a(-this.sUS);
    }
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.sVl });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.sVl, 0 }))
    {
      paramc = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(182057);
          c.f(c.this, true);
          if (c.c.sVJ == paramc)
          {
            c.g(c.this, true);
            if (c.g(c.this))
            {
              if (!c.z(c.this)) {
                break label171;
              }
              c.c(c.this, false);
            }
          }
          for (;;)
          {
            c.b(c.this, paramc);
            c.B(c.this).clearAnimation();
            c.h(c.this).clearAnimation();
            c.C(c.this).clearAnimation();
            if (!c.D(c.this)) {
              break label242;
            }
            c.h(c.this, false);
            if ((!c.n(c.this).oiJ.equals(c.E(c.this))) || (!c.n(c.this).cBN)) {
              break;
            }
            c.F(c.this);
            AppMethodBeat.o(182057);
            return;
            label171:
            c.A(c.this);
            continue;
            c.g(c.this, false);
            c.c(c.this);
            if (c.g(c.this)) {
              c.a(c.this, c.n(c.this).rZ);
            }
          }
          c.G(c.this);
          c.l(c.this);
          label242:
          AppMethodBeat.o(182057);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(182056);
          ad.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          c.f(c.this, false);
          c.b(c.this, true);
          AppMethodBeat.o(182056);
        }
      };
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(182058);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          paramAnonymousValueAnimator = c.x(c.this).getLayoutParams();
          paramAnonymousValueAnimator.height = i;
          c.x(c.this).setLayoutParams(paramAnonymousValueAnimator);
          AppMethodBeat.o(182058);
        }
      });
      locala2 = locala2.cKt().cKu();
      locala2.setAnimationListener(paramc);
      locala2.dY(this.sUP).dY(this.sUE).startAnimation();
      locala1.cKt().cKu().dY(this.sUW).startAnimation();
      localValueAnimator.setDuration(200L).start();
      AppMethodBeat.o(56037);
      return;
      ad.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation, getListTopMargin(): %d, collapsedTopMargin: %d.", new Object[] { Integer.valueOf(cKp()), Integer.valueOf(this.sUQ) });
      i = this.sUQ - cKp();
      ad.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation (collapsedTopMargin - getListTopMargin()): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(i);
      locala1 = new a(this.sUS);
    }
  }
  
  private void b(c.c paramc)
  {
    AppMethodBeat.i(56055);
    if (c.c.sVI == paramc)
    {
      ((FrameLayout.LayoutParams)this.sUP.getLayoutParams()).topMargin = this.sUQ;
      ((RelativeLayout.LayoutParams)this.sUW.getLayoutParams()).topMargin = 0;
      ((FrameLayout.LayoutParams)this.sUE.getLayoutParams()).topMargin = (this.sUQ - ao.fromDPToPix(this.activity, 92));
      this.sSd.setLogoMargin(this.sVi);
    }
    for (;;)
    {
      this.sUP.requestLayout();
      this.sUE.requestLayout();
      this.sUW.requestLayout();
      AppMethodBeat.o(56055);
      return;
      if (c.c.sVJ == paramc)
      {
        ((FrameLayout.LayoutParams)this.sUP.getLayoutParams()).topMargin = this.sUR;
        ((RelativeLayout.LayoutParams)this.sUW.getLayoutParams()).topMargin = (-this.sUS);
        ((FrameLayout.LayoutParams)this.sUE.getLayoutParams()).topMargin = (this.sUR - ao.fromDPToPix(this.activity, 92));
        this.sSd.setLogoMargin(this.sVj);
      }
    }
  }
  
  private boolean cKk()
  {
    AppMethodBeat.i(56035);
    double d1 = this.activity.getIntent().getDoubleExtra("KPickPoiLat", -85.0D);
    double d2 = this.activity.getIntent().getDoubleExtra("KPickPoiLong", -85.0D);
    if ((d1 != -85.0D) && (d2 != -1000.0D))
    {
      AppMethodBeat.o(56035);
      return true;
    }
    AppMethodBeat.o(56035);
    return false;
  }
  
  private void cKl()
  {
    AppMethodBeat.i(56039);
    this.sUN = false;
    this.sUo.setVisibility(0);
    a(c.c.sVI);
    cKq();
    this.hpg = "";
    this.sUA.setVisibility(8);
    this.sUB.notifyDataSetChanged();
    this.sUz.setVisibility(0);
    this.sUD.setVisibility(8);
    this.sUI.setVisibility(8);
    cKn();
    mL(true);
    this.sUE.setSelected(this.sVw);
    this.sSd.getIController().animateTo(this.lat, this.lng);
    AppMethodBeat.o(56039);
  }
  
  private void cKm()
  {
    AppMethodBeat.i(56043);
    if (this.sUy.sVN)
    {
      f localf = this.sUy.getPoi();
      e locale = this.sUB;
      if (locale.sVR.size() >= 0)
      {
        locale.sVR.add(0, localf);
        locale.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(56043);
  }
  
  private void cKn()
  {
    AppMethodBeat.i(56050);
    Iterator localIterator = this.sVt.values().iterator();
    while (localIterator.hasNext()) {
      ((PoiPoint)localIterator.next()).remove();
    }
    this.sVt.clear();
    this.sVs = null;
    AppMethodBeat.o(56050);
  }
  
  private void cKo()
  {
    AppMethodBeat.i(56051);
    Object localObject = new ArrayList(5);
    int i = 0;
    while ((i < 5) && (i < this.sUC.getCount()))
    {
      ((List)localObject).add(this.sUC.FH(i));
      i += 1;
    }
    localObject = dY((List)localObject);
    cKn();
    i = 0;
    while (i < ((List)localObject).size())
    {
      f localf = this.sUC.FH(i);
      PoiPoint localPoiPoint = new PoiPoint(this.activity, this.sSd);
      localPoiPoint.setPosition(i);
      localPoiPoint.setOnPointClick(this.sRu);
      this.sVt.put(localf.bPI + localf.bPJ, localPoiPoint);
      localPoiPoint.c(localf.bPI, localf.bPJ, false);
      i += 1;
    }
    dZ((List)localObject);
    AppMethodBeat.o(56051);
  }
  
  private int cKp()
  {
    AppMethodBeat.i(56056);
    int i = ((ViewGroup.MarginLayoutParams)this.sUP.getLayoutParams()).topMargin;
    AppMethodBeat.o(56056);
    return i;
  }
  
  private void cKq()
  {
    AppMethodBeat.i(56057);
    if (this.sUN)
    {
      this.sVm.setVisibility(8);
      this.sVn.setVisibility(0);
      this.sVq.setVisibility(0);
      AppMethodBeat.o(56057);
      return;
    }
    this.sVm.setVisibility(0);
    this.sVn.setVisibility(8);
    this.sVq.setVisibility(8);
    AppMethodBeat.o(56057);
  }
  
  private void cKr()
  {
    AppMethodBeat.i(56058);
    if (!this.sVy)
    {
      this.sVy = true;
      this.sVo.requestFocus();
      InputMethodManager localInputMethodManager = (InputMethodManager)this.activity.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        View localView = this.activity.getCurrentFocus();
        if ((localView != null) && (localView.getWindowToken() != null)) {
          localInputMethodManager.toggleSoftInput(0, 2);
        }
      }
    }
    AppMethodBeat.o(56058);
  }
  
  private static List<f> dY(List<f> paramList)
  {
    AppMethodBeat.i(56052);
    ArrayList localArrayList = new ArrayList(5);
    int i = 0;
    if (i < paramList.size())
    {
      if (i == 0) {
        localArrayList.add(paramList.get(0));
      }
      for (;;)
      {
        i += 1;
        break;
        f localf1 = (f)paramList.get(i);
        f localf2 = (f)localArrayList.get(localArrayList.size() - 1);
        if (TencentLocationUtils.distanceBetween(localf1.bPI, localf1.bPJ, localf2.bPI, localf2.bPJ) > 5000.0D) {
          break label121;
        }
        localArrayList.add(localf1);
      }
    }
    label121:
    AppMethodBeat.o(56052);
    return localArrayList;
  }
  
  private void dZ(List<f> paramList)
  {
    int i = 0;
    AppMethodBeat.i(56053);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(56053);
      return;
    }
    if (1 == paramList.size())
    {
      this.sSd.getIController().animateTo(((f)paramList.get(0)).bPI, ((f)paramList.get(0)).bPJ);
      AppMethodBeat.o(56053);
      return;
    }
    ArrayList localArrayList = new ArrayList(5);
    while (i < paramList.size())
    {
      f localf = (f)paramList.get(i);
      localArrayList.add(new LatLng(localf.bPI, localf.bPJ));
      i += 1;
    }
    paramList = LatLngBounds.builder().include(localArrayList).build();
    if ((Double.isInfinite(paramList.getNortheast().getLatitude())) || (Double.isNaN(paramList.getNortheast().getLongitude())) || (Double.isInfinite(paramList.getSouthwest().getLatitude())) || (Double.isNaN(paramList.getSouthwest().getLongitude())))
    {
      AppMethodBeat.o(56053);
      return;
    }
    this.sSd.animateCamera(CameraUpdateFactory.newLatLngBounds(paramList, 250));
    AppMethodBeat.o(56053);
  }
  
  private void lQ(boolean paramBoolean)
  {
    AppMethodBeat.i(56044);
    ad.d("MicroMsg.MMPoiMapUI", "stack: %s", new Object[] { bt.eGN() });
    this.sOK = a(this.lat, this.hpg);
    if (this.sOK.equals(this.sUB.key))
    {
      ad.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[] { this.sOK });
      AppMethodBeat.o(56044);
      return;
    }
    byte[] arrayOfByte = null;
    int i = 1;
    this.sUD.setVisibility(0);
    label185:
    double d1;
    double d2;
    if (this.sUN) {
      if ((this.sOL > 0) && (paramBoolean))
      {
        this.sUA.eSN();
        this.sUC.cKv();
        this.sUC.afe(this.sOK);
        this.sUC.oiJ = this.hpg;
        this.sUC.cBN = false;
        arrayOfByte = this.sUC.buffer;
        if (i == 0) {
          break label436;
        }
        if (this.sUO != 0) {
          break label424;
        }
        i = 0;
        d1 = this.lat;
        d2 = this.lng;
        if (!this.sUN) {
          break label430;
        }
      }
    }
    label424:
    label430:
    for (int j = 0;; j = 1)
    {
      this.sUF = new com.tencent.mm.plugin.location.model.i(arrayOfByte, d1, d2, i, j, this.sUM, this.sUL, this.sOK, this.hpg, paramBoolean);
      com.tencent.mm.kernel.g.aeS().a(this.sUF, 0);
      this.sUX += 1;
      if (this.sVa == -1L) {
        this.sVa = System.currentTimeMillis();
      }
      AppMethodBeat.o(56044);
      return;
      if (!paramBoolean)
      {
        this.sUA.eSN();
        this.sUC.clean();
        this.sUC.afe(this.sOK);
        this.sUC.oiJ = this.hpg;
        this.sUC.cBN = false;
        arrayOfByte = this.sUC.buffer;
        this.sUC.notifyDataSetChanged();
        break;
      }
      i = 0;
      this.sUC.cBN = false;
      break;
      this.sUz.eSN();
      this.sUB.clean();
      this.sUB.afe(this.sOK);
      this.sUB.notifyDataSetChanged();
      arrayOfByte = this.sUB.buffer;
      mL(false);
      cKm();
      break;
      i = 1;
      break label185;
    }
    label436:
    ad.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", new Object[] { Integer.valueOf(this.sOL) });
    AppMethodBeat.o(56044);
  }
  
  private void mL(boolean paramBoolean)
  {
    AppMethodBeat.i(56048);
    ad.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.sss.setEnabled(paramBoolean);
    this.sUH.setEnabled(paramBoolean);
    AppMethodBeat.o(56048);
  }
  
  private void t(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(56045);
    String str3;
    String str1;
    String str2;
    if ((this.sUL == -85.0D) || (this.sUM == -1000.0D))
    {
      str3 = "null/null";
      str1 = "";
      if (paramBoolean) {
        break label563;
      }
      if ((paramInt2 < 0) || (paramInt2 >= this.sUB.getCount())) {
        break label614;
      }
      str1 = this.sUB.FH(paramInt2).sWi;
      str2 = this.sUB.FH(paramInt2).sVY;
    }
    for (;;)
    {
      label82:
      String str4 = str1;
      if (paramInt2 == 0)
      {
        str4 = str1;
        if (bt.isNullOrNil(str1))
        {
          str4 = str1;
          if (this.sUB.getCount() > 1)
          {
            ad.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str4 = this.sUB.FH(1).sWi;
          }
        }
      }
      if ((this.sUB.getCount() > 0) && (!paramBoolean)) {
        ad.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", new Object[] { Integer.valueOf(paramInt2) });
      }
      for (str1 = this.sUB.FH(0).dnB;; str1 = "")
      {
        int i = paramInt2;
        if (paramInt2 == 0)
        {
          i = paramInt2;
          if (!paramBoolean)
          {
            i = paramInt2;
            if (this.sUB.getCount() > 0)
            {
              int j = this.sUB.FH(0).sWj;
              i = paramInt2;
              if (j >= 0)
              {
                ad.d("MicroMsg.MMPoiMapUI", "change to search index: %s", new Object[] { Integer.valueOf(j) });
                i = j;
              }
            }
          }
        }
        ad.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.sVa), Long.valueOf(this.sUZ), Long.valueOf(this.sUY), Integer.valueOf(this.sUX), str3, Integer.valueOf(this.sVb), str4, str1 });
        com.tencent.mm.plugin.report.service.h.vKh.f(11135, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.sVa), Long.valueOf(this.sUZ), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.sUY), Integer.valueOf(this.sUX), str3, str2, Integer.valueOf(this.sVb), str4, com.tencent.mm.compatible.deviceinfo.q.cG(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
        AppMethodBeat.o(56045);
        return;
        str3 = String.format("%f/%f", new Object[] { Double.valueOf(this.sUL), Double.valueOf(this.sUM) });
        break;
        label563:
        if ((paramInt2 < 0) || (paramInt2 >= this.sUC.getCount())) {
          break label614;
        }
        str1 = this.sUC.FH(paramInt2).sWi;
        str2 = this.sUC.FH(paramInt2).sVY;
        break label82;
      }
      label614:
      str2 = "";
    }
  }
  
  public final com.tencent.mm.plugin.k.d cKh()
  {
    AppMethodBeat.i(56036);
    com.tencent.mm.plugin.k.d locald = (com.tencent.mm.plugin.k.d)this.activity.findViewById(2131300334);
    AppMethodBeat.o(56036);
    return locald;
  }
  
  public final void cKi()
  {
    AppMethodBeat.i(56040);
    a(c.c.sVI);
    AppMethodBeat.o(56040);
  }
  
  public final void cKj()
  {
    AppMethodBeat.i(56041);
    if (this.sUE.isSelected()) {
      this.sUE.setSelected(false);
    }
    if (!this.sUN)
    {
      this.sUy.play();
      this.lat = (this.sSd.getMapCenterX() / 1000000.0D);
      this.lng = (this.sSd.getMapCenterY() / 1000000.0D);
      this.sUy.l(this.lat, this.lng);
      this.sUE.setSelected(false);
      if (this.sUV) {
        a(c.c.sVI);
      }
      lQ(false);
      this.sVg = false;
      g.c.sWw.sWk = 0;
      g.c.sWw.a(g.b.sWs);
    }
    AppMethodBeat.o(56041);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(56038);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent, back.");
      g.c.sWw.a(g.a.sWn);
      if (this.sUN)
      {
        cKl();
        t(sVf, this.sUC.rZ, true);
        AppMethodBeat.o(56038);
        return false;
      }
      t(sVd, this.sUB.rZ, false);
      this.activity.finish();
      AppMethodBeat.o(56038);
      return true;
    }
    AppMethodBeat.o(56038);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(56034);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = this.activity.getWindow();
      paramBundle.getDecorView().setSystemUiVisibility(1280);
      paramBundle.setStatusBarColor(0);
    }
    com.tencent.mm.kernel.g.aeS().a(457, this);
    this.sVb = ((int)(System.currentTimeMillis() / 1000L));
    this.sSd.setCanRotate(false);
    label212:
    int j;
    if (ai.Eq())
    {
      cKh().enableDarkMode();
      this.sUJ = ((LinearLayout)findViewById(2131300707));
      ((TextView)findViewById(2131297583)).setText(2131755691);
      this.sUG = findViewById(2131305909);
      this.sUG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56013);
          g.c.sWw.a(g.a.sWn);
          c.a(c.this, c.sVd, c.b(c.this).rZ, false);
          c.c(c.this);
          c.this.activity.finish();
          AppMethodBeat.o(56013);
        }
      });
      this.sUG.setVisibility(0);
      this.sss = findViewById(2131305910);
      this.sUH = findViewById(2131297599);
      switch (this.type)
      {
      default: 
        this.sss.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(56018);
            g.c.sWw.a(g.a.sWm);
            c.d(c.this);
            AppMethodBeat.o(56018);
          }
        });
        this.sss.setVisibility(0);
        mL(false);
        this.sUP = ((RelativeLayout)findViewById(2131301531));
        this.sUz = ((MMLoadMoreListView)this.activity.findViewById(2131303334));
        this.sUA = ((MMLoadMoreListView)this.activity.findViewById(2131304431));
        this.sUD = findViewById(2131301491);
        this.sUI = ((TextView)findViewById(2131304416));
        this.sUx = ((PoiHeaderView)findViewById(2131303327));
        this.sUW = ((FrameLayout)findViewById(2131302156));
        this.sUE = ((ImageButton)findViewById(2131301520));
        this.sUE.setSelected(true);
        this.sUE.setContentDescription(this.activity.getString(2131760710));
        this.sUE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182066);
            ad.d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", new Object[] { Double.valueOf(c.e(c.this)), Double.valueOf(c.f(c.this)) });
            if ((c.e(c.this) == -85.0D) || (c.f(c.this) == -1000.0D))
            {
              ad.i("MicroMsg.MMPoiMapUI", "invalid lat lng");
              AppMethodBeat.o(182066);
              return;
            }
            if (c.g(c.this))
            {
              c.this.sSd.getIController().animateTo(c.e(c.this), c.f(c.this));
              c.h(c.this).setSelected(true);
              c.a(c.this, c.c.sVI);
              AppMethodBeat.o(182066);
              return;
            }
            c.this.sSd.getIController().animateTo(c.e(c.this), c.f(c.this));
            c.a(c.this, c.e(c.this));
            c.b(c.this, c.f(c.this));
            c.a(c.this).l(c.i(c.this), c.j(c.this));
            c.h(c.this).setSelected(true);
            c.a(c.this, false);
            c.b(c.this).rZ = 0;
            c.k(c.this).setSelection(0);
            g.c.sWw.sWk = 0;
            g.c.sWw.a(g.b.sWu);
            c.l(c.this);
            AppMethodBeat.o(182066);
          }
        });
        this.sSd.setBuiltInZoomControls(false);
        this.sUo = ((FrameLayout)findViewById(2131298786));
        this.sUK = new MyPoiPoint(this.activity, this.sSd);
        this.sUy = new PickPoi(this.activity);
        this.sUy.setOnCurPoiGet(new b()
        {
          public final void a(f paramAnonymousf)
          {
            AppMethodBeat.i(182067);
            c.a(c.this).setOnCurPoiGet(null);
            if (paramAnonymousf != null)
            {
              c.m(c.this).c(paramAnonymousf.sWh);
              if (c.b(c.this) != null)
              {
                c.b(c.this).hc(c.m(c.this).sWb, c.m(c.this).sWc);
                c.n(c.this).hc(c.m(c.this).sWb, c.m(c.this).sWc);
              }
            }
            AppMethodBeat.o(182067);
          }
        });
        this.sUo.addView(this.sUy);
        paramBundle = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FjH, "");
        if ((!bt.isNullOrNil(paramBundle)) && ((this.sUL == -85.0D) || (this.sUM == -1000.0D)))
        {
          String[] arrayOfString = paramBundle.split(",");
          ad.i("MicroMsg.MMPoiMapUI", "last locationInfo ".concat(String.valueOf(paramBundle)));
          if (arrayOfString.length == 2)
          {
            float f1 = (float)(bt.aGh(arrayOfString[0]) * 1.0D / 1000000.0D);
            float f2 = (float)(bt.aGh(arrayOfString[1]) * 1.0D / 1000000.0D);
            this.sSd.getIController().animateTo(f1, f2);
          }
        }
        this.sVr = new View.OnTouchListener()
        {
          private float sVF;
          private short sVG = 0;
          
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(182068);
            if (c.g(c.this)) {
              c.c(c.this);
            }
            if (!c.o(c.this))
            {
              AppMethodBeat.o(182068);
              return true;
            }
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(182068);
              return false;
              ad.d("MicroMsg.MMPoiMapUI", "newpoi action down %s.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
              this.sVF = paramAnonymousMotionEvent.getRawY();
              c.b(c.this, false);
              continue;
              ad.d("MicroMsg.MMPoiMapUI", "newpoi action move %s.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
              if (c.p(c.this))
              {
                ad.d("MicroMsg.MMPoiMapUI", "newpoi blocked.");
                c.k(c.this).setSelection(0);
              }
              float f = this.sVF - paramAnonymousMotionEvent.getRawY();
              if (Math.abs(f) < BackwardSupportUtil.b.g(c.this.activity, 20.0F)) {
                this.sVG = 0;
              }
              while (((c.q(c.this)) && (this.sVG == 1)) || ((c.r(c.this)) && (this.sVG == -1)) || ((c.q(c.this)) && (!c.s(c.this).getScroll2Top()) && (this.sVG == -1)))
              {
                AppMethodBeat.o(182068);
                return false;
                if (f > 0.0F) {
                  this.sVG = 1;
                } else {
                  this.sVG = -1;
                }
              }
              if ((c.o(c.this)) && (this.sVG != 0))
              {
                ad.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[] { Short.valueOf(this.sVG) });
                if (this.sVG == 1)
                {
                  c.c(c.this, true);
                  c.a(c.this, c.c.sVJ);
                  AppMethodBeat.o(182068);
                  return false;
                }
                c.a(c.this, c.c.sVI);
                AppMethodBeat.o(182068);
                return false;
              }
              AppMethodBeat.o(182068);
              return true;
              ad.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
              c.b(c.this, false);
            }
          }
        };
        this.sUz.setOnTouchListener(this.sVr);
        this.sUz.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void Wc()
          {
            AppMethodBeat.i(182069);
            c.t(c.this);
            AppMethodBeat.o(182069);
          }
        });
        this.sUz.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182070);
            ad.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= c.b(c.this).getCount()))
            {
              ad.i("MicroMsg.MMPoiMapUI", "wrong position");
              AppMethodBeat.o(182070);
              return;
            }
            paramAnonymousAdapterView = c.b(c.this).FH(paramAnonymousInt);
            if (paramAnonymousAdapterView.type == 0) {
              c.h(c.this).setSelected(false);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView.bPI);
              c.b(c.this, paramAnonymousAdapterView.bPJ);
              c.this.sSd.getIController().animateTo(paramAnonymousAdapterView.bPI, paramAnonymousAdapterView.bPJ);
              c.b(c.this).rZ = paramAnonymousInt;
              c.b(c.this).notifyDataSetChanged();
              c.a(c.this, false);
              g.c.sWw.sWk = (paramAnonymousInt + 1);
              g.c.sWw.a(g.b.sWt);
              AppMethodBeat.o(182070);
              return;
              c.h(c.this).setSelected(true);
            }
          }
        });
        this.sUB = new e(this.activity);
        this.sUz.setAdapter(this.sUB);
        this.sUy.setAdapter(this.sUB);
        this.sRu = new PoiPoint.a()
        {
          public final void a(PoiPoint.b paramAnonymousb, PoiPoint paramAnonymousPoiPoint)
          {
            AppMethodBeat.i(182071);
            if (PoiPoint.b.sRx == paramAnonymousb)
            {
              if (-1 == c.n(c.this).rZ) {
                c.d(c.this, true);
              }
              if (c.u(c.this) != null) {
                c.u(c.this).cJH();
              }
              c.this.sSd.getIController().animateTo(paramAnonymousPoiPoint.getLat(), paramAnonymousPoiPoint.getLng());
              c.a(c.this, paramAnonymousPoiPoint);
              paramAnonymousPoiPoint.cJI();
              c.a(c.this, paramAnonymousPoiPoint.getPosition());
              c.n(c.this).rZ = paramAnonymousPoiPoint.getPosition();
              c.n(c.this).notifyDataSetChanged();
              g.c.sWw.sWk = (paramAnonymousPoiPoint.getPosition() + 1);
              g.c.sWw.a(g.b.sWr);
              AppMethodBeat.o(182071);
              return;
            }
            paramAnonymousb = PoiPoint.b.sRw;
            AppMethodBeat.o(182071);
          }
        };
        this.sUC = new e(this.activity);
        this.sUC.inh = true;
        this.sUC.rZ = -1;
        this.sUA.setAdapter(this.sUC);
        this.sUA.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void Wc()
          {
            AppMethodBeat.i(182051);
            c.t(c.this);
            AppMethodBeat.o(182051);
          }
        });
        this.sUA.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182052);
            if (-1 == c.n(c.this).rZ)
            {
              c.d(c.this, true);
              c.a(c.this, c.c.sVI);
            }
            c.n(c.this).rZ = paramAnonymousInt;
            c.n(c.this).notifyDataSetChanged();
            if ((paramAnonymousInt >= 0) && (paramAnonymousInt < c.n(c.this).getCount()))
            {
              c.a(c.this, true);
              if (c.u(c.this) != null) {
                c.u(c.this).cJH();
              }
              paramAnonymousView = c.n(c.this).FH(paramAnonymousInt);
              if ((paramAnonymousView.bPI == c.e(c.this)) && (paramAnonymousView.bPJ == c.f(c.this))) {
                break label349;
              }
              c.h(c.this).setSelected(false);
              c.this.sSd.getIController().animateTo(paramAnonymousView.bPI, paramAnonymousView.bPJ);
              paramAnonymousAdapterView = (PoiPoint)c.v(c.this).get(paramAnonymousView.bPI + paramAnonymousView.bPJ);
              if (paramAnonymousAdapterView != null) {
                break label363;
              }
              paramAnonymousAdapterView = new PoiPoint(c.this.activity, c.this.sSd);
              paramAnonymousAdapterView.setPosition(paramAnonymousInt);
              paramAnonymousAdapterView.setOnPointClick(c.this.sRu);
              c.v(c.this).put(paramAnonymousView.bPI + paramAnonymousView.bPJ, paramAnonymousAdapterView);
              paramAnonymousAdapterView.c(paramAnonymousView.bPI, paramAnonymousView.bPJ, true);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView);
              g.c.sWw.sWk = (paramAnonymousInt + 1);
              g.c.sWw.a(g.b.sWq);
              AppMethodBeat.o(182052);
              return;
              label349:
              c.h(c.this).setSelected(true);
              break;
              label363:
              paramAnonymousAdapterView.cJI();
            }
          }
        });
        this.sUA.setOnTouchListener(this.sVr);
        this.sVm = findViewById(2131304573);
        this.sVn = findViewById(2131304575);
        this.sVo = ((EditText)findViewById(2131304572));
        this.sVp = ((ImageView)findViewById(2131304577));
        this.sVq = findViewById(2131304571);
        this.sVm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(170177);
            if (!c.g(c.this)) {
              c.H(c.this);
            }
            AppMethodBeat.o(170177);
          }
        });
        this.sVq.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182059);
            c.a(c.this, c.cKs(), c.n(c.this).rZ, true);
            c.y(c.this);
            AppMethodBeat.o(182059);
          }
        });
        this.sVo.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(182060);
            if (c.I(c.this)) {
              c.A(c.this);
            }
            for (;;)
            {
              AppMethodBeat.o(182060);
              return true;
              if (c.o(c.this)) {
                c.a(c.this, c.c.sVJ);
              }
            }
          }
        });
        this.sVo.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(182061);
            if (3 == paramAnonymousInt)
            {
              c.a(c.this, c.c.sVI);
              c.h(c.this, true);
            }
            AppMethodBeat.o(182061);
            return false;
          }
        });
        this.sVo.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(182062);
            ad.d("MicroMsg.MMPoiMapUI", "searchText: %s.", new Object[] { paramAnonymousCharSequence });
            c.a(c.this, paramAnonymousCharSequence.toString());
            c.J(c.this).eSN();
            c.K(c.this).setVisibility(8);
            if (bt.isNullOrNil(c.E(c.this)))
            {
              c.L(c.this).setVisibility(8);
              c.n(c.this).clean();
              c.n(c.this).notifyDataSetChanged();
              c.M(c.this);
              c.d(c.this, false);
              c.N(c.this).setVisibility(8);
              AppMethodBeat.o(182062);
              return;
            }
            c.L(c.this).setVisibility(0);
            c.O(c.this);
            AppMethodBeat.o(182062);
          }
        });
        this.sVp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182063);
            c.P(c.this).setText("");
            c.A(c.this);
            AppMethodBeat.o(182063);
          }
        });
        cKq();
        this.sVk = findViewById(2131304570);
        this.sVk.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182053);
            ad.d("MicroMsg.MMPoiMapUI", "pennqin, collapseBtnLayoutHeight: %d.", new Object[] { Integer.valueOf(c.w(c.this)) });
            c.b(c.this, c.x(c.this).getHeight());
            c.x(c.this).setVisibility(8);
            AppMethodBeat.o(182053);
          }
        });
        findViewById(2131304569).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182054);
            if (c.n(c.this).getCount() == 0)
            {
              c.y(c.this);
              AppMethodBeat.o(182054);
              return;
            }
            c.a(c.this, c.c.sVI);
            AppMethodBeat.o(182054);
          }
        });
        this.sVB = ((InputPanelFrameLayout)findViewById(2131303335));
        this.sVB.setExternalListener(new com.tencent.mm.ui.widget.b.a()
        {
          public final void g(boolean paramAnonymousBoolean, int paramAnonymousInt)
          {
            AppMethodBeat.i(182055);
            ad.d("MicroMsg.MMPoiMapUI", "isKeyboardShow: %s.", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            c.e(c.this, paramAnonymousBoolean);
            AppMethodBeat.o(182055);
          }
        });
        paramBundle = ai.cf(this.activity);
        j = Math.max(paramBundle.x, paramBundle.y);
        this.sUQ = (j - BackwardSupportUtil.b.g(this.activity, 320.0F));
        this.sUR = ((int)(j * 0.25F + 0.5D));
        this.sUS = ((int)((this.sUQ - this.sUR) / 3.0D + 0.5D));
        ad.i("MicroMsg.MMPoiMapUI", "collapsedTopMargin: %d, openedTopMargin: %d, mapViewTopMargin: %d.", new Object[] { Integer.valueOf(this.sUQ), Integer.valueOf(this.sUR), Integer.valueOf(this.sUS) });
        this.sVj = new int[] { this.sUQ - this.sUR - this.sUS + 24, 24 };
        i = this.activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i <= 0) {
          break;
        }
      }
    }
    for (int i = this.activity.getResources().getDimensionPixelSize(i);; i = 0)
    {
      paramBundle = (FrameLayout.LayoutParams)this.sUJ.getLayoutParams();
      paramBundle.height += i * 2;
      this.sUJ.setLayoutParams(paramBundle);
      this.sUJ.setPadding(0, i, 0, i);
      if (ap.ju(this.activity))
      {
        i = ap.eb(this.activity);
        label1279:
        j = j - this.sUR - i;
        ad.i("MicroMsg.MMPoiMapUI", "reset poi view height: %s, navigationBarHeight: %s.", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramBundle = this.sUP.getLayoutParams();
        paramBundle.height = j;
        this.sUP.setLayoutParams(paramBundle);
        paramBundle = (RelativeLayout.LayoutParams)this.sUW.getLayoutParams();
        paramBundle.height = this.sUQ;
        this.sUW.setLayoutParams(paramBundle);
        b(c.c.sVI);
        if ((this.type != 0) && (this.type != 8)) {
          break label1512;
        }
        g.c.sWw.setScene(this.activity.getIntent().getIntExtra("type_tag", 0));
      }
      for (;;)
      {
        this.sUy.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(182050);
            c.a(c.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            c.a(c.this).play();
            AppMethodBeat.o(182050);
          }
        });
        AppMethodBeat.o(56034);
        return;
        cKh().disableDarkMode();
        break;
        ((TextView)findViewById(2131297599)).setText(2131760730);
        break label212;
        ((TextView)findViewById(2131297599)).setText(2131755830);
        break label212;
        ((TextView)findViewById(2131297599)).setText(2131755779);
        break label212;
        i = 0;
        break label1279;
        label1512:
        g.c.sWw.setScene(this.type);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56049);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(457, this);
    AppMethodBeat.o(56049);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56047);
    super.onPause();
    this.sVx = false;
    com.tencent.mm.modelgeo.d.axT().c(this.fjJ);
    MyPoiPoint localMyPoiPoint = this.sUK;
    ad.d("MicroMsg.MyPoiPoint", "disableLocation");
    localMyPoiPoint.sQN.c(localMyPoiPoint.fjJ);
    AppMethodBeat.o(56047);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56046);
    super.onResume();
    this.sVx = true;
    com.tencent.mm.modelgeo.d.axT().b(this.fjJ, true);
    this.sUK.cJG();
    AppMethodBeat.o(56046);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(56054);
    if (paramn.getType() == 457)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(56054);
        return;
      }
      this.sUF = null;
      com.tencent.mm.plugin.location.model.i locali = (com.tencent.mm.plugin.location.model.i)paramn;
      if (!locali.sOK.equals(this.sOK))
      {
        ad.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.sOK + " " + locali.sOK);
        AppMethodBeat.o(56054);
        return;
      }
      ad.i("MicroMsg.MMPoiMapUI", "isEnd: " + locali.gna + " searchId: " + locali.jko + " isInSearch: " + this.sUN);
      if (this.sUY == -1L)
      {
        long l = System.currentTimeMillis();
        this.sUZ = l;
        this.sUY = l;
      }
      for (;;)
      {
        this.sOL = locali.sOL;
        this.sUD.setVisibility(8);
        if (!this.sUN) {
          break label419;
        }
        if (!bt.isNullOrNil(this.hpg)) {
          break;
        }
        AppMethodBeat.o(56054);
        return;
        this.sUZ = System.currentTimeMillis();
      }
      if ((locali.list != null) && (locali.list.size() == 0))
      {
        this.sUI.setVisibility(0);
        this.sUA.eSN();
      }
      ad.d("MicroMsg.MMPoiMapUI", "search is first: %s", new Object[] { Boolean.valueOf(locali.isFirst()) });
      if (locali.isFirst())
      {
        this.sUC.cBN = true;
        this.sUC.sVR.clear();
      }
      this.sUC.a(locali.list, locali.sOJ, locali.gna, locali.sOK);
      if (!this.sUC.gna)
      {
        this.sUA.eSM();
        this.sUA.eSO();
      }
      while (this.sVu)
      {
        this.sVu = false;
        cKo();
        AppMethodBeat.o(56054);
        return;
        this.sUA.eSN();
        this.sUA.eSP();
      }
      label419:
      Object localObject2;
      Object localObject1;
      if (this.sUx != null)
      {
        localObject2 = (axp)locali.rr.gUT.gUX;
        paramn = this.sUx;
        localObject1 = ((axp)localObject2).CIE;
        paramString = ((axp)localObject2).Dvj;
        String str = ((axp)localObject2).Url;
        localObject2 = com.tencent.mm.plugin.image.d.apW();
        ad.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[] { paramString, str });
        paramn.sQZ = str;
        paramn.sRa = "";
        if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(paramString))) {
          break label629;
        }
        paramn.setVisibility(8);
        paramn.ful.setVisibility(8);
        paramn.sRb.setVisibility(8);
      }
      for (;;)
      {
        mL(true);
        this.sUB.a(locali.list, locali.sOJ, locali.gna, locali.sOK);
        this.sUB.rZ = 0;
        this.sUB.notifyDataSetChanged();
        if (this.sUB.gna) {
          break;
        }
        this.sUz.eSM();
        this.sUz.eSO();
        AppMethodBeat.o(56054);
        return;
        label629:
        paramn.setVisibility(0);
        paramn.ful.setVisibility(0);
        paramn.sRb.setVisibility(0);
        paramn.ful.setText((CharSequence)localObject1);
        localObject1 = paramn.sRb;
        ((SimpleImageView)localObject1).imagePath = ((String)localObject2);
        ((SimpleImageView)localObject1).url = paramString;
        ((SimpleImageView)localObject1).gnh = 0;
        ((SimpleImageView)localObject1).gni = 0;
        if ((paramString == null) || (paramString.length() == 0))
        {
          ((SimpleImageView)localObject1).setVisibility(8);
        }
        else if (paramString.startsWith("http"))
        {
          paramn = MMBitmapFactory.decodeFile(((SimpleImageView)localObject1).imagePath + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
          if (paramn != null)
          {
            paramString = paramn;
            if (((SimpleImageView)localObject1).gnh > 0)
            {
              paramString = paramn;
              if (((SimpleImageView)localObject1).gni > 0) {
                paramString = com.tencent.mm.sdk.platformtools.f.a(paramn, ((SimpleImageView)localObject1).gnh, ((SimpleImageView)localObject1).gni, true, false);
              }
            }
            ((SimpleImageView)localObject1).setImageBitmap(paramString);
          }
          else
          {
            com.tencent.mm.sdk.g.b.c(new SimpleImageView.a(paramString, ((SimpleImageView)localObject1).handler), "SimpleImageView_download");
          }
        }
        else if (!com.tencent.mm.vfs.i.eK(paramString))
        {
          ((SimpleImageView)localObject1).setVisibility(8);
        }
        else
        {
          if ((((SimpleImageView)localObject1).gnh <= 0) || (((SimpleImageView)localObject1).gni <= 0)) {}
          for (paramString = com.tencent.mm.sdk.platformtools.f.aFi(paramString);; paramString = com.tencent.mm.sdk.platformtools.f.e(paramString, ((SimpleImageView)localObject1).gnh, ((SimpleImageView)localObject1).gni, true))
          {
            if (paramString != null) {
              break label906;
            }
            ((SimpleImageView)localObject1).setVisibility(8);
            break;
          }
          label906:
          ((SimpleImageView)localObject1).setImageBitmap(paramString);
        }
      }
      this.sUz.eSN();
      this.sUz.eSP();
    }
    AppMethodBeat.o(56054);
  }
  
  final class a
    extends TranslateAnimation
  {
    private List<View> sVH;
    
    public a(float paramFloat)
    {
      super(0.0F, 0.0F, paramFloat);
      AppMethodBeat.i(56025);
      this.sVH = new ArrayList();
      AppMethodBeat.o(56025);
    }
    
    public final a cKt()
    {
      AppMethodBeat.i(56026);
      setDuration(200L);
      AppMethodBeat.o(56026);
      return this;
    }
    
    public final a cKu()
    {
      AppMethodBeat.i(56027);
      setFillEnabled(true);
      setFillAfter(true);
      AppMethodBeat.o(56027);
      return this;
    }
    
    public final a dY(View paramView)
    {
      AppMethodBeat.i(56028);
      this.sVH.add(paramView);
      AppMethodBeat.o(56028);
      return this;
    }
    
    public final void startAnimation()
    {
      AppMethodBeat.i(56029);
      int i = 0;
      while (i < this.sVH.size())
      {
        ((View)this.sVH.get(i)).startAnimation(this);
        i += 1;
      }
      AppMethodBeat.o(56029);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c
 * JD-Core Version:    0.7.0.1
 */