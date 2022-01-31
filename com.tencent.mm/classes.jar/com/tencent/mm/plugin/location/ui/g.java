package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.d;

public final class g
  extends FrameLayout
{
  private Context mContext;
  private ImageView ocK;
  public d ocL;
  public boolean oct;
  
  public g(Context paramContext, d paramd)
  {
    super(paramContext);
    AppMethodBeat.i(113471);
    this.oct = false;
    this.ocL = paramd;
    this.mContext = paramContext;
    this.ocK = ((ImageView)View.inflate(this.mContext, 2130970427, this).findViewById(2131826757));
    AppMethodBeat.o(113471);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(113472);
    if (this.oct) {
      this.ocL.removeView(this);
    }
    this.oct = false;
    AppMethodBeat.o(113472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.g
 * JD-Core Version:    0.7.0.1
 */