package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.dcx;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.dcz;
import com.tencent.mm.protocal.protobuf.dda;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import java.util.HashSet;
import java.util.LinkedList;

public final class aa
  extends n
  implements k
{
  private static HashSet<Long> hTi;
  private com.tencent.mm.ak.g callback;
  private final String dfJ;
  private final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(150959);
    hTi = new HashSet();
    AppMethodBeat.o(150959);
  }
  
  public aa(String paramString, int paramInt1, int paramInt2, LinkedList<dda> paramLinkedList)
  {
    AppMethodBeat.i(150955);
    this.dfJ = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dcy();
    ((b.a)localObject).hvu = new dcz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).funcId = 251;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dcy)this.rr.hvr.hvw;
    ((dcy)localObject).tlK = u.axw();
    ((dcy)localObject).FMB = paramInt1;
    ((dcy)localObject).tlJ = paramString;
    ((dcy)localObject).DRb = System.currentTimeMillis();
    if ((paramLinkedList != null) && (paramLinkedList.size() == paramInt2))
    {
      ((dcy)localObject).FMC = paramInt2;
      ((dcy)localObject).FMD.addAll(paramLinkedList);
    }
    ac.d("MicroMsg.NetSceneStatusNotify", "summerstatus toUserName = " + paramString + " unreadChatListCount = " + ((dcy)localObject).FMD.size());
    AppMethodBeat.o(150955);
  }
  
  private aa(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150956);
    this.dfJ = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dcy();
    ((b.a)localObject).hvu = new dcz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).funcId = 251;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dcy)this.rr.hvr.hvw;
    ((dcy)localObject).tlK = u.axw();
    ((dcy)localObject).FMB = paramInt;
    ((dcy)localObject).tlJ = paramString1;
    ((dcy)localObject).DRb = System.currentTimeMillis();
    ((dcy)localObject).FME = new dcx();
    ((dcy)localObject).FME.Name = paramString2;
    ((dcy)localObject).FME.FMA = paramString3;
    AppMethodBeat.o(150956);
  }
  
  public static void O(bo parambo)
  {
    AppMethodBeat.i(150952);
    com.tencent.mm.kernel.g.agS();
    if (!((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLb, Boolean.TRUE)).booleanValue())
    {
      ac.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
      AppMethodBeat.o(150952);
      return;
    }
    if (hTi.contains(Long.valueOf(parambo.field_msgId)))
    {
      ac.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", new Object[] { Long.valueOf(parambo.field_msgId), Long.valueOf(parambo.field_msgId) });
      AppMethodBeat.o(150952);
      return;
    }
    hTi.add(Long.valueOf(parambo.field_msgId));
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      AppMethodBeat.o(150952);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<![CDATA[<downloadList>");
    localStringBuilder.append("<downloadItem>");
    localStringBuilder.append("<username>");
    localStringBuilder.append(parambo.field_talker);
    localStringBuilder.append("</username>");
    localStringBuilder.append("<msgsvrid>");
    localStringBuilder.append(parambo.field_msgSvrId);
    localStringBuilder.append("</msgsvrid>");
    localStringBuilder.append("</downloadItem>");
    localStringBuilder.append("</downloadList>]]>");
    String str = localStringBuilder.toString();
    ac.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", new Object[] { Long.valueOf(parambo.field_msgId), localStringBuilder });
    parambo = new aa(u.axw(), 11, "DownloadFile", str);
    com.tencent.mm.kernel.g.agQ().ghe.a(parambo, 0);
    AppMethodBeat.o(150952);
  }
  
  public static void ao(String paramString, int paramInt)
  {
    AppMethodBeat.i(150951);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150951);
      return;
    }
    if ((!com.tencent.mm.kernel.g.agP().afY()) || ((w.xr(paramString)) && (!w.wL(paramString))))
    {
      AppMethodBeat.o(150951);
      return;
    }
    paramString = new aa(paramString, paramInt, 0, null);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
    AppMethodBeat.o(150951);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150953);
    if ((bs.isNullOrNil(paramString1)) || (w.xr(paramString1)))
    {
      AppMethodBeat.o(150953);
      return;
    }
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      AppMethodBeat.o(150953);
      return;
    }
    paramString1 = new aa(paramString1, paramInt, paramString2, paramString3);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString1, 0);
    AppMethodBeat.o(150953);
  }
  
  public static void bu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150954);
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      AppMethodBeat.o(150954);
      return;
    }
    if (!bs.isNullOrNil(paramString1))
    {
      paramString1 = new aa(u.axw(), 11, paramString2, paramString1);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramString1, 0);
    }
    AppMethodBeat.o(150954);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(150957);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150957);
    return i;
  }
  
  public final int getType()
  {
    return 251;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150958);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ac.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.dfJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.aa
 * JD-Core Version:    0.7.0.1
 */