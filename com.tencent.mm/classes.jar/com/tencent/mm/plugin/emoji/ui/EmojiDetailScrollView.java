package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmojiDetailScrollView
  extends ScrollView
{
  private boolean xSp;
  
  public EmojiDetailScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmojiDetailScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(108929);
    this.xSp = true;
    setFadingEdgeLength(0);
    AppMethodBeat.o(108929);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(108932);
    if (!this.xSp)
    {
      AppMethodBeat.o(108932);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(108932);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(108931);
    this.xSp = false;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(108931);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void requestChildFocus(View paramView1, View paramView2) {}
  
  public void requestLayout()
  {
    AppMethodBeat.i(108930);
    this.xSp = false;
    super.requestLayout();
    AppMethodBeat.o(108930);
  }
  
  public void scrollBy(int paramInt1, int paramInt2) {}
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    this.xSp = true;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.xSp = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiDetailScrollView
 * JD-Core Version:    0.7.0.1
 */