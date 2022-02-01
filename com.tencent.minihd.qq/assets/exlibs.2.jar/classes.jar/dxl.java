import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.statistics.ReportController;

public class dxl
  implements View.OnClickListener
{
  public dxl(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131368462);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(true);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.setEditMode(true);
      this.a.b = true;
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      ReportController.b(this.a.app, "CliOper", "", "", "EmosSetting", "EpsEdit", 0, 0, "", "", "", "");
    }
    while ((this.a.g != 2) && (this.a.g != 1)) {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131368459);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.setEditMode(false);
    this.a.b();
    this.a.b = false;
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.clearSelectStatus();
    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dxl
 * JD-Core Version:    0.7.0.1
 */