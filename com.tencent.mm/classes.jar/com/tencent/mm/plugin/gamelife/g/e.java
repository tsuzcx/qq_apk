package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.byp.a.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.i.c;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler;", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "()V", "notifier", "com/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1;", "beforeProcessAddMsg", "", "rawBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "getBypBizSyncKeyType", "", "getRoleType", "getSyncMessageNotifier", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "Companion", "plugin-gamelife_release"})
public final class e
  extends a
{
  public static final a uys;
  private final b uyr;
  
  static
  {
    AppMethodBeat.i(211393);
    uys = new a((byte)0);
    AppMethodBeat.o(211393);
  }
  
  public e()
  {
    AppMethodBeat.i(211392);
    this.uyr = new b();
    AppMethodBeat.o(211392);
  }
  
  public final boolean a(cg paramcg)
  {
    AppMethodBeat.i(211391);
    p.h(paramcg, "rawBypMsg");
    Object localObject1 = paramcg.FuH;
    boolean bool = paramcg.FuK;
    String str2 = paramcg.FuI;
    String str1 = com.tencent.mm.platformtools.z.a(((cv)localObject1).Fvj);
    localObject1 = com.tencent.mm.platformtools.z.a(((cv)localObject1).Fvi);
    Object localObject2;
    if (bool)
    {
      localObject2 = str1;
      if (!bool) {
        break label228;
      }
    }
    label228:
    for (Object localObject3 = localObject1;; localObject3 = str1)
    {
      c localc = ((PluginGameLife)g.ad(PluginGameLife.class)).getSessionInfoStorage();
      p.g(str2, "sessionId");
      p.g(localObject3, "selfUsername");
      p.g(localObject2, "talker");
      localc.ak(str2, (String)localObject3, (String)localObject2);
      ad.i("GameLife.MsgSyncHandler", "[beforeProcessAddMsg] svrMsgId=" + paramcg.FuH.xbt + " isSender=" + bool + " msgType=" + paramcg.FuH.ugm + ' ' + "createTime=" + paramcg.FuH.CreateTime + " fromUser=" + (String)localObject1 + " toUser=" + str1 + " sessionId=" + paramcg.FuI + ' ');
      AppMethodBeat.o(211391);
      return true;
      localObject2 = localObject1;
      break;
    }
  }
  
  public final int bSR()
  {
    return 5;
  }
  
  public final int bSS()
  {
    return 3;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.z bST()
  {
    return (com.tencent.mm.plugin.messenger.foundation.a.z)this.uyr;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "flushNotifyAllMsg", "", "notifyNewMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "plugin-gamelife_release"})
  public static final class b
    implements com.tencent.mm.plugin.messenger.foundation.a.z
  {
    public final void a(bu parambu, cv paramcv)
    {
      AppMethodBeat.i(211389);
      ad.i("GameLife.MsgSyncHandler", "[notifyNewMsg] msg=" + parambu + " addMsg=" + paramcv);
      AppMethodBeat.o(211389);
    }
    
    public final void cCF()
    {
      AppMethodBeat.i(211390);
      ad.i("GameLife.MsgSyncHandler", "flushNotifyAllMsg");
      AppMethodBeat.o(211390);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.e
 * JD-Core Version:    0.7.0.1
 */