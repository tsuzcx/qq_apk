package com.google.firebase.iid;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class ai
{
  private static ai dDR;
  final Context dCI;
  final ScheduledExecutorService dDS;
  private aj dDT;
  private int dDU;
  
  private ai(Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(4254);
    this.dDT = new aj(this, (byte)0);
    this.dDU = 1;
    this.dDS = paramScheduledExecutorService;
    this.dCI = paramContext.getApplicationContext();
    AppMethodBeat.o(4254);
  }
  
  public static ai aZ(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(4253);
      if (dDR == null) {
        dDR = new ai(paramContext, Executors.newSingleThreadScheduledExecutor());
      }
      paramContext = dDR;
      AppMethodBeat.o(4253);
      return paramContext;
    }
    finally {}
  }
  
  public final int YB()
  {
    try
    {
      int i = this.dDU;
      this.dDU = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
      if (!this.dDT.b(paramc))
      {
        this.dDT = new aj(this, (byte)0);
        this.dDT.b(paramc);
      }
      paramc = paramc.dCG.getTask();
      AppMethodBeat.o(4255);
      return paramc;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.ai
 * JD-Core Version:    0.7.0.1
 */