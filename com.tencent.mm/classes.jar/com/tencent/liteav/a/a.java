package com.tencent.liteav.a;

import android.content.Context;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.muxer.c;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.microedition.khronos.egl.EGLContext;

public class a
  implements e, com.tencent.liteav.videoencoder.d
{
  private com.tencent.liteav.audio.impl.a.d a;
  private com.tencent.liteav.videoencoder.a b;
  private c c;
  private a d;
  private b e;
  private long f;
  private long g;
  private boolean h;
  private Handler i;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(16672);
    this.f = 0L;
    this.g = -1L;
    this.h = false;
    this.i = new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(16670);
        if (a.a(a.this) != null) {
          switch (paramAnonymousMessage.what)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(16670);
          return;
          a.a(a.this).a(((Long)paramAnonymousMessage.obj).longValue());
          AppMethodBeat.o(16670);
          return;
          TXCLog.d("TXCStreamRecord", "record complete. errcode = " + paramAnonymousMessage.arg1 + ", errmsg = " + (String)paramAnonymousMessage.obj + ", outputPath = " + a.b(a.this).f + ", coverImage = " + a.b(a.this).g);
          if ((paramAnonymousMessage.arg1 == 0) && (a.b(a.this).g != null) && (!a.b(a.this).g.isEmpty()) && (!com.tencent.liteav.basic.util.d.a(a.b(a.this).f, a.b(a.this).g))) {
            TXCLog.e("TXCStreamRecord", "saveVideoThumb error. sourcePath = " + a.b(a.this).f + ", coverImagePath = " + a.b(a.this).g);
          }
          if (paramAnonymousMessage.arg1 != 0) {}
          try
          {
            File localFile = new File(a.b(a.this).f);
            if (localFile.exists()) {
              localFile.delete();
            }
            label302:
            a.a(a.this).a(paramAnonymousMessage.arg1, (String)paramAnonymousMessage.obj, a.b(a.this).f, a.b(a.this).g);
          }
          catch (Exception localException)
          {
            break label302;
          }
        }
      }
    };
    this.a = new com.tencent.liteav.audio.impl.a.d();
    this.b = new com.tencent.liteav.videoencoder.a();
    this.c = new c(paramContext, 1);
    AppMethodBeat.o(16672);
  }
  
  private static String a(Context paramContext)
  {
    Object localObject = null;
    AppMethodBeat.i(16678);
    if (paramContext == null)
    {
      AppMethodBeat.o(16678);
      return null;
    }
    File localFile;
    if (("mounted".equals(Environment.getExternalStorageState())) || (!Environment.isExternalStorageRemovable()))
    {
      localFile = paramContext.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
      paramContext = localObject;
      if (localFile == null) {}
    }
    for (paramContext = localFile.getPath();; paramContext = paramContext.getFilesDir().getPath())
    {
      AppMethodBeat.o(16678);
      return paramContext;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(16677);
    if (paramContext == null)
    {
      AppMethodBeat.o(16677);
      return null;
    }
    try
    {
      long l = System.currentTimeMillis() / 1000L;
      String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(Long.valueOf(String.valueOf(l) + "000").longValue()));
      paramContext = a(paramContext);
      boolean bool = TextUtils.isEmpty(paramContext);
      if (bool)
      {
        AppMethodBeat.o(16677);
        return null;
      }
      paramContext = new File(paramContext, String.format("TXUGC_%s".concat(String.valueOf(paramString)), new Object[] { str })).getAbsolutePath();
      AppMethodBeat.o(16677);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(16677);
    }
    return null;
  }
  
  private String b(int paramInt)
  {
    AppMethodBeat.i(16679);
    String str;
    switch (paramInt)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      this.i.sendMessage(Message.obtain(this.i, 2, 1, 0, str));
      AppMethodBeat.o(16679);
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
  
  public void a()
  {
    AppMethodBeat.i(16674);
    this.h = false;
    this.a.a();
    this.b.stop();
    if (this.c.b() < 0)
    {
      this.i.sendMessage(Message.obtain(this.i, 2, 1, 0, "mp4合成失败"));
      AppMethodBeat.o(16674);
      return;
    }
    this.i.sendMessage(Message.obtain(this.i, 2, 0, 0, ""));
    AppMethodBeat.o(16674);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, long paramLong)
  {
    AppMethodBeat.i(16675);
    this.b.pushVideoFrame(paramInt, this.d.a, this.d.b, paramLong);
    AppMethodBeat.o(16675);
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(16682);
    this.c.a(paramMediaFormat);
    if ((this.c.c()) && (this.c.a() < 0)) {
      this.i.sendMessage(Message.obtain(this.i, 2, 1, 0, "mp4封装器启动失败"));
    }
    AppMethodBeat.o(16682);
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(16673);
    this.d = parama;
    this.f = 0L;
    this.g = -1L;
    this.c.a(this.d.f);
    if ((parama.h > 0) && (parama.i > 0) && (parama.j > 0))
    {
      this.a.a(10, parama.i, parama.h, parama.j, new WeakReference(this));
      parama = com.tencent.liteav.basic.util.d.a(this.d.i, this.d.h, 2);
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
    AppMethodBeat.o(16673);
  }
  
  public void a(b paramb)
  {
    this.e = paramb;
  }
  
  public void a(TXSNALPacket paramTXSNALPacket, int paramInt)
  {
    AppMethodBeat.i(16681);
    if (paramInt == 0)
    {
      this.c.b(paramTXSNALPacket.nalData, 0, paramTXSNALPacket.nalData.length, paramTXSNALPacket.pts * 1000L, paramTXSNALPacket.info.flags);
      if (this.g < 0L) {
        this.g = paramTXSNALPacket.pts;
      }
      if (paramTXSNALPacket.pts > this.f + 500L)
      {
        this.i.sendMessage(Message.obtain(this.i, 1, new Long(paramTXSNALPacket.pts - this.g)));
        this.f = paramTXSNALPacket.pts;
        AppMethodBeat.o(16681);
      }
    }
    else
    {
      TXCLog.e("TXCStreamRecord", "video encode error! errmsg: ".concat(String.valueOf(b(paramInt))));
    }
    AppMethodBeat.o(16681);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(16676);
    if (this.h)
    {
      this.a.a(paramArrayOfByte, paramLong);
      AppMethodBeat.o(16676);
      return;
    }
    TXCLog.e("TXCStreamRecord", "drainAudio fail because of not init yet!");
    AppMethodBeat.o(16676);
  }
  
  public void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16680);
    this.c.a(paramArrayOfByte, 0, paramArrayOfByte.length, 1000L * paramLong, 1);
    AppMethodBeat.o(16680);
  }
  
  public void onRecordError(int paramInt, String paramString) {}
  
  public void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
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
      AppMethodBeat.i(16671);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TXCStreamRecordParams: [width=" + this.a);
      ((StringBuilder)localObject).append("; height=" + this.b);
      ((StringBuilder)localObject).append("; fps=" + this.c);
      ((StringBuilder)localObject).append("; bitrate=" + this.d);
      ((StringBuilder)localObject).append("; channels=" + this.h);
      ((StringBuilder)localObject).append("; samplerate=" + this.i);
      ((StringBuilder)localObject).append("; bits=" + this.j);
      ((StringBuilder)localObject).append("; EGLContext=" + this.e);
      ((StringBuilder)localObject).append("; coveriamge=" + this.g);
      ((StringBuilder)localObject).append("; outputpath=" + this.f + "]");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(16671);
      return localObject;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString1, String paramString2, String paramString3);
    
    public abstract void a(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.a.a
 * JD-Core Version:    0.7.0.1
 */