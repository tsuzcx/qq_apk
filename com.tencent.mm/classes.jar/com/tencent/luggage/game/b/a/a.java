package com.tencent.luggage.game.b.a;

import android.content.Context;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.nio.ByteBuffer;

public final class a
  extends c<c.b>
{
  private final String appId;
  private final q cuH;
  
  public a(c.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(222867);
    this.appId = paramb.LR();
    this.cuH = paramb.getFileSystem();
    AppMethodBeat.o(222867);
  }
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(222868);
    paramImageDecodeConfig = new b.a();
    paramObject = (String)paramObject;
    if (this.cuH == null)
    {
      Log.e("MicroMsg.AppBrandFileSystemImageStreamFetcher", "fetch %s, appId[%s] fs NULL", new Object[] { paramObject, this.appId });
      paramImageDecodeConfig.errorMsg = MMApplicationContext.getContext().getString(2131756067);
      AppMethodBeat.o(222868);
      return paramImageDecodeConfig;
    }
    i locali = new i();
    m localm = this.cuH.b(paramObject, locali);
    if ((localm == m.kSu) && (locali.value != null)) {
      paramImageDecodeConfig.inputStream = new com.tencent.luggage.h.a((ByteBuffer)locali.value);
    }
    for (;;)
    {
      AppMethodBeat.o(222868);
      return paramImageDecodeConfig;
      Log.e("MicroMsg.AppBrandFileSystemImageStreamFetcher", "fetch %s, ret %s, appId[%s]", new Object[] { paramObject, localm.name(), this.appId });
      paramImageDecodeConfig.errorMsg = String.format(MMApplicationContext.getContext().getString(2131756066), new Object[] { localm.name() });
    }
  }
  
  public final boolean accept(Object paramObject)
  {
    return true;
  }
  
  public final String sS()
  {
    return "appbrand_file";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.b.a.a
 * JD-Core Version:    0.7.0.1
 */