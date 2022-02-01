package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.RecyclerHorizontalViewPager;

public class LuckyMoneyStoryViewPager
  extends RecyclerHorizontalViewPager
{
  public LuckyMoneyStoryViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(163683);
    if (paramMotionEvent.getActionMasked() == 3)
    {
      bool = super.dispatchTouchEvent(MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), 1, paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState()));
      AppMethodBeat.o(163683);
      return bool;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(163683);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.LuckyMoneyStoryViewPager
 * JD-Core Version:    0.7.0.1
 */