package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import com.tencent.mm.plugin.map.a.e;

final class h$1
  implements ViewStub.OnInflateListener
{
  h$1(h paramh) {}
  
  public final void onInflate(ViewStub paramViewStub, View paramView)
  {
    paramView.findViewById(a.e.location_info_frame).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h.1
 * JD-Core Version:    0.7.0.1
 */