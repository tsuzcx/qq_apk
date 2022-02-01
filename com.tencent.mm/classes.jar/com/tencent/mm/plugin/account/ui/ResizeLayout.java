package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResizeLayout
  extends LinearLayout
{
  private a jtL = null;
  
  public ResizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(128726);
    if (this.jtL != null) {
      this.jtL.aUw();
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(128726);
  }
  
  public void setOnSizeChanged(a parama)
  {
    this.jtL = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aUw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ResizeLayout
 * JD-Core Version:    0.7.0.1
 */