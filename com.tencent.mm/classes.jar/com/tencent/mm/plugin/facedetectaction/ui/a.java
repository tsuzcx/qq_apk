package com.tencent.mm.plugin.facedetectaction.ui;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.ui.al;

public final class a
  extends o
{
  private boolean ryP = true;
  private int ryQ = 0;
  private boolean ryR = true;
  private a ryS;
  private String text = "";
  private int textColor = 0;
  
  public a(String paramString, int paramInt1, int paramInt2, a parama)
  {
    super(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.ryQ = paramInt2;
    this.ryR = true;
    this.text = paramString;
    this.ryS = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(188673);
    if ((this.ryP) && (this.ryS != null)) {
      this.ryS.agX(this.text);
    }
    AppMethodBeat.o(188673);
  }
  
  public final void setColor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188671);
    super.setColor(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.ryQ = paramInt2;
    AppMethodBeat.o(188671);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(188672);
    super.updateDrawState(paramTextPaint);
    if (this.ryR) {
      al.a(paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(188672);
  }
  
  static abstract interface a
  {
    public abstract void agX(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.a
 * JD-Core Version:    0.7.0.1
 */