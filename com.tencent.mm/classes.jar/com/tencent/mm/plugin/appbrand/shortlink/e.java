package com.tencent.mm.plugin.appbrand.shortlink;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ipc.a.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkRiskManager;", "", "()V", "IMAGE_WIDTH", "", "KEY_DATA", "", "KEY_DATA_MMKV_KEY", "KEY_LINK_URL", "QUALITY", "", "TAG", "uploadScreenshotToCdn", "", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "shortLink", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e nNT;
  
  static
  {
    AppMethodBeat.i(229363);
    nNT = new e();
    AppMethodBeat.o(229363);
  }
  
  public static void b(final ag paramag, final String paramString)
  {
    AppMethodBeat.i(229362);
    p.h(paramag, "pageView");
    p.h(paramString, "shortLink");
    Object localObject1 = paramag.bRB();
    Object localObject2 = new Matrix();
    p.g(localObject1, "screenshot");
    ((Matrix)localObject2).setScale(720.0F / ((Bitmap)localObject1).getWidth(), 720.0F / ((Bitmap)localObject1).getWidth());
    localObject1 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject2, true);
    localObject2 = new ByteArrayOutputStream();
    ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 10, (OutputStream)localObject2);
    localObject2 = ((ByteArrayOutputStream)localObject2).toByteArray();
    Log.i("MicroMsg.WxaShortLinkRiskManager", "data size %dBYTE", new Object[] { Integer.valueOf(localObject2.length) });
    localObject1 = new Bundle();
    Object localObject3 = a.lxe;
    p.g(localObject2, "data");
    localObject3 = a.aH((byte[])localObject2);
    if (((Boolean)((o)localObject3).first).booleanValue())
    {
      ((Bundle)localObject1).putString("data_mmkv_key", (String)((o)localObject3).second);
      Log.i("MicroMsg.WxaShortLinkRiskManager", "transfer data with mmkv");
    }
    for (;;)
    {
      ((Bundle)localObject1).putString("linkUrl", paramString);
      localObject2 = paramag.getRuntime();
      h.a(MainProcessIPCService.dkO, (Parcelable)localObject1, c.class, (d)new a((q)localObject2, paramag, paramString));
      AppMethodBeat.o(229362);
      return;
      ((Bundle)localObject1).putByteArray("data", (byte[])localObject2);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/shortlink/UploadResult;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements d<ResultType>
  {
    a(q paramq, ag paramag, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.e
 * JD-Core Version:    0.7.0.1
 */