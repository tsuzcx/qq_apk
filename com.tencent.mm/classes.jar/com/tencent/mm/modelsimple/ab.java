package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ems;
import com.tencent.mm.protocal.protobuf.emt;
import com.tencent.mm.protocal.protobuf.emu;
import com.tencent.mm.protocal.protobuf.emv;
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
  private static HashSet<Long> maB;
  private i callback;
  private final String fCl;
  private final d rr;
  
  static
  {
    AppMethodBeat.i(150959);
    maB = new HashSet();
    AppMethodBeat.o(150959);
  }
  
  public ab(String paramString, int paramInt1, int paramInt2, LinkedList<emv> paramLinkedList)
  {
    AppMethodBeat.i(150955);
    this.fCl = paramString;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new emt();
    ((d.a)localObject).lBV = new emu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((d.a)localObject).funcId = 251;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (emt)d.b.b(this.rr.lBR);
    ((emt)localObject).CRR = z.bcZ();
    ((emt)localObject).Upv = paramInt1;
    ((emt)localObject).CRQ = paramString;
    ((emt)localObject).RJQ = System.currentTimeMillis();
    if ((paramLinkedList != null) && (paramLinkedList.size() == paramInt2))
    {
      ((emt)localObject).Upw = paramInt2;
      ((emt)localObject).Upx.addAll(paramLinkedList);
    }
    Log.d("MicroMsg.NetSceneStatusNotify", "summerstatus toUserName = " + paramString + " unreadChatListCount = " + ((emt)localObject).Upx.size());
    AppMethodBeat.o(150955);
  }
  
  private ab(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150956);
    this.fCl = paramString1;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new emt();
    ((d.a)localObject).lBV = new emu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((d.a)localObject).funcId = 251;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (emt)d.b.b(this.rr.lBR);
    ((emt)localObject).CRR = z.bcZ();
    ((emt)localObject).Upv = paramInt;
    ((emt)localObject).CRQ = paramString1;
    ((emt)localObject).RJQ = System.currentTimeMillis();
    ((emt)localObject).Upy = new ems();
    ((emt)localObject).Upy.CMP = paramString2;
    ((emt)localObject).Upy.Upu = paramString3;
    AppMethodBeat.o(150956);
  }
  
  public static void aN(String paramString, int paramInt)
  {
    AppMethodBeat.i(150951);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150951);
      return;
    }
    if ((!h.aHE().aGM()) || ((com.tencent.mm.model.ab.QX(paramString)) && (!com.tencent.mm.model.ab.Qq(paramString))))
    {
      AppMethodBeat.o(150951);
      return;
    }
    paramString = new ab(paramString, paramInt, 0, null);
    h.aHF().kcd.a(paramString, 0);
    AppMethodBeat.o(150951);
  }
  
  public static void ah(ca paramca)
  {
    AppMethodBeat.i(150952);
    h.aHH();
    if (!((Boolean)h.aHG().aHp().get(ar.a.VnU, Boolean.TRUE)).booleanValue())
    {
      Log.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
      AppMethodBeat.o(150952);
      return;
    }
    if (maB.contains(Long.valueOf(paramca.field_msgId)))
    {
      Log.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", new Object[] { Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgId) });
      AppMethodBeat.o(150952);
      return;
    }
    maB.add(Long.valueOf(paramca.field_msgId));
    if (!h.aHE().aGM())
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
    paramca = new ab(z.bcZ(), 11, "DownloadFile", str);
    h.aHF().kcd.a(paramca, 0);
    AppMethodBeat.o(150952);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150953);
    if ((Util.isNullOrNil(paramString1)) || (com.tencent.mm.model.ab.QX(paramString1)))
    {
      AppMethodBeat.o(150953);
      return;
    }
    if (!h.aHE().aGM())
    {
      AppMethodBeat.o(150953);
      return;
    }
    paramString1 = new ab(paramString1, paramInt, paramString2, paramString3);
    h.aHF().kcd.a(paramString1, 0);
    AppMethodBeat.o(150953);
  }
  
  public static boolean bC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204439);
    if (!h.aHE().aGM())
    {
      Log.e("MicroMsg.NetSceneStatusNotify", "sendHandOffSyncCmd fail due to account has not initialized");
      AppMethodBeat.o(204439);
      return false;
    }
    if (!Util.isNullOrNil(paramString1))
    {
      paramString1 = new ab(z.bcZ(), 11, paramString2, paramString1);
      h.aHF().kcd.a(paramString1, 0);
      AppMethodBeat.o(204439);
      return true;
    }
    AppMethodBeat.o(204439);
    return false;
  }
  
  public final int doScene(g paramg, i parami)
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
      Log.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.fCl);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ab
 * JD-Core Version:    0.7.0.1
 */