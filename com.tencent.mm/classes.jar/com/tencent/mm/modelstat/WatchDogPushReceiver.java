package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.a.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public class WatchDogPushReceiver
  extends BroadcastReceiver
{
  private static String className = "";
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(151147);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.WatchDogPushReceiver");
    localIntent.setComponent(new ComponentName(MMApplicationContext.getPackageName(), getClassName()));
    localIntent.putExtra("type", 1);
    localIntent.putExtra("rtType", paramh.rtType);
    localIntent.putExtra("beginTime", paramh.beginTime);
    localIntent.putExtra("endTime", paramh.endTime);
    localIntent.putExtra("rtType", paramh.rtType);
    localIntent.putExtra("dataLen", paramh.jod);
    localIntent.putExtra("isSend", paramh.ehd);
    localIntent.putExtra("cost", paramh.cCv);
    localIntent.putExtra("doSceneCount", paramh.joe);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(151147);
  }
  
  public static void bgp()
  {
    AppMethodBeat.i(151148);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.WatchDogPushReceiver");
    localIntent.setComponent(new ComponentName(MMApplicationContext.getPackageName(), getClassName()));
    localIntent.putExtra("type", 3);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(151148);
  }
  
  public static void bgq()
  {
    AppMethodBeat.i(151150);
    if (!CrashReportFactory.hasDebuger())
    {
      AppMethodBeat.o(151150);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.WatchDogPushReceiver");
    localIntent.setComponent(new ComponentName(MMApplicationContext.getPackageName(), getClassName()));
    localIntent.putExtra("type", 7);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(151150);
  }
  
  private static String getClassName()
  {
    AppMethodBeat.i(151146);
    if (Util.isNullOrNil(className)) {
      className = MMApplicationContext.getSourcePackageName() + ".modelstat.WatchDogPushReceiver";
    }
    String str = className;
    AppMethodBeat.o(151146);
    return str;
  }
  
  public static void tZ(int paramInt)
  {
    AppMethodBeat.i(151149);
    if (!CrashReportFactory.hasDebuger())
    {
      AppMethodBeat.o(151149);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.WatchDogPushReceiver");
    localIntent.setComponent(new ComponentName(MMApplicationContext.getPackageName(), getClassName()));
    localIntent.putExtra("type", 5);
    localIntent.putExtra("jni", paramInt);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(151149);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(151145);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.WatchDogPushReceiver", "onReceive intent == null");
      AppMethodBeat.o(151145);
      return;
    }
    int i = paramIntent.getIntExtra("type", 0);
    Log.d("MicroMsg.WatchDogPushReceiver", "onReceive type:".concat(String.valueOf(i)));
    if (i == 1)
    {
      paramContext = new a.a();
      paramContext.rtType = paramIntent.getIntExtra("rtType", 0);
      paramContext.beginTime = paramIntent.getLongExtra("beginTime", 0L);
      paramContext.endTime = paramIntent.getLongExtra("endTime", 0L);
      boolean bool = paramIntent.getBooleanExtra("isSend", false);
      if (!bool) {
        paramContext.jGp = paramIntent.getLongExtra("dataLen", 0L);
      }
      for (;;)
      {
        paramContext.cCv = paramIntent.getLongExtra("cost", 0L);
        paramContext.count = paramIntent.getLongExtra("doSceneCount", 0L);
        Log.d("MicroMsg.WatchDogPushReceiver", "onRecv: rtType:" + paramContext.rtType + " isSend:" + bool + " tx:" + paramContext.jGo + " rx:" + paramContext.jGp + " begin:" + paramContext.beginTime + " end:" + paramContext.endTime);
        if ((paramContext.count != 0L) && (paramContext.rtType != 0L) && (paramContext.beginTime != 0L) && (paramContext.endTime != 0L) && (paramContext.endTime - paramContext.beginTime > 0L)) {
          break;
        }
        Log.w("MicroMsg.WatchDogPushReceiver", "onRecv: count:" + paramContext.count + " rtType:" + paramContext.rtType + " begin:" + paramContext.beginTime + " end:" + paramContext.endTime);
        AppMethodBeat.o(151145);
        return;
        paramContext.jGo = paramIntent.getLongExtra("dataLen", 0L);
      }
      AppMethodBeat.o(151145);
      return;
    }
    if ((i != 2) && (i != 3) && (i != 4))
    {
      if ((i == 5) && (CrashReportFactory.hasDebuger()))
      {
        if (paramIntent.getIntExtra("jni", 1) == 1)
        {
          Assert.assertTrue("test errlog push " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
          AppMethodBeat.o(151145);
          return;
        }
        MMProtocalJni.setClientPackVersion(-1);
        AppMethodBeat.o(151145);
        return;
      }
      if (i == 6) {
        Log.appenderFlush();
      }
    }
    AppMethodBeat.o(151145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.WatchDogPushReceiver
 * JD-Core Version:    0.7.0.1
 */