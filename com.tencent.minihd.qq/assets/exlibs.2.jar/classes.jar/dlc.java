import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public final class dlc
  implements Runnable
{
  public dlc(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363703));
    localActionSheet.a(2131366672, 3);
    localActionSheet.e(2131365736);
    localActionSheet.a(new dld(this, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dlc
 * JD-Core Version:    0.7.0.1
 */