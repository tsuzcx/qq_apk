package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.networking.b;
import com.tencent.mm.protocal.protobuf.fcw;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class o
  extends b<lm>
{
  public o(String paramString)
  {
    super((byte)0);
    AppMethodBeat.i(226461);
    ll localll = new ll();
    localll.Scene = a.lfg.intValue;
    fcw localfcw = new fcw();
    localfcw.qwo = paramString;
    localll.KOw.add(localfcw);
    a(localll);
    AppMethodBeat.o(226461);
  }
  
  o(List<String> paramList, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(44852);
    Log.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(paramList.size()), parama.name(), Integer.valueOf(parama.intValue) });
    ll localll = new ll();
    localll.Scene = parama.intValue;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      parama = (String)paramList.next();
      if (!Util.isNullOrNil(parama))
      {
        fcw localfcw = new fcw();
        localfcw.Mmv = parama;
        localfcw.KSW = n.buC().Xp(parama);
        localll.KOw.add(localfcw);
      }
    }
    a(localll);
    AppMethodBeat.o(44852);
  }
  
  private void a(ll paramll)
  {
    AppMethodBeat.i(226462);
    d.a locala = new d.a();
    locala.iLN = paramll;
    locala.iLO = new lm();
    locala.funcId = 1192;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    c(locala.aXF());
    AppMethodBeat.o(226462);
  }
  
  public static enum a
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(44851);
      leT = new a("DEFAULT", 0, 100);
      leU = new a("RECENTS_LIST", 1, 101);
      leV = new a("TASK_BAR", 2, 102);
      leW = new a("STAR_LIST", 3, 103);
      leX = new a("MP_PRELOAD", 4, 104);
      leY = new a("BIZ_BIND_WXA", 5, 105);
      leZ = new a("WXA_CUSTOMER_SERVICE", 6, 106);
      lfa = new a("WXA_PLUGIN_JSAPI", 7, 107);
      lfb = new a("WXA_RECOMMEND_LIST", 8, 108);
      lfc = new a("WXA_RECOMMEND_CARD_LIST", 9, 109);
      lfd = new a("WALLET_MALL_INDEX", 10, 110);
      lfe = new a("CHATTING", 11, 111);
      lff = new a("QRCODE", 12, 112);
      lfg = new a("QRCODE_PRE", 13, 113);
      lfh = new a[] { leT, leU, leV, leW, leX, leY, leZ, lfa, lfb, lfc, lfd, lfe, lff, lfg };
      AppMethodBeat.o(44851);
    }
    
    private a(int paramInt)
    {
      this.intValue = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.o
 * JD-Core Version:    0.7.0.1
 */