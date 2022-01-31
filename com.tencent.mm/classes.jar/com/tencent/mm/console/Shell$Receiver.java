package com.tencent.mm.console;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class Shell$Receiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    Shell.a locala = (Shell.a)Shell.AD().get(paramContext);
    if (locala == null)
    {
      y.e("MicroMsg.Shell", "no action found for %s", new Object[] { paramContext });
      return;
    }
    y.e("MicroMsg.Shell", "shell action %s", new Object[] { paramContext });
    locala.g(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.console.Shell.Receiver
 * JD-Core Version:    0.7.0.1
 */