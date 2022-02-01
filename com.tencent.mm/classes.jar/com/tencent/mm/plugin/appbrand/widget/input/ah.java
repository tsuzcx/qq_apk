package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface ah
{
  public abstract Activity getHostActivity();
  
  public abstract void hideVKB();
  
  public abstract void hideVKB(View paramView);
  
  public abstract boolean hideVKBHavingResult();
  
  public abstract void showVKB();
  
  public static final class a
  {
    public static ah fy(Context paramContext)
    {
      AppMethodBeat.i(324399);
      for (;;)
      {
        if (paramContext == null)
        {
          AppMethodBeat.o(324399);
          return null;
        }
        if ((paramContext instanceof ah))
        {
          paramContext = (ah)paramContext;
          AppMethodBeat.o(324399);
          return paramContext;
        }
        if (!(paramContext instanceof ContextWrapper)) {
          break;
        }
        Context localContext = ((ContextWrapper)paramContext).getBaseContext();
        if (localContext == paramContext) {
          break;
        }
        paramContext = localContext;
      }
      AppMethodBeat.o(324399);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ah
 * JD-Core Version:    0.7.0.1
 */