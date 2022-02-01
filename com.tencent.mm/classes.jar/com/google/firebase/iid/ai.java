package com.google.firebase.iid;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class ai
{
  @GuardedBy("MessengerIpcClient.class")
  private static ai bMo;
  final Context bLf;
  final ScheduledExecutorService bMp;
  @GuardedBy("this")
  private aj bMq;
  @GuardedBy("this")
  private int bMr;
  
  private ai(Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(4254);
    this.bMq = new aj(this, (byte)0);
    this.bMr = 1;
    this.bMp = paramScheduledExecutorService;
    this.bLf = paramContext.getApplicationContext();
    AppMethodBeat.o(4254);
  }
  
  public static ai ar(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(4253);
      if (bMo == null) {
        bMo = new ai(paramContext, Executors.newSingleThreadScheduledExecutor());
      }
      paramContext = bMo;
      AppMethodBeat.o(4253);
      return paramContext;
    }
    finally {}
  }
  
  public final <T> Task<T> a(c<T> paramc)
  {
    try
    {
      AppMethodBeat.i(4255);
      if (Log.isLoggable("MessengerIpcClient", 3))
      {
        String str = String.valueOf(paramc);
        new StringBuilder(String.valueOf(str).length() + 9).append("Queueing ").append(str);
      }
      if (!this.bMq.b(paramc))
      {
        this.bMq = new aj(this, (byte)0);
        this.bMq.b(paramc);
      }
      paramc = paramc.bLd.getTask();
      AppMethodBeat.o(4255);
      return paramc;
    }
    finally {}
  }
  
  public final int yo()
  {
    try
    {
      int i = this.bMr;
      this.bMr = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.ai
 * JD-Core Version:    0.7.0.1
 */