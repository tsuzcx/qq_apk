import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.ChatHistoryForC2C.ChatHistoryAdapter;
import com.tencent.mobileqq.activity.ChatHistoryForC2C.PlayingPttHistoryInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;

public class doo
  implements View.OnClickListener
{
  public doo(ChatHistoryForC2C.ChatHistoryAdapter paramChatHistoryAdapter, PicEmoticonInfo paramPicEmoticonInfo) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      paramView = paramView.getTag();
      String str = EmosmUtils.getEmoticonSoundPath(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter.a.a == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter.a.a = new ChatHistoryForC2C.PlayingPttHistoryInfo(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter.a);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter.a.a.a(1, localView, paramView, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     doo
 * JD-Core Version:    0.7.0.1
 */