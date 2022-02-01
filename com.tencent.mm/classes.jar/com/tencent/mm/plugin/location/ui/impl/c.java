package com.tencent.mm.plugin.location.ui.impl;

import android.animation.ValueAnimator;
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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.ui.MyPoiPoint;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.PoiPoint;
import com.tencent.mm.plugin.location.ui.PoiPoint.a;
import com.tencent.mm.plugin.location.ui.PoiPoint.b;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.SimpleImageView.a;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.base.h;
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
  implements com.tencent.mm.al.f
{
  private static int vfY = 11;
  private static int vfZ = 12;
  private static int vga = 13;
  private static int vgb = 14;
  private b.a fFl;
  private String iiW;
  private double lat;
  private double lng;
  private View uCR;
  private String uZG;
  private int uZH;
  PoiPoint.a vcq;
  private ImageButton vfA;
  private com.tencent.mm.plugin.location.model.i vfB;
  private View vfC;
  private View vfD;
  private TextView vfE;
  private LinearLayout vfF;
  private MyPoiPoint vfG;
  private double vfH;
  private double vfI;
  private boolean vfJ;
  private int vfK;
  private RelativeLayout vfL;
  private int vfM;
  private int vfN;
  private int vfO;
  private boolean vfP;
  private boolean vfQ;
  private boolean vfR;
  private FrameLayout vfS;
  private int vfT;
  private long vfU;
  private long vfV;
  private long vfW;
  private int vfX;
  private FrameLayout vfk;
  private PoiHeaderView vft;
  private PickPoi vfu;
  private MMLoadMoreListView vfv;
  private MMLoadMoreListView vfw;
  private e vfx;
  private e vfy;
  private View vfz;
  private boolean vgc;
  private boolean vgd;
  private int[] vge;
  private int[] vgf;
  private View vgg;
  private int vgh;
  private View vgi;
  private View vgj;
  private EditText vgk;
  private ImageView vgl;
  private View vgm;
  private View.OnTouchListener vgn;
  private PoiPoint vgo;
  private Map<String, PoiPoint> vgp;
  private boolean vgq;
  private f vgr;
  private boolean vgs;
  private boolean vgt;
  private boolean vgu;
  private boolean vgv;
  private boolean vgw;
  private InputPanelFrameLayout vgx;
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56033);
    this.vfB = null;
    this.lat = -85.0D;
    this.lng = -1000.0D;
    this.vfH = -85.0D;
    this.vfI = -1000.0D;
    this.uZG = "";
    this.vfJ = false;
    this.iiW = "";
    this.vfK = 0;
    this.vfP = true;
    this.vfQ = false;
    this.vfR = false;
    this.vfT = 0;
    this.vfU = -1L;
    this.vfV = -1L;
    this.vfW = -1L;
    this.vfX = -1;
    this.vgc = false;
    this.uZH = 1;
    this.vge = new int[] { 24, 24 };
    this.vgp = new HashMap();
    this.vgr = new f();
    this.vgs = false;
    this.fFl = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(182065);
        if (!paramAnonymousBoolean)
        {
          if ((!c.Q(c.this)) && (!com.tencent.mm.modelgeo.d.aHR()))
          {
            c.R(c.this);
            h.a(c.this.activity, c.this.activity.getString(2131760082), c.this.activity.getString(2131755906), c.this.activity.getString(2131760598), c.this.activity.getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(182064);
                com.tencent.mm.modelgeo.d.cB(c.this.activity);
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
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ItO, str);
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
          c.this.vcZ.getIController().animateTo(c.e(c.this), c.f(c.this), com.tencent.mm.plugin.location.ui.d.dgu());
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
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ItO, str);
            c.c(c.this, paramAnonymousFloat2);
            c.d(c.this, paramAnonymousFloat1);
          }
        }
      }
    };
    this.vgt = false;
    this.vgu = false;
    this.vgv = false;
    this.vgw = false;
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
    if (((c.c.vgF == paramc) && (this.vfR)) || ((c.c.vgE == paramc) && (!this.vfR)))
    {
      AppMethodBeat.o(56037);
      return;
    }
    if (this.vgg.getVisibility() != 0) {
      this.vgg.setVisibility(0);
    }
    this.vfP = false;
    int i;
    a locala2;
    a locala1;
    if (c.c.vgF == paramc)
    {
      ad.d("MicroMsg.MMPoiMapUI", "pennqin play open animation, getListTopMargin(): %d, openedTopMargin: %d.", new Object[] { Integer.valueOf(dhg()), Integer.valueOf(this.vfN) });
      i = dhg() - this.vfN;
      ad.d("MicroMsg.MMPoiMapUI", "pennqin play open animation (getListTopMargin() - openedTopMargin): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(-i);
      locala1 = new a(-this.vfO);
    }
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.vgh });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.vgh, 0 }))
    {
      paramc = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(182057);
          c.f(c.this, true);
          if (c.c.vgF == paramc)
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
            if ((!c.n(c.this).ppR.equals(c.E(c.this))) || (!c.n(c.this).cJS)) {
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
          ad.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          c.f(c.this, false);
          c.b(c.this, true);
          AppMethodBeat.o(182056);
        }
      };
      localValueAnimator.addUpdateListener(new c.8(this));
      locala2 = locala2.dhk().dhl();
      locala2.setAnimationListener(paramc);
      locala2.ep(this.vfL).ep(this.vfA).startAnimation();
      locala1.dhk().dhl().ep(this.vfS).startAnimation();
      localValueAnimator.setDuration(200L).start();
      AppMethodBeat.o(56037);
      return;
      ad.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation, getListTopMargin(): %d, collapsedTopMargin: %d.", new Object[] { Integer.valueOf(dhg()), Integer.valueOf(this.vfM) });
      i = this.vfM - dhg();
      ad.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation (collapsedTopMargin - getListTopMargin()): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(i);
      locala1 = new a(this.vfO);
    }
  }
  
  private void b(c.c paramc)
  {
    AppMethodBeat.i(56055);
    if (c.c.vgE == paramc)
    {
      ((FrameLayout.LayoutParams)this.vfL.getLayoutParams()).topMargin = this.vfM;
      ((RelativeLayout.LayoutParams)this.vfS.getLayoutParams()).topMargin = 0;
      ((FrameLayout.LayoutParams)this.vfA.getLayoutParams()).topMargin = (this.vfM - aq.fromDPToPix(this.activity, 92));
      this.vcZ.setLogoMargin(this.vge);
    }
    for (;;)
    {
      this.vfL.requestLayout();
      this.vfA.requestLayout();
      this.vfS.requestLayout();
      AppMethodBeat.o(56055);
      return;
      if (c.c.vgF == paramc)
      {
        ((FrameLayout.LayoutParams)this.vfL.getLayoutParams()).topMargin = this.vfN;
        ((RelativeLayout.LayoutParams)this.vfS.getLayoutParams()).topMargin = (-this.vfO);
        ((FrameLayout.LayoutParams)this.vfA.getLayoutParams()).topMargin = (this.vfN - aq.fromDPToPix(this.activity, 92));
        this.vcZ.setLogoMargin(this.vgf);
      }
    }
  }
  
  private boolean dhb()
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
  
  private void dhc()
  {
    AppMethodBeat.i(56039);
    this.vfJ = false;
    this.vfk.setVisibility(0);
    a(c.c.vgE);
    dhh();
    this.iiW = "";
    this.vfw.setVisibility(8);
    this.vfx.notifyDataSetChanged();
    this.vfv.setVisibility(0);
    this.vfz.setVisibility(8);
    this.vfE.setVisibility(8);
    dhe();
    nX(true);
    this.vfA.setSelected(this.vgs);
    this.vcZ.getIController().animateTo(this.lat, this.lng);
    AppMethodBeat.o(56039);
  }
  
  private void dhd()
  {
    AppMethodBeat.i(56043);
    if (this.vfu.vgJ)
    {
      f localf = this.vfu.getPoi();
      e locale = this.vfx;
      if (locale.vgN.size() >= 0)
      {
        locale.vgN.add(0, localf);
        locale.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(56043);
  }
  
  private void dhe()
  {
    AppMethodBeat.i(56050);
    Iterator localIterator = this.vgp.values().iterator();
    while (localIterator.hasNext()) {
      ((PoiPoint)localIterator.next()).remove();
    }
    this.vgp.clear();
    this.vgo = null;
    AppMethodBeat.o(56050);
  }
  
  private void dhf()
  {
    AppMethodBeat.i(56051);
    Object localObject = new ArrayList(5);
    int i = 0;
    while ((i < 5) && (i < this.vfy.getCount()))
    {
      ((List)localObject).add(this.vfy.IY(i));
      i += 1;
    }
    localObject = ep((List)localObject);
    dhe();
    i = 0;
    while (i < ((List)localObject).size())
    {
      f localf = this.vfy.IY(i);
      PoiPoint localPoiPoint = new PoiPoint(this.activity, this.vcZ);
      localPoiPoint.setPosition(i);
      localPoiPoint.setOnPointClick(this.vcq);
      this.vgp.put(localf.bXD + localf.bXE, localPoiPoint);
      localPoiPoint.c(localf.bXD, localf.bXE, false);
      i += 1;
    }
    eq((List)localObject);
    AppMethodBeat.o(56051);
  }
  
  private int dhg()
  {
    AppMethodBeat.i(56056);
    int i = ((ViewGroup.MarginLayoutParams)this.vfL.getLayoutParams()).topMargin;
    AppMethodBeat.o(56056);
    return i;
  }
  
  private void dhh()
  {
    AppMethodBeat.i(56057);
    if (this.vfJ)
    {
      this.vgi.setVisibility(8);
      this.vgj.setVisibility(0);
      this.vgm.setVisibility(0);
      AppMethodBeat.o(56057);
      return;
    }
    this.vgi.setVisibility(0);
    this.vgj.setVisibility(8);
    this.vgm.setVisibility(8);
    AppMethodBeat.o(56057);
  }
  
  private void dhi()
  {
    AppMethodBeat.i(56058);
    if (!this.vgu)
    {
      this.vgu = true;
      this.vgk.requestFocus();
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
  
  private static List<f> ep(List<f> paramList)
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
  
  private void eq(List<f> paramList)
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
      this.vcZ.getIController().animateTo(((f)paramList.get(0)).bXD, ((f)paramList.get(0)).bXE);
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
    this.vcZ.animateCamera(CameraUpdateFactory.newLatLngBounds(paramList, 250));
    AppMethodBeat.o(56053);
  }
  
  private void nX(boolean paramBoolean)
  {
    AppMethodBeat.i(56048);
    ad.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.uCR.setEnabled(paramBoolean);
    this.vfD.setEnabled(paramBoolean);
    AppMethodBeat.o(56048);
  }
  
  private void nd(boolean paramBoolean)
  {
    AppMethodBeat.i(56044);
    ad.d("MicroMsg.MMPoiMapUI", "stack: %s", new Object[] { bt.flS() });
    this.uZG = a(this.lat, this.iiW);
    if (this.uZG.equals(this.vfx.key))
    {
      ad.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[] { this.uZG });
      AppMethodBeat.o(56044);
      return;
    }
    byte[] arrayOfByte = null;
    int i = 1;
    this.vfz.setVisibility(0);
    label185:
    double d1;
    double d2;
    if (this.vfJ) {
      if ((this.uZH > 0) && (paramBoolean))
      {
        this.vfw.fyM();
        this.vfy.dhm();
        this.vfy.aoL(this.uZG);
        this.vfy.ppR = this.iiW;
        this.vfy.cJS = false;
        arrayOfByte = this.vfy.buffer;
        if (i == 0) {
          break label436;
        }
        if (this.vfK != 0) {
          break label424;
        }
        i = 0;
        d1 = this.lat;
        d2 = this.lng;
        if (!this.vfJ) {
          break label430;
        }
      }
    }
    label424:
    label430:
    for (int j = 0;; j = 1)
    {
      this.vfB = new com.tencent.mm.plugin.location.model.i(arrayOfByte, d1, d2, i, j, this.vfI, this.vfH, this.uZG, this.iiW, paramBoolean);
      com.tencent.mm.kernel.g.aiU().a(this.vfB, 0);
      this.vfT += 1;
      if (this.vfW == -1L) {
        this.vfW = System.currentTimeMillis();
      }
      AppMethodBeat.o(56044);
      return;
      if (!paramBoolean)
      {
        this.vfw.fyM();
        this.vfy.clean();
        this.vfy.aoL(this.uZG);
        this.vfy.ppR = this.iiW;
        this.vfy.cJS = false;
        arrayOfByte = this.vfy.buffer;
        this.vfy.notifyDataSetChanged();
        break;
      }
      i = 0;
      this.vfy.cJS = false;
      break;
      this.vfv.fyM();
      this.vfx.clean();
      this.vfx.aoL(this.uZG);
      this.vfx.notifyDataSetChanged();
      arrayOfByte = this.vfx.buffer;
      nX(false);
      dhd();
      break;
      i = 1;
      break label185;
    }
    label436:
    ad.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", new Object[] { Integer.valueOf(this.uZH) });
    AppMethodBeat.o(56044);
  }
  
  private void t(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(56045);
    String str3;
    String str1;
    String str2;
    if ((this.vfH == -85.0D) || (this.vfI == -1000.0D))
    {
      str3 = "null/null";
      str1 = "";
      if (paramBoolean) {
        break label563;
      }
      if ((paramInt2 < 0) || (paramInt2 >= this.vfx.getCount())) {
        break label614;
      }
      str1 = this.vfx.IY(paramInt2).vhe;
      str2 = this.vfx.IY(paramInt2).vgU;
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
          if (this.vfx.getCount() > 1)
          {
            ad.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str4 = this.vfx.IY(1).vhe;
          }
        }
      }
      if ((this.vfx.getCount() > 0) && (!paramBoolean)) {
        ad.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", new Object[] { Integer.valueOf(paramInt2) });
      }
      for (str1 = this.vfx.IY(0).dwW;; str1 = "")
      {
        int i = paramInt2;
        if (paramInt2 == 0)
        {
          i = paramInt2;
          if (!paramBoolean)
          {
            i = paramInt2;
            if (this.vfx.getCount() > 0)
            {
              int j = this.vfx.IY(0).vhf;
              i = paramInt2;
              if (j >= 0)
              {
                ad.d("MicroMsg.MMPoiMapUI", "change to search index: %s", new Object[] { Integer.valueOf(j) });
                i = j;
              }
            }
          }
        }
        ad.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.vfW), Long.valueOf(this.vfV), Long.valueOf(this.vfU), Integer.valueOf(this.vfT), str3, Integer.valueOf(this.vfX), str4, str1 });
        com.tencent.mm.plugin.report.service.g.yhR.f(11135, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.vfW), Long.valueOf(this.vfV), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.vfU), Integer.valueOf(this.vfT), str3, str2, Integer.valueOf(this.vfX), str4, com.tencent.mm.compatible.deviceinfo.q.cH(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
        AppMethodBeat.o(56045);
        return;
        str3 = String.format("%f/%f", new Object[] { Double.valueOf(this.vfH), Double.valueOf(this.vfI) });
        break;
        label563:
        if ((paramInt2 < 0) || (paramInt2 >= this.vfy.getCount())) {
          break label614;
        }
        str1 = this.vfy.IY(paramInt2).vhe;
        str2 = this.vfy.IY(paramInt2).vgU;
        break label82;
      }
      label614:
      str2 = "";
    }
  }
  
  public final com.tencent.mm.plugin.k.d dgY()
  {
    AppMethodBeat.i(56036);
    com.tencent.mm.plugin.k.d locald = (com.tencent.mm.plugin.k.d)this.activity.findViewById(2131300334);
    AppMethodBeat.o(56036);
    return locald;
  }
  
  public final void dgZ()
  {
    AppMethodBeat.i(56040);
    a(c.c.vgE);
    AppMethodBeat.o(56040);
  }
  
  public final void dha()
  {
    AppMethodBeat.i(56041);
    if (this.vfA.isSelected()) {
      this.vfA.setSelected(false);
    }
    if (!this.vfJ)
    {
      this.vfu.play();
      this.lat = (this.vcZ.getMapCenterX() / 1000000.0D);
      this.lng = (this.vcZ.getMapCenterY() / 1000000.0D);
      this.vfu.l(this.lat, this.lng);
      this.vfA.setSelected(false);
      if (this.vfR) {
        a(c.c.vgE);
      }
      nd(false);
      this.vgc = false;
      g.c.vhs.vhg = 0;
      g.c.vhs.a(g.b.vho);
    }
    AppMethodBeat.o(56041);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(56038);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent, back.");
      g.c.vhs.a(g.a.vhj);
      if (this.vfJ)
      {
        dhc();
        t(vgb, this.vfy.uT, true);
        AppMethodBeat.o(56038);
        return false;
      }
      t(vfZ, this.vfx.uT, false);
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
    com.tencent.mm.kernel.g.aiU().a(457, this);
    this.vfX = ((int)(System.currentTimeMillis() / 1000L));
    this.vcZ.setCanRotate(false);
    label212:
    int j;
    if (al.isDarkMode())
    {
      dgY().enableDarkMode();
      this.vfF = ((LinearLayout)findViewById(2131300707));
      ((TextView)findViewById(2131297583)).setText(2131755691);
      this.vfC = findViewById(2131305909);
      this.vfC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56013);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          g.c.vhs.a(g.a.vhj);
          c.a(c.this, c.vfZ, c.b(c.this).uT, false);
          c.c(c.this);
          c.this.activity.finish();
          a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(56013);
        }
      });
      this.vfC.setVisibility(0);
      this.uCR = findViewById(2131305910);
      this.vfD = findViewById(2131297599);
      switch (this.type)
      {
      default: 
        this.uCR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(56018);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            g.c.vhs.a(g.a.vhi);
            c.d(c.this);
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(56018);
          }
        });
        this.uCR.setVisibility(0);
        nX(false);
        this.vfL = ((RelativeLayout)findViewById(2131301531));
        this.vfv = ((MMLoadMoreListView)this.activity.findViewById(2131303334));
        this.vfw = ((MMLoadMoreListView)this.activity.findViewById(2131304431));
        this.vfz = findViewById(2131301491);
        this.vfE = ((TextView)findViewById(2131304416));
        this.vft = ((PoiHeaderView)findViewById(2131303327));
        this.vfS = ((FrameLayout)findViewById(2131302156));
        this.vfA = ((ImageButton)findViewById(2131301520));
        this.vfA.setSelected(true);
        this.vfA.setContentDescription(this.activity.getString(2131760710));
        this.vfA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182066);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", new Object[] { Double.valueOf(c.e(c.this)), Double.valueOf(c.f(c.this)) });
            if ((c.e(c.this) == -85.0D) || (c.f(c.this) == -1000.0D))
            {
              ad.i("MicroMsg.MMPoiMapUI", "invalid lat lng");
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182066);
              return;
            }
            if (c.g(c.this))
            {
              c.this.vcZ.getIController().animateTo(c.e(c.this), c.f(c.this));
              c.h(c.this).setSelected(true);
              c.a(c.this, c.c.vgE);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182066);
              return;
              c.this.vcZ.getIController().animateTo(c.e(c.this), c.f(c.this));
              c.a(c.this, c.e(c.this));
              c.b(c.this, c.f(c.this));
              c.a(c.this).l(c.i(c.this), c.j(c.this));
              c.h(c.this).setSelected(true);
              c.a(c.this, false);
              c.b(c.this).uT = 0;
              c.k(c.this).setSelection(0);
              g.c.vhs.vhg = 0;
              g.c.vhs.a(g.b.vhq);
              c.l(c.this);
            }
          }
        });
        this.vcZ.setBuiltInZoomControls(false);
        this.vfk = ((FrameLayout)findViewById(2131298786));
        this.vfG = new MyPoiPoint(this.activity, this.vcZ);
        this.vfu = new PickPoi(this.activity);
        this.vfu.setOnCurPoiGet(new b()
        {
          public final void a(f paramAnonymousf)
          {
            AppMethodBeat.i(182067);
            c.a(c.this).setOnCurPoiGet(null);
            if (paramAnonymousf != null)
            {
              c.m(c.this).c(paramAnonymousf.vhd);
              if (c.b(c.this) != null)
              {
                c.b(c.this).hH(c.m(c.this).vgX, c.m(c.this).vgY);
                c.n(c.this).hH(c.m(c.this).vgX, c.m(c.this).vgY);
              }
            }
            AppMethodBeat.o(182067);
          }
        });
        this.vfk.addView(this.vfu);
        paramBundle = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ItO, "");
        if ((!bt.isNullOrNil(paramBundle)) && ((this.vfH == -85.0D) || (this.vfI == -1000.0D)))
        {
          String[] arrayOfString = paramBundle.split(",");
          ad.i("MicroMsg.MMPoiMapUI", "last locationInfo ".concat(String.valueOf(paramBundle)));
          if (arrayOfString.length == 2)
          {
            float f1 = (float)(bt.aRe(arrayOfString[0]) * 1.0D / 1000000.0D);
            float f2 = (float)(bt.aRe(arrayOfString[1]) * 1.0D / 1000000.0D);
            this.vcZ.getIController().animateTo(f1, f2);
          }
        }
        this.vgn = new View.OnTouchListener()
        {
          private float vgB;
          private short vgC = 0;
          
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(182068);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
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
              ad.d("MicroMsg.MMPoiMapUI", "newpoi action down %s.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
              this.vgB = paramAnonymousMotionEvent.getRawY();
              c.b(c.this, false);
              continue;
              ad.d("MicroMsg.MMPoiMapUI", "newpoi action move %s.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
              if (c.p(c.this))
              {
                ad.d("MicroMsg.MMPoiMapUI", "newpoi blocked.");
                c.k(c.this).setSelection(0);
              }
              float f = this.vgB - paramAnonymousMotionEvent.getRawY();
              if (Math.abs(f) < BackwardSupportUtil.b.g(c.this.activity, 20.0F)) {
                this.vgC = 0;
              }
              while (((c.q(c.this)) && (this.vgC == 1)) || ((c.r(c.this)) && (this.vgC == -1)) || ((c.q(c.this)) && (!c.s(c.this).getScroll2Top()) && (this.vgC == -1)))
              {
                a.a(false, this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(182068);
                return false;
                if (f > 0.0F) {
                  this.vgC = 1;
                } else {
                  this.vgC = -1;
                }
              }
              if ((c.o(c.this)) && (this.vgC != 0))
              {
                ad.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[] { Short.valueOf(this.vgC) });
                if (this.vgC == 1)
                {
                  c.c(c.this, true);
                  c.a(c.this, c.c.vgF);
                  a.a(false, this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                  AppMethodBeat.o(182068);
                  return false;
                }
                c.a(c.this, c.c.vgE);
                a.a(false, this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(182068);
                return false;
              }
              a.a(true, this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(182068);
              return true;
              ad.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
              c.b(c.this, false);
            }
          }
        };
        this.vfv.setOnTouchListener(this.vgn);
        this.vfv.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void Zt()
          {
            AppMethodBeat.i(182069);
            c.t(c.this);
            AppMethodBeat.o(182069);
          }
        });
        this.vfv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182070);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousAdapterView);
            localb.bd(paramAnonymousView);
            localb.mr(paramAnonymousInt);
            localb.qY(paramAnonymousLong);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
            ad.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= c.b(c.this).getCount()))
            {
              ad.i("MicroMsg.MMPoiMapUI", "wrong position");
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182070);
              return;
            }
            paramAnonymousAdapterView = c.b(c.this).IY(paramAnonymousInt);
            if (paramAnonymousAdapterView.type == 0) {
              c.h(c.this).setSelected(false);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView.bXD);
              c.b(c.this, paramAnonymousAdapterView.bXE);
              c.this.vcZ.getIController().animateTo(paramAnonymousAdapterView.bXD, paramAnonymousAdapterView.bXE);
              c.b(c.this).uT = paramAnonymousInt;
              c.b(c.this).notifyDataSetChanged();
              c.a(c.this, false);
              g.c.vhs.vhg = (paramAnonymousInt + 1);
              g.c.vhs.a(g.b.vhp);
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182070);
              return;
              c.h(c.this).setSelected(true);
            }
          }
        });
        this.vfx = new e(this.activity);
        this.vfv.setAdapter(this.vfx);
        this.vfu.setAdapter(this.vfx);
        this.vcq = new PoiPoint.a()
        {
          public final void a(PoiPoint.b paramAnonymousb, PoiPoint paramAnonymousPoiPoint)
          {
            AppMethodBeat.i(182071);
            if (PoiPoint.b.vct == paramAnonymousb)
            {
              if (-1 == c.n(c.this).uT) {
                c.d(c.this, true);
              }
              if (c.u(c.this) != null) {
                c.u(c.this).dgy();
              }
              c.this.vcZ.getIController().animateTo(paramAnonymousPoiPoint.getLat(), paramAnonymousPoiPoint.getLng());
              c.a(c.this, paramAnonymousPoiPoint);
              paramAnonymousPoiPoint.dgz();
              c.a(c.this, paramAnonymousPoiPoint.getPosition());
              c.n(c.this).uT = paramAnonymousPoiPoint.getPosition();
              c.n(c.this).notifyDataSetChanged();
              g.c.vhs.vhg = (paramAnonymousPoiPoint.getPosition() + 1);
              g.c.vhs.a(g.b.vhn);
              AppMethodBeat.o(182071);
              return;
            }
            paramAnonymousb = PoiPoint.b.vcs;
            AppMethodBeat.o(182071);
          }
        };
        this.vfy = new e(this.activity);
        this.vfy.jgw = true;
        this.vfy.uT = -1;
        this.vfw.setAdapter(this.vfy);
        this.vfw.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void Zt()
          {
            AppMethodBeat.i(182051);
            c.t(c.this);
            AppMethodBeat.o(182051);
          }
        });
        this.vfw.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182052);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousAdapterView);
            localb.bd(paramAnonymousView);
            localb.mr(paramAnonymousInt);
            localb.qY(paramAnonymousLong);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
            if (-1 == c.n(c.this).uT)
            {
              c.d(c.this, true);
              c.a(c.this, c.c.vgE);
            }
            c.n(c.this).uT = paramAnonymousInt;
            c.n(c.this).notifyDataSetChanged();
            if ((paramAnonymousInt >= 0) && (paramAnonymousInt < c.n(c.this).getCount()))
            {
              c.a(c.this, true);
              if (c.u(c.this) != null) {
                c.u(c.this).dgy();
              }
              paramAnonymousView = c.n(c.this).IY(paramAnonymousInt);
              if ((paramAnonymousView.bXD == c.e(c.this)) && (paramAnonymousView.bXE == c.f(c.this))) {
                break label412;
              }
              c.h(c.this).setSelected(false);
              c.this.vcZ.getIController().animateTo(paramAnonymousView.bXD, paramAnonymousView.bXE);
              paramAnonymousAdapterView = (PoiPoint)c.v(c.this).get(paramAnonymousView.bXD + paramAnonymousView.bXE);
              if (paramAnonymousAdapterView != null) {
                break label426;
              }
              paramAnonymousAdapterView = new PoiPoint(c.this.activity, c.this.vcZ);
              paramAnonymousAdapterView.setPosition(paramAnonymousInt);
              paramAnonymousAdapterView.setOnPointClick(c.this.vcq);
              c.v(c.this).put(paramAnonymousView.bXD + paramAnonymousView.bXE, paramAnonymousAdapterView);
              paramAnonymousAdapterView.c(paramAnonymousView.bXD, paramAnonymousView.bXE, true);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView);
              g.c.vhs.vhg = (paramAnonymousInt + 1);
              g.c.vhs.a(g.b.vhm);
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182052);
              return;
              label412:
              c.h(c.this).setSelected(true);
              break;
              label426:
              paramAnonymousAdapterView.dgz();
            }
          }
        });
        this.vfw.setOnTouchListener(this.vgn);
        this.vgi = findViewById(2131304573);
        this.vgj = findViewById(2131304575);
        this.vgk = ((EditText)findViewById(2131304572));
        this.vgl = ((ImageView)findViewById(2131304577));
        this.vgm = findViewById(2131304571);
        this.vgi.setOnClickListener(new c.9(this));
        this.vgm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182059);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            c.a(c.this, c.dhj(), c.n(c.this).uT, true);
            c.y(c.this);
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(182059);
          }
        });
        this.vgk.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(182060);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$19", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            if (c.I(c.this)) {
              c.A(c.this);
            }
            for (;;)
            {
              a.a(true, this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$19", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(182060);
              return true;
              if (c.o(c.this)) {
                c.a(c.this, c.c.vgF);
              }
            }
          }
        });
        this.vgk.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(182061);
            if (3 == paramAnonymousInt)
            {
              c.a(c.this, c.c.vgE);
              c.h(c.this, true);
            }
            AppMethodBeat.o(182061);
            return false;
          }
        });
        this.vgk.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(182062);
            ad.d("MicroMsg.MMPoiMapUI", "searchText: %s.", new Object[] { paramAnonymousCharSequence });
            c.a(c.this, paramAnonymousCharSequence.toString());
            c.J(c.this).fyM();
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
        this.vgl.setOnClickListener(new c.15(this));
        dhh();
        this.vgg = findViewById(2131304570);
        this.vgg.post(new c.4(this));
        findViewById(2131304569).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182054);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (c.n(c.this).getCount() == 0) {
              c.y(c.this);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182054);
              return;
              c.a(c.this, c.c.vgE);
            }
          }
        });
        this.vgx = ((InputPanelFrameLayout)findViewById(2131303335));
        this.vgx.setExternalListener(new c.6(this));
        paramBundle = al.ci(this.activity);
        j = Math.max(paramBundle.x, paramBundle.y);
        this.vfM = (j - BackwardSupportUtil.b.g(this.activity, 320.0F));
        this.vfN = ((int)(j * 0.25F + 0.5D));
        this.vfO = ((int)((this.vfM - this.vfN) / 3.0D + 0.5D));
        ad.i("MicroMsg.MMPoiMapUI", "collapsedTopMargin: %d, openedTopMargin: %d, mapViewTopMargin: %d.", new Object[] { Integer.valueOf(this.vfM), Integer.valueOf(this.vfN), Integer.valueOf(this.vfO) });
        this.vgf = new int[] { this.vfM - this.vfN - this.vfO + 24, 24 };
        i = this.activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i <= 0) {
          break;
        }
      }
    }
    for (int i = this.activity.getResources().getDimensionPixelSize(i);; i = 0)
    {
      paramBundle = (FrameLayout.LayoutParams)this.vfF.getLayoutParams();
      paramBundle.height += i * 2;
      this.vfF.setLayoutParams(paramBundle);
      this.vfF.setPadding(0, i, 0, i);
      if (ar.jR(this.activity))
      {
        i = ar.ej(this.activity);
        label1279:
        j = j - this.vfN - i;
        ad.i("MicroMsg.MMPoiMapUI", "reset poi view height: %s, navigationBarHeight: %s.", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramBundle = this.vfL.getLayoutParams();
        paramBundle.height = j;
        this.vfL.setLayoutParams(paramBundle);
        paramBundle = (RelativeLayout.LayoutParams)this.vfS.getLayoutParams();
        paramBundle.height = this.vfM;
        this.vfS.setLayoutParams(paramBundle);
        b(c.c.vgE);
        if ((this.type != 0) && (this.type != 8)) {
          break label1512;
        }
        g.c.vhs.setScene(this.activity.getIntent().getIntExtra("type_tag", 0));
      }
      for (;;)
      {
        this.vfu.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
        dgY().disableDarkMode();
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
        g.c.vhs.setScene(this.type);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56049);
    super.onDestroy();
    com.tencent.mm.kernel.g.aiU().b(457, this);
    AppMethodBeat.o(56049);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56047);
    super.onPause();
    this.vgt = false;
    com.tencent.mm.modelgeo.d.aHQ().c(this.fFl);
    MyPoiPoint localMyPoiPoint = this.vfG;
    ad.d("MicroMsg.MyPoiPoint", "disableLocation");
    localMyPoiPoint.vbJ.c(localMyPoiPoint.fFl);
    AppMethodBeat.o(56047);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56046);
    super.onResume();
    this.vgt = true;
    com.tencent.mm.modelgeo.d.aHQ().b(this.fFl, true);
    this.vfG.dgx();
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
      this.vfB = null;
      com.tencent.mm.plugin.location.model.i locali = (com.tencent.mm.plugin.location.model.i)paramn;
      if (!locali.uZG.equals(this.uZG))
      {
        ad.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.uZG + " " + locali.uZG);
        AppMethodBeat.o(56054);
        return;
      }
      ad.i("MicroMsg.MMPoiMapUI", "isEnd: " + locali.hhJ + " searchId: " + locali.keN + " isInSearch: " + this.vfJ);
      if (this.vfU == -1L)
      {
        long l = System.currentTimeMillis();
        this.vfV = l;
        this.vfU = l;
      }
      for (;;)
      {
        this.uZH = locali.uZH;
        this.vfz.setVisibility(8);
        if (!this.vfJ) {
          break label419;
        }
        if (!bt.isNullOrNil(this.iiW)) {
          break;
        }
        AppMethodBeat.o(56054);
        return;
        this.vfV = System.currentTimeMillis();
      }
      if ((locali.list != null) && (locali.list.size() == 0))
      {
        this.vfE.setVisibility(0);
        this.vfw.fyM();
      }
      ad.d("MicroMsg.MMPoiMapUI", "search is first: %s", new Object[] { Boolean.valueOf(locali.isFirst()) });
      if (locali.isFirst())
      {
        this.vfy.cJS = true;
        this.vfy.vgN.clear();
      }
      this.vfy.a(locali.list, locali.uZF, locali.hhJ, locali.uZG);
      if (!this.vfy.hhJ)
      {
        this.vfw.fyL();
        this.vfw.fyN();
      }
      while (this.vgq)
      {
        this.vgq = false;
        dhf();
        AppMethodBeat.o(56054);
        return;
        this.vfw.fyM();
        this.vfw.fyO();
      }
      label419:
      Object localObject2;
      Object localObject1;
      if (this.vft != null)
      {
        localObject2 = (bfl)locali.rr.hNL.hNQ;
        paramn = this.vft;
        localObject1 = ((bfl)localObject2).FGP;
        paramString = ((bfl)localObject2).GzJ;
        String str = ((bfl)localObject2).Url;
        localObject2 = com.tencent.mm.plugin.image.d.azA();
        ad.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[] { paramString, str });
        paramn.vbV = str;
        paramn.vbW = "";
        if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(paramString))) {
          break label629;
        }
        paramn.setVisibility(8);
        paramn.fRf.setVisibility(8);
        paramn.vbX.setVisibility(8);
      }
      for (;;)
      {
        nX(true);
        this.vfx.a(locali.list, locali.uZF, locali.hhJ, locali.uZG);
        this.vfx.uT = 0;
        this.vfx.notifyDataSetChanged();
        if (this.vfx.hhJ) {
          break;
        }
        this.vfv.fyL();
        this.vfv.fyN();
        AppMethodBeat.o(56054);
        return;
        label629:
        paramn.setVisibility(0);
        paramn.fRf.setVisibility(0);
        paramn.vbX.setVisibility(0);
        paramn.fRf.setText((CharSequence)localObject1);
        localObject1 = paramn.vbX;
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
                paramString = com.tencent.mm.sdk.platformtools.g.a(paramn, ((SimpleImageView)localObject1).targetWidth, ((SimpleImageView)localObject1).targetHeight, true, false);
              }
            }
            ((SimpleImageView)localObject1).setImageBitmap(paramString);
          }
          else
          {
            com.tencent.mm.sdk.g.b.c(new SimpleImageView.a(paramString, ((SimpleImageView)localObject1).handler), "SimpleImageView_download");
          }
        }
        else if (!com.tencent.mm.vfs.i.fv(paramString))
        {
          ((SimpleImageView)localObject1).setVisibility(8);
        }
        else
        {
          if ((((SimpleImageView)localObject1).targetWidth <= 0) || (((SimpleImageView)localObject1).targetHeight <= 0)) {}
          for (paramString = com.tencent.mm.sdk.platformtools.g.aQf(paramString);; paramString = com.tencent.mm.sdk.platformtools.g.d(paramString, ((SimpleImageView)localObject1).targetWidth, ((SimpleImageView)localObject1).targetHeight, true))
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
      this.vfv.fyM();
      this.vfv.fyO();
    }
    AppMethodBeat.o(56054);
  }
  
  final class a
    extends TranslateAnimation
  {
    private List<View> vgD;
    
    public a(float paramFloat)
    {
      super(0.0F, 0.0F, paramFloat);
      AppMethodBeat.i(56025);
      this.vgD = new ArrayList();
      AppMethodBeat.o(56025);
    }
    
    public final a dhk()
    {
      AppMethodBeat.i(56026);
      setDuration(200L);
      AppMethodBeat.o(56026);
      return this;
    }
    
    public final a dhl()
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
      this.vgD.add(paramView);
      AppMethodBeat.o(56028);
      return this;
    }
    
    public final void startAnimation()
    {
      AppMethodBeat.i(56029);
      int i = 0;
      while (i < this.vgD.size())
      {
        ((View)this.vgD.get(i)).startAnimation(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c
 * JD-Core Version:    0.7.0.1
 */