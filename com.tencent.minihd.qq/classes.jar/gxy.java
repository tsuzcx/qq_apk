import QQService.AddDiscussMemberInfo;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.ResultRecord;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gxy
  extends Thread
{
  public gxy(SelectMemberActivity paramSelectMemberActivity, FriendManager paramFriendManager) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.a());
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c.size() - 1;
    if (i >= 0)
    {
      SelectMemberActivity.ResultRecord localResultRecord = (SelectMemberActivity.ResultRecord)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c.get(i);
      Object localObject2 = new AddDiscussMemberInfo();
      String str;
      Object localObject5;
      if (localResultRecord.jdField_a_of_type_Int == 4)
      {
        ((AddDiscussMemberInfo)localObject2).RefStr = localResultRecord.jdField_a_of_type_JavaLangString;
        ((AddDiscussMemberInfo)localObject2).Type = localResultRecord.jdField_a_of_type_Int;
        localArrayList.add(localObject2);
        str = (String)localObject1 + "、";
        localObject2 = null;
        if (localResultRecord.jdField_a_of_type_Int != 0) {
          break label312;
        }
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(localResultRecord.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject5 != null)
        {
          localObject1 = ((Friends)localObject5).name;
          if (!TextUtils.isEmpty(((Friends)localObject5).remark)) {
            break label302;
          }
          localObject2 = ((Friends)localObject5).name;
        }
        label189:
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label537;
        }
        localObject1 = str + localResultRecord.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        for (;;)
        {
          i -= 1;
          break;
          try
          {
            ((AddDiscussMemberInfo)localObject2).Uin = Long.valueOf(localResultRecord.jdField_a_of_type_JavaLangString).longValue();
            ((AddDiscussMemberInfo)localObject2).RefUin = Long.valueOf(localResultRecord.c).longValue();
          }
          catch (NumberFormatException localNumberFormatException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SelectMemberActivity", 2, "NumberFormatException!!! uin=" + localResultRecord.jdField_a_of_type_JavaLangString);
            }
          }
        }
        continue;
        label302:
        localObject3 = ((Friends)localObject5).remark;
        break label189;
        label312:
        if (localResultRecord.jdField_a_of_type_Int == 1)
        {
          localObject5 = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
          localObject1 = localObject3;
          if (localObject5 == null) {
            break label189;
          }
          localObject1 = localObject3;
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject5).friendnick)) {
            break label189;
          }
          localObject1 = ((TroopMemberInfo)localObject5).friendnick;
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject5).autoremark))
          {
            localObject3 = ((TroopMemberInfo)localObject5).friendnick;
            break label189;
          }
          localObject3 = ((TroopMemberInfo)localObject5).autoremark;
          break label189;
        }
        if (localResultRecord.jdField_a_of_type_Int == 2)
        {
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(localResultRecord.c, localResultRecord.jdField_a_of_type_JavaLangString);
          localObject1 = localObject3;
          if (localObject5 == null) {
            break label189;
          }
          localObject1 = localObject3;
          if (((DiscussionMemberInfo)localObject5).inteRemark == null) {
            break label189;
          }
          localObject1 = localObject3;
          if (((DiscussionMemberInfo)localObject5).inteRemark.length() <= 0) {
            break label189;
          }
          localObject1 = ((DiscussionMemberInfo)localObject5).inteRemark;
          localObject3 = ((DiscussionMemberInfo)localObject5).inteRemark;
          break label189;
        }
        if (localResultRecord.jdField_a_of_type_Int == 3)
        {
          localObject1 = localResultRecord.b;
          localObject3 = localResultRecord.b;
          break label189;
        }
        localObject1 = localObject3;
        if (localResultRecord.jdField_a_of_type_Int != 4) {
          break label189;
        }
        localObject1 = localResultRecord.b;
        localObject3 = localResultRecord.b;
        break label189;
        label537:
        localObject1 = str + (String)localObject1;
      }
    }
    Object localObject3 = localObject1;
    for (;;)
    {
      try
      {
        if (((String)localObject1).getBytes("utf-8").length > 48)
        {
          int j = ((String)localObject1).length();
          i = 1;
          localObject3 = localObject1;
          if (i <= j)
          {
            if (((String)localObject1).substring(0, i).getBytes("utf-8").length <= 48) {
              continue;
            }
            localObject3 = ((String)localObject1).substring(0, i - 1);
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Object localObject4 = localObject1;
        continue;
        SelectMemberActivity.jdField_a_of_type_Boolean = false;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SelectMemberActivity", 2, "add discussion member: groupCode: " + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.F + " member count: " + localArrayList.size());
        ((DiscussionHandler)localObject1).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.F).longValue(), localArrayList);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendToVideo", false)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d = localArrayList;
      }
      localObject1 = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.a(6);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.F != null) {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "create discussion: " + (String)localObject3 + " member count: " + localArrayList.size());
      }
      if (10 != this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.q) {
        continue;
      }
      SelectMemberActivity.jdField_a_of_type_Boolean = true;
      ((DiscussionHandler)localObject1).a((String)localObject3, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.p);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gxy
 * JD-Core Version:    0.7.0.1
 */