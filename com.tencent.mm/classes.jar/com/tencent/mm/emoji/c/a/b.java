package com.tencent.mm.emoji.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/cgi/CgiExchangeEmotionPack;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ExchangeEmotionPackResponse;", "groupId", "", "scene", "", "token", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.am.b<cjd>
{
  public static final b.a mil;
  
  static
  {
    AppMethodBeat.i(242659);
    mil = new b.a((byte)0);
    AppMethodBeat.o(242659);
  }
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(242658);
    cjc localcjc = new cjc();
    cjd localcjd = new cjd();
    localcjc.akkD = 1;
    localcjc.ProductID = paramString1;
    localcjc.IJG = 1;
    localcjc.ZvK = null;
    if (Util.isNullOrNil(paramString2)) {
      i = 0;
    }
    localcjc.IcB = i;
    localcjc.akkE = w.ak(paramString2, false);
    paramString1 = new c.a();
    paramString1.otE = ((a)localcjc);
    paramString1.otF = ((a)localcjd);
    paramString1.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
    paramString1.funcId = 423;
    paramString1.otG = 213;
    paramString1.respCmdId = 1000000213;
    c(paramString1.bEF());
    AppMethodBeat.o(242658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.a.b
 * JD-Core Version:    0.7.0.1
 */