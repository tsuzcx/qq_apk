package com.tencent.mm.plugin.finder.extension.reddot;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "lastUpdateWxMessageSessionId", "", "getLastUpdateWxMessageSessionId", "()Ljava/lang/String;", "setLastUpdateWxMessageSessionId", "(Ljava/lang/String;)V", "addFinderHelloMessageRedDot", "", "addFinderMessageRedDot", "addWxMessageRedDot", "checkMsgRedDot", "clearAllFinderMsgRedDot", "clearAllWxMsgRedDot", "clearWxMsgBubbleRedDot", "isEnableMessageEntrance", "", "sendClearFinderMsgRedDotPath", "sendClearWxMsgBubbleRedDotPath", "sendClearWxMsgRedDotPath", "sendInsertFinderMsgRedDot", "sendInsertHelloMsgRedDot", "sendInsertWxMsgRedDot", "sendUpdateFinderMsgRedDot", "sendUpdateWxMsgRedDot", "updateFinderMessageRedDot", "updateWxMessageRedDot", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a rRH;
  public final ap handler;
  public String rRF;
  private final e rRG;
  
  static
  {
    AppMethodBeat.i(201581);
    rRH = new a((byte)0);
    AppMethodBeat.o(201581);
  }
  
  public a(e parame)
  {
    AppMethodBeat.i(201580);
    this.rRG = parame;
    this.rRF = "";
    parame = new ap("FinderMsgRedDotHandler", (ap.a)new c(this));
    parame.setLogging(false);
    this.handler = parame;
    AppMethodBeat.o(201580);
  }
  
  public final void czD()
  {
    AppMethodBeat.i(201578);
    this.handler.removeMessages(8);
    this.handler.sendEmptyMessage(8);
    AppMethodBeat.o(201578);
  }
  
  public final void czE()
  {
    AppMethodBeat.i(201579);
    this.handler.removeMessages(7);
    this.handler.sendEmptyMessage(7);
    AppMethodBeat.o(201579);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler$Companion;", "", "()V", "MSG_CLEAR_ALL_FINDER_MSG", "", "MSG_CLEAR_ALL_WX_MSG", "MSG_CLEAR_WX_MSG_BUBBLE", "MSG_INSERT_GREET", "MSG_INSERT_NORMAL", "MSG_INSERT_WX_NORMAL", "MSG_UPDATE_NORMAL", "MSG_UPDATE_WX_NORMAL", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(201576);
      long l = System.currentTimeMillis();
      int k = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().fQ(2, 2);
      int m = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().fQ(2, 1);
      Object localObject1 = a.a(this.rRI).ahn("finder_private_msg_entrance");
      int i;
      Object localObject2;
      if ((localObject1 != null) && (((i)localObject1).field_ctrInfo.type == 1007))
      {
        if (m <= 0)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(20492, new Object[] { Long.valueOf(2L), Long.valueOf(1L), Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.g.yhR.n(1473L, 2L, 1L);
        }
        i = 1;
        localObject2 = new StringBuilder("[checkMsgRedDot] token=").append(l).append(" cost=").append(System.currentTimeMillis() - l).append("ms, [normalUnReadCount:redDotCount]=[").append(k).append(':').append(i).append("] greetUnReadCount=").append(m).append(" ctrlType=[");
        if (localObject1 == null) {
          break label349;
        }
      }
      label349:
      for (localObject1 = Integer.valueOf(((i)localObject1).field_ctrInfo.type);; localObject1 = null)
      {
        ad.i("Finder.MsgRedDotHandler", localObject1 + ']');
        AppMethodBeat.o(201576);
        return;
        if ((localObject1 != null) && (((i)localObject1).field_ctrInfo.type == 1006))
        {
          localObject2 = ((i)localObject1).ahq("finder_private_msg_entrance");
          if (localObject2 != null) {}
          for (int j = ((ase)localObject2).count;; j = 0)
          {
            i = j;
            if (j == k) {
              break;
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(20492, new Object[] { Long.valueOf(1L), Long.valueOf(1L), Long.valueOf(l) });
            com.tencent.mm.plugin.report.service.g.yhR.n(1473L, 1L, 1L);
            i = j;
            break;
          }
        }
        i = 0;
        break;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class c
    implements ap.a
  {
    c(a parama) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(201577);
      ad.i("Finder.MsgRedDotHandler", "[Callback] What=" + paramMessage.what);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(201577);
        return true;
        if (a.czF())
        {
          a.b(this.rRI);
          continue;
          if (a.czF())
          {
            a.c(this.rRI);
            continue;
            if (a.czF())
            {
              a.d(this.rRI);
              continue;
              if (a.czF())
              {
                a.e(this.rRI);
                continue;
                if (a.czF())
                {
                  a.f(this.rRI);
                  continue;
                  a.g(this.rRI);
                  continue;
                  a.h(this.rRI);
                  continue;
                  a.i(this.rRI);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.a
 * JD-Core Version:    0.7.0.1
 */