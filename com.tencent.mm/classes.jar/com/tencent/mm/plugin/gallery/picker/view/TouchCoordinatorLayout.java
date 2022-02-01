package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TouchCoordinatorLayout
  extends CoordinatorLayout
{
  private View.OnTouchListener yQj;
  
  public TouchCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TouchCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164789);
    if (this.yQj != null) {
      this.yQj.onTouch(this, paramMotionEvent);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164789);
    return bool;
  }
  
  public void setTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.yQj = paramOnTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.TouchCoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */