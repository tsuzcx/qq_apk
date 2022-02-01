package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public static String G(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(131468);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MotionEvent { action=").append(actionToString(paramMotionEvent.getAction()));
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(", x[").append(i).append("]=").append(paramMotionEvent.getX(i));
      localStringBuilder.append(", y[").append(i).append("]=").append(paramMotionEvent.getY(i));
      i += 1;
    }
    localStringBuilder.append(", downTime=").append(paramMotionEvent.getDownTime());
    localStringBuilder.append(" }");
    paramMotionEvent = localStringBuilder.toString();
    AppMethodBeat.o(131468);
    return paramMotionEvent;
  }
  
  public static void a(String paramString1, String paramString2, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(131467);
    if (ae.getLogLevel() > 0)
    {
      AppMethodBeat.o(131467);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2).append(' ');
    localStringBuilder.append("[apptouch] MotionEvent { action=").append(actionToString(paramMotionEvent.getAction()));
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(", x[").append(i).append("]=").append(paramMotionEvent.getX(i));
      localStringBuilder.append(", y[").append(i).append("]=").append(paramMotionEvent.getY(i));
      i += 1;
    }
    localStringBuilder.append(", downTime=").append(paramMotionEvent.getDownTime());
    localStringBuilder.append(" }");
    ae.v(paramString1, localStringBuilder.toString());
    AppMethodBeat.o(131467);
  }
  
  private static String actionToString(int paramInt)
  {
    AppMethodBeat.i(131469);
    int i;
    switch (paramInt)
    {
    case 5: 
    case 6: 
    default: 
      i = (0xFF00 & paramInt) >> 8;
      switch (paramInt & 0xFF)
      {
      default: 
        str = Integer.toString(paramInt);
        AppMethodBeat.o(131469);
        return str;
      }
    case 0: 
      AppMethodBeat.o(131469);
      return "ACTION_DOWN";
    case 1: 
      AppMethodBeat.o(131469);
      return "ACTION_UP";
    case 3: 
      AppMethodBeat.o(131469);
      return "ACTION_CANCEL";
    case 4: 
      AppMethodBeat.o(131469);
      return "ACTION_OUTSIDE";
    case 2: 
      AppMethodBeat.o(131469);
      return "ACTION_MOVE";
    case 7: 
      AppMethodBeat.o(131469);
      return "ACTION_HOVER_MOVE";
    case 8: 
      AppMethodBeat.o(131469);
      return "ACTION_SCROLL";
    case 9: 
      AppMethodBeat.o(131469);
      return "ACTION_HOVER_ENTER";
    case 10: 
      AppMethodBeat.o(131469);
      return "ACTION_HOVER_EXIT";
    case 11: 
      AppMethodBeat.o(131469);
      return "ACTION_BUTTON_PRESS";
    }
    AppMethodBeat.o(131469);
    return "ACTION_BUTTON_RELEASE";
    String str = "ACTION_POINTER_DOWN(" + i + ")";
    AppMethodBeat.o(131469);
    return str;
    str = "ACTION_POINTER_UP(" + i + ")";
    AppMethodBeat.o(131469);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.a
 * JD-Core Version:    0.7.0.1
 */