package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import java.util.HashSet;
import java.util.LinkedList;

public final class aa
  extends n
  implements k
{
  private static HashSet<Long> hsG;
  private com.tencent.mm.al.g callback;
  private final String dio;
  private final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(150959);
    hsG = new HashSet();
    AppMethodBeat.o(150959);
  }
  
  public aa(String paramString, int paramInt1, int paramInt2, LinkedList<cxo> paramLinkedList)
  {
    AppMethodBeat.i(150955);
    this.dio = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cxm();
    ((b.a)localObject).gUV = new cxn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).funcId = 251;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cxm)this.rr.gUS.gUX;
    ((cxm)localObject).sdQ = u.aqG();
    ((cxm)localObject).Epz = paramInt1;
    ((cxm)localObject).sdP = paramString;
    ((cxm)localObject).CyF = System.currentTimeMillis();
    if ((paramLinkedList != null) && (paramLinkedList.size() == paramInt2))
    {
      ((cxm)localObject).EpA = paramInt2;
      ((cxm)localObject).EpB.addAll(paramLinkedList);
    }
    ad.d("MicroMsg.NetSceneStatusNotify", "summerstatus toUserName = " + paramString + " unreadChatListCount = " + ((cxm)localObject).EpB.size());
    AppMethodBeat.o(150955);
  }
  
  private aa(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150956);
    this.dio = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cxm();
    ((b.a)localObject).gUV = new cxn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).funcId = 251;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cxm)this.rr.gUS.gUX;
    ((cxm)localObject).sdQ = u.aqG();
    ((cxm)localObject).Epz = paramInt;
    ((cxm)localObject).sdP = paramString1;
    ((cxm)localObject).CyF = System.currentTimeMillis();
    ((cxm)localObject).EpC = new cxl();
    ((cxm)localObject).EpC.Name = paramString2;
    ((cxm)localObject).EpC.Epy = paramString3;
    AppMethodBeat.o(150956);
  }
  
  public static void O(bl parambl)
  {
    AppMethodBeat.i(150952);
    com.tencent.mm.kernel.g.afC();
    if (!((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fnm, Boolean.TRUE)).booleanValue())
    {
      ad.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
      AppMethodBeat.o(150952);
      return;
    }
    if (hsG.contains(Long.valueOf(parambl.field_msgId)))
    {
      ad.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", new Object[] { Long.valueOf(parambl.field_msgId), Long.valueOf(parambl.field_msgId) });
      AppMethodBeat.o(150952);
      return;
    }
    hsG.add(Long.valueOf(parambl.field_msgId));
    if (!com.tencent.mm.kernel.g.afz().aeI())
    {
      AppMethodBeat.o(150952);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<![CDATA[<downloadList>");
    localStringBuilder.append("<downloadItem>");
    localStringBuilder.append("<username>");
    localStringBuilder.append(parambl.field_talker);
    localStringBuilder.append("</username>");
    localStringBuilder.append("<msgsvrid>");
    localStringBuilder.append(parambl.field_msgSvrId);
    localStringBuilder.append("</msgsvrid>");
    localStringBuilder.append("</downloadItem>");
    localStringBuilder.append("</downloadList>]]>");
    String str = localStringBuilder.toString();
    ad.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", new Object[] { Long.valueOf(parambl.field_msgId), localStringBuilder });
    parambl = new aa(u.aqG(), 11, "DownloadFile", str);
    com.tencent.mm.kernel.g.afA().gcy.a(parambl, 0);
    AppMethodBeat.o(150952);
  }
  
  public static void ak(String paramString, int paramInt)
  {
    AppMethodBeat.i(150951);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150951);
      return;
    }
    if ((!com.tencent.mm.kernel.g.afz().aeI()) || ((w.to(paramString)) && (!w.sI(paramString))))
    {
      AppMethodBeat.o(150951);
      return;
    }
    paramString = new aa(paramString, paramInt, 0, null);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
    AppMethodBeat.o(150951);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150953);
    if ((bt.isNullOrNil(paramString1)) || (w.to(paramString1)))
    {
      AppMethodBeat.o(150953);
      return;
    }
    if (!com.tencent.mm.kernel.g.afz().aeI())
    {
      AppMethodBeat.o(150953);
      return;
    }
    paramString1 = new aa(paramString1, paramInt, paramString2, paramString3);
    com.tencent.mm.kernel.g.afA().gcy.a(paramString1, 0);
    AppMethodBeat.o(150953);
  }
  
  public static void bm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150954);
    if (!com.tencent.mm.kernel.g.afz().aeI())
    {
      AppMethodBeat.o(150954);
      return;
    }
    if (!bt.isNullOrNil(paramString1))
    {
      paramString1 = new aa(u.aqG(), 11, paramString2, paramString1);
      com.tencent.mm.kernel.g.afA().gcy.a(paramString1, 0);
    }
    AppMethodBeat.o(150954);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
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
      ad.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.dio);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.aa
 * JD-Core Version:    0.7.0.1
 */