package com.tencent.mm.plugin.facedetectaction.ui;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.ui.ao;

public final class a
  extends p
{
  private boolean sYU = true;
  private int sYV = 0;
  private boolean sYW = true;
  private a sYX;
  private String text = "";
  private int textColor = 0;
  
  public a(String paramString, int paramInt1, int paramInt2, a parama)
  {
    super(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.sYV = paramInt2;
    this.sYW = true;
    this.text = paramString;
    this.sYX = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(186417);
    if ((this.sYU) && (this.sYX != null)) {
      this.sYX.arG(this.text);
    }
    AppMethodBeat.o(186417);
  }
  
  public final void setColor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186415);
    super.setColor(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.sYV = paramInt2;
    AppMethodBeat.o(186415);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(186416);
    super.updateDrawState(paramTextPaint);
    if (this.sYW) {
      ao.a(paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(186416);
  }
  
  public static abstract interface a
  {
    public abstract void arG(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.a
 * JD-Core Version:    0.7.0.1
 */