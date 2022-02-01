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
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.location.model.i;
import com.tencent.mm.plugin.location.ui.MyPoiPoint;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.PoiPoint;
import com.tencent.mm.plugin.location.ui.PoiPoint.a;
import com.tencent.mm.plugin.location.ui.PoiPoint.b;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.SimpleImageView.a;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.vfs.o;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends b
  implements com.tencent.mm.ak.f
{
  private static int vsf = 11;
  private static int vsg = 12;
  private static int vsh = 13;
  private static int vsi = 14;
  private com.tencent.mm.modelgeo.b.a fHp;
  private String ilP;
  private double lat;
  private double lng;
  private View uOw;
  private String vlR;
  private int vlS;
  PoiPoint.a voB;
  private PoiHeaderView vrA;
  private PickPoi vrB;
  private MMLoadMoreListView vrC;
  private MMLoadMoreListView vrD;
  private e vrE;
  private e vrF;
  private View vrG;
  private ImageButton vrH;
  private i vrI;
  private View vrJ;
  private View vrK;
  private TextView vrL;
  private LinearLayout vrM;
  private MyPoiPoint vrN;
  private double vrO;
  private double vrP;
  private boolean vrQ;
  private int vrR;
  private RelativeLayout vrS;
  private int vrT;
  private int vrU;
  private int vrV;
  private boolean vrW;
  private boolean vrX;
  private boolean vrY;
  private FrameLayout vrZ;
  private FrameLayout vrr;
  private boolean vsA;
  private boolean vsB;
  private boolean vsC;
  private boolean vsD;
  private InputPanelFrameLayout vsE;
  private int vsa;
  private long vsb;
  private long vsc;
  private long vsd;
  private int vse;
  private boolean vsj;
  private boolean vsk;
  private int[] vsl;
  private int[] vsm;
  private View vsn;
  private int vso;
  private View vsp;
  private View vsq;
  private EditText vsr;
  private ImageView vss;
  private View vst;
  private View.OnTouchListener vsu;
  private PoiPoint vsv;
  private Map<String, PoiPoint> vsw;
  private boolean vsx;
  private f vsy;
  private boolean vsz;
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56033);
    this.vrI = null;
    this.lat = -85.0D;
    this.lng = -1000.0D;
    this.vrO = -85.0D;
    this.vrP = -1000.0D;
    this.vlR = "";
    this.vrQ = false;
    this.ilP = "";
    this.vrR = 0;
    this.vrW = true;
    this.vrX = false;
    this.vrY = false;
    this.vsa = 0;
    this.vsb = -1L;
    this.vsc = -1L;
    this.vsd = -1L;
    this.vse = -1;
    this.vsj = false;
    this.vlS = 1;
    this.vsl = new int[] { 24, 24 };
    this.vsw = new HashMap();
    this.vsy = new f();
    this.vsz = false;
    this.fHp = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(182065);
        if (!paramAnonymousBoolean)
        {
          if ((!c.Q(c.this)) && (!com.tencent.mm.modelgeo.d.aIi()))
          {
            c.R(c.this);
            com.tencent.mm.ui.base.h.a(c.this.activity, c.this.activity.getString(2131760082), c.this.activity.getString(2131755906), c.this.activity.getString(2131760598), c.this.activity.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(182064);
                com.tencent.mm.modelgeo.d.cD(c.this.activity);
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
          ae.d("MicroMsg.MMPoiMapUI", "init my location.");
          str = (int)(1000000.0F * paramAnonymousFloat2) + "," + (int)(1000000.0F * paramAnonymousFloat1);
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IOl, str);
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
          c.this.vpk.getIController().animateTo(c.e(c.this), c.f(c.this), com.tencent.mm.plugin.location.ui.d.djt());
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
            ae.d("MicroMsg.MMPoiMapUI", "update lat/lng.");
            str = (int)(1000000.0F * paramAnonymousFloat2) + "," + (int)(1000000.0F * paramAnonymousFloat1);
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IOl, str);
            c.c(c.this, paramAnonymousFloat2);
            c.d(c.this, paramAnonymousFloat1);
          }
        }
      }
    };
    this.vsA = false;
    this.vsB = false;
    this.vsC = false;
    this.vsD = false;
    AppMethodBeat.o(56033);
  }
  
  private String a(double paramDouble, String paramString)
  {
    AppMethodBeat.i(56042);
    paramString = (int)(paramDouble * 1000000.0D) + "_" + (int)(this.lng * 1000000.0D) + "_" + paramString;
    AppMethodBeat.o(56042);
    return paramString;
  }
  
  private void a(final c paramc)
  {
    AppMethodBeat.i(56037);
    if (((c.vsM == paramc) && (this.vrY)) || ((c.vsL == paramc) && (!this.vrY)))
    {
      AppMethodBeat.o(56037);
      return;
    }
    if (this.vsn.getVisibility() != 0) {
      this.vsn.setVisibility(0);
    }
    this.vrW = false;
    int i;
    a locala2;
    a locala1;
    if (c.vsM == paramc)
    {
      ae.d("MicroMsg.MMPoiMapUI", "pennqin play open animation, getListTopMargin(): %d, openedTopMargin: %d.", new Object[] { Integer.valueOf(dkf()), Integer.valueOf(this.vrU) });
      i = dkf() - this.vrU;
      ae.d("MicroMsg.MMPoiMapUI", "pennqin play open animation (getListTopMargin() - openedTopMargin): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(-i);
      locala1 = new a(-this.vrV);
    }
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.vso });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.vso, 0 }))
    {
      paramc = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(182057);
          c.f(c.this, true);
          if (c.c.vsM == paramc)
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
            if ((!c.n(c.this).pwx.equals(c.E(c.this))) || (!c.n(c.this).cKB)) {
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
              c.a(c.this, c.n(c.this).uT);
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
          ae.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
      locala2 = locala2.dkj().dkk();
      locala2.setAnimationListener(paramc);
      locala2.ep(this.vrS).ep(this.vrH).startAnimation();
      locala1.dkj().dkk().ep(this.vrZ).startAnimation();
      localValueAnimator.setDuration(200L).start();
      AppMethodBeat.o(56037);
      return;
      ae.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation, getListTopMargin(): %d, collapsedTopMargin: %d.", new Object[] { Integer.valueOf(dkf()), Integer.valueOf(this.vrT) });
      i = this.vrT - dkf();
      ae.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation (collapsedTopMargin - getListTopMargin()): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(i);
      locala1 = new a(this.vrV);
    }
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(56055);
    if (c.vsL == paramc)
    {
      ((FrameLayout.LayoutParams)this.vrS.getLayoutParams()).topMargin = this.vrT;
      ((RelativeLayout.LayoutParams)this.vrZ.getLayoutParams()).topMargin = 0;
      ((FrameLayout.LayoutParams)this.vrH.getLayoutParams()).topMargin = (this.vrT - aq.fromDPToPix(this.activity, 92));
      this.vpk.setLogoMargin(this.vsl);
    }
    for (;;)
    {
      this.vrS.requestLayout();
      this.vrH.requestLayout();
      this.vrZ.requestLayout();
      AppMethodBeat.o(56055);
      return;
      if (c.vsM == paramc)
      {
        ((FrameLayout.LayoutParams)this.vrS.getLayoutParams()).topMargin = this.vrU;
        ((RelativeLayout.LayoutParams)this.vrZ.getLayoutParams()).topMargin = (-this.vrV);
        ((FrameLayout.LayoutParams)this.vrH.getLayoutParams()).topMargin = (this.vrU - aq.fromDPToPix(this.activity, 92));
        this.vpk.setLogoMargin(this.vsm);
      }
    }
  }
  
  private boolean dka()
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
  
  private void dkb()
  {
    AppMethodBeat.i(56039);
    this.vrQ = false;
    this.vrr.setVisibility(0);
    a(c.vsL);
    dkg();
    this.ilP = "";
    this.vrD.setVisibility(8);
    this.vrE.notifyDataSetChanged();
    this.vrC.setVisibility(0);
    this.vrG.setVisibility(8);
    this.vrL.setVisibility(8);
    dkd();
    oc(true);
    this.vrH.setSelected(this.vsz);
    this.vpk.getIController().animateTo(this.lat, this.lng);
    AppMethodBeat.o(56039);
  }
  
  private void dkc()
  {
    AppMethodBeat.i(56043);
    if (this.vrB.vsQ)
    {
      f localf = this.vrB.getPoi();
      e locale = this.vrE;
      if (locale.vsU.size() >= 0)
      {
        locale.vsU.add(0, localf);
        locale.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(56043);
  }
  
  private void dkd()
  {
    AppMethodBeat.i(56050);
    Iterator localIterator = this.vsw.values().iterator();
    while (localIterator.hasNext()) {
      ((PoiPoint)localIterator.next()).remove();
    }
    this.vsw.clear();
    this.vsv = null;
    AppMethodBeat.o(56050);
  }
  
  private void dke()
  {
    AppMethodBeat.i(56051);
    Object localObject = new ArrayList(5);
    int i = 0;
    while ((i < 5) && (i < this.vrF.getCount()))
    {
      ((List)localObject).add(this.vrF.Jx(i));
      i += 1;
    }
    localObject = et((List)localObject);
    dkd();
    i = 0;
    while (i < ((List)localObject).size())
    {
      f localf = this.vrF.Jx(i);
      PoiPoint localPoiPoint = new PoiPoint(this.activity, this.vpk);
      localPoiPoint.setPosition(i);
      localPoiPoint.setOnPointClick(this.voB);
      this.vsw.put(localf.bXD + localf.bXE, localPoiPoint);
      localPoiPoint.c(localf.bXD, localf.bXE, false);
      i += 1;
    }
    eu((List)localObject);
    AppMethodBeat.o(56051);
  }
  
  private int dkf()
  {
    AppMethodBeat.i(56056);
    int i = ((ViewGroup.MarginLayoutParams)this.vrS.getLayoutParams()).topMargin;
    AppMethodBeat.o(56056);
    return i;
  }
  
  private void dkg()
  {
    AppMethodBeat.i(56057);
    if (this.vrQ)
    {
      this.vsp.setVisibility(8);
      this.vsq.setVisibility(0);
      this.vst.setVisibility(0);
      AppMethodBeat.o(56057);
      return;
    }
    this.vsp.setVisibility(0);
    this.vsq.setVisibility(8);
    this.vst.setVisibility(8);
    AppMethodBeat.o(56057);
  }
  
  private void dkh()
  {
    AppMethodBeat.i(56058);
    if (!this.vsB)
    {
      this.vsB = true;
      this.vsr.requestFocus();
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
  
  private static List<f> et(List<f> paramList)
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
        if (TencentLocationUtils.distanceBetween(localf1.bXD, localf1.bXE, localf2.bXD, localf2.bXE) > 5000.0D) {
          break label121;
        }
        localArrayList.add(localf1);
      }
    }
    label121:
    AppMethodBeat.o(56052);
    return localArrayList;
  }
  
  private void eu(List<f> paramList)
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
      this.vpk.getIController().animateTo(((f)paramList.get(0)).bXD, ((f)paramList.get(0)).bXE);
      AppMethodBeat.o(56053);
      return;
    }
    ArrayList localArrayList = new ArrayList(5);
    while (i < paramList.size())
    {
      f localf = (f)paramList.get(i);
      localArrayList.add(new LatLng(localf.bXD, localf.bXE));
      i += 1;
    }
    paramList = LatLngBounds.builder().include(localArrayList).build();
    if ((Double.isInfinite(paramList.getNortheast().getLatitude())) || (Double.isNaN(paramList.getNortheast().getLongitude())) || (Double.isInfinite(paramList.getSouthwest().getLatitude())) || (Double.isNaN(paramList.getSouthwest().getLongitude())))
    {
      AppMethodBeat.o(56053);
      return;
    }
    this.vpk.animateCamera(CameraUpdateFactory.newLatLngBounds(paramList, 250));
    AppMethodBeat.o(56053);
  }
  
  private void nh(boolean paramBoolean)
  {
    AppMethodBeat.i(56044);
    ae.d("MicroMsg.MMPoiMapUI", "stack: %s", new Object[] { bu.fpN() });
    this.vlR = a(this.lat, this.ilP);
    if (this.vlR.equals(this.vrE.key))
    {
      ae.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[] { this.vlR });
      AppMethodBeat.o(56044);
      return;
    }
    byte[] arrayOfByte = null;
    int i = 1;
    this.vrG.setVisibility(0);
    label185:
    double d1;
    double d2;
    if (this.vrQ) {
      if ((this.vlS > 0) && (paramBoolean))
      {
        this.vrD.fCO();
        this.vrF.dkl();
        this.vrF.apQ(this.vlR);
        this.vrF.pwx = this.ilP;
        this.vrF.cKB = false;
        arrayOfByte = this.vrF.buffer;
        if (i == 0) {
          break label436;
        }
        if (this.vrR != 0) {
          break label424;
        }
        i = 0;
        d1 = this.lat;
        d2 = this.lng;
        if (!this.vrQ) {
          break label430;
        }
      }
    }
    label424:
    label430:
    for (int j = 0;; j = 1)
    {
      this.vrI = new i(arrayOfByte, d1, d2, i, j, this.vrP, this.vrO, this.vlR, this.ilP, paramBoolean);
      com.tencent.mm.kernel.g.ajj().a(this.vrI, 0);
      this.vsa += 1;
      if (this.vsd == -1L) {
        this.vsd = System.currentTimeMillis();
      }
      AppMethodBeat.o(56044);
      return;
      if (!paramBoolean)
      {
        this.vrD.fCO();
        this.vrF.clean();
        this.vrF.apQ(this.vlR);
        this.vrF.pwx = this.ilP;
        this.vrF.cKB = false;
        arrayOfByte = this.vrF.buffer;
        this.vrF.notifyDataSetChanged();
        break;
      }
      i = 0;
      this.vrF.cKB = false;
      break;
      this.vrC.fCO();
      this.vrE.clean();
      this.vrE.apQ(this.vlR);
      this.vrE.notifyDataSetChanged();
      arrayOfByte = this.vrE.buffer;
      oc(false);
      dkc();
      break;
      i = 1;
      break label185;
    }
    label436:
    ae.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", new Object[] { Integer.valueOf(this.vlS) });
    AppMethodBeat.o(56044);
  }
  
  private void oc(boolean paramBoolean)
  {
    AppMethodBeat.i(56048);
    ae.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.uOw.setEnabled(paramBoolean);
    this.vrK.setEnabled(paramBoolean);
    AppMethodBeat.o(56048);
  }
  
  private void t(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(56045);
    String str3;
    String str1;
    String str2;
    if ((this.vrO == -85.0D) || (this.vrP == -1000.0D))
    {
      str3 = "null/null";
      str1 = "";
      if (paramBoolean) {
        break label563;
      }
      if ((paramInt2 < 0) || (paramInt2 >= this.vrE.getCount())) {
        break label614;
      }
      str1 = this.vrE.Jx(paramInt2).vtl;
      str2 = this.vrE.Jx(paramInt2).vtb;
    }
    for (;;)
    {
      label82:
      String str4 = str1;
      if (paramInt2 == 0)
      {
        str4 = str1;
        if (bu.isNullOrNil(str1))
        {
          str4 = str1;
          if (this.vrE.getCount() > 1)
          {
            ae.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str4 = this.vrE.Jx(1).vtl;
          }
        }
      }
      if ((this.vrE.getCount() > 0) && (!paramBoolean)) {
        ae.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", new Object[] { Integer.valueOf(paramInt2) });
      }
      for (str1 = this.vrE.Jx(0).dyb;; str1 = "")
      {
        int i = paramInt2;
        if (paramInt2 == 0)
        {
          i = paramInt2;
          if (!paramBoolean)
          {
            i = paramInt2;
            if (this.vrE.getCount() > 0)
            {
              int j = this.vrE.Jx(0).vtm;
              i = paramInt2;
              if (j >= 0)
              {
                ae.d("MicroMsg.MMPoiMapUI", "change to search index: %s", new Object[] { Integer.valueOf(j) });
                i = j;
              }
            }
          }
        }
        ae.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.vsd), Long.valueOf(this.vsc), Long.valueOf(this.vsb), Integer.valueOf(this.vsa), str3, Integer.valueOf(this.vse), str4, str1 });
        com.tencent.mm.plugin.report.service.g.yxI.f(11135, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.vsd), Long.valueOf(this.vsc), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.vsb), Integer.valueOf(this.vsa), str3, str2, Integer.valueOf(this.vse), str4, com.tencent.mm.compatible.deviceinfo.q.cH(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
        AppMethodBeat.o(56045);
        return;
        str3 = String.format("%f/%f", new Object[] { Double.valueOf(this.vrO), Double.valueOf(this.vrP) });
        break;
        label563:
        if ((paramInt2 < 0) || (paramInt2 >= this.vrF.getCount())) {
          break label614;
        }
        str1 = this.vrF.Jx(paramInt2).vtl;
        str2 = this.vrF.Jx(paramInt2).vtb;
        break label82;
      }
      label614:
      str2 = "";
    }
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(56038);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ae.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent, back.");
      g.c.vtz.a(g.a.vtq);
      if (this.vrQ)
      {
        dkb();
        t(vsi, this.vrF.uT, true);
        AppMethodBeat.o(56038);
        return false;
      }
      t(vsg, this.vrE.uT, false);
      this.activity.finish();
      AppMethodBeat.o(56038);
      return true;
    }
    AppMethodBeat.o(56038);
    return false;
  }
  
  public final com.tencent.mm.plugin.k.d djX()
  {
    AppMethodBeat.i(56036);
    com.tencent.mm.plugin.k.d locald = (com.tencent.mm.plugin.k.d)this.activity.findViewById(2131300334);
    AppMethodBeat.o(56036);
    return locald;
  }
  
  public final void djY()
  {
    AppMethodBeat.i(56040);
    a(c.vsL);
    AppMethodBeat.o(56040);
  }
  
  public final void djZ()
  {
    AppMethodBeat.i(56041);
    if (this.vrH.isSelected()) {
      this.vrH.setSelected(false);
    }
    if (!this.vrQ)
    {
      this.vrB.play();
      this.lat = (this.vpk.getMapCenterX() / 1000000.0D);
      this.lng = (this.vpk.getMapCenterY() / 1000000.0D);
      this.vrB.l(this.lat, this.lng);
      this.vrH.setSelected(false);
      if (this.vrY) {
        a(c.vsL);
      }
      nh(false);
      this.vsj = false;
      g.c.vtz.vtn = 0;
      g.c.vtz.a(g.b.vtv);
    }
    AppMethodBeat.o(56041);
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
    com.tencent.mm.kernel.g.ajj().a(457, this);
    this.vse = ((int)(System.currentTimeMillis() / 1000L));
    this.vpk.setCanRotate(false);
    label212:
    int j;
    if (al.isDarkMode())
    {
      djX().enableDarkMode();
      this.vrM = ((LinearLayout)findViewById(2131300707));
      ((TextView)findViewById(2131297583)).setText(2131755691);
      this.vrJ = findViewById(2131305909);
      this.vrJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56013);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          g.c.vtz.a(g.a.vtq);
          c.a(c.this, c.vsg, c.b(c.this).uT, false);
          c.c(c.this);
          c.this.activity.finish();
          a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(56013);
        }
      });
      this.vrJ.setVisibility(0);
      this.uOw = findViewById(2131305910);
      this.vrK = findViewById(2131297599);
      switch (this.type)
      {
      default: 
        this.uOw.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(56018);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            g.c.vtz.a(g.a.vtp);
            c.d(c.this);
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(56018);
          }
        });
        this.uOw.setVisibility(0);
        oc(false);
        this.vrS = ((RelativeLayout)findViewById(2131301531));
        this.vrC = ((MMLoadMoreListView)this.activity.findViewById(2131303334));
        this.vrD = ((MMLoadMoreListView)this.activity.findViewById(2131304431));
        this.vrG = findViewById(2131301491);
        this.vrL = ((TextView)findViewById(2131304416));
        this.vrA = ((PoiHeaderView)findViewById(2131303327));
        this.vrZ = ((FrameLayout)findViewById(2131302156));
        this.vrH = ((ImageButton)findViewById(2131301520));
        this.vrH.setSelected(true);
        this.vrH.setContentDescription(this.activity.getString(2131760710));
        this.vrH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182066);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", new Object[] { Double.valueOf(c.e(c.this)), Double.valueOf(c.f(c.this)) });
            if ((c.e(c.this) == -85.0D) || (c.f(c.this) == -1000.0D))
            {
              ae.i("MicroMsg.MMPoiMapUI", "invalid lat lng");
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182066);
              return;
            }
            if (c.g(c.this))
            {
              c.this.vpk.getIController().animateTo(c.e(c.this), c.f(c.this));
              c.h(c.this).setSelected(true);
              c.a(c.this, c.c.vsL);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182066);
              return;
              c.this.vpk.getIController().animateTo(c.e(c.this), c.f(c.this));
              c.a(c.this, c.e(c.this));
              c.b(c.this, c.f(c.this));
              c.a(c.this).l(c.i(c.this), c.j(c.this));
              c.h(c.this).setSelected(true);
              c.a(c.this, false);
              c.b(c.this).uT = 0;
              c.k(c.this).setSelection(0);
              g.c.vtz.vtn = 0;
              g.c.vtz.a(g.b.vtx);
              c.l(c.this);
            }
          }
        });
        this.vpk.setBuiltInZoomControls(false);
        this.vrr = ((FrameLayout)findViewById(2131298786));
        this.vrN = new MyPoiPoint(this.activity, this.vpk);
        this.vrB = new PickPoi(this.activity);
        this.vrB.setOnCurPoiGet(new b()
        {
          public final void a(f paramAnonymousf)
          {
            AppMethodBeat.i(182067);
            c.a(c.this).setOnCurPoiGet(null);
            if (paramAnonymousf != null)
            {
              c.m(c.this).c(paramAnonymousf.vtk);
              if (c.b(c.this) != null)
              {
                c.b(c.this).hO(c.m(c.this).vte, c.m(c.this).vtf);
                c.n(c.this).hO(c.m(c.this).vte, c.m(c.this).vtf);
              }
            }
            AppMethodBeat.o(182067);
          }
        });
        this.vrr.addView(this.vrB);
        paramBundle = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IOl, "");
        if ((!bu.isNullOrNil(paramBundle)) && ((this.vrO == -85.0D) || (this.vrP == -1000.0D)))
        {
          String[] arrayOfString = paramBundle.split(",");
          ae.i("MicroMsg.MMPoiMapUI", "last locationInfo ".concat(String.valueOf(paramBundle)));
          if (arrayOfString.length == 2)
          {
            float f1 = (float)(bu.aSB(arrayOfString[0]) * 1.0D / 1000000.0D);
            float f2 = (float)(bu.aSB(arrayOfString[1]) * 1.0D / 1000000.0D);
            this.vpk.getIController().animateTo(f1, f2);
          }
        }
        this.vsu = new View.OnTouchListener()
        {
          private float vsI;
          private short vsJ = 0;
          
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(182068);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            if (c.g(c.this)) {
              c.c(c.this);
            }
            if (!c.o(c.this))
            {
              a.a(true, this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(182068);
              return true;
            }
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              a.a(false, this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(182068);
              return false;
              ae.d("MicroMsg.MMPoiMapUI", "newpoi action down %s.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
              this.vsI = paramAnonymousMotionEvent.getRawY();
              c.b(c.this, false);
              continue;
              ae.d("MicroMsg.MMPoiMapUI", "newpoi action move %s.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
              if (c.p(c.this))
              {
                ae.d("MicroMsg.MMPoiMapUI", "newpoi blocked.");
                c.k(c.this).setSelection(0);
              }
              float f = this.vsI - paramAnonymousMotionEvent.getRawY();
              if (Math.abs(f) < BackwardSupportUtil.b.h(c.this.activity, 20.0F)) {
                this.vsJ = 0;
              }
              while (((c.q(c.this)) && (this.vsJ == 1)) || ((c.r(c.this)) && (this.vsJ == -1)) || ((c.q(c.this)) && (!c.s(c.this).getScroll2Top()) && (this.vsJ == -1)))
              {
                a.a(false, this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(182068);
                return false;
                if (f > 0.0F) {
                  this.vsJ = 1;
                } else {
                  this.vsJ = -1;
                }
              }
              if ((c.o(c.this)) && (this.vsJ != 0))
              {
                ae.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[] { Short.valueOf(this.vsJ) });
                if (this.vsJ == 1)
                {
                  c.c(c.this, true);
                  c.a(c.this, c.c.vsM);
                  a.a(false, this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                  AppMethodBeat.o(182068);
                  return false;
                }
                c.a(c.this, c.c.vsL);
                a.a(false, this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(182068);
                return false;
              }
              a.a(true, this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(182068);
              return true;
              ae.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
              c.b(c.this, false);
            }
          }
        };
        this.vrC.setOnTouchListener(this.vsu);
        this.vrC.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void ZC()
          {
            AppMethodBeat.i(182069);
            c.t(c.this);
            AppMethodBeat.o(182069);
          }
        });
        this.vrC.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182070);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousAdapterView);
            localb.bd(paramAnonymousView);
            localb.mu(paramAnonymousInt);
            localb.rl(paramAnonymousLong);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
            ae.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= c.b(c.this).getCount()))
            {
              ae.i("MicroMsg.MMPoiMapUI", "wrong position");
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182070);
              return;
            }
            paramAnonymousAdapterView = c.b(c.this).Jx(paramAnonymousInt);
            if (paramAnonymousAdapterView.type == 0) {
              c.h(c.this).setSelected(false);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView.bXD);
              c.b(c.this, paramAnonymousAdapterView.bXE);
              c.this.vpk.getIController().animateTo(paramAnonymousAdapterView.bXD, paramAnonymousAdapterView.bXE);
              c.b(c.this).uT = paramAnonymousInt;
              c.b(c.this).notifyDataSetChanged();
              c.a(c.this, false);
              g.c.vtz.vtn = (paramAnonymousInt + 1);
              g.c.vtz.a(g.b.vtw);
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182070);
              return;
              c.h(c.this).setSelected(true);
            }
          }
        });
        this.vrE = new e(this.activity);
        this.vrC.setAdapter(this.vrE);
        this.vrB.setAdapter(this.vrE);
        this.voB = new PoiPoint.a()
        {
          public final void a(PoiPoint.b paramAnonymousb, PoiPoint paramAnonymousPoiPoint)
          {
            AppMethodBeat.i(182071);
            if (PoiPoint.b.voE == paramAnonymousb)
            {
              if (-1 == c.n(c.this).uT) {
                c.d(c.this, true);
              }
              if (c.u(c.this) != null) {
                c.u(c.this).djx();
              }
              c.this.vpk.getIController().animateTo(paramAnonymousPoiPoint.getLat(), paramAnonymousPoiPoint.getLng());
              c.a(c.this, paramAnonymousPoiPoint);
              paramAnonymousPoiPoint.djy();
              c.a(c.this, paramAnonymousPoiPoint.getPosition());
              c.n(c.this).uT = paramAnonymousPoiPoint.getPosition();
              c.n(c.this).notifyDataSetChanged();
              g.c.vtz.vtn = (paramAnonymousPoiPoint.getPosition() + 1);
              g.c.vtz.a(g.b.vtu);
              AppMethodBeat.o(182071);
              return;
            }
            paramAnonymousb = PoiPoint.b.voD;
            AppMethodBeat.o(182071);
          }
        };
        this.vrF = new e(this.activity);
        this.vrF.jjp = true;
        this.vrF.uT = -1;
        this.vrD.setAdapter(this.vrF);
        this.vrD.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void ZC()
          {
            AppMethodBeat.i(182051);
            c.t(c.this);
            AppMethodBeat.o(182051);
          }
        });
        this.vrD.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182052);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousAdapterView);
            localb.bd(paramAnonymousView);
            localb.mu(paramAnonymousInt);
            localb.rl(paramAnonymousLong);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
            if (-1 == c.n(c.this).uT)
            {
              c.d(c.this, true);
              c.a(c.this, c.c.vsL);
            }
            c.n(c.this).uT = paramAnonymousInt;
            c.n(c.this).notifyDataSetChanged();
            if ((paramAnonymousInt >= 0) && (paramAnonymousInt < c.n(c.this).getCount()))
            {
              c.a(c.this, true);
              if (c.u(c.this) != null) {
                c.u(c.this).djx();
              }
              paramAnonymousView = c.n(c.this).Jx(paramAnonymousInt);
              if ((paramAnonymousView.bXD == c.e(c.this)) && (paramAnonymousView.bXE == c.f(c.this))) {
                break label412;
              }
              c.h(c.this).setSelected(false);
              c.this.vpk.getIController().animateTo(paramAnonymousView.bXD, paramAnonymousView.bXE);
              paramAnonymousAdapterView = (PoiPoint)c.v(c.this).get(paramAnonymousView.bXD + paramAnonymousView.bXE);
              if (paramAnonymousAdapterView != null) {
                break label426;
              }
              paramAnonymousAdapterView = new PoiPoint(c.this.activity, c.this.vpk);
              paramAnonymousAdapterView.setPosition(paramAnonymousInt);
              paramAnonymousAdapterView.setOnPointClick(c.this.voB);
              c.v(c.this).put(paramAnonymousView.bXD + paramAnonymousView.bXE, paramAnonymousAdapterView);
              paramAnonymousAdapterView.c(paramAnonymousView.bXD, paramAnonymousView.bXE, true);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView);
              g.c.vtz.vtn = (paramAnonymousInt + 1);
              g.c.vtz.a(g.b.vtt);
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182052);
              return;
              label412:
              c.h(c.this).setSelected(true);
              break;
              label426:
              paramAnonymousAdapterView.djy();
            }
          }
        });
        this.vrD.setOnTouchListener(this.vsu);
        this.vsp = findViewById(2131304573);
        this.vsq = findViewById(2131304575);
        this.vsr = ((EditText)findViewById(2131304572));
        this.vss = ((ImageView)findViewById(2131304577));
        this.vst = findViewById(2131304571);
        this.vsp.setOnClickListener(new c.9(this));
        this.vst.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182059);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            c.a(c.this, c.dki(), c.n(c.this).uT, true);
            c.y(c.this);
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(182059);
          }
        });
        this.vsr.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(182060);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$19", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            if (c.I(c.this)) {
              c.A(c.this);
            }
            for (;;)
            {
              a.a(true, this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$19", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(182060);
              return true;
              if (c.o(c.this)) {
                c.a(c.this, c.c.vsM);
              }
            }
          }
        });
        this.vsr.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(182061);
            if (3 == paramAnonymousInt)
            {
              c.a(c.this, c.c.vsL);
              c.h(c.this, true);
            }
            AppMethodBeat.o(182061);
            return false;
          }
        });
        this.vsr.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(182062);
            ae.d("MicroMsg.MMPoiMapUI", "searchText: %s.", new Object[] { paramAnonymousCharSequence });
            c.a(c.this, paramAnonymousCharSequence.toString());
            c.J(c.this).fCO();
            c.K(c.this).setVisibility(8);
            if (bu.isNullOrNil(c.E(c.this)))
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
        this.vss.setOnClickListener(new c.15(this));
        dkg();
        this.vsn = findViewById(2131304570);
        this.vsn.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182053);
            ae.d("MicroMsg.MMPoiMapUI", "pennqin, collapseBtnLayoutHeight: %d.", new Object[] { Integer.valueOf(c.w(c.this)) });
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
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (c.n(c.this).getCount() == 0) {
              c.y(c.this);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182054);
              return;
              c.a(c.this, c.c.vsL);
            }
          }
        });
        this.vsE = ((InputPanelFrameLayout)findViewById(2131303335));
        this.vsE.setExternalListener(new com.tencent.mm.ui.widget.b.a()
        {
          public final void g(boolean paramAnonymousBoolean, int paramAnonymousInt)
          {
            AppMethodBeat.i(182055);
            ae.d("MicroMsg.MMPoiMapUI", "isKeyboardShow: %s.", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            c.e(c.this, paramAnonymousBoolean);
            AppMethodBeat.o(182055);
          }
        });
        paramBundle = al.ck(this.activity);
        j = Math.max(paramBundle.x, paramBundle.y);
        this.vrT = (j - BackwardSupportUtil.b.h(this.activity, 320.0F));
        this.vrU = ((int)(j * 0.25F + 0.5D));
        this.vrV = ((int)((this.vrT - this.vrU) / 3.0D + 0.5D));
        ae.i("MicroMsg.MMPoiMapUI", "collapsedTopMargin: %d, openedTopMargin: %d, mapViewTopMargin: %d.", new Object[] { Integer.valueOf(this.vrT), Integer.valueOf(this.vrU), Integer.valueOf(this.vrV) });
        this.vsm = new int[] { this.vrT - this.vrU - this.vrV + 24, 24 };
        i = this.activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i <= 0) {
          break;
        }
      }
    }
    for (int i = this.activity.getResources().getDimensionPixelSize(i);; i = 0)
    {
      paramBundle = (FrameLayout.LayoutParams)this.vrM.getLayoutParams();
      paramBundle.height += i * 2;
      this.vrM.setLayoutParams(paramBundle);
      this.vrM.setPadding(0, i, 0, i);
      if (ar.jY(this.activity))
      {
        i = ar.en(this.activity);
        label1279:
        j = j - this.vrU - i;
        ae.i("MicroMsg.MMPoiMapUI", "reset poi view height: %s, navigationBarHeight: %s.", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramBundle = this.vrS.getLayoutParams();
        paramBundle.height = j;
        this.vrS.setLayoutParams(paramBundle);
        paramBundle = (RelativeLayout.LayoutParams)this.vrZ.getLayoutParams();
        paramBundle.height = this.vrT;
        this.vrZ.setLayoutParams(paramBundle);
        b(c.vsL);
        if ((this.type != 0) && (this.type != 8)) {
          break label1512;
        }
        g.c.vtz.setScene(this.activity.getIntent().getIntExtra("type_tag", 0));
      }
      for (;;)
      {
        this.vrB.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
        djX().disableDarkMode();
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
        g.c.vtz.setScene(this.type);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56049);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(457, this);
    AppMethodBeat.o(56049);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56047);
    super.onPause();
    this.vsA = false;
    com.tencent.mm.modelgeo.d.aIh().c(this.fHp);
    MyPoiPoint localMyPoiPoint = this.vrN;
    ae.d("MicroMsg.MyPoiPoint", "disableLocation");
    localMyPoiPoint.vnU.c(localMyPoiPoint.fHp);
    AppMethodBeat.o(56047);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56046);
    super.onResume();
    this.vsA = true;
    com.tencent.mm.modelgeo.d.aIh().b(this.fHp, true);
    this.vrN.djw();
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
      this.vrI = null;
      i locali = (i)paramn;
      if (!locali.vlR.equals(this.vlR))
      {
        ae.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.vlR + " " + locali.vlR);
        AppMethodBeat.o(56054);
        return;
      }
      ae.i("MicroMsg.MMPoiMapUI", "isEnd: " + locali.hkx + " searchId: " + locali.kid + " isInSearch: " + this.vrQ);
      if (this.vsb == -1L)
      {
        long l = System.currentTimeMillis();
        this.vsc = l;
        this.vsb = l;
      }
      for (;;)
      {
        this.vlS = locali.vlS;
        this.vrG.setVisibility(8);
        if (!this.vrQ) {
          break label419;
        }
        if (!bu.isNullOrNil(this.ilP)) {
          break;
        }
        AppMethodBeat.o(56054);
        return;
        this.vsc = System.currentTimeMillis();
      }
      if ((locali.list != null) && (locali.list.size() == 0))
      {
        this.vrL.setVisibility(0);
        this.vrD.fCO();
      }
      ae.d("MicroMsg.MMPoiMapUI", "search is first: %s", new Object[] { Boolean.valueOf(locali.isFirst()) });
      if (locali.isFirst())
      {
        this.vrF.cKB = true;
        this.vrF.vsU.clear();
      }
      this.vrF.a(locali.list, locali.vlQ, locali.hkx, locali.vlR);
      if (!this.vrF.hkx)
      {
        this.vrD.fCN();
        this.vrD.fCP();
      }
      while (this.vsx)
      {
        this.vsx = false;
        dke();
        AppMethodBeat.o(56054);
        return;
        this.vrD.fCO();
        this.vrD.fCQ();
      }
      label419:
      Object localObject2;
      Object localObject1;
      if (this.vrA != null)
      {
        localObject2 = (bgb)locali.rr.hQE.hQJ;
        paramn = this.vrA;
        localObject1 = ((bgb)localObject2).FZl;
        paramString = ((bgb)localObject2).GTj;
        String str = ((bgb)localObject2).Url;
        localObject2 = com.tencent.mm.plugin.image.d.azQ();
        ae.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[] { paramString, str });
        paramn.vog = str;
        paramn.voh = "";
        if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil(paramString))) {
          break label629;
        }
        paramn.setVisibility(8);
        paramn.fTl.setVisibility(8);
        paramn.voi.setVisibility(8);
      }
      for (;;)
      {
        oc(true);
        this.vrE.a(locali.list, locali.vlQ, locali.hkx, locali.vlR);
        this.vrE.uT = 0;
        this.vrE.notifyDataSetChanged();
        if (this.vrE.hkx) {
          break;
        }
        this.vrC.fCN();
        this.vrC.fCP();
        AppMethodBeat.o(56054);
        return;
        label629:
        paramn.setVisibility(0);
        paramn.fTl.setVisibility(0);
        paramn.voi.setVisibility(0);
        paramn.fTl.setText((CharSequence)localObject1);
        localObject1 = paramn.voi;
        ((SimpleImageView)localObject1).imagePath = ((String)localObject2);
        ((SimpleImageView)localObject1).url = paramString;
        ((SimpleImageView)localObject1).targetWidth = 0;
        ((SimpleImageView)localObject1).targetHeight = 0;
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
            if (((SimpleImageView)localObject1).targetWidth > 0)
            {
              paramString = paramn;
              if (((SimpleImageView)localObject1).targetHeight > 0) {
                paramString = com.tencent.mm.sdk.platformtools.h.a(paramn, ((SimpleImageView)localObject1).targetWidth, ((SimpleImageView)localObject1).targetHeight, true, false);
              }
            }
            ((SimpleImageView)localObject1).setImageBitmap(paramString);
          }
          else
          {
            com.tencent.mm.sdk.g.b.c(new SimpleImageView.a(paramString, ((SimpleImageView)localObject1).handler), "SimpleImageView_download");
          }
        }
        else if (!o.fB(paramString))
        {
          ((SimpleImageView)localObject1).setVisibility(8);
        }
        else
        {
          if ((((SimpleImageView)localObject1).targetWidth <= 0) || (((SimpleImageView)localObject1).targetHeight <= 0)) {}
          for (paramString = com.tencent.mm.sdk.platformtools.h.aRC(paramString);; paramString = com.tencent.mm.sdk.platformtools.h.d(paramString, ((SimpleImageView)localObject1).targetWidth, ((SimpleImageView)localObject1).targetHeight, true))
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
      this.vrC.fCO();
      this.vrC.fCQ();
    }
    AppMethodBeat.o(56054);
  }
  
  final class a
    extends TranslateAnimation
  {
    private List<View> vsK;
    
    public a(float paramFloat)
    {
      super(0.0F, 0.0F, paramFloat);
      AppMethodBeat.i(56025);
      this.vsK = new ArrayList();
      AppMethodBeat.o(56025);
    }
    
    public final a dkj()
    {
      AppMethodBeat.i(56026);
      setDuration(200L);
      AppMethodBeat.o(56026);
      return this;
    }
    
    public final a dkk()
    {
      AppMethodBeat.i(56027);
      setFillEnabled(true);
      setFillAfter(true);
      AppMethodBeat.o(56027);
      return this;
    }
    
    public final a ep(View paramView)
    {
      AppMethodBeat.i(56028);
      this.vsK.add(paramView);
      AppMethodBeat.o(56028);
      return this;
    }
    
    public final void startAnimation()
    {
      AppMethodBeat.i(56029);
      int i = 0;
      while (i < this.vsK.size())
      {
        ((View)this.vsK.get(i)).startAnimation(this);
        i += 1;
      }
      AppMethodBeat.o(56029);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(f paramf);
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(56032);
      vsL = new c("COLLAPSED", 0);
      vsM = new c("OPENED", 1);
      vsN = new c[] { vsL, vsM };
      AppMethodBeat.o(56032);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c
 * JD-Core Version:    0.7.0.1
 */