package com.tencent.mm.plugin.facedetectaction.ui;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.ui.ar;

public final class a
  extends p
{
  private String text = "";
  private int textColor = 0;
  private boolean wEW = true;
  private int wEX = 0;
  private boolean wEY = true;
  private a wEZ;
  
  public a(String paramString, int paramInt1, int paramInt2, a parama)
  {
    super(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.wEX = paramInt2;
    this.wEY = true;
    this.text = paramString;
    this.wEZ = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190992);
    if ((this.wEW) && (this.wEZ != null)) {
      this.wEZ.azH(this.text);
    }
    AppMethodBeat.o(190992);
  }
  
  public final void setColor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190987);
    super.setColor(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.wEX = paramInt2;
    AppMethodBeat.o(190987);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(190988);
    super.updateDrawState(paramTextPaint);
    if (this.wEY) {
      ar.a(paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(190988);
  }
  
  public static abstract interface a
  {
    public abstract void azH(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.a
 * JD-Core Version:    0.7.0.1
 */