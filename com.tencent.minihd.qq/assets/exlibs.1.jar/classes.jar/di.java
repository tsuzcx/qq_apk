import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.util.DLRouterSessionInfoRequestTask;
import com.dataline.util.DLRouterSessionListAdapter;
import com.tencent.litetransfersdk.ProgressInfo;
import java.util.ArrayList;
import java.util.HashMap;

class di
  implements DialogInterface.OnClickListener
{
  di(dh paramdh, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Dh.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter.a.a(this.jdField_a_of_type_Dh.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    if (DLRouterSessionListAdapter.a(this.jdField_a_of_type_Dh.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter).containsKey(Long.valueOf(this.jdField_a_of_type_Dh.jdField_a_of_type_Long)))
    {
      ProgressInfo localProgressInfo = (ProgressInfo)DLRouterSessionListAdapter.a(this.jdField_a_of_type_Dh.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter).get(Long.valueOf(this.jdField_a_of_type_Dh.jdField_a_of_type_Long));
      DLRouterSessionListAdapter.a(this.jdField_a_of_type_Dh.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter).remove(Long.valueOf(this.jdField_a_of_type_Dh.jdField_a_of_type_Long));
      DLRouterSessionListAdapter.a(this.jdField_a_of_type_Dh.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter).remove(localProgressInfo);
      this.jdField_a_of_type_Dh.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter.notifyDataSetChanged();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     di
 * JD-Core Version:    0.7.0.1
 */