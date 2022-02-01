package com.tencent.luggage.game.b;

import android.content.Context;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b;
import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.nio.ByteBuffer;

final class b$a
  implements b
{
  private final String appId;
  private final p ciF;
  
  private b$a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130463);
    this.appId = paramAppBrandRuntime.mAppId;
    this.ciF = paramAppBrandRuntime.Fg();
    AppMethodBeat.o(130463);
  }
  
  public final com.github.henryye.nativeiv.b.b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(190397);
    paramImageDecodeConfig = new com.github.henryye.nativeiv.b.b.a();
    paramObject = (String)paramObject;
    if (this.ciF == null)
    {
      ad.e("MicroMsg.WAGameRuntimeFileSystemImageStreamFetcher", "fetch %s, appId[%s] fs NULL", new Object[] { paramObject, this.appId });
      paramImageDecodeConfig.errorMsg = aj.getContext().getString(2131757205);
      AppMethodBeat.o(190397);
      return paramImageDecodeConfig;
    }
    i locali = new i();
    l locall = this.ciF.b(paramObject, locali);
    if ((locall == l.jMv) && (locali.value != null)) {
      paramImageDecodeConfig.inputStream = new a((ByteBuffer)locali.value);
    }
    for (;;)
    {
      AppMethodBeat.o(190397);
      return paramImageDecodeConfig;
      ad.e("MicroMsg.WAGameRuntimeFileSystemImageStreamFetcher", "fetch %s, ret %s, appId[%s]", new Object[] { paramObject, locall.name(), this.appId });
      paramImageDecodeConfig.errorMsg = String.format(aj.getContext().getString(2131757119), new Object[] { locall.name() });
    }
  }
  
  public final boolean accept(Object paramObject)
  {
    return true;
  }
  
  public final String sP()
  {
    return "appbrand_file";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.b.b.a
 * JD-Core Version:    0.7.0.1
 */