package com.tencent.mm.audio.mix.decode;

import android.text.TextUtils;
import com.tencent.mm.audio.mix.a.e;
import com.tencent.mm.audio.mix.c.h;
import com.tencent.mm.audio.mix.f.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c
  implements l, com.tencent.mm.audio.mix.f.f
{
  protected int channels = 0;
  protected volatile String hqQ;
  protected volatile com.tencent.mm.audio.mix.f.d hrT;
  protected volatile com.tencent.mm.audio.mix.g.c hsc;
  protected volatile com.tencent.mm.al.b hsd;
  protected h hse;
  protected int hsf = 0;
  public volatile String hsg;
  protected AtomicBoolean hsh = new AtomicBoolean(false);
  protected AtomicInteger hsi = new AtomicInteger(0);
  protected AtomicBoolean hsj = new AtomicBoolean(false);
  protected AtomicBoolean hsk = new AtomicBoolean(false);
  protected AtomicBoolean hsl = new AtomicBoolean(false);
  protected AtomicBoolean hsm = new AtomicBoolean(false);
  protected AtomicBoolean hsn = new AtomicBoolean(false);
  protected int hso = -1;
  protected Object hsp = new Object();
  protected Object lock = new Object();
  protected int sampleRate = 0;
  protected volatile String sourcePath;
  protected int startTime;
  
  protected c(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.c paramc)
  {
    this.hrT = paramd;
    this.hsc = paramc;
    this.hsd = this.hsc.aGB();
    this.hqQ = this.hsd.hqQ;
    this.sourcePath = this.hsd.filePath;
    this.startTime = this.hsd.startTime;
    this.hsg = this.hsd.hsg;
  }
  
  private String aFS()
  {
    com.tencent.mm.al.b localb = aFR();
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "param is null");
      return this.hqQ;
    }
    return localb.hqQ;
  }
  
  private void e(int paramInt1, int paramInt2, String paramString)
  {
    int i = 2;
    if (this.hrT == null) {
      return;
    }
    this.hsi.set(paramInt1);
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      if (paramInt1 == 3) {
        i = 9;
      }
    }
    for (;;)
    {
      String str = aFS();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      com.tencent.mm.audio.mix.f.d locald = this.hrT;
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
        if (paramInt1 == 14)
        {
          i = 12;
          continue;
        }
        if (paramInt1 == 15) {
          i = 13;
        }
      }
      else
      {
        if (locald == null) {
          break;
        }
        locald.h(i, str, this.hsg);
        return;
      }
      i = -1;
    }
  }
  
  private boolean isError()
  {
    return this.hsi.get() == 9;
  }
  
  private boolean isPlaying()
  {
    return this.hsi.get() == 4;
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.d paramd)
  {
    if (this.hse == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "process is null");
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
    aFP();
    e locale;
    if (!this.hsk.get())
    {
      aFJ();
      locale = this.hse.aFy();
      if ((paramd.size() <= 0) || (locale != null)) {
        break label70;
      }
      paramd.GK();
    }
    for (;;)
    {
      aFQ();
      return;
      label70:
      if ((paramd.size() == 0) && (locale == null))
      {
        paramd.reset();
      }
      else if (locale != null)
      {
        if (!paramd.ckB) {
          paramd.a(locale);
        }
        a(locale);
        if (locale != null) {
          break;
        }
      }
    }
  }
  
  protected final void a(e parame)
  {
    if (this.hsh.get()) {}
    while ((parame == null) || ((parame.hqT > 0L) && (this.startTime > 0) && (parame.hqT < this.startTime)) || (this.hrT == null) || (this.hrT.huj == null) || (parame == null)) {
      return;
    }
    parame.hqQ = aFS();
    c(parame);
  }
  
  public final void aFB()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload");
    this.hsh.set(true);
    ob(10);
  }
  
  public void aFC()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
    pause();
  }
  
  public void aFD()
  {
    Object localObject = this.hrT.huj;
    String str = aFS();
    if (((com.tencent.mm.audio.mix.e.c)localObject).hte.containsKey(str))
    {
      localObject = (WeakReference)((com.tencent.mm.audio.mix.e.c)localObject).hte.remove(str);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((WeakReference)localObject).clear();
      }
    }
  }
  
  public final void aFE()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", new Object[] { Boolean.TRUE });
    this.hsk.set(true);
    ob(9);
    com.tencent.mm.audio.mix.a.d locald = aFI();
    if ((locald != null) && (!locald.ckB)) {
      locald.reset();
    }
  }
  
  public final boolean aFF()
  {
    return this.hsj.get();
  }
  
  public final boolean aFG()
  {
    return this.hsk.get();
  }
  
  public final boolean aFH()
  {
    return (this.hsi.get() == 8) || (this.hsi.get() == 7);
  }
  
  public final com.tencent.mm.audio.mix.a.d aFI()
  {
    return com.tencent.mm.audio.mix.b.f.aFr().iR(this.sourcePath);
  }
  
  protected final void aFJ()
  {
    synchronized (this.lock)
    {
      for (;;)
      {
        if (!this.hsk.get())
        {
          boolean bool = this.hsj.get();
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
  
  protected final void aFK()
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
  
  public final void aFL()
  {
    if (this.hrT.hum != null) {
      this.hrT.hum.oi(aFR().fromScene);
    }
    this.sourcePath = aFR().filePath;
    if (TextUtils.isEmpty(this.sourcePath))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "source path is null");
      this.hsf = 712;
      oc(this.hsf);
      return;
    }
    Object localObject = aFR();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", new Object[] { this.sourcePath, Boolean.valueOf(((com.tencent.mm.al.b)localObject).loop) });
    if (this.hsh.get())
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
      if (((com.tencent.mm.al.b)localObject).ory)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload begin");
        if (!com.tencent.mm.audio.mix.b.f.aFr().iT(this.sourcePath)) {
          aFM();
        }
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload end");
          ob(15);
          return;
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
        }
      }
      if (!isPlaying()) {
        ob(3);
      }
      if (!com.tencent.mm.audio.mix.b.f.aFr().iT(this.sourcePath)) {
        aFM();
      }
      for (;;)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
        this.hsh.set(false);
        com.tencent.mm.audio.mix.a.d locald = aFI();
        if (!this.hsk.get()) {
          break label276;
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
        if (!locald.ckB) {
          break;
        }
        ob(2);
        return;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
      }
      label276:
      if (isError())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
        return;
      }
      if ((isPlaying()) || (((com.tencent.mm.al.b)localObject).orj))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "to play");
        ob(2);
      }
    }
    else
    {
      ob(4);
    }
    for (;;)
    {
      label341:
      int i;
      if (!com.tencent.mm.audio.mix.b.f.aFr().iT(this.sourcePath))
      {
        aFM();
        if ((!((com.tencent.mm.al.b)localObject).loop) || (this.hsk.get())) {
          break label494;
        }
        i = 1;
        if (i != 0) {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", new Object[] { aFS() });
        }
      }
      try
      {
        Thread.sleep(20L);
        this.startTime = 0;
        if (i != 0) {
          continue;
        }
        if ((this.hsk.get()) || (isError()))
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
          localObject = aFR().filePath;
          if (this.hsc.equals(localObject))
          {
            this.hrT.huj.jh(aFS());
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "task end");
            return;
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not to play");
            ob(2);
            return;
            aFN();
            break label341;
            label494:
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
          if (!this.hrT.huj.jk(aFS()))
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
            this.hrT.huj.p(aFS(), true);
          }
          else
          {
            ob(7);
            this.hrT.huj.jh(aFS());
          }
        }
      }
    }
  }
  
  protected abstract void aFM();
  
  protected final void aFN()
  {
    int i = 0;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
    com.tencent.mm.audio.mix.a.d locald = aFI();
    if (locald == null) {
      return;
    }
    aFP();
    int k = locald.size();
    while ((i < k) && (!this.hsk.get()))
    {
      aFJ();
      Object localObject2 = this.hsp;
      int j = i;
      try
      {
        if (this.hso >= 0)
        {
          j = i;
          if (this.hso < k)
          {
            j = this.hso;
            this.hso = -1;
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "seek to pos:%s", new Object[] { Integer.valueOf(j) });
          }
        }
        localObject2 = locald.nY(j);
        if (localObject2 != null) {
          a((e)localObject2);
        }
        i = j + 1;
      }
      finally {}
    }
    aFQ();
  }
  
  public final void aFO()
  {
    if ((!this.hsm.get()) && (!this.hsk.get()))
    {
      this.hsm.set(true);
      ob(13);
    }
  }
  
  protected void aFP() {}
  
  protected void aFQ() {}
  
  public final com.tencent.mm.al.b aFR()
  {
    if (this.hsc != null) {
      return this.hsc.aGB();
    }
    return this.hsd;
  }
  
  protected void c(e arg1)
  {
    int i;
    if (this.hsc.aGB().hqN)
    {
      if (!this.hsn.get())
      {
        this.hsn.set(true);
        ob(14);
      }
      i = this.hrT.huj.a(aFS(), ???, this);
      if (i < 50) {
        this.hsl.set(false);
      }
    }
    else
    {
      return;
    }
    ??? = aFI();
    aFR();
    if ((??? != null) && (???.ckB))
    {
      this.hsl.set(true);
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
    this.hsl.set(false);
  }
  
  public long getCurrentPosition()
  {
    return -1L;
  }
  
  public final void init()
  {
    this.startTime = this.hsc.aGB().ori;
    this.hsj.set(false);
    this.hsk.set(false);
    if (this.hsc != null) {
      this.hsc.connect();
    }
    ob(1);
  }
  
  public final void oa(int paramInt)
  {
    if (paramInt >= 20) {}
    while ((!this.hsl.get()) || (this.hsj.get()) || (this.hsk.get())) {
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", new Object[] { Integer.valueOf(paramInt) });
    aFK();
  }
  
  protected final void ob(int paramInt)
  {
    e(paramInt, 0, "");
  }
  
  public final void oc(int paramInt)
  {
    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.hsf = paramInt;
    this.hsk.set(true);
    e(9, paramInt, "");
  }
  
  public void pause()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pause");
    ob(5);
    this.hsj.set(true);
    this.hsm.set(false);
  }
  
  public final void release()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "release");
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "duration:%d", new Object[] { Long.valueOf(aFI().duration) });
    aFD();
    onRelease();
    if (this.hsc != null)
    {
      this.hsc.aGB().startTime = 0;
      this.hsc.disconnect();
    }
    this.hsh.set(false);
    this.hsk.set(true);
    this.hsj.set(false);
    this.hsl.set(false);
    this.hrT = null;
  }
  
  public final void resume()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "resume");
    ob(4);
    synchronized (this.lock)
    {
      if (this.hsj.get()) {
        this.hsj.set(false);
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
    synchronized (this.hsp)
    {
      this.startTime = paramInt;
      this.hso = (paramInt / 20);
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      return;
    }
  }
  
  public void setVolume(float paramFloat1, float paramFloat2) {}
  
  public final void stop()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stop");
    setVolume(0.0F, 0.0F);
    ob(6);
    this.hsk.set(true);
    this.hsj.set(false);
    aFK();
    this.hsm.set(false);
    this.hsn.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.c
 * JD-Core Version:    0.7.0.1
 */