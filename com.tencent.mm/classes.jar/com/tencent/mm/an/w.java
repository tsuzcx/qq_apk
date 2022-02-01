package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.ezh;
import com.tencent.mm.protocal.protobuf.fas;
import com.tencent.mm.protocal.protobuf.gjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import java.util.LinkedList;

public final class w
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public w(String paramString1, int paramInt1, String paramString2, LinkedList<acr> paramLinkedList, int paramInt2, ezh paramezh, fas paramfas)
  {
    AppMethodBeat.i(124120);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new acs();
    ((c.a)localObject).otF = new act();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/clickcommand";
    ((c.a)localObject).funcId = 359;
    ((c.a)localObject).otG = 176;
    ((c.a)localObject).respCmdId = 1000000176;
    this.rr = ((c.a)localObject).bEF();
    localObject = (acs)c.b.b(this.rr.otB);
    ((acs)localObject).Zlk = paramInt1;
    ((acs)localObject).Zll = paramString2;
    ((acs)localObject).YRs = paramString1;
    ((acs)localObject).YFJ = bt.bCQ();
    ((acs)localObject).scene = paramInt2;
    ((acs)localObject).YPI = ad.getSessionId();
    if (paramLinkedList != null) {
      ((acs)localObject).Zlm = paramLinkedList;
    }
    if (paramezh != null)
    {
      ((acs)localObject).Zln = paramezh;
      Log.d("MicroMsg.NetSceneBizClickCommand", "SessionStat StayDuration=%d, UnreadCount=%d, UnreadDuration=%d, IndexInSessionList=%d, LatestMsgType=%d, MassSendUnreadCount=%d, TemplateUnreadCount=%d", new Object[] { Integer.valueOf(paramezh.abAs), Integer.valueOf(paramezh.abAu), Integer.valueOf(paramezh.abAt), Integer.valueOf(paramezh.abAw), Integer.valueOf(paramezh.abAv), Integer.valueOf(paramezh.abAx), Integer.valueOf(paramezh.abAy) });
    }
    if (paramfas != null)
    {
      ((acs)localObject).Zlo = paramfas;
      Log.d("MicroMsg.NetSceneBizClickCommand", "settingPageInfo Scene=%d, IsServiceWuRaoOpen=%d", new Object[] { Integer.valueOf(paramfas.IJG), Integer.valueOf(paramfas.abAN) });
    }
    Log.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d, scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, ((acs)localObject).YFJ, Integer.valueOf(((acs)localObject).Zlm.size()), Integer.valueOf(paramInt2) });
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
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(124122);
    this.callback = paramh;
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
      params = (acs)c.b.b(this.rr.otB);
      paramArrayOfByte = (act)c.c.b(this.rr.otC);
      if ((params.Zlk == 10) && (params.YRs != null) && (paramArrayOfByte.Zlp != null) && (((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(params.YRs) != null))
      {
        localObject2 = paramArrayOfByte.Zlp;
        str1 = params.YRs;
        if ((localObject2 != null) && (!Util.isNullOrNil(((gjl)localObject2).acfI)) && (!Util.isNullOrNil(((gjl)localObject2).acfH))) {
          break label193;
        }
        Log.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg tips is null");
      }
    }
    for (;;)
    {
      if (paramArrayOfByte.Zlp != null) {
        Log.d("MicroMsg.NetSceneBizClickCommand", "onGYNetEnd ClickType=%d", new Object[] { Integer.valueOf(params.Zlk) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(124121);
      return;
      label193:
      if (((gjl)localObject2).acfG != 1)
      {
        Log.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg %d", new Object[] { Integer.valueOf(((gjl)localObject2).acfG) });
      }
      else
      {
        Object localObject1 = ((gjl)localObject2).acfH;
        String str2 = ((gjl)localObject2).acfI;
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
        localObject1 = new cc();
        ((cc)localObject1).BS(str1);
        ((cc)localObject1).pI(2);
        ((cc)localObject1).setType(10002);
        ((cc)localObject1).setCreateTime(br.bCJ());
        ((cc)localObject1).setContent(((StringBuffer)localObject2).toString());
        br.B((cc)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.w
 * JD-Core Version:    0.7.0.1
 */