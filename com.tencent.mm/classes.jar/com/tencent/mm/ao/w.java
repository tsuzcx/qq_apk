package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.protocal.protobuf.fmt;
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
  
  public w(String paramString1, int paramInt1, String paramString2, LinkedList<aar> paramLinkedList, int paramInt2, efo paramefo, egs paramegs)
  {
    AppMethodBeat.i(124120);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new aas();
    ((d.a)localObject).lBV = new aat();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/clickcommand";
    ((d.a)localObject).funcId = 359;
    ((d.a)localObject).lBW = 176;
    ((d.a)localObject).respCmdId = 1000000176;
    this.rr = ((d.a)localObject).bgN();
    localObject = (aas)d.b.b(this.rr.lBR);
    ((aas)localObject).SmY = paramInt1;
    ((aas)localObject).SmZ = paramString2;
    ((aas)localObject).RTS = paramString1;
    ((aas)localObject).RII = bs.apc();
    ((aas)localObject).scene = paramInt2;
    ((aas)localObject).RSi = ab.getSessionId();
    if (paramLinkedList != null) {
      ((aas)localObject).Sna = paramLinkedList;
    }
    if (paramefo != null)
    {
      ((aas)localObject).Snb = paramefo;
      Log.d("MicroMsg.NetSceneBizClickCommand", "SessionStat StayDuration=%d, UnreadCount=%d, UnreadDuration=%d, IndexInSessionList=%d, LatestMsgType=%d, MassSendUnreadCount=%d, TemplateUnreadCount=%d", new Object[] { Integer.valueOf(paramefo.UiT), Integer.valueOf(paramefo.UiV), Integer.valueOf(paramefo.UiU), Integer.valueOf(paramefo.UiX), Integer.valueOf(paramefo.UiW), Integer.valueOf(paramefo.UiY), Integer.valueOf(paramefo.UiZ) });
    }
    if (paramegs != null)
    {
      ((aas)localObject).Snc = paramegs;
      Log.d("MicroMsg.NetSceneBizClickCommand", "settingPageInfo Scene=%d, IsServiceWuRaoOpen=%d", new Object[] { Integer.valueOf(paramegs.CPw), Integer.valueOf(paramegs.Uji) });
    }
    Log.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d, scene %d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, ((aas)localObject).RII, Integer.valueOf(((aas)localObject).Sna.size()), Integer.valueOf(paramInt2) });
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
  
  public final int doScene(g paramg, i parami)
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
      params = (aas)d.b.b(this.rr.lBR);
      paramArrayOfByte = (aat)d.c.b(this.rr.lBS);
      if ((params.SmY == 10) && (params.RTS != null) && (paramArrayOfByte.Snd != null) && (((n)h.ae(n.class)).bbR().bwx(params.RTS) != null))
      {
        localObject2 = paramArrayOfByte.Snd;
        str1 = params.RTS;
        if ((localObject2 != null) && (!Util.isNullOrNil(((fmt)localObject2).ULv)) && (!Util.isNullOrNil(((fmt)localObject2).ULu))) {
          break label196;
        }
        Log.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg tips is null");
      }
    }
    for (;;)
    {
      if (paramArrayOfByte.Snd != null) {
        Log.d("MicroMsg.NetSceneBizClickCommand", "onGYNetEnd ClickType=%d", new Object[] { Integer.valueOf(params.SmY) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(124121);
      return;
      label196:
      if (((fmt)localObject2).ULt != 1)
      {
        Log.w("MicroMsg.NetSceneBizClickCommand", "insertReportLocationMsg %d", new Object[] { Integer.valueOf(((fmt)localObject2).ULt) });
      }
      else
      {
        Object localObject1 = ((fmt)localObject2).ULu;
        String str2 = ((fmt)localObject2).ULv;
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
        ((ca)localObject1).Jm(str1);
        ((ca)localObject1).pJ(2);
        ((ca)localObject1).setType(10002);
        ((ca)localObject1).setCreateTime(bq.beS());
        ((ca)localObject1).setContent(((StringBuffer)localObject2).toString());
        bq.z((ca)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.w
 * JD-Core Version:    0.7.0.1
 */