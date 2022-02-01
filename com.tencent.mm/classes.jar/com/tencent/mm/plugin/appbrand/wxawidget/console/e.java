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
  private static final List<WeakReference<ControlBoardPanel>> rHF;
  private static final ControlBoardPanel.a rHG;
  
  static
  {
    AppMethodBeat.i(121642);
    rHF = new LinkedList();
    rHG = new ControlBoardPanel.a()
    {
      public final void a(ControlBoardPanel paramAnonymousControlBoardPanel, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(121639);
        if (!paramAnonymousBoolean) {
          e.a(paramAnonymousControlBoardPanel);
        }
        AppMethodBeat.o(121639);
      }
    };
    AppMethodBeat.o(121642);
  }
  
  public static void eG(Context paramContext)
  {
    AppMethodBeat.i(121640);
    int i;
    Object localObject;
    if (paramContext != null)
    {
      i = 0;
      if (i < rHF.size())
      {
        localObject = (WeakReference)rHF.get(i);
        if (localObject != null)
        {
          localObject = (ControlBoardPanel)((WeakReference)localObject).get();
          if ((localObject != null) && (paramContext == ((ControlBoardPanel)localObject).getContext()))
          {
            label60:
            if (localObject != null) {
              break label242;
            }
            paramContext = new ControlBoardPanel(paramContext);
            rHF.add(new WeakReference(paramContext));
          }
        }
      }
    }
    for (;;)
    {
      localObject = rHG;
      if (!paramContext.rHP)
      {
        paramContext.rHP = true;
        Activity localActivity = (Activity)paramContext.getContext();
        paramContext.rHO = new WindowManager.LayoutParams(-2, -2, 1003, 520, -3);
        paramContext.rHO.y = a.t(localActivity);
        paramContext.rHO.token = localActivity.getWindow().getDecorView().getWindowToken();
        paramContext.rHO.gravity = 51;
        paramContext.rHO.softInputMode = 16;
        paramContext.rHN.addView(paramContext, paramContext.rHO);
        paramContext.reset();
        paramContext.rHG = ((ControlBoardPanel.a)localObject);
        if (paramContext.rHG != null) {
          paramContext.rHG.a(paramContext, true);
        }
      }
      AppMethodBeat.o(121640);
      return;
      i += 1;
      break;
      localObject = null;
      break label60;
      label242:
      paramContext = (Context)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.e
 * JD-Core Version:    0.7.0.1
 */