package com.tencent.luggage.game.b.a;

import android.content.Context;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b.a;
import com.tencent.luggage.wxa.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.nio.ByteBuffer;

public final class a
  extends d<d.b>
{
  private final String appId;
  private final r csT;
  
  public a(d.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(247358);
    this.appId = paramb.OI();
    this.csT = paramb.getFileSystem();
    AppMethodBeat.o(247358);
  }
  
  public final boolean V(Object paramObject)
  {
    return true;
  }
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(247366);
    paramImageDecodeConfig = new b.a();
    paramObject = (String)paramObject;
    if (this.csT == null)
    {
      Log.e("MicroMsg.AppBrandFileSystemImageStreamFetcher", "fetch %s, appId[%s] fs NULL", new Object[] { paramObject, this.appId });
      paramImageDecodeConfig.errorMsg = MMApplicationContext.getContext().getString(a.e.appbrand_game_image_stream_error_file_system);
      AppMethodBeat.o(247366);
      return paramImageDecodeConfig;
    }
    i locali = new i();
    m localm = this.csT.b(paramObject, locali);
    if ((localm == m.nMR) && (locali.value != null)) {
      paramImageDecodeConfig.aFw = new com.tencent.luggage.k.a((ByteBuffer)locali.value);
    }
    for (;;)
    {
      AppMethodBeat.o(247366);
      return paramImageDecodeConfig;
      Log.e("MicroMsg.AppBrandFileSystemImageStreamFetcher", "fetch %s, ret %s, appId[%s]", new Object[] { paramObject, localm.name(), this.appId });
      paramImageDecodeConfig.errorMsg = String.format(MMApplicationContext.getContext().getString(a.e.appbrand_game_image_stream_error_file_read), new Object[] { localm.name() });
    }
  }
  
  public final String qG()
  {
    return "appbrand_file";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.b.a.a
 * JD-Core Version:    0.7.0.1
 */