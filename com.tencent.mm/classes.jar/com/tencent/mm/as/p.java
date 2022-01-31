package com.tencent.mm.as;

import android.graphics.Bitmap;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  implements c.c
{
  List<p.c> eqn = new LinkedList();
  p.c eqo = null;
  boolean eqp = false;
  
  static String mm(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      if (bk.bl(str))
      {
        y.e("MicroMsg.UrlImageCacheService", "encode result is null: " + paramString);
        return null;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      y.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: " + paramString);
      return null;
    }
    paramString = new StringBuilder();
    paramString.append(e.dzC);
    int j = localUnsupportedEncodingException.length();
    int i = 0;
    while (i < j)
    {
      paramString.append('/');
      if (i + 20 < j)
      {
        paramString.append(localUnsupportedEncodingException.substring(i, i + 20));
        i += 20;
      }
      else
      {
        paramString.append(localUnsupportedEncodingException.substring(i, j));
        i = j;
      }
    }
    return paramString.toString();
  }
  
  final void OP()
  {
    for (;;)
    {
      if ((this.eqo != null) || (this.eqn.size() == 0))
      {
        y.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
        return;
      }
      this.eqo = ((p.c)this.eqn.get(0));
      this.eqn.remove(0);
      this.eqp = false;
      o.OI();
      Bitmap localBitmap = c.jK(this.eqo.url);
      if (localBitmap == null) {
        break;
      }
      y.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.eqo.url);
      if (!this.eqp) {
        this.eqo.eqr.h(this.eqo.url, localBitmap);
      }
      this.eqo = null;
    }
    new p.1(this).execute(new String[] { this.eqo.url });
  }
  
  public final void a(String paramString, p.a parama)
  {
    if ((bk.bl(paramString)) || (parama == null))
    {
      y.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      return;
    }
    if ((this.eqo != null) && (this.eqo.url.equals(paramString)) && (this.eqo.eqr == parama))
    {
      y.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
      return;
    }
    Iterator localIterator = this.eqn.iterator();
    while (localIterator.hasNext())
    {
      p.c localc = (p.c)localIterator.next();
      if ((localc.url.equals(paramString)) && (localc.eqr == parama))
      {
        y.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        return;
      }
    }
    this.eqn.add(new p.c(paramString, parama));
    OP();
  }
  
  public final void t(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      y.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.eqo.url);
      this.eqo = null;
      OP();
      return;
    }
    y.i("MicroMsg.UrlImageCacheService", "load from %s successed", new Object[] { this.eqo.url });
    new p.2(this).execute(new p.b[] { new p.b(mm(this.eqo.url), paramBitmap) });
    if (!this.eqp)
    {
      o.OI();
      c.g(this.eqo.url, paramBitmap);
      this.eqo.eqr.h(this.eqo.url, paramBitmap);
    }
    this.eqo = null;
    OP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.as.p
 * JD-Core Version:    0.7.0.1
 */