package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static Map<String, c> lVj;
  private static Map<String, com.tencent.mm.sdk.b.c> lVk;
  private static ArrayList<String> lVl;
  private static Map<String, Boolean> lVm;
  
  static
  {
    AppMethodBeat.i(145783);
    lVj = new ConcurrentHashMap();
    lVk = new HashMap();
    lVl = new ArrayList();
    lVm = new ConcurrentHashMap();
    AppMethodBeat.o(145783);
  }
  
  public static void PR(String paramString)
  {
    AppMethodBeat.i(145776);
    ae.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
    b.PR(paramString);
    lVj.clear();
    Iterator localIterator = lVl.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (com.tencent.mm.sdk.b.c)lVk.remove(localObject);
      if (localObject != null) {
        com.tencent.mm.sdk.b.a.IvT.d((com.tencent.mm.sdk.b.c)localObject);
      }
    }
    lVk.clear();
    lVl.clear();
    lVm.remove(paramString);
    AppMethodBeat.o(145776);
  }
  
  public static c SV(String paramString)
  {
    AppMethodBeat.i(145778);
    paramString = (c)lVj.get(paramString);
    AppMethodBeat.o(145778);
    return paramString;
  }
  
  public static void SW(String paramString)
  {
    AppMethodBeat.i(145780);
    if (!lVk.containsKey(paramString))
    {
      ae.e("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(145780);
      return;
    }
    ae.d("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", new Object[] { paramString });
    lVl.remove(paramString);
    paramString = (com.tencent.mm.sdk.b.c)lVk.remove(paramString);
    if (paramString != null) {
      com.tencent.mm.sdk.b.a.IvT.d(paramString);
    }
    AppMethodBeat.o(145780);
  }
  
  public static boolean SX(String paramString)
  {
    AppMethodBeat.i(145781);
    if (!lVm.containsKey(paramString))
    {
      AppMethodBeat.o(145781);
      return false;
    }
    boolean bool = ((Boolean)lVm.get(paramString)).booleanValue();
    AppMethodBeat.o(145781);
    return bool;
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(145777);
    lVj.put(paramString, paramc);
    AppMethodBeat.o(145777);
  }
  
  public static void a(String paramString, com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(145779);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.Audio.AppBrandAudioClientService", "appId is empty");
      AppMethodBeat.o(145779);
      return;
    }
    if (paramc == null)
    {
      ae.e("MicroMsg.Audio.AppBrandAudioClientService", "listener is null");
      AppMethodBeat.o(145779);
      return;
    }
    if (lVk.containsKey(paramString)) {
      SW(paramString);
    }
    ae.d("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", new Object[] { paramString });
    lVk.put(paramString, paramc);
    if (!lVl.contains(paramString)) {
      lVl.add(paramString);
    }
    com.tencent.mm.sdk.b.a.IvT.b(paramc);
    AppMethodBeat.o(145779);
  }
  
  public static void av(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(145782);
    lVm.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(145782);
  }
  
  public static void onCreate(String paramString)
  {
    AppMethodBeat.i(145775);
    ae.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
    lVj.clear();
    b.onCreate(paramString);
    lVm.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(145775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.a
 * JD-Core Version:    0.7.0.1
 */