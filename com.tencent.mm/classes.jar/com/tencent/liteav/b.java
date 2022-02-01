package com.tencent.liteav;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class b
{
  private static final String a;
  private int b;
  private long c;
  private a d;
  private HandlerThread e;
  private boolean f;
  private ByteBuffer g;
  private Bitmap h;
  private int i;
  private int j;
  private WeakReference<b> k;
  
  static
  {
    AppMethodBeat.i(244959);
    a = b.class.getSimpleName();
    AppMethodBeat.o(244959);
  }
  
  public b(b paramb)
  {
    AppMethodBeat.i(244938);
    this.b = 300;
    this.c = 0L;
    this.f = false;
    this.g = null;
    this.h = null;
    this.i = 0;
    this.j = 0;
    this.k = null;
    this.k = new WeakReference(paramb);
    AppMethodBeat.o(244938);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16710);
    int m;
    if (paramInt1 > 0) {
      if (paramInt1 >= 20) {
        m = 20;
      }
    }
    for (this.b = (1000 / m);; this.b = 200)
    {
      long l = paramInt2;
      if (paramInt2 <= 0) {
        break label79;
      }
      this.c = (l * 1000L + System.currentTimeMillis());
      AppMethodBeat.o(16710);
      return;
      m = paramInt1;
      if (paramInt1 > 5) {
        break;
      }
      m = 5;
      break;
    }
    label79:
    if (paramInt2 == 0)
    {
      this.c = (System.currentTimeMillis() + 300000L);
      AppMethodBeat.o(16710);
      return;
    }
    this.c = -1L;
    AppMethodBeat.o(16710);
  }
  
  private void d()
  {
    AppMethodBeat.i(244949);
    e();
    this.e = new HandlerThread("TXImageCapturer");
    this.e.start();
    this.d = new a(this.e.getLooper(), this.b, this.c);
    AppMethodBeat.o(244949);
  }
  
  private void e()
  {
    AppMethodBeat.i(244951);
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
    AppMethodBeat.o(244951);
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: ldc 132
    //   7: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 70	com/tencent/liteav/b:k	Ljava/lang/ref/WeakReference;
    //   14: ifnull +141 -> 155
    //   17: aload_0
    //   18: getfield 60	com/tencent/liteav/b:f	Z
    //   21: ifeq +134 -> 155
    //   24: aload_0
    //   25: getfield 70	com/tencent/liteav/b:k	Ljava/lang/ref/WeakReference;
    //   28: invokevirtual 136	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   31: checkcast 9	com/tencent/liteav/b$b
    //   34: astore 6
    //   36: aload 6
    //   38: ifnull +117 -> 155
    //   41: aload_0
    //   42: getfield 64	com/tencent/liteav/b:h	Landroid/graphics/Bitmap;
    //   45: astore 7
    //   47: aload_0
    //   48: getfield 62	com/tencent/liteav/b:g	Ljava/nio/ByteBuffer;
    //   51: astore 5
    //   53: aload 5
    //   55: ifnonnull +215 -> 270
    //   58: aload 7
    //   60: ifnull +210 -> 270
    //   63: aload 7
    //   65: invokevirtual 142	android/graphics/Bitmap:getWidth	()I
    //   68: istore_1
    //   69: aload 7
    //   71: invokevirtual 145	android/graphics/Bitmap:getHeight	()I
    //   74: istore_3
    //   75: iload_3
    //   76: istore_2
    //   77: iload_3
    //   78: istore 4
    //   80: iload_1
    //   81: iload_3
    //   82: imul
    //   83: iconst_4
    //   84: imul
    //   85: invokestatic 151	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   88: astore 5
    //   90: iload_3
    //   91: istore_2
    //   92: iload_3
    //   93: istore 4
    //   95: aload 7
    //   97: aload 5
    //   99: invokevirtual 155	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   102: iload_3
    //   103: istore_2
    //   104: iload_3
    //   105: istore 4
    //   107: aload 5
    //   109: invokevirtual 159	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   112: pop
    //   113: iload_3
    //   114: istore_2
    //   115: iload_3
    //   116: istore 4
    //   118: aload_0
    //   119: aload 5
    //   121: putfield 62	com/tencent/liteav/b:g	Ljava/nio/ByteBuffer;
    //   124: iload_3
    //   125: istore_2
    //   126: aload 7
    //   128: ifnull +27 -> 155
    //   131: aload 5
    //   133: ifnull +22 -> 155
    //   136: aload 6
    //   138: aload 7
    //   140: aload 5
    //   142: aload_0
    //   143: getfield 66	com/tencent/liteav/b:i	I
    //   146: aload_0
    //   147: getfield 68	com/tencent/liteav/b:j	I
    //   150: invokeinterface 162 5 0
    //   155: ldc 132
    //   157: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: return
    //   161: astore 5
    //   163: iconst_0
    //   164: istore_2
    //   165: iconst_0
    //   166: istore_1
    //   167: getstatic 45	com/tencent/liteav/b:a	Ljava/lang/String;
    //   170: new 164	java/lang/StringBuilder
    //   173: dup
    //   174: ldc 166
    //   176: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   179: iload_1
    //   180: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc 173
    //   185: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: iload_2
    //   189: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 185	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: ldc 132
    //   200: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: return
    //   204: astore 5
    //   206: iconst_0
    //   207: istore_2
    //   208: iconst_0
    //   209: istore_1
    //   210: getstatic 45	com/tencent/liteav/b:a	Ljava/lang/String;
    //   213: new 164	java/lang/StringBuilder
    //   216: dup
    //   217: ldc 187
    //   219: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   222: iload_1
    //   223: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc 173
    //   228: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload_2
    //   232: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 185	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: ldc 132
    //   243: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: return
    //   247: astore 5
    //   249: goto -39 -> 210
    //   252: astore 5
    //   254: goto -44 -> 210
    //   257: astore 5
    //   259: iload 4
    //   261: istore_2
    //   262: goto -95 -> 167
    //   265: astore 5
    //   267: goto -100 -> 167
    //   270: iconst_0
    //   271: istore_2
    //   272: iconst_0
    //   273: istore_1
    //   274: goto -148 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	b
    //   68	206	1	m	int
    //   4	268	2	n	int
    //   74	51	3	i1	int
    //   1	259	4	i2	int
    //   51	90	5	localByteBuffer	ByteBuffer
    //   161	1	5	localException1	Exception
    //   204	1	5	localError1	Error
    //   247	1	5	localError2	Error
    //   252	1	5	localError3	Error
    //   257	1	5	localException2	Exception
    //   265	1	5	localException3	Exception
    //   34	103	6	localb	b
    //   45	94	7	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   10	36	161	java/lang/Exception
    //   41	53	161	java/lang/Exception
    //   63	69	161	java/lang/Exception
    //   10	36	204	java/lang/Error
    //   41	53	204	java/lang/Error
    //   63	69	204	java/lang/Error
    //   69	75	247	java/lang/Error
    //   80	90	247	java/lang/Error
    //   95	102	247	java/lang/Error
    //   107	113	247	java/lang/Error
    //   118	124	247	java/lang/Error
    //   136	155	252	java/lang/Error
    //   69	75	257	java/lang/Exception
    //   80	90	257	java/lang/Exception
    //   95	102	257	java/lang/Exception
    //   107	113	257	java/lang/Exception
    //   118	124	257	java/lang/Exception
    //   136	155	265	java/lang/Exception
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16698);
    if (this.f)
    {
      TXCLog.w(a, "bkgpush: start background publish return when started");
      AppMethodBeat.o(16698);
      return;
    }
    this.f = true;
    b(paramInt1, paramInt2);
    d();
    if (this.d != null) {
      this.d.sendEmptyMessageDelayed(1001, this.b);
    }
    TXCLog.w(a, "bkgpush: start background publish with time:" + (this.c - System.currentTimeMillis()) / 1000L + ", interval:" + this.b);
    AppMethodBeat.o(16698);
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(244941);
    if (this.f)
    {
      TXCLog.w(a, "bkgpush: start background publish return when started");
      AppMethodBeat.o(244941);
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
      this.h = localBitmap;
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        TXCLog.e(a, "save bitmap failed.", paramBitmap);
      }
    }
    catch (Error paramBitmap)
    {
      for (;;)
      {
        TXCLog.e(a, "save bitmap failed.", paramBitmap);
      }
    }
    this.i = paramInt3;
    this.j = paramInt4;
    a(paramInt1, paramInt2);
    AppMethodBeat.o(244941);
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public void b()
  {
    AppMethodBeat.i(16693);
    this.f = false;
    this.g = null;
    this.h = null;
    TXCLog.w(a, "bkgpush: stop background publish");
    e();
    AppMethodBeat.o(16693);
  }
  
  class a
    extends Handler
  {
    private int b;
    private long c;
    
    public a(Looper paramLooper, int paramInt, long paramLong)
    {
      super();
      AppMethodBeat.i(221764);
      this.b = 300;
      this.c = 0L;
      this.b = paramInt;
      this.c = paramLong;
      TXCLog.w(b.c(), "bkgpush:init publish time delay:" + this.b + ", end:" + this.c);
      AppMethodBeat.o(221764);
    }
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(221771);
      if (paramMessage.what == 1001) {
        try
        {
          b.a(b.this);
          if ((this.c < 0L) || (System.currentTimeMillis() < this.c))
          {
            sendEmptyMessageDelayed(1001, this.b);
            AppMethodBeat.o(221771);
            return;
          }
          TXCLog.w(b.c(), "bkgpush:stop background publish when timeout");
          if ((b.b(b.this) != null) && (b.c(b.this)))
          {
            paramMessage = (b.b)b.b(b.this).get();
            if (paramMessage != null) {
              paramMessage.a();
            }
            b.a(b.this, false);
          }
          AppMethodBeat.o(221771);
          return;
        }
        catch (Exception paramMessage)
        {
          TXCLog.e(b.c(), "publish image failed." + paramMessage.getMessage());
        }
      }
      AppMethodBeat.o(221771);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(Bitmap paramBitmap, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.b
 * JD-Core Version:    0.7.0.1
 */