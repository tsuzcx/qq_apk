package com.tencent.luggage.xweb_ext.extendplugin.b;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a
  implements c
{
  private com.tencent.luggage.xweb_ext.extendplugin.a.c cKC;
  private Map<String, b> cKD;
  private com.tencent.luggage.xweb_ext.extendplugin.c cKE;
  
  public a()
  {
    AppMethodBeat.i(139354);
    this.cKD = new ConcurrentHashMap();
    AppMethodBeat.o(139354);
  }
  
  private b b(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(221503);
      paramString1 = c(paramString1, paramInt, paramString2, paramBoolean);
      AppMethodBeat.o(221503);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private b c(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(221513);
    b localb2 = (b)this.cKD.get(paramString2);
    b localb1 = localb2;
    if (localb2 == null)
    {
      Log.e(getLogTag(), "getPluginHandler, key:%s, current no handler for this key", new Object[] { paramString2 });
      localb1 = localb2;
      if (this.cKC != null)
      {
        if (!paramBoolean) {
          break label172;
        }
        localb1 = this.cKC.ex(paramString1);
        if (localb1 == null) {
          break label152;
        }
        Log.w(getLogTag(), "getPluginHandler, key:%s, created new plugin handler(%s)", new Object[] { paramString2, Integer.valueOf(localb1.hashCode()) });
        localb1.setId(paramInt);
        localb1.setType(paramString1);
        localb1.a(this);
        this.cKD.put(paramString2, localb1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(221513);
      return localb1;
      label152:
      Log.e(getLogTag(), "getPluginHandler, key:%s, no handler for this key?", new Object[] { paramString2 });
      continue;
      label172:
      Log.i(getLogTag(), "getPluginHandler, key:%s, do not create handler", new Object[] { paramString2 });
      localb1 = localb2;
    }
  }
  
  private b f(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      AppMethodBeat.i(139360);
      paramString1 = c(paramString1, paramInt, paramString2, true);
      AppMethodBeat.o(139360);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(139355);
    String str = String.format(Locale.US, "%s(%s)", new Object[] { "MicroMsg.SameLayer.DefaultExtendPluginClientProxy", Integer.valueOf(hashCode()) });
    AppMethodBeat.o(139355);
    return str;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.c Ur()
  {
    return this.cKE;
  }
  
  public final String a(String paramString, int paramInt, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139356);
    String str = d.y(paramString, paramInt);
    boolean bool = b(paramString, parama);
    Log.i(getLogTag(), "handleJsApi, key:%s, jsapi:%s, createHandlerIfNeed: %b", new Object[] { str, parama.SS(), Boolean.valueOf(bool) });
    paramString = b(paramString, paramInt, str, bool);
    if (paramString == null)
    {
      Log.w(getLogTag(), "handleJsApi, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(139356);
      return "";
    }
    if (paramString.g(parama))
    {
      if (parama.SQ())
      {
        paramString = paramString.h(parama);
        AppMethodBeat.o(139356);
        return paramString;
      }
      paramString.h(parama);
      AppMethodBeat.o(139356);
      return "";
    }
    if (parama.SQ())
    {
      paramString = parama.er("ok");
      AppMethodBeat.o(139356);
      return paramString;
    }
    AppMethodBeat.o(139356);
    return "";
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a.c paramc)
  {
    this.cKC = paramc;
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.c paramc)
  {
    this.cKE = paramc;
  }
  
  protected boolean b(String paramString, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    return true;
  }
  
  public final void onPluginDestroy(String paramString, int paramInt)
  {
    AppMethodBeat.i(139358);
    String str = d.y(paramString, paramInt);
    Log.i(getLogTag(), "onPluginDestroy, key:%s", new Object[] { str });
    paramString = f(paramString, paramInt, str);
    if (paramString == null)
    {
      Log.w(getLogTag(), "onPluginDestroy, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(139358);
      return;
    }
    paramString.Tr();
    AppMethodBeat.o(139358);
  }
  
  public final void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139357);
    String str = d.y(paramString, paramInt);
    Log.i(getLogTag(), "onPluginReady, key:%s", new Object[] { str });
    paramString = f(paramString, paramInt, str);
    if (paramString == null)
    {
      Log.w(getLogTag(), "onPluginReady, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(139357);
      return;
    }
    Log.i(getLogTag(), "onPluginReady, key:%s, handler is ready", new Object[] { str });
    paramString.e(paramSurfaceTexture);
    AppMethodBeat.o(139357);
  }
  
  public final void onPluginScreenshotTaken(String paramString, int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(178851);
    String str = d.y(paramString, paramInt);
    Log.v(getLogTag(), "onPluginScreenshotTaken, key:%s", new Object[] { str });
    paramString = f(paramString, paramInt, str);
    if (paramString == null)
    {
      Log.w(getLogTag(), "onPluginScreenshotTaken, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(178851);
      return;
    }
    paramString.n(paramBitmap);
    AppMethodBeat.o(178851);
  }
  
  public final void onPluginTouch(String paramString, int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139359);
    String str = d.y(paramString, paramInt);
    Log.v(getLogTag(), "onPluginTouch, key:%s", new Object[] { str });
    paramString = f(paramString, paramInt, str);
    if (paramString == null)
    {
      Log.w(getLogTag(), "onPluginTouch, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(139359);
      return;
    }
    paramString.o(paramMotionEvent);
    AppMethodBeat.o(139359);
  }
  
  public final void z(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(221518);
      paramString = d.y(paramString, paramInt);
      Log.i(getLogTag(), "removePlugin, key:%s", new Object[] { paramString });
      this.cKD.remove(paramString);
      AppMethodBeat.o(221518);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.b.a
 * JD-Core Version:    0.7.0.1
 */