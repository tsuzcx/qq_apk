package com.google.firebase.iid;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class x
  implements Runnable
{
  x(w paramw, u paramu) {}
  
  public final void run()
  {
    AppMethodBeat.i(108777);
    Log.isLoggable("EnhancedIntentService", 3);
    w.a(this.bgb).g(this.bga.intent);
    this.bga.finish();
    AppMethodBeat.o(108777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.firebase.iid.x
 * JD-Core Version:    0.7.0.1
 */