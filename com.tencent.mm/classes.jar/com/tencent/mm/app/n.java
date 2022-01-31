package com.tencent.mm.app;

import android.content.Context;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ad;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.c;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;
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

public class n
  implements c, ao.d
{
  private static final byte[] bYD;
  private static volatile ParcelFileDescriptor bYE;
  private static final long bYl;
  private static final Set<c.a> bYp;
  private static String bYw;
  private static final String bYx;
  private static CrashMonitorForJni.a sCrashExtraMessageGetter;
  
  static
  {
    AppMethodBeat.i(153471);
    bYl = bo.aoy();
    bYw = "";
    bYD = new byte[] { 0 };
    bYE = null;
    bYp = new HashSet();
    bYx = "version:" + d.whH;
    sCrashExtraMessageGetter = new n.1();
    AppMethodBeat.o(153471);
  }
  
  public static boolean a(ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, String arg2)
  {
    AppMethodBeat.i(153464);
    bYw = ???;
    synchronized (bYD)
    {
      bYE = paramParcelFileDescriptor1;
      paramParcelFileDescriptor1 = new n();
      ah.getContext();
      ao.a(paramParcelFileDescriptor1);
      com.tencent.mm.sdk.a.b.a(paramParcelFileDescriptor1);
      paramParcelFileDescriptor1 = ad.get("ro.product.cpu.abi");
      if ((paramParcelFileDescriptor1 == null) || (paramParcelFileDescriptor1.length() == 0) || ((!paramParcelFileDescriptor1.equals("x86")) && (!paramParcelFileDescriptor1.equals("x86-64"))))
      {
        k.a("wechatCrashForJni", n.class.getClassLoader());
        CrashMonitorForJni.setCrashExtraMessageGetter(sCrashExtraMessageGetter);
        paramParcelFileDescriptor1 = bYx;
        paramParcelFileDescriptor1 = paramParcelFileDescriptor1 + "\n" + WebView.getCrashExtraMessage(ah.getContext()) + String.format(Locale.US, "client_version:%s;", new Object[] { f.CLIENT_VERSION }) + "\n";
        ab.i("MicroMsg.MMIsolatedCrashReporter", "append crash extra message : %s", new Object[] { paramParcelFileDescriptor1 });
        CrashMonitorForJni.setClientVersionMsg(paramParcelFileDescriptor1);
        CrashMonitorForJni.setCrashRecordLowFd(paramParcelFileDescriptor2);
      }
      AppMethodBeat.o(153464);
      return false;
    }
  }
  
  private static void dx(String paramString)
  {
    AppMethodBeat.i(153465);
    try
    {
      while (paramString.length() > 896)
      {
        int i = paramString.substring(0, 896).lastIndexOf("\n");
        if (-1 == i) {
          break;
        }
        ab.e("MicroMsg.MMIsolatedCrashReporter", paramString.substring(0, i));
        paramString = paramString.substring(i + 1);
      }
      ab.e("MicroMsg.MMIsolatedCrashReporter", paramString);
      AppMethodBeat.o(153465);
      return;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.MMIsolatedCrashReporter", paramString, "Failed printing stack trace.", new Object[0]);
      AppMethodBeat.o(153465);
    }
  }
  
  private static String dy(String paramString)
  {
    AppMethodBeat.i(153470);
    StringBuilder localStringBuilder = new StringBuilder(256);
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    Object localObject1 = ah.getContext();
    localStringBuilderPrinter.println("#client.version=" + d.whH);
    localStringBuilderPrinter.println("#client.verhistory=" + cf.abt());
    localStringBuilderPrinter.println("#client.imei=0123456789ABCDEF");
    localStringBuilderPrinter.println("#accinfo.revision=" + f.REV);
    localStringBuilderPrinter.println("#accinfo.uin=0");
    localStringBuilderPrinter.println("#accinfo.dev=");
    localStringBuilderPrinter.println("#accinfo.runtime=" + (bo.aoy() - bYl) + "(" + bo.nullAsNil(bYw) + ")");
    localStringBuilderPrinter.println("#accinfo.build=" + f.TIME + ":" + f.HOSTNAME + ":" + g.bWu);
    localStringBuilderPrinter.println("#qbrwoser.corever=" + WebView.getInstalledTbsCoreVersion((Context)localObject1));
    localStringBuilderPrinter.println("#qbrowser.ver=" + WebView.getTbsSDKVersion((Context)localObject1));
    localStringBuilderPrinter.println("#xsdkver=190503");
    try
    {
      localStringBuilderPrinter.println("#xcorever=" + XWalkEnvironment.getInstalledNewstVersion(ah.getContext()));
      localStringBuilderPrinter.println("#syswebcore=" + XWalkEnvironment.safeGetChromiunVersion());
      ab.i("MicroMsg.MMIsolatedCrashReporter", "Activity dump before crash report, [%s]", new Object[] { com.tencent.mm.ac.a.SU() });
      localStringBuilderPrinter.println(sCrashExtraMessageGetter.Bt());
      Object localObject2 = new StringBuilder("#accinfo.env=");
      if (com.tencent.mm.sdk.a.b.foreground)
      {
        localObject1 = "f";
        localStringBuilderPrinter.println((String)localObject1 + ":" + Thread.currentThread().getName() + ":" + com.tencent.mm.sdk.a.b.ymf);
        localObject1 = "";
      }
      try
      {
        localObject2 = Environment.getDataDirectory();
        StatFs localStatFs1 = new StatFs(((File)localObject2).getPath());
        StatFs localStatFs2 = new StatFs(e.eQx);
        localObject2 = String.format("%s:%d:%d:%d %s:%d:%d:%d", new Object[] { ((File)localObject2).getAbsolutePath(), Integer.valueOf(localStatFs1.getBlockSize()), Integer.valueOf(localStatFs1.getBlockCount()), Integer.valueOf(localStatFs1.getAvailableBlocks()), e.eQx, Integer.valueOf(localStatFs2.getBlockSize()), Integer.valueOf(localStatFs2.getBlockCount()), Integer.valueOf(localStatFs2.getAvailableBlocks()) });
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
          ab.e("MicroMsg.MMIsolatedCrashReporter", "check data size failed :%s", new Object[] { localException2.getMessage() });
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
      i = com.tencent.mm.plugin.performance.b.b.zq();
      localObject1 = localObject2;
      if (i > 260)
      {
        localObject1 = new LinkedList();
        j = com.tencent.mm.plugin.performance.b.b.cw((List)localObject1);
        localObject1 = (String)localObject2 + String.format("[threadInfo(%s:%s) %s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), localObject1 });
      }
      localStringBuilderPrinter.println("#accinfo.memory=".concat(String.valueOf(localObject1)));
      if (!bo.isNullOrNil(paramString)) {
        localStringBuilderPrinter.println("#".concat(String.valueOf(paramString)));
      }
      localStringBuilderPrinter.println("#crashContent=");
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(153470);
      return paramString;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMIsolatedCrashReporter", "get syswebcore failed: " + localException1.getMessage());
        continue;
        str = "b";
      }
    }
  }
  
  /* Error */
  public final void G(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 469
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokevirtual 473	java/lang/String:isEmpty	()Z
    //   14: ifeq +10 -> 24
    //   17: ldc_w 469
    //   20: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: getstatic 45	com/tencent/mm/app/n:bYD	[B
    //   27: astore 5
    //   29: aload 5
    //   31: monitorenter
    //   32: getstatic 47	com/tencent/mm/app/n:bYE	Landroid/os/ParcelFileDescriptor;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnull +44 -> 81
    //   40: new 475	java/io/PrintWriter
    //   43: dup
    //   44: new 477	java/io/FileWriter
    //   47: dup
    //   48: getstatic 47	com/tencent/mm/app/n:bYE	Landroid/os/ParcelFileDescriptor;
    //   51: invokevirtual 483	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   54: invokespecial 486	java/io/FileWriter:<init>	(Ljava/io/FileDescriptor;)V
    //   57: invokespecial 489	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   60: astore_3
    //   61: aload_3
    //   62: astore_2
    //   63: aload_3
    //   64: getstatic 77	com/tencent/mm/app/n:bYx	Ljava/lang/String;
    //   67: invokevirtual 492	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   70: aload_3
    //   71: astore_2
    //   72: aload_3
    //   73: aload_1
    //   74: invokevirtual 493	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   77: aload_3
    //   78: invokestatic 496	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   81: aload 5
    //   83: monitorexit
    //   84: ldc_w 469
    //   87: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: return
    //   91: astore 4
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: astore_2
    //   97: ldc 179
    //   99: aload 4
    //   101: ldc_w 498
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 218	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_1
    //   112: invokestatic 496	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   115: goto -34 -> 81
    //   118: astore_1
    //   119: aload 5
    //   121: monitorexit
    //   122: ldc_w 469
    //   125: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_2
    //   134: invokestatic 496	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   137: ldc_w 469
    //   140: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	156	0	this	n
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
  
  public final void a(com.tencent.mm.sdk.a.a parama)
  {
    AppMethodBeat.i(153468);
    ao.a(parama);
    AppMethodBeat.o(153468);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(155401);
    if (parama == null)
    {
      AppMethodBeat.o(155401);
      return;
    }
    bYp.add(parama);
    AppMethodBeat.o(155401);
  }
  
  /* Error */
  public final void a(ao paramao, String paramString, java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc_w 511
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_3
    //   7: instanceof 513
    //   10: ifeq +254 -> 264
    //   13: aload_3
    //   14: invokevirtual 514	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   17: astore_3
    //   18: aload_3
    //   19: invokestatic 450	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   22: ifne +242 -> 264
    //   25: aload_1
    //   26: aload_3
    //   27: invokevirtual 517	com/tencent/mm/sdk/platformtools/ao:apo	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_1
    //   31: aload_1
    //   32: invokestatic 450	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifne +229 -> 264
    //   38: new 56	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   45: aload_1
    //   46: invokestatic 519	com/tencent/mm/app/n:dy	(Ljava/lang/String;)Ljava/lang/String;
    //   49: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_2
    //   53: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +10 -> 71
    //   64: aload_1
    //   65: invokevirtual 473	java/lang/String:isEmpty	()Z
    //   68: ifeq +10 -> 78
    //   71: ldc_w 511
    //   74: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: return
    //   78: aload_1
    //   79: invokestatic 524	com/tencent/smtt/sdk/QbSdk:replaceLibraryName	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 5
    //   84: aload 5
    //   86: invokestatic 526	com/tencent/mm/app/n:dx	(Ljava/lang/String;)V
    //   89: getstatic 45	com/tencent/mm/app/n:bYD	[B
    //   92: astore 6
    //   94: aload 6
    //   96: monitorenter
    //   97: getstatic 47	com/tencent/mm/app/n:bYE	Landroid/os/ParcelFileDescriptor;
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
    //   118: invokevirtual 121	java/lang/String:length	()I
    //   121: sipush 3072
    //   124: if_icmple +16 -> 140
    //   127: aload 4
    //   129: astore_1
    //   130: aload 5
    //   132: iconst_0
    //   133: sipush 3072
    //   136: invokevirtual 201	java/lang/String:substring	(II)Ljava/lang/String;
    //   139: astore_2
    //   140: aload 4
    //   142: astore_1
    //   143: aload_2
    //   144: invokevirtual 529	java/lang/String:trim	()Ljava/lang/String;
    //   147: astore 5
    //   149: aload 4
    //   151: astore_1
    //   152: new 475	java/io/PrintWriter
    //   155: dup
    //   156: new 477	java/io/FileWriter
    //   159: dup
    //   160: getstatic 47	com/tencent/mm/app/n:bYE	Landroid/os/ParcelFileDescriptor;
    //   163: invokevirtual 483	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   166: invokespecial 486	java/io/FileWriter:<init>	(Ljava/io/FileDescriptor;)V
    //   169: invokespecial 489	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   172: astore_2
    //   173: aload_2
    //   174: getstatic 77	com/tencent/mm/app/n:bYx	Ljava/lang/String;
    //   177: invokevirtual 492	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   180: aload_2
    //   181: aload 5
    //   183: invokevirtual 493	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   186: aload_2
    //   187: invokestatic 496	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   190: aload 6
    //   192: monitorexit
    //   193: ldc_w 511
    //   196: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: return
    //   200: astore_1
    //   201: aload_3
    //   202: astore_2
    //   203: aload_1
    //   204: astore_3
    //   205: aload_2
    //   206: astore_1
    //   207: ldc 179
    //   209: aload_3
    //   210: ldc_w 498
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 218	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload_2
    //   221: invokestatic 496	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   224: goto -34 -> 190
    //   227: astore_1
    //   228: aload 6
    //   230: monitorexit
    //   231: ldc_w 511
    //   234: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_1
    //   238: athrow
    //   239: astore_3
    //   240: aload_1
    //   241: astore_2
    //   242: aload_3
    //   243: astore_1
    //   244: aload_2
    //   245: invokestatic 496	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   248: ldc_w 511
    //   251: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: aload_1
    //   255: athrow
    //   256: astore_1
    //   257: goto -13 -> 244
    //   260: astore_3
    //   261: goto -56 -> 205
    //   264: ldc 41
    //   266: astore_1
    //   267: goto -229 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	n
    //   0	270	1	paramao	ao
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
  
  public final void bc(Context paramContext)
  {
    AppMethodBeat.i(156898);
    ao.a(this);
    AppMethodBeat.o(156898);
  }
  
  public final void k(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.n
 * JD-Core Version:    0.7.0.1
 */