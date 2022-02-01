package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends a<km>
{
  n(List<String> paramList, a parama)
  {
    AppMethodBeat.i(44852);
    ac.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(paramList.size()), parama.name(), Integer.valueOf(parama.intValue) });
    kl localkl = new kl();
    localkl.Scene = parama.intValue;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      parama = (String)paramList.next();
      if (!bs.isNullOrNil(parama))
      {
        eaj localeaj = new eaj();
        localeaj.Fed = parama;
        localeaj.EaW = j.aVu().Kd(parama);
        localkl.DWX.add(localeaj);
      }
    }
    paramList = new b.a();
    paramList.hvt = localkl;
    paramList.hvu = new km();
    paramList.funcId = 1192;
    paramList.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    this.rr = paramList.aAz();
    AppMethodBeat.o(44852);
  }
  
  public static enum a
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(44851);
      jEv = new a("DEFAULT", 0, 100);
      jEw = new a("RECENTS_LIST", 1, 101);
      jEx = new a("TASK_BAR", 2, 102);
      jEy = new a("STAR_LIST", 3, 103);
      jEz = new a("MP_PRELOAD", 4, 104);
      jEA = new a("BIZ_BIND_WXA", 5, 105);
      jEB = new a("WXA_CUSTOMER_SERVICE", 6, 106);
      jEC = new a("WXA_PLUGIN_JSAPI", 7, 107);
      jED = new a("WXA_RECOMMEND_LIST", 8, 108);
      jEE = new a("WXA_RECOMMEND_CARD_LIST", 9, 109);
      jEF = new a("WALLET_MALL_INDEX", 10, 110);
      jEG = new a("CHATTING", 11, 111);
      jEH = new a("QRCODE", 12, 112);
      jEI = new a[] { jEv, jEw, jEx, jEy, jEz, jEA, jEB, jEC, jED, jEE, jEF, jEG, jEH };
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