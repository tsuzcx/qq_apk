package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cwb;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.protocal.protobuf.ww;
import com.tencent.mm.protocal.protobuf.wx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.LinkedList;

public final class v
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private b rr;
  
  public v(String paramString1, int paramInt1, String paramString2, LinkedList<wv> paramLinkedList, int paramInt2, cwb paramcwb, cxh paramcxh)
  {
    AppMethodBeat.i(124120);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ww();
    ((b.a)localObject).hvu = new wx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/clickcommand";
    ((b.a)localObject).funcId = 359;
    ((b.a)localObject).reqCmdId = 176;
    ((b.a)localObject).respCmdId = 1000000176;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ww)this.rr.hvr.hvw;
    ((ww)localObject).Erj = paramInt1;
    ((ww)localObject).Erk = paramString2;
    ((ww)localObject).EaV = paramString1;
    ((ww)localObject).DPY = com.tencent.mm.model.bk.TG();
    ((ww)localObject).scene = paramInt2;
    ((ww)localObject).DZA = com.tencent.mm.storage.v.getSessionId();
    if (paramLinkedList != null) {
      ((ww)localObject).Erl = paramLinkedList;
    }
    if (paramcwb != null)
    {
      ((ww)localObject).Erm = paramcwb;
      ac.d("MicroMsg.NetSceneBizClickCommand", "SessionStat StayDuration=%d, UnreadCount=%d, UnreadDuration=%d, IndexInSessionList=%d, LatestMsgType=%d, MassSendUnreadCount=%d, TemplateUnreadCount=%d", new Object[] { Integer.valueOf(paramcwb.FGE), Integer.valueOf(paramcwb.FGG), Integer.valueOf(paramcwb.FGF), Integer.valueOf(paramcwb.FGI), Integer.valueOf(paramcwb.FGH), Integer.valueOf(paramcwb.FGJ), Integer.valueOf(paramcwb.FGK) });
    }
    if (paramcxh != null)
    {
      ((ww)localObject).Ern = paramcxh;
      ac.d("MicroMsg.NetSceneBizClickCommand", "settingPageInfo Scene=%d, IsServiceWuRaoOpen=%d", new Object[] { Integer.valueOf(paramcxh.Scene), Integer.valueOf(paramcxh.FGU) });
    }
    ac.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d, scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, ((ww)localObject).DPY, Integer.valueOf(((ww)localObject).Erl.size()), Integer.valueOf(paramInt2) });
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
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
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
      paramq = (ww)this.rr.hvr.hvw;
      paramArrayOfByte = (wx)this.rr.hvs.hvw;
      if ((paramq.Erj == 10) && (paramq.EaV != null) && (paramArrayOfByte.Ero != null) && (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNI(paramq.EaV) != null))
      {
        localObject2 = paramArrayOfByte.Ero;
        str1 = paramq.EaV;
        if ((localObject2 != null) && (!bs.isNullOrNil(((dzm)localObject2).GfK)) && (!bs.isNullOrNil(((dzm)localObject2).GfJ))) {
          break label196;
        }
        ac.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg tips is null");
      }
    }
    for (;;)
    {
      if (paramArrayOfByte.Ero != null) {
        ac.d("MicroMsg.NetSceneBizClickCommand", "onGYNetEnd ClickType=%d", new Object[] { Integer.valueOf(paramq.Erj) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(124121);
      return;
      label196:
      if (((dzm)localObject2).GfI != 1)
      {
        ac.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg %d", new Object[] { Integer.valueOf(((dzm)localObject2).GfI) });
      }
      else
      {
        Object localObject1 = ((dzm)localObject2).GfJ;
        String str2 = ((dzm)localObject2).GfK;
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
        localObject1 = new bo();
        ((bo)localObject1).re(str1);
        ((bo)localObject1).jT(2);
        ((bo)localObject1).setType(10002);
        ((bo)localObject1).oA(bi.ayX());
        ((bo)localObject1).setContent(((StringBuffer)localObject2).toString());
        bi.u((bo)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.v
 * JD-Core Version:    0.7.0.1
 */