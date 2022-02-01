package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.j.a;
import com.tencent.mm.am.j.b;
import com.tencent.mm.am.k;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class o
  implements j.a, j.b, SensorController.SensorEventCallBack
{
  static SensorController xCV;
  boolean Adv;
  private int Adw;
  private List<a> bPE;
  private int hIY;
  private long lastShakeTime;
  public String path;
  public j xCQ;
  private boolean xCR;
  private boolean xCS;
  private boolean xCT;
  ShakeManager xCU;
  
  public o()
  {
    AppMethodBeat.i(103442);
    this.xCR = true;
    this.xCT = false;
    this.lastShakeTime = -1L;
    this.bPE = new LinkedList();
    this.xCQ = ((k)h.ax(k.class)).aDy();
    Boolean localBoolean = (Boolean)h.baE().ban().d(26, Boolean.FALSE);
    this.xCS = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.xCR = bool;
      if (this.xCQ == null) {
        break label185;
      }
      this.xCQ.a(this);
      this.xCQ.a(this);
      this.xCQ.ed(this.xCR);
    }
    for (;;)
    {
      if (xCV == null) {
        xCV = new SensorController(MMApplicationContext.getContext());
      }
      if (this.xCU == null) {
        this.xCU = new ShakeManager(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(103442);
      return;
      bool = false;
      break;
      label185:
      Log.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
    }
  }
  
  private void dxD()
  {
    AppMethodBeat.i(103454);
    if (xCV != null) {
      xCV.removeSensorCallBack();
    }
    if (this.xCU != null) {
      this.xCU.stopShake();
    }
    AppMethodBeat.o(103454);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(103443);
    Iterator localIterator = this.bPE.iterator();
    while (localIterator.hasNext()) {
      if (parama == (a)localIterator.next())
      {
        AppMethodBeat.o(103443);
        return;
      }
    }
    this.bPE.add(parama);
    AppMethodBeat.o(103443);
  }
  
  public final boolean ah(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103447);
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(103447);
      return false;
    }
    this.xCQ.stop();
    Object localObject = this.bPE.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).es(paramString, paramInt2);
    }
    if ((xCV != null) && (!xCV.hasRegistered()))
    {
      xCV.setSensorCallBack(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103441);
          o.a(o.this, Util.currentTicks());
          AppMethodBeat.o(103441);
        }
      };
      if (!this.xCU.startShake((Runnable)localObject)) {
        break label199;
      }
    }
    label199:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.hIY = paramInt1;
      if ((Util.isNullOrNil(paramString)) || (!this.xCQ.a(paramString, this.xCR, paramInt1, paramInt2))) {
        break;
      }
      MMEntryLock.lock("keep_app_silent");
      com.tencent.mm.plugin.audio.c.a.cTW().ee(this.xCR);
      AppMethodBeat.o(103447);
      return true;
    }
    AppMethodBeat.o(103447);
    return false;
  }
  
  public final void atR()
  {
    AppMethodBeat.i(103452);
    Log.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
    stopPlay();
    Iterator localIterator = this.bPE.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(103452);
  }
  
  public final boolean dU(String paramString, int paramInt)
  {
    AppMethodBeat.i(103446);
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(103446);
      return false;
    }
    this.xCQ.stop();
    Object localObject = this.bPE.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).es(paramString, 0);
    }
    if ((xCV != null) && (!xCV.hasRegistered()))
    {
      xCV.setSensorCallBack(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103440);
          o.a(o.this, Util.currentTicks());
          AppMethodBeat.o(103440);
        }
      };
      if (!this.xCU.startShake((Runnable)localObject)) {
        break label187;
      }
    }
    label187:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.hIY = paramInt;
      if ((Util.isNullOrNil(paramString)) || (!this.xCQ.a(paramString, this.xCR, true, paramInt))) {
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
    dxD();
    xCV = null;
    this.bPE.clear();
    AppMethodBeat.o(103444);
  }
  
  public final boolean dxE()
  {
    AppMethodBeat.i(103448);
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
      AppMethodBeat.o(103448);
      return false;
    }
    boolean bool = this.xCQ.isPlaying();
    AppMethodBeat.o(103448);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(103453);
    Log.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
    stopPlay();
    Iterator localIterator = this.bPE.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(103453);
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
    if (this.xCT)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.xCT = paramBoolean;
        AppMethodBeat.o(103455);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.xCT = true;
      AppMethodBeat.o(103455);
      return;
    }
    this.xCT = false;
    if ((this.xCQ != null) && (this.xCQ.isCalling()))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.xCS)
    {
      if (this.xCQ != null) {
        this.xCQ.ed(false);
      }
      com.tencent.mm.plugin.audio.c.a.cTW().ee(false);
      this.xCR = false;
      AppMethodBeat.o(103455);
      return;
    }
    if ((this.xCQ != null) && (!this.xCQ.isPlaying()) && (!this.Adv))
    {
      this.xCQ.ed(true);
      this.xCR = true;
      AppMethodBeat.o(103455);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.cTX())
    {
      Log.d("MicroMsg.FavVoiceLogic", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(103455);
      return;
    }
    if (this.xCQ != null) {
      this.xCQ.ed(paramBoolean);
    }
    this.xCR = paramBoolean;
    if ((this.Adv) && (!paramBoolean))
    {
      ah(this.path, this.hIY, this.Adw);
      AppMethodBeat.o(103455);
      return;
    }
    if (!paramBoolean) {
      dU(this.path, this.hIY);
    }
    AppMethodBeat.o(103455);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(103445);
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
      AppMethodBeat.o(103445);
      return;
    }
    if (this.xCQ.isPlaying()) {
      pausePlay();
    }
    Iterator localIterator = this.bPE.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onPause();
    }
    AppMethodBeat.o(103445);
  }
  
  public final boolean pausePlay()
  {
    AppMethodBeat.i(103450);
    Log.i("MicroMsg.FavVoiceLogic", "pause play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
      AppMethodBeat.o(103450);
      return false;
    }
    boolean bool = this.xCQ.pause();
    AppMethodBeat.o(103450);
    return bool;
  }
  
  public final boolean resumePlay()
  {
    AppMethodBeat.i(103449);
    Log.i("MicroMsg.FavVoiceLogic", "resume play");
    MMEntryLock.lock("keep_app_silent");
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
      AppMethodBeat.o(103449);
      return false;
    }
    boolean bool = this.xCQ.resume();
    AppMethodBeat.o(103449);
    return bool;
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(103451);
    Log.d("MicroMsg.FavVoiceLogic", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.xCQ != null) {
      this.xCQ.stop();
    }
    dxD();
    AppMethodBeat.o(103451);
  }
  
  public static abstract interface a
  {
    public abstract void es(String paramString, int paramInt);
    
    public abstract void onFinish();
    
    public abstract void onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.o
 * JD-Core Version:    0.7.0.1
 */