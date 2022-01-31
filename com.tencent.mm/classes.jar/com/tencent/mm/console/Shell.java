package com.tencent.mm.console;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class Shell
{
  private static HashMap<String, Shell.a> eul;
  public static IntentFilter eum;
  private static Runnable eun;
  public Receiver euk = null;
  
  static
  {
    AppMethodBeat.i(16123);
    eul = new HashMap();
    eum = new IntentFilter();
    a("wechat.shell.SET_NEXTRET", new Shell.1());
    a("wechat.shell.SET_LOGLEVEL", new Shell.5());
    a("wechat.shell.SET_CDNTRANS", new Shell.6());
    a("wechat.shell.SET_DKTEST", new Shell.7());
    a("wechat.shell.NET_DNS_TEST", new Shell.8());
    a("wechat.shell.IDC_ERROR", new Shell.9());
    a("wechat.shell.SET_DK_WT_TEST", new Shell.10());
    a("wechat.shell.SET_MUTE_ROOM_TEST", new Shell.11());
    a("wechat.shell.HOTPATCH_TEST", new Shell.12());
    a("wechat.shell.EXEC_SQL", new Shell.2());
    a("wechat.shell.DUMP_HPROF", new Shell.3());
    eun = new Shell.4();
    AppMethodBeat.o(16123);
  }
  
  private static void a(String paramString, Shell.a parama)
  {
    AppMethodBeat.i(16122);
    eum.addAction(paramString);
    eul.put(paramString, parama);
    AppMethodBeat.o(16122);
  }
  
  public static class Receiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(16121);
      paramContext = paramIntent.getAction();
      Shell.a locala = (Shell.a)Shell.Nt().get(paramContext);
      if (locala == null)
      {
        ab.e("MicroMsg.Shell", "no action found for %s", new Object[] { paramContext });
        AppMethodBeat.o(16121);
        return;
      }
      ab.e("MicroMsg.Shell", "shell action %s", new Object[] { paramContext });
      locala.s(paramIntent);
      AppMethodBeat.o(16121);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.console.Shell
 * JD-Core Version:    0.7.0.1
 */