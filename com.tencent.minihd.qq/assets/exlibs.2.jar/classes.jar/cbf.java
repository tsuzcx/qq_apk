import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class cbf
  implements Animation.AnimationListener
{
  public cbf(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation1, Dialog paramDialog, int paramInt, TranslateAnimation paramTranslateAnimation2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity).getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity).getLayoutParams();
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidViewView.findViewById(2131299473).setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidViewView.findViewById(2131300437).setVisibility(8);
      localLayoutParams.height = (this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight() + this.jdField_a_of_type_Int);
      PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity, this.jdField_a_of_type_Int / 2, true);
    }
    for (;;)
    {
      localLayoutParams1.height = -1;
      localLayoutParams2.height = -1;
      PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity).setLayoutParams(localLayoutParams2);
      PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity).setLayoutParams(localLayoutParams1);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      PoiMapActivity.c(this.jdField_a_of_type_ComTencentBizPoiMapActivity).setEnabled(true);
      if ((this.jdField_a_of_type_ComTencentBizPoiMapActivity.i) && (paramAnimation == this.b)) {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.m();
      }
      return;
      if (paramAnimation == this.b)
      {
        localLayoutParams.height = (this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight() - this.jdField_a_of_type_Int);
        PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity, -this.jdField_a_of_type_Int / 2, true);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cbf
 * JD-Core Version:    0.7.0.1
 */