package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class TaskExecutors
{
  public static final Executor MAIN_THREAD;
  static final Executor zzagd;
  
  static
  {
    AppMethodBeat.i(57349);
    MAIN_THREAD = new zza();
    zzagd = new zzt();
    AppMethodBeat.o(57349);
  }
  
  static final class zza
    implements Executor
  {
    private final Handler mHandler;
    
    public zza()
    {
      AppMethodBeat.i(57347);
      this.mHandler = new Handler(Looper.getMainLooper());
      AppMethodBeat.o(57347);
    }
    
    public final void execute(Runnable paramRunnable)
    {
      AppMethodBeat.i(57348);
      this.mHandler.post(paramRunnable);
      AppMethodBeat.o(57348);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tasks.TaskExecutors
 * JD-Core Version:    0.7.0.1
 */