package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;

public final class g
{
  private static Boolean isMIUI = null;
  private static Boolean isMIUIV8 = null;
  private static Boolean jvC = null;
  
  @TargetApi(8)
  public static File KU(String paramString)
  {
    AppMethodBeat.i(155885);
    if (Util.isNullOrNil(af.juS.jrO))
    {
      paramString = Environment.getExternalStoragePublicDirectory(paramString);
      AppMethodBeat.o(155885);
      return paramString;
    }
    paramString = new File(af.juS.jrO);
    AppMethodBeat.o(155885);
    return paramString;
  }
  
  public static File avF()
  {
    AppMethodBeat.i(155884);
    if (Util.isNullOrNil(af.juS.jrN))
    {
      localFile = Environment.getExternalStorageDirectory();
      AppMethodBeat.o(155884);
      return localFile;
    }
    File localFile = new File(af.juS.jrN);
    AppMethodBeat.o(155884);
    return localFile;
  }
  
  public static File avG()
  {
    AppMethodBeat.i(155886);
    if (Util.isNullOrNil(af.juS.jrP))
    {
      localFile = Environment.getDataDirectory();
      AppMethodBeat.o(155886);
      return localFile;
    }
    File localFile = new File(af.juS.jrP);
    AppMethodBeat.o(155886);
    return localFile;
  }
  
  public static File avH()
  {
    AppMethodBeat.i(155887);
    if (Util.isNullOrNil(af.juS.jrQ))
    {
      localFile = Environment.getRootDirectory();
      AppMethodBeat.o(155887);
      return localFile;
    }
    File localFile = new File(af.juS.jrQ);
    AppMethodBeat.o(155887);
    return localFile;
  }
  
  public static File avI()
  {
    AppMethodBeat.i(155888);
    if (Util.isNullOrNil(af.juS.jrS))
    {
      localFile = Environment.getDownloadCacheDirectory();
      AppMethodBeat.o(155888);
      return localFile;
    }
    File localFile = new File(af.juS.jrS);
    AppMethodBeat.o(155888);
    return localFile;
  }
  
  public static String avJ()
  {
    AppMethodBeat.i(155889);
    if (Util.isNullOrNil(af.juS.jrR))
    {
      str = Environment.getExternalStorageState();
      AppMethodBeat.o(155889);
      return str;
    }
    String str = af.juS.jrR;
    AppMethodBeat.o(155889);
    return str;
  }
  
  public static int avK()
  {
    return 4;
  }
  
  /* Error */
  @java.lang.Deprecated
  public static boolean isMIUI()
  {
    // Byte code:
    //   0: ldc 111
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 12	com/tencent/mm/compatible/util/g:isMIUI	Ljava/lang/Boolean;
    //   8: ifnonnull +58 -> 66
    //   11: new 113	java/io/FileInputStream
    //   14: dup
    //   15: new 57	java/io/File
    //   18: dup
    //   19: invokestatic 87	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   22: ldc 115
    //   24: invokespecial 118	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokespecial 121	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: new 123	java/util/Properties
    //   36: dup
    //   37: invokespecial 125	java/util/Properties:<init>	()V
    //   40: astore_3
    //   41: aload_2
    //   42: astore_1
    //   43: aload_3
    //   44: aload_2
    //   45: invokevirtual 129	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: ldc 131
    //   53: invokevirtual 135	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   56: invokestatic 141	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: putstatic 12	com/tencent/mm/compatible/util/g:isMIUI	Ljava/lang/Boolean;
    //   62: aload_2
    //   63: invokevirtual 144	java/io/FileInputStream:close	()V
    //   66: getstatic 12	com/tencent/mm/compatible/util/g:isMIUI	Ljava/lang/Boolean;
    //   69: invokevirtual 147	java/lang/Boolean:booleanValue	()Z
    //   72: istore_0
    //   73: ldc 111
    //   75: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iload_0
    //   79: ireturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_1
    //   85: ldc 149
    //   87: aload_3
    //   88: ldc 151
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_2
    //   98: astore_1
    //   99: getstatic 160	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   102: putstatic 12	com/tencent/mm/compatible/util/g:isMIUI	Ljava/lang/Boolean;
    //   105: aload_2
    //   106: ifnull -40 -> 66
    //   109: aload_2
    //   110: invokevirtual 144	java/io/FileInputStream:close	()V
    //   113: goto -47 -> 66
    //   116: astore_1
    //   117: goto -51 -> 66
    //   120: astore_2
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 144	java/io/FileInputStream:close	()V
    //   131: ldc 111
    //   133: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_2
    //   137: athrow
    //   138: astore_1
    //   139: goto -73 -> 66
    //   142: astore_1
    //   143: goto -12 -> 131
    //   146: astore_2
    //   147: goto -24 -> 123
    //   150: astore_3
    //   151: goto -68 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   72	7	0	bool	boolean
    //   32	67	1	localFileInputStream1	java.io.FileInputStream
    //   116	1	1	localException1	java.lang.Exception
    //   122	6	1	localObject1	Object
    //   138	1	1	localException2	java.lang.Exception
    //   142	1	1	localException3	java.lang.Exception
    //   30	80	2	localFileInputStream2	java.io.FileInputStream
    //   120	17	2	localObject2	Object
    //   146	1	2	localObject3	Object
    //   40	11	3	localProperties	java.util.Properties
    //   80	8	3	localException4	java.lang.Exception
    //   150	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	31	80	java/lang/Exception
    //   109	113	116	java/lang/Exception
    //   11	31	120	finally
    //   62	66	138	java/lang/Exception
    //   127	131	142	java/lang/Exception
    //   33	41	146	finally
    //   43	48	146	finally
    //   50	62	146	finally
    //   85	97	146	finally
    //   99	105	146	finally
    //   33	41	150	java/lang/Exception
    //   43	48	150	java/lang/Exception
    //   50	62	150	java/lang/Exception
  }
  
  /* Error */
  public static boolean isMIUIV8()
  {
    // Byte code:
    //   0: ldc 162
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 14	com/tencent/mm/compatible/util/g:isMIUIV8	Ljava/lang/Boolean;
    //   8: ifnonnull +65 -> 73
    //   11: new 113	java/io/FileInputStream
    //   14: dup
    //   15: new 57	java/io/File
    //   18: dup
    //   19: invokestatic 87	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   22: ldc 115
    //   24: invokespecial 118	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokespecial 121	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: new 123	java/util/Properties
    //   36: dup
    //   37: invokespecial 125	java/util/Properties:<init>	()V
    //   40: astore_3
    //   41: aload_2
    //   42: astore_1
    //   43: aload_3
    //   44: aload_2
    //   45: invokevirtual 129	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: ldc 131
    //   53: ldc 164
    //   55: invokevirtual 168	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: ldc 170
    //   60: invokevirtual 176	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: invokestatic 141	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: putstatic 14	com/tencent/mm/compatible/util/g:isMIUIV8	Ljava/lang/Boolean;
    //   69: aload_2
    //   70: invokevirtual 144	java/io/FileInputStream:close	()V
    //   73: getstatic 14	com/tencent/mm/compatible/util/g:isMIUIV8	Ljava/lang/Boolean;
    //   76: invokevirtual 147	java/lang/Boolean:booleanValue	()Z
    //   79: istore_0
    //   80: ldc 162
    //   82: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iload_0
    //   86: ireturn
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_2
    //   91: astore_1
    //   92: ldc 149
    //   94: aload_3
    //   95: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   98: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_2
    //   102: astore_1
    //   103: getstatic 160	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   106: putstatic 14	com/tencent/mm/compatible/util/g:isMIUIV8	Ljava/lang/Boolean;
    //   109: aload_2
    //   110: ifnull -37 -> 73
    //   113: aload_2
    //   114: invokevirtual 144	java/io/FileInputStream:close	()V
    //   117: goto -44 -> 73
    //   120: astore_1
    //   121: goto -48 -> 73
    //   124: astore_2
    //   125: aconst_null
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 144	java/io/FileInputStream:close	()V
    //   135: ldc 162
    //   137: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_2
    //   141: athrow
    //   142: astore_1
    //   143: goto -70 -> 73
    //   146: astore_1
    //   147: goto -12 -> 135
    //   150: astore_2
    //   151: goto -24 -> 127
    //   154: astore_3
    //   155: goto -65 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   79	7	0	bool	boolean
    //   32	71	1	localFileInputStream1	java.io.FileInputStream
    //   120	1	1	localException1	java.lang.Exception
    //   126	6	1	localObject1	Object
    //   142	1	1	localException2	java.lang.Exception
    //   146	1	1	localException3	java.lang.Exception
    //   30	84	2	localFileInputStream2	java.io.FileInputStream
    //   124	17	2	localObject2	Object
    //   150	1	2	localObject3	Object
    //   40	11	3	localProperties	java.util.Properties
    //   87	8	3	localException4	java.lang.Exception
    //   154	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	31	87	java/lang/Exception
    //   113	117	120	java/lang/Exception
    //   11	31	124	finally
    //   69	73	142	java/lang/Exception
    //   131	135	146	java/lang/Exception
    //   33	41	150	finally
    //   43	48	150	finally
    //   50	69	150	finally
    //   92	101	150	finally
    //   103	109	150	finally
    //   33	41	154	java/lang/Exception
    //   43	48	154	java/lang/Exception
    //   50	69	154	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.util.g
 * JD-Core Version:    0.7.0.1
 */