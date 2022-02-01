package com.tencent.luggage.h.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.skyline.jni.ISkylineResourceLoader;
import com.tencent.skyline.jni.ISkylineResourceLoader.BitmapLoadCallback;
import com.tencent.skyline.jni.ISkylineResourceLoader.ResourceLoadCallback;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/wxa/SkylineResourceLoaderImpl;", "Lcom/tencent/skyline/jni/ISkylineResourceLoader;", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "getRuntime", "()Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "loadBitmap", "Landroid/graphics/Bitmap;", "url", "", "loadBitmapAsync", "", "path", "callback", "Lcom/tencent/skyline/jni/ISkylineResourceLoader$BitmapLoadCallback;", "loadResource", "", "loadResourceAsync", "Lcom/tencent/skyline/jni/ISkylineResourceLoader$ResourceLoadCallback;", "Companion", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements ISkylineResourceLoader
{
  public static final e.a ewm;
  private final com.tencent.luggage.sdk.e.d ewn;
  
  static
  {
    AppMethodBeat.i(220048);
    ewm = new e.a((byte)0);
    AppMethodBeat.o(220048);
  }
  
  public e(com.tencent.luggage.sdk.e.d paramd)
  {
    AppMethodBeat.i(220037);
    this.ewn = paramd;
    Log.i("Luggage.SkylineResourceLoaderImpl", this.ewn.mAppId + " init " + this.ewn);
    AppMethodBeat.o(220037);
  }
  
  private static final void a(e parame, String paramString, ISkylineResourceLoader.ResourceLoadCallback paramResourceLoadCallback)
  {
    AppMethodBeat.i(220041);
    kotlin.g.b.s.u(parame, "this$0");
    byte[] arrayOfByte = parame.loadResource(paramString);
    paramString = new StringBuilder("loadResourceAsync path:").append(paramString).append(": ");
    if (arrayOfByte == null) {}
    for (parame = null;; parame = Integer.valueOf(arrayOfByte.length))
    {
      Log.d("Luggage.SkylineResourceLoaderImpl", parame + " success");
      if (paramResourceLoadCallback != null) {
        paramResourceLoadCallback.onResourceLoaded(arrayOfByte);
      }
      AppMethodBeat.o(220041);
      return;
    }
  }
  
  public final Bitmap loadBitmap(String paramString)
  {
    return null;
  }
  
  public final void loadBitmapAsync(String paramString, ISkylineResourceLoader.BitmapLoadCallback paramBitmapLoadCallback) {}
  
  public final byte[] loadResource(String paramString)
  {
    AppMethodBeat.i(220068);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (n.bp((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(220068);
      return new byte[0];
    }
    if (n.U(paramString, "wxlibfile://", false))
    {
      localObject1 = this.ewn.ari().cbl();
      if (localObject1 == null)
      {
        Log.e("Luggage.SkylineResourceLoaderImpl", "loadResource fail: " + paramString + ", libReader is null");
        AppMethodBeat.o(220068);
        return new byte[0];
      }
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(220068);
        throw paramString;
      }
      localObject2 = paramString.substring(12);
      kotlin.g.b.s.s(localObject2, "(this as java.lang.String).substring(startIndex)");
      localObject1 = ((ICommLibReader)localObject1).Lh((String)localObject2);
      if (localObject1 == null)
      {
        Log.e("Luggage.SkylineResourceLoaderImpl", "loadResource, fileStream: " + paramString + " is null");
        AppMethodBeat.o(220068);
        return new byte[0];
      }
      paramString = com.tencent.mm.plugin.appbrand.af.d.T((InputStream)localObject1);
      AppMethodBeat.o(220068);
      return paramString;
    }
    localObject1 = (com.tencent.mm.plugin.appbrand.appcache.s)bl.R((AppBrandRuntime)this.ewn);
    if (localObject1 == null)
    {
      Log.e("Luggage.SkylineResourceLoaderImpl", "loadResource fail: " + paramString + ", pkgListReader is null");
      AppMethodBeat.o(220068);
      return new byte[0];
    }
    localObject1 = ((com.tencent.mm.plugin.appbrand.appcache.s)localObject1).Vd(paramString);
    if (localObject1 == null)
    {
      Log.e("Luggage.SkylineResourceLoaderImpl", "loadResource, fileStream: " + paramString + " is null");
      AppMethodBeat.o(220068);
      return new byte[0];
    }
    localObject1 = com.tencent.mm.plugin.appbrand.af.d.T((InputStream)localObject1);
    Object localObject2 = new StringBuilder("loadResource path:").append(paramString).append(": ");
    if (localObject1 == null) {}
    for (paramString = null;; paramString = Integer.valueOf(localObject1.length))
    {
      Log.i("Luggage.SkylineResourceLoaderImpl", paramString + " success");
      AppMethodBeat.o(220068);
      return localObject1;
    }
  }
  
  public final void loadResourceAsync(String paramString, ISkylineResourceLoader.ResourceLoadCallback paramResourceLoadCallback)
  {
    AppMethodBeat.i(220061);
    h.ahAA.bo(new e..ExternalSyntheticLambda0(this, paramString, paramResourceLoadCallback));
    AppMethodBeat.o(220061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.h.a.e
 * JD-Core Version:    0.7.0.1
 */