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
  private static ai bME;
  final Context bLv;
  final ScheduledExecutorService bMF;
  @GuardedBy("this")
  private aj bMG;
  @GuardedBy("this")
  private int bMH;
  
  private ai(Context paramContext, ScheduledExecutorService paramScheduledExecutorService)
  {
    AppMethodBeat.i(4254);
    this.bMG = new aj(this, (byte)0);
    this.bMH = 1;
    this.bMF = paramScheduledExecutorService;
    this.bLv = paramContext.getApplicationContext();
    AppMethodBeat.o(4254);
  }
  
  public static ai as(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(4253);
      if (bME == null) {
        bME = new ai(paramContext, Executors.newSingleThreadScheduledExecutor());
      }
      paramContext = bME;
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
      if (!this.bMG.b(paramc))
      {
        this.bMG = new aj(this, (byte)0);
        this.bMG.b(paramc);
      }
      paramc = paramc.bLt.getTask();
      AppMethodBeat.o(4255);
      return paramc;
    }
    finally {}
  }
  
  public final int yw()
  {
    try
    {
      int i = this.bMH;
      this.bMH = (i + 1);
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