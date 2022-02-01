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
  protected volatile String dce;
  protected volatile com.tencent.mm.audio.mix.f.d ddc;
  protected volatile com.tencent.mm.audio.mix.g.b ddl;
  protected volatile com.tencent.mm.aj.b ddm;
  protected com.tencent.mm.audio.mix.c.g ddn;
  protected int ddo = 0;
  public volatile String ddp;
  protected AtomicBoolean ddq = new AtomicBoolean(false);
  protected AtomicInteger ddr = new AtomicInteger(0);
  protected AtomicBoolean dds = new AtomicBoolean(false);
  protected AtomicBoolean ddt = new AtomicBoolean(false);
  protected AtomicBoolean ddu = new AtomicBoolean(false);
  protected AtomicBoolean ddv = new AtomicBoolean(false);
  protected AtomicBoolean ddw = new AtomicBoolean(false);
  protected int ddx;
  protected Object lock = new Object();
  protected int sampleRate = 0;
  protected volatile String sourcePath;
  
  protected c(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb)
  {
    this.ddc = paramd;
    this.ddl = paramb;
    this.ddm = this.ddl.PC();
    this.dce = this.ddm.dce;
    this.sourcePath = this.ddm.filePath;
    this.ddx = this.ddm.ddx;
    this.ddp = this.ddm.ddp;
  }
  
  private String OV()
  {
    com.tencent.mm.aj.b localb = OU();
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "param is null");
      return this.dce;
    }
    return localb.dce;
  }
  
  private void d(int paramInt1, int paramInt2, String paramString)
  {
    int i = 2;
    if (this.ddc == null) {
      return;
    }
    this.ddr.set(paramInt1);
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      if (paramInt1 == 3) {
        i = 9;
      }
    }
    for (;;)
    {
      String str = OV();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      com.tencent.mm.audio.mix.f.d locald = this.ddc;
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
        locald.f(i, str, this.ddp);
        return;
      }
      i = -1;
    }
  }
  
  private boolean isError()
  {
    return this.ddr.get() == 9;
  }
  
  private boolean isPlaying()
  {
    return this.ddr.get() == 4;
  }
  
  public final void OE()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload");
    this.ddq.set(true);
    hI(10);
  }
  
  public void OF()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
    pause();
  }
  
  public void OG()
  {
    Object localObject = this.ddc.dfc;
    String str = OV();
    if (((com.tencent.mm.audio.mix.e.c)localObject).ddY.containsKey(str))
    {
      localObject = (WeakReference)((com.tencent.mm.audio.mix.e.c)localObject).ddY.remove(str);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((WeakReference)localObject).clear();
      }
    }
  }
  
  public final void OH()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", new Object[] { Boolean.TRUE });
    this.ddt.set(true);
    hI(9);
    com.tencent.mm.audio.mix.a.d locald = OK();
    if ((locald != null) && (!locald.aBS)) {
      locald.reset();
    }
  }
  
  public final boolean OI()
  {
    return this.dds.get();
  }
  
  public final boolean OJ()
  {
    return this.ddt.get();
  }
  
  public final com.tencent.mm.audio.mix.a.d OK()
  {
    return com.tencent.mm.audio.mix.b.e.Ou().fJ(this.sourcePath);
  }
  
  protected final void OL()
  {
    synchronized (this.lock)
    {
      for (;;)
      {
        if (!this.ddt.get())
        {
          boolean bool = this.dds.get();
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
  
  protected final void OM()
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
  
  public final void ON()
  {
    if (this.ddc.dff != null) {
      this.ddc.dff.hN(OU().fromScene);
    }
    this.sourcePath = OU().filePath;
    if (TextUtils.isEmpty(this.sourcePath))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "source path is null");
      this.ddo = 712;
      onError(this.ddo);
      return;
    }
    Object localObject = OU();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", new Object[] { this.sourcePath, Boolean.valueOf(((com.tencent.mm.aj.b)localObject).loop) });
    if (this.ddq.get())
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
      if (((com.tencent.mm.aj.b)localObject).hLU)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload begin");
        if (!com.tencent.mm.audio.mix.b.e.Ou().fL(this.sourcePath)) {
          OO();
        }
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload end");
          return;
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
        }
      }
      if (!isPlaying()) {
        hI(3);
      }
      if (!com.tencent.mm.audio.mix.b.e.Ou().fL(this.sourcePath)) {
        OO();
      }
      for (;;)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
        this.ddq.set(false);
        com.tencent.mm.audio.mix.a.d locald = OK();
        if (!this.ddt.get()) {
          break label270;
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
        if (!locald.aBS) {
          break;
        }
        hI(2);
        return;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
      }
      label270:
      if (isError())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
        return;
      }
      if ((isPlaying()) || (((com.tencent.mm.aj.b)localObject).hLF))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "to play");
        hI(2);
      }
    }
    else
    {
      hI(4);
    }
    for (;;)
    {
      label335:
      int i;
      if (!com.tencent.mm.audio.mix.b.e.Ou().fL(this.sourcePath))
      {
        OO();
        if ((!((com.tencent.mm.aj.b)localObject).loop) || (this.ddt.get())) {
          break label488;
        }
        i = 1;
        if (i != 0) {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", new Object[] { OV() });
        }
      }
      try
      {
        Thread.sleep(20L);
        this.ddx = 0;
        if (i != 0) {
          continue;
        }
        if ((this.ddt.get()) || (isError()))
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
          localObject = OU().filePath;
          if (this.ddl.equals(localObject))
          {
            this.ddc.dfc.fY(OV());
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "task end");
            return;
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not to play");
            hI(2);
            return;
            OP();
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
          if (!this.ddc.dfc.ga(OV()))
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
            this.ddc.dfc.m(OV(), true);
          }
          else
          {
            hI(7);
            this.ddc.dfc.fY(OV());
          }
        }
      }
    }
  }
  
  protected abstract void OO();
  
  protected final void OP()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
    com.tencent.mm.audio.mix.a.d locald = OK();
    if (locald == null) {
      return;
    }
    OR();
    int j = locald.size();
    int i = 0;
    while ((i < j) && (!this.ddt.get()))
    {
      OL();
      com.tencent.mm.audio.mix.a.e locale = locald.hF(i);
      if (locale != null) {
        a(locale);
      }
      i += 1;
    }
    OS();
  }
  
  public final void OQ()
  {
    if ((!this.ddv.get()) && (!this.ddt.get()))
    {
      this.ddv.set(true);
      hI(13);
    }
  }
  
  protected void OR() {}
  
  protected void OS() {}
  
  public void OT() {}
  
  public final com.tencent.mm.aj.b OU()
  {
    if (this.ddl != null) {
      return this.ddl.PC();
    }
    return this.ddm;
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.d paramd)
  {
    if (this.ddn == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "process is null");
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
    OR();
    com.tencent.mm.audio.mix.a.e locale;
    if (!this.ddt.get())
    {
      OL();
      locale = this.ddn.OB();
      if ((paramd.size() <= 0) || (locale != null)) {
        break label72;
      }
      paramd.complete();
    }
    for (;;)
    {
      OS();
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
    if (this.ddq.get()) {}
    while ((parame == null) || ((parame.dch > 0L) && (this.ddx > 0) && (parame.dch < this.ddx)) || (this.ddc == null) || (this.ddc.dfc == null) || (parame == null)) {
      return;
    }
    parame.dce = OV();
    c(parame);
  }
  
  protected void c(com.tencent.mm.audio.mix.a.e arg1)
  {
    int i;
    if (this.ddl.PC().dcb)
    {
      if (!this.ddw.get())
      {
        this.ddw.set(true);
        hI(14);
      }
      i = this.ddc.dfc.a(OV(), ???, this);
      if (i < 50) {
        this.ddu.set(false);
      }
    }
    else
    {
      return;
    }
    ??? = OK();
    if ((??? != null) && (???.aBS))
    {
      this.ddu.set(true);
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
    this.ddu.set(false);
  }
  
  public long getCurrentPosition()
  {
    return -1L;
  }
  
  public final void hH(int paramInt)
  {
    if (paramInt >= 20) {}
    while ((!this.ddu.get()) || (this.dds.get()) || (this.ddt.get())) {
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", new Object[] { Integer.valueOf(paramInt) });
    OM();
  }
  
  protected final void hI(int paramInt)
  {
    d(paramInt, 0, "");
  }
  
  public final void init()
  {
    this.ddx = this.ddl.PC().hLE;
    this.dds.set(false);
    this.ddt.set(false);
    if (this.ddl != null) {
      com.tencent.mm.audio.mix.g.b localb = this.ddl;
    }
    hI(1);
  }
  
  public final void onError(int paramInt)
  {
    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.ddo = paramInt;
    this.ddt.set(true);
    d(9, paramInt, "");
  }
  
  public void pause()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pause");
    hI(5);
    this.dds.set(true);
    this.ddv.set(false);
  }
  
  public final void release()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "release");
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "duration:%d", new Object[] { Long.valueOf(OK().duration) });
    OG();
    onRelease();
    if (this.ddl != null)
    {
      this.ddl.PC().ddx = 0;
      com.tencent.mm.audio.mix.g.b localb = this.ddl;
    }
    this.ddq.set(false);
    this.ddt.set(true);
    this.dds.set(false);
    this.ddu.set(false);
    this.ddc = null;
  }
  
  public final void resume()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "resume");
    hI(4);
    synchronized (this.lock)
    {
      if (this.dds.get()) {
        this.dds.set(false);
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
    int i = this.ddx;
    this.ddx = paramInt;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
  }
  
  public final void stop()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stop");
    OT();
    hI(6);
    this.ddt.set(true);
    this.dds.set(false);
    OM();
    this.ddv.set(false);
    this.ddw.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.c
 * JD-Core Version:    0.7.0.1
 */