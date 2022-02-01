import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.util.Pair;

public class fen
  implements DialogInterface.OnClickListener
{
  public fen(SubAccountUgActivity paramSubAccountUgActivity, SubAccountControll paramSubAccountControll, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountControll.a((String)this.jdField_a_of_type_ComTencentUtilPair.first, ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue(), true);
    if (!SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.app))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.setTitle("");
      SubAccountAssistantForward.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fen
 * JD-Core Version:    0.7.0.1
 */