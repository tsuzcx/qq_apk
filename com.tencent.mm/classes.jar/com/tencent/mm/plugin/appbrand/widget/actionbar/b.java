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
import com.tencent.mm.plugin.appbrand.page.a.d.a;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import d.g.b.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class b
  extends LinearLayout
  implements f.b, f.d, f
{
  private View iCR;
  protected int mGM;
  protected View mTA;
  protected View mTB;
  protected TextView mTC;
  protected ProgressBar mTD;
  protected CircleProgressDrawable mTE;
  protected AppBrandOptionButton mTF;
  protected AppBrandCapsuleHomeButton mTG;
  protected LinearLayout mTH;
  protected View mTI;
  protected int mTJ;
  protected double mTK;
  protected boolean mTL;
  protected boolean mTM;
  protected c mTN;
  private e mTO;
  private b.c mTP;
  private b mTQ;
  private final Set<a> mTR;
  private boolean mTS;
  private AppBrandActionBarCustomImageView mTT;
  protected ImageView mTy;
  protected View mTz;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135409);
    this.mTN = new c();
    this.mTP = new b.a(this, (byte)0);
    this.mTR = new LinkedHashSet();
    this.mTS = false;
    this.mTL = false;
    this.mTM = false;
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setBackgroundResource(2131099873);
    this.iCR = LayoutInflater.from(getContext()).inflate(2131492964, this, false);
    addView(this.iCR);
    this.mGM = -1;
    this.mTJ = getResources().getColor(2131099873);
    this.mTK = 1.0D;
    this.mTA = findViewById(2131296405);
    this.mTy = ((ImageView)findViewById(2131296406));
    this.mTz = findViewById(2131296404);
    this.mTB = findViewById(2131296412);
    this.mTC = ((TextView)findViewById(2131296415));
    this.mTD = ((ProgressBar)findViewById(2131296403));
    this.mTE = new CircleProgressDrawable(getContext());
    this.mTF = ((AppBrandOptionButton)findViewById(2131296402));
    this.mTG = ((AppBrandCapsuleHomeButton)findViewById(2131296401));
    this.mTH = ((LinearLayout)findViewById(2131296399));
    this.mTI = findViewById(2131296400);
    this.mTO = new e();
    paramContext = this.mTO;
    AppBrandOptionButton localAppBrandOptionButton = this.mTF;
    p.h(localAppBrandOptionButton, "button");
    paramContext.mUg = localAppBrandOptionButton;
    this.mTz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(135404);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.this.mTN.cU(b.this.mTz);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(135404);
      }
    });
    this.mTG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(135405);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = b.this.mTN;
        paramAnonymousView = b.this.mTG;
        if (((c)localObject).mTZ.isEmpty()) {}
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            b.this.mTN.cU(b.this.mTG);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(135405);
          return;
          localObject = ((c)localObject).mTZ.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramAnonymousView);
          }
        }
      }
    });
    this.mTF.setAccessibilityLabel(getContext().getString(2131755290));
    this.mTG.setAccessibilityLabel(getContext().getString(2131755286));
    AppMethodBeat.o(135409);
  }
  
  private void bCh()
  {
    AppMethodBeat.i(135419);
    this.mTB.setOnClickListener(new b.4(this));
    AppMethodBeat.o(135419);
  }
  
  private void bCl()
  {
    AppMethodBeat.i(135432);
    if (this.mGM == -1)
    {
      this.mTF.setColor(-1);
      this.mTG.setColor(-1);
      AppMethodBeat.o(135432);
      return;
    }
    this.mTF.setColor(-16777216);
    this.mTG.setColor(-16777216);
    AppMethodBeat.o(135432);
  }
  
  private void bCn()
  {
    AppMethodBeat.i(135434);
    View localView = this.mTz;
    if ((this.mTM) || (this.mTL)) {}
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
    if (!this.mTM)
    {
      super.setBackgroundColor(paramInt);
      AppMethodBeat.o(135421);
      return;
    }
    super.setBackgroundColor(0);
    AppMethodBeat.o(135421);
  }
  
  private void vU(int paramInt)
  {
    AppMethodBeat.i(135431);
    if (paramInt == -1)
    {
      this.mTI.setBackgroundResource(2131099920);
      this.mTH.setBackgroundResource(2131230978);
      AppMethodBeat.o(135431);
      return;
    }
    this.mTI.setBackgroundResource(2131099921);
    this.mTH.setBackgroundResource(2131230979);
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
    this.mTR.add(parama);
    if (!this.mTS)
    {
      bCh();
      this.mTS = true;
    }
    AppMethodBeat.o(135414);
  }
  
  public final boolean bCi()
  {
    AppMethodBeat.i(135425);
    if (this.mTH.getVisibility() == 0)
    {
      AppMethodBeat.o(135425);
      return true;
    }
    AppMethodBeat.o(135425);
    return false;
  }
  
  public final void bCj()
  {
    AppMethodBeat.i(135426);
    this.mTF.reset();
    this.mTG.reset();
    bCl();
    AppMethodBeat.o(135426);
  }
  
  public final void bCk()
  {
    AppMethodBeat.i(135430);
    if (this.mTP != null) {
      this.mTP.a(this.mTy, this.mTz, this.mTA);
    }
    this.mTC.setTextColor(this.mGM);
    this.mTE.setStrokeColor(this.mGM);
    this.mTD.setIndeterminateDrawable(this.mTE);
    bCl();
    vU(this.mGM);
    AppMethodBeat.o(135430);
  }
  
  public final boolean bCm()
  {
    return this.mTL;
  }
  
  public final boolean bCo()
  {
    AppMethodBeat.i(135436);
    if (this.mTD.getVisibility() == 0)
    {
      AppMethodBeat.o(135436);
      return true;
    }
    AppMethodBeat.o(135436);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(197466);
    if (this.mTE != null) {
      this.mTE.stop();
    }
    removeAllViews();
    getCapsuleBar().destroy();
    AppMethodBeat.o(197466);
  }
  
  public final View getActionView()
  {
    return this;
  }
  
  public final double getBackgroundAlpha()
  {
    return this.mTK;
  }
  
  public final int getBackgroundColor()
  {
    if (this.mTM) {
      return 0;
    }
    return this.mTJ;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.a.b getCapsuleBar()
  {
    return this.mTO;
  }
  
  public final View getCapsuleView()
  {
    return this.mTH;
  }
  
  public final int getForegroundColor()
  {
    return this.mGM;
  }
  
  public final CharSequence getMainTitle()
  {
    AppMethodBeat.i(135418);
    CharSequence localCharSequence = this.mTC.getText();
    AppMethodBeat.o(135418);
    return localCharSequence;
  }
  
  public final b.c getNavResetStyleListener()
  {
    return this.mTP;
  }
  
  public final AppBrandOptionButton getOptionButton()
  {
    return this.mTF;
  }
  
  public final void hK(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(135424);
    Object localObject = this.mTH;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((LinearLayout)localObject).setVisibility(i);
      if (this.mTH.getLayoutParams() != null)
      {
        localObject = this.mTH.getLayoutParams();
        i = j;
        if (paramBoolean) {
          i = -2;
        }
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.mTH.requestLayout();
      }
      AppMethodBeat.o(135424);
      return;
    }
  }
  
  public final void hW(boolean paramBoolean)
  {
    AppMethodBeat.i(135438);
    View localView = this.mTz;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(135438);
      return;
    }
  }
  
  public final void hX(boolean paramBoolean)
  {
    AppMethodBeat.i(135439);
    View localView = this.mTB;
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
    return this.mTM;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(197467);
    if (this.mTE != null) {
      this.mTE.stop();
    }
    AppMethodBeat.o(197467);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(197468);
    if ((bCo()) && (this.mTE != null)) {
      this.mTE.start();
    }
    AppMethodBeat.o(197468);
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
    ViewGroup.LayoutParams localLayoutParams = this.iCR.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = paramInt;
      this.iCR.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(178644);
  }
  
  public final void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135410);
    this.mTN.mUa.add(paramOnClickListener);
    AppMethodBeat.o(135410);
  }
  
  public final void setBackgroundAlpha(double paramDouble)
  {
    AppMethodBeat.i(135420);
    this.mTK = paramDouble;
    if (!this.mTM)
    {
      Drawable localDrawable2 = super.getBackground();
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null)
      {
        setBackgroundColorInternal(this.mTJ);
        localDrawable1 = super.getBackground();
      }
      localDrawable1.setAlpha((int)(255.0D * paramDouble));
    }
    AppMethodBeat.o(135420);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(135422);
    this.mTJ = paramInt;
    setBackgroundColorInternal(paramInt);
    setBackgroundAlpha(this.mTK);
    AppMethodBeat.o(135422);
  }
  
  public final void setCapsuleHomeButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(135412);
    this.mTG.setOnLongClickListener(paramOnLongClickListener);
    AppMethodBeat.o(135412);
  }
  
  public final void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135411);
    this.mTN.mTZ.add(paramOnClickListener);
    AppMethodBeat.o(135411);
  }
  
  public final void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(135429);
    this.mGM = paramInt;
    bCk();
    AppMethodBeat.o(135429);
  }
  
  public final void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(135427);
    this.mGM = d.a.TA(paramString).mga;
    bCk();
    AppMethodBeat.o(135427);
  }
  
  public final void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(135428);
    if (paramBoolean) {}
    for (int i = -16777216;; i = -1)
    {
      this.mGM = i;
      bCk();
      AppMethodBeat.o(135428);
      return;
    }
  }
  
  public final void setFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(135437);
    this.mTM = paramBoolean;
    bCn();
    View localView = this.mTB;
    if (this.mTM) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      requestLayout();
      setBackgroundColor(this.mTJ);
      AppMethodBeat.o(135437);
      return;
    }
  }
  
  public final void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(135435);
    if (this.mTQ != null)
    {
      this.mTQ.hm(paramBoolean);
      AppMethodBeat.o(135435);
      return;
    }
    ProgressBar localProgressBar = this.mTD;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      this.mTE.Mx();
      this.mTE.start();
      AppMethodBeat.o(135435);
      return;
    }
    this.mTE.stop();
    AppMethodBeat.o(135435);
  }
  
  public final void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(135415);
    boolean bool = isLayoutRequested();
    this.mTC.setText(paramCharSequence);
    if (bool) {
      requestLayout();
    }
    AppMethodBeat.o(135415);
  }
  
  public final void setNavButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(135413);
    this.mTz.setOnLongClickListener(new b.3(this, paramOnLongClickListener));
    AppMethodBeat.o(135413);
  }
  
  public final void setNavContainerMinimumWidth(int paramInt)
  {
    AppMethodBeat.i(178643);
    if (this.mTA != null) {
      this.mTA.setMinimumWidth(paramInt);
    }
    AppMethodBeat.o(178643);
  }
  
  public final void setNavHidden(boolean paramBoolean)
  {
    AppMethodBeat.i(135433);
    this.mTL = paramBoolean;
    bCn();
    bCk();
    AppMethodBeat.o(135433);
  }
  
  public final void setNavLoadingIconVisibilityResetListener(b paramb)
  {
    this.mTQ = paramb;
  }
  
  public final void setNavResetStyleListener(b.c paramc)
  {
    this.mTP = paramc;
  }
  
  public final void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(135423);
    this.mTF.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(135423);
  }
  
  public final void vT(int paramInt)
  {
    AppMethodBeat.i(178642);
    this.mTJ = paramInt;
    super.setBackgroundColor(paramInt);
    AppMethodBeat.o(178642);
  }
  
  public static abstract interface b
  {
    public abstract void hm(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b
 * JD-Core Version:    0.7.0.1
 */