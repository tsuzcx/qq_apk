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
  private static ai bEs;
  final Context bDj;
  final ScheduledExecutorService bEt;
  @GuardedBy("this")
  private aj bEu;
  @GuardedBy("this")
  private int bEv;
  
  private ai(Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(4254);
    this.bEu = new aj(this, (byte)0);
    this.bEv = 1;
    this.bEt = paramScheduledExecutorService;
    this.bDj = paramContext.getApplicationContext();
    AppMethodBeat.o(4254);
  }
  
  public static ai ap(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(4253);
      if (bEs == null) {
        bEs = new ai(paramContext, Executors.newSingleThreadScheduledExecutor());
      }
      paramContext = bEs;
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
      if (!this.bEu.b(paramc))
      {
        this.bEu = new aj(this, (byte)0);
        this.bEu.b(paramc);
      }
      paramc = paramc.bDh.getTask();
      AppMethodBeat.o(4255);
      return paramc;
    }
    finally {}
  }
  
  public final int xe()
  {
    try
    {
      int i = this.bEv;
      this.bEv = (i + 1);
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