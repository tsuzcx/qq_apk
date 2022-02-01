package com.tencent.kinda.framework.widget.base;

import android.view.View;
import com.tencent.kinda.gen.LinkStyle;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.o;

class MMKRichText$MMKLink$LinkClickableSpan
  extends o
{
  private VoidCallback clickCallback;
  private int linkColor;
  private LinkStyle linkStyle;
  
  public MMKRichText$MMKLink$LinkClickableSpan(int paramInt, VoidCallback paramVoidCallback)
  {
    super(2, null);
    AppMethodBeat.i(19105);
    this.linkColor = paramInt;
    this.clickCallback = paramVoidCallback;
    setColor(this.linkColor, 0);
    AppMethodBeat.o(19105);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(19106);
    if (this.clickCallback != null) {
      this.clickCallback.call();
    }
    AppMethodBeat.o(19106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKRichText.MMKLink.LinkClickableSpan
 * JD-Core Version:    0.7.0.1
 */