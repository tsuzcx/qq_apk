package com.tencent.mobileqq.servlet;

import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneSubAccountUnreadServlet
  extends MSFServlet
{
  public static final String a = QzoneSubAccountUnreadServlet.class.getSimpleName();
  public static final String b = "Qzone_Get_SubAccount_Count";
  public static final String c = "scene";
  public static final String d = "qzone_get_sub_account_unread";
  public static final String e = "qzone_get_sub_account_unread_uin";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent instanceof GetSubAccountUnreadIntent))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "get subaccount unread count,get response");
      }
      paramFromServiceMsg = QZoneFeedCountPackeger.a(paramFromServiceMsg.getWupBuffer(), (QQAppInterface)getAppRuntime(), paramIntent.getLongExtra("qzone_get_sub_account_unread_uin", 0L));
      if (((GetSubAccountUnreadIntent)paramIntent).a != null) {
        ((GetSubAccountUnreadIntent)paramIntent).a.a(paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = (QQAppInterface)getAppRuntime();
    if (paramIntent.getAction().equals("Qzone_Get_SubAccount_Count"))
    {
      int i = ((QQAppInterface)localObject).a().getResources().getDisplayMetrics().widthPixels;
      int j = ((QQAppInterface)localObject).a().getResources().getDisplayMetrics().heightPixels;
      int k = paramIntent.getIntExtra("scene", 102);
      if ((paramIntent instanceof GetSubAccountUnreadIntent))
      {
        localObject = QZoneFeedCountPackeger.a(Long.valueOf(((QQAppInterface)localObject).a()).longValue(), null, i, j, k, paramIntent.getLongExtra("qzone_get_sub_account_unread_uin", 0L));
        if (localObject != null) {
          break label153;
        }
        paramIntent = ((GetSubAccountUnreadIntent)paramIntent).a;
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "get subaccount unread count,encode error");
        }
        if (paramIntent != null)
        {
          paramIntent.a(null);
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "get subaccount unread count,listen is null");
          }
        }
      }
    }
    return;
    label153:
    paramPacket.setSSOCommand("SQQzoneSvc." + "getRelateUserCount");
    paramPacket.putSendData((byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QzoneSubAccountUnreadServlet
 * JD-Core Version:    0.7.0.1
 */