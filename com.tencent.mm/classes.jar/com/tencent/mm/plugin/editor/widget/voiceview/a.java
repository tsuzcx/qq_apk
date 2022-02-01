package com.tencent.mm.plugin.editor.widget.voiceview;

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

public class a
  implements h.a, h.b, SensorController.a
{
  public static volatile a pET = null;
  public List<a> callbacks;
  private int dui;
  private long lastShakeTime;
  public h pEU;
  private boolean pEV;
  private boolean pEW;
  private boolean pEX;
  public bl pEY;
  public SensorController pEZ;
  public String path;
  
  private a()
  {
    AppMethodBeat.i(182004);
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
        break label187;
      }
      this.pEU.a(this);
      this.pEU.a(this);
      this.pEU.cm(this.pEV);
    }
    for (;;)
    {
      if (this.pEZ == null) {
        this.pEZ = new SensorController(ak.getContext());
      }
      if (this.pEY == null) {
        this.pEY = new bl(ak.getContext());
      }
      AppMethodBeat.o(182004);
      return;
      bool = false;
      break;
      label187:
      ae.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public static a cgP()
  {
    AppMethodBeat.i(182005);
    if (pET == null) {}
    try
    {
      if (pET == null) {
        pET = new a();
      }
      a locala = pET;
      AppMethodBeat.o(182005);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(182005);
    }
  }
  
  private void cgQ()
  {
    AppMethodBeat.i(182006);
    if ((this.pEZ != null) && (!this.pEZ.aMy))
    {
      this.pEZ.a(this);
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182003);
          a.a(a.this, bu.HQ());
          AppMethodBeat.o(182003);
        }
      };
      if (this.pEY.aB(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(182006);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(182006);
  }
  
  private void cgR()
  {
    AppMethodBeat.i(182007);
    if (this.pEZ != null) {
      this.pEZ.fpx();
    }
    if (this.pEY != null) {
      this.pEY.fpy();
    }
    AppMethodBeat.o(182007);
  }
  
  public final double PE()
  {
    AppMethodBeat.i(182011);
    if (this.pEU == null)
    {
      ae.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(182011);
      return 0.0D;
    }
    double d = this.pEU.PE();
    AppMethodBeat.o(182011);
    return d;
  }
  
  public final boolean cU(String paramString, int paramInt)
  {
    AppMethodBeat.i(182008);
    if (this.pEU == null)
    {
      ae.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(182008);
      return false;
    }
    this.pEU.stop();
    cgQ();
    this.path = paramString;
    this.dui = paramInt;
    if ((!bu.isNullOrNil(paramString)) && (this.pEU.a(paramString, this.pEV, true, paramInt)))
    {
      ao.aRR("keep_app_silent");
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.abP(paramString);
        }
      }
      AppMethodBeat.o(182008);
      return true;
    }
    AppMethodBeat.o(182008);
    return false;
  }
  
  public final boolean cgS()
  {
    AppMethodBeat.i(182010);
    if (this.pEU == null)
    {
      ae.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(182010);
      return false;
    }
    boolean bool = this.pEU.isPlaying();
    AppMethodBeat.o(182010);
    return bool;
  }
  
  public final void km(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(182014);
    if (bu.isNullOrNil(this.path))
    {
      AppMethodBeat.o(182014);
      return;
    }
    if (this.pEX)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.pEX = paramBoolean;
        AppMethodBeat.o(182014);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bu.aO(this.lastShakeTime) > 400L))
    {
      this.pEX = true;
      AppMethodBeat.o(182014);
      return;
    }
    this.pEX = false;
    if ((this.pEU != null) && (this.pEU.PC()))
    {
      AppMethodBeat.o(182014);
      return;
    }
    if (this.pEW)
    {
      if (this.pEU != null) {
        this.pEU.cm(false);
      }
      this.pEV = false;
      AppMethodBeat.o(182014);
      return;
    }
    if ((this.pEU != null) && (!this.pEU.isPlaying()))
    {
      this.pEU.cm(true);
      this.pEV = true;
      AppMethodBeat.o(182014);
      return;
    }
    if (this.pEU != null) {
      this.pEU.cm(paramBoolean);
    }
    this.pEV = paramBoolean;
    if (!paramBoolean) {
      cU(this.path, this.dui);
    }
    AppMethodBeat.o(182014);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(182013);
    ae.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    AppMethodBeat.o(182013);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(182012);
    ae.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    AppMethodBeat.o(182012);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(182009);
    ae.i("MicroMsg.RecordVoiceHelper", "stop play");
    ao.aRS("keep_app_silent");
    if (this.pEU != null)
    {
      this.pEU.stop();
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.cgO();
        }
      }
    }
    cgR();
    AppMethodBeat.o(182009);
  }
  
  static abstract interface a
  {
    public abstract void abP(String paramString);
    
    public abstract void cgO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.a
 * JD-Core Version:    0.7.0.1
 */