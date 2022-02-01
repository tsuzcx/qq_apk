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
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class b
  extends LinearLayout
  implements h.b, h.d, f
{
  private View mrI;
  protected int raJ;
  private b roA;
  private AppBrandCapsuleBarPlaceHolderView roB;
  private a roC;
  private d roD;
  private final Set<a> roE;
  private boolean roF;
  private AppBrandActionBarCustomImageView roG;
  protected ImageView ron;
  protected View roo;
  protected View rop;
  protected View roq;
  protected TextView ror;
  protected ProgressBar ros;
  protected CircleProgressDrawable rot;
  protected int rou;
  protected double rov;
  protected boolean rox;
  protected boolean roy;
  protected c roz;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135409);
    this.roz = new c();
    this.roC = new c((byte)0);
    this.roE = new LinkedHashSet();
    this.roF = false;
    this.rox = false;
    this.roy = false;
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setBackgroundResource(a.a.action_bar_color);
    this.mrI = LayoutInflater.from(getContext()).inflate(a.e.app_brand_action_bar, this, false);
    addView(this.mrI);
    this.raJ = -1;
    this.rou = getResources().getColor(a.a.action_bar_color);
    this.rov = 1.0D;
    this.rop = findViewById(a.d.actionbar_nav_area_container);
    this.ron = ((ImageView)findViewById(a.d.actionbar_nav_btn));
    this.roo = findViewById(a.d.actionbar_nav_area);
    this.roq = findViewById(a.d.actionbar_title_area);
    this.ror = ((TextView)findViewById(a.d.actionbar_title_main));
    this.ros = ((ProgressBar)findViewById(a.d.actionbar_loading_icon));
    this.rot = new CircleProgressDrawable(getContext());
    this.roB = ((AppBrandCapsuleBarPlaceHolderView)findViewById(a.d.actionbar_capsule_area_placeholder));
    this.roo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(242643);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((b.d(b.this) != null) && (!b.d(b.this).cS(paramAnonymousView)))
        {
          localObject = b.this.roz;
          paramAnonymousView = b.this.roo;
          if (!((c)localObject).roN.isEmpty())
          {
            localObject = ((c)localObject).roN.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242643);
      }
    });
    AppMethodBeat.o(135409);
  }
  
  private void Dx(int paramInt)
  {
    AppMethodBeat.i(135431);
    if (f.a.Dy(paramInt) == f.a.roV)
    {
      if (this.roA != null)
      {
        this.roA.setStyleColor(-1);
        AppMethodBeat.o(135431);
      }
    }
    else if (this.roA != null) {
      this.roA.setStyleColor(-16777216);
    }
    AppMethodBeat.o(135431);
  }
  
  private void cmZ()
  {
    AppMethodBeat.i(135419);
    this.roq.setOnClickListener(new View.OnClickListener()
    {
      private long roJ = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(244712);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (System.currentTimeMillis() - this.roJ < 250L)
        {
          paramAnonymousView = b.e(b.this).iterator();
          while (paramAnonymousView.hasNext()) {
            ((a)paramAnonymousView.next()).bXE();
          }
          this.roJ = 0L;
        }
        this.roJ = System.currentTimeMillis();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(244712);
      }
    });
    AppMethodBeat.o(135419);
  }
  
  private void cnc()
  {
    AppMethodBeat.i(135434);
    View localView = this.roo;
    if ((this.roy) || (this.rox)) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135434);
      return;
    }
  }
  
  private void setBackgroundColorInternal(int paramInt)
  {
    AppMethodBeat.i(135421);
    if (!this.roy)
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
        AppMethodBeat.i(244507);
        if (b.this.getParent() == null)
        {
          AppMethodBeat.o(244507);
          return;
        }
        if (b.f(b.this) == null)
        {
          ViewStub localViewStub = (ViewStub)b.this.findViewById(a.d.custom_right_btn_viewstub);
          if (localViewStub == null)
          {
            AppMethodBeat.o(244507);
            return;
          }
          localViewStub.inflate();
          b.a(b.this, (AppBrandActionBarCustomImageView)b.this.findViewById(a.d.custom_right_btn));
        }
        b.f(b.this).setVisibility(0);
        b.f(b.this).setImageBitmap(paramBitmap);
        b.f(b.this).setClickable(true);
        b.f(b.this).setOnClickListener(paramOnClickListener);
        AppMethodBeat.o(244507);
      }
    });
    AppMethodBeat.o(135440);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(135414);
    this.roE.add(parama);
    if (!this.roF)
    {
      cmZ();
      this.roF = true;
    }
    AppMethodBeat.o(135414);
  }
  
  public final void cna()
  {
    AppMethodBeat.i(135430);
    if (this.roC != null) {
      this.roC.a(this.ron, this.roo, this.rop);
    }
    this.ror.setTextColor(this.raJ);
    this.rot.setStrokeColor(this.raJ);
    this.ros.setIndeterminateDrawable(this.rot);
    Dx(this.raJ);
    AppMethodBeat.o(135430);
  }
  
  public final boolean cnb()
  {
    return this.rox;
  }
  
  public final boolean cnd()
  {
    AppMethodBeat.i(135436);
    if (this.ros.getVisibility() == 0)
    {
      AppMethodBeat.o(135436);
      return true;
    }
    AppMethodBeat.o(135436);
    return false;
  }
  
  public final boolean cne()
  {
    return this.roy;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(243030);
    if (this.rot != null) {
      this.rot.stop();
    }
    removeAllViews();
    AppMethodBeat.o(243030);
  }
  
  public View getActionView()
  {
    return this;
  }
  
  public final double getBackgroundAlpha()
  {
    return this.rov;
  }
  
  public final int getBackgroundColor()
  {
    if (this.roy) {
      return 0;
    }
    return this.rou;
  }
  
  public AppBrandCapsuleBarPlaceHolderView getCapsuleView()
  {
    return this.roB;
  }
  
  public int getForegroundColor()
  {
    return this.raJ;
  }
  
  public CharSequence getMainTitle()
  {
    AppMethodBeat.i(135418);
    CharSequence localCharSequence = this.ror.getText();
    AppMethodBeat.o(135418);
    return localCharSequence;
  }
  
  public a getNavResetStyleListener()
  {
    return this.roC;
  }
  
  public final void hi(boolean paramBoolean)
  {
    AppMethodBeat.i(135438);
    View localView = this.roo;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135438);
      return;
    }
  }
  
  public final void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(135439);
    View localView = this.roq;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135439);
      return;
    }
  }
  
  public final void hk(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(135424);
    Object localObject = this.roB;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((AppBrandCapsuleBarPlaceHolderView)localObject).setVisibility(i);
      if (this.roB.getLayoutParams() != null)
      {
        localObject = this.roB.getLayoutParams();
        i = j;
        if (paramBoolean) {
          i = -2;
        }
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.roB.requestLayout();
      }
      if (this.roA != null) {
        this.roA.yT(this.roB.getVisibility());
      }
      if (this.roG != null) {
        this.roG.setVisibility(8);
      }
      AppMethodBeat.o(135424);
      return;
    }
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(243031);
    if (this.rot != null) {
      this.rot.stop();
    }
    AppMethodBeat.o(243031);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(243032);
    if ((cnd()) && (this.rot != null)) {
      this.rot.start();
    }
    AppMethodBeat.o(243032);
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
    ViewGroup.LayoutParams localLayoutParams = this.mrI.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height != paramInt))
    {
      localLayoutParams.height = paramInt;
      this.mrI.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(178644);
  }
  
  public void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135410);
    c localc = this.roz;
    if (paramOnClickListener == null)
    {
      AppMethodBeat.o(135410);
      return;
    }
    localc.roN.add(paramOnClickListener);
    AppMethodBeat.o(135410);
  }
  
  public final void setBackgroundAlpha(double paramDouble)
  {
    AppMethodBeat.i(135420);
    this.rov = paramDouble;
    if (!this.roy)
    {
      Drawable localDrawable2 = super.getBackground();
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null)
      {
        setBackgroundColorInternal(this.rou);
        localDrawable1 = super.getBackground();
      }
      localDrawable1.setAlpha((int)(255.0D * paramDouble));
    }
    AppMethodBeat.o(135420);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135422);
    this.rou = paramInt;
    setBackgroundColorInternal(paramInt);
    setBackgroundAlpha(this.rov);
    AppMethodBeat.o(135422);
  }
  
  public final void setCapsuleBarInteractionDelegate(b paramb)
  {
    AppMethodBeat.i(243029);
    this.roA = paramb;
    if (this.roA != null)
    {
      this.roA.setOptionButtonOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(135404);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = b.this.roz;
          if (!((c)localObject).roO.isEmpty())
          {
            localObject = ((c)localObject).roO.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135404);
        }
      });
      this.roA.setHomeButtonOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(135405);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = b.this.roz;
          if (!((c)localObject).roM.isEmpty())
          {
            localObject = ((c)localObject).roM.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135405);
        }
      });
    }
    AppMethodBeat.o(243029);
  }
  
  public void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135411);
    c localc = this.roz;
    if (paramOnClickListener == null)
    {
      AppMethodBeat.o(135411);
      return;
    }
    localc.roM.add(paramOnClickListener);
    AppMethodBeat.o(135411);
  }
  
  public void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(135429);
    this.raJ = paramInt;
    cna();
    AppMethodBeat.o(135429);
  }
  
  public void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(135427);
    this.raJ = f.a.anB(paramString).roW;
    cna();
    AppMethodBeat.o(135427);
  }
  
  public void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(135428);
    if (paramBoolean) {}
    for (int i = -16777216;; i = -1)
    {
      this.raJ = i;
      cna();
      AppMethodBeat.o(135428);
      return;
    }
  }
  
  public void setFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(135437);
    this.roy = paramBoolean;
    cnc();
    View localView = this.roq;
    if (this.roy) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      requestLayout();
      setBackgroundColor(this.rou);
      AppMethodBeat.o(135437);
      return;
    }
  }
  
  public void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(135435);
    if (this.roD != null)
    {
      this.roD.jl(paramBoolean);
      AppMethodBeat.o(135435);
      return;
    }
    ProgressBar localProgressBar = this.ros;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      this.rot.cmW();
      this.rot.start();
      AppMethodBeat.o(135435);
      return;
    }
    this.rot.stop();
    AppMethodBeat.o(135435);
  }
  
  public void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(135415);
    boolean bool = isLayoutRequested();
    this.ror.setText(paramCharSequence);
    if (bool) {
      requestLayout();
    }
    AppMethodBeat.o(135415);
  }
  
  public void setNavButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(135413);
    this.roo.setOnLongClickListener(new b.4(this, paramOnLongClickListener));
    AppMethodBeat.o(135413);
  }
  
  public void setNavContainerMinimumWidth(int paramInt)
  {
    AppMethodBeat.i(178643);
    if (this.rop != null) {
      this.rop.setMinimumWidth(paramInt);
    }
    AppMethodBeat.o(178643);
  }
  
  public void setNavHidden(boolean paramBoolean)
  {
    AppMethodBeat.i(135433);
    this.rox = paramBoolean;
    cnc();
    cna();
    AppMethodBeat.o(135433);
  }
  
  public void setNavLoadingIconVisibilityResetListener(d paramd)
  {
    this.roD = paramd;
  }
  
  public void setNavResetStyleListener(a parama)
  {
    this.roC = parama;
  }
  
  public void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135423);
    c localc = this.roz;
    if (paramOnClickListener == null)
    {
      AppMethodBeat.o(135423);
      return;
    }
    localc.roO.add(paramOnClickListener);
    AppMethodBeat.o(135423);
  }
  
  public static abstract class a
  {
    public static final int roL = a.b.app_brand_actionbar_left_margin;
    
    protected abstract void a(ImageView paramImageView, View paramView1, View paramView2);
    
    protected boolean cS(View paramView)
    {
      return false;
    }
    
    public abstract int cdp();
  }
  
  public static abstract interface b
  {
    public abstract void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setStyleColor(int paramInt);
    
    public abstract void yT(int paramInt);
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
        paramImageView.setColorFilter(b.this.raJ, PorterDuff.Mode.SRC_ATOP);
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
    
    public final int cdp()
    {
      return a.b.app_brand_actionbar_left_margin;
    }
  }
  
  public static abstract interface d
  {
    public abstract void jl(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b
 * JD-Core Version:    0.7.0.1
 */