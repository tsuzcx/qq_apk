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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.location.ui.MyPoiPoint;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.PoiPoint;
import com.tencent.mm.plugin.location.ui.PoiPoint.a;
import com.tencent.mm.plugin.location.ui.PoiPoint.b;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.SimpleImageView.a;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.vfs.s;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
  extends b
  implements com.tencent.mm.ak.i
{
  private static int yLT = 11;
  private static int yLU = 12;
  private static int yLV = 13;
  private static int yLW = 14;
  private com.tencent.mm.modelgeo.b.a gmA;
  private String jgR;
  private double lat;
  private double lng;
  private boolean uSu;
  private View uvi;
  private String yFJ;
  private int yFK;
  PoiPoint.a yIr;
  private LinearLayout yLA;
  private MyPoiPoint yLB;
  private double yLC;
  private double yLD;
  private boolean yLE;
  private int yLF;
  private RelativeLayout yLG;
  private int yLH;
  private int yLI;
  private int yLJ;
  private boolean yLK;
  private boolean yLL;
  private boolean yLM;
  private FrameLayout yLN;
  private int yLO;
  private long yLP;
  private long yLQ;
  private long yLR;
  private int yLS;
  private boolean yLX;
  private int[] yLY;
  private int[] yLZ;
  private FrameLayout yLg;
  private PoiHeaderView yLp;
  private PickPoi yLq;
  private MMLoadMoreListView yLr;
  private MMLoadMoreListView yLs;
  private e yLt;
  private e yLu;
  private View yLv;
  private ImageButton yLw;
  private com.tencent.mm.plugin.location.model.i yLx;
  private View yLy;
  private TextView yLz;
  private View yMa;
  private int yMb;
  private View yMc;
  private View yMd;
  private EditText yMe;
  private ImageView yMf;
  private View yMg;
  private View.OnTouchListener yMh;
  private PoiPoint yMi;
  private Map<String, PoiPoint> yMj;
  private boolean yMk;
  private f yMl;
  private boolean yMm;
  private boolean yMn;
  private boolean yMo;
  private boolean yMp;
  private boolean yMq;
  private InputPanelFrameLayout yMr;
  private View ygS;
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(56033);
    this.yLx = null;
    this.lat = -85.0D;
    this.lng = -1000.0D;
    this.yLC = -85.0D;
    this.yLD = -1000.0D;
    this.yFJ = "";
    this.yLE = false;
    this.jgR = "";
    this.yLF = 0;
    this.yLK = true;
    this.yLL = false;
    this.yLM = false;
    this.yLO = 0;
    this.yLP = -1L;
    this.yLQ = -1L;
    this.yLR = -1L;
    this.yLS = -1;
    this.yLX = false;
    this.yFK = 1;
    this.yLY = new int[] { 24, 24 };
    this.yMj = new HashMap();
    this.yMl = new f();
    this.yMm = false;
    this.gmA = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(182065);
        if (!paramAnonymousBoolean)
        {
          if ((!c.Q(c.this)) && (!com.tencent.mm.modelgeo.d.bcc()))
          {
            c.R(c.this);
            com.tencent.mm.ui.base.h.a(c.this.activity, c.this.activity.getString(2131761461), c.this.activity.getString(2131755998), c.this.activity.getString(2131762043), c.this.activity.getString(2131755761), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(182064);
                com.tencent.mm.modelgeo.d.cZ(c.this.activity);
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
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NWn, str);
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
          c.this.yJa.getIController().animateTo(c.e(c.this), c.f(c.this), com.tencent.mm.plugin.location.ui.d.ede());
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
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NWn, str);
            c.c(c.this, paramAnonymousFloat2);
            c.d(c.this, paramAnonymousFloat1);
          }
        }
      }
    };
    this.yMn = false;
    this.yMo = false;
    this.yMp = false;
    this.yMq = false;
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
    if (((c.yMz == paramc) && (this.yLM)) || ((c.yMy == paramc) && (!this.yLM)))
    {
      AppMethodBeat.o(56037);
      return;
    }
    if (this.yMa.getVisibility() != 0) {
      this.yMa.setVisibility(0);
    }
    this.yLK = false;
    int i;
    a locala2;
    a locala1;
    if (c.yMz == paramc)
    {
      Log.d("MicroMsg.MMPoiMapUI", "pennqin play open animation, getListTopMargin(): %d, openedTopMargin: %d.", new Object[] { Integer.valueOf(edQ()), Integer.valueOf(this.yLI) });
      i = edQ() - this.yLI;
      Log.d("MicroMsg.MMPoiMapUI", "pennqin play open animation (getListTopMargin() - openedTopMargin): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(-i);
      locala1 = new a(-this.yLJ);
    }
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.yMb });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.yMb, 0 }))
    {
      paramc = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(182057);
          c.f(c.this, true);
          if (c.c.yMz == paramc)
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
            if ((!c.n(c.this).qLO.equals(c.E(c.this))) || (!c.n(c.this).daZ)) {
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
              c.a(c.this, c.n(c.this).va);
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
      locala2 = locala2.edU().edV();
      locala2.setAnimationListener(paramc);
      locala2.en(this.yLG).en(this.yLw).startAnimation();
      locala1.edU().edV().en(this.yLN).startAnimation();
      localValueAnimator.setDuration(200L).start();
      AppMethodBeat.o(56037);
      return;
      Log.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation, getListTopMargin(): %d, collapsedTopMargin: %d.", new Object[] { Integer.valueOf(edQ()), Integer.valueOf(this.yLH) });
      i = this.yLH - edQ();
      Log.d("MicroMsg.MMPoiMapUI", "pennqin play collapse animation (collapsedTopMargin - getListTopMargin()): %d.", new Object[] { Integer.valueOf(i) });
      locala2 = new a(i);
      locala1 = new a(this.yLJ);
    }
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(56055);
    if (c.yMy == paramc)
    {
      ((FrameLayout.LayoutParams)this.yLG.getLayoutParams()).topMargin = this.yLH;
      ((RelativeLayout.LayoutParams)this.yLN.getLayoutParams()).topMargin = 0;
      ((FrameLayout.LayoutParams)this.yLw.getLayoutParams()).topMargin = (this.yLH - at.fromDPToPix(this.activity, 92));
      this.yJa.setLogoMargin(this.yLY);
    }
    for (;;)
    {
      this.yLG.requestLayout();
      this.yLw.requestLayout();
      this.yLN.requestLayout();
      AppMethodBeat.o(56055);
      return;
      if (c.yMz == paramc)
      {
        ((FrameLayout.LayoutParams)this.yLG.getLayoutParams()).topMargin = this.yLI;
        ((RelativeLayout.LayoutParams)this.yLN.getLayoutParams()).topMargin = (-this.yLJ);
        ((FrameLayout.LayoutParams)this.yLw.getLayoutParams()).topMargin = (this.yLI - at.fromDPToPix(this.activity, 92));
        this.yJa.setLogoMargin(this.yLZ);
      }
    }
  }
  
  private boolean edL()
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
  
  private void edM()
  {
    AppMethodBeat.i(56039);
    this.yLE = false;
    this.yLg.setVisibility(0);
    a(c.yMy);
    edR();
    this.jgR = "";
    this.yLs.setVisibility(8);
    this.yLt.notifyDataSetChanged();
    this.yLr.setVisibility(0);
    this.yLv.setVisibility(8);
    this.yLz.setVisibility(8);
    edO();
    qK(true);
    this.yLw.setSelected(this.yMm);
    this.yJa.getIController().animateTo(this.lat, this.lng);
    AppMethodBeat.o(56039);
  }
  
  private void edN()
  {
    AppMethodBeat.i(56043);
    if (this.yLq.yMD)
    {
      f localf = this.yLq.getPoi();
      e locale = this.yLt;
      if (locale.yMH.size() >= 0)
      {
        locale.yMH.add(0, localf);
        locale.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(56043);
  }
  
  private void edO()
  {
    AppMethodBeat.i(56050);
    Iterator localIterator = this.yMj.values().iterator();
    while (localIterator.hasNext()) {
      ((PoiPoint)localIterator.next()).remove();
    }
    this.yMj.clear();
    this.yMi = null;
    AppMethodBeat.o(56050);
  }
  
  private void edP()
  {
    AppMethodBeat.i(56051);
    Object localObject = new ArrayList(5);
    int i = 0;
    while ((i < 5) && (i < this.yLu.getCount()))
    {
      ((List)localObject).add(this.yLu.Pz(i));
      i += 1;
    }
    localObject = fn((List)localObject);
    edO();
    i = 0;
    while (i < ((List)localObject).size())
    {
      f localf = this.yLu.Pz(i);
      PoiPoint localPoiPoint = new PoiPoint(this.activity, this.yJa);
      localPoiPoint.setPosition(i);
      localPoiPoint.setOnPointClick(this.yIr);
      this.yMj.put(localf.cik + localf.cil, localPoiPoint);
      localPoiPoint.c(localf.cik, localf.cil, false);
      i += 1;
    }
    fo((List)localObject);
    AppMethodBeat.o(56051);
  }
  
  private int edQ()
  {
    AppMethodBeat.i(56056);
    int i = ((ViewGroup.MarginLayoutParams)this.yLG.getLayoutParams()).topMargin;
    AppMethodBeat.o(56056);
    return i;
  }
  
  private void edR()
  {
    AppMethodBeat.i(56057);
    if (this.yLE)
    {
      this.yMc.setVisibility(8);
      this.yMd.setVisibility(0);
      this.yMg.setVisibility(0);
      AppMethodBeat.o(56057);
      return;
    }
    this.yMc.setVisibility(0);
    this.yMd.setVisibility(8);
    this.yMg.setVisibility(8);
    AppMethodBeat.o(56057);
  }
  
  private void edS()
  {
    AppMethodBeat.i(56058);
    if (!this.yMo)
    {
      this.yMo = true;
      this.yMe.requestFocus();
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
  
  private static List<f> fn(List<f> paramList)
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
        if (TencentLocationUtils.distanceBetween(localf1.cik, localf1.cil, localf2.cik, localf2.cil) > 5000.0D) {
          break label121;
        }
        localArrayList.add(localf1);
      }
    }
    label121:
    AppMethodBeat.o(56052);
    return localArrayList;
  }
  
  private void fo(List<f> paramList)
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
      this.yJa.getIController().animateTo(((f)paramList.get(0)).cik, ((f)paramList.get(0)).cil);
      AppMethodBeat.o(56053);
      return;
    }
    ArrayList localArrayList = new ArrayList(5);
    while (i < paramList.size())
    {
      f localf = (f)paramList.get(i);
      localArrayList.add(new LatLng(localf.cik, localf.cil));
      i += 1;
    }
    paramList = LatLngBounds.builder().include(localArrayList).build();
    if ((Double.isInfinite(paramList.getNortheast().getLatitude())) || (Double.isNaN(paramList.getNortheast().getLongitude())) || (Double.isInfinite(paramList.getSouthwest().getLatitude())) || (Double.isNaN(paramList.getSouthwest().getLongitude())))
    {
      AppMethodBeat.o(56053);
      return;
    }
    this.yJa.animateCamera(CameraUpdateFactory.newLatLngBounds(paramList, 250));
    AppMethodBeat.o(56053);
  }
  
  private void pN(boolean paramBoolean)
  {
    AppMethodBeat.i(56044);
    Log.d("MicroMsg.MMPoiMapUI", "stack: %s", new Object[] { Util.getStack() });
    this.yFJ = a(this.lat, this.jgR);
    if (this.yFJ.equals(this.yLt.key))
    {
      Log.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[] { this.yFJ });
      AppMethodBeat.o(56044);
      return;
    }
    byte[] arrayOfByte = null;
    int i = 1;
    this.yLv.setVisibility(0);
    label185:
    double d1;
    double d2;
    if (this.yLE) {
      if ((this.yFK > 0) && (paramBoolean))
      {
        this.yLs.gKN();
        this.yLu.edW();
        this.yLu.aDj(this.yFJ);
        this.yLu.qLO = this.jgR;
        this.yLu.daZ = false;
        arrayOfByte = this.yLu.buffer;
        if (i == 0) {
          break label436;
        }
        if (this.yLF != 0) {
          break label424;
        }
        i = 0;
        d1 = this.lat;
        d2 = this.lng;
        if (!this.yLE) {
          break label430;
        }
      }
    }
    label424:
    label430:
    for (int j = 0;; j = 1)
    {
      this.yLx = new com.tencent.mm.plugin.location.model.i(arrayOfByte, d1, d2, i, j, this.yLD, this.yLC, this.yFJ, this.jgR, paramBoolean);
      com.tencent.mm.kernel.g.azz().a(this.yLx, 0);
      this.yLO += 1;
      if (this.yLR == -1L) {
        this.yLR = System.currentTimeMillis();
      }
      AppMethodBeat.o(56044);
      return;
      if (!paramBoolean)
      {
        this.yLs.gKN();
        this.yLu.clean();
        this.yLu.aDj(this.yFJ);
        this.yLu.qLO = this.jgR;
        this.yLu.daZ = false;
        arrayOfByte = this.yLu.buffer;
        this.yLu.notifyDataSetChanged();
        break;
      }
      i = 0;
      this.yLu.daZ = false;
      break;
      this.yLr.gKN();
      this.yLt.clean();
      this.yLt.aDj(this.yFJ);
      this.yLt.notifyDataSetChanged();
      arrayOfByte = this.yLt.buffer;
      qK(false);
      edN();
      break;
      i = 1;
      break label185;
    }
    label436:
    Log.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", new Object[] { Integer.valueOf(this.yFK) });
    AppMethodBeat.o(56044);
  }
  
  private void qK(boolean paramBoolean)
  {
    AppMethodBeat.i(56048);
    Log.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ygS.setEnabled(paramBoolean);
    this.yLy.setEnabled(paramBoolean);
    AppMethodBeat.o(56048);
  }
  
  private void x(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(56045);
    String str3;
    String str1;
    String str2;
    if ((this.yLC == -85.0D) || (this.yLD == -1000.0D))
    {
      str3 = "null/null";
      str1 = "";
      if (paramBoolean) {
        break label563;
      }
      if ((paramInt2 < 0) || (paramInt2 >= this.yLt.getCount())) {
        break label614;
      }
      str1 = this.yLt.Pz(paramInt2).yMY;
      str2 = this.yLt.Pz(paramInt2).yMO;
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
          if (this.yLt.getCount() > 1)
          {
            Log.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str4 = this.yLt.Pz(1).yMY;
          }
        }
      }
      if ((this.yLt.getCount() > 0) && (!paramBoolean)) {
        Log.d("MicroMsg.MMPoiMapUI", "set request id at index: %s", new Object[] { Integer.valueOf(paramInt2) });
      }
      for (str1 = this.yLt.Pz(0).dPI;; str1 = "")
      {
        int i = paramInt2;
        if (paramInt2 == 0)
        {
          i = paramInt2;
          if (!paramBoolean)
          {
            i = paramInt2;
            if (this.yLt.getCount() > 0)
            {
              int j = this.yLt.Pz(0).yMZ;
              i = paramInt2;
              if (j >= 0)
              {
                Log.d("MicroMsg.MMPoiMapUI", "change to search index: %s", new Object[] { Integer.valueOf(j) });
                i = j;
              }
            }
          }
        }
        Log.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s, requestId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.yLR), Long.valueOf(this.yLQ), Long.valueOf(this.yLP), Integer.valueOf(this.yLO), str3, Integer.valueOf(this.yLS), str4, str1 });
        com.tencent.mm.plugin.report.service.h.CyF.a(11135, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i + 1), Long.valueOf(this.yLR), Long.valueOf(this.yLQ), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.yLP), Integer.valueOf(this.yLO), str3, str2, Integer.valueOf(this.yLS), str4, com.tencent.mm.compatible.deviceinfo.q.dr(true), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str1 });
        AppMethodBeat.o(56045);
        return;
        str3 = String.format("%f/%f", new Object[] { Double.valueOf(this.yLC), Double.valueOf(this.yLD) });
        break;
        label563:
        if ((paramInt2 < 0) || (paramInt2 >= this.yLu.getCount())) {
          break label614;
        }
        str1 = this.yLu.Pz(paramInt2).yMY;
        str2 = this.yLu.Pz(paramInt2).yMO;
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
      Log.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent, back.");
      g.c.yNm.a(g.a.yNd);
      if (this.yLE)
      {
        edM();
        x(yLW, this.yLu.va, true);
        AppMethodBeat.o(56038);
        return false;
      }
      x(yLU, this.yLt.va, false);
      this.activity.finish();
      AppMethodBeat.o(56038);
      return true;
    }
    AppMethodBeat.o(56038);
    return false;
  }
  
  public final com.tencent.mm.plugin.k.d edI()
  {
    AppMethodBeat.i(56036);
    com.tencent.mm.plugin.k.d locald = (com.tencent.mm.plugin.k.d)this.activity.findViewById(2131301852);
    AppMethodBeat.o(56036);
    return locald;
  }
  
  public final void edJ()
  {
    AppMethodBeat.i(56040);
    a(c.yMy);
    AppMethodBeat.o(56040);
  }
  
  public final void edK()
  {
    AppMethodBeat.i(56041);
    if (this.yLw.isSelected()) {
      this.yLw.setSelected(false);
    }
    if (!this.yLE)
    {
      this.yLq.play();
      this.lat = (this.yJa.getMapCenterX() / 1000000.0D);
      this.lng = (this.yJa.getMapCenterY() / 1000000.0D);
      this.yLq.l(this.lat, this.lng);
      this.yLw.setSelected(false);
      if (this.yLM) {
        a(c.yMy);
      }
      pN(false);
      this.yLX = false;
      g.c.yNm.yNa = 0;
      g.c.yNm.a(g.b.yNi);
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
    com.tencent.mm.kernel.g.azz().a(457, this);
    this.yLS = ((int)(System.currentTimeMillis() / 1000L));
    this.yJa.setCanRotate(false);
    label212:
    int j;
    if (com.tencent.mm.ui.ao.isDarkMode())
    {
      edI().enableDarkMode();
      this.yLA = ((LinearLayout)findViewById(2131302279));
      ((TextView)findViewById(2131297824)).setText(2131755761);
      this.uvi = findViewById(2131309205);
      this.uvi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(56013);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          g.c.yNm.a(g.a.yNd);
          c.a(c.this, c.yLU, c.b(c.this).va, false);
          c.c(c.this);
          c.this.activity.finish();
          a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(56013);
        }
      });
      this.uvi.setVisibility(0);
      this.ygS = findViewById(2131309206);
      this.yLy = findViewById(2131297849);
      switch (this.type)
      {
      default: 
        this.ygS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(56018);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            g.c.yNm.a(g.a.yNc);
            c.d(c.this);
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(56018);
          }
        });
        this.ygS.setVisibility(0);
        qK(false);
        this.yLG = ((RelativeLayout)findViewById(2131303737));
        this.yLr = ((MMLoadMoreListView)this.activity.findViewById(2131306011));
        this.yLs = ((MMLoadMoreListView)this.activity.findViewById(2131307403));
        this.yLv = findViewById(2131303690);
        this.yLz = ((TextView)findViewById(2131307383));
        this.yLp = ((PoiHeaderView)findViewById(2131306004));
        this.yLN = ((FrameLayout)findViewById(2131304495));
        this.yLw = ((ImageButton)findViewById(2131303726));
        this.yLw.setSelected(true);
        this.yLw.setContentDescription(this.activity.getString(2131762448));
        this.yLw.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182066);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
              c.this.yJa.getIController().animateTo(c.e(c.this), c.f(c.this));
              c.h(c.this).setSelected(true);
              c.a(c.this, c.c.yMy);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182066);
              return;
              c.this.yJa.getIController().animateTo(c.e(c.this), c.f(c.this));
              c.a(c.this, c.e(c.this));
              c.b(c.this, c.f(c.this));
              c.a(c.this).l(c.i(c.this), c.j(c.this));
              c.h(c.this).setSelected(true);
              c.a(c.this, false);
              c.b(c.this).va = 0;
              c.k(c.this).setSelection(0);
              g.c.yNm.yNa = 0;
              g.c.yNm.a(g.b.yNk);
              c.l(c.this);
            }
          }
        });
        this.yJa.setBuiltInZoomControls(false);
        this.yLg = ((FrameLayout)findViewById(2131299236));
        this.yLB = new MyPoiPoint(this.activity, this.yJa);
        this.yLq = new PickPoi(this.activity);
        this.yLq.setOnCurPoiGet(new b()
        {
          public final void a(f paramAnonymousf)
          {
            AppMethodBeat.i(182067);
            c.a(c.this).setOnCurPoiGet(null);
            if (paramAnonymousf != null)
            {
              c.m(c.this).c(paramAnonymousf.yMX);
              if (c.b(c.this) != null)
              {
                c.b(c.this).iy(c.m(c.this).yMR, c.m(c.this).yMS);
                c.n(c.this).iy(c.m(c.this).yMR, c.m(c.this).yMS);
              }
            }
            AppMethodBeat.o(182067);
          }
        });
        this.yLg.addView(this.yLq);
        paramBundle = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NWn, "");
        if ((!Util.isNullOrNil(paramBundle)) && ((this.yLC == -85.0D) || (this.yLD == -1000.0D)))
        {
          String[] arrayOfString = paramBundle.split(",");
          Log.i("MicroMsg.MMPoiMapUI", "last locationInfo ".concat(String.valueOf(paramBundle)));
          if (arrayOfString.length == 2)
          {
            float f1 = (float)(Util.safeParseInt(arrayOfString[0]) * 1.0D / 1000000.0D);
            float f2 = (float)(Util.safeParseInt(arrayOfString[1]) * 1.0D / 1000000.0D);
            this.yJa.getIController().animateTo(f1, f2);
          }
        }
        this.yMh = new View.OnTouchListener()
        {
          private float yMv;
          private short yMw = 0;
          
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
              this.yMv = paramAnonymousMotionEvent.getRawY();
              c.b(c.this, false);
              continue;
              Log.d("MicroMsg.MMPoiMapUI", "newpoi action move %s.", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getRawY()) });
              if (c.p(c.this))
              {
                Log.d("MicroMsg.MMPoiMapUI", "newpoi blocked.");
                c.k(c.this).setSelection(0);
              }
              float f = this.yMv - paramAnonymousMotionEvent.getRawY();
              if (Math.abs(f) < BackwardSupportUtil.BitmapFactory.fromDPToPix(c.this.activity, 20.0F)) {
                this.yMw = 0;
              }
              while (((c.q(c.this)) && (this.yMw == 1)) || ((c.r(c.this)) && (this.yMw == -1)) || ((c.q(c.this)) && (!c.s(c.this).getScroll2Top()) && (this.yMw == -1)))
              {
                AppMethodBeat.o(182068);
                return false;
                if (f > 0.0F) {
                  this.yMw = 1;
                } else {
                  this.yMw = -1;
                }
              }
              if ((c.o(c.this)) && (this.yMw != 0))
              {
                Log.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[] { Short.valueOf(this.yMw) });
                if (this.yMw == 1)
                {
                  c.c(c.this, true);
                  c.a(c.this, c.c.yMz);
                  AppMethodBeat.o(182068);
                  return false;
                }
                c.a(c.this, c.c.yMy);
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
        this.yLr.setOnTouchListener(this.yMh);
        this.yLr.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void onLoadMore()
          {
            AppMethodBeat.i(182069);
            c.t(c.this);
            AppMethodBeat.o(182069);
          }
        });
        this.yLr.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182070);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousAdapterView);
            localb.bm(paramAnonymousView);
            localb.pH(paramAnonymousInt);
            localb.zo(paramAnonymousLong);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
            Log.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= c.b(c.this).getCount()))
            {
              Log.i("MicroMsg.MMPoiMapUI", "wrong position");
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182070);
              return;
            }
            paramAnonymousAdapterView = c.b(c.this).Pz(paramAnonymousInt);
            if (paramAnonymousAdapterView.type == 0) {
              c.h(c.this).setSelected(false);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView.cik);
              c.b(c.this, paramAnonymousAdapterView.cil);
              c.this.yJa.getIController().animateTo(paramAnonymousAdapterView.cik, paramAnonymousAdapterView.cil);
              c.b(c.this).va = paramAnonymousInt;
              c.b(c.this).notifyDataSetChanged();
              c.a(c.this, false);
              g.c.yNm.yNa = (paramAnonymousInt + 1);
              g.c.yNm.a(g.b.yNj);
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182070);
              return;
              c.h(c.this).setSelected(true);
            }
          }
        });
        this.yLt = new e(this.activity);
        this.yLr.setAdapter(this.yLt);
        this.yLq.setAdapter(this.yLt);
        this.yIr = new PoiPoint.a()
        {
          public final void a(PoiPoint.b paramAnonymousb, PoiPoint paramAnonymousPoiPoint)
          {
            AppMethodBeat.i(182071);
            if (PoiPoint.b.yIu == paramAnonymousb)
            {
              if (-1 == c.n(c.this).va) {
                c.d(c.this, true);
              }
              if (c.u(c.this) != null) {
                c.u(c.this).edi();
              }
              c.this.yJa.getIController().animateTo(paramAnonymousPoiPoint.getLat(), paramAnonymousPoiPoint.getLng());
              c.a(c.this, paramAnonymousPoiPoint);
              paramAnonymousPoiPoint.edj();
              c.a(c.this, paramAnonymousPoiPoint.getPosition());
              c.n(c.this).va = paramAnonymousPoiPoint.getPosition();
              c.n(c.this).notifyDataSetChanged();
              g.c.yNm.yNa = (paramAnonymousPoiPoint.getPosition() + 1);
              g.c.yNm.a(g.b.yNh);
              AppMethodBeat.o(182071);
              return;
            }
            paramAnonymousb = PoiPoint.b.yIt;
            AppMethodBeat.o(182071);
          }
        };
        this.yLu = new e(this.activity);
        this.yLu.khr = true;
        this.yLu.va = -1;
        this.yLs.setAdapter(this.yLu);
        this.yLs.setOnLoadMoreListener(new MMLoadMoreListView.a()
        {
          public final void onLoadMore()
          {
            AppMethodBeat.i(182051);
            c.t(c.this);
            AppMethodBeat.o(182051);
          }
        });
        this.yLs.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(182052);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousAdapterView);
            localb.bm(paramAnonymousView);
            localb.pH(paramAnonymousInt);
            localb.zo(paramAnonymousLong);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
            if (-1 == c.n(c.this).va)
            {
              c.d(c.this, true);
              c.a(c.this, c.c.yMy);
            }
            c.n(c.this).va = paramAnonymousInt;
            c.n(c.this).notifyDataSetChanged();
            if ((paramAnonymousInt >= 0) && (paramAnonymousInt < c.n(c.this).getCount()))
            {
              c.a(c.this, true);
              if (c.u(c.this) != null) {
                c.u(c.this).edi();
              }
              paramAnonymousView = c.n(c.this).Pz(paramAnonymousInt);
              if ((paramAnonymousView.cik == c.e(c.this)) && (paramAnonymousView.cil == c.f(c.this))) {
                break label412;
              }
              c.h(c.this).setSelected(false);
              c.this.yJa.getIController().animateTo(paramAnonymousView.cik, paramAnonymousView.cil);
              paramAnonymousAdapterView = (PoiPoint)c.v(c.this).get(paramAnonymousView.cik + paramAnonymousView.cil);
              if (paramAnonymousAdapterView != null) {
                break label426;
              }
              paramAnonymousAdapterView = new PoiPoint(c.this.activity, c.this.yJa);
              paramAnonymousAdapterView.setPosition(paramAnonymousInt);
              paramAnonymousAdapterView.setOnPointClick(c.this.yIr);
              c.v(c.this).put(paramAnonymousView.cik + paramAnonymousView.cil, paramAnonymousAdapterView);
              paramAnonymousAdapterView.c(paramAnonymousView.cik, paramAnonymousView.cil, true);
            }
            for (;;)
            {
              c.a(c.this, paramAnonymousAdapterView);
              g.c.yNm.yNa = (paramAnonymousInt + 1);
              g.c.yNm.a(g.b.yNg);
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(182052);
              return;
              label412:
              c.h(c.this).setSelected(true);
              break;
              label426:
              paramAnonymousAdapterView.edj();
            }
          }
        });
        this.yLs.setOnTouchListener(this.yMh);
        this.yMc = findViewById(2131307615);
        this.yMd = findViewById(2131307617);
        this.yMe = ((EditText)findViewById(2131307614));
        this.yMf = ((ImageView)findViewById(2131307619));
        this.yMg = findViewById(2131307613);
        this.yMc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(170177);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (!c.g(c.this)) {
              c.H(c.this);
            }
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(170177);
          }
        });
        this.yMg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182059);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            c.a(c.this, c.edT(), c.n(c.this).va, true);
            c.y(c.this);
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(182059);
          }
        });
        this.yMe.setOnTouchListener(new View.OnTouchListener()
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
                c.a(c.this, c.c.yMz);
              }
            }
          }
        });
        this.yLG.setClickable(true);
        this.yMe.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
          public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
          {
            AppMethodBeat.i(182061);
            if (3 == paramAnonymousInt)
            {
              c.a(c.this, c.c.yMy);
              c.h(c.this, true);
            }
            AppMethodBeat.o(182061);
            return false;
          }
        });
        this.yMe.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(182062);
            Log.d("MicroMsg.MMPoiMapUI", "searchText: %s.", new Object[] { paramAnonymousCharSequence });
            c.a(c.this, paramAnonymousCharSequence.toString());
            c.J(c.this).gKN();
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
        this.yMf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182063);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            c.P(c.this).setText("");
            c.A(c.this);
            if (c.o(c.this)) {
              c.a(c.this, c.c.yMz);
            }
            a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(182063);
          }
        });
        edR();
        this.yMa = findViewById(2131307612);
        this.yMa.post(new Runnable()
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
        findViewById(2131307611).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(182054);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (c.n(c.this).getCount() == 0) {
              c.y(c.this);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/plugin/location/ui/impl/MMPoiMapUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(182054);
              return;
              c.a(c.this, c.c.yMy);
            }
          }
        });
        this.yMr = ((InputPanelFrameLayout)findViewById(2131306012));
        this.yMr.setExternalListener(new com.tencent.mm.ui.widget.b.a()
        {
          public final void f(boolean paramAnonymousBoolean, int paramAnonymousInt)
          {
            AppMethodBeat.i(182055);
            Log.d("MicroMsg.MMPoiMapUI", "isKeyboardShow: %s.", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            c.e(c.this, paramAnonymousBoolean);
            AppMethodBeat.o(182055);
          }
        });
        paramBundle = com.tencent.mm.ui.ao.az(this.activity);
        j = Math.max(paramBundle.x, paramBundle.y);
        this.yLH = (j - BackwardSupportUtil.BitmapFactory.fromDPToPix(this.activity, 320.0F));
        this.yLI = ((int)(j * 0.25F + 0.5D));
        this.yLJ = ((int)((this.yLH - this.yLI) / 3.0D + 0.5D));
        Log.i("MicroMsg.MMPoiMapUI", "collapsedTopMargin: %d, openedTopMargin: %d, mapViewTopMargin: %d.", new Object[] { Integer.valueOf(this.yLH), Integer.valueOf(this.yLI), Integer.valueOf(this.yLJ) });
        this.yLZ = new int[] { this.yLH - this.yLI - this.yLJ + 24, 24 };
        i = this.activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (i <= 0) {
          break;
        }
      }
    }
    for (int i = this.activity.getResources().getDimensionPixelSize(i);; i = 0)
    {
      paramBundle = (FrameLayout.LayoutParams)this.yLA.getLayoutParams();
      paramBundle.height += i * 2;
      this.yLA.setLayoutParams(paramBundle);
      this.yLA.setPadding(0, i, 0, i);
      if (au.aA(this.activity))
      {
        i = au.aD(this.activity);
        label1287:
        j = j - this.yLI - i;
        Log.i("MicroMsg.MMPoiMapUI", "reset poi view height: %s, navigationBarHeight: %s.", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        paramBundle = this.yLG.getLayoutParams();
        paramBundle.height = j;
        this.yLG.setLayoutParams(paramBundle);
        paramBundle = (RelativeLayout.LayoutParams)this.yLN.getLayoutParams();
        paramBundle.height = this.yLH;
        this.yLN.setLayoutParams(paramBundle);
        b(c.yMy);
        if ((this.type != 0) && (this.type != 8)) {
          break label1520;
        }
        g.c.yNm.setScene(this.activity.getIntent().getIntExtra("type_tag", 0));
      }
      for (;;)
      {
        this.yLq.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
        edI().disableDarkMode();
        break;
        ((TextView)findViewById(2131297849)).setText(2131762471);
        break label212;
        ((TextView)findViewById(2131297849)).setText(2131755916);
        break label212;
        ((TextView)findViewById(2131297849)).setText(2131755858);
        break label212;
        i = 0;
        break label1287;
        label1520:
        g.c.yNm.setScene(this.type);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(56049);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(457, this);
    AppMethodBeat.o(56049);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(56047);
    super.onPause();
    this.yMn = false;
    com.tencent.mm.modelgeo.d.bca().c(this.gmA);
    MyPoiPoint localMyPoiPoint = this.yLB;
    Log.d("MicroMsg.MyPoiPoint", "disableLocation");
    localMyPoiPoint.yHL.c(localMyPoiPoint.gmA);
    AppMethodBeat.o(56047);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(56046);
    super.onResume();
    this.yMn = true;
    com.tencent.mm.modelgeo.d.bca().b(this.gmA, true);
    this.yLB.edh();
    AppMethodBeat.o(56046);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(56054);
    if (paramq.getType() == 457)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(56054);
        return;
      }
      this.yLx = null;
      com.tencent.mm.plugin.location.model.i locali = (com.tencent.mm.plugin.location.model.i)paramq;
      if (!locali.yFJ.equals(this.yFJ))
      {
        Log.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.yFJ + " " + locali.yFJ);
        AppMethodBeat.o(56054);
        return;
      }
      Log.i("MicroMsg.MMPoiMapUI", "isEnd: " + locali.idt + " searchId: " + locali.hes + " isInSearch: " + this.yLE);
      if (this.yLP == -1L)
      {
        long l = System.currentTimeMillis();
        this.yLQ = l;
        this.yLP = l;
      }
      for (;;)
      {
        this.yFK = locali.yFK;
        this.yLv.setVisibility(8);
        if (!this.yLE) {
          break label419;
        }
        if (!Util.isNullOrNil(this.jgR)) {
          break;
        }
        AppMethodBeat.o(56054);
        return;
        this.yLQ = System.currentTimeMillis();
      }
      if ((locali.list != null) && (locali.list.size() == 0))
      {
        this.yLz.setVisibility(0);
        this.yLs.gKN();
      }
      Log.d("MicroMsg.MMPoiMapUI", "search is first: %s", new Object[] { Boolean.valueOf(locali.isFirst()) });
      if (locali.isFirst())
      {
        this.yLu.daZ = true;
        this.yLu.yMH.clear();
      }
      this.yLu.a(locali.list, locali.yFI, locali.idt, locali.yFJ);
      if (!this.yLu.idt)
      {
        this.yLs.gKM();
        this.yLs.gKO();
      }
      while (this.yMk)
      {
        this.yMk = false;
        edP();
        AppMethodBeat.o(56054);
        return;
        this.yLs.gKN();
        this.yLs.gKP();
      }
      label419:
      Object localObject2;
      Object localObject1;
      if (this.yLp != null)
      {
        localObject2 = (brx)locali.rr.iLL.iLR;
        paramq = this.yLp;
        localObject1 = ((brx)localObject2).KTg;
        paramString = ((brx)localObject2).LXv;
        String str = ((brx)localObject2).Url;
        localObject2 = com.tencent.mm.plugin.image.d.aSY();
        Log.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[] { paramString, str });
        paramq.yHX = str;
        paramq.yHY = "";
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(paramString))) {
          break label629;
        }
        paramq.setVisibility(8);
        paramq.gyt.setVisibility(8);
        paramq.yHZ.setVisibility(8);
      }
      for (;;)
      {
        qK(true);
        this.yLt.a(locali.list, locali.yFI, locali.idt, locali.yFJ);
        this.yLt.va = 0;
        this.yLt.notifyDataSetChanged();
        if (this.yLt.idt) {
          break;
        }
        this.yLr.gKM();
        this.yLr.gKO();
        AppMethodBeat.o(56054);
        return;
        label629:
        paramq.setVisibility(0);
        paramq.gyt.setVisibility(0);
        paramq.yHZ.setVisibility(0);
        paramq.gyt.setText((CharSequence)localObject1);
        localObject1 = paramq.yHZ;
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
        else if (!s.YS(paramString))
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
      this.yLr.gKN();
      this.yLr.gKP();
    }
    AppMethodBeat.o(56054);
  }
  
  final class a
    extends TranslateAnimation
  {
    private List<View> yMx;
    
    public a(float paramFloat)
    {
      super(0.0F, 0.0F, paramFloat);
      AppMethodBeat.i(56025);
      this.yMx = new ArrayList();
      AppMethodBeat.o(56025);
    }
    
    public final a edU()
    {
      AppMethodBeat.i(56026);
      setDuration(200L);
      AppMethodBeat.o(56026);
      return this;
    }
    
    public final a edV()
    {
      AppMethodBeat.i(56027);
      setFillEnabled(true);
      setFillAfter(true);
      AppMethodBeat.o(56027);
      return this;
    }
    
    public final a en(View paramView)
    {
      AppMethodBeat.i(56028);
      this.yMx.add(paramView);
      AppMethodBeat.o(56028);
      return this;
    }
    
    public final void startAnimation()
    {
      AppMethodBeat.i(56029);
      int i = 0;
      while (i < this.yMx.size())
      {
        ((View)this.yMx.get(i)).startAnimation(this);
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
      yMy = new c("COLLAPSED", 0);
      yMz = new c("OPENED", 1);
      yMA = new c[] { yMy, yMz };
      AppMethodBeat.o(56032);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c
 * JD-Core Version:    0.7.0.1
 */