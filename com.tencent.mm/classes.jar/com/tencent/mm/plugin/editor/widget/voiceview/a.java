package com.tencent.mm.plugin.editor.widget.voiceview;

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

public class a
  implements k.a, k.b, SensorController.SensorEventCallBack
{
  public static volatile a uwq = null;
  public List<a> callbacks;
  private int fEi;
  private long lastShakeTime;
  public String path;
  public k uwr;
  private boolean uws;
  private boolean uwt;
  private boolean uwu;
  public ShakeManager uwv;
  public SensorController uww;
  
  private a()
  {
    AppMethodBeat.i(182004);
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
        break label187;
      }
      this.uwr.a(this);
      this.uwr.a(this);
      this.uwr.dr(this.uws);
    }
    for (;;)
    {
      if (this.uww == null) {
        this.uww = new SensorController(MMApplicationContext.getContext());
      }
      if (this.uwv == null) {
        this.uwv = new ShakeManager(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(182004);
      return;
      bool = false;
      break;
      label187:
      Log.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public static a cTi()
  {
    AppMethodBeat.i(182005);
    if (uwq == null) {}
    try
    {
      if (uwq == null) {
        uwq = new a();
      }
      a locala = uwq;
      AppMethodBeat.o(182005);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(182005);
    }
  }
  
  private void cTj()
  {
    AppMethodBeat.i(182006);
    if ((this.uww != null) && (!this.uww.hasRegistered()))
    {
      this.uww.setSensorCallBack(this);
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182003);
          a.a(a.this, Util.currentTicks());
          AppMethodBeat.o(182003);
        }
      };
      if (this.uwv.startShake(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(182006);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(182006);
  }
  
  private void cTk()
  {
    AppMethodBeat.i(182007);
    if (this.uww != null) {
      this.uww.removeSensorCallBack();
    }
    if (this.uwv != null) {
      this.uwv.stopShake();
    }
    AppMethodBeat.o(182007);
  }
  
  public final double aeI()
  {
    AppMethodBeat.i(182011);
    if (this.uwr == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(182011);
      return 0.0D;
    }
    double d = this.uwr.aeI();
    AppMethodBeat.o(182011);
    return d;
  }
  
  public final boolean cTl()
  {
    AppMethodBeat.i(182010);
    if (this.uwr == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(182010);
      return false;
    }
    boolean bool = this.uwr.isPlaying();
    AppMethodBeat.o(182010);
    return bool;
  }
  
  public final boolean dt(String paramString, int paramInt)
  {
    AppMethodBeat.i(182008);
    if (this.uwr == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(182008);
      return false;
    }
    this.uwr.stop();
    cTj();
    this.path = paramString;
    this.fEi = paramInt;
    if ((!Util.isNullOrNil(paramString)) && (this.uwr.a(paramString, this.uws, true, paramInt)))
    {
      MMEntryLock.lock("keep_app_silent");
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.atP(paramString);
        }
      }
      AppMethodBeat.o(182008);
      return true;
    }
    AppMethodBeat.o(182008);
    return false;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(182013);
    Log.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    AppMethodBeat.o(182013);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(182012);
    Log.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    AppMethodBeat.o(182012);
  }
  
  public void onSensorEvent(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(182014);
    if (Util.isNullOrNil(this.path))
    {
      AppMethodBeat.o(182014);
      return;
    }
    if (this.uwu)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.uwu = paramBoolean;
        AppMethodBeat.o(182014);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.uwu = true;
      AppMethodBeat.o(182014);
      return;
    }
    this.uwu = false;
    if ((this.uwr != null) && (this.uwr.isCalling()))
    {
      AppMethodBeat.o(182014);
      return;
    }
    if (this.uwt)
    {
      if (this.uwr != null) {
        this.uwr.dr(false);
      }
      this.uws = false;
      AppMethodBeat.o(182014);
      return;
    }
    if ((this.uwr != null) && (!this.uwr.isPlaying()))
    {
      this.uwr.dr(true);
      this.uws = true;
      AppMethodBeat.o(182014);
      return;
    }
    if (this.uwr != null) {
      this.uwr.dr(paramBoolean);
    }
    this.uws = paramBoolean;
    if (!paramBoolean) {
      dt(this.path, this.fEi);
    }
    AppMethodBeat.o(182014);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(182009);
    Log.i("MicroMsg.RecordVoiceHelper", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.uwr != null)
    {
      this.uwr.stop();
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.cTh();
        }
      }
    }
    cTk();
    AppMethodBeat.o(182009);
  }
  
  static abstract interface a
  {
    public abstract void atP(String paramString);
    
    public abstract void cTh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.a
 * JD-Core Version:    0.7.0.1
 */