package com.google.android.gms.iid;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzh
  implements Runnable
{
  zzh(zzg paramzzg, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(2520);
    String str = this.zzbb.getAction();
    new StringBuilder(String.valueOf(str).length() + 61).append("Service took too long to process intent: ").append(str).append(" App may get closed.");
    this.zzbh.finish();
    AppMethodBeat.o(2520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.iid.zzh
 * JD-Core Version:    0.7.0.1
 */