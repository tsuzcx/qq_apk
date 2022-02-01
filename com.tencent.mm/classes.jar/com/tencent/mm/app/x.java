package com.tencent.mm.app;

import android.content.Context;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.model.cr;
import com.tencent.mm.plugin.performance.watchdogs.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.crash.CallbackForReset;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.crash.ICrashReporter;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportListener;
import com.tencent.mm.sdk.crash.ISubReporter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.CrashExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IReporter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.ao;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import junit.framework.AssertionFailedError;

public final class x
  implements ICrashReporter, MMUncaughtExceptionHandler.IReporter
{
  private static final long hgL;
  private static final Set<ICrashReporter.ICrashReportExtraMessageGetter> hgP;
  private static final Set<ICrashReporter.ICrashReportListener> hgQ;
  private static String hgV;
  private static final ParcelFileDescriptor[] hhk;
  private static final ParcelFileDescriptor[] hhl;
  private static final String hhm;
  private static final CrashMonitorForJni.CrashExtraMessageGetter sCrashExtraMessageGetter;
  
  static
  {
    AppMethodBeat.i(19455);
    hgL = Util.nowMilliSecond();
    hgV = "";
    hhk = new ParcelFileDescriptor[] { null };
    hhl = new ParcelFileDescriptor[] { null };
    hgP = new HashSet();
    hgQ = new HashSet();
    hhm = "version:" + d.Yxh;
    sCrashExtraMessageGetter = new x.1();
    AppMethodBeat.o(19455);
  }
  
  public static boolean a(ParcelFileDescriptor arg0, ParcelFileDescriptor paramParcelFileDescriptor2, String arg2)
  {
    AppMethodBeat.i(19447);
    new StringBuilder("setup: ").append(???);
    hgV = ???;
    synchronized (hhk)
    {
      hhk[0] = ???;
    }
    synchronized (hhl)
    {
      hhl[0] = paramParcelFileDescriptor2;
      ??? = new x();
      ???.init(MMApplicationContext.getContext(), false);
      CrashReportFactory.setupCrashReporter(???);
      com.tencent.mm.crash.a.b(hhl[0]);
      AppMethodBeat.o(19447);
      return false;
      ??? = finally;
      AppMethodBeat.o(19447);
      throw ???;
    }
  }
  
  public static String g(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(239321);
    paramContext = new File(new File(paramContext.getFilesDir(), "crash"), "java_" + paramString1.replace(':', '_') + "_" + System.currentTimeMillis() + "_" + paramString2 + ".dmp");
    if (!paramContext.exists()) {
      paramContext.getParentFile().mkdirs();
    }
    paramContext = paramContext.getAbsolutePath();
    AppMethodBeat.o(239321);
    return paramContext;
  }
  
  public static String h(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(239325);
    paramContext = new File(new File(paramContext.getFilesDir(), "crash"), "NativeCrash_" + paramString1.replace(':', '_') + "_" + System.currentTimeMillis() + "_" + paramString2 + ".dmp");
    if (!paramContext.exists()) {
      paramContext.getParentFile().mkdirs();
    }
    paramContext = paramContext.getAbsolutePath();
    AppMethodBeat.o(239325);
    return paramContext;
  }
  
  private static void io(String paramString)
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
        Log.e("MicroMsg.MMIsolatedCrashReporter", paramString.substring(0, i));
        paramString = paramString.substring(i + 1);
      }
      Log.e("MicroMsg.MMIsolatedCrashReporter", paramString);
      AppMethodBeat.o(19448);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.MMIsolatedCrashReporter", paramString, "Failed printing stack trace.", new Object[0]);
      AppMethodBeat.o(19448);
    }
  }
  
  private static String iq(String paramString)
  {
    AppMethodBeat.i(19453);
    StringBuilder localStringBuilder = new StringBuilder(256);
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    Object localObject1 = MMApplicationContext.getContext();
    localStringBuilderPrinter.println("#client.version=" + d.Yxh);
    localStringBuilderPrinter.println("#client.verhistory=" + cr.vq(4));
    localStringBuilderPrinter.println("#client.imei=0123456789ABCDEF");
    localStringBuilderPrinter.println("#accinfo.revision=" + BuildInfo.REV);
    localStringBuilderPrinter.println("#accinfo.uin=0");
    localStringBuilderPrinter.println("#accinfo.dev=");
    localStringBuilderPrinter.println("#accinfo.runtime=" + (Util.nowMilliSecond() - hgL) + "(" + Util.nullAsNil(hgV) + ")");
    localStringBuilderPrinter.println("#accinfo.build=" + BuildInfo.TIME + ":" + BuildInfo.HOSTNAME + ":" + ChannelUtil.channelId);
    localStringBuilderPrinter.println("#qbrwoser.corever=" + ao.getInstalledTbsCoreVersion((Context)localObject1));
    localStringBuilderPrinter.println("#qbrowser.ver=" + ao.getTbsSDKVersion((Context)localObject1));
    localStringBuilderPrinter.println("#xsdkver=" + ao.kge());
    try
    {
      localStringBuilderPrinter.println("#xcorever=" + ao.getInstalledNewstVersion(MMApplicationContext.getContext()));
      localStringBuilderPrinter.println("#syswebcore=" + ao.kgg());
      Log.i("MicroMsg.MMIsolatedCrashReporter", "Activity dump before crash report, [%s]", new Object[] { com.tencent.mm.ag.a.bbZ() });
      localStringBuilderPrinter.println(sCrashExtraMessageGetter.getExtraMessage());
      Object localObject2 = new StringBuilder("#accinfo.env=");
      if (CrashReportFactory.foreground)
      {
        localObject1 = "f";
        localStringBuilderPrinter.println((String)localObject1 + ":" + Thread.currentThread().getName() + ":" + CrashReportFactory.currentActivity);
        localObject1 = "";
      }
      try
      {
        localObject2 = new StatFs(Environment.getDataDirectory().getPath());
        StatFs localStatFs = new StatFs(b.bmt());
        localObject2 = String.format("%s:%d:%d:%d %s:%d:%d:%d", new Object[] { Environment.getDataDirectory().getAbsolutePath(), Integer.valueOf(((StatFs)localObject2).getBlockSize()), Integer.valueOf(((StatFs)localObject2).getBlockCount()), Integer.valueOf(((StatFs)localObject2).getAvailableBlocks()), b.bmt(), Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
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
          Log.e("MicroMsg.MMIsolatedCrashReporter", "check data size failed :%s", new Object[] { localException2.getMessage() });
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
      i = f.gzF();
      localObject1 = localObject2;
      if (i > 260)
      {
        j = f.gzD();
        localObject1 = (String)localObject2 + String.format("[threadInfo(%s:%s) %s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), f.gzG() });
      }
      localStringBuilderPrinter.println("#accinfo.memory=".concat(String.valueOf(localObject1)));
      if (!Util.isNullOrNil(paramString)) {
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
        Log.e("MicroMsg.MMIsolatedCrashReporter", "get syswebcore failed: " + localException1.getMessage());
        continue;
        str = "b";
      }
    }
  }
  
  public final void addCrashReportListener(ICrashReporter.ICrashReportListener paramICrashReportListener)
  {
    AppMethodBeat.i(239359);
    if (paramICrashReportListener == null)
    {
      AppMethodBeat.o(239359);
      return;
    }
    hgQ.add(paramICrashReportListener);
    AppMethodBeat.o(239359);
  }
  
  public final void addExtraMessageGetter(ICrashReporter.ICrashReportExtraMessageGetter paramICrashReportExtraMessageGetter)
  {
    AppMethodBeat.i(19454);
    if (paramICrashReportExtraMessageGetter == null)
    {
      AppMethodBeat.o(19454);
      return;
    }
    hgP.add(paramICrashReportExtraMessageGetter);
    AppMethodBeat.o(19454);
  }
  
  public final void init(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(239342);
    MMUncaughtExceptionHandler.setReporter(this);
    AppMethodBeat.o(239342);
  }
  
  public final void removeCrashReportListener(ICrashReporter.ICrashReportListener paramICrashReportListener)
  {
    AppMethodBeat.i(239361);
    if (paramICrashReportListener == null)
    {
      AppMethodBeat.o(239361);
      return;
    }
    hgQ.remove(paramICrashReportListener);
    AppMethodBeat.o(239361);
  }
  
  public final void reportCrashMessage(String paramString1, String paramString2) {}
  
  public final void reportException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(19452);
    if ((paramThrowable instanceof AssertionFailedError))
    {
      paramThrowable = paramThrowable.getMessage();
      if (!Util.isNullOrNil(paramThrowable))
      {
        paramMMUncaughtExceptionHandler = paramMMUncaughtExceptionHandler.getReportByAssertPrefix(paramThrowable);
        if (Util.isNullOrNil(paramMMUncaughtExceptionHandler)) {}
      }
    }
    for (;;)
    {
      paramMMUncaughtExceptionHandler = iq(paramMMUncaughtExceptionHandler) + paramString;
      if ((paramMMUncaughtExceptionHandler == null) || (paramMMUncaughtExceptionHandler.isEmpty()))
      {
        AppMethodBeat.o(19452);
        return;
      }
      paramThrowable = QbSdk.replaceLibraryName(paramMMUncaughtExceptionHandler);
      io(paramThrowable);
      synchronized (hhk)
      {
        paramMMUncaughtExceptionHandler = hhk[0];
        if (paramMMUncaughtExceptionHandler != null)
        {
          paramString = null;
          paramMMUncaughtExceptionHandler = paramThrowable;
        }
        try
        {
          if (paramThrowable.length() > 3072) {
            paramMMUncaughtExceptionHandler = paramThrowable.substring(0, 3072);
          }
          paramThrowable = paramMMUncaughtExceptionHandler.trim();
          paramMMUncaughtExceptionHandler = new PrintWriter(new FileWriter(hhk[0].getFileDescriptor()));
          try
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.MMIsolatedCrashReporter", paramString, "writeException", new Object[0]);
              Util.qualityClose(paramMMUncaughtExceptionHandler);
            }
          }
          finally
          {
            Util.qualityClose(paramMMUncaughtExceptionHandler);
            AppMethodBeat.o(19452);
          }
        }
        finally
        {
          try
          {
            paramMMUncaughtExceptionHandler.print(hhm);
            paramMMUncaughtExceptionHandler.println(paramThrowable);
            Util.qualityClose(paramMMUncaughtExceptionHandler);
            AppMethodBeat.o(19452);
            return;
          }
          finally {}
          paramThrowable = finally;
          paramMMUncaughtExceptionHandler = paramString;
          paramString = paramThrowable;
        }
      }
      paramMMUncaughtExceptionHandler = "";
    }
  }
  
  public final void reportJniCrash(int paramInt, String paramString1, String paramString2) {}
  
  public final void reportRawMessage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19450);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      AppMethodBeat.o(19450);
      return;
    }
    synchronized (hhk)
    {
      paramString2 = hhk[0];
      if (paramString2 != null) {}
      try
      {
        localPrintWriter = new PrintWriter(new FileWriter(hhk[0].getFileDescriptor()));
        try
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.MMIsolatedCrashReporter", paramString2, "reportRawMessage", new Object[0]);
            Util.qualityClose(paramString1);
          }
        }
        finally
        {
          Util.qualityClose(paramString1);
          AppMethodBeat.o(19450);
        }
      }
      finally
      {
        try
        {
          localPrintWriter.print(hhm);
          localPrintWriter.println(paramString1);
          Util.qualityClose(localPrintWriter);
          AppMethodBeat.o(19450);
          return;
        }
        finally
        {
          PrintWriter localPrintWriter;
          paramString1 = localPrintWriter;
        }
        paramString2 = finally;
        paramString1 = null;
      }
    }
  }
  
  public final void setCallbackForReset(CallbackForReset paramCallbackForReset)
  {
    AppMethodBeat.i(19451);
    MMUncaughtExceptionHandler.setCallbackForReset(paramCallbackForReset);
    AppMethodBeat.o(19451);
  }
  
  public final void setReportID(String paramString) {}
  
  public final void setupSubReporter(ISubReporter paramISubReporter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.x
 * JD-Core Version:    0.7.0.1
 */