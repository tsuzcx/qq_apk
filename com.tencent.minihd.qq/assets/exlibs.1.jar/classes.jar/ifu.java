import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;

public class ifu
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public ifu(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
  public void a()
  {
    this.jdField_a_of_type_Int = EmoticonLinearLayout.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout);
  }
  
  public void run()
  {
    EmoticonInfo localEmoticonInfo;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.getParent() != null) && (this.jdField_a_of_type_Int == EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidViewView != null))
    {
      localEmoticonInfo = (EmoticonInfo)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidViewView.getTag();
      if (localEmoticonInfo != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a(localEmoticonInfo))) {
          break label172;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.getParent().requestDisallowInterceptTouchEvent(true);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.sendAccessibilityEvent(2);
        if (!"delete".equals(localEmoticonInfo.a)) {
          break label132;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaLangRunnable.run();
      }
    }
    label132:
    while (("setting".equals(localEmoticonInfo.a)) || ("add".equals(localEmoticonInfo.a))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidViewView, localEmoticonInfo);
    return;
    label172:
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ifu
 * JD-Core Version:    0.7.0.1
 */