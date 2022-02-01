import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.Contacts;

public class dro
  implements DialogInterface.OnDismissListener
{
  public dro(Contacts paramContacts, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContacts.findViewById(2131300437).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContacts.jdField_a_of_type_AndroidWidgetRelativeLayout.offsetTopAndBottom(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContacts.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_ComTencentMobileqqActivityContacts.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dro
 * JD-Core Version:    0.7.0.1
 */