package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends a<kg>
{
  n(List<String> paramList, a parama)
  {
    AppMethodBeat.i(44852);
    ad.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(paramList.size()), parama.name(), Integer.valueOf(parama.intValue) });
    kf localkf = new kf();
    localkf.Scene = parama.intValue;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      parama = (String)paramList.next();
      if (!bt.isNullOrNil(parama))
      {
        dus localdus = new dus();
        localdus.DII = parama;
        localdus.CIu = j.aOC().FZ(parama);
        localkf.CEx.add(localdus);
      }
    }
    paramList = new b.a();
    paramList.gUU = localkf;
    paramList.gUV = new kg();
    paramList.funcId = 1192;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    this.rr = paramList.atI();
    AppMethodBeat.o(44852);
  }
  
  public static enum a
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(44851);
      jeh = new a("DEFAULT", 0, 100);
      jei = new a("RECENTS_LIST", 1, 101);
      jej = new a("TASK_BAR", 2, 102);
      jek = new a("STAR_LIST", 3, 103);
      jel = new a("MP_PRELOAD", 4, 104);
      jem = new a("BIZ_BIND_WXA", 5, 105);
      jen = new a("WXA_CUSTOMER_SERVICE", 6, 106);
      jeo = new a("WXA_PLUGIN_JSAPI", 7, 107);
      jep = new a("WXA_RECOMMEND_LIST", 8, 108);
      jeq = new a("WXA_RECOMMEND_CARD_LIST", 9, 109);
      jer = new a("WALLET_MALL_INDEX", 10, 110);
      jes = new a("CHATTING", 11, 111);
      jet = new a("QRCODE", 12, 112);
      jeu = new a[] { jeh, jei, jej, jek, jel, jem, jen, jeo, jep, jeq, jer, jes, jet };
      AppMethodBeat.o(44851);
    }
    
    private a(int paramInt)
    {
      this.intValue = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.n
 * JD-Core Version:    0.7.0.1
 */