import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.util.RouterSessionAdapter;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.data.RouterMsgRecord;

class eb
  implements DialogInterface.OnClickListener
{
  eb(ea paramea) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataRouterMsgRecord.status < 3) {
      this.a.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.a.a(0, this.a.jdField_a_of_type_ComTencentMobileqqDataRouterMsgRecord.uSessionID, true);
    }
    this.a.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataRouterMsgRecord);
    this.a.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.a();
    this.a.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eb
 * JD-Core Version:    0.7.0.1
 */