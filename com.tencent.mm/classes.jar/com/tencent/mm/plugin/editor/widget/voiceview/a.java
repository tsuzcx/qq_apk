package com.tencent.mm.plugin.editor.widget.voiceview;

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

public class a
  implements i.a, i.b, SensorController.a
{
  public static volatile a orf = null;
  public List<a> callbacks;
  private int dkj;
  private long lastShakeTime;
  public i org;
  private boolean orh;
  private boolean ori;
  private boolean orj;
  public bk ork;
  public SensorController orl;
  public String path;
  
  private a()
  {
    AppMethodBeat.i(182004);
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
        break label187;
      }
      this.org.a(this);
      this.org.a(this);
      this.org.cj(this.orh);
    }
    for (;;)
    {
      if (this.orl == null) {
        this.orl = new SensorController(aj.getContext());
      }
      if (this.ork == null) {
        this.ork = new bk(aj.getContext());
      }
      AppMethodBeat.o(182004);
      return;
      bool = false;
      break;
      label187:
      ad.w("MicroMsg.RecordVoiceHelper", "get voice player fail, it is null");
    }
  }
  
  public static a bTH()
  {
    AppMethodBeat.i(182005);
    if (orf == null) {}
    try
    {
      if (orf == null) {
        orf = new a();
      }
      a locala = orf;
      AppMethodBeat.o(182005);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(182005);
    }
  }
  
  private void bTI()
  {
    AppMethodBeat.i(182006);
    if ((this.orl != null) && (!this.orl.aJR))
    {
      this.orl.a(this);
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(182003);
          a.a(a.this, bt.GC());
          AppMethodBeat.o(182003);
        }
      };
      if (this.ork.aC(local1))
      {
        this.lastShakeTime = 0L;
        AppMethodBeat.o(182006);
        return;
      }
      this.lastShakeTime = -1L;
    }
    AppMethodBeat.o(182006);
  }
  
  private void bTJ()
  {
    AppMethodBeat.i(182007);
    if (this.orl != null) {
      this.orl.eGx();
    }
    if (this.ork != null) {
      this.ork.eGy();
    }
    AppMethodBeat.o(182007);
  }
  
  public final double Oa()
  {
    AppMethodBeat.i(182011);
    if (this.org == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "get now progress error, player is null");
      AppMethodBeat.o(182011);
      return 0.0D;
    }
    double d = this.org.Oa();
    AppMethodBeat.o(182011);
    return d;
  }
  
  public final boolean bTK()
  {
    AppMethodBeat.i(182010);
    if (this.org == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "check is play, but player is null");
      AppMethodBeat.o(182010);
      return false;
    }
    boolean bool = this.org.isPlaying();
    AppMethodBeat.o(182010);
    return bool;
  }
  
  public final boolean cI(String paramString, int paramInt)
  {
    AppMethodBeat.i(182008);
    if (this.org == null)
    {
      ad.w("MicroMsg.RecordVoiceHelper", "start play error, path %s, voiceType %d, player is null", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(182008);
      return false;
    }
    this.org.stop();
    bTI();
    this.path = paramString;
    this.dkj = paramInt;
    if ((!bt.isNullOrNil(paramString)) && (this.org.a(paramString, this.orh, true, paramInt)))
    {
      an.aFx("keep_app_silent");
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.Tf(paramString);
        }
      }
      AppMethodBeat.o(182008);
      return true;
    }
    AppMethodBeat.o(182008);
    return false;
  }
  
  public final void jz(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(182014);
    if (bt.isNullOrNil(this.path))
    {
      AppMethodBeat.o(182014);
      return;
    }
    if (this.orj)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.orj = paramBoolean;
        AppMethodBeat.o(182014);
        return;
      }
    }
    if ((!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aS(this.lastShakeTime) > 400L))
    {
      this.orj = true;
      AppMethodBeat.o(182014);
      return;
    }
    this.orj = false;
    if ((this.org != null) && (this.org.NY()))
    {
      AppMethodBeat.o(182014);
      return;
    }
    if (this.ori)
    {
      if (this.org != null) {
        this.org.cj(false);
      }
      this.orh = false;
      AppMethodBeat.o(182014);
      return;
    }
    if ((this.org != null) && (!this.org.isPlaying()))
    {
      this.org.cj(true);
      this.orh = true;
      AppMethodBeat.o(182014);
      return;
    }
    if (this.org != null) {
      this.org.cj(paramBoolean);
    }
    this.orh = paramBoolean;
    if (!paramBoolean) {
      cI(this.path, this.dkj);
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
    an.aFy("keep_app_silent");
    if (this.org != null)
    {
      this.org.stop();
      Iterator localIterator = this.callbacks.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.bTG();
        }
      }
    }
    bTJ();
    AppMethodBeat.o(182009);
  }
  
  static abstract interface a
  {
    public abstract void Tf(String paramString);
    
    public abstract void bTG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.voiceview.a
 * JD-Core Version:    0.7.0.1
 */