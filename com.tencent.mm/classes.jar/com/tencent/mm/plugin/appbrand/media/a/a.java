package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static Map<String, c> ioO;
  private static Map<String, com.tencent.mm.sdk.b.c> ioP;
  private static ArrayList<String> ioQ;
  private static Map<String, Boolean> ioR;
  
  static
  {
    AppMethodBeat.i(137803);
    ioO = new ConcurrentHashMap();
    ioP = new HashMap();
    ioQ = new ArrayList();
    ioR = new ConcurrentHashMap();
    AppMethodBeat.o(137803);
  }
  
  public static void BP(String paramString)
  {
    AppMethodBeat.i(137796);
    ab.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
    b.BP(paramString);
    ioO.clear();
    Iterator localIterator = ioQ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (com.tencent.mm.sdk.b.c)ioP.remove(localObject);
      if (localObject != null) {
        com.tencent.mm.sdk.b.a.ymk.d((com.tencent.mm.sdk.b.c)localObject);
      }
    }
    ioP.clear();
    ioQ.clear();
    ioR.remove(paramString);
    AppMethodBeat.o(137796);
  }
  
  public static c Dv(String paramString)
  {
    AppMethodBeat.i(137798);
    paramString = (c)ioO.get(paramString);
    AppMethodBeat.o(137798);
    return paramString;
  }
  
  public static void Dw(String paramString)
  {
    AppMethodBeat.i(137800);
    if (!ioP.containsKey(paramString))
    {
      ab.e("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(137800);
      return;
    }
    ab.d("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", new Object[] { paramString });
    ioQ.remove(paramString);
    paramString = (com.tencent.mm.sdk.b.c)ioP.remove(paramString);
    if (paramString != null) {
      com.tencent.mm.sdk.b.a.ymk.d(paramString);
    }
    AppMethodBeat.o(137800);
  }
  
  public static boolean Dx(String paramString)
  {
    AppMethodBeat.i(137801);
    if (!ioR.containsKey(paramString))
    {
      AppMethodBeat.o(137801);
      return false;
    }
    boolean bool = ((Boolean)ioR.get(paramString)).booleanValue();
    AppMethodBeat.o(137801);
    return bool;
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(137797);
    ioO.put(paramString, paramc);
    AppMethodBeat.o(137797);
  }
  
  public static void a(String paramString, com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(137799);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.Audio.AppBrandAudioClientService", "appId is empty");
      AppMethodBeat.o(137799);
      return;
    }
    if (paramc == null)
    {
      ab.e("MicroMsg.Audio.AppBrandAudioClientService", "listener is null");
      AppMethodBeat.o(137799);
      return;
    }
    if (ioP.containsKey(paramString)) {
      Dw(paramString);
    }
    ab.d("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", new Object[] { paramString });
    ioP.put(paramString, paramc);
    if (!ioQ.contains(paramString)) {
      ioQ.add(paramString);
    }
    com.tencent.mm.sdk.b.a.ymk.b(paramc);
    AppMethodBeat.o(137799);
  }
  
  public static void ap(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(137802);
    ioR.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(137802);
  }
  
  public static void onCreate(String paramString)
  {
    AppMethodBeat.i(137795);
    ab.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
    ioO.clear();
    b.onCreate(paramString);
    ioR.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(137795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.a
 * JD-Core Version:    0.7.0.1
 */