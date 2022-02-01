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
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.it.a;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import java.util.ArrayList;

public class AppBrandDesktopContainer
  extends HeaderContainer
  implements View.OnTouchListener
{
  private int aNI;
  private int aNJ;
  private int anM;
  private View lEz;
  private GyroView lSL;
  private int lTA;
  private boolean lTB;
  private boolean lTC;
  private a lTD;
  private Runnable lTE;
  private com.tencent.mm.sdk.b.c lTF;
  private com.tencent.mm.plugin.appbrand.widget.header.c lTj;
  private AppBrandDesktopView lTk;
  private DynamicBackgroundGLSurfaceView lTl;
  private GradientColorBackgroundView lTm;
  private Rect lTn;
  private LinearLayout lTo;
  private View lTp;
  private TextView lTq;
  private WeImageView lTr;
  private WeImageView lTs;
  private View lTt;
  private View lTu;
  private AppBrandDesktopBottomView lTv;
  private View lTw;
  private MMFragmentActivity lTx;
  private boolean lTy;
  private int lTz;
  
  public AppBrandDesktopContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49444);
    this.lTn = new Rect();
    this.lTy = true;
    this.aNI = 0;
    this.aNJ = 0;
    this.lTz = 0;
    this.lTA = 0;
    this.anM = 0;
    this.lTB = true;
    this.lTC = ac.eFq();
    this.lTD = null;
    this.lTE = null;
    this.lTF = new AppBrandDesktopContainer.1(this);
    init(paramContext);
    AppMethodBeat.o(49444);
  }
  
  public AppBrandDesktopContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49445);
    this.lTn = new Rect();
    this.lTy = true;
    this.aNI = 0;
    this.aNJ = 0;
    this.lTz = 0;
    this.lTA = 0;
    this.anM = 0;
    this.lTB = true;
    this.lTC = ac.eFq();
    this.lTD = null;
    this.lTE = null;
    this.lTF = new AppBrandDesktopContainer.1(this);
    init(paramContext);
    AppMethodBeat.o(49445);
  }
  
  public AppBrandDesktopContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49446);
    this.lTn = new Rect();
    this.lTy = true;
    this.aNI = 0;
    this.aNJ = 0;
    this.lTz = 0;
    this.lTA = 0;
    this.anM = 0;
    this.lTB = true;
    this.lTC = ac.eFq();
    this.lTD = null;
    this.lTE = null;
    this.lTF = new AppBrandDesktopContainer.1(this);
    init(paramContext);
    AppMethodBeat.o(49446);
  }
  
  private void a(DynamicBackgroundGLSurfaceView paramDynamicBackgroundGLSurfaceView, GradientColorBackgroundView paramGradientColorBackgroundView)
  {
    AppMethodBeat.i(196208);
    this.lTl = paramDynamicBackgroundGLSurfaceView;
    this.lTm = paramGradientColorBackgroundView;
    brK();
    if (this.lTj != null) {
      this.lTj.g(this.lTl, this.lTm);
    }
    AppMethodBeat.o(196208);
  }
  
  private void brG()
  {
    AppMethodBeat.i(49449);
    int i = getResources().getConfiguration().orientation;
    this.lTz = 0;
    AppMethodBeat.o(49449);
  }
  
  private void brH()
  {
    AppMethodBeat.i(49454);
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewScale measuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
    if (!this.lTB)
    {
      AppMethodBeat.o(49454);
      return;
    }
    if (this.lTo != null)
    {
      this.lTo.setScaleX(0.6F);
      this.lTo.setScaleY(0.6F);
    }
    AppMethodBeat.o(49454);
  }
  
  private void brJ()
  {
    AppMethodBeat.i(49457);
    int[] arrayOfInt;
    if ((this.lTq != null) && (this.lEz != null))
    {
      arrayOfInt = new int[2];
      this.lEz.getLocationOnScreen(arrayOfInt);
      ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin location x: %d, y: %d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]) });
      if (Build.VERSION.SDK_INT < 24) {
        break label187;
      }
    }
    label180:
    label187:
    for (boolean bool = this.lTx.isInMultiWindowMode();; bool = false)
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((arrayOfInt[0] >= 0) || (bool))
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.lTq.getLayoutParams();
        if (!bool) {
          break label180;
        }
      }
      for (int i = 0;; i = arrayOfInt[0])
      {
        localLayoutParams.leftMargin = (i + getResources().getDimensionPixelSize(2131165198));
        ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin leftMargin: %d", new Object[] { Integer.valueOf(localLayoutParams.leftMargin) });
        if (this.lTq.getParent() != null) {
          this.lTq.getParent().requestLayout();
        }
        this.lTp.setVisibility(0);
        AppMethodBeat.o(49457);
        return;
      }
    }
  }
  
  private void brK()
  {
    AppMethodBeat.i(196206);
    Object localObject1 = getBgParticlesColorConfig();
    if (localObject1 != this.lTD)
    {
      this.lTD = ((a)localObject1);
      if (this.lTl != null)
      {
        localObject1 = this.lTl;
        int i = this.lTD.fJa;
        int j = this.lTD.fJb;
        int k = this.lTD.fJc;
        int m = this.lTD.fJd;
        int n = this.lTD.fJe;
        Object localObject2 = ((DynamicBackgroundGLSurfaceView)localObject1).fIG;
        if (localObject2 != null)
        {
          ((DynamicBackgroundGLSurfaceView.b)localObject2).fIV = new DynamicBackgroundGLSurfaceView.b.a(i, j, k, m, n);
          if (((DynamicBackgroundGLSurfaceView.b)localObject2).fIW)
          {
            localObject1 = ((DynamicBackgroundGLSurfaceView.b)localObject2).fIK;
            if (localObject1 != null)
            {
              DynamicBackgroundGLSurfaceView.b.a locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).fIV;
              if (locala == null) {
                k.fvU();
              }
              i = locala.fJa;
              locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).fIV;
              if (locala == null) {
                k.fvU();
              }
              j = locala.fJb;
              locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).fIV;
              if (locala == null) {
                k.fvU();
              }
              k = locala.fJc;
              locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).fIV;
              if (locala == null) {
                k.fvU();
              }
              m = locala.fJd;
              localObject2 = ((DynamicBackgroundGLSurfaceView.b)localObject2).fIV;
              if (localObject2 == null) {
                k.fvU();
              }
              ((DynamicBackgroundNative)localObject1).setColor(i, j, k, m, ((DynamicBackgroundGLSurfaceView.b.a)localObject2).fJe);
            }
          }
        }
      }
      if (this.lTm != null)
      {
        localObject1 = this.lTm;
        ((GradientColorBackgroundView)localObject1).post((Runnable)new GradientColorBackgroundView.b((GradientColorBackgroundView)localObject1, this.lTD.fJd, this.lTD.fJe));
      }
    }
    AppMethodBeat.o(196206);
  }
  
  private void dO(Context paramContext)
  {
    AppMethodBeat.i(49453);
    paramContext = LayoutInflater.from(paramContext).inflate(2131492982, null);
    this.lTo = ((LinearLayout)paramContext.findViewById(2131296708));
    this.lSL = ((GyroView)paramContext.findViewById(2131300673));
    this.lTp = paramContext.findViewById(2131296699);
    this.lTq = ((TextView)paramContext.findViewById(2131296694));
    this.lTr = ((WeImageView)paramContext.findViewById(2131304422));
    this.lTs = ((WeImageView)paramContext.findViewById(2131303323));
    this.lTt = paramContext.findViewById(2131304423);
    this.lTu = paramContext.findViewById(2131303324);
    this.lTv = ((AppBrandDesktopBottomView)paramContext.findViewById(2131296695));
    this.lTr.setOnClickListener(new AppBrandDesktopContainer.2(this));
    this.lTs.setOnClickListener(new AppBrandDesktopContainer.3(this));
    brH();
    this.lTk = ((AppBrandDesktopView)paramContext.findViewById(2131296711));
    this.lTk.setHeaderContainer(this);
    this.lTk.setId(2131296711);
    int i = this.lTk.getLeftRightMargin();
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktop view marginLeftRight: %d, width: %d, pivotX: %f, pivotY: %f", new Object[] { Integer.valueOf(i), Integer.valueOf(getMeasuredWidth()), Float.valueOf(this.lTo.getPivotX()), Float.valueOf(this.lTo.getPivotY()) });
    AppBrandDesktopView localAppBrandDesktopView = this.lTk;
    localAppBrandDesktopView.setPadding(i, localAppBrandDesktopView.getPaddingTop(), i, 0);
    addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(49453);
  }
  
  private a getBgParticlesColorConfig()
  {
    AppMethodBeat.i(196207);
    if (ai.Eq())
    {
      locala = a.brL();
      AppMethodBeat.o(196207);
      return locala;
    }
    a locala = a.brM();
    AppMethodBeat.o(196207);
    return locala;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49450);
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer init");
    this.anM = com.tencent.mm.cd.a.fromDPToPix(paramContext, 16);
    brG();
    setBackgroundColor(getResources().getColor(2131101053));
    com.tencent.mm.plugin.appbrand.widget.desktop.a.a locala = com.tencent.mm.plugin.appbrand.widget.desktop.a.a.lWw;
    com.tencent.mm.plugin.appbrand.widget.desktop.a.a.bsh();
    dO(paramContext);
    AppMethodBeat.o(49450);
  }
  
  private void setActionBarTitle(String paramString)
  {
    AppMethodBeat.i(180414);
    if (this.lTq != null)
    {
      this.lTq.setText(paramString);
      float f = com.tencent.mm.cd.a.ap(getContext(), 2131165184) * com.tencent.mm.cd.a.hQ(getContext());
      if (this.lTq.getTextSize() != f) {
        this.lTq.setTextSize(0, f);
      }
      ai.a(this.lTq.getPaint(), 0.8F);
    }
    AppMethodBeat.o(180414);
  }
  
  public final void brI()
  {
    AppMethodBeat.i(49455);
    if (this.lTk != null) {
      this.lTk.setPadding(this.lTk.getLeftRightMargin(), this.lTk.getPaddingTop(), this.lTk.getLeftRightMargin(), 0);
    }
    AppMethodBeat.o(49455);
  }
  
  public final boolean brv()
  {
    AppMethodBeat.i(49461);
    if (this.lTj != null)
    {
      boolean bool = this.lTj.brv();
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
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo AppBrandDesktopContainer onCustomConfigurationChanged newConfig orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.lTE != null) {
      removeCallbacks(this.lTE);
    }
    this.lTp.setVisibility(4);
    Object localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49443);
        AppBrandDesktopContainer.b(AppBrandDesktopContainer.this);
        AppMethodBeat.o(49443);
      }
    };
    this.lTE = ((Runnable)localObject);
    postDelayed((Runnable)localObject, 400L);
    uD(getResources().getColor(2131100705));
    if (this.lTk != null)
    {
      localObject = this.lTk;
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged lastOrientation: %d, orientation: %d", new Object[] { Integer.valueOf(((AppBrandDesktopView)localObject).lgU), Integer.valueOf(paramConfiguration.orientation) });
      if (((AppBrandDesktopView)localObject).lRJ != null)
      {
        ((AppBrandDesktopView)localObject).lUu = ((AppBrandDesktopView)localObject).lRJ.getViewHeight();
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged fixedViewHeight: %d", new Object[] { Integer.valueOf(((AppBrandDesktopView)localObject).lUu) });
      }
      if (((AppBrandDesktopView)localObject).lgU != paramConfiguration.orientation)
      {
        ((AppBrandDesktopView)localObject).lgU = paramConfiguration.orientation;
        if ((((AppBrandDesktopView)localObject).lRJ != null) && (((AppBrandDesktopView)localObject).lRJ.brv()))
        {
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onCustomConfigurationChanged closeHeader");
          ((AppBrandDesktopView)localObject).lRJ.k(0L, 0);
        }
      }
    }
    AppMethodBeat.o(49460);
  }
  
  public final void en(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49458);
    if (!this.lTB)
    {
      if (paramInt1 <= 10) {
        this.lTB = true;
      }
      AppMethodBeat.o(49458);
      return;
    }
    float f3;
    AppBrandDesktopView localAppBrandDesktopView;
    if (this.lTo != null)
    {
      if (paramInt1 <= 10)
      {
        AppMethodBeat.o(49458);
        return;
      }
      this.lTo.setTranslationY(getMeasuredHeight() - getBottom());
      f3 = Math.max(Math.min(1.0F * paramInt1 / paramInt2 * 0.4F + 0.6F, 1.0F), 0.6F);
      this.lTo.setScaleX(f3);
      this.lTo.setScaleY(f3);
      ad.v("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer onScroll scale: %f, scrollY: %d, totalHeight: %d", new Object[] { Float.valueOf(f3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.lTk != null)
      {
        localAppBrandDesktopView = this.lTk;
        if (!localAppBrandDesktopView.dqc) {
          break label189;
        }
        localAppBrandDesktopView.aG(1.0F);
      }
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        this.lTB = false;
      }
      AppMethodBeat.o(49458);
      return;
      label189:
      int i = 0;
      if (localAppBrandDesktopView.lRJ != null) {
        i = localAppBrandDesktopView.lRJ.getAnimationScrollOffset();
      }
      int j = localAppBrandDesktopView.lUl;
      int k = localAppBrandDesktopView.lUl;
      k = localAppBrandDesktopView.getCollectionDataSize() + k;
      ad.v("MicroMsg.AppBrandDesktopView", "alvinluo onScroll scrollY: %d, totalHeight: %d, startPos: %d, endPos: %d, animationOffset: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localAppBrandDesktopView.lUl), Integer.valueOf(k), Integer.valueOf(i) });
      int m = paramInt2 - i;
      int n = paramInt1 - i;
      Object localObject1;
      if ((localAppBrandDesktopView.lUm) || (localAppBrandDesktopView.lUn))
      {
        if (m - localAppBrandDesktopView.lVa > n)
        {
          f1 = 0.0F;
          localAppBrandDesktopView.aG(Math.min(1.0F, Math.max(0.0F, f1)));
        }
      }
      else
      {
        int i1 = (k - j) / localAppBrandDesktopView.amN;
        int i2 = localAppBrandDesktopView.lVa;
        float f2 = 0.0F;
        f1 = f2;
        if (localAppBrandDesktopView.lUm)
        {
          i = localAppBrandDesktopView.lUB;
          localObject1 = localAppBrandDesktopView.cj(2);
          f1 = f2;
          if (localObject1 != null)
          {
            f1 = f2;
            if (((RecyclerView.v)localObject1).arI != null)
            {
              f1 = Math.min(0.0F, i * f3 * n / (m - i2) - i);
              ((RecyclerView.v)localObject1).arI.setTranslationY(f1);
              f1 = Math.abs(f1);
            }
          }
        }
        int i3 = (int)(localAppBrandDesktopView.lUB + com.tencent.mm.cd.a.fromDPToPix(localAppBrandDesktopView.mContext, 16) + f1);
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
        ad.v("MicroMsg.AppBrandDesktopView", "alvinluo onScroll lastRowTranslationY: %f, row: %d", new Object[] { Float.valueOf(f1), Integer.valueOf(i) });
        i += 1;
        break label487;
        f1 = 1.0F * (n - (m - localAppBrandDesktopView.lVa)) / localAppBrandDesktopView.lVa;
        break;
        label602:
        f1 = Math.min(0.0F, (localAppBrandDesktopView.lVh + f1) * f3 * n / m - (f1 + localAppBrandDesktopView.lVh));
        ((ArrayList)localObject1).add(Float.valueOf(f1));
      }
      label653:
      i = j;
      while (i < k)
      {
        Object localObject2 = localAppBrandDesktopView.cj(i);
        if (((localObject2 instanceof e)) && (((RecyclerView.v)localObject2).arI != null))
        {
          localObject2 = (e)localObject2;
          m = (i - j) / localAppBrandDesktopView.amN;
          ((e)localObject2).arI.setTranslationY(((Float)((ArrayList)localObject1).get(m)).floatValue());
        }
        i += 1;
      }
    }
  }
  
  public final void eo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49470);
    super.eo(paramInt1, paramInt2);
    if (this.lTq != null) {
      this.lTq.setTextColor(paramInt1);
    }
    if (this.lTr != null)
    {
      this.lTr.setImageResource(2131689494);
      this.lTr.setIconColor(paramInt2);
    }
    if (this.lTs != null)
    {
      this.lTs.setImageResource(2131690510);
      this.lTs.setIconColor(paramInt2);
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
    int i = this.lTj.getAnimationScrollOffset();
    AppMethodBeat.o(49471);
    return i;
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.lTn;
  }
  
  public View getBackgroundGLSurfaceView()
  {
    return this.lTl;
  }
  
  public View getBackgroundGradientView()
  {
    return this.lTm;
  }
  
  public View getEmptyView()
  {
    return null;
  }
  
  public int getExtraBottomHeight()
  {
    return this.lTA;
  }
  
  public GyroView getGyroView()
  {
    return this.lSL;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.header.a.a getHeaderView()
  {
    return null;
  }
  
  public View getMaskView()
  {
    return this.lTw;
  }
  
  public int getViewHeight()
  {
    return this.aNJ;
  }
  
  public final void hu(boolean paramBoolean)
  {
    AppMethodBeat.i(49472);
    super.hu(paramBoolean);
    if (this.lTk != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.lTk;
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyMultiWindowModeChanged: %b, old: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(localAppBrandDesktopView.dqc) });
      if (localAppBrandDesktopView.dqc != paramBoolean)
      {
        localAppBrandDesktopView.dqc = paramBoolean;
        int i = localAppBrandDesktopView.lUl;
        int j = localAppBrandDesktopView.lUl;
        int k = localAppBrandDesktopView.getCollectionDataSize();
        while (i < k + j)
        {
          RecyclerView.v localv = localAppBrandDesktopView.cj(i);
          if (((localv instanceof e)) && (localv.arI != null)) {
            ((e)localv).arI.setTranslationY(0.0F);
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
  
  public final void k(long paramLong, int paramInt)
  {
    AppMethodBeat.i(49462);
    super.k(paramLong, paramInt);
    if (this.lTj != null) {
      this.lTj.b(paramLong, paramInt, false);
    }
    AppMethodBeat.o(49462);
  }
  
  public final void l(long paramLong, int paramInt)
  {
    AppMethodBeat.i(49463);
    super.l(paramLong, paramInt);
    if (this.lTj != null) {
      this.lTj.b(paramLong, paramInt, true);
    }
    AppMethodBeat.o(49463);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(49451);
    super.onAttachedToWindow();
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onAttachedToWindow");
    if (this.lTF != null) {
      this.lTF.alive();
    }
    it localit = new it();
    com.tencent.mm.sdk.b.a.ESL.l(localit);
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateUnReadCount unReadCount: %d", new Object[] { Integer.valueOf(localit.dmK.dmL) });
    Object localObject2 = getContext().getResources().getString(2131755822);
    Object localObject1 = localObject2;
    if (d.CpN) {
      if (!this.lTC) {
        break label225;
      }
    }
    label225:
    for (localObject1 = (String)localObject2 + getContext().getResources().getString(2131755263);; localObject1 = (String)localObject2 + " " + getContext().getResources().getString(2131755263))
    {
      localObject2 = localObject1;
      if (localit.dmK.dmL > 0)
      {
        localObject2 = localObject1;
        if (!this.lTC) {
          localObject2 = (String)localObject1 + " ";
        }
        localObject2 = (String)localObject2 + "(" + localit.dmK.dmL + ")";
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
    if (this.lTk != null)
    {
      localAppBrandDesktopView = this.lTk;
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onDestroy %d", new Object[] { Integer.valueOf(localAppBrandDesktopView.hashCode()) });
    }
    try
    {
      if (localAppBrandDesktopView.lUr != null)
      {
        localObject = localAppBrandDesktopView.lUr;
        if (((RecentAppBrandViewContainer)localObject).Zq != null) {
          ((RecentAppBrandViewContainer)localObject).removeCallbacks(((RecentAppBrandViewContainer)localObject).Zq);
        }
      }
      if (localAppBrandDesktopView.lUy != null)
      {
        localAppBrandDesktopView.removeCallbacks(localAppBrandDesktopView.lUy);
        localAppBrandDesktopView.lUy = null;
      }
      if (localAppBrandDesktopView.lUz != null)
      {
        localAppBrandDesktopView.removeCallbacks(localAppBrandDesktopView.lUz);
        localAppBrandDesktopView.lUz = null;
      }
      Object localObject = com.tencent.mm.plugin.appbrand.widget.desktop.b.c.lXD.bsy();
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.widget.desktop.b.b)localObject).remove(localAppBrandDesktopView.lUW);
      }
      localObject = com.tencent.mm.plugin.appbrand.widget.desktop.b.c.lXD.bsx();
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.widget.desktop.b.e)localObject).remove(localAppBrandDesktopView.lUX);
      }
      localAppBrandDesktopView.lUY = false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandDesktopView", localException, "alvinluo onDestroy exception", new Object[0]);
      }
    }
    if (this.lTF != null) {
      this.lTF.dead();
    }
    if (this.lTE != null)
    {
      removeCallbacks(this.lTE);
      this.lTE = null;
    }
    AppMethodBeat.o(49468);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(49452);
    super.onDetachedFromWindow();
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onDetachedFromWindow");
    if (this.lTF != null) {
      this.lTF.dead();
    }
    AppMethodBeat.o(49452);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49448);
    brG();
    ad.v("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure orientation: %d, closeHeight: %d, extraBottomHeight: %d", new Object[] { Integer.valueOf(getResources().getConfiguration().orientation), Integer.valueOf(this.lTz), Integer.valueOf(this.lTA) });
    if (this.lTy)
    {
      int i = ((ViewGroup)getParent()).getMeasuredHeight() - this.lTz - this.lTA - this.anM;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      this.aNJ = i;
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredWidth() != this.aNI)
      {
        ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure width new: %d, old: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.aNI) });
        this.aNI = getMeasuredWidth();
        ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewPivot getMeasuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
        this.lTo.setPivotX(getMeasuredWidth() / 2.0F);
        this.lTo.setPivotY(ap.dL(getContext()));
        brH();
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
    if (this.lTk != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.lTk;
      localAppBrandDesktopView.isPaused = true;
      localAppBrandDesktopView.lUR = false;
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onPause isHeaderOpen: %b, needProcess: %b, needRecreate: %b", new Object[] { Boolean.valueOf(localAppBrandDesktopView.lUP), Boolean.valueOf(localAppBrandDesktopView.lUS), Boolean.valueOf(localAppBrandDesktopView.lUR) });
      if ((localAppBrandDesktopView.lUP) && (localAppBrandDesktopView.lUS))
      {
        localAppBrandDesktopView.lUT = true;
        localAppBrandDesktopView.bsa();
      }
    }
    AppMethodBeat.o(49467);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49466);
    super.onResume();
    if (this.lTk != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.lTk;
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume");
      localAppBrandDesktopView.isPaused = false;
      if (localAppBrandDesktopView.apo)
      {
        ad.v("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume setLayoutFrozen false");
        localAppBrandDesktopView.setLayoutFrozen(false);
      }
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onResume isHeaderOpen: %b, needProcessSurfaceWhenResumed: %b, needCloseWhenPaused: %b", new Object[] { Boolean.valueOf(localAppBrandDesktopView.lUP), Boolean.valueOf(localAppBrandDesktopView.lUT), Boolean.valueOf(localAppBrandDesktopView.lUU) });
      if ((localAppBrandDesktopView.lUP) && (localAppBrandDesktopView.lUT))
      {
        if ((b.aaf()) && (localAppBrandDesktopView.lRJ != null) && (localAppBrandDesktopView.lRJ.brv()))
        {
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView");
          ((View)localAppBrandDesktopView.lRJ.getParent()).setBackgroundColor(localAppBrandDesktopView.mContext.getResources().getColor(2131101053));
          View localView = localAppBrandDesktopView.lRJ.getBackgroundGradientView();
          if (localView != null) {
            localView.setVisibility(0);
          }
          localView = localAppBrandDesktopView.lRJ.getBackgroundGLSurfaceView();
          if ((localView instanceof DynamicBackgroundGLSurfaceView))
          {
            localView.setVisibility(0);
            if (localAppBrandDesktopView.lUZ)
            {
              ((DynamicBackgroundGLSurfaceView)localView).onResume();
              localAppBrandDesktopView.lUZ = false;
            }
            ad.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView show dynamicBackgroundView");
            localAppBrandDesktopView.postDelayed(new AppBrandDesktopView.4(localAppBrandDesktopView, localView), 100L);
          }
        }
        localAppBrandDesktopView.lUS = true;
        localAppBrandDesktopView.lUT = true;
      }
      if ((localAppBrandDesktopView.lUU) && (localAppBrandDesktopView.lRJ != null))
      {
        localAppBrandDesktopView.lRJ.l(0L, localAppBrandDesktopView.lUV);
        localAppBrandDesktopView.lUV = 0;
        localAppBrandDesktopView.lUU = false;
      }
      localAppBrandDesktopView.brT();
    }
    AppMethodBeat.o(49466);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49459);
    if ((this.lTj != null) && ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))) {
      this.lTj.onTouch(paramView, paramMotionEvent);
    }
    AppMethodBeat.o(49459);
    return false;
  }
  
  public void setActionBar(View paramView)
  {
    AppMethodBeat.i(49456);
    super.setActionBar(paramView);
    this.lEz = paramView;
    brJ();
    AppMethodBeat.o(49456);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    this.lTx = paramMMFragmentActivity;
  }
  
  public void setAnimController(com.tencent.mm.plugin.appbrand.widget.header.c paramc)
  {
    AppMethodBeat.i(49447);
    this.lTj = paramc;
    if ((this.lTk != null) && (this.lTj != null)) {
      this.lTj.a(this.lTk);
    }
    AppMethodBeat.o(49447);
  }
  
  public void setDynamicBackgroundView(View paramView)
  {
    AppMethodBeat.i(49465);
    a((DynamicBackgroundGLSurfaceView)paramView, this.lTm);
    AppMethodBeat.o(49465);
  }
  
  public void setExtraBottomHeight(int paramInt)
  {
    this.lTA = paramInt;
  }
  
  public void setFixedHeight(boolean paramBoolean)
  {
    this.lTy = paramBoolean;
  }
  
  public final void uD(int paramInt)
  {
    AppMethodBeat.i(49469);
    super.uD(paramInt);
    if (this.lTv != null) {
      this.lTv.setDrawColor(paramInt);
    }
    AppMethodBeat.o(49469);
  }
  
  static final class a
  {
    private static final a lTH;
    private static final a lTI;
    int fJa = 4671303;
    int fJb = 2829099;
    int fJc = 4671303;
    int fJd = 1842204;
    int fJe = 5460819;
    
    static
    {
      AppMethodBeat.i(196205);
      lTH = new a(-12105913, -13948117, -12105913, -14935012, -11316397);
      lTI = new a(-11975584, -13948609, -11975584, -15263959, -11120530);
      AppMethodBeat.o(196205);
    }
    
    private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.fJa = paramInt1;
      this.fJb = paramInt2;
      this.fJc = paramInt3;
      this.fJd = paramInt4;
      this.fJe = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainer
 * JD-Core Version:    0.7.0.1
 */