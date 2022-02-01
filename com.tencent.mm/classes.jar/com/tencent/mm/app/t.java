package com.tencent.mm.app;

import android.content.Context;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.performance.c.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.c;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.d;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.xweb.WebView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

public class t
  implements c, au.d
{
  private static final long cTZ;
  private static final Set<c.a> cUd;
  private static String cUk;
  private static final byte[] cUv;
  private static volatile ParcelFileDescriptor cUw;
  private static final String cUx;
  private static CrashMonitorForJni.a sCrashExtraMessageGetter;
  
  static
  {
    AppMethodBeat.i(19455);
    cTZ = bt.flT();
    cUk = "";
    cUv = new byte[] { 0 };
    cUw = null;
    cUd = new HashSet();
    cUx = "version:" + d.Fnj;
    sCrashExtraMessageGetter = new t.1();
    AppMethodBeat.o(19455);
  }
  
  public static boolean a(ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, String arg2)
  {
    AppMethodBeat.i(19447);
    cUk = ???;
    synchronized (cUv)
    {
      cUw = paramParcelFileDescriptor1;
      paramParcelFileDescriptor1 = new t();
      aj.getContext();
      au.a(paramParcelFileDescriptor1);
      com.tencent.mm.sdk.a.b.a(paramParcelFileDescriptor1);
      paramParcelFileDescriptor1 = af.get("ro.product.cpu.abi");
      if ((paramParcelFileDescriptor1 == null) || (paramParcelFileDescriptor1.length() == 0) || ((!paramParcelFileDescriptor1.equals("x86")) && (!paramParcelFileDescriptor1.equals("x86-64"))))
      {
        t.class.getClassLoader();
        com.tencent.mm.compatible.util.j.vr("wechatCrashForJni");
        CrashMonitorForJni.setCrashExtraMessageGetter(sCrashExtraMessageGetter);
        paramParcelFileDescriptor1 = cUx;
        paramParcelFileDescriptor1 = paramParcelFileDescriptor1 + "\n" + WebView.getCrashExtraMessage(aj.getContext()) + String.format(Locale.US, "client_version:%s;", new Object[] { i.hgG }) + "\n";
        ad.i("MicroMsg.MMIsolatedCrashReporter", "append crash extra message : %s", new Object[] { paramParcelFileDescriptor1 });
        CrashMonitorForJni.setClientVersionMsg(paramParcelFileDescriptor1);
        CrashMonitorForJni.setCrashRecordLowFd(paramParcelFileDescriptor2);
      }
      AppMethodBeat.o(19447);
      return false;
    }
  }
  
  private static void fl(String paramString)
  {
    AppMethodBeat.i(19448);
    try
    {
      while (paramString.length() > 896)
      {
        int i = paramString.substring(0, 896).lastIndexOf("\n");
        if (-1 == i) {
          break;
        }
        ad.e("MicroMsg.MMIsolatedCrashReporter", paramString.substring(0, i));
        paramString = paramString.substring(i + 1);
      }
      ad.e("MicroMsg.MMIsolatedCrashReporter", paramString);
      AppMethodBeat.o(19448);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.MMIsolatedCrashReporter", paramString, "Failed printing stack trace.", new Object[0]);
      AppMethodBeat.o(19448);
    }
  }
  
  private static String fn(String paramString)
  {
    AppMethodBeat.i(19453);
    StringBuilder localStringBuilder = new StringBuilder(256);
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    Object localObject1 = aj.getContext();
    localStringBuilderPrinter.println("#client.version=" + d.Fnj);
    localStringBuilderPrinter.println("#client.verhistory=" + cj.oF(4));
    localStringBuilderPrinter.println("#client.imei=0123456789ABCDEF");
    localStringBuilderPrinter.println("#accinfo.revision=" + i.REV);
    localStringBuilderPrinter.println("#accinfo.uin=0");
    localStringBuilderPrinter.println("#accinfo.dev=");
    localStringBuilderPrinter.println("#accinfo.runtime=" + (bt.flT() - cTZ) + "(" + bt.nullAsNil(cUk) + ")");
    localStringBuilderPrinter.println("#accinfo.build=" + i.TIME + ":" + i.HOSTNAME + ":" + com.tencent.mm.sdk.platformtools.j.cSc);
    localStringBuilderPrinter.println("#qbrwoser.corever=" + WebView.getInstalledTbsCoreVersion((Context)localObject1));
    localStringBuilderPrinter.println("#qbrowser.ver=" + WebView.getTbsSDKVersion((Context)localObject1));
    localStringBuilderPrinter.println("#xsdkver=200801");
    try
    {
      localStringBuilderPrinter.println("#xcorever=" + XWalkEnvironment.getInstalledNewstVersion(aj.getContext()));
      localStringBuilderPrinter.println("#syswebcore=" + XWalkEnvironment.safeGetChromiunVersion());
      ad.i("MicroMsg.MMIsolatedCrashReporter", "Activity dump before crash report, [%s]", new Object[] { com.tencent.mm.ae.a.akR() });
      localStringBuilderPrinter.println(sCrashExtraMessageGetter.Mj());
      Object localObject2 = new StringBuilder("#accinfo.env=");
      if (com.tencent.mm.sdk.a.b.foreground)
      {
        localObject1 = "f";
        localStringBuilderPrinter.println((String)localObject1 + ":" + Thread.currentThread().getName() + ":" + com.tencent.mm.sdk.a.b.IbD);
        localObject1 = "";
      }
      try
      {
        localObject2 = new StatFs(Environment.getDataDirectory().getPath());
        StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.arO());
        localObject2 = String.format("%s:%d:%d:%d %s:%d:%d:%d", new Object[] { Environment.getDataDirectory().getAbsolutePath(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()), com.tencent.mm.loader.j.b.arO(), Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          long l1;
          long l2;
          int i;
          int j;
          String str;
          ad.e("MicroMsg.MMIsolatedCrashReporter", "check data size failed :%s", new Object[] { localException2.getMessage() });
        }
      }
      localStringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(localObject1)));
      localObject1 = new Date();
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
      localStringBuilderPrinter.println("#accinfo.crashTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
      l1 = Runtime.getRuntime().totalMemory();
      l2 = Runtime.getRuntime().freeMemory();
      localObject1 = String.format("Runtime Mem[%s:%s:%s:%s] vmSize:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l1 - l2), Long.valueOf(Runtime.getRuntime().maxMemory()), LogLogic.getVmSize() });
      localObject2 = "" + (String)localObject1;
      i = e.IS();
      localObject1 = localObject2;
      if (i > 260)
      {
        localObject1 = new LinkedList();
        j = e.eK((List)localObject1);
        localObject1 = (String)localObject2 + String.format("[threadInfo(%s:%s) %s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), localObject1 });
      }
      localStringBuilderPrinter.println("#accinfo.memory=".concat(String.valueOf(localObject1)));
      if (!bt.isNullOrNil(paramString)) {
        localStringBuilderPrinter.println("#".concat(String.valueOf(paramString)));
      }
      localStringBuilderPrinter.println("#crashContent=");
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(19453);
      return paramString;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ad.e("MicroMsg.MMIsolatedCrashReporter", "get syswebcore failed: " + localException1.getMessage());
        continue;
        str = "b";
      }
    }
  }
  
  /* Error */
  public final void O(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 19450
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 468	java/lang/String:isEmpty	()Z
    //   14: ifeq +10 -> 24
    //   17: sipush 19450
    //   20: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: getstatic 44	com/tencent/mm/app/t:cUv	[B
    //   27: astore 5
    //   29: aload 5
    //   31: monitorenter
    //   32: getstatic 46	com/tencent/mm/app/t:cUw	Landroid/os/ParcelFileDescriptor;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnull +44 -> 81
    //   40: new 470	java/io/PrintWriter
    //   43: dup
    //   44: new 472	java/io/FileWriter
    //   47: dup
    //   48: getstatic 46	com/tencent/mm/app/t:cUw	Landroid/os/ParcelFileDescriptor;
    //   51: invokevirtual 478	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   54: invokespecial 481	java/io/FileWriter:<init>	(Ljava/io/FileDescriptor;)V
    //   57: invokespecial 484	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   60: astore_3
    //   61: aload_3
    //   62: astore_2
    //   63: aload_3
    //   64: getstatic 76	com/tencent/mm/app/t:cUx	Ljava/lang/String;
    //   67: invokevirtual 487	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   70: aload_3
    //   71: astore_2
    //   72: aload_3
    //   73: aload_1
    //   74: invokevirtual 488	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   77: aload_3
    //   78: invokestatic 492	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   81: aload 5
    //   83: monitorexit
    //   84: sipush 19450
    //   87: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: return
    //   91: astore 4
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: astore_2
    //   97: ldc 177
    //   99: aload 4
    //   101: ldc_w 494
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 215	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_1
    //   112: invokestatic 492	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   115: goto -34 -> 81
    //   118: astore_1
    //   119: aload 5
    //   121: monitorexit
    //   122: sipush 19450
    //   125: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_2
    //   134: invokestatic 492	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   137: sipush 19450
    //   140: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: goto -13 -> 133
    //   149: astore 4
    //   151: aload_3
    //   152: astore_1
    //   153: goto -58 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	t
    //   0	156	1	paramString1	String
    //   0	156	2	paramString2	String
    //   60	92	3	localPrintWriter	java.io.PrintWriter
    //   91	9	4	localThrowable1	java.lang.Throwable
    //   149	1	4	localThrowable2	java.lang.Throwable
    //   27	93	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   40	61	91	java/lang/Throwable
    //   32	36	118	finally
    //   77	81	118	finally
    //   81	84	118	finally
    //   111	115	118	finally
    //   119	122	118	finally
    //   133	145	118	finally
    //   40	61	130	finally
    //   63	70	145	finally
    //   72	77	145	finally
    //   97	111	145	finally
    //   63	70	149	java/lang/Throwable
    //   72	77	149	java/lang/Throwable
  }
  
  public final void P(String paramString1, String paramString2) {}
  
  public final void a(com.tencent.mm.sdk.a.a parama)
  {
    AppMethodBeat.i(19451);
    au.a(parama);
    AppMethodBeat.o(19451);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(19454);
    if (parama == null)
    {
      AppMethodBeat.o(19454);
      return;
    }
    cUd.add(parama);
    AppMethodBeat.o(19454);
  }
  
  /* Error */
  public final void b(au paramau, String paramString, java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: sipush 19452
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_3
    //   7: instanceof 507
    //   10: ifeq +254 -> 264
    //   13: aload_3
    //   14: invokevirtual 508	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   17: astore_3
    //   18: aload_3
    //   19: invokestatic 446	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   22: ifne +242 -> 264
    //   25: aload_1
    //   26: aload_3
    //   27: invokevirtual 511	com/tencent/mm/sdk/platformtools/au:aQx	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_1
    //   31: aload_1
    //   32: invokestatic 446	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifne +229 -> 264
    //   38: new 55	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   45: aload_1
    //   46: invokestatic 513	com/tencent/mm/app/t:fn	(Ljava/lang/String;)Ljava/lang/String;
    //   49: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_2
    //   53: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +10 -> 71
    //   64: aload_1
    //   65: invokevirtual 468	java/lang/String:isEmpty	()Z
    //   68: ifeq +10 -> 78
    //   71: sipush 19452
    //   74: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: return
    //   78: aload_1
    //   79: invokestatic 518	com/tencent/smtt/sdk/QbSdk:replaceLibraryName	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 5
    //   84: aload 5
    //   86: invokestatic 520	com/tencent/mm/app/t:fl	(Ljava/lang/String;)V
    //   89: getstatic 44	com/tencent/mm/app/t:cUv	[B
    //   92: astore 6
    //   94: aload 6
    //   96: monitorenter
    //   97: getstatic 46	com/tencent/mm/app/t:cUw	Landroid/os/ParcelFileDescriptor;
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +88 -> 190
    //   105: aconst_null
    //   106: astore 4
    //   108: aconst_null
    //   109: astore_3
    //   110: aload 5
    //   112: astore_2
    //   113: aload 4
    //   115: astore_1
    //   116: aload 5
    //   118: invokevirtual 119	java/lang/String:length	()I
    //   121: sipush 3072
    //   124: if_icmple +16 -> 140
    //   127: aload 4
    //   129: astore_1
    //   130: aload 5
    //   132: iconst_0
    //   133: sipush 3072
    //   136: invokevirtual 198	java/lang/String:substring	(II)Ljava/lang/String;
    //   139: astore_2
    //   140: aload 4
    //   142: astore_1
    //   143: aload_2
    //   144: invokevirtual 523	java/lang/String:trim	()Ljava/lang/String;
    //   147: astore 5
    //   149: aload 4
    //   151: astore_1
    //   152: new 470	java/io/PrintWriter
    //   155: dup
    //   156: new 472	java/io/FileWriter
    //   159: dup
    //   160: getstatic 46	com/tencent/mm/app/t:cUw	Landroid/os/ParcelFileDescriptor;
    //   163: invokevirtual 478	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   166: invokespecial 481	java/io/FileWriter:<init>	(Ljava/io/FileDescriptor;)V
    //   169: invokespecial 484	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   172: astore_2
    //   173: aload_2
    //   174: getstatic 76	com/tencent/mm/app/t:cUx	Ljava/lang/String;
    //   177: invokevirtual 487	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   180: aload_2
    //   181: aload 5
    //   183: invokevirtual 488	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   186: aload_2
    //   187: invokestatic 492	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   190: aload 6
    //   192: monitorexit
    //   193: sipush 19452
    //   196: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: return
    //   200: astore_1
    //   201: aload_3
    //   202: astore_2
    //   203: aload_1
    //   204: astore_3
    //   205: aload_2
    //   206: astore_1
    //   207: ldc 177
    //   209: aload_3
    //   210: ldc_w 494
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 215	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload_2
    //   221: invokestatic 492	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   224: goto -34 -> 190
    //   227: astore_1
    //   228: aload 6
    //   230: monitorexit
    //   231: sipush 19452
    //   234: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_1
    //   238: athrow
    //   239: astore_3
    //   240: aload_1
    //   241: astore_2
    //   242: aload_3
    //   243: astore_1
    //   244: aload_2
    //   245: invokestatic 492	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   248: sipush 19452
    //   251: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: aload_1
    //   255: athrow
    //   256: astore_1
    //   257: goto -13 -> 244
    //   260: astore_3
    //   261: goto -56 -> 205
    //   264: ldc 40
    //   266: astore_1
    //   267: goto -229 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	t
    //   0	270	1	paramau	au
    //   0	270	2	paramString	String
    //   0	270	3	paramThrowable	java.lang.Throwable
    //   106	44	4	localObject	Object
    //   82	100	5	str	String
    //   92	137	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   116	127	200	java/lang/Throwable
    //   130	140	200	java/lang/Throwable
    //   143	149	200	java/lang/Throwable
    //   152	173	200	java/lang/Throwable
    //   97	101	227	finally
    //   186	190	227	finally
    //   190	193	227	finally
    //   220	224	227	finally
    //   228	231	227	finally
    //   244	256	227	finally
    //   116	127	239	finally
    //   130	140	239	finally
    //   143	149	239	finally
    //   152	173	239	finally
    //   207	220	239	finally
    //   173	186	256	finally
    //   173	186	260	java/lang/Throwable
  }
  
  public final void bp(Context paramContext)
  {
    AppMethodBeat.i(221372);
    au.a(this);
    AppMethodBeat.o(221372);
  }
  
  public final void d(int paramInt, String paramString1, String paramString2) {}
  
  public final void fm(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.t
 * JD-Core Version:    0.7.0.1
 */