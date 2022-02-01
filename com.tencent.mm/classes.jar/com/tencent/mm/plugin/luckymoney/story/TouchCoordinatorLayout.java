package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TouchCoordinatorLayout
  extends CoordinatorLayout
{
  private List<View.OnTouchListener> vuk;
  public boolean vul;
  
  public TouchCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163684);
    this.vuk = new ArrayList();
    this.vul = false;
    AppMethodBeat.o(163684);
  }
  
  public TouchCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(163685);
    this.vuk = new ArrayList();
    this.vul = false;
    AppMethodBeat.o(163685);
  }
  
  public final void a(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(163686);
    this.vuk.add(paramOnTouchListener);
    AppMethodBeat.o(163686);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(163687);
    Iterator localIterator = this.vuk.iterator();
    while (localIterator.hasNext()) {
      ((View.OnTouchListener)localIterator.next()).onTouch(this, paramMotionEvent);
    }
    if (this.vul)
    {
      AppMethodBeat.o(163687);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(163687);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.TouchCoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */