package com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a;

import com.google.android.exoplayer2.h.a.a;
import com.google.android.exoplayer2.h.a.e;
import com.google.android.exoplayer2.h.a.m;
import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;

public class d
  implements b, com.tencent.mm.plugin.appbrand.jsapi.video.f
{
  private static d sHg;
  private a dja;
  public e sGZ;
  private c sHh;
  private boolean sHi;
  
  /* Error */
  protected d()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 22	java/lang/Object:<init>	()V
    //   4: ldc 23
    //   6: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 31	com/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/d:sHh	Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/c;
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 33	com/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/d:sHi	Z
    //   19: aload_0
    //   20: invokevirtual 37	com/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/d:cwY	()Ljava/lang/String;
    //   23: astore_3
    //   24: invokestatic 42	com/tencent/mm/loader/i/b:bmz	()Ljava/lang/String;
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: ldc 44
    //   33: invokevirtual 50	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   36: ifne +23 -> 59
    //   39: new 52	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   46: aload_2
    //   47: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 44
    //   52: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_1
    //   59: new 52	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   66: aload_1
    //   67: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 62
    //   72: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_1
    //   79: aload_1
    //   80: iconst_1
    //   81: invokestatic 68	com/tencent/mm/vfs/y:ew	(Ljava/lang/String;Z)Z
    //   84: pop
    //   85: invokestatic 42	com/tencent/mm/loader/i/b:bmz	()Ljava/lang/String;
    //   88: astore_2
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: ldc 44
    //   94: invokevirtual 50	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   97: ifne +23 -> 120
    //   100: new 52	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   107: aload_2
    //   108: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 44
    //   113: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore_1
    //   120: new 52	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   127: aload_1
    //   128: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 70
    //   133: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_3
    //   137: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 44
    //   142: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore_1
    //   149: aload_1
    //   150: invokestatic 73	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   153: ifne +97 -> 250
    //   156: ldc 75
    //   158: ldc 77
    //   160: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: new 85	com/tencent/mm/vfs/u
    //   166: dup
    //   167: aload_1
    //   168: invokespecial 88	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   171: invokevirtual 92	com/tencent/mm/vfs/u:isDirectory	()Z
    //   174: ifne +76 -> 250
    //   177: ldc 75
    //   179: ldc 94
    //   181: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_1
    //   185: invokestatic 97	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   188: pop
    //   189: aload_1
    //   190: invokestatic 73	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   193: ifne +57 -> 250
    //   196: ldc 75
    //   198: ldc 99
    //   200: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: ldc 23
    //   205: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: return
    //   209: astore_1
    //   210: ldc 75
    //   212: ldc 104
    //   214: iconst_1
    //   215: anewarray 4	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: aload_1
    //   221: aastore
    //   222: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: goto -140 -> 85
    //   228: astore_1
    //   229: ldc 75
    //   231: ldc 110
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload_1
    //   240: aastore
    //   241: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: ldc 23
    //   246: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: return
    //   250: new 85	com/tencent/mm/vfs/u
    //   253: dup
    //   254: aload_1
    //   255: invokespecial 88	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   258: astore_1
    //   259: aload_0
    //   260: aload_0
    //   261: new 112	java/io/File
    //   264: dup
    //   265: aload_1
    //   266: invokevirtual 116	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   269: invokestatic 122	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   272: iconst_1
    //   273: invokestatic 126	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   276: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   279: new 129	com/google/android/exoplayer2/h/a/k
    //   282: dup
    //   283: ldc2_w 130
    //   286: invokespecial 134	com/google/android/exoplayer2/h/a/k:<init>	(J)V
    //   289: invokevirtual 138	com/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/d:a	(Ljava/io/File;Lcom/google/android/exoplayer2/h/a/f;)Lcom/google/android/exoplayer2/h/a/a;
    //   292: putfield 140	com/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/d:dja	Lcom/google/android/exoplayer2/h/a/a;
    //   295: ldc 75
    //   297: ldc 142
    //   299: iconst_1
    //   300: anewarray 4	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: aload_1
    //   306: invokevirtual 116	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   309: invokestatic 122	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   312: aastore
    //   313: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: invokestatic 150	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   319: invokestatic 156	com/tencent/mm/plugin/appbrand/jsapi/video/e/c/k:eQ	(Landroid/content/Context;)Lcom/google/android/exoplayer2/h/g$a;
    //   322: astore_1
    //   323: new 158	com/google/android/exoplayer2/h/a/c
    //   326: dup
    //   327: aload_0
    //   328: getfield 140	com/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/d:dja	Lcom/google/android/exoplayer2/h/a/a;
    //   331: ldc2_w 159
    //   334: invokespecial 163	com/google/android/exoplayer2/h/a/c:<init>	(Lcom/google/android/exoplayer2/h/a/a;J)V
    //   337: astore_2
    //   338: aload_0
    //   339: new 165	com/google/android/exoplayer2/h/a/e
    //   342: dup
    //   343: aload_0
    //   344: getfield 140	com/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/d:dja	Lcom/google/android/exoplayer2/h/a/a;
    //   347: aload_1
    //   348: new 167	com/google/android/exoplayer2/h/r
    //   351: dup
    //   352: invokespecial 168	com/google/android/exoplayer2/h/r:<init>	()V
    //   355: aload_2
    //   356: iconst_2
    //   357: new 170	com/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/d$1
    //   360: dup
    //   361: aload_0
    //   362: invokespecial 173	com/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/d$1:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/d;)V
    //   365: invokespecial 176	com/google/android/exoplayer2/h/a/e:<init>	(Lcom/google/android/exoplayer2/h/a/a;Lcom/google/android/exoplayer2/h/g$a;Lcom/google/android/exoplayer2/h/g$a;Lcom/google/android/exoplayer2/h/f$a;ILcom/google/android/exoplayer2/h/a/d$a;)V
    //   368: putfield 178	com/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/d:sGZ	Lcom/google/android/exoplayer2/h/a/e;
    //   371: ldc 75
    //   373: ldc 180
    //   375: iconst_1
    //   376: anewarray 4	java/lang/Object
    //   379: dup
    //   380: iconst_0
    //   381: aload_0
    //   382: getfield 140	com/tencent/mm/plugin/appbrand/jsapi/video/e/c/a/d:dja	Lcom/google/android/exoplayer2/h/a/a;
    //   385: aastore
    //   386: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   389: ldc 23
    //   391: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	d
    //   29	161	1	localObject1	Object
    //   209	12	1	localObject2	Object
    //   228	27	1	str1	String
    //   258	90	1	localObject3	Object
    //   27	329	2	localObject4	Object
    //   23	114	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   79	85	209	finally
    //   149	203	228	finally
  }
  
  public static d cwX()
  {
    AppMethodBeat.i(328747);
    if (sHg == null) {}
    try
    {
      if (sHg == null) {
        sHg = new d();
      }
      d locald = sHg;
      AppMethodBeat.o(328747);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(328747);
    }
  }
  
  private void cwZ()
  {
    try
    {
      AppMethodBeat.i(328771);
      if (!this.sHi)
      {
        if ((this.dja != null) && (this.sGZ != null)) {
          this.sHh = new c(this.dja, this.sGZ);
        }
        this.sHi = true;
      }
      AppMethodBeat.o(328771);
      return;
    }
    finally {}
  }
  
  protected a a(File paramFile, com.google.android.exoplayer2.h.a.f paramf)
  {
    AppMethodBeat.i(328805);
    paramFile = new m(paramFile, paramf);
    AppMethodBeat.o(328805);
    return paramFile;
  }
  
  public final void bbB()
  {
    AppMethodBeat.i(328779);
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "register VideoCacheService#ExoVideoCacheHandler");
    AppMethodBeat.o(328779);
  }
  
  public final void bbC()
  {
    AppMethodBeat.i(328788);
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "unregister VideoCacheService#ExoVideoCacheHandler");
    AppMethodBeat.o(328788);
  }
  
  public final String cd(String paramString)
  {
    return paramString;
  }
  
  public final g.a cvB()
  {
    return this.sGZ;
  }
  
  public final g.a cvC()
  {
    AppMethodBeat.i(328818);
    cwZ();
    if (this.sHh != null)
    {
      localObject = this.sHh.sHb;
      AppMethodBeat.o(328818);
      return localObject;
    }
    Object localObject = this.sGZ;
    AppMethodBeat.o(328818);
    return localObject;
  }
  
  protected String cwY()
  {
    AppMethodBeat.i(328797);
    String str3 = MMApplicationContext.getProcessName();
    String str2 = "main";
    String str1 = str2;
    if (!Util.isNullOrNil(str3))
    {
      int i = str3.indexOf(":");
      str1 = str2;
      if (i >= 0)
      {
        str1 = str2;
        if (str3.length() >= i + 1) {
          str1 = str3.substring(i + 1);
        }
      }
    }
    AppMethodBeat.o(328797);
    return str1;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328839);
    if (this.dja == null)
    {
      Log.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cache is null");
      AppMethodBeat.o(328839);
      return 0L;
    }
    i.cvD();
    String str = i.abO(paramString);
    long l = this.dja.f(str, paramLong1, paramLong2);
    Log.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "getCachedBytes, cachedSize:%s, position:%s, length:%s, url:%s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
    AppMethodBeat.o(328839);
    return l;
  }
  
  public final void q(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328830);
    cwZ();
    if (this.sHh == null)
    {
      AppMethodBeat.o(328830);
      return;
    }
    this.sHh.q(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(328830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a.d
 * JD-Core Version:    0.7.0.1
 */