package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.djf;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import java.util.HashSet;
import java.util.LinkedList;

public final class ab
  extends n
  implements k
{
  private static HashSet<Long> ipt;
  private f callback;
  private final String dsk;
  private final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(150959);
    ipt = new HashSet();
    AppMethodBeat.o(150959);
  }
  
  public ab(String paramString, int paramInt1, int paramInt2, LinkedList<dji> paramLinkedList)
  {
    AppMethodBeat.i(150955);
    this.dsk = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new djg();
    ((b.a)localObject).hQG = new djh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).funcId = 251;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (djg)this.rr.hQD.hQJ;
    ((djg)localObject).uvG = v.aAC();
    ((djg)localObject).HQX = paramInt1;
    ((djg)localObject).uvF = paramString;
    ((djg)localObject).FOR = System.currentTimeMillis();
    if ((paramLinkedList != null) && (paramLinkedList.size() == paramInt2))
    {
      ((djg)localObject).HQY = paramInt2;
      ((djg)localObject).HQZ.addAll(paramLinkedList);
    }
    ae.d("MicroMsg.NetSceneStatusNotify", "summerstatus toUserName = " + paramString + " unreadChatListCount = " + ((djg)localObject).HQZ.size());
    AppMethodBeat.o(150955);
  }
  
  private ab(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150956);
    this.dsk = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new djg();
    ((b.a)localObject).hQG = new djh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).funcId = 251;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (djg)this.rr.hQD.hQJ;
    ((djg)localObject).uvG = v.aAC();
    ((djg)localObject).HQX = paramInt;
    ((djg)localObject).uvF = paramString1;
    ((djg)localObject).FOR = System.currentTimeMillis();
    ((djg)localObject).HRa = new djf();
    ((djg)localObject).HRa.Name = paramString2;
    ((djg)localObject).HRa.HQW = paramString3;
    AppMethodBeat.o(150956);
  }
  
  public static void R(bv parambv)
  {
    AppMethodBeat.i(150952);
    g.ajS();
    if (!((Boolean)g.ajR().ajA().get(am.a.IRR, Boolean.TRUE)).booleanValue())
    {
      ae.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
      AppMethodBeat.o(150952);
      return;
    }
    if (ipt.contains(Long.valueOf(parambv.field_msgId)))
    {
      ae.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", new Object[] { Long.valueOf(parambv.field_msgId), Long.valueOf(parambv.field_msgId) });
      AppMethodBeat.o(150952);
      return;
    }
    ipt.add(Long.valueOf(parambv.field_msgId));
    if (!g.ajP().aiZ())
    {
      AppMethodBeat.o(150952);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<![CDATA[<downloadList>");
    localStringBuilder.append("<downloadItem>");
    localStringBuilder.append("<username>");
    localStringBuilder.append(parambv.field_talker);
    localStringBuilder.append("</username>");
    localStringBuilder.append("<msgsvrid>");
    localStringBuilder.append(parambv.field_msgSvrId);
    localStringBuilder.append("</msgsvrid>");
    localStringBuilder.append("</downloadItem>");
    localStringBuilder.append("</downloadList>]]>");
    String str = localStringBuilder.toString();
    ae.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", new Object[] { Long.valueOf(parambv.field_msgId), localStringBuilder });
    parambv = new ab(v.aAC(), 11, "DownloadFile", str);
    g.ajQ().gDv.a(parambv, 0);
    AppMethodBeat.o(150952);
  }
  
  public static void ar(String paramString, int paramInt)
  {
    AppMethodBeat.i(150951);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150951);
      return;
    }
    if ((!g.ajP().aiZ()) || ((x.AZ(paramString)) && (!x.As(paramString))))
    {
      AppMethodBeat.o(150951);
      return;
    }
    paramString = new ab(paramString, paramInt, 0, null);
    g.ajQ().gDv.a(paramString, 0);
    AppMethodBeat.o(150951);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150953);
    if ((bu.isNullOrNil(paramString1)) || (x.AZ(paramString1)))
    {
      AppMethodBeat.o(150953);
      return;
    }
    if (!g.ajP().aiZ())
    {
      AppMethodBeat.o(150953);
      return;
    }
    paramString1 = new ab(paramString1, paramInt, paramString2, paramString3);
    g.ajQ().gDv.a(paramString1, 0);
    AppMethodBeat.o(150953);
  }
  
  public static void bv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150954);
    if (!g.ajP().aiZ())
    {
      AppMethodBeat.o(150954);
      return;
    }
    if (!bu.isNullOrNil(paramString1))
    {
      paramString1 = new ab(v.aAC(), 11, paramString2, paramString1);
      g.ajQ().gDv.a(paramString1, 0);
    }
    AppMethodBeat.o(150954);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(150957);
    this.callback = paramf;
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
      ae.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.dsk);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ab
 * JD-Core Version:    0.7.0.1
 */