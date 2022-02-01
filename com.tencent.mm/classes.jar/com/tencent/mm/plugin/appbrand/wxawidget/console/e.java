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
  private static final List<WeakReference<ControlBoardPanel>> oFQ;
  private static final ControlBoardPanel.a oFR;
  
  static
  {
    AppMethodBeat.i(121642);
    oFQ = new LinkedList();
    oFR = new ControlBoardPanel.a()
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
  
  public static void eD(Context paramContext)
  {
    AppMethodBeat.i(121640);
    int i;
    Object localObject;
    if (paramContext != null)
    {
      i = 0;
      if (i < oFQ.size())
      {
        localObject = (WeakReference)oFQ.get(i);
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
            oFQ.add(new WeakReference(paramContext));
          }
        }
      }
    }
    for (;;)
    {
      localObject = oFR;
      if (!paramContext.oGa)
      {
        paramContext.oGa = true;
        Activity localActivity = (Activity)paramContext.getContext();
        paramContext.oFZ = new WindowManager.LayoutParams(-2, -2, 1003, 520, -3);
        paramContext.oFZ.y = a.u(localActivity);
        paramContext.oFZ.token = localActivity.getWindow().getDecorView().getWindowToken();
        paramContext.oFZ.gravity = 51;
        paramContext.oFZ.softInputMode = 16;
        paramContext.oFY.addView(paramContext, paramContext.oFZ);
        paramContext.reset();
        paramContext.oFR = ((ControlBoardPanel.a)localObject);
        if (paramContext.oFR != null) {
          paramContext.oFR.a(paramContext, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.e
 * JD-Core Version:    0.7.0.1
 */