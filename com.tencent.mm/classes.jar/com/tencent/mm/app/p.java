package com.tencent.mm.app;

import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.d.a.4;
import com.tencent.mm.model.d.b;
import com.tencent.mm.model.d.b.1;
import com.tencent.mm.model.d.c.1;
import com.tencent.mm.model.d.c.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class p
{
  public static p bYI;
  public boolean bYJ;
  public ak bYK;
  
  public p()
  {
    AppMethodBeat.i(15386);
    this.bYK = new ak(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(15385);
        super.handleMessage(paramAnonymousMessage);
        Object localObject;
        if (paramAnonymousMessage.what == -1999)
        {
          if (!p.this.bYJ)
          {
            paramAnonymousMessage = LauncherUI.getInstance();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.yYV))
            {
              paramAnonymousMessage.yYT.getMainTabUI().atp("tab_main");
              localObject = paramAnonymousMessage.getHomeUI();
              if (((HomeUI)localObject).yXC) {
                ((HomeUI)localObject).yXE = true;
              }
              localObject = n.raQ;
              if (localObject != null) {
                ((f)localObject).cnM();
              }
              paramAnonymousMessage = paramAnonymousMessage.yYT.getMainTabUI().zcI.values().iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject = (Fragment)paramAnonymousMessage.next();
                if (!(localObject instanceof MainUI)) {
                  ((m)localObject).dAH();
                }
              }
            }
            System.gc();
            AppMethodBeat.o(15385);
          }
        }
        else if (paramAnonymousMessage.what == -2999)
        {
          if (p.this.bYJ)
          {
            AppMethodBeat.o(15385);
            return;
          }
          paramAnonymousMessage = LauncherUI.getInstance();
          if (paramAnonymousMessage != null)
          {
            paramAnonymousMessage = paramAnonymousMessage.yYT.getMainTabUI();
            if (paramAnonymousMessage.zcI.containsKey(Integer.valueOf(0))) {
              ((m)paramAnonymousMessage.zcI.get(Integer.valueOf(0))).dAH();
            }
          }
          if (g.RJ().QU())
          {
            aw.aat();
            paramAnonymousMessage = bw.pF("plugin.emoji");
            if (paramAnonymousMessage != null) {
              paramAnonymousMessage.clearPluginData(0);
            }
            paramAnonymousMessage = b.acd();
            localObject = com.tencent.mm.model.d.a.abX();
            com.tencent.mm.model.d.c localc = com.tencent.mm.model.d.c.acf();
            aw.RO().ac(new b.1(paramAnonymousMessage));
            d.ysn.aj(new a.4((com.tencent.mm.model.d.a)localObject));
            localc.a(paramAnonymousMessage);
            localc.a((c.a)localObject);
            aw.RO().ac(new c.1(localc));
          }
          System.gc();
        }
        AppMethodBeat.o(15385);
      }
    };
    AppMethodBeat.o(15386);
  }
  
  public static p Bv()
  {
    AppMethodBeat.i(15387);
    if (bYI == null) {
      bYI = new p();
    }
    p localp = bYI;
    AppMethodBeat.o(15387);
    return localp;
  }
  
  public final void start()
  {
    AppMethodBeat.i(153472);
    this.bYJ = false;
    this.bYK.removeMessages(-1999);
    this.bYK.removeMessages(-2999);
    this.bYK.sendEmptyMessageDelayed(-1999, 3000L);
    this.bYK.sendEmptyMessageDelayed(-2999, 30000L);
    AppMethodBeat.o(153472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.p
 * JD-Core Version:    0.7.0.1
 */