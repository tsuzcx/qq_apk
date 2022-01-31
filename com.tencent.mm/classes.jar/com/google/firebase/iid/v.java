package com.google.firebase.iid;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class v
  implements Runnable
{
  v(u paramu, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(108776);
    String str = this.bfT.getAction();
    new StringBuilder(String.valueOf(str).length() + 61).append("Service took too long to process intent: ").append(str).append(" App may get closed.");
    this.bfY.finish();
    AppMethodBeat.o(108776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.v
 * JD-Core Version:    0.7.0.1
 */