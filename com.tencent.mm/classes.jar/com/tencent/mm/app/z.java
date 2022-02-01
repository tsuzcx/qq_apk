package com.tencent.mm.app;

import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c.a;
import com.tencent.mm.model.c.a.1;
import com.tencent.mm.model.c.b.1;
import com.tencent.mm.model.c.c;
import com.tencent.mm.model.c.c.1;
import com.tencent.mm.model.c.c.a;
import com.tencent.mm.model.ci;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.p;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class z
{
  public static z hhq;
  public boolean hhr;
  public MMHandler hhs;
  
  public z()
  {
    AppMethodBeat.i(19458);
    this.hhs = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(19457);
        super.handleMessage(paramAnonymousMessage);
        Object localObject;
        if (paramAnonymousMessage.what == -1999)
        {
          if (!z.this.hhr)
          {
            paramAnonymousMessage = LauncherUI.getInstance();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.adBI))
            {
              paramAnonymousMessage.adBG.getMainTabUI().bzP("tab_main");
              localObject = paramAnonymousMessage.getHomeUI();
              if (((HomeUI)localObject).adAk) {
                ((HomeUI)localObject).adAm = true;
              }
              localObject = q.Qkh;
              if (localObject != null) {
                ((com.tencent.mm.plugin.sns.c.i)localObject).heg();
              }
              paramAnonymousMessage = paramAnonymousMessage.adBG.getMainTabUI().adHf.values().iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject = (Fragment)paramAnonymousMessage.next();
                if (!(localObject instanceof MainUI)) {
                  ((p)localObject).jhw();
                }
              }
            }
            System.gc();
            AppMethodBeat.o(19457);
          }
        }
        else if (paramAnonymousMessage.what == -2999)
        {
          if (z.this.hhr)
          {
            AppMethodBeat.o(19457);
            return;
          }
          paramAnonymousMessage = LauncherUI.getInstance();
          if (paramAnonymousMessage != null)
          {
            paramAnonymousMessage = paramAnonymousMessage.adBG.getMainTabUI();
            if (paramAnonymousMessage.adHf.containsKey(Integer.valueOf(0))) {
              ((p)paramAnonymousMessage.adHf.get(Integer.valueOf(0))).jhw();
            }
          }
          if (com.tencent.mm.kernel.h.baC().aZN())
          {
            bh.bCt();
            paramAnonymousMessage = ci.Ka("plugin.emoji");
            if (paramAnonymousMessage != null) {
              paramAnonymousMessage.clearPluginData(0);
            }
            paramAnonymousMessage = com.tencent.mm.model.c.b.bEz();
            localObject = a.bEw();
            c localc = c.bEC();
            bh.baH().postToWorker(new b.1(paramAnonymousMessage));
            com.tencent.threadpool.h.ahAA.bm(new a.1((a)localObject));
            localc.a(paramAnonymousMessage);
            localc.a((c.a)localObject);
            bh.baH().postToWorker(new c.1(localc));
          }
          System.gc();
        }
        AppMethodBeat.o(19457);
      }
    };
    AppMethodBeat.o(19458);
  }
  
  public static z aCK()
  {
    AppMethodBeat.i(19459);
    if (hhq == null) {
      hhq = new z();
    }
    z localz = hhq;
    AppMethodBeat.o(19459);
    return localz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.z
 * JD-Core Version:    0.7.0.1
 */