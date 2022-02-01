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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class b
  extends LinearLayout
  implements i.b, i.d, e
{
  private View jBN;
  protected int nYY;
  protected ImageView olL;
  protected View olM;
  protected View olN;
  protected View olO;
  protected TextView olP;
  protected ProgressBar olQ;
  protected CircleProgressDrawable olR;
  protected int olS;
  protected double olT;
  protected boolean olU;
  protected boolean olV;
  protected c olW;
  private b olX;
  private AppBrandCapsuleBarPlaceHolderView olY;
  private a olZ;
  private d oma;
  private final Set<a> omb;
  private boolean omc;
  private AppBrandActionBarCustomImageView omd;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135409);
    this.olW = new c();
    this.olZ = new c((byte)0);
    this.omb = new LinkedHashSet();
    this.omc = false;
    this.olU = false;
    this.olV = false;
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setBackgroundResource(2131099891);
    this.jBN = LayoutInflater.from(getContext()).inflate(2131492999, this, false);
    addView(this.jBN);
    this.nYY = -1;
    this.olS = getResources().getColor(2131099891);
    this.olT = 1.0D;
    this.olN = findViewById(2131296435);
    this.olL = ((ImageView)findViewById(2131296436));
    this.olM = findViewById(2131296434);
    this.olO = findViewById(2131296444);
    this.olP = ((TextView)findViewById(2131296447));
    this.olQ = ((ProgressBar)findViewById(2131296433));
    this.olR = new CircleProgressDrawable(getContext());
    this.olY = ((AppBrandCapsuleBarPlaceHolderView)findViewById(2131296425));
    this.olM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219616);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((b.d(b.this) != null) && (!b.d(b.this).cz(paramAnonymousView)))
        {
          localObject = b.this.olW;
          paramAnonymousView = b.this.olM;
          if (!((c)localObject).omk.isEmpty())
          {
            localObject = ((c)localObject).omk.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(219616);
      }
    });
    AppMethodBeat.o(135409);
  }
  
  private void cac()
  {
    AppMethodBeat.i(135419);
    this.olO.setOnClickListener(new View.OnClickListener()
    {
      private long omg = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219618);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (System.currentTimeMillis() - this.omg < 250L)
        {
          paramAnonymousView = b.e(b.this).iterator();
          while (paramAnonymousView.hasNext()) {
            ((a)paramAnonymousView.next()).bLE();
          }
          this.omg = 0L;
        }
        this.omg = System.currentTimeMillis();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(219618);
      }
    });
    AppMethodBeat.o(135419);
  }
  
  private void caf()
  {
    AppMethodBeat.i(135434);
    View localView = this.olM;
    if ((this.olV) || (this.olU)) {}
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
    if (!this.olV)
    {
      super.setBackgroundColor(paramInt);
      AppMethodBeat.o(135421);
      return;
    }
    super.setBackgroundColor(0);
    AppMethodBeat.o(135421);
  }
  
  private void zO(int paramInt)
  {
    AppMethodBeat.i(135431);
    if (e.a.zP(paramInt) == e.a.omt)
    {
      if (this.olX != null)
      {
        this.olX.setStyleColor(-1);
        AppMethodBeat.o(135431);
      }
    }
    else if (this.olX != null) {
      this.olX.setStyleColor(-16777216);
    }
    AppMethodBeat.o(135431);
  }
  
  public final void a(final Bitmap paramBitmap, final View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135440);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219619);
        if (b.this.getParent() == null)
        {
          AppMethodBeat.o(219619);
          return;
        }
        if (b.f(b.this) == null)
        {
          ViewStub localViewStub = (ViewStub)b.this.findViewById(2131299384);
          if (localViewStub == null)
          {
            AppMethodBeat.o(219619);
            return;
          }
          localViewStub.inflate();
          b.a(b.this, (AppBrandActionBarCustomImageView)b.this.findViewById(2131299383));
        }
        b.f(b.this).setVisibility(0);
        b.f(b.this).setImageBitmap(paramBitmap);
        b.f(b.this).setClickable(true);
        b.f(b.this).setOnClickListener(paramOnClickListener);
        AppMethodBeat.o(219619);
      }
    });
    AppMethodBeat.o(135440);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(135414);
    this.omb.add(parama);
    if (!this.omc)
    {
      cac();
      this.omc = true;
    }
    AppMethodBeat.o(135414);
  }
  
  public final void cad()
  {
    AppMethodBeat.i(135430);
    if (this.olZ != null) {
      this.olZ.a(this.olL, this.olM, this.olN);
    }
    this.olP.setTextColor(this.nYY);
    this.olR.setStrokeColor(this.nYY);
    this.olQ.setIndeterminateDrawable(this.olR);
    zO(this.nYY);
    AppMethodBeat.o(135430);
  }
  
  public final boolean cae()
  {
    return this.olU;
  }
  
  public final boolean cag()
  {
    AppMethodBeat.i(135436);
    if (this.olQ.getVisibility() == 0)
    {
      AppMethodBeat.o(135436);
      return true;
    }
    AppMethodBeat.o(135436);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(219621);
    if (this.olR != null) {
      this.olR.stop();
    }
    removeAllViews();
    AppMethodBeat.o(219621);
  }
  
  public View getActionView()
  {
    return this;
  }
  
  public final double getBackgroundAlpha()
  {
    return this.olT;
  }
  
  public final int getBackgroundColor()
  {
    if (this.olV) {
      return 0;
    }
    return this.olS;
  }
  
  public AppBrandCapsuleBarPlaceHolderView getCapsuleView()
  {
    return this.olY;
  }
  
  public int getForegroundColor()
  {
    return this.nYY;
  }
  
  public CharSequence getMainTitle()
  {
    AppMethodBeat.i(135418);
    CharSequence localCharSequence = this.olP.getText();
    AppMethodBeat.o(135418);
    return localCharSequence;
  }
  
  public a getNavResetStyleListener()
  {
    return this.olZ;
  }
  
  public final void gx(boolean paramBoolean)
  {
    AppMethodBeat.i(135438);
    View localView = this.olM;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135438);
      return;
    }
  }
  
  public final void gy(boolean paramBoolean)
  {
    AppMethodBeat.i(135439);
    View localView = this.olO;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135439);
      return;
    }
  }
  
  public final void gz(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(135424);
    Object localObject = this.olY;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((AppBrandCapsuleBarPlaceHolderView)localObject).setVisibility(i);
      if (this.olY.getLayoutParams() != null)
      {
        localObject = this.olY.getLayoutParams();
        i = j;
        if (paramBoolean) {
          i = -2;
        }
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.olY.requestLayout();
      }
      if (this.olX != null) {
        this.olX.vI(this.olY.getVisibility());
      }
      AppMethodBeat.o(135424);
      return;
    }
  }
  
  public final boolean isFullscreenMode()
  {
    return this.olV;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(219622);
    if (this.olR != null) {
      this.olR.stop();
    }
    AppMethodBeat.o(219622);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(219623);
    if ((cag()) && (this.olR != null)) {
      this.olR.start();
    }
    AppMethodBeat.o(219623);
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
    ViewGroup.LayoutParams localLayoutParams = this.jBN.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height != paramInt))
    {
      localLayoutParams.height = paramInt;
      this.jBN.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(178644);
  }
  
  public void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135410);
    c localc = this.olW;
    if (paramOnClickListener == null)
    {
      AppMethodBeat.o(135410);
      return;
    }
    localc.omk.add(paramOnClickListener);
    AppMethodBeat.o(135410);
  }
  
  public final void setBackgroundAlpha(double paramDouble)
  {
    AppMethodBeat.i(135420);
    this.olT = paramDouble;
    if (!this.olV)
    {
      Drawable localDrawable2 = super.getBackground();
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null)
      {
        setBackgroundColorInternal(this.olS);
        localDrawable1 = super.getBackground();
      }
      localDrawable1.setAlpha((int)(255.0D * paramDouble));
    }
    AppMethodBeat.o(135420);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135422);
    this.olS = paramInt;
    setBackgroundColorInternal(paramInt);
    setBackgroundAlpha(this.olT);
    AppMethodBeat.o(135422);
  }
  
  public final void setCapsuleBarInteractionDelegate(b paramb)
  {
    AppMethodBeat.i(219620);
    this.olX = paramb;
    if (this.olX != null)
    {
      this.olX.setOptionButtonOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(135404);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = b.this.olW;
          if (!((c)localObject).oml.isEmpty())
          {
            localObject = ((c)localObject).oml.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135404);
        }
      });
      this.olX.setHomeButtonOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(135405);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = b.this.olW;
          if (!((c)localObject).omj.isEmpty())
          {
            localObject = ((c)localObject).omj.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135405);
        }
      });
    }
    AppMethodBeat.o(219620);
  }
  
  public void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135411);
    c localc = this.olW;
    if (paramOnClickListener == null)
    {
      AppMethodBeat.o(135411);
      return;
    }
    localc.omj.add(paramOnClickListener);
    AppMethodBeat.o(135411);
  }
  
  public void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(135429);
    this.nYY = paramInt;
    cad();
    AppMethodBeat.o(135429);
  }
  
  public void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(135427);
    this.nYY = e.a.afW(paramString).omu;
    cad();
    AppMethodBeat.o(135427);
  }
  
  public void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(135428);
    if (paramBoolean) {}
    for (int i = -16777216;; i = -1)
    {
      this.nYY = i;
      cad();
      AppMethodBeat.o(135428);
      return;
    }
  }
  
  public void setFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(135437);
    this.olV = paramBoolean;
    caf();
    View localView = this.olO;
    if (this.olV) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      requestLayout();
      setBackgroundColor(this.olS);
      AppMethodBeat.o(135437);
      return;
    }
  }
  
  public void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(135435);
    if (this.oma != null)
    {
      this.oma.io(paramBoolean);
      AppMethodBeat.o(135435);
      return;
    }
    ProgressBar localProgressBar = this.olQ;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      this.olR.caK();
      this.olR.start();
      AppMethodBeat.o(135435);
      return;
    }
    this.olR.stop();
    AppMethodBeat.o(135435);
  }
  
  public void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(135415);
    boolean bool = isLayoutRequested();
    this.olP.setText(paramCharSequence);
    if (bool) {
      requestLayout();
    }
    AppMethodBeat.o(135415);
  }
  
  public void setNavButtonLongClickListener(final View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(135413);
    this.olM.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219617);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        if (paramOnLongClickListener != null)
        {
          boolean bool = paramOnLongClickListener.onLongClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(219617);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(219617);
        return false;
      }
    });
    AppMethodBeat.o(135413);
  }
  
  public void setNavContainerMinimumWidth(int paramInt)
  {
    AppMethodBeat.i(178643);
    if (this.olN != null) {
      this.olN.setMinimumWidth(paramInt);
    }
    AppMethodBeat.o(178643);
  }
  
  public void setNavHidden(boolean paramBoolean)
  {
    AppMethodBeat.i(135433);
    this.olU = paramBoolean;
    caf();
    cad();
    AppMethodBeat.o(135433);
  }
  
  public void setNavLoadingIconVisibilityResetListener(d paramd)
  {
    this.oma = paramd;
  }
  
  public void setNavResetStyleListener(a parama)
  {
    this.olZ = parama;
  }
  
  public void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135423);
    c localc = this.olW;
    if (paramOnClickListener == null)
    {
      AppMethodBeat.o(135423);
      return;
    }
    localc.oml.add(paramOnClickListener);
    AppMethodBeat.o(135423);
  }
  
  public final void zN(int paramInt)
  {
    AppMethodBeat.i(178642);
    this.olS = paramInt;
    super.setBackgroundColor(paramInt);
    AppMethodBeat.o(178642);
  }
  
  public static abstract class a
  {
    public static final int omi = 2131165766;
    
    protected abstract void a(ImageView paramImageView, View paramView1, View paramView2);
    
    public abstract int bQz();
    
    protected boolean cz(View paramView)
    {
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setStyleColor(int paramInt);
    
    public abstract void vI(int paramInt);
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
        paramImageView.setImageResource(2131689605);
        paramImageView.setColorFilter(b.this.nYY, PorterDuff.Mode.SRC_ATOP);
        paramView2 = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
        paramView2.width = b.this.getContext().getResources().getDimensionPixelSize(2131165758);
        paramView2.height = b.this.getContext().getResources().getDimensionPixelSize(2131165757);
        paramView2.leftMargin = b.this.getContext().getResources().getDimensionPixelSize(2131165766);
        paramView2.rightMargin = b.this.getContext().getResources().getDimensionPixelSize(2131165768);
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
    
    public final int bQz()
    {
      return 2131165766;
    }
  }
  
  public static abstract interface d
  {
    public abstract void io(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b
 * JD-Core Version:    0.7.0.1
 */