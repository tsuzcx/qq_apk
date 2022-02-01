package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.byp.a.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b.m;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler;", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "()V", "notifier", "com/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1;", "beforeProcessAddMsg", "", "rawBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "getBypBizSyncKeyType", "", "getRoleType", "getSyncMessageNotifier", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "Companion", "plugin-gamelife_release"})
public final class e
  extends a
{
  public static final a ycm;
  private final b ycl;
  
  static
  {
    AppMethodBeat.i(241407);
    ycm = new a((byte)0);
    AppMethodBeat.o(241407);
  }
  
  public e()
  {
    AppMethodBeat.i(241406);
    this.ycl = new b();
    AppMethodBeat.o(241406);
  }
  
  public final boolean a(cp paramcp)
  {
    AppMethodBeat.i(241405);
    p.h(paramcp, "rawBypMsg");
    Object localObject1 = paramcp.KGK;
    boolean bool = paramcp.KGN;
    String str2 = paramcp.KGL;
    String str1 = z.a(((de)localObject1).KHm);
    localObject1 = z.a(((de)localObject1).KHl);
    Object localObject2;
    if (bool)
    {
      localObject2 = str1;
      if (!bool) {
        break label125;
      }
    }
    label125:
    for (Object localObject3 = localObject1;; localObject3 = str1)
    {
      localObject4 = new com.tencent.mm.plugin.gamelife.b.c();
      localObject5 = paramcp.KGM;
      p.g(localObject5, "rawBypMsg.extinfo");
      localObject4 = ((com.tencent.mm.plugin.gamelife.b.c)localObject4).parseFrom(((b)localObject5).zy);
      if (localObject4 != null) {
        break label131;
      }
      paramcp = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.autogen.GameLifeMsgExtInfo");
      AppMethodBeat.o(241405);
      throw paramcp;
      localObject2 = localObject1;
      break;
    }
    label131:
    Object localObject4 = (com.tencent.mm.plugin.gamelife.b.c)localObject4;
    if ((((com.tencent.mm.plugin.gamelife.b.c)localObject4).ybd != null) && (((com.tencent.mm.plugin.gamelife.b.c)localObject4).ybd.ybn != null))
    {
      localObject5 = g.aAh();
      p.g(localObject5, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject5).azQ().set(ar.a.Odg, Integer.valueOf(((com.tencent.mm.plugin.gamelife.b.c)localObject4).ybd.ybm));
      localObject5 = g.aAh();
      p.g(localObject5, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject5).azQ().set(ar.a.Odh, ((com.tencent.mm.plugin.gamelife.b.c)localObject4).ybd.ybn);
    }
    Object localObject5 = ((PluginGameLife)g.ah(PluginGameLife.class)).getSessionInfoStorage();
    p.g(str2, "sessionId");
    p.g(localObject3, "selfUsername");
    p.g(localObject2, "talker");
    ((com.tencent.mm.plugin.gamelife.j.c)localObject5).a(str2, (String)localObject3, (String)localObject2, (com.tencent.mm.plugin.gamelife.b.c)localObject4);
    Log.i("GameLife.MsgSyncHandler", "[beforeProcessAddMsg] svrMsgId=" + paramcp.KGK.Brn + " isSender=" + bool + " msgType=" + paramcp.KGK.xKb + ' ' + "createTime=" + paramcp.KGK.CreateTime + " fromUser=" + (String)localObject1 + " toUser=" + str1 + " sessionId=" + paramcp.KGL + ' ');
    AppMethodBeat.o(241405);
    return true;
  }
  
  public final int crR()
  {
    return 5;
  }
  
  public final int crS()
  {
    return 3;
  }
  
  public final aa crT()
  {
    return (aa)this.ycl;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "flushNotifyAllMsg", "", "notifyNewMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "plugin-gamelife_release"})
  public static final class b
    implements aa
  {
    public final void a(ca paramca, de paramde)
    {
      AppMethodBeat.i(241403);
      Log.i("GameLife.MsgSyncHandler", "[notifyNewMsg] msg=" + paramca + " addMsg=" + paramde);
      AppMethodBeat.o(241403);
    }
    
    public final void dkt()
    {
      AppMethodBeat.i(241404);
      Log.i("GameLife.MsgSyncHandler", "flushNotifyAllMsg");
      AppMethodBeat.o(241404);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.e
 * JD-Core Version:    0.7.0.1
 */