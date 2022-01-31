package com.tencent.mm.chatroom.ui;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
  extends TouchDelegate
{
  private static final Rect dtx = new Rect();
  ArrayList<TouchDelegate> dty;
  TouchDelegate dtz;
  
  public d(View paramView)
  {
    super(dtx, paramView);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject;
    switch (paramMotionEvent.getAction())
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        break label123;
      }
      return false;
      if (this.dty == null) {
        break;
      }
      localObject = this.dty.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TouchDelegate localTouchDelegate = (TouchDelegate)((Iterator)localObject).next();
        if ((localTouchDelegate != null) && (localTouchDelegate.onTouchEvent(paramMotionEvent)))
        {
          this.dtz = localTouchDelegate;
          return true;
        }
      }
      localObject = null;
      continue;
      localObject = this.dtz;
      continue;
      localObject = this.dtz;
      this.dtz = null;
    }
    label123:
    return ((TouchDelegate)localObject).onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.d
 * JD-Core Version:    0.7.0.1
 */