package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.SmileySubGrid;

public class EmojiDetailGridView
  extends SmileySubGrid
{
  private String liu;
  private EmojiDetailScrollView llW;
  private volatile boolean llX = true;
  
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
    return this.liu;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(53367);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
    AppMethodBeat.o(53367);
  }
  
  public void setEmojiDetailScrollView(EmojiDetailScrollView paramEmojiDetailScrollView)
  {
    this.llW = paramEmojiDetailScrollView;
  }
  
  public void setProductId(String paramString)
  {
    this.liu = paramString;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(53368);
    if (this.llW != null) {
      this.llW.setScrollEnable(paramBoolean);
    }
    AppMethodBeat.o(53368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiDetailGridView
 * JD-Core Version:    0.7.0.1
 */