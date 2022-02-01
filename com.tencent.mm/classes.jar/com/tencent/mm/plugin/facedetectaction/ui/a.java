package com.tencent.mm.plugin.facedetectaction.ui;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.ui.al;

public final class a
  extends o
{
  private a EIt;
  private boolean sWc = true;
  private int sWd = 0;
  private boolean sWe = true;
  private String text = "";
  private int textColor = 0;
  
  public a(String paramString, int paramInt1, int paramInt2, a parama)
  {
    super(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.sWd = paramInt2;
    this.sWe = true;
    this.text = paramString;
    this.EIt = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(221173);
    if ((this.sWc) && (this.EIt != null)) {
      this.EIt.axC(this.text);
    }
    AppMethodBeat.o(221173);
  }
  
  public final void setColor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221171);
    super.setColor(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.sWd = paramInt2;
    AppMethodBeat.o(221171);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(221172);
    super.updateDrawState(paramTextPaint);
    if (this.sWe) {
      al.a(paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(221172);
  }
  
  static abstract interface a
  {
    public abstract void axC(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.a
 * JD-Core Version:    0.7.0.1
 */