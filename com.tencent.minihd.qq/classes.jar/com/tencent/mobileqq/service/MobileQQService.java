package com.tencent.mobileqq.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.tencent.biz.bmqq.protocol.BmqqBusinessService;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.compatible.ActionListener;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.RegisterProxySvcPack.RegisterProxySvcPackService;
import com.tencent.mobileqq.service.cardpay.CardPayService;
import com.tencent.mobileqq.service.config.ConfigService;
import com.tencent.mobileqq.service.discussion.DiscussionService;
import com.tencent.mobileqq.service.friendlist.FriendListService;
import com.tencent.mobileqq.service.lbs.LBSService;
import com.tencent.mobileqq.service.message.MessageService;
import com.tencent.mobileqq.service.profile.ProfileService;
import com.tencent.mobileqq.service.push.PushService;
import com.tencent.mobileqq.service.qwallet.QWalletAuthService;
import com.tencent.mobileqq.service.qwallet.QWalletHomeService;
import com.tencent.mobileqq.service.qwallet.QWalletOpenService;
import com.tencent.mobileqq.service.qwallet.UniPayService;
import com.tencent.mobileqq.service.qzone.QZoneService;
import com.tencent.mobileqq.service.report.ReportService;
import com.tencent.mobileqq.util.NotifyLightUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import com.tencent.util.notification.NotificationFactory;
import com.tencent.util.notification.QQNotificationManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import juu;
import juv;
import juw;

