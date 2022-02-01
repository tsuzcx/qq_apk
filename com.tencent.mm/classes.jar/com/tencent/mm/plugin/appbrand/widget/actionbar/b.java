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
  private View hIZ;
  protected int lEr;
  protected ImageView lQP;
  protected View lQQ;
  protected View lQR;
  protected View lQS;
  protected TextView lQT;
  protected ProgressBar lQU;
  protected CircleProgressDrawable lQV;
  protected AppBrandOptionButton lQW;
  protected AppBrandCapsuleHomeButton lQX;
  protected LinearLayout lQY;
  protected View lQZ;
  protected int lRa;
  protected double lRb;
  protected boolean lRc;
  protected boolean lRd;
  protected c lRe;
  private e lRf;
  private c lRg;
  private b lRh;
  private final Set<a> lRi;
  private boolean lRj;
  private AppBrandActionBarCustomImageView lRk;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135409);
    this.lRe = new c();
    this.lRg = new a((byte)0);
    this.lRi = new LinkedHashSet();
    this.lRj = false;
    this.lRc = false;
    this.lRd = false;
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setBackgroundResource(2131099873);
    this.hIZ = LayoutInflater.from(getContext()).inflate(2131492964, this, false);
    addView(this.hIZ);
    this.lEr = -1;
    this.lRa = getResources().getColor(2131099873);
    this.lRb = 1.0D;
    this.lQR = findViewById(2131296405);
    this.lQP = ((ImageView)findViewById(2131296406));
    this.lQQ = findViewById(2131296404);
    this.lQS = findViewById(2131296412);
    this.lQT = ((TextView)findViewById(2131296415));
    this.lQU = ((ProgressBar)findViewById(2131296403));
    this.lQV = new CircleProgressDrawable(getContext());
    this.lQW = ((AppBrandOptionButton)findViewById(2131296402));
    this.lQX = ((AppBrandCapsuleHomeButton)findViewById(2131296401));
    this.lQY = ((LinearLayout)findViewById(2131296399));
    this.lQZ = findViewById(2131296400);
    this.lRf = new e();
    paramContext = this.lRf;
    AppBrandOptionButton localAppBrandOptionButton = this.lQW;
    k.h(localAppBrandOptionButton, "button");
    paramContext.lRx = localAppBrandOptionButton;
    this.lQQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(135404);
        b.this.lRe.cQ(b.this.lQQ);
        AppMethodBeat.o(135404);
      }
    });
    this.lQX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(135405);
        Object localObject = b.this.lRe;
        paramAnonymousView = b.this.lQX;
        if (((c)localObject).lRq.isEmpty()) {}
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            b.this.lRe.cQ(b.this.lQX);
          }
          AppMethodBeat.o(135405);
          return;
          localObject = ((c)localObject).lRq.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
          }
        }
      }
    });
    this.lQW.setAccessibilityLabel(getContext().getString(2131755290));
    this.lQX.setAccessibilityLabel(getContext().getString(2131755286));
    AppMethodBeat.o(135409);
  }
  
  private void brb()
  {
    AppMethodBeat.i(135419);
    this.lQS.setOnClickListener(new View.OnClickListener()
    {
      private long lRn = 0L;
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(135407);
        if (System.currentTimeMillis() - this.lRn < 250L)
        {
          paramAnonymousView = b.d(b.this).iterator();
          while (paramAnonymousView.hasNext()) {
            ((a)paramAnonymousView.next()).beJ();
          }
          this.lRn = 0L;
        }
        this.lRn = System.currentTimeMillis();
        AppMethodBeat.o(135407);
      }
    });
    AppMethodBeat.o(135419);
  }
  
  private void brf()
  {
    AppMethodBeat.i(135432);
    if (this.lEr == -1)
    {
      this.lQW.setColor(-1);
      this.lQX.setColor(-1);
      AppMethodBeat.o(135432);
      return;
    }
    this.lQW.setColor(-16777216);
    this.lQX.setColor(-16777216);
    AppMethodBeat.o(135432);
  }
  
  private void brh()
  {
    AppMethodBeat.i(135434);
    View localView = this.lQQ;
    if ((this.lRd) || (this.lRc)) {}
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
    if (!this.lRd)
    {
      super.setBackgroundColor(paramInt);
      AppMethodBeat.o(135421);
      return;
    }
    super.setBackgroundColor(0);
    AppMethodBeat.o(135421);
  }
  
  private void ux(int paramInt)
  {
    AppMethodBeat.i(135431);
    if (paramInt == -1)
    {
      this.lQZ.setBackgroundResource(2131099920);
      this.lQY.setBackgroundResource(2131230978);
      AppMethodBeat.o(135431);
      return;
    }
    this.lQZ.setBackgroundResource(2131099921);
    this.lQY.setBackgroundResource(2131230979);
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
    this.lRi.add(parama);
    if (!this.lRj)
    {
      brb();
      this.lRj = true;
    }
    AppMethodBeat.o(135414);
  }
  
  public final boolean brc()
  {
    AppMethodBeat.i(135425);
    if (this.lQY.getVisibility() == 0)
    {
      AppMethodBeat.o(135425);
      return true;
    }
    AppMethodBeat.o(135425);
    return false;
  }
  
  public final void brd()
  {
    AppMethodBeat.i(135426);
    this.lQW.reset();
    this.lQX.reset();
    brf();
    AppMethodBeat.o(135426);
  }
  
  public final void bre()
  {
    AppMethodBeat.i(135430);
    if (this.lRg != null) {
      this.lRg.a(this.lQP, this.lQQ, this.lQR);
    }
    this.lQT.setTextColor(this.lEr);
    this.lQV.setStrokeColor(this.lEr);
    this.lQU.setIndeterminateDrawable(this.lQV);
    brf();
    ux(this.lEr);
    AppMethodBeat.o(135430);
  }
  
  public final boolean brg()
  {
    return this.lRc;
  }
  
  public final boolean bri()
  {
    AppMethodBeat.i(135436);
    if (this.lQU.getVisibility() == 0)
    {
      AppMethodBeat.o(135436);
      return true;
    }
    AppMethodBeat.o(135436);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(194542);
    if (this.lQV != null) {
      this.lQV.stop();
    }
    removeAllViews();
    getCapsuleBar().destroy();
    AppMethodBeat.o(194542);
  }
  
  public final View getActionView()
  {
    return this;
  }
  
  public final double getBackgroundAlpha()
  {
    return this.lRb;
  }
  
  public final int getBackgroundColor()
  {
    if (this.lRd) {
      return 0;
    }
    return this.lRa;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.a.b getCapsuleBar()
  {
    return this.lRf;
  }
  
  public final View getCapsuleView()
  {
    return this.lQY;
  }
  
  public final int getForegroundColor()
  {
    return this.lEr;
  }
  
  public final CharSequence getMainTitle()
  {
    AppMethodBeat.i(135418);
    CharSequence localCharSequence = this.lQT.getText();
    AppMethodBeat.o(135418);
    return localCharSequence;
  }
  
  public final c getNavResetStyleListener()
  {
    return this.lRg;
  }
  
  public final AppBrandOptionButton getOptionButton()
  {
    return this.lQW;
  }
  
  public final void hd(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(135424);
    Object localObject = this.lQY;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((LinearLayout)localObject).setVisibility(i);
      if (this.lQY.getLayoutParams() != null)
      {
        localObject = this.lQY.getLayoutParams();
        i = j;
        if (paramBoolean) {
          i = -2;
        }
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.lQY.requestLayout();
      }
      AppMethodBeat.o(135424);
      return;
    }
  }
  
  public final void ho(boolean paramBoolean)
  {
    AppMethodBeat.i(135438);
    View localView = this.lQQ;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135438);
      return;
    }
  }
  
  public final void hp(boolean paramBoolean)
  {
    AppMethodBeat.i(135439);
    View localView = this.lQS;
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
    return this.lRd;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(194543);
    if (this.lQV != null) {
      this.lQV.stop();
    }
    AppMethodBeat.o(194543);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(194544);
    if ((bri()) && (this.lQV != null)) {
      this.lQV.start();
    }
    AppMethodBeat.o(194544);
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
    ViewGroup.LayoutParams localLayoutParams = this.hIZ.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = paramInt;
      this.hIZ.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(178644);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135410);
    this.lRe.lRr.add(paramOnClickListener);
    AppMethodBeat.o(135410);
  }
  
  public final void setBackgroundAlpha(double paramDouble)
  {
    AppMethodBeat.i(135420);
    this.lRb = paramDouble;
    if (!this.lRd)
    {
      Drawable localDrawable2 = super.getBackground();
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null)
      {
        setBackgroundColorInternal(this.lRa);
        localDrawable1 = super.getBackground();
      }
      localDrawable1.setAlpha((int)(255.0D * paramDouble));
    }
    AppMethodBeat.o(135420);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135422);
    this.lRa = paramInt;
    setBackgroundColorInternal(paramInt);
    setBackgroundAlpha(this.lRb);
    AppMethodBeat.o(135422);
  }
  
  public final void setCapsuleHomeButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(135412);
    this.lQX.setOnLongClickListener(paramOnLongClickListener);
    AppMethodBeat.o(135412);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135411);
    this.lRe.lRq.add(paramOnClickListener);
    AppMethodBeat.o(135411);
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(135429);
    this.lEr = paramInt;
    bre();
    AppMethodBeat.o(135429);
  }
  
  public final void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(135427);
    this.lEr = d.a.LQ(paramString).lgD;
    bre();
    AppMethodBeat.o(135427);
  }
  
  public final void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(135428);
    if (paramBoolean) {}
    for (int i = -16777216;; i = -1)
    {
      this.lEr = i;
      bre();
      AppMethodBeat.o(135428);
      return;
    }
  }
  
  public final void setFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(135437);
    this.lRd = paramBoolean;
    brh();
    View localView = this.lQS;
    if (this.lRd) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      requestLayout();
      setBackgroundColor(this.lRa);
      AppMethodBeat.o(135437);
      return;
    }
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(135435);
    if (this.lRh != null)
    {
      this.lRh.gK(paramBoolean);
      AppMethodBeat.o(135435);
      return;
    }
    ProgressBar localProgressBar = this.lQU;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      this.lQV.fQW();
      this.lQV.start();
      AppMethodBeat.o(135435);
      return;
    }
    this.lQV.stop();
    AppMethodBeat.o(135435);
  }
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(135415);
    boolean bool = isLayoutRequested();
    this.lQT.setText(paramCharSequence);
    if (bool) {
      requestLayout();
    }
    AppMethodBeat.o(135415);
  }
  
  public final void setNavButtonLongClickListener(final View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(135413);
    this.lQQ.setOnLongClickListener(new View.OnLongClickListener()
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
    if (this.lQR != null) {
      this.lQR.setMinimumWidth(paramInt);
    }
    AppMethodBeat.o(178643);
  }
  
  public final void setNavHidden(boolean paramBoolean)
  {
    AppMethodBeat.i(135433);
    this.lRc = paramBoolean;
    brh();
    bre();
    AppMethodBeat.o(135433);
  }
  
  public final void setNavLoadingIconVisibilityResetListener(b paramb)
  {
    this.lRh = paramb;
  }
  
  public final void setNavResetStyleListener(c paramc)
  {
    this.lRg = paramc;
  }
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135423);
    this.lQW.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(135423);
  }
  
  public final void uw(int paramInt)
  {
    AppMethodBeat.i(178642);
    this.lRa = paramInt;
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
        paramImageView.setColorFilter(b.this.lEr, PorterDuff.Mode.SRC_ATOP);
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
    
    public final int bkf()
    {
      return 2131165747;
    }
  }
  
  public static abstract interface b
  {
    public abstract void gK(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public static final int lRp = 2131165747;
    
    public abstract void a(ImageView paramImageView, View paramView1, View paramView2);
    
    public abstract int bkf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b
 * JD-Core Version:    0.7.0.1
 */