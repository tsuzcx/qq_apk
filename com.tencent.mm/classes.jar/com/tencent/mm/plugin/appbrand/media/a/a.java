package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static Map<String, c> lQI;
  private static Map<String, com.tencent.mm.sdk.b.c> lQJ;
  private static ArrayList<String> lQK;
  private static Map<String, Boolean> lQL;
  
  static
  {
    AppMethodBeat.i(145783);
    lQI = new ConcurrentHashMap();
    lQJ = new HashMap();
    lQK = new ArrayList();
    lQL = new ConcurrentHashMap();
    AppMethodBeat.o(145783);
  }
  
  public static void Pj(String paramString)
  {
    AppMethodBeat.i(145776);
    ad.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
    b.Pj(paramString);
    lQI.clear();
    Iterator localIterator = lQK.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (com.tencent.mm.sdk.b.c)lQJ.remove(localObject);
      if (localObject != null) {
        com.tencent.mm.sdk.b.a.IbL.d((com.tencent.mm.sdk.b.c)localObject);
      }
    }
    lQJ.clear();
    lQK.clear();
    lQL.remove(paramString);
    AppMethodBeat.o(145776);
  }
  
  public static c Sm(String paramString)
  {
    AppMethodBeat.i(145778);
    paramString = (c)lQI.get(paramString);
    AppMethodBeat.o(145778);
    return paramString;
  }
  
  public static void Sn(String paramString)
  {
    AppMethodBeat.i(145780);
    if (!lQJ.containsKey(paramString))
    {
      ad.e("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(145780);
      return;
    }
    ad.d("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", new Object[] { paramString });
    lQK.remove(paramString);
    paramString = (com.tencent.mm.sdk.b.c)lQJ.remove(paramString);
    if (paramString != null) {
      com.tencent.mm.sdk.b.a.IbL.d(paramString);
    }
    AppMethodBeat.o(145780);
  }
  
  public static boolean So(String paramString)
  {
    AppMethodBeat.i(145781);
    if (!lQL.containsKey(paramString))
    {
      AppMethodBeat.o(145781);
      return false;
    }
    boolean bool = ((Boolean)lQL.get(paramString)).booleanValue();
    AppMethodBeat.o(145781);
    return bool;
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(145777);
    lQI.put(paramString, paramc);
    AppMethodBeat.o(145777);
  }
  
  public static void a(String paramString, com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(145779);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.Audio.AppBrandAudioClientService", "appId is empty");
      AppMethodBeat.o(145779);
      return;
    }
    if (paramc == null)
    {
      ad.e("MicroMsg.Audio.AppBrandAudioClientService", "listener is null");
      AppMethodBeat.o(145779);
      return;
    }
    if (lQJ.containsKey(paramString)) {
      Sn(paramString);
    }
    ad.d("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", new Object[] { paramString });
    lQJ.put(paramString, paramc);
    if (!lQK.contains(paramString)) {
      lQK.add(paramString);
    }
    com.tencent.mm.sdk.b.a.IbL.b(paramc);
    AppMethodBeat.o(145779);
  }
  
  public static void av(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(145782);
    lQL.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(145782);
  }
  
  public static void onCreate(String paramString)
  {
    AppMethodBeat.i(145775);
    ad.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
    lQI.clear();
    b.onCreate(paramString);
    lQL.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(145775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.a
 * JD-Core Version:    0.7.0.1
 */