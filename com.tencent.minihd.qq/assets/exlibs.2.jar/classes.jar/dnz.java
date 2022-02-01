import android.os.Handler;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dnz
  implements ActionSheet.OnButtonClickListener
{
  public dnz(ChatHistoryForC2C paramChatHistoryForC2C, MessageRecord paramMessageRecord, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      ChatHistoryForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C, true);
      paramView = ChatHistoryForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C).obtainMessage(1);
      ChatHistoryForC2C.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C).sendMessageDelayed(paramView, 800L);
      Utils.executeAsyncTaskOnThreadPool(new doa(this), new MessageRecord[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dnz
 * JD-Core Version:    0.7.0.1
 */