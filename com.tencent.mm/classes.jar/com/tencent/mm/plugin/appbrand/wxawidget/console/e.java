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
  private static final List<WeakReference<ControlBoardPanel>> mPW;
  private static final ControlBoardPanel.a mPX;
  
  static
  {
    AppMethodBeat.i(121642);
    mPW = new LinkedList();
    mPX = new ControlBoardPanel.a()
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
  
  public static void eg(Context paramContext)
  {
    AppMethodBeat.i(121640);
    int i;
    Object localObject;
    if (paramContext != null)
    {
      i = 0;
      if (i < mPW.size())
      {
        localObject = (WeakReference)mPW.get(i);
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
            mPW.add(new WeakReference(paramContext));
          }
        }
      }
    }
    for (;;)
    {
      localObject = mPX;
      if (!paramContext.mQg)
      {
        paramContext.mQg = true;
        Activity localActivity = (Activity)paramContext.getContext();
        paramContext.mQf = new WindowManager.LayoutParams(-2, -2, 1003, 520, -3);
        paramContext.mQf.y = a.u(localActivity);
        paramContext.mQf.token = localActivity.getWindow().getDecorView().getWindowToken();
        paramContext.mQf.gravity = 51;
        paramContext.mQf.softInputMode = 16;
        paramContext.mQe.addView(paramContext, paramContext.mQf);
        paramContext.reset();
        paramContext.mPX = ((ControlBoardPanel.a)localObject);
        if (paramContext.mPX != null) {
          paramContext.mPX.a(paramContext, true);
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