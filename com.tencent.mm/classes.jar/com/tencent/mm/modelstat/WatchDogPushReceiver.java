package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.network.a.a.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public class WatchDogPushReceiver
  extends BroadcastReceiver
{
  private static String className = "";
  
  public static void RD()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.WatchDogPushReceiver");
    localIntent.setComponent(new ComponentName(ae.getPackageName(), getClassName()));
    localIntent.putExtra("type", 3);
    ae.getContext().sendBroadcast(localIntent);
  }
  
  public static void RE()
  {
    if (!b.cqk()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.WatchDogPushReceiver");
    localIntent.setComponent(new ComponentName(ae.getPackageName(), getClassName()));
    localIntent.putExtra("type", 7);
    ae.getContext().sendBroadcast(localIntent);
  }
  
  public static void a(h paramh)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.WatchDogPushReceiver");
    localIntent.setComponent(new ComponentName(ae.getPackageName(), getClassName()));
    localIntent.putExtra("type", 1);
    localIntent.putExtra("rtType", paramh.rtType);
    localIntent.putExtra("beginTime", paramh.beginTime);
    localIntent.putExtra("endTime", paramh.endTime);
    localIntent.putExtra("rtType", paramh.rtType);
    localIntent.putExtra("dataLen", paramh.eDz);
    localIntent.putExtra("isSend", paramh.ceg);
    localIntent.putExtra("cost", paramh.brE);
    localIntent.putExtra("doSceneCount", paramh.eDA);
    ae.getContext().sendBroadcast(localIntent);
  }
  
  private static String getClassName()
  {
    if (bk.bl(className)) {
      className = ae.getPackageName() + ".modelstat.WatchDogPushReceiver";
    }
    return className;
  }
  
  public static void jo(int paramInt)
  {
    if (!b.cqk()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.WatchDogPushReceiver");
    localIntent.setComponent(new ComponentName(ae.getPackageName(), getClassName()));
    localIntent.putExtra("type", 5);
    localIntent.putExtra("jni", paramInt);
    ae.getContext().sendBroadcast(localIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      y.e("MicroMsg.WatchDogPushReceiver", "onReceive intent == null");
    }
    int i;
    do
    {
      do
      {
        return;
        i = paramIntent.getIntExtra("type", 0);
        y.d("MicroMsg.WatchDogPushReceiver", "onReceive type:" + i);
        if (i == 1)
        {
          paramContext = new a.a();
          paramContext.rtType = paramIntent.getIntExtra("rtType", 0);
          paramContext.beginTime = paramIntent.getLongExtra("beginTime", 0L);
          paramContext.endTime = paramIntent.getLongExtra("endTime", 0L);
          boolean bool = paramIntent.getBooleanExtra("isSend", false);
          if (!bool) {
            paramContext.ePu = paramIntent.getLongExtra("dataLen", 0L);
          }
          for (;;)
          {
            paramContext.brE = paramIntent.getLongExtra("cost", 0L);
            paramContext.ePv = paramIntent.getLongExtra("doSceneCount", 0L);
            y.d("MicroMsg.WatchDogPushReceiver", "onRecv: rtType:" + paramContext.rtType + " isSend:" + bool + " tx:" + paramContext.ePt + " rx:" + paramContext.ePu + " begin:" + paramContext.beginTime + " end:" + paramContext.endTime);
            if ((paramContext.ePv != 0L) && (paramContext.rtType != 0L) && (paramContext.beginTime != 0L) && (paramContext.endTime != 0L) && (paramContext.endTime - paramContext.beginTime > 0L)) {
              break;
            }
            y.w("MicroMsg.WatchDogPushReceiver", "onRecv: count:" + paramContext.ePv + " rtType:" + paramContext.rtType + " begin:" + paramContext.beginTime + " end:" + paramContext.endTime);
            return;
            paramContext.ePt = paramIntent.getLongExtra("dataLen", 0L);
          }
        }
      } while ((i == 2) || (i == 3) || (i == 4));
      if ((i == 5) && (b.cqk()))
      {
        if (paramIntent.getIntExtra("jni", 1) == 1)
        {
          Assert.assertTrue("test errlog push " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
          return;
        }
        MMProtocalJni.setClientPackVersion(-1);
        return;
      }
    } while (i != 6);
    y.cqL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.WatchDogPushReceiver
 * JD-Core Version:    0.7.0.1
 */