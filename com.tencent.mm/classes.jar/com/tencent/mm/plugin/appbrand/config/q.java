package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.l;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.protocal.protobuf.gkw;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class q
  extends com.tencent.mm.plugin.appbrand.networking.b<md>
{
  public q(String paramString)
  {
    super((byte)0);
    AppMethodBeat.i(323361);
    mc localmc = new mc();
    localmc.IJG = a.qZB.qDL;
    gkw localgkw = new gkw();
    localgkw.wYJ = paramString;
    localmc.YMH.add(localgkw);
    a(localmc);
    AppMethodBeat.o(323361);
  }
  
  q(List<String> paramList, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(44852);
    if ((BuildInfo.DEBUG) && (Util.isNullOrNil(paramList))) {
      Assert.fail("usernameList should not be null or nil!");
    }
    Log.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", new Object[] { Integer.valueOf(paramList.size()), parama.name(), Integer.valueOf(parama.qDL) });
    mc localmc = new mc();
    localmc.IJG = parama.qDL;
    parama = paramList.iterator();
    while (parama.hasNext())
    {
      paramList = (String)parama.next();
      if (!Util.isNullOrNil(paramList))
      {
        gkw localgkw = new gkw();
        localgkw.aaLU = paramList;
        paramList = n.cfc().d(paramList, ag.a.rbu);
        if (paramList == null)
        {
          paramList = new com.tencent.mm.bx.b(new byte[0]);
          label160:
          localgkw.YRt = paramList;
          localmc.YMH.add(localgkw);
          if (Log.getLogLevel() > 1) {
            continue;
          }
          paramList = localgkw.aaLU;
          if ((localgkw.YRt == null) || (localgkw.YRt.Op.length <= 0)) {
            break label317;
          }
        }
        label317:
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, username[%s], has cache?[%b]", new Object[] { paramList, Boolean.valueOf(bool) });
          break;
          if (ag.g(paramList))
          {
            paramList = new com.tencent.mm.bx.b(new byte[0]);
            break label160;
          }
          if (ag.h(paramList))
          {
            int i = ((l)n.ag(l.class)).VS(paramList.field_username);
            paramList = a.qJY;
            a.ac(i, 199L);
            paramList = new com.tencent.mm.bx.b(new byte[0]);
            break label160;
          }
          paramList = ac.d(paramList);
          break label160;
        }
      }
    }
    a(localmc);
    AppMethodBeat.o(44852);
  }
  
  private void a(mc parammc)
  {
    AppMethodBeat.i(323364);
    c.a locala = new c.a();
    locala.otE = parammc;
    locala.otF = new md();
    locala.funcId = 1192;
    locala.uri = at.rxA;
    c(locala.bEF());
    AppMethodBeat.o(323364);
  }
  
  public static enum a
  {
    public final int qDL;
    
    static
    {
      AppMethodBeat.i(44851);
      qZo = new a("DEFAULT", 0, 100);
      qZp = new a("RECENTS_LIST", 1, 101);
      qZq = new a("TASK_BAR", 2, 102);
      qZr = new a("STAR_LIST", 3, 103);
      qZs = new a("MP_PRELOAD", 4, 104);
      qZt = new a("BIZ_BIND_WXA", 5, 105);
      qZu = new a("WXA_CUSTOMER_SERVICE", 6, 106);
      qZv = new a("WXA_PLUGIN_JSAPI", 7, 107);
      qZw = new a("WXA_RECOMMEND_LIST", 8, 108);
      qZx = new a("WXA_RECOMMEND_CARD_LIST", 9, 109);
      qZy = new a("WALLET_MALL_INDEX", 10, 110);
      qZz = new a("CHATTING", 11, 111);
      qZA = new a("QRCODE", 12, 112);
      qZB = new a("QRCODE_PRE", 13, 113);
      qZC = new a("WX_OPEN_SDK_PRE_FETCH", 14, 114);
      qZD = new a[] { qZo, qZp, qZq, qZr, qZs, qZt, qZu, qZv, qZw, qZx, qZy, qZz, qZA, qZB, qZC };
      AppMethodBeat.o(44851);
    }
    
    private a(int paramInt)
    {
      this.qDL = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.q
 * JD-Core Version:    0.7.0.1
 */