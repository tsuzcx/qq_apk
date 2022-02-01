package com.tencent.liteav;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.e;
import com.tencent.liteav.videoencoder.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class a
  implements e, com.tencent.liteav.videoencoder.d
{
  private static final String a;
  private int b;
  private long c;
  private a d;
  private HandlerThread e;
  private boolean f;
  private b g;
  private TXSNALPacket h;
  private com.tencent.liteav.beauty.d i;
  private ByteBuffer j;
  private Bitmap k;
  private int l;
  private int m;
  private WeakReference<b> n;
  
  static
  {
    AppMethodBeat.i(14967);
    a = a.class.getSimpleName();
    AppMethodBeat.o(14967);
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(14958);
    this.b = 300;
    this.c = 0L;
    this.f = false;
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = 0;
    this.m = 0;
    this.n = null;
    this.n = new WeakReference(paramb);
    AppMethodBeat.o(14958);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14962);
    int i1;
    if (paramInt1 > 0) {
      if (paramInt1 >= 8) {
        i1 = 8;
      }
    }
    for (this.b = (1000 / i1);; this.b = 200)
    {
      long l1 = paramInt2;
      if (paramInt2 <= 0) {
        break label79;
      }
      this.c = (l1 * 1000L + System.currentTimeMillis());
      AppMethodBeat.o(14962);
      return;
      i1 = paramInt1;
      if (paramInt1 > 3) {
        break;
      }
      i1 = 3;
      break;
    }
    label79:
    if (paramInt2 == 0)
    {
      this.c = (System.currentTimeMillis() + 300000L);
      AppMethodBeat.o(14962);
      return;
    }
    this.c = -1L;
    AppMethodBeat.o(14962);
  }
  
  private void d()
  {
    AppMethodBeat.i(14963);
    e();
    this.e = new HandlerThread("TXImageCapturer");
    this.e.start();
    this.d = new a(this.e.getLooper(), this.b, this.c);
    AppMethodBeat.o(14963);
  }
  
  private void e()
  {
    AppMethodBeat.i(14964);
    if (this.d != null)
    {
      this.d.removeCallbacksAndMessages(null);
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.quit();
      this.e = null;
    }
    AppMethodBeat.o(14964);
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: sipush 14965
    //   8: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: getfield 80	com/tencent/liteav/a:n	Ljava/lang/ref/WeakReference;
    //   15: ifnull +141 -> 156
    //   18: aload_0
    //   19: getfield 68	com/tencent/liteav/a:f	Z
    //   22: ifeq +134 -> 156
    //   25: aload_0
    //   26: getfield 80	com/tencent/liteav/a:n	Ljava/lang/ref/WeakReference;
    //   29: invokevirtual 142	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   32: checkcast 13	com/tencent/liteav/a$b
    //   35: astore 6
    //   37: aload 6
    //   39: ifnull +117 -> 156
    //   42: aload_0
    //   43: getfield 74	com/tencent/liteav/a:k	Landroid/graphics/Bitmap;
    //   46: astore 7
    //   48: aload_0
    //   49: getfield 72	com/tencent/liteav/a:j	Ljava/nio/ByteBuffer;
    //   52: astore 5
    //   54: aload 5
    //   56: ifnonnull +218 -> 274
    //   59: aload 7
    //   61: ifnull +213 -> 274
    //   64: aload 7
    //   66: invokevirtual 148	android/graphics/Bitmap:getWidth	()I
    //   69: istore_1
    //   70: aload 7
    //   72: invokevirtual 151	android/graphics/Bitmap:getHeight	()I
    //   75: istore_3
    //   76: iload_3
    //   77: istore_2
    //   78: iload_3
    //   79: istore 4
    //   81: iload_1
    //   82: iload_3
    //   83: imul
    //   84: iconst_4
    //   85: imul
    //   86: invokestatic 157	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   89: astore 5
    //   91: iload_3
    //   92: istore_2
    //   93: iload_3
    //   94: istore 4
    //   96: aload 7
    //   98: aload 5
    //   100: invokevirtual 161	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   103: iload_3
    //   104: istore_2
    //   105: iload_3
    //   106: istore 4
    //   108: aload 5
    //   110: invokevirtual 165	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   113: pop
    //   114: iload_3
    //   115: istore_2
    //   116: iload_3
    //   117: istore 4
    //   119: aload_0
    //   120: aload 5
    //   122: putfield 72	com/tencent/liteav/a:j	Ljava/nio/ByteBuffer;
    //   125: iload_3
    //   126: istore_2
    //   127: aload 7
    //   129: ifnull +27 -> 156
    //   132: aload 5
    //   134: ifnull +22 -> 156
    //   137: aload 6
    //   139: aload 7
    //   141: aload 5
    //   143: aload_0
    //   144: getfield 76	com/tencent/liteav/a:l	I
    //   147: aload_0
    //   148: getfield 78	com/tencent/liteav/a:m	I
    //   151: invokeinterface 168 5 0
    //   156: sipush 14965
    //   159: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: return
    //   163: astore 5
    //   165: iconst_0
    //   166: istore_2
    //   167: iconst_0
    //   168: istore_1
    //   169: getstatic 54	com/tencent/liteav/a:a	Ljava/lang/String;
    //   172: new 170	java/lang/StringBuilder
    //   175: dup
    //   176: ldc 172
    //   178: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   181: iload_1
    //   182: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: ldc 179
    //   187: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_2
    //   191: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 191	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: sipush 14965
    //   203: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: return
    //   207: astore 5
    //   209: iconst_0
    //   210: istore_2
    //   211: iconst_0
    //   212: istore_1
    //   213: getstatic 54	com/tencent/liteav/a:a	Ljava/lang/String;
    //   216: new 170	java/lang/StringBuilder
    //   219: dup
    //   220: ldc 193
    //   222: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: iload_1
    //   226: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: ldc 179
    //   231: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: iload_2
    //   235: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 191	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: sipush 14965
    //   247: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: return
    //   251: astore 5
    //   253: goto -40 -> 213
    //   256: astore 5
    //   258: goto -45 -> 213
    //   261: astore 5
    //   263: iload 4
    //   265: istore_2
    //   266: goto -97 -> 169
    //   269: astore 5
    //   271: goto -102 -> 169
    //   274: iconst_0
    //   275: istore_2
    //   276: iconst_0
    //   277: istore_1
    //   278: goto -151 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	a
    //   69	209	1	i1	int
    //   4	272	2	i2	int
    //   75	51	3	i3	int
    //   1	263	4	i4	int
    //   52	90	5	localByteBuffer	ByteBuffer
    //   163	1	5	localException1	Exception
    //   207	1	5	localError1	Error
    //   251	1	5	localError2	Error
    //   256	1	5	localError3	Error
    //   261	1	5	localException2	Exception
    //   269	1	5	localException3	Exception
    //   35	103	6	localb	b
    //   46	94	7	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   11	37	163	java/lang/Exception
    //   42	54	163	java/lang/Exception
    //   64	70	163	java/lang/Exception
    //   11	37	207	java/lang/Error
    //   42	54	207	java/lang/Error
    //   64	70	207	java/lang/Error
    //   70	76	251	java/lang/Error
    //   81	91	251	java/lang/Error
    //   96	103	251	java/lang/Error
    //   108	114	251	java/lang/Error
    //   119	125	251	java/lang/Error
    //   137	156	256	java/lang/Error
    //   70	76	261	java/lang/Exception
    //   81	91	261	java/lang/Exception
    //   96	103	261	java/lang/Exception
    //   108	114	261	java/lang/Exception
    //   119	125	261	java/lang/Exception
    //   137	156	269	java/lang/Exception
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return 0;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14959);
    if (this.f)
    {
      TXCLog.w(a, "bkgpush: start background publish return when started");
      AppMethodBeat.o(14959);
      return;
    }
    this.f = true;
    b(paramInt1, paramInt2);
    d();
    if (this.d != null) {
      this.d.sendEmptyMessageDelayed(1001, this.b);
    }
    TXCLog.w(a, "bkgpush: start background publish with time:" + (this.c - System.currentTimeMillis()) / 1000L + ", interval:" + this.b);
    AppMethodBeat.o(14959);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(14956);
    TXCLog.w(a, "bkgpush: got texture");
    if (this.g != null) {
      this.g.a(paramInt1, paramInt2, paramInt3, TXCTimeUtil.generatePtsMS());
    }
    AppMethodBeat.o(14956);
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(14960);
    if (this.f)
    {
      TXCLog.w(a, "bkgpush: start background publish return when started");
      AppMethodBeat.o(14960);
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {}
    try
    {
      TXCLog.w(a, "bkgpush: background publish img is empty, add default img " + paramInt3 + "*" + paramInt4);
      paramBitmap = new ColorDrawable(-16777216);
      localBitmap = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
      paramBitmap.draw(new Canvas(localBitmap));
      TXCLog.w(a, "bkgpush: generate bitmap " + paramInt3 + "*" + paramInt4);
      this.k = localBitmap;
    }
    catch (Error paramBitmap)
    {
      break label142;
    }
    catch (Exception paramBitmap)
    {
      label142:
      break label142;
    }
    this.l = paramInt3;
    this.m = paramInt4;
    a(paramInt1, paramInt2);
    AppMethodBeat.o(14960);
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(MediaFormat paramMediaFormat) {}
  
  public void a(TXSNALPacket paramTXSNALPacket, int paramInt)
  {
    AppMethodBeat.i(14957);
    this.h = paramTXSNALPacket;
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder("bkgpush: got nal type: ");
    Object localObject = paramTXSNALPacket;
    if (paramTXSNALPacket != null) {
      localObject = Integer.valueOf(paramTXSNALPacket.nalType);
    }
    TXCLog.w(str, localObject);
    if (this.g != null)
    {
      this.g.a(null);
      paramTXSNALPacket = this.g;
      try
      {
        if (this.n != null)
        {
          localObject = (b)this.n.get();
          if (localObject != null) {
            ((b)localObject).a(paramTXSNALPacket);
          }
        }
        AppMethodBeat.o(14957);
        return;
      }
      catch (Exception paramTXSNALPacket) {}
    }
    AppMethodBeat.o(14957);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public boolean a()
  {
    return this.f;
  }
  
  public void b()
  {
    AppMethodBeat.i(14961);
    this.f = false;
    this.j = null;
    this.k = null;
    TXCLog.w(a, "bkgpush: stop background publish");
    e();
    AppMethodBeat.o(14961);
  }
  
  class a
    extends Handler
  {
    private int b;
    private long c;
    
    public a(Looper paramLooper, int paramInt, long paramLong)
    {
      super();
      AppMethodBeat.i(15536);
      this.b = 300;
      this.c = 0L;
      this.b = paramInt;
      this.c = paramLong;
      TXCLog.w(a.c(), "bkgpush:init publish time delay:" + this.b + ", end:" + this.c);
      AppMethodBeat.o(15536);
    }
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(15537);
      if (paramMessage.what == 1001) {
        try
        {
          a.a(a.this);
          if ((this.c < 0L) || (System.currentTimeMillis() < this.c))
          {
            sendEmptyMessageDelayed(1001, this.b);
            AppMethodBeat.o(15537);
            return;
          }
          TXCLog.w(a.c(), "bkgpush:stop background publish when timeout");
          if ((a.b(a.this) != null) && (a.c(a.this)))
          {
            paramMessage = (a.b)a.b(a.this).get();
            if (paramMessage != null) {
              paramMessage.a();
            }
            a.a(a.this, false);
          }
          AppMethodBeat.o(15537);
          return;
        }
        catch (Exception paramMessage) {}
      }
      AppMethodBeat.o(15537);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(Bitmap paramBitmap, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
    
    public abstract void a(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.a
 * JD-Core Version:    0.7.0.1
 */