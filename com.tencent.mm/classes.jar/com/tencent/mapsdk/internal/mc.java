package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class mc
{
  private static final String a = "tencentmap";
  private static final String b = "/mapsdk_vector/";
  private static String c;
  private static String d;
  private static String e = "resourceVersion.dat";
  
  public static final InputStream a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(222736);
    paramContext = b(paramContext, "tencentmap/mapsdk_vector/" + paramString);
    AppMethodBeat.o(222736);
    return paramContext;
  }
  
  private static InputStream a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(222739);
    paramContext = b(paramContext, paramString1 + paramString2);
    AppMethodBeat.o(222739);
    return paramContext;
  }
  
  public static String a()
  {
    return c;
  }
  
  /* Error */
  public static void a(Context paramContext, mb parammb, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 58
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 60	java/io/File
    //   8: dup
    //   9: aload_2
    //   10: aload_3
    //   11: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: astore 7
    //   16: new 34	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   23: aload_0
    //   24: aconst_null
    //   25: invokestatic 68	com/tencent/mapsdk/internal/mf:a	(Landroid/content/Context;Lcom/tencent/tencentmap/mapsdk/maps/TencentMapOptions;)Lcom/tencent/mapsdk/internal/mf;
    //   28: aconst_null
    //   29: invokevirtual 71	com/tencent/mapsdk/internal/mf:b	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_3
    //   36: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 76	com/tencent/mapsdk/internal/kb:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore 6
    //   47: aload 6
    //   49: astore_2
    //   50: aload 6
    //   52: ifnonnull +90 -> 142
    //   55: aload 6
    //   57: astore 4
    //   59: aload 6
    //   61: astore 5
    //   63: getstatic 54	com/tencent/mapsdk/internal/mc:c	Ljava/lang/String;
    //   66: ifnull +243 -> 309
    //   69: aload 6
    //   71: astore 4
    //   73: aload 6
    //   75: astore 5
    //   77: aload 7
    //   79: invokevirtual 80	java/io/File:exists	()Z
    //   82: ifeq +27 -> 109
    //   85: aload 6
    //   87: astore_2
    //   88: aload 6
    //   90: astore 4
    //   92: aload 6
    //   94: astore 5
    //   96: aload_0
    //   97: aload_1
    //   98: getstatic 54	com/tencent/mapsdk/internal/mc:c	Ljava/lang/String;
    //   101: aload_3
    //   102: iconst_1
    //   103: invokestatic 83	com/tencent/mapsdk/internal/mc:a	(Landroid/content/Context;Lcom/tencent/mapsdk/internal/mb;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   106: ifeq +36 -> 142
    //   109: aload 6
    //   111: astore 4
    //   113: aload 6
    //   115: astore 5
    //   117: aload_0
    //   118: new 34	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   125: getstatic 54	com/tencent/mapsdk/internal/mc:c	Ljava/lang/String;
    //   128: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_3
    //   132: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 47	com/tencent/mapsdk/internal/mc:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   141: astore_2
    //   142: aload_2
    //   143: astore 6
    //   145: aload_2
    //   146: ifnonnull +84 -> 230
    //   149: aload_2
    //   150: astore 4
    //   152: aload_2
    //   153: astore 5
    //   155: aload_0
    //   156: aconst_null
    //   157: invokestatic 68	com/tencent/mapsdk/internal/mf:a	(Landroid/content/Context;Lcom/tencent/tencentmap/mapsdk/maps/TencentMapOptions;)Lcom/tencent/mapsdk/internal/mf;
    //   160: invokevirtual 85	com/tencent/mapsdk/internal/mf:e	()Ljava/lang/String;
    //   163: astore 8
    //   165: aload_2
    //   166: astore 4
    //   168: aload_2
    //   169: astore 5
    //   171: aload 7
    //   173: invokevirtual 80	java/io/File:exists	()Z
    //   176: ifeq +24 -> 200
    //   179: aload_2
    //   180: astore 6
    //   182: aload_2
    //   183: astore 4
    //   185: aload_2
    //   186: astore 5
    //   188: aload_0
    //   189: aload_1
    //   190: aload 8
    //   192: aload_3
    //   193: iconst_0
    //   194: invokestatic 83	com/tencent/mapsdk/internal/mc:a	(Landroid/content/Context;Lcom/tencent/mapsdk/internal/mb;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   197: ifeq +33 -> 230
    //   200: aload_2
    //   201: astore 4
    //   203: aload_2
    //   204: astore 5
    //   206: new 34	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   213: aload 8
    //   215: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_3
    //   219: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 76	com/tencent/mapsdk/internal/kb:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   228: astore 6
    //   230: aload 6
    //   232: astore_2
    //   233: aload 6
    //   235: ifnonnull +56 -> 291
    //   238: aload 6
    //   240: astore 4
    //   242: aload 6
    //   244: astore 5
    //   246: aload 7
    //   248: invokevirtual 80	java/io/File:exists	()Z
    //   251: ifeq +26 -> 277
    //   254: aload 6
    //   256: astore_2
    //   257: aload 6
    //   259: astore 4
    //   261: aload 6
    //   263: astore 5
    //   265: aload_0
    //   266: aload_1
    //   267: ldc 37
    //   269: aload_3
    //   270: iconst_1
    //   271: invokestatic 83	com/tencent/mapsdk/internal/mc:a	(Landroid/content/Context;Lcom/tencent/mapsdk/internal/mb;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   274: ifeq +17 -> 291
    //   277: aload 6
    //   279: astore 4
    //   281: aload 6
    //   283: astore 5
    //   285: aload_0
    //   286: aload_3
    //   287: invokestatic 87	com/tencent/mapsdk/internal/mc:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   290: astore_2
    //   291: aload_2
    //   292: ifnonnull +109 -> 401
    //   295: aconst_null
    //   296: invokestatic 90	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   299: aload_2
    //   300: invokestatic 90	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   303: ldc 58
    //   305: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: return
    //   309: aload 6
    //   311: astore_2
    //   312: aload 6
    //   314: astore 4
    //   316: aload 6
    //   318: astore 5
    //   320: getstatic 92	com/tencent/mapsdk/internal/mc:d	Ljava/lang/String;
    //   323: ifnull -181 -> 142
    //   326: aload 6
    //   328: astore 4
    //   330: aload 6
    //   332: astore 5
    //   334: aload 7
    //   336: invokevirtual 80	java/io/File:exists	()Z
    //   339: ifeq +27 -> 366
    //   342: aload 6
    //   344: astore_2
    //   345: aload 6
    //   347: astore 4
    //   349: aload 6
    //   351: astore 5
    //   353: aload_0
    //   354: aload_1
    //   355: getstatic 92	com/tencent/mapsdk/internal/mc:d	Ljava/lang/String;
    //   358: aload_3
    //   359: iconst_0
    //   360: invokestatic 83	com/tencent/mapsdk/internal/mc:a	(Landroid/content/Context;Lcom/tencent/mapsdk/internal/mb;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   363: ifeq -221 -> 142
    //   366: aload 6
    //   368: astore 4
    //   370: aload 6
    //   372: astore 5
    //   374: new 34	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   381: getstatic 92	com/tencent/mapsdk/internal/mc:d	Ljava/lang/String;
    //   384: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload_3
    //   388: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 76	com/tencent/mapsdk/internal/kb:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   397: astore_2
    //   398: goto -256 -> 142
    //   401: aload_2
    //   402: astore 4
    //   404: aload_2
    //   405: astore 5
    //   407: new 94	java/io/FileOutputStream
    //   410: dup
    //   411: aload 7
    //   413: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   416: astore_0
    //   417: aload_2
    //   418: aload_0
    //   419: invokestatic 100	com/tencent/mapsdk/internal/kb:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   422: pop2
    //   423: aload_0
    //   424: invokestatic 90	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   427: aload_2
    //   428: invokestatic 90	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   431: ldc 58
    //   433: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   436: return
    //   437: astore_0
    //   438: aconst_null
    //   439: astore_0
    //   440: aconst_null
    //   441: astore_2
    //   442: aload_0
    //   443: invokestatic 90	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   446: aload_2
    //   447: invokestatic 90	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   450: ldc 58
    //   452: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   455: return
    //   456: astore_0
    //   457: aconst_null
    //   458: astore_1
    //   459: aconst_null
    //   460: astore_2
    //   461: aload_1
    //   462: invokestatic 90	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   465: aload_2
    //   466: invokestatic 90	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   469: ldc 58
    //   471: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: aload_0
    //   475: athrow
    //   476: astore_0
    //   477: aconst_null
    //   478: astore_1
    //   479: aload 4
    //   481: astore_2
    //   482: goto -21 -> 461
    //   485: astore_1
    //   486: aload_0
    //   487: astore_3
    //   488: aload_1
    //   489: astore_0
    //   490: aload_3
    //   491: astore_1
    //   492: goto -31 -> 461
    //   495: astore_0
    //   496: aconst_null
    //   497: astore_0
    //   498: aload 5
    //   500: astore_2
    //   501: goto -59 -> 442
    //   504: astore_1
    //   505: goto -63 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	508	0	paramContext	Context
    //   0	508	1	parammb	mb
    //   0	508	2	paramString1	String
    //   0	508	3	paramString2	String
    //   57	423	4	localObject1	Object
    //   61	438	5	localObject2	Object
    //   45	326	6	localObject3	Object
    //   14	398	7	localFile	File
    //   163	51	8	str	String
    // Exception table:
    //   from	to	target	type
    //   16	47	437	java/io/IOException
    //   16	47	456	finally
    //   63	69	476	finally
    //   77	85	476	finally
    //   96	109	476	finally
    //   117	142	476	finally
    //   155	165	476	finally
    //   171	179	476	finally
    //   188	200	476	finally
    //   206	230	476	finally
    //   246	254	476	finally
    //   265	277	476	finally
    //   285	291	476	finally
    //   320	326	476	finally
    //   334	342	476	finally
    //   353	366	476	finally
    //   374	398	476	finally
    //   407	417	476	finally
    //   417	423	485	finally
    //   63	69	495	java/io/IOException
    //   77	85	495	java/io/IOException
    //   96	109	495	java/io/IOException
    //   117	142	495	java/io/IOException
    //   155	165	495	java/io/IOException
    //   171	179	495	java/io/IOException
    //   188	200	495	java/io/IOException
    //   206	230	495	java/io/IOException
    //   246	254	495	java/io/IOException
    //   265	277	495	java/io/IOException
    //   285	291	495	java/io/IOException
    //   320	326	495	java/io/IOException
    //   334	342	495	java/io/IOException
    //   353	366	495	java/io/IOException
    //   374	398	495	java/io/IOException
    //   407	417	495	java/io/IOException
    //   417	423	504	java/io/IOException
  }
  
  /* Error */
  public static void a(mb parammb, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 104
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokestatic 107	com/tencent/mapsdk/internal/mc:b	(Lcom/tencent/mapsdk/internal/mb;Ljava/lang/String;)Z
    //   12: ifne +9 -> 21
    //   15: ldc 104
    //   17: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: return
    //   21: new 60	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: ldc 109
    //   28: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore 4
    //   33: aload_0
    //   34: ldc 111
    //   36: invokevirtual 115	com/tencent/mapsdk/internal/mb:a	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore 5
    //   41: aload 5
    //   43: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +80 -> 126
    //   49: ldc 123
    //   51: ldc 125
    //   53: invokestatic 129	com/tencent/mapsdk/internal/kh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload 4
    //   58: invokestatic 134	com/tencent/mapsdk/internal/kq:a	(Ljava/io/File;)Ljava/lang/String;
    //   61: astore_2
    //   62: aload_2
    //   63: aload 5
    //   65: invokestatic 138	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   68: ifne +58 -> 126
    //   71: ldc 123
    //   73: new 34	java/lang/StringBuilder
    //   76: dup
    //   77: ldc 140
    //   79: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: aload_2
    //   83: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 145
    //   88: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_2
    //   92: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 129	com/tencent/mapsdk/internal/kh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 4
    //   103: invokevirtual 148	java/io/File:delete	()Z
    //   106: pop
    //   107: aload_0
    //   108: iconst_2
    //   109: anewarray 150	java/lang/String
    //   112: dup
    //   113: iconst_0
    //   114: ldc 152
    //   116: aastore
    //   117: dup
    //   118: iconst_1
    //   119: ldc 111
    //   121: aastore
    //   122: invokevirtual 155	com/tencent/mapsdk/internal/mb:a	([Ljava/lang/String;)Z
    //   125: pop
    //   126: new 60	java/io/File
    //   129: dup
    //   130: aload_1
    //   131: ldc 157
    //   133: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: astore 4
    //   138: aload_0
    //   139: ldc 159
    //   141: invokevirtual 115	com/tencent/mapsdk/internal/mb:a	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore 5
    //   146: aload 5
    //   148: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   151: ifne +81 -> 232
    //   154: ldc 123
    //   156: ldc 161
    //   158: invokestatic 129	com/tencent/mapsdk/internal/kh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 4
    //   163: invokestatic 134	com/tencent/mapsdk/internal/kq:a	(Ljava/io/File;)Ljava/lang/String;
    //   166: astore_2
    //   167: aload_2
    //   168: aload 5
    //   170: invokestatic 138	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   173: ifne +59 -> 232
    //   176: ldc 123
    //   178: new 34	java/lang/StringBuilder
    //   181: dup
    //   182: ldc 140
    //   184: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: aload_2
    //   188: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc 145
    //   193: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 5
    //   198: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 129	com/tencent/mapsdk/internal/kh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload 4
    //   209: invokevirtual 148	java/io/File:delete	()Z
    //   212: pop
    //   213: aload_0
    //   214: iconst_2
    //   215: anewarray 150	java/lang/String
    //   218: dup
    //   219: iconst_0
    //   220: ldc 163
    //   222: aastore
    //   223: dup
    //   224: iconst_1
    //   225: ldc 159
    //   227: aastore
    //   228: invokevirtual 155	com/tencent/mapsdk/internal/mb:a	([Ljava/lang/String;)Z
    //   231: pop
    //   232: new 60	java/io/File
    //   235: dup
    //   236: aload_1
    //   237: ldc 165
    //   239: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: astore_1
    //   243: aload_0
    //   244: ldc 167
    //   246: invokevirtual 115	com/tencent/mapsdk/internal/mb:a	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore_2
    //   250: aload_2
    //   251: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifne +40 -> 294
    //   257: aload_1
    //   258: invokestatic 134	com/tencent/mapsdk/internal/kq:a	(Ljava/io/File;)Ljava/lang/String;
    //   261: astore_3
    //   262: aload_3
    //   263: aload_2
    //   264: invokestatic 138	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   267: ifne +27 -> 294
    //   270: aload_1
    //   271: invokevirtual 148	java/io/File:delete	()Z
    //   274: pop
    //   275: aload_0
    //   276: iconst_2
    //   277: anewarray 150	java/lang/String
    //   280: dup
    //   281: iconst_0
    //   282: ldc 169
    //   284: aastore
    //   285: dup
    //   286: iconst_1
    //   287: ldc 167
    //   289: aastore
    //   290: invokevirtual 155	com/tencent/mapsdk/internal/mb:a	([Ljava/lang/String;)Z
    //   293: pop
    //   294: ldc 104
    //   296: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: return
    //   300: astore_2
    //   301: aconst_null
    //   302: astore_2
    //   303: goto -241 -> 62
    //   306: astore_1
    //   307: ldc 171
    //   309: aload_1
    //   310: invokestatic 174	com/tencent/mapsdk/internal/kh:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   313: aload_0
    //   314: iconst_2
    //   315: anewarray 150	java/lang/String
    //   318: dup
    //   319: iconst_0
    //   320: ldc 169
    //   322: aastore
    //   323: dup
    //   324: iconst_1
    //   325: ldc 167
    //   327: aastore
    //   328: invokevirtual 155	com/tencent/mapsdk/internal/mb:a	([Ljava/lang/String;)Z
    //   331: pop
    //   332: ldc 104
    //   334: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   337: return
    //   338: astore_2
    //   339: aload_3
    //   340: astore_2
    //   341: goto -174 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	parammb	mb
    //   0	344	1	paramString	String
    //   61	203	2	str1	String
    //   300	1	2	localFileNotFoundException1	FileNotFoundException
    //   302	1	2	localObject	Object
    //   338	1	2	localFileNotFoundException2	FileNotFoundException
    //   340	1	2	str2	String
    //   1	339	3	str3	String
    //   31	177	4	localFile	File
    //   39	158	5	str4	String
    // Exception table:
    //   from	to	target	type
    //   56	62	300	java/io/FileNotFoundException
    //   257	262	306	java/io/FileNotFoundException
    //   161	167	338	java/io/FileNotFoundException
  }
  
  public static void a(TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(222865);
    if (paramTencentMapOptions != null)
    {
      String str;
      if (paramTencentMapOptions.getCustomAssetsPath() != null)
      {
        str = paramTencentMapOptions.getCustomAssetsPath();
        if ((str != null) && (str.trim().length() != 0))
        {
          paramTencentMapOptions = str;
          if (!str.endsWith(File.separator)) {
            paramTencentMapOptions = str + File.separator;
          }
          c = paramTencentMapOptions;
        }
        AppMethodBeat.o(222865);
        return;
      }
      if (paramTencentMapOptions.getCustomLocalPath() != null)
      {
        str = paramTencentMapOptions.getCustomLocalPath();
        if ((str != null) && (str.trim().length() != 0))
        {
          paramTencentMapOptions = str;
          if (!str.endsWith(File.separator)) {
            paramTencentMapOptions = str + File.separator;
          }
          d = paramTencentMapOptions;
        }
      }
    }
    AppMethodBeat.o(222865);
  }
  
  private static void a(String paramString)
  {
    AppMethodBeat.i(222831);
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      String str = paramString;
      if (!paramString.endsWith(File.separator)) {
        str = paramString + File.separator;
      }
      c = str;
    }
    AppMethodBeat.o(222831);
  }
  
  private static boolean a(Context paramContext, mb parammb, String paramString1, String paramString2, boolean paramBoolean)
  {
    byte[] arrayOfByte = null;
    AppMethodBeat.i(222819);
    if ((parammb == null) || ((parammb instanceof md)))
    {
      AppMethodBeat.o(222819);
      return false;
    }
    String str1;
    if (paramString2.startsWith("mapconfig"))
    {
      str1 = "mapconfig";
      paramString2 = "mapConfigVersion";
    }
    for (;;)
    {
      if (str1 == null)
      {
        AppMethodBeat.o(222819);
        return false;
        if (paramString2.startsWith("map_icon"))
        {
          str1 = "map_icon";
          paramString2 = "mapIconVersion";
          continue;
        }
        if (paramString2.startsWith("poi_icon"))
        {
          str1 = "poi_icon";
          paramString2 = "poiIconVersion";
        }
      }
      else
      {
        int i = parammb.b(paramString2);
        String str2 = paramString1 + e;
        if (paramBoolean) {
          paramString1 = arrayOfByte;
        }
        try
        {
          for (paramContext = b(paramContext, str2); paramContext == null; paramContext = kb.b(str2))
          {
            return false;
            paramString1 = arrayOfByte;
          }
          paramString1 = paramContext;
          int j;
          paramString2 = null;
        }
        catch (Exception paramContext)
        {
          paramContext = paramContext;
          paramContext = null;
          return false;
        }
        finally
        {
          kb.a(paramString1);
          AppMethodBeat.o(222819);
        }
      }
      str1 = null;
    }
  }
  
  public static final InputStream b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(222748);
    if (paramContext == null)
    {
      AppMethodBeat.o(222748);
      return null;
    }
    paramContext = paramContext.getAssets();
    if (paramContext == null)
    {
      AppMethodBeat.o(222748);
      return null;
    }
    try
    {
      paramContext = paramContext.open(paramString);
      AppMethodBeat.o(222748);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramString = paramContext.getMessage();
      if (kh.a == null) {
        break label76;
      }
    }
    kh.a.d("asset", paramString, paramContext);
    for (;;)
    {
      AppMethodBeat.o(222748);
      return null;
      label76:
      kh.b("asset", paramString, paramContext);
    }
  }
  
  public static String b()
  {
    return d;
  }
  
  private static void b(String paramString)
  {
    AppMethodBeat.i(222841);
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      String str = paramString;
      if (!paramString.endsWith(File.separator)) {
        str = paramString + File.separator;
      }
      d = str;
    }
    AppMethodBeat.o(222841);
  }
  
  private static boolean b(mb parammb, String paramString)
  {
    AppMethodBeat.i(222783);
    paramString = new File(paramString, "mapconfig.dat");
    String str1 = parammb.a("mapConfigZipMd5");
    if ((!paramString.exists()) && (TextUtils.isEmpty(str1)))
    {
      AppMethodBeat.o(222783);
      return true;
    }
    try
    {
      String str2 = kq.a(paramString);
      if (TextUtils.equals(str2, str1))
      {
        AppMethodBeat.o(222783);
        return true;
      }
    }
    catch (FileNotFoundException paramString)
    {
      parammb.a();
      AppMethodBeat.o(222783);
      return false;
    }
    paramString.delete();
    parammb.a();
    AppMethodBeat.o(222783);
    return false;
  }
  
  private static void c(mb parammb, String paramString)
  {
    Object localObject3 = null;
    AppMethodBeat.i(222792);
    Object localObject4 = new File(paramString, "indoor_style.dat");
    String str = parammb.a("indoormap_style_md5");
    if (!TextUtils.isEmpty(str)) {
      kh.b("TDZ", "校验文件:indoor_style.dat");
    }
    try
    {
      localObject1 = kq.a((File)localObject4);
      if (!TextUtils.equals((CharSequence)localObject1, str))
      {
        kh.b("TDZ", "文件md5校验失败:" + (String)localObject1 + "," + (String)localObject1);
        ((File)localObject4).delete();
        parammb.a(new String[] { "indoormap_style_version", "indoormap_style_md5" });
      }
      localObject1 = new File(paramString, "indoor_style_night.dat");
      localObject4 = parammb.a("indoormap_style_night_md5");
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        kh.b("TDZ", "校验文件:indoor_style_night.dat");
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      try
      {
        Object localObject1;
        paramString = kq.a((File)localObject1);
        if (!TextUtils.equals(paramString, (CharSequence)localObject4))
        {
          kh.b("TDZ", "文件md5校验失败:" + paramString + "," + (String)localObject4);
          ((File)localObject1).delete();
          parammb.a(new String[] { "indoormap_style_night_version", "indoormap_style_night_md5" });
        }
        AppMethodBeat.o(222792);
        return;
        localFileNotFoundException = localFileNotFoundException;
        Object localObject2 = null;
      }
      catch (FileNotFoundException paramString)
      {
        for (;;)
        {
          paramString = localObject3;
        }
      }
    }
  }
  
  private static void d(mb parammb, String paramString)
  {
    AppMethodBeat.i(222804);
    paramString = new File(paramString, "poi_icon_indoor_ex@2x.png");
    String str1 = parammb.a("poiIcon3dIndoorMd5");
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(222804);
      return;
    }
    try
    {
      String str2 = kq.a(paramString);
      if (TextUtils.equals(str2, str1))
      {
        AppMethodBeat.o(222804);
        return;
      }
    }
    catch (FileNotFoundException paramString)
    {
      kh.b("config error: ", paramString);
      parammb.a(new String[] { "mapPoiIcon3dIndoorVersion", "poiIcon3dIndoorMd5" });
      AppMethodBeat.o(222804);
      return;
    }
    paramString.delete();
    parammb.a(new String[] { "mapPoiIcon3dIndoorVersion", "poiIcon3dIndoorMd5" });
    AppMethodBeat.o(222804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mc
 * JD-Core Version:    0.7.0.1
 */