import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.DatalineFilesAdapter.ItemHolder;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

class dm
  implements DialogInterface.OnClickListener
{
  dm(dl paramdl, DataLineMsgRecord paramDataLineMsgRecord, DatalineFilesAdapter.ItemHolder paramItemHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = DatalineFilesAdapter.a(this.jdField_a_of_type_Dl.a).a().a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    if (paramDialogInterface != null) {
      paramDialogInterface.setPaused(false);
    }
    if (this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter$ItemHolder.a.a != 1)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.fileMsgStatus == 1L) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.strMoloKey != null)) {
        DataLineReportUtil.e(DatalineFilesAdapter.a(this.jdField_a_of_type_Dl.a));
      }
      DatalineFilesAdapter.a(this.jdField_a_of_type_Dl.a, this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter$ItemHolder, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      return;
    }
    DatalineFilesAdapter.b(this.jdField_a_of_type_Dl.a, this.jdField_a_of_type_ComDatalineUtilDatalineFilesAdapter$ItemHolder, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dm
 * JD-Core Version:    0.7.0.1
 */