package com.tencent.mm.app;

import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.d.a.1;
import com.tencent.mm.model.d.b;
import com.tencent.mm.model.d.b.1;
import com.tencent.mm.model.d.c;
import com.tencent.mm.model.d.c.1;
import com.tencent.mm.model.d.c.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.n;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class w
{
  public static w dlV;
  public boolean dlW;
  public MMHandler dlX;
  
  public w()
  {
    AppMethodBeat.i(19458);
    this.dlX = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(19457);
        super.handleMessage(paramAnonymousMessage);
        Object localObject;
        if (paramAnonymousMessage.what == -1999)
        {
          if (!w.this.dlW)
          {
            paramAnonymousMessage = LauncherUI.getInstance();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.ODT))
            {
              paramAnonymousMessage.ODR.getMainTabUI().blU("tab_main");
              localObject = paramAnonymousMessage.getHomeUI();
              if (((HomeUI)localObject).OCv) {
                ((HomeUI)localObject).OCx = true;
              }
              localObject = o.DCM;
              if (localObject != null) {
                ((com.tencent.mm.plugin.sns.b.g)localObject).eZk();
              }
              paramAnonymousMessage = paramAnonymousMessage.ODR.getMainTabUI().OIl.values().iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject = (Fragment)paramAnonymousMessage.next();
                if (!(localObject instanceof MainUI)) {
                  ((n)localObject).gGD();
                }
              }
            }
            System.gc();
            AppMethodBeat.o(19457);
          }
        }
        else if (paramAnonymousMessage.what == -2999)
        {
          if (w.this.dlW)
          {
            AppMethodBeat.o(19457);
            return;
          }
          paramAnonymousMessage = LauncherUI.getInstance();
          if (paramAnonymousMessage != null)
          {
            paramAnonymousMessage = paramAnonymousMessage.ODR.getMainTabUI();
            if (paramAnonymousMessage.OIl.containsKey(Integer.valueOf(0))) {
              ((n)paramAnonymousMessage.OIl.get(Integer.valueOf(0))).gGD();
            }
          }
          if (com.tencent.mm.kernel.g.aAf().azp())
          {
            bg.aVz();
            paramAnonymousMessage = cg.KG("plugin.emoji");
            if (paramAnonymousMessage != null) {
              paramAnonymousMessage.clearPluginData(0);
            }
            paramAnonymousMessage = b.aXA();
            localObject = com.tencent.mm.model.d.a.aXx();
            c localc = c.aXD();
            bg.aAk().postToWorker(new b.1(paramAnonymousMessage));
            h.RTc.aX(new a.1((com.tencent.mm.model.d.a)localObject));
            localc.a(paramAnonymousMessage);
            localc.a((c.a)localObject);
            bg.aAk().postToWorker(new c.1(localc));
          }
          System.gc();
        }
        AppMethodBeat.o(19457);
      }
    };
    AppMethodBeat.o(19458);
  }
  
  public static w WE()
  {
    AppMethodBeat.i(19459);
    if (dlV == null) {
      dlV = new w();
    }
    w localw = dlV;
    AppMethodBeat.o(19459);
    return localw;
  }
  
  public final void start()
  {
    AppMethodBeat.i(19460);
    this.dlW = false;
    this.dlX.removeMessages(-1999);
    this.dlX.removeMessages(-2999);
    this.dlX.sendEmptyMessageDelayed(-1999, 3000L);
    this.dlX.sendEmptyMessageDelayed(-2999, 30000L);
    AppMethodBeat.o(19460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.w
 * JD-Core Version:    0.7.0.1
 */