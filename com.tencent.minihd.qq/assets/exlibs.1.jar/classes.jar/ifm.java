import android.view.View;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;
import com.tencent.mobileqq.widget.ProgressButton;

public class ifm
  implements Runnable
{
  public ifm(BigEmoticonViewBinder paramBigEmoticonViewBinder, View paramView) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewBigEmoticonViewBinder.a(0);
    ProgressButton localProgressButton;
    if (i == 2005)
    {
      localProgressButton = (ProgressButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131297541);
      if (localProgressButton != null)
      {
        localProgressButton.setVisibility(0);
        localProgressButton.setText("下载");
        BigEmoticonViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewBigEmoticonViewBinder, 2);
        localProgressButton.setProgress(0);
      }
    }
    do
    {
      do
      {
        return;
      } while (i != 2004);
      localProgressButton = (ProgressButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131297584);
    } while (localProgressButton == null);
    localProgressButton.setVisibility(0);
    localProgressButton.setText("更新");
    BigEmoticonViewBinder.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewBigEmoticonViewBinder, 2);
    localProgressButton.setProgress(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ifm
 * JD-Core Version:    0.7.0.1
 */