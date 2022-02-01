package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ecr;
import com.tencent.mm.protocal.protobuf.ecs;
import com.tencent.mm.protocal.protobuf.ect;
import com.tencent.mm.protocal.protobuf.ecu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import java.util.HashSet;
import java.util.LinkedList;

public final class ab
  extends q
  implements m
{
  private static HashSet<Long> jkA;
  private i callback;
  private final String dJw;
  private final d rr;
  
  static
  {
    AppMethodBeat.i(150959);
    jkA = new HashSet();
    AppMethodBeat.o(150959);
  }
  
  public ab(String paramString, int paramInt1, int paramInt2, LinkedList<ecu> paramLinkedList)
  {
    AppMethodBeat.i(150955);
    this.dJw = paramString;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ecs();
    ((d.a)localObject).iLO = new ect();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((d.a)localObject).funcId = 251;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ecs)this.rr.iLK.iLR;
    ((ecs)localObject).xNH = z.aTY();
    ((ecs)localObject).NcY = paramInt1;
    ((ecs)localObject).xNG = paramString;
    ((ecs)localObject).KIz = System.currentTimeMillis();
    if ((paramLinkedList != null) && (paramLinkedList.size() == paramInt2))
    {
      ((ecs)localObject).NcZ = paramInt2;
      ((ecs)localObject).Nda.addAll(paramLinkedList);
    }
    Log.d("MicroMsg.NetSceneStatusNotify", "summerstatus toUserName = " + paramString + " unreadChatListCount = " + ((ecs)localObject).Nda.size());
    AppMethodBeat.o(150955);
  }
  
  private ab(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150956);
    this.dJw = paramString1;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ecs();
    ((d.a)localObject).iLO = new ect();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((d.a)localObject).funcId = 251;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ecs)this.rr.iLK.iLR;
    ((ecs)localObject).xNH = z.aTY();
    ((ecs)localObject).NcY = paramInt;
    ((ecs)localObject).xNG = paramString1;
    ((ecs)localObject).KIz = System.currentTimeMillis();
    ((ecs)localObject).Ndb = new ecr();
    ((ecs)localObject).Ndb.Name = paramString2;
    ((ecs)localObject).Ndb.NcX = paramString3;
    AppMethodBeat.o(150956);
  }
  
  public static void ab(ca paramca)
  {
    AppMethodBeat.i(150952);
    com.tencent.mm.kernel.g.aAi();
    if (!((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NZT, Boolean.TRUE)).booleanValue())
    {
      Log.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
      AppMethodBeat.o(150952);
      return;
    }
    if (jkA.contains(Long.valueOf(paramca.field_msgId)))
    {
      Log.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", new Object[] { Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgId) });
      AppMethodBeat.o(150952);
      return;
    }
    jkA.add(Long.valueOf(paramca.field_msgId));
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      AppMethodBeat.o(150952);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<![CDATA[<downloadList>");
    localStringBuilder.append("<downloadItem>");
    localStringBuilder.append("<username>");
    localStringBuilder.append(paramca.field_talker);
    localStringBuilder.append("</username>");
    localStringBuilder.append("<msgsvrid>");
    localStringBuilder.append(paramca.field_msgSvrId);
    localStringBuilder.append("</msgsvrid>");
    localStringBuilder.append("</downloadItem>");
    localStringBuilder.append("</downloadList>]]>");
    String str = localStringBuilder.toString();
    Log.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", new Object[] { Long.valueOf(paramca.field_msgId), localStringBuilder });
    paramca = new ab(z.aTY(), 11, "DownloadFile", str);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramca, 0);
    AppMethodBeat.o(150952);
  }
  
  public static void av(String paramString, int paramInt)
  {
    AppMethodBeat.i(150951);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150951);
      return;
    }
    if ((!com.tencent.mm.kernel.g.aAf().azp()) || ((com.tencent.mm.model.ab.JE(paramString)) && (!com.tencent.mm.model.ab.IX(paramString))))
    {
      AppMethodBeat.o(150951);
      return;
    }
    paramString = new ab(paramString, paramInt, 0, null);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
    AppMethodBeat.o(150951);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150953);
    if ((Util.isNullOrNil(paramString1)) || (com.tencent.mm.model.ab.JE(paramString1)))
    {
      AppMethodBeat.o(150953);
      return;
    }
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      AppMethodBeat.o(150953);
      return;
    }
    paramString1 = new ab(paramString1, paramInt, paramString2, paramString3);
    com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
    AppMethodBeat.o(150953);
  }
  
  public static boolean bz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223640);
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      Log.e("MicroMsg.NetSceneStatusNotify", "sendHandOffSyncCmd fail due to account has not initialized");
      AppMethodBeat.o(223640);
      return false;
    }
    if (!Util.isNullOrNil(paramString1))
    {
      paramString1 = new ab(z.aTY(), 11, paramString2, paramString1);
      com.tencent.mm.kernel.g.aAg().hqi.a(paramString1, 0);
      AppMethodBeat.o(223640);
      return true;
    }
    AppMethodBeat.o(223640);
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(150957);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150957);
    return i;
  }
  
  public final int getType()
  {
    return 251;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150958);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.dJw);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ab
 * JD-Core Version:    0.7.0.1
 */