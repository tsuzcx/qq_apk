import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class ikr
  implements View.OnClickListener
{
  public ikr(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
    }
    paramView = (Button)paramView.findViewById(2131297628);
    if (paramView.getTag() != null)
    {
      this.a.b = ((Integer)paramView.getTag()).intValue();
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(null);
      }
    }
    this.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ikr
 * JD-Core Version:    0.7.0.1
 */