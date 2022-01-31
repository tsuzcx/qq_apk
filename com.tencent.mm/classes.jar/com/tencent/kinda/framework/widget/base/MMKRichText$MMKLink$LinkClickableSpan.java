package com.tencent.kinda.framework.widget.base;

import android.view.View;
import com.tencent.kinda.gen.LinkStyle;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.n;

class MMKRichText$MMKLink$LinkClickableSpan
  extends n
{
  private VoidCallback clickCallback;
  private int linkColor;
  private LinkStyle linkStyle;
  
  public MMKRichText$MMKLink$LinkClickableSpan(int paramInt, VoidCallback paramVoidCallback)
  {
    super(2, null);
    AppMethodBeat.i(144946);
    this.linkColor = paramInt;
    this.clickCallback = paramVoidCallback;
    setColor(this.linkColor, 0);
    AppMethodBeat.o(144946);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(144947);
    if (this.clickCallback != null) {
      this.clickCallback.call();
    }
    AppMethodBeat.o(144947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKRichText.MMKLink.LinkClickableSpan
 * JD-Core Version:    0.7.0.1
 */