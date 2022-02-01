import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.contact.newfriend.CircleGroupListView;

public class ghi
  implements DialogInterface.OnDismissListener
{
  public ghi(CircleGroupListView paramCircleGroupListView, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView.b.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView.b.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     ghi
 * JD-Core Version:    0.7.0.1
 */