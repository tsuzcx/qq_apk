import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.PublicView;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class ggo
  implements Runnable
{
  public ggo(SearchBaseFragment paramSearchBaseFragment, int paramInt, AccountSearchPb.record paramrecord) {}
  
  public void run()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 80000000: 
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
      return;
    case 80000001: 
      Bundle localBundle = TroopInfoActivity.a(String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get()), 2);
      ChatSettingForTroop.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(), localBundle, 2);
      return;
    }
    PublicView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(), this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.class_index.get(), String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get()), String.valueOf(this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get()), this.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ggo
 * JD-Core Version:    0.7.0.1
 */