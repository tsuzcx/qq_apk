import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountInfoListActivity;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.util.Pair;

class fdf
  implements DialogInterface.OnClickListener
{
  fdf(fde paramfde, SubAccountControll paramSubAccountControll, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountControll.a((String)this.jdField_a_of_type_ComTencentUtilPair.first, ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue(), true);
    if (!SubAccountControll.a(this.jdField_a_of_type_Fde.a.app))
    {
      this.jdField_a_of_type_Fde.a.setTitle("");
      SubAccountAssistantForward.a(this.jdField_a_of_type_Fde.a.app, this.jdField_a_of_type_Fde.a, null);
      this.jdField_a_of_type_Fde.a.finish();
      return;
    }
    SubAccountInfoListActivity.a(this.jdField_a_of_type_Fde.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fdf
 * JD-Core Version:    0.7.0.1
 */