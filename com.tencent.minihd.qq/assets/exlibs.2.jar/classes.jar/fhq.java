import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class fhq
  extends Thread
{
  public fhq(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    Object localObject1;
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p))
    {
      localObject1 = ((FriendManager)this.a.app.getManager(8)).c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q = ((String)localObject1);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
    }
    else if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 2)) {
        break label566;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a());
    }
    for (;;)
    {
      this.a.app.c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
      }
      localObject1 = GroupCatalogTool.a(BaseApplication.getContext()).a(this.a, Long.toString(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long));
      if (localObject1 != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i = ((GroupCatalogBean)localObject1).a();
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.h(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
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
            break label467;
          }
          localObject1 = ((TroopMemberInfo)localObject3).friendnick;
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label525;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.q = ((String)localObject1);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        break;
        label467:
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
      label525:
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        break;
      }
      this.a.b = true;
      this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.p);
      break;
      label566:
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fhq
 * JD-Core Version:    0.7.0.1
 */