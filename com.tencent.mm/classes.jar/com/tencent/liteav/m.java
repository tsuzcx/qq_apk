package com.tencent.liteav;

import android.content.Context;
import android.view.Surface;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.d.o;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import java.lang.ref.WeakReference;

public abstract class m
{
  protected g a = null;
  protected Context b = null;
  protected TXCloudVideoView c = null;
  protected WeakReference<a> d;
  
  public m(Context paramContext)
  {
    if (paramContext != null) {
      this.b = paramContext.getApplicationContext();
    }
  }
  
  public int a(String paramString)
  {
    return -1;
  }
  
  public abstract int a(String paramString, int paramInt);
  
  public abstract int a(boolean paramBoolean);
  
  public void a()
  {
    TXCLog.w("TXIPlayer", "pause not support");
  }
  
  public void a(float paramFloat)
  {
    TXCLog.w("TXIPlayer", "rate not implement");
  }
  
  public abstract void a(int paramInt);
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Context paramContext, int paramInt) {}
  
  public void a(Surface paramSurface) {}
  
  public void a(a parama)
  {
    this.d = new WeakReference(parama);
  }
  
  public abstract void a(o paramo);
  
  public void a(g paramg)
  {
    this.a = paramg;
    if (this.a == null) {
      this.a = new g();
    }
  }
  
  public void a(n paramn) {}
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener) {}
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    this.c = paramTXCloudVideoView;
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener) {}
  
  public void b()
  {
    TXCLog.w("TXIPlayer", "resume not support");
  }
  
  public abstract void b(int paramInt);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c(int paramInt);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract boolean c();
  
  public abstract int d();
  
  public abstract int d(int paramInt);
  
  public abstract void d(boolean paramBoolean);
  
  public void e(int paramInt)
  {
    TXCLog.w("TXIPlayer", "seek not support");
  }
  
  public void e(boolean paramBoolean)
  {
    TXCLog.w("TXIPlayer", "autoPlay not implement");
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f() {}
  
  public abstract int h();
  
  public g i()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.m
 * JD-Core Version:    0.7.0.1
 */