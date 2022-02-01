package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;

public final class a
{
  private final d.a bTD;
  private final byte[] bTE;
  private final File bTF;
  private final String bTG;
  private final String bTH;
  private final File bTI;
  private boolean bTJ;
  private Map<String, b> bTK;
  private byte[] bTL;
  private final AssetManager mAssetManager;
  private final Executor mExecutor;
  
  public a(AssetManager paramAssetManager, Executor paramExecutor, d.a parama, String paramString1, String paramString2, File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(194226);
    this.bTJ = false;
    this.mAssetManager = paramAssetManager;
    this.mExecutor = paramExecutor;
    this.bTD = parama;
    this.bTG = paramString1;
    this.bTH = paramString2;
    this.bTF = paramFile1;
    this.bTI = paramFile2;
    if (Build.VERSION.SDK_INT >= 24) {}
    switch (Build.VERSION.SDK_INT)
    {
    default: 
      paramAssetManager = null;
    }
    for (;;)
    {
      this.bTE = paramAssetManager;
      AppMethodBeat.o(194226);
      return;
      paramAssetManager = f.bUc;
      continue;
      paramAssetManager = f.bUb;
      continue;
      paramAssetManager = f.bUa;
    }
  }
  
  private void IJ()
  {
    AppMethodBeat.i(194234);
    if (!this.bTJ)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
      AppMethodBeat.o(194234);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(194234);
  }
  
  private void p(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(194219);
    this.mExecutor.execute(new a..ExternalSyntheticLambda0(this, paramInt, paramObject));
    AppMethodBeat.o(194219);
  }
  
  public final boolean II()
  {
    AppMethodBeat.i(194254);
    if (this.bTE == null)
    {
      p(3, Integer.valueOf(Build.VERSION.SDK_INT));
      AppMethodBeat.o(194254);
      return false;
    }
    if (!this.bTF.canWrite())
    {
      p(4, null);
      AppMethodBeat.o(194254);
      return false;
    }
    this.bTJ = true;
    AppMethodBeat.o(194254);
    return true;
  }
  
  /* Error */
  public final a IK()
  {
    // Byte code:
    //   0: ldc 138
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokespecial 140	androidx/profileinstaller/a:IJ	()V
    //   9: aload_0
    //   10: getfield 77	androidx/profileinstaller/a:bTE	[B
    //   13: ifnonnull +10 -> 23
    //   16: ldc 138
    //   18: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: areturn
    //   23: aload_0
    //   24: getfield 57	androidx/profileinstaller/a:mAssetManager	Landroid/content/res/AssetManager;
    //   27: aload_0
    //   28: getfield 65	androidx/profileinstaller/a:bTH	Ljava/lang/String;
    //   31: invokevirtual 146	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 152	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   39: astore_3
    //   40: aload_0
    //   41: aload_3
    //   42: aload_3
    //   43: invokestatic 158	androidx/profileinstaller/e:l	(Ljava/io/InputStream;)[B
    //   46: aload_0
    //   47: getfield 63	androidx/profileinstaller/a:bTG	Ljava/lang/String;
    //   50: invokestatic 161	androidx/profileinstaller/e:a	(Ljava/io/InputStream;[BLjava/lang/String;)Ljava/util/Map;
    //   53: putfield 163	androidx/profileinstaller/a:bTK	Ljava/util/Map;
    //   56: aload_3
    //   57: ifnull +7 -> 64
    //   60: aload_3
    //   61: invokevirtual 168	java/io/InputStream:close	()V
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 169	android/content/res/AssetFileDescriptor:close	()V
    //   72: ldc 138
    //   74: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_0
    //   78: areturn
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 168	java/io/InputStream:close	()V
    //   88: ldc 138
    //   90: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_2
    //   94: athrow
    //   95: astore_2
    //   96: aload_1
    //   97: ifnull +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 169	android/content/res/AssetFileDescriptor:close	()V
    //   104: ldc 138
    //   106: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_2
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: getfield 61	androidx/profileinstaller/a:bTD	Landroidx/profileinstaller/d$a;
    //   116: bipush 6
    //   118: aload_1
    //   119: invokeinterface 115 3 0
    //   124: ldc 138
    //   126: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_0
    //   130: areturn
    //   131: astore_3
    //   132: aload_2
    //   133: aload_3
    //   134: invokevirtual 175	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   137: goto -49 -> 88
    //   140: astore_1
    //   141: aload_2
    //   142: aload_1
    //   143: invokevirtual 175	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   146: goto -42 -> 104
    //   149: astore_1
    //   150: aload_0
    //   151: getfield 61	androidx/profileinstaller/a:bTD	Landroidx/profileinstaller/d$a;
    //   154: bipush 7
    //   156: aload_1
    //   157: invokeinterface 115 3 0
    //   162: goto -38 -> 124
    //   165: astore_1
    //   166: aload_0
    //   167: getfield 61	androidx/profileinstaller/a:bTD	Landroidx/profileinstaller/d$a;
    //   170: bipush 8
    //   172: aload_1
    //   173: invokeinterface 115 3 0
    //   178: goto -54 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	a
    //   34	67	1	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   111	8	1	localFileNotFoundException	java.io.FileNotFoundException
    //   140	3	1	localThrowable1	java.lang.Throwable
    //   149	8	1	localIOException	java.io.IOException
    //   165	8	1	localIllegalStateException	IllegalStateException
    //   79	15	2	localObject1	Object
    //   95	47	2	localObject2	Object
    //   39	46	3	localFileInputStream	java.io.FileInputStream
    //   131	3	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   40	56	79	finally
    //   35	40	95	finally
    //   60	64	95	finally
    //   88	95	95	finally
    //   132	137	95	finally
    //   23	35	111	java/io/FileNotFoundException
    //   68	72	111	java/io/FileNotFoundException
    //   104	111	111	java/io/FileNotFoundException
    //   141	146	111	java/io/FileNotFoundException
    //   84	88	131	finally
    //   100	104	140	finally
    //   23	35	149	java/io/IOException
    //   68	72	149	java/io/IOException
    //   104	111	149	java/io/IOException
    //   141	146	149	java/io/IOException
    //   23	35	165	java/lang/IllegalStateException
    //   68	72	165	java/lang/IllegalStateException
    //   104	111	165	java/lang/IllegalStateException
    //   141	146	165	java/lang/IllegalStateException
  }
  
