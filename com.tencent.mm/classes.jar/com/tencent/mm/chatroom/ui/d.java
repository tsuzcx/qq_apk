package com.tencent.mm.chatroom.ui;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
  extends TouchDelegate
{
  private static final Rect elb;
  ArrayList<TouchDelegate> elc;
  TouchDelegate eld;
  
  static
  {
    AppMethodBeat.i(104461);
    elb = new Rect();
    AppMethodBeat.o(104461);
  }
  
  public d(View paramView)
  {
    super(elb, paramView);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(104460);
    Object localObject;
    switch (paramMotionEvent.getAction())
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        break label141;
      }
      AppMethodBeat.o(104460);
      return false;
      if (this.elc == null) {
        break;
      }
      localObject = this.elc.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TouchDelegate localTouchDelegate = (TouchDelegate)((Iterator)localObject).next();
        if ((localTouchDelegate != null) && (localTouchDelegate.onTouchEvent(paramMotionEvent)))
        {
          this.eld = localTouchDelegate;
          AppMethodBeat.o(104460);
          return true;
        }
      }
      localObject = null;
      continue;
      localObject = this.eld;
      continue;
      localObject = this.eld;
      this.eld = null;
    }
    label141:
    boolean bool = ((TouchDelegate)localObject).onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(104460);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.d
 * JD-Core Version:    0.7.0.1
 */