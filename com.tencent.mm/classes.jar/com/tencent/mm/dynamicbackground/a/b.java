package com.tencent.mm.dynamicbackground.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/util/DynamicBgAssetsManager;", "", "()V", "TAG", "", "checkDirectory", "", "context", "Landroid/content/Context;", "copyFileFromAssets", "srcFileName", "dstFileName", "getSavedFileDirectory", "init", "dynamicbg_release"}, k=1, mv={1, 1, 11})
public final class b
{
  private static final String TAG = "DynamicBgAssetsManager";
  public static final b mbC;
  
  static
  {
    AppMethodBeat.i(103093);
    mbC = new b();
    TAG = "DynamicBgAssetsManager";
    AppMethodBeat.o(103093);
  }
  
  public static String dq(Context paramContext)
  {
    AppMethodBeat.i(103092);
    s.t(paramContext, "context");
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = paramContext.getFilesDir();
    s.r(paramContext, "context.filesDir");
    paramContext = paramContext.getParent() + File.separator + "appbrand/glsl/";
    AppMethodBeat.o(103092);
    return paramContext;
  }
  
  /* Error */
  public static void n(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 100
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 57
    //   8: invokestatic 63	kotlin/g/b/s:t	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 101
    //   14: invokestatic 63	kotlin/g/b/s:t	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ldc 102
    //   20: invokestatic 63	kotlin/g/b/s:t	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: getstatic 48	com/tencent/mm/dynamicbackground/a/b:TAG	Ljava/lang/String;
    //   26: ldc 104
    //   28: iconst_2
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: aload_1
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: aload_2
    //   39: aastore
    //   40: invokestatic 109	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: new 79	java/io/File
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore 4
    //   53: aload 4
    //   55: invokevirtual 116	java/io/File:exists	()Z
    //   58: ifne +9 -> 67
    //   61: aload 4
    //   63: invokevirtual 119	java/io/File:createNewFile	()Z
    //   66: pop
    //   67: aload_0
    //   68: invokevirtual 123	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   71: aload_1
    //   72: invokevirtual 129	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   75: astore_2
    //   76: new 131	java/io/FileOutputStream
    //   79: dup
    //   80: aload 4
    //   82: invokespecial 134	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: checkcast 136	java/io/OutputStream
    //   88: astore_0
    //   89: sipush 1024
    //   92: newarray byte
    //   94: astore 5
    //   96: aload_2
    //   97: ifnonnull +6 -> 103
    //   100: invokestatic 139	kotlin/g/b/s:klw	()V
    //   103: aload_2
    //   104: aload 5
    //   106: invokevirtual 145	java/io/InputStream:read	([B)I
    //   109: istore_3
    //   110: iload_3
    //   111: iconst_m1
    //   112: if_icmpeq +53 -> 165
    //   115: aload_0
    //   116: aload 5
    //   118: iconst_0
    //   119: iload_3
    //   120: invokevirtual 149	java/io/OutputStream:write	([BII)V
    //   123: goto -27 -> 96
    //   126: astore_1
    //   127: getstatic 48	com/tencent/mm/dynamicbackground/a/b:TAG	Ljava/lang/String;
    //   130: aload_1
    //   131: checkcast 151	java/lang/Throwable
    //   134: ldc 153
    //   136: iconst_0
    //   137: anewarray 4	java/lang/Object
    //   140: invokestatic 157	com/tencent/mm/dynamicbackground/a/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_2
    //   144: ifnull +7 -> 151
    //   147: aload_2
    //   148: invokevirtual 160	java/io/InputStream:close	()V
    //   151: aload_0
    //   152: ifnull +65 -> 217
    //   155: aload_0
    //   156: invokevirtual 161	java/io/OutputStream:close	()V
    //   159: ldc 100
    //   161: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: return
    //   165: aload_0
    //   166: invokevirtual 164	java/io/OutputStream:flush	()V
    //   169: getstatic 48	com/tencent/mm/dynamicbackground/a/b:TAG	Ljava/lang/String;
    //   172: ldc 166
    //   174: iconst_2
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_1
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload 4
    //   186: invokevirtual 170	java/io/File:length	()J
    //   189: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   192: aastore
    //   193: invokestatic 109	com/tencent/mm/dynamicbackground/a/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload_2
    //   197: invokevirtual 160	java/io/InputStream:close	()V
    //   200: aload_0
    //   201: invokevirtual 161	java/io/OutputStream:close	()V
    //   204: ldc 100
    //   206: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: return
    //   210: astore_0
    //   211: ldc 100
    //   213: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: return
    //   217: ldc 100
    //   219: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: return
    //   223: astore_0
    //   224: ldc 100
    //   226: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: return
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_0
    //   233: aconst_null
    //   234: astore_2
    //   235: aload_2
    //   236: ifnull +7 -> 243
    //   239: aload_2
    //   240: invokevirtual 160	java/io/InputStream:close	()V
    //   243: aload_0
    //   244: ifnull +7 -> 251
    //   247: aload_0
    //   248: invokevirtual 161	java/io/OutputStream:close	()V
    //   251: ldc 100
    //   253: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload_1
    //   257: athrow
    //   258: astore_0
    //   259: goto -8 -> 251
    //   262: astore_1
    //   263: aconst_null
    //   264: astore_0
    //   265: goto -30 -> 235
    //   268: astore_1
    //   269: goto -34 -> 235
    //   272: astore_1
    //   273: goto -38 -> 235
    //   276: astore_1
    //   277: aconst_null
    //   278: astore_0
    //   279: aconst_null
    //   280: astore_2
    //   281: goto -154 -> 127
    //   284: astore_1
    //   285: aconst_null
    //   286: astore_0
    //   287: goto -160 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	paramContext	Context
    //   0	290	1	paramString1	String
    //   0	290	2	paramString2	String
    //   109	11	3	i	int
    //   51	134	4	localFile	File
    //   94	23	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   89	96	126	java/lang/Exception
    //   100	103	126	java/lang/Exception
    //   103	110	126	java/lang/Exception
    //   115	123	126	java/lang/Exception
    //   165	196	126	java/lang/Exception
    //   196	204	210	java/lang/Exception
    //   147	151	223	java/lang/Exception
    //   155	164	223	java/lang/Exception
    //   43	67	230	finally
    //   67	76	230	finally
    //   239	243	258	java/lang/Exception
    //   247	251	258	java/lang/Exception
    //   76	89	262	finally
    //   89	96	268	finally
    //   100	103	268	finally
    //   103	110	268	finally
    //   115	123	268	finally
    //   165	196	268	finally
    //   127	143	272	finally
    //   43	67	276	java/lang/Exception
    //   67	76	276	java/lang/Exception
    //   76	89	284	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.a.b
 * JD-Core Version:    0.7.0.1
 */