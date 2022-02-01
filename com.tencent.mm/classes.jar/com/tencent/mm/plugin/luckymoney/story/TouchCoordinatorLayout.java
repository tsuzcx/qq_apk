package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TouchCoordinatorLayout
  extends CoordinatorLayout
{
  private List<View.OnTouchListener> KyQ;
  public boolean KyR;
  
  public TouchCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163684);
    this.KyQ = new ArrayList();
    this.KyR = false;
    AppMethodBeat.o(163684);
  }
  
  public TouchCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(163685);
    this.KyQ = new ArrayList();
    this.KyR = false;
    AppMethodBeat.o(163685);
  }
  
  public final void a(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(163686);
    this.KyQ.add(paramOnTouchListener);
    AppMethodBeat.o(163686);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(163687);
    Iterator localIterator = this.KyQ.iterator();
    while (localIterator.hasNext()) {
      ((View.OnTouchListener)localIterator.next()).onTouch(this, paramMotionEvent);
    }
    if (this.KyR)
    {
      AppMethodBeat.o(163687);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(163687);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.TouchCoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */