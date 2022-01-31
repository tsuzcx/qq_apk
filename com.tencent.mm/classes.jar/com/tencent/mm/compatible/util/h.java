package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class h
{
  private static Boolean etg = null;
  private static Boolean eth = null;
  private static Boolean eti = null;
  
  /* Error */
  @java.lang.Deprecated
  public static boolean Mn()
  {
    // Byte code:
    //   0: ldc 23
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 12	com/tencent/mm/compatible/util/h:etg	Ljava/lang/Boolean;
    //   8: ifnonnull +58 -> 66
    //   11: new 31	java/io/FileInputStream
    //   14: dup
    //   15: new 33	java/io/File
    //   18: dup
    //   19: invokestatic 39	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   22: ldc 41
    //   24: invokespecial 45	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: new 50	java/util/Properties
    //   36: dup
    //   37: invokespecial 52	java/util/Properties:<init>	()V
    //   40: astore_3
    //   41: aload_2
    //   42: astore_1
    //   43: aload_3
    //   44: aload_2
    //   45: invokevirtual 56	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: ldc 58
    //   53: invokevirtual 62	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   56: invokestatic 68	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: putstatic 12	com/tencent/mm/compatible/util/h:etg	Ljava/lang/Boolean;
    //   62: aload_2
    //   63: invokevirtual 71	java/io/FileInputStream:close	()V
    //   66: getstatic 12	com/tencent/mm/compatible/util/h:etg	Ljava/lang/Boolean;
    //   69: invokevirtual 74	java/lang/Boolean:booleanValue	()Z
    //   72: istore_0
    //   73: ldc 23
    //   75: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iload_0
    //   79: ireturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_1
    //   85: ldc 79
    //   87: aload_3
    //   88: ldc 81
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 87	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_2
    //   98: astore_1
    //   99: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   102: putstatic 12	com/tencent/mm/compatible/util/h:etg	Ljava/lang/Boolean;
    //   105: aload_2
    //   106: ifnull -40 -> 66
    //   109: aload_2
    //   110: invokevirtual 71	java/io/FileInputStream:close	()V
    //   113: goto -47 -> 66
    //   116: astore_1
    //   117: goto -51 -> 66
    //   120: astore_2
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 71	java/io/FileInputStream:close	()V
    //   131: ldc 23
    //   133: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public static boolean Mo()
  {
    // Byte code:
    //   0: ldc 93
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 14	com/tencent/mm/compatible/util/h:eth	Ljava/lang/Boolean;
    //   8: ifnonnull +65 -> 73
    //   11: new 31	java/io/FileInputStream
    //   14: dup
    //   15: new 33	java/io/File
    //   18: dup
    //   19: invokestatic 39	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   22: ldc 41
    //   24: invokespecial 45	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: new 50	java/util/Properties
    //   36: dup
    //   37: invokespecial 52	java/util/Properties:<init>	()V
    //   40: astore_3
    //   41: aload_2
    //   42: astore_1
    //   43: aload_3
    //   44: aload_2
    //   45: invokevirtual 56	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: ldc 58
    //   53: ldc 95
    //   55: invokevirtual 99	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: ldc 101
    //   60: invokevirtual 107	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: invokestatic 68	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: putstatic 14	com/tencent/mm/compatible/util/h:eth	Ljava/lang/Boolean;
    //   69: aload_2
    //   70: invokevirtual 71	java/io/FileInputStream:close	()V
    //   73: getstatic 14	com/tencent/mm/compatible/util/h:eth	Ljava/lang/Boolean;
    //   76: invokevirtual 74	java/lang/Boolean:booleanValue	()Z
    //   79: istore_0
    //   80: ldc 93
    //   82: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iload_0
    //   86: ireturn
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_2
    //   91: astore_1
    //   92: ldc 79
    //   94: aload_3
    //   95: ldc 81
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 87	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload_2
    //   105: astore_1
    //   106: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   109: putstatic 14	com/tencent/mm/compatible/util/h:eth	Ljava/lang/Boolean;
    //   112: aload_2
    //   113: ifnull -40 -> 73
    //   116: aload_2
    //   117: invokevirtual 71	java/io/FileInputStream:close	()V
    //   120: goto -47 -> 73
    //   123: astore_1
    //   124: goto -51 -> 73
    //   127: astore_2
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 71	java/io/FileInputStream:close	()V
    //   138: ldc 93
    //   140: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_2
    //   144: athrow
    //   145: astore_1
    //   146: goto -73 -> 73
    //   149: astore_1
    //   150: goto -12 -> 138
    //   153: astore_2
    //   154: goto -24 -> 130
    //   157: astore_3
    //   158: goto -68 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   79	7	0	bool	boolean
    //   32	74	1	localFileInputStream1	java.io.FileInputStream
    //   123	1	1	localException1	java.lang.Exception
    //   129	6	1	localObject1	Object
    //   145	1	1	localException2	java.lang.Exception
    //   149	1	1	localException3	java.lang.Exception
    //   30	87	2	localFileInputStream2	java.io.FileInputStream
    //   127	17	2	localObject2	Object
    //   153	1	2	localObject3	Object
    //   40	11	3	localProperties	java.util.Properties
    //   87	8	3	localException4	java.lang.Exception
    //   157	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	31	87	java/lang/Exception
    //   116	120	123	java/lang/Exception
    //   11	31	127	finally
    //   69	73	145	java/lang/Exception
    //   134	138	149	java/lang/Exception
    //   33	41	153	finally
    //   43	48	153	finally
    //   50	69	153	finally
    //   92	104	153	finally
    //   106	112	153	finally
    //   33	41	157	java/lang/Exception
    //   43	48	157	java/lang/Exception
    //   50	69	157	java/lang/Exception
  }
  
  public static int Mp()
  {
    return 4;
  }
  
  public static File getDataDirectory()
  {
    AppMethodBeat.i(93081);
    if (bo.isNullOrNil(ac.erF.epv))
    {
      localFile = Environment.getDataDirectory();
      AppMethodBeat.o(93081);
      return localFile;
    }
    File localFile = new File(ac.erF.epv);
    AppMethodBeat.o(93081);
    return localFile;
  }
  
  public static File getDownloadCacheDirectory()
  {
    AppMethodBeat.i(93083);
    if (bo.isNullOrNil(ac.erF.epy))
    {
      localFile = Environment.getDownloadCacheDirectory();
      AppMethodBeat.o(93083);
      return localFile;
    }
    File localFile = new File(ac.erF.epy);
    AppMethodBeat.o(93083);
    return localFile;
  }
  
  public static File getExternalStorageDirectory()
  {
    AppMethodBeat.i(93079);
    if (bo.isNullOrNil(ac.erF.ept))
    {
      localFile = Environment.getExternalStorageDirectory();
      AppMethodBeat.o(93079);
      return localFile;
    }
    File localFile = new File(ac.erF.ept);
    AppMethodBeat.o(93079);
    return localFile;
  }
  
  @TargetApi(8)
  public static File getExternalStoragePublicDirectory(String paramString)
  {
    AppMethodBeat.i(93080);
    if (bo.isNullOrNil(ac.erF.epu))
    {
      paramString = Environment.getExternalStoragePublicDirectory(paramString);
      AppMethodBeat.o(93080);
      return paramString;
    }
    paramString = new File(ac.erF.epu);
    AppMethodBeat.o(93080);
    return paramString;
  }
  
  public static String getExternalStorageState()
  {
    AppMethodBeat.i(93084);
    if (bo.isNullOrNil(ac.erF.epx))
    {
      str = Environment.getExternalStorageState();
      AppMethodBeat.o(93084);
      return str;
    }
    String str = ac.erF.epx;
    AppMethodBeat.o(93084);
    return str;
  }
  
  public static File getRootDirectory()
  {
    AppMethodBeat.i(93082);
    if (bo.isNullOrNil(ac.erF.epw))
    {
      localFile = Environment.getRootDirectory();
      AppMethodBeat.o(93082);
      return localFile;
    }
    File localFile = new File(ac.erF.epw);
    AppMethodBeat.o(93082);
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.h
 * JD-Core Version:    0.7.0.1
 */