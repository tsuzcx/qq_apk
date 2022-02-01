package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;

public final class d
  extends FrameLayout
  implements bz, g
{
  private int nvb;
  private AppBrandOptionButton nvc;
  private AppBrandCapsuleHomeButton nvd;
  private LinearLayout nve;
  private View nvf;
  public View nvg;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(219479);
    this.nvb = 0;
    LayoutInflater.from(paramContext).inflate(2131493016, this);
    this.nvc = ((AppBrandOptionButton)findViewById(2131296428));
    this.nvd = ((AppBrandCapsuleHomeButton)findViewById(2131296427));
    this.nve = ((LinearLayout)findViewById(2131296424));
    this.nvf = findViewById(2131296426);
    this.nvc.setAccessibilityLabel(getContext().getString(2131755326));
    this.nvd.setAccessibilityLabel(getContext().getString(2131755322));
    AppMethodBeat.o(219479);
  }
  
  public final boolean c(Canvas paramCanvas)
  {
    AppMethodBeat.i(219480);
    draw(paramCanvas);
    AppMethodBeat.o(219480);
    return true;
  }
  
  public final View getCapsuleContentAreaView()
  {
    return this.nve;
  }
  
  public final AppBrandCapsuleHomeButton getCapsuleHomeButton()
  {
    return this.nvd;
  }
  
  public final AppBrandOptionButton getOptionBtn()
  {
    return this.nvc;
  }
  
  public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(219482);
    this.nvd.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(219482);
  }
  
  public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(219483);
    this.nvc.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(219483);
  }
  
  public final void setStyleColor(int paramInt)
  {
    AppMethodBeat.i(219481);
    if (paramInt == this.nvb)
    {
      AppMethodBeat.o(219481);
      return;
    }
    if (paramInt == -1)
    {
      this.nvb = -1;
      this.nvf.setBackgroundResource(2131099939);
      this.nve.setBackgroundResource(2131231007);
      this.nvc.setColor(-1);
      this.nvd.setColor(-1);
    }
    for (;;)
    {
      if (this.nvg != null)
      {
        this.nvg.animate().cancel();
        removeView(this.nvg);
      }
      AppMethodBeat.o(219481);
      return;
      this.nvb = -16777216;
      this.nvf.setBackgroundResource(2131099940);
      this.nve.setBackgroundResource(2131231008);
      this.nvc.setColor(-16777216);
      this.nvd.setColor(-16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.d
 * JD-Core Version:    0.7.0.1
 */