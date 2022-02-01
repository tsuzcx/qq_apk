package com.tencent.mm.plugin.appbrand.debugger.console;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.f;
import com.tencent.threadpool.i;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl;", "Lcom/tencent/mm/plugin/appbrand/debugger/console/LogImplAdapter;", "simpleProcessName", "", "(Ljava/lang/String;)V", "expectedFlushLogTime", "", "flushLogBufferFuture", "Ljava/util/concurrent/Future;", "flushLogBufferTask", "com/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl$flushLogBufferTask$1", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl$flushLogBufferTask$1;", "logInfoBuffer", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl$LogInfoBuffer;", "logLevel", "", "getLogLevel", "()I", "setLogLevel", "(I)V", "doLog", "", "priority", "logLine", "flushLogBuffer", "logD", "logInstancePtr", "tag", "filename", "funcname", "linuxTid", "pid", "tid", "maintid", "log", "logE", "logI", "logV", "logW", "Companion", "LogInfo", "LogInfoBuffer", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ConsoleDebugLogImpl
  extends h
{
  public static final ConsoleDebugLogImpl.a reV;
  public int logLevel;
  private final String reW;
  private final ConsoleDebugLogImpl.b reX;
  private long reY;
  private Future<?> reZ;
  private final d rfa;
  
  static
  {
    AppMethodBeat.i(319792);
    reV = new ConsoleDebugLogImpl.a((byte)0);
    AppMethodBeat.o(319792);
  }
  
  public ConsoleDebugLogImpl(String paramString)
  {
    AppMethodBeat.i(319750);
    this.reW = paramString;
    this.logLevel = 2;
    this.reX = new ConsoleDebugLogImpl.b();
    this.reY = -1L;
    this.rfa = new d(this);
    AppMethodBeat.o(319750);
  }
  
  private static final IPCVoid W(Bundle paramBundle)
  {
    AppMethodBeat.i(319777);
    paramBundle.setClassLoader(LogInfo.class.getClassLoader());
    paramBundle = paramBundle.getParcelableArray("BatchLogInfo");
    if (paramBundle == null)
    {
      Log.i("MicroMsg.AppBrand.ConsoleDebugLogImpl", "flushLogBuffer, uncheckedBatchLogInfo is null");
      paramBundle = IPCVoid.mzv;
      AppMethodBeat.o(319777);
      return paramBundle;
    }
    f.bt((kotlin.g.a.a)new c(paramBundle));
    paramBundle = IPCVoid.mzv;
    AppMethodBeat.o(319777);
    return paramBundle;
  }
  
  private static final void a(ConsoleDebugLogImpl paramConsoleDebugLogImpl, int paramInt, String paramString)
  {
    AppMethodBeat.i(319774);
    s.u(paramConsoleDebugLogImpl, "this$0");
    s.u(paramString, "$logLine");
    ConsoleDebugLogImpl.b localb = paramConsoleDebugLogImpl.reX;
    paramString = new LogInfo(paramInt, paramString);
    s.u(paramString, "logInfo");
    paramInt = (localb.rff + 1) % 100;
    int i = localb.rfg;
    int j = paramString.rfc;
    localb.rfe[paramInt] = paramString;
    localb.rff = paramInt;
    localb.rfg = (i + j);
    if ((99 <= localb.rff) || (524288 <= localb.rfg)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (1 == paramInt) {
        paramConsoleDebugLogImpl.cmb();
      }
      paramConsoleDebugLogImpl.reY = (SystemClock.elapsedRealtime() + 200L);
      if (paramConsoleDebugLogImpl.reZ == null) {
        paramConsoleDebugLogImpl.reZ = ((Future)com.tencent.threadpool.h.ahAA.q((Runnable)paramConsoleDebugLogImpl.rfa, 200L));
      }
      AppMethodBeat.o(319774);
      return;
    }
  }
  
  private final void ar(int paramInt, String paramString)
  {
    AppMethodBeat.i(319756);
    com.tencent.threadpool.h.ahAA.i(new ConsoleDebugLogImpl..ExternalSyntheticLambda1(this, paramInt, paramString), "ConsoleDebugLog");
    AppMethodBeat.o(319756);
  }
  
  private final void cmb()
  {
    AppMethodBeat.i(319764);
    Log.i("MicroMsg.AppBrand.ConsoleDebugLogImpl", "flushLogBuffer");
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(LogInfo.class.getClassLoader());
    localBundle.putParcelableArray("BatchLogInfo", (Parcelable[])this.reX.cmc());
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(localBundle, ConsoleDebugLogImpl..ExternalSyntheticLambda0.INSTANCE);
    this.reZ = null;
    AppMethodBeat.o(319764);
  }
  
  public final void logD(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    AppMethodBeat.i(319826);
    if (paramString4 == null)
    {
      AppMethodBeat.o(319826);
      return;
    }
    if (3 < this.logLevel)
    {
      AppMethodBeat.o(319826);
      return;
    }
    ar(3, "[" + this.reW + "] " + paramString4);
    AppMethodBeat.o(319826);
  }
  
  public final void logE(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    AppMethodBeat.i(319845);
    if (paramString4 == null)
    {
      AppMethodBeat.o(319845);
      return;
    }
    if (6 < this.logLevel)
    {
      AppMethodBeat.o(319845);
      return;
    }
    ar(6, "[" + this.reW + ']' + paramString4);
    AppMethodBeat.o(319845);
  }
  
  public final void logI(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    AppMethodBeat.i(319833);
    if (paramString4 == null)
    {
      AppMethodBeat.o(319833);
      return;
    }
    if (4 < this.logLevel)
    {
      AppMethodBeat.o(319833);
      return;
    }
    ar(4, "[" + this.reW + "] " + paramString4);
    AppMethodBeat.o(319833);
  }
  
  public final void logV(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    AppMethodBeat.i(319819);
    if (paramString4 == null)
    {
      AppMethodBeat.o(319819);
      return;
    }
    if (2 < this.logLevel)
    {
      AppMethodBeat.o(319819);
      return;
    }
    ar(2, "[" + this.reW + "] " + paramString4);
    AppMethodBeat.o(319819);
  }
  
  public final void logW(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    AppMethodBeat.i(319838);
    if (paramString4 == null)
    {
      AppMethodBeat.o(319838);
      return;
    }
    if (5 < this.logLevel)
    {
      AppMethodBeat.o(319838);
      return;
    }
    ar(5, "[" + this.reW + "] " + paramString4);
    AppMethodBeat.o(319838);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl$LogInfo;", "Landroid/os/Parcelable;", "priority", "", "logLine", "", "(ILjava/lang/String;)V", "getLogLine", "()Ljava/lang/String;", "getPriority", "()I", "usedSizeInByte", "getUsedSizeInByte$annotations", "()V", "getUsedSizeInByte", "describeContents", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class LogInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<LogInfo> CREATOR;
    final int priority;
    final String rfb;
    final int rfc;
    
    static
    {
      AppMethodBeat.i(319772);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(319772);
    }
    
    public LogInfo(int paramInt, String paramString)
    {
      AppMethodBeat.i(319762);
      this.priority = paramInt;
      this.rfb = paramString;
      this.rfc = (this.rfb.length() * 2 + 4);
      AppMethodBeat.o(319762);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(319780);
      String str = "LogInfo(priority=" + this.priority + ", logLine='" + this.rfb + "')";
      AppMethodBeat.o(319780);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(319793);
      s.u(paramParcel, "out");
      paramParcel.writeInt(this.priority);
      paramParcel.writeString(this.rfb);
      AppMethodBeat.o(319793);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<ConsoleDebugLogImpl.LogInfo>
    {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(Parcelable[] paramArrayOfParcelable)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl$flushLogBufferTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Runnable
  {
    d(ConsoleDebugLogImpl paramConsoleDebugLogImpl) {}
    
    public final void run()
    {
      AppMethodBeat.i(319713);
      long l = ConsoleDebugLogImpl.a(this.rfi) - SystemClock.elapsedRealtime();
      Log.i("MicroMsg.AppBrand.ConsoleDebugLogImpl", s.X("run#flushLogBufferTask, remainDelayTime: ", Long.valueOf(l)));
      if (l <= 0L)
      {
        ConsoleDebugLogImpl.b(this.rfi);
        AppMethodBeat.o(319713);
        return;
      }
      ConsoleDebugLogImpl.a(this.rfi, (Future)com.tencent.threadpool.h.ahAA.q((Runnable)this, l));
      AppMethodBeat.o(319713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.console.ConsoleDebugLogImpl
 * JD-Core Version:    0.7.0.1
 */