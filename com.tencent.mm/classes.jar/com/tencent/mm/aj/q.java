package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.s;
import java.util.LinkedList;

public final class q
  extends m
  implements k
{
  private f callback;
  private b rr;
  
  public q(String paramString1, int paramInt1, String paramString2, LinkedList<to> paramLinkedList, int paramInt2, caf paramcaf, cbg paramcbg)
  {
    AppMethodBeat.i(11435);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new tp();
    ((b.a)localObject).fsY = new tq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/clickcommand";
    ((b.a)localObject).funcId = 359;
    ((b.a)localObject).reqCmdId = 176;
    ((b.a)localObject).respCmdId = 1000000176;
    this.rr = ((b.a)localObject).ado();
    localObject = (tp)this.rr.fsV.fta;
    ((tp)localObject).wMf = paramInt1;
    ((tp)localObject).wMg = paramString2;
    ((tp)localObject).wxM = paramString1;
    ((tp)localObject).woU = bh.aaQ();
    ((tp)localObject).scene = paramInt2;
    ((tp)localObject).wMi = s.getSessionId();
    if (paramLinkedList != null) {
      ((tp)localObject).wMh = paramLinkedList;
    }
    if (paramcaf != null)
    {
      ((tp)localObject).wMj = paramcaf;
      ab.d("MicroMsg.NetSceneBizClickCommand", "SessionStat StayDuration=%d, UnreadCount=%d, UnreadDuration=%d, IndexInSessionList=%d, LatestMsgType=%d, MassSendUnreadCount=%d, TemplateUnreadCount=%d", new Object[] { Integer.valueOf(paramcaf.xLI), Integer.valueOf(paramcaf.xLK), Integer.valueOf(paramcaf.xLJ), Integer.valueOf(paramcaf.xLM), Integer.valueOf(paramcaf.xLL), Integer.valueOf(paramcaf.xLN), Integer.valueOf(paramcaf.xLO) });
    }
    if (paramcbg != null)
    {
      ((tp)localObject).wMk = paramcbg;
      ab.d("MicroMsg.NetSceneBizClickCommand", "settingPageInfo Scene=%d, IsServiceWuRaoOpen=%d", new Object[] { Integer.valueOf(paramcbg.Scene), Integer.valueOf(paramcbg.xLY) });
    }
    ab.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d, scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, ((tp)localObject).woU, Integer.valueOf(((tp)localObject).wMh.size()), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(11435);
  }
  
  public q(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, (byte)0);
  }
  
  private q(String paramString1, String paramString2, byte paramByte)
  {
    this(paramString1, 1, paramString2, null, 0, null, null);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(11437);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(11437);
    return i;
  }
  
  public final int getType()
  {
    return 359;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(11436);
    Object localObject2;
    String str1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (tp)this.rr.fsV.fta;
      paramArrayOfByte = (tq)this.rr.fsW.fta;
      if ((paramq.wMf == 10) && (paramq.wxM != null) && (paramArrayOfByte.wMl != null) && (((j)g.E(j.class)).YF().arH(paramq.wxM) != null))
      {
        localObject2 = paramArrayOfByte.wMl;
        str1 = paramq.wxM;
        if ((localObject2 != null) && (!bo.isNullOrNil(((czf)localObject2).ygi)) && (!bo.isNullOrNil(((czf)localObject2).ygh))) {
          break label198;
        }
        ab.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg tips is null");
      }
    }
    for (;;)
    {
      if (paramArrayOfByte.wMl != null) {
        ab.d("MicroMsg.NetSceneBizClickCommand", "onGYNetEnd ClickType=%d", new Object[] { Integer.valueOf(paramq.wMf) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(11436);
      return;
      label198:
      if (((czf)localObject2).ygg != 1)
      {
        ab.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg %d", new Object[] { Integer.valueOf(((czf)localObject2).ygg) });
      }
      else
      {
        Object localObject1 = ((czf)localObject2).ygh;
        String str2 = ((czf)localObject2).ygi;
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
        localObject1 = new bi();
        ((bi)localObject1).kj(str1);
        ((bi)localObject1).hL(2);
        ((bi)localObject1).setType(10002);
        ((bi)localObject1).fQ(bf.aaM());
        ((bi)localObject1).setContent(((StringBuffer)localObject2).toString());
        bf.l((bi)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aj.q
 * JD-Core Version:    0.7.0.1
 */