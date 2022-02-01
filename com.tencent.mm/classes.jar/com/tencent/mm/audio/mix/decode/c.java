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
  protected volatile String fmF;
  protected volatile com.tencent.mm.audio.mix.f.d fnI;
  protected volatile com.tencent.mm.audio.mix.g.c fnR;
  protected volatile com.tencent.mm.al.b fnS;
  protected h fnT;
  protected int fnU = 0;
  public volatile String fnV;
  protected AtomicBoolean fnW = new AtomicBoolean(false);
  protected AtomicInteger fnX = new AtomicInteger(0);
  protected AtomicBoolean fnY = new AtomicBoolean(false);
  protected AtomicBoolean fnZ = new AtomicBoolean(false);
  protected AtomicBoolean foa = new AtomicBoolean(false);
  protected AtomicBoolean fob = new AtomicBoolean(false);
  protected AtomicBoolean foc = new AtomicBoolean(false);
  protected int fod;
  protected int foe = -1;
  protected Object fof = new Object();
  protected Object lock = new Object();
  protected int sampleRate = 0;
  protected volatile String sourcePath;
  
  protected c(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.c paramc)
  {
    this.fnI = paramd;
    this.fnR = paramc;
    this.fnS = this.fnR.aeD();
    this.fmF = this.fnS.fmF;
    this.sourcePath = this.fnS.filePath;
    this.fod = this.fnS.fod;
    this.fnV = this.fnS.fnV;
  }
  
  private String adU()
  {
    com.tencent.mm.al.b localb = adT();
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "param is null");
      return this.fmF;
    }
    return localb.fmF;
  }
  
  private void d(int paramInt1, int paramInt2, String paramString)
  {
    int i = 2;
    if (this.fnI == null) {
      return;
    }
    this.fnX.set(paramInt1);
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      if (paramInt1 == 3) {
        i = 9;
      }
    }
    for (;;)
    {
      String str = adU();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      com.tencent.mm.audio.mix.f.d locald = this.fnI;
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
        locald.f(i, str, this.fnV);
        return;
      }
      i = -1;
    }
  }
  
  private boolean isError()
  {
    return this.fnX.get() == 9;
  }
  
  private boolean isPlaying()
  {
    return this.fnX.get() == 4;
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.d paramd)
  {
    if (this.fnT == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "process is null");
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
    adQ();
    e locale;
    if (!this.fnZ.get())
    {
      adK();
      locale = this.fnT.adz();
      if ((paramd.size() <= 0) || (locale != null)) {
        break label70;
      }
      paramd.ph();
    }
    for (;;)
    {
      adR();
      return;
      label70:
      if ((paramd.size() == 0) && (locale == null))
      {
        paramd.reset();
      }
      else if (locale != null)
      {
        if (!paramd.awf) {
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
    if (this.fnW.get()) {}
    while ((parame == null) || ((parame.fmI > 0L) && (this.fod > 0) && (parame.fmI < this.fod)) || (this.fnI == null) || (this.fnI.fqa == null) || (parame == null)) {
      return;
    }
    parame.fmF = adU();
    c(parame);
  }
  
  public final void adD()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload");
    this.fnW.set(true);
    ku(10);
  }
  
  public void adE()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
    pause();
  }
  
  public void adF()
  {
    Object localObject = this.fnI.fqa;
    String str = adU();
    if (((com.tencent.mm.audio.mix.e.c)localObject).foU.containsKey(str))
    {
      localObject = (WeakReference)((com.tencent.mm.audio.mix.e.c)localObject).foU.remove(str);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((WeakReference)localObject).clear();
      }
    }
  }
  
  public final void adG()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", new Object[] { Boolean.TRUE });
    this.fnZ.set(true);
    ku(9);
    com.tencent.mm.audio.mix.a.d locald = adJ();
    if ((locald != null) && (!locald.awf)) {
      locald.reset();
    }
  }
  
  public final boolean adH()
  {
    return this.fnY.get();
  }
  
  public final boolean adI()
  {
    return this.fnZ.get();
  }
  
  public final com.tencent.mm.audio.mix.a.d adJ()
  {
    return com.tencent.mm.audio.mix.b.f.ads().hq(this.sourcePath);
  }
  
  protected final void adK()
  {
    synchronized (this.lock)
    {
      for (;;)
      {
        if (!this.fnZ.get())
        {
          boolean bool = this.fnY.get();
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
  
  protected final void adL()
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
  
  public final void adM()
  {
    if (this.fnI.fqd != null) {
      this.fnI.fqd.kB(adT().fromScene);
    }
    this.sourcePath = adT().filePath;
    if (TextUtils.isEmpty(this.sourcePath))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "source path is null");
      this.fnU = 712;
      kv(this.fnU);
      return;
    }
    Object localObject = adT();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", new Object[] { this.sourcePath, Boolean.valueOf(((com.tencent.mm.al.b)localObject).loop) });
    if (this.fnW.get())
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
      if (((com.tencent.mm.al.b)localObject).lzX)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload begin");
        if (!com.tencent.mm.audio.mix.b.f.ads().hs(this.sourcePath)) {
          adN();
        }
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload end");
          ku(15);
          return;
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
        }
      }
      if (!isPlaying()) {
        ku(3);
      }
      if (!com.tencent.mm.audio.mix.b.f.ads().hs(this.sourcePath)) {
        adN();
      }
      for (;;)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
        this.fnW.set(false);
        com.tencent.mm.audio.mix.a.d locald = adJ();
        if (!this.fnZ.get()) {
          break label276;
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
        if (!locald.awf) {
          break;
        }
        ku(2);
        return;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
      }
      label276:
      if (isError())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
        return;
      }
      if ((isPlaying()) || (((com.tencent.mm.al.b)localObject).lzI))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "to play");
        ku(2);
      }
    }
    else
    {
      ku(4);
    }
    for (;;)
    {
      label341:
      int i;
      if (!com.tencent.mm.audio.mix.b.f.ads().hs(this.sourcePath))
      {
        adN();
        if ((!((com.tencent.mm.al.b)localObject).loop) || (this.fnZ.get())) {
          break label494;
        }
        i = 1;
        if (i != 0) {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", new Object[] { adU() });
        }
      }
      try
      {
        Thread.sleep(20L);
        this.fod = 0;
        if (i != 0) {
          continue;
        }
        if ((this.fnZ.get()) || (isError()))
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
          localObject = adT().filePath;
          if (this.fnR.equals(localObject))
          {
            this.fnI.fqa.hG(adU());
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "task end");
            return;
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not to play");
            ku(2);
            return;
            adO();
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
          if (!this.fnI.fqa.hJ(adU()))
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
            this.fnI.fqa.p(adU(), true);
          }
          else
          {
            ku(7);
            this.fnI.fqa.hG(adU());
          }
        }
      }
    }
  }
  
  protected abstract void adN();
  
  protected final void adO()
  {
    int i = 0;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
    com.tencent.mm.audio.mix.a.d locald = adJ();
    if (locald == null) {
      return;
    }
    adQ();
    int k = locald.size();
    while ((i < k) && (!this.fnZ.get()))
    {
      adK();
      Object localObject2 = this.fof;
      int j = i;
      try
      {
        if (this.foe >= 0)
        {
          j = i;
          if (this.foe < k)
          {
            j = this.foe;
            this.foe = -1;
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "seek to pos:%s", new Object[] { Integer.valueOf(j) });
          }
        }
        localObject2 = locald.kr(j);
        if (localObject2 != null) {
          a((e)localObject2);
        }
        i = j + 1;
      }
      finally {}
    }
    adR();
  }
  
  public final void adP()
  {
    if ((!this.fob.get()) && (!this.fnZ.get()))
    {
      this.fob.set(true);
      ku(13);
    }
  }
  
  protected void adQ() {}
  
  protected void adR() {}
  
  public void adS() {}
  
  public final com.tencent.mm.al.b adT()
  {
    if (this.fnR != null) {
      return this.fnR.aeD();
    }
    return this.fnS;
  }
  
  protected void c(e arg1)
  {
    int i;
    if (this.fnR.aeD().fmC)
    {
      if (!this.foc.get())
      {
        this.foc.set(true);
        ku(14);
      }
      i = this.fnI.fqa.a(adU(), ???, this);
      if (i < 50) {
        this.foa.set(false);
      }
    }
    else
    {
      return;
    }
    ??? = adJ();
    adT();
    if ((??? != null) && (???.awf))
    {
      this.foa.set(true);
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
    this.foa.set(false);
  }
  
  public long getCurrentPosition()
  {
    return -1L;
  }
  
  public final void init()
  {
    this.fod = this.fnR.aeD().lzH;
    this.fnY.set(false);
    this.fnZ.set(false);
    if (this.fnR != null) {
      this.fnR.connect();
    }
    ku(1);
  }
  
  public final void kt(int paramInt)
  {
    if (paramInt >= 20) {}
    while ((!this.foa.get()) || (this.fnY.get()) || (this.fnZ.get())) {
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", new Object[] { Integer.valueOf(paramInt) });
    adL();
  }
  
  protected final void ku(int paramInt)
  {
    d(paramInt, 0, "");
  }
  
  public final void kv(int paramInt)
  {
    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.fnU = paramInt;
    this.fnZ.set(true);
    d(9, paramInt, "");
  }
  
  public void pause()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pause");
    ku(5);
    this.fnY.set(true);
    this.fob.set(false);
  }
  
  public final void release()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "release");
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "duration:%d", new Object[] { Long.valueOf(adJ().duration) });
    adF();
    onRelease();
    if (this.fnR != null)
    {
      this.fnR.aeD().fod = 0;
      this.fnR.disconnect();
    }
    this.fnW.set(false);
    this.fnZ.set(true);
    this.fnY.set(false);
    this.foa.set(false);
    this.fnI = null;
  }
  
  public final void resume()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "resume");
    ku(4);
    synchronized (this.lock)
    {
      if (this.fnY.get()) {
        this.fnY.set(false);
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
    int i = this.fod;
    synchronized (this.fof)
    {
      this.fod = paramInt;
      this.foe = (paramInt / 20);
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      return;
    }
  }
  
  public final void stop()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stop");
    adS();
    ku(6);
    this.fnZ.set(true);
    this.fnY.set(false);
    adL();
    this.fob.set(false);
    this.foc.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.c
 * JD-Core Version:    0.7.0.1
 */