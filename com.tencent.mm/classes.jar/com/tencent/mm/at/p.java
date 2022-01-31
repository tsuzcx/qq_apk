package com.tencent.mm.at;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  implements c.c
{
  List<p.c> fGO;
  p.c fGP;
  boolean fGQ;
  
  public p()
  {
    AppMethodBeat.i(78399);
    this.fGO = new LinkedList();
    this.fGP = null;
    this.fGQ = false;
    AppMethodBeat.o(78399);
  }
  
  static String tr(String paramString)
  {
    AppMethodBeat.i(78403);
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      if (bo.isNullOrNil(str))
      {
        ab.e("MicroMsg.UrlImageCacheService", "encode result is null: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(78403);
        return null;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      ab.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(78403);
      return null;
    }
    paramString = new StringBuilder();
    paramString.append(e.esI);
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
    paramString = paramString.toString();
    AppMethodBeat.o(78403);
    return paramString;
  }
  
  public final void B(Bitmap paramBitmap)
  {
    AppMethodBeat.i(78404);
    if (paramBitmap == null)
    {
      ab.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.fGP.url);
      this.fGP = null;
      ahI();
      AppMethodBeat.o(78404);
      return;
    }
    ab.i("MicroMsg.UrlImageCacheService", "load from %s successed", new Object[] { this.fGP.url });
    new p.2(this).execute(new p.b[] { new p.b(tr(this.fGP.url), paramBitmap) });
    if (!this.fGQ)
    {
      o.ahB();
      c.h(this.fGP.url, paramBitmap);
      this.fGP.fGS.i(this.fGP.url, paramBitmap);
    }
    this.fGP = null;
    ahI();
    AppMethodBeat.o(78404);
  }
  
  public final void a(String paramString, p.a parama)
  {
    AppMethodBeat.i(78400);
    if ((bo.isNullOrNil(paramString)) || (parama == null))
    {
      ab.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(78400);
      return;
    }
    if ((this.fGP != null) && (this.fGP.url.equals(paramString)) && (this.fGP.fGS == parama))
    {
      ab.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
      AppMethodBeat.o(78400);
      return;
    }
    Iterator localIterator = this.fGO.iterator();
    while (localIterator.hasNext())
    {
      p.c localc = (p.c)localIterator.next();
      if ((localc.url.equals(paramString)) && (localc.fGS == parama))
      {
        ab.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        AppMethodBeat.o(78400);
        return;
      }
    }
    this.fGO.add(new p.c(paramString, parama));
    ahI();
    AppMethodBeat.o(78400);
  }
  
  final void ahI()
  {
    AppMethodBeat.i(78402);
    for (;;)
    {
      if ((this.fGP != null) || (this.fGO.size() == 0))
      {
        ab.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
        AppMethodBeat.o(78402);
        return;
      }
      this.fGP = ((p.c)this.fGO.get(0));
      this.fGO.remove(0);
      this.fGQ = false;
      o.ahB();
      Bitmap localBitmap = c.lK(this.fGP.url);
      if (localBitmap == null) {
        break;
      }
      ab.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.fGP.url);
      if (!this.fGQ) {
        this.fGP.fGS.i(this.fGP.url, localBitmap);
      }
      this.fGP = null;
    }
    new p.1(this).execute(new String[] { this.fGP.url });
    AppMethodBeat.o(78402);
  }
  
  public final void b(String paramString, p.a parama)
  {
    AppMethodBeat.i(78401);
    if ((bo.isNullOrNil(paramString)) || (parama == null))
    {
      ab.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(78401);
      return;
    }
    if ((this.fGP != null) && (this.fGP.url.equals(paramString)) && (this.fGP.fGS == parama))
    {
      this.fGQ = true;
      ab.i("MicroMsg.UrlImageCacheService", "cancel task that is loading, url:%s", new Object[] { paramString });
      AppMethodBeat.o(78401);
      return;
    }
    Iterator localIterator = this.fGO.iterator();
    while (localIterator.hasNext())
    {
      p.c localc = (p.c)localIterator.next();
      if ((localc.url.equals(paramString)) && (localc.fGS == parama))
      {
        ab.i("MicroMsg.UrlImageCacheService", "cancel task, url:%s", new Object[] { paramString });
        this.fGO.remove(localc);
        AppMethodBeat.o(78401);
        return;
      }
    }
    AppMethodBeat.o(78401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.at.p
 * JD-Core Version:    0.7.0.1
 */