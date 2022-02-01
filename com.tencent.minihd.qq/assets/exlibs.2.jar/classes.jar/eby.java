import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class eby
  implements View.OnClickListener
{
  public eby(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296568)
    {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (paramView != null))
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
        localActionSheet.a(2131368337, 3);
        localActionSheet.e(2131365736);
        localActionSheet.a(new ebz(this, paramView, localActionSheet));
        localActionSheet.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eby
 * JD-Core Version:    0.7.0.1
 */