package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class MMReceivers
{
  public static class ExdeviceProcessReceiver
    extends BroadcastReceiver
  {
    private static MMReceivers.a lrA = null;
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(131891);
      if (lrA != null) {
        lrA.onReceive(paramContext, paramIntent);
      }
      AppMethodBeat.o(131891);
    }
  }
  
  public static class SandBoxProcessReceiver
    extends BroadcastReceiver
  {
    private static MMReceivers.a lrA = null;
    
    public static void a(MMReceivers.a parama)
    {
      lrA = parama;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(131892);
      if (lrA != null) {
        lrA.onReceive(paramContext, paramIntent);
      }
      AppMethodBeat.o(131892);
    }
  }
  
  public static class ToolsMpProcessReceiver
    extends BroadcastReceiver
  {
    private static MMReceivers.a lrA = null;
    
    public static void a(MMReceivers.a parama)
    {
      lrA = parama;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(131893);
      try
      {
        if (lrA != null) {
          lrA.onReceive(paramContext, paramIntent);
        }
        AppMethodBeat.o(131893);
        return;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.ToolsMpProcessReceiver", paramContext, "onReceive error", new Object[0]);
        AppMethodBeat.o(131893);
      }
    }
  }
  
  public static class ToolsProcessReceiver
    extends BroadcastReceiver
  {
    private static MMReceivers.a lrA = null;
    
    public static void a(MMReceivers.a parama)
    {
      lrA = parama;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(131894);
      try
      {
        if (lrA != null) {
          lrA.onReceive(paramContext, paramIntent);
        }
        AppMethodBeat.o(131894);
        return;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.ToolsProcessReceiver", paramContext, "onReceive error", new Object[0]);
        AppMethodBeat.o(131894);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onReceive(Context paramContext, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers
 * JD-Core Version:    0.7.0.1
 */