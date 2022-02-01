package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetRequest.NetRequestBuilder;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import java.net.MalformedURLException;
import java.net.URL;

public final class rk
  extends OverSeaTileProvider
{
  private rr a;
  private gq b;
  private Language c = Language.zh;
  private OverSeaSource d;
  
  public rk(rr paramrr, OverSeaSource paramOverSeaSource, gq paramgq)
  {
    super(paramrr.a, paramrr.d);
    this.b = paramgq;
    this.d = paramOverSeaSource;
    this.a = paramrr;
  }
  
  public final Bitmap getLogo(boolean paramBoolean)
  {
    return null;
  }
  
  public final URL getTileUrl(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(223138);
    rr localrr = this.a;
    String str = this.c.name();
    Object localObject1 = localrr.e;
    int[] arrayOfInt = localrr.f;
    if (arrayOfInt.length == 0)
    {
      localObject1 = ((String)localObject1).replaceFirst("\\{range\\}", "");
      localObject1 = ((String)localObject1).replaceFirst("\\{z\\}", Integer.toString(paramInt3)).replaceFirst("\\{x\\}", Integer.toString(paramInt1)).replaceFirst("\\{y\\}", Integer.toString(paramInt2)).replaceFirst("\\{style\\}", Integer.toString(localrr.b)).replaceFirst("\\{scene\\}", Integer.toString(localrr.c)).replaceFirst("\\{version\\}", Integer.toString(localrr.d)).replaceFirst("\\{ch\\}", str);
      if (localObject1 == null) {
        break label201;
      }
      kh.c("TO", "请求海外图瓦片：".concat(String.valueOf(localObject1)));
    }
    for (;;)
    {
      try
      {
        localObject1 = new URL((String)localObject1);
        AppMethodBeat.o(223138);
        return localObject1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        kh.c(Log.getStackTraceString(localMalformedURLException));
      }
      localObject1 = ((String)localObject1).replaceFirst("\\{range\\}", Integer.toString(rr.a(paramInt1 + paramInt2, arrayOfInt.length)));
      break;
      label201:
      Object localObject2 = null;
    }
  }
  
  public final boolean onLanguageChange(Language paramLanguage)
  {
    this.c = paramLanguage;
    return false;
  }
  
  public final NetResponse requestTileData(String paramString)
  {
    AppMethodBeat.i(223125);
    Object localObject = null;
    NetResponse localNetResponse = NetManager.getInstance().builder().url(paramString).doGet();
    paramString = localObject;
    if (localNetResponse != null) {
      paramString = localNetResponse.data;
    }
    if ((paramString != null) && (paramString.length != 0) && (this.b != null)) {
      switch (1.a[this.d.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(223125);
      return localNetResponse;
      paramString = this.b.b();
      paramString.a += 1;
      continue;
      paramString = this.b.b();
      paramString.b += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rk
 * JD-Core Version:    0.7.0.1
 */