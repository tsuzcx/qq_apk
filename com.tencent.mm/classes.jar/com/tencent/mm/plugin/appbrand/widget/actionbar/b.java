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
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.a.d.a;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import d.g.b.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class b
  extends LinearLayout
  implements f.b, f.d, f
{
  private View ijA;
  protected int mgl;
  protected ImageView msS;
  protected View msT;
  protected View msU;
  protected View msV;
  protected TextView msW;
  protected ProgressBar msX;
  protected CircleProgressDrawable msY;
  protected AppBrandOptionButton msZ;
  protected AppBrandCapsuleHomeButton mta;
  protected LinearLayout mtb;
  protected View mtc;
  protected int mtd;
  protected double mte;
  protected boolean mtf;
  protected boolean mtg;
  protected c mth;
  private e mti;
  private c mtj;
  private b mtk;
  private final Set<a> mtl;
  private boolean mtm;
  private AppBrandActionBarCustomImageView mtn;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135409);
    this.mth = new c();
    this.mtj = new a((byte)0);
    this.mtl = new LinkedHashSet();
    this.mtm = false;
    this.mtf = false;
    this.mtg = false;
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setBackgroundResource(2131099873);
    this.ijA = LayoutInflater.from(getContext()).inflate(2131492964, this, false);
    addView(this.ijA);
    this.mgl = -1;
    this.mtd = getResources().getColor(2131099873);
    this.mte = 1.0D;
    this.msU = findViewById(2131296405);
    this.msS = ((ImageView)findViewById(2131296406));
    this.msT = findViewById(2131296404);
    this.msV = findViewById(2131296412);
    this.msW = ((TextView)findViewById(2131296415));
    this.msX = ((ProgressBar)findViewById(2131296403));
    this.msY = new CircleProgressDrawable(getContext());
    this.msZ = ((AppBrandOptionButton)findViewById(2131296402));
    this.mta = ((AppBrandCapsuleHomeButton)findViewById(2131296401));
    this.mtb = ((LinearLayout)findViewById(2131296399));
    this.mtc = findViewById(2131296400);
    this.mti = new e();
    paramContext = this.mti;
    AppBrandOptionButton localAppBrandOptionButton = this.msZ;
    k.h(localAppBrandOptionButton, "button");
    paramContext.mtA = localAppBrandOptionButton;
    this.msT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(135404);
        b.this.mth.cS(b.this.msT);
        AppMethodBeat.o(135404);
      }
    });
    this.mta.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(135405);
        Object localObject = b.this.mth;
        paramAnonymousView = b.this.mta;
        if (((c)localObject).mtt.isEmpty()) {}
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            b.this.mth.cS(b.this.mta);
          }
          AppMethodBeat.o(135405);
          return;
          localObject = ((c)localObject).mtt.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
          }
        }
      }
    });
    this.msZ.setAccessibilityLabel(getContext().getString(2131755290));
    this.mta.setAccessibilityLabel(getContext().getString(2131755286));
    AppMethodBeat.o(135409);
  }
  
  private void byb()
  {
    AppMethodBeat.i(135419);
    this.msV.setOnClickListener(new View.OnClickListener()
    {
      private long mtq = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(135407);
        if (System.currentTimeMillis() - this.mtq < 250L)
        {
          paramAnonymousView = b.d(b.this).iterator();
          while (paramAnonymousView.hasNext()) {
            ((a)paramAnonymousView.next()).blD();
          }
          this.mtq = 0L;
        }
        this.mtq = System.currentTimeMillis();
        AppMethodBeat.o(135407);
      }
    });
    AppMethodBeat.o(135419);
  }
  
  private void byf()
  {
    AppMethodBeat.i(135432);
    if (this.mgl == -1)
    {
      this.msZ.setColor(-1);
      this.mta.setColor(-1);
      AppMethodBeat.o(135432);
      return;
    }
    this.msZ.setColor(-16777216);
    this.mta.setColor(-16777216);
    AppMethodBeat.o(135432);
  }
  
  private void byh()
  {
    AppMethodBeat.i(135434);
    View localView = this.msT;
    if ((this.mtg) || (this.mtf)) {}
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
    if (!this.mtg)
    {
      super.setBackgroundColor(paramInt);
      AppMethodBeat.o(135421);
      return;
    }
    super.setBackgroundColor(0);
    AppMethodBeat.o(135421);
  }
  
  private void vo(int paramInt)
  {
    AppMethodBeat.i(135431);
    if (paramInt == -1)
    {
      this.mtc.setBackgroundResource(2131099920);
      this.mtb.setBackgroundResource(2131230978);
      AppMethodBeat.o(135431);
      return;
    }
    this.mtc.setBackgroundResource(2131099921);
    this.mtb.setBackgroundResource(2131230979);
    AppMethodBeat.o(135431);
  }
  
  public final void a(final Bitmap paramBitmap, final View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135440);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135408);
        if (b.this.getParent() == null)
        {
          AppMethodBeat.o(135408);
          return;
        }
        if (b.e(b.this) == null)
        {
          ViewStub localViewStub = (ViewStub)b.this.findViewById(2131298905);
          if (localViewStub == null)
          {
            AppMethodBeat.o(135408);
            return;
          }
          localViewStub.inflate();
          b.a(b.this, (AppBrandActionBarCustomImageView)b.this.findViewById(2131298904));
        }
        b.e(b.this).setVisibility(0);
        b.e(b.this).setImageBitmap(paramBitmap);
        b.e(b.this).setClickable(true);
        b.e(b.this).setOnClickListener(paramOnClickListener);
        AppMethodBeat.o(135408);
      }
    });
    AppMethodBeat.o(135440);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(135414);
    this.mtl.add(parama);
    if (!this.mtm)
    {
      byb();
      this.mtm = true;
    }
    AppMethodBeat.o(135414);
  }
  
  public final boolean byc()
  {
    AppMethodBeat.i(135425);
    if (this.mtb.getVisibility() == 0)
    {
      AppMethodBeat.o(135425);
      return true;
    }
    AppMethodBeat.o(135425);
    return false;
  }
  
  public final void byd()
  {
    AppMethodBeat.i(135426);
    this.msZ.reset();
    this.mta.reset();
    byf();
    AppMethodBeat.o(135426);
  }
  
  public final void bye()
  {
    AppMethodBeat.i(135430);
    if (this.mtj != null) {
      this.mtj.a(this.msS, this.msT, this.msU);
    }
    this.msW.setTextColor(this.mgl);
    this.msY.setStrokeColor(this.mgl);
    this.msX.setIndeterminateDrawable(this.msY);
    byf();
    vo(this.mgl);
    AppMethodBeat.o(135430);
  }
  
  public final boolean byg()
  {
    return this.mtf;
  }
  
  public final boolean byi()
  {
    AppMethodBeat.i(135436);
    if (this.msX.getVisibility() == 0)
    {
      AppMethodBeat.o(135436);
      return true;
    }
    AppMethodBeat.o(135436);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(193544);
    if (this.msY != null) {
      this.msY.stop();
    }
    removeAllViews();
    getCapsuleBar().destroy();
    AppMethodBeat.o(193544);
  }
  
  public final View getActionView()
  {
    return this;
  }
  
  public final double getBackgroundAlpha()
  {
    return this.mte;
  }
  
  public final int getBackgroundColor()
  {
    if (this.mtg) {
      return 0;
    }
    return this.mtd;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.a.b getCapsuleBar()
  {
    return this.mti;
  }
  
  public final View getCapsuleView()
  {
    return this.mtb;
  }
  
  public final int getForegroundColor()
  {
    return this.mgl;
  }
  
  public final CharSequence getMainTitle()
  {
    AppMethodBeat.i(135418);
    CharSequence localCharSequence = this.msW.getText();
    AppMethodBeat.o(135418);
    return localCharSequence;
  }
  
  public final c getNavResetStyleListener()
  {
    return this.mtj;
  }
  
  public final AppBrandOptionButton getOptionButton()
  {
    return this.msZ;
  }
  
  public final void hA(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(135424);
    Object localObject = this.mtb;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((LinearLayout)localObject).setVisibility(i);
      if (this.mtb.getLayoutParams() != null)
      {
        localObject = this.mtb.getLayoutParams();
        i = j;
        if (paramBoolean) {
          i = -2;
        }
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.mtb.requestLayout();
      }
      AppMethodBeat.o(135424);
      return;
    }
  }
  
  public final void hM(boolean paramBoolean)
  {
    AppMethodBeat.i(135438);
    View localView = this.msT;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135438);
      return;
    }
  }
  
  public final void hN(boolean paramBoolean)
  {
    AppMethodBeat.i(135439);
    View localView = this.msV;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135439);
      return;
    }
  }
  
  public final boolean isFullscreenMode()
  {
    return this.mtg;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(193545);
    if (this.msY != null) {
      this.msY.stop();
    }
    AppMethodBeat.o(193545);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(193546);
    if ((byi()) && (this.msY != null)) {
      this.msY.start();
    }
    AppMethodBeat.o(193546);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(135416);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(135416);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135417);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(135417);
  }
  
  public final void setActionBarHeight(int paramInt)
  {
    AppMethodBeat.i(178644);
    ViewGroup.LayoutParams localLayoutParams = this.ijA.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = paramInt;
      this.ijA.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(178644);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135410);
    this.mth.mtu.add(paramOnClickListener);
    AppMethodBeat.o(135410);
  }
  
  public final void setBackgroundAlpha(double paramDouble)
  {
    AppMethodBeat.i(135420);
    this.mte = paramDouble;
    if (!this.mtg)
    {
      Drawable localDrawable2 = super.getBackground();
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null)
      {
        setBackgroundColorInternal(this.mtd);
        localDrawable1 = super.getBackground();
      }
      localDrawable1.setAlpha((int)(255.0D * paramDouble));
    }
    AppMethodBeat.o(135420);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135422);
    this.mtd = paramInt;
    setBackgroundColorInternal(paramInt);
    setBackgroundAlpha(this.mte);
    AppMethodBeat.o(135422);
  }
  
  public final void setCapsuleHomeButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(135412);
    this.mta.setOnLongClickListener(paramOnLongClickListener);
    AppMethodBeat.o(135412);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135411);
    this.mth.mtt.add(paramOnClickListener);
    AppMethodBeat.o(135411);
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(135429);
    this.mgl = paramInt;
    bye();
    AppMethodBeat.o(135429);
  }
  
  public final void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(135427);
    this.mgl = d.a.PW(paramString).lGx;
    bye();
    AppMethodBeat.o(135427);
  }
  
  public final void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(135428);
    if (paramBoolean) {}
    for (int i = -16777216;; i = -1)
    {
      this.mgl = i;
      bye();
      AppMethodBeat.o(135428);
      return;
    }
  }
  
  public final void setFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(135437);
    this.mtg = paramBoolean;
    byh();
    View localView = this.msV;
    if (this.mtg) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      requestLayout();
      setBackgroundColor(this.mtd);
      AppMethodBeat.o(135437);
      return;
    }
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(135435);
    if (this.mtk != null)
    {
      this.mtk.he(paramBoolean);
      AppMethodBeat.o(135435);
      return;
    }
    ProgressBar localProgressBar = this.msX;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      this.msY.blV();
      this.msY.start();
      AppMethodBeat.o(135435);
      return;
    }
    this.msY.stop();
    AppMethodBeat.o(135435);
  }
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(135415);
    boolean bool = isLayoutRequested();
    this.msW.setText(paramCharSequence);
    if (bool) {
      requestLayout();
    }
    AppMethodBeat.o(135415);
  }
  
  public final void setNavButtonLongClickListener(final View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(135413);
    this.msT.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(135406);
        if (paramOnLongClickListener != null)
        {
          boolean bool = paramOnLongClickListener.onLongClick(paramAnonymousView);
          AppMethodBeat.o(135406);
          return bool;
        }
        AppMethodBeat.o(135406);
        return false;
      }
    });
    AppMethodBeat.o(135413);
  }
  
  public final void setNavContainerMinimumWidth(int paramInt)
  {
    AppMethodBeat.i(178643);
    if (this.msU != null) {
      this.msU.setMinimumWidth(paramInt);
    }
    AppMethodBeat.o(178643);
  }
  
  public final void setNavHidden(boolean paramBoolean)
  {
    AppMethodBeat.i(135433);
    this.mtf = paramBoolean;
    byh();
    bye();
    AppMethodBeat.o(135433);
  }
  
  public final void setNavLoadingIconVisibilityResetListener(b paramb)
  {
    this.mtk = paramb;
  }
  
  public final void setNavResetStyleListener(c paramc)
  {
    this.mtj = paramc;
  }
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135423);
    this.msZ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(135423);
  }
  
  public final void vn(int paramInt)
  {
    AppMethodBeat.i(178642);
    this.mtd = paramInt;
    super.setBackgroundColor(paramInt);
    AppMethodBeat.o(178642);
  }
  
  final class a
    implements b.c
  {
    private a() {}
    
    public final void a(ImageView paramImageView, View paramView1, View paramView2)
    {
      AppMethodBeat.i(178641);
      if (paramImageView != null)
      {
        paramImageView.setImageResource(2131689602);
        paramImageView.setColorFilter(b.this.mgl, PorterDuff.Mode.SRC_ATOP);
        paramView2 = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
        paramView2.width = b.this.getContext().getResources().getDimensionPixelSize(2131165740);
        paramView2.height = b.this.getContext().getResources().getDimensionPixelSize(2131165739);
        paramView2.leftMargin = b.this.getContext().getResources().getDimensionPixelSize(2131165747);
        paramView2.rightMargin = b.this.getContext().getResources().getDimensionPixelSize(2131165749);
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
    
    public final int bqW()
    {
      return 2131165747;
    }
  }
  
  public static abstract interface b
  {
    public abstract void he(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public static final int mts = 2131165747;
    
    public abstract void a(ImageView paramImageView, View paramView1, View paramView2);
    
    public abstract int bqW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b
 * JD-Core Version:    0.7.0.1
 */