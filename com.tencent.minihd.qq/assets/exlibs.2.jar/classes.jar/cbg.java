import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class cbg
  implements DialogInterface.OnDismissListener
{
  public cbg(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidViewView.findViewById(2131299473).setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidViewView.findViewById(2131300437).setVisibility(0);
    PoiMapActivity.d(this.jdField_a_of_type_ComTencentBizPoiMapActivity).setEnabled(false);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetLinearLayout.getHandler().postDelayed(new cbh(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cbg
 * JD-Core Version:    0.7.0.1
 */