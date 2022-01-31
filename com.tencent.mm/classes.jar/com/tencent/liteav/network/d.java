package com.tencent.liteav.network;

import com.tencent.liteav.basic.f.a;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.util.Vector;

public class d
  implements f
{
  private f a = null;
  private d.b b = null;
  private long c = 0L;
  private long d = 0L;
  private d.b e = null;
  private d.a f;
  private long g = 0L;
  private long h = 0L;
  
  public d(d.a parama)
  {
    this.f = parama;
  }
  
  long a(long paramLong)
  {
    if (this.b != null) {
      this.b.b(this.c);
    }
    TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop begin from " + this.c);
    return this.c;
  }
  
  public void a()
  {
    if (this.b != null) {
      this.b.b(0L);
    }
    if (this.e != null) {
      this.e.b(0L);
    }
  }
  
  public void a(TXIStreamDownloader paramTXIStreamDownloader1, TXIStreamDownloader paramTXIStreamDownloader2, long paramLong1, long paramLong2, String paramString)
  {
    this.c = paramLong1;
    this.d = paramLong2;
    this.b = new d.b(paramTXIStreamDownloader1, this);
    this.b.a(this);
    Vector localVector = new Vector();
    localVector.add(new e(paramString, false));
    paramTXIStreamDownloader2.setOriginUrl(paramString);
    paramTXIStreamDownloader2.startDownload(localVector, false, false, paramTXIStreamDownloader1.mEnableMessage);
    this.e = new d.b(paramTXIStreamDownloader2, this);
    this.e.a(this.c);
  }
  
  void a(TXIStreamDownloader paramTXIStreamDownloader, boolean paramBoolean)
  {
    if (this.f != null) {
      this.f.onSwitchFinish(paramTXIStreamDownloader, paramBoolean);
    }
  }
  
  public void a(f paramf)
  {
    this.a = paramf;
  }
  
  void b()
  {
    this.b.a(null);
    this.e.a(this);
    this.b = this.e;
    this.e = null;
    StringBuilder localStringBuilder = new StringBuilder(" stream_switch end at ").append(this.c).append(" stop ts ").append(this.h).append(" start ts ").append(this.g).append(" diff ts ");
    if (this.h > this.g) {}
    for (long l = this.h - this.g;; l = this.g - this.h)
    {
      TXCLog.w("TXCMultiStreamDownloader", l);
      return;
    }
  }
  
  void b(long paramLong)
  {
    this.g = paramLong;
  }
  
  void c(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void onPullAudio(a parama)
  {
    if (this.a != null) {
      this.a.onPullAudio(parama);
    }
  }
  
  public void onPullNAL(b paramb)
  {
    this.c = paramb.g;
    if (paramb.b == 0) {
      this.d = paramb.g;
    }
    if (this.a != null) {
      this.a.onPullNAL(paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.network.d
 * JD-Core Version:    0.7.0.1
 */