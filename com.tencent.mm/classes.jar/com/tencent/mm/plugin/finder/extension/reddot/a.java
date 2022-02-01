package com.tencent.mm.plugin.finder.extension.reddot;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "lastUpdateWxMessageSessionId", "", "getLastUpdateWxMessageSessionId", "()Ljava/lang/String;", "setLastUpdateWxMessageSessionId", "(Ljava/lang/String;)V", "addFinderHelloMessageRedDot", "", "addFinderMessageRedDot", "addWxMessageRedDot", "checkMsgRedDot", "clearAllFinderMsgRedDot", "clearAllWxMsgRedDot", "clearWxMsgBubbleRedDot", "getFinderMessageTotalCount", "", "count", "isEnableMessageEntrance", "", "sendClearFinderMsgRedDotPath", "sendClearWxMsgBubbleRedDotPath", "sendClearWxMsgRedDotPath", "sendInsertFinderMsgRedDot", "sendInsertHelloMsgRedDot", "sendInsertWxMsgRedDot", "sendUpdateFinderMsgRedDot", "sendUpdateWxMsgRedDot", "updateFinderMessageRedDot", "updateWxMessageRedDot", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a xsr;
  public final MMHandler handler;
  public String xsp;
  private final f xsq;
  
  static
  {
    AppMethodBeat.i(223167);
    xsr = new a((byte)0);
    AppMethodBeat.o(223167);
  }
  
  public a(f paramf)
  {
    AppMethodBeat.i(223166);
    this.xsq = paramf;
    this.xsp = "";
    paramf = new MMHandler("FinderMsgRedDotHandler", (MMHandler.Callback)new i(this));
    paramf.setLogging(false);
    this.handler = paramf;
    AppMethodBeat.o(223166);
  }
  
  public final void dqs()
  {
    AppMethodBeat.i(223158);
    this.handler.removeMessages(8);
    this.handler.sendEmptyMessage(8);
    AppMethodBeat.o(223158);
  }
  
  public final void dqt()
  {
    AppMethodBeat.i(223160);
    this.handler.removeMessages(7);
    this.handler.sendEmptyMessage(7);
    AppMethodBeat.o(223160);
  }
  
  public final void dqu()
  {
    AppMethodBeat.i(223161);
    this.handler.removeMessages(1);
    this.handler.sendEmptyMessage(1);
    AppMethodBeat.o(223161);
  }
  
  public final void dqv()
  {
    AppMethodBeat.i(223163);
    this.handler.removeMessages(3);
    this.handler.sendEmptyMessage(3);
    AppMethodBeat.o(223163);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler$Companion;", "", "()V", "MSG_CLEAR_ALL_FINDER_MSG", "", "MSG_CLEAR_ALL_WX_MSG", "MSG_CLEAR_WX_MSG_BUBBLE", "MSG_INSERT_GREET", "MSG_INSERT_NORMAL", "MSG_INSERT_WX_NORMAL", "MSG_UPDATE_NORMAL", "MSG_UPDATE_WX_NORMAL", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(a parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(a parama, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class e
    implements Runnable
  {
    public e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(291290);
      long l = System.currentTimeMillis();
      int k = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getConversationStorage().gV(2, 2);
      int m = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getConversationStorage().gV(2, 1);
      Object localObject1 = a.a(this.xss).aBf("finder_private_msg_entrance");
      int i;
      Object localObject2;
      if ((localObject1 != null) && (((l)localObject1).field_ctrInfo.type == 1007))
      {
        if (m <= 0)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(20492, new Object[] { Long.valueOf(2L), Long.valueOf(1L), Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.h.IzE.p(1473L, 2L, 1L);
        }
        i = 1;
        localObject2 = new StringBuilder("[checkMsgRedDot] token=").append(l).append(" cost=").append(System.currentTimeMillis() - l).append("ms, [normalUnReadCount:redDotCount]=[").append(k).append(':').append(i).append("] greetUnReadCount=").append(m).append(" ctrlType=[");
        if (localObject1 == null) {
          break label349;
        }
      }
      label349:
      for (localObject1 = Integer.valueOf(((l)localObject1).field_ctrInfo.type);; localObject1 = null)
      {
        Log.i("Finder.MsgRedDotHandler", localObject1 + ']');
        AppMethodBeat.o(291290);
        return;
        if ((localObject1 != null) && (((l)localObject1).field_ctrInfo.type == 1006))
        {
          localObject2 = ((l)localObject1).aBy("finder_private_msg_entrance");
          if (localObject2 != null) {}
          for (int j = ((bkn)localObject2).count;; j = 0)
          {
            i = j;
            if (j == k) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(20492, new Object[] { Long.valueOf(1L), Long.valueOf(1L), Long.valueOf(l) });
            com.tencent.mm.plugin.report.service.h.IzE.p(1473L, 1L, 1L);
            i = j;
            break;
          }
        }
        i = 0;
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class i
    implements MMHandler.Callback
  {
    i(a parama) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(267857);
      Log.i("Finder.MsgRedDotHandler", "[Callback] What=" + paramMessage.what);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(267857);
        return true;
        if (a.dqw())
        {
          a.b(this.xss);
          continue;
          if (a.dqw())
          {
            a.c(this.xss);
            continue;
            if (a.dqw())
            {
              a.d(this.xss);
              continue;
              if (a.dqw())
              {
                a.e(this.xss);
                continue;
                if (a.dqw())
                {
                  a.f(this.xss);
                  continue;
                  a.g(this.xss);
                  continue;
                  a.h(this.xss);
                  continue;
                  a.i(this.xss);
                }
              }
            }
          }
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(a parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(a parama, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.a
 * JD-Core Version:    0.7.0.1
 */