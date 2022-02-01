package com.tencent.kinda.framework.widget.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LayoutWrapper
  extends LinearLayout
{
  public LayoutWrapper(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(214511);
    setGravity(16);
    paramContext = new LinearLayout.LayoutParams(0, -2);
    paramContext.weight = 1.0F;
    addView(paramView, paramContext);
    setClickable(true);
    setLongClickable(true);
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      @SuppressLint({"ClickableViewAccessibility"})
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(214510);
        jdField_this.onTouchEvent(paramAnonymousMotionEvent);
        AppMethodBeat.o(214510);
        return false;
      }
    });
    AppMethodBeat.o(214511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.LayoutWrapper
 * JD-Core Version:    0.7.0.1
 */