import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;

public class gjb
  implements DialogInterface.OnDismissListener
{
  public gjb(BaseTroopView paramBaseTroopView, int paramInt1, int paramInt2, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.c.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.findViewById(2131300437).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.b.setVisibility(this.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.c.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.jdField_a_of_type_AndroidAppDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gjb
 * JD-Core Version:    0.7.0.1
 */