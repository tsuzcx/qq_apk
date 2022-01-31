package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.protocal.protobuf.cgl;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.LinkedList;

public final class aa
  extends m
  implements k
{
  private static HashSet<Long> fQc;
  private f callback;
  private final com.tencent.mm.ai.b rr;
  private final String toUserName;
  
  static
  {
    AppMethodBeat.i(78608);
    fQc = new HashSet();
    AppMethodBeat.o(78608);
  }
  
  public aa(String paramString, int paramInt1, int paramInt2, LinkedList<cgm> paramLinkedList)
  {
    AppMethodBeat.i(78604);
    this.toUserName = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cgk();
    ((b.a)localObject).fsY = new cgl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).funcId = 251;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cgk)this.rr.fsV.fta;
    ((cgk)localObject).num = r.Zn();
    ((cgk)localObject).xRf = paramInt1;
    ((cgk)localObject).nul = paramString;
    ((cgk)localObject).wpS = System.currentTimeMillis();
    if ((paramLinkedList != null) && (paramLinkedList.size() == paramInt2))
    {
      ((cgk)localObject).xRg = paramInt2;
      ((cgk)localObject).xRh.addAll(paramLinkedList);
    }
    ab.d("MicroMsg.NetSceneStatusNotify", "summerstatus toUserName = " + paramString + " unreadChatListCount = " + ((cgk)localObject).xRh.size());
    AppMethodBeat.o(78604);
  }
  
  private aa(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78605);
    this.toUserName = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cgk();
    ((b.a)localObject).fsY = new cgl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/statusnotify";
    ((b.a)localObject).funcId = 251;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cgk)this.rr.fsV.fta;
    ((cgk)localObject).num = r.Zn();
    ((cgk)localObject).xRf = paramInt;
    ((cgk)localObject).nul = paramString1;
    ((cgk)localObject).wpS = System.currentTimeMillis();
    ((cgk)localObject).xRi = new cgj();
    ((cgk)localObject).xRi.Name = paramString2;
    ((cgk)localObject).xRi.xRe = paramString3;
    AppMethodBeat.o(78605);
  }
  
  public static void C(bi parambi)
  {
    AppMethodBeat.i(78602);
    g.RM();
    if (!((Boolean)g.RL().Ru().get(ac.a.yEG, Boolean.TRUE)).booleanValue())
    {
      ab.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
      AppMethodBeat.o(78602);
      return;
    }
    if (fQc.contains(Long.valueOf(parambi.field_msgId)))
    {
      ab.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", new Object[] { Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_msgId) });
      AppMethodBeat.o(78602);
      return;
    }
    fQc.add(Long.valueOf(parambi.field_msgId));
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(78602);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<![CDATA[<downloadList>");
    localStringBuilder.append("<downloadItem>");
    localStringBuilder.append("<username>");
    localStringBuilder.append(parambi.field_talker);
    localStringBuilder.append("</username>");
    localStringBuilder.append("<msgsvrid>");
    localStringBuilder.append(parambi.field_msgSvrId);
    localStringBuilder.append("</msgsvrid>");
    localStringBuilder.append("</downloadItem>");
    localStringBuilder.append("</downloadList>]]>");
    String str = localStringBuilder.toString();
    ab.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", new Object[] { Long.valueOf(parambi.field_msgId), localStringBuilder });
    parambi = new aa(r.Zn(), 11, "DownloadFile", str);
    g.RK().eHt.a(parambi, 0);
    AppMethodBeat.o(78602);
  }
  
  public static void ab(String paramString, int paramInt)
  {
    AppMethodBeat.i(78601);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78601);
      return;
    }
    if ((!g.RJ().QU()) || ((t.oD(paramString)) && (!t.nY(paramString))))
    {
      AppMethodBeat.o(78601);
      return;
    }
    paramString = new aa(paramString, paramInt, 0, null);
    g.RK().eHt.a(paramString, 0);
    AppMethodBeat.o(78601);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78603);
    if ((bo.isNullOrNil(paramString1)) || (t.oD(paramString1)))
    {
      AppMethodBeat.o(78603);
      return;
    }
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(78603);
      return;
    }
    paramString1 = new aa(paramString1, paramInt, paramString2, paramString3);
    g.RK().eHt.a(paramString1, 0);
    AppMethodBeat.o(78603);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(78606);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78606);
    return i;
  }
  
  public final int getType()
  {
    return 251;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78607);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ab.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.toUserName);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.aa
 * JD-Core Version:    0.7.0.1
 */