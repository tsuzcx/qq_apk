import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class fun
  extends ClickableSpan
{
  private WeakReference a;
  private WeakReference b;
  
  public fun(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.a.get();
    if (((this.b.get() instanceof Activity)) && (paramView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "handleHotChatToSeeTip span click ");
      }
      ReportController.b(paramView, "CliOper", "", "", "0X8004410", "0X8004410", 2, 0, "", "", "", "");
      HotChatListActivity.a();
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fun
 * JD-Core Version:    0.7.0.1
 */