import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.eAnimType;

public class ikk
  implements Runnable
{
  public ikk(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.a.c) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - this.a.jdField_a_of_type_AndroidViewViewGroup.getHeight());
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue = new FilePreviewAnimQueue(this.a.jdField_a_of_type_AndroidViewViewGroup);
    }
    FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = new FilePreviewAnimQueue.FilePreviewAnim();
    localFilePreviewAnim.jdField_a_of_type_JavaLangObject = localTranslateAnimation;
    localFilePreviewAnim.jdField_a_of_type_Boolean = false;
    localFilePreviewAnim.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue$eAnimType = FilePreviewAnimQueue.eAnimType.eTranslateAnim;
    localFilePreviewAnim.jdField_a_of_type_Int = 250;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.a(localFilePreviewAnim);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue.a();
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ikk
 * JD-Core Version:    0.7.0.1
 */