package com.tencent.mm.console;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class Shell
{
  private static HashMap<String, Shell.a> dAK = new HashMap();
  public static IntentFilter dAL = new IntentFilter();
  private static Runnable dAM = new Shell.3();
  public Shell.Receiver dAJ = null;
  
  static
  {
    a("wechat.shell.SET_NEXTRET", new Shell.1());
    a("wechat.shell.SET_LOGLEVEL", new Shell.4());
    a("wechat.shell.SET_CDNTRANS", new Shell.a()
    {
      public final void g(Intent paramAnonymousIntent)
      {
        ae.eSJ = paramAnonymousIntent.getBooleanExtra("value", false);
        y.w("MicroMsg.Shell", "kiro set Test.forceCDNTrans=%b", new Object[] { Boolean.valueOf(ae.eSJ) });
      }
    });
    a("wechat.shell.SET_DKTEST", new Shell.6());
    a("wechat.shell.NET_DNS_TEST", new Shell.a()
    {
      public final void g(Intent paramAnonymousIntent)
      {
        ae.eSO = paramAnonymousIntent.getIntExtra("value", 0);
        y.w("MicroMsg.Shell", "dkdnstd set Test.netDnsSimulateFault=%s", new Object[] { Integer.toBinaryString(ae.eSO) });
      }
    });
    a("wechat.shell.IDC_ERROR", new Shell.8());
    a("wechat.shell.SET_DK_WT_TEST", new Shell.9());
    a("wechat.shell.SET_MUTE_ROOM_TEST", new Shell.10());
    a("wechat.shell.HOTPATCH_TEST", new Shell.11());
    a("wechat.shell.EXEC_SQL", new Shell.2());
  }
  
  private static void a(String paramString, Shell.a parama)
  {
    dAL.addAction(paramString);
    dAK.put(paramString, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.console.Shell
 * JD-Core Version:    0.7.0.1
 */