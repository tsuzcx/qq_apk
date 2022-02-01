package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class s
  extends BroadcastReceiver
{
  r dDm;
  
  public s(r paramr)
  {
    this.dDm = paramr;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(4208);
    if (this.dDm == null)
    {
      AppMethodBeat.o(4208);
      return;
    }
    if (!this.dDm.zzaj())
    {
      AppMethodBeat.o(4208);
      return;
    }
    FirebaseInstanceId.Yl();
    FirebaseInstanceId.c(this.dDm, 0L);
    this.dDm.getContext().unregisterReceiver(this);
    this.dDm = null;
    AppMethodBeat.o(4208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.s
 * JD-Core Version:    0.7.0.1
 */