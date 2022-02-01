package com.tencent.mm.app;

import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.d.a.1;
import com.tencent.mm.model.d.b;
import com.tencent.mm.model.d.b.1;
import com.tencent.mm.model.d.c;
import com.tencent.mm.model.d.c.1;
import com.tencent.mm.model.d.c.a;
import com.tencent.mm.plugin.sns.b.o;
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
  public static v cUB;
  public boolean cUC;
  public ap cUD;
  
  public v()
  {
    AppMethodBeat.i(19458);
    this.cUD = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(19457);
        super.handleMessage(paramAnonymousMessage);
        Object localObject;
        if (paramAnonymousMessage.what == -1999)
        {
          if (!v.this.cUC)
          {
            paramAnonymousMessage = LauncherUI.getInstance();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.IYS))
            {
              paramAnonymousMessage.IYQ.getMainTabUI().aVt("tab_main");
              localObject = paramAnonymousMessage.getHomeUI();
              if (((HomeUI)localObject).IXx) {
                ((HomeUI)localObject).IXz = true;
              }
              localObject = o.zbS;
              if (localObject != null) {
                ((com.tencent.mm.plugin.sns.b.g)localObject).dSB();
              }
              paramAnonymousMessage = paramAnonymousMessage.IYQ.getMainTabUI().Jdh.values().iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject = (Fragment)paramAnonymousMessage.next();
                if (!(localObject instanceof MainUI)) {
                  ((m)localObject).fuO();
                }
              }
            }
            System.gc();
            AppMethodBeat.o(19457);
          }
        }
        else if (paramAnonymousMessage.what == -2999)
        {
          if (v.this.cUC)
          {
            AppMethodBeat.o(19457);
            return;
          }
          paramAnonymousMessage = LauncherUI.getInstance();
          if (paramAnonymousMessage != null)
          {
            paramAnonymousMessage = paramAnonymousMessage.IYQ.getMainTabUI();
            if (paramAnonymousMessage.Jdh.containsKey(Integer.valueOf(0))) {
              ((m)paramAnonymousMessage.Jdh.get(Integer.valueOf(0))).fuO();
            }
          }
          if (com.tencent.mm.kernel.g.ajA().aiK())
          {
            ba.aBK();
            paramAnonymousMessage = ca.By("plugin.emoji");
            if (paramAnonymousMessage != null) {
              paramAnonymousMessage.clearPluginData(0);
            }
            paramAnonymousMessage = b.aDy();
            localObject = com.tencent.mm.model.d.a.aDv();
            c localc = c.aDA();
            ba.ajF().ay(new b.1(paramAnonymousMessage));
            h.LTJ.aR(new a.1((com.tencent.mm.model.d.a)localObject));
            localc.a(paramAnonymousMessage);
            localc.a((c.a)localObject);
            ba.ajF().ay(new c.1(localc));
          }
          System.gc();
        }
        AppMethodBeat.o(19457);
      }
    };
    AppMethodBeat.o(19458);
  }
  
  public static v Ml()
  {
    AppMethodBeat.i(19459);
    if (cUB == null) {
      cUB = new v();
    }
    v localv = cUB;
    AppMethodBeat.o(19459);
    return localv;
  }
  
  public final void start()
  {
    AppMethodBeat.i(19460);
    this.cUC = false;
    this.cUD.removeMessages(-1999);
    this.cUD.removeMessages(-2999);
    this.cUD.sendEmptyMessageDelayed(-1999, 3000L);
    this.cUD.sendEmptyMessageDelayed(-2999, 30000L);
    AppMethodBeat.o(19460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.v
 * JD-Core Version:    0.7.0.1
 */