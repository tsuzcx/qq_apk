package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.mm.view.SmileySubGrid;

public class EmojiDetailGridView
  extends SmileySubGrid
{
  private String iZD;
  private EmojiDetailScrollView jdm;
  private volatile boolean jdn = true;
  
  public EmojiDetailGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected int getLongTouchTime()
  {
    return 200;
  }
  
  public String getProductId()
  {
    return this.iZD;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
  
  public void setEmojiDetailScrollView(EmojiDetailScrollView paramEmojiDetailScrollView)
  {
    this.jdm = paramEmojiDetailScrollView;
  }
  
  public void setProductId(String paramString)
  {
    this.iZD = paramString;
  }
  
  protected void setScrollEnable(boolean paramBoolean)
  {
    if (this.jdm != null) {
      this.jdm.setScrollEnable(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiDetailGridView
 * JD-Core Version:    0.7.0.1
 */