package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;

public final class d
  extends FrameLayout
  implements g
{
  private int mkE;
  private AppBrandOptionButton mkF;
  private AppBrandCapsuleHomeButton mkG;
  private LinearLayout mkH;
  private View mkI;
  public View mkJ;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(207878);
    this.mkE = 0;
    LayoutInflater.from(paramContext).inflate(2131496508, this);
    this.mkF = ((AppBrandOptionButton)findViewById(2131296402));
    this.mkG = ((AppBrandCapsuleHomeButton)findViewById(2131296401));
    this.mkH = ((LinearLayout)findViewById(2131296399));
    this.mkI = findViewById(2131296400);
    this.mkF.setAccessibilityLabel(getContext().getString(2131755290));
    this.mkG.setAccessibilityLabel(getContext().getString(2131755286));
    AppMethodBeat.o(207878);
  }
  
  public final View getCapsuleContentAreaView()
  {
    return this.mkH;
  }
  
  public final AppBrandCapsuleHomeButton getCapsuleHomeButton()
  {
    return this.mkG;
  }
  
  public final AppBrandOptionButton getOptionBtn()
  {
    return this.mkF;
  }
  
  public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(207880);
    this.mkG.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(207880);
  }
  
  public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(207881);
    this.mkF.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(207881);
  }
  
  public final void setStyleColor(int paramInt)
  {
    AppMethodBeat.i(207879);
    if (paramInt == this.mkE)
    {
      AppMethodBeat.o(207879);
      return;
    }
    if (paramInt == -1)
    {
      this.mkE = -1;
      this.mkI.setBackgroundResource(2131099920);
      this.mkH.setBackgroundResource(2131230978);
      this.mkF.setColor(-1);
      this.mkG.setColor(-1);
    }
    for (;;)
    {
      if (this.mkJ != null)
      {
        this.mkJ.animate().cancel();
        removeView(this.mkJ);
      }
      AppMethodBeat.o(207879);
      return;
      this.mkE = -16777216;
      this.mkI.setBackgroundResource(2131099921);
      this.mkH.setBackgroundResource(2131230979);
      this.mkF.setColor(-16777216);
      this.mkG.setColor(-16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.d
 * JD-Core Version:    0.7.0.1
 */