package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private static Map<String, c> ncL;
  private static Map<String, IListener> ncM;
  private static ArrayList<String> ncN;
  private static Map<String, Boolean> ncO;
  
  static
  {
    AppMethodBeat.i(145783);
    ncL = new ConcurrentHashMap();
    ncM = new HashMap();
    ncN = new ArrayList();
    ncO = new ConcurrentHashMap();
    AppMethodBeat.o(145783);
  }
  
  public static void Zl(String paramString)
  {
    AppMethodBeat.i(145776);
    Log.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
    b.Zl(paramString);
    ncL.clear();
    Iterator localIterator = ncN.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (IListener)ncM.remove(localObject);
      if (localObject != null) {
        EventCenter.instance.removeListener((IListener)localObject);
      }
    }
    ncM.clear();
    ncN.clear();
    ncO.remove(paramString);
    AppMethodBeat.o(145776);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(145777);
    ncL.put(paramString, paramc);
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
    if (ncM.containsKey(paramString)) {
      acA(paramString);
    }
    Log.d("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", new Object[] { paramString });
    ncM.put(paramString, paramIListener);
    if (!ncN.contains(paramString)) {
      ncN.add(paramString);
    }
    EventCenter.instance.add(paramIListener);
    AppMethodBeat.o(145779);
  }
  
  public static void acA(String paramString)
  {
    AppMethodBeat.i(145780);
    if (!ncM.containsKey(paramString))
    {
      Log.e("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(145780);
      return;
    }
    Log.d("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", new Object[] { paramString });
    ncN.remove(paramString);
    paramString = (IListener)ncM.remove(paramString);
    if (paramString != null) {
      EventCenter.instance.removeListener(paramString);
    }
    AppMethodBeat.o(145780);
  }
  
  public static boolean acB(String paramString)
  {
    AppMethodBeat.i(145781);
    if (!ncO.containsKey(paramString))
    {
      AppMethodBeat.o(145781);
      return false;
    }
    boolean bool = ((Boolean)ncO.get(paramString)).booleanValue();
    AppMethodBeat.o(145781);
    return bool;
  }
  
  public static c acz(String paramString)
  {
    AppMethodBeat.i(145778);
    paramString = (c)ncL.get(paramString);
    AppMethodBeat.o(145778);
    return paramString;
  }
  
  public static void aw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(145782);
    ncO.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(145782);
  }
  
  public static void onCreate(String paramString)
  {
    AppMethodBeat.i(145775);
    Log.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
    ncL.clear();
    b.onCreate(paramString);
    ncO.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(145775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.a
 * JD-Core Version:    0.7.0.1
 */