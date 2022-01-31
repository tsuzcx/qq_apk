package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ThrowBottleFooter
  extends LinearLayout
{
  private ThrowBottleFooter.a ibl;
  
  public ThrowBottleFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.ibl != null) {
      this.ibl.axh();
    }
  }
  
  public void setOnLayoutChangeListener(ThrowBottleFooter.a parama)
  {
    this.ibl = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.ThrowBottleFooter
 * JD-Core Version:    0.7.0.1
 */