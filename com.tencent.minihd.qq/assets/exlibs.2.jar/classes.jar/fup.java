import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.LocationItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;

public class fup
  implements View.OnClickListener
{
  public fup(LocationItemBuilder paramLocationItemBuilder) {}
  
  public void onClick(View paramView)
  {
    AIOUtils.h = true;
    if (LocationItemBuilder.a(this.a)) {}
    do
    {
      return;
      MessageForText localMessageForText = (MessageForText)AIOUtils.a(paramView);
      try
      {
        ((ChatActivity)this.a.jdField_a_of_type_AndroidContentContext).a().ac();
        paramView = new Intent(paramView.getContext(), PoiMapActivity.class).putExtra("lat", localMessageForText.latitude).putExtra("lon", localMessageForText.longitude).putExtra("url", localMessageForText.url).putExtra("loc", localMessageForText.location).putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        ((ChatActivity)this.a.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 18);
        i = 1;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          try
          {
            ((Activity)this.a.jdField_a_of_type_AndroidContentContext).startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(localMessageForText.url)), 0);
            i = 1;
          }
          catch (Exception paramView)
          {
            int i = 0;
          }
        }
      }
    } while ((i == 0) || (!(this.a.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)));
    ((ChatActivity)this.a.jdField_a_of_type_AndroidContentContext).setCanLock(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fup
 * JD-Core Version:    0.7.0.1
 */