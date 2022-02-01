import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.BoundedLinearLayout;
import com.tencent.mobileqq.widget.IconPopupWindow;

public class kyd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public kyd(IconPopupWindow paramIconPopupWindow, int paramInt1, int paramInt2, int paramInt3, View paramView, int[] paramArrayOfInt) {}
  
  public void onGlobalLayout()
  {
    IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).setOnDismissListener(null);
    IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).dismiss();
    int i = AIOUtils.a(this.jdField_a_of_type_Int, IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).getContext().getResources());
    int j = AIOUtils.a(this.b, IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).getContext().getResources());
    switch (this.c)
    {
    }
    for (;;)
    {
      IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).setOnDismissListener(IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow));
      return;
      IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).showAtLocation(this.jdField_a_of_type_AndroidViewView, 0, this.jdField_a_of_type_ArrayOfInt[0] - i, this.jdField_a_of_type_ArrayOfInt[1] - j);
      continue;
      IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).showAtLocation(this.jdField_a_of_type_AndroidViewView, 0, i + (this.jdField_a_of_type_ArrayOfInt[0] + this.jdField_a_of_type_AndroidViewView.getWidth() - IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).getContentView().getWidth()), this.jdField_a_of_type_ArrayOfInt[1]);
      continue;
      IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).showAtLocation(this.jdField_a_of_type_AndroidViewView, 0, this.jdField_a_of_type_ArrayOfInt[0], j + (this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_AndroidViewView.getHeight() - IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).getContentView().getHeight()));
      continue;
      IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).showAtLocation(this.jdField_a_of_type_AndroidViewView, 0, i + (this.jdField_a_of_type_ArrayOfInt[0] + this.jdField_a_of_type_AndroidViewView.getWidth() - IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).getContentView().getWidth()), j + (this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_AndroidViewView.getHeight() - IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).getContentView().getHeight()));
      continue;
      IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).showAtLocation(this.jdField_a_of_type_AndroidViewView, 0, this.jdField_a_of_type_ArrayOfInt[0] + (this.jdField_a_of_type_AndroidViewView.getWidth() - IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).getContentView().getWidth()) / 2, this.jdField_a_of_type_ArrayOfInt[1] + (this.jdField_a_of_type_AndroidViewView.getHeight() - IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).getContentView().getHeight()) / 2);
      continue;
      IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).showAtLocation(this.jdField_a_of_type_AndroidViewView, 0, this.jdField_a_of_type_ArrayOfInt[0] + (this.jdField_a_of_type_AndroidViewView.getWidth() - IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).getContentView().getWidth()) / 2, j + (this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_AndroidViewView.getHeight() - IconPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow).getContentView().getHeight()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kyd
 * JD-Core Version:    0.7.0.1
 */