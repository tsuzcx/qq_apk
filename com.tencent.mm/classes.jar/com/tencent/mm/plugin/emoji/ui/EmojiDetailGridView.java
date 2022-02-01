package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.SmileySubGrid;

public class EmojiDetailGridView
  extends SmileySubGrid
{
  private String pMk;
  private EmojiDetailScrollView pPT;
  private volatile boolean pPU = true;
  
  public EmojiDetailGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getLongTouchTime()
  {
    return 200;
  }
  
  public String getProductId()
  {
    return this.pMk;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108927);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
    AppMethodBeat.o(108927);
  }
  
  public void setEmojiDetailScrollView(EmojiDetailScrollView paramEmojiDetailScrollView)
  {
    this.pPT = paramEmojiDetailScrollView;
  }
  
  public void setProductId(String paramString)
  {
    this.pMk = paramString;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(108928);
    if (this.pPT != null) {
      this.pPT.setScrollEnable(paramBoolean);
    }
    AppMethodBeat.o(108928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiDetailGridView
 * JD-Core Version:    0.7.0.1
 */