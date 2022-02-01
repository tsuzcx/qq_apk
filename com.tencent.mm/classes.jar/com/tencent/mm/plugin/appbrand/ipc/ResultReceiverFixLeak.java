package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.support.v4.os.b;
import androidx.core.app.ComponentActivity;
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ResultReceiverFixLeak
{
  static ResultReceiver a(ResultReceiver paramResultReceiver, Context paramContext)
  {
    AppMethodBeat.i(251523);
    if (!(paramContext instanceof ComponentActivity))
    {
      AppMethodBeat.o(251523);
      return paramResultReceiver;
    }
    paramResultReceiver = new ResultReceiverLifecycleWrapper(paramResultReceiver, (l)paramContext);
    AppMethodBeat.o(251523);
    return paramResultReceiver;
  }
  
  static final class ResultReceiverLifecycleWrapper
    extends ResultReceiver
    implements k
  {
    private ResultReceiver orQ;
    
    public ResultReceiverLifecycleWrapper(ResultReceiver paramResultReceiver, l paraml)
    {
      super();
      AppMethodBeat.i(281783);
      this.orQ = paramResultReceiver;
      paraml.getLifecycle().a(this);
      AppMethodBeat.o(281783);
    }
    
    @t(jl=h.a.ON_DESTROY)
    final void onDestroy()
    {
      this.orQ = null;
    }
    
    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(281784);
      super.onReceiveResult(paramInt, paramBundle);
      if (this.orQ != null) {
        b.a(this.orQ, paramInt, paramBundle);
      }
      AppMethodBeat.o(281784);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.ResultReceiverFixLeak
 * JD-Core Version:    0.7.0.1
 */