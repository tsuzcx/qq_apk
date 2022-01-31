package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.ah.p;
import com.tencent.mm.am.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.l;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyReceiver
  extends BroadcastReceiver
{
  private static WakerLock dhK = null;
  private static Set<Long> dhL = new HashSet();
  private static Lock dhM = new ReentrantLock(false);
  private static byte[] dhN = new byte[0];
  private static byte[] dhO = new byte[0];
  private static NotifyReceiver.a dhP;
  private static boolean dhQ = true;
  private static WakerLock dhx = null;
  
  public static void vX()
  {
    y.i("MicroMsg.NotifyReceiver", "markUIShow");
    dhQ = false;
    aa.Un().edit().putBoolean("is_in_notify_mode", false).commit();
  }
  
  public static void vY()
  {
    com.tencent.mm.kernel.g.Dk().b(138, dhP);
    com.tencent.mm.kernel.g.Dk().b(39, dhP);
    com.tencent.mm.kernel.g.Dk().b(268369922, dhP);
    if (dhP == null) {
      dhP = new NotifyReceiver.a();
    }
    com.tencent.mm.kernel.g.Dk().a(138, dhP);
    com.tencent.mm.kernel.g.Dk().a(39, dhP);
    com.tencent.mm.kernel.g.Dk().a(268369922, dhP);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    y.i("MicroMsg.NotifyReceiver", "onReceive intent :%s", new Object[] { paramIntent });
    if (paramIntent == null) {
      return;
    }
    if (l.bm(paramContext))
    {
      y.i("MicroMsg.NotifyReceiver", "fully exited, no need to start service");
      return;
    }
    a.iv(paramIntent.getIntExtra("notify_respType", -1));
    Intent localIntent = new Intent(paramContext, NotifyReceiver.NotifyService.class);
    if (paramIntent.getBooleanExtra("intent_from_shoot_key", false)) {
      localIntent.putExtra("notify_option_type", 3);
    }
    localIntent.putExtras(paramIntent);
    paramContext.startService(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver
 * JD-Core Version:    0.7.0.1
 */