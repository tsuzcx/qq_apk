import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

public final class igp
  implements DialogInterface.OnClickListener
{
  public igp(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid(), false);
    if (7 == this.jdField_a_of_type_Int) {
      EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, MarketFaceItemBuilder.a.frienduin, "ep_mall", "Clk_pkg_forward", 0);
    }
    while (6 != this.jdField_a_of_type_Int) {
      return;
    }
    EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, MarketFaceItemBuilder.a.frienduin, "ep_mall", "Clk_collect_more", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     igp
 * JD-Core Version:    0.7.0.1
 */