package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.ak.l;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
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

public final class n
  implements k.a, k.b, SensorController.SensorEventCallBack
{
  static SensorController qUq;
  private List<a> callbacks;
  private int dLt;
  private long lastShakeTime;
  public String path;
  public k qUl;
  private boolean qUm;
  private boolean qUn;
  private boolean qUo;
  ShakeManager qUp;
  boolean tbh;
  private int tbi;
  
  public n()
  {
    AppMethodBeat.i(103442);
    this.qUm = true;
    this.qUo = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.qUl = ((l)g.af(l.class)).Xa();
    Boolean localBoolean = (Boolean)g.aAh().azQ().get(26, Boolean.FALSE);
    this.qUn = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.qUm = bool;
      if (this.qUl == null) {
        break label185;
      }
      this.qUl.a(this);
      this.qUl.a(this);
      this.qUl.cU(this.qUm);
    }
    for (;;)
    {
      if (qUq == null) {
        qUq = new SensorController(MMApplicationContext.getContext());
      }
      if (this.qUp == null) {
        this.qUp = new ShakeManager(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(103442);
      return;
      bool = false;
      break;
      label185:
      Log.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
    }
  }
  
  private void cEE()
  {
    AppMethodBeat.i(103454);
    if (qUq != null) {
      qUq.removeSensorCallBack();
    }
    if (this.qUp != null) {
      this.qUp.stopShake();
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
  
  public final boolean ab(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103447);
    if (this.qUl == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(103447);
      return false;
    }
    this.qUl.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).dt(paramString, paramInt2);
    }
    if ((qUq != null) && (!qUq.hasRegistered()))
    {
      qUq.setSensorCallBack(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103441);
          n.a(n.this, Util.currentTicks());
          AppMethodBeat.o(103441);
        }
      };
      if (!this.qUp.startShake((Runnable)localObject)) {
        break label199;
      }
    }
    label199:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dLt = paramInt1;
      if ((Util.isNullOrNil(paramString)) || (!this.qUl.a(paramString, this.qUm, paramInt1, paramInt2))) {
        break;
      }
      MMEntryLock.lock("keep_app_silent");
      com.tencent.mm.plugin.audio.c.a.cea().cV(this.qUm);
      AppMethodBeat.o(103447);
      return true;
    }
    AppMethodBeat.o(103447);
    return false;
  }
  
  public final boolean cEF()
  {
    AppMethodBeat.i(103448);
    if (this.qUl == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
      AppMethodBeat.o(103448);
      return false;
    }
    boolean bool = this.qUl.isPlaying();
    AppMethodBeat.o(103448);
    return bool;
  }
  
  public final boolean cUI()
  {
    AppMethodBeat.i(103449);
    Log.i("MicroMsg.FavVoiceLogic", "resume play");
    MMEntryLock.lock("keep_app_silent");
    if (this.qUl == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
      AppMethodBeat.o(103449);
      return false;
    }
    boolean bool = this.qUl.resume();
    AppMethodBeat.o(103449);
    return bool;
  }
  
  public final boolean cUJ()
  {
    AppMethodBeat.i(103450);
    Log.i("MicroMsg.FavVoiceLogic", "pause play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.qUl == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
      AppMethodBeat.o(103450);
      return false;
    }
    boolean bool = this.qUl.pause();
    AppMethodBeat.o(103450);
    return bool;
  }
  
  public final boolean cZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(103446);
    if (this.qUl == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(103446);
      return false;
    }
    this.qUl.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).dt(paramString, 0);
    }
    if ((qUq != null) && (!qUq.hasRegistered()))
    {
      qUq.setSensorCallBack(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103440);
          n.a(n.this, Util.currentTicks());
          AppMethodBeat.o(103440);
        }
      };
      if (!this.qUp.startShake((Runnable)localObject)) {
        break label187;
      }
    }
    label187:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dLt = paramInt;
      if ((Util.isNullOrNil(paramString)) || (!this.qUl.a(paramString, this.qUm, true, paramInt))) {
        break;
      }
      MMEntryLock.lock("keep_app_silent");
      AppMethodBeat.o(103446);
      return true;
    }
    AppMethodBeat.o(103446);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(103444);
    pause();
    cEE();
    qUq = null;
    this.callbacks.clear();
    AppMethodBeat.o(103444);
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
  
  public final void onSensorEvent(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(103455);
    if (Util.isNullOrNil(this.path))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.qUo)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.qUo = paramBoolean;
        AppMethodBeat.o(103455);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.qUo = true;
      AppMethodBeat.o(103455);
      return;
    }
    this.qUo = false;
    if ((this.qUl != null) && (this.qUl.isCalling()))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.qUn)
    {
      if (this.qUl != null) {
        this.qUl.cU(false);
      }
      com.tencent.mm.plugin.audio.c.a.cea().cV(false);
      this.qUm = false;
      AppMethodBeat.o(103455);
      return;
    }
    if ((this.qUl != null) && (!this.qUl.isPlaying()) && (!this.tbh))
    {
      this.qUl.cU(true);
      this.qUm = true;
      AppMethodBeat.o(103455);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.ceb())
    {
      Log.d("MicroMsg.FavVoiceLogic", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(103455);
      return;
    }
    if (this.qUl != null) {
      this.qUl.cU(paramBoolean);
    }
    this.qUm = paramBoolean;
    if ((this.tbh) && (!paramBoolean))
    {
      ab(this.path, this.dLt, this.tbi);
      AppMethodBeat.o(103455);
      return;
    }
    if (!paramBoolean) {
      cZ(this.path, this.dLt);
    }
    AppMethodBeat.o(103455);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(103445);
    if (this.qUl == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
      AppMethodBeat.o(103445);
      return;
    }
    if (this.qUl.isPlaying()) {
      cUJ();
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
    if (this.qUl != null) {
      this.qUl.stop();
    }
    cEE();
    AppMethodBeat.o(103451);
  }
  
  public static abstract interface a
  {
    public abstract void dt(String paramString, int paramInt);
    
    public abstract void onFinish();
    
    public abstract void onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.n
 * JD-Core Version:    0.7.0.1
 */