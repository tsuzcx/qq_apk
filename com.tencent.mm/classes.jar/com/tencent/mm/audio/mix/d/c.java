package com.tencent.mm.audio.mix.d;

import android.text.TextUtils;
import com.tencent.mm.audio.mix.f.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c
  implements k, f
{
  protected volatile String ceu;
  protected volatile com.tencent.mm.audio.mix.g.b cfB;
  protected volatile com.tencent.mm.ag.b cfC;
  protected com.tencent.mm.audio.mix.c.g cfD;
  protected int cfE = 0;
  protected volatile String cfF;
  public volatile String cfG;
  protected AtomicBoolean cfH = new AtomicBoolean(false);
  protected AtomicInteger cfI = new AtomicInteger(0);
  protected AtomicBoolean cfJ = new AtomicBoolean(false);
  protected AtomicBoolean cfK = new AtomicBoolean(false);
  protected AtomicBoolean cfL = new AtomicBoolean(false);
  protected AtomicBoolean cfM = new AtomicBoolean(false);
  protected AtomicBoolean cfN = new AtomicBoolean(false);
  protected volatile com.tencent.mm.audio.mix.f.d cfs;
  protected int channels = 0;
  protected Object lock = new Object();
  protected int sampleRate = 0;
  protected int startTime;
  
  protected c(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb)
  {
    this.cfs = paramd;
    this.cfB = paramb;
    this.cfC = this.cfB.En();
    this.ceu = this.cfC.ceu;
    this.cfF = this.cfC.filePath;
    this.startTime = this.cfC.startTime;
    this.cfG = this.cfC.cfG;
  }
  
  private String DF()
  {
    com.tencent.mm.ag.b localb = DE();
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "param is null");
      return this.ceu;
    }
    return localb.ceu;
  }
  
  private void d(int paramInt1, int paramInt2, String paramString)
  {
    int i = 2;
    if (this.cfs == null) {
      return;
    }
    this.cfI.set(paramInt1);
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      if (paramInt1 == 3) {
        i = 9;
      }
    }
    for (;;)
    {
      String str = DF();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      com.tencent.mm.audio.mix.f.d locald = this.cfs;
      if (i == -1) {
        break;
      }
      if ((locald != null) && (i == 4))
      {
        locald.a(i, str, paramInt2, paramString);
        return;
        if (paramInt1 == 2)
        {
          i = 7;
          continue;
        }
        if (paramInt1 == 4)
        {
          i = 0;
          continue;
        }
        if (paramInt1 == 5) {
          continue;
        }
        if (paramInt1 == 6)
        {
          i = 3;
          continue;
        }
        if (paramInt1 == 7)
        {
          i = 5;
          continue;
        }
        if (paramInt1 == 9)
        {
          i = 4;
          continue;
        }
        if (paramInt1 == 11)
        {
          i = 6;
          continue;
        }
        if (paramInt1 == 12)
        {
          i = 10;
          continue;
        }
        if (paramInt1 == 13)
        {
          i = 11;
          continue;
        }
        if (paramInt1 == 14) {
          i = 12;
        }
      }
      else
      {
        if (locald == null) {
          break;
        }
        locald.e(i, str, this.cfG);
        return;
      }
      i = -1;
    }
  }
  
  private boolean isError()
  {
    return this.cfI.get() == 9;
  }
  
  private boolean isPlaying()
  {
    return this.cfI.get() == 4;
  }
  
  public final void DA()
  {
    if ((!this.cfM.get()) && (!this.cfK.get()))
    {
      this.cfM.set(true);
      gs(13);
    }
  }
  
  protected void DB() {}
  
  protected void DC() {}
  
  public void DD() {}
  
  public final com.tencent.mm.ag.b DE()
  {
    if (this.cfB != null) {
      return this.cfB.En();
    }
    return this.cfC;
  }
  
  public final void Do()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload");
    this.cfH.set(true);
    gs(10);
  }
  
  public void Dp()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
    pause();
  }
  
  public void Dq()
  {
    Object localObject = this.cfs.chs;
    String str = DF();
    if (((com.tencent.mm.audio.mix.e.c)localObject).cgq.containsKey(str))
    {
      localObject = (WeakReference)((com.tencent.mm.audio.mix.e.c)localObject).cgq.remove(str);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((WeakReference)localObject).clear();
      }
    }
  }
  
  public final void Dr()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", new Object[] { Boolean.TRUE });
    this.cfK.set(true);
    gs(9);
    com.tencent.mm.audio.mix.a.c localc = Du();
    if ((localc != null) && (!localc.cep)) {
      localc.reset();
    }
  }
  
  public final boolean Ds()
  {
    return this.cfJ.get();
  }
  
  public final boolean Dt()
  {
    return this.cfK.get();
  }
  
  public final com.tencent.mm.audio.mix.a.c Du()
  {
    return com.tencent.mm.audio.mix.b.d.De().dR(this.cfF);
  }
  
  protected final void Dv()
  {
    synchronized (this.lock)
    {
      for (;;)
      {
        if (!this.cfK.get())
        {
          boolean bool = this.cfJ.get();
          if (bool) {
            try
            {
              com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "waitDecode");
              this.lock.wait();
            }
            catch (Exception localException)
            {
              com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", localException, "waitDecode", new Object[0]);
            }
          }
        }
      }
    }
  }
  
  protected final void Dw()
  {
    synchronized (this.lock)
    {
      try
      {
        this.lock.notify();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", localException, "notifyDecode", new Object[0]);
        }
      }
    }
  }
  
  public final void Dx()
  {
    if (this.cfs.chv != null) {
      this.cfs.chv.gx(DE().fromScene);
    }
    this.cfF = DE().filePath;
    if (TextUtils.isEmpty(this.cfF))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "source path is null");
      this.cfE = 712;
      onError(this.cfE);
      return;
    }
    Object localObject = DE();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", new Object[] { this.cfF, Boolean.valueOf(((com.tencent.mm.ag.b)localObject).fqY) });
    if (this.cfH.get())
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
      if (((com.tencent.mm.ag.b)localObject).frk)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload begin");
        if (!com.tencent.mm.audio.mix.b.d.De().dT(this.cfF)) {
          Dy();
        }
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload end");
          return;
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
        }
      }
      if (!isPlaying()) {
        gs(3);
      }
      if (!com.tencent.mm.audio.mix.b.d.De().dT(this.cfF)) {
        Dy();
      }
      for (;;)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
        this.cfH.set(false);
        com.tencent.mm.audio.mix.a.c localc = Du();
        if (!this.cfK.get()) {
          break label270;
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
        if (!localc.cep) {
          break;
        }
        gs(2);
        return;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
      }
      label270:
      if (isError())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
        return;
      }
      if ((isPlaying()) || (((com.tencent.mm.ag.b)localObject).fqX))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "to play");
        gs(2);
      }
    }
    else
    {
      gs(4);
    }
    for (;;)
    {
      label335:
      int i;
      if (!com.tencent.mm.audio.mix.b.d.De().dT(this.cfF))
      {
        Dy();
        if ((!((com.tencent.mm.ag.b)localObject).fqY) || (this.cfK.get())) {
          break label488;
        }
        i = 1;
        if (i != 0) {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", new Object[] { DF() });
        }
      }
      try
      {
        Thread.sleep(20L);
        this.startTime = 0;
        if (i != 0) {
          continue;
        }
        if ((this.cfK.get()) || (isError()))
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
          localObject = DE().filePath;
          if (this.cfB.equals(localObject))
          {
            this.cfs.chs.eg(DF());
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "task end");
            return;
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not to play");
            gs(2);
            return;
            Dz();
            break label335;
            label488:
            i = 0;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "sleep exception");
          continue;
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "change src only, don't removeAudio");
          continue;
          if (!this.cfs.chs.ei(DF()))
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
            this.cfs.chs.m(DF(), true);
          }
          else
          {
            gs(7);
            this.cfs.chs.eg(DF());
          }
        }
      }
    }
  }
  
  protected abstract void Dy();
  
  protected final void Dz()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
    com.tencent.mm.audio.mix.a.c localc = Du();
    if (localc == null) {
      return;
    }
    DB();
    int j = localc.size();
    int i = 0;
    while ((i < j) && (!this.cfK.get()))
    {
      Dv();
      com.tencent.mm.audio.mix.a.d locald = localc.gp(i);
      if (locald != null) {
        a(locald);
      }
      i += 1;
    }
    DC();
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.c paramc)
  {
    if (this.cfD == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "process is null");
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
    DB();
    com.tencent.mm.audio.mix.a.d locald;
    if (!this.cfK.get())
    {
      Dv();
      locald = this.cfD.Dl();
      if ((paramc.size() <= 0) || (locald != null)) {
        break label72;
      }
      paramc.complete();
    }
    for (;;)
    {
      DC();
      return;
      label72:
      if ((paramc.size() == 0) && (locald == null))
      {
        paramc.reset();
      }
      else if (locald != null)
      {
        if (!paramc.cep) {
          paramc.a(locald);
        }
        a(locald);
        if (locald != null) {
          break;
        }
      }
    }
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.d paramd)
  {
    if (this.cfH.get()) {}
    while ((paramd == null) || ((paramd.cex > 0L) && (this.startTime > 0) && (paramd.cex < this.startTime)) || (this.cfs == null) || (this.cfs.chs == null) || (paramd == null)) {
      return;
    }
    paramd.ceu = DF();
    c(paramd);
  }
  
  protected void c(com.tencent.mm.audio.mix.a.d arg1)
  {
    int i;
    if (this.cfB.En().cer)
    {
      if (!this.cfN.get())
      {
        this.cfN.set(true);
        gs(14);
      }
      i = this.cfs.chs.a(DF(), ???, this);
      if (i < 50) {
        this.cfL.set(false);
      }
    }
    else
    {
      return;
    }
    ??? = Du();
    if ((??? != null) && (???.cep))
    {
      this.cfL.set(true);
      try
      {
        synchronized (this.lock)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "lockWriteBuffer, writeSize:%d", new Object[] { Integer.valueOf(i) });
          this.lock.wait();
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", localException, "lockWriteBuffer", new Object[0]);
        }
      }
    }
    this.cfL.set(false);
  }
  
  public final void gr(int paramInt)
  {
    if (paramInt >= 20) {}
    while ((!this.cfL.get()) || (this.cfJ.get()) || (this.cfK.get())) {
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", new Object[] { Integer.valueOf(paramInt) });
    Dw();
  }
  
  protected final void gs(int paramInt)
  {
    d(paramInt, 0, "");
  }
  
  public final void init()
  {
    this.startTime = this.cfB.En().fqW;
    this.cfJ.set(false);
    this.cfK.set(false);
    if (this.cfB != null) {
      com.tencent.mm.audio.mix.g.b localb = this.cfB;
    }
    gs(1);
  }
  
  public final void onError(int paramInt)
  {
    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.cfE = paramInt;
    this.cfK.set(true);
    d(9, paramInt, "");
  }
  
  public void pause()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pause");
    gs(5);
    this.cfJ.set(true);
    this.cfM.set(false);
  }
  
  public final void release()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "release");
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "duration:%d", new Object[] { Long.valueOf(Du().duration) });
    Dq();
    onRelease();
    if (this.cfB != null)
    {
      this.cfB.En().startTime = 0;
      com.tencent.mm.audio.mix.g.b localb = this.cfB;
    }
    this.cfH.set(false);
    this.cfK.set(true);
    this.cfJ.set(false);
    this.cfL.set(false);
    this.cfs = null;
  }
  
  public final void resume()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "resume");
    gs(4);
    synchronized (this.lock)
    {
      if (this.cfJ.get()) {
        this.cfJ.set(false);
      }
      try
      {
        this.lock.notify();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", localException, "resume", new Object[0]);
        }
      }
    }
  }
  
  public void seek(int paramInt)
  {
    int i = this.startTime;
    this.startTime = paramInt;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
  }
  
  public final void stop()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stop");
    DD();
    gs(6);
    this.cfK.set(true);
    this.cfJ.set(false);
    Dw();
    this.cfM.set(false);
    this.cfN.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.c
 * JD-Core Version:    0.7.0.1
 */