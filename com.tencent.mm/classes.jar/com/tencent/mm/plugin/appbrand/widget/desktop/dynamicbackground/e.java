package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/FileUtils;", "", "()V", "TAG", "", "copyFileFromAssets", "", "context", "Landroid/content/Context;", "srcFileName", "dstFileName", "getSavedFileDirectory", "plugin-appbrand-integration_release"})
public final class e
{
  private static final String TAG = "FileUtils";
  public static final e jgU;
  
  static
  {
    AppMethodBeat.i(135255);
    jgU = new e();
    TAG = "FileUtils";
    AppMethodBeat.o(135255);
  }
  
  public static String ds(Context paramContext)
  {
    AppMethodBeat.i(135254);
    j.q(paramContext, "context");
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = paramContext.getFilesDir();
    j.p(paramContext, "context.filesDir");
    paramContext = paramContext.getParent() + File.separator + "appbrand/glsl/";
    AppMethodBeat.o(135254);
    return paramContext;
  }
  
  /* Error */
  public static void p(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 93
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 51
    //   8: invokestatic 57	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 94
    //   14: invokestatic 57	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ldc 95
    //   20: invokestatic 57	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: getstatic 42	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/e:TAG	Ljava/lang/String;
    //   26: ldc 97
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
    //   40: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: new 73	java/io/File
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore 4
    //   53: aload_0
    //   54: invokevirtual 109	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   57: aload_1
    //   58: invokevirtual 115	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   61: astore_2
    //   62: new 117	java/io/FileOutputStream
    //   65: dup
    //   66: aload 4
    //   68: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   71: checkcast 122	java/io/OutputStream
    //   74: astore_0
    //   75: sipush 1024
    //   78: newarray byte
    //   80: astore 5
    //   82: aload_2
    //   83: ifnonnull +6 -> 89
    //   86: invokestatic 125	a/f/b/j:ebi	()V
    //   89: aload_2
    //   90: aload 5
    //   92: invokevirtual 131	java/io/InputStream:read	([B)I
    //   95: istore_3
    //   96: iload_3
    //   97: iconst_m1
    //   98: if_icmpeq +53 -> 151
    //   101: aload_0
    //   102: aload 5
    //   104: iconst_0
    //   105: iload_3
    //   106: invokevirtual 135	java/io/OutputStream:write	([BII)V
    //   109: goto -27 -> 82
    //   112: astore_1
    //   113: getstatic 42	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/e:TAG	Ljava/lang/String;
    //   116: aload_1
    //   117: checkcast 137	java/lang/Throwable
    //   120: ldc 139
    //   122: iconst_0
    //   123: anewarray 4	java/lang/Object
    //   126: invokestatic 143	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 146	java/io/InputStream:close	()V
    //   137: aload_0
    //   138: ifnull +65 -> 203
    //   141: aload_0
    //   142: invokevirtual 147	java/io/OutputStream:close	()V
    //   145: ldc 93
    //   147: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: aload_0
    //   152: invokevirtual 150	java/io/OutputStream:flush	()V
    //   155: getstatic 42	com/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/e:TAG	Ljava/lang/String;
    //   158: ldc 152
    //   160: iconst_2
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload_1
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: aload 4
    //   172: invokevirtual 156	java/io/File:length	()J
    //   175: invokestatic 162	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   178: aastore
    //   179: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_2
    //   183: invokevirtual 146	java/io/InputStream:close	()V
    //   186: aload_0
    //   187: invokevirtual 147	java/io/OutputStream:close	()V
    //   190: ldc 93
    //   192: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: return
    //   196: astore_0
    //   197: ldc 93
    //   199: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: return
    //   203: ldc 93
    //   205: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: return
    //   209: astore_0
    //   210: ldc 93
    //   212: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: return
    //   216: astore_1
    //   217: aconst_null
    //   218: astore_0
    //   219: aconst_null
    //   220: astore_2
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 146	java/io/InputStream:close	()V
    //   229: aload_0
    //   230: ifnull +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 147	java/io/OutputStream:close	()V
    //   237: ldc 93
    //   239: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload_1
    //   243: athrow
    //   244: astore_0
    //   245: goto -8 -> 237
    //   248: astore_1
    //   249: aconst_null
    //   250: astore_0
    //   251: goto -30 -> 221
    //   254: astore_1
    //   255: goto -34 -> 221
    //   258: astore_1
    //   259: goto -38 -> 221
    //   262: astore_1
    //   263: aconst_null
    //   264: astore_0
    //   265: aconst_null
    //   266: astore_2
    //   267: goto -154 -> 113
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_0
    //   273: goto -160 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramContext	Context
    //   0	276	1	paramString1	String
    //   0	276	2	paramString2	String
    //   95	11	3	i	int
    //   51	120	4	localFile	File
    //   80	23	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   75	82	112	java/lang/Exception
    //   86	89	112	java/lang/Exception
    //   89	96	112	java/lang/Exception
    //   101	109	112	java/lang/Exception
    //   151	182	112	java/lang/Exception
    //   182	190	196	java/lang/Exception
    //   133	137	209	java/lang/Exception
    //   141	150	209	java/lang/Exception
    //   43	62	216	finally
    //   225	229	244	java/lang/Exception
    //   233	237	244	java/lang/Exception
    //   62	75	248	finally
    //   75	82	254	finally
    //   86	89	254	finally
    //   89	96	254	finally
    //   101	109	254	finally
    //   151	182	254	finally
    //   113	129	258	finally
    //   43	62	262	java/lang/Exception
    //   62	75	270	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.e
 * JD-Core Version:    0.7.0.1
 */