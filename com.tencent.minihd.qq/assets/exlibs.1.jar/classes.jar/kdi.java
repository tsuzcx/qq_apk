import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;

public class kdi
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public kdi(NearbyTroopsView paramNearbyTroopsView) {}
  
  public void onGlobalLayout()
  {
    if (NearbyTroopsView.c(this.a)) {}
    do
    {
      return;
      NearbyTroopsView.c(this.a, true);
    } while (this.a.c.getVisibility() == 8);
    this.a.e.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    this.a.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(NearbyTroopsView.a(this.a));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setSelectionFromTop(0, -this.a.c.getTop());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kdi
 * JD-Core Version:    0.7.0.1
 */