package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dim;
import com.tencent.mm.protocal.protobuf.din;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import java.util.HashSet;
import java.util.LinkedList;

public final class aa
  extends n
  implements k
{
  private static HashSet<Long> imz;
  private f callback;
  private final String drf;
  private final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(150959);
    imz = new HashSet();
    AppMethodBeat.o(150959);
  }
  
  public aa(String paramString, int paramInt1, int paramInt2, LinkedList<din> paramLinkedList)
  {
    AppMethodBeat.i(150955);
    this.drf = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dil();
    ((b.a)localObject).hNN = new dim();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).funcId = 251;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dil)this.rr.hNK.hNQ;
    ((dil)localObject).ukj = u.aAm();
    ((dil)localObject).Hxm = paramInt1;
    ((dil)localObject).uki = paramString;
    ((dil)localObject).Fwt = System.currentTimeMillis();
    if ((paramLinkedList != null) && (paramLinkedList.size() == paramInt2))
    {
      ((dil)localObject).Hxn = paramInt2;
      ((dil)localObject).Hxo.addAll(paramLinkedList);
    }
    ad.d("MicroMsg.NetSceneStatusNotify", "summerstatus toUserName = " + paramString + " unreadChatListCount = " + ((dil)localObject).Hxo.size());
    AppMethodBeat.o(150955);
  }
  
  private aa(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150956);
    this.drf = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dil();
    ((b.a)localObject).hNN = new dim();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).funcId = 251;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dil)this.rr.hNK.hNQ;
    ((dil)localObject).ukj = u.aAm();
    ((dil)localObject).Hxm = paramInt;
    ((dil)localObject).uki = paramString1;
    ((dil)localObject).Fwt = System.currentTimeMillis();
    ((dil)localObject).Hxp = new dik();
    ((dil)localObject).Hxp.Name = paramString2;
    ((dil)localObject).Hxp.Hxl = paramString3;
    AppMethodBeat.o(150956);
  }
  
  public static void R(bu parambu)
  {
    AppMethodBeat.i(150952);
    g.ajD();
    if (!((Boolean)g.ajC().ajl().get(al.a.Ixt, Boolean.TRUE)).booleanValue())
    {
      ad.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
      AppMethodBeat.o(150952);
      return;
    }
    if (imz.contains(Long.valueOf(parambu.field_msgId)))
    {
      ad.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", new Object[] { Long.valueOf(parambu.field_msgId), Long.valueOf(parambu.field_msgId) });
      AppMethodBeat.o(150952);
      return;
    }
    imz.add(Long.valueOf(parambu.field_msgId));
    if (!g.ajA().aiK())
    {
      AppMethodBeat.o(150952);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<![CDATA[<downloadList>");
    localStringBuilder.append("<downloadItem>");
    localStringBuilder.append("<username>");
    localStringBuilder.append(parambu.field_talker);
    localStringBuilder.append("</username>");
    localStringBuilder.append("<msgsvrid>");
    localStringBuilder.append(parambu.field_msgSvrId);
    localStringBuilder.append("</msgsvrid>");
    localStringBuilder.append("</downloadItem>");
    localStringBuilder.append("</downloadList>]]>");
    String str = localStringBuilder.toString();
    ad.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", new Object[] { Long.valueOf(parambu.field_msgId), localStringBuilder });
    parambu = new aa(u.aAm(), 11, "DownloadFile", str);
    g.ajB().gAO.a(parambu, 0);
    AppMethodBeat.o(150952);
  }
  
  public static void aq(String paramString, int paramInt)
  {
    AppMethodBeat.i(150951);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150951);
      return;
    }
    if ((!g.ajA().aiK()) || ((w.Ap(paramString)) && (!w.zI(paramString))))
    {
      AppMethodBeat.o(150951);
      return;
    }
    paramString = new aa(paramString, paramInt, 0, null);
    g.ajB().gAO.a(paramString, 0);
    AppMethodBeat.o(150951);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150953);
    if ((bt.isNullOrNil(paramString1)) || (w.Ap(paramString1)))
    {
      AppMethodBeat.o(150953);
      return;
    }
    if (!g.ajA().aiK())
    {
      AppMethodBeat.o(150953);
      return;
    }
    paramString1 = new aa(paramString1, paramInt, paramString2, paramString3);
    g.ajB().gAO.a(paramString1, 0);
    AppMethodBeat.o(150953);
  }
  
  public static void bv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150954);
    if (!g.ajA().aiK())
    {
      AppMethodBeat.o(150954);
      return;
    }
    if (!bt.isNullOrNil(paramString1))
    {
      paramString1 = new aa(u.aAm(), 11, paramString2, paramString1);
      g.ajB().gAO.a(paramString1, 0);
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
      ad.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.drf);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.aa
 * JD-Core Version:    0.7.0.1
 */