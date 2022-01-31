package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;

@SuppressLint({"ViewConstructor"})
final class f
  extends com.tencent.mm.ui.statusbar.b
  implements r
{
  private i gRG;
  private Runnable iNb;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b ixl;
  
  public f(Context paramContext, i parami)
  {
    super(paramContext);
    AppMethodBeat.i(102314);
    this.gRG = parami;
    this.ixl = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(paramContext);
    this.ixl.setFullscreenMode(false);
    addView(this.ixl.getActionView());
    this.ixl.fb(false);
    paramContext = new f.1(this);
    this.ixl.setCloseButtonClickListener(paramContext);
    this.ixl.setBackButtonClickListener(paramContext);
    paramContext = getContext().getString(2131296558);
    this.ixl.setMainTitle(paramContext);
    this.ixl.setBackgroundColor(-1);
    this.ixl.setForegroundStyle("black");
    this.ixl.setLoadingIconVisibility(true);
    K(-1, "black".equals("black"));
    setBackgroundColor(-1);
    AppMethodBeat.o(102314);
  }
  
  public final void aHA()
  {
    AppMethodBeat.i(102318);
    removeCallbacks(this.iNb);
    post(new f.3(this));
    AppMethodBeat.o(102318);
  }
  
  public final void aHB()
  {
    AppMethodBeat.i(102319);
    this.ixl.setNavHidden(true);
    AppMethodBeat.o(102319);
  }
  
  public final void cD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102315);
    this.ixl.setMainTitle(getContext().getString(2131296558));
    AppMethodBeat.o(102315);
  }
  
  public final View getView()
  {
    return this;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(102316);
    super.onAttachedToWindow();
    if (this.iNb == null)
    {
      this.iNb = new f.2(this);
      postDelayed(this.iNb, 1500L);
    }
    AppMethodBeat.o(102316);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(102317);
    super.onDetachedFromWindow();
    removeCallbacks(this.iNb);
    AppMethodBeat.o(102317);
  }
  
  public final void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.f
 * JD-Core Version:    0.7.0.1
 */