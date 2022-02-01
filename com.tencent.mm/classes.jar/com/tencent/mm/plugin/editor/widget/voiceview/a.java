package com.tencent.mm.plugin.editor.widget.voiceview;

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

public class a
  implements i.a, i.b, SensorController.a
{
  public static volatile a oUF = null;
  public List<a> callbacks;
  private int dhE;
  private long lastShakeTime;
  public i oUG;
  private boolean oUH;
  private boolean oUI;
  private boolean oUJ;
  public bj oUK;
  public SensorController oUL;
  public String path;
  
  private a()
  {
    AppMethodBeat.i(182004);
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
        break label187;
      }
      this.oUG.a(this);
      this.oUG.a(this);
      this.oUG.cl(this.oUH);
    }
    for (;;)
    {
      if (this.oUL == null) {
        this.oUL = new SensorController(ai.getContext());
      }
      if (this.oUK == null) {
        this.oUK = new bj(ai.getContext());
      }
      AppMethodBeat.o(182004);
      return;
      bool = false;
      break;
      label187:
      ac.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public static a caV()
  {
    AppMethodBeat.i(182005);
    if (oUF == null) {}
    try
    {
      if (oUF == null) {
        oUF = new a();
      }
      a locala = oUF;
      AppMethodBeat.o(182005);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(182005);
    }
  }
  
  private void caW()
  {
    AppMethodBeat.i(182006);
    if ((this.oUL != null) && (!this.oUL.aKH))
    {
      this.oUL.a(this);
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182003);
          a.a(a.this, bs.Gn());
          AppMethodBeat.o(182003);
        }
      };
      if (this.oUK.aE(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(182006);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(182006);
  }
  
  private void caX()
  {
    AppMethodBeat.i(182007);
    if (this.oUL != null) {
      this.oUL.eVS();
    }
    if (this.oUK != null) {
      this.oUK.eVT();
    }
    AppMethodBeat.o(182007);
  }
  
  public final double NW()
  {
    AppMethodBeat.i(182011);
    if (this.oUG == null)
    {
      ac.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(182011);
      return 0.0D;
    }
    double d = this.oUG.NW();
    AppMethodBeat.o(182011);
    return d;
  }
  
  public final boolean cN(String paramString, int paramInt)
  {
    AppMethodBeat.i(182008);
    if (this.oUG == null)
    {
      ac.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(182008);
      return false;
    }
    this.oUG.stop();
    caW();
    this.path = paramString;
    this.dhE = paramInt;
    if ((!bs.isNullOrNil(paramString)) && (this.oUG.a(paramString, this.oUH, true, paramInt)))
    {
      am.aKO("keep_app_silent");
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.Xr(paramString);
        }
      }
      AppMethodBeat.o(182008);
      return true;
    }
    AppMethodBeat.o(182008);
    return false;
  }
  
  public final boolean caY()
  {
    AppMethodBeat.i(182010);
    if (this.oUG == null)
    {
      ac.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(182010);
      return false;
    }
    boolean bool = this.oUG.isPlaying();
    AppMethodBeat.o(182010);
    return bool;
  }
  
  public final void kc(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(182014);
    if (bs.isNullOrNil(this.path))
    {
      AppMethodBeat.o(182014);
      return;
    }
    if (this.oUJ)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.oUJ = paramBoolean;
        AppMethodBeat.o(182014);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bs.aO(this.lastShakeTime) > 400L))
    {
      this.oUJ = true;
      AppMethodBeat.o(182014);
      return;
    }
    this.oUJ = false;
    if ((this.oUG != null) && (this.oUG.NU()))
    {
      AppMethodBeat.o(182014);
      return;
    }
    if (this.oUI)
    {
      if (this.oUG != null) {
        this.oUG.cl(false);
      }
      this.oUH = false;
      AppMethodBeat.o(182014);
      return;
    }
    if ((this.oUG != null) && (!this.oUG.isPlaying()))
    {
      this.oUG.cl(true);
      this.oUH = true;
      AppMethodBeat.o(182014);
      return;
    }
    if (this.oUG != null) {
      this.oUG.cl(paramBoolean);
    }
    this.oUH = paramBoolean;
    if (!paramBoolean) {
      cN(this.path, this.dhE);
    }
    AppMethodBeat.o(182014);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(182013);
    ac.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    AppMethodBeat.o(182013);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(182012);
    ac.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    AppMethodBeat.o(182012);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(182009);
    ac.i("MicroMsg.RecordVoiceHelper", "stop play");
    am.aKP("keep_app_silent");
    if (this.oUG != null)
    {
      this.oUG.stop();
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.caU();
        }
      }
    }
    caX();
    AppMethodBeat.o(182009);
  }
  
  static abstract interface a
  {
    public abstract void Xr(String paramString);
    
    public abstract void caU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.a
 * JD-Core Version:    0.7.0.1
 */