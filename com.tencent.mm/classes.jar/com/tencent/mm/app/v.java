package com.tencent.mm.app;

import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.d.a.1;
import com.tencent.mm.model.d.b;
import com.tencent.mm.model.d.b.1;
import com.tencent.mm.model.d.c;
import com.tencent.mm.model.d.c.1;
import com.tencent.mm.model.d.c.a;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class v
{
  public static v cMg;
  public boolean cMh;
  public ap cMi;
  
  public v()
  {
    AppMethodBeat.i(19458);
    this.cMi = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(19457);
        super.handleMessage(paramAnonymousMessage);
        Object localObject;
        if (paramAnonymousMessage.what == -1999)
        {
          if (!v.this.cMh)
          {
            paramAnonymousMessage = LauncherUI.getInstance();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.FMd))
            {
              paramAnonymousMessage.FMb.getMainTabUI().aKb("tab_main");
              localObject = paramAnonymousMessage.getHomeUI();
              if (((HomeUI)localObject).FKI) {
                ((HomeUI)localObject).FKK = true;
              }
              localObject = o.wzG;
              if (localObject != null) {
                ((com.tencent.mm.plugin.sns.c.g)localObject).drP();
              }
              paramAnonymousMessage = paramAnonymousMessage.FMb.getMainTabUI().FPQ.values().iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject = (Fragment)paramAnonymousMessage.next();
                if (!(localObject instanceof MainUI)) {
                  ((m)localObject).ePd();
                }
              }
            }
            System.gc();
            AppMethodBeat.o(19457);
          }
        }
        else if (paramAnonymousMessage.what == -2999)
        {
          if (v.this.cMh)
          {
            AppMethodBeat.o(19457);
            return;
          }
          paramAnonymousMessage = LauncherUI.getInstance();
          if (paramAnonymousMessage != null)
          {
            paramAnonymousMessage = paramAnonymousMessage.FMb.getMainTabUI();
            if (paramAnonymousMessage.FPQ.containsKey(Integer.valueOf(0))) {
              ((m)paramAnonymousMessage.FPQ.get(Integer.valueOf(0))).ePd();
            }
          }
          if (com.tencent.mm.kernel.g.afz().aeI())
          {
            az.arP();
            paramAnonymousMessage = bz.ut("plugin.emoji");
            if (paramAnonymousMessage != null) {
              paramAnonymousMessage.clearPluginData(0);
            }
            paramAnonymousMessage = b.atE();
            localObject = com.tencent.mm.model.d.a.atB();
            c localc = c.atG();
            az.afE().ax(new b.1(paramAnonymousMessage));
            h.Iye.aP(new a.1((com.tencent.mm.model.d.a)localObject));
            localc.a(paramAnonymousMessage);
            localc.a((c.a)localObject);
            az.afE().ax(new c.1(localc));
          }
          System.gc();
        }
        AppMethodBeat.o(19457);
      }
    };
    AppMethodBeat.o(19458);
  }
  
  public static v KT()
  {
    AppMethodBeat.i(19459);
    if (cMg == null) {
      cMg = new v();
    }
    v localv = cMg;
    AppMethodBeat.o(19459);
    return localv;
  }
  
  public final void start()
  {
    AppMethodBeat.i(19460);
    this.cMh = false;
    this.cMi.removeMessages(-1999);
    this.cMi.removeMessages(-2999);
    this.cMi.sendEmptyMessageDelayed(-1999, 3000L);
    this.cMi.sendEmptyMessageDelayed(-2999, 30000L);
    AppMethodBeat.o(19460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.v
 * JD-Core Version:    0.7.0.1
 */