  /* Error */
  public final a IL()
  {
    // Byte code:
    //   0: ldc 177
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 163	androidx/profileinstaller/a:bTK	Ljava/util/Map;
    //   9: astore_2
    //   10: aload_0
    //   11: getfield 77	androidx/profileinstaller/a:bTE	[B
    //   14: astore_3
    //   15: aload_2
    //   16: ifnull +7 -> 23
    //   19: aload_3
    //   20: ifnonnull +10 -> 30
    //   23: ldc 177
    //   25: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: invokespecial 140	androidx/profileinstaller/a:IJ	()V
    //   34: new 179	java/io/ByteArrayOutputStream
    //   37: dup
    //   38: invokespecial 180	java/io/ByteArrayOutputStream:<init>	()V
    //   41: astore_1
    //   42: aload_1
    //   43: aload_3
    //   44: invokestatic 183	androidx/profileinstaller/e:b	(Ljava/io/OutputStream;[B)V
    //   47: aload_1
    //   48: aload_3
    //   49: aload_2
    //   50: invokestatic 186	androidx/profileinstaller/e:a	(Ljava/io/OutputStream;[BLjava/util/Map;)Z
    //   53: ifne +30 -> 83
    //   56: aload_0
    //   57: getfield 61	androidx/profileinstaller/a:bTD	Landroidx/profileinstaller/d$a;
    //   60: iconst_5
    //   61: aconst_null
    //   62: invokeinterface 115 3 0
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 163	androidx/profileinstaller/a:bTK	Ljava/util/Map;
    //   72: aload_1
    //   73: invokevirtual 187	java/io/ByteArrayOutputStream:close	()V
    //   76: ldc 177
    //   78: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: areturn
    //   83: aload_0
    //   84: aload_1
    //   85: invokevirtual 191	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   88: putfield 193	androidx/profileinstaller/a:bTL	[B
    //   91: aload_1
    //   92: invokevirtual 187	java/io/ByteArrayOutputStream:close	()V
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield 163	androidx/profileinstaller/a:bTK	Ljava/util/Map;
    //   100: ldc 177
    //   102: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: areturn
    //   107: astore_2
    //   108: aload_1
    //   109: invokevirtual 187	java/io/ByteArrayOutputStream:close	()V
    //   112: ldc 177
    //   114: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_2
    //   118: athrow
    //   119: astore_1
    //   120: aload_0
    //   121: getfield 61	androidx/profileinstaller/a:bTD	Landroidx/profileinstaller/d$a;
    //   124: bipush 7
    //   126: aload_1
    //   127: invokeinterface 115 3 0
    //   132: goto -37 -> 95
    //   135: astore_1
    //   136: aload_2
    //   137: aload_1
    //   138: invokevirtual 175	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   141: goto -29 -> 112
    //   144: astore_1
    //   145: aload_0
    //   146: getfield 61	androidx/profileinstaller/a:bTD	Landroidx/profileinstaller/d$a;
    //   149: bipush 8
    //   151: aload_1
    //   152: invokeinterface 115 3 0
    //   157: goto -62 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	a
    //   41	68	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   119	8	1	localIOException	java.io.IOException
    //   135	3	1	localThrowable	java.lang.Throwable
    //   144	8	1	localIllegalStateException	IllegalStateException
    //   9	41	2	localMap	Map
    //   107	30	2	localObject	Object
    //   14	35	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   42	72	107	finally
    //   83	91	107	finally
    //   34	42	119	java/io/IOException
    //   72	76	119	java/io/IOException
    //   91	95	119	java/io/IOException
    //   112	119	119	java/io/IOException
    //   136	141	119	java/io/IOException
    //   108	112	135	finally
    //   34	42	144	java/lang/IllegalStateException
    //   72	76	144	java/lang/IllegalStateException
    //   91	95	144	java/lang/IllegalStateException
    //   112	119	144	java/lang/IllegalStateException
    //   136	141	144	java/lang/IllegalStateException
  }
  
