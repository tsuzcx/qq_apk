package com.tencent.mm.modelsimple;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aff;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

final class j$a
{
  static b a(a parama)
  {
    AppMethodBeat.i(78568);
    b.a locala = new b.a();
    locala.fsX = new aff();
    locala.fsY = new afg();
    switch (j.1.fOM[parama.ordinal()])
    {
    default: 
      locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
      locala.funcId = 226;
      locala.reqCmdId = 388;
      locala.respCmdId = 1000000388;
    }
    for (;;)
    {
      parama = locala.ado();
      AppMethodBeat.o(78568);
      return parama;
      locala.uri = "/cgi-bin/micromsg-bin/geta8key";
      locala.funcId = 233;
      locala.reqCmdId = 155;
      locala.respCmdId = 1000000155;
      continue;
      locala.uri = "/cgi-bin/micromsg-bin/mp-geta8key";
      locala.funcId = 238;
      locala.reqCmdId = 345;
      locala.respCmdId = 1000000345;
      continue;
      locala.uri = "/cgi-bin/micromsg-bin/pay-geta8key";
      locala.funcId = 835;
      locala.reqCmdId = 346;
      locala.respCmdId = 1000000346;
      continue;
      locala.uri = "/cgi-bin/micromsg-bin/minor-geta8key";
      locala.funcId = 812;
      locala.reqCmdId = 387;
      locala.respCmdId = 1000000387;
      continue;
      locala.uri = "/cgi-bin/micromsg-bin/3rd-geta8key";
      locala.funcId = 226;
      locala.reqCmdId = 388;
      locala.respCmdId = 1000000388;
    }
  }
  
  static a aa(String paramString, int paramInt)
  {
    AppMethodBeat.i(78569);
    if (paramInt == 5)
    {
      paramString = a.fOR;
      AppMethodBeat.o(78569);
      return paramString;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl reqUrl is null, getA8Key");
      paramString = a.fOO;
      AppMethodBeat.o(78569);
      return paramString;
    }
    try
    {
      Object localObject = Uri.parse(paramString);
      if (localObject == null)
      {
        paramString = a.fOS;
        AppMethodBeat.o(78569);
        return paramString;
      }
      String str = bo.nullAsNil(((Uri)localObject).getHost()).toLowerCase();
      if (bo.isNullOrNil(((Uri)localObject).getFragment())) {}
      for (localObject = "";; localObject = "#" + ((Uri)localObject).getFragment())
      {
        ab.d("MicroMsg.NetSceneGetA8Key", "get TypeFromUrl domain:%s, fragment:%s", new Object[] { str, localObject });
        if ((!str.equals("open.weixin.qq.com")) && (!str.equals("mp.weixin.qq.com")) && (!str.equals("mp.weixinbridge.com"))) {
          break;
        }
        paramString = a.fOP;
        AppMethodBeat.o(78569);
        return paramString;
      }
      if (((String)localObject).contains("wechat_pay"))
      {
        paramString = a.fOQ;
        AppMethodBeat.o(78569);
        return paramString;
      }
      if ((str.contains(".qq.com")) || (str.equals("qq.com")) || (str.contains(".wechat.com")) || (str.equals("wechat.com")) || (str.contains(".tenpay.com")) || (str.equals("tenpay.com")) || (str.contains(".url.cn")) || (str.equals("url.com")) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))))
      {
        paramString = a.fOO;
        AppMethodBeat.o(78569);
        return paramString;
      }
      paramString = a.fOS;
      AppMethodBeat.o(78569);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.NetSceneGetA8Key", "getTypeFromUrl parse uri fail %s", new Object[] { paramString.getMessage() });
      paramString = a.fOO;
      AppMethodBeat.o(78569);
    }
    return paramString;
  }
  
  static b d(b paramb)
  {
    AppMethodBeat.i(78570);
    aff localaff = (aff)paramb.fsV.fta;
    g.RM();
    String str1 = bo.nullAsNil((String)g.RL().Ru().get(46, null));
    localaff.wrT = new SKBuiltinBuffer_t().setBuffer(bo.apQ(str1));
    g.RM();
    String str2 = bo.nullAsNil((String)g.RL().Ru().get(72, null));
    localaff.wYg = new SKBuiltinBuffer_t().setBuffer(bo.apQ(str2));
    ab.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + str1 + " newa2=" + str2);
    AppMethodBeat.o(78570);
    return paramb;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(78567);
      fON = new a("AutoRoute", 0);
      fOO = new a("GetA8Key", 1);
      fOP = new a("MpGetA8Key", 2);
      fOQ = new a("PayGetA8Key", 3);
      fOR = new a("MinorGetA8Key", 4);
      fOS = new a("ThridGetA8Key", 5);
      fOT = new a[] { fON, fOO, fOP, fOQ, fOR, fOS };
      AppMethodBeat.o(78567);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.j.a
 * JD-Core Version:    0.7.0.1
 */