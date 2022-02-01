package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.luggage.wxa.a.a;
import com.tencent.luggage.wxa.a.b;
import com.tencent.luggage.wxa.a.d;
import com.tencent.luggage.wxa.a.e;
import com.tencent.luggage.wxa.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class b
  extends LinearLayout
  implements i.b, i.d, f
{
  private View plc;
  protected int ugz;
  protected CircleProgressDrawable uyA;
  protected int uyB;
  protected double uyC;
  protected boolean uyD;
  protected boolean uyE;
  protected c uyF;
  private b uyG;
  private AppBrandCapsuleBarPlaceHolderView uyH;
  private a uyI;
  private d uyJ;
  private final Set<a> uyK;
  private boolean uyL;
  private AppBrandActionBarCustomImageView uyM;
  protected ImageView uyu;
  protected View uyv;
  protected View uyw;
  protected View uyx;
  protected TextView uyy;
  protected ProgressBar uyz;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135409);
    this.uyF = new c();
    this.uyI = new c((byte)0);
    this.uyK = new LinkedHashSet();
    this.uyL = false;
    this.uyD = false;
    this.uyE = false;
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setBackgroundResource(a.a.action_bar_color);
    this.plc = LayoutInflater.from(getContext()).inflate(a.e.app_brand_action_bar, this, false);
    addView(this.plc);
    this.ugz = -1;
    this.uyB = getResources().getColor(a.a.action_bar_color);
    this.uyC = 1.0D;
    this.uyw = findViewById(a.d.actionbar_nav_area_container);
    this.uyu = ((ImageView)findViewById(a.d.actionbar_nav_btn));
    this.uyv = findViewById(a.d.actionbar_nav_area);
    this.uyx = findViewById(a.d.actionbar_title_area);
    this.uyy = ((TextView)findViewById(a.d.actionbar_title_main));
    this.uyz = ((ProgressBar)findViewById(a.d.actionbar_loading_icon));
    this.uyA = new CircleProgressDrawable(getContext());
    this.uyH = ((AppBrandCapsuleBarPlaceHolderView)findViewById(a.d.actionbar_capsule_area_placeholder));
    this.uyv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(324149);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((b.d(b.this) != null) && (!b.d(b.this).dz(paramAnonymousView)))
        {
          localObject = b.this.uyF;
          paramAnonymousView = b.this.uyv;
          if (!((c)localObject).uyT.isEmpty())
          {
            localObject = ((c)localObject).uyT.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(324149);
      }
    });
    AppMethodBeat.o(135409);
  }
  
  private void DW(int paramInt)
  {
    AppMethodBeat.i(135431);
    if (f.a.DX(paramInt) == f.a.uzg)
    {
      if (this.uyG != null)
      {
        this.uyG.setStyleColor(-1);
        AppMethodBeat.o(135431);
      }
    }
    else if (this.uyG != null) {
      this.uyG.setStyleColor(-16777216);
    }
    AppMethodBeat.o(135431);
  }
  
  private void cOS()
  {
    AppMethodBeat.i(135419);
    this.uyx.setOnClickListener(new b.5(this));
    AppMethodBeat.o(135419);
  }
  
  private void cOV()
  {
    AppMethodBeat.i(135434);
    View localView = this.uyv;
    if ((this.uyE) || (this.uyD)) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      requestLayout();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(324152);
          b.this.requestLayout();
          AppMethodBeat.o(324152);
        }
      });
      AppMethodBeat.o(135434);
      return;
    }
  }
  
  private void setBackgroundColorInternal(int paramInt)
  {
    AppMethodBeat.i(135421);
    if (!this.uyE)
    {
      super.setBackgroundColor(paramInt);
      AppMethodBeat.o(135421);
      return;
    }
    super.setBackgroundColor(0);
    AppMethodBeat.o(135421);
  }
  
  public final void a(final Bitmap paramBitmap, final View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135440);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(324148);
        if (b.this.getParent() == null)
        {
          AppMethodBeat.o(324148);
          return;
        }
        if (b.f(b.this) == null)
        {
          ViewStub localViewStub = (ViewStub)b.this.findViewById(a.d.custom_right_btn_viewstub);
          if (localViewStub == null)
          {
            AppMethodBeat.o(324148);
            return;
          }
          localViewStub.inflate();
          b.a(b.this, (AppBrandActionBarCustomImageView)b.this.findViewById(a.d.custom_right_btn));
        }
        b.f(b.this).setVisibility(0);
        b.f(b.this).setImageBitmap(paramBitmap);
        b.f(b.this).setClickable(true);
        b.f(b.this).setOnClickListener(paramOnClickListener);
        AppMethodBeat.o(324148);
      }
    });
    AppMethodBeat.o(135440);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(135414);
    this.uyK.add(parama);
    if (!this.uyL)
    {
      cOS();
      this.uyL = true;
    }
    AppMethodBeat.o(135414);
  }
  
  public final void cOT()
  {
    AppMethodBeat.i(135430);
    if (this.uyI != null) {
      this.uyI.a(this.uyu, this.uyv, this.uyw);
    }
    this.uyy.setTextColor(this.ugz);
    this.uyA.setStrokeColor(this.ugz);
    this.uyz.setIndeterminateDrawable(this.uyA);
    DW(this.ugz);
    AppMethodBeat.o(135430);
  }
  
  public final boolean cOU()
  {
    return this.uyD;
  }
  
  public final boolean cOW()
  {
    AppMethodBeat.i(135436);
    if (this.uyz.getVisibility() == 0)
    {
      AppMethodBeat.o(135436);
      return true;
    }
    AppMethodBeat.o(135436);
    return false;
  }
  
  public final boolean cOX()
  {
    return this.uyE;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(324193);
    if (this.uyA != null) {
      this.uyA.stop();
    }
    removeAllViews();
    this.uyI = null;
    AppMethodBeat.o(324193);
  }
  
  public View getActionView()
  {
    return this;
  }
  
  public final double getBackgroundAlpha()
  {
    return this.uyC;
  }
  
  public final int getBackgroundColor()
  {
    if (this.uyE) {
      return 0;
    }
    return this.uyB;
  }
  
  public AppBrandCapsuleBarPlaceHolderView getCapsuleView()
  {
    return this.uyH;
  }
  
  public int getForegroundColor()
  {
    return this.ugz;
  }
  
  public CharSequence getMainTitle()
  {
    AppMethodBeat.i(135418);
    CharSequence localCharSequence = this.uyy.getText();
    AppMethodBeat.o(135418);
    return localCharSequence;
  }
  
  public a getNavResetStyleListener()
  {
    return this.uyI;
  }
  
  public final void hZ(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(135424);
    Object localObject = this.uyH;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((AppBrandCapsuleBarPlaceHolderView)localObject).setVisibility(i);
      if (this.uyH.getLayoutParams() != null)
      {
        localObject = this.uyH.getLayoutParams();
        i = j;
        if (paramBoolean) {
          i = -2;
        }
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.uyH.requestLayout();
      }
      if (this.uyG != null) {
        this.uyG.zc(this.uyH.getVisibility());
      }
      if (this.uyM != null) {
        this.uyM.setVisibility(8);
      }
      AppMethodBeat.o(135424);
      return;
    }
  }
  
  public final void ia(boolean paramBoolean)
  {
    AppMethodBeat.i(135438);
    View localView = this.uyv;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135438);
      return;
    }
  }
  
  public final void ib(boolean paramBoolean)
  {
    AppMethodBeat.i(135439);
    View localView = this.uyx;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135439);
      return;
    }
  }
  
  public void onBackground()
  {
    AppMethodBeat.i(324196);
    if (this.uyA != null) {
      this.uyA.stop();
    }
    AppMethodBeat.o(324196);
  }
  
  public void onForeground()
  {
    AppMethodBeat.i(324202);
    if ((cOW()) && (this.uyA != null)) {
      this.uyA.start();
    }
    AppMethodBeat.o(324202);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(135416);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(135416);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135417);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(135417);
  }
  
  public void setActionBarHeight(int paramInt)
  {
    AppMethodBeat.i(178644);
    ViewGroup.LayoutParams localLayoutParams = this.plc.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height != paramInt))
    {
      localLayoutParams.height = paramInt;
      this.plc.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(178644);
  }
  
  public void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135410);
    c localc = this.uyF;
    if (paramOnClickListener == null)
    {
      AppMethodBeat.o(135410);
      return;
    }
    localc.uyT.add(paramOnClickListener);
    AppMethodBeat.o(135410);
  }
  
  public final void setBackgroundAlpha(double paramDouble)
  {
    AppMethodBeat.i(135420);
    this.uyC = paramDouble;
    if (!this.uyE)
    {
      Drawable localDrawable2 = super.getBackground();
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null)
      {
        setBackgroundColorInternal(this.uyB);
        localDrawable1 = super.getBackground();
      }
      localDrawable1.setAlpha((int)(255.0D * paramDouble));
    }
    AppMethodBeat.o(135420);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135422);
    this.uyB = paramInt;
    setBackgroundColorInternal(paramInt);
    setBackgroundAlpha(this.uyC);
    AppMethodBeat.o(135422);
  }
  
  public final void setCapsuleBarInteractionDelegate(b paramb)
  {
    AppMethodBeat.i(324187);
    this.uyG = paramb;
    if (this.uyG != null)
    {
      this.uyG.setOptionButtonOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(135404);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = b.this.uyF;
          if (!((c)localObject).uyU.isEmpty())
          {
            localObject = ((c)localObject).uyU.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135404);
        }
      });
      this.uyG.setHomeButtonOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(135405);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = b.this.uyF;
          if (!((c)localObject).uyS.isEmpty())
          {
            localObject = ((c)localObject).uyS.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135405);
        }
      });
    }
    AppMethodBeat.o(324187);
  }
  
  public void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135411);
    c localc = this.uyF;
    if (paramOnClickListener == null)
    {
      AppMethodBeat.o(135411);
      return;
    }
    localc.uyS.add(paramOnClickListener);
    AppMethodBeat.o(135411);
  }
  
  public void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(135429);
    this.ugz = paramInt;
    cOT();
    AppMethodBeat.o(135429);
  }
  
  public void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(135427);
    this.ugz = f.a.agY(paramString).uzh;
    cOT();
    AppMethodBeat.o(135427);
  }
  
  public void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(135428);
    if (paramBoolean) {}
    for (int i = -16777216;; i = -1)
    {
      this.ugz = i;
      cOT();
      AppMethodBeat.o(135428);
      return;
    }
  }
  
  public void setFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(135437);
    this.uyE = paramBoolean;
    cOV();
    View localView = this.uyx;
    if (this.uyE) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      requestLayout();
      setBackgroundColor(this.uyB);
      AppMethodBeat.o(135437);
      return;
    }
  }
  
  public void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(135435);
    if (this.uyJ != null)
    {
      this.uyJ.kw(paramBoolean);
      AppMethodBeat.o(135435);
      return;
    }
    ProgressBar localProgressBar = this.uyz;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      this.uyA.cQH();
      this.uyA.start();
      AppMethodBeat.o(135435);
      return;
    }
    this.uyA.stop();
    AppMethodBeat.o(135435);
  }
  
  public void setMainTitle(CharSequence paramCharSequence)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(135415);
    boolean bool = isLayoutRequested();
    this.uyy.setText(paramCharSequence);
    float f3 = com.tencent.mm.cd.a.bs(this.uyy.getContext(), a.b.ActionBarTextSize);
    paramCharSequence = this.uyy;
    float f4 = com.tencent.mm.cd.a.getScaleSize(this.uyy.getContext());
    float f1;
    if (f4 == 0.8F) {
      f1 = 0.91F;
    }
    for (;;)
    {
      paramCharSequence.setTextSize(0, f1 * f3);
      if (bool) {
        requestLayout();
      }
      AppMethodBeat.o(135415);
      return;
      f1 = f2;
      if (f4 != 1.0F) {
        if (f4 == 1.1F)
        {
          f1 = 1.11F;
        }
        else if (f4 == 1.12F)
        {
          f1 = 1.11F;
        }
        else if (f4 == 1.125F)
        {
          f1 = 1.18F;
        }
        else if (f4 == 1.4F)
        {
          f1 = 1.18F;
        }
        else if (f4 == 1.55F)
        {
          f1 = 1.18F;
        }
        else if (f4 == 1.65F)
        {
          f1 = 1.18F;
        }
        else
        {
          if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger()) || (WeChatEnvironment.isMonkeyEnv()))
          {
            paramCharSequence = new IllegalStateException(String.format("unhandled scale[%f]", new Object[] { Float.valueOf(f4) }));
            AppMethodBeat.o(135415);
            throw paramCharSequence;
          }
          Log.w("MicroMsg.AppBrandActionBarCommon", "getActionBarTextSizeScale: unhandled scale[%f]", new Object[] { Float.valueOf(f4) });
          f1 = f2;
        }
      }
    }
  }
  
  public void setNavButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(135413);
    this.uyv.setOnLongClickListener(new b.4(this, paramOnLongClickListener));
    AppMethodBeat.o(135413);
  }
  
  public void setNavContainerMinimumWidth(int paramInt)
  {
    AppMethodBeat.i(178643);
    if (this.uyw != null) {
      this.uyw.setMinimumWidth(paramInt);
    }
    AppMethodBeat.o(178643);
  }
  
  public void setNavHidden(boolean paramBoolean)
  {
    AppMethodBeat.i(135433);
    this.uyD = paramBoolean;
    cOV();
    cOT();
    AppMethodBeat.o(135433);
  }
  
  public void setNavLoadingIconVisibilityResetListener(d paramd)
  {
    this.uyJ = paramd;
  }
  
  public void setNavResetStyleListener(a parama)
  {
    this.uyI = parama;
  }
  
  public void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135423);
    c localc = this.uyF;
    if (paramOnClickListener == null)
    {
      AppMethodBeat.o(135423);
      return;
    }
    localc.uyU.add(paramOnClickListener);
    AppMethodBeat.o(135423);
  }
  
  public static abstract class a
  {
    public static final int uyR = a.b.app_brand_actionbar_left_margin;
    
    protected abstract void a(ImageView paramImageView, View paramView1, View paramView2);
    
    public abstract int cDN();
    
    protected boolean dz(View paramView)
    {
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setStyleColor(int paramInt);
    
    public abstract void zc(int paramInt);
  }
  
  final class c
    extends b.a
  {
    private c() {}
    
    public final void a(ImageView paramImageView, View paramView1, View paramView2)
    {
      AppMethodBeat.i(178641);
      if (paramImageView != null)
      {
        paramImageView.setImageResource(a.f.app_brand_back);
        paramImageView.setColorFilter(b.this.ugz, PorterDuff.Mode.SRC_ATOP);
        paramView2 = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
        paramView2.width = b.this.getContext().getResources().getDimensionPixelSize(a.b.app_brand_actionbar_back_arrow_width);
        paramView2.height = b.this.getContext().getResources().getDimensionPixelSize(a.b.app_brand_actionbar_back_arrow_height);
        paramView2.leftMargin = b.this.getContext().getResources().getDimensionPixelSize(a.b.app_brand_actionbar_left_margin);
        paramView2.rightMargin = b.this.getContext().getResources().getDimensionPixelSize(a.b.app_brand_actionbar_right_margin);
        paramImageView.setLayoutParams(paramView2);
      }
      if (paramView1 != null)
      {
        paramImageView = (ViewGroup.MarginLayoutParams)paramView1.getLayoutParams();
        paramImageView.leftMargin = 0;
        paramImageView.rightMargin = 0;
        paramView1.setLayoutParams(paramImageView);
      }
      AppMethodBeat.o(178641);
    }
    
    public final int cDN()
    {
      return a.b.app_brand_actionbar_left_margin;
    }
  }
  
  public static abstract interface d
  {
    public abstract void kw(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b
 * JD-Core Version:    0.7.0.1
 */