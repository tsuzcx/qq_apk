package com.tencent.mm.plugin.editor.widget.voiceview;

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

public class a
  implements j.a, j.b, SensorController.SensorEventCallBack
{
  public static volatile a xCP = null;
  public List<a> bPE;
  private int hIY;
  private long lastShakeTime;
  public String path;
  public j xCQ;
  private boolean xCR;
  private boolean xCS;
  private boolean xCT;
  public ShakeManager xCU;
  public SensorController xCV;
  
  private a()
  {
    AppMethodBeat.i(182004);
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
        break label187;
      }
      this.xCQ.a(this);
      this.xCQ.a(this);
      this.xCQ.ed(this.xCR);
    }
    for (;;)
    {
      if (this.xCV == null) {
        this.xCV = new SensorController(MMApplicationContext.getContext());
      }
      if (this.xCU == null) {
        this.xCU = new ShakeManager(MMApplicationContext.getContext());
      }
      AppMethodBeat.o(182004);
      return;
      bool = false;
      break;
      label187:
      Log.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public static a dxB()
  {
    AppMethodBeat.i(182005);
    if (xCP == null) {}
    try
    {
      if (xCP == null) {
        xCP = new a();
      }
      a locala = xCP;
      AppMethodBeat.o(182005);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(182005);
    }
  }
  
  private void dxC()
  {
    AppMethodBeat.i(182006);
    if ((this.xCV != null) && (!this.xCV.hasRegistered()))
    {
      this.xCV.setSensorCallBack(this);
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182003);
          a.a(a.this, Util.currentTicks());
          AppMethodBeat.o(182003);
        }
      };
      if (this.xCU.startShake(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(182006);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(182006);
  }
  
  private void dxD()
  {
    AppMethodBeat.i(182007);
    if (this.xCV != null) {
      this.xCV.removeSensorCallBack();
    }
    if (this.xCU != null) {
      this.xCU.stopShake();
    }
    AppMethodBeat.o(182007);
  }
  
  public final double aGG()
  {
    AppMethodBeat.i(182011);
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(182011);
      return 0.0D;
    }
    double d = this.xCQ.aGG();
    AppMethodBeat.o(182011);
    return d;
  }
  
  public final void atR()
  {
    AppMethodBeat.i(182012);
    Log.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    AppMethodBeat.o(182012);
  }
  
  public final boolean dU(String paramString, int paramInt)
  {
    AppMethodBeat.i(182008);
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(182008);
      return false;
    }
    this.xCQ.stop();
    dxC();
    this.path = paramString;
    this.hIY = paramInt;
    if ((!Util.isNullOrNil(paramString)) && (this.xCQ.a(paramString, this.xCR, true, paramInt)))
    {
      MMEntryLock.lock("keep_app_silent");
      Iterator localIterator = this.bPE.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.anE(paramString);
        }
      }
      AppMethodBeat.o(182008);
      return true;
    }
    AppMethodBeat.o(182008);
    return false;
  }
  
  public final boolean dxE()
  {
    AppMethodBeat.i(182010);
    if (this.xCQ == null)
    {
      Log.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(182010);
      return false;
    }
    boolean bool = this.xCQ.isPlaying();
    AppMethodBeat.o(182010);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(182013);
    Log.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    AppMethodBeat.o(182013);
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
    if (this.xCT)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.xCT = paramBoolean;
        AppMethodBeat.o(182014);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (Util.ticksToNow(this.lastShakeTime) > 400L))
    {
      this.xCT = true;
      AppMethodBeat.o(182014);
      return;
    }
    this.xCT = false;
    if ((this.xCQ != null) && (this.xCQ.isCalling()))
    {
      AppMethodBeat.o(182014);
      return;
    }
    if (this.xCS)
    {
      if (this.xCQ != null) {
        this.xCQ.ed(false);
      }
      this.xCR = false;
      AppMethodBeat.o(182014);
      return;
    }
    if ((this.xCQ != null) && (!this.xCQ.isPlaying()))
    {
      this.xCQ.ed(true);
      this.xCR = true;
      AppMethodBeat.o(182014);
      return;
    }
    if (this.xCQ != null) {
      this.xCQ.ed(paramBoolean);
    }
    this.xCR = paramBoolean;
    if (!paramBoolean) {
      dU(this.path, this.hIY);
    }
    AppMethodBeat.o(182014);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(182009);
    Log.i("MicroMsg.RecordVoiceHelper", "stop play");
    MMEntryLock.unlock("keep_app_silent");
    if (this.xCQ != null)
    {
      this.xCQ.stop();
      Iterator localIterator = this.bPE.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.dxA();
        }
      }
    }
    dxD();
    AppMethodBeat.o(182009);
  }
  
  static abstract interface a
  {
    public abstract void anE(String paramString);
    
    public abstract void dxA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.a
 * JD-Core Version:    0.7.0.1
 */