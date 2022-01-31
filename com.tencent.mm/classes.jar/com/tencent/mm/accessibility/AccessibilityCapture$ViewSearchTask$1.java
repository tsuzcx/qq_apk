package com.tencent.mm.accessibility;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

class AccessibilityCapture$ViewSearchTask$1
  implements ViewSearchTool.Matcher
{
  AccessibilityCapture$ViewSearchTask$1(AccessibilityCapture.ViewSearchTask paramViewSearchTask, int paramInt) {}
  
  public boolean match(View paramView)
  {
    AppMethodBeat.i(118626);
    try
    {
      if (((Integer)AccessibilityCapture.access$900().get(paramView)).intValue() == this.val$id)
      {
        AppMethodBeat.o(118626);
        return true;
      }
      AppMethodBeat.o(118626);
      return false;
    }
    catch (IllegalAccessException paramView)
    {
      AppMethodBeat.o(118626);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.accessibility.AccessibilityCapture.ViewSearchTask.1
 * JD-Core Version:    0.7.0.1
 */