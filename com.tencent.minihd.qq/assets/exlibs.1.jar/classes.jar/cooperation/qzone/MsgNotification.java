package cooperation.qzone;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.common.app.FowardIntent;
import com.tencent.mobileqq.activity.QzoneWrapperActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.BaseApplication;

public class MsgNotification
{
  public static final int a = 0;
  private static MsgNotification a = null;
  public static final int b = 1;
  public static final int c = 2;
  
  private Intent a(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = QZoneHelper.b(paramQQAppInterface.a());
    localIntent.putExtra("qzone_uin", paramQQAppInterface.getAccount());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("FromNotification", true);
    localIntent.putExtras(paramQQAppInterface);
    localIntent.addFlags(67108864);
    localIntent.putExtra("vipReminderFlag", true);
    return localIntent;
  }
  
  private Intent a(String paramString)
  {
    Object localObject = Uri.parse(paramString);
    paramString = new Bundle();
    paramString.putBoolean("specialpush", true);
    paramString.putLong("special_uin", Long.parseLong(((Uri)localObject).getQueryParameter("uin")));
    paramString.putInt("appid", Integer.parseInt(((Uri)localObject).getQueryParameter("appid")));
    paramString.putString("cellid", ((Uri)localObject).getQueryParameter("uid"));
    paramString.putString("subid", ((Uri)localObject).getQueryParameter("subid"));
    localObject = QZoneHelper.a();
    ((Intent)localObject).putExtras(paramString);
    return localObject;
  }
  
  public static MsgNotification a()
  {
    if (a == null) {
      a = new MsgNotification();
    }
    return a;
  }
  
  private void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramInt != 0)) {
      paramQQAppInterface.q();
    }
  }
  
  private Intent b(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = QZoneHelper.a(paramQQAppInterface.a());
    localIntent.putExtra("qzone_uin", paramQQAppInterface.getAccount());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("FromNotification", true);
    localIntent.putExtras(paramQQAppInterface);
    localIntent.addFlags(67108864);
    localIntent.putExtra("src_type", "app");
    localIntent.putExtra("isFromQQ", "true");
    localIntent.putExtra("page", "tab_remind");
    localIntent.putExtra("version", "1");
    return localIntent;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((NotificationManager)paramQQAppInterface.a().getSystemService("notification")).cancel(120);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, boolean paramBoolean, int paramInt2, String paramString2)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a(paramInt1, paramQQAppInterface);
    Notification localNotification = new Notification(2130841297, paramString1, System.currentTimeMillis());
    localNotification.flags = 16;
    Object localObject2 = null;
    int k = 0;
    int j = 1;
    int i = j;
    paramInt1 = k;
    Object localObject1 = localObject2;
    switch (paramInt2)
    {
    default: 
      localObject1 = localObject2;
      paramInt1 = k;
      i = j;
    case 3: 
      label95:
      paramString2 = new FowardIntent(paramQQAppInterface.a(), QzoneWrapperActivity.class, TranslucentActivity.class);
      paramString2.addFlags(268435456);
      if (localObject1 != null) {
        paramString2.putExtras((Intent)localObject1);
      }
      paramString2 = PendingIntent.getActivity(paramQQAppInterface.a(), 124, paramString2, 268435456);
      if (paramBoolean) {
        if (paramInt2 == 2) {
          localNotification.setLatestEventInfo(paramQQAppInterface.a(), BaseApplication.getContext().getString(2131366710), paramString1, paramString2);
        }
      }
      break;
    }
    for (;;)
    {
      ((NotificationManager)paramQQAppInterface.a().getSystemService("notification")).notify(paramInt1, localNotification);
      if (paramQQAppInterface == null) {
        break;
      }
      QZoneHelper.a(paramQQAppInterface);
      if (GuardManager.a == null) {
        break;
      }
      GuardManager.a.b(0, null);
      return;
      localObject1 = b(paramQQAppInterface);
      ((Intent)localObject1).putExtra("launch_time", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("refer", "msg_notification");
      paramInt1 = 120;
      i = ((QZoneManagerImp)paramQQAppInterface.getManager(9)).a(1);
      break label95;
      localObject1 = a(paramQQAppInterface);
      paramInt1 = 127;
      i = j;
      break label95;
      localObject1 = a(paramString2);
      paramInt1 = 120;
      i = j;
      break label95;
      localNotification.setLatestEventInfo(paramQQAppInterface.a(), BaseApplication.getContext().getString(2131366710) + "(" + BaseApplication.getContext().getString(2131366384) + i + BaseApplication.getContext().getString(2131366385) + BaseApplication.getContext().getString(2131367357) + ")", paramString1, paramString2);
      continue;
      localNotification.setLatestEventInfo(paramQQAppInterface.a(), BaseApplication.getContext().getString(2131366710), paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.MsgNotification
 * JD-Core Version:    0.7.0.1
 */