package com.tencent.mm.plugin.emoji.d;

import com.tencent.mm.a.o;
import com.tencent.mm.as.a.b.e;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.b.b;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.HttpURLConnection;

final class a$a
{
  private static u b(String paramString, b.b paramb)
  {
    u localu = com.tencent.mm.network.b.a(paramString, paramb);
    paramb = "";
    paramString = paramb;
    if (ae.cqV())
    {
      paramString = paramb;
      if (g.DK())
      {
        int i = d.spa;
        g.DN();
        paramString = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", new Object[] { Integer.valueOf(i), o.getString(a.CK()), Integer.valueOf(aq.getNetTypeForStat(ae.getContext())), Integer.valueOf(aq.getStrength(ae.getContext())) });
      }
    }
    y.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "referer %s ", new Object[] { paramString });
    localu.setRequestMethod("GET");
    localu.setRequestProperty("referer", paramString);
    localu.setConnectTimeout(15000);
    localu.setReadTimeout(20000);
    return localu;
  }
  
  public static com.tencent.mm.as.a.d.b c(String paramString, b.b paramb)
  {
    u localu2 = b(paramString, paramb);
    if (localu2 == null) {
      y.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "open connection failed.");
    }
    u localu1 = localu2;
    b.b localb = paramb;
    if (localu2.getResponseCode() == 302) {}
    for (;;)
    {
      try
      {
        y.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "302 redirect: %s", new Object[] { paramString });
        String str = localu2.getHeaderField("location");
        localu1 = localu2;
        localb = paramb;
        if (!bk.bl(str)) {
          localb = new b.b(str);
        }
        int i;
        y.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", localException1, "httpURLConnectionGet 302 redirect", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localu2.aRG.disconnect();
          localu1 = b(str, localb);
          if (com.tencent.mm.network.b.a(localu1) == 0) {
            break;
          }
          i = localu1.getResponseCode();
          y.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", new Object[] { paramString, localb.ip, localb.ip, Integer.valueOf(localb.eNz), Integer.valueOf(i) });
          switch (i)
          {
          default: 
            h.nFQ.a(315L, 12L, 1L, false);
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
      localu1 = localu2;
      localObject = paramb;
      continue;
      h.nFQ.a(315L, 8L, 1L, false);
      continue;
      h.nFQ.a(315L, 9L, 1L, false);
      continue;
      h.nFQ.a(315L, 10L, 1L, false);
      continue;
      h.nFQ.a(315L, 11L, 1L, false);
    }
    paramb = localu1.getInputStream();
    if (paramb == null)
    {
      y.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", new Object[] { paramString });
      return null;
    }
    paramString = localu1.aRG.getContentType();
    paramb = e.a(paramb, false);
    localu1.aRG.disconnect();
    return new com.tencent.mm.as.a.d.b(paramb, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.d.a.a
 * JD-Core Version:    0.7.0.1
 */