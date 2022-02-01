package com.tencent.mm.plugin.finder.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.finder.storage.af.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler;", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "syncKeyType", "", "(I)V", "notifier", "com/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$notifier$1;", "getSyncKeyType", "()I", "setSyncKeyType", "beforeProcessAddMsg", "", "rawBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "getBypBizSyncKeyType", "getRoleType", "getSyncMessageNotifier", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "throwException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.byp.a.a
{
  public static final a zzR;
  private final b zzP;
  private int zzQ;
  
  static
  {
    AppMethodBeat.i(288580);
    zzR = new a((byte)0);
    AppMethodBeat.o(288580);
  }
  
  public a()
  {
    AppMethodBeat.i(288579);
    this.zzQ = 1;
    this.zzP = new b();
    AppMethodBeat.o(288579);
  }
  
  public final boolean a(co paramco)
  {
    AppMethodBeat.i(288578);
    p.k(paramco, "rawBypMsg");
    String str1 = com.tencent.mm.platformtools.z.a(paramco.RIe.RID);
    String str2 = com.tencent.mm.platformtools.z.a(paramco.RIe.RIE);
    boolean bool5 = paramco.RIh;
    String str4 = paramco.RIf;
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(str4, paramco.RIe.HlH);
    p.j(localObject1, "MMKernel.service(IMessen…, rawBypMsg.msg.NewMsgId)");
    if (((ca)localObject1).apG() != 0L)
    {
      Log.i("Finder.BysSyncHandler", "msg already exist");
      AppMethodBeat.o(288578);
      return false;
    }
    bgq localbgq = new bgq();
    localObject1 = paramco.RIg;
    if ((localObject1 == null) || (localbgq.parseFrom(((com.tencent.mm.cd.b)localObject1).toByteArray()) == null))
    {
      Log.e("Finder.BysSyncHandler", "extInfo is null! fromUser=" + str1 + " toUser=" + str2 + " sessionId=" + paramco.RIf);
      localObject1 = x.aazN;
    }
    af localaf = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getSessionInfoStorage();
    Object localObject2 = localaf.aEN(str4);
    localObject1 = (CharSequence)((com.tencent.mm.plugin.finder.conv.l)localObject2).field_senderUserName;
    boolean bool1;
    boolean bool2;
    label252:
    boolean bool3;
    label265:
    int j;
    label272:
    int m;
    String str3;
    label288:
    label297:
    label310:
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      bool1 = true;
      if (((com.tencent.mm.plugin.finder.conv.l)localObject2).systemRowid <= 0L) {
        break label444;
      }
      bool2 = true;
      if ((localbgq.action & 0x1) <= 0) {
        break label450;
      }
      bool3 = true;
      if (!bool3) {
        break label456;
      }
      j = 1;
      m = ((com.tencent.mm.plugin.finder.conv.l)localObject2).field_rejectMsg;
      if (!bool5) {
        break label461;
      }
      str3 = str2;
      if (!bool5) {
        break label468;
      }
      localObject1 = str1;
      if (!as.bvN((String)localObject1)) {
        break label475;
      }
      localObject1 = com.tencent.mm.model.z.bcZ();
      if (!as.bvO((String)localObject1)) {
        break label478;
      }
      i = 3;
      label320:
      if ((localbgq.action & 0x4) <= 0) {
        break label588;
      }
      k = 1;
      label333:
      if (k == 0) {
        break label594;
      }
    }
    label444:
    label450:
    label456:
    label461:
    label594:
    for (int k = 1;; k = 0)
    {
      if ((as.bvN(str3)) || (as.bvP(str3))) {
        break label600;
      }
      Log.e("Finder.BysSyncHandler", "[beforeProcessAddMsg] talker[" + str3 + "] is invalid.");
      com.tencent.mm.plugin.report.service.h.IzE.a(20492, new Object[] { Long.valueOf(3L), Long.valueOf(1L), str3 });
      com.tencent.mm.plugin.report.service.h.IzE.p(1473L, 3L, 1L);
      AppMethodBeat.o(288578);
      return false;
      bool1 = false;
      break;
      bool2 = false;
      break label252;
      bool3 = false;
      break label265;
      j = 0;
      break label272;
      str3 = str1;
      break label288;
      label468:
      localObject1 = str2;
      break label297;
      label475:
      break label310;
      label478:
      if ((localbgq.action & 0x2) > 0)
      {
        i = 2;
        break label320;
      }
      if (!bool2)
      {
        i = 1;
        break label320;
      }
      Log.e("Finder.BysSyncHandler", "this sessionId[" + str4 + "] has exist, but it will be move to hi holder. just return");
      com.tencent.mm.plugin.report.service.h.IzE.a(20492, new Object[] { Long.valueOf(4L), Long.valueOf(1L), str4 });
      com.tencent.mm.plugin.report.service.h.IzE.p(1473L, 4L, 1L);
      i = ((com.tencent.mm.plugin.finder.conv.l)localObject2).field_type;
      break label320;
      k = 0;
      break label333;
    }
    label588:
    label600:
    if ((((com.tencent.mm.plugin.finder.conv.l)localObject2).field_type != i) || (j != ((com.tencent.mm.plugin.finder.conv.l)localObject2).field_actionPermission) || (k != ((com.tencent.mm.plugin.finder.conv.l)localObject2).field_disableSendMsg) || ((p.h(str3, ((com.tencent.mm.plugin.finder.conv.l)localObject2).field_talker) ^ true)) || (bool1)) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      if (bool4)
      {
        str4 = paramco.RIf;
        p.j(str4, "rawBypMsg.msg_session_id");
        p.j(str3, "talker");
        localObject2 = af.b.Amu;
        p.j(localObject1, "myUserName");
        localaf.a(str4, str3, i, j, (af.b)localObject2, m, k, (String)localObject1);
      }
      Log.i("Finder.BysSyncHandler", "[beforeProcessAddMsg] isNeedReplaceSession=" + bool4 + " svrMsgId=" + paramco.RIe.HlH + " isSender=" + bool5 + " msgType=" + paramco.RIe.COi + ' ' + "createTime=" + paramco.RIe.CreateTime + " isExitSessionInfo=" + bool2 + " isSupportSendMedia=" + bool3 + " convType=" + i + ' ' + "fromUser=" + str1 + " toUser=" + str2 + " sessionId=" + paramco.RIf + " actionPermission=" + j + " extInfo=" + localbgq.action + " myUserName:" + (String)localObject1 + " isSenderUserNameEmpty:" + bool1);
      AppMethodBeat.o(288578);
      return true;
    }
  }
  
  public final int cEZ()
  {
    return 4;
  }
  
  public final int cFa()
  {
    return this.zzQ;
  }
  
  public final ae cFb()
  {
    return (ae)this.zzP;
  }
  
  public final boolean k(Exception paramException)
  {
    AppMethodBeat.i(288577);
    p.k(paramException, "e");
    f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "Finder.BysSyncHandler", false, false, (kotlin.g.a.a)new c(paramException), 12);
    AppMethodBeat.o(288577);
    return false;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "flushNotifyAllMsg", "", "notifyNewMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "plugin-finder_release"})
  public static final class b
    implements ae
  {
    public final void a(ca paramca, db paramdb) {}
    
    public final void dKq() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<String>
  {
    c(Exception paramException)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.message.a
 * JD-Core Version:    0.7.0.1
 */