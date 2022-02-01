package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.networking.b;
import com.tencent.mm.protocal.protobuf.fnx;
import com.tencent.mm.protocal.protobuf.lb;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class o
  extends b<lc>
{
  public o(String paramString)
  {
    super((byte)0);
    AppMethodBeat.i(269987);
    lb locallb = new lb();
    locallb.CPw = a.nZt.intValue;
    fnx localfnx = new fnx();
    localfnx.tVp = paramString;
    locallb.RPu.add(localfnx);
    a(locallb);
    AppMethodBeat.o(269987);
  }
  
  o(List<String> paramList, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(44852);
    Log.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(paramList.size()), parama.name(), Integer.valueOf(parama.intValue) });
    lb locallb = new lb();
    locallb.CPw = parama.intValue;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      parama = (String)paramList.next();
      if (!Util.isNullOrNil(parama))
      {
        fnx localfnx = new fnx();
        localfnx.Txp = parama;
        localfnx.RTT = m.bFF().afb(parama);
        locallb.RPu.add(localfnx);
      }
    }
    a(locallb);
    AppMethodBeat.o(44852);
  }
  
  private void a(lb paramlb)
  {
    AppMethodBeat.i(269988);
    d.a locala = new d.a();
    locala.lBU = paramlb;
    locala.lBV = new lc();
    locala.funcId = 1192;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    c(locala.bgN());
    AppMethodBeat.o(269988);
  }
  
  public static enum a
  {
    final int intValue;
    
    static
    {
      AppMethodBeat.i(44851);
      nZg = new a("DEFAULT", 0, 100);
      nZh = new a("RECENTS_LIST", 1, 101);
      nZi = new a("TASK_BAR", 2, 102);
      nZj = new a("STAR_LIST", 3, 103);
      nZk = new a("MP_PRELOAD", 4, 104);
      nZl = new a("BIZ_BIND_WXA", 5, 105);
      nZm = new a("WXA_CUSTOMER_SERVICE", 6, 106);
      nZn = new a("WXA_PLUGIN_JSAPI", 7, 107);
      nZo = new a("WXA_RECOMMEND_LIST", 8, 108);
      nZp = new a("WXA_RECOMMEND_CARD_LIST", 9, 109);
      nZq = new a("WALLET_MALL_INDEX", 10, 110);
      nZr = new a("CHATTING", 11, 111);
      nZs = new a("QRCODE", 12, 112);
      nZt = new a("QRCODE_PRE", 13, 113);
      nZu = new a[] { nZg, nZh, nZi, nZj, nZk, nZl, nZm, nZn, nZo, nZp, nZq, nZr, nZs, nZt };
      AppMethodBeat.o(44851);
    }
    
    private a(int paramInt)
    {
      this.intValue = paramInt;
    }
    
    public final int intValue()
    {
      return this.intValue;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.o
 * JD-Core Version:    0.7.0.1
 */