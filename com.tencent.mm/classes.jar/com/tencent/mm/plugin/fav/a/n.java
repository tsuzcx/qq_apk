package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  implements h.a, h.b, SensorController.a
{
  static SensorController pEZ;
  private List<a> callbacks;
  private int dui;
  long lastShakeTime;
  public h pEU;
  private boolean pEV;
  private boolean pEW;
  private boolean pEX;
  bl pEY;
  public String path;
  boolean rBC;
  private int rBD;
  
  public n()
  {
    AppMethodBeat.i(103442);
    this.pEV = true;
    this.pEX = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.pEU = ((i)g.ab(i.class)).MN();
    Boolean localBoolean = (Boolean)g.ajR().ajA().get(26, Boolean.FALSE);
    this.pEW = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.pEV = bool;
      if (this.pEU == null) {
        break label185;
      }
      this.pEU.a(this);
      this.pEU.a(this);
      this.pEU.cm(this.pEV);
    }
    for (;;)
    {
      if (pEZ == null) {
        pEZ = new SensorController(ak.getContext());
      }
      if (this.pEY == null) {
        this.pEY = new bl(ak.getContext());
      }
      AppMethodBeat.o(103442);
      return;
      bool = false;
      break;
      label185:
      ae.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
    }
  }
  
  private void cgR()
  {
    AppMethodBeat.i(103454);
    if (pEZ != null) {
      pEZ.fpx();
    }
    if (this.pEY != null) {
      this.pEY.fpy();
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
  
  public final boolean aa(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103447);
    if (this.pEU == null)
    {
      ae.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(103447);
      return false;
    }
    this.pEU.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).cB(paramString, paramInt2);
    }
    if ((pEZ != null) && (!pEZ.aMy))
    {
      pEZ.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103441);
          n.this.lastShakeTime = bu.HQ();
          AppMethodBeat.o(103441);
        }
      };
      if (!this.pEY.aB((Runnable)localObject)) {
        break label199;
      }
    }
    label199:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dui = paramInt1;
      if ((bu.isNullOrNil(paramString)) || (!this.pEU.a(paramString, this.pEV, paramInt1, paramInt2))) {
        break;
      }
      ao.aRR("keep_app_silent");
      com.tencent.mm.plugin.audio.c.a.bHy().cn(this.pEV);
      AppMethodBeat.o(103447);
      return true;
    }
    AppMethodBeat.o(103447);
    return false;
  }
  
  public final boolean cU(String paramString, int paramInt)
  {
    AppMethodBeat.i(103446);
    if (this.pEU == null)
    {
      ae.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(103446);
      return false;
    }
    this.pEU.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).cB(paramString, 0);
    }
    if ((pEZ != null) && (!pEZ.aMy))
    {
      pEZ.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103440);
          n.this.lastShakeTime = bu.HQ();
          AppMethodBeat.o(103440);
        }
      };
      if (!this.pEY.aB((Runnable)localObject)) {
        break label184;
      }
    }
    label184:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dui = paramInt;
      if ((bu.isNullOrNil(paramString)) || (!this.pEU.a(paramString, this.pEV, true, paramInt))) {
        break;
      }
      ao.aRR("keep_app_silent");
      AppMethodBeat.o(103446);
      return true;
    }
    AppMethodBeat.o(103446);
    return false;
  }
  
  public final boolean cgS()
  {
    AppMethodBeat.i(103448);
    if (this.pEU == null)
    {
      ae.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
      AppMethodBeat.o(103448);
      return false;
    }
    boolean bool = this.pEU.isPlaying();
    AppMethodBeat.o(103448);
    return bool;
  }
  
  public final boolean cwE()
  {
    AppMethodBeat.i(103449);
    ae.i("MicroMsg.FavVoiceLogic", "resume play");
    ao.aRR("keep_app_silent");
    if (this.pEU == null)
    {
      ae.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
      AppMethodBeat.o(103449);
      return false;
    }
    boolean bool = this.pEU.resume();
    AppMethodBeat.o(103449);
    return bool;
  }
  
  public final boolean cwF()
  {
    AppMethodBeat.i(103450);
    ae.i("MicroMsg.FavVoiceLogic", "pause play");
    ao.aRS("keep_app_silent");
    if (this.pEU == null)
    {
      ae.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
      AppMethodBeat.o(103450);
      return false;
    }
    boolean bool = this.pEU.pause();
    AppMethodBeat.o(103450);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(103444);
    pause();
    cgR();
    pEZ = null;
    this.callbacks.clear();
    AppMethodBeat.o(103444);
  }
  
  public final void km(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(103455);
    if (bu.isNullOrNil(this.path))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.pEX)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.pEX = paramBoolean;
        AppMethodBeat.o(103455);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bu.aO(this.lastShakeTime) > 400L))
    {
      this.pEX = true;
      AppMethodBeat.o(103455);
      return;
    }
    this.pEX = false;
    if ((this.pEU != null) && (this.pEU.PC()))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.pEW)
    {
      if (this.pEU != null) {
        this.pEU.cm(false);
      }
      com.tencent.mm.plugin.audio.c.a.bHy().cn(false);
      this.pEV = false;
      AppMethodBeat.o(103455);
      return;
    }
    if ((this.pEU != null) && (!this.pEU.isPlaying()) && (!this.rBC))
    {
      this.pEU.cm(true);
      this.pEV = true;
      AppMethodBeat.o(103455);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.bHz())
    {
      ae.d("MicroMsg.FavVoiceLogic", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(103455);
      return;
    }
    if (this.pEU != null) {
      this.pEU.cm(paramBoolean);
    }
    this.pEV = paramBoolean;
    if ((this.rBC) && (!paramBoolean))
    {
      aa(this.path, this.dui, this.rBD);
      AppMethodBeat.o(103455);
      return;
    }
    if (!paramBoolean) {
      cU(this.path, this.dui);
    }
    AppMethodBeat.o(103455);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(103453);
    ae.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
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
    ae.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
    stopPlay();
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFinish();
    }
    AppMethodBeat.o(103452);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(103445);
    if (this.pEU == null)
    {
      ae.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
      AppMethodBeat.o(103445);
      return;
    }
    if (this.pEU.isPlaying()) {
      cwF();
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
    ae.d("MicroMsg.FavVoiceLogic", "stop play");
    ao.aRS("keep_app_silent");
    if (this.pEU != null) {
      this.pEU.stop();
    }
    cgR();
    AppMethodBeat.o(103451);
  }
  
  public static abstract interface a
  {
    public abstract void cB(String paramString, int paramInt);
    
    public abstract void onFinish();
    
    public abstract void onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.n
 * JD-Core Version:    0.7.0.1
 */