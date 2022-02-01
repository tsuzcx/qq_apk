import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class fua
  extends ClickableSpan
{
  public fua(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.e(this.a.jdField_a_of_type_AndroidContentContext))
    {
      paramView = (FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      paramView.a((short)1, localArrayList, false);
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365730), 1).b(((ChatActivity)this.a.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fua
 * JD-Core Version:    0.7.0.1
 */