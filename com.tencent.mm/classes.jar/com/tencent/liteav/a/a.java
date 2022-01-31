package com.tencent.liteav.a;

import android.content.Context;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.d;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.microedition.khronos.egl.EGLContext;

public class a
  implements com.tencent.liteav.audio.e, d
{
  private com.tencent.liteav.audio.impl.Record.e a = new com.tencent.liteav.audio.impl.Record.e();
  private com.tencent.liteav.videoencoder.a b = new com.tencent.liteav.videoencoder.a();
  private com.tencent.liteav.muxer.c c;
  private a d;
  private a.b e;
  private long f = 0L;
  private long g = -1L;
  private boolean h = false;
  private Handler i = new a.1(this, Looper.getMainLooper());
  
  public a(Context paramContext)
  {
    this.c = new com.tencent.liteav.muxer.c(paramContext, 1);
  }
  
  private String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      this.i.sendMessage(Message.obtain(this.i, 2, 1, 0, str));
      return str;
      str = "视频编码失败";
      continue;
      str = "视频编码初始化失败";
      continue;
      str = "非法视频输入参数";
      continue;
      str = "未启动视频编码器";
    }
  }
  
  private static String a(Context paramContext)
  {
    if (("mounted".equals(Environment.getExternalStorageState())) || (!Environment.isExternalStorageRemovable())) {
      return paramContext.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getPath();
    }
    return paramContext.getFilesDir().getPath();
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      long l = System.currentTimeMillis() / 1000L;
      String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(Long.valueOf(String.valueOf(l) + "000").longValue()));
      paramContext = new File(a(paramContext), String.format("TXUGC_%s" + paramString, new Object[] { str })).getAbsolutePath();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public void a()
  {
    this.h = false;
    this.a.a();
    this.b.stop();
    if (this.c.b() < 0)
    {
      this.i.sendMessage(Message.obtain(this.i, 2, 1, 0, "mp4合成失败"));
      return;
    }
    this.i.sendMessage(Message.obtain(this.i, 2, 0, 0, ""));
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.b.pushVideoFrame(paramInt, this.d.a, this.d.b, paramLong);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(MediaFormat paramMediaFormat)
  {
    this.c.a(paramMediaFormat);
    if ((this.c.c()) && (this.c.a() < 0)) {
      this.i.sendMessage(Message.obtain(this.i, 2, 1, 0, "mp4封装器启动失败"));
    }
  }
  
  public void a(a parama)
  {
    this.d = parama;
    this.f = 0L;
    this.g = -1L;
    this.c.a(this.d.f);
    if ((parama.h > 0) && (parama.i > 0) && (parama.j > 0))
    {
      this.a.a(com.tencent.liteav.audio.c.f, parama.i, parama.h, parama.j, new WeakReference(this));
      parama = com.tencent.liteav.basic.util.a.a(this.d.i, this.d.h, 2);
      this.c.b(parama);
      this.h = true;
    }
    this.b.setListener(this);
    parama = new TXSVideoEncoderParam();
    parama.width = this.d.a;
    parama.height = this.d.b;
    parama.fps = this.d.c;
    parama.glContext = this.d.e;
    parama.annexb = true;
    parama.appendSpsPps = false;
    this.b.setBitrate(this.d.d);
    this.b.start(parama);
  }
  
  public void a(a.b paramb)
  {
    this.e = paramb;
  }
  
  public void a(b paramb, int paramInt)
  {
    if (paramInt == 0)
    {
      this.c.b(paramb.a, 0, paramb.a.length, paramb.g * 1000L, paramb.k.flags);
      if (this.g < 0L) {
        this.g = paramb.g;
      }
      if (paramb.g > this.f + 500L)
      {
        this.i.sendMessage(Message.obtain(this.i, 1, new Long(paramb.g - this.g)));
        this.f = paramb.g;
      }
      return;
    }
    paramb = a(paramInt);
    TXCLog.e("TXCStreamRecord", "video encode error! errmsg: " + paramb);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.h)
    {
      this.a.a(paramArrayOfByte, paramLong);
      return;
    }
    TXCLog.e("TXCStreamRecord", "drainAudio fail because of not init yet!");
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c.a(paramArrayOfByte, 0, paramArrayOfByte.length, 1000L * paramLong, 1);
  }
  
  public static class a
  {
    public int a = 544;
    public int b = 960;
    public int c = 20;
    public int d = 1000;
    public EGLContext e;
    public String f;
    public String g;
    public int h = 0;
    public int i = 0;
    public int j = 16;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TXCStreamRecordParams: [width=" + this.a);
      localStringBuilder.append("; height=" + this.b);
      localStringBuilder.append("; fps=" + this.c);
      localStringBuilder.append("; bitrate=" + this.d);
      localStringBuilder.append("; channels=" + this.h);
      localStringBuilder.append("; samplerate=" + this.i);
      localStringBuilder.append("; bits=" + this.j);
      localStringBuilder.append("; EGLContext=" + this.e);
      localStringBuilder.append("; coveriamge=" + this.g);
      localStringBuilder.append("; outputpath=" + this.f + "]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.a.a
 * JD-Core Version:    0.7.0.1
 */