package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.os.ResultReceiver;
import android.support.v4.os.b;
import androidx.core.app.ComponentActivity;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class ResultReceiverFixLeak
{
  public static ResultReceiver a(ResultReceiver paramResultReceiver, Context paramContext)
  {
    AppMethodBeat.i(319413);
    if (!(paramContext instanceof ComponentActivity))
    {
      AppMethodBeat.o(319413);
      return paramResultReceiver;
    }
    paramResultReceiver = new ResultReceiverLifecycleWrapper(paramResultReceiver, (q)paramContext);
    AppMethodBeat.o(319413);
    return paramResultReceiver;
  }
  
  static final class ResultReceiverLifecycleWrapper
    extends ResultReceiver
    implements p
  {
    private ResultReceiver rvK;
    
    public ResultReceiverLifecycleWrapper(ResultReceiver paramResultReceiver, final q paramq)
    {
      super();
      AppMethodBeat.i(319433);
      this.rvK = paramResultReceiver;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        paramq.getLifecycle().addObserver(this);
        AppMethodBeat.o(319433);
        return;
      }
      h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(319438);
          paramq.getLifecycle().addObserver(ResultReceiverFixLeak.ResultReceiverLifecycleWrapper.this);
          AppMethodBeat.o(319438);
        }
      });
      AppMethodBeat.o(319433);
    }
    
    @z(Ho=j.a.ON_DESTROY)
    final void onDestroy()
    {
      this.rvK = null;
    }
    
    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(319434);
      super.onReceiveResult(paramInt, paramBundle);
      if (this.rvK != null) {
        b.a(this.rvK, paramInt, paramBundle);
      }
      AppMethodBeat.o(319434);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.ResultReceiverFixLeak
 * JD-Core Version:    0.7.0.1
 */