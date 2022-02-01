package com.tencent.luggage.game.b.a;

import android.content.Context;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b.a;
import com.tencent.luggage.wxa.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.nio.ByteBuffer;

public final class a
  extends d<d.b>
{
  private final String appId;
  private final w ekN;
  
  public a(d.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(220118);
    this.appId = paramb.aoQ();
    this.ekN = paramb.getFileSystem();
    AppMethodBeat.o(220118);
  }
  
  public final String Qj()
  {
    return "appbrand_file";
  }
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(220126);
    paramImageDecodeConfig = new b.a();
    paramObject = (String)paramObject;
    if (this.ekN == null)
    {
      Log.e("MicroMsg.AppBrandFileSystemImageStreamFetcher", "fetch %s, appId[%s] fs NULL", new Object[] { paramObject, this.appId });
      paramImageDecodeConfig.errorMsg = MMApplicationContext.getContext().getString(a.f.appbrand_game_image_stream_error_file_system);
      AppMethodBeat.o(220126);
      return paramImageDecodeConfig;
    }
    k localk = new k();
    r localr = this.ekN.b(paramObject, localk);
    if ((localr == r.qML) && (localk.value != null)) {
      paramImageDecodeConfig.inputStream = new com.tencent.luggage.l.a((ByteBuffer)localk.value);
    }
    for (;;)
    {
      AppMethodBeat.o(220126);
      return paramImageDecodeConfig;
      Log.e("MicroMsg.AppBrandFileSystemImageStreamFetcher", "fetch %s, ret %s, appId[%s]", new Object[] { paramObject, localr.name(), this.appId });
      paramImageDecodeConfig.errorMsg = String.format(MMApplicationContext.getContext().getString(a.f.appbrand_game_image_stream_error_file_read), new Object[] { localr.name() });
    }
  }
  
  public final boolean be(Object paramObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.b.a.a
 * JD-Core Version:    0.7.0.1
 */