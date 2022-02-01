package com.tencent.mm.plugin.finder.extension.reddot;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "lastUpdateWxMessageSessionId", "", "getLastUpdateWxMessageSessionId", "()Ljava/lang/String;", "setLastUpdateWxMessageSessionId", "(Ljava/lang/String;)V", "addFinderHelloMessageRedDot", "", "addFinderMessageRedDot", "addWxMessageRedDot", "checkMsgRedDot", "clearAllFinderMsgRedDot", "clearAllWxMsgRedDot", "clearWxMsgBubbleRedDot", "isEnableMessageEntrance", "", "sendClearFinderMsgRedDotPath", "sendClearWxMsgBubbleRedDotPath", "sendClearWxMsgRedDotPath", "sendInsertFinderMsgRedDot", "sendInsertHelloMsgRedDot", "sendInsertWxMsgRedDot", "sendUpdateFinderMsgRedDot", "sendUpdateWxMsgRedDot", "updateFinderMessageRedDot", "updateWxMessageRedDot", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a saj;
  public final aq handler;
  public String sah;
  private final e sai;
  
  static
  {
    AppMethodBeat.i(202029);
    saj = new a((byte)0);
    AppMethodBeat.o(202029);
  }
  
  public a(e parame)
  {
    AppMethodBeat.i(202028);
    this.sai = parame;
    this.sah = "";
    parame = new aq("FinderMsgRedDotHandler", (aq.a)new c(this));
    parame.setLogging(false);
    this.handler = parame;
    AppMethodBeat.o(202028);
  }
  
  public final void cBh()
  {
    AppMethodBeat.i(202026);
    this.handler.removeMessages(8);
    this.handler.sendEmptyMessage(8);
    AppMethodBeat.o(202026);
  }
  
  public final void cBi()
  {
    AppMethodBeat.i(202027);
    this.handler.removeMessages(7);
    this.handler.sendEmptyMessage(7);
    AppMethodBeat.o(202027);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler$Companion;", "", "()V", "MSG_CLEAR_ALL_FINDER_MSG", "", "MSG_CLEAR_ALL_WX_MSG", "MSG_CLEAR_WX_MSG_BUBBLE", "MSG_INSERT_GREET", "MSG_INSERT_NORMAL", "MSG_INSERT_WX_NORMAL", "MSG_UPDATE_NORMAL", "MSG_UPDATE_WX_NORMAL", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(202024);
      long l = System.currentTimeMillis();
      int k = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().fQ(2, 2);
      int m = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().fQ(2, 1);
      Object localObject1 = a.a(this.sak).aij("finder_private_msg_entrance");
      int i;
      Object localObject2;
      if ((localObject1 != null) && (((i)localObject1).field_ctrInfo.type == 1007))
      {
        if (m <= 0)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(20492, new Object[] { Long.valueOf(2L), Long.valueOf(1L), Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.g.yxI.n(1473L, 2L, 1L);
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
        ae.i("Finder.MsgRedDotHandler", localObject1 + ']');
        AppMethodBeat.o(202024);
        return;
        if ((localObject1 != null) && (((i)localObject1).field_ctrInfo.type == 1006))
        {
          localObject2 = ((i)localObject1).aim("finder_private_msg_entrance");
          if (localObject2 != null) {}
          for (int j = ((ast)localObject2).count;; j = 0)
          {
            i = j;
            if (j == k) {
              break;
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(20492, new Object[] { Long.valueOf(1L), Long.valueOf(1L), Long.valueOf(l) });
            com.tencent.mm.plugin.report.service.g.yxI.n(1473L, 1L, 1L);
            i = j;
            break;
          }
        }
        i = 0;
        break;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class c
    implements aq.a
  {
    c(a parama) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(202025);
      ae.i("Finder.MsgRedDotHandler", "[Callback] What=" + paramMessage.what);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(202025);
        return true;
        if (a.cBj())
        {
          a.b(this.sak);
          continue;
          if (a.cBj())
          {
            a.c(this.sak);
            continue;
            if (a.cBj())
            {
              a.d(this.sak);
              continue;
              if (a.cBj())
              {
                a.e(this.sak);
                continue;
                if (a.cBj())
                {
                  a.f(this.sak);
                  continue;
                  a.g(this.sak);
                  continue;
                  a.h(this.sak);
                  continue;
                  a.i(this.sak);
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