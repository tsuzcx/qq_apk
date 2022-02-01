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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.location.ui.MyPoiPoint;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.PoiPoint;
import com.tencent.mm.plugin.location.ui.PoiPoint.a;
import com.tencent.mm.plugin.location.ui.PoiPoint.b;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.SimpleImageView.a;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.aj;
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
  implements com.tencent.mm.ak.g
{
  private static int udo = 11;
  private static int udp = 12;
  private static int udq = 13;
  private static int udr = 14;
  private com.tencent.mm.modelgeo.b.a fnd;
  private String hPI;
  private double lat;
  private double lng;
  private View tAi;
  private String tWX;
  private int tWY;
  PoiPoint.a tZH;
  private FrameLayout ucA;
  private PoiHeaderView ucJ;
  private PickPoi ucK;
  private MMLoadMoreListView ucL;
  private MMLoadMoreListView ucM;
  private e ucN;
  private e ucO;
  private View ucP;
  private ImageButton ucQ;
  private com.tencent.mm.plugin.location.model.i ucR;
  private View ucS;
  private View ucT;
  private TextView ucU;
  private LinearLayout ucV;
  private MyPoiPoint ucW;
  private double ucX;
  private double ucY;
  private boolean ucZ;
  private EditText udA;
  private ImageView udB;
  private View udC;
  private View.OnTouchListener udD;
  private PoiPoint udE;
  private Map<String, PoiPoint> udF;
  private boolean udG;
  private f udH;
  private boolean udI;
  private boolean udJ;
  private boolean udK;
  private boolean udL;
  private boolean udM;
  private InputPanelFrameLayout udN;
  private int uda;
  private RelativeLayout udb;
  private int udc;
  private int udd;
  private int ude;
  private boolean udf;
  private boolean udg;
  private boolean udh;
  private FrameLayout udi;
  private int udj;
  private long udk;
  private long udl;
  private long udm;
  private int udn;
  private boolean uds;
  private boolean udt;
  private int[] udu;
  private int[] udv;
  private View udw;
  private int udx;
  private View udy;
  private View udz;
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56033);
    this.ucR = null;
    this.lat = -85.0D;
    this.lng = -1000.0D;
    this.ucX = -85.0D;
    this.ucY = -1000.0D;
    this.tWX = "";
    this.ucZ = false;
    this.hPI = "";
    this.uda = 0;
    this.udf = true;
    this.udg = false;
    this.udh = false;
    this.udj = 0;
    this.udk = -1L;
    this.udl = -1L;
    this.udm = -1L;
    this.udn = -1;
    this.uds = false;
    this.tWY = 1;
    this.udu = new int[] { 24, 24 };
    this.udF = new HashMap();
    this.udH = new f();
    this.udI = false;
    this.fnd = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(182065);
        if (!paramAnonymousBoolean)
        {
          if ((!c.Q(c.this)) && (!com.tencent.mm.modelgeo.d.aEM()))
          {
            c.R(c.this);
            com.tencent.mm.ui.base.h.a(c.this.activity, c.this.activity.getString(2131760082), c.this.activity.getString(2131755906), c.this.activity.getString(2131760598), c.this.activity.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(182064);
                com.tencent.mm.modelgeo.d.cE(c.this.activity);
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
          ac.d("MicroMsg.MMPoiMapUI", "init my location.");
          str = (int)(1000000.0F * paramAnonymousFloat2) + "," + (int)(1000000.0F * paramAnonymousFloat1);
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHw, str);
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
          c.this.uaq.getIController().animateTo(c.e(c.this), c.f(c.this), com.tencent.mm.plugin.location.ui.d.cXi());
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
            ac.d("MicroMsg.MMPoiMapUI", "update lat/lng.");
            str = (int)(1000000.0F * paramAnonymousFloat2) + "," + (int)(1000000.0F * paramAnonymousFloat1);
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHw, str);
            c.c(c.this, paramAnonymousFloat2);
            c.d(c.this, paramAnonymousFloat1);
          }
        }
      }
    };
    this.udJ = false;
    this.udK = false;
    this.udL = false;
    this.udM = false;
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
    if (((c.c.udV == paramc) && (this.udh)) || ((c.c.udU == paramc) && (!this.udh)))
    {
      AppMethodBeat.o(56037);
      return;
    }
    if (this.udw.getVisibility() != 0) {
      this.udw.setVisibility(0);
    }
    this.udf = false;
    int i;
    a locala2;
    a locala1;
    if (c.c.udV == paramc)
    {
      ac.d("MicroMsg.MMPoiMapUI", "pennqin play open animation, getListTopMargin(): %d, openedTopMargin: %d.", new Object[] { Integer.valueOf(cXU()), Integer.valueOf(this.udd) });
      i = cXU() - this.udd;
      ac.d("MicroMsg.MMPoiMapUI", "pennqin play open animation (getListTopMargin() - openedTopMargin): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(-i);
      locala1 = new a(-this.ude);
    }
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.udx });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.udx, 0 }))
    {
      paramc = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(182057);
          c.f(c.this, true);
          if (c.c.udV == paramc)
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
            if ((!c.n(c.this).oMj.equals(c.E(c.this))) || (!c.n(c.this).cyW)) {
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
              c.a(c.this, c.n(c.this).ta);
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
          ac.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
      locala2 = locala2.cXY().cXZ();
      locala2.setAnimationListener(paramc);
      locala2.eh(this.udb).eh(this.ucQ).startAnimation();
      locala1.cXY().cXZ().eh(this.udi).startAnimation();
      localValueAnimator.setDuration(200L).start();
      AppMethodBeat.o(56037);
      return;
      ac.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation, getListTopMargin(): %d, collapsedTopMargin: %d.", new Object[] { Integer.valueOf(cXU()), Integer.valueOf(this.udc) });
      i = this.udc - cXU();
      ac.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation (collapsedTopMargin - getListTopMargin()): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(i);
      locala1 = new a(this.ude);
    }
  }
  
  private void b(c.c paramc)
  {
    AppMethodBeat.i(56055);
    if (c.c.udU == paramc)
    {
      ((FrameLayout.LayoutParams)this.udb.getLayoutParams()).topMargin = this.udc;
      ((RelativeLayout.LayoutParams)this.udi.getLayoutParams()).topMargin = 0;
      ((FrameLayout.LayoutParams)this.ucQ.getLayoutParams()).topMargin = (this.udc - ao.fromDPToPix(this.activity, 92));
      this.uaq.setLogoMargin(this.udu);
    }
    for (;;)
    {
      this.udb.requestLayout();
      this.ucQ.requestLayout();
      this.udi.requestLayout();
      AppMethodBeat.o(56055);
      return;
      if (c.c.udV == paramc)
      {
        ((FrameLayout.LayoutParams)this.udb.getLayoutParams()).topMargin = this.udd;
        ((RelativeLayout.LayoutParams)this.udi.getLayoutParams()).topMargin = (-this.ude);
        ((FrameLayout.LayoutParams)this.ucQ.getLayoutParams()).topMargin = (this.udd - ao.fromDPToPix(this.activity, 92));
        this.uaq.setLogoMargin(this.udv);
      }
    }
  }
  
  private boolean cXP()
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
  
  private void cXQ()
  {
    AppMethodBeat.i(56039);
    this.ucZ = false;
    this.ucA.setVisibility(0);
    a(c.c.udU);
    cXV();
    this.hPI = "";
    this.ucM.setVisibility(8);
    this.ucN.notifyDataSetChanged();
    this.ucL.setVisibility(0);
    this.ucP.setVisibility(8);
    this.ucU.setVisibility(8);
    cXS();
    nD(true);
    this.ucQ.setSelected(this.udI);
    this.uaq.getIController().animateTo(this.lat, this.lng);
    AppMethodBeat.o(56039);
  }
  
  private void cXR()
  {
    AppMethodBeat.i(56043);
    if (this.ucK.udZ)
    {
      f localf = this.ucK.getPoi();
      e locale = this.ucN;
      if (locale.ued.size() >= 0)
      {
        locale.ued.add(0, localf);
        locale.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(56043);
  }
  
  private void cXS()
  {
    AppMethodBeat.i(56050);
    Iterator localIterator = this.udF.values().iterator();
    while (localIterator.hasNext()) {
      ((PoiPoint)localIterator.next()).remove();
    }
    this.udF.clear();
    this.udE = null;
    AppMethodBeat.o(56050);
  }
  
  private void cXT()
  {
    AppMethodBeat.i(56051);
    Object localObject = new ArrayList(5);
    int i = 0;
    while ((i < 5) && (i < this.ucO.getCount()))
    {
      ((List)localObject).add(this.ucO.HC(i));
      i += 1;
    }
    localObject = ec((List)localObject);
    cXS();
    i = 0;
    while (i < ((List)localObject).size())
    {
      f localf = this.ucO.HC(i);
      PoiPoint localPoiPoint = new PoiPoint(this.activity, this.uaq);
      localPoiPoint.setPosition(i);
      localPoiPoint.setOnPointClick(this.tZH);
      this.udF.put(localf.bNq + localf.bNr, localPoiPoint);
      localPoiPoint.c(localf.bNq, localf.bNr, false);
      i += 1;
    }
    ed((List)localObject);
    AppMethodBeat.o(56051);
  }
  
  private int cXU()
  {
    AppMethodBeat.i(56056);
    int i = ((ViewGroup.MarginLayoutParams)this.udb.getLayoutParams()).topMargin;
    AppMethodBeat.o(56056);
    return i;
  }
  
  private void cXV()
  {
    AppMethodBeat.i(56057);
    if (this.ucZ)
    {
      this.udy.setVisibility(8);
      this.udz.setVisibility(0);
      this.udC.setVisibility(0);
      AppMethodBeat.o(56057);
      return;
    }
    this.udy.setVisibility(0);
    this.udz.setVisibility(8);
    this.udC.setVisibility(8);
    AppMethodBeat.o(56057);
  }
  
  private void cXW()
  {
    AppMethodBeat.i(56058);
    if (!this.udK)
    {
      this.udK = true;
      this.udA.requestFocus();
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
  
  private static List<f> ec(List<f> paramList)
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
        if (TencentLocationUtils.distanceBetween(localf1.bNq, localf1.bNr, localf2.bNq, localf2.bNr) > 5000.0D) {
          break label121;
        }
        localArrayList.add(localf1);
      }
    }
    label121:
    AppMethodBeat.o(56052);
    return localArrayList;
  }
  
  private void ed(List<f> paramList)
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
      this.uaq.getIController().animateTo(((f)paramList.get(0)).bNq, ((f)paramList.get(0)).bNr);
      AppMethodBeat.o(56053);
      return;
    }
    ArrayList localArrayList = new ArrayList(5);
    while (i < paramList.size())
    {
      f localf = (f)paramList.get(i);
      localArrayList.add(new LatLng(localf.bNq, localf.bNr));
      i += 1;
    }
    paramList = LatLngBounds.builder().include(localArrayList).build();
    if ((Double.isInfinite(paramList.getNortheast().getLatitude())) || (Double.isNaN(paramList.getNortheast().getLongitude())) || (Double.isInfinite(paramList.getSouthwest().getLatitude())) || (Double.isNaN(paramList.getSouthwest().getLongitude())))
    {
      AppMethodBeat.o(56053);
      return;
    }
    this.uaq.animateCamera(CameraUpdateFactory.newLatLngBounds(paramList, 250));
    AppMethodBeat.o(56053);
  }
  
  private void mJ(boolean paramBoolean)
  {
    AppMethodBeat.i(56044);
    ac.d("MicroMsg.MMPoiMapUI", "stack: %s", new Object[] { bs.eWi() });
    this.tWX = a(this.lat, this.hPI);
    if (this.tWX.equals(this.ucN.key))
    {
      ac.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[] { this.tWX });
      AppMethodBeat.o(56044);
      return;
    }
    byte[] arrayOfByte = null;
    int i = 1;
    this.ucP.setVisibility(0);
    label185:
    double d1;
    double d2;
    if (this.ucZ) {
      if ((this.tWY > 0) && (paramBoolean))
      {
        this.ucM.fix();
        this.ucO.cYa();
        this.ucO.ajY(this.tWX);
        this.ucO.oMj = this.hPI;
        this.ucO.cyW = false;
        arrayOfByte = this.ucO.buffer;
        if (i == 0) {
          break label436;
        }
        if (this.uda != 0) {
          break label424;
        }
        i = 0;
        d1 = this.lat;
        d2 = this.lng;
        if (!this.ucZ) {
          break label430;
        }
      }
    }
    label424:
    label430:
    for (int j = 0;; j = 1)
    {
      this.ucR = new com.tencent.mm.plugin.location.model.i(arrayOfByte, d1, d2, i, j, this.ucY, this.ucX, this.tWX, this.hPI, paramBoolean);
      com.tencent.mm.kernel.g.agi().a(this.ucR, 0);
      this.udj += 1;
      if (this.udm == -1L) {
        this.udm = System.currentTimeMillis();
      }
      AppMethodBeat.o(56044);
      return;
      if (!paramBoolean)
      {
        this.ucM.fix();
        this.ucO.clean();
        this.ucO.ajY(this.tWX);
        this.ucO.oMj = this.hPI;
        this.ucO.cyW = false;
        arrayOfByte = this.ucO.buffer;
        this.ucO.notifyDataSetChanged();
        break;
      }
      i = 0;
      this.ucO.cyW = false;
      break;
      this.ucL.fix();
      this.ucN.clean();
      this.ucN.ajY(this.tWX);
      this.ucN.notifyDataSetChanged();
      arrayOfByte = this.ucN.buffer;
      nD(false);
      cXR();
      break;
      i = 1;
      break label185;
    }
    label436:
    ac.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", new Object[] { Integer.valueOf(this.tWY) });
    AppMethodBeat.o(56044);
  }
  
  private void nD(boolean paramBoolean)
  {
    AppMethodBeat.i(56048);
    ac.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.tAi.setEnabled(paramBoolean);
    this.ucT.setEnabled(paramBoolean);
    AppMethodBeat.o(56048);
  }
  
  private void t(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(56045);
    String str3;
    String str1;
    String str2;
    if ((this.ucX == -85.0D) || (this.ucY == -1000.0D))
    {
      str3 = "null/null";
      str1 = "";
      if (paramBoolean) {
        break label563;
      }
      if ((paramInt2 < 0) || (paramInt2 >= this.ucN.getCount())) {
        break label614;
      }
      str1 = this.ucN.HC(paramInt2).uev;
      str2 = this.ucN.HC(paramInt2).uel;
    }
    for (;;)
    {
      label82:
      String str4 = str1;
      if (paramInt2 == 0)
      {
        str4 = str1;
        if (bs.isNullOrNil(str1))
        {
          str4 = str1;
          if (this.ucN.getCount() > 1)
          {
            ac.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str4 = this.ucN.HC(1).uev;
          }
        }
      }
      if ((this.ucN.getCount() > 0) && (!paramBoolean)) {
        ac.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", new Object[] { Integer.valueOf(paramInt2) });
      }
      for (str1 = this.ucN.HC(0).dlj;; str1 = "")
      {
        int i = paramInt2;
        if (paramInt2 == 0)
        {
          i = paramInt2;
          if (!paramBoolean)
          {
            i = paramInt2;
            if (this.ucN.getCount() > 0)
            {
              int j = this.ucN.HC(0).uew;
              i = paramInt2;
              if (j >= 0)
              {
                ac.d("MicroMsg.MMPoiMapUI", "change to search index: %s", new Object[] { Integer.valueOf(j) });
                i = j;
              }
            }
          }
        }
        ac.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.udm), Long.valueOf(this.udl), Long.valueOf(this.udk), Integer.valueOf(this.udj), str3, Integer.valueOf(this.udn), str4, str1 });
        com.tencent.mm.plugin.report.service.h.wUl.f(11135, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.udm), Long.valueOf(this.udl), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.udk), Integer.valueOf(this.udj), str3, str2, Integer.valueOf(this.udn), str4, com.tencent.mm.compatible.deviceinfo.q.cF(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
        AppMethodBeat.o(56045);
        return;
        str3 = String.format("%f/%f", new Object[] { Double.valueOf(this.ucX), Double.valueOf(this.ucY) });
        break;
        label563:
        if ((paramInt2 < 0) || (paramInt2 >= this.ucO.getCount())) {
          break label614;
        }
        str1 = this.ucO.HC(paramInt2).uev;
        str2 = this.ucO.HC(paramInt2).uel;
        break label82;
      }
      label614:
      str2 = "";
    }
  }
  
  public final com.tencent.mm.plugin.k.d cXM()
  {
    AppMethodBeat.i(56036);
    com.tencent.mm.plugin.k.d locald = (com.tencent.mm.plugin.k.d)this.activity.findViewById(2131300334);
    AppMethodBeat.o(56036);
    return locald;
  }
  
  public final void cXN()
  {
    AppMethodBeat.i(56040);
    a(c.c.udU);
    AppMethodBeat.o(56040);
  }
  
  public final void cXO()
  {
    AppMethodBeat.i(56041);
    if (this.ucQ.isSelected()) {
      this.ucQ.setSelected(false);
    }
    if (!this.ucZ)
    {
      this.ucK.play();
      this.lat = (this.uaq.getMapCenterX() / 1000000.0D);
      this.lng = (this.uaq.getMapCenterY() / 1000000.0D);
      this.ucK.l(this.lat, this.lng);
      this.ucQ.setSelected(false);
      if (this.udh) {
        a(c.c.udU);
      }
      mJ(false);
      this.uds = false;
      g.c.ueJ.uex = 0;
      g.c.ueJ.a(g.b.ueF);
    }
    AppMethodBeat.o(56041);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(56038);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ac.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent, back.");
      g.c.ueJ.a(g.a.ueA);
      if (this.ucZ)
      {
        cXQ();
        t(udr, this.ucO.ta, true);
        AppMethodBeat.o(56038);
        return false;
      }
      t(udp, this.ucN.ta, false);
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
    com.tencent.mm.kernel.g.agi().a(457, this);
    this.udn = ((int)(System.currentTimeMillis() / 1000L));
    this.uaq.setCanRotate(false);
    label212:
    int j;
    if (aj.DT())
    {
      cXM().enableDarkMode();
      this.ucV = ((LinearLayout)findViewById(2131300707));
      ((TextView)findViewById(2131297583)).setText(2131755691);
      this.ucS = findViewById(2131305909);
      this.ucS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56013);
          g.c.ueJ.a(g.a.ueA);
          c.a(c.this, c.udp, c.b(c.this).ta, false);
          c.c(c.this);
          c.this.activity.finish();
          AppMethodBeat.o(56013);
        }
      });
      this.ucS.setVisibility(0);
      this.tAi = findViewById(2131305910);
      this.ucT = findViewById(2131297599);
      switch (this.type)
      {
      default: 
        this.tAi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(56018);
            g.c.ueJ.a(g.a.uez);
            c.d(c.this);
            AppMethodBeat.o(56018);
          }
        });
        this.tAi.setVisibility(0);
        nD(false);
        this.udb = ((RelativeLayout)findViewById(2131301531));
        this.ucL = ((MMLoadMoreListView)this.activity.findViewById(2131303334));
        this.ucM = ((MMLoadMoreListView)this.activity.findViewById(2131304431));
        this.ucP = findViewById(2131301491);
        this.ucU = ((TextView)findViewById(2131304416));
        this.ucJ = ((PoiHeaderView)findViewById(2131303327));
        this.udi = ((FrameLayout)findViewById(2131302156));
        this.ucQ = ((ImageButton)findViewById(2131301520));
        this.ucQ.setSelected(true);
        this.ucQ.setContentDescription(this.activity.getString(2131760710));
        this.ucQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182066);
            ac.d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", new Object[] { Double.valueOf(c.e(c.this)), Double.valueOf(c.f(c.this)) });
            if ((c.e(c.this) == -85.0D) || (c.f(c.this) == -1000.0D))
            {
              ac.i("MicroMsg.MMPoiMapUI", "invalid lat lng");
              AppMethodBeat.o(182066);
              return;
            }
            if (c.g(c.this))
            {
              c.this.uaq.getIController().animateTo(c.e(c.this), c.f(c.this));
              c.h(c.this).setSelected(true);
              c.a(c.this, c.c.udU);
              AppMethodBeat.o(182066);
              return;
            }
            c.this.uaq.getIController().animateTo(c.e(c.this), c.f(c.this));
            c.a(c.this, c.e(c.this));
            c.b(c.this, c.f(c.this));
            c.a(c.this).l(c.i(c.this), c.j(c.this));
            c.h(c.this).setSelected(true);
            c.a(c.this, false);
            c.b(c.this).ta = 0;
            c.k(c.this).setSelection(0);
            g.c.ueJ.uex = 0;
            g.c.ueJ.a(g.b.ueH);
            c.l(c.this);
            AppMethodBeat.o(182066);
          }
        });
        this.uaq.setBuiltInZoomControls(false);
        this.ucA = ((FrameLayout)findViewById(2131298786));
        this.ucW = new MyPoiPoint(this.activity, this.uaq);
        this.ucK = new PickPoi(this.activity);
        this.ucK.setOnCurPoiGet(new b()
        {
          public final void a(f paramAnonymousf)
          {
            AppMethodBeat.i(182067);
            c.a(c.this).setOnCurPoiGet(null);
            if (paramAnonymousf != null)
            {
              c.m(c.this).c(paramAnonymousf.ueu);
              if (c.b(c.this) != null)
              {
                c.b(c.this).hv(c.m(c.this).ueo, c.m(c.this).uep);
                c.n(c.this).hv(c.m(c.this).ueo, c.m(c.this).uep);
              }
            }
            AppMethodBeat.o(182067);
          }
        });
        this.ucA.addView(this.ucK);
        paramBundle = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GHw, "");
        if ((!bs.isNullOrNil(paramBundle)) && ((this.ucX == -85.0D) || (this.ucY == -1000.0D)))
        {
          String[] arrayOfString = paramBundle.split(",");
          ac.i("MicroMsg.MMPoiMapUI", "last locationInfo ".concat(String.valueOf(paramBundle)));
          if (arrayOfString.length == 2)
          {
            float f1 = (float)(bs.aLy(arrayOfString[0]) * 1.0D / 1000000.0D);
            float f2 = (float)(bs.aLy(arrayOfString[1]) * 1.0D / 1000000.0D);
            this.uaq.getIController().animateTo(f1, f2);
          }
        }
        this.udD = new View.OnTouchListener()
        {
          private float udR;
          private short udS = 0;
          
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
              ac.d("MicroMsg.MMPoiMapUI", "newpoi action down %s.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
              this.udR = paramAnonymousMotionEvent.getRawY();
              c.b(c.this, false);
              continue;
              ac.d("MicroMsg.MMPoiMapUI", "newpoi action move %s.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
              if (c.p(c.this))
              {
                ac.d("MicroMsg.MMPoiMapUI", "newpoi blocked.");
                c.k(c.this).setSelection(0);
              }
              float f = this.udR - paramAnonymousMotionEvent.getRawY();
              if (Math.abs(f) < BackwardSupportUtil.b.g(c.this.activity, 20.0F)) {
                this.udS = 0;
              }
              while (((c.q(c.this)) && (this.udS == 1)) || ((c.r(c.this)) && (this.udS == -1)) || ((c.q(c.this)) && (!c.s(c.this).getScroll2Top()) && (this.udS == -1)))
              {
                AppMethodBeat.o(182068);
                return false;
                if (f > 0.0F) {
                  this.udS = 1;
                } else {
                  this.udS = -1;
                }
              }
              if ((c.o(c.this)) && (this.udS != 0))
              {
                ac.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[] { Short.valueOf(this.udS) });
                if (this.udS == 1)
                {
                  c.c(c.this, true);
                  c.a(c.this, c.c.udV);
                  AppMethodBeat.o(182068);
                  return false;
                }
                c.a(c.this, c.c.udU);
                AppMethodBeat.o(182068);
                return false;
              }
              AppMethodBeat.o(182068);
              return true;
              ac.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
              c.b(c.this, false);
            }
          }
        };
        this.ucL.setOnTouchListener(this.udD);
        this.ucL.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void Xa()
          {
            AppMethodBeat.i(182069);
            c.t(c.this);
            AppMethodBeat.o(182069);
          }
        });
        this.ucL.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182070);
            ac.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= c.b(c.this).getCount()))
            {
              ac.i("MicroMsg.MMPoiMapUI", "wrong position");
              AppMethodBeat.o(182070);
              return;
            }
            paramAnonymousAdapterView = c.b(c.this).HC(paramAnonymousInt);
            if (paramAnonymousAdapterView.type == 0) {
              c.h(c.this).setSelected(false);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView.bNq);
              c.b(c.this, paramAnonymousAdapterView.bNr);
              c.this.uaq.getIController().animateTo(paramAnonymousAdapterView.bNq, paramAnonymousAdapterView.bNr);
              c.b(c.this).ta = paramAnonymousInt;
              c.b(c.this).notifyDataSetChanged();
              c.a(c.this, false);
              g.c.ueJ.uex = (paramAnonymousInt + 1);
              g.c.ueJ.a(g.b.ueG);
              AppMethodBeat.o(182070);
              return;
              c.h(c.this).setSelected(true);
            }
          }
        });
        this.ucN = new e(this.activity);
        this.ucL.setAdapter(this.ucN);
        this.ucK.setAdapter(this.ucN);
        this.tZH = new PoiPoint.a()
        {
          public final void a(PoiPoint.b paramAnonymousb, PoiPoint paramAnonymousPoiPoint)
          {
            AppMethodBeat.i(182071);
            if (PoiPoint.b.tZK == paramAnonymousb)
            {
              if (-1 == c.n(c.this).ta) {
                c.d(c.this, true);
              }
              if (c.u(c.this) != null) {
                c.u(c.this).cXm();
              }
              c.this.uaq.getIController().animateTo(paramAnonymousPoiPoint.getLat(), paramAnonymousPoiPoint.getLng());
              c.a(c.this, paramAnonymousPoiPoint);
              paramAnonymousPoiPoint.cXn();
              c.a(c.this, paramAnonymousPoiPoint.getPosition());
              c.n(c.this).ta = paramAnonymousPoiPoint.getPosition();
              c.n(c.this).notifyDataSetChanged();
              g.c.ueJ.uex = (paramAnonymousPoiPoint.getPosition() + 1);
              g.c.ueJ.a(g.b.ueE);
              AppMethodBeat.o(182071);
              return;
            }
            paramAnonymousb = PoiPoint.b.tZJ;
            AppMethodBeat.o(182071);
          }
        };
        this.ucO = new e(this.activity);
        this.ucO.iNn = true;
        this.ucO.ta = -1;
        this.ucM.setAdapter(this.ucO);
        this.ucM.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void Xa()
          {
            AppMethodBeat.i(182051);
            c.t(c.this);
            AppMethodBeat.o(182051);
          }
        });
        this.ucM.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182052);
            if (-1 == c.n(c.this).ta)
            {
              c.d(c.this, true);
              c.a(c.this, c.c.udU);
            }
            c.n(c.this).ta = paramAnonymousInt;
            c.n(c.this).notifyDataSetChanged();
            if ((paramAnonymousInt >= 0) && (paramAnonymousInt < c.n(c.this).getCount()))
            {
              c.a(c.this, true);
              if (c.u(c.this) != null) {
                c.u(c.this).cXm();
              }
              paramAnonymousView = c.n(c.this).HC(paramAnonymousInt);
              if ((paramAnonymousView.bNq == c.e(c.this)) && (paramAnonymousView.bNr == c.f(c.this))) {
                break label349;
              }
              c.h(c.this).setSelected(false);
              c.this.uaq.getIController().animateTo(paramAnonymousView.bNq, paramAnonymousView.bNr);
              paramAnonymousAdapterView = (PoiPoint)c.v(c.this).get(paramAnonymousView.bNq + paramAnonymousView.bNr);
              if (paramAnonymousAdapterView != null) {
                break label363;
              }
              paramAnonymousAdapterView = new PoiPoint(c.this.activity, c.this.uaq);
              paramAnonymousAdapterView.setPosition(paramAnonymousInt);
              paramAnonymousAdapterView.setOnPointClick(c.this.tZH);
              c.v(c.this).put(paramAnonymousView.bNq + paramAnonymousView.bNr, paramAnonymousAdapterView);
              paramAnonymousAdapterView.c(paramAnonymousView.bNq, paramAnonymousView.bNr, true);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView);
              g.c.ueJ.uex = (paramAnonymousInt + 1);
              g.c.ueJ.a(g.b.ueD);
              AppMethodBeat.o(182052);
              return;
              label349:
              c.h(c.this).setSelected(true);
              break;
              label363:
              paramAnonymousAdapterView.cXn();
            }
          }
        });
        this.ucM.setOnTouchListener(this.udD);
        this.udy = findViewById(2131304573);
        this.udz = findViewById(2131304575);
        this.udA = ((EditText)findViewById(2131304572));
        this.udB = ((ImageView)findViewById(2131304577));
        this.udC = findViewById(2131304571);
        this.udy.setOnClickListener(new View.OnClickListener()
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
        this.udC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182059);
            c.a(c.this, c.cXX(), c.n(c.this).ta, true);
            c.y(c.this);
            AppMethodBeat.o(182059);
          }
        });
        this.udA.setOnTouchListener(new View.OnTouchListener()
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
                c.a(c.this, c.c.udV);
              }
            }
          }
        });
        this.udA.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(182061);
            if (3 == paramAnonymousInt)
            {
              c.a(c.this, c.c.udU);
              c.h(c.this, true);
            }
            AppMethodBeat.o(182061);
            return false;
          }
        });
        this.udA.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(182062);
            ac.d("MicroMsg.MMPoiMapUI", "searchText: %s.", new Object[] { paramAnonymousCharSequence });
            c.a(c.this, paramAnonymousCharSequence.toString());
            c.J(c.this).fix();
            c.K(c.this).setVisibility(8);
            if (bs.isNullOrNil(c.E(c.this)))
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
        this.udB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182063);
            c.P(c.this).setText("");
            c.A(c.this);
            AppMethodBeat.o(182063);
          }
        });
        cXV();
        this.udw = findViewById(2131304570);
        this.udw.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182053);
            ac.d("MicroMsg.MMPoiMapUI", "pennqin, collapseBtnLayoutHeight: %d.", new Object[] { Integer.valueOf(c.w(c.this)) });
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
            c.a(c.this, c.c.udU);
            AppMethodBeat.o(182054);
          }
        });
        this.udN = ((InputPanelFrameLayout)findViewById(2131303335));
        this.udN.setExternalListener(new com.tencent.mm.ui.widget.b.a()
        {
          public final void g(boolean paramAnonymousBoolean, int paramAnonymousInt)
          {
            AppMethodBeat.i(182055);
            ac.d("MicroMsg.MMPoiMapUI", "isKeyboardShow: %s.", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            c.e(c.this, paramAnonymousBoolean);
            AppMethodBeat.o(182055);
          }
        });
        paramBundle = aj.cl(this.activity);
        j = Math.max(paramBundle.x, paramBundle.y);
        this.udc = (j - BackwardSupportUtil.b.g(this.activity, 320.0F));
        this.udd = ((int)(j * 0.25F + 0.5D));
        this.ude = ((int)((this.udc - this.udd) / 3.0D + 0.5D));
        ac.i("MicroMsg.MMPoiMapUI", "collapsedTopMargin: %d, openedTopMargin: %d, mapViewTopMargin: %d.", new Object[] { Integer.valueOf(this.udc), Integer.valueOf(this.udd), Integer.valueOf(this.ude) });
        this.udv = new int[] { this.udc - this.udd - this.ude + 24, 24 };
        i = this.activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i <= 0) {
          break;
        }
      }
    }
    for (int i = this.activity.getResources().getDimensionPixelSize(i);; i = 0)
    {
      paramBundle = (FrameLayout.LayoutParams)this.ucV.getLayoutParams();
      paramBundle.height += i * 2;
      this.ucV.setLayoutParams(paramBundle);
      this.ucV.setPadding(0, i, 0, i);
      if (ap.jF(this.activity))
      {
        i = ap.ej(this.activity);
        label1279:
        j = j - this.udd - i;
        ac.i("MicroMsg.MMPoiMapUI", "reset poi view height: %s, navigationBarHeight: %s.", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramBundle = this.udb.getLayoutParams();
        paramBundle.height = j;
        this.udb.setLayoutParams(paramBundle);
        paramBundle = (RelativeLayout.LayoutParams)this.udi.getLayoutParams();
        paramBundle.height = this.udc;
        this.udi.setLayoutParams(paramBundle);
        b(c.c.udU);
        if ((this.type != 0) && (this.type != 8)) {
          break label1512;
        }
        g.c.ueJ.setScene(this.activity.getIntent().getIntExtra("type_tag", 0));
      }
      for (;;)
      {
        this.ucK.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
        cXM().disableDarkMode();
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
        g.c.ueJ.setScene(this.type);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56049);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(457, this);
    AppMethodBeat.o(56049);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56047);
    super.onPause();
    this.udJ = false;
    com.tencent.mm.modelgeo.d.aEL().c(this.fnd);
    MyPoiPoint localMyPoiPoint = this.ucW;
    ac.d("MicroMsg.MyPoiPoint", "disableLocation");
    localMyPoiPoint.tZa.c(localMyPoiPoint.fnd);
    AppMethodBeat.o(56047);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56046);
    super.onResume();
    this.udJ = true;
    com.tencent.mm.modelgeo.d.aEL().b(this.fnd, true);
    this.ucW.cXl();
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
      this.ucR = null;
      com.tencent.mm.plugin.location.model.i locali = (com.tencent.mm.plugin.location.model.i)paramn;
      if (!locali.tWX.equals(this.tWX))
      {
        ac.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.tWX + " " + locali.tWX);
        AppMethodBeat.o(56054);
        return;
      }
      ac.i("MicroMsg.MMPoiMapUI", "isEnd: " + locali.gNN + " searchId: " + locali.jKB + " isInSearch: " + this.ucZ);
      if (this.udk == -1L)
      {
        long l = System.currentTimeMillis();
        this.udl = l;
        this.udk = l;
      }
      for (;;)
      {
        this.tWY = locali.tWY;
        this.ucP.setVisibility(8);
        if (!this.ucZ) {
          break label419;
        }
        if (!bs.isNullOrNil(this.hPI)) {
          break;
        }
        AppMethodBeat.o(56054);
        return;
        this.udl = System.currentTimeMillis();
      }
      if ((locali.list != null) && (locali.list.size() == 0))
      {
        this.ucU.setVisibility(0);
        this.ucM.fix();
      }
      ac.d("MicroMsg.MMPoiMapUI", "search is first: %s", new Object[] { Boolean.valueOf(locali.isFirst()) });
      if (locali.isFirst())
      {
        this.ucO.cyW = true;
        this.ucO.ued.clear();
      }
      this.ucO.a(locali.list, locali.tWW, locali.gNN, locali.tWX);
      if (!this.ucO.gNN)
      {
        this.ucM.fiw();
        this.ucM.fiy();
      }
      while (this.udG)
      {
        this.udG = false;
        cXT();
        AppMethodBeat.o(56054);
        return;
        this.ucM.fix();
        this.ucM.fiz();
      }
      label419:
      Object localObject2;
      Object localObject1;
      if (this.ucJ != null)
      {
        localObject2 = (bbh)locali.rr.hvs.hvw;
        paramn = this.ucJ;
        localObject1 = ((bbh)localObject2).Ebg;
        paramString = ((bbh)localObject2).EQs;
        String str = ((bbh)localObject2).Url;
        localObject2 = com.tencent.mm.plugin.image.d.awL();
        ac.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[] { paramString, str });
        paramn.tZm = str;
        paramn.tZn = "";
        if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil(paramString))) {
          break label629;
        }
        paramn.setVisibility(8);
        paramn.fxS.setVisibility(8);
        paramn.tZo.setVisibility(8);
      }
      for (;;)
      {
        nD(true);
        this.ucN.a(locali.list, locali.tWW, locali.gNN, locali.tWX);
        this.ucN.ta = 0;
        this.ucN.notifyDataSetChanged();
        if (this.ucN.gNN) {
          break;
        }
        this.ucL.fiw();
        this.ucL.fiy();
        AppMethodBeat.o(56054);
        return;
        label629:
        paramn.setVisibility(0);
        paramn.fxS.setVisibility(0);
        paramn.tZo.setVisibility(0);
        paramn.fxS.setText((CharSequence)localObject1);
        localObject1 = paramn.tZo;
        ((SimpleImageView)localObject1).imagePath = ((String)localObject2);
        ((SimpleImageView)localObject1).url = paramString;
        ((SimpleImageView)localObject1).gNU = 0;
        ((SimpleImageView)localObject1).gNV = 0;
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
            if (((SimpleImageView)localObject1).gNU > 0)
            {
              paramString = paramn;
              if (((SimpleImageView)localObject1).gNV > 0) {
                paramString = com.tencent.mm.sdk.platformtools.f.a(paramn, ((SimpleImageView)localObject1).gNU, ((SimpleImageView)localObject1).gNV, true, false);
              }
            }
            ((SimpleImageView)localObject1).setImageBitmap(paramString);
          }
          else
          {
            com.tencent.mm.sdk.g.b.c(new SimpleImageView.a(paramString, ((SimpleImageView)localObject1).handler), "SimpleImageView_download");
          }
        }
        else if (!com.tencent.mm.vfs.i.eA(paramString))
        {
          ((SimpleImageView)localObject1).setVisibility(8);
        }
        else
        {
          if ((((SimpleImageView)localObject1).gNU <= 0) || (((SimpleImageView)localObject1).gNV <= 0)) {}
          for (paramString = com.tencent.mm.sdk.platformtools.f.aKz(paramString);; paramString = com.tencent.mm.sdk.platformtools.f.e(paramString, ((SimpleImageView)localObject1).gNU, ((SimpleImageView)localObject1).gNV, true))
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
      this.ucL.fix();
      this.ucL.fiz();
    }
    AppMethodBeat.o(56054);
  }
  
  final class a
    extends TranslateAnimation
  {
    private List<View> udT;
    
    public a(float paramFloat)
    {
      super(0.0F, 0.0F, paramFloat);
      AppMethodBeat.i(56025);
      this.udT = new ArrayList();
      AppMethodBeat.o(56025);
    }
    
    public final a cXY()
    {
      AppMethodBeat.i(56026);
      setDuration(200L);
      AppMethodBeat.o(56026);
      return this;
    }
    
    public final a cXZ()
    {
      AppMethodBeat.i(56027);
      setFillEnabled(true);
      setFillAfter(true);
      AppMethodBeat.o(56027);
      return this;
    }
    
    public final a eh(View paramView)
    {
      AppMethodBeat.i(56028);
      this.udT.add(paramView);
      AppMethodBeat.o(56028);
      return this;
    }
    
    public final void startAnimation()
    {
      AppMethodBeat.i(56029);
      int i = 0;
      while (i < this.udT.size())
      {
        ((View)this.udT.get(i)).startAnimation(this);
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