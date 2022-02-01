package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.efq;
import com.tencent.mm.protocal.protobuf.yu;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.y;
import java.util.LinkedList;

public final class w
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public w(String paramString1, int paramInt1, String paramString2, LinkedList<yu> paramLinkedList, int paramInt2, dbo paramdbo, dcu paramdcu)
  {
    AppMethodBeat.i(124120);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new yv();
    ((b.a)localObject).hNN = new yw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/clickcommand";
    ((b.a)localObject).funcId = 359;
    ((b.a)localObject).hNO = 176;
    ((b.a)localObject).respCmdId = 1000000176;
    this.rr = ((b.a)localObject).aDC();
    localObject = (yv)this.rr.hNK.hNQ;
    ((yv)localObject).FYt = paramInt1;
    ((yv)localObject).FYu = paramString2;
    ((yv)localObject).FGE = paramString1;
    ((yv)localObject).Fvn = bl.VW();
    ((yv)localObject).scene = paramInt2;
    ((yv)localObject).FEY = y.getSessionId();
    if (paramLinkedList != null) {
      ((yv)localObject).FYv = paramLinkedList;
    }
    if (paramdbo != null)
    {
      ((yv)localObject).FYw = paramdbo;
      ad.d("MicroMsg.NetSceneBizClickCommand", "SessionStat StayDuration=%d, UnreadCount=%d, UnreadDuration=%d, IndexInSessionList=%d, LatestMsgType=%d, MassSendUnreadCount=%d, TemplateUnreadCount=%d", new Object[] { Integer.valueOf(paramdbo.Hrn), Integer.valueOf(paramdbo.Hrp), Integer.valueOf(paramdbo.Hro), Integer.valueOf(paramdbo.Hrr), Integer.valueOf(paramdbo.Hrq), Integer.valueOf(paramdbo.Hrs), Integer.valueOf(paramdbo.Hrt) });
    }
    if (paramdcu != null)
    {
      ((yv)localObject).FYx = paramdcu;
      ad.d("MicroMsg.NetSceneBizClickCommand", "settingPageInfo Scene=%d, IsServiceWuRaoOpen=%d", new Object[] { Integer.valueOf(paramdcu.Scene), Integer.valueOf(paramdcu.HrC) });
    }
    ad.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d, scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, ((yv)localObject).Fvn, Integer.valueOf(((yv)localObject).FYv.size()), Integer.valueOf(paramInt2) });
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
      paramq = (yv)this.rr.hNK.hNQ;
      paramArrayOfByte = (yw)this.rr.hNL.hNQ;
      if ((paramq.FYt == 10) && (paramq.FGE != null) && (paramArrayOfByte.FYy != null) && (((l)g.ab(l.class)).azv().aTz(paramq.FGE) != null))
      {
        localObject2 = paramArrayOfByte.FYy;
        str1 = paramq.FGE;
        if ((localObject2 != null) && (!bt.isNullOrNil(((efq)localObject2).HQT)) && (!bt.isNullOrNil(((efq)localObject2).HQS))) {
          break label196;
        }
        ad.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg tips is null");
      }
    }
    for (;;)
    {
      if (paramArrayOfByte.FYy != null) {
        ad.d("MicroMsg.NetSceneBizClickCommand", "onGYNetEnd ClickType=%d", new Object[] { Integer.valueOf(paramq.FYt) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(124121);
      return;
      label196:
      if (((efq)localObject2).HQR != 1)
      {
        ad.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg %d", new Object[] { Integer.valueOf(((efq)localObject2).HQR) });
      }
      else
      {
        Object localObject1 = ((efq)localObject2).HQS;
        String str2 = ((efq)localObject2).HQT;
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
        localObject1 = new bu();
        ((bu)localObject1).tN(str1);
        ((bu)localObject1).kr(2);
        ((bu)localObject1).setType(10002);
        ((bu)localObject1).qA(bj.aCb());
        ((bu)localObject1).setContent(((StringBuffer)localObject2).toString());
        bj.v((bu)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.w
 * JD-Core Version:    0.7.0.1
 */