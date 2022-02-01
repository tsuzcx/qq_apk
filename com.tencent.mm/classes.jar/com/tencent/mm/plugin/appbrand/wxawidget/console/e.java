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
  private static final List<WeakReference<ControlBoardPanel>> uSU;
  private static final ControlBoardPanel.a uSV;
  
  static
  {
    AppMethodBeat.i(121642);
    uSU = new LinkedList();
    uSV = new ControlBoardPanel.a()
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
  
  public static void fB(Context paramContext)
  {
    AppMethodBeat.i(121640);
    int i;
    Object localObject;
    if (paramContext != null)
    {
      i = 0;
      if (i < uSU.size())
      {
        localObject = (WeakReference)uSU.get(i);
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
            uSU.add(new WeakReference(paramContext));
          }
        }
      }
    }
    for (;;)
    {
      localObject = uSV;
      if (!paramContext.uTe)
      {
        paramContext.uTe = true;
        Activity localActivity = (Activity)paramContext.getContext();
        paramContext.uTd = new WindowManager.LayoutParams(-2, -2, 1003, 520, -3);
        paramContext.uTd.y = a.v(localActivity);
        paramContext.uTd.token = localActivity.getWindow().getDecorView().getWindowToken();
        paramContext.uTd.gravity = 51;
        paramContext.uTd.softInputMode = 16;
        paramContext.uTc.addView(paramContext, paramContext.uTd);
        paramContext.reset();
        paramContext.uSV = ((ControlBoardPanel.a)localObject);
        if (paramContext.uSV != null) {
          paramContext.uSV.a(paramContext, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.e
 * JD-Core Version:    0.7.0.1
 */