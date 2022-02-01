package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.byp.a.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b.m;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler;", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "()V", "notifier", "com/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1;", "beforeProcessAddMsg", "", "rawBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "getBypBizSyncKeyType", "", "getRoleType", "getSyncMessageNotifier", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "Companion", "plugin-gamelife_release"})
public final class e
  extends a
{
  public static final a DhS;
  private final b DhR;
  
  static
  {
    AppMethodBeat.i(204127);
    DhS = new a((byte)0);
    AppMethodBeat.o(204127);
  }
  
  public e()
  {
    AppMethodBeat.i(204126);
    this.DhR = new b();
    AppMethodBeat.o(204126);
  }
  
  public final boolean a(co paramco)
  {
    AppMethodBeat.i(204125);
    p.k(paramco, "rawBypMsg");
    Object localObject1 = paramco.RIe;
    boolean bool = paramco.RIh;
    String str2 = paramco.RIf;
    String str1 = z.a(((db)localObject1).RIE);
    localObject1 = z.a(((db)localObject1).RID);
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
      localObject5 = paramco.RIg;
      p.j(localObject5, "rawBypMsg.extinfo");
      localObject4 = ((com.tencent.mm.plugin.gamelife.b.c)localObject4).parseFrom(((b)localObject5).UH);
      if (localObject4 != null) {
        break label131;
      }
      paramco = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.autogen.GameLifeMsgExtInfo");
      AppMethodBeat.o(204125);
      throw paramco;
      localObject2 = localObject1;
      break;
    }
    label131:
    Object localObject4 = (com.tencent.mm.plugin.gamelife.b.c)localObject4;
    if ((((com.tencent.mm.plugin.gamelife.b.c)localObject4).DgL != null) && (((com.tencent.mm.plugin.gamelife.b.c)localObject4).DgL.extern_info != null))
    {
      localObject5 = ((com.tencent.mm.plugin.gamelife.b.c)localObject4).DgL.extern_info;
      p.j(localObject5, "msgExtInfo.msg_report.extern_info");
      if (!n.a((CharSequence)localObject5, (CharSequence)"20008", false))
      {
        localObject5 = h.aHG();
        p.j(localObject5, "MMKernel.storage()");
        ((f)localObject5).aHp().set(ar.a.Vrn, Integer.valueOf(((com.tencent.mm.plugin.gamelife.b.c)localObject4).DgL.msg_type));
        localObject5 = h.aHG();
        p.j(localObject5, "MMKernel.storage()");
        ((f)localObject5).aHp().set(ar.a.Vro, ((com.tencent.mm.plugin.gamelife.b.c)localObject4).DgL.extern_info);
      }
    }
    Object localObject5 = ((PluginGameLife)h.ag(PluginGameLife.class)).getSessionInfoStorage();
    p.j(str2, "sessionId");
    p.j(localObject3, "selfUsername");
    p.j(localObject2, "talker");
    ((com.tencent.mm.plugin.gamelife.j.c)localObject5).a(str2, (String)localObject3, (String)localObject2, (com.tencent.mm.plugin.gamelife.b.c)localObject4);
    Log.i("GameLife.MsgSyncHandler", "[beforeProcessAddMsg] svrMsgId=" + paramco.RIe.HlH + " isSender=" + bool + " msgType=" + paramco.RIe.COi + ' ' + "createTime=" + paramco.RIe.CreateTime + " fromUser=" + (String)localObject1 + " toUser=" + str1 + " sessionId=" + paramco.RIf + ' ');
    AppMethodBeat.o(204125);
    return true;
  }
  
  public final int cEZ()
  {
    return 5;
  }
  
  public final int cFa()
  {
    return 3;
  }
  
  public final ae cFb()
  {
    return (ae)this.DhR;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$Companion;", "", "()V", "MSG_REPORT_EXP", "", "TAG", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "flushNotifyAllMsg", "", "notifyNewMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "plugin-gamelife_release"})
  public static final class b
    implements ae
  {
    public final void a(ca paramca, db paramdb)
    {
      AppMethodBeat.i(204215);
      Log.i("GameLife.MsgSyncHandler", "[notifyNewMsg] msg=" + paramca + " addMsg=" + paramdb);
      AppMethodBeat.o(204215);
    }
    
    public final void dKq()
    {
      AppMethodBeat.i(204216);
      Log.i("GameLife.MsgSyncHandler", "flushNotifyAllMsg");
      AppMethodBeat.o(204216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.e
 * JD-Core Version:    0.7.0.1
 */