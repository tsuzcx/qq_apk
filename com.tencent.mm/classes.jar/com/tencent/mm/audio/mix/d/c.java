package com.tencent.mm.audio.mix.d;

import android.text.TextUtils;
import com.tencent.mm.audio.mix.a.e;
import com.tencent.mm.audio.mix.c.h;
import com.tencent.mm.audio.mix.g.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c
  implements l, com.tencent.mm.audio.mix.g.f
{
  protected int channels = 0;
  protected volatile String dtX;
  protected volatile com.tencent.mm.audio.mix.g.d dva;
  protected volatile com.tencent.mm.audio.mix.h.c dvj;
  protected volatile com.tencent.mm.ai.b dvk;
  protected h dvl;
  protected int dvm = 0;
  public volatile String dvn;
  protected AtomicBoolean dvo = new AtomicBoolean(false);
  protected AtomicInteger dvp = new AtomicInteger(0);
  protected AtomicBoolean dvq = new AtomicBoolean(false);
  protected AtomicBoolean dvr = new AtomicBoolean(false);
  protected AtomicBoolean dvs = new AtomicBoolean(false);
  protected AtomicBoolean dvt = new AtomicBoolean(false);
  protected AtomicBoolean dvu = new AtomicBoolean(false);
  protected int dvv;
  protected int dvw = -1;
  protected Object dvx = new Object();
  protected Object lock = new Object();
  protected int sampleRate = 0;
  protected volatile String sourcePath;
  
  protected c(com.tencent.mm.audio.mix.g.d paramd, com.tencent.mm.audio.mix.h.c paramc)
  {
    this.dva = paramd;
    this.dvj = paramc;
    this.dvk = this.dvj.ZU();
    this.dtX = this.dvk.dtX;
    this.sourcePath = this.dvk.filePath;
    this.dvv = this.dvk.dvv;
    this.dvn = this.dvk.dvn;
  }
  
  private String Zl()
  {
    com.tencent.mm.ai.b localb = Zk();
    if (localb == null)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecoderBase", "param is null");
      return this.dtX;
    }
    return localb.dtX;
  }
  
  private void d(int paramInt1, int paramInt2, String paramString)
  {
    int i = 2;
    if (this.dva == null) {
      return;
    }
    this.dvp.set(paramInt1);
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      if (paramInt1 == 3) {
        i = 9;
      }
    }
    for (;;)
    {
      String str = Zl();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      com.tencent.mm.audio.mix.g.d locald = this.dva;
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
        locald.f(i, str, this.dvn);
        return;
      }
      i = -1;
    }
  }
  
  private boolean isError()
  {
    return this.dvp.get() == 9;
  }
  
  private boolean isPlaying()
  {
    return this.dvp.get() == 4;
  }
  
  public final void YU()
  {
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "preload");
    this.dvo.set(true);
    je(10);
  }
  
  public void YV()
  {
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
    pause();
  }
  
  public void YW()
  {
    Object localObject = this.dva.dxo;
    String str = Zl();
    if (((com.tencent.mm.audio.mix.f.c)localObject).dwk.containsKey(str))
    {
      localObject = (WeakReference)((com.tencent.mm.audio.mix.f.c)localObject).dwk.remove(str);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((WeakReference)localObject).clear();
      }
    }
  }
  
  public final void YX()
  {
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", new Object[] { Boolean.TRUE });
    this.dvr.set(true);
    je(9);
    com.tencent.mm.audio.mix.a.d locald = Za();
    if ((locald != null) && (!locald.aBQ)) {
      locald.reset();
    }
  }
  
  public final boolean YY()
  {
    return this.dvq.get();
  }
  
  public final boolean YZ()
  {
    return this.dvr.get();
  }
  
  public final com.tencent.mm.audio.mix.a.d Za()
  {
    return com.tencent.mm.audio.mix.b.f.YL().gE(this.sourcePath);
  }
  
  protected final void Zb()
  {
    synchronized (this.lock)
    {
      for (;;)
      {
        if (!this.dvr.get())
        {
          boolean bool = this.dvq.get();
          if (bool) {
            try
            {
              com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "waitDecode");
              this.lock.wait();
            }
            catch (Exception localException)
            {
              com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", localException, "waitDecode", new Object[0]);
            }
          }
        }
      }
    }
  }
  
  protected final void Zc()
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
          com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", localException, "notifyDecode", new Object[0]);
        }
      }
    }
  }
  
  public final void Zd()
  {
    if (this.dva.dxr != null) {
      this.dva.dxr.jj(Zk().fromScene);
    }
    this.sourcePath = Zk().filePath;
    if (TextUtils.isEmpty(this.sourcePath))
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecoderBase", "source path is null");
      this.dvm = 712;
      onError(this.dvm);
      return;
    }
    Object localObject = Zk();
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", new Object[] { this.sourcePath, Boolean.valueOf(((com.tencent.mm.ai.b)localObject).loop) });
    if (this.dvo.get())
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
      if (((com.tencent.mm.ai.b)localObject).iJT)
      {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "preload begin");
        if (!com.tencent.mm.audio.mix.b.f.YL().gG(this.sourcePath)) {
          Ze();
        }
        for (;;)
        {
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "preload end");
          je(15);
          return;
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
        }
      }
      if (!isPlaying()) {
        je(3);
      }
      if (!com.tencent.mm.audio.mix.b.f.YL().gG(this.sourcePath)) {
        Ze();
      }
      for (;;)
      {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
        this.dvo.set(false);
        com.tencent.mm.audio.mix.a.d locald = Za();
        if (!this.dvr.get()) {
          break label276;
        }
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
        if (!locald.aBQ) {
          break;
        }
        je(2);
        return;
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
      }
      label276:
      if (isError())
      {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
        return;
      }
      if ((isPlaying()) || (((com.tencent.mm.ai.b)localObject).iJE))
      {
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "to play");
        je(2);
      }
    }
    else
    {
      je(4);
    }
    for (;;)
    {
      label341:
      int i;
      if (!com.tencent.mm.audio.mix.b.f.YL().gG(this.sourcePath))
      {
        Ze();
        if ((!((com.tencent.mm.ai.b)localObject).loop) || (this.dvr.get())) {
          break label494;
        }
        i = 1;
        if (i != 0) {
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", new Object[] { Zl() });
        }
      }
      try
      {
        Thread.sleep(20L);
        this.dvv = 0;
        if (i != 0) {
          continue;
        }
        if ((this.dvr.get()) || (isError()))
        {
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
          localObject = Zk().filePath;
          if (this.dvj.equals(localObject))
          {
            this.dva.dxo.gU(Zl());
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "task end");
            return;
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "not to play");
            je(2);
            return;
            Zf();
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
          com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecoderBase", "sleep exception");
          continue;
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "change src only, don't removeAudio");
          continue;
          if (!this.dva.dxo.gW(Zl()))
          {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
            this.dva.dxo.m(Zl(), true);
          }
          else
          {
            je(7);
            this.dva.dxo.gU(Zl());
          }
        }
      }
    }
  }
  
  protected abstract void Ze();
  
  protected final void Zf()
  {
    int i = 0;
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
    com.tencent.mm.audio.mix.a.d locald = Za();
    if (locald == null) {
      return;
    }
    Zh();
    int k = locald.size();
    while ((i < k) && (!this.dvr.get()))
    {
      Zb();
      Object localObject2 = this.dvx;
      int j = i;
      try
      {
        if (this.dvw >= 0)
        {
          j = i;
          if (this.dvw < k)
          {
            j = this.dvw;
            this.dvw = -1;
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "seek to pos:%s", new Object[] { Integer.valueOf(j) });
          }
        }
        localObject2 = locald.jb(j);
        if (localObject2 != null) {
          a((e)localObject2);
        }
        i = j + 1;
      }
      finally {}
    }
    Zi();
  }
  
  public final void Zg()
  {
    if ((!this.dvt.get()) && (!this.dvr.get()))
    {
      this.dvt.set(true);
      je(13);
    }
  }
  
  protected void Zh() {}
  
  protected void Zi() {}
  
  public void Zj() {}
  
  public final com.tencent.mm.ai.b Zk()
  {
    if (this.dvj != null) {
      return this.dvj.ZU();
    }
    return this.dvk;
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.d paramd)
  {
    if (this.dvl == null)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecoderBase", "process is null");
      return;
    }
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
    Zh();
    e locale;
    if (!this.dvr.get())
    {
      Zb();
      locale = this.dvl.YS();
      if ((paramd.size() <= 0) || (locale != null)) {
        break label72;
      }
      paramd.complete();
    }
    for (;;)
    {
      Zi();
      return;
      label72:
      if ((paramd.size() == 0) && (locale == null))
      {
        paramd.reset();
      }
      else if (locale != null)
      {
        if (!paramd.aBQ) {
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
    if (this.dvo.get()) {}
    while ((parame == null) || ((parame.dua > 0L) && (this.dvv > 0) && (parame.dua < this.dvv)) || (this.dva == null) || (this.dva.dxo == null) || (parame == null)) {
      return;
    }
    parame.dtX = Zl();
    c(parame);
  }
  
  protected void c(e arg1)
  {
    int i;
    if (this.dvj.ZU().dtU)
    {
      if (!this.dvu.get())
      {
        this.dvu.set(true);
        je(14);
      }
      i = this.dva.dxo.a(Zl(), ???, this);
      if (i < 50) {
        this.dvs.set(false);
      }
    }
    else
    {
      return;
    }
    ??? = Za();
    if ((??? != null) && (???.aBQ))
    {
      this.dvs.set(true);
      try
      {
        synchronized (this.lock)
        {
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "lockWriteBuffer, writeSize:%d", new Object[] { Integer.valueOf(i) });
          this.lock.wait();
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", localException, "lockWriteBuffer", new Object[0]);
        }
      }
    }
    this.dvs.set(false);
  }
  
  public long getCurrentPosition()
  {
    return -1L;
  }
  
  public final void init()
  {
    this.dvv = this.dvj.ZU().iJD;
    this.dvq.set(false);
    this.dvr.set(false);
    if (this.dvj != null) {
      this.dvj.connect();
    }
    je(1);
  }
  
  public final void jd(int paramInt)
  {
    if (paramInt >= 20) {}
    while ((!this.dvs.get()) || (this.dvq.get()) || (this.dvr.get())) {
      return;
    }
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", new Object[] { Integer.valueOf(paramInt) });
    Zc();
  }
  
  protected final void je(int paramInt)
  {
    d(paramInt, 0, "");
  }
  
  public final void onError(int paramInt)
  {
    com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.dvm = paramInt;
    this.dvr.set(true);
    d(9, paramInt, "");
  }
  
  public void pause()
  {
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "pause");
    je(5);
    this.dvq.set(true);
    this.dvt.set(false);
  }
  
  public final void release()
  {
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "release");
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "duration:%d", new Object[] { Long.valueOf(Za().duration) });
    YW();
    onRelease();
    if (this.dvj != null)
    {
      this.dvj.ZU().dvv = 0;
      this.dvj.disconnect();
    }
    this.dvo.set(false);
    this.dvr.set(true);
    this.dvq.set(false);
    this.dvs.set(false);
    this.dva = null;
  }
  
  public final void resume()
  {
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "resume");
    je(4);
    synchronized (this.lock)
    {
      if (this.dvq.get()) {
        this.dvq.set(false);
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
          com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", localException, "resume", new Object[0]);
        }
      }
    }
  }
  
  public void seek(int paramInt)
  {
    int i = this.dvv;
    synchronized (this.dvx)
    {
      this.dvv = paramInt;
      this.dvw = (paramInt / 20);
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      return;
    }
  }
  
  public final void stop()
  {
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecoderBase", "stop");
    Zj();
    je(6);
    this.dvr.set(true);
    this.dvq.set(false);
    Zc();
    this.dvt.set(false);
    this.dvu.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.c
 * JD-Core Version:    0.7.0.1
 */