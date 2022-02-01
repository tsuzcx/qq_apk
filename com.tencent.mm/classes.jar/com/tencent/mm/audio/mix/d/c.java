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
  protected int channels = 0;
  protected volatile String ddg;
  protected volatile com.tencent.mm.audio.mix.f.d dee;
  protected volatile com.tencent.mm.audio.mix.g.b den;
  protected volatile com.tencent.mm.ai.b deo;
  protected com.tencent.mm.audio.mix.c.g dep;
  protected int deq = 0;
  public volatile String der;
  protected AtomicBoolean des = new AtomicBoolean(false);
  protected AtomicInteger det = new AtomicInteger(0);
  protected AtomicBoolean deu = new AtomicBoolean(false);
  protected AtomicBoolean dev = new AtomicBoolean(false);
  protected AtomicBoolean dew = new AtomicBoolean(false);
  protected AtomicBoolean dex = new AtomicBoolean(false);
  protected AtomicBoolean dey = new AtomicBoolean(false);
  protected int dez;
  protected Object lock = new Object();
  protected int sampleRate = 0;
  protected volatile String sourcePath;
  
  protected c(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb)
  {
    this.dee = paramd;
    this.den = paramb;
    this.deo = this.den.PA();
    this.ddg = this.deo.ddg;
    this.sourcePath = this.deo.filePath;
    this.dez = this.deo.dez;
    this.der = this.deo.der;
  }
  
  private String OT()
  {
    com.tencent.mm.ai.b localb = OS();
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "param is null");
      return this.ddg;
    }
    return localb.ddg;
  }
  
  private void d(int paramInt1, int paramInt2, String paramString)
  {
    int i = 2;
    if (this.dee == null) {
      return;
    }
    this.det.set(paramInt1);
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      if (paramInt1 == 3) {
        i = 9;
      }
    }
    for (;;)
    {
      String str = OT();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      com.tencent.mm.audio.mix.f.d locald = this.dee;
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
        locald.f(i, str, this.der);
        return;
      }
      i = -1;
    }
  }
  
  private boolean isError()
  {
    return this.det.get() == 9;
  }
  
  private boolean isPlaying()
  {
    return this.det.get() == 4;
  }
  
  public final void OC()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload");
    this.des.set(true);
    hK(10);
  }
  
  public void OD()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
    pause();
  }
  
  public void OE()
  {
    Object localObject = this.dee.dge;
    String str = OT();
    if (((com.tencent.mm.audio.mix.e.c)localObject).dfa.containsKey(str))
    {
      localObject = (WeakReference)((com.tencent.mm.audio.mix.e.c)localObject).dfa.remove(str);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((WeakReference)localObject).clear();
      }
    }
  }
  
  public final void OF()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", new Object[] { Boolean.TRUE });
    this.dev.set(true);
    hK(9);
    com.tencent.mm.audio.mix.a.d locald = OI();
    if ((locald != null) && (!locald.aBS)) {
      locald.reset();
    }
  }
  
  public final boolean OG()
  {
    return this.deu.get();
  }
  
  public final boolean OH()
  {
    return this.dev.get();
  }
  
  public final com.tencent.mm.audio.mix.a.d OI()
  {
    return com.tencent.mm.audio.mix.b.e.Os().fP(this.sourcePath);
  }
  
  protected final void OJ()
  {
    synchronized (this.lock)
    {
      for (;;)
      {
        if (!this.dev.get())
        {
          boolean bool = this.deu.get();
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
  
  protected final void OK()
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
  
  public final void OL()
  {
    if (this.dee.dgh != null) {
      this.dee.dgh.hP(OS().fromScene);
    }
    this.sourcePath = OS().filePath;
    if (TextUtils.isEmpty(this.sourcePath))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "source path is null");
      this.deq = 712;
      onError(this.deq);
      return;
    }
    Object localObject = OS();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", new Object[] { this.sourcePath, Boolean.valueOf(((com.tencent.mm.ai.b)localObject).loop) });
    if (this.des.get())
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
      if (((com.tencent.mm.ai.b)localObject).hON)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload begin");
        if (!com.tencent.mm.audio.mix.b.e.Os().fR(this.sourcePath)) {
          OM();
        }
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload end");
          return;
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
        }
      }
      if (!isPlaying()) {
        hK(3);
      }
      if (!com.tencent.mm.audio.mix.b.e.Os().fR(this.sourcePath)) {
        OM();
      }
      for (;;)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
        this.des.set(false);
        com.tencent.mm.audio.mix.a.d locald = OI();
        if (!this.dev.get()) {
          break label270;
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
        if (!locald.aBS) {
          break;
        }
        hK(2);
        return;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
      }
      label270:
      if (isError())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
        return;
      }
      if ((isPlaying()) || (((com.tencent.mm.ai.b)localObject).hOy))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "to play");
        hK(2);
      }
    }
    else
    {
      hK(4);
    }
    for (;;)
    {
      label335:
      int i;
      if (!com.tencent.mm.audio.mix.b.e.Os().fR(this.sourcePath))
      {
        OM();
        if ((!((com.tencent.mm.ai.b)localObject).loop) || (this.dev.get())) {
          break label488;
        }
        i = 1;
        if (i != 0) {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", new Object[] { OT() });
        }
      }
      try
      {
        Thread.sleep(20L);
        this.dez = 0;
        if (i != 0) {
          continue;
        }
        if ((this.dev.get()) || (isError()))
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
          localObject = OS().filePath;
          if (this.den.equals(localObject))
          {
            this.dee.dge.ge(OT());
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "task end");
            return;
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not to play");
            hK(2);
            return;
            ON();
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
          if (!this.dee.dge.gg(OT()))
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
            this.dee.dge.m(OT(), true);
          }
          else
          {
            hK(7);
            this.dee.dge.ge(OT());
          }
        }
      }
    }
  }
  
  protected abstract void OM();
  
  protected final void ON()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
    com.tencent.mm.audio.mix.a.d locald = OI();
    if (locald == null) {
      return;
    }
    OP();
    int j = locald.size();
    int i = 0;
    while ((i < j) && (!this.dev.get()))
    {
      OJ();
      com.tencent.mm.audio.mix.a.e locale = locald.hH(i);
      if (locale != null) {
        a(locale);
      }
      i += 1;
    }
    OQ();
  }
  
  public final void OO()
  {
    if ((!this.dex.get()) && (!this.dev.get()))
    {
      this.dex.set(true);
      hK(13);
    }
  }
  
  protected void OP() {}
  
  protected void OQ() {}
  
  public void OR() {}
  
  public final com.tencent.mm.ai.b OS()
  {
    if (this.den != null) {
      return this.den.PA();
    }
    return this.deo;
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.d paramd)
  {
    if (this.dep == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "process is null");
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
    OP();
    com.tencent.mm.audio.mix.a.e locale;
    if (!this.dev.get())
    {
      OJ();
      locale = this.dep.Oz();
      if ((paramd.size() <= 0) || (locale != null)) {
        break label72;
      }
      paramd.complete();
    }
    for (;;)
    {
      OQ();
      return;
      label72:
      if ((paramd.size() == 0) && (locale == null))
      {
        paramd.reset();
      }
      else if (locale != null)
      {
        if (!paramd.aBS) {
          paramd.a(locale);
        }
        a(locale);
        if (locale != null) {
          break;
        }
      }
    }
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.e parame)
  {
    if (this.des.get()) {}
    while ((parame == null) || ((parame.ddj > 0L) && (this.dez > 0) && (parame.ddj < this.dez)) || (this.dee == null) || (this.dee.dge == null) || (parame == null)) {
      return;
    }
    parame.ddg = OT();
    c(parame);
  }
  
  protected void c(com.tencent.mm.audio.mix.a.e arg1)
  {
    int i;
    if (this.den.PA().ddd)
    {
      if (!this.dey.get())
      {
        this.dey.set(true);
        hK(14);
      }
      i = this.dee.dge.a(OT(), ???, this);
      if (i < 50) {
        this.dew.set(false);
      }
    }
    else
    {
      return;
    }
    ??? = OI();
    if ((??? != null) && (???.aBS))
    {
      this.dew.set(true);
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
    this.dew.set(false);
  }
  
  public long getCurrentPosition()
  {
    return -1L;
  }
  
  public final void hJ(int paramInt)
  {
    if (paramInt >= 20) {}
    while ((!this.dew.get()) || (this.deu.get()) || (this.dev.get())) {
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", new Object[] { Integer.valueOf(paramInt) });
    OK();
  }
  
  protected final void hK(int paramInt)
  {
    d(paramInt, 0, "");
  }
  
  public final void init()
  {
    this.dez = this.den.PA().hOx;
    this.deu.set(false);
    this.dev.set(false);
    if (this.den != null) {
      com.tencent.mm.audio.mix.g.b localb = this.den;
    }
    hK(1);
  }
  
  public final void onError(int paramInt)
  {
    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.deq = paramInt;
    this.dev.set(true);
    d(9, paramInt, "");
  }
  
  public void pause()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pause");
    hK(5);
    this.deu.set(true);
    this.dex.set(false);
  }
  
  public final void release()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "release");
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "duration:%d", new Object[] { Long.valueOf(OI().duration) });
    OE();
    onRelease();
    if (this.den != null)
    {
      this.den.PA().dez = 0;
      com.tencent.mm.audio.mix.g.b localb = this.den;
    }
    this.des.set(false);
    this.dev.set(true);
    this.deu.set(false);
    this.dew.set(false);
    this.dee = null;
  }
  
  public final void resume()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "resume");
    hK(4);
    synchronized (this.lock)
    {
      if (this.deu.get()) {
        this.deu.set(false);
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
    int i = this.dez;
    this.dez = paramInt;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
  }
  
  public final void stop()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stop");
    OR();
    hK(6);
    this.dev.set(true);
    this.deu.set(false);
    OK();
    this.dex.set(false);
    this.dey.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.c
 * JD-Core Version:    0.7.0.1
 */