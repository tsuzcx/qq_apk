import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.WorkSpaceView.OnScreenChangeListener;

public class kws
  implements WorkSpaceView.OnScreenChangeListener
{
  public kws(ADView paramADView, LinearLayout paramLinearLayout) {}
  
  public void a(int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (localView != null) {
        localView.setEnabled(false);
      }
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a) {
      if (paramInt == -1) {
        i = j - 1;
      }
    }
    for (;;)
    {
      if ((i > -1) && (i < j))
      {
        localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if (localView != null) {
          localView.setEnabled(true);
        }
      }
      return;
      i = paramInt;
      if (paramInt == j)
      {
        i = 0;
        continue;
        if (paramInt == -1)
        {
          i = 0;
        }
        else
        {
          i = paramInt;
          if (paramInt == j) {
            i = j - 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kws
 * JD-Core Version:    0.7.0.1
 */