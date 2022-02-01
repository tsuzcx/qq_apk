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
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.t;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.ui.MyPoiPoint;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.PoiPoint;
import com.tencent.mm.plugin.location.ui.PoiPoint.a;
import com.tencent.mm.plugin.location.ui.PoiPoint.b;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.SimpleImageView.a;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.protocal.protobuf.bzt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.vfs.u;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends b
  implements com.tencent.mm.an.i
{
  private static int EpM = 11;
  private static int EpN = 12;
  private static int EpO = 13;
  private static int EpP = 14;
  private View DqU;
  private String EjC;
  private int EjD;
  PoiPoint.a Emk;
  private FrameLayout EoZ;
  private int EpA;
  private int EpB;
  private int EpC;
  private boolean EpD;
  private boolean EpE;
  private boolean EpF;
  private FrameLayout EpG;
  private int EpH;
  private long EpI;
  private long EpJ;
  private long EpK;
  private int EpL;
  private boolean EpQ;
  private int[] EpR;
  private int[] EpS;
  private View EpT;
  private int EpU;
  private View EpV;
  private View EpW;
  private EditText EpX;
  private ImageView EpY;
  private View EpZ;
  private PoiHeaderView Epi;
  private PickPoi Epj;
  private MMLoadMoreListView Epk;
  private MMLoadMoreListView Epl;
  private e Epm;
  private e Epn;
  private View Epo;
  private ImageButton Epp;
  private com.tencent.mm.plugin.location.model.i Epq;
  private View Epr;
  private TextView Eps;
  private LinearLayout Ept;
  private MyPoiPoint Epu;
  private double Epv;
  private double Epw;
  private boolean Epx;
  private int Epy;
  private RelativeLayout Epz;
  private View.OnTouchListener Eqa;
  private PoiPoint Eqb;
  private Map<String, PoiPoint> Eqc;
  private boolean Eqd;
  private f Eqe;
  private boolean Eqf;
  private boolean Eqg;
  private boolean Eqh;
  private boolean Eqi;
  private boolean Eqj;
  private InputPanelFrameLayout Eqk;
  private b.a iQJ;
  private String lXu;
  private double lat;
  private double lng;
  private View xZQ;
  private boolean zHI;
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56033);
    this.Epq = null;
    this.lat = -85.0D;
    this.lng = -1000.0D;
    this.Epv = -85.0D;
    this.Epw = -1000.0D;
    this.EjC = "";
    this.Epx = false;
    this.lXu = "";
    this.Epy = 0;
    this.EpD = true;
    this.EpE = false;
    this.EpF = false;
    this.EpH = 0;
    this.EpI = -1L;
    this.EpJ = -1L;
    this.EpK = -1L;
    this.EpL = -1;
    this.EpQ = false;
    this.EjD = 1;
    this.EpR = new int[] { 24, 24 };
    this.Eqc = new HashMap();
    this.Eqe = new f();
    this.Eqf = false;
    this.iQJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(182065);
        if (!paramAnonymousBoolean)
        {
          if ((!c.Q(c.this)) && (!com.tencent.mm.modelgeo.d.blr()))
          {
            c.R(c.this);
            com.tencent.mm.ui.base.h.a(c.this.activity, c.this.activity.getString(a.i.gps_disable_tip), c.this.activity.getString(a.i.app_tip), c.this.activity.getString(a.i.jump_to_settings), c.this.activity.getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(182064);
                com.tencent.mm.modelgeo.d.cW(c.this.activity);
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
          Log.d("MicroMsg.MMPoiMapUI", "init my location.");
          str = (int)(1000000.0F * paramAnonymousFloat2) + "," + (int)(1000000.0F * paramAnonymousFloat1);
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vkn, str);
          c.c(c.this, paramAnonymousFloat2);
          c.d(c.this, paramAnonymousFloat1);
          c.b(c.this).k(c.e(c.this), c.f(c.this));
          c.n(c.this).k(c.e(c.this), c.f(c.this));
          if (c.T(c.this))
          {
            c.U(c.this);
            AppMethodBeat.o(182065);
            return true;
          }
          c.a(c.this, c.e(c.this));
          c.b(c.this, c.f(c.this));
          c.a(c.this).d(c.i(c.this), c.j(c.this), c.this.activity.getIntent().getBooleanExtra("key_geo_coder_four_level", false));
          c.this.EmT.getIController().animateTo(c.e(c.this), c.f(c.this), com.tencent.mm.plugin.location.ui.d.eMx());
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
            Log.d("MicroMsg.MMPoiMapUI", "update lat/lng.");
            str = (int)(1000000.0F * paramAnonymousFloat2) + "," + (int)(1000000.0F * paramAnonymousFloat1);
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vkn, str);
            c.c(c.this, paramAnonymousFloat2);
            c.d(c.this, paramAnonymousFloat1);
          }
        }
      }
    };
    this.Eqg = false;
    this.Eqh = false;
    this.Eqi = false;
    this.Eqj = false;
    AppMethodBeat.o(56033);
  }
  
  private void B(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(56045);
    String str3;
    String str1;
    String str2;
    if ((this.Epv == -85.0D) || (this.Epw == -1000.0D))
    {
      str3 = "null/null";
      str1 = "";
      if (paramBoolean) {
        break label563;
      }
      if ((paramInt2 < 0) || (paramInt2 >= this.Epm.getCount())) {
        break label614;
      }
      str1 = this.Epm.VI(paramInt2).EqW;
      str2 = this.Epm.VI(paramInt2).EqL;
    }
    for (;;)
    {
      label82:
      String str4 = str1;
      if (paramInt2 == 0)
      {
        str4 = str1;
        if (Util.isNullOrNil(str1))
        {
          str4 = str1;
          if (this.Epm.getCount() > 1)
          {
            Log.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str4 = this.Epm.VI(1).EqW;
          }
        }
      }
      if ((this.Epm.getCount() > 0) && (!paramBoolean)) {
        Log.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", new Object[] { Integer.valueOf(paramInt2) });
      }
      for (str1 = this.Epm.VI(0).fIY;; str1 = "")
      {
        int i = paramInt2;
        if (paramInt2 == 0)
        {
          i = paramInt2;
          if (!paramBoolean)
          {
            i = paramInt2;
            if (this.Epm.getCount() > 0)
            {
              int j = this.Epm.VI(0).EqX;
              i = paramInt2;
              if (j >= 0)
              {
                Log.d("MicroMsg.MMPoiMapUI", "change to search index: %s", new Object[] { Integer.valueOf(j) });
                i = j;
              }
            }
          }
        }
        Log.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.EpK), Long.valueOf(this.EpJ), Long.valueOf(this.EpI), Integer.valueOf(this.EpH), str3, Integer.valueOf(this.EpL), str4, str1 });
        com.tencent.mm.plugin.report.service.h.IzE.a(11135, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.EpK), Long.valueOf(this.EpJ), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.EpI), Integer.valueOf(this.EpH), str3, str2, Integer.valueOf(this.EpL), str4, com.tencent.mm.compatible.deviceinfo.q.dR(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
        AppMethodBeat.o(56045);
        return;
        str3 = String.format("%f/%f", new Object[] { Double.valueOf(this.Epv), Double.valueOf(this.Epw) });
        break;
        label563:
        if ((paramInt2 < 0) || (paramInt2 >= this.Epn.getCount())) {
          break label614;
        }
        str1 = this.Epn.VI(paramInt2).EqW;
        str2 = this.Epn.VI(paramInt2).EqL;
        break label82;
      }
      label614:
      str2 = "";
    }
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
    if (((c.c.Eqw == paramc) && (this.EpF)) || ((c.c.Eqv == paramc) && (!this.EpF)))
    {
      AppMethodBeat.o(56037);
      return;
    }
    if (this.EpT.getVisibility() != 0) {
      this.EpT.setVisibility(0);
    }
    this.EpD = false;
    int i;
    a locala2;
    a locala1;
    if (c.c.Eqw == paramc)
    {
      Log.d("MicroMsg.MMPoiMapUI", "pennqin play open animation, getListTopMargin(): %d, openedTopMargin: %d.", new Object[] { Integer.valueOf(eNl()), Integer.valueOf(this.EpB) });
      i = eNl() - this.EpB;
      Log.d("MicroMsg.MMPoiMapUI", "pennqin play open animation (getListTopMargin() - openedTopMargin): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(-i);
      locala1 = new a(-this.EpC);
    }
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.EpU });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.EpU, 0 }))
    {
      paramc = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(182057);
          c.f(c.this, true);
          if (c.c.Eqw == paramc)
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
            if ((!c.n(c.this).una.equals(c.E(c.this))) || (!c.n(c.this).cSY)) {
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
              c.a(c.this, c.n(c.this).bFx);
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
          Log.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s.", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
      locala2 = locala2.eNp().eNq();
      locala2.setAnimationListener(paramc);
      locala2.fl(this.Epz).fl(this.Epp).startAnimation();
      locala1.eNp().eNq().fl(this.EpG).startAnimation();
      localValueAnimator.setDuration(200L).start();
      AppMethodBeat.o(56037);
      return;
      Log.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation, getListTopMargin(): %d, collapsedTopMargin: %d.", new Object[] { Integer.valueOf(eNl()), Integer.valueOf(this.EpA) });
      i = this.EpA - eNl();
      Log.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation (collapsedTopMargin - getListTopMargin()): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(i);
      locala1 = new a(this.EpC);
    }
  }
  
  private void b(c.c paramc)
  {
    AppMethodBeat.i(56055);
    if (c.c.Eqv == paramc)
    {
      ((FrameLayout.LayoutParams)this.Epz.getLayoutParams()).topMargin = this.EpA;
      ((RelativeLayout.LayoutParams)this.EpG.getLayoutParams()).topMargin = 0;
      ((FrameLayout.LayoutParams)this.Epp.getLayoutParams()).topMargin = (this.EpA - aw.fromDPToPix(this.activity, 92));
      this.EmT.setLogoMargin(this.EpR);
    }
    for (;;)
    {
      this.Epz.requestLayout();
      this.Epp.requestLayout();
      this.EpG.requestLayout();
      AppMethodBeat.o(56055);
      return;
      if (c.c.Eqw == paramc)
      {
        ((FrameLayout.LayoutParams)this.Epz.getLayoutParams()).topMargin = this.EpB;
        ((RelativeLayout.LayoutParams)this.EpG.getLayoutParams()).topMargin = (-this.EpC);
        ((FrameLayout.LayoutParams)this.Epp.getLayoutParams()).topMargin = (this.EpB - aw.fromDPToPix(this.activity, 92));
        this.EmT.setLogoMargin(this.EpS);
      }
    }
  }
  
  private boolean eNg()
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
  
  private void eNh()
  {
    AppMethodBeat.i(56039);
    this.Epx = false;
    this.EoZ.setVisibility(0);
    a(c.c.Eqv);
    eNm();
    this.lXu = "";
    this.Epl.setVisibility(8);
    this.Epm.notifyDataSetChanged();
    this.Epk.setVisibility(0);
    this.Epo.setVisibility(8);
    this.Eps.setVisibility(8);
    eNj();
    tM(true);
    this.Epp.setSelected(this.Eqf);
    this.EmT.getIController().animateTo(this.lat, this.lng);
    AppMethodBeat.o(56039);
  }
  
  private void eNi()
  {
    AppMethodBeat.i(56043);
    if (this.Epj.EqA)
    {
      f localf = this.Epj.getPoi();
      e locale = this.Epm;
      if (locale.EqE.size() >= 0)
      {
        locale.EqE.add(0, localf);
        locale.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(56043);
  }
  
  private void eNj()
  {
    AppMethodBeat.i(56050);
    Iterator localIterator = this.Eqc.values().iterator();
    while (localIterator.hasNext()) {
      ((PoiPoint)localIterator.next()).remove();
    }
    this.Eqc.clear();
    this.Eqb = null;
    AppMethodBeat.o(56050);
  }
  
  private void eNk()
  {
    AppMethodBeat.i(56051);
    Object localObject = new ArrayList(5);
    int i = 0;
    while ((i < 5) && (i < this.Epn.getCount()))
    {
      ((List)localObject).add(this.Epn.VI(i));
      i += 1;
    }
    localObject = fP((List)localObject);
    eNj();
    i = 0;
    while (i < ((List)localObject).size())
    {
      f localf = this.Epn.VI(i);
      PoiPoint localPoiPoint = new PoiPoint(this.activity, this.EmT);
      localPoiPoint.setPosition(i);
      localPoiPoint.setOnPointClick(this.Emk);
      this.Eqc.put(localf.BVq + localf.BVp, localPoiPoint);
      localPoiPoint.c(localf.BVq, localf.BVp, false);
      i += 1;
    }
    fQ((List)localObject);
    AppMethodBeat.o(56051);
  }
  
  private int eNl()
  {
    AppMethodBeat.i(56056);
    int i = ((ViewGroup.MarginLayoutParams)this.Epz.getLayoutParams()).topMargin;
    AppMethodBeat.o(56056);
    return i;
  }
  
  private void eNm()
  {
    AppMethodBeat.i(56057);
    if (this.Epx)
    {
      this.EpV.setVisibility(8);
      this.EpW.setVisibility(0);
      this.EpZ.setVisibility(0);
      AppMethodBeat.o(56057);
      return;
    }
    this.EpV.setVisibility(0);
    this.EpW.setVisibility(8);
    this.EpZ.setVisibility(8);
    AppMethodBeat.o(56057);
  }
  
  private void eNn()
  {
    AppMethodBeat.i(56058);
    if (!this.Eqh)
    {
      this.Eqh = true;
      this.EpX.requestFocus();
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
  
  private static List<f> fP(List<f> paramList)
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
        if (TencentLocationUtils.distanceBetween(localf1.BVq, localf1.BVp, localf2.BVq, localf2.BVp) > 5000.0D) {
          break label121;
        }
        localArrayList.add(localf1);
      }
    }
    label121:
    AppMethodBeat.o(56052);
    return localArrayList;
  }
  
  private void fQ(List<f> paramList)
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
      this.EmT.getIController().animateTo(((f)paramList.get(0)).BVq, ((f)paramList.get(0)).BVp);
      AppMethodBeat.o(56053);
      return;
    }
    ArrayList localArrayList = new ArrayList(5);
    while (i < paramList.size())
    {
      f localf = (f)paramList.get(i);
      localArrayList.add(new LatLng(localf.BVq, localf.BVp));
      i += 1;
    }
    paramList = LatLngBounds.builder().include(localArrayList).build();
    if ((Double.isInfinite(paramList.getNortheast().getLatitude())) || (Double.isNaN(paramList.getNortheast().getLongitude())) || (Double.isInfinite(paramList.getSouthwest().getLatitude())) || (Double.isNaN(paramList.getSouthwest().getLongitude())))
    {
      AppMethodBeat.o(56053);
      return;
    }
    this.EmT.animateCamera(CameraUpdateFactory.newLatLngBounds(paramList, 250));
    AppMethodBeat.o(56053);
  }
  
  private void sk(boolean paramBoolean)
  {
    AppMethodBeat.i(56044);
    Log.d("MicroMsg.MMPoiMapUI", "stack: %s", new Object[] { Util.getStack() });
    this.EjC = a(this.lat, this.lXu);
    if (this.EjC.equals(this.Epm.key))
    {
      Log.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[] { this.EjC });
      AppMethodBeat.o(56044);
      return;
    }
    byte[] arrayOfByte = null;
    int i = 1;
    this.Epo.setVisibility(0);
    label185:
    double d1;
    double d2;
    if (this.Epx) {
      if ((this.EjD > 0) && (paramBoolean))
      {
        this.Epl.hJL();
        this.Epn.eNr();
        this.Epn.aNt(this.EjC);
        this.Epn.una = this.lXu;
        this.Epn.cSY = false;
        arrayOfByte = this.Epn.buffer;
        if (i == 0) {
          break label436;
        }
        if (this.Epy != 0) {
          break label424;
        }
        i = 0;
        d1 = this.lat;
        d2 = this.lng;
        if (!this.Epx) {
          break label430;
        }
      }
    }
    label424:
    label430:
    for (int j = 0;; j = 1)
    {
      this.Epq = new com.tencent.mm.plugin.location.model.i(arrayOfByte, d1, d2, i, j, this.Epw, this.Epv, this.EjC, this.lXu, paramBoolean);
      com.tencent.mm.kernel.h.aGY().a(this.Epq, 0);
      this.EpH += 1;
      if (this.EpK == -1L) {
        this.EpK = System.currentTimeMillis();
      }
      AppMethodBeat.o(56044);
      return;
      if (!paramBoolean)
      {
        this.Epl.hJL();
        this.Epn.clean();
        this.Epn.aNt(this.EjC);
        this.Epn.una = this.lXu;
        this.Epn.cSY = false;
        arrayOfByte = this.Epn.buffer;
        this.Epn.notifyDataSetChanged();
        break;
      }
      i = 0;
      this.Epn.cSY = false;
      break;
      this.Epk.hJL();
      this.Epm.clean();
      this.Epm.aNt(this.EjC);
      this.Epm.notifyDataSetChanged();
      arrayOfByte = this.Epm.buffer;
      tM(false);
      eNi();
      break;
      i = 1;
      break label185;
    }
    label436:
    Log.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", new Object[] { Integer.valueOf(this.EjD) });
    AppMethodBeat.o(56044);
  }
  
  private void tM(boolean paramBoolean)
  {
    AppMethodBeat.i(56048);
    Log.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.DqU.setEnabled(paramBoolean);
    this.Epr.setEnabled(paramBoolean);
    AppMethodBeat.o(56048);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(56038);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent, back.");
      g.c.Erk.a(g.a.Erb);
      if (this.Epx)
      {
        eNh();
        B(EpP, this.Epn.bFx, true);
        AppMethodBeat.o(56038);
        return false;
      }
      B(EpN, this.Epm.bFx, false);
      this.activity.finish();
      AppMethodBeat.o(56038);
      return true;
    }
    AppMethodBeat.o(56038);
    return false;
  }
  
  public final com.tencent.mm.plugin.q.d eNd()
  {
    AppMethodBeat.i(56036);
    com.tencent.mm.plugin.q.d locald = (com.tencent.mm.plugin.q.d)this.activity.findViewById(a.e.g_mapView);
    AppMethodBeat.o(56036);
    return locald;
  }
  
  public final void eNe()
  {
    AppMethodBeat.i(56040);
    a(c.c.Eqv);
    AppMethodBeat.o(56040);
  }
  
  public final void eNf()
  {
    AppMethodBeat.i(56041);
    if (this.Epp.isSelected()) {
      this.Epp.setSelected(false);
    }
    if (!this.Epx)
    {
      this.Epj.play();
      this.lat = (this.EmT.getMapCenterX() / 1000000.0D);
      this.lng = (this.EmT.getMapCenterY() / 1000000.0D);
      this.Epj.d(this.lat, this.lng, this.activity.getIntent().getBooleanExtra("key_geo_coder_four_level", false));
      this.Epp.setSelected(false);
      if (this.EpF) {
        a(c.c.Eqv);
      }
      sk(false);
      this.EpQ = false;
      g.c.Erk.EqY = 0;
      g.c.Erk.a(g.b.Erg);
    }
    AppMethodBeat.o(56041);
  }
  
  public final int getLayoutId()
  {
    return a.f.poi_gmap_ui;
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
    com.tencent.mm.kernel.h.aGY().a(457, this);
    this.EpL = ((int)(System.currentTimeMillis() / 1000L));
    this.EmT.setCanRotate(false);
    label212:
    int j;
    if (ar.isDarkMode())
    {
      eNd().enableDarkMode();
      this.Ept = ((LinearLayout)findViewById(a.e.header_bar));
      ((TextView)findViewById(a.e.btn_back_txt)).setText(a.i.app_cancel);
      this.xZQ = findViewById(a.e.title_bar_btn_back_area);
      this.xZQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56013);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          g.c.Erk.a(g.a.Erb);
          c.a(c.this, c.EpN, c.b(c.this).bFx, false);
          c.c(c.this);
          c.this.activity.finish();
          a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(56013);
        }
      });
      this.xZQ.setVisibility(0);
      this.DqU = findViewById(a.e.title_bar_btn_send_area);
      this.Epr = findViewById(a.e.btn_send_txt);
      switch (this.type)
      {
      default: 
        this.DqU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(56018);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            g.c.Erk.a(g.a.Era);
            c.d(c.this);
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(56018);
          }
        });
        this.DqU.setVisibility(0);
        tM(false);
        this.Epz = ((RelativeLayout)findViewById(a.e.location_list_rl));
        this.Epk = ((MMLoadMoreListView)this.activity.findViewById(a.e.poi_list));
        this.Epl = ((MMLoadMoreListView)this.activity.findViewById(a.e.search_list));
        this.Epo = findViewById(a.e.loading);
        this.Eps = ((TextView)findViewById(a.e.search_empty));
        this.Epi = ((PoiHeaderView)findViewById(a.e.poi_header));
        this.EpG = ((FrameLayout)findViewById(a.e.mapview_fl));
        this.Epp = ((ImageButton)findViewById(a.e.locate_to_my_position));
        this.Epp.setSelected(true);
        paramBundle = this.Epp;
        i = a.i.locate_to_my_pos;
        paramBundle.setContentDescription(this.activity.getString(i));
        this.Epp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182066);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", new Object[] { Double.valueOf(c.e(c.this)), Double.valueOf(c.f(c.this)) });
            if ((c.e(c.this) == -85.0D) || (c.f(c.this) == -1000.0D))
            {
              Log.i("MicroMsg.MMPoiMapUI", "invalid lat lng");
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182066);
              return;
            }
            if (c.g(c.this))
            {
              c.this.EmT.getIController().animateTo(c.e(c.this), c.f(c.this));
              c.h(c.this).setSelected(true);
              c.a(c.this, c.c.Eqv);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182066);
              return;
              c.this.EmT.getIController().animateTo(c.e(c.this), c.f(c.this));
              c.a(c.this, c.e(c.this));
              c.b(c.this, c.f(c.this));
              c.a(c.this).d(c.i(c.this), c.j(c.this), c.this.activity.getIntent().getBooleanExtra("key_geo_coder_four_level", false));
              c.h(c.this).setSelected(true);
              c.a(c.this, false);
              c.b(c.this).bFx = 0;
              c.k(c.this).setSelection(0);
              g.c.Erk.EqY = 0;
              g.c.Erk.a(g.b.Eri);
              c.l(c.this);
            }
          }
        });
        this.EmT.setBuiltInZoomControls(false);
        this.EoZ = ((FrameLayout)findViewById(a.e.control_id));
        this.Epu = new MyPoiPoint(this.activity, this.EmT);
        this.Epj = new PickPoi(this.activity);
        this.Epj.setOnCurPoiGet(new b()
        {
          public final void a(f paramAnonymousf)
          {
            AppMethodBeat.i(182067);
            c.a(c.this).setOnCurPoiGet(null);
            if (paramAnonymousf != null)
            {
              c.m(c.this).c(paramAnonymousf.EqV);
              if (c.b(c.this) != null)
              {
                c.b(c.this).iK(c.m(c.this).EqO, c.m(c.this).EqP);
                c.n(c.this).iK(c.m(c.this).EqO, c.m(c.this).EqP);
              }
            }
            AppMethodBeat.o(182067);
          }
        });
        this.EoZ.addView(this.Epj);
        paramBundle = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vkn, "");
        if ((!Util.isNullOrNil(paramBundle)) && ((this.Epv == -85.0D) || (this.Epw == -1000.0D)))
        {
          String[] arrayOfString = paramBundle.split(",");
          Log.i("MicroMsg.MMPoiMapUI", "last locationInfo ".concat(String.valueOf(paramBundle)));
          if (arrayOfString.length == 2)
          {
            float f1 = (float)(Util.safeParseInt(arrayOfString[0]) * 1.0D / 1000000.0D);
            float f2 = (float)(Util.safeParseInt(arrayOfString[1]) * 1.0D / 1000000.0D);
            this.EmT.getIController().animateTo(f1, f2);
          }
        }
        this.Eqa = new View.OnTouchListener()
        {
          private float Eqq;
          private short Eqr = 0;
          
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
              Log.d("MicroMsg.MMPoiMapUI", "newpoi action down %s.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
              this.Eqq = paramAnonymousMotionEvent.getRawY();
              c.b(c.this, false);
              continue;
              Log.d("MicroMsg.MMPoiMapUI", "newpoi action move %s.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
              if (c.p(c.this))
              {
                Log.d("MicroMsg.MMPoiMapUI", "newpoi blocked.");
                c.k(c.this).setSelection(0);
              }
              float f = this.Eqq - paramAnonymousMotionEvent.getRawY();
              if (Math.abs(f) < BackwardSupportUtil.BitmapFactory.fromDPToPix(c.this.activity, 20.0F)) {
                this.Eqr = 0;
              }
              while (((c.q(c.this)) && (this.Eqr == 1)) || ((c.r(c.this)) && (this.Eqr == -1)) || ((c.q(c.this)) && (!c.s(c.this).getScroll2Top()) && (this.Eqr == -1)))
              {
                AppMethodBeat.o(182068);
                return false;
                if (f > 0.0F) {
                  this.Eqr = 1;
                } else {
                  this.Eqr = -1;
                }
              }
              if ((c.o(c.this)) && (this.Eqr != 0))
              {
                Log.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[] { Short.valueOf(this.Eqr) });
                if (this.Eqr == 1)
                {
                  c.c(c.this, true);
                  c.a(c.this, c.c.Eqw);
                  AppMethodBeat.o(182068);
                  return false;
                }
                c.a(c.this, c.c.Eqv);
                AppMethodBeat.o(182068);
                return false;
              }
              AppMethodBeat.o(182068);
              return true;
              Log.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
              c.b(c.this, false);
            }
          }
        };
        this.Epk.setOnTouchListener(this.Eqa);
        this.Epk.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void onLoadMore()
          {
            AppMethodBeat.i(182069);
            c.t(c.this);
            AppMethodBeat.o(182069);
          }
        });
        this.Epk.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182070);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousAdapterView);
            localb.bn(paramAnonymousView);
            localb.sg(paramAnonymousInt);
            localb.Fs(paramAnonymousLong);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
            Log.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= c.b(c.this).getCount()))
            {
              Log.i("MicroMsg.MMPoiMapUI", "wrong position");
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182070);
              return;
            }
            paramAnonymousAdapterView = c.b(c.this).VI(paramAnonymousInt);
            if (paramAnonymousAdapterView.type == 0) {
              c.h(c.this).setSelected(false);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView.BVq);
              c.b(c.this, paramAnonymousAdapterView.BVp);
              c.this.EmT.getIController().animateTo(paramAnonymousAdapterView.BVq, paramAnonymousAdapterView.BVp);
              if (c.this.activity.getIntent().getBooleanExtra("key_geo_coder_four_level", false)) {
                com.tencent.mm.modelgeo.c.bln().a(c.i(c.this), c.j(c.this), new com.tencent.mm.modelgeo.c.a()
                {
                  public final void b(Addr paramAnonymous2Addr)
                  {
                    AppMethodBeat.i(244675);
                    com.tencent.mm.modelgeo.c.bln().a(this);
                    paramAnonymousAdapterView.EqV.lLo = paramAnonymous2Addr.lLo;
                    AppMethodBeat.o(244675);
                  }
                }, null, true);
              }
              c.b(c.this).bFx = paramAnonymousInt;
              c.b(c.this).notifyDataSetChanged();
              c.a(c.this, false);
              g.c.Erk.EqY = (paramAnonymousInt + 1);
              g.c.Erk.a(g.b.Erh);
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182070);
              return;
              c.h(c.this).setSelected(true);
            }
          }
        });
        this.Epm = new e(this.activity);
        this.Epk.setAdapter(this.Epm);
        this.Epj.setAdapter(this.Epm);
        this.Emk = new PoiPoint.a()
        {
          public final void a(PoiPoint.b paramAnonymousb, PoiPoint paramAnonymousPoiPoint)
          {
            AppMethodBeat.i(182071);
            if (PoiPoint.b.Emn == paramAnonymousb)
            {
              if (-1 == c.n(c.this).bFx) {
                c.d(c.this, true);
              }
              if (c.u(c.this) != null) {
                c.u(c.this).eMB();
              }
              c.this.EmT.getIController().animateTo(paramAnonymousPoiPoint.getLat(), paramAnonymousPoiPoint.getLng());
              c.a(c.this, paramAnonymousPoiPoint);
              paramAnonymousPoiPoint.eMC();
              c.a(c.this, paramAnonymousPoiPoint.getPosition());
              c.n(c.this).bFx = paramAnonymousPoiPoint.getPosition();
              c.n(c.this).notifyDataSetChanged();
              g.c.Erk.EqY = (paramAnonymousPoiPoint.getPosition() + 1);
              g.c.Erk.a(g.b.Erf);
              AppMethodBeat.o(182071);
              return;
            }
            paramAnonymousb = PoiPoint.b.Emm;
            AppMethodBeat.o(182071);
          }
        };
        this.Epn = new e(this.activity);
        this.Epn.mYQ = true;
        this.Epn.bFx = -1;
        this.Epl.setAdapter(this.Epn);
        this.Epl.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void onLoadMore()
          {
            AppMethodBeat.i(182051);
            c.t(c.this);
            AppMethodBeat.o(182051);
          }
        });
        this.Epl.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182052);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousAdapterView);
            localb.bn(paramAnonymousView);
            localb.sg(paramAnonymousInt);
            localb.Fs(paramAnonymousLong);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
            if (-1 == c.n(c.this).bFx)
            {
              c.d(c.this, true);
              c.a(c.this, c.c.Eqv);
            }
            c.n(c.this).bFx = paramAnonymousInt;
            c.n(c.this).notifyDataSetChanged();
            if ((paramAnonymousInt >= 0) && (paramAnonymousInt < c.n(c.this).getCount()))
            {
              c.a(c.this, true);
              if (c.u(c.this) != null) {
                c.u(c.this).eMB();
              }
              paramAnonymousView = c.n(c.this).VI(paramAnonymousInt);
              if ((paramAnonymousView.BVq == c.e(c.this)) && (paramAnonymousView.BVp == c.f(c.this))) {
                break label457;
              }
              c.h(c.this).setSelected(false);
              c.this.EmT.getIController().animateTo(paramAnonymousView.BVq, paramAnonymousView.BVp);
              if (c.this.activity.getIntent().getBooleanExtra("key_geo_coder_four_level", false)) {
                com.tencent.mm.modelgeo.c.bln().a(paramAnonymousView.BVq, paramAnonymousView.BVp, new com.tencent.mm.modelgeo.c.a()
                {
                  public final void b(Addr paramAnonymous2Addr)
                  {
                    AppMethodBeat.i(246198);
                    com.tencent.mm.modelgeo.c.bln().a(this);
                    paramAnonymousView.EqV.lLo = paramAnonymous2Addr.lLo;
                    AppMethodBeat.o(246198);
                  }
                }, null, true);
              }
              paramAnonymousAdapterView = (PoiPoint)c.v(c.this).get(paramAnonymousView.BVq + paramAnonymousView.BVp);
              if (paramAnonymousAdapterView != null) {
                break label471;
              }
              paramAnonymousAdapterView = new PoiPoint(c.this.activity, c.this.EmT);
              paramAnonymousAdapterView.setPosition(paramAnonymousInt);
              paramAnonymousAdapterView.setOnPointClick(c.this.Emk);
              c.v(c.this).put(paramAnonymousView.BVq + paramAnonymousView.BVp, paramAnonymousAdapterView);
              paramAnonymousAdapterView.c(paramAnonymousView.BVq, paramAnonymousView.BVp, true);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView);
              g.c.Erk.EqY = (paramAnonymousInt + 1);
              g.c.Erk.a(g.b.Ere);
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182052);
              return;
              label457:
              c.h(c.this).setSelected(true);
              break;
              label471:
              paramAnonymousAdapterView.eMC();
            }
          }
        });
        this.Epl.setOnTouchListener(this.Eqa);
        this.EpV = findViewById(a.e.send_loc_search_hint);
        this.EpW = findViewById(a.e.send_loc_search_ing);
        this.EpX = ((EditText)findViewById(a.e.send_loc_search_edt));
        this.EpY = ((ImageView)findViewById(a.e.send_loc_search_reset));
        this.EpZ = findViewById(a.e.send_loc_search_cancel);
        this.EpV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(170177);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (!c.g(c.this)) {
              c.H(c.this);
            }
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(170177);
          }
        });
        this.EpZ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182059);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            c.a(c.this, c.eNo(), c.n(c.this).bFx, true);
            c.y(c.this);
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(182059);
          }
        });
        this.EpX.setOnTouchListener(new View.OnTouchListener()
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
              return false;
              if (c.o(c.this)) {
                c.a(c.this, c.c.Eqw);
              }
            }
          }
        });
        this.Epz.setClickable(true);
        this.EpX.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(182061);
            if (3 == paramAnonymousInt)
            {
              c.a(c.this, c.c.Eqv);
              c.h(c.this, true);
            }
            AppMethodBeat.o(182061);
            return false;
          }
        });
        this.EpX.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(182062);
            Log.d("MicroMsg.MMPoiMapUI", "searchText: %s.", new Object[] { paramAnonymousCharSequence });
            c.a(c.this, paramAnonymousCharSequence.toString());
            c.J(c.this).hJL();
            c.K(c.this).setVisibility(8);
            if (Util.isNullOrNil(c.E(c.this)))
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
        this.EpY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182063);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            c.P(c.this).setText("");
            c.A(c.this);
            if (c.o(c.this)) {
              c.a(c.this, c.c.Eqw);
            }
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(182063);
          }
        });
        eNm();
        this.EpT = findViewById(a.e.send_loc_collapse_layout);
        this.EpT.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182053);
            Log.d("MicroMsg.MMPoiMapUI", "pennqin, collapseBtnLayoutHeight: %d.", new Object[] { Integer.valueOf(c.w(c.this)) });
            c.b(c.this, c.x(c.this).getHeight());
            c.x(c.this).setVisibility(8);
            AppMethodBeat.o(182053);
          }
        });
        findViewById(a.e.send_loc_collapse_btn).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182054);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (c.n(c.this).getCount() == 0) {
              c.y(c.this);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182054);
              return;
              c.a(c.this, c.c.Eqv);
            }
          }
        });
        this.Eqk = ((InputPanelFrameLayout)findViewById(a.e.poi_map_fl));
        this.Eqk.setExternalListener(new com.tencent.mm.ui.widget.c.a()
        {
          public final void h(boolean paramAnonymousBoolean, int paramAnonymousInt)
          {
            AppMethodBeat.i(182055);
            Log.d("MicroMsg.MMPoiMapUI", "isKeyboardShow: %s.", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            c.e(c.this, paramAnonymousBoolean);
            AppMethodBeat.o(182055);
          }
        });
        paramBundle = ar.au(this.activity);
        j = Math.max(paramBundle.x, paramBundle.y);
        this.EpA = (j - BackwardSupportUtil.BitmapFactory.fromDPToPix(this.activity, 320.0F));
        this.EpB = ((int)(j * 0.25F + 0.5D));
        this.EpC = ((int)((this.EpA - this.EpB) / 3.0D + 0.5D));
        Log.i("MicroMsg.MMPoiMapUI", "collapsedTopMargin: %d, openedTopMargin: %d, mapViewTopMargin: %d.", new Object[] { Integer.valueOf(this.EpA), Integer.valueOf(this.EpB), Integer.valueOf(this.EpC) });
        this.EpS = new int[] { this.EpA - this.EpB - this.EpC + 24, 24 };
        i = this.activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i <= 0) {
          break;
        }
      }
    }
    for (int i = this.activity.getResources().getDimensionPixelSize(i);; i = 0)
    {
      paramBundle = (FrameLayout.LayoutParams)this.Ept.getLayoutParams();
      paramBundle.height += i * 2;
      this.Ept.setLayoutParams(paramBundle);
      this.Ept.setPadding(0, i, 0, i);
      if (ax.av(this.activity))
      {
        i = ax.aB(this.activity);
        label1293:
        j = j - this.EpB - i;
        Log.i("MicroMsg.MMPoiMapUI", "reset poi view height: %s, navigationBarHeight: %s.", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramBundle = this.Epz.getLayoutParams();
        paramBundle.height = j;
        this.Epz.setLayoutParams(paramBundle);
        paramBundle = (RelativeLayout.LayoutParams)this.EpG.getLayoutParams();
        paramBundle.height = this.EpA;
        this.EpG.setLayoutParams(paramBundle);
        b(c.c.Eqv);
        if ((this.type != 0) && (this.type != 8)) {
          break label1526;
        }
        g.c.Erk.setScene(this.activity.getIntent().getIntExtra("type_tag", 0));
      }
      for (;;)
      {
        this.Epj.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
        eNd().disableDarkMode();
        break;
        ((TextView)findViewById(a.e.btn_send_txt)).setText(a.i.location_send);
        break label212;
        ((TextView)findViewById(a.e.btn_send_txt)).setText(a.i.app_nextstep);
        break label212;
        ((TextView)findViewById(a.e.btn_send_txt)).setText(a.i.app_finish);
        break label212;
        i = 0;
        break label1293;
        label1526:
        g.c.Erk.setScene(this.type);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56049);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(457, this);
    AppMethodBeat.o(56049);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56047);
    super.onPause();
    this.Eqg = false;
    com.tencent.mm.modelgeo.d.blq().b(this.iQJ);
    MyPoiPoint localMyPoiPoint = this.Epu;
    Log.d("MicroMsg.MyPoiPoint", "disableLocation");
    localMyPoiPoint.ElE.b(localMyPoiPoint.iQJ);
    AppMethodBeat.o(56047);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56046);
    super.onResume();
    this.Eqg = true;
    com.tencent.mm.modelgeo.d.blq().b(this.iQJ, true);
    this.Epu.eMA();
    AppMethodBeat.o(56046);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(56054);
    if (paramq.getType() == 457)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(56054);
        return;
      }
      this.Epq = null;
      com.tencent.mm.plugin.location.model.i locali = (com.tencent.mm.plugin.location.model.i)paramq;
      if (!locali.EjC.equals(this.EjC))
      {
        Log.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.EjC + " " + locali.EjC);
        AppMethodBeat.o(56054);
        return;
      }
      Log.i("MicroMsg.MMPoiMapUI", "isEnd: " + locali.kSa + " searchId: " + locali.jQi + " isInSearch: " + this.Epx);
      if (this.EpI == -1L)
      {
        long l = System.currentTimeMillis();
        this.EpJ = l;
        this.EpI = l;
      }
      for (;;)
      {
        this.EjD = locali.EjD;
        this.Epo.setVisibility(8);
        if (!this.Epx) {
          break label419;
        }
        if (!Util.isNullOrNil(this.lXu)) {
          break;
        }
        AppMethodBeat.o(56054);
        return;
        this.EpJ = System.currentTimeMillis();
      }
      if ((locali.list != null) && (locali.list.size() == 0))
      {
        this.Eps.setVisibility(0);
        this.Epl.hJL();
      }
      Log.d("MicroMsg.MMPoiMapUI", "search is first: %s", new Object[] { Boolean.valueOf(locali.isFirst()) });
      if (locali.isFirst())
      {
        this.Epn.cSY = true;
        this.Epn.EqE.clear();
      }
      this.Epn.a(locali.list, locali.EjB, locali.kSa, locali.EjC);
      if (!this.Epn.kSa)
      {
        this.Epl.hJK();
        this.Epl.hJM();
      }
      while (this.Eqd)
      {
        this.Eqd = false;
        eNk();
        AppMethodBeat.o(56054);
        return;
        this.Epl.hJL();
        this.Epl.hJN();
      }
      label419:
      Object localObject2;
      Object localObject1;
      if (this.Epi != null)
      {
        localObject2 = (bzt)d.c.b(locali.rr.lBS);
        paramq = this.Epi;
        localObject1 = ((bzt)localObject2).RUd;
        paramString = ((bzt)localObject2).TgM;
        String str = ((bzt)localObject2).Url;
        localObject2 = com.tencent.mm.plugin.image.d.bbW();
        Log.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[] { paramString, str });
        paramq.ElQ = str;
        paramq.ElR = "";
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(paramString))) {
          break label629;
        }
        paramq.setVisibility(8);
        paramq.jiw.setVisibility(8);
        paramq.ElS.setVisibility(8);
      }
      for (;;)
      {
        tM(true);
        this.Epm.a(locali.list, locali.EjB, locali.kSa, locali.EjC);
        this.Epm.bFx = 0;
        this.Epm.notifyDataSetChanged();
        if (this.Epm.kSa) {
          break;
        }
        this.Epk.hJK();
        this.Epk.hJM();
        AppMethodBeat.o(56054);
        return;
        label629:
        paramq.setVisibility(0);
        paramq.jiw.setVisibility(0);
        paramq.ElS.setVisibility(0);
        paramq.jiw.setText((CharSequence)localObject1);
        localObject1 = paramq.ElS;
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
          paramq = MMBitmapFactory.decodeFile(((SimpleImageView)localObject1).imagePath + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
          if (paramq != null)
          {
            paramString = paramq;
            if (((SimpleImageView)localObject1).targetWidth > 0)
            {
              paramString = paramq;
              if (((SimpleImageView)localObject1).targetHeight > 0) {
                paramString = BitmapUtil.extractThumbNail(paramq, ((SimpleImageView)localObject1).targetWidth, ((SimpleImageView)localObject1).targetHeight, true, false);
              }
            }
            ((SimpleImageView)localObject1).setImageBitmap(paramString);
          }
          else
          {
            ThreadPool.post(new SimpleImageView.a(paramString, ((SimpleImageView)localObject1).handler), "SimpleImageView_download");
          }
        }
        else if (!u.agG(paramString))
        {
          ((SimpleImageView)localObject1).setVisibility(8);
        }
        else
        {
          if ((((SimpleImageView)localObject1).targetWidth <= 0) || (((SimpleImageView)localObject1).targetHeight <= 0)) {}
          for (paramString = BitmapUtil.getBitmapNative(paramString);; paramString = BitmapUtil.extractThumbNail(paramString, ((SimpleImageView)localObject1).targetWidth, ((SimpleImageView)localObject1).targetHeight, true))
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
      this.Epk.hJL();
      this.Epk.hJN();
    }
    AppMethodBeat.o(56054);
  }
  
  final class a
    extends TranslateAnimation
  {
    private List<View> Equ;
    
    public a(float paramFloat)
    {
      super(0.0F, 0.0F, paramFloat);
      AppMethodBeat.i(56025);
      this.Equ = new ArrayList();
      AppMethodBeat.o(56025);
    }
    
    public final a eNp()
    {
      AppMethodBeat.i(56026);
      setDuration(200L);
      AppMethodBeat.o(56026);
      return this;
    }
    
    public final a eNq()
    {
      AppMethodBeat.i(56027);
      setFillEnabled(true);
      setFillAfter(true);
      AppMethodBeat.o(56027);
      return this;
    }
    
    public final a fl(View paramView)
    {
      AppMethodBeat.i(56028);
      this.Equ.add(paramView);
      AppMethodBeat.o(56028);
      return this;
    }
    
    public final void startAnimation()
    {
      AppMethodBeat.i(56029);
      int i = 0;
      while (i < this.Equ.size())
      {
        ((View)this.Equ.get(i)).startAnimation(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c
 * JD-Core Version:    0.7.0.1
 */