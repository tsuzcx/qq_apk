package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.byp.a.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler;", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "()V", "notifier", "com/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1;", "beforeProcessAddMsg", "", "rawBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "getBypBizSyncKeyType", "", "getRoleType", "getSyncMessageNotifier", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "Companion", "plugin-gamelife_release"})
public final class e
  extends a
{
  public static final a uJV;
  private final b uJU;
  
  static
  {
    AppMethodBeat.i(212164);
    uJV = new a((byte)0);
    AppMethodBeat.o(212164);
  }
  
  public e()
  {
    AppMethodBeat.i(212163);
    this.uJU = new b();
    AppMethodBeat.o(212163);
  }
  
  public final boolean a(cg paramcg)
  {
    AppMethodBeat.i(212162);
    p.h(paramcg, "rawBypMsg");
    Object localObject1 = paramcg.FNf;
    boolean bool = paramcg.FNi;
    String str2 = paramcg.FNg;
    String str1 = z.a(((cv)localObject1).FNH);
    localObject1 = z.a(((cv)localObject1).FNG);
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
      localObject5 = paramcg.FNh;
      p.g(localObject5, "rawBypMsg.extinfo");
      localObject4 = ((com.tencent.mm.plugin.gamelife.b.c)localObject4).parseFrom(((b)localObject5).getBytes());
      if (localObject4 != null) {
        break label131;
      }
      paramcg = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.autogen.GameLifeMsgExtInfo");
      AppMethodBeat.o(212162);
      throw paramcg;
      localObject2 = localObject1;
      break;
    }
    label131:
    Object localObject4 = (com.tencent.mm.plugin.gamelife.b.c)localObject4;
    Object localObject5 = ((PluginGameLife)g.ad(PluginGameLife.class)).getSessionInfoStorage();
    p.g(str2, "sessionId");
    p.g(localObject3, "selfUsername");
    p.g(localObject2, "talker");
    ((com.tencent.mm.plugin.gamelife.j.c)localObject5).a(str2, (String)localObject3, (String)localObject2, (com.tencent.mm.plugin.gamelife.b.c)localObject4);
    ae.i("GameLife.MsgSyncHandler", "[beforeProcessAddMsg] svrMsgId=" + paramcg.FNf.xrk + " isSender=" + bool + " msgType=" + paramcg.FNf.urJ + ' ' + "createTime=" + paramcg.FNf.CreateTime + " fromUser=" + (String)localObject1 + " toUser=" + str1 + " sessionId=" + paramcg.FNg + ' ');
    AppMethodBeat.o(212162);
    return true;
  }
  
  public final int bUe()
  {
    return 5;
  }
  
  public final int bUf()
  {
    return 3;
  }
  
  public final aa bUg()
  {
    return (aa)this.uJU;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "flushNotifyAllMsg", "", "notifyNewMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "plugin-gamelife_release"})
  public static final class b
    implements aa
  {
    public final void a(bv parambv, cv paramcv)
    {
      AppMethodBeat.i(212160);
      ae.i("GameLife.MsgSyncHandler", "[notifyNewMsg] msg=" + parambv + " addMsg=" + paramcv);
      AppMethodBeat.o(212160);
    }
    
    public final void cEs()
    {
      AppMethodBeat.i(212161);
      ae.i("GameLife.MsgSyncHandler", "flushNotifyAllMsg");
      AppMethodBeat.o(212161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.e
 * JD-Core Version:    0.7.0.1
 */