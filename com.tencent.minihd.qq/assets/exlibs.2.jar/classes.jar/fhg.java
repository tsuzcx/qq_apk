import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

public class fhg
  extends Thread
{
  public fhg(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    Object localObject1 = ((FriendManager)this.a.app.getManager(8)).c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q = ((String)localObject1);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "mTroopInfoData.troopOwnerNick = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q);
      }
      return;
      Object localObject2 = null;
      Object localObject3 = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p);
      if (localObject3 == null)
      {
        localObject3 = DBUtils.a().a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject3).friendnick)) {
            break label247;
          }
          localObject1 = ((TroopMemberInfo)localObject3).friendnick;
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label305;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q = ((String)localObject1);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        break;
        label247:
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject3).troopnick))
        {
          localObject1 = ((TroopMemberInfo)localObject3).troopnick;
          continue;
          if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject3).nick))
          {
            localObject1 = ((TroopMemberCardInfo)localObject3).nick;
          }
          else
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject3).name)) {
              localObject1 = ((TroopMemberCardInfo)localObject3).name;
            }
          }
        }
      }
      label305:
      if ((!this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null))
      {
        this.a.b = true;
        this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fhg
 * JD-Core Version:    0.7.0.1
 */