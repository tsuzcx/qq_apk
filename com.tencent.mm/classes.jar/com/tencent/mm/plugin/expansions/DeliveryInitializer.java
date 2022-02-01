package com.tencent.mm.plugin.expansions;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class DeliveryInitializer
{
  private static final String TAG = "MicroMsg.exp.DeliveryInitializer";
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(273679);
    Log.i("MicroMsg.exp.DeliveryInitializer", "init Delivery for Expansions");
    Delivery.init(paramContext);
    AppMethodBeat.o(273679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.DeliveryInitializer
 * JD-Core Version:    0.7.0.1
 */