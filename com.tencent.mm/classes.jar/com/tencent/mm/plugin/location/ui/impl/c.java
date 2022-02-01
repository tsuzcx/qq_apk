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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.i;
import com.tencent.mm.plugin.location.ui.MyPoiPoint;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.PoiPoint;
import com.tencent.mm.plugin.location.ui.PoiPoint.a;
import com.tencent.mm.plugin.location.ui.PoiPoint.b;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.SimpleImageView.a;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.protocal.protobuf.cpc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.sensitive.d.e;
import com.tencent.mm.sensitive.d.f;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.vfs.y;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends b
  implements com.tencent.mm.am.h, d.e
{
  private static int Kit = 11;
  private static int Kiu = 12;
  private static int Kiv = 13;
  private static int Kiw = 14;
  private View CxW;
  private boolean EPk;
  private View JkC;
  private String Kcl;
  private int Kcm;
  PoiPoint.a KeT;
  private FrameLayout KhG;
  private PoiHeaderView KhP;
  private PickPoi KhQ;
  private MMLoadMoreListView KhR;
  private MMLoadMoreListView KhS;
  private e KhT;
  private e KhU;
  private View KhV;
  private ImageButton KhW;
  private i KhX;
  private View KhY;
  private TextView KhZ;
  private View KiA;
  private int KiB;
  private View KiC;
  private View KiD;
  private EditText KiE;
  private ImageView KiF;
  private View KiG;
  private View.OnTouchListener KiH;
  private PoiPoint KiI;
  private Map<String, PoiPoint> KiJ;
  private boolean KiK;
  private f KiL;
  private boolean KiM;
  private boolean KiN;
  private boolean KiO;
  private boolean KiP;
  private boolean KiQ;
  private InputPanelFrameLayout KiR;
  private LinearLayout Kia;
  private MyPoiPoint Kib;
  private double Kic;
  private double Kid;
  private boolean Kie;
  private int Kif;
  private RelativeLayout Kig;
  private int Kih;
  private int Kii;
  private int Kij;
  private boolean Kik;
  private boolean Kil;
  private boolean Kim;
  private FrameLayout Kin;
  private int Kio;
  private long Kip;
  private long Kiq;
  private long Kir;
  private int Kis;
  private boolean Kix;
  private int[] Kiy;
  private int[] Kiz;
  private double lat;
  private double lng;
  private b.a lsF;
  private String oQy;
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56033);
    this.KhX = null;
    this.lat = -85.0D;
    this.lng = -1000.0D;
    this.Kic = -85.0D;
    this.Kid = -1000.0D;
    this.Kcl = "";
    this.Kie = false;
    this.oQy = "";
    this.Kif = 0;
    this.Kik = true;
    this.Kil = false;
    this.Kim = false;
    this.Kio = 0;
    this.Kip = -1L;
    this.Kiq = -1L;
    this.Kir = -1L;
    this.Kis = -1;
    this.Kix = false;
    this.Kcm = 1;
    this.Kiy = new int[] { 24, 24 };
    this.KiJ = new HashMap();
    this.KiL = new f();
    this.KiM = false;
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(264969);
        if (!paramAnonymousBoolean)
        {
          if ((!c.Q(c.this)) && (!com.tencent.mm.modelgeo.d.bJm()))
          {
            c.R(c.this);
            k.a(c.this.activity, c.this.activity.getString(a.i.gps_disable_tip), c.this.activity.getString(a.i.app_tip), c.this.activity.getString(a.i.jump_to_settings), c.this.activity.getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(264977);
                com.tencent.mm.modelgeo.d.dP(c.this.activity);
                AppMethodBeat.o(264977);
              }
            }, null);
          }
          AppMethodBeat.o(264969);
          return false;
        }
        if (!c.S(c.this))
        {
          AppMethodBeat.o(264969);
          return true;
        }
        String str;
        if ((c.e(c.this) == -85.0D) || (c.f(c.this) == -1000.0D))
        {
          Log.d("MicroMsg.MMPoiMapUI", "init my location.");
          str = (int)(1000000.0F * paramAnonymousFloat2) + "," + (int)(1000000.0F * paramAnonymousFloat1);
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acLH, str);
          c.c(c.this, paramAnonymousFloat2);
          c.d(c.this, paramAnonymousFloat1);
          c.b(c.this).o(c.e(c.this), c.f(c.this));
          c.n(c.this).o(c.e(c.this), c.f(c.this));
          if (c.T(c.this))
          {
            c.U(c.this);
            AppMethodBeat.o(264969);
            return true;
          }
          c.a(c.this, c.e(c.this));
          c.b(c.this, c.f(c.this));
          c.a(c.this).e(c.i(c.this), c.j(c.this), c.this.activity.getIntent().getBooleanExtra("key_geo_coder_four_level", false));
          c.this.KfB.getIController().animateTo(c.e(c.this), c.f(c.this), com.tencent.mm.plugin.location.ui.d.fUQ());
          if (!c.g(c.this)) {
            c.l(c.this);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(264969);
          return true;
          if ((c.e(c.this) != paramAnonymousFloat2) || (c.f(c.this) != paramAnonymousFloat1))
          {
            Log.d("MicroMsg.MMPoiMapUI", "update lat/lng.");
            str = (int)(1000000.0F * paramAnonymousFloat2) + "," + (int)(1000000.0F * paramAnonymousFloat1);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acLH, str);
            c.c(c.this, paramAnonymousFloat2);
            c.d(c.this, paramAnonymousFloat1);
          }
        }
      }
    };
    this.KiN = false;
    this.KiO = false;
    this.KiP = false;
    this.KiQ = false;
    AppMethodBeat.o(56033);
  }
  
  private void F(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(56045);
    String str3;
    String str1;
    String str2;
    if ((this.Kic == -85.0D) || (this.Kid == -1000.0D))
    {
      str3 = "null/null";
      str1 = "";
      if (paramBoolean) {
        break label563;
      }
      if ((paramInt2 < 0) || (paramInt2 >= this.KhT.getCount())) {
        break label614;
      }
      str1 = this.KhT.ZE(paramInt2).KjC;
      str2 = this.KhT.ZE(paramInt2).Kjr;
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
          if (this.KhT.getCount() > 1)
          {
            Log.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str4 = this.KhT.ZE(1).KjC;
          }
        }
      }
      if ((this.KhT.getCount() > 0) && (!paramBoolean)) {
        Log.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", new Object[] { Integer.valueOf(paramInt2) });
      }
      for (str1 = this.KhT.ZE(0).hOG;; str1 = "")
      {
        int i = paramInt2;
        if (paramInt2 == 0)
        {
          i = paramInt2;
          if (!paramBoolean)
          {
            i = paramInt2;
            if (this.KhT.getCount() > 0)
            {
              int j = this.KhT.ZE(0).KjD;
              i = paramInt2;
              if (j >= 0)
              {
                Log.d("MicroMsg.MMPoiMapUI", "change to search index: %s", new Object[] { Integer.valueOf(j) });
                i = j;
              }
            }
          }
        }
        Log.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.Kir), Long.valueOf(this.Kiq), Long.valueOf(this.Kip), Integer.valueOf(this.Kio), str3, Integer.valueOf(this.Kis), str4, str1 });
        com.tencent.mm.plugin.report.service.h.OAn.b(11135, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.Kir), Long.valueOf(this.Kiq), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.Kip), Integer.valueOf(this.Kio), str3, str2, Integer.valueOf(this.Kis), str4, q.eD(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
        AppMethodBeat.o(56045);
        return;
        str3 = String.format("%f/%f", new Object[] { Double.valueOf(this.Kic), Double.valueOf(this.Kid) });
        break;
        label563:
        if ((paramInt2 < 0) || (paramInt2 >= this.KhU.getCount())) {
          break label614;
        }
        str1 = this.KhU.ZE(paramInt2).KjC;
        str2 = this.KhU.ZE(paramInt2).Kjr;
        break label82;
      }
      label614:
      str2 = "";
    }
  }
  
  private void a(final c paramc)
  {
    AppMethodBeat.i(56037);
    if (((c.Kjd == paramc) && (this.Kim)) || ((c.Kjc == paramc) && (!this.Kim)))
    {
      AppMethodBeat.o(56037);
      return;
    }
    if (this.KiA.getVisibility() != 0) {
      this.KiA.setVisibility(0);
    }
    this.Kik = false;
    int i;
    a locala2;
    a locala1;
    if (c.Kjd == paramc)
    {
      Log.d("MicroMsg.MMPoiMapUI", "pennqin play open animation, getListTopMargin(): %d, openedTopMargin: %d.", new Object[] { Integer.valueOf(fVE()), Integer.valueOf(this.Kii) });
      i = fVE() - this.Kii;
      Log.d("MicroMsg.MMPoiMapUI", "pennqin play open animation (getListTopMargin() - openedTopMargin): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(-i);
      locala1 = new a(-this.Kij);
    }
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.KiB });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.KiB, 0 }))
    {
      paramc = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(182057);
          c.f(c.this, true);
          if (c.c.Kjd == paramc)
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
            if ((!c.n(c.this).xts.equals(c.E(c.this))) || (!c.n(c.this).clZ)) {
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
              c.a(c.this, c.n(c.this).dyx);
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
      locala2 = locala2.fVI().fVJ();
      locala2.setAnimationListener(paramc);
      locala2.hX(this.Kig).hX(this.KhW).startAnimation();
      locala1.fVI().fVJ().hX(this.Kin).startAnimation();
      localValueAnimator.setDuration(200L).start();
      AppMethodBeat.o(56037);
      return;
      Log.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation, getListTopMargin(): %d, collapsedTopMargin: %d.", new Object[] { Integer.valueOf(fVE()), Integer.valueOf(this.Kih) });
      i = this.Kih - fVE();
      Log.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation (collapsedTopMargin - getListTopMargin()): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(i);
      locala1 = new a(this.Kij);
    }
  }
  
  private String b(double paramDouble, String paramString)
  {
    AppMethodBeat.i(56042);
    paramString = (int)(paramDouble * 1000000.0D) + "_" + (int)(this.lng * 1000000.0D) + "_" + paramString;
    AppMethodBeat.o(56042);
    return paramString;
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(56055);
    if (c.Kjc == paramc)
    {
      ((FrameLayout.LayoutParams)this.Kig.getLayoutParams()).topMargin = this.Kih;
      ((RelativeLayout.LayoutParams)this.Kin.getLayoutParams()).topMargin = 0;
      ((FrameLayout.LayoutParams)this.KhW.getLayoutParams()).topMargin = (this.Kih - bd.fromDPToPix(this.activity, 92));
      this.KfB.setLogoMargin(this.Kiy);
    }
    for (;;)
    {
      this.Kig.requestLayout();
      this.KhW.requestLayout();
      this.Kin.requestLayout();
      AppMethodBeat.o(56055);
      return;
      if (c.Kjd == paramc)
      {
        ((FrameLayout.LayoutParams)this.Kig.getLayoutParams()).topMargin = this.Kii;
        ((RelativeLayout.LayoutParams)this.Kin.getLayoutParams()).topMargin = (-this.Kij);
        ((FrameLayout.LayoutParams)this.KhW.getLayoutParams()).topMargin = (this.Kii - bd.fromDPToPix(this.activity, 92));
        this.KfB.setLogoMargin(this.Kiz);
      }
    }
  }
  
  private void fVA()
  {
    AppMethodBeat.i(56039);
    this.Kie = false;
    this.KhG.setVisibility(0);
    a(c.Kjc);
    fVF();
    this.oQy = "";
    this.KhS.setVisibility(8);
    this.KhT.notifyDataSetChanged();
    this.KhR.setVisibility(0);
    this.KhV.setVisibility(8);
    this.KhZ.setVisibility(8);
    fVC();
    xY(true);
    this.KhW.setSelected(this.KiM);
    this.KfB.getIController().animateTo(this.lat, this.lng);
    AppMethodBeat.o(56039);
  }
  
  private void fVB()
  {
    AppMethodBeat.i(56043);
    if (this.KhQ.Kjh)
    {
      f localf = this.KhQ.getPoi();
      e locale = this.KhT;
      if (locale.Kjl.size() >= 0)
      {
        locale.Kjl.add(0, localf);
        locale.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(56043);
  }
  
  private void fVC()
  {
    AppMethodBeat.i(56050);
    Iterator localIterator = this.KiJ.values().iterator();
    while (localIterator.hasNext()) {
      ((PoiPoint)localIterator.next()).remove();
    }
    this.KiJ.clear();
    this.KiI = null;
    AppMethodBeat.o(56050);
  }
  
  private void fVD()
  {
    AppMethodBeat.i(56051);
    Object localObject = new ArrayList(5);
    int i = 0;
    while ((i < 5) && (i < this.KhU.getCount()))
    {
      ((List)localObject).add(this.KhU.ZE(i));
      i += 1;
    }
    localObject = iN((List)localObject);
    fVC();
    i = 0;
    while (i < ((List)localObject).size())
    {
      f localf = this.KhU.ZE(i);
      PoiPoint localPoiPoint = new PoiPoint(this.activity, this.KfB);
      localPoiPoint.setPosition(i);
      localPoiPoint.setOnPointClick(this.KeT);
      this.KiJ.put(localf.HHO + localf.HHN, localPoiPoint);
      localPoiPoint.d(localf.HHO, localf.HHN, false);
      i += 1;
    }
    iO((List)localObject);
    AppMethodBeat.o(56051);
  }
  
  private int fVE()
  {
    AppMethodBeat.i(56056);
    int i = ((ViewGroup.MarginLayoutParams)this.Kig.getLayoutParams()).topMargin;
    AppMethodBeat.o(56056);
    return i;
  }
  
  private void fVF()
  {
    AppMethodBeat.i(56057);
    if (this.Kie)
    {
      this.KiC.setVisibility(8);
      this.KiD.setVisibility(0);
      this.KiG.setVisibility(0);
      AppMethodBeat.o(56057);
      return;
    }
    this.KiC.setVisibility(0);
    this.KiD.setVisibility(8);
    this.KiG.setVisibility(8);
    AppMethodBeat.o(56057);
  }
  
  private void fVG()
  {
    AppMethodBeat.i(56058);
    if (!this.KiO)
    {
      this.KiO = true;
      this.KiE.requestFocus();
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
  
  private boolean fVz()
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
  
  private static List<f> iN(List<f> paramList)
  {
    AppMethodBeat.i(56052);
    ArrayList localArrayList = new ArrayList(5);
    int i = 0;
    if (i < paramList.size())
    {
      if (i == 0) {
        localArrayList.add((f)paramList.get(0));
      }
      for (;;)
      {
        i += 1;
        break;
        f localf1 = (f)paramList.get(i);
        f localf2 = (f)localArrayList.get(localArrayList.size() - 1);
        if (TencentLocationUtils.distanceBetween(localf1.HHO, localf1.HHN, localf2.HHO, localf2.HHN) > 5000.0D) {
          break label124;
        }
        localArrayList.add(localf1);
      }
    }
    label124:
    AppMethodBeat.o(56052);
    return localArrayList;
  }
  
  private void iO(List<f> paramList)
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
      this.KfB.getIController().animateTo(((f)paramList.get(0)).HHO, ((f)paramList.get(0)).HHN);
      AppMethodBeat.o(56053);
      return;
    }
    ArrayList localArrayList = new ArrayList(5);
    while (i < paramList.size())
    {
      f localf = (f)paramList.get(i);
      localArrayList.add(new LatLng(localf.HHO, localf.HHN));
      i += 1;
    }
    paramList = LatLngBounds.builder().include(localArrayList).build();
    if ((Double.isInfinite(paramList.getNortheast().getLatitude())) || (Double.isNaN(paramList.getNortheast().getLongitude())) || (Double.isInfinite(paramList.getSouthwest().getLatitude())) || (Double.isNaN(paramList.getSouthwest().getLongitude())))
    {
      AppMethodBeat.o(56053);
      return;
    }
    this.KfB.animateCamera(CameraUpdateFactory.newLatLngBounds(paramList, 250));
    AppMethodBeat.o(56053);
  }
  
  private void wq(boolean paramBoolean)
  {
    AppMethodBeat.i(56044);
    Log.d("MicroMsg.MMPoiMapUI", "stack: %s", new Object[] { Util.getStack() });
    this.Kcl = b(this.lat, this.oQy);
    if (this.Kcl.equals(this.KhT.key))
    {
      Log.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[] { this.Kcl });
      AppMethodBeat.o(56044);
      return;
    }
    byte[] arrayOfByte = null;
    int i = 1;
    this.KhV.setVisibility(0);
    label185:
    double d1;
    double d2;
    if (this.Kie) {
      if ((this.Kcm > 0) && (paramBoolean))
      {
        this.KhS.jmt();
        this.KhU.fVK();
        this.KhU.aKo(this.Kcl);
        this.KhU.xts = this.oQy;
        this.KhU.clZ = false;
        arrayOfByte = this.KhU.buffer;
        if (i == 0) {
          break label436;
        }
        if (this.Kif != 0) {
          break label424;
        }
        i = 0;
        d1 = this.lat;
        d2 = this.lng;
        if (!this.Kie) {
          break label430;
        }
      }
    }
    label424:
    label430:
    for (int j = 0;; j = 1)
    {
      this.KhX = new i(arrayOfByte, d1, d2, i, j, this.Kid, this.Kic, this.Kcl, this.oQy, paramBoolean);
      com.tencent.mm.kernel.h.aZW().a(this.KhX, 0);
      this.Kio += 1;
      if (this.Kir == -1L) {
        this.Kir = System.currentTimeMillis();
      }
      AppMethodBeat.o(56044);
      return;
      if (!paramBoolean)
      {
        this.KhS.jmt();
        this.KhU.clean();
        this.KhU.aKo(this.Kcl);
        this.KhU.xts = this.oQy;
        this.KhU.clZ = false;
        arrayOfByte = this.KhU.buffer;
        this.KhU.notifyDataSetChanged();
        break;
      }
      i = 0;
      this.KhU.clZ = false;
      break;
      this.KhR.jmt();
      this.KhT.clean();
      this.KhT.aKo(this.Kcl);
      this.KhT.notifyDataSetChanged();
      arrayOfByte = this.KhT.buffer;
      xY(false);
      fVB();
      break;
      i = 1;
      break label185;
    }
    label436:
    Log.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", new Object[] { Integer.valueOf(this.Kcm) });
    AppMethodBeat.o(56044);
  }
  
  private void xY(boolean paramBoolean)
  {
    AppMethodBeat.i(56048);
    Log.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.JkC.setEnabled(paramBoolean);
    this.KhY.setEnabled(paramBoolean);
    AppMethodBeat.o(56048);
  }
  
  public final void c(LatLng paramLatLng)
  {
    AppMethodBeat.i(265379);
    if (this.KhW.isSelected()) {
      this.KhW.setSelected(false);
    }
    if (!this.Kie)
    {
      this.KhQ.play();
      this.lat = paramLatLng.getLatitude();
      this.lng = paramLatLng.getLongitude();
      this.KhQ.e(this.lat, this.lng, this.activity.getIntent().getBooleanExtra("key_geo_coder_four_level", false));
      this.KhW.setSelected(false);
      if (this.Kim) {
        a(c.Kjc);
      }
      wq(false);
      this.Kix = false;
      g.c.KjQ.KjE = 0;
      g.c.KjQ.a(g.b.KjM);
      ((SoSoMapView)this.KfB).announceForAccessibility(getString(a.i.location_selected_accessibility));
    }
    ((SoSoMapView)this.KfB).getIController().animateTo(this.lat, this.lng);
    AppMethodBeat.o(265379);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(56038);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent, back.");
      g.c.KjQ.a(g.a.KjH);
      if (this.Kie)
      {
        fVA();
        F(Kiw, this.KhU.dyx, true);
        AppMethodBeat.o(56038);
        return false;
      }
      F(Kiu, this.KhT.dyx, false);
      this.activity.finish();
      AppMethodBeat.o(56038);
      return true;
    }
    AppMethodBeat.o(56038);
    return false;
  }
  
  public final SoSoMapView fVw()
  {
    return (SoSoMapView)this.KfB;
  }
  
  public final void fVx()
  {
    AppMethodBeat.i(56040);
    a(c.Kjc);
    AppMethodBeat.o(56040);
  }
  
  public final void fVy()
  {
    AppMethodBeat.i(56041);
    if (this.KhW.isSelected()) {
      this.KhW.setSelected(false);
    }
    if (!this.Kie)
    {
      this.KhQ.play();
      this.lat = (this.KfB.getMapCenterX() / 1000000.0D);
      this.lng = (this.KfB.getMapCenterY() / 1000000.0D);
      this.KhQ.e(this.lat, this.lng, this.activity.getIntent().getBooleanExtra("key_geo_coder_four_level", false));
      this.KhW.setSelected(false);
      if (this.Kim) {
        a(c.Kjc);
      }
      wq(false);
      this.Kix = false;
      g.c.KjQ.KjE = 0;
      g.c.KjQ.a(g.b.KjM);
    }
    AppMethodBeat.o(56041);
  }
  
  public final int getLayoutId()
  {
    return a.f.poi_gmap_ui;
  }
  
  public final void onBusinessPermissionDenied(String paramString)
  {
    AppMethodBeat.i(265406);
    this.activity.finish();
    AppMethodBeat.o(265406);
  }
  
  public final void onBusinessPermissionGranted(String paramString)
  {
    AppMethodBeat.i(265403);
    this.activity.recreate();
    AppMethodBeat.o(265403);
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
    com.tencent.mm.kernel.h.aZW().a(457, this);
    this.Kis = ((int)(System.currentTimeMillis() / 1000L));
    this.KfB.setCanRotate(false);
    label216:
    int j;
    if (aw.isDarkMode())
    {
      ((SoSoMapView)this.KfB).enableDarkMode();
      this.Kia = ((LinearLayout)findViewById(a.e.header_bar));
      ((TextView)findViewById(a.e.btn_back_txt)).setText(a.i.app_cancel);
      this.CxW = findViewById(a.e.title_bar_btn_back_area);
      this.CxW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56013);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          g.c.KjQ.a(g.a.KjH);
          c.a(c.this, c.Kiu, c.b(c.this).dyx, false);
          c.c(c.this);
          c.this.activity.finish();
          a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(56013);
        }
      });
      this.CxW.setVisibility(0);
      this.JkC = findViewById(a.e.title_bar_btn_send_area);
      this.KhY = findViewById(a.e.btn_send_txt);
      switch (this.type)
      {
      default: 
        this.JkC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(56018);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            g.c.KjQ.a(g.a.KjG);
            c.d(c.this);
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(56018);
          }
        });
        this.JkC.setVisibility(0);
        xY(false);
        this.Kig = ((RelativeLayout)findViewById(a.e.location_list_rl));
        this.KhR = ((MMLoadMoreListView)this.activity.findViewById(a.e.poi_list));
        this.KhS = ((MMLoadMoreListView)this.activity.findViewById(a.e.search_list));
        this.KhV = findViewById(a.e.loading);
        this.KhZ = ((TextView)findViewById(a.e.search_empty));
        this.KhP = ((PoiHeaderView)findViewById(a.e.poi_header));
        this.Kin = ((FrameLayout)findViewById(a.e.mapview_fl));
        this.KhW = ((ImageButton)findViewById(a.e.locate_to_my_position));
        this.KhW.setSelected(true);
        this.KhW.setContentDescription(getString(a.i.locate_to_my_pos));
        this.KhW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182066);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
              c.this.KfB.getIController().animateTo(c.e(c.this), c.f(c.this));
              c.h(c.this).setSelected(true);
              c.a(c.this, c.c.Kjc);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182066);
              return;
              c.this.KfB.getIController().animateTo(c.e(c.this), c.f(c.this));
              c.a(c.this, c.e(c.this));
              c.b(c.this, c.f(c.this));
              c.a(c.this).e(c.i(c.this), c.j(c.this), c.this.activity.getIntent().getBooleanExtra("key_geo_coder_four_level", false));
              c.h(c.this).setSelected(true);
              c.a(c.this, false);
              c.b(c.this).dyx = 0;
              c.k(c.this).setSelection(0);
              g.c.KjQ.KjE = 0;
              g.c.KjQ.a(g.b.KjO);
              c.l(c.this);
            }
          }
        });
        this.KfB.setBuiltInZoomControls(false);
        this.KhG = ((FrameLayout)findViewById(a.e.control_id));
        this.Kib = new MyPoiPoint(this.activity, this.KfB);
        this.KhQ = new PickPoi(this.activity);
        this.KhQ.setOnCurPoiGet(new b()
        {
          public final void a(f paramAnonymousf)
          {
            AppMethodBeat.i(182067);
            c.a(c.this).setOnCurPoiGet(null);
            if (paramAnonymousf != null)
            {
              c.m(c.this).d(paramAnonymousf.KjB);
              if (c.b(c.this) != null)
              {
                c.b(c.this).jU(c.m(c.this).Kju, c.m(c.this).Kjv);
                c.n(c.this).jU(c.m(c.this).Kju, c.m(c.this).Kjv);
              }
            }
            AppMethodBeat.o(182067);
          }
        });
        this.KhG.addView(this.KhQ);
        paramBundle = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acLH, "");
        if ((!Util.isNullOrNil(paramBundle)) && ((this.Kic == -85.0D) || (this.Kid == -1000.0D)))
        {
          String[] arrayOfString = paramBundle.split(",");
          Log.i("MicroMsg.MMPoiMapUI", "last locationInfo ".concat(String.valueOf(paramBundle)));
          if (arrayOfString.length == 2)
          {
            float f1 = (float)(Util.safeParseInt(arrayOfString[0]) * 1.0D / 1000000.0D);
            float f2 = (float)(Util.safeParseInt(arrayOfString[1]) * 1.0D / 1000000.0D);
            this.KfB.getIController().animateTo(f1, f2);
          }
        }
        this.KiH = new View.OnTouchListener()
        {
          private float KiX;
          private short KiY = 0;
          
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
              this.KiX = paramAnonymousMotionEvent.getRawY();
              c.b(c.this, false);
              continue;
              Log.d("MicroMsg.MMPoiMapUI", "newpoi action move %s.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
              if (c.p(c.this))
              {
                Log.d("MicroMsg.MMPoiMapUI", "newpoi blocked.");
                c.k(c.this).setSelection(0);
              }
              float f = this.KiX - paramAnonymousMotionEvent.getRawY();
              if (Math.abs(f) < BackwardSupportUtil.BitmapFactory.fromDPToPix(c.this.activity, 20.0F)) {
                this.KiY = 0;
              }
              while (((c.q(c.this)) && (this.KiY == 1)) || ((c.r(c.this)) && (this.KiY == -1)) || ((c.q(c.this)) && (!c.s(c.this).getScroll2Top()) && (this.KiY == -1)))
              {
                AppMethodBeat.o(182068);
                return false;
                if (f > 0.0F) {
                  this.KiY = 1;
                } else {
                  this.KiY = -1;
                }
              }
              if ((c.o(c.this)) && (this.KiY != 0))
              {
                Log.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[] { Short.valueOf(this.KiY) });
                if (this.KiY == 1)
                {
                  c.c(c.this, true);
                  c.a(c.this, c.c.Kjd);
                  AppMethodBeat.o(182068);
                  return false;
                }
                c.a(c.this, c.c.Kjc);
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
        this.KhR.setOnTouchListener(this.KiH);
        this.KhR.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void onLoadMore()
          {
            AppMethodBeat.i(182069);
            c.t(c.this);
            AppMethodBeat.o(182069);
          }
        });
        this.KhR.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182070);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousAdapterView);
            localb.cH(paramAnonymousView);
            localb.sc(paramAnonymousInt);
            localb.hB(paramAnonymousLong);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
            Log.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= c.b(c.this).getCount()))
            {
              Log.i("MicroMsg.MMPoiMapUI", "wrong position");
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182070);
              return;
            }
            paramAnonymousAdapterView = c.b(c.this).ZE(paramAnonymousInt);
            if (paramAnonymousAdapterView.type == 0) {
              c.h(c.this).setSelected(false);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView.HHO);
              c.b(c.this, paramAnonymousAdapterView.HHN);
              c.this.KfB.getIController().animateTo(paramAnonymousAdapterView.HHO, paramAnonymousAdapterView.HHN);
              if (c.this.activity.getIntent().getBooleanExtra("key_geo_coder_four_level", false)) {
                com.tencent.mm.modelgeo.c.bJh().a(c.i(c.this), c.j(c.this), new com.tencent.mm.modelgeo.c.a()
                {
                  public final void b(Addr paramAnonymous2Addr)
                  {
                    AppMethodBeat.i(264979);
                    com.tencent.mm.modelgeo.c.bJh().a(this);
                    paramAnonymousAdapterView.KjB.oDQ = paramAnonymous2Addr.oDQ;
                    AppMethodBeat.o(264979);
                  }
                }, null, true);
              }
              c.b(c.this).dyx = paramAnonymousInt;
              c.b(c.this).notifyDataSetChanged();
              c.a(c.this, false);
              c.this.fVw().announceForAccessibility(c.this.getString(a.i.location_selected_accessibility));
              g.c.KjQ.KjE = (paramAnonymousInt + 1);
              g.c.KjQ.a(g.b.KjN);
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182070);
              return;
              c.h(c.this).setSelected(true);
            }
          }
        });
        this.KhT = new e(this.activity);
        this.KhR.setAdapter(this.KhT);
        this.KhQ.setAdapter(this.KhT);
        this.KeT = new PoiPoint.a()
        {
          public final void a(PoiPoint.b paramAnonymousb, PoiPoint paramAnonymousPoiPoint)
          {
            AppMethodBeat.i(182071);
            if (PoiPoint.b.KeW == paramAnonymousb)
            {
              if (-1 == c.n(c.this).dyx) {
                c.d(c.this, true);
              }
              if (c.u(c.this) != null) {
                c.u(c.this).fUU();
              }
              c.this.KfB.getIController().animateTo(paramAnonymousPoiPoint.getLat(), paramAnonymousPoiPoint.getLng());
              c.a(c.this, paramAnonymousPoiPoint);
              paramAnonymousPoiPoint.fUV();
              c.a(c.this, paramAnonymousPoiPoint.getPosition());
              c.n(c.this).dyx = paramAnonymousPoiPoint.getPosition();
              c.n(c.this).notifyDataSetChanged();
              g.c.KjQ.KjE = (paramAnonymousPoiPoint.getPosition() + 1);
              g.c.KjQ.a(g.b.KjL);
              AppMethodBeat.o(182071);
              return;
            }
            paramAnonymousb = PoiPoint.b.KeV;
            AppMethodBeat.o(182071);
          }
        };
        this.KhU = new e(this.activity);
        this.KhU.pVy = true;
        this.KhU.dyx = -1;
        this.KhS.setAdapter(this.KhU);
        this.KhS.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void onLoadMore()
          {
            AppMethodBeat.i(182051);
            c.t(c.this);
            AppMethodBeat.o(182051);
          }
        });
        this.KhS.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182052);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousAdapterView);
            localb.cH(paramAnonymousView);
            localb.sc(paramAnonymousInt);
            localb.hB(paramAnonymousLong);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
            if (-1 == c.n(c.this).dyx)
            {
              c.d(c.this, true);
              c.a(c.this, c.c.Kjc);
            }
            c.n(c.this).dyx = paramAnonymousInt;
            c.n(c.this).notifyDataSetChanged();
            if ((paramAnonymousInt >= 0) && (paramAnonymousInt < c.n(c.this).getCount()))
            {
              c.a(c.this, true);
              if (c.u(c.this) != null) {
                c.u(c.this).fUU();
              }
              paramAnonymousView = c.n(c.this).ZE(paramAnonymousInt);
              if ((paramAnonymousView.HHO == c.e(c.this)) && (paramAnonymousView.HHN == c.f(c.this))) {
                break label457;
              }
              c.h(c.this).setSelected(false);
              c.this.KfB.getIController().animateTo(paramAnonymousView.HHO, paramAnonymousView.HHN);
              if (c.this.activity.getIntent().getBooleanExtra("key_geo_coder_four_level", false)) {
                com.tencent.mm.modelgeo.c.bJh().a(paramAnonymousView.HHO, paramAnonymousView.HHN, new com.tencent.mm.modelgeo.c.a()
                {
                  public final void b(Addr paramAnonymous2Addr)
                  {
                    AppMethodBeat.i(264992);
                    com.tencent.mm.modelgeo.c.bJh().a(this);
                    paramAnonymousView.KjB.oDQ = paramAnonymous2Addr.oDQ;
                    AppMethodBeat.o(264992);
                  }
                }, null, true);
              }
              paramAnonymousAdapterView = (PoiPoint)c.v(c.this).get(paramAnonymousView.HHO + paramAnonymousView.HHN);
              if (paramAnonymousAdapterView != null) {
                break label471;
              }
              paramAnonymousAdapterView = new PoiPoint(c.this.activity, c.this.KfB);
              paramAnonymousAdapterView.setPosition(paramAnonymousInt);
              paramAnonymousAdapterView.setOnPointClick(c.this.KeT);
              c.v(c.this).put(paramAnonymousView.HHO + paramAnonymousView.HHN, paramAnonymousAdapterView);
              paramAnonymousAdapterView.d(paramAnonymousView.HHO, paramAnonymousView.HHN, true);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView);
              g.c.KjQ.KjE = (paramAnonymousInt + 1);
              g.c.KjQ.a(g.b.KjK);
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182052);
              return;
              label457:
              c.h(c.this).setSelected(true);
              break;
              label471:
              paramAnonymousAdapterView.fUV();
            }
          }
        });
        this.KhS.setOnTouchListener(this.KiH);
        this.KiC = findViewById(a.e.send_loc_search_hint);
        this.KiD = findViewById(a.e.send_loc_search_ing);
        this.KiE = ((EditText)findViewById(a.e.send_loc_search_edt));
        this.KiF = ((ImageView)findViewById(a.e.send_loc_search_reset));
        this.KiG = findViewById(a.e.send_loc_search_cancel);
        this.KiC.setOnClickListener(new c.9(this));
        this.KiG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182059);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            c.a(c.this, c.fVH(), c.n(c.this).dyx, true);
            c.y(c.this);
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(182059);
          }
        });
        this.KiE.setOnTouchListener(new View.OnTouchListener()
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
                c.a(c.this, c.c.Kjd);
              }
            }
          }
        });
        this.Kig.setClickable(true);
        this.KiE.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(182061);
            if (3 == paramAnonymousInt)
            {
              c.a(c.this, c.c.Kjc);
              c.h(c.this, true);
            }
            AppMethodBeat.o(182061);
            return false;
          }
        });
        this.KiE.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(182062);
            Log.d("MicroMsg.MMPoiMapUI", "searchText: %s.", new Object[] { paramAnonymousCharSequence });
            c.a(c.this, paramAnonymousCharSequence.toString());
            c.J(c.this).jmt();
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
        this.KiF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182063);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            c.P(c.this).setText("");
            c.A(c.this);
            if (c.o(c.this)) {
              c.a(c.this, c.c.Kjd);
            }
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(182063);
          }
        });
        fVF();
        this.KiA = findViewById(a.e.send_loc_collapse_layout);
        this.KiA.post(new Runnable()
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
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (c.n(c.this).getCount() == 0) {
              c.y(c.this);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182054);
              return;
              c.a(c.this, c.c.Kjc);
            }
          }
        });
        this.KiR = ((InputPanelFrameLayout)findViewById(a.e.poi_map_fl));
        this.KiR.setExternalListener(new c.6(this));
        paramBundle = aw.bf(this.activity);
        j = Math.max(paramBundle.x, paramBundle.y);
        this.Kih = (j - BackwardSupportUtil.BitmapFactory.fromDPToPix(this.activity, 320.0F));
        this.Kii = ((int)(j * 0.25F + 0.5D));
        this.Kij = ((int)((this.Kih - this.Kii) / 3.0D + 0.5D));
        Log.i("MicroMsg.MMPoiMapUI", "collapsedTopMargin: %d, openedTopMargin: %d, mapViewTopMargin: %d.", new Object[] { Integer.valueOf(this.Kih), Integer.valueOf(this.Kii), Integer.valueOf(this.Kij) });
        this.Kiz = new int[] { this.Kih - this.Kii - this.Kij + 24, 24 };
        i = this.activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i <= 0) {
          break;
        }
      }
    }
    for (int i = this.activity.getResources().getDimensionPixelSize(i);; i = 0)
    {
      paramBundle = (FrameLayout.LayoutParams)this.Kia.getLayoutParams();
      paramBundle.height += i * 2;
      this.Kia.setLayoutParams(paramBundle);
      this.Kia.setPadding(0, i, 0, i);
      if (bf.bg(this.activity))
      {
        i = bf.bk(this.activity);
        label1288:
        j = j - this.Kii - i;
        Log.i("MicroMsg.MMPoiMapUI", "reset poi view height: %s, navigationBarHeight: %s.", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramBundle = this.Kig.getLayoutParams();
        paramBundle.height = j;
        this.Kig.setLayoutParams(paramBundle);
        paramBundle = (RelativeLayout.LayoutParams)this.Kin.getLayoutParams();
        paramBundle.height = this.Kih;
        this.Kin.setLayoutParams(paramBundle);
        b(c.Kjc);
        if ((this.type != 0) && (this.type != 8)) {
          break label1559;
        }
        g.c.KjQ.setScene(this.activity.getIntent().getIntExtra("type_tag", 0));
      }
      for (;;)
      {
        this.KhQ.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
        ((SoSoMapView)this.KfB).disableDarkMode();
        break;
        ((TextView)findViewById(a.e.btn_send_txt)).setText(a.i.location_send);
        break label216;
        ((TextView)findViewById(a.e.btn_send_txt)).setText(a.i.app_nextstep);
        break label216;
        if (this.activity.getIntent().getIntExtra("type_pick_location_btn", 1) == 2)
        {
          ((TextView)findViewById(a.e.btn_send_txt)).setText(a.i.app_add);
          break label216;
        }
        ((TextView)findViewById(a.e.btn_send_txt)).setText(a.i.app_finish);
        break label216;
        i = 0;
        break label1288;
        label1559:
        g.c.KjQ.setScene(this.type);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56049);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(457, this);
    AppMethodBeat.o(56049);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56047);
    super.onPause();
    this.KiN = false;
    com.tencent.mm.modelgeo.d.bJl().a(this.lsF);
    MyPoiPoint localMyPoiPoint = this.Kib;
    Log.d("MicroMsg.MyPoiPoint", "disableLocation");
    localMyPoiPoint.Ken.a(localMyPoiPoint.lsF);
    AppMethodBeat.o(56047);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56046);
    super.onResume();
    this.KiN = true;
    if (!((com.tencent.mm.sensitive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.sensitive.d.class)).checkAndShowPermissionDialog(d.c.actu, new d.f()
    {
      public final void onOp(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(264980);
        if (paramAnonymousBoolean.booleanValue())
        {
          c.this.onBusinessPermissionGranted(d.c.actu.value);
          AppMethodBeat.o(264980);
          return;
        }
        c.this.onBusinessPermissionDenied(d.c.actu.value);
        AppMethodBeat.o(264980);
      }
    })) {
      com.tencent.mm.modelgeo.d.bJl().a(this.lsF, true);
    }
    this.Kib.fUT();
    AppMethodBeat.o(56046);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(56054);
    if (paramp.getType() == 457)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(56054);
        return;
      }
      this.KhX = null;
      i locali = (i)paramp;
      if (!locali.Kcl.equals(this.Kcl))
      {
        Log.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.Kcl + " " + locali.Kcl);
        AppMethodBeat.o(56054);
        return;
      }
      Log.i("MicroMsg.MMPoiMapUI", "isEnd: " + locali.nxG + " searchId: " + locali.mpa + " isInSearch: " + this.Kie);
      if (this.Kip == -1L)
      {
        long l = System.currentTimeMillis();
        this.Kiq = l;
        this.Kip = l;
      }
      for (;;)
      {
        this.Kcm = locali.Kcm;
        this.KhV.setVisibility(8);
        if (!this.Kie) {
          break label419;
        }
        if (!Util.isNullOrNil(this.oQy)) {
          break;
        }
        AppMethodBeat.o(56054);
        return;
        this.Kiq = System.currentTimeMillis();
      }
      if ((locali.list != null) && (locali.list.size() == 0))
      {
        this.KhZ.setVisibility(0);
        this.KhS.jmt();
      }
      Log.d("MicroMsg.MMPoiMapUI", "search is first: %s", new Object[] { Boolean.valueOf(locali.isFirst()) });
      if (locali.isFirst())
      {
        this.KhU.clZ = true;
        this.KhU.Kjl.clear();
      }
      this.KhU.a(locali.list, locali.Kck, locali.nxG, locali.Kcl);
      if (!this.KhU.nxG)
      {
        this.KhS.jms();
        this.KhS.jmu();
      }
      while (this.KiK)
      {
        this.KiK = false;
        fVD();
        AppMethodBeat.o(56054);
        return;
        this.KhS.jmt();
        this.KhS.jmv();
      }
      label419:
      Object localObject2;
      Object localObject1;
      if (this.KhP != null)
      {
        localObject2 = (cpc)com.tencent.mm.am.c.c.b(locali.rr.otC);
        paramp = this.KhP;
        localObject1 = ((cpc)localObject2).YRE;
        paramString = ((cpc)localObject2).aauc;
        String str = ((cpc)localObject2).Url;
        localObject2 = com.tencent.mm.plugin.image.d.bzL();
        Log.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[] { paramString, str });
        paramp.Kez = str;
        paramp.KeA = "";
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(paramString))) {
          break label629;
        }
        paramp.setVisibility(8);
        paramp.lKQ.setVisibility(8);
        paramp.KeB.setVisibility(8);
      }
      for (;;)
      {
        xY(true);
        this.KhT.a(locali.list, locali.Kck, locali.nxG, locali.Kcl);
        this.KhT.dyx = 0;
        this.KhT.notifyDataSetChanged();
        if (this.KhT.nxG) {
          break;
        }
        this.KhR.jms();
        this.KhR.jmu();
        AppMethodBeat.o(56054);
        return;
        label629:
        paramp.setVisibility(0);
        paramp.lKQ.setVisibility(0);
        paramp.KeB.setVisibility(0);
        paramp.lKQ.setText((CharSequence)localObject1);
        localObject1 = paramp.KeB;
        ((SimpleImageView)localObject1).imagePath = ((String)localObject2);
        ((SimpleImageView)localObject1).url = paramString;
        ((SimpleImageView)localObject1).nxO = 0;
        ((SimpleImageView)localObject1).nxP = 0;
        if ((paramString == null) || (paramString.length() == 0))
        {
          ((SimpleImageView)localObject1).setVisibility(8);
        }
        else if (paramString.startsWith("http"))
        {
          paramp = MMBitmapFactory.decodeFile(((SimpleImageView)localObject1).imagePath + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
          if (paramp != null)
          {
            paramString = paramp;
            if (((SimpleImageView)localObject1).nxO > 0)
            {
              paramString = paramp;
              if (((SimpleImageView)localObject1).nxP > 0) {
                paramString = BitmapUtil.extractThumbNail(paramp, ((SimpleImageView)localObject1).nxO, ((SimpleImageView)localObject1).nxP, true, false);
              }
            }
            ((SimpleImageView)localObject1).setImageBitmap(paramString);
          }
          else
          {
            ThreadPool.post(new SimpleImageView.a(paramString, ((SimpleImageView)localObject1).handler), "SimpleImageView_download");
          }
        }
        else if (!y.ZC(paramString))
        {
          ((SimpleImageView)localObject1).setVisibility(8);
        }
        else
        {
          if ((((SimpleImageView)localObject1).nxO <= 0) || (((SimpleImageView)localObject1).nxP <= 0)) {}
          for (paramString = BitmapUtil.getBitmapNative(paramString);; paramString = BitmapUtil.extractThumbNail(paramString, ((SimpleImageView)localObject1).nxO, ((SimpleImageView)localObject1).nxP, true))
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
      this.KhR.jmt();
      this.KhR.jmv();
    }
    AppMethodBeat.o(56054);
  }
  
  final class a
    extends TranslateAnimation
  {
    private List<View> Kjb;
    
    public a(float paramFloat)
    {
      super(0.0F, 0.0F, paramFloat);
      AppMethodBeat.i(56025);
      this.Kjb = new ArrayList();
      AppMethodBeat.o(56025);
    }
    
    public final a fVI()
    {
      AppMethodBeat.i(56026);
      setDuration(200L);
      AppMethodBeat.o(56026);
      return this;
    }
    
    public final a fVJ()
    {
      AppMethodBeat.i(56027);
      setFillEnabled(true);
      setFillAfter(true);
      AppMethodBeat.o(56027);
      return this;
    }
    
    public final a hX(View paramView)
    {
      AppMethodBeat.i(56028);
      this.Kjb.add(paramView);
      AppMethodBeat.o(56028);
      return this;
    }
    
    public final void startAnimation()
    {
      AppMethodBeat.i(56029);
      int i = 0;
      while (i < this.Kjb.size())
      {
        ((View)this.Kjb.get(i)).startAnimation(this);
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
      Kjc = new c("COLLAPSED", 0);
      Kjd = new c("OPENED", 1);
      Kje = new c[] { Kjc, Kjd };
      AppMethodBeat.o(56032);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c
 * JD-Core Version:    0.7.0.1
 */