  /* Error */
  public final void a(b paramb)
  {
    // Byte code:
    //   0: ldc 195
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 193	androidx/profileinstaller/a:bTL	[B
    //   9: astore_2
    //   10: aload_2
    //   11: ifnonnull +9 -> 20
    //   14: ldc 195
    //   16: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: invokespecial 140	androidx/profileinstaller/a:IJ	()V
    //   24: aload_1
    //   25: aload_2
    //   26: arraylength
    //   27: i2l
    //   28: new 6	androidx/profileinstaller/a$a
    //   31: dup
    //   32: aload_0
    //   33: getfield 67	androidx/profileinstaller/a:bTF	Ljava/io/File;
    //   36: invokevirtual 199	java/io/File:length	()J
    //   39: aload_0
    //   40: getfield 69	androidx/profileinstaller/a:bTI	Ljava/io/File;
    //   43: invokevirtual 199	java/io/File:length	()J
    //   46: aload_0
    //   47: getfield 67	androidx/profileinstaller/a:bTF	Ljava/io/File;
    //   50: invokevirtual 202	java/io/File:exists	()Z
    //   53: aload_0
    //   54: getfield 69	androidx/profileinstaller/a:bTI	Ljava/io/File;
    //   57: invokevirtual 202	java/io/File:exists	()Z
    //   60: invokespecial 205	androidx/profileinstaller/a$a:<init>	(JJZZ)V
    //   63: invokeinterface 209 4 0
    //   68: ifne +167 -> 235
    //   71: new 211	java/io/ByteArrayInputStream
    //   74: dup
    //   75: aload_2
    //   76: invokespecial 214	java/io/ByteArrayInputStream:<init>	([B)V
    //   79: astore_1
    //   80: new 216	java/io/FileOutputStream
    //   83: dup
    //   84: aload_0
    //   85: getfield 67	androidx/profileinstaller/a:bTF	Ljava/io/File;
    //   88: invokespecial 219	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   91: astore_3
    //   92: aload_1
    //   93: aload_3
    //   94: invokestatic 225	androidx/profileinstaller/c:d	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   97: aload_0
    //   98: iconst_1
    //   99: aconst_null
    //   100: invokespecial 126	androidx/profileinstaller/a:p	(ILjava/lang/Object;)V
    //   103: aload_3
    //   104: invokevirtual 228	java/io/OutputStream:close	()V
    //   107: aload_1
    //   108: invokevirtual 168	java/io/InputStream:close	()V
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 193	androidx/profileinstaller/a:bTL	[B
    //   116: aload_0
    //   117: aconst_null
    //   118: putfield 163	androidx/profileinstaller/a:bTK	Ljava/util/Map;
    //   121: ldc 195
    //   123: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: return
    //   127: astore_2
    //   128: aload_3
    //   129: invokevirtual 228	java/io/OutputStream:close	()V
    //   132: ldc 195
    //   134: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_2
    //   138: athrow
    //   139: astore_2
    //   140: aload_1
    //   141: invokevirtual 168	java/io/InputStream:close	()V
    //   144: ldc 195
    //   146: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_2
    //   150: athrow
    //   151: astore_1
    //   152: aload_0
    //   153: bipush 6
    //   155: aload_1
    //   156: invokespecial 126	androidx/profileinstaller/a:p	(ILjava/lang/Object;)V
    //   159: aload_0
    //   160: aconst_null
    //   161: putfield 193	androidx/profileinstaller/a:bTL	[B
    //   164: aload_0
    //   165: aconst_null
    //   166: putfield 163	androidx/profileinstaller/a:bTK	Ljava/util/Map;
    //   169: ldc 195
    //   171: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: return
    //   175: astore_3
    //   176: aload_2
    //   177: aload_3
    //   178: invokevirtual 175	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   181: goto -49 -> 132
    //   184: astore_1
    //   185: aload_2
    //   186: aload_1
    //   187: invokevirtual 175	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   190: goto -46 -> 144
    //   193: astore_1
    //   194: aload_0
    //   195: bipush 7
    //   197: aload_1
    //   198: invokespecial 126	androidx/profileinstaller/a:p	(ILjava/lang/Object;)V
    //   201: aload_0
    //   202: aconst_null
    //   203: putfield 193	androidx/profileinstaller/a:bTL	[B
    //   206: aload_0
    //   207: aconst_null
    //   208: putfield 163	androidx/profileinstaller/a:bTK	Ljava/util/Map;
    //   211: ldc 195
    //   213: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: return
    //   217: astore_1
    //   218: aload_0
    //   219: aconst_null
    //   220: putfield 193	androidx/profileinstaller/a:bTL	[B
    //   223: aload_0
    //   224: aconst_null
    //   225: putfield 163	androidx/profileinstaller/a:bTK	Ljava/util/Map;
    //   228: ldc 195
    //   230: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aload_1
    //   234: athrow
    //   235: ldc 195
    //   237: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	a
    //   0	241	1	paramb	b
    //   9	67	2	arrayOfByte	byte[]
    //   127	11	2	localObject1	Object
    //   139	47	2	localObject2	Object
    //   91	38	3	localFileOutputStream	java.io.FileOutputStream
    //   175	3	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   92	103	127	finally
    //   80	92	139	finally
    //   103	107	139	finally
    //   132	139	139	finally
    //   176	181	139	finally
    //   71	80	151	java/io/FileNotFoundException
    //   107	111	151	java/io/FileNotFoundException
    //   144	151	151	java/io/FileNotFoundException
    //   185	190	151	java/io/FileNotFoundException
    //   128	132	175	finally
    //   140	144	184	finally
    //   71	80	193	java/io/IOException
    //   107	111	193	java/io/IOException
    //   144	151	193	java/io/IOException
    //   185	190	193	java/io/IOException
    //   71	80	217	finally
    //   107	111	217	finally
    //   144	151	217	finally
    //   152	159	217	finally
    //   185	190	217	finally
    //   194	201	217	finally
  }
  
  public static final class a
  {
    final long bTM;
    final long bTN;
    final boolean bTO;
    final boolean bTP;
    
    a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.bTM = paramLong1;
      this.bTN = paramLong2;
      this.bTO = paramBoolean1;
      this.bTP = paramBoolean2;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean shouldSkip(long paramLong, a.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.profileinstaller.a
 * JD-Core Version:    0.7.0.1
 */