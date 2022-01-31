package com.tencent.liteav;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.c;
import com.tencent.liteav.videoencoder.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class a
  implements com.tencent.liteav.beauty.d, com.tencent.liteav.videoencoder.d
{
  private static final String a;
  private int b;
  private long c;
  private a.a d;
  private HandlerThread e;
  private boolean f;
  private b g;
  private TXSNALPacket h;
  private c i;
  private ByteBuffer j;
  private Bitmap k;
  private int l;
  private int m;
  private WeakReference<a.b> n;
  
  static
  {
    AppMethodBeat.i(67720);
    a = a.class.getSimpleName();
    AppMethodBeat.o(67720);
  }
  
  public a(a.b paramb)
  {
    AppMethodBeat.i(67710);
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
    AppMethodBeat.o(67710);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67715);
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
        break label77;
      }
      this.c = (l1 * 1000L + System.currentTimeMillis());
      AppMethodBeat.o(67715);
      return;
      i1 = paramInt1;
      if (paramInt1 > 3) {
        break;
      }
      i1 = 3;
      break;
    }
    label77:
    this.c = (System.currentTimeMillis() + 300000L);
    AppMethodBeat.o(67715);
  }
  
  private void c()
  {
    AppMethodBeat.i(67716);
    d();
    this.e = new HandlerThread("TXImageCapturer");
    this.e.start();
    this.d = new a.a(this, this.e.getLooper(), this.b, this.c);
    AppMethodBeat.o(67716);
  }
  
  private void d()
  {
    AppMethodBeat.i(67717);
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
    AppMethodBeat.o(67717);
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: ldc 143
    //   7: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 82	com/tencent/liteav/a:n	Ljava/lang/ref/WeakReference;
    //   14: ifnull +141 -> 155
    //   17: aload_0
    //   18: getfield 70	com/tencent/liteav/a:f	Z
    //   21: ifeq +134 -> 155
    //   24: aload_0
    //   25: getfield 82	com/tencent/liteav/a:n	Ljava/lang/ref/WeakReference;
    //   28: invokevirtual 147	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   31: checkcast 12	com/tencent/liteav/a$b
    //   34: astore 6
    //   36: aload 6
    //   38: ifnull +117 -> 155
    //   41: aload_0
    //   42: getfield 76	com/tencent/liteav/a:k	Landroid/graphics/Bitmap;
    //   45: astore 7
    //   47: aload_0
    //   48: getfield 74	com/tencent/liteav/a:j	Ljava/nio/ByteBuffer;
    //   51: astore 5
    //   53: aload 5
    //   55: ifnonnull +215 -> 270
    //   58: aload 7
    //   60: ifnull +210 -> 270
    //   63: aload 7
    //   65: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   68: istore_1
    //   69: aload 7
    //   71: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
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
    //   85: invokestatic 162	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   88: astore 5
    //   90: iload_3
    //   91: istore_2
    //   92: iload_3
    //   93: istore 4
    //   95: aload 7
    //   97: aload 5
    //   99: invokevirtual 166	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   102: iload_3
    //   103: istore_2
    //   104: iload_3
    //   105: istore 4
    //   107: aload 5
    //   109: invokevirtual 170	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   112: pop
    //   113: iload_3
    //   114: istore_2
    //   115: iload_3
    //   116: istore 4
    //   118: aload_0
    //   119: aload 5
    //   121: putfield 74	com/tencent/liteav/a:j	Ljava/nio/ByteBuffer;
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
    //   143: getfield 78	com/tencent/liteav/a:l	I
    //   146: aload_0
    //   147: getfield 80	com/tencent/liteav/a:m	I
    //   150: invokeinterface 173 5 0
    //   155: ldc 143
    //   157: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: return
    //   161: astore 5
    //   163: iconst_0
    //   164: istore_2
    //   165: iconst_0
    //   166: istore_1
    //   167: getstatic 55	com/tencent/liteav/a:a	Ljava/lang/String;
    //   170: new 175	java/lang/StringBuilder
    //   173: dup
    //   174: ldc 177
    //   176: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   179: iload_1
    //   180: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc 184
    //   185: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: iload_2
    //   189: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: ldc 143
    //   200: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: return
    //   204: astore 5
    //   206: iconst_0
    //   207: istore_2
    //   208: iconst_0
    //   209: istore_1
    //   210: getstatic 55	com/tencent/liteav/a:a	Ljava/lang/String;
    //   213: new 175	java/lang/StringBuilder
    //   216: dup
    //   217: ldc 198
    //   219: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   222: iload_1
    //   223: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc 184
    //   228: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: iload_2
    //   232: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: ldc 143
    //   243: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	277	0	this	a
    //   68	206	1	i1	int
    //   4	268	2	i2	int
    //   74	51	3	i3	int
    //   1	259	4	i4	int
    //   51	90	5	localByteBuffer	ByteBuffer
    //   161	1	5	localException1	Exception
    //   204	1	5	localError1	Error
    //   247	1	5	localError2	Error
    //   252	1	5	localError3	Error
    //   257	1	5	localException2	Exception
    //   265	1	5	localException3	Exception
    //   34	103	6	localb	a.b
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
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return 0;
  }
  
  public void a()
  {
    AppMethodBeat.i(67713);
    this.f = false;
    this.j = null;
    this.k = null;
    TXCLog.w(a, "bkgpush: stop background publish");
    d();
    AppMethodBeat.o(67713);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67711);
    if (this.f)
    {
      TXCLog.w(a, "bkgpush: start background publish return when started");
      AppMethodBeat.o(67711);
      return;
    }
    this.f = true;
    b(paramInt1, paramInt2);
    c();
    if (this.d != null) {
      this.d.sendEmptyMessageDelayed(1001, this.b);
    }
    TXCLog.w(a, "bkgpush: start background publish with time:" + (this.c - System.currentTimeMillis()) / 1000L + ", interval:" + this.b);
    AppMethodBeat.o(67711);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(67708);
    TXCLog.w(a, "bkgpush: got texture");
    if (this.g != null) {
      this.g.a(paramInt1, paramInt2, paramInt3, TXCTimeUtil.getTimeTick());
    }
    AppMethodBeat.o(67708);
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(67712);
    if (this.f)
    {
      TXCLog.w(a, "bkgpush: start background publish return when started");
      AppMethodBeat.o(67712);
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
      break label141;
    }
    catch (Exception paramBitmap)
    {
      label141:
      break label141;
    }
    this.l = paramInt3;
    this.m = paramInt4;
    a(paramInt1, paramInt2);
    AppMethodBeat.o(67712);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(MediaFormat paramMediaFormat) {}
  
  public void a(TXSNALPacket paramTXSNALPacket, int paramInt)
  {
    AppMethodBeat.i(146455);
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
          localObject = (a.b)this.n.get();
          if (localObject != null) {
            ((a.b)localObject).a(paramTXSNALPacket);
          }
        }
        AppMethodBeat.o(146455);
        return;
      }
      catch (Exception paramTXSNALPacket) {}
    }
    AppMethodBeat.o(146455);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.a
 * JD-Core Version:    0.7.0.1
 */