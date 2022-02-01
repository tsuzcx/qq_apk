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
  protected volatile String cQO;
  protected volatile com.tencent.mm.audio.mix.f.d cRM;
  protected volatile com.tencent.mm.audio.mix.g.b cRV;
  protected volatile com.tencent.mm.ai.b cRW;
  protected com.tencent.mm.audio.mix.c.g cRX;
  protected int cRY = 0;
  public volatile String cRZ;
  protected AtomicBoolean cSa = new AtomicBoolean(false);
  protected AtomicInteger cSb = new AtomicInteger(0);
  protected AtomicBoolean cSc = new AtomicBoolean(false);
  protected AtomicBoolean cSd = new AtomicBoolean(false);
  protected AtomicBoolean cSe = new AtomicBoolean(false);
  protected AtomicBoolean cSf = new AtomicBoolean(false);
  protected AtomicBoolean cSg = new AtomicBoolean(false);
  protected int cSh;
  protected int channels = 0;
  protected Object lock = new Object();
  protected int sampleRate = 0;
  protected volatile String sourcePath;
  
  protected c(com.tencent.mm.audio.mix.f.d paramd, com.tencent.mm.audio.mix.g.b paramb)
  {
    this.cRM = paramd;
    this.cRV = paramb;
    this.cRW = this.cRV.NT();
    this.cQO = this.cRW.cQO;
    this.sourcePath = this.cRW.filePath;
    this.cSh = this.cRW.cSh;
    this.cRZ = this.cRW.cRZ;
  }
  
  private String Nm()
  {
    com.tencent.mm.ai.b localb = Nl();
    if (localb == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "param is null");
      return this.cQO;
    }
    return localb.cQO;
  }
  
  private void d(int paramInt1, int paramInt2, String paramString)
  {
    int i = 2;
    if (this.cRM == null) {
      return;
    }
    this.cSb.set(paramInt1);
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      if (paramInt1 == 3) {
        i = 9;
      }
    }
    for (;;)
    {
      String str = Nm();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      com.tencent.mm.audio.mix.f.d locald = this.cRM;
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
        locald.f(i, str, this.cRZ);
        return;
      }
      i = -1;
    }
  }
  
  private boolean isError()
  {
    return this.cSb.get() == 9;
  }
  
  private boolean isPlaying()
  {
    return this.cSb.get() == 4;
  }
  
  public final void MV()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload");
    this.cSa.set(true);
    hB(10);
  }
  
  public void MW()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
    pause();
  }
  
  public void MX()
  {
    Object localObject = this.cRM.cTM;
    String str = Nm();
    if (((com.tencent.mm.audio.mix.e.c)localObject).cSI.containsKey(str))
    {
      localObject = (WeakReference)((com.tencent.mm.audio.mix.e.c)localObject).cSI.remove(str);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((WeakReference)localObject).clear();
      }
    }
  }
  
  public final void MY()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", new Object[] { Boolean.TRUE });
    this.cSd.set(true);
    hB(9);
    com.tencent.mm.audio.mix.a.d locald = Nb();
    if ((locald != null) && (!locald.aAb)) {
      locald.reset();
    }
  }
  
  public final boolean MZ()
  {
    return this.cSc.get();
  }
  
  public final boolean Na()
  {
    return this.cSd.get();
  }
  
  public final com.tencent.mm.audio.mix.a.d Nb()
  {
    return com.tencent.mm.audio.mix.b.e.ML().eO(this.sourcePath);
  }
  
  protected final void Nc()
  {
    synchronized (this.lock)
    {
      for (;;)
      {
        if (!this.cSd.get())
        {
          boolean bool = this.cSc.get();
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
  
  protected final void Nd()
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
  
  public final void Ne()
  {
    if (this.cRM.cTP != null) {
      this.cRM.cTP.hG(Nl().fromScene);
    }
    this.sourcePath = Nl().filePath;
    if (TextUtils.isEmpty(this.sourcePath))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "source path is null");
      this.cRY = 712;
      onError(this.cRY);
      return;
    }
    Object localObject = Nl();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", new Object[] { this.sourcePath, Boolean.valueOf(((com.tencent.mm.ai.b)localObject).loop) });
    if (this.cSa.get())
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
      if (((com.tencent.mm.ai.b)localObject).htC)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload begin");
        if (!com.tencent.mm.audio.mix.b.e.ML().eQ(this.sourcePath)) {
          Nf();
        }
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload end");
          return;
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
        }
      }
      if (!isPlaying()) {
        hB(3);
      }
      if (!com.tencent.mm.audio.mix.b.e.ML().eQ(this.sourcePath)) {
        Nf();
      }
      for (;;)
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
        this.cSa.set(false);
        com.tencent.mm.audio.mix.a.d locald = Nb();
        if (!this.cSd.get()) {
          break label270;
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
        if (!locald.aAb) {
          break;
        }
        hB(2);
        return;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
      }
      label270:
      if (isError())
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
        return;
      }
      if ((isPlaying()) || (((com.tencent.mm.ai.b)localObject).htn))
      {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "to play");
        hB(2);
      }
    }
    else
    {
      hB(4);
    }
    for (;;)
    {
      label335:
      int i;
      if (!com.tencent.mm.audio.mix.b.e.ML().eQ(this.sourcePath))
      {
        Nf();
        if ((!((com.tencent.mm.ai.b)localObject).loop) || (this.cSd.get())) {
          break label488;
        }
        i = 1;
        if (i != 0) {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", new Object[] { Nm() });
        }
      }
      try
      {
        Thread.sleep(20L);
        this.cSh = 0;
        if (i != 0) {
          continue;
        }
        if ((this.cSd.get()) || (isError()))
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
          localObject = Nl().filePath;
          if (this.cRV.equals(localObject))
          {
            this.cRM.cTM.fd(Nm());
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "task end");
            return;
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not to play");
            hB(2);
            return;
            Ng();
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
          if (!this.cRM.cTM.ff(Nm()))
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
            this.cRM.cTM.m(Nm(), true);
          }
          else
          {
            hB(7);
            this.cRM.cTM.fd(Nm());
          }
        }
      }
    }
  }
  
  protected abstract void Nf();
  
  protected final void Ng()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
    com.tencent.mm.audio.mix.a.d locald = Nb();
    if (locald == null) {
      return;
    }
    Ni();
    int j = locald.size();
    int i = 0;
    while ((i < j) && (!this.cSd.get()))
    {
      Nc();
      com.tencent.mm.audio.mix.a.e locale = locald.hy(i);
      if (locale != null) {
        a(locale);
      }
      i += 1;
    }
    Nj();
  }
  
  public final void Nh()
  {
    if ((!this.cSf.get()) && (!this.cSd.get()))
    {
      this.cSf.set(true);
      hB(13);
    }
  }
  
  protected void Ni() {}
  
  protected void Nj() {}
  
  public void Nk() {}
  
  public final com.tencent.mm.ai.b Nl()
  {
    if (this.cRV != null) {
      return this.cRV.NT();
    }
    return this.cRW;
  }
  
  protected final void a(com.tencent.mm.audio.mix.a.d paramd)
  {
    if (this.cRX == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "process is null");
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
    Ni();
    com.tencent.mm.audio.mix.a.e locale;
    if (!this.cSd.get())
    {
      Nc();
      locale = this.cRX.MS();
      if ((paramd.size() <= 0) || (locale != null)) {
        break label72;
      }
      paramd.complete();
    }
    for (;;)
    {
      Nj();
      return;
      label72:
      if ((paramd.size() == 0) && (locale == null))
      {
        paramd.reset();
      }
      else if (locale != null)
      {
        if (!paramd.aAb) {
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
    if (this.cSa.get()) {}
    while ((parame == null) || ((parame.cQR > 0L) && (this.cSh > 0) && (parame.cQR < this.cSh)) || (this.cRM == null) || (this.cRM.cTM == null) || (parame == null)) {
      return;
    }
    parame.cQO = Nm();
    c(parame);
  }
  
  protected void c(com.tencent.mm.audio.mix.a.e arg1)
  {
    int i;
    if (this.cRV.NT().cQL)
    {
      if (!this.cSg.get())
      {
        this.cSg.set(true);
        hB(14);
      }
      i = this.cRM.cTM.a(Nm(), ???, this);
      if (i < 50) {
        this.cSe.set(false);
      }
    }
    else
    {
      return;
    }
    ??? = Nb();
    if ((??? != null) && (???.aAb))
    {
      this.cSe.set(true);
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
    this.cSe.set(false);
  }
  
  public long getCurrentPosition()
  {
    return -1L;
  }
  
  public final void hA(int paramInt)
  {
    if (paramInt >= 20) {}
    while ((!this.cSe.get()) || (this.cSc.get()) || (this.cSd.get())) {
      return;
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", new Object[] { Integer.valueOf(paramInt) });
    Nd();
  }
  
  protected final void hB(int paramInt)
  {
    d(paramInt, 0, "");
  }
  
  public final void init()
  {
    this.cSh = this.cRV.NT().htm;
    this.cSc.set(false);
    this.cSd.set(false);
    if (this.cRV != null) {
      com.tencent.mm.audio.mix.g.b localb = this.cRV;
    }
    hB(1);
  }
  
  public final void onError(int paramInt)
  {
    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", new Object[] { Integer.valueOf(paramInt) });
    this.cRY = paramInt;
    this.cSd.set(true);
    d(9, paramInt, "");
  }
  
  public void pause()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pause");
    hB(5);
    this.cSc.set(true);
    this.cSf.set(false);
  }
  
  public final void release()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "release");
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "duration:%d", new Object[] { Long.valueOf(Nb().duration) });
    MX();
    onRelease();
    if (this.cRV != null)
    {
      this.cRV.NT().cSh = 0;
      com.tencent.mm.audio.mix.g.b localb = this.cRV;
    }
    this.cSa.set(false);
    this.cSd.set(true);
    this.cSc.set(false);
    this.cSe.set(false);
    this.cRM = null;
  }
  
  public final void resume()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "resume");
    hB(4);
    synchronized (this.lock)
    {
      if (this.cSc.get()) {
        this.cSc.set(false);
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
    int i = this.cSh;
    this.cSh = paramInt;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
  }
  
  public final void stop()
  {
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stop");
    Nk();
    hB(6);
    this.cSd.set(true);
    this.cSc.set(false);
    Nd();
    this.cSf.set(false);
    this.cSg.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.c
 * JD-Core Version:    0.7.0.1
 */