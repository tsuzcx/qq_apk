import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.adapter.SubAccountMessageAdapter.ViewHolder;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;

public class fdw
  implements View.OnClickListener
{
  public fdw(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.app.a().c(SubAccountMessageActivity.a(this.a).subuin, 7000);
    if (!PhoneNumLoginImpl.a().a(this.a.app, this.a)) {}
    Object localObject;
    do
    {
      return;
      localObject = "";
      if (SubAccountMessageActivity.a(this.a) != null) {
        localObject = SubAccountMessageActivity.a(this.a).subuin;
      }
      ReportController.b(this.a.app, "CliOper", "", (String)localObject, "Bind_account", "Clk_readmsg", 0, 0, "", "", "", "");
    } while (!this.a.b());
    this.a.a(0);
    try
    {
      paramView = (String)((SubAccountMessageAdapter.ViewHolder)paramView.getTag()).a.getTag();
      if (SubAccountMessageActivity.a(this.a))
      {
        localObject = (MessageHandler)this.a.app.a(0);
        if (paramView.equalsIgnoreCase("2005060620050606"))
        {
          ((MessageHandler)localObject).a().a(SubAccountMessageActivity.a(this.a).subuin, "sub.acocunt.toQZone");
          return;
        }
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView = "";
      }
      ((MessageHandler)localObject).a().a(SubAccountMessageActivity.a(this.a).subuin, "sub.account.switchAccount");
      return;
    }
    if (paramView.equalsIgnoreCase("2005060620050606")) {
      SubAccountMessageActivity.a(this.a, true);
    }
    SubAccountMessageActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fdw
 * JD-Core Version:    0.7.0.1
 */