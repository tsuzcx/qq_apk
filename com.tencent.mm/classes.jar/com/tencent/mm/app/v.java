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
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
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
  public static v cJo;
  public boolean cJp;
  public ao cJq;
  
  public v()
  {
    AppMethodBeat.i(19458);
    this.cJq = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(19457);
        super.handleMessage(paramAnonymousMessage);
        Object localObject;
        if (paramAnonymousMessage.what == -1999)
        {
          if (!v.this.cJp)
          {
            paramAnonymousMessage = LauncherUI.getInstance();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.Hll))
            {
              paramAnonymousMessage.Hlj.getMainTabUI().aPD("tab_main");
              localObject = paramAnonymousMessage.getHomeUI();
              if (((HomeUI)localObject).HjQ) {
                ((HomeUI)localObject).HjS = true;
              }
              localObject = o.xMa;
              if (localObject != null) {
                ((com.tencent.mm.plugin.sns.b.g)localObject).dGo();
              }
              paramAnonymousMessage = paramAnonymousMessage.Hlj.getMainTabUI().HpB.values().iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject = (Fragment)paramAnonymousMessage.next();
                if (!(localObject instanceof MainUI)) {
                  ((m)localObject).feH();
                }
              }
            }
            System.gc();
            AppMethodBeat.o(19457);
          }
        }
        else if (paramAnonymousMessage.what == -2999)
        {
          if (v.this.cJp)
          {
            AppMethodBeat.o(19457);
            return;
          }
          paramAnonymousMessage = LauncherUI.getInstance();
          if (paramAnonymousMessage != null)
          {
            paramAnonymousMessage = paramAnonymousMessage.Hlj.getMainTabUI();
            if (paramAnonymousMessage.HpB.containsKey(Integer.valueOf(0))) {
              ((m)paramAnonymousMessage.HpB.get(Integer.valueOf(0))).feH();
            }
          }
          if (com.tencent.mm.kernel.g.agP().afY())
          {
            az.ayG();
            paramAnonymousMessage = bz.yz("plugin.emoji");
            if (paramAnonymousMessage != null) {
              paramAnonymousMessage.clearPluginData(0);
            }
            paramAnonymousMessage = b.aAv();
            localObject = com.tencent.mm.model.d.a.aAs();
            c localc = c.aAx();
            az.agU().az(new b.1(paramAnonymousMessage));
            h.JZN.aS(new a.1((com.tencent.mm.model.d.a)localObject));
            localc.a(paramAnonymousMessage);
            localc.a((c.a)localObject);
            az.agU().az(new c.1(localc));
          }
          System.gc();
        }
        AppMethodBeat.o(19457);
      }
    };
    AppMethodBeat.o(19458);
  }
  
  public static v KE()
  {
    AppMethodBeat.i(19459);
    if (cJo == null) {
      cJo = new v();
    }
    v localv = cJo;
    AppMethodBeat.o(19459);
    return localv;
  }
  
  public final void start()
  {
    AppMethodBeat.i(19460);
    this.cJp = false;
    this.cJq.removeMessages(-1999);
    this.cJq.removeMessages(-2999);
    this.cJq.sendEmptyMessageDelayed(-1999, 3000L);
    this.cJq.sendEmptyMessageDelayed(-2999, 30000L);
    AppMethodBeat.o(19460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.v
 * JD-Core Version:    0.7.0.1
 */