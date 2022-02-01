import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.OfflinePreviewController;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.qphone.base.util.QLog;

public class ise
  extends FMObserver
{
  public ise(OfflinePreviewController paramOfflinePreviewController) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    label109:
    for (;;)
    {
      try
      {
        if (FMConfig.a)
        {
          paramString3 = "183.61.37.13";
          paramString4 = "443";
          if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback.a(paramBoolean, paramString3, paramString4, paramInt1, paramString1, paramString2, null, this.a.jdField_a_of_type_JavaLangString);
          }
        }
        else
        {
          if ((paramString3 == null) || (paramString3.length() <= 0)) {
            break label109;
          }
          paramString4 = String.valueOf(paramInt2);
          continue;
        }
        if (QLog.isColorLevel())
        {
          QLog.e(this.a.b, 2, " callback is null");
          continue;
          paramString3 = paramString4;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ise
 * JD-Core Version:    0.7.0.1
 */