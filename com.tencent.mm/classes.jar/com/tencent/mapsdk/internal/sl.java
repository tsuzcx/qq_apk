package com.tencent.mapsdk.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetRequest.NetRequestBuilder;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.exception.NetErrorException;
import com.tencent.map.tools.net.exception.NetUnavailableException;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sl
  extends lc
{
  private Context a;
  private lh b;
  private String c;
  private String d;
  private VectorMap e;
  private gq f;
  
  public sl(sr paramsr)
  {
    AppMethodBeat.i(224032);
    this.b = new lh();
    this.c = "UNKNOW";
    this.d = "";
    this.a = paramsr.G();
    this.c = this.a.getClass().getSimpleName();
    this.a = this.a.getApplicationContext();
    this.e = ((VectorMap)paramsr.e_);
    this.f = paramsr.aB.d;
    AppMethodBeat.o(224032);
  }
  
  private String a(String paramString)
  {
    AppMethodBeat.i(224045);
    Object localObject1 = (dg)cj.a(dg.class);
    de localde = (de)cj.a(de.class);
    Object localObject3 = ((cs)((dg)localObject1).h()).getIndoorMapUrl();
    localObject1 = ((cr)localde.h()).getIndoorMapUrl();
    Object localObject2 = Uri.parse(paramString);
    Uri localUri = Uri.parse((String)localObject3);
    localObject3 = Uri.parse((String)localObject1);
    String str4 = gz.c(((Uri)localObject2).getAuthority());
    String str1 = gz.c(((Uri)localObject2).getPath());
    String str2 = gz.c(localUri.getPath());
    String str3 = gz.c(((Uri)localObject3).getPath());
    localObject1 = paramString;
    if (str4.equals(localUri.getAuthority())) {
      if (!str1.startsWith(str2))
      {
        localObject1 = paramString;
        if (!str1.startsWith(str3)) {}
      }
      else
      {
        if (!localde.b) {
          break label273;
        }
      }
    }
    label273:
    for (paramString = "https";; paramString = ((Uri)localObject2).getScheme())
    {
      localObject1 = ((Uri)localObject3).buildUpon().scheme(paramString).encodedPath(str1.replace(str2, str3)).encodedQuery(((Uri)localObject2).getQuery()).appendQueryParameter("type", "1").toString();
      localObject2 = (dn)cj.a(dn.class);
      paramString = (String)localObject1;
      if (localObject2 != null)
      {
        paramString = (String)localObject1;
        if (!((String)localObject1).endsWith(".jpg"))
        {
          paramString = (String)localObject1;
          if (!((String)localObject1).startsWith(((dn)localObject2).i())) {
            paramString = (String)localObject1 + this.d + gw.a(this.c);
          }
        }
      }
      AppMethodBeat.o(224045);
      return paramString;
    }
  }
  
  public final byte[] f(String paramString)
  {
    AppMethodBeat.i(224067);
    kh.b("TDZ", "download url : ".concat(String.valueOf(paramString)));
    if ((this.a == null) || (gz.a(paramString)))
    {
      AppMethodBeat.o(224067);
      return null;
    }
    if (!this.b.a(paramString))
    {
      AppMethodBeat.o(224067);
      return null;
    }
    if ((this.e != null) && (gz.a(this.d)) && (!gz.a(this.e.x()))) {
      this.d = ("&eng_ver=" + this.e.x());
    }
    Object localObject1 = (dg)cj.a(dg.class);
    de localde = (de)cj.a(de.class);
    Object localObject3 = ((cs)((dg)localObject1).h()).getIndoorMapUrl();
    localObject1 = ((cr)localde.h()).getIndoorMapUrl();
    Object localObject2 = Uri.parse(paramString);
    Uri localUri = Uri.parse((String)localObject3);
    localObject3 = Uri.parse((String)localObject1);
    String str4 = gz.c(((Uri)localObject2).getAuthority());
    String str1 = gz.c(((Uri)localObject2).getPath());
    String str2 = gz.c(localUri.getPath());
    String str3 = gz.c(((Uri)localObject3).getPath());
    localObject1 = paramString;
    if (str4.equals(localUri.getAuthority())) {
      if (!str1.startsWith(str2))
      {
        localObject1 = paramString;
        if (!str1.startsWith(str3)) {}
      }
      else
      {
        if (!localde.b) {
          break label426;
        }
      }
    }
    for (paramString = "https";; paramString = ((Uri)localObject2).getScheme())
    {
      localObject1 = ((Uri)localObject3).buildUpon().scheme(paramString).encodedPath(str1.replace(str2, str3)).encodedQuery(((Uri)localObject2).getQuery()).appendQueryParameter("type", "1").toString();
      localObject2 = (dn)cj.a(dn.class);
      paramString = (String)localObject1;
      if (localObject2 != null)
      {
        paramString = (String)localObject1;
        if (!((String)localObject1).endsWith(".jpg"))
        {
          paramString = (String)localObject1;
          if (!((String)localObject1).startsWith(((dn)localObject2).i())) {
            paramString = (String)localObject1 + this.d + gw.a(this.c);
          }
        }
      }
      kh.b("TDZ", "rectify url : ".concat(String.valueOf(paramString)));
      try
      {
        localObject1 = NetManager.getInstance().builder().url(paramString).userAgent("androidsdk").doGet();
        if (localObject1 != null) {
          break label512;
        }
        AppMethodBeat.o(224067);
        return null;
      }
      catch (Exception localException)
      {
        label426:
        if (!paramString.contains("/mvd_map")) {
          break;
        }
      }
    }
    int i;
    if ((localException instanceof NetUnavailableException)) {
      i = ((NetUnavailableException)localException).errorCode;
    }
    for (;;)
    {
      this.f.a().a(System.currentTimeMillis(), paramString.substring(paramString.indexOf('?') + 1), i);
      AppMethodBeat.o(224067);
      return null;
      if ((localException instanceof NetErrorException))
      {
        i = ((NetErrorException)localException).statusCode;
        continue;
        label512:
        if (!paramString.contains("qt=rtt")) {
          this.b.b(paramString);
        }
        paramString = localException.data;
        AppMethodBeat.o(224067);
        return paramString;
      }
      else
      {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.sl
 * JD-Core Version:    0.7.0.1
 */