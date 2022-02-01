import android.content.Intent;
import com.dataline.activities.PrinterActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumConstants;
import java.util.ArrayList;

public class hmv
  implements FMDialogUtil.FMDialogInterface
{
  public hmv(PrinterHandler paramPrinterHandler, BaseActivity paramBaseActivity, String paramString) {}
  
  public void a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PrinterActivity.class);
    localIntent.putExtra(AlbumConstants.i, 55);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_JavaLangString);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a, "CliOper", "", "", "0X8004059", "0X8004059", 0, 0, "", "", "", "");
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hmv
 * JD-Core Version:    0.7.0.1
 */