import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.activity.ChatHistory.PlayingPttHistoryInfo;

class dmu
  implements Runnable
{
  dmu(dmt paramdmt, Object paramObject, View paramView) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Dmt.jdField_a_of_type_Int == 0) && ((this.jdField_a_of_type_Dmt.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a == null) || (!this.jdField_a_of_type_Dmt.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.a(0, this.jdField_a_of_type_JavaLangObject))))
    {
      Toast.makeText(this.jdField_a_of_type_Dmt.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Dmt.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131367024), 0).show();
      return;
    }
    if (this.jdField_a_of_type_Dmt.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a == null) {
      this.jdField_a_of_type_Dmt.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a = new ChatHistory.PlayingPttHistoryInfo(this.jdField_a_of_type_Dmt.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory);
    }
    this.jdField_a_of_type_Dmt.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.a(0, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_Dmt.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dmu
 * JD-Core Version:    0.7.0.1
 */