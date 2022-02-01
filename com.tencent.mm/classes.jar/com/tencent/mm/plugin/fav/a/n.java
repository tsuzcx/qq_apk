package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.i.a;
import com.tencent.mm.ak.i.b;
import com.tencent.mm.ak.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  implements i.a, i.b, SensorController.a
{
  static SensorController oUL;
  private List<a> callbacks;
  private int dhE;
  long lastShakeTime;
  public i oUG;
  private boolean oUH;
  private boolean oUI;
  private boolean oUJ;
  bj oUK;
  public String path;
  boolean qJo;
  private int qJp;
  
  public n()
  {
    AppMethodBeat.i(103442);
    this.oUH = true;
    this.oUJ = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.oUG = ((j)g.ab(j.class)).Lk();
    Boolean localBoolean = (Boolean)g.agR().agA().get(26, Boolean.FALSE);
    this.oUI = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.oUH = bool;
      if (this.oUG == null) {
        break label185;
      }
      this.oUG.a(this);
      this.oUG.a(this);
      this.oUG.cl(this.oUH);
    }
    for (;;)
    {
      if (oUL == null) {
        oUL = new SensorController(ai.getContext());
      }
      if (this.oUK == null) {
        this.oUK = new bj(ai.getContext());
      }
      AppMethodBeat.o(103442);
      return;
      bool = false;
      break;
      label185:
      ac.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
    }
  }
  
  private void caX()
  {
    AppMethodBeat.i(103454);
    if (oUL != null) {
      oUL.eVS();
    }
    if (this.oUK != null) {
      this.oUK.eVT();
    }
    AppMethodBeat.o(103454);
  }
  
  public final boolean Y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103447);
    if (this.oUG == null)
    {
      ac.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(103447);
      return false;
    }
    this.oUG.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).cu(paramString, paramInt2);
    }
    if ((oUL != null) && (!oUL.aKH))
    {
      oUL.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103441);
          n.this.lastShakeTime = bs.Gn();
          AppMethodBeat.o(103441);
        }
      };
      if (!this.oUK.aE((Runnable)localObject)) {
        break label199;
      }
    }
    label199:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dhE = paramInt1;
      if ((bs.isNullOrNil(paramString)) || (!this.oUG.a(paramString, this.oUH, paramInt1, paramInt2))) {
        break;
      }
      am.aKO("keep_app_silent");
      com.tencent.mm.plugin.audio.c.a.bCx().cm(this.oUH);
      AppMethodBeat.o(103447);
      return true;
    }
    AppMethodBeat.o(103447);
    return false;
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
  
  public final boolean cN(String paramString, int paramInt)
  {
    AppMethodBeat.i(103446);
    if (this.oUG == null)
    {
      ac.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(103446);
      return false;
    }
    this.oUG.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).cu(paramString, 0);
    }
    if ((oUL != null) && (!oUL.aKH))
    {
      oUL.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103440);
          n.this.lastShakeTime = bs.Gn();
          AppMethodBeat.o(103440);
        }
      };
      if (!this.oUK.aE((Runnable)localObject)) {
        break label184;
      }
    }
    label184:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dhE = paramInt;
      if ((bs.isNullOrNil(paramString)) || (!this.oUG.a(paramString, this.oUH, true, paramInt))) {
        break;
      }
      am.aKO("keep_app_silent");
      AppMethodBeat.o(103446);
      return true;
    }
    AppMethodBeat.o(103446);
    return false;
  }
  
  public final boolean caY()
  {
    AppMethodBeat.i(103448);
    if (this.oUG == null)
    {
      ac.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
      AppMethodBeat.o(103448);
      return false;
    }
    boolean bool = this.oUG.isPlaying();
    AppMethodBeat.o(103448);
    return bool;
  }
  
  public final boolean cpy()
  {
    AppMethodBeat.i(103449);
    ac.i("MicroMsg.FavVoiceLogic", "resume play");
    am.aKO("keep_app_silent");
    if (this.oUG == null)
    {
      ac.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
      AppMethodBeat.o(103449);
      return false;
    }
    boolean bool = this.oUG.resume();
    AppMethodBeat.o(103449);
    return bool;
  }
  
  public final boolean cpz()
  {
    AppMethodBeat.i(103450);
    ac.i("MicroMsg.FavVoiceLogic", "pause play");
    am.aKP("keep_app_silent");
    if (this.oUG == null)
    {
      ac.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
      AppMethodBeat.o(103450);
      return false;
    }
    boolean bool = this.oUG.pause();
    AppMethodBeat.o(103450);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(103444);
    pause();
    caX();
    oUL = null;
    this.callbacks.clear();
    AppMethodBeat.o(103444);
  }
  
  public final void kc(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(103455);
    if (bs.isNullOrNil(this.path))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.oUJ)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.oUJ = paramBoolean;
        AppMethodBeat.o(103455);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bs.aO(this.lastShakeTime) > 400L))
    {
      this.oUJ = true;
      AppMethodBeat.o(103455);
      return;
    }
    this.oUJ = false;
    if ((this.oUG != null) && (this.oUG.NU()))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.oUI)
    {
      if (this.oUG != null) {
        this.oUG.cl(false);
      }
      com.tencent.mm.plugin.audio.c.a.bCx().cm(false);
      this.oUH = false;
      AppMethodBeat.o(103455);
      return;
    }
    if ((this.oUG != null) && (!this.oUG.isPlaying()) && (!this.qJo))
    {
      this.oUG.cl(true);
      this.oUH = true;
      AppMethodBeat.o(103455);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.bCy())
    {
      ac.d("MicroMsg.FavVoiceLogic", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(103455);
      return;
    }
    if (this.oUG != null) {
      this.oUG.cl(paramBoolean);
    }
    this.oUH = paramBoolean;
    if ((this.qJo) && (!paramBoolean))
    {
      Y(this.path, this.dhE, this.qJp);
      AppMethodBeat.o(103455);
      return;
    }
    if (!paramBoolean) {
      cN(this.path, this.dhE);
    }
    AppMethodBeat.o(103455);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(103453);
    ac.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
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
    ac.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
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
    if (this.oUG == null)
    {
      ac.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
      AppMethodBeat.o(103445);
      return;
    }
    if (this.oUG.isPlaying()) {
      cpz();
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
    ac.d("MicroMsg.FavVoiceLogic", "stop play");
    am.aKP("keep_app_silent");
    if (this.oUG != null) {
      this.oUG.stop();
    }
    caX();
    AppMethodBeat.o(103451);
  }
  
  public static abstract interface a
  {
    public abstract void cu(String paramString, int paramInt);
    
    public abstract void onFinish();
    
    public abstract void onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.n
 * JD-Core Version:    0.7.0.1
 */