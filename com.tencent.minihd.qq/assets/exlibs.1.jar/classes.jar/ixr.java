import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;

public class ixr
  extends GestureDetector.SimpleOnGestureListener
{
  public ixr(FileBrowserActivity paramFileBrowserActivity, int paramInt) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    do
    {
      return false;
      paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
    } while ((paramFloat1 > -this.jdField_a_of_type_Int) || (paramFloat2 >= 0.5F) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.a.a()));
    return FileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ixr
 * JD-Core Version:    0.7.0.1
 */