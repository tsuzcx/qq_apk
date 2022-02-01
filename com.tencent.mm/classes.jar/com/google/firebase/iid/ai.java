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
  private static ai bKj;
  final Context bJa;
  final ScheduledExecutorService bKk;
  @GuardedBy("this")
  private aj bKl;
  @GuardedBy("this")
  private int bKm;
  
  private ai(Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(4254);
    this.bKl = new aj(this, (byte)0);
    this.bKm = 1;
    this.bKk = paramScheduledExecutorService;
    this.bJa = paramContext.getApplicationContext();
    AppMethodBeat.o(4254);
  }
  
  public static ai ao(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(4253);
      if (bKj == null) {
        bKj = new ai(paramContext, Executors.newSingleThreadScheduledExecutor());
      }
      paramContext = bKj;
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
      if (!this.bKl.b(paramc))
      {
        this.bKl = new aj(this, (byte)0);
        this.bKl.b(paramc);
      }
      paramc = paramc.bIY.getTask();
      AppMethodBeat.o(4255);
      return paramc;
    }
    finally {}
  }
  
  public final int yQ()
  {
    try
    {
      int i = this.bKm;
      this.bKm = (i + 1);
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