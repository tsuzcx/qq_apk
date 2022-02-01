package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.dtv;
import com.tencent.mm.protocal.protobuf.wk;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.wm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.u;
import java.util.LinkedList;

public final class v
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private b rr;
  
  public v(String paramString1, int paramInt1, String paramString2, LinkedList<wk> paramLinkedList, int paramInt2, cqu paramcqu, cry paramcry)
  {
    AppMethodBeat.i(124120);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new wl();
    ((b.a)localObject).gUV = new wm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/clickcommand";
    ((b.a)localObject).funcId = 359;
    ((b.a)localObject).reqCmdId = 176;
    ((b.a)localObject).respCmdId = 1000000176;
    this.rr = ((b.a)localObject).atI();
    localObject = (wl)this.rr.gUS.gUX;
    ((wl)localObject).CYz = paramInt1;
    ((wl)localObject).CYA = paramString2;
    ((wl)localObject).CIt = paramString1;
    ((wl)localObject).CxC = bk.SM();
    ((wl)localObject).scene = paramInt2;
    ((wl)localObject).CGZ = u.getSessionId();
    if (paramLinkedList != null) {
      ((wl)localObject).CYB = paramLinkedList;
    }
    if (paramcqu != null)
    {
      ((wl)localObject).CYC = paramcqu;
      ad.d("MicroMsg.NetSceneBizClickCommand", "SessionStat StayDuration=%d, UnreadCount=%d, UnreadDuration=%d, IndexInSessionList=%d, LatestMsgType=%d, MassSendUnreadCount=%d, TemplateUnreadCount=%d", new Object[] { Integer.valueOf(paramcqu.EjG), Integer.valueOf(paramcqu.EjI), Integer.valueOf(paramcqu.EjH), Integer.valueOf(paramcqu.EjK), Integer.valueOf(paramcqu.EjJ), Integer.valueOf(paramcqu.EjL), Integer.valueOf(paramcqu.EjM) });
    }
    if (paramcry != null)
    {
      ((wl)localObject).CYD = paramcry;
      ad.d("MicroMsg.NetSceneBizClickCommand", "settingPageInfo Scene=%d, IsServiceWuRaoOpen=%d", new Object[] { Integer.valueOf(paramcry.Scene), Integer.valueOf(paramcry.EjW) });
    }
    ad.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d, scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, ((wl)localObject).CxC, Integer.valueOf(((wl)localObject).CYB.size()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(124120);
  }
  
  public v(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, (byte)0);
  }
  
  private v(String paramString1, String paramString2, byte paramByte)
  {
    this(paramString1, 1, paramString2, null, 0, null, null);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(124122);
    this.callback = paramg;
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
      paramq = (wl)this.rr.gUS.gUX;
      paramArrayOfByte = (wm)this.rr.gUT.gUX;
      if ((paramq.CYz == 10) && (paramq.CIt != null) && (paramArrayOfByte.CYE != null) && (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIn(paramq.CIt) != null))
      {
        localObject2 = paramArrayOfByte.CYE;
        str1 = paramq.CIt;
        if ((localObject2 != null) && (!bt.isNullOrNil(((dtv)localObject2).EIy)) && (!bt.isNullOrNil(((dtv)localObject2).EIx))) {
          break label196;
        }
        ad.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg tips is null");
      }
    }
    for (;;)
    {
      if (paramArrayOfByte.CYE != null) {
        ad.d("MicroMsg.NetSceneBizClickCommand", "onGYNetEnd ClickType=%d", new Object[] { Integer.valueOf(paramq.CYz) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(124121);
      return;
      label196:
      if (((dtv)localObject2).EIw != 1)
      {
        ad.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg %d", new Object[] { Integer.valueOf(((dtv)localObject2).EIw) });
      }
      else
      {
        Object localObject1 = ((dtv)localObject2).EIx;
        String str2 = ((dtv)localObject2).EIy;
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
        localObject1 = new bl();
        ((bl)localObject1).nY(str1);
        ((bl)localObject1).jV(2);
        ((bl)localObject1).setType(10002);
        ((bl)localObject1).kY(bi.asg());
        ((bl)localObject1).setContent(((StringBuffer)localObject2).toString());
        bi.u((bl)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.v
 * JD-Core Version:    0.7.0.1
 */