import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class fja
  implements DialogInterface.OnDismissListener
{
  public fja(TroopMemberListActivity paramTroopMemberListActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.findViewById(2131302355);
    if (paramDialogInterface != null) {
      paramDialogInterface.postDelayed(new fjb(this), 150L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fja
 * JD-Core Version:    0.7.0.1
 */