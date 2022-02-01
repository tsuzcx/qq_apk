package com.tencent.mm.plugin.finder.extension.reddot;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "lastUpdateWxMessageSessionId", "", "getLastUpdateWxMessageSessionId", "()Ljava/lang/String;", "setLastUpdateWxMessageSessionId", "(Ljava/lang/String;)V", "addFinderHelloMessageRedDot", "", "addFinderMessageRedDot", "addWxMessageRedDot", "checkMsgRedDot", "clearAllFinderMsgRedDot", "clearAllWxMsgRedDot", "clearWxMsgBubbleRedDot", "isEnableMessageEntrance", "", "sendClearFinderMsgRedDotPath", "sendClearWxMsgBubbleRedDotPath", "sendClearWxMsgRedDotPath", "sendInsertFinderMsgRedDot", "sendInsertHelloMsgRedDot", "sendInsertWxMsgRedDot", "sendUpdateFinderMsgRedDot", "sendUpdateWxMsgRedDot", "updateFinderMessageRedDot", "updateWxMessageRedDot", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a tJi;
  public final MMHandler handler;
  public String tJg;
  private final f tJh;
  
  static
  {
    AppMethodBeat.i(243490);
    tJi = new a((byte)0);
    AppMethodBeat.o(243490);
  }
  
  public a(f paramf)
  {
    AppMethodBeat.i(243489);
    this.tJh = paramf;
    this.tJg = "";
    paramf = new MMHandler("FinderMsgRedDotHandler", (MMHandler.Callback)new c(this));
    paramf.setLogging(false);
    this.handler = paramf;
    AppMethodBeat.o(243489);
  }
  
  public final void das()
  {
    AppMethodBeat.i(243486);
    this.handler.removeMessages(8);
    this.handler.sendEmptyMessage(8);
    AppMethodBeat.o(243486);
  }
  
  public final void dat()
  {
    AppMethodBeat.i(243487);
    this.handler.removeMessages(7);
    this.handler.sendEmptyMessage(7);
    AppMethodBeat.o(243487);
  }
  
  public final void dau()
  {
    AppMethodBeat.i(243488);
    this.handler.removeMessages(1);
    this.handler.sendEmptyMessage(1);
    AppMethodBeat.o(243488);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler$Companion;", "", "()V", "MSG_CLEAR_ALL_FINDER_MSG", "", "MSG_CLEAR_ALL_WX_MSG", "MSG_CLEAR_WX_MSG_BUBBLE", "MSG_INSERT_GREET", "MSG_INSERT_NORMAL", "MSG_INSERT_WX_NORMAL", "MSG_UPDATE_NORMAL", "MSG_UPDATE_WX_NORMAL", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(243484);
      long l = System.currentTimeMillis();
      int k = ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage().gk(2, 2);
      int m = ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage().gk(2, 1);
      Object localObject1 = a.a(this.tJj).asX("finder_private_msg_entrance");
      int i;
      Object localObject2;
      if ((localObject1 != null) && (((k)localObject1).field_ctrInfo.type == 1007))
      {
        if (m <= 0)
        {
          h.CyF.a(20492, new Object[] { Long.valueOf(2L), Long.valueOf(1L), Long.valueOf(l) });
          h.CyF.n(1473L, 2L, 1L);
        }
        i = 1;
        localObject2 = new StringBuilder("[checkMsgRedDot] token=").append(l).append(" cost=").append(System.currentTimeMillis() - l).append("ms, [normalUnReadCount:redDotCount]=[").append(k).append(':').append(i).append("] greetUnReadCount=").append(m).append(" ctrlType=[");
        if (localObject1 == null) {
          break label349;
        }
      }
      label349:
      for (localObject1 = Integer.valueOf(((k)localObject1).field_ctrInfo.type);; localObject1 = null)
      {
        Log.i("Finder.MsgRedDotHandler", localObject1 + ']');
        AppMethodBeat.o(243484);
        return;
        if ((localObject1 != null) && (((k)localObject1).field_ctrInfo.type == 1006))
        {
          localObject2 = ((k)localObject1).atl("finder_private_msg_entrance");
          if (localObject2 != null) {}
          for (int j = ((bdo)localObject2).count;; j = 0)
          {
            i = j;
            if (j == k) {
              break;
            }
            h.CyF.a(20492, new Object[] { Long.valueOf(1L), Long.valueOf(1L), Long.valueOf(l) });
            h.CyF.n(1473L, 1L, 1L);
            i = j;
            break;
          }
        }
        i = 0;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class c
    implements MMHandler.Callback
  {
    c(a parama) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(243485);
      Log.i("Finder.MsgRedDotHandler", "[Callback] What=" + paramMessage.what);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(243485);
        return true;
        if (a.dav())
        {
          a.b(this.tJj);
          continue;
          if (a.dav())
          {
            a.c(this.tJj);
            continue;
            if (a.dav())
            {
              a.d(this.tJj);
              continue;
              if (a.dav())
              {
                a.e(this.tJj);
                continue;
                if (a.dav())
                {
                  a.f(this.tJj);
                  continue;
                  a.g(this.tJj);
                  continue;
                  a.h(this.tJj);
                  continue;
                  a.i(this.tJj);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.a
 * JD-Core Version:    0.7.0.1
 */