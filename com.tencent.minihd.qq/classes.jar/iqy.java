import android.app.Activity;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class iqy
  implements Runnable
{
  public iqy(FileTransferHandler paramFileTransferHandler, long paramLong, Activity paramActivity, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    String str = "";
    if (this.jdField_a_of_type_Long == -5L) {
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131367793);
    }
    for (;;)
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, "发送失败", str, new iqz(this), null).show();
      return;
      if (this.jdField_a_of_type_Long == -6L) {
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131366404);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     iqy
 * JD-Core Version:    0.7.0.1
 */