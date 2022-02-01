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
  private static Map<String, c> qda;
  private static Map<String, IListener> qdb;
  private static ArrayList<String> qdc;
  private static Map<String, Boolean> qdd;
  
  static
  {
    AppMethodBeat.i(145783);
    qda = new ConcurrentHashMap();
    qdb = new HashMap();
    qdc = new ArrayList();
    qdd = new ConcurrentHashMap();
    AppMethodBeat.o(145783);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(145777);
    qda.put(paramString, paramc);
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
    if (qdb.containsKey(paramString)) {
      aku(paramString);
    }
    Log.d("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", new Object[] { paramString });
    qdb.put(paramString, paramIListener);
    if (!qdc.contains(paramString)) {
      qdc.add(paramString);
    }
    EventCenter.instance.add(paramIListener);
    AppMethodBeat.o(145779);
  }
  
  public static void agY(String paramString)
  {
    AppMethodBeat.i(145776);
    Log.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
    b.agY(paramString);
    qda.clear();
    Iterator localIterator = qdc.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (IListener)qdb.remove(localObject);
      if (localObject != null) {
        EventCenter.instance.removeListener((IListener)localObject);
      }
    }
    qdb.clear();
    qdc.clear();
    qdd.remove(paramString);
    AppMethodBeat.o(145776);
  }
  
  public static c akt(String paramString)
  {
    AppMethodBeat.i(145778);
    paramString = (c)qda.get(paramString);
    AppMethodBeat.o(145778);
    return paramString;
  }
  
  public static void aku(String paramString)
  {
    AppMethodBeat.i(145780);
    if (!qdb.containsKey(paramString))
    {
      Log.e("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", new Object[] { paramString });
      AppMethodBeat.o(145780);
      return;
    }
    Log.d("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", new Object[] { paramString });
    qdc.remove(paramString);
    paramString = (IListener)qdb.remove(paramString);
    if (paramString != null) {
      EventCenter.instance.removeListener(paramString);
    }
    AppMethodBeat.o(145780);
  }
  
  public static boolean akv(String paramString)
  {
    AppMethodBeat.i(145781);
    if (!qdd.containsKey(paramString))
    {
      AppMethodBeat.o(145781);
      return false;
    }
    boolean bool = ((Boolean)qdd.get(paramString)).booleanValue();
    AppMethodBeat.o(145781);
    return bool;
  }
  
  public static void ay(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(145782);
    qdd.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(145782);
  }
  
  public static void onCreate(String paramString)
  {
    AppMethodBeat.i(145775);
    Log.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
    qda.clear();
    b.onCreate(paramString);
    qdd.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(145775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.a
 * JD-Core Version:    0.7.0.1
 */