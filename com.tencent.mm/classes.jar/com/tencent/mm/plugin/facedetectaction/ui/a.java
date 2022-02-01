package com.tencent.mm.plugin.facedetectaction.ui;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.ui.aw;

public final class a
  extends t
{
  private boolean Abi = true;
  private int Abj = 0;
  private a.a Abk;
  private boolean bold = true;
  private String text = "";
  private int textColor = 0;
  
  public a(String paramString, int paramInt1, int paramInt2, a.a parama)
  {
    super(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.Abj = paramInt2;
    this.bold = true;
    this.text = paramString;
    this.Abk = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(262614);
    if ((this.Abi) && (this.Abk != null)) {
      this.Abk.onClick(this.text);
    }
    AppMethodBeat.o(262614);
  }
  
  public final void setColor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(262604);
    super.setColor(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.Abj = paramInt2;
    AppMethodBeat.o(262604);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(262608);
    super.updateDrawState(paramTextPaint);
    if (this.bold) {
      aw.a(paramTextPaint, 0.8F);
    }
    AppMethodBeat.o(262608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.a
 * JD-Core Version:    0.7.0.1
 */