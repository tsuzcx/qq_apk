package com.tencent.mm.plugin.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.at.a.b.e;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.b.b;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.HttpURLConnection;

final class a$a
{
  private static v b(String paramString, b.b paramb)
  {
    AppMethodBeat.i(62334);
    v localv = com.tencent.mm.network.b.a(paramString, paramb);
    paramb = "";
    paramString = paramb;
    if (ah.brt())
    {
      paramString = paramb;
      if (g.RG())
      {
        int i = d.whH;
        g.RJ();
        paramString = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", new Object[] { Integer.valueOf(i), p.getString(a.getUin()), Integer.valueOf(at.getNetTypeForStat(ah.getContext())), Integer.valueOf(at.getStrength(ah.getContext())) });
      }
    }
    ab.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "referer %s ", new Object[] { paramString });
    localv.setRequestMethod("GET");
    localv.setRequestProperty("referer", paramString);
    localv.setConnectTimeout(15000);
    localv.setReadTimeout(20000);
    AppMethodBeat.o(62334);
    return localv;
  }
  
  public static com.tencent.mm.at.a.d.b c(String paramString, b.b paramb)
  {
    AppMethodBeat.i(62335);
    v localv2 = b(paramString, paramb);
    if (localv2 == null) {
      ab.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "open connection failed.");
    }
    v localv1 = localv2;
    b.b localb = paramb;
    if (localv2.getResponseCode() == 302) {}
    for (;;)
    {
      try
      {
        ab.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "302 redirect: %s", new Object[] { paramString });
        String str = localv2.getHeaderField("location");
        localv1 = localv2;
        localb = paramb;
        if (!bo.isNullOrNil(str)) {
          localb = new b.b(str);
        }
        int i;
        ab.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", localException1, "httpURLConnectionGet 302 redirect", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localv2.disconnect();
          localv1 = b(str, localb);
          if (com.tencent.mm.network.b.a(localv1) == 0) {
            break;
          }
          i = localv1.getResponseCode();
          ab.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", new Object[] { paramString, localb.ip, localb.ip, Integer.valueOf(localb.gdn), Integer.valueOf(i) });
          switch (i)
          {
          default: 
            h.qsU.idkeyStat(315L, 12L, 1L, false);
            i = localb.gdn;
            paramString = localb.ip;
            if ((i == 1) && (at.isConnected(ah.getContext()))) {
              com.tencent.mm.network.b.reportFailIp(paramString);
            }
            AppMethodBeat.o(62335);
            return null;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramb = (b.b)localObject;
            Object localObject = localException2;
          }
        }
        localException1 = localException1;
      }
      localv1 = localv2;
      localObject = paramb;
      continue;
      h.qsU.idkeyStat(315L, 8L, 1L, false);
      continue;
      h.qsU.idkeyStat(315L, 9L, 1L, false);
      continue;
      h.qsU.idkeyStat(315L, 10L, 1L, false);
      continue;
      h.qsU.idkeyStat(315L, 11L, 1L, false);
    }
    paramb = localv1.getInputStream();
    if (paramb == null)
    {
      ab.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", new Object[] { paramString });
      AppMethodBeat.o(62335);
      return null;
    }
    paramString = localv1.connection.getContentType();
    paramb = e.a(paramb, false);
    localv1.disconnect();
    paramString = new com.tencent.mm.at.a.d.b(paramb, paramString);
    AppMethodBeat.o(62335);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.d.a.a
 * JD-Core Version:    0.7.0.1
 */