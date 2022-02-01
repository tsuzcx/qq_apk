package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static Map<String, c> thO;
  private static Map<String, IListener> thP;
  private static ArrayList<String> thQ;
  private static Map<String, Boolean> thR;
  
  static
  {
    AppMethodBeat.i(145783);
    thO = new ConcurrentHashMap();
    thP = new HashMap();
    thQ = new ArrayList();
    thR = new ConcurrentHashMap();
    AppMethodBeat.o(145783);
  }
  
  public static void ZW(String paramString)
  {
    AppMethodBeat.i(145776);
    Log.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
    b.ZW(paramString);
    thO.clear();
    Iterator localIterator = thQ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (IListener)thP.remove(localObject);
      if (localObject != null) {
        ((IListener)localObject).dead();
      }
    }
    thP.clear();
    thQ.clear();
    thR.remove(paramString);
    AppMethodBeat.o(145776);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(145777);
    thO.put(paramString, paramc);
    AppMethodBeat.o(145777);
  }
  
  public static void a(String paramString, IListener paramIListener)
  {
    AppMethodBeat.i(145779);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.Audio.AppBrandAudioClientService", "appId is empty");
      AppMethodBeat.o(145779);
      return;
    }
    if (paramIListener == null)
    {
      Log.e("MicroMsg.Audio.AppBrandAudioClientService", "listener is null");
      AppMethodBeat.o(145779);
      return;
    }
    if (thP.containsKey(paramString)) {
      adA(paramString);
    }
    Log.d("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", new Object[] { paramString });
    thP.put(paramString, paramIListener);
    if (!thQ.contains(paramString)) {
      thQ.add(paramString);
    }
    paramIListener.alive();
    AppMethodBeat.o(145779);
  }
  
  public static void aL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(145782);
    thR.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(145782);
  }
  
  public static void adA(String paramString)
  {
    AppMethodBeat.i(145780);
    if (!thP.containsKey(paramString))
    {
      Log.e("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(145780);
      return;
    }
    Log.d("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", new Object[] { paramString });
    thQ.remove(paramString);
    paramString = (IListener)thP.remove(paramString);
    if (paramString != null) {
      paramString.dead();
    }
    AppMethodBeat.o(145780);
  }
  
  public static boolean adB(String paramString)
  {
    AppMethodBeat.i(145781);
    if (!thR.containsKey(paramString))
    {
      AppMethodBeat.o(145781);
      return false;
    }
    boolean bool = ((Boolean)thR.get(paramString)).booleanValue();
    AppMethodBeat.o(145781);
    return bool;
  }
  
  public static c adz(String paramString)
  {
    AppMethodBeat.i(145778);
    paramString = (c)thO.get(paramString);
    AppMethodBeat.o(145778);
    return paramString;
  }
  
  public static void onCreate(String paramString)
  {
    AppMethodBeat.i(145775);
    Log.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
    thO.clear();
    b.onCreate(paramString);
    thR.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(145775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.a
 * JD-Core Version:    0.7.0.1
 */