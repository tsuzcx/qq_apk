package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h;
import com.tencent.mm.al.h.a;
import com.tencent.mm.al.h.b;
import com.tencent.mm.al.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  implements h.a, h.b, SensorController.a
{
  static SensorController pyv;
  private List<a> callbacks;
  private int dtc;
  long lastShakeTime;
  public String path;
  public h pyq;
  private boolean pyr;
  private boolean pys;
  private boolean pyt;
  bk pyu;
  boolean rtp;
  private int rtq;
  
  public n()
  {
    AppMethodBeat.i(103442);
    this.pyr = true;
    this.pyt = false;
    this.lastShakeTime = -1L;
    this.callbacks = new LinkedList();
    this.pyq = ((i)g.ab(i.class)).MS();
    Boolean localBoolean = (Boolean)g.ajC().ajl().get(26, Boolean.FALSE);
    this.pys = localBoolean.booleanValue();
    boolean bool;
    if (!localBoolean.booleanValue())
    {
      bool = true;
      this.pyr = bool;
      if (this.pyq == null) {
        break label185;
      }
      this.pyq.a(this);
      this.pyq.a(this);
      this.pyq.cm(this.pyr);
    }
    for (;;)
    {
      if (pyv == null) {
        pyv = new SensorController(aj.getContext());
      }
      if (this.pyu == null) {
        this.pyu = new bk(aj.getContext());
      }
      AppMethodBeat.o(103442);
      return;
      bool = false;
      break;
      label185:
      ad.w("MicroMsg.FavVoiceLogic", "get voice player fail, it is null");
    }
  }
  
  private void cfB()
  {
    AppMethodBeat.i(103454);
    if (pyv != null) {
      pyv.flC();
    }
    if (this.pyu != null) {
      this.pyu.flD();
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
    if (this.pyq == null)
    {
      ad.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt1) });
      AppMethodBeat.o(103447);
      return false;
    }
    this.pyq.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).cx(paramString, paramInt2);
    }
    if ((pyv != null) && (!pyv.aMy))
    {
      pyv.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103441);
          n.this.lastShakeTime = bt.HI();
          AppMethodBeat.o(103441);
        }
      };
      if (!this.pyu.aD((Runnable)localObject)) {
        break label199;
      }
    }
    label199:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dtc = paramInt1;
      if ((bt.isNullOrNil(paramString)) || (!this.pyq.a(paramString, this.pyr, paramInt1, paramInt2))) {
        break;
      }
      an.aQu("keep_app_silent");
      com.tencent.mm.plugin.audio.c.a.bGC().cn(this.pyr);
      AppMethodBeat.o(103447);
      return true;
    }
    AppMethodBeat.o(103447);
    return false;
  }
  
  public final boolean cQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(103446);
    if (this.pyq == null)
    {
      ad.w("MicroMsg.FavVoiceLogic", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(103446);
      return false;
    }
    this.pyq.stop();
    Object localObject = this.callbacks.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).cx(paramString, 0);
    }
    if ((pyv != null) && (!pyv.aMy))
    {
      pyv.a(this);
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103440);
          n.this.lastShakeTime = bt.HI();
          AppMethodBeat.o(103440);
        }
      };
      if (!this.pyu.aD((Runnable)localObject)) {
        break label184;
      }
    }
    label184:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      this.path = paramString;
      this.dtc = paramInt;
      if ((bt.isNullOrNil(paramString)) || (!this.pyq.a(paramString, this.pyr, true, paramInt))) {
        break;
      }
      an.aQu("keep_app_silent");
      AppMethodBeat.o(103446);
      return true;
    }
    AppMethodBeat.o(103446);
    return false;
  }
  
  public final boolean cfC()
  {
    AppMethodBeat.i(103448);
    if (this.pyq == null)
    {
      ad.w("MicroMsg.FavVoiceLogic", "check is play, but player is null");
      AppMethodBeat.o(103448);
      return false;
    }
    boolean bool = this.pyq.isPlaying();
    AppMethodBeat.o(103448);
    return bool;
  }
  
  public final boolean cvd()
  {
    AppMethodBeat.i(103449);
    ad.i("MicroMsg.FavVoiceLogic", "resume play");
    an.aQu("keep_app_silent");
    if (this.pyq == null)
    {
      ad.w("MicroMsg.FavVoiceLogic", "resum play error, player is null");
      AppMethodBeat.o(103449);
      return false;
    }
    boolean bool = this.pyq.resume();
    AppMethodBeat.o(103449);
    return bool;
  }
  
  public final boolean cve()
  {
    AppMethodBeat.i(103450);
    ad.i("MicroMsg.FavVoiceLogic", "pause play");
    an.aQv("keep_app_silent");
    if (this.pyq == null)
    {
      ad.w("MicroMsg.FavVoiceLogic", "pause play error, player is null");
      AppMethodBeat.o(103450);
      return false;
    }
    boolean bool = this.pyq.pause();
    AppMethodBeat.o(103450);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(103444);
    pause();
    cfB();
    pyv = null;
    this.callbacks.clear();
    AppMethodBeat.o(103444);
  }
  
  public final void kn(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(103455);
    if (bt.isNullOrNil(this.path))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.pyt)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.pyt = paramBoolean;
        AppMethodBeat.o(103455);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aO(this.lastShakeTime) > 400L))
    {
      this.pyt = true;
      AppMethodBeat.o(103455);
      return;
    }
    this.pyt = false;
    if ((this.pyq != null) && (this.pyq.PD()))
    {
      AppMethodBeat.o(103455);
      return;
    }
    if (this.pys)
    {
      if (this.pyq != null) {
        this.pyq.cm(false);
      }
      com.tencent.mm.plugin.audio.c.a.bGC().cn(false);
      this.pyr = false;
      AppMethodBeat.o(103455);
      return;
    }
    if ((this.pyq != null) && (!this.pyq.isPlaying()) && (!this.rtp))
    {
      this.pyq.cm(true);
      this.pyr = true;
      AppMethodBeat.o(103455);
      return;
    }
    if (com.tencent.mm.plugin.audio.c.a.bGD())
    {
      ad.d("MicroMsg.FavVoiceLogic", "onSensorEvent, connecting bluetooth, omit sensor event");
      AppMethodBeat.o(103455);
      return;
    }
    if (this.pyq != null) {
      this.pyq.cm(paramBoolean);
    }
    this.pyr = paramBoolean;
    if ((this.rtp) && (!paramBoolean))
    {
      aa(this.path, this.dtc, this.rtq);
      AppMethodBeat.o(103455);
      return;
    }
    if (!paramBoolean) {
      cQ(this.path, this.dtc);
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
    if (this.pyq == null)
    {
      ad.w("MicroMsg.FavVoiceLogic", "do pause, but player is null");
      AppMethodBeat.o(103445);
      return;
    }
    if (this.pyq.isPlaying()) {
      cve();
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
    an.aQv("keep_app_silent");
    if (this.pyq != null) {
      this.pyq.stop();
    }
    cfB();
    AppMethodBeat.o(103451);
  }
  
  public static abstract interface a
  {
    public abstract void cx(String paramString, int paramInt);
    
    public abstract void onFinish();
    
    public abstract void onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.n
 * JD-Core Version:    0.7.0.1
 */