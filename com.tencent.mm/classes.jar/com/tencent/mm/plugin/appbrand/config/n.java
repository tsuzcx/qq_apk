package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.networking.b;
import com.tencent.mm.protocal.protobuf.eie;
import com.tencent.mm.protocal.protobuf.ku;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class n
  extends b<kv>
{
  public n(String paramString)
  {
    super((byte)0);
    AppMethodBeat.i(222220);
    ku localku = new ku();
    localku.Scene = a.kbZ.intValue;
    eie localeie = new eie();
    localeie.phf = paramString;
    localku.FUO.add(localeie);
    a(localku);
    AppMethodBeat.o(222220);
  }
  
  n(List<String> paramList, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(44852);
    ae.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(paramList.size()), parama.name(), Integer.valueOf(parama.intValue) });
    ku localku = new ku();
    localku.Scene = parama.intValue;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      parama = (String)paramList.next();
      if (!bu.isNullOrNil(parama))
      {
        eie localeie = new eie();
        localeie.Hhh = parama;
        localeie.FZb = j.aZl().Oe(parama);
        localku.FUO.add(localeie);
      }
    }
    a(localku);
    AppMethodBeat.o(44852);
  }
  
  private void a(ku paramku)
  {
    AppMethodBeat.i(222221);
    b.a locala = new b.a();
    locala.hQF = paramku;
    locala.hQG = new kv();
    locala.funcId = 1192;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    c(locala.aDS());
    AppMethodBeat.o(222221);
  }
  
  public static enum a
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(44851);
      kbM = new a("DEFAULT", 0, 100);
      kbN = new a("RECENTS_LIST", 1, 101);
      kbO = new a("TASK_BAR", 2, 102);
      kbP = new a("STAR_LIST", 3, 103);
      kbQ = new a("MP_PRELOAD", 4, 104);
      kbR = new a("BIZ_BIND_WXA", 5, 105);
      kbS = new a("WXA_CUSTOMER_SERVICE", 6, 106);
      kbT = new a("WXA_PLUGIN_JSAPI", 7, 107);
      kbU = new a("WXA_RECOMMEND_LIST", 8, 108);
      kbV = new a("WXA_RECOMMEND_CARD_LIST", 9, 109);
      kbW = new a("WALLET_MALL_INDEX", 10, 110);
      kbX = new a("CHATTING", 11, 111);
      kbY = new a("QRCODE", 12, 112);
      kbZ = new a("QRCODE_PRE", 13, 113);
      kca = new a[] { kbM, kbN, kbO, kbP, kbQ, kbR, kbS, kbT, kbU, kbV, kbW, kbX, kbY, kbZ };
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