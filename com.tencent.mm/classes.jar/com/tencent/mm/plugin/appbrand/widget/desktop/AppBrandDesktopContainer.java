package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.model.DynamicBackgroundNative;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b.a;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView.b;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.ja.a;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import java.util.ArrayList;

public class AppBrandDesktopContainer
  extends HeaderContainer
  implements View.OnTouchListener
{
  private int aOy;
  private int aOz;
  private int aoH;
  private View mgu;
  private GyroView muN;
  private boolean mvA;
  private int mvB;
  private int mvC;
  private boolean mvD;
  private boolean mvE;
  private a mvF;
  private Runnable mvG;
  private com.tencent.mm.sdk.b.c mvH;
  private com.tencent.mm.plugin.appbrand.widget.header.c mvl;
  private AppBrandDesktopView mvm;
  private DynamicBackgroundGLSurfaceView mvn;
  private GradientColorBackgroundView mvo;
  private Rect mvp;
  private LinearLayout mvq;
  private View mvr;
  private TextView mvs;
  private WeImageView mvt;
  private WeImageView mvu;
  private View mvv;
  private View mvw;
  private AppBrandDesktopBottomView mvx;
  private View mvy;
  private MMFragmentActivity mvz;
  
  public AppBrandDesktopContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49444);
    this.mvp = new Rect();
    this.mvA = true;
    this.aOy = 0;
    this.aOz = 0;
    this.mvB = 0;
    this.mvC = 0;
    this.aoH = 0;
    this.mvD = true;
    this.mvE = ab.eUK();
    this.mvF = null;
    this.mvG = null;
    this.mvH = new AppBrandDesktopContainer.1(this);
    init(paramContext);
    AppMethodBeat.o(49444);
  }
  
  public AppBrandDesktopContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49445);
    this.mvp = new Rect();
    this.mvA = true;
    this.aOy = 0;
    this.aOz = 0;
    this.mvB = 0;
    this.mvC = 0;
    this.aoH = 0;
    this.mvD = true;
    this.mvE = ab.eUK();
    this.mvF = null;
    this.mvG = null;
    this.mvH = new AppBrandDesktopContainer.1(this);
    init(paramContext);
    AppMethodBeat.o(49445);
  }
  
  public AppBrandDesktopContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49446);
    this.mvp = new Rect();
    this.mvA = true;
    this.aOy = 0;
    this.aOz = 0;
    this.mvB = 0;
    this.mvC = 0;
    this.aoH = 0;
    this.mvD = true;
    this.mvE = ab.eUK();
    this.mvF = null;
    this.mvG = null;
    this.mvH = new AppBrandDesktopContainer.1(this);
    init(paramContext);
    AppMethodBeat.o(49446);
  }
  
  private void a(DynamicBackgroundGLSurfaceView paramDynamicBackgroundGLSurfaceView, GradientColorBackgroundView paramGradientColorBackgroundView)
  {
    AppMethodBeat.i(187069);
    this.mvn = paramDynamicBackgroundGLSurfaceView;
    this.mvo = paramGradientColorBackgroundView;
    byK();
    if (this.mvl != null) {
      this.mvl.g(this.mvn, this.mvo);
    }
    AppMethodBeat.o(187069);
  }
  
  private void byG()
  {
    AppMethodBeat.i(49449);
    int i = getResources().getConfiguration().orientation;
    this.mvB = 0;
    AppMethodBeat.o(49449);
  }
  
  private void byH()
  {
    AppMethodBeat.i(49454);
    ac.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewScale measuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
    if (!this.mvD)
    {
      AppMethodBeat.o(49454);
      return;
    }
    if (this.mvq != null)
    {
      this.mvq.setScaleX(0.6F);
      this.mvq.setScaleY(0.6F);
    }
    AppMethodBeat.o(49454);
  }
  
  private void byJ()
  {
    AppMethodBeat.i(49457);
    int[] arrayOfInt;
    if ((this.mvs != null) && (this.mgu != null))
    {
      arrayOfInt = new int[2];
      this.mgu.getLocationOnScreen(arrayOfInt);
      ac.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin location x: %d, y: %d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]) });
      if (Build.VERSION.SDK_INT < 24) {
        break label187;
      }
    }
    label180:
    label187:
    for (boolean bool = this.mvz.isInMultiWindowMode();; bool = false)
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((arrayOfInt[0] >= 0) || (bool))
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.mvs.getLayoutParams();
        if (!bool) {
          break label180;
        }
      }
      for (int i = 0;; i = arrayOfInt[0])
      {
        localLayoutParams.leftMargin = (i + getResources().getDimensionPixelSize(2131165198));
        ac.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin leftMargin: %d", new Object[] { Integer.valueOf(localLayoutParams.leftMargin) });
        if (this.mvs.getParent() != null) {
          this.mvs.getParent().requestLayout();
        }
        this.mvr.setVisibility(0);
        AppMethodBeat.o(49457);
        return;
      }
    }
  }
  
  private void byK()
  {
    AppMethodBeat.i(187067);
    Object localObject1 = getBgParticlesColorConfig();
    if (localObject1 != this.mvF)
    {
      this.mvF = ((a)localObject1);
      if (this.mvn != null)
      {
        localObject1 = this.mvn;
        int i = this.mvF.fMG;
        int j = this.mvF.fMH;
        int k = this.mvF.fMI;
        int m = this.mvF.fMJ;
        int n = this.mvF.fMK;
        Object localObject2 = ((DynamicBackgroundGLSurfaceView)localObject1).fMm;
        if (localObject2 != null)
        {
          ((DynamicBackgroundGLSurfaceView.b)localObject2).fMB = new DynamicBackgroundGLSurfaceView.b.a(i, j, k, m, n);
          if (((DynamicBackgroundGLSurfaceView.b)localObject2).fMC)
          {
            localObject1 = ((DynamicBackgroundGLSurfaceView.b)localObject2).fMq;
            if (localObject1 != null)
            {
              DynamicBackgroundGLSurfaceView.b.a locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).fMB;
              if (locala == null) {
                k.fOy();
              }
              i = locala.fMG;
              locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).fMB;
              if (locala == null) {
                k.fOy();
              }
              j = locala.fMH;
              locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).fMB;
              if (locala == null) {
                k.fOy();
              }
              k = locala.fMI;
              locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).fMB;
              if (locala == null) {
                k.fOy();
              }
              m = locala.fMJ;
              localObject2 = ((DynamicBackgroundGLSurfaceView.b)localObject2).fMB;
              if (localObject2 == null) {
                k.fOy();
              }
              ((DynamicBackgroundNative)localObject1).setColor(i, j, k, m, ((DynamicBackgroundGLSurfaceView.b.a)localObject2).fMK);
            }
          }
        }
      }
      if (this.mvo != null)
      {
        localObject1 = this.mvo;
        ((GradientColorBackgroundView)localObject1).post((Runnable)new GradientColorBackgroundView.b((GradientColorBackgroundView)localObject1, this.mvF.fMJ, this.mvF.fMK));
      }
    }
    AppMethodBeat.o(187067);
  }
  
  private void dW(Context paramContext)
  {
    AppMethodBeat.i(49453);
    paramContext = LayoutInflater.from(paramContext).inflate(2131492982, null);
    this.mvq = ((LinearLayout)paramContext.findViewById(2131296708));
    this.muN = ((GyroView)paramContext.findViewById(2131300673));
    this.mvr = paramContext.findViewById(2131296699);
    this.mvs = ((TextView)paramContext.findViewById(2131296694));
    this.mvt = ((WeImageView)paramContext.findViewById(2131304422));
    this.mvu = ((WeImageView)paramContext.findViewById(2131303323));
    this.mvv = paramContext.findViewById(2131304423);
    this.mvw = paramContext.findViewById(2131303324);
    this.mvx = ((AppBrandDesktopBottomView)paramContext.findViewById(2131296695));
    this.mvt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49441);
        if ((AppBrandDesktopContainer.a(AppBrandDesktopContainer.this) != null) && (AppBrandDesktopContainer.a(AppBrandDesktopContainer.this).byu())) {
          AppBrandDesktopContainer.a(AppBrandDesktopContainer.this).vr(16);
        }
        AppMethodBeat.o(49441);
      }
    });
    this.mvu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49442);
        if ((AppBrandDesktopContainer.a(AppBrandDesktopContainer.this) != null) && (AppBrandDesktopContainer.a(AppBrandDesktopContainer.this).byu())) {
          AppBrandDesktopContainer.a(AppBrandDesktopContainer.this).vr(14);
        }
        AppMethodBeat.o(49442);
      }
    });
    byH();
    this.mvm = ((AppBrandDesktopView)paramContext.findViewById(2131296711));
    this.mvm.setHeaderContainer(this);
    this.mvm.setId(2131296711);
    int i = this.mvm.getLeftRightMargin();
    ac.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktop view marginLeftRight: %d, width: %d, pivotX: %f, pivotY: %f", new Object[] { Integer.valueOf(i), Integer.valueOf(getMeasuredWidth()), Float.valueOf(this.mvq.getPivotX()), Float.valueOf(this.mvq.getPivotY()) });
    AppBrandDesktopView localAppBrandDesktopView = this.mvm;
    localAppBrandDesktopView.setPadding(i, localAppBrandDesktopView.getPaddingTop(), i, 0);
    addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(49453);
  }
  
  private a getBgParticlesColorConfig()
  {
    AppMethodBeat.i(187068);
    if (aj.DT())
    {
      locala = a.byL();
      AppMethodBeat.o(187068);
      return locala;
    }
    a locala = a.byM();
    AppMethodBeat.o(187068);
    return locala;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49450);
    ac.i("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer init");
    this.aoH = com.tencent.mm.cc.a.fromDPToPix(paramContext, 16);
    byG();
    setBackgroundColor(getResources().getColor(2131101053));
    com.tencent.mm.plugin.appbrand.widget.desktop.a.a locala = com.tencent.mm.plugin.appbrand.widget.desktop.a.a.myy;
    com.tencent.mm.plugin.appbrand.widget.desktop.a.a.bzh();
    dW(paramContext);
    AppMethodBeat.o(49450);
  }
  
  private void setActionBarTitle(String paramString)
  {
    AppMethodBeat.i(180414);
    if (this.mvs != null)
    {
      this.mvs.setText(paramString);
      float f = com.tencent.mm.cc.a.av(getContext(), 2131165184) * com.tencent.mm.cc.a.ib(getContext());
      if (this.mvs.getTextSize() != f) {
        this.mvs.setTextSize(0, f);
      }
      aj.a(this.mvs.getPaint(), 0.8F);
    }
    AppMethodBeat.o(180414);
  }
  
  public final void byI()
  {
    AppMethodBeat.i(49455);
    if (this.mvm != null) {
      this.mvm.setPadding(this.mvm.getLeftRightMargin(), this.mvm.getPaddingTop(), this.mvm.getLeftRightMargin(), 0);
    }
    AppMethodBeat.o(49455);
  }
  
  public final boolean byv()
  {
    AppMethodBeat.i(49461);
    if (this.mvl != null)
    {
      boolean bool = this.mvl.byv();
      AppMethodBeat.o(49461);
      return bool;
    }
    AppMethodBeat.o(49461);
    return false;
  }
  
  public final void e(Configuration paramConfiguration)
  {
    AppMethodBeat.i(49460);
    super.e(paramConfiguration);
    ac.i("MicroMsg.AppBrandDesktopContainer", "alvinluo AppBrandDesktopContainer onCustomConfigurationChanged newConfig orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.mvG != null) {
      removeCallbacks(this.mvG);
    }
    this.mvr.setVisibility(4);
    Object localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49443);
        AppBrandDesktopContainer.b(AppBrandDesktopContainer.this);
        AppMethodBeat.o(49443);
      }
    };
    this.mvG = ((Runnable)localObject);
    postDelayed((Runnable)localObject, 400L);
    vu(getResources().getColor(2131100705));
    if (this.mvm != null)
    {
      localObject = this.mvm;
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged lastOrientation: %d, orientation: %d", new Object[] { Integer.valueOf(((AppBrandDesktopView)localObject).guA), Integer.valueOf(paramConfiguration.orientation) });
      if (((AppBrandDesktopView)localObject).mtL != null)
      {
        ((AppBrandDesktopView)localObject).mww = ((AppBrandDesktopView)localObject).mtL.getViewHeight();
        ac.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged fixedViewHeight: %d", new Object[] { Integer.valueOf(((AppBrandDesktopView)localObject).mww) });
      }
      if (((AppBrandDesktopView)localObject).guA != paramConfiguration.orientation)
      {
        ((AppBrandDesktopView)localObject).guA = paramConfiguration.orientation;
        if ((((AppBrandDesktopView)localObject).mtL != null) && (((AppBrandDesktopView)localObject).mtL.byv()))
        {
          ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onCustomConfigurationChanged closeHeader");
          ((AppBrandDesktopView)localObject).mtL.l(0L, 0);
        }
      }
    }
    AppMethodBeat.o(49460);
  }
  
  public final void eq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49458);
    if (!this.mvD)
    {
      if (paramInt1 <= 10) {
        this.mvD = true;
      }
      AppMethodBeat.o(49458);
      return;
    }
    float f3;
    AppBrandDesktopView localAppBrandDesktopView;
    if (this.mvq != null)
    {
      if (paramInt1 <= 10)
      {
        AppMethodBeat.o(49458);
        return;
      }
      this.mvq.setTranslationY(getMeasuredHeight() - getBottom());
      f3 = Math.max(Math.min(1.0F * paramInt1 / paramInt2 * 0.4F + 0.6F, 1.0F), 0.6F);
      this.mvq.setScaleX(f3);
      this.mvq.setScaleY(f3);
      ac.v("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer onScroll scale: %f, scrollY: %d, totalHeight: %d", new Object[] { Float.valueOf(f3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.mvm != null)
      {
        localAppBrandDesktopView = this.mvm;
        if (!localAppBrandDesktopView.dnN) {
          break label189;
        }
        localAppBrandDesktopView.aK(1.0F);
      }
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        this.mvD = false;
      }
      AppMethodBeat.o(49458);
      return;
      label189:
      int i = 0;
      if (localAppBrandDesktopView.mtL != null) {
        i = localAppBrandDesktopView.mtL.getAnimationScrollOffset();
      }
      int j = localAppBrandDesktopView.mwn;
      int k = localAppBrandDesktopView.mwn;
      k = localAppBrandDesktopView.getCollectionDataSize() + k;
      ac.v("MicroMsg.AppBrandDesktopView", "alvinluo onScroll scrollY: %d, totalHeight: %d, startPos: %d, endPos: %d, animationOffset: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localAppBrandDesktopView.mwn), Integer.valueOf(k), Integer.valueOf(i) });
      int m = paramInt2 - i;
      int n = paramInt1 - i;
      Object localObject1;
      if ((localAppBrandDesktopView.mwo) || (localAppBrandDesktopView.mwp))
      {
        if (m - localAppBrandDesktopView.mxc > n)
        {
          f1 = 0.0F;
          localAppBrandDesktopView.aK(Math.min(1.0F, Math.max(0.0F, f1)));
        }
      }
      else
      {
        int i1 = (k - j) / localAppBrandDesktopView.anI;
        int i2 = localAppBrandDesktopView.mxc;
        float f2 = 0.0F;
        f1 = f2;
        if (localAppBrandDesktopView.mwo)
        {
          i = localAppBrandDesktopView.mwD;
          localObject1 = localAppBrandDesktopView.ci(2);
          f1 = f2;
          if (localObject1 != null)
          {
            f1 = f2;
            if (((RecyclerView.w)localObject1).asD != null)
            {
              f1 = Math.min(0.0F, i * f3 * n / (m - i2) - i);
              ((RecyclerView.w)localObject1).asD.setTranslationY(f1);
              f1 = Math.abs(f1);
            }
          }
        }
        int i3 = (int)(localAppBrandDesktopView.mwD + com.tencent.mm.cc.a.fromDPToPix(localAppBrandDesktopView.mContext, 16) + f1);
        localObject1 = new ArrayList();
        i = 0;
        label487:
        if (i > i1) {
          break label653;
        }
        if (i != 0) {
          break label602;
        }
        f1 = Math.min(0.0F, i3 * f3 * n / (m - i2) - i3);
        ((ArrayList)localObject1).add(Float.valueOf(f1));
      }
      for (float f1 = Math.abs(f1);; f1 = Math.abs(f1))
      {
        ac.v("MicroMsg.AppBrandDesktopView", "alvinluo onScroll lastRowTranslationY: %f, row: %d", new Object[] { Float.valueOf(f1), Integer.valueOf(i) });
        i += 1;
        break label487;
        f1 = 1.0F * (n - (m - localAppBrandDesktopView.mxc)) / localAppBrandDesktopView.mxc;
        break;
        label602:
        f1 = Math.min(0.0F, (localAppBrandDesktopView.mxj + f1) * f3 * n / m - (f1 + localAppBrandDesktopView.mxj));
        ((ArrayList)localObject1).add(Float.valueOf(f1));
      }
      label653:
      i = j;
      while (i < k)
      {
        Object localObject2 = localAppBrandDesktopView.ci(i);
        if (((localObject2 instanceof e)) && (((RecyclerView.w)localObject2).asD != null))
        {
          localObject2 = (e)localObject2;
          m = (i - j) / localAppBrandDesktopView.anI;
          ((e)localObject2).asD.setTranslationY(((Float)((ArrayList)localObject1).get(m)).floatValue());
        }
        i += 1;
      }
    }
  }
  
  public final void er(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49470);
    super.er(paramInt1, paramInt2);
    if (this.mvs != null) {
      this.mvs.setTextColor(paramInt1);
    }
    if (this.mvt != null)
    {
      this.mvt.setImageResource(2131689494);
      this.mvt.setIconColor(paramInt2);
    }
    if (this.mvu != null)
    {
      this.mvu.setImageResource(2131690510);
      this.mvu.setIconColor(paramInt2);
    }
    AppMethodBeat.o(49470);
  }
  
  public final void g(View paramView1, View paramView2)
  {
    AppMethodBeat.i(49464);
    a((DynamicBackgroundGLSurfaceView)paramView1, (GradientColorBackgroundView)paramView2);
    AppMethodBeat.o(49464);
  }
  
  public int getAnimationScrollOffset()
  {
    AppMethodBeat.i(49471);
    int i = this.mvl.getAnimationScrollOffset();
    AppMethodBeat.o(49471);
    return i;
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.mvp;
  }
  
  public View getBackgroundGLSurfaceView()
  {
    return this.mvn;
  }
  
  public View getBackgroundGradientView()
  {
    return this.mvo;
  }
  
  public View getEmptyView()
  {
    return null;
  }
  
  public int getExtraBottomHeight()
  {
    return this.mvC;
  }
  
  public GyroView getGyroView()
  {
    return this.muN;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.header.a.a getHeaderView()
  {
    return null;
  }
  
  public View getMaskView()
  {
    return this.mvy;
  }
  
  public int getViewHeight()
  {
    return this.aOz;
  }
  
  public final void hS(boolean paramBoolean)
  {
    AppMethodBeat.i(49472);
    super.hS(paramBoolean);
    if (this.mvm != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.mvm;
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyMultiWindowModeChanged: %b, old: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(localAppBrandDesktopView.dnN) });
      if (localAppBrandDesktopView.dnN != paramBoolean)
      {
        localAppBrandDesktopView.dnN = paramBoolean;
        int i = localAppBrandDesktopView.mwn;
        int j = localAppBrandDesktopView.mwn;
        int k = localAppBrandDesktopView.getCollectionDataSize();
        while (i < k + j)
        {
          RecyclerView.w localw = localAppBrandDesktopView.ci(i);
          if (((localw instanceof e)) && (localw.asD != null)) {
            ((e)localw).asD.setTranslationY(0.0F);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(49472);
  }
  
  public final boolean isFullScreen()
  {
    return true;
  }
  
  public final void l(long paramLong, int paramInt)
  {
    AppMethodBeat.i(49462);
    super.l(paramLong, paramInt);
    if (this.mvl != null) {
      this.mvl.b(paramLong, paramInt, false);
    }
    AppMethodBeat.o(49462);
  }
  
  public final void m(long paramLong, int paramInt)
  {
    AppMethodBeat.i(49463);
    super.m(paramLong, paramInt);
    if (this.mvl != null) {
      this.mvl.b(paramLong, paramInt, true);
    }
    AppMethodBeat.o(49463);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(49451);
    super.onAttachedToWindow();
    ac.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onAttachedToWindow");
    if (this.mvH != null) {
      this.mvH.alive();
    }
    ja localja = new ja();
    com.tencent.mm.sdk.b.a.GpY.l(localja);
    ac.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateUnReadCount unReadCount: %d", new Object[] { Integer.valueOf(localja.dks.dkt) });
    Object localObject2 = getContext().getResources().getString(2131755822);
    Object localObject1 = localObject2;
    if (d.DIf) {
      if (!this.mvE) {
        break label225;
      }
    }
    label225:
    for (localObject1 = (String)localObject2 + getContext().getResources().getString(2131755263);; localObject1 = (String)localObject2 + " " + getContext().getResources().getString(2131755263))
    {
      localObject2 = localObject1;
      if (localja.dks.dkt > 0)
      {
        localObject2 = localObject1;
        if (!this.mvE) {
          localObject2 = (String)localObject1 + " ";
        }
        localObject2 = (String)localObject2 + "(" + localja.dks.dkt + ")";
      }
      setActionBarTitle((String)localObject2);
      AppMethodBeat.o(49451);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(49468);
    super.onDestroy();
    AppBrandDesktopView localAppBrandDesktopView;
    if (this.mvm != null)
    {
      localAppBrandDesktopView = this.mvm;
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onDestroy %d", new Object[] { Integer.valueOf(localAppBrandDesktopView.hashCode()) });
    }
    try
    {
      if (localAppBrandDesktopView.mwt != null)
      {
        localObject = localAppBrandDesktopView.mwt;
        if (((RecentAppBrandViewContainer)localObject).aal != null) {
          ((RecentAppBrandViewContainer)localObject).removeCallbacks(((RecentAppBrandViewContainer)localObject).aal);
        }
      }
      if (localAppBrandDesktopView.mwA != null)
      {
        localAppBrandDesktopView.removeCallbacks(localAppBrandDesktopView.mwA);
        localAppBrandDesktopView.mwA = null;
      }
      if (localAppBrandDesktopView.mwB != null)
      {
        localAppBrandDesktopView.removeCallbacks(localAppBrandDesktopView.mwB);
        localAppBrandDesktopView.mwB = null;
      }
      Object localObject = com.tencent.mm.plugin.appbrand.widget.desktop.b.c.mzF.bzy();
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.widget.desktop.b.b)localObject).remove(localAppBrandDesktopView.mwY);
      }
      localObject = com.tencent.mm.plugin.appbrand.widget.desktop.b.c.mzF.bzx();
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.widget.desktop.b.e)localObject).remove(localAppBrandDesktopView.mwZ);
      }
      localAppBrandDesktopView.mxa = false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandDesktopView", localException, "alvinluo onDestroy exception", new Object[0]);
      }
    }
    if (this.mvH != null) {
      this.mvH.dead();
    }
    if (this.mvG != null)
    {
      removeCallbacks(this.mvG);
      this.mvG = null;
    }
    AppMethodBeat.o(49468);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(49452);
    super.onDetachedFromWindow();
    ac.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onDetachedFromWindow");
    if (this.mvH != null) {
      this.mvH.dead();
    }
    AppMethodBeat.o(49452);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49448);
    byG();
    ac.v("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure orientation: %d, closeHeight: %d, extraBottomHeight: %d", new Object[] { Integer.valueOf(getResources().getConfiguration().orientation), Integer.valueOf(this.mvB), Integer.valueOf(this.mvC) });
    if (this.mvA)
    {
      int i = ((ViewGroup)getParent()).getMeasuredHeight() - this.mvB - this.mvC - this.aoH;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      this.aOz = i;
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredWidth() != this.aOy)
      {
        ac.i("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure width new: %d, old: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.aOy) });
        this.aOy = getMeasuredWidth();
        ac.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewPivot getMeasuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
        this.mvq.setPivotX(getMeasuredWidth() / 2.0F);
        this.mvq.setPivotY(ap.dT(getContext()));
        byH();
      }
      AppMethodBeat.o(49448);
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(49467);
    super.onPause();
    if (this.mvm != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.mvm;
      localAppBrandDesktopView.isPaused = true;
      localAppBrandDesktopView.mwT = false;
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onPause isHeaderOpen: %b, needProcess: %b, needRecreate: %b", new Object[] { Boolean.valueOf(localAppBrandDesktopView.mwR), Boolean.valueOf(localAppBrandDesktopView.mwU), Boolean.valueOf(localAppBrandDesktopView.mwT) });
      if ((localAppBrandDesktopView.mwR) && (localAppBrandDesktopView.mwU))
      {
        localAppBrandDesktopView.mwV = true;
        localAppBrandDesktopView.bza();
      }
    }
    AppMethodBeat.o(49467);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49466);
    super.onResume();
    if (this.mvm != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.mvm;
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume");
      localAppBrandDesktopView.isPaused = false;
      if (localAppBrandDesktopView.aqk)
      {
        ac.v("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume setLayoutFrozen false");
        localAppBrandDesktopView.setLayoutFrozen(false);
      }
      ac.i("MicroMsg.AppBrandDesktopView", "alvinluo onResume isHeaderOpen: %b, needProcessSurfaceWhenResumed: %b, needCloseWhenPaused: %b", new Object[] { Boolean.valueOf(localAppBrandDesktopView.mwR), Boolean.valueOf(localAppBrandDesktopView.mwV), Boolean.valueOf(localAppBrandDesktopView.mwW) });
      if ((localAppBrandDesktopView.mwR) && (localAppBrandDesktopView.mwV))
      {
        if ((b.abe()) && (localAppBrandDesktopView.mtL != null) && (localAppBrandDesktopView.mtL.byv()))
        {
          ac.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView");
          ((View)localAppBrandDesktopView.mtL.getParent()).setBackgroundColor(localAppBrandDesktopView.mContext.getResources().getColor(2131101053));
          View localView = localAppBrandDesktopView.mtL.getBackgroundGradientView();
          if (localView != null) {
            localView.setVisibility(0);
          }
          localView = localAppBrandDesktopView.mtL.getBackgroundGLSurfaceView();
          if ((localView instanceof DynamicBackgroundGLSurfaceView))
          {
            localView.setVisibility(0);
            if (localAppBrandDesktopView.mxb)
            {
              ((DynamicBackgroundGLSurfaceView)localView).onResume();
              localAppBrandDesktopView.mxb = false;
            }
            ac.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView show dynamicBackgroundView");
            localAppBrandDesktopView.postDelayed(new AppBrandDesktopView.4(localAppBrandDesktopView, localView), 100L);
          }
        }
        localAppBrandDesktopView.mwU = true;
        localAppBrandDesktopView.mwV = true;
      }
      if ((localAppBrandDesktopView.mwW) && (localAppBrandDesktopView.mtL != null))
      {
        localAppBrandDesktopView.mtL.m(0L, localAppBrandDesktopView.mwX);
        localAppBrandDesktopView.mwX = 0;
        localAppBrandDesktopView.mwW = false;
      }
      localAppBrandDesktopView.byT();
    }
    AppMethodBeat.o(49466);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49459);
    if ((this.mvl != null) && ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))) {
      this.mvl.onTouch(paramView, paramMotionEvent);
    }
    AppMethodBeat.o(49459);
    return false;
  }
  
  public void setActionBar(View paramView)
  {
    AppMethodBeat.i(49456);
    super.setActionBar(paramView);
    this.mgu = paramView;
    byJ();
    AppMethodBeat.o(49456);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    this.mvz = paramMMFragmentActivity;
  }
  
  public void setAnimController(com.tencent.mm.plugin.appbrand.widget.header.c paramc)
  {
    AppMethodBeat.i(49447);
    this.mvl = paramc;
    if ((this.mvm != null) && (this.mvl != null)) {
      this.mvl.a(this.mvm);
    }
    AppMethodBeat.o(49447);
  }
  
  public void setDynamicBackgroundView(View paramView)
  {
    AppMethodBeat.i(49465);
    a((DynamicBackgroundGLSurfaceView)paramView, this.mvo);
    AppMethodBeat.o(49465);
  }
  
  public void setExtraBottomHeight(int paramInt)
  {
    this.mvC = paramInt;
  }
  
  public void setFixedHeight(boolean paramBoolean)
  {
    this.mvA = paramBoolean;
  }
  
  public final void vu(int paramInt)
  {
    AppMethodBeat.i(49469);
    super.vu(paramInt);
    if (this.mvx != null) {
      this.mvx.setDrawColor(paramInt);
    }
    AppMethodBeat.o(49469);
  }
  
  static final class a
  {
    private static final a mvJ;
    private static final a mvK;
    int fMG = 4671303;
    int fMH = 2829099;
    int fMI = 4671303;
    int fMJ = 1842204;
    int fMK = 5460819;
    
    static
    {
      AppMethodBeat.i(187066);
      mvJ = new a(-12105913, -13948117, -12105913, -14935012, -11316397);
      mvK = new a(-11975584, -13948609, -11975584, -15263959, -11120530);
      AppMethodBeat.o(187066);
    }
    
    private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.fMG = paramInt1;
      this.fMH = paramInt2;
      this.fMI = paramInt3;
      this.fMJ = paramInt4;
      this.fMK = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainer
 * JD-Core Version:    0.7.0.1
 */