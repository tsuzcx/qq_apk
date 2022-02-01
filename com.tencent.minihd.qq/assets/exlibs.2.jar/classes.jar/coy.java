import android.os.Handler;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.ui.CustomMenuBar;

public class coy
  implements PopupWindow.OnDismissListener
{
  public coy(CustomMenuBar paramCustomMenuBar, ImageView paramImageView) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839277);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = true;
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     coy
 * JD-Core Version:    0.7.0.1
 */