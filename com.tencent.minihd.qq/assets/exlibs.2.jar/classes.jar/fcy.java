import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.qphone.base.remote.SimpleAccount;

class fcy
  implements Runnable
{
  fcy(fcx paramfcx) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Fcw.a.a();
    this.a.jdField_a_of_type_Fcw.a.a(this.a.jdField_a_of_type_Fcw.a.getString(2131368699));
    Intent localIntent = new Intent(this.a.jdField_a_of_type_Fcw.a, SubLoginActivity.class);
    localIntent.putExtra("subuin", this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    localIntent.putExtra("fromWhere", this.a.jdField_a_of_type_Fcw.a.a);
    this.a.jdField_a_of_type_Fcw.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fcy
 * JD-Core Version:    0.7.0.1
 */