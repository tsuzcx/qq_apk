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
  private static final Rect fBs;
  ArrayList<TouchDelegate> fBt;
  TouchDelegate fBu;
  
  static
  {
    AppMethodBeat.i(13003);
    fBs = new Rect();
    AppMethodBeat.o(13003);
  }
  
  public d(View paramView)
  {
    super(fBs, paramView);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(13002);
    Object localObject;
    switch (paramMotionEvent.getAction())
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        break label143;
      }
      AppMethodBeat.o(13002);
      return false;
      if (this.fBt == null) {
        break;
      }
      localObject = this.fBt.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TouchDelegate localTouchDelegate = (TouchDelegate)((Iterator)localObject).next();
        if ((localTouchDelegate != null) && (localTouchDelegate.onTouchEvent(paramMotionEvent)))
        {
          this.fBu = localTouchDelegate;
          AppMethodBeat.o(13002);
          return true;
        }
      }
      localObject = null;
      continue;
      localObject = this.fBu;
      continue;
      localObject = this.fBu;
      this.fBu = null;
    }
    label143:
    boolean bool = ((TouchDelegate)localObject).onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(13002);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.d
 * JD-Core Version:    0.7.0.1
 */