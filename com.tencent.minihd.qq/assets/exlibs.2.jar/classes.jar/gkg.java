import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.widget.IconPopupWindow;

public class gkg
  implements View.OnClickListener
{
  public gkg(TroopActivity paramTroopActivity, IconPopupWindow paramIconPopupWindow) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (i == 0) {
      paramView.setId(2131298681);
    }
    for (;;)
    {
      TroopActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity).onClick(paramView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      return;
      if (i == 1) {
        paramView.setId(2131298874);
      } else if (i == 2) {
        paramView.setId(2131298876);
      } else {
        paramView.setId(2131299329);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gkg
 * JD-Core Version:    0.7.0.1
 */