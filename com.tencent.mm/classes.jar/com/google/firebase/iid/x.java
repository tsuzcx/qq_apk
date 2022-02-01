package com.google.firebase.iid;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class x
  implements Runnable
{
  x(w paramw, u paramu) {}
  
  public final void run()
  {
    AppMethodBeat.i(4213);
    Log.isLoggable("EnhancedIntentService", 3);
    w.a(this.bJR).f(this.bJQ.intent);
    this.bJQ.finish();
    AppMethodBeat.o(4213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.x
 * JD-Core Version:    0.7.0.1
 */