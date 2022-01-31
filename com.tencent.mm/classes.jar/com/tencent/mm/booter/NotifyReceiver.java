package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.an.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.service.ProcessService.MMProcessService;
import com.tencent.mm.service.c;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyReceiver
  extends BroadcastReceiver
{
  private static WakerLock dYK;
  private static WakerLock dZd;
  private static Set<Long> dZe;
  private static Lock dZf;
  private static byte[] dZg;
  private static byte[] dZh;
  private static NotifyReceiver.a dZi;
  private static boolean dZj;
  
  static
  {
    AppMethodBeat.i(57806);
    dYK = null;
    dZd = null;
    dZe = new HashSet();
    dZf = new ReentrantLock(false);
    dZg = new byte[0];
    dZh = new byte[0];
    dZj = true;
    AppMethodBeat.o(57806);
  }
  
  public static void Il()
  {
    AppMethodBeat.i(57802);
    Im();
    AppMethodBeat.o(57802);
  }
  
  public static void Im()
  {
    AppMethodBeat.i(57803);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifyReceiver", "quitLightPushMode");
    dZj = false;
    com.tencent.mm.network.ab.any().edit().putBoolean("is_in_notify_mode", false).commit();
    AppMethodBeat.o(57803);
  }
  
  public static void In()
  {
    AppMethodBeat.i(57804);
    g.Rc().b(138, dZi);
    g.Rc().b(39, dZi);
    g.Rc().b(268369922, dZi);
    if (dZi == null) {
      dZi = new NotifyReceiver.a();
    }
    g.Rc().a(138, dZi);
    g.Rc().a(39, dZi);
    g.Rc().a(268369922, dZi);
    AppMethodBeat.o(57804);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(57805);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifyReceiver", "onReceive intent :%s", new Object[] { paramIntent });
    if (paramIntent == null)
    {
      AppMethodBeat.o(57805);
      return;
    }
    if (l.bQ(paramContext))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NotifyReceiver", "fully exited, no need to start service");
      AppMethodBeat.o(57805);
      return;
    }
    a.lj(paramIntent.getIntExtra("notify_respType", -1));
    paramContext = new Intent(paramContext, NotifyReceiver.NotifyService.class);
    if (paramIntent.getBooleanExtra("intent_from_shoot_key", false)) {
      paramContext.putExtra("notify_option_type", 3);
    }
    paramContext.putExtras(paramIntent);
    c.a(paramContext, "mm", true, new Intent(ah.getContext(), ProcessService.MMProcessService.class));
    AppMethodBeat.o(57805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver
 * JD-Core Version:    0.7.0.1
 */