package com.tencent.mm.plugin.editor.widget.voiceview;

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

public class a
  implements h.a, h.b, SensorController.a
{
  public static volatile a pyp = null;
  public List<a> callbacks;
  private int dtc;
  private long lastShakeTime;
  public String path;
  public h pyq;
  private boolean pyr;
  private boolean pys;
  private boolean pyt;
  public bk pyu;
  public SensorController pyv;
  
  private a()
  {
    AppMethodBeat.i(182004);
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
        break label187;
      }
      this.pyq.a(this);
      this.pyq.a(this);
      this.pyq.cm(this.pyr);
    }
    for (;;)
    {
      if (this.pyv == null) {
        this.pyv = new SensorController(aj.getContext());
      }
      if (this.pyu == null) {
        this.pyu = new bk(aj.getContext());
      }
      AppMethodBeat.o(182004);
      return;
      bool = false;
      break;
      label187:
      ad.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  private void cfA()
  {
    AppMethodBeat.i(182006);
    if ((this.pyv != null) && (!this.pyv.aMy))
    {
      this.pyv.a(this);
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182003);
          a.a(a.this, bt.HI());
          AppMethodBeat.o(182003);
        }
      };
      if (this.pyu.aD(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(182006);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(182006);
  }
  
  private void cfB()
  {
    AppMethodBeat.i(182007);
    if (this.pyv != null) {
      this.pyv.flC();
    }
    if (this.pyu != null) {
      this.pyu.flD();
    }
    AppMethodBeat.o(182007);
  }
  
  public static a cfz()
  {
    AppMethodBeat.i(182005);
    if (pyp == null) {}
    try
    {
      if (pyp == null) {
        pyp = new a();
      }
      a locala = pyp;
      AppMethodBeat.o(182005);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(182005);
    }
  }
  
  public final double PF()
  {
    AppMethodBeat.i(182011);
    if (this.pyq == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(182011);
      return 0.0D;
    }
    double d = this.pyq.PF();
    AppMethodBeat.o(182011);
    return d;
  }
  
  public final boolean cQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(182008);
    if (this.pyq == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(182008);
      return false;
    }
    this.pyq.stop();
    cfA();
    this.path = paramString;
    this.dtc = paramInt;
    if ((!bt.isNullOrNil(paramString)) && (this.pyq.a(paramString, this.pyr, true, paramInt)))
    {
      an.aQu("keep_app_silent");
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.aaY(paramString);
        }
      }
      AppMethodBeat.o(182008);
      return true;
    }
    AppMethodBeat.o(182008);
    return false;
  }
  
  public final boolean cfC()
  {
    AppMethodBeat.i(182010);
    if (this.pyq == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(182010);
      return false;
    }
    boolean bool = this.pyq.isPlaying();
    AppMethodBeat.o(182010);
    return bool;
  }
  
  public final void kn(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(182014);
    if (bt.isNullOrNil(this.path))
    {
      AppMethodBeat.o(182014);
      return;
    }
    if (this.pyt)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.pyt = paramBoolean;
        AppMethodBeat.o(182014);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aO(this.lastShakeTime) > 400L))
    {
      this.pyt = true;
      AppMethodBeat.o(182014);
      return;
    }
    this.pyt = false;
    if ((this.pyq != null) && (this.pyq.PD()))
    {
      AppMethodBeat.o(182014);
      return;
    }
    if (this.pys)
    {
      if (this.pyq != null) {
        this.pyq.cm(false);
      }
      this.pyr = false;
      AppMethodBeat.o(182014);
      return;
    }
    if ((this.pyq != null) && (!this.pyq.isPlaying()))
    {
      this.pyq.cm(true);
      this.pyr = true;
      AppMethodBeat.o(182014);
      return;
    }
    if (this.pyq != null) {
      this.pyq.cm(paramBoolean);
    }
    this.pyr = paramBoolean;
    if (!paramBoolean) {
      cQ(this.path, this.dtc);
    }
    AppMethodBeat.o(182014);
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(182013);
    ad.d("MicroMsg.RecordVoiceHelper", "on completion, do stop play");
    stopPlay();
    AppMethodBeat.o(182013);
  }
  
  public final void onError()
  {
    AppMethodBeat.i(182012);
    ad.d("MicroMsg.RecordVoiceHelper", "on error, do stop play");
    stopPlay();
    AppMethodBeat.o(182012);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(182009);
    ad.i("MicroMsg.RecordVoiceHelper", "stop play");
    an.aQv("keep_app_silent");
    if (this.pyq != null)
    {
      this.pyq.stop();
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.cfy();
        }
      }
    }
    cfB();
    AppMethodBeat.o(182009);
  }
  
  static abstract interface a
  {
    public abstract void aaY(String paramString);
    
    public abstract void cfy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.a
 * JD-Core Version:    0.7.0.1
 */