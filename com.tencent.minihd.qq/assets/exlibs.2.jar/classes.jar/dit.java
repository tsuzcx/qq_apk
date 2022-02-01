import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;

class dit
  implements Runnable
{
  dit(dis paramdis) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
      {
        View localView = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
        Object localObject = localView.getTag(2131296312);
        if ((localObject instanceof MessageRecord))
        {
          Log.i("uniseq", "tag=" + localObject + " uniseq=" + ((MessageRecord)localObject).uniseq);
          if (this.a.jdField_a_of_type_Long == ((MessageRecord)localObject).uniseq)
          {
            localView = localView.findViewById(2131296322);
            if (localView != null)
            {
              if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("also_open_hb_detail", false)) {
                com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.d = true;
              }
              localView.performClick();
              com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.d = false;
            }
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dit
 * JD-Core Version:    0.7.0.1
 */