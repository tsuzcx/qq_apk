package com.tencent.mm.plugin.finder.extension.reddot;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler;", "", "manager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "lastUpdateWxMessageSessionId", "", "getLastUpdateWxMessageSessionId", "()Ljava/lang/String;", "setLastUpdateWxMessageSessionId", "(Ljava/lang/String;)V", "addFinderHelloMessageRedDot", "", "addFinderMessageRedDot", "addWxMessageRedDot", "checkMsgRedDot", "clearAllFinderMsgRedDot", "clearAllWxMsgRedDot", "clearWxMsgBubbleRedDot", "getFinderMessageTotalCount", "", "count", "isEnableMessageEntrance", "", "sendClearFinderMsgRedDotPath", "sendClearWxMsgBubbleRedDotPath", "sendClearWxMsgRedDotPath", "sendInsertFinderMsgRedDot", "sendInsertHelloMsgRedDot", "sendInsertWxMsgRedDot", "sendUpdateFinderMsgRedDot", "sendUpdateWxMsgRedDot", "updateFinderMessageRedDot", "updateWxMessageRedDot", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a APN;
  private final i APO;
  public String APQ;
  public final MMHandler handler;
  
  static
  {
    AppMethodBeat.i(366807);
    APN = new a((byte)0);
    AppMethodBeat.o(366807);
  }
  
  public b(i parami)
  {
    AppMethodBeat.i(366760);
    this.APO = parami;
    this.APQ = "";
    parami = new MMHandler("FinderMsgRedDotHandler", new b..ExternalSyntheticLambda0(this));
    parami.setLogging(false);
    ah localah = ah.aiuX;
    this.handler = parami;
    AppMethodBeat.o(366760);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(366789);
    s.u(paramb, "this$0");
    long l = System.currentTimeMillis();
    int k = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getConversationStorage().im(2, 2);
    int m = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getConversationStorage().im(2, 1);
    paramb = paramb.APO.Su("finder_private_msg_entrance");
    int i;
    label141:
    Object localObject;
    if ((paramb != null) && (paramb.field_ctrInfo.type == 1007))
    {
      i = 1;
      if (i == 0) {
        break label243;
      }
      if (m <= 0)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(20492, new Object[] { Long.valueOf(2L), Long.valueOf(1L), Long.valueOf(l) });
        com.tencent.mm.plugin.report.service.h.OAn.p(1473L, 2L, 1L);
      }
      i = 1;
      localObject = new StringBuilder("[checkMsgRedDot] token=").append(l).append(" cost=").append(System.currentTimeMillis() - l).append("ms, [normalUnReadCount:redDotCount]=[").append(k).append(':').append(i).append("] greetUnReadCount=").append(m).append(" ctrlType=[");
      if (paramb != null) {
        break label358;
      }
    }
    label262:
    label344:
    label353:
    label358:
    for (paramb = null;; paramb = Integer.valueOf(paramb.field_ctrInfo.type))
    {
      Log.i("Finder.MsgRedDotHandler", paramb + ']');
      AppMethodBeat.o(366789);
      return;
      i = 0;
      break;
      label243:
      if ((paramb != null) && (paramb.field_ctrInfo.type == 1006))
      {
        i = 1;
        if (i == 0) {
          break label353;
        }
        localObject = paramb.avK("finder_private_msg_entrance");
        if (localObject != null) {
          break label344;
        }
      }
      for (int j = 0;; j = ((bxq)localObject).count)
      {
        i = j;
        if (j == k) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(20492, new Object[] { Long.valueOf(1L), Long.valueOf(1L), Long.valueOf(l) });
        com.tencent.mm.plugin.report.service.h.OAn.p(1473L, 1L, 1L);
        i = j;
        break;
        i = 0;
        break label262;
      }
      i = 0;
      break label141;
    }
  }
  
  private static final boolean a(final b paramb, Message paramMessage)
  {
    AppMethodBeat.i(366779);
    s.u(paramb, "this$0");
    s.u(paramMessage, "it");
    Log.i("Finder.MsgRedDotHandler", s.X("[Callback] What=", Integer.valueOf(paramMessage.what)));
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(366779);
      return true;
      if (dYY())
      {
        com.tencent.mm.ae.d.uiThread((a)new c(((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getConversationStorage().im(2, 2), com.tencent.mm.kernel.h.baE().ban().getInt(at.a.addL, 0), paramb));
        continue;
        if (dYY())
        {
          com.tencent.mm.ae.d.uiThread((a)new h(paramb, ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getConversationStorage().im(2, 2), com.tencent.mm.kernel.h.baE().ban().getInt(at.a.addL, 0)));
          continue;
          if (dYY())
          {
            com.tencent.mm.ae.d.uiThread((a)new b(paramb));
            continue;
            if (dYY())
            {
              int i = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getConversationStorage().im(1, 2);
              Log.i("Finder.MsgRedDotHandler", s.X("[addWxMessageRedDot] unReadCount=", Integer.valueOf(i)));
              com.tencent.mm.ae.d.uiThread((a)new d(i, paramb));
              continue;
              if (dYY())
              {
                com.tencent.mm.ae.d.uiThread((a)new i(paramb, ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getConversationStorage().im(1, 2)));
                continue;
                com.tencent.mm.ae.d.uiThread((a)new e(paramb));
                continue;
                com.tencent.mm.ae.d.uiThread((a)new f(paramb));
                continue;
                com.tencent.mm.ae.d.uiThread((a)new g(paramb));
                paramb.APQ = "";
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean dYY()
  {
    AppMethodBeat.i(366764);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eTo().bmg()).intValue() > 0)
    {
      AppMethodBeat.o(366764);
      return true;
    }
    AppMethodBeat.o(366764);
    return false;
  }
  
  public final void dYZ()
  {
    AppMethodBeat.i(366827);
    this.handler.removeMessages(8);
    this.handler.sendEmptyMessage(8);
    AppMethodBeat.o(366827);
  }
  
  public final void dZa()
  {
    AppMethodBeat.i(366832);
    this.handler.removeMessages(7);
    this.handler.sendEmptyMessage(7);
    AppMethodBeat.o(366832);
  }
  
  public final void dZb()
  {
    AppMethodBeat.i(366840);
    this.handler.removeMessages(1);
    this.handler.sendEmptyMessage(1);
    AppMethodBeat.o(366840);
  }
  
  public final void dZc()
  {
    AppMethodBeat.i(366845);
    this.handler.removeMessages(3);
    this.handler.sendEmptyMessage(3);
    AppMethodBeat.o(366845);
  }
  
  public final void dZd()
  {
    AppMethodBeat.i(366854);
    this.handler.post(new b..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(366854);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderMsgRedDotHandler$Companion;", "", "()V", "MSG_CLEAR_ALL_FINDER_MSG", "", "MSG_CLEAR_ALL_WX_MSG", "MSG_CLEAR_WX_MSG_BUBBLE", "MSG_INSERT_GREET", "MSG_INSERT_NORMAL", "MSG_INSERT_WX_NORMAL", "MSG_UPDATE_NORMAL", "MSG_UPDATE_WX_NORMAL", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(int paramInt1, int paramInt2, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(int paramInt, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<ah>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements a<ah>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements a<ah>
  {
    h(b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements a<ah>
  {
    i(b paramb, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.b
 * JD-Core Version:    0.7.0.1
 */