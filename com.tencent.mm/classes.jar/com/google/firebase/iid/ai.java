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
  private static ai bgt;
  final Context bfj;
  final ScheduledExecutorService bgu;
  @GuardedBy("this")
  private aj bgv;
  @GuardedBy("this")
  private int bgw;
  
  private ai(Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(108818);
    this.bgv = new aj(this, (byte)0);
    this.bgw = 1;
    this.bgu = paramScheduledExecutorService;
    this.bfj = paramContext.getApplicationContext();
    AppMethodBeat.o(108818);
  }
  
  public static ai aj(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(108817);
      if (bgt == null) {
        bgt = new ai(paramContext, Executors.newSingleThreadScheduledExecutor());
      }
      paramContext = bgt;
      AppMethodBeat.o(108817);
      return paramContext;
    }
    finally {}
  }
  
  public final <T> Task<T> a(c<T> paramc)
  {
    try
    {
      AppMethodBeat.i(108819);
      if (Log.isLoggable("MessengerIpcClient", 3))
      {
        String str = String.valueOf(paramc);
        new StringBuilder(String.valueOf(str).length() + 9).append("Queueing ").append(str);
      }
      if (!this.bgv.b(paramc))
      {
        this.bgv = new aj(this, (byte)0);
        this.bgv.b(paramc);
      }
      paramc = paramc.bfh.getTask();
      AppMethodBeat.o(108819);
      return paramc;
    }
    finally {}
  }
  
  public final int sf()
  {
    try
    {
      int i = this.bgw;
      this.bgw = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.firebase.iid.ai
 * JD-Core Version:    0.7.0.1
 */