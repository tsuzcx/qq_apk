import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class fjm
  extends TroopObserver
{
  public fjm(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  protected void a(String arg1, String paramString2, String paramString3, int paramInt)
  {
    if (!this.a.i.equals(???)) {}
    TroopMemberInfo localTroopMemberInfo;
    do
    {
      return;
      paramString3 = (FriendsManagerImp)this.a.app.getManager(8);
      localTroopMemberInfo = DBUtils.a().a(this.a.app, this.a.i, paramString2);
    } while ((localTroopMemberInfo == null) || (paramString3 == null));
    this.a.c(paramString2);
    synchronized (this.a.jdField_a_of_type_JavaUtilList)
    {
      paramString2 = this.a.a(localTroopMemberInfo, paramString3);
      this.a.jdField_a_of_type_JavaUtilList.add(paramString2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
      return;
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivity", 2, "onDeleteTroopMember, isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    }
    if (paramBoolean)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.a.c((String)paramArrayList.get(0));
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6));
      }
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(7));
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivity", 2, "onGetTroopInfoResult, isSuccess:" + paramBoolean + " returnUin:" + paramString + " mTroopUin:" + this.a.i + " time:" + (System.currentTimeMillis() - this.a.b) / 1000L + "s");
    }
    if ((!paramBoolean) || (!this.a.i.equals(paramString))) {}
    do
    {
      return;
      this.a.getSharedPreferences("last_update_time" + this.a.app.a(), 0).edit().putLong("key_troop_info_last_update" + this.a.i, System.currentTimeMillis()).commit();
      paramString = ((FriendManager)this.a.app.getManager(8)).a(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramString;
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
      this.a.j = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
      this.a.k = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
    }
    paramString = this.a;
    if ((this.a.app.a().equals(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin)) || ((this.a.k != null) && (this.a.k.contains(this.a.app.a()))))
    {
      paramBoolean = true;
      paramString.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.a.j == null) || (!this.a.j.equals(this.a.app.a()))) {
        break label418;
      }
    }
    for (this.a.q = "0";; this.a.q = "1") {
      label418:
      do
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9));
        return;
        paramBoolean = false;
        break;
      } while ((this.a.k == null) || (!this.a.k.contains(this.a.app.a())));
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3)
  {
    this.a.runOnUiThread(new fjn(this, paramBoolean1, paramString1, paramBoolean2, paramString3, paramString2));
  }
  
  protected void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivity", 2, "onUpdateTroopGetMemberList:" + paramBoolean + " time:" + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long) / 1000L + "s");
    }
    if (paramBoolean) {}
    try
    {
      this.a.getSharedPreferences("last_update_time" + this.a.app.a(), 0).edit().putLong("key_last_update_time" + this.a.i, System.currentTimeMillis()).commit();
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      Object[] arrayOfObject = this.a.b(this.a.i);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, arrayOfObject));
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivity", 2, "onUpdateTroopGetMemberList:" + localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fjm
 * JD-Core Version:    0.7.0.1
 */