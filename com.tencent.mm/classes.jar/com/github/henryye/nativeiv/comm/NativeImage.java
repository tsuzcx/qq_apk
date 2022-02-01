package com.github.henryye.nativeiv.comm;

import android.graphics.Rect;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

@Keep
class NativeImage
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
    //   36: getfield 48	com/github/henryye/nativeiv/comm/a:aQZ	Ljava/util/HashMap;
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
  public void decodeInputStream(InputStream paramInputStream, ImageDecodeConfig paramImageDecodeConfig, c paramc)
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
    //   39: invokestatic 85	com/github/henryye/nativeiv/a/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: invokevirtual 88	com/github/henryye/nativeiv/comm/NativeImage:recycle	()V
    //   46: aload_1
    //   47: invokestatic 94	com/github/henryye/nativeiv/c/a:f	(Ljava/io/InputStream;)Ljava/nio/ByteBuffer;
    //   50: astore_3
    //   51: aload_2
    //   52: getfield 100	com/github/henryye/nativeiv/ImageDecodeConfig:mConfig	Landroid/graphics/Bitmap$Config;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +121 -> 178
    //   60: aload_1
    //   61: getstatic 105	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   64: if_acmpeq +114 -> 178
    //   67: aload_1
    //   68: getstatic 108	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   71: if_acmpeq +107 -> 178
    //   74: aload_1
    //   75: getstatic 111	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   78: if_acmpeq +100 -> 178
    //   81: getstatic 114	android/graphics/Bitmap$Config:ALPHA_8	Landroid/graphics/Bitmap$Config;
    //   84: astore 8
    //   86: aload_1
    //   87: aload 8
    //   89: if_acmpne +84 -> 173
    //   92: iconst_2
    //   93: istore 4
    //   95: aload_3
    //   96: ifnull +125 -> 221
    //   99: aload_0
    //   100: getfield 40	com/github/henryye/nativeiv/comm/NativeImage:jni	Lcom/github/henryye/nativeiv/comm/NativeImageJni;
    //   103: astore_1
    //   104: aload_2
    //   105: getfield 118	com/github/henryye/nativeiv/ImageDecodeConfig:mPremultiplyAlpha	Z
    //   108: istore 7
    //   110: aload_1
    //   111: getfield 123	com/github/henryye/nativeiv/comm/NativeImageJni:mNativeInst	J
    //   114: lconst_0
    //   115: lcmp
    //   116: ifeq +68 -> 184
    //   119: aload_1
    //   120: aload_1
    //   121: getfield 123	com/github/henryye/nativeiv/comm/NativeImageJni:mNativeInst	J
    //   124: aload_3
    //   125: iload 4
    //   127: iload 7
    //   129: invokevirtual 127	com/github/henryye/nativeiv/comm/NativeImageJni:nativeDecodeNative	(JLjava/nio/ByteBuffer;IZ)Lcom/github/henryye/nativeiv/comm/CommNativeBitmapStruct;
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull +55 -> 189
    //   137: aload_0
    //   138: aload_1
    //   139: invokevirtual 133	com/github/henryye/nativeiv/comm/CommNativeBitmapStruct:convertToCommonStruct	()Lcom/github/henryye/nativeiv/comm/CommNativeBitmapStruct;
    //   142: putfield 34	com/github/henryye/nativeiv/comm/NativeImage:mNativeBitmapStruct	Lcom/github/henryye/nativeiv/bitmap/NativeBitmapStruct;
    //   145: aload_3
    //   146: invokevirtual 139	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   149: pop
    //   150: aload_0
    //   151: invokestatic 77	android/os/SystemClock:elapsedRealtime	()J
    //   154: lload 5
    //   156: lsub
    //   157: putfield 38	com/github/henryye/nativeiv/comm/NativeImage:lastDecodeUsing	J
    //   160: ldc 71
    //   162: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: goto -146 -> 19
    //   168: astore_1
    //   169: aload_0
    //   170: monitorexit
    //   171: aload_1
    //   172: athrow
    //   173: getstatic 145	android/os/Build$VERSION:SDK_INT	I
    //   176: istore 4
    //   178: iconst_4
    //   179: istore 4
    //   181: goto -86 -> 95
    //   184: aconst_null
    //   185: astore_1
    //   186: goto -53 -> 133
    //   189: ldc 12
    //   191: ldc 147
    //   193: iconst_0
    //   194: anewarray 5	java/lang/Object
    //   197: invokestatic 150	com/github/henryye/nativeiv/a/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: goto -55 -> 145
    //   203: astore_1
    //   204: aload_0
    //   205: invokestatic 77	android/os/SystemClock:elapsedRealtime	()J
    //   208: lload 5
    //   210: lsub
    //   211: putfield 38	com/github/henryye/nativeiv/comm/NativeImage:lastDecodeUsing	J
    //   214: ldc 71
    //   216: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_1
    //   220: athrow
    //   221: ldc 12
    //   223: ldc 152
    //   225: iconst_0
    //   226: anewarray 5	java/lang/Object
    //   229: invokestatic 85	com/github/henryye/nativeiv/a/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_0
    //   233: invokevirtual 88	com/github/henryye/nativeiv/comm/NativeImage:recycle	()V
    //   236: new 154	java/io/IOException
    //   239: dup
    //   240: ldc 156
    //   242: invokespecial 159	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   245: astore_1
    //   246: ldc 71
    //   248: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aload_1
    //   252: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	NativeImage
    //   0	253	1	paramInputStream	InputStream
    //   0	253	2	paramImageDecodeConfig	ImageDecodeConfig
    //   0	253	3	paramc	c
    //   93	87	4	i	int
    //   25	184	5	l	long
    //   108	20	7	bool	boolean
    //   84	4	8	localConfig	android.graphics.Bitmap.Config
    // Exception table:
    //   from	to	target	type
    //   2	19	168	finally
    //   22	27	168	finally
    //   31	46	168	finally
    //   46	56	168	finally
    //   60	86	168	finally
    //   150	165	168	finally
    //   173	178	168	finally
    //   204	221	168	finally
    //   99	133	203	finally
    //   137	145	203	finally
    //   145	150	203	finally
    //   189	200	203	finally
    //   221	253	203	finally
  }
  
  public void decodeInputStreamRegion(InputStream paramInputStream, Rect paramRect, ImageDecodeConfig paramImageDecodeConfig, c paramc)
  {
    AppMethodBeat.i(127368);
    paramInputStream = new IOException("Stub!");
    AppMethodBeat.o(127368);
    throw paramInputStream;
  }
  
  public com.github.henryye.nativeiv.bitmap.a<Integer> dump()
  {
    try
    {
      AppMethodBeat.i(127369);
      com.github.henryye.nativeiv.bitmap.a locala = new com.github.henryye.nativeiv.bitmap.a();
      if (this.mNativeBitmapStruct != null)
      {
        locala.width = this.mNativeBitmapStruct.width;
        locala.height = this.mNativeBitmapStruct.height;
        locala.aQM = true;
        locala.aQN = Integer.valueOf(this.mNativeBitmapStruct.glFormat);
        locala.aQO = this.lastDecodeUsing;
      }
      AppMethodBeat.o(127369);
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
    //   2: ldc 218
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 34	com/github/henryye/nativeiv/comm/NativeImage:mNativeBitmapStruct	Lcom/github/henryye/nativeiv/bitmap/NativeBitmapStruct;
    //   11: ifnull +53 -> 64
    //   14: aload_0
    //   15: getfield 34	com/github/henryye/nativeiv/comm/NativeImage:mNativeBitmapStruct	Lcom/github/henryye/nativeiv/bitmap/NativeBitmapStruct;
    //   18: getfield 221	com/github/henryye/nativeiv/bitmap/NativeBitmapStruct:ptr	J
    //   21: ldc2_w 35
    //   24: lcmp
    //   25: ifeq +39 -> 64
    //   28: aload_0
    //   29: getfield 40	com/github/henryye/nativeiv/comm/NativeImage:jni	Lcom/github/henryye/nativeiv/comm/NativeImageJni;
    //   32: astore_3
    //   33: aload_0
    //   34: getfield 34	com/github/henryye/nativeiv/comm/NativeImage:mNativeBitmapStruct	Lcom/github/henryye/nativeiv/bitmap/NativeBitmapStruct;
    //   37: getfield 221	com/github/henryye/nativeiv/bitmap/NativeBitmapStruct:ptr	J
    //   40: lstore_1
    //   41: aload_3
    //   42: getfield 123	com/github/henryye/nativeiv/comm/NativeImageJni:mNativeInst	J
    //   45: lconst_0
    //   46: lcmp
    //   47: ifeq +12 -> 59
    //   50: aload_3
    //   51: aload_3
    //   52: getfield 123	com/github/henryye/nativeiv/comm/NativeImageJni:mNativeInst	J
    //   55: lload_1
    //   56: invokevirtual 225	com/github/henryye/nativeiv/comm/NativeImageJni:nativeRecycleNative	(JJ)V
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 34	com/github/henryye/nativeiv/comm/NativeImage:mNativeBitmapStruct	Lcom/github/henryye/nativeiv/bitmap/NativeBitmapStruct;
    //   64: aload_0
    //   65: getfield 42	com/github/henryye/nativeiv/comm/NativeImage:factory	Lcom/github/henryye/nativeiv/comm/a;
    //   68: ifnull +32 -> 100
    //   71: aload_0
    //   72: getfield 42	com/github/henryye/nativeiv/comm/NativeImage:factory	Lcom/github/henryye/nativeiv/comm/a;
    //   75: astore_3
    //   76: aload_3
    //   77: monitorenter
    //   78: aload_3
    //   79: getfield 48	com/github/henryye/nativeiv/comm/a:aQZ	Ljava/util/HashMap;
    //   82: aload_0
    //   83: invokevirtual 52	java/lang/Object:hashCode	()I
    //   86: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: invokevirtual 229	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: pop
    //   93: aload_3
    //   94: monitorexit
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield 42	com/github/henryye/nativeiv/comm/NativeImage:factory	Lcom/github/henryye/nativeiv/comm/a;
    //   100: ldc 218
    //   102: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: astore 4
    //   110: aload_3
    //   111: monitorexit
    //   112: ldc 218
    //   114: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload 4
    //   119: athrow
    //   120: astore_3
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_3
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	NativeImage
    //   40	16	1	l	long
    //   120	4	3	localObject2	Object
    //   108	10	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   78	95	108	finally
    //   110	112	108	finally
    //   2	59	120	finally
    //   59	64	120	finally
    //   64	78	120	finally
    //   95	100	120	finally
    //   100	105	120	finally
    //   112	120	120	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.NativeImage
 * JD-Core Version:    0.7.0.1
 */