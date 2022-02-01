package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.networking.a;
import com.tencent.mm.protocal.protobuf.egn;
import com.tencent.mm.protocal.protobuf.ku;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends a<kv>
{
  n(List<String> paramList, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(44852);
    ad.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(paramList.size()), parama.name(), Integer.valueOf(parama.intValue) });
    ku localku = new ku();
    localku.Scene = parama.intValue;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      parama = (String)paramList.next();
      if (!bt.isNullOrNil(parama))
      {
        egn localegn = new egn();
        localegn.GNH = parama;
        localegn.FGF = j.aYP().Nw(parama);
        localku.FCt.add(localegn);
      }
    }
    paramList = new b.a();
    paramList.hNM = localku;
    paramList.hNN = new kv();
    paramList.funcId = 1192;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    c(paramList.aDC());
    AppMethodBeat.o(44852);
  }
  
  public static enum a
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(44851);
      jYx = new a("DEFAULT", 0, 100);
      jYy = new a("RECENTS_LIST", 1, 101);
      jYz = new a("TASK_BAR", 2, 102);
      jYA = new a("STAR_LIST", 3, 103);
      jYB = new a("MP_PRELOAD", 4, 104);
      jYC = new a("BIZ_BIND_WXA", 5, 105);
      jYD = new a("WXA_CUSTOMER_SERVICE", 6, 106);
      jYE = new a("WXA_PLUGIN_JSAPI", 7, 107);
      jYF = new a("WXA_RECOMMEND_LIST", 8, 108);
      jYG = new a("WXA_RECOMMEND_CARD_LIST", 9, 109);
      jYH = new a("WALLET_MALL_INDEX", 10, 110);
      jYI = new a("CHATTING", 11, 111);
      jYJ = new a("QRCODE", 12, 112);
      jYK = new a[] { jYx, jYy, jYz, jYA, jYB, jYC, jYD, jYE, jYF, jYG, jYH, jYI, jYJ };
      AppMethodBeat.o(44851);
    }
    
    private a(int paramInt)
    {
      this.intValue = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.n
 * JD-Core Version:    0.7.0.1
 */