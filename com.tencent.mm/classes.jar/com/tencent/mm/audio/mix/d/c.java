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
  protected volatile String cTr;
  protected com.tencent.mm.audio.mix.c.g cUA;
  protected int cUB = 0;
  public volatile String cUD;
  protected AtomicBoolean cUE = new AtomicBoolean(false);
  protected AtomicInteger cUF = new AtomicInteger(0);
  protected AtomicBoolean cUG = new AtomicBoolean(false);
  protected AtomicBoolean cUH = new AtomicBoolean(false);
  protected AtomicBoolean cUI = new AtomicBoolean(false);
  protected AtomicBoolean cUJ = new AtomicBoolean(false);
  protected AtomicBoolean cUK = new AtomicBoolean(false);
  protected int cUL;
  protected volatile com.tencent.mm.audio.mix.f.d cUp;
  protected volatile com.tencent.mm.audio.mix.g.b cUy;
  protected volatile com.tencent.mm.aj.b cUz;
  protected int channels = 0;
  protected Object lock = new Object();
  protected int sampleRate = 0;
  protected volatile String sourcePath;
  
  protected c(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb)
  {
    this.cUp = paramd;
    this.cUy = paramb;
    this.cUz = this.cUy.NW();
    this.cTr = this.cUz.cTr;
    this.sourcePath = this.cUz.filePath;
    this.cUL = this.cUz.cUL;
    this.cUD = this.cUz.cUD;
  }
  
  private String No()
  {
    com.tencent.mm.aj.b localb = Nn();
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "param is null");
      return this.cTr;
    }
    return localb.cTr;
  }
  
  private void d(int paramInt1, int paramInt2, String paramString)
  {
    int i = 2;
    if (this.cUp == null) {
      return;
    }
    this.cUF.set(paramInt1);
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      if (paramInt1 == 3) {
        i = 9;
      }
    }
    for (;;)
    {
      String str = No();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      com.tencent.mm.audio.mix.f.d locald = this.cUp;
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
        locald.f(i, str, this.cUD);
        return;
      }
      i = -1;
    }
  }
  
  private boolean isError()
  {
    return this.cUF.get() == 9;
  }
  
  private boolean isPlaying()
  {
    return this.cUF.get() == 4;
  }
  
  public final void MX()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload");
    this.cUE.set(true);
    hR(10);
  }
  
  public void MY()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
    pause();
  }
  
  public void MZ()
  {
    Object localObject = this.cUp.cWq;
    String str = No();
    if (((com.tencent.mm.audio.mix.e.c)localObject).cVm.containsKey(str))
    {
      localObject = (WeakReference)((com.tencent.mm.audio.mix.e.c)localObject).cVm.remove(str);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((WeakReference)localObject).clear();
      }
    }
  }
  
  public final void Na()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", new Object[] { Boolean.TRUE });
    this.cUH.set(true);
    hR(9);
    com.tencent.mm.audio.mix.a.d locald = Nd();
    if ((locald != null) && (!locald.azh)) {
      locald.reset();
    }
  }
  
  public final boolean Nb()
  {
    return this.cUG.get();
  }
  
  public final boolean Nc()
  {
    return this.cUH.get();
  }
  
  public final com.tencent.mm.audio.mix.a.d Nd()
  {
    return com.tencent.mm.audio.mix.b.e.MN().eY(this.sourcePath);
  }
  
  protected final void Ne()
  {
    synchronized (this.lock)
    {
      for (;;)
      {
        if (!this.cUH.get())
        {
          boolean bool = this.cUG.get();
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
  
  protected final void Nf()
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
  
  public final void Ng()
  {
    if (this.cUp.cWt != null) {
      this.cUp.cWt.hW(Nn().fromScene);
    }
    this.sourcePath = Nn().filePath;
    if (TextUtils.isEmpty(this.sourcePath))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "source path is null");
      this.cUB = 712;
      onError(this.cUB);
      return;
    }
    Object localObject = Nn();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", new Object[] { this.sourcePath, Boolean.valueOf(((com.tencent.mm.aj.b)localObject).loop) });
    if (this.cUE.get())
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
      if (((com.tencent.mm.aj.b)localObject).gTd)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload begin");
        if (!com.tencent.mm.audio.mix.b.e.MN().fa(this.sourcePath)) {
          Nh();
        }
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload end");
          return;
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
        }
      }
      if (!isPlaying()) {
        hR(3);
      }
      if (!com.tencent.mm.audio.mix.b.e.MN().fa(this.sourcePath)) {
        Nh();
      }
      for (;;)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
        this.cUE.set(false);
        com.tencent.mm.audio.mix.a.d locald = Nd();
        if (!this.cUH.get()) {
          break label270;
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
        if (!locald.azh) {
          break;
        }
        hR(2);
        return;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
      }
      label270:
      if (isError())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
        return;
      }
      if ((isPlaying()) || (((com.tencent.mm.aj.b)localObject).gSN))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "to play");
        hR(2);
      }
    }
    else
    {
      hR(4);
    }
    for (;;)
    {
      label335:
      int i;
      if (!com.tencent.mm.audio.mix.b.e.MN().fa(this.sourcePath))
      {
        Nh();
        if ((!((com.tencent.mm.aj.b)localObject).loop) || (this.cUH.get())) {
          break label488;
        }
        i = 1;
        if (i != 0) {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", new Object[] { No() });
        }
      }
      try
      {
        Thread.sleep(20L);
        this.cUL = 0;
        if (i != 0) {
          continue;
        }
        if ((this.cUH.get()) || (isError()))
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
          localObject = Nn().filePath;
          if (this.cUy.equals(localObject))
          {
            this.cUp.cWq.fn(No());
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "task end");
            return;
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not to play");
            hR(2);
            return;
            Ni();
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
          if (!this.cUp.cWq.fp(No()))
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
            this.cUp.cWq.m(No(), true);
          }
          else
          {
            hR(7);
            this.cUp.cWq.fn(No());
          }
        }
      }
    }
  }
  
  protected abstract void Nh();
  
  protected final void Ni()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
    com.tencent.mm.audio.mix.a.d locald = Nd();
    if (locald == null) {
      return;
    }
    Nk();
    int j = locald.size();
    int i = 0;
    while ((i < j) && (!this.cUH.get()))
    {
      Ne();
      com.tencent.mm.audio.mix.a.e locale = locald.hO(i);
      if (locale != null) {
        a(locale);
      }
      i += 1;
    }
    Nl();
  }
  
  public final void Nj()
  {
    if ((!this.cUJ.get()) && (!this.cUH.get()))
    {
      this.cUJ.set(true);
      hR(13);
    }
  }
  
  protected void Nk() {}
  
  protected void Nl() {}
  
  public void Nm() {}
  
  public final com.tencent.mm.aj.b Nn()
  {
    if (this.cUy != null) {
      return this.cUy.NW();
    }
    return this.cUz;
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.d paramd)
  {
    if (this.cUA == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "process is null");
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
    Nk();
    com.tencent.mm.audio.mix.a.e locale;
    if (!this.cUH.get())
    {
      Ne();
      locale = this.cUA.MU();
      if ((paramd.size() <= 0) || (locale != null)) {
        break label72;
      }
      paramd.complete();
    }
    for (;;)
    {
      Nl();
      return;
      label72:
      if ((paramd.size() == 0) && (locale == null))
      {
        paramd.reset();
      }
      else if (locale != null)
      {
        if (!paramd.azh) {
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
    if (this.cUE.get()) {}
    while ((parame == null) || ((parame.cTu > 0L) && (this.cUL > 0) && (parame.cTu < this.cUL)) || (this.cUp == null) || (this.cUp.cWq == null) || (parame == null)) {
      return;
    }
    parame.cTr = No();
    c(parame);
  }
  
  protected void c(com.tencent.mm.audio.mix.a.e arg1)
  {
    int i;
    if (this.cUy.NW().cTo)
    {
      if (!this.cUK.get())
      {
        this.cUK.set(true);
        hR(14);
      }
      i = this.cUp.cWq.a(No(), ???, this);
      if (i < 50) {
        this.cUI.set(false);
      }
    }
    else
    {
      return;
    }
    ??? = Nd();
    if ((??? != null) && (???.azh))
    {
      this.cUI.set(true);
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
    this.cUI.set(false);
  }
  
  public long getCurrentPosition()
  {
    return -1L;
  }
  
  public final void hQ(int paramInt)
  {
    if (paramInt >= 20) {}
    while ((!this.cUI.get()) || (this.cUG.get()) || (this.cUH.get())) {
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", new Object[] { Integer.valueOf(paramInt) });
    Nf();
  }
  
  protected final void hR(int paramInt)
  {
    d(paramInt, 0, "");
  }
  
  public final void init()
  {
    this.cUL = this.cUy.NW().gSM;
    this.cUG.set(false);
    this.cUH.set(false);
    if (this.cUy != null) {
      com.tencent.mm.audio.mix.g.b localb = this.cUy;
    }
    hR(1);
  }
  
  public final void onError(int paramInt)
  {
    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.cUB = paramInt;
    this.cUH.set(true);
    d(9, paramInt, "");
  }
  
  public void pause()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pause");
    hR(5);
    this.cUG.set(true);
    this.cUJ.set(false);
  }
  
  public final void release()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "release");
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "duration:%d", new Object[] { Long.valueOf(Nd().duration) });
    MZ();
    onRelease();
    if (this.cUy != null)
    {
      this.cUy.NW().cUL = 0;
      com.tencent.mm.audio.mix.g.b localb = this.cUy;
    }
    this.cUE.set(false);
    this.cUH.set(true);
    this.cUG.set(false);
    this.cUI.set(false);
    this.cUp = null;
  }
  
  public final void resume()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "resume");
    hR(4);
    synchronized (this.lock)
    {
      if (this.cUG.get()) {
        this.cUG.set(false);
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
    int i = this.cUL;
    this.cUL = paramInt;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
  }
  
  public final void stop()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stop");
    Nm();
    hR(6);
    this.cUH.set(true);
    this.cUG.set(false);
    Nf();
    this.cUJ.set(false);
    this.cUK.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.c
 * JD-Core Version:    0.7.0.1
 */