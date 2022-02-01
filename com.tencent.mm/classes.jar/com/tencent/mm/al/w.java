package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.protocal.protobuf.fby;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;

public final class w
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public w(String paramString1, int paramInt1, String paramString2, LinkedList<aam> paramLinkedList, int paramInt2, dvm paramdvm, dws paramdws)
  {
    AppMethodBeat.i(124120);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new aan();
    ((d.a)localObject).iLO = new aao();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/clickcommand";
    ((d.a)localObject).funcId = 359;
    ((d.a)localObject).iLP = 176;
    ((d.a)localObject).respCmdId = 1000000176;
    this.rr = ((d.a)localObject).aXF();
    localObject = (aan)this.rr.iLK.iLR;
    ((aan)localObject).LlO = paramInt1;
    ((aan)localObject).LlP = paramString2;
    ((aan)localObject).KSV = paramString1;
    ((aan)localObject).KHq = br.ajw();
    ((aan)localObject).scene = paramInt2;
    ((aan)localObject).KRg = ab.getSessionId();
    if (paramLinkedList != null) {
      ((aan)localObject).LlQ = paramLinkedList;
    }
    if (paramdvm != null)
    {
      ((aan)localObject).LlR = paramdvm;
      Log.d("MicroMsg.NetSceneBizClickCommand", "SessionStat StayDuration=%d, UnreadCount=%d, UnreadDuration=%d, IndexInSessionList=%d, LatestMsgType=%d, MassSendUnreadCount=%d, TemplateUnreadCount=%d", new Object[] { Integer.valueOf(paramdvm.MWy), Integer.valueOf(paramdvm.MWA), Integer.valueOf(paramdvm.MWz), Integer.valueOf(paramdvm.MWC), Integer.valueOf(paramdvm.MWB), Integer.valueOf(paramdvm.MWD), Integer.valueOf(paramdvm.MWE) });
    }
    if (paramdws != null)
    {
      ((aan)localObject).LlS = paramdws;
      Log.d("MicroMsg.NetSceneBizClickCommand", "settingPageInfo Scene=%d, IsServiceWuRaoOpen=%d", new Object[] { Integer.valueOf(paramdws.Scene), Integer.valueOf(paramdws.MWN) });
    }
    Log.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d, scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, ((aan)localObject).KHq, Integer.valueOf(((aan)localObject).LlQ.size()), Integer.valueOf(paramInt2) });
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
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(124122);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124122);
    return i;
  }
  
  public final int getType()
  {
    return 359;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124121);
    Object localObject2;
    String str1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (aan)this.rr.iLK.iLR;
      paramArrayOfByte = (aao)this.rr.iLL.iLR;
      if ((params.LlO == 10) && (params.KSV != null) && (paramArrayOfByte.LlT != null) && (((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjY(params.KSV) != null))
      {
        localObject2 = paramArrayOfByte.LlT;
        str1 = params.KSV;
        if ((localObject2 != null) && (!Util.isNullOrNil(((fby)localObject2).Nyb)) && (!Util.isNullOrNil(((fby)localObject2).Nya))) {
          break label196;
        }
        Log.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg tips is null");
      }
    }
    for (;;)
    {
      if (paramArrayOfByte.LlT != null) {
        Log.d("MicroMsg.NetSceneBizClickCommand", "onGYNetEnd ClickType=%d", new Object[] { Integer.valueOf(params.LlO) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(124121);
      return;
      label196:
      if (((fby)localObject2).NxZ != 1)
      {
        Log.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg %d", new Object[] { Integer.valueOf(((fby)localObject2).NxZ) });
      }
      else
      {
        Object localObject1 = ((fby)localObject2).Nya;
        String str2 = ((fby)localObject2).Nyb;
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
        localObject1 = new ca();
        ((ca)localObject1).Cy(str1);
        ((ca)localObject1).nv(2);
        ((ca)localObject1).setType(10002);
        ((ca)localObject1).setCreateTime(bp.aVP());
        ((ca)localObject1).setContent(((StringBuffer)localObject2).toString());
        bp.x((ca)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.w
 * JD-Core Version:    0.7.0.1
 */