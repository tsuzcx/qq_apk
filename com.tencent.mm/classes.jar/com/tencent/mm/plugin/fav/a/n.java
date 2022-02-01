package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.i;
import com.tencent.mm.al.i.a;
import com.tencent.mm.al.i.b;
import com.tencent.mm.al.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  implements i.a, i.b, SensorController.a
{
  static SensorController orl;
  private List<a> callbacks;
  private int dkj;
  long lastShakeTime;
  public i org;
  private boolean orh;
  private boolean ori;
  private boolean orj;
  bk ork;
  public String path;
  boolean qaI;
  private int qaJ;
  
  public n()
  {
    AppMethodBeat.i(103442);
    this.orh = true;
    this.orj = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.org = ((j)g.ab(j.class)).Lm();
    Boolean localBoolean = (Boolean)g.afB().afk().get(26, Boolean.FALSE);
    this.ori = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.orh = bool;
      if (this.org == null) {
        break label185;
      }
      this.org.a(this);
      this.org.a(this);
      this.org.cj(this.orh);
    }
    for (;;)
    {
      if (orl == null) {
        orl = new SensorController(aj.getContext());
      }
      if (this.ork == null) {
        this.ork = new bk(aj.getContext());
      }
      AppMethodBeat.o(103442);
      return;
      bool = false;
      break;
      label185:
      ad.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
    }
  }
  
  private void bTJ()
  {
    AppMethodBeat.i(103454);
    if (orl != null) {
      orl.eGx();
    }
    if (this.ork != null) {
      this.ork.eGy();
    }
    AppMethodBeat.o(103454);
  }
  
  public final boolean Z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103447);
    if (this.org == null)
    {
      ad.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(103447);
      return false;
    }
    this.org.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).cp(paramString, paramInt2);
    }
    if ((orl != null) && (!orl.aJR))
    {
      orl.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103441);
          n.this.lastShakeTime = bt.GC();
          AppMethodBeat.o(103441);
        }
      };
      if (!this.ork.aC((Runnable)localObject)) {
        break label199;
      }
    }
    label199:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dkj = paramInt1;
      if ((bt.isNullOrNil(paramString)) || (!this.org.a(paramString, this.orh, paramInt1, paramInt2))) {
        break;
      }
      an.aFx("keep_app_silent");
      com.tencent.mm.plugin.audio.c.a.bvB().ck(this.orh);
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
  
  public final boolean bTK()
  {
    AppMethodBeat.i(103448);
    if (this.org == null)
    {
      ad.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
      AppMethodBeat.o(103448);
      return false;
    }
    boolean bool = this.org.isPlaying();
    AppMethodBeat.o(103448);
    return bool;
  }
  
  public final boolean cI(String paramString, int paramInt)
  {
    AppMethodBeat.i(103446);
    if (this.org == null)
    {
      ad.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(103446);
      return false;
    }
    this.org.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).cp(paramString, 0);
    }
    if ((orl != null) && (!orl.aJR))
    {
      orl.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103440);
          n.this.lastShakeTime = bt.GC();
          AppMethodBeat.o(103440);
        }
      };
      if (!this.ork.aC((Runnable)localObject)) {
        break label184;
      }
    }
    label184:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dkj = paramInt;
      if ((bt.isNullOrNil(paramString)) || (!this.org.a(paramString, this.orh, true, paramInt))) {
        break;
      }
      an.aFx("keep_app_silent");
      AppMethodBeat.o(103446);
      return true;
    }
    AppMethodBeat.o(103446);
    return false;
  }
  
  public final boolean chR()
  {
    AppMethodBeat.i(103449);
    ad.i("MicroMsg.FavVoiceLogic", "resume play");
    an.aFx("keep_app_silent");
    if (this.org == null)
    {
      ad.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
      AppMethodBeat.o(103449);
      return false;
    }
    boolean bool = this.org.resume();
    AppMethodBeat.o(103449);
    return bool;
  }
  
  public final boolean chS()
  {
    AppMethodBeat.i(103450);
    ad.i("MicroMsg.FavVoiceLogic", "pause play");
    an.aFy("keep_app_silent");
    if (this.org == null)
    {
      ad.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
      AppMethodBeat.o(103450);
      return false;
    }
    boolean bool = this.org.pause();
    AppMethodBeat.o(103450);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(103444);
    pause();
    bTJ();
    orl = null;
    this.callbacks.clear();
    AppMethodBeat.o(103444);
  }
  
  public final void jz(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(103455);
    if (bt.isNullOrNil(this.path))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.orj)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.orj = paramBoolean;
        AppMethodBeat.o(103455);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aS(this.lastShakeTime) > 400L))
    {
      this.orj = true;
      AppMethodBeat.o(103455);
      return;
    }
    this.orj = false;
    if ((this.org != null) && (this.org.NY()))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.ori)
    {
      if (this.org != null) {
        this.org.cj(false);
      }
      com.tencent.mm.plugin.audio.c.a.bvB().ck(false);
      this.orh = false;
      AppMethodBeat.o(103455);
      return;
    }
    if ((this.org != null) && (!this.org.isPlaying()) && (!this.qaI))
    {
      this.org.cj(true);
      this.orh = true;
      AppMethodBeat.o(103455);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.bvC())
    {
      ad.d("MicroMsg.FavVoiceLogic", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(103455);
      return;
    }
    if (this.org != null) {
      this.org.cj(paramBoolean);
    }
    this.orh = paramBoolean;
    if ((this.qaI) && (!paramBoolean))
    {
      Z(this.path, this.dkj, this.qaJ);
      AppMethodBeat.o(103455);
      return;
    }
    if (!paramBoolean) {
      cI(this.path, this.dkj);
    }
    AppMethodBeat.o(103455);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(103453);
    ad.d("MicroMsg.FavVoiceLogic", "on completion, do stop play");
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
    ad.d("MicroMsg.FavVoiceLogic", "on error, do stop play");
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
    if (this.org == null)
    {
      ad.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
      AppMethodBeat.o(103445);
      return;
    }
    if (this.org.isPlaying()) {
      chS();
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
    ad.d("MicroMsg.FavVoiceLogic", "stop play");
    an.aFy("keep_app_silent");
    if (this.org != null) {
      this.org.stop();
    }
    bTJ();
    AppMethodBeat.o(103451);
  }
  
  public static abstract interface a
  {
    public abstract void cp(String paramString, int paramInt);
    
    public abstract void onFinish();
    
    public abstract void onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.n
 * JD-Core Version:    0.7.0.1
 */