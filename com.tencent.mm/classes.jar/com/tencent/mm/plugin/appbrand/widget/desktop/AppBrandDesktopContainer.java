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
import com.tencent.mm.cd.g;
import com.tencent.mm.dynamicbackground.model.DynamicBackgroundNative;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b.a;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView.b;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.ji.a;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
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
  private View mGU;
  private com.tencent.mm.plugin.appbrand.widget.header.c mVS;
  private AppBrandDesktopView mVT;
  private DynamicBackgroundGLSurfaceView mVU;
  private GradientColorBackgroundView mVV;
  private Rect mVW;
  private LinearLayout mVX;
  private View mVY;
  private TextView mVZ;
  private GyroView mVu;
  private WeImageView mWa;
  private WeImageView mWb;
  private View mWc;
  private View mWd;
  private AppBrandDesktopBottomView mWe;
  private View mWf;
  private MMFragmentActivity mWg;
  private boolean mWh;
  private int mWi;
  private int mWj;
  private boolean mWk;
  private boolean mWl;
  private e mWm;
  private Runnable mWn;
  private com.tencent.mm.sdk.b.c mWo;
  
  public AppBrandDesktopContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(49444);
    this.mVW = new Rect();
    this.mWh = true;
    this.aYS = 0;
    this.aYT = 0;
    this.mWi = 0;
    this.mWj = 0;
    this.aqz = 0;
    this.mWk = true;
    this.mWl = ac.fko();
    this.mWm = null;
    this.mWn = null;
    this.mWo = new com.tencent.mm.sdk.b.c() {};
    init(paramContext);
    AppMethodBeat.o(49444);
  }
  
  public AppBrandDesktopContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49445);
    this.mVW = new Rect();
    this.mWh = true;
    this.aYS = 0;
    this.aYT = 0;
    this.mWi = 0;
    this.mWj = 0;
    this.aqz = 0;
    this.mWk = true;
    this.mWl = ac.fko();
    this.mWm = null;
    this.mWn = null;
    this.mWo = new com.tencent.mm.sdk.b.c() {};
    init(paramContext);
    AppMethodBeat.o(49445);
  }
  
  public AppBrandDesktopContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49446);
    this.mVW = new Rect();
    this.mWh = true;
    this.aYS = 0;
    this.aYT = 0;
    this.mWi = 0;
    this.mWj = 0;
    this.aqz = 0;
    this.mWk = true;
    this.mWl = ac.fko();
    this.mWm = null;
    this.mWn = null;
    this.mWo = new com.tencent.mm.sdk.b.c() {};
    init(paramContext);
    AppMethodBeat.o(49446);
  }
  
  private void a(DynamicBackgroundGLSurfaceView paramDynamicBackgroundGLSurfaceView, GradientColorBackgroundView paramGradientColorBackgroundView)
  {
    AppMethodBeat.i(188948);
    this.mVU = paramDynamicBackgroundGLSurfaceView;
    this.mVV = paramGradientColorBackgroundView;
    bCP();
    if (this.mVS != null) {
      this.mVS.g(this.mVU, this.mVV);
    }
    AppMethodBeat.o(188948);
  }
  
  private void bCL()
  {
    AppMethodBeat.i(49449);
    int i = getResources().getConfiguration().orientation;
    this.mWi = 0;
    AppMethodBeat.o(49449);
  }
  
  private void bCM()
  {
    AppMethodBeat.i(49454);
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewScale measuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
    if (!this.mWk)
    {
      AppMethodBeat.o(49454);
      return;
    }
    if (this.mVX != null)
    {
      this.mVX.setScaleX(0.6F);
      this.mVX.setScaleY(0.6F);
    }
    AppMethodBeat.o(49454);
  }
  
  private void bCO()
  {
    AppMethodBeat.i(49457);
    int[] arrayOfInt;
    if ((this.mVZ != null) && (this.mGU != null))
    {
      arrayOfInt = new int[2];
      this.mGU.getLocationOnScreen(arrayOfInt);
      ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin location x: %d, y: %d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]) });
      if (Build.VERSION.SDK_INT < 24) {
        break label187;
      }
    }
    label180:
    label187:
    for (boolean bool = this.mWg.isInMultiWindowMode();; bool = false)
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((arrayOfInt[0] >= 0) || (bool))
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.mVZ.getLayoutParams();
        if (!bool) {
          break label180;
        }
      }
      for (int i = 0;; i = arrayOfInt[0])
      {
        localLayoutParams.leftMargin = (i + getResources().getDimensionPixelSize(2131165198));
        ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin leftMargin: %d", new Object[] { Integer.valueOf(localLayoutParams.leftMargin) });
        if (this.mVZ.getParent() != null) {
          this.mVZ.getParent().requestLayout();
        }
        this.mVY.setVisibility(0);
        AppMethodBeat.o(49457);
        return;
      }
    }
  }
  
  private void bCP()
  {
    AppMethodBeat.i(188947);
    Object localObject1 = e.bDe();
    if (localObject1 != this.mWm)
    {
      this.mWm = ((e)localObject1);
      if (this.mVU != null)
      {
        localObject1 = this.mVU;
        int i = this.mWm.ggg;
        int j = this.mWm.ggh;
        int k = this.mWm.ggi;
        int m = this.mWm.ggj;
        int n = this.mWm.ggk;
        Object localObject2 = ((DynamicBackgroundGLSurfaceView)localObject1).gfM;
        if (localObject2 != null)
        {
          ((DynamicBackgroundGLSurfaceView.b)localObject2).ggb = new DynamicBackgroundGLSurfaceView.b.a(i, j, k, m, n);
          if (((DynamicBackgroundGLSurfaceView.b)localObject2).ggc)
          {
            localObject1 = ((DynamicBackgroundGLSurfaceView.b)localObject2).gfQ;
            if (localObject1 != null)
            {
              DynamicBackgroundGLSurfaceView.b.a locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).ggb;
              if (locala == null) {
                p.gfZ();
              }
              i = locala.ggg;
              locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).ggb;
              if (locala == null) {
                p.gfZ();
              }
              j = locala.ggh;
              locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).ggb;
              if (locala == null) {
                p.gfZ();
              }
              k = locala.ggi;
              locala = ((DynamicBackgroundGLSurfaceView.b)localObject2).ggb;
              if (locala == null) {
                p.gfZ();
              }
              m = locala.ggj;
              localObject2 = ((DynamicBackgroundGLSurfaceView.b)localObject2).ggb;
              if (localObject2 == null) {
                p.gfZ();
              }
              ((DynamicBackgroundNative)localObject1).setColor(i, j, k, m, ((DynamicBackgroundGLSurfaceView.b.a)localObject2).ggk);
            }
          }
        }
      }
      if (this.mVV != null)
      {
        localObject1 = this.mVV;
        ((GradientColorBackgroundView)localObject1).post((Runnable)new GradientColorBackgroundView.b((GradientColorBackgroundView)localObject1, this.mWm.ggj, this.mWm.ggk));
      }
    }
    AppMethodBeat.o(188947);
  }
  
  private void dW(Context paramContext)
  {
    AppMethodBeat.i(49453);
    paramContext = LayoutInflater.from(paramContext).inflate(2131492982, null);
    this.mVX = ((LinearLayout)paramContext.findViewById(2131296708));
    this.mVu = ((GyroView)paramContext.findViewById(2131300673));
    this.mVY = paramContext.findViewById(2131296699);
    this.mVZ = ((TextView)paramContext.findViewById(2131296694));
    this.mWa = ((WeImageView)paramContext.findViewById(2131304422));
    this.mWb = ((WeImageView)paramContext.findViewById(2131303323));
    this.mWc = paramContext.findViewById(2131304423);
    this.mWd = paramContext.findViewById(2131303324);
    this.mWe = ((AppBrandDesktopBottomView)paramContext.findViewById(2131296695));
    this.mWa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49441);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((AppBrandDesktopContainer.a(AppBrandDesktopContainer.this) != null) && (AppBrandDesktopContainer.a(AppBrandDesktopContainer.this).bCz())) {
          AppBrandDesktopContainer.a(AppBrandDesktopContainer.this).vX(16);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(49441);
      }
    });
    this.mWb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49442);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((AppBrandDesktopContainer.a(AppBrandDesktopContainer.this) != null) && (AppBrandDesktopContainer.a(AppBrandDesktopContainer.this).bCz())) {
          AppBrandDesktopContainer.a(AppBrandDesktopContainer.this).vX(14);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(49442);
      }
    });
    bCM();
    this.mVT = ((AppBrandDesktopView)paramContext.findViewById(2131296711));
    this.mVT.setHeaderContainer(this);
    this.mVT.setId(2131296711);
    int i = this.mVT.getLeftRightMargin();
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktop view marginLeftRight: %d, width: %d, pivotX: %f, pivotY: %f", new Object[] { Integer.valueOf(i), Integer.valueOf(getMeasuredWidth()), Float.valueOf(this.mVX.getPivotX()), Float.valueOf(this.mVX.getPivotY()) });
    AppBrandDesktopView localAppBrandDesktopView = this.mVT;
    localAppBrandDesktopView.setPadding(i, localAppBrandDesktopView.getPaddingTop(), i, 0);
    addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(49453);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49450);
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer init");
    this.aqz = com.tencent.mm.cc.a.fromDPToPix(paramContext, 16);
    bCL();
    setBackgroundColor(getResources().getColor(2131101053));
    com.tencent.mm.plugin.appbrand.widget.desktop.a.a locala = com.tencent.mm.plugin.appbrand.widget.desktop.a.a.mZg;
    com.tencent.mm.plugin.appbrand.widget.desktop.a.a.bDl();
    dW(paramContext);
    AppMethodBeat.o(49450);
  }
  
  private void setActionBarTitle(String paramString)
  {
    AppMethodBeat.i(180414);
    if (this.mVZ != null)
    {
      this.mVZ.setText(paramString);
      float f = com.tencent.mm.cc.a.ay(getContext(), 2131165184) * com.tencent.mm.cc.a.ik(getContext());
      if (this.mVZ.getTextSize() != f) {
        this.mVZ.setTextSize(0, f);
      }
      al.a(this.mVZ.getPaint(), 0.8F);
    }
    AppMethodBeat.o(180414);
  }
  
  public final boolean bCA()
  {
    AppMethodBeat.i(49461);
    if (this.mVS != null)
    {
      boolean bool = this.mVS.bCA();
      AppMethodBeat.o(49461);
      return bool;
    }
    AppMethodBeat.o(49461);
    return false;
  }
  
  public final void bCN()
  {
    AppMethodBeat.i(49455);
    if (this.mVT != null) {
      this.mVT.setPadding(this.mVT.getLeftRightMargin(), this.mVT.getPaddingTop(), this.mVT.getLeftRightMargin(), 0);
    }
    AppMethodBeat.o(49455);
  }
  
  public final void e(Configuration paramConfiguration)
  {
    AppMethodBeat.i(49460);
    super.e(paramConfiguration);
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo AppBrandDesktopContainer onCustomConfigurationChanged newConfig orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.mWn != null) {
      removeCallbacks(this.mWn);
    }
    this.mVY.setVisibility(4);
    Object localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49443);
        AppBrandDesktopContainer.b(AppBrandDesktopContainer.this);
        AppMethodBeat.o(49443);
      }
    };
    this.mWn = ((Runnable)localObject);
    postDelayed((Runnable)localObject, 400L);
    wa(getResources().getColor(2131100705));
    if (this.mVT != null)
    {
      localObject = this.mVT;
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged lastOrientation: %d, orientation: %d", new Object[] { Integer.valueOf(((AppBrandDesktopView)localObject).gOl), Integer.valueOf(paramConfiguration.orientation) });
      if (((AppBrandDesktopView)localObject).mUr != null)
      {
        ((AppBrandDesktopView)localObject).mXb = ((AppBrandDesktopView)localObject).mUr.getViewHeight();
        ad.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onCustomConfigurationChanged fixedViewHeight: %d", new Object[] { Integer.valueOf(((AppBrandDesktopView)localObject).mXb) });
      }
      if (((AppBrandDesktopView)localObject).gOl != paramConfiguration.orientation)
      {
        ((AppBrandDesktopView)localObject).gOl = paramConfiguration.orientation;
        if ((((AppBrandDesktopView)localObject).mUr != null) && (((AppBrandDesktopView)localObject).mUr.bCA()))
        {
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onCustomConfigurationChanged closeHeader");
          ((AppBrandDesktopView)localObject).mUr.l(0L, 0);
        }
      }
    }
    AppMethodBeat.o(49460);
  }
  
  public final void es(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49458);
    if (!this.mWk)
    {
      if (paramInt1 <= 10) {
        this.mWk = true;
      }
      AppMethodBeat.o(49458);
      return;
    }
    float f3;
    AppBrandDesktopView localAppBrandDesktopView;
    if (this.mVX != null)
    {
      if (paramInt1 <= 10)
      {
        AppMethodBeat.o(49458);
        return;
      }
      this.mVX.setTranslationY(getMeasuredHeight() - getBottom());
      f3 = Math.max(Math.min(1.0F * paramInt1 / paramInt2 * 0.4F + 0.6F, 1.0F), 0.6F);
      this.mVX.setScaleX(f3);
      this.mVX.setScaleY(f3);
      ad.v("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer onScroll scale: %f, scrollY: %d, totalHeight: %d", new Object[] { Float.valueOf(f3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.mVT != null)
      {
        localAppBrandDesktopView = this.mVT;
        if (!localAppBrandDesktopView.dzB) {
          break label189;
        }
        localAppBrandDesktopView.aN(1.0F);
      }
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        this.mWk = false;
      }
      AppMethodBeat.o(49458);
      return;
      label189:
      int i = 0;
      if (localAppBrandDesktopView.mUr != null) {
        i = localAppBrandDesktopView.mUr.getAnimationScrollOffset();
      }
      int j = localAppBrandDesktopView.mWS;
      int k = localAppBrandDesktopView.mWS;
      k = localAppBrandDesktopView.getCollectionDataSize() + k;
      ad.v("MicroMsg.AppBrandDesktopView", "alvinluo onScroll scrollY: %d, totalHeight: %d, startPos: %d, endPos: %d, animationOffset: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localAppBrandDesktopView.mWS), Integer.valueOf(k), Integer.valueOf(i) });
      int m = paramInt2 - i;
      int n = paramInt1 - i;
      Object localObject1;
      if ((localAppBrandDesktopView.mWT) || (localAppBrandDesktopView.mWU))
      {
        if (m - localAppBrandDesktopView.mXG > n)
        {
          f1 = 0.0F;
          localAppBrandDesktopView.aN(Math.min(1.0F, Math.max(0.0F, f1)));
        }
      }
      else
      {
        int i1 = (k - j) / localAppBrandDesktopView.apA;
        int i2 = localAppBrandDesktopView.mXG;
        float f2 = 0.0F;
        f1 = f2;
        if (localAppBrandDesktopView.mWT)
        {
          i = localAppBrandDesktopView.mXh;
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
        int i3 = (int)(localAppBrandDesktopView.mXh + com.tencent.mm.cc.a.fromDPToPix(localAppBrandDesktopView.mContext, 16) + f1);
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
        f1 = 1.0F * (n - (m - localAppBrandDesktopView.mXG)) / localAppBrandDesktopView.mXG;
        break;
        label602:
        f1 = Math.min(0.0F, (localAppBrandDesktopView.mXN + f1) * f3 * n / m - (f1 + localAppBrandDesktopView.mXN));
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
    if (this.mVZ != null) {
      this.mVZ.setTextColor(paramInt1);
    }
    if (this.mWa != null)
    {
      this.mWa.setImageResource(2131689494);
      this.mWa.setIconColor(paramInt2);
    }
    if (this.mWb != null)
    {
      this.mWb.setImageResource(2131690510);
      this.mWb.setIconColor(paramInt2);
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
    int i = this.mVS.getAnimationScrollOffset();
    AppMethodBeat.o(49471);
    return i;
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.mVW;
  }
  
  public View getBackgroundGLSurfaceView()
  {
    return this.mVU;
  }
  
  public View getBackgroundGradientView()
  {
    return this.mVV;
  }
  
  public View getEmptyView()
  {
    return null;
  }
  
  public int getExtraBottomHeight()
  {
    return this.mWj;
  }
  
  public GyroView getGyroView()
  {
    return this.mVu;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.header.a.a getHeaderView()
  {
    return null;
  }
  
  public View getMaskView()
  {
    return this.mWf;
  }
  
  public int getViewHeight()
  {
    return this.aYT;
  }
  
  public final void ic(boolean paramBoolean)
  {
    AppMethodBeat.i(49472);
    super.ic(paramBoolean);
    if (this.mVT != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.mVT;
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyMultiWindowModeChanged: %b, old: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(localAppBrandDesktopView.dzB) });
      if (localAppBrandDesktopView.dzB != paramBoolean)
      {
        localAppBrandDesktopView.dzB = paramBoolean;
        int i = localAppBrandDesktopView.mWS;
        int j = localAppBrandDesktopView.mWS;
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
    if (this.mVS != null) {
      this.mVS.b(paramLong, paramInt, false);
    }
    AppMethodBeat.o(49462);
  }
  
  public final void m(long paramLong, int paramInt)
  {
    AppMethodBeat.i(49463);
    super.m(paramLong, paramInt);
    if (this.mVS != null) {
      this.mVS.b(paramLong, paramInt, true);
    }
    AppMethodBeat.o(49463);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(49451);
    super.onAttachedToWindow();
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onAttachedToWindow");
    if (this.mWo != null) {
      this.mWo.alive();
    }
    ji localji = new ji();
    com.tencent.mm.sdk.b.a.IbL.l(localji);
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateUnReadCount unReadCount: %d", new Object[] { Integer.valueOf(localji.dwf.dwg) });
    Object localObject2 = getContext().getResources().getString(2131755822);
    if (!d.Fnm)
    {
      localObject1 = localObject2;
      if (!i.IS_FLAVOR_BLUE) {}
    }
    else
    {
      if (!this.mWl) {
        break label225;
      }
    }
    label225:
    for (Object localObject1 = (String)localObject2 + g.is(getContext());; localObject1 = (String)localObject2 + " " + g.is(getContext()))
    {
      localObject2 = localObject1;
      if (localji.dwf.dwg > 0)
      {
        localObject2 = localObject1;
        if (!this.mWl) {
          localObject2 = (String)localObject1 + " ";
        }
        localObject2 = (String)localObject2 + "(" + localji.dwf.dwg + ")";
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
    if (this.mVT != null)
    {
      localAppBrandDesktopView = this.mVT;
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onDestroy %d", new Object[] { Integer.valueOf(localAppBrandDesktopView.hashCode()) });
    }
    try
    {
      if (localAppBrandDesktopView.mWY != null)
      {
        localObject = localAppBrandDesktopView.mWY;
        if (((RecentAppBrandViewContainer)localObject).acb != null) {
          ((RecentAppBrandViewContainer)localObject).removeCallbacks(((RecentAppBrandViewContainer)localObject).acb);
        }
      }
      if (localAppBrandDesktopView.mXf != null)
      {
        localAppBrandDesktopView.removeCallbacks(localAppBrandDesktopView.mXf);
        localAppBrandDesktopView.mXf = null;
      }
      if (localAppBrandDesktopView.mXg != null)
      {
        localAppBrandDesktopView.removeCallbacks(localAppBrandDesktopView.mXg);
        localAppBrandDesktopView.mXg = null;
      }
      Object localObject = com.tencent.mm.plugin.appbrand.widget.desktop.b.c.nan.bDC();
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.widget.desktop.b.b)localObject).remove(localAppBrandDesktopView.mXC);
      }
      localObject = com.tencent.mm.plugin.appbrand.widget.desktop.b.c.nan.bDB();
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.widget.desktop.b.e)localObject).remove(localAppBrandDesktopView.mXD);
      }
      localAppBrandDesktopView.mXE = false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandDesktopView", localException, "alvinluo onDestroy exception", new Object[0]);
      }
    }
    if (this.mWo != null) {
      this.mWo.dead();
    }
    if (this.mWn != null)
    {
      removeCallbacks(this.mWn);
      this.mWn = null;
    }
    AppMethodBeat.o(49468);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(49452);
    super.onDetachedFromWindow();
    ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onDetachedFromWindow");
    if (this.mWo != null) {
      this.mWo.dead();
    }
    AppMethodBeat.o(49452);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49448);
    bCL();
    ad.v("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure orientation: %d, closeHeight: %d, extraBottomHeight: %d", new Object[] { Integer.valueOf(getResources().getConfiguration().orientation), Integer.valueOf(this.mWi), Integer.valueOf(this.mWj) });
    if (this.mWh)
    {
      int i = ((ViewGroup)getParent()).getMeasuredHeight() - this.mWi - this.mWj - this.aqz;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      this.aYT = i;
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredWidth() != this.aYS)
      {
        ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure width new: %d, old: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.aYS) });
        this.aYS = getMeasuredWidth();
        ad.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewPivot getMeasuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
        this.mVX.setPivotX(getMeasuredWidth() / 2.0F);
        this.mVX.setPivotY(ar.dT(getContext()));
        bCM();
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
    if (this.mVT != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.mVT;
      localAppBrandDesktopView.isPaused = true;
      localAppBrandDesktopView.mXx = false;
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onPause isHeaderOpen: %b, needProcess: %b, needRecreate: %b", new Object[] { Boolean.valueOf(localAppBrandDesktopView.mXv), Boolean.valueOf(localAppBrandDesktopView.mXy), Boolean.valueOf(localAppBrandDesktopView.mXx) });
      if ((localAppBrandDesktopView.mXv) && (localAppBrandDesktopView.mXy))
      {
        localAppBrandDesktopView.mXz = true;
        localAppBrandDesktopView.bDd();
      }
    }
    AppMethodBeat.o(49467);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(49466);
    super.onResume();
    if (this.mVT != null)
    {
      AppBrandDesktopView localAppBrandDesktopView = this.mVT;
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume");
      localAppBrandDesktopView.isPaused = false;
      if (localAppBrandDesktopView.asc)
      {
        ad.v("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView onResume setLayoutFrozen false");
        localAppBrandDesktopView.setLayoutFrozen(false);
      }
      ad.i("MicroMsg.AppBrandDesktopView", "alvinluo onResume isHeaderOpen: %b, needProcessSurfaceWhenResumed: %b, needCloseWhenPaused: %b", new Object[] { Boolean.valueOf(localAppBrandDesktopView.mXv), Boolean.valueOf(localAppBrandDesktopView.mXz), Boolean.valueOf(localAppBrandDesktopView.mXA) });
      if ((localAppBrandDesktopView.mXv) && (localAppBrandDesktopView.mXz))
      {
        if ((b.adI()) && (localAppBrandDesktopView.mUr != null) && (localAppBrandDesktopView.mUr.bCA()))
        {
          ad.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView");
          ((View)localAppBrandDesktopView.mUr.getParent()).setBackgroundColor(localAppBrandDesktopView.mContext.getResources().getColor(2131101053));
          View localView = localAppBrandDesktopView.mUr.getBackgroundGradientView();
          if (localView != null) {
            localView.setVisibility(0);
          }
          localView = localAppBrandDesktopView.mUr.getBackgroundGLSurfaceView();
          if ((localView instanceof DynamicBackgroundGLSurfaceView))
          {
            localView.setVisibility(0);
            if (localAppBrandDesktopView.mXF)
            {
              ((DynamicBackgroundGLSurfaceView)localView).onResume();
              localAppBrandDesktopView.mXF = false;
            }
            ad.i("MicroMsg.AppBrandDesktopView", "alvinluo switchToDynamicBackgroundView show dynamicBackgroundView");
            localAppBrandDesktopView.postDelayed(new AppBrandDesktopView.4(localAppBrandDesktopView, localView), 100L);
          }
        }
        localAppBrandDesktopView.mXy = true;
        localAppBrandDesktopView.mXz = true;
      }
      if ((localAppBrandDesktopView.mXA) && (localAppBrandDesktopView.mUr != null))
      {
        localAppBrandDesktopView.mUr.m(0L, localAppBrandDesktopView.mXB);
        localAppBrandDesktopView.mXB = 0;
        localAppBrandDesktopView.mXA = false;
      }
      localAppBrandDesktopView.bCW();
    }
    AppMethodBeat.o(49466);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49459);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainer", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if ((this.mVS != null) && ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))) {
      this.mVS.onTouch(paramView, paramMotionEvent);
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainer", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(49459);
    return false;
  }
  
  public void setActionBar(View paramView)
  {
    AppMethodBeat.i(49456);
    super.setActionBar(paramView);
    this.mGU = paramView;
    bCO();
    AppMethodBeat.o(49456);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    this.mWg = paramMMFragmentActivity;
  }
  
  public void setAnimController(com.tencent.mm.plugin.appbrand.widget.header.c paramc)
  {
    AppMethodBeat.i(49447);
    this.mVS = paramc;
    if ((this.mVT != null) && (this.mVS != null)) {
      this.mVS.a(this.mVT);
    }
    AppMethodBeat.o(49447);
  }
  
  public void setDynamicBackgroundView(View paramView)
  {
    AppMethodBeat.i(49465);
    a((DynamicBackgroundGLSurfaceView)paramView, this.mVV);
    AppMethodBeat.o(49465);
  }
  
  public void setExtraBottomHeight(int paramInt)
  {
    this.mWj = paramInt;
  }
  
  public void setFixedHeight(boolean paramBoolean)
  {
    this.mWh = paramBoolean;
  }
  
  public final void wa(int paramInt)
  {
    AppMethodBeat.i(49469);
    super.wa(paramInt);
    if (this.mWe != null) {
      this.mWe.setDrawColor(paramInt);
    }
    AppMethodBeat.o(49469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainer
 * JD-Core Version:    0.7.0.1
 */