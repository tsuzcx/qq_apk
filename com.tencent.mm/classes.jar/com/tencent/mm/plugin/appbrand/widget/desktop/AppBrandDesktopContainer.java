package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GradientColorBackgroundView;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import java.util.ArrayList;

public class AppBrandDesktopContainer
  extends HeaderContainer
  implements View.OnTouchListener
{
  private int agF;
  private int asY;
  private int asZ;
  private View iQc;
  private DynamicBackgroundGLSurfaceView jbX;
  private GyroView jcR;
  private View jdA;
  private MMFragmentActivity jdB;
  private boolean jdC;
  private int jdD;
  private int jdE;
  private boolean jdF;
  private Runnable jdG;
  private com.tencent.mm.sdk.b.c jdH;
  private com.tencent.mm.plugin.appbrand.widget.header.c jdo;
  private AppBrandDesktopView jdp;
  private GradientColorBackgroundView jdq;
  private Rect jdr;
  private LinearLayout jds;
  private View jdt;
  private TextView jdu;
  private ImageView jdv;
  private ImageView jdw;
  private View jdx;
  private View jdy;
  private AppBrandDesktopBottomView jdz;
  
  public AppBrandDesktopContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(133713);
    this.jdr = new Rect();
    this.jdC = true;
    this.asY = 0;
    this.asZ = 0;
    this.jdD = 0;
    this.jdE = 0;
    this.agF = 0;
    this.jdF = true;
    this.jdG = null;
    this.jdH = new AppBrandDesktopContainer.1(this);
    init(paramContext);
    AppMethodBeat.o(133713);
  }
  
  public AppBrandDesktopContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133714);
    this.jdr = new Rect();
    this.jdC = true;
    this.asY = 0;
    this.asZ = 0;
    this.jdD = 0;
    this.jdE = 0;
    this.agF = 0;
    this.jdF = true;
    this.jdG = null;
    this.jdH = new AppBrandDesktopContainer.1(this);
    init(paramContext);
    AppMethodBeat.o(133714);
  }
  
  public AppBrandDesktopContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133715);
    this.jdr = new Rect();
    this.jdC = true;
    this.asY = 0;
    this.asZ = 0;
    this.jdD = 0;
    this.jdE = 0;
    this.agF = 0;
    this.jdF = true;
    this.jdG = null;
    this.jdH = new AppBrandDesktopContainer.1(this);
    init(paramContext);
    AppMethodBeat.o(133715);
  }
  
  private void aPj()
  {
    AppMethodBeat.i(133718);
    int i = getResources().getConfiguration().orientation;
    this.jdD = 0;
    AppMethodBeat.o(133718);
  }
  
  private void aPk()
  {
    AppMethodBeat.i(143641);
    if (this.jdH != null) {
      this.jdH.alive();
    }
    AppMethodBeat.o(143641);
  }
  
  private void aPl()
  {
    AppMethodBeat.i(143643);
    ab.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewScale measuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
    if (!this.jdF)
    {
      AppMethodBeat.o(143643);
      return;
    }
    if (this.jds != null)
    {
      this.jds.setScaleX(0.6F);
      this.jds.setScaleY(0.6F);
    }
    AppMethodBeat.o(143643);
  }
  
  private void aPn()
  {
    AppMethodBeat.i(143645);
    int[] arrayOfInt;
    if ((this.jdu != null) && (this.iQc != null))
    {
      arrayOfInt = new int[2];
      this.iQc.getLocationOnScreen(arrayOfInt);
      ab.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin location x: %d, y: %d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]) });
      if (Build.VERSION.SDK_INT < 24) {
        break label187;
      }
    }
    label180:
    label187:
    for (boolean bool = this.jdB.isInMultiWindowMode();; bool = false)
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((arrayOfInt[0] >= 0) || (bool))
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.jdu.getLayoutParams();
        if (!bool) {
          break label180;
        }
      }
      for (int i = 0;; i = arrayOfInt[0])
      {
        localLayoutParams.leftMargin = (i + getResources().getDimensionPixelSize(2131427506));
        ab.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin leftMargin: %d", new Object[] { Integer.valueOf(localLayoutParams.leftMargin) });
        if (this.jdu.getParent() != null) {
          this.jdu.getParent().requestLayout();
        }
        this.jdt.setVisibility(0);
        AppMethodBeat.o(143645);
        return;
      }
    }
  }
  
  private void dm(Context paramContext)
  {
    AppMethodBeat.i(143642);
    paramContext = LayoutInflater.from(paramContext).inflate(2130968672, null);
    this.jds = ((LinearLayout)paramContext.findViewById(2131821175));
    this.jcR = ((GyroView)paramContext.findViewById(2131820627));
    this.jdt = paramContext.findViewById(2131821177);
    this.jdu = ((TextView)paramContext.findViewById(2131821179));
    this.jdv = ((ImageView)paramContext.findViewById(2131821180));
    this.jdw = ((ImageView)paramContext.findViewById(2131821182));
    this.jdx = paramContext.findViewById(2131821181);
    this.jdy = paramContext.findViewById(2131821183);
    this.jdz = ((AppBrandDesktopBottomView)paramContext.findViewById(2131821178));
    this.jdv.setOnClickListener(new AppBrandDesktopContainer.2(this));
    this.jdw.setOnClickListener(new AppBrandDesktopContainer.3(this));
    aPl();
    this.jdp = ((AppBrandDesktopView)paramContext.findViewById(2131820554));
    this.jdp.setHeaderContainer(this);
    this.jdp.setId(2131820554);
    int i = this.jdp.getLeftRightMargin();
    ab.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktop view marginLeftRight: %d, width: %d, pivotX: %f, pivotY: %f", new Object[] { Integer.valueOf(i), Integer.valueOf(getMeasuredWidth()), Float.valueOf(this.jds.getPivotX()), Float.valueOf(this.jds.getPivotY()) });
    AppBrandDesktopView localAppBrandDesktopView = this.jdp;
    localAppBrandDesktopView.setPadding(i, localAppBrandDesktopView.getPaddingTop(), i, 0);
    addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(143642);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(133719);
    ab.i("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer init");
    this.agF = com.tencent.mm.cb.a.fromDPToPix(paramContext, 16);
    aPj();
    setBackgroundColor(getResources().getColor(2131690605));
    com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b localb = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.jgw;
    com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.aPI();
    dm(paramContext);
    aPk();
    AppMethodBeat.o(133719);
  }
  
  public final boolean aOY()
  {
    AppMethodBeat.i(133724);
    if (this.jdo != null)
    {
      boolean bool = this.jdo.aOY();
      AppMethodBeat.o(133724);
      return bool;
    }
    AppMethodBeat.o(133724);
    return false;
  }
  
  public final void aPm()
  {
    AppMethodBeat.i(133720);
    if (this.jdp != null) {
      this.jdp.setPadding(this.jdp.getLeftRightMargin(), this.jdp.getPaddingTop(), this.jdp.getLeftRightMargin(), 0);
    }
    AppMethodBeat.o(133720);
  }
  
  public final void b(Configuration paramConfiguration)
  {
    AppMethodBeat.i(133723);
    super.b(paramConfiguration);
    ab.i("MicroMsg.AppBrandDesktopContainer", "alvinluo AppBrandDesktopContainer onCustomConfigurationChanged newConfig orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.jdG != null) {
      removeCallbacks(this.jdG);
    }
    this.jdt.setVisibility(4);
    Object localObject = new AppBrandDesktopContainer.4(this);
    this.jdG = ((Runnable)localObject);
    postDelayed((Runnable)localObject, 400L);
    pZ(getResources().getColor(2131690316));
    if (this.jdp != null)
    {
      localObject = this.jdp;
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged lastOrientation: %d, orientation: %d", new Object[] { Integer.valueOf(((AppBrandDesktopView)localObject).iAy), Integer.valueOf(paramConfiguration.orientation) });
      if (((AppBrandDesktopView)localObject).jbP != null)
      {
        ((AppBrandDesktopView)localObject).jeu = ((AppBrandDesktopView)localObject).jbP.getViewHeight();
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged fixedViewHeight: %d", new Object[] { Integer.valueOf(((AppBrandDesktopView)localObject).jeu) });
      }
      if (((AppBrandDesktopView)localObject).iAy != paramConfiguration.orientation)
      {
        ((AppBrandDesktopView)localObject).iAy = paramConfiguration.orientation;
        if ((((AppBrandDesktopView)localObject).jbP != null) && (((AppBrandDesktopView)localObject).jbP.aOY()))
        {
          ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onCustomConfigurationChanged closeHeader");
          ((AppBrandDesktopView)localObject).jbP.j(0L, 0);
        }
      }
    }
    AppMethodBeat.o(133723);
  }
  
  public final void dr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143646);
    if (!this.jdF)
    {
      if (paramInt1 <= 10) {
        this.jdF = true;
      }
      AppMethodBeat.o(143646);
      return;
    }
    float f3;
    AppBrandDesktopView localAppBrandDesktopView;
    if (this.jds != null)
    {
      if (paramInt1 <= 10)
      {
        AppMethodBeat.o(143646);
        return;
      }
      this.jds.setTranslationY(getMeasuredHeight() - getBottom());
      f3 = Math.max(Math.min(1.0F * paramInt1 / paramInt2 * 0.4F + 0.6F, 1.0F), 0.6F);
      this.jds.setScaleX(f3);
      this.jds.setScaleY(f3);
      ab.v("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer onScroll scale: %f, scrollY: %d, totalHeight: %d", new Object[] { Float.valueOf(f3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.jdp != null)
      {
        localAppBrandDesktopView = this.jdp;
        if (!localAppBrandDesktopView.czT) {
          break label189;
        }
        localAppBrandDesktopView.aD(1.0F);
      }
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        this.jdF = false;
      }
      AppMethodBeat.o(143646);
      return;
      label189:
      int i = 0;
      if (localAppBrandDesktopView.jbP != null) {
        i = localAppBrandDesktopView.jbP.getAnimationScrollOffset();
      }
      int j = localAppBrandDesktopView.jel;
      int k = localAppBrandDesktopView.jel;
      k = localAppBrandDesktopView.getCollectionDataSize() + k;
      ab.v("MicroMsg.AppBrandDesktopView", "alvinluo onScroll scrollY: %d, totalHeight: %d, startPos: %d, endPos: %d, animationOffset: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localAppBrandDesktopView.jel), Integer.valueOf(k), Integer.valueOf(i) });
      int m = paramInt2 - i;
      int n = paramInt1 - i;
      Object localObject1;
      if ((localAppBrandDesktopView.jem) || (localAppBrandDesktopView.jen))
      {
        if (m - localAppBrandDesktopView.jeW > n)
        {
          f1 = 0.0F;
          localAppBrandDesktopView.aD(Math.min(1.0F, Math.max(0.0F, f1)));
        }
      }
      else
      {
        int i1 = (k - j) / localAppBrandDesktopView.afG;
        int i2 = localAppBrandDesktopView.jeW;
        float f2 = 0.0F;
        f1 = f2;
        if (localAppBrandDesktopView.jem)
        {
          i = localAppBrandDesktopView.jeB;
          localObject1 = localAppBrandDesktopView.bQ(2);
          f1 = f2;
          if (localObject1 != null)
          {
            f1 = f2;
            if (((RecyclerView.v)localObject1).aku != null)
            {
              f1 = Math.min(0.0F, i * f3 * n / (m - i2) - i);
              ((RecyclerView.v)localObject1).aku.setTranslationY(f1);
              f1 = Math.abs(f1);
            }
          }
        }
        int i3 = (int)(localAppBrandDesktopView.jeB + com.tencent.mm.cb.a.fromDPToPix(localAppBrandDesktopView.mContext, 16) + f1);
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
        ab.v("MicroMsg.AppBrandDesktopView", "alvinluo onScroll lastRowTranslationY: %f, row: %d", new Object[] { Float.valueOf(f1), Integer.valueOf(i) });
        i += 1;
        break label487;
        f1 = 1.0F * (n - (m - localAppBrandDesktopView.jeW)) / localAppBrandDesktopView.jeW;
        break;
        label602:
        f1 = Math.min(0.0F, (localAppBrandDesktopView.jfc + f1) * f3 * n / m - (f1 + localAppBrandDesktopView.jfc));
        ((ArrayList)localObject1).add(Float.valueOf(f1));
      }
      label653:
      i = j;
      while (i < k)
      {
        Object localObject2 = localAppBrandDesktopView.bQ(i);
        if (((localObject2 instanceof e)) && (((RecyclerView.v)localObject2).aku != null))
        {
          localObject2 = (e)localObject2;
          m = (i - j) / localAppBrandDesktopView.afG;
          ((e)localObject2).aku.setTranslationY(((Float)((ArrayList)localObject1).get(m)).floatValue());
        }
        i += 1;
      }
    }
  }
  
  public final void ds(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143648);
    super.ds(paramInt1, paramInt2);
    if (this.jdu != null) {
      this.jdu.setTextColor(paramInt1);
    }
    if (this.jdv != null) {
      this.jdv.setImageDrawable(aj.g(getContext(), 2131230741, paramInt2));
    }
    if (this.jdw != null) {
      this.jdw.setImageDrawable(aj.g(getContext(), 2131231480, paramInt2));
    }
    AppMethodBeat.o(143648);
  }
  
  public final void e(View paramView1, View paramView2)
  {
    AppMethodBeat.i(133727);
    this.jbX = ((DynamicBackgroundGLSurfaceView)paramView1);
    this.jdq = ((GradientColorBackgroundView)paramView2);
    if (this.jdo != null) {
      this.jdo.e(paramView1, paramView2);
    }
    AppMethodBeat.o(133727);
  }
  
  public final void fg(boolean paramBoolean)
  {
    AppMethodBeat.i(154352);
    super.fg(paramBoolean);
    if (this.jdp != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.jdp;
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyMultiWindowModeChanged: %b, old: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(localAppBrandDesktopView.czT) });
      if (localAppBrandDesktopView.czT != paramBoolean)
      {
        localAppBrandDesktopView.czT = paramBoolean;
        int i = localAppBrandDesktopView.jel;
        int j = localAppBrandDesktopView.jel;
        int k = localAppBrandDesktopView.getCollectionDataSize();
        while (i < k + j)
        {
          RecyclerView.v localv = localAppBrandDesktopView.bQ(i);
          if (((localv instanceof e)) && (localv.aku != null)) {
            ((e)localv).aku.setTranslationY(0.0F);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(154352);
  }
  
  public int getAnimationScrollOffset()
  {
    AppMethodBeat.i(143649);
    int i = this.jdo.getAnimationScrollOffset();
    AppMethodBeat.o(143649);
    return i;
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.jdr;
  }
  
  public View getBackgroundGLSurfaceView()
  {
    return this.jbX;
  }
  
  public View getBackgroundGradientView()
  {
    return this.jdq;
  }
  
  public View getEmptyView()
  {
    return null;
  }
  
  public int getExtraBottomHeight()
  {
    return this.jdE;
  }
  
  public GyroView getGyroView()
  {
    return this.jcR;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.header.a.a getHeaderView()
  {
    return null;
  }
  
  public View getMaskView()
  {
    return this.jdA;
  }
  
  public int getViewHeight()
  {
    return this.asZ;
  }
  
  public final boolean isFullScreen()
  {
    return true;
  }
  
  public final void j(long paramLong, int paramInt)
  {
    AppMethodBeat.i(133725);
    super.j(paramLong, paramInt);
    if (this.jdo != null) {
      this.jdo.c(paramLong, paramInt, false);
    }
    AppMethodBeat.o(133725);
  }
  
  public final void k(long paramLong, int paramInt)
  {
    AppMethodBeat.i(133726);
    super.k(paramLong, paramInt);
    if (this.jdo != null) {
      this.jdo.c(paramLong, paramInt, true);
    }
    AppMethodBeat.o(133726);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(133731);
    super.onDestroy();
    AppBrandDesktopView localAppBrandDesktopView;
    if (this.jdp != null)
    {
      localAppBrandDesktopView = this.jdp;
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onDestroy %d", new Object[] { Integer.valueOf(localAppBrandDesktopView.hashCode()) });
    }
    try
    {
      if (localAppBrandDesktopView.jer != null)
      {
        RecentAppBrandViewContainer localRecentAppBrandViewContainer = localAppBrandDesktopView.jer;
        if (localRecentAppBrandViewContainer.Sn != null) {
          localRecentAppBrandViewContainer.removeCallbacks(localRecentAppBrandViewContainer.Sn);
        }
      }
      if (localAppBrandDesktopView.jey != null)
      {
        localAppBrandDesktopView.removeCallbacks(localAppBrandDesktopView.jey);
        localAppBrandDesktopView.jey = null;
      }
      if (localAppBrandDesktopView.jez != null)
      {
        localAppBrandDesktopView.removeCallbacks(localAppBrandDesktopView.jez);
        localAppBrandDesktopView.jez = null;
      }
      if (localAppBrandDesktopView.jeS != null) {
        ((af)g.E(af.class)).remove(localAppBrandDesktopView.jeS);
      }
      if (localAppBrandDesktopView.jeT != null) {
        ((ag)g.E(ag.class)).remove(localAppBrandDesktopView.jeT);
      }
      localAppBrandDesktopView.jeU = false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandDesktopView", localException, "alvinluo onDestroy exception", new Object[0]);
      }
    }
    if (this.jdH != null) {
      this.jdH.dead();
    }
    if (this.jdG != null)
    {
      removeCallbacks(this.jdG);
      this.jdG = null;
    }
    AppMethodBeat.o(133731);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133717);
    aPj();
    ab.v("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure orientation: %d, closeHeight: %d, extraBottomHeight: %d", new Object[] { Integer.valueOf(getResources().getConfiguration().orientation), Integer.valueOf(this.jdD), Integer.valueOf(this.jdE) });
    if (this.jdC)
    {
      int i = ((ViewGroup)getParent()).getMeasuredHeight() - this.jdD - this.jdE - this.agF;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      this.asZ = i;
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredWidth() != this.asY)
      {
        ab.i("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure width new: %d, old: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.asY) });
        this.asY = getMeasuredWidth();
        ab.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewPivot getMeasuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
        this.jds.setPivotX(getMeasuredWidth() / 2.0F);
        this.jds.setPivotY(am.di(getContext()));
        aPl();
      }
      AppMethodBeat.o(133717);
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(133730);
    super.onPause();
    if (this.jdp != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.jdp;
      localAppBrandDesktopView.isPaused = true;
      localAppBrandDesktopView.jeN = false;
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onPause isHeaderOpen: %b, needProcess: %b, needRecreate: %b", new Object[] { Boolean.valueOf(localAppBrandDesktopView.jeL), Boolean.valueOf(localAppBrandDesktopView.jeO), Boolean.valueOf(localAppBrandDesktopView.jeN) });
      if ((localAppBrandDesktopView.jeL) && (localAppBrandDesktopView.jeO))
      {
        localAppBrandDesktopView.jeP = true;
        localAppBrandDesktopView.aPA();
      }
    }
    AppMethodBeat.o(133730);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(133729);
    super.onResume();
    if (this.jdp != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.jdp;
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume");
      localAppBrandDesktopView.isPaused = false;
      if (localAppBrandDesktopView.aih)
      {
        ab.v("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume setLayoutFrozen false");
        localAppBrandDesktopView.setLayoutFrozen(false);
      }
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onResume isHeaderOpen: %b, needProcessSurfaceWhenResumed: %b, needCloseWhenPaused: %b", new Object[] { Boolean.valueOf(localAppBrandDesktopView.jeL), Boolean.valueOf(localAppBrandDesktopView.jeP), Boolean.valueOf(localAppBrandDesktopView.jeQ) });
      if ((localAppBrandDesktopView.jeL) && (localAppBrandDesktopView.jeP))
      {
        if ((b.aPg()) && (localAppBrandDesktopView.jbP != null) && (localAppBrandDesktopView.jbP.aOY()))
        {
          ab.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView");
          ((View)localAppBrandDesktopView.jbP.getParent()).setBackgroundColor(localAppBrandDesktopView.mContext.getResources().getColor(2131690605));
          View localView = localAppBrandDesktopView.jbP.getBackgroundGradientView();
          if (localView != null) {
            localView.setVisibility(0);
          }
          localView = localAppBrandDesktopView.jbP.getBackgroundGLSurfaceView();
          if ((localView instanceof DynamicBackgroundGLSurfaceView))
          {
            localView.setVisibility(0);
            if (localAppBrandDesktopView.jeV)
            {
              ((DynamicBackgroundGLSurfaceView)localView).onResume();
              localAppBrandDesktopView.jeV = false;
            }
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView show dynamicBackgroundView");
            localAppBrandDesktopView.postDelayed(new AppBrandDesktopView.3(localAppBrandDesktopView, localView), 100L);
          }
        }
        localAppBrandDesktopView.jeO = true;
        localAppBrandDesktopView.jeP = true;
      }
      if ((localAppBrandDesktopView.jeQ) && (localAppBrandDesktopView.jbP != null))
      {
        localAppBrandDesktopView.jbP.k(0L, localAppBrandDesktopView.jeR);
        localAppBrandDesktopView.jeR = 0;
        localAppBrandDesktopView.jeQ = false;
      }
      localAppBrandDesktopView.aPu();
    }
    AppMethodBeat.o(133729);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(133722);
    if ((this.jdo != null) && ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))) {
      this.jdo.onTouch(paramView, paramMotionEvent);
    }
    AppMethodBeat.o(133722);
    return false;
  }
  
  public final void pZ(int paramInt)
  {
    AppMethodBeat.i(143647);
    super.pZ(paramInt);
    if (this.jdz != null) {
      this.jdz.setDrawColor(paramInt);
    }
    AppMethodBeat.o(143647);
  }
  
  public void setActionBar(View paramView)
  {
    AppMethodBeat.i(143644);
    super.setActionBar(paramView);
    this.iQc = paramView;
    aPn();
    AppMethodBeat.o(143644);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    this.jdB = paramMMFragmentActivity;
  }
  
  public void setAnimController(com.tencent.mm.plugin.appbrand.widget.header.c paramc)
  {
    AppMethodBeat.i(133716);
    this.jdo = paramc;
    if ((this.jdp != null) && (this.jdo != null)) {
      this.jdo.a(this.jdp);
    }
    AppMethodBeat.o(133716);
  }
  
  public void setDynamicBackgroundView(View paramView)
  {
    AppMethodBeat.i(133728);
    this.jbX = ((DynamicBackgroundGLSurfaceView)paramView);
    if (this.jdo != null) {
      this.jdo.e(this.jbX, this.jdq);
    }
    AppMethodBeat.o(133728);
  }
  
  public void setExtraBottomHeight(int paramInt)
  {
    this.jdE = paramInt;
  }
  
  public void setFixedHeight(boolean paramBoolean)
  {
    this.jdC = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainer
 * JD-Core Version:    0.7.0.1
 */