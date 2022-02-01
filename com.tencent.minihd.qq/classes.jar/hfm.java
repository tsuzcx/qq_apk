import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.QQUtils;

public class hfm
  implements DialogInterface.OnClickListener
{
  public hfm(ForwardRecentListAdapter paramForwardRecentListAdapter, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    Friends localFriends = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.a.getManager(8)).c(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_JavaLangString;
    if (localFriends != null) {
      paramDialogInterface = localFriends.name;
    }
    QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.a, this.jdField_a_of_type_JavaLangString, paramDialogInterface, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hfm
 * JD-Core Version:    0.7.0.1
 */