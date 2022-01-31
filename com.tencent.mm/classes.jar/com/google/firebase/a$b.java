package com.google.firebase;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(24)
final class a$b
  extends BroadcastReceiver
{
  private static AtomicReference<b> bel;
  private final Context bed;
  
  static
  {
    AppMethodBeat.i(10576);
    bel = new AtomicReference();
    AppMethodBeat.o(10576);
  }
  
  private a$b(Context paramContext)
  {
    this.bed = paramContext;
  }
  
  public final void onReceive(Context arg1, Intent paramIntent)
  {
    AppMethodBeat.i(10574);
    synchronized (a.rF())
    {
      paramIntent = a.bec.values().iterator();
      if (paramIntent.hasNext()) {
        a.a((a)paramIntent.next());
      }
    }
    this.bed.unregisterReceiver(this);
    AppMethodBeat.o(10574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.firebase.a.b
 * JD-Core Version:    0.7.0.1
 */