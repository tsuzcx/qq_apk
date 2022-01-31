package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class EmojiDetailScrollView
  extends ScrollView
{
  private boolean jdo = true;
  
  public EmojiDetailScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmojiDetailScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFadingEdgeLength(0);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdo) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdo = false;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void requestChildFocus(View paramView1, View paramView2) {}
  
  public void requestLayout()
  {
    this.jdo = false;
    super.requestLayout();
  }
  
  public void scrollBy(int paramInt1, int paramInt2) {}
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    this.jdo = true;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.jdo = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiDetailScrollView
 * JD-Core Version:    0.7.0.1
 */