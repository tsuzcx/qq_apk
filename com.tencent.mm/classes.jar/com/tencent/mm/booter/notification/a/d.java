package com.tencent.mm.booter.notification.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public Intent mIntent;
  
  public static PendingIntent c(Context paramContext, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(20043);
    paramContext = PendingIntent.getActivity(paramContext, paramInt, paramIntent, 134217728);
    AppMethodBeat.o(20043);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.d
 * JD-Core Version:    0.7.0.1
 */