package com.tencent.mobileqq.servlet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class QZoneManagerImp
  implements QZoneManager
{
  private static long jdField_a_of_type_Long = 600000L;
  private static final long jdField_b_of_type_Long = 300000L;
  private static long c = 30000L;
  public static final String d = "https://scannon.3g.qq.com/api";
  public static final String e = "https://scannon.3g.qq.com/";
  public static final int f = 0;
  public static final String f = "Feeds";
  public static final int g = 1;
  public static final String g = "QZONE_UNREAD";
  public static final String h = "notify_type";
  public static final String i = ".ZebraAlbum";
  private static final String j = "Q.lebatab.QZoneManagerImp";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private long[] jdField_a_of_type_ArrayOfLong;
  private boolean jdField_b_of_type_Boolean;
  private int h = 1;
  private int i = 0;
  
  public QZoneManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = ReflectedMethods.a(paramQQAppInterface.a(), "QZONE_UNREAD");
    b();
    b(jdField_a_of_type_Long);
  }
  
  private void a()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    int k = 0;
    while (k < this.jdField_a_of_type_ArrayOfLong.length)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if ((str != null) && (str.length() > 0))
        {
          if (k == this.jdField_a_of_type_ArrayOfLong[5]) {
            QLog.d("Q.lebatab.QZoneManagerImp.ZebraAlbum", 4, "QZoneManagerImp save zebra unread: " + this.jdField_a_of_type_ArrayOfLong[5] + "to sharerefrence");
          }
          localEditor.putLong(str + k + "", this.jdField_a_of_type_ArrayOfLong[k]);
        }
      }
      k += 1;
    }
    localEditor.commit();
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    return LocalMultiProcConfig.a(paramQQAppInterface.a().getApplicationContext().getString(2131366826) + paramQQAppInterface.getAccount(), true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ArrayOfLong = new long[6];
    int k = 0;
    while (k < 6)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        if ((str != null) && (str.length() > 0)) {
          this.jdField_a_of_type_ArrayOfLong[k] = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str + k + "", 0L);
        }
      }
      k += 1;
    }
  }
  
  public int a(int paramInt)
  {
    int k = 0;
    if (paramInt == 1) {
      k = (int)this.jdField_a_of_type_ArrayOfLong[1];
    }
    do
    {
      return k;
      if (paramInt == 0) {
        return (int)this.jdField_a_of_type_ArrayOfLong[0];
      }
    } while (paramInt != 5);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.lebatab.QZoneManagerImp.ZebraAlbum", 4, "QZoneManagerImp getFeedCount type  ZEBRA_ALBUM:" + (int)this.jdField_a_of_type_ArrayOfLong[5]);
    }
    return (int)this.jdField_a_of_type_ArrayOfLong[5];
  }
  
  public long a()
  {
    long l2 = -1L;
    long l1 = l2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      l1 = l2;
      if (this.i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        l2 = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(this.i)).longValue();
        this.i += 1;
        l1 = l2;
        if (this.i >= this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          this.i = 0;
          l1 = l2;
        }
      }
    }
    return l1;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ArrayOfLong[3]);
  }
  
  public void a(int paramInt)
  {
    Intent localIntent;
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ArrayOfLong[1] = 0L;
      a();
      if (paramInt != 0) {
        break label85;
      }
      localIntent = new Intent("com.tencent.qq.syncFriendFeedMessage");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
    label85:
    do
    {
      do
      {
        return;
        if (paramInt == 0)
        {
          this.jdField_a_of_type_ArrayOfLong[0] = 0L;
          break;
        }
      } while (paramInt != 5);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.lebatab.QZoneManagerImp.ZebraAlbum", 4, "QZoneManagerImp clearReadCount cache arrays zebra");
      }
      this.jdField_a_of_type_ArrayOfLong[5] = 0L;
      break;
      if (paramInt == 1)
      {
        localIntent = new Intent("com.tencent.qq.syncMyFeedMessage");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
        return;
      }
    } while (paramInt != 5);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    int m = 0;
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.QZoneManagerImp", 2, "setFeedCount.feedtype=" + paramInt1 + ",count=" + paramInt2 + ",uin=" + paramLong);
    }
    if (paramInt1 == 0) {
      if (this.jdField_a_of_type_ArrayOfLong[0] == paramInt2) {
        break label356;
      }
    }
    label356:
    for (k = 1;; k = 0)
    {
      this.jdField_a_of_type_ArrayOfLong[0] = paramInt2;
      this.jdField_a_of_type_ArrayOfLong[3] = paramLong;
      a();
      Object localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
      ((NewIntent)localObject).setAction("Qzone_Refresh_UI");
      ((NewIntent)localObject).putExtra("notify_type", paramInt1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      if (paramInt1 == 0)
      {
        paramString = new Intent("com.tencent.qq.syncFriendFeedMessage");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramString);
      }
      do
      {
        do
        {
          return;
          if (paramInt1 == 1)
          {
            if (this.jdField_a_of_type_ArrayOfLong[1] != paramInt2) {
              k = 1;
            }
            this.jdField_a_of_type_ArrayOfLong[1] = paramInt2;
            this.jdField_a_of_type_ArrayOfLong[4] = paramLong;
            break;
          }
        } while (paramInt1 != 5);
        k = m;
        if (this.jdField_a_of_type_ArrayOfLong[5] != paramInt2) {
          k = 1;
        }
        this.jdField_a_of_type_ArrayOfLong[5] = paramInt2;
        break;
        if (paramInt1 == 1)
        {
          localObject = new Intent("com.tencent.qq.syncMyFeedMessage");
          if (!TextUtils.isEmpty(paramString))
          {
            ((Intent)localObject).putExtra("com.tencent.qq.syncMyFeedMessagelist", paramString);
            ((Intent)localObject).putExtra("com.tencent.qq.syncMyFeedMessageUin", paramLong);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast((Intent)localObject);
          return;
        }
      } while ((paramInt1 != 5) || (k == 0));
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.lebatab.QZoneManagerImp.ZebraAlbum", 4, "setFeedCount signal count  method send broadcast to update qzone UI.\nBROADCAST_SYNC_FRIEND_ZEBRA_MESSAGE");
      }
      paramString = new Intent("com.tencent.qq.syncFriendZebraAlbumMsg");
      paramString.putExtra("com.tencent.qq.syncFriendZebraAlbumMsgunread", paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramString);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (str != null)
      {
        LocalMultiProcConfig.a("creditlevel", paramInt, Long.valueOf(str).longValue());
        LocalMultiProcConfig.a("creditmessage", paramString, Long.valueOf(str).longValue());
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (str != null) {
        LocalMultiProcConfig.a("qzone_jinyan", (int)(0x8000 & paramLong), Long.valueOf(str).longValue());
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.h == 0) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      paramString1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
      paramString1.setAction("Qzone_Get_NewAndUnread_Count");
      paramString1.putExtra("qzone_send_by_time", 3);
      paramString1.putExtra("scene", 100);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.QZoneManagerImp", 2, "setEnterQZone.isenter=" + paramBoolean);
    }
    this.b = paramBoolean;
  }
  
  public void a(long[] paramArrayOfLong, ArrayList paramArrayList)
  {
    int k = 0;
    if (this.b)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.lebatab.QZoneManagerImp.ZebraAlbum", 4, "setFeedCount.user enter qzone.dismiss data.");
      }
      return;
    }
    int m = a(0);
    int i1 = a(1);
    int n = a(5);
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
    if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.jdField_a_of_type_ArrayOfLong[1] = i1;
      this.jdField_a_of_type_ArrayOfLong[5] = n;
    }
    a();
    QLog.i("Feeds", 1, "setFeedCount.olddata:friendfeed=" + m + ",myfeed=" + i1);
    if (paramArrayOfLong.length == 3)
    {
      QLog.i("Feeds", 1, "setFeedCount.friendfeed=" + paramArrayOfLong[0] + ",myfeed=" + paramArrayOfLong[1] + ",2=" + paramArrayOfLong[2]);
      label180:
      if (this.jdField_a_of_type_ArrayOfLong[0] == m) {
        break label440;
      }
    }
    label440:
    for (m = 1;; m = 0)
    {
      if (this.jdField_a_of_type_ArrayOfLong[1] != i1)
      {
        k = 1;
        m = 1;
      }
      if (this.jdField_a_of_type_ArrayOfLong[5] != n)
      {
        k = 5;
        m = 1;
      }
      if (m == 0) {
        break;
      }
      if (k == 0)
      {
        paramArrayOfLong = new Intent("com.tencent.qq.syncFriendFeedMessage");
        if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
          paramArrayOfLong.putExtra("com.tencent.qq.syncFriendFeedFriends", paramArrayList);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramArrayOfLong);
        return;
        if (paramArrayOfLong.length < 4) {
          break label180;
        }
        QLog.i("Feeds", 1, "setFeedCount.friendfeed=" + paramArrayOfLong[0] + ",myfeed=" + paramArrayOfLong[1] + ",2=" + paramArrayOfLong[2] + ",3=" + paramArrayOfLong[3]);
        break label180;
      }
      if (k == 1)
      {
        paramArrayOfLong = new Intent("com.tencent.qq.syncMyFeedMessage");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramArrayOfLong);
        return;
      }
      if (k != 5) {
        break;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.lebatab.QZoneManagerImp.ZebraAlbum", 4, "setFeedCount long[] result method send broadcast to update qzone UI.");
      }
      paramArrayOfLong = new Intent("com.tencent.qq.syncFriendZebraAlbumMsg");
      paramArrayOfLong.putExtra("com.tencent.qq.syncFriendZebraAlbumMsgunread", this.jdField_a_of_type_ArrayOfLong[5]);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramArrayOfLong);
      return;
    }
  }
  
  public boolean a()
  {
    return this.i == 0;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.QZoneManagerImp", 2, "sendGetFeedByTime.begin.");
    }
    if (this.jdField_a_of_type_Boolean) {}
    label22:
    do
    {
      do
      {
        do
        {
          break label22;
          do
          {
            return;
          } while (this.h == 0);
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.QZoneManagerImp", 2, "sendGetFeedByTime. by servlet.");
          }
          if (paramInt != 1) {
            break;
          }
          localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
          localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
          localNewIntent.putExtra("qzone_send_by_time", paramInt);
          localNewIntent.putExtra("scene", 103);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
        } while (!QLog.isColorLevel());
        QLog.d("Q.lebatab.QZoneManagerImp", 2, "sendGetFeedByTime.switch to forground.");
        return;
      } while ((paramInt != 2) || (System.currentTimeMillis() - QZoneNotifyServlet.jdField_a_of_type_Long <= QZoneHelper.b()) || (a(1) > 0));
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QZoneNotifyServlet.class);
      localNewIntent.setAction("Qzone_Get_NewAndUnread_Count");
      localNewIntent.putExtra("qzone_send_by_time", paramInt);
      localNewIntent.putExtra("scene", 103);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebatab.QZoneManagerImp", 2, "sendGetFeedByTime.click leba.");
  }
  
  public void b(long paramLong)
  {
    if ((paramLong != jdField_a_of_type_Long) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0))
    {
      jdField_a_of_type_Long = paramLong;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      while (paramLong >= 300000L)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(300000L));
        paramLong -= 300000L;
      }
      if (paramLong > 0L) {
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
      }
      this.i = 0;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp
 * JD-Core Version:    0.7.0.1
 */