package com.tencent.mm.plugin.appbrand.widget.actionbar;

import a.f.b.j;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.d.a;
import com.tencent.mm.plugin.appbrand.widget.AppBrandActionBarCustomImageView;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class b
  extends LinearLayout
  implements f
{
  protected ImageView jaV;
  protected View jaW;
  protected View jaX;
  protected TextView jaY;
  protected TextView jaZ;
  protected ProgressBar jba;
  protected CircleProgressDrawable jbb;
  protected AppBrandOptionButton jbc;
  protected AppBrandCapsuleHomeButton jbd;
  protected LinearLayout jbe;
  protected ImageView jbf;
  protected int jbg;
  protected int jbh;
  protected double jbi;
  protected boolean jbj;
  protected boolean jbk;
  protected c jbl;
  private e jbm;
  private b.b jbn;
  private b.a jbo;
  private final Set<a> jbp;
  private boolean jbq;
  private AppBrandActionBarCustomImageView jbr;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(87453);
    this.jbl = new c();
    this.jbp = new LinkedHashSet();
    this.jbq = false;
    this.jbj = false;
    this.jbk = false;
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setBackgroundResource(2131689641);
    addView(LayoutInflater.from(getContext()).inflate(2130968655, this, false));
    this.jbg = -1;
    this.jbh = getResources().getColor(2131689641);
    this.jbi = 1.0D;
    this.jaV = ((ImageView)findViewById(2131821133));
    this.jaW = findViewById(2131821132);
    this.jaX = findViewById(2131821140);
    this.jaY = ((TextView)findViewById(2131821142));
    this.jaZ = ((TextView)findViewById(2131821143));
    this.jba = ((ProgressBar)findViewById(2131821144));
    this.jbb = new CircleProgressDrawable(getContext());
    this.jbc = ((AppBrandOptionButton)findViewById(2131821136));
    this.jbd = ((AppBrandCapsuleHomeButton)findViewById(2131821138));
    this.jbe = ((LinearLayout)findViewById(2131821135));
    this.jbr = ((AppBrandActionBarCustomImageView)findViewById(2131821139));
    this.jbf = ((ImageView)findViewById(2131821137));
    this.jbm = new e();
    paramContext = this.jbm;
    AppBrandOptionButton localAppBrandOptionButton = this.jbc;
    j.q(localAppBrandOptionButton, "button");
    paramContext.jbC = localAppBrandOptionButton;
    this.jaW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(87449);
        b.this.jbl.cE(b.this.jaW);
        AppMethodBeat.o(87449);
      }
    });
    this.jbd.setOnClickListener(new b.2(this));
    this.jbc.setAccessibilityLabel(getContext().getString(2131296555));
    this.jbd.setAccessibilityLabel(getContext().getString(2131296551));
    AppMethodBeat.o(87453);
  }
  
  private void aOE()
  {
    AppMethodBeat.i(87463);
    this.jaX.setOnClickListener(new b.4(this));
    AppMethodBeat.o(87463);
  }
  
  private void aOH()
  {
    AppMethodBeat.i(87473);
    if (this.jbn == null)
    {
      this.jaV.setImageResource(2130837617);
      this.jaV.setColorFilter(this.jbg, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      this.jaY.setTextColor(this.jbg);
      this.jaZ.setTextColor(this.jbg);
      this.jbb.setStrokeColor(this.jbg);
      this.jba.setIndeterminateDrawable(this.jbb);
      aOI();
      pV(this.jbg);
      AppMethodBeat.o(87473);
      return;
      this.jbn.a(this.jaV, this.jaW);
    }
  }
  
  private void aOI()
  {
    AppMethodBeat.i(87475);
    if (this.jbg == -1)
    {
      this.jbc.setColor(-1);
      this.jbd.setColor(-1);
      AppMethodBeat.o(87475);
      return;
    }
    this.jbc.setColor(-16777216);
    this.jbd.setColor(-16777216);
    AppMethodBeat.o(87475);
  }
  
  private void aOK()
  {
    AppMethodBeat.i(87478);
    View localView = this.jaW;
    if ((this.jbk) || (this.jbj)) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      requestLayout();
      AppMethodBeat.o(87478);
      return;
    }
  }
  
  private void pV(int paramInt)
  {
    AppMethodBeat.i(87474);
    if (paramInt == -1)
    {
      this.jbf.setImageResource(2131689680);
      this.jbe.setBackgroundResource(2130837741);
      AppMethodBeat.o(87474);
      return;
    }
    this.jbf.setImageResource(2131689681);
    this.jbe.setBackgroundResource(2130837742);
    AppMethodBeat.o(87474);
  }
  
  private void setBackgroundColorInternal(int paramInt)
  {
    AppMethodBeat.i(141719);
    if (!this.jbk)
    {
      super.setBackgroundColor(paramInt);
      AppMethodBeat.o(141719);
      return;
    }
    super.setBackgroundColor(0);
    AppMethodBeat.o(141719);
  }
  
  public final void a(Bitmap paramBitmap, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(141721);
    al.d(new b.5(this, paramBitmap, paramOnClickListener));
    AppMethodBeat.o(141721);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(87457);
    this.jbp.add(parama);
    if (!this.jbq)
    {
      aOE();
      this.jbq = true;
    }
    AppMethodBeat.o(87457);
  }
  
  public final boolean aOF()
  {
    AppMethodBeat.i(87468);
    if (this.jbe.getVisibility() == 0)
    {
      AppMethodBeat.o(87468);
      return true;
    }
    AppMethodBeat.o(87468);
    return false;
  }
  
  public final void aOG()
  {
    AppMethodBeat.i(87469);
    this.jbc.reset();
    this.jbd.reset();
    aOI();
    AppMethodBeat.o(87469);
  }
  
  public final boolean aOJ()
  {
    return this.jbj;
  }
  
  public final boolean aOL()
  {
    AppMethodBeat.i(141720);
    if (this.jba.getVisibility() == 0)
    {
      AppMethodBeat.o(141720);
      return true;
    }
    AppMethodBeat.o(141720);
    return false;
  }
  
  public final void aOM()
  {
    AppMethodBeat.i(87481);
    this.jaW.setVisibility(0);
    requestLayout();
    AppMethodBeat.o(87481);
  }
  
  public final void fb(boolean paramBoolean)
  {
    AppMethodBeat.i(87467);
    if (paramBoolean)
    {
      this.jbe.setVisibility(0);
      AppMethodBeat.o(87467);
      return;
    }
    this.jbe.setVisibility(8);
    AppMethodBeat.o(87467);
  }
  
  public View getActionView()
  {
    return this;
  }
  
  public final double getBackgroundAlpha()
  {
    return this.jbi;
  }
  
  public final int getBackgroundColor()
  {
    if (this.jbk) {
      return 0;
    }
    return this.jbh;
  }
  
  public com.tencent.mm.plugin.appbrand.page.a.b getCapsuleBar()
  {
    return this.jbm;
  }
  
  public View getCapsuleView()
  {
    return this.jbe;
  }
  
  public int getForegroundColor()
  {
    return this.jbg;
  }
  
  public CharSequence getMainTitle()
  {
    AppMethodBeat.i(87461);
    CharSequence localCharSequence = this.jaY.getText();
    AppMethodBeat.o(87461);
    return localCharSequence;
  }
  
  public final boolean isFullscreenMode()
  {
    return this.jbk;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(87459);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(87459);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(87460);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(87460);
  }
  
  public void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(87454);
    this.jbl.jbw.add(paramOnClickListener);
    AppMethodBeat.o(87454);
  }
  
  public final void setBackgroundAlpha(double paramDouble)
  {
    AppMethodBeat.i(87464);
    this.jbi = paramDouble;
    if (!this.jbk)
    {
      Drawable localDrawable2 = super.getBackground();
      Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null)
      {
        setBackgroundColorInternal(this.jbh);
        localDrawable1 = super.getBackground();
      }
      localDrawable1.setAlpha((int)(255.0D * paramDouble));
    }
    AppMethodBeat.o(87464);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(87465);
    this.jbh = paramInt;
    setBackgroundColorInternal(paramInt);
    setBackgroundAlpha(this.jbi);
    AppMethodBeat.o(87465);
  }
  
  public void setCapsuleHomeButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(87456);
    this.jbd.setOnLongClickListener(paramOnLongClickListener);
    AppMethodBeat.o(87456);
  }
  
  public void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(87455);
    this.jbl.jbv.add(paramOnClickListener);
    AppMethodBeat.o(87455);
  }
  
  public void setForegroundColor(int paramInt)
  {
    AppMethodBeat.i(87472);
    this.jbg = paramInt;
    aOH();
    AppMethodBeat.o(87472);
  }
  
  public void setForegroundStyle(String paramString)
  {
    AppMethodBeat.i(87470);
    this.jbg = d.a.Es(paramString).iAo;
    aOH();
    AppMethodBeat.o(87470);
  }
  
  public void setForegroundStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(87471);
    if (paramBoolean) {}
    for (int i = -16777216;; i = -1)
    {
      this.jbg = i;
      aOH();
      AppMethodBeat.o(87471);
      return;
    }
  }
  
  public void setFullscreenMode(boolean paramBoolean)
  {
    AppMethodBeat.i(87480);
    this.jbk = paramBoolean;
    aOK();
    View localView = this.jaX;
    if (this.jbk) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      requestLayout();
      setBackgroundColor(this.jbh);
      AppMethodBeat.o(87480);
      return;
    }
  }
  
  public void setLoadingIconVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(87479);
    if (this.jbo != null)
    {
      this.jbo.eI(paramBoolean);
      AppMethodBeat.o(87479);
      return;
    }
    ProgressBar localProgressBar = this.jba;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      this.jbb.aQG();
      this.jbb.start();
      AppMethodBeat.o(87479);
      return;
    }
    this.jbb.stop();
    AppMethodBeat.o(87479);
  }
  
  public void setMainTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141718);
    boolean bool = isLayoutRequested();
    this.jaY.setText(paramCharSequence);
    if (bool) {
      requestLayout();
    }
    AppMethodBeat.o(141718);
  }
  
  public void setNavButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(141717);
    this.jaW.setOnLongClickListener(new b.3(this, paramOnLongClickListener));
    AppMethodBeat.o(141717);
  }
  
  public void setNavHidden(boolean paramBoolean)
  {
    AppMethodBeat.i(87477);
    this.jbj = paramBoolean;
    aOK();
    aOH();
    AppMethodBeat.o(87477);
  }
  
  public void setNavLoadingIconVisibilityResetListener(b.a parama)
  {
    this.jbo = parama;
  }
  
  public void setNavResetStyleListener(b.b paramb)
  {
    this.jbn = paramb;
  }
  
  public void setOptionButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(87466);
    this.jbc.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(87466);
  }
  
  public void setSubTitle(String paramString)
  {
    AppMethodBeat.i(87462);
    if (bo.isNullOrNil(paramString)) {
      this.jaZ.setVisibility(8);
    }
    for (;;)
    {
      this.jaZ.clearAnimation();
      AppMethodBeat.o(87462);
      return;
      this.jaZ.setVisibility(0);
      this.jaZ.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b
 * JD-Core Version:    0.7.0.1
 */