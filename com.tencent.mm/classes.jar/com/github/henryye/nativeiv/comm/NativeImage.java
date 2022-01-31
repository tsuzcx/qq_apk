package com.github.henryye.nativeiv.comm;

import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

@Keep
public class NativeImage
  implements IBitmap<NativeBitmapStruct>
{
  private static final String TAG = "Ni.NativeImage";
  private a factory;
  private NativeImageJni jni;
  private long lastDecodeUsing;
  private NativeBitmapStruct mNativeBitmapStruct;
  
  /* Error */
  public NativeImage(NativeImageJni paramNativeImageJni, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 25	java/lang/Object:<init>	()V
    //   4: ldc 26
    //   6: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 34	com/github/henryye/nativeiv/comm/NativeImage:mNativeBitmapStruct	Lcom/github/henryye/nativeiv/bitmap/NativeBitmapStruct;
    //   14: aload_0
    //   15: ldc2_w 35
    //   18: putfield 38	com/github/henryye/nativeiv/comm/NativeImage:lastDecodeUsing	J
    //   21: aload_0
    //   22: aload_1
    //   23: putfield 40	com/github/henryye/nativeiv/comm/NativeImage:jni	Lcom/github/henryye/nativeiv/comm/NativeImageJni;
    //   26: aload_0
    //   27: aload_2
    //   28: putfield 42	com/github/henryye/nativeiv/comm/NativeImage:factory	Lcom/github/henryye/nativeiv/comm/a;
    //   31: aload_0
    //   32: monitorenter
    //   33: aload_2
    //   34: monitorenter
    //   35: aload_2
    //   36: getfield 48	com/github/henryye/nativeiv/comm/a:auT	Ljava/util/HashMap;
    //   39: aload_0
    //   40: invokevirtual 52	java/lang/Object:hashCode	()I
    //   43: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aload_0
    //   47: invokevirtual 64	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload_2
    //   52: monitorexit
    //   53: aload_0
    //   54: monitorexit
    //   55: ldc 26
    //   57: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: return
    //   61: astore_1
    //   62: aload_2
    //   63: monitorexit
    //   64: ldc 26
    //   66: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: ldc 26
    //   76: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	NativeImage
    //   0	81	1	paramNativeImageJni	NativeImageJni
    //   0	81	2	parama	a
    // Exception table:
    //   from	to	target	type
    //   35	53	61	finally
    //   62	64	61	finally
    //   33	35	71	finally
    //   53	55	71	finally
    //   64	71	71	finally
    //   72	74	71	finally
  }
  
  /* Error */
  public void decodeInputStream(InputStream paramInputStream, Bitmap.Config paramConfig, c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 71
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 42	com/github/henryye/nativeiv/comm/NativeImage:factory	Lcom/github/henryye/nativeiv/comm/a;
    //   11: ifnonnull +11 -> 22
    //   14: ldc 71
    //   16: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 77	android/os/SystemClock:elapsedRealtime	()J
    //   25: lstore 5
    //   27: aload_1
    //   28: ifnonnull +18 -> 46
    //   31: ldc 12
    //   33: ldc 79
    //   35: iconst_0
    //   36: anewarray 5	java/lang/Object
    //   39: invokestatic 85	com/tencent/magicbrush/a/c$c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: invokevirtual 88	com/github/henryye/nativeiv/comm/NativeImage:recycle	()V
    //   46: aload_1
    //   47: invokestatic 94	com/github/henryye/nativeiv/b/a:c	(Ljava/io/InputStream;)Ljava/nio/ByteBuffer;
    //   50: astore_3
    //   51: aload_2
    //   52: ifnull +111 -> 163
    //   55: aload_2
    //   56: getstatic 100	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   59: if_acmpeq +104 -> 163
    //   62: aload_2
    //   63: getstatic 103	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   66: if_acmpeq +97 -> 163
    //   69: aload_2
    //   70: getstatic 106	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   73: if_acmpeq +90 -> 163
    //   76: getstatic 109	android/graphics/Bitmap$Config:ALPHA_8	Landroid/graphics/Bitmap$Config;
    //   79: astore_1
    //   80: aload_2
    //   81: aload_1
    //   82: if_acmpne +76 -> 158
    //   85: iconst_2
    //   86: istore 4
    //   88: aload_3
    //   89: ifnull +117 -> 206
    //   92: aload_0
    //   93: getfield 40	com/github/henryye/nativeiv/comm/NativeImage:jni	Lcom/github/henryye/nativeiv/comm/NativeImageJni;
    //   96: astore_1
    //   97: aload_1
    //   98: getfield 114	com/github/henryye/nativeiv/comm/NativeImageJni:mNativeInst	J
    //   101: lconst_0
    //   102: lcmp
    //   103: ifeq +66 -> 169
    //   106: aload_1
    //   107: aload_1
    //   108: getfield 114	com/github/henryye/nativeiv/comm/NativeImageJni:mNativeInst	J
    //   111: aload_3
    //   112: iload 4
    //   114: invokevirtual 118	com/github/henryye/nativeiv/comm/NativeImageJni:nativeDecodeNative	(JLjava/nio/ByteBuffer;I)Lcom/github/henryye/nativeiv/comm/CommNativeBitmapStruct;
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull +55 -> 174
    //   122: aload_0
    //   123: aload_1
    //   124: invokevirtual 124	com/github/henryye/nativeiv/comm/CommNativeBitmapStruct:convertToCommonStruct	()Lcom/github/henryye/nativeiv/comm/CommNativeBitmapStruct;
    //   127: putfield 34	com/github/henryye/nativeiv/comm/NativeImage:mNativeBitmapStruct	Lcom/github/henryye/nativeiv/bitmap/NativeBitmapStruct;
    //   130: aload_3
    //   131: invokevirtual 130	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   134: pop
    //   135: aload_0
    //   136: invokestatic 77	android/os/SystemClock:elapsedRealtime	()J
    //   139: lload 5
    //   141: lsub
    //   142: putfield 38	com/github/henryye/nativeiv/comm/NativeImage:lastDecodeUsing	J
    //   145: ldc 71
    //   147: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: goto -131 -> 19
    //   153: astore_1
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    //   158: getstatic 136	android/os/Build$VERSION:SDK_INT	I
    //   161: istore 4
    //   163: iconst_4
    //   164: istore 4
    //   166: goto -78 -> 88
    //   169: aconst_null
    //   170: astore_1
    //   171: goto -53 -> 118
    //   174: ldc 12
    //   176: ldc 138
    //   178: iconst_0
    //   179: anewarray 5	java/lang/Object
    //   182: invokestatic 141	com/tencent/magicbrush/a/c$c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: goto -55 -> 130
    //   188: astore_1
    //   189: aload_0
    //   190: invokestatic 77	android/os/SystemClock:elapsedRealtime	()J
    //   193: lload 5
    //   195: lsub
    //   196: putfield 38	com/github/henryye/nativeiv/comm/NativeImage:lastDecodeUsing	J
    //   199: ldc 71
    //   201: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload_1
    //   205: athrow
    //   206: ldc 12
    //   208: ldc 143
    //   210: iconst_0
    //   211: anewarray 5	java/lang/Object
    //   214: invokestatic 85	com/tencent/magicbrush/a/c$c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: aload_0
    //   218: invokevirtual 88	com/github/henryye/nativeiv/comm/NativeImage:recycle	()V
    //   221: new 145	java/io/IOException
    //   224: dup
    //   225: ldc 147
    //   227: invokespecial 150	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   230: astore_1
    //   231: ldc 71
    //   233: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_1
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	NativeImage
    //   0	238	1	paramInputStream	InputStream
    //   0	238	2	paramConfig	Bitmap.Config
    //   0	238	3	paramc	c
    //   86	79	4	i	int
    //   25	169	5	l	long
    // Exception table:
    //   from	to	target	type
    //   2	19	153	finally
    //   22	27	153	finally
    //   31	46	153	finally
    //   46	51	153	finally
    //   55	80	153	finally
    //   135	150	153	finally
    //   158	163	153	finally
    //   189	206	153	finally
    //   92	118	188	finally
    //   122	130	188	finally
    //   130	135	188	finally
    //   174	185	188	finally
    //   206	238	188	finally
  }
  
  public void decodeInputStreamRegion(InputStream paramInputStream, Rect paramRect, Bitmap.Config paramConfig, c paramc)
  {
    AppMethodBeat.i(115763);
    paramInputStream = new IOException("Stub!");
    AppMethodBeat.o(115763);
    throw paramInputStream;
  }
  
  public com.github.henryye.nativeiv.bitmap.a<Integer> dump()
  {
    try
    {
      AppMethodBeat.i(115764);
      com.github.henryye.nativeiv.bitmap.a locala = new com.github.henryye.nativeiv.bitmap.a();
      if (this.mNativeBitmapStruct != null)
      {
        locala.width = this.mNativeBitmapStruct.width;
        locala.height = this.mNativeBitmapStruct.height;
        locala.auG = true;
        locala.auH = Integer.valueOf(this.mNativeBitmapStruct.glFormat);
        locala.auI = this.lastDecodeUsing;
      }
      AppMethodBeat.o(115764);
      return locala;
    }
    finally {}
  }
  
  public void forceSet(NativeBitmapStruct paramNativeBitmapStruct)
  {
    this.mNativeBitmapStruct = paramNativeBitmapStruct;
  }
  
  public long getDecodeTime()
  {
    return this.lastDecodeUsing;
  }
  
  @Keep
  public BitmapType getType()
  {
    return BitmapType.Native;
  }
  
  @Keep
  public NativeBitmapStruct provide()
  {
    return this.mNativeBitmapStruct;
  }
  
  /* Error */
  @Keep
  public void recycle()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 210
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 12
    //   9: ldc 212
    //   11: iconst_1
    //   12: anewarray 5	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: invokevirtual 52	java/lang/Object:hashCode	()I
    //   21: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: invokestatic 215	com/tencent/magicbrush/a/c$c:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 34	com/github/henryye/nativeiv/comm/NativeImage:mNativeBitmapStruct	Lcom/github/henryye/nativeiv/bitmap/NativeBitmapStruct;
    //   32: ifnull +53 -> 85
    //   35: aload_0
    //   36: getfield 34	com/github/henryye/nativeiv/comm/NativeImage:mNativeBitmapStruct	Lcom/github/henryye/nativeiv/bitmap/NativeBitmapStruct;
    //   39: getfield 218	com/github/henryye/nativeiv/bitmap/NativeBitmapStruct:ptr	J
    //   42: ldc2_w 35
    //   45: lcmp
    //   46: ifeq +39 -> 85
    //   49: aload_0
    //   50: getfield 40	com/github/henryye/nativeiv/comm/NativeImage:jni	Lcom/github/henryye/nativeiv/comm/NativeImageJni;
    //   53: astore_3
    //   54: aload_0
    //   55: getfield 34	com/github/henryye/nativeiv/comm/NativeImage:mNativeBitmapStruct	Lcom/github/henryye/nativeiv/bitmap/NativeBitmapStruct;
    //   58: getfield 218	com/github/henryye/nativeiv/bitmap/NativeBitmapStruct:ptr	J
    //   61: lstore_1
    //   62: aload_3
    //   63: getfield 114	com/github/henryye/nativeiv/comm/NativeImageJni:mNativeInst	J
    //   66: lconst_0
    //   67: lcmp
    //   68: ifeq +12 -> 80
    //   71: aload_3
    //   72: aload_3
    //   73: getfield 114	com/github/henryye/nativeiv/comm/NativeImageJni:mNativeInst	J
    //   76: lload_1
    //   77: invokevirtual 222	com/github/henryye/nativeiv/comm/NativeImageJni:nativeRecycleNative	(JJ)V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 34	com/github/henryye/nativeiv/comm/NativeImage:mNativeBitmapStruct	Lcom/github/henryye/nativeiv/bitmap/NativeBitmapStruct;
    //   85: aload_0
    //   86: getfield 42	com/github/henryye/nativeiv/comm/NativeImage:factory	Lcom/github/henryye/nativeiv/comm/a;
    //   89: ifnull +32 -> 121
    //   92: aload_0
    //   93: getfield 42	com/github/henryye/nativeiv/comm/NativeImage:factory	Lcom/github/henryye/nativeiv/comm/a;
    //   96: astore_3
    //   97: aload_3
    //   98: monitorenter
    //   99: aload_3
    //   100: getfield 48	com/github/henryye/nativeiv/comm/a:auT	Ljava/util/HashMap;
    //   103: aload_0
    //   104: invokevirtual 52	java/lang/Object:hashCode	()I
    //   107: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: invokevirtual 226	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: aload_3
    //   115: monitorexit
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield 42	com/github/henryye/nativeiv/comm/NativeImage:factory	Lcom/github/henryye/nativeiv/comm/a;
    //   121: ldc 210
    //   123: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_0
    //   127: monitorexit
    //   128: return
    //   129: astore 4
    //   131: aload_3
    //   132: monitorexit
    //   133: ldc 210
    //   135: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload 4
    //   140: athrow
    //   141: astore_3
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_3
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	NativeImage
    //   61	16	1	l	long
    //   141	4	3	localObject2	Object
    //   129	10	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   99	116	129	finally
    //   131	133	129	finally
    //   2	80	141	finally
    //   80	85	141	finally
    //   85	99	141	finally
    //   116	121	141	finally
    //   121	126	141	finally
    //   133	141	141	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.NativeImage
 * JD-Core Version:    0.7.0.1
 */