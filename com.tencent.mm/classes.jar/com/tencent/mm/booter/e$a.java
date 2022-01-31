package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
  extends e.c
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(15841);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(15841);
      return;
    }
    super.onReceive(paramContext, paramIntent);
    AppMethodBeat.o(15841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.e.a
 * JD-Core Version:    0.7.0.1
 */