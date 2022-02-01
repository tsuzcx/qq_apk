package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class b
  extends LinearLayout
  implements f.b, f.d, e
{
  private View iFK;
  protected int mLQ;
  protected ImageView mYG;
  protected View mYH;
  protected View mYI;
  protected View mYJ;
  protected TextView mYK;
  protected ProgressBar mYL;
  protected CircleProgressDrawable mYM;
  protected int mYN;
  protected double mYO;
  protected boolean mYP;
  protected boolean mYQ;
  protected c mYR;
  private a mYS;
  private AppBrandCapsuleBarPlaceHolderView mYT;
  private d mYU;
  private c mYV;
  private final Set<a> mYW;
  private boolean mYX;
  private AppBrandActionBarCustomImageView mYY;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135409);
    this.mYR = new c();
    this.mYU = new b.b(this, (byte)0);
    this.mYW = new LinkedHashSet();
    this.mYX = false;
    this.mYP = false;
    this.mYQ = false;
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setBackgroundResource(2131099873);
    this.iFK = LayoutInflater.from(getContext()).inflate(2131492964, this, false);
    addView(this.iFK);
    this.mLQ = -1;
    this.mYN = getResources().getColor(2131099873);
    this.mYO = 1.0D;
    this.mYI = findViewById(2131296405);
    this.mYG = ((ImageView)findViewById(2131296406));
    this.mYH = findViewById(2131296404);
    this.mYJ = findViewById(2131296412);
    this.mYK = ((TextView)findViewById(2131296415));
    this.mYL = ((ProgressBar)findViewById(2131296403));
    this.mYM = new CircleProgressDrawable(getContext());
    this.mYT = ((AppBrandCapsuleBarPlaceHolderView)findViewById(2131308125));
    this.mYH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208009);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        localObject = b.this.mYR;
        paramAnonymousView = b.this.mYH;
        if (!((c)localObject).mZf.isEmpty())
        {
          localObject = ((c)localObject).mZf.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208009);
      }
    });
    AppMethodBeat.o(135409);
  }
  
  private void bDb()
  {
    AppMethodBeat.i(135419);
    this.mYJ.setOnClickListener(new View.OnClickListener()
    {
      private long mZb = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208011);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (System.currentTimeMillis() - this.mZb < 250L)
        {
          paramAnonymousView = b.d(b.this).iterator();
          while (paramAnonymousView.hasNext()) {
            ((a)paramAnonymousView.next()).bpY();
          }
          this.mZb = 0L;
        }
        this.mZb = System.currentTimeMillis();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208011);
      }
    });
    AppMethodBeat.o(135419);
  }
  
  private void bDd()
  {
    AppMethodBeat.i(135432);
    if (this.mLQ == -1)
    {
      if (this.mYS != null)
      {
        this.mYS.setStyleColor(-1);
        AppMethodBeat.o(135432);
      }
    }
    else if (this.mYS != null) {
      this.mYS.setStyleColor(-16777216);
    }
    AppMethodBeat.o(135432);
  }
  
  private void bDf()
  {
    AppMethodBeat.i(135434);
    View localView = this.mYH;
    if ((this.mYQ) || (this.mYP)) {}
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
    if (!this.mYQ)
    {
      super.setBackgroundColor(paramInt);
      AppMethodBeat.o(135421);
      return;
    }
    super.setBackgroundColor(0);
    AppMethodBeat.o(135421);
  }
  
  private void vZ(int paramInt)
  {
    AppMethodBeat.i(135431);
    if (paramInt == -1)
    {
      if (this.mYS != null)
      {
        this.mYS.setStyleColor(-1);
        AppMethodBeat.o(135431);
      }
    }
    else if (this.mYS != null) {
      this.mYS.setStyleColor(-16777216);
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
        AppMethodBeat.i(208012);
        if (b.this.getParent() == null)
        {
          AppMethodBeat.o(208012);
          return;
        }
        if (b.e(b.this) == null)
        {
          ViewStub localViewStub = (ViewStub)b.this.findViewById(2131298905);
          if (localViewStub == null)
          {
            AppMethodBeat.o(208012);
            return;
          }
          localViewStub.inflate();
          b.a(b.this, (AppBrandActionBarCustomImageView)b.this.findViewById(2131298904));
        }
        b.e(b.this).setVisibility(0);
        b.e(b.this).setImageBitmap(paramBitmap);
        b.e(b.this).setClickable(true);
        b.e(b.this).setOnClickListener(paramOnClickListener);
        AppMethodBeat.o(208012);
      }
    });
    AppMethodBeat.o(135440);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(135414);
    this.mYW.add(parama);
    if (!this.mYX)
    {
      bDb();
      this.mYX = true;
    }
    AppMethodBeat.o(135414);
  }
  
  public final void bDc()
  {
    AppMethodBeat.i(135430);
    if (this.mYU != null) {
      this.mYU.a(this.mYG, this.mYH, this.mYI);
    }
    this.mYK.setTextColor(this.mLQ);
    this.mYM.setStrokeColor(this.mLQ);
    this.mYL.setIndeterminateDrawable(this.mYM);
    bDd();
    vZ(this.mLQ);
    AppMethodBeat.o(135430);
  }
  
  public final boolean bDe()
  {
    return this.mYP;
  }
  
  public final boolean bDg()
  {
    AppMethodBeat.i(135436);
    if (this.mYL.getVisibility() == 0)
    {
      AppMethodBeat.o(135436);
      return true;
    }
    AppMethodBeat.o(135436);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(208014);
    if (this.mYM != null) {
      this.mYM.stop();
    }
    removeAllViews();
    AppMethodBeat.o(208014);
  }
  
  public final void fC(boolean paramBoolean)
  {
    AppMethodBeat.i(135438);
    View localView = this.mYH;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135438);
      return;
    }
  }
  
  public final void fD(boolean paramBoolean)
  {
    AppMethodBeat.i(135439);
    View localView = this.mYJ;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135439);
      return;
    }
  }
  
  public final void fE(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(135424);
    Object localObject = this.mYT;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((AppBrandCapsuleBarPlaceHolderView)localObject).setVisibility(i);
      if (this.mYT.getLayoutParams() != null)
      {
        localObject = this.mYT.getLayoutParams();
        i = j;
        if (paramBoolean) {
          i = -2;
        }
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.mYT.requestLayout();
      }
      if (this.mYS != null) {
        this.mYS.rN(this.mYT.getVisibility());
      }
      AppMethodBeat.o(135424);
      return;
    }
  }
  
  public View getActionView()
  {
    return this;
  }
  
  public final double getBackgroundAlpha()
  {
    return this.mYO;
  }
  
  public final int getBackgroundColor()
  {
    if (this.mYQ) {
      return 0;
    }
    return this.mYN;
  }
  
  public AppBrandCapsuleBarPlaceHolderView getCapsuleView()
  {
    return this.mYT;
  }
  
  public int getForegroundColor()
  {
    return this.mLQ;
  }
  
  public CharSequence getMainTitle()
  {
    AppMethodBeat.i(135418);
    CharSequence localCharSequence = this.mYK.getText();
    AppMethodBeat.o(135418);
    return localCharSequence;
  }
  
  public d getNavResetStyleListener()
  {
    return this.mYU;
  }
  
  public final boolean isFullscreenMode()
  {
    return this.mYQ;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(208015);
    if (this.mYM != null) {
      this.mYM.stop();
    }
    AppMethodBeat.o(208015);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(208016);
    if ((bDg()) && (this.mYM != null)) {
      this.mYM.start();
    }
    AppMethodBeat.o(208016);
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
    ViewGroup.LayoutParams localLayoutParams = this.iFK.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height != paramInt))
    {
      localLayoutParams.height = paramInt;
      this.iFK.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(178644);
  }
  
  public void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135410);
    c localc = this.mYR;
    if (paramOnClickListener == null)
    {
      AppMethodBeat.o(135410);
      return;
    }
    localc.mZf.add(paramOnClickListener);
    AppMethodBeat.o(135410);
  }
  
  public final void setBackgroundAlpha(double paramDouble)
  {
    AppMethodBeat.i(135420);
    this.mYO = paramDouble;
    if (!this.mYQ)
    {
      Drawable localDrawable2 = super.getBackground();
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null)
      {
        setBackgroundColorInternal(this.mYN);
        localDrawable1 = super.getBackground();
      }
      localDrawable1.setAlpha((int)(255.0D * paramDouble));
    }
    AppMethodBeat.o(135420);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135422);
    this.mYN = paramInt;
    setBackgroundColorInternal(paramInt);
    setBackgroundAlpha(this.mYO);
    AppMethodBeat.o(135422);
  }
  
  public final void setCapsuleBarInteractionDelegate(a parama)
  {
    AppMethodBeat.i(208013);
    this.mYS = parama;
    if (this.mYS != null)
    {
      this.mYS.setOptionButtonOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(135404);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = b.this.mYR;
          if (!((c)localObject).mZg.isEmpty())
          {
            localObject = ((c)localObject).mZg.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135404);
        }
      });
      this.mYS.setHomeButtonOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(135405);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = b.this.mYR;
          if (!((c)localObject).mZe.isEmpty())
          {
            localObject = ((c)localObject).mZe.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135405);
        }
      });
    }
    AppMethodBeat.o(208013);
  }
  
  public void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135411);
    c localc = this.mYR;
    if (paramOnClickListener == null)
    {
      AppMethodBeat.o(135411);
      return;
    }
    localc.mZe.add(paramOnClickListener);
    AppMethodBeat.o(135411);
  }
  
  public void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(135429);
    this.mLQ = paramInt;
    bDc();
    AppMethodBeat.o(135429);
  }
  
  public void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(135427);
    this.mLQ = e.a.Wa(paramString).mZp;
    bDc();
    AppMethodBeat.o(135427);
  }
  
  public void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(135428);
    if (paramBoolean) {}
    for (int i = -16777216;; i = -1)
    {
      this.mLQ = i;
      bDc();
      AppMethodBeat.o(135428);
      return;
    }
  }
  
  public void setFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(135437);
    this.mYQ = paramBoolean;
    bDf();
    View localView = this.mYJ;
    if (this.mYQ) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      requestLayout();
      setBackgroundColor(this.mYN);
      AppMethodBeat.o(135437);
      return;
    }
  }
  
  public void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(135435);
    if (this.mYV != null)
    {
      this.mYV.hn(paramBoolean);
      AppMethodBeat.o(135435);
      return;
    }
    ProgressBar localProgressBar = this.mYL;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      this.mYM.bEw();
      this.mYM.start();
      AppMethodBeat.o(135435);
      return;
    }
    this.mYM.stop();
    AppMethodBeat.o(135435);
  }
  
  public void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(135415);
    boolean bool = isLayoutRequested();
    this.mYK.setText(paramCharSequence);
    if (bool) {
      requestLayout();
    }
    AppMethodBeat.o(135415);
  }
  
  public void setNavButtonLongClickListener(final View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(135413);
    this.mYH.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208010);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        if (paramOnLongClickListener != null)
        {
          boolean bool = paramOnLongClickListener.onLongClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(208010);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(208010);
        return false;
      }
    });
    AppMethodBeat.o(135413);
  }
  
  public void setNavContainerMinimumWidth(int paramInt)
  {
    AppMethodBeat.i(178643);
    if (this.mYI != null) {
      this.mYI.setMinimumWidth(paramInt);
    }
    AppMethodBeat.o(178643);
  }
  
  public void setNavHidden(boolean paramBoolean)
  {
    AppMethodBeat.i(135433);
    this.mYP = paramBoolean;
    bDf();
    bDc();
    AppMethodBeat.o(135433);
  }
  
  public void setNavLoadingIconVisibilityResetListener(c paramc)
  {
    this.mYV = paramc;
  }
  
  public void setNavResetStyleListener(d paramd)
  {
    this.mYU = paramd;
  }
  
  public void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135423);
    c localc = this.mYR;
    if (paramOnClickListener == null)
    {
      AppMethodBeat.o(135423);
      return;
    }
    localc.mZg.add(paramOnClickListener);
    AppMethodBeat.o(135423);
  }
  
  public final void vY(int paramInt)
  {
    AppMethodBeat.i(178642);
    this.mYN = paramInt;
    super.setBackgroundColor(paramInt);
    AppMethodBeat.o(178642);
  }
  
  public static abstract interface a
  {
    public abstract void rN(int paramInt);
    
    public abstract void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener);
    
    public abstract void setStyleColor(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void hn(boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public static final int mZd = 2131165747;
    
    public abstract void a(ImageView paramImageView, View paramView1, View paramView2);
    
    public abstract int bvI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b
 * JD-Core Version:    0.7.0.1
 */