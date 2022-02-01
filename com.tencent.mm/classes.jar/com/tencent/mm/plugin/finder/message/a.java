package com.tencent.mm.plugin.finder.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.k;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.ag.b;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler;", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "()V", "notifier", "com/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$notifier$1;", "beforeProcessAddMsg", "", "rawBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "getBypBizSyncKeyType", "", "getRoleType", "getSyncMessageNotifier", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.byp.a.a
{
  public static final a uNE;
  private final b uND;
  
  static
  {
    AppMethodBeat.i(248688);
    uNE = new a((byte)0);
    AppMethodBeat.o(248688);
  }
  
  public a()
  {
    AppMethodBeat.i(248687);
    this.uND = new b();
    AppMethodBeat.o(248687);
  }
  
  public final boolean a(cp paramcp)
  {
    AppMethodBeat.i(248686);
    p.h(paramcp, "rawBypMsg");
    String str2 = z.a(paramcp.KGK.KHl);
    String str3 = z.a(paramcp.KGK.KHm);
    boolean bool4 = paramcp.KGN;
    String str1 = paramcp.KGL;
    baf localbaf = new baf();
    Object localObject1 = paramcp.KGM;
    if ((localObject1 == null) || (localbaf.parseFrom(((b)localObject1).toByteArray()) == null))
    {
      Log.e("Finder.BysSyncHandler", "extInfo is null! fromUser=" + str2 + " toUser=" + str3 + " sessionId=" + paramcp.KGL);
      localObject1 = x.SXb;
    }
    localObject1 = ((PluginFinder)g.ah(PluginFinder.class)).getSessionInfoStorage();
    Object localObject2 = ((ag)localObject1).avz(str1);
    boolean bool1;
    boolean bool2;
    label177:
    int j;
    label184:
    int m;
    int i;
    label203:
    int k;
    if (((k)localObject2).systemRowid > 0L)
    {
      bool1 = true;
      if ((localbaf.action & 0x1) <= 0) {
        break label336;
      }
      bool2 = true;
      if (!bool2) {
        break label342;
      }
      j = 1;
      m = ((k)localObject2).field_rejectMsg;
      if ((localbaf.action & 0x2) <= 0) {
        break label347;
      }
      i = 2;
      if ((localbaf.action & 0x4) <= 0) {
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
      if ((as.bjs(str1)) || (as.bjt(str1))) {
        break label459;
      }
      Log.e("Finder.BysSyncHandler", "[beforeProcessAddMsg] talker[" + str1 + "] is invalid.");
      h.CyF.a(20492, new Object[] { Long.valueOf(3L), Long.valueOf(1L), str1 });
      h.CyF.n(1473L, 3L, 1L);
      AppMethodBeat.o(248686);
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
      Log.e("Finder.BysSyncHandler", "this sessionId[" + str1 + "] has exist, but it will be move to hi holder. just return");
      h.CyF.a(20492, new Object[] { Long.valueOf(4L), Long.valueOf(1L), str1 });
      h.CyF.n(1473L, 4L, 1L);
      i = ((k)localObject2).field_type;
      break label203;
      k = 0;
      break label216;
      k = 0;
      break label224;
    }
    label459:
    if ((((k)localObject2).field_type != i) || (j != ((k)localObject2).field_actionPermission) || (k != ((k)localObject2).field_disableSendMsg) || ((p.j(str1, ((k)localObject2).field_talker) ^ true))) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      if (bool3)
      {
        localObject2 = paramcp.KGL;
        p.g(localObject2, "rawBypMsg.msg_session_id");
        p.g(str1, "talker");
        ((ag)localObject1).a((String)localObject2, str1, i, j, ag.b.vFd, m, k);
      }
      Log.i("Finder.BysSyncHandler", "[beforeProcessAddMsg] isNeedReplaceSession=" + bool3 + " svrMsgId=" + paramcp.KGK.Brn + " isSender=" + bool4 + " msgType=" + paramcp.KGK.xKb + ' ' + "createTime=" + paramcp.KGK.CreateTime + " isExitSessionInfo=" + bool1 + " isSupportSendMedia=" + bool2 + " convType=" + i + ' ' + "fromUser=" + str2 + " toUser=" + str3 + " sessionId=" + paramcp.KGL + " actionPermission=" + j + " extInfo=" + localbaf.action);
      AppMethodBeat.o(248686);
      return true;
    }
  }
  
  public final int crR()
  {
    return 4;
  }
  
  public final int crS()
  {
    return 1;
  }
  
  public final aa crT()
  {
    return (aa)this.uND;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$notifier$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "flushNotifyAllMsg", "", "notifyNewMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "plugin-finder_release"})
  public static final class b
    implements aa
  {
    public final void a(ca paramca, de paramde) {}
    
    public final void dkt() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.message.a
 * JD-Core Version:    0.7.0.1
 */