public class MobileQQService
  implements AppConstants
{
  public static final int a = 1;
  public static final String a = "MobileQQService";
  public static final int b = 2;
  public static final String b = "req_pb_protocol_flag";
  public static volatile int c = 0;
  private static final String jdField_c_of_type_JavaLangString = "sendtimekey";
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new juw(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ActionListener jdField_a_of_type_ComTencentMobileqqCompatibleActionListener = new juu(this);
  private QQNotificationManager jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public boolean a;
  boolean b = true;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = 0;
  private volatile boolean f = false;
  
  static
  {
    jdField_c_of_type_Int = 0;
  }
  
  public MobileQQService(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    PendingIntent localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 134217728);
    Notification localNotification;
    int i;
    if (!MobileIssueSettings.e)
    {
      localNotification = KapalaiAdapterUtil.a().a(BaseApplication.getContext(), 2130838569);
      paramIntent = localNotification;
      if (QLog.isColorLevel())
      {
        QLog.i("MobileQQService", 2, "buildIdleNotification by newNotificationForMeizu. nf=" + localNotification);
        paramIntent = localNotification;
      }
      paramIntent.icon = 2130838569;
      if (!this.jdField_c_of_type_Boolean) {
        break label189;
      }
      if (paramBitmap != null)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("icon");
        if ((i > 0) && (paramIntent.contentView != null)) {
          paramIntent.contentView.setImageViewBitmap(i, paramBitmap);
        }
      }
      paramIntent.setLatestEventInfo(BaseApplication.getContext(), paramString1, paramString2, localPendingIntent);
    }
    label189:
    do
    {
      do
      {
        return paramIntent;
        localNotification = new Notification(2130838569, null, System.currentTimeMillis());
        paramIntent = localNotification;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MobileQQService", 2, "buildIdleNotification by default. nf=" + localNotification);
        paramIntent = localNotification;
        break;
        paramIntent.setLatestEventInfo(BaseApplication.getContext(), paramString1, paramString2, localPendingIntent);
      } while (paramBitmap == null);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("icon");
    } while ((i <= 0) || (paramIntent.contentView == null));
    paramIntent.contentView.setImageViewBitmap(i, paramBitmap);
    return paramIntent;
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
    PendingIntent localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 268435456);
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQService", 2, "buildNotification by getActivity. contentIntent=" + localPendingIntent);
    }
    int j = 2130838570;
    int i = j;
    if (paramIntent.getIntExtra("uintype", -1) == 1008)
    {
      if (AppConstants.T.equals(paramIntent.getStringExtra("uin"))) {
        i = j;
      }
    }
    else
    {
      boolean bool = paramIntent.getBooleanExtra("key_notifycation_oneway_message", false);
      j = i;
      if (bool)
      {
        j = i;
        if (paramIntent.getIntExtra("uintype", -1) == 1010) {
          j = 2130840383;
        }
      }
      i = j;
      if (bool)
      {
        i = j;
        if (paramIntent.getIntExtra("uintype", -1) == 1001) {
          i = 2130838439;
        }
      }
      if (paramIntent.getBooleanExtra("qav_notify_flag", false)) {
        i = 2130838900;
      }
      paramIntent = NotificationFactory.a("").setSmallIcon(i).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(paramString1);
      if (NotifyLightUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        Calendar.getInstance().get(11);
        paramIntent.setLights(-16711936, 2000, 2000);
      }
      if (!this.jdField_c_of_type_Boolean) {
        break label318;
      }
      if (paramBitmap != null) {
        paramIntent.setLargeIcon(paramBitmap);
      }
      paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent(localPendingIntent);
    }
    for (;;)
    {
      if ((Build.VERSION.SDK_INT >= 24) || (this.b)) {
        paramIntent.setPriority(1).setVibrate(new long[0]);
      }
      paramIntent = paramIntent.build();
      QQNotificationManager.a(paramIntent, "CHANNEL_ID_SHOW_BADGE");
      return paramIntent;
      i = 2130838652;
      break;
      label318:
      paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent(localPendingIntent);
      if (paramBitmap != null) {
        paramIntent.setLargeIcon(paramBitmap);
      }
    }
  }
  
  private void a(boolean paramBoolean) {}
  
  private boolean a(BaseProtocolCoder paramBaseProtocolCoder)
  {
    int i = 0;
    String[] arrayOfString = paramBaseProtocolCoder.a();
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return false;
    }
    while (i < arrayOfString.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(arrayOfString[i], paramBaseProtocolCoder);
      i += 1;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return ("OnlinePush.PbPushGroupMsg".equalsIgnoreCase(paramString)) || ("OnlinePush.PbPushDisMsg".equalsIgnoreCase(paramString)) || ("OnlinePush.PbC2CMsgSync".equalsIgnoreCase(paramString)) || ("NearFieldTranFileSvr.NotifyList".equalsIgnoreCase(paramString)) || ("NearFieldDiscussSvr.NotifyList".equalsIgnoreCase(paramString));
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    Object localObject = new ProfileService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((ProfileService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new FriendListService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((FriendListService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new MessageService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((MessageService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new LBSService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((LBSService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new QZoneService();
    ((QZoneService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new PushService();
    ((PushService)localObject).a();
    a((BaseProtocolCoder)localObject);
    ((PushService)localObject).a(this.jdField_a_of_type_ComTencentMobileqqCompatibleActionListener);
    localObject = new ConfigService();
    ((ConfigService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new ReportService();
    ((ReportService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new DiscussionService();
    ((DiscussionService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new RegisterProxySvcPackService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((RegisterProxySvcPackService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new VIPService();
    ((VIPService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new CardPayService();
    ((CardPayService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new QWalletOpenService();
    ((QWalletOpenService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new QWalletHomeService();
    ((QWalletHomeService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new BmqqBusinessService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((BmqqBusinessService)localObject).a();
    a((BaseProtocolCoder)localObject);
    localObject = new UniPayService();
    ((UniPayService)localObject).a();
    a((BaseProtocolCoder)localObject);
    this.f = true;
    localObject = new QWalletAuthService();
    ((QWalletAuthService)localObject).a();
    a((BaseProtocolCoder)localObject);
  }
  
  public BaseProtocolCoder a(String paramString)
  {
    if (!this.f) {}
    int i;
    try
    {
      if (!this.f) {
        c();
      }
      i = paramString.indexOf('.');
      if (i <= 1) {
        return null;
      }
    }
    finally {}
    paramString = paramString.substring(0, i);
    return (BaseProtocolCoder)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager == null) && (this.d < 3)) {}
    try
    {
      this.jdField_c_of_type_Boolean = DeviceInfoUtil.a();
      a(true);
      this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager = QQNotificationManager.a();
      if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a() == null) {
        this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager = null;
      }
      jdField_c_of_type_Int = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
      if (QLog.isColorLevel()) {
        QLog.i("MobileQQService", 2, "MobileQQService has created. mNM=" + this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager);
      }
      this.d += 1;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "e = " + localException.toString());
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if ((this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication() != null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("stopForegroundCompat", paramInt);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a(int paramInt, Notification paramNotification)
  {
    int j = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {}
    for (;;)
    {
      int i;
      try
      {
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        QCallFacade localQCallFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localQCallFacade == null) {
          break label238;
        }
        i = localQCallFacade.a();
        if (localQQMessageFacade == null) {
          break label243;
        }
        j = localQQMessageFacade.e();
      }
      catch (Throwable paramNotification)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MobileQQService", 2, "startForegroundCompat exception. id=" + paramInt + ", mNM=" + this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager, paramNotification);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BadgeUtilImpl", 2, "startForegroundCompat changeMI6Badge count=" + j);
      }
      BadgeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), j, paramNotification);
      this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("startForegroundCompat", paramInt, paramNotification);
      return;
      if (paramInt == 129)
      {
        j = i;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("MobileQQService", 2, "startForegroundCompat. id=" + paramInt + ", mNM=" + this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager);
        }
      }
      else
      {
        j = 1;
        continue;
        label238:
        i = 0;
        continue;
        label243:
        if (paramInt != 121) {}
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = new juv(this, paramToServiceMsg);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.a().post(paramToServiceMsg);
      return;
    }
    paramToServiceMsg.run();
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    BusinessHandler localBusinessHandler = null;
    if (paramToServiceMsg == null) {
      return;
    }
    float f1 = (float)(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")) / 1000.0F;
    label105:
    boolean bool;
    label165:
    Object localObject;
    label203:
    int i;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MobileQQService", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f1) + "sec.");
      }
      bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
      if (QLog.isDevelopLevel()) {
        QLog.d("Troop", 4, "bPbResp:" + bool);
      }
      if (bool) {
        break label816;
      }
      bool = a(paramFromServiceMsg.getServiceCmd());
      paramException = (IBaseActionListener)paramToServiceMsg.getAttribute("listener");
      if (paramException != null) {
        paramToServiceMsg.actionListener = paramException;
      }
      if (bool) {
        break label810;
      }
      localObject = a(paramFromServiceMsg.getServiceCmd());
      paramException = localBusinessHandler;
      if (paramBoolean)
      {
        if (!bool) {
          break label680;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "PB cmd: recv cmd: " + paramFromServiceMsg.getServiceCmd());
        }
        paramException = localBusinessHandler;
        if (paramFromServiceMsg.getWupBuffer() != null)
        {
          i = paramFromServiceMsg.getWupBuffer().length - 4;
          paramException = new byte[i];
          PkgTools.a(paramException, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          paramFromServiceMsg.putWupBuffer(paramException);
          paramException = paramFromServiceMsg.getWupBuffer();
        }
      }
    }
    label680:
    label810:
    label816:
    label819:
    for (;;)
    {
      for (;;)
      {
        LoadingStateManager.a().a(paramFromServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!bool) && (localObject == null)) {
          break;
        }
        localObject = (int[])Cmd2HandlerMap.a().get(paramFromServiceMsg.getServiceCmd());
        if ((localObject == null) || (localObject.length <= 0)) {
          break;
        }
        int j = localObject.length;
        i = 0;
        label359:
        if (i >= j) {
          break;
        }
        int k = localObject[i];
        localBusinessHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(k);
        if (localBusinessHandler != null) {}
        try
        {
          localBusinessHandler.a(paramToServiceMsg, paramFromServiceMsg, paramException);
          i += 1;
          break label359;
          if (paramFromServiceMsg.getResultCode() == 2008)
          {
            paramFromServiceMsg = BaseActivity.sTopActivity;
            paramToServiceMsg = paramFromServiceMsg;
            if (paramFromServiceMsg == null) {
              paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
            }
            paramFromServiceMsg = new Intent(paramToServiceMsg, NotificationActivity.class);
            paramFromServiceMsg.setFlags(872415232);
            paramFromServiceMsg.putExtra("type", 2);
            paramToServiceMsg.startActivity(paramFromServiceMsg);
            return;
          }
          if (paramException != null)
          {
            localObject = new ByteArrayOutputStream();
            paramException.printStackTrace(new PrintStream((OutputStream)localObject));
            paramException = new String(((ByteArrayOutputStream)localObject).toByteArray());
            if (!QLog.isColorLevel()) {
              break label105;
            }
            QLog.d("MobileQQService", 2, "[NOT SEND]cmd=" + paramFromServiceMsg.getServiceCmd() + ", " + paramException);
            break label105;
          }
          if (QLog.isColorLevel()) {
            QLog.w("MobileQQService", 2, "[RES]cmd=" + paramFromServiceMsg.getServiceCmd() + ",CODE=" + paramFromServiceMsg.getResultCode() + " during " + this.jdField_a_of_type_JavaTextDecimalFormat.format(f1) + "sec.");
          }
          if (((paramFromServiceMsg.getResultCode() != 1002) && (paramFromServiceMsg.getResultCode() != 1013)) || (!"ProfileService.CheckUpdateReq".equals(paramFromServiceMsg.getServiceCmd()))) {
            break label105;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
          break label105;
          if (localObject != null) {}
          try
          {
            ((BaseProtocolCoder)localObject).a(paramToServiceMsg, paramFromServiceMsg);
            paramException = ((BaseProtocolCoder)localObject).a(paramToServiceMsg, paramFromServiceMsg);
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            paramException = localBusinessHandler;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQService", 2, "bpc null");
          }
          paramException = null;
          break label819;
          if (QLog.isColorLevel())
          {
            QLog.d("MobileQQService", 2, "", localException1);
            paramException = localBusinessHandler;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.w("MobileQQService", 2, localBusinessHandler.getClass().getSimpleName() + " onReceive error,", localException2);
            }
          }
        }
      }
      localObject = null;
      break label203;
      break label165;
    }
  }
  
  public void b()
  {
    a(false);
    a(119);
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQService", 2, "MobileQQService has destroyed.");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (BaseProtocolCoder)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null)
        {
          try
          {
            ((BaseProtocolCoder)localObject).b();
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQService", 2, "bpc destory error " + localException, localException);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    this.f = false;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {
      this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("cancelNotification", paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.MobileQQService
 * JD-Core Version:    0.7.0.1
 */