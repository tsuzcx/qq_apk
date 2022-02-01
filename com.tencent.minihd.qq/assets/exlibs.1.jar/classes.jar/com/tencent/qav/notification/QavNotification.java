package com.tencent.qav.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.tencent.qav.activity.QavChatActivity;
import com.tencent.qav.activity.QavInviteActivity;
import com.tencent.qav.ipc.QavService;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.session.QavSession;
import java.util.Locale;
import ljx;

public class QavNotification
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "QavNotification";
  private Notification jdField_a_of_type_AndroidAppNotification;
  private Context jdField_a_of_type_AndroidContentContext;
  private RemoteViews jdField_a_of_type_AndroidWidgetRemoteViews;
  private ljx jdField_a_of_type_Ljx;
  
  public QavNotification(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private String a(long paramLong)
  {
    String str = "00:00";
    long l1 = paramLong / 1000L;
    long l2;
    if (l1 > 0L)
    {
      paramLong = l1 % 60L;
      l2 = l1 / 60L;
      l1 = l2 / 60L;
      l2 %= 60L;
      if (l1 > 0L) {
        str = String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(paramLong) });
      }
    }
    else
    {
      return str;
    }
    return String.format(Locale.CHINA, "%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong) });
  }
  
  private void a(Notification paramNotification, String paramString) {}
  
  private void a(ljx paramljx, String paramString)
  {
    if (paramljx == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAppNotification == null)
    {
      this.jdField_a_of_type_AndroidAppNotification = new Notification();
      this.jdField_a_of_type_AndroidAppNotification.when = System.currentTimeMillis();
    }
    if (this.jdField_a_of_type_AndroidWidgetRemoteViews == null) {
      this.jdField_a_of_type_AndroidWidgetRemoteViews = new RemoteViews(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 2130903483);
    }
    String str1 = "";
    Intent localIntent;
    String str2;
    PendingIntent localPendingIntent;
    switch (paramljx.jdField_a_of_type_Int)
    {
    case 43: 
    case 44: 
    default: 
      localIntent = null;
      str2 = "";
      localPendingIntent = null;
      if (localIntent != null)
      {
        localIntent.addFlags(4194304);
        localIntent.addFlags(262144);
        if ((paramljx.jdField_a_of_type_Int != 40) && (paramljx.jdField_a_of_type_Int != 45)) {
          localIntent.addFlags(268435456);
        }
        localPendingIntent = PendingIntent.getActivity(this.jdField_a_of_type_AndroidContentContext, 0, localIntent, 134217728);
      }
      if (paramString == null) {
        break;
      }
    }
    for (;;)
    {
      AVLog.d("QavNotification", String.format("updateNotification sessionId=%s type=%s header=%s title=%s state=%s", new Object[] { paramljx.jdField_a_of_type_JavaLangString, Integer.valueOf(paramljx.jdField_a_of_type_Int), paramljx.jdField_a_of_type_AndroidGraphicsBitmap, str2, paramString }));
      if (paramljx.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewBitmap(2131298475, paramljx.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131298477, paramljx.b);
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131298479, paramString);
      try
      {
        paramljx = this.jdField_a_of_type_AndroidAppNotification;
        paramljx.flags |= 0x2;
        paramljx = this.jdField_a_of_type_AndroidAppNotification;
        paramljx.flags |= 0x8;
        paramljx = this.jdField_a_of_type_AndroidAppNotification;
        paramljx.flags |= 0x20;
        this.jdField_a_of_type_AndroidAppNotification.contentView = this.jdField_a_of_type_AndroidWidgetRemoteViews;
        this.jdField_a_of_type_AndroidAppNotification.contentIntent = localPendingIntent;
        a(true, this.jdField_a_of_type_AndroidAppNotification);
        return;
      }
      catch (Exception paramljx)
      {
        AVLog.e("QavNotification", "updateNotification fail.", paramljx);
        return;
      }
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QavInviteActivity.class);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131362854);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131362951);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838979;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131298478, 2130838979);
      break;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QavChatActivity.class);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131362854);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363091);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838979;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131298478, 2130838979);
      break;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QavChatActivity.class);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363017);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838979;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131298478, 2130838979);
      str2 = str1;
      break;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QavInviteActivity.class);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131363050);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131362892);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838900;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131298478, 2130838900);
      break;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QavChatActivity.class);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131363050);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363091);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838900;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131298478, 2130838900);
      break;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QavChatActivity.class);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363018);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str1;
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130838900;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131298478, 2130838900);
      str2 = str1;
      break;
      paramString = str1;
    }
  }
  
  private void a(boolean paramBoolean, Notification paramNotification)
  {
    AVLog.d("QavNotification", String.format("setQavServiceForeground foreground=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QavService.class);
    localIntent.putExtra("extra_action", "action_set_foreground");
    localIntent.putExtra("extra_foreground", paramBoolean);
    localIntent.putExtra("extra_notification", paramNotification);
    this.jdField_a_of_type_AndroidContentContext.startService(localIntent);
  }
  
  public void a()
  {
    try
    {
      AVLog.d("QavNotification", "cancelNotification");
      a(false, null);
      this.jdField_a_of_type_AndroidAppNotification = null;
      this.jdField_a_of_type_AndroidWidgetRemoteViews = null;
      this.jdField_a_of_type_Ljx = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_Ljx != null)
      {
        String str = a(paramLong);
        a(this.jdField_a_of_type_Ljx, str);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(QavSession paramQavSession, int paramInt, String paramString, Bitmap paramBitmap)
  {
    try
    {
      if (this.jdField_a_of_type_Ljx == null) {
        this.jdField_a_of_type_Ljx = new ljx(this, null);
      }
      this.jdField_a_of_type_Ljx.jdField_a_of_type_JavaLangString = paramQavSession.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Ljx.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Ljx.b = paramString;
      this.jdField_a_of_type_Ljx.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      a(this.jdField_a_of_type_Ljx, null);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.notification.QavNotification
 * JD-Core Version:    0.7.0.1
 */