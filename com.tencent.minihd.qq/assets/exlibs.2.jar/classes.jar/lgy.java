import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.MyAppApi.CopyAndInstallTask;
import com.tencent.open.downloadnew.MyAppApi.InstallParams;

public class lgy
  implements DialogInterface.OnClickListener
{
  public lgy(MyAppApi paramMyAppApi, Bundle paramBundle, boolean paramBoolean, Activity paramActivity, String paramString1, DialogInterface.OnClickListener paramOnClickListener, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LogUtility.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.b())
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a = new MyAppApi.InstallParams(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi);
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.b = true;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a.jdField_a_of_type_Int = 2;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.c = true;
      StaticAnalyz.a("201", StaticAnalyz.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.b);
      return;
      new MyAppApi.CopyAndInstallTask(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a).execute(new Void[0]);
      continue;
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lgy
 * JD-Core Version:    0.7.0.1
 */