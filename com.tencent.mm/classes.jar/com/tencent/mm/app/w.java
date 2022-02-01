package com.tencent.mm.app;

import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.Fragment;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.d.a.1;
import com.tencent.mm.model.d.b.1;
import com.tencent.mm.model.d.c;
import com.tencent.mm.model.d.c.1;
import com.tencent.mm.model.d.c.a;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class w
{
  public static w fdA;
  public boolean fdB;
  public MMHandler fdC;
  
  public w()
  {
    AppMethodBeat.i(19458);
    this.fdC = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(19457);
        super.handleMessage(paramAnonymousMessage);
        Object localObject;
        if (paramAnonymousMessage.what == -1999)
        {
          if (!w.this.fdB)
          {
            paramAnonymousMessage = LauncherUI.getInstance();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.VXm))
            {
              paramAnonymousMessage.VXk.getMainTabUI().byt("tab_main");
              localObject = paramAnonymousMessage.getHomeUI();
              if (((HomeUI)localObject).VVM) {
                ((HomeUI)localObject).VVO = true;
              }
              localObject = p.JPc;
              if (localObject != null) {
                ((com.tencent.mm.plugin.sns.b.h)localObject).fNa();
              }
              paramAnonymousMessage = paramAnonymousMessage.VXk.getMainTabUI().WbG.values().iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject = (Fragment)paramAnonymousMessage.next();
                if (!(localObject instanceof MainUI)) {
                  ((o)localObject).hFk();
                }
              }
            }
            System.gc();
            AppMethodBeat.o(19457);
          }
        }
        else if (paramAnonymousMessage.what == -2999)
        {
          if (w.this.fdB)
          {
            AppMethodBeat.o(19457);
            return;
          }
          paramAnonymousMessage = LauncherUI.getInstance();
          if (paramAnonymousMessage != null)
          {
            paramAnonymousMessage = paramAnonymousMessage.VXk.getMainTabUI();
            if (paramAnonymousMessage.WbG.containsKey(Integer.valueOf(0))) {
              ((o)paramAnonymousMessage.WbG.get(Integer.valueOf(0))).hFk();
            }
          }
          if (com.tencent.mm.kernel.h.aHE().aGM())
          {
            bh.beC();
            paramAnonymousMessage = ch.RZ("plugin.emoji");
            if (paramAnonymousMessage != null) {
              paramAnonymousMessage.clearPluginData(0);
            }
            paramAnonymousMessage = com.tencent.mm.model.d.b.bgH();
            localObject = a.bgE();
            c localc = c.bgK();
            bh.aHJ().postToWorker(new b.1(paramAnonymousMessage));
            com.tencent.e.h.ZvG.be(new a.1((a)localObject));
            localc.a(paramAnonymousMessage);
            localc.a((c.a)localObject);
            bh.aHJ().postToWorker(new c.1(localc));
          }
          System.gc();
        }
        AppMethodBeat.o(19457);
      }
    };
    AppMethodBeat.o(19458);
  }
  
  public static w aaZ()
  {
    AppMethodBeat.i(19459);
    if (fdA == null) {
      fdA = new w();
    }
    w localw = fdA;
    AppMethodBeat.o(19459);
    return localw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.w
 * JD-Core Version:    0.7.0.1
 */