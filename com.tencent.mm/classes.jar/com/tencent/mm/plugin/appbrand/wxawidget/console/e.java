package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  private static final List<WeakReference<ControlBoardPanel>> jxF;
  private static final ControlBoardPanel.a jxG;
  
  static
  {
    AppMethodBeat.i(11157);
    jxF = new LinkedList();
    jxG = new e.1();
    AppMethodBeat.o(11157);
  }
  
  public static void dw(Context paramContext)
  {
    AppMethodBeat.i(11155);
    int i;
    Object localObject;
    if (paramContext != null)
    {
      i = 0;
      if (i < jxF.size())
      {
        localObject = (WeakReference)jxF.get(i);
        if (localObject != null)
        {
          localObject = (ControlBoardPanel)((WeakReference)localObject).get();
          if ((localObject != null) && (paramContext == ((ControlBoardPanel)localObject).getContext()))
          {
            label61:
            if (localObject != null) {
              break label244;
            }
            paramContext = new ControlBoardPanel(paramContext);
            jxF.add(new WeakReference(paramContext));
          }
        }
      }
    }
    for (;;)
    {
      localObject = jxG;
      if (!paramContext.jxP)
      {
        paramContext.jxP = true;
        Activity localActivity = (Activity)paramContext.getContext();
        paramContext.jxO = new WindowManager.LayoutParams(-2, -2, 1003, 520, -3);
        paramContext.jxO.y = a.p(localActivity);
        paramContext.jxO.token = localActivity.getWindow().getDecorView().getWindowToken();
        paramContext.jxO.gravity = 51;
        paramContext.jxO.softInputMode = 16;
        paramContext.jxN.addView(paramContext, paramContext.jxO);
        paramContext.reset();
        paramContext.jxG = ((ControlBoardPanel.a)localObject);
        if (paramContext.jxG != null) {
          paramContext.jxG.a(paramContext, true);
        }
      }
      AppMethodBeat.o(11155);
      return;
      i += 1;
      break;
      localObject = null;
      break label61;
      label244:
      paramContext = (Context)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.e
 * JD-Core Version:    0.7.0.1
 */