package com.tencent.e.k;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/threadpool/stub/ThreadPoolStubDummyImpl;", "Lcom/tencent/threadpool/stub/IThreadPoolStub;", "()V", "STUB_HT_COUNT", "", "TAG", "", "mainHandler", "Landroid/os/Handler;", "stubExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "stubHandler", "", "stubHandlerThreads", "", "Landroid/os/HandlerThread;", "compute", "Ljava/util/concurrent/Future;", "runnable", "Ljava/lang/Runnable;", "serialTag", "T", "callable", "Ljava/util/concurrent/Callable;", "computeDelay", "delayMs", "", "cycle", "initialDelayMs", "periodMs", "cycleRate", "execute", "executeAtFront", "executeDelay", "forkExecutorService", "Ljava/util/concurrent/ExecutorService;", "name", "corePoolSize", "maximumPoolSize", "workQueue", "Ljava/util/concurrent/BlockingQueue;", "handler", "Lcom/tencent/threadpool/stub/StubRejectedExecutionHandler;", "forkSingleExecutorService", "io", "ioDelay", "persist", "persistDelay", "provideSerial", "removeBy", "", "serial", "Ljava/util/concurrent/FutureTask;", "future", "serialAtFront", "ui", "uiAtFront", "uiDelay", "of", "", "threadpool-stub_release"})
public final class c
  implements a
{
  private static final ScheduledExecutorService ZxL;
  private static final List<HandlerThread> ZxM;
  private static final Map<String, Handler> ZxN;
  public static final c ZxO;
  private static final Handler die;
  
  static
  {
    AppMethodBeat.i(255071);
    ZxO = new c();
    die = new Handler(Looper.getMainLooper());
    ZxL = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    ZxN = (Map)new LinkedHashMap();
    ZxM = (List)new ArrayList();
    int i = 1;
    while (i <= 50)
    {
      ZxM.add(new HandlerThread("#StubHT-".concat(String.valueOf(i))));
      i += 1;
    }
    AppMethodBeat.o(255071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.k.c
 * JD-Core Version:    0.7.0.1
 */