package com.tencent.mm.plugin.cast.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/cast/service/ScreenCastForegroundService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "", "flags", "startId", "Companion", "plugin-cast_release"})
public final class ScreenCastForegroundService
  extends Service
{
  public static final a qmh;
  
  static
  {
    AppMethodBeat.i(197255);
    qmh = new a((byte)0);
    AppMethodBeat.o(197255);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(197252);
    super.onCreate();
    Log.i("MicroMsg.ScreenCastForegroundService", "Service onCreate() is called");
    AppMethodBeat.o(197252);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(197254);
    super.onDestroy();
    Log.i("MicroMsg.ScreenCastForegroundService", "Service onDestroy");
    AppMethodBeat.o(197254);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197253);
    p.h(paramIntent, "intent");
    Log.i("MicroMsg.ScreenCastForegroundService", "Service onStartCommand() is called");
    AppMethodBeat.o(197253);
    return 2;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/cast/service/ScreenCastForegroundService$Companion;", "", "()V", "TAG", "", "plugin-cast_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.service.ScreenCastForegroundService
 * JD-Core Version:    0.7.0.1
 */