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
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.g;
import com.tencent.mm.dynamicbackground.model.DynamicBackgroundNative;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b.a;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView.b;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.a.jj.a;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import java.util.ArrayList;

public class AppBrandDesktopContainer
  extends HeaderContainer
  implements View.OnTouchListener
{
  private int aYS;
  private int aYT;
  private int aqz;
  private View mLY;
  private GyroView naA;
  private com.tencent.mm.plugin.appbrand.widget.header.c naY;
  private AppBrandDesktopView naZ;
  private DynamicBackgroundGLSurfaceView nba;
  private GradientColorBackgroundView nbb;
  private Rect nbc;
  private LinearLayout nbd;
  private View nbe;
  private TextView nbf;
  private WeImageView nbg;
  private WeImageView nbh;
  private View nbi;
  private View nbj;
  private AppBrandDesktopBottomView nbk;
  private View nbl;
  private MMFragmentActivity nbm;
  private boolean nbn;
  private int nbo;
  private int nbp;
  private boolean nbq;
  private boolean nbr;
  private e nbs;
  private Runnable nbt;
  private com.tencent.mm.sdk.b.c nbu;
  
  public AppBrandDesktopContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49444);
    this.nbc = new Rect();
    this.nbn = true;
    this.aYS = 0;
    this.aYT = 0;
    this.nbo = 0;
    this.nbp = 0;
    this.aqz = 0;
    this.nbq = true;
    this.nbr = ad.foi();
    this.nbs = null;
    this.nbt = null;
    this.nbu = new AppBrandDesktopContainer.1(this);
    init(paramContext);
    AppMethodBeat.o(49444);
  }
  
  public AppBrandDesktopContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49445);
    this.nbc = new Rect();
    this.nbn = true;
    this.aYS = 0;
    this.aYT = 0;
    this.nbo = 0;
    this.nbp = 0;
    this.aqz = 0;
    this.nbq = true;
    this.nbr = ad.foi();
    this.nbs = null;
    this.nbt = null;
    this.nbu = new AppBrandDesktopContainer.1(this);
    init(paramContext);
    AppMethodBeat.o(49445);
  }
  
  public AppBrandDesktopContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49446);
    this.nbc = new Rect();
    this.nbn = true;
    this.aYS = 0;
    this.aYT = 0;
    this.nbo = 0;
    this.nbp = 0;
    this.aqz = 0;
    this.nbq = true;
    this.nbr = ad.foi();
    this.nbs = null;
    this.nbt = null;
    this.nbu = new AppBrandDesktopContainer.1(this);
    init(paramContext);
    AppMethodBeat.o(49446);
  }
  
  private void a(DynamicBackgroundGLSurfaceView paramDynamicBackgroundGLSurfaceView, GradientColorBackgroundView paramGradientColorBackgroundView)
  {
    AppMethodBeat.i(223181);
    this.nba = paramDynamicBackgroundGLSurfaceView;
    this.nbb = paramGradientColorBackgroundView;
    bDH();
    if (this.naY != null) {
      this.naY.g(this.nba, this.nbb);
    }
    AppMethodBeat.o(223181);
  }
  
  private void bDD()
  {
    AppMethodBeat.i(49449);
    int i = getResources().getConfiguration().orientation;
    this.nbo = 0;
    AppMethodBeat.o(49449);
  }
  
  private void bDE()
  {
    AppMethodBeat.i(49454);
    ae.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewScale measuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
    if (!this.nbq)
    {
      AppMethodBeat.o(49454);
      return;
    }
    if (this.nbd != null)
    {
      this.nbd.setScaleX(0.6F);
      this.nbd.setScaleY(0.6F);
    }
    AppMethodBeat.o(49454);
  }
  
  private void bDG()
  {
    AppMethodBeat.i(49457);
    int[] arrayOfInt;
    if ((this.nbf != null) && (this.mLY != null))
    {
      arrayOfInt = new int[2];
      this.mLY.getLocationOnScreen(arrayOfInt);
      ae.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin location x: %d, y: %d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]) });
      if (Build.VERSION.SDK_INT < 24) {
        break label187;
      }
    }
    label180:
    label187:
    for (boolean bool = this.nbm.isInMultiWindowMode();; bool = false)
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((arrayOfInt[0] >= 0) || (bool))
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.nbf.getLayoutParams();
        if (!bool) {
          break label180;
        }
      }
      for (int i = 0;; i = arrayOfInt[0])
      {
        localLayoutParams.leftMargin = (i + getResources().getDimensionPixelSize(2131165198));
        ae.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin leftMargin: %d", new Object[] { Integer.valueOf(localLayoutParams.leftMargin) });
        if (this.nbf.getParent() != null) {
          this.nbf.getParent().requestLayout();
        }
        this.nbe.setVisibility(0);
        AppMethodBeat.o(49457);
        return;
      }
    }
  }
  
  private void bDH()
  {
    AppMethodBeat.i(223180);
    Object localObject1 = e.bDW();
    if (localObject1 != this.nbs)
    {
      this.nbs = ((e)localObject1);
      if (this.nba != null)
      {
        localObject1 = this.nba;
        int i = this.nbs.giy;
        int j = this.nbs.giz;
        int k = this.nbs.giA;
        int m = this.nbs.giB;
        int n = this.nbs.giC;
        Object localObject2 = ((DynamicBackgroundGLSurfaceView)localObject1).gie;
        if (localObject2 != null)
        {
          ((DynamicBackgroundGLSurfaceView.b)localObject2).git = new DynamicBackgroundGLSurfaceView.b.a(i, j, k, m, n);
          if (((DynamicBackgroundGLSurfaceView.b)localObject2).giu)
          {
            localObject1 = ((DynamicBackgroundGLSurfaceView.b)localObject2).gii;
            if (localObject1 != null)
            {
              DynamicBackgroundGLSurfaceView.b.a locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).git;
              if (locala == null) {
                p.gkB();
              }
              i = locala.giy;
              locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).git;
              if (locala == null) {
                p.gkB();
              }
              j = locala.giz;
              locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).git;
              if (locala == null) {
                p.gkB();
              }
              k = locala.giA;
              locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).git;
              if (locala == null) {
                p.gkB();
              }
              m = locala.giB;
              localObject2 = ((DynamicBackgroundGLSurfaceView.b)localObject2).git;
              if (localObject2 == null) {
                p.gkB();
              }
              ((DynamicBackgroundNative)localObject1).setColor(i, j, k, m, ((DynamicBackgroundGLSurfaceView.b.a)localObject2).giC);
            }
          }
        }
      }
      if (this.nbb != null)
      {
        localObject1 = this.nbb;
        ((GradientColorBackgroundView)localObject1).post((Runnable)new GradientColorBackgroundView.b((GradientColorBackgroundView)localObject1, this.nbs.giB, this.nbs.giC));
      }
    }
    AppMethodBeat.o(223180);
  }
  
  private void ea(Context paramContext)
  {
    AppMethodBeat.i(49453);
    paramContext = LayoutInflater.from(paramContext).inflate(2131492982, null);
    this.nbd = ((LinearLayout)paramContext.findViewById(2131296708));
    this.naA = ((GyroView)paramContext.findViewById(2131300673));
    this.nbe = paramContext.findViewById(2131296699);
    this.nbf = ((TextView)paramContext.findViewById(2131296694));
    this.nbg = ((WeImageView)paramContext.findViewById(2131304422));
    this.nbh = ((WeImageView)paramContext.findViewById(2131303323));
    this.nbi = paramContext.findViewById(2131304423);
    this.nbj = paramContext.findViewById(2131303324);
    this.nbk = ((AppBrandDesktopBottomView)paramContext.findViewById(2131296695));
    this.nbg.setOnClickListener(new AppBrandDesktopContainer.2(this));
    this.nbh.setOnClickListener(new AppBrandDesktopContainer.3(this));
    bDE();
    this.naZ = ((AppBrandDesktopView)paramContext.findViewById(2131296711));
    this.naZ.setHeaderContainer(this);
    this.naZ.setId(2131296711);
    int i = this.naZ.getLeftRightMargin();
    ae.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktop view marginLeftRight: %d, width: %d, pivotX: %f, pivotY: %f", new Object[] { Integer.valueOf(i), Integer.valueOf(getMeasuredWidth()), Float.valueOf(this.nbd.getPivotX()), Float.valueOf(this.nbd.getPivotY()) });
    AppBrandDesktopView localAppBrandDesktopView = this.naZ;
    localAppBrandDesktopView.setPadding(i, localAppBrandDesktopView.getPaddingTop(), i, 0);
    addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(49453);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49450);
    ae.i("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer init");
    this.aqz = com.tencent.mm.cb.a.fromDPToPix(paramContext, 16);
    bDD();
    setBackgroundColor(getResources().getColor(2131101053));
    com.tencent.mm.plugin.appbrand.widget.desktop.a.a locala = com.tencent.mm.plugin.appbrand.widget.desktop.a.a.nen;
    com.tencent.mm.plugin.appbrand.widget.desktop.a.a.bEd();
    ea(paramContext);
    AppMethodBeat.o(49450);
  }
  
  private void setActionBarTitle(String paramString)
  {
    AppMethodBeat.i(180414);
    if (this.nbf != null)
    {
      this.nbf.setText(paramString);
      float f = com.tencent.mm.cb.a.ay(getContext(), 2131165184) * com.tencent.mm.cb.a.ip(getContext());
      if (this.nbf.getTextSize() != f) {
        this.nbf.setTextSize(0, f);
      }
      al.a(this.nbf.getPaint(), 0.8F);
    }
    AppMethodBeat.o(180414);
  }
  
  public final void bDF()
  {
    AppMethodBeat.i(49455);
    if (this.naZ != null) {
      this.naZ.setPadding(this.naZ.getLeftRightMargin(), this.naZ.getPaddingTop(), this.naZ.getLeftRightMargin(), 0);
    }
    AppMethodBeat.o(49455);
  }
  
  public final boolean bDs()
  {
    AppMethodBeat.i(49461);
    if (this.naY != null)
    {
      boolean bool = this.naY.bDs();
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
    ae.i("MicroMsg.AppBrandDesktopContainer", "alvinluo AppBrandDesktopContainer onCustomConfigurationChanged newConfig orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.nbt != null) {
      removeCallbacks(this.nbt);
    }
    this.nbe.setVisibility(4);
    Object localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49443);
        AppBrandDesktopContainer.b(AppBrandDesktopContainer.this);
        AppMethodBeat.o(49443);
      }
    };
    this.nbt = ((Runnable)localObject);
    postDelayed((Runnable)localObject, 400L);
    wf(getResources().getColor(2131100705));
    if (this.naZ != null)
    {
      localObject = this.naZ;
      ae.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged lastOrientation: %d, orientation: %d", new Object[] { Integer.valueOf(((AppBrandDesktopView)localObject).gQT), Integer.valueOf(paramConfiguration.orientation) });
      if (((AppBrandDesktopView)localObject).mZy != null)
      {
        ((AppBrandDesktopView)localObject).nch = ((AppBrandDesktopView)localObject).mZy.getViewHeight();
        ae.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged fixedViewHeight: %d", new Object[] { Integer.valueOf(((AppBrandDesktopView)localObject).nch) });
      }
      if (((AppBrandDesktopView)localObject).gQT != paramConfiguration.orientation)
      {
        ((AppBrandDesktopView)localObject).gQT = paramConfiguration.orientation;
        if ((((AppBrandDesktopView)localObject).mZy != null) && (((AppBrandDesktopView)localObject).mZy.bDs()))
        {
          ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onCustomConfigurationChanged closeHeader");
          ((AppBrandDesktopView)localObject).mZy.l(0L, 0);
        }
      }
    }
    AppMethodBeat.o(49460);
  }
  
  public final void es(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49458);
    if (!this.nbq)
    {
      if (paramInt1 <= 10) {
        this.nbq = true;
      }
      AppMethodBeat.o(49458);
      return;
    }
    float f3;
    AppBrandDesktopView localAppBrandDesktopView;
    if (this.nbd != null)
    {
      if (paramInt1 <= 10)
      {
        AppMethodBeat.o(49458);
        return;
      }
      this.nbd.setTranslationY(getMeasuredHeight() - getBottom());
      f3 = Math.max(Math.min(1.0F * paramInt1 / paramInt2 * 0.4F + 0.6F, 1.0F), 0.6F);
      this.nbd.setScaleX(f3);
      this.nbd.setScaleY(f3);
      ae.v("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer onScroll scale: %f, scrollY: %d, totalHeight: %d", new Object[] { Float.valueOf(f3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.naZ != null)
      {
        localAppBrandDesktopView = this.naZ;
        if (!localAppBrandDesktopView.dAG) {
          break label189;
        }
        localAppBrandDesktopView.aN(1.0F);
      }
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        this.nbq = false;
      }
      AppMethodBeat.o(49458);
      return;
      label189:
      int i = 0;
      if (localAppBrandDesktopView.mZy != null) {
        i = localAppBrandDesktopView.mZy.getAnimationScrollOffset();
      }
      int j = localAppBrandDesktopView.nbY;
      int k = localAppBrandDesktopView.nbY;
      k = localAppBrandDesktopView.getCollectionDataSize() + k;
      ae.v("MicroMsg.AppBrandDesktopView", "alvinluo onScroll scrollY: %d, totalHeight: %d, startPos: %d, endPos: %d, animationOffset: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localAppBrandDesktopView.nbY), Integer.valueOf(k), Integer.valueOf(i) });
      int m = paramInt2 - i;
      int n = paramInt1 - i;
      Object localObject1;
      if ((localAppBrandDesktopView.nbZ) || (localAppBrandDesktopView.nca))
      {
        if (m - localAppBrandDesktopView.ncN > n)
        {
          f1 = 0.0F;
          localAppBrandDesktopView.aN(Math.min(1.0F, Math.max(0.0F, f1)));
        }
      }
      else
      {
        int i1 = (k - j) / localAppBrandDesktopView.apA;
        int i2 = localAppBrandDesktopView.ncN;
        float f2 = 0.0F;
        f1 = f2;
        if (localAppBrandDesktopView.nbZ)
        {
          i = localAppBrandDesktopView.nco;
          localObject1 = localAppBrandDesktopView.ci(2);
          f1 = f2;
          if (localObject1 != null)
          {
            f1 = f2;
            if (((RecyclerView.w)localObject1).auu != null)
            {
              f1 = Math.min(0.0F, i * f3 * n / (m - i2) - i);
              ((RecyclerView.w)localObject1).auu.setTranslationY(f1);
              f1 = Math.abs(f1);
            }
          }
        }
        int i3 = (int)(localAppBrandDesktopView.nco + com.tencent.mm.cb.a.fromDPToPix(localAppBrandDesktopView.mContext, 16) + f1);
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
        ae.v("MicroMsg.AppBrandDesktopView", "alvinluo onScroll lastRowTranslationY: %f, row: %d", new Object[] { Float.valueOf(f1), Integer.valueOf(i) });
        i += 1;
        break label487;
        f1 = 1.0F * (n - (m - localAppBrandDesktopView.ncN)) / localAppBrandDesktopView.ncN;
        break;
        label602:
        f1 = Math.min(0.0F, (localAppBrandDesktopView.ncU + f1) * f3 * n / m - (f1 + localAppBrandDesktopView.ncU));
        ((ArrayList)localObject1).add(Float.valueOf(f1));
      }
      label653:
      i = j;
      while (i < k)
      {
        Object localObject2 = localAppBrandDesktopView.ci(i);
        if (((localObject2 instanceof f)) && (((RecyclerView.w)localObject2).auu != null))
        {
          localObject2 = (f)localObject2;
          m = (i - j) / localAppBrandDesktopView.apA;
          ((f)localObject2).auu.setTranslationY(((Float)((ArrayList)localObject1).get(m)).floatValue());
        }
        i += 1;
      }
    }
  }
  
  public final void et(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49470);
    super.et(paramInt1, paramInt2);
    if (this.nbf != null) {
      this.nbf.setTextColor(paramInt1);
    }
    if (this.nbg != null)
    {
      this.nbg.setImageResource(2131689494);
      this.nbg.setIconColor(paramInt2);
    }
    if (this.nbh != null)
    {
      this.nbh.setImageResource(2131690510);
      this.nbh.setIconColor(paramInt2);
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
    int i = this.naY.getAnimationScrollOffset();
    AppMethodBeat.o(49471);
    return i;
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.nbc;
  }
  
  public View getBackgroundGLSurfaceView()
  {
    return this.nba;
  }
  
  public View getBackgroundGradientView()
  {
    return this.nbb;
  }
  
  public View getEmptyView()
  {
    return null;
  }
  
  public int getExtraBottomHeight()
  {
    return this.nbp;
  }
  
  public GyroView getGyroView()
  {
    return this.naA;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.header.a.a getHeaderView()
  {
    return null;
  }
  
  public View getMaskView()
  {
    return this.nbl;
  }
  
  public int getViewHeight()
  {
    return this.aYT;
  }
  
  public final void ia(boolean paramBoolean)
  {
    AppMethodBeat.i(49472);
    super.ia(paramBoolean);
    if (this.naZ != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.naZ;
      ae.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyMultiWindowModeChanged: %b, old: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(localAppBrandDesktopView.dAG) });
      if (localAppBrandDesktopView.dAG != paramBoolean)
      {
        localAppBrandDesktopView.dAG = paramBoolean;
        int i = localAppBrandDesktopView.nbY;
        int j = localAppBrandDesktopView.nbY;
        int k = localAppBrandDesktopView.getCollectionDataSize();
        while (i < k + j)
        {
          RecyclerView.w localw = localAppBrandDesktopView.ci(i);
          if (((localw instanceof f)) && (localw.auu != null)) {
            ((f)localw).auu.setTranslationY(0.0F);
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
    if (this.naY != null) {
      this.naY.b(paramLong, paramInt, false);
    }
    AppMethodBeat.o(49462);
  }
  
  public final void m(long paramLong, int paramInt)
  {
    AppMethodBeat.i(49463);
    super.m(paramLong, paramInt);
    if (this.naY != null) {
      this.naY.b(paramLong, paramInt, true);
    }
    AppMethodBeat.o(49463);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(49451);
    super.onAttachedToWindow();
    ae.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onAttachedToWindow");
    if (this.nbu != null) {
      this.nbu.alive();
    }
    jj localjj = new jj();
    com.tencent.mm.sdk.b.a.IvT.l(localjj);
    ae.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateUnReadCount unReadCount: %d", new Object[] { Integer.valueOf(localjj.dxk.dxl) });
    Object localObject2 = getContext().getResources().getString(2131755822);
    if (!d.FFK)
    {
      localObject1 = localObject2;
      if (!j.IS_FLAVOR_BLUE) {}
    }
    else
    {
      if (!this.nbr) {
        break label225;
      }
    }
    label225:
    for (Object localObject1 = (String)localObject2 + g.ix(getContext());; localObject1 = (String)localObject2 + " " + g.ix(getContext()))
    {
      localObject2 = localObject1;
      if (localjj.dxk.dxl > 0)
      {
        localObject2 = localObject1;
        if (!this.nbr) {
          localObject2 = (String)localObject1 + " ";
        }
        localObject2 = (String)localObject2 + "(" + localjj.dxk.dxl + ")";
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
    if (this.naZ != null)
    {
      localAppBrandDesktopView = this.naZ;
      ae.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onDestroy %d", new Object[] { Integer.valueOf(localAppBrandDesktopView.hashCode()) });
    }
    try
    {
      if (localAppBrandDesktopView.nce != null)
      {
        localObject = localAppBrandDesktopView.nce;
        if (((RecentAppBrandViewContainer)localObject).acb != null) {
          ((RecentAppBrandViewContainer)localObject).removeCallbacks(((RecentAppBrandViewContainer)localObject).acb);
        }
      }
      if (localAppBrandDesktopView.ncl != null)
      {
        localAppBrandDesktopView.removeCallbacks(localAppBrandDesktopView.ncl);
        localAppBrandDesktopView.ncl = null;
      }
      if (localAppBrandDesktopView.ncm != null)
      {
        localAppBrandDesktopView.removeCallbacks(localAppBrandDesktopView.ncm);
        localAppBrandDesktopView.ncm = null;
      }
      Object localObject = com.tencent.mm.plugin.appbrand.widget.desktop.b.c.nfv.bEu();
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.widget.desktop.b.b)localObject).remove(localAppBrandDesktopView.ncJ);
      }
      localObject = com.tencent.mm.plugin.appbrand.widget.desktop.b.c.nfv.bEt();
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.widget.desktop.b.e)localObject).remove(localAppBrandDesktopView.ncK);
      }
      localAppBrandDesktopView.ncL = false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandDesktopView", localException, "alvinluo onDestroy exception", new Object[0]);
      }
    }
    if (this.nbu != null) {
      this.nbu.dead();
    }
    if (this.nbt != null)
    {
      removeCallbacks(this.nbt);
      this.nbt = null;
    }
    AppMethodBeat.o(49468);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(49452);
    super.onDetachedFromWindow();
    ae.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onDetachedFromWindow");
    if (this.nbu != null) {
      this.nbu.dead();
    }
    AppMethodBeat.o(49452);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49448);
    bDD();
    ae.v("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure orientation: %d, closeHeight: %d, extraBottomHeight: %d", new Object[] { Integer.valueOf(getResources().getConfiguration().orientation), Integer.valueOf(this.nbo), Integer.valueOf(this.nbp) });
    if (this.nbn)
    {
      int i = ((ViewGroup)getParent()).getMeasuredHeight() - this.nbo - this.nbp - this.aqz;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      this.aYT = i;
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredWidth() != this.aYS)
      {
        ae.i("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure width new: %d, old: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.aYS) });
        this.aYS = getMeasuredWidth();
        ae.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewPivot getMeasuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
        this.nbd.setPivotX(getMeasuredWidth() / 2.0F);
        this.nbd.setPivotY(ar.dX(getContext()));
        bDE();
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
    if (this.naZ != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.naZ;
      localAppBrandDesktopView.isPaused = true;
      localAppBrandDesktopView.ncE = false;
      ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onPause isHeaderOpen: %b, needProcess: %b, needRecreate: %b", new Object[] { Boolean.valueOf(localAppBrandDesktopView.ncC), Boolean.valueOf(localAppBrandDesktopView.ncF), Boolean.valueOf(localAppBrandDesktopView.ncE) });
      if ((localAppBrandDesktopView.ncC) && (localAppBrandDesktopView.ncF))
      {
        localAppBrandDesktopView.ncG = true;
        localAppBrandDesktopView.bDV();
      }
    }
    AppMethodBeat.o(49467);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49466);
    super.onResume();
    if (this.naZ != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.naZ;
      ae.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume");
      localAppBrandDesktopView.isPaused = false;
      if (localAppBrandDesktopView.asc)
      {
        ae.v("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume setLayoutFrozen false");
        localAppBrandDesktopView.setLayoutFrozen(false);
      }
      ae.i("MicroMsg.AppBrandDesktopView", "alvinluo onResume isHeaderOpen: %b, needProcessSurfaceWhenResumed: %b, needCloseWhenPaused: %b", new Object[] { Boolean.valueOf(localAppBrandDesktopView.ncC), Boolean.valueOf(localAppBrandDesktopView.ncG), Boolean.valueOf(localAppBrandDesktopView.ncH) });
      if ((localAppBrandDesktopView.ncC) && (localAppBrandDesktopView.ncG))
      {
        if ((b.adU()) && (localAppBrandDesktopView.mZy != null) && (localAppBrandDesktopView.mZy.bDs()))
        {
          ae.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView");
          ((View)localAppBrandDesktopView.mZy.getParent()).setBackgroundColor(localAppBrandDesktopView.mContext.getResources().getColor(2131101053));
          View localView = localAppBrandDesktopView.mZy.getBackgroundGradientView();
          if (localView != null) {
            localView.setVisibility(0);
          }
          localView = localAppBrandDesktopView.mZy.getBackgroundGLSurfaceView();
          if ((localView instanceof DynamicBackgroundGLSurfaceView))
          {
            localView.setVisibility(0);
            if (localAppBrandDesktopView.ncM)
            {
              ((DynamicBackgroundGLSurfaceView)localView).onResume();
              localAppBrandDesktopView.ncM = false;
            }
            ae.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView show dynamicBackgroundView");
            localAppBrandDesktopView.postDelayed(new AppBrandDesktopView.4(localAppBrandDesktopView, localView), 100L);
          }
        }
        localAppBrandDesktopView.ncF = true;
        localAppBrandDesktopView.ncG = true;
      }
      if ((localAppBrandDesktopView.ncH) && (localAppBrandDesktopView.mZy != null))
      {
        localAppBrandDesktopView.mZy.m(0L, localAppBrandDesktopView.ncI);
        localAppBrandDesktopView.ncI = 0;
        localAppBrandDesktopView.ncH = false;
      }
      localAppBrandDesktopView.bDO();
    }
    AppMethodBeat.o(49466);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49459);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainer", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    if ((this.naY != null) && ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))) {
      this.naY.onTouch(paramView, paramMotionEvent);
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainer", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(49459);
    return false;
  }
  
  public void setActionBar(View paramView)
  {
    AppMethodBeat.i(49456);
    super.setActionBar(paramView);
    this.mLY = paramView;
    bDG();
    AppMethodBeat.o(49456);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    this.nbm = paramMMFragmentActivity;
  }
  
  public void setAnimController(com.tencent.mm.plugin.appbrand.widget.header.c paramc)
  {
    AppMethodBeat.i(49447);
    this.naY = paramc;
    if ((this.naZ != null) && (this.naY != null)) {
      this.naY.a(this.naZ);
    }
    AppMethodBeat.o(49447);
  }
  
  public void setDynamicBackgroundView(View paramView)
  {
    AppMethodBeat.i(49465);
    a((DynamicBackgroundGLSurfaceView)paramView, this.nbb);
    AppMethodBeat.o(49465);
  }
  
  public void setExtraBottomHeight(int paramInt)
  {
    this.nbp = paramInt;
  }
  
  public void setFixedHeight(boolean paramBoolean)
  {
    this.nbn = paramBoolean;
  }
  
  public final void wf(int paramInt)
  {
    AppMethodBeat.i(49469);
    super.wf(paramInt);
    if (this.nbk != null) {
      this.nbk.setDrawColor(paramInt);
    }
    AppMethodBeat.o(49469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainer
 * JD-Core Version:    0.7.0.1
 */