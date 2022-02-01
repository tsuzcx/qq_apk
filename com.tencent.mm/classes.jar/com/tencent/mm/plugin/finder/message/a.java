package com.tencent.mm.plugin.finder.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.j;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.storage.w.b;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler;", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "()V", "notifier", "com/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$notifier$1;", "beforeProcessAddMsg", "", "rawBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "getBypBizSyncKeyType", "", "getRoleType", "getSyncMessageNotifier", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.byp.a.a
{
  public static final a ssJ;
  private final b ssI;
  
  static
  {
    AppMethodBeat.i(203412);
    ssJ = new a((byte)0);
    AppMethodBeat.o(203412);
  }
  
  public a()
  {
    AppMethodBeat.i(203411);
    this.ssI = new b();
    AppMethodBeat.o(203411);
  }
  
  public final boolean a(cg paramcg)
  {
    AppMethodBeat.i(203410);
    p.h(paramcg, "rawBypMsg");
    String str2 = com.tencent.mm.platformtools.z.a(paramcg.FNf.FNG);
    String str3 = com.tencent.mm.platformtools.z.a(paramcg.FNf.FNH);
    boolean bool4 = paramcg.FNi;
    String str1 = paramcg.FNg;
    aqw localaqw = new aqw();
    Object localObject1 = paramcg.FNh;
    if ((localObject1 == null) || (localaqw.parseFrom(((b)localObject1).toByteArray()) == null))
    {
      ae.e("Finder.BysSyncHandler", "extInfo is null! fromUser=" + str2 + " toUser=" + str3 + " sessionId=" + paramcg.FNg);
      localObject1 = d.z.Nhr;
    }
    localObject1 = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage();
    Object localObject2 = ((w)localObject1).ajt(str1);
    boolean bool1;
    boolean bool2;
    label177:
    int j;
    label184:
    int m;
    int i;
    label203:
    int k;
    if (((j)localObject2).systemRowid > 0L)
    {
      bool1 = true;
      if ((localaqw.action & 0x1) <= 0) {
        break label336;
      }
      bool2 = true;
      if (!bool2) {
        break label342;
      }
      j = 1;
      m = ((j)localObject2).field_rejectMsg;
      if ((localaqw.action & 0x2) <= 0) {
        break label347;
      }
      i = 2;
      if ((localaqw.action & 0x4) <= 0) {
        break label440;
      }
      k = 1;
      label216:
      if (k == 0) {
        break label446;
      }
      k = 1;
      label224:
      if (!bool4) {
        break label452;
      }
    }
    label440:
    label446:
    label452:
    for (str1 = str3;; str1 = str2)
    {
      if ((an.aUt(str1)) || (an.aUu(str1))) {
        break label459;
      }
      ae.e("Finder.BysSyncHandler", "[beforeProcessAddMsg] talker[" + str1 + "] is invalid.");
      com.tencent.mm.plugin.report.service.g.yxI.f(20492, new Object[] { Long.valueOf(3L), Long.valueOf(1L), str1 });
      com.tencent.mm.plugin.report.service.g.yxI.n(1473L, 3L, 1L);
      AppMethodBeat.o(203410);
      return false;
      bool1 = false;
      break;
      label336:
      bool2 = false;
      break label177;
      label342:
      j = 0;
      break label184;
      label347:
      if (!bool1)
      {
        i = 1;
        break label203;
      }
      ae.e("Finder.BysSyncHandler", "this sessionId[" + str1 + "] has exist, but it will be move to hi holder. just return");
      com.tencent.mm.plugin.report.service.g.yxI.f(20492, new Object[] { Long.valueOf(4L), Long.valueOf(1L), str1 });
      com.tencent.mm.plugin.report.service.g.yxI.n(1473L, 4L, 1L);
      i = ((j)localObject2).field_type;
      break label203;
      k = 0;
      break label216;
      k = 0;
      break label224;
    }
    label459:
    if ((((j)localObject2).field_type != i) || (j != ((j)localObject2).field_actionPermission) || (k != ((j)localObject2).field_disableSendMsg) || ((p.i(str1, ((j)localObject2).field_talker) ^ true))) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      if (bool3)
      {
        localObject2 = paramcg.FNg;
        p.g(localObject2, "rawBypMsg.msg_session_id");
        p.g(str1, "talker");
        ((w)localObject1).a((String)localObject2, str1, i, j, w.b.sJY, m, k);
      }
      ae.i("Finder.BysSyncHandler", "[beforeProcessAddMsg] isNeedReplaceSession=" + bool3 + " svrMsgId=" + paramcg.FNf.xrk + " isSender=" + bool4 + " msgType=" + paramcg.FNf.urJ + ' ' + "createTime=" + paramcg.FNf.CreateTime + " isExitSessionInfo=" + bool1 + " isSupportSendMedia=" + bool2 + " convType=" + i + ' ' + "fromUser=" + str2 + " toUser=" + str3 + " sessionId=" + paramcg.FNg + " actionPermission=" + j + " extInfo=" + localaqw.action);
      AppMethodBeat.o(203410);
      return true;
    }
  }
  
  public final int bUe()
  {
    return 4;
  }
  
  public final int bUf()
  {
    return 1;
  }
  
  public final aa bUg()
  {
    return (aa)this.ssI;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "flushNotifyAllMsg", "", "notifyNewMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "plugin-finder_release"})
  public static final class b
    implements aa
  {
    public final void a(bv parambv, cv paramcv) {}
    
    public final void cEs() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.message.a
 * JD-Core Version:    0.7.0.1
 */