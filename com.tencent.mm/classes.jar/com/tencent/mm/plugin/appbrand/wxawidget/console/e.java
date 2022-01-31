package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.compatible.util.a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  private static final List<WeakReference<ControlBoardPanel>> hEs = new LinkedList();
  private static final ControlBoardPanel.a hEt = new e.1();
  
  public static void cL(Context paramContext)
  {
    int i;
    Object localObject;
    if (paramContext != null)
    {
      i = 0;
      if (i < hEs.size())
      {
        localObject = (WeakReference)hEs.get(i);
        if (localObject != null)
        {
          localObject = (ControlBoardPanel)((WeakReference)localObject).get();
          if ((localObject != null) && (paramContext == ((ControlBoardPanel)localObject).getContext()))
          {
            label55:
            if (localObject != null) {
              break label232;
            }
            paramContext = new ControlBoardPanel(paramContext);
            hEs.add(new WeakReference(paramContext));
          }
        }
      }
    }
    for (;;)
    {
      localObject = hEt;
      if (!paramContext.hEC)
      {
        paramContext.hEC = true;
        Activity localActivity = (Activity)paramContext.getContext();
        paramContext.hEB = new WindowManager.LayoutParams(-2, -2, 1003, 520, -3);
        paramContext.hEB.y = a.o(localActivity);
        paramContext.hEB.token = localActivity.getWindow().getDecorView().getWindowToken();
        paramContext.hEB.gravity = 51;
        paramContext.hEB.softInputMode = 16;
        paramContext.hEA.addView(paramContext, paramContext.hEB);
        paramContext.reset();
        paramContext.hEt = ((ControlBoardPanel.a)localObject);
        if (paramContext.hEt != null) {
          paramContext.hEt.a(paramContext, true);
        }
      }
      return;
      i += 1;
      break;
      localObject = null;
      break label55;
      label232:
      paramContext = (Context)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.e
 * JD-Core Version:    0.7.0.1
 */