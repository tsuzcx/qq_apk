import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;

public class fty
  extends ClickableSpan
{
  public fty(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, MessageRecord paramMessageRecord, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("makePhoneCall") == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, "Tips_Click", "makePhoneCall", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
      paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
    Object localObject;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("showAlert") == 0)
        {
          paramView = this.jdField_a_of_type_AndroidOsBundle.getString("AlertTitle");
          localObject = this.jdField_a_of_type_AndroidOsBundle.getString("AlertText");
          String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("AlertOtherBtnText");
          String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("AlertCancelBtnText");
          MQPSensitiveMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, paramView, (String)localObject, str1, str2);
          return;
        }
      } while (this.jdField_a_of_type_JavaLangString.compareToIgnoreCase("openURL") != 0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, "Tips_Click", "openURL", this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "", "", "", "");
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("Action");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    paramView = (View)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (((String)localObject).startsWith("http://")) {
        break label394;
      }
      paramView = "http://" + (String)localObject;
      if (!paramView.contains("?")) {
        break label428;
      }
    }
    label394:
    label428:
    for (paramView = paramView + "&sid=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();; paramView = paramView + "?sid=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid())
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      ((Intent)localObject).putExtra("hide_left_button", true);
      ((Intent)localObject).putExtra("show_right_close_button", true);
      ((Intent)localObject).putExtra("finish_animation_up_down", true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return;
      paramView = (View)localObject;
      if (((String)localObject).startsWith("https://")) {
        break;
      }
      paramView = "https://" + (String)localObject;
      break;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fty
 * JD-Core Version:    0.7.0.1
 */