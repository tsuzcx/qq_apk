package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LuckyMoneyEnvelopeTouchRecyclerView
  extends RecyclerView
{
  public LuckyMoneyEnvelopeTouchRecyclerView.a otE;
  
  public LuckyMoneyEnvelopeTouchRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LuckyMoneyEnvelopeTouchRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(42720);
    if (this.otE != null) {
      this.otE.onInterceptTouchEvent(paramMotionEvent);
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(42720);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyEnvelopeTouchRecyclerView
 * JD-Core Version:    0.7.0.1
 */