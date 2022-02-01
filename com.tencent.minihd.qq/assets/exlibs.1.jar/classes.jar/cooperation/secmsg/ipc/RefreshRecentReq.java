package cooperation.secmsg.ipc;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class RefreshRecentReq
  extends BaseReq
{
  public static final String a = "RefreshRecentReq_command";
  public static final String b = "RefreshRecentReq_showSecMsg";
  public static final String c = "RefreshRecentReq_msgTime";
  public static final int d = 1;
  private static final String d = RefreshRecentReq.class.getName();
  public static final int e = 2;
  public long a;
  public boolean a;
  public int f = 0;
  
  public RefreshRecentReq()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "add secmsg to ru show=" + this.jdField_a_of_type_Boolean + ", msgTime=" + this.jdField_a_of_type_Long);
      }
      localRecentUserProxy = paramQQAppInterface.a().a();
      localRecentUser = localRecentUserProxy.a(AppConstants.as, 9001);
    } while (localRecentUser == null);
    if (this.jdField_a_of_type_Boolean)
    {
      localRecentUser.uin = AppConstants.as;
      localRecentUser.type = 9001;
      if (localRecentUser.lastmsgtime < this.jdField_a_of_type_Long) {
        localRecentUser.lastmsgtime = this.jdField_a_of_type_Long;
      }
      localRecentUserProxy.a(localRecentUser);
    }
    for (;;)
    {
      b(paramQQAppInterface);
      return true;
      localRecentUserProxy.b(localRecentUser);
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "refresh recent");
      }
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendEmptyMessage(1009);
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putInt("RefreshRecentReq_command", this.f);
    paramBundle.putBoolean("RefreshRecentReq_showSecMsg", this.jdField_a_of_type_Boolean);
    paramBundle.putLong("RefreshRecentReq_msgTime", this.jdField_a_of_type_Long);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    switch (this.f)
    {
    default: 
      return;
    case 2: 
      a(paramQQAppInterface);
      return;
    }
    b(paramQQAppInterface);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.f = paramBundle.getInt("RefreshRecentReq_command");
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("RefreshRecentReq_showSecMsg", true);
    this.jdField_a_of_type_Long = paramBundle.getLong("RefreshRecentReq_msgTime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.secmsg.ipc.RefreshRecentReq
 * JD-Core Version:    0.7.0.1
 */