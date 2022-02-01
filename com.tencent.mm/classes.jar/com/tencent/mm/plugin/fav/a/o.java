package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.k;
import com.tencent.mm.an.k.a;
import com.tencent.mm.an.k.b;
import com.tencent.mm.an.l;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class o
  implements k.a, k.b, SensorController.SensorEventCallBack
{
  static SensorController uww;
  private List<a> callbacks;
  private int fEi;
  private long lastShakeTime;
  public String path;
  public k uwr;
  private boolean uws;
  private boolean uwt;
  private boolean uwu;
  ShakeManager uwv;
  boolean wHm;
  private int wHn;
  
  public o()
  {
    AppMethodBeat.i(103442);
    this.uws = true;
    this.uwu = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.uwr = ((l)h.ae(l.class)).abD();
    Boolean localBoolean = (Boolean)h.aHG().aHp().b(26, Boolean.FALSE);
    this.uwt = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.uws = bool;
      if (this.uwr == null) {
        break label185;
      }
      this.uwr.a(this);
      this.uwr.a(this);
      this.uwr.dr(this.uws);
    }
    for (;;)
    {
      if (uww == null) {
        uww = new SensorController(MMApplicationContext.getContext());
      }
      if (this.uwv == null) {
        this.uwv = new ShakeManager(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(103442);
      return;
      bool = false;
      break;
      label185:
      Log.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
    }
  }
  
  private void cTk()
  {
    AppMethodBeat.i(103454);
    if (uww != null) {
      uww.removeSensorCallBack();
    }
    if (this.uwv != null) {
      this.uwv.stopShake();
    }
    AppMethodBeat.o(103454);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103443);
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      if (parama == (a)localIterator.next())
      {
        AppMethodBeat.o(103443);
        return;
      }
    }
    this.callbacks.add(parama);
    AppMethodBeat.o(103443);
  }
  
  public final boolean ad(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103447);
    if (this.uwr == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(103447);
      return false;
    }
    this.uwr.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).dO(paramString, paramInt2);
    }
    if ((uww != null) && (!uww.hasRegistered()))
    {
      uww.setSensorCallBack(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103441);
          o.a(o.this, Util.currentTicks());
          AppMethodBeat.o(103441);
        }
      };
      if (!this.uwv.startShake((Runnable)localObject)) {
        break label199;
      }
    }
    label199:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.fEi = paramInt1;
      if ((Util.isNullOrNil(paramString)) || (!this.uwr.a(paramString, this.uws, paramInt1, paramInt2))) {
        break;
      }
      MMEntryLock.lock("keep_app_silent");
      com.tencent.mm.plugin.audio.c.a.crn().ds(this.uws);
      AppMethodBeat.o(103447);
      return true;
    }
    AppMethodBeat.o(103447);
    return false;
  }
  
  public final boolean cTl()
  {
    AppMethodBeat.i(103448);
    if (this.uwr == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
      AppMethodBeat.o(103448);
      return false;
    }
    boolean bool = this.uwr.isPlaying();
    AppMethodBeat.o(103448);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(103444);
    pause();
    cTk();
    uww = null;
    this.callbacks.clear();
    AppMethodBeat.o(103444);
  }
  
  public final boolean djO()
  {
    AppMethodBeat.i(103449);
    Log.i("MicroMsg.FavVoiceLogic", "resume play");
    MMEntryLock.lock("keep_app_silent");
    if (this.uwr == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
      AppMethodBeat.o(103449);
      return false;
    }
    boolean bool = this.uwr.resume();
    AppMethodBeat.o(103449);
    return bool;
  }
  
  public final boolean djP()
  {
    AppMethodBeat.i(103450);
    Log.i("MicroMsg.FavVoiceLogic", "pause play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.uwr == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
      AppMethodBeat.o(103450);
      return false;
    }
    boolean bool = this.uwr.pause();
    AppMethodBeat.o(103450);
    return bool;
  }
  
  public final boolean dt(String paramString, int paramInt)
  {
    AppMethodBeat.i(103446);
    if (this.uwr == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(103446);
      return false;
    }
    this.uwr.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).dO(paramString, 0);
    }
    if ((uww != null) && (!uww.hasRegistered()))
    {
      uww.setSensorCallBack(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103440);
          o.a(o.this, Util.currentTicks());
          AppMethodBeat.o(103440);
        }
      };
      if (!this.uwv.startShake((Runnable)localObject)) {
        break label187;
      }
    }
    label187:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.fEi = paramInt;
      if ((Util.isNullOrNil(paramString)) || (!this.uwr.a(paramString, this.uws, true, paramInt))) {
        break;
      }
      MMEntryLock.lock("keep_app_silent");
      AppMethodBeat.o(103446);
      return true;
    }
    AppMethodBeat.o(103446);
    return false;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(103453);
    Log.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
    stopPlay();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(103453);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(103452);
    Log.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
    stopPlay();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(103452);
  }
  
  public void onSensorEvent(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(103455);
    if (Util.isNullOrNil(this.path))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.uwu)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.uwu = paramBoolean;
        AppMethodBeat.o(103455);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.uwu = true;
      AppMethodBeat.o(103455);
      return;
    }
    this.uwu = false;
    if ((this.uwr != null) && (this.uwr.isCalling()))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.uwt)
    {
      if (this.uwr != null) {
        this.uwr.dr(false);
      }
      com.tencent.mm.plugin.audio.c.a.crn().ds(false);
      this.uws = false;
      AppMethodBeat.o(103455);
      return;
    }
    if ((this.uwr != null) && (!this.uwr.isPlaying()) && (!this.wHm))
    {
      this.uwr.dr(true);
      this.uws = true;
      AppMethodBeat.o(103455);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.cro())
    {
      Log.d("MicroMsg.FavVoiceLogic", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(103455);
      return;
    }
    if (this.uwr != null) {
      this.uwr.dr(paramBoolean);
    }
    this.uws = paramBoolean;
    if ((this.wHm) && (!paramBoolean))
    {
      ad(this.path, this.fEi, this.wHn);
      AppMethodBeat.o(103455);
      return;
    }
    if (!paramBoolean) {
      dt(this.path, this.fEi);
    }
    AppMethodBeat.o(103455);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(103445);
    if (this.uwr == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
      AppMethodBeat.o(103445);
      return;
    }
    if (this.uwr.isPlaying()) {
      djP();
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onPause();
    }
    AppMethodBeat.o(103445);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(103451);
    Log.d("MicroMsg.FavVoiceLogic", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.uwr != null) {
      this.uwr.stop();
    }
    cTk();
    AppMethodBeat.o(103451);
  }
  
  public static abstract interface a
  {
    public abstract void dO(String paramString, int paramInt);
    
    public abstract void onFinish();
    
    public abstract void onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.o
 * JD-Core Version:    0.7.0.1
 */