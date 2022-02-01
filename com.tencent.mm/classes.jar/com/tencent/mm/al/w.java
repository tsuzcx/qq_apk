package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.dci;
import com.tencent.mm.protocal.protobuf.ddo;
import com.tencent.mm.protocal.protobuf.ehh;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.protocal.protobuf.yy;
import com.tencent.mm.protocal.protobuf.yz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.y;
import java.util.LinkedList;

public final class w
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public w(String paramString1, int paramInt1, String paramString2, LinkedList<yx> paramLinkedList, int paramInt2, dci paramdci, ddo paramddo)
  {
    AppMethodBeat.i(124120);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new yy();
    ((b.a)localObject).hQG = new yz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/clickcommand";
    ((b.a)localObject).funcId = 359;
    ((b.a)localObject).hQH = 176;
    ((b.a)localObject).respCmdId = 1000000176;
    this.rr = ((b.a)localObject).aDS();
    localObject = (yy)this.rr.hQD.hQJ;
    ((yy)localObject).GqS = paramInt1;
    ((yy)localObject).GqT = paramString2;
    ((yy)localObject).FZa = paramString1;
    ((yy)localObject).FNL = bn.We();
    ((yy)localObject).scene = paramInt2;
    ((yy)localObject).FXt = y.getSessionId();
    if (paramLinkedList != null) {
      ((yy)localObject).GqU = paramLinkedList;
    }
    if (paramdci != null)
    {
      ((yy)localObject).GqV = paramdci;
      ae.d("MicroMsg.NetSceneBizClickCommand", "SessionStat StayDuration=%d, UnreadCount=%d, UnreadDuration=%d, IndexInSessionList=%d, LatestMsgType=%d, MassSendUnreadCount=%d, TemplateUnreadCount=%d", new Object[] { Integer.valueOf(paramdci.HKP), Integer.valueOf(paramdci.HKR), Integer.valueOf(paramdci.HKQ), Integer.valueOf(paramdci.HKT), Integer.valueOf(paramdci.HKS), Integer.valueOf(paramdci.HKU), Integer.valueOf(paramdci.HKV) });
    }
    if (paramddo != null)
    {
      ((yy)localObject).GqW = paramddo;
      ae.d("MicroMsg.NetSceneBizClickCommand", "settingPageInfo Scene=%d, IsServiceWuRaoOpen=%d", new Object[] { Integer.valueOf(paramddo.Scene), Integer.valueOf(paramddo.HLe) });
    }
    ae.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d, scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, ((yy)localObject).FNL, Integer.valueOf(((yy)localObject).GqU.size()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(124120);
  }
  
  public w(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, (byte)0);
  }
  
  private w(String paramString1, String paramString2, byte paramByte)
  {
    this(paramString1, 1, paramString2, null, 0, null, null);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124122);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124122);
    return i;
  }
  
  public final int getType()
  {
    return 359;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124121);
    Object localObject2;
    String str1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (yy)this.rr.hQD.hQJ;
      paramArrayOfByte = (yz)this.rr.hQE.hQJ;
      if ((paramq.GqS == 10) && (paramq.FZa != null) && (paramArrayOfByte.GqX != null) && (((l)g.ab(l.class)).azL().aVa(paramq.FZa) != null))
      {
        localObject2 = paramArrayOfByte.GqX;
        str1 = paramq.FZa;
        if ((localObject2 != null) && (!bu.isNullOrNil(((ehh)localObject2).Ila)) && (!bu.isNullOrNil(((ehh)localObject2).IkZ))) {
          break label196;
        }
        ae.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg tips is null");
      }
    }
    for (;;)
    {
      if (paramArrayOfByte.GqX != null) {
        ae.d("MicroMsg.NetSceneBizClickCommand", "onGYNetEnd ClickType=%d", new Object[] { Integer.valueOf(paramq.GqS) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(124121);
      return;
      label196:
      if (((ehh)localObject2).IkY != 1)
      {
        ae.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg %d", new Object[] { Integer.valueOf(((ehh)localObject2).IkY) });
      }
      else
      {
        Object localObject1 = ((ehh)localObject2).IkZ;
        String str2 = ((ehh)localObject2).Ila;
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("<sysmsg type=\"biz_services_mute\">");
        ((StringBuffer)localObject2).append("<biz_services_mute>");
        ((StringBuffer)localObject2).append("<text><![CDATA[").append((String)localObject1).append("]]></text>");
        ((StringBuffer)localObject2).append("<link>");
        ((StringBuffer)localObject2).append("<scene>biz_services_mute</scene>");
        ((StringBuffer)localObject2).append("<text><![CDATA[").append(str2).append("]]></text>");
        ((StringBuffer)localObject2).append("</link>");
        ((StringBuffer)localObject2).append("</biz_services_mute>");
        ((StringBuffer)localObject2).append("</sysmsg>");
        localObject1 = new bv();
        ((bv)localObject1).ui(str1);
        ((bv)localObject1).kt(2);
        ((bv)localObject1).setType(10002);
        ((bv)localObject1).qN(bl.aCr());
        ((bv)localObject1).setContent(((StringBuffer)localObject2).toString());
        bl.v((bv)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.w
 * JD-Core Version:    0.7.0.1
 */