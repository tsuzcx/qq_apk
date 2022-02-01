package com.tencent.mm.app;

import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.d.a.1;
import com.tencent.mm.model.d.b;
import com.tencent.mm.model.d.b.1;
import com.tencent.mm.model.d.c;
import com.tencent.mm.model.d.c.1;
import com.tencent.mm.model.d.c.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class w
{
  public static w cVB;
  public boolean cVC;
  public aq cVD;
  
  public w()
  {
    AppMethodBeat.i(19458);
    this.cVD = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(19457);
        super.handleMessage(paramAnonymousMessage);
        Object localObject;
        if (paramAnonymousMessage.what == -1999)
        {
          if (!w.this.cVC)
          {
            paramAnonymousMessage = LauncherUI.getInstance();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.JtA))
            {
              paramAnonymousMessage.Jty.getMainTabUI().aWU("tab_main");
              localObject = paramAnonymousMessage.getHomeUI();
              if (((HomeUI)localObject).Jsf) {
                ((HomeUI)localObject).Jsh = true;
              }
              localObject = o.zsv;
              if (localObject != null) {
                ((com.tencent.mm.plugin.sns.b.g)localObject).dVZ();
              }
              paramAnonymousMessage = paramAnonymousMessage.Jty.getMainTabUI().JxR.values().iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject = (Fragment)paramAnonymousMessage.next();
                if (!(localObject instanceof MainUI)) {
                  ((m)localObject).fyP();
                }
              }
            }
            System.gc();
            AppMethodBeat.o(19457);
          }
        }
        else if (paramAnonymousMessage.what == -2999)
        {
          if (w.this.cVC)
          {
            AppMethodBeat.o(19457);
            return;
          }
          paramAnonymousMessage = LauncherUI.getInstance();
          if (paramAnonymousMessage != null)
          {
            paramAnonymousMessage = paramAnonymousMessage.Jty.getMainTabUI();
            if (paramAnonymousMessage.JxR.containsKey(Integer.valueOf(0))) {
              ((m)paramAnonymousMessage.JxR.get(Integer.valueOf(0))).fyP();
            }
          }
          if (com.tencent.mm.kernel.g.ajP().aiZ())
          {
            bc.aCa();
            paramAnonymousMessage = cc.Ca("plugin.emoji");
            if (paramAnonymousMessage != null) {
              paramAnonymousMessage.clearPluginData(0);
            }
            paramAnonymousMessage = b.aDO();
            localObject = com.tencent.mm.model.d.a.aDL();
            c localc = c.aDQ();
            bc.ajU().aw(new b.1(paramAnonymousMessage));
            h.MqF.aO(new a.1((com.tencent.mm.model.d.a)localObject));
            localc.a(paramAnonymousMessage);
            localc.a((c.a)localObject);
            bc.ajU().aw(new c.1(localc));
          }
          System.gc();
        }
        AppMethodBeat.o(19457);
      }
    };
    AppMethodBeat.o(19458);
  }
  
  public static w Mt()
  {
    AppMethodBeat.i(19459);
    if (cVB == null) {
      cVB = new w();
    }
    w localw = cVB;
    AppMethodBeat.o(19459);
    return localw;
  }
  
  public final void start()
  {
    AppMethodBeat.i(19460);
    this.cVC = false;
    this.cVD.removeMessages(-1999);
    this.cVD.removeMessages(-2999);
    this.cVD.sendEmptyMessageDelayed(-1999, 3000L);
    this.cVD.sendEmptyMessageDelayed(-2999, 30000L);
    AppMethodBeat.o(19460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.w
 * JD-Core Version:    0.7.0.1
 */