import MyCarrier.Carrier;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.widget.XListView;

public class gpw
  implements View.OnClickListener
{
  public gpw(ContactListView paramContactListView) {}
  
  private void a()
  {
    Context localContext = this.a.getContext();
    Object localObject = ((MyBusinessManager)this.a.a.getManager(48)).a();
    if ((localObject == null) || (TextUtils.isEmpty(((Carrier)localObject).carrierURL))) {
      return;
    }
    if ((((Carrier)localObject).carrierURL.indexOf("&") > -1) || (((Carrier)localObject).carrierURL.indexOf("?") > -1)) {}
    for (localObject = ((Carrier)localObject).carrierURL + "&sid=" + this.a.a.getSid();; localObject = ((Carrier)localObject).carrierURL + "?sid=" + this.a.a.getSid())
    {
      Intent localIntent = new Intent(localContext, MyBusinessActivity.class);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("uin", this.a.a.a());
      localIntent.putExtra("title", localContext.getString(2131369326));
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("hideRightButton", true);
      localContext.startActivity(localIntent);
      return;
    }
  }
  
  private void b()
  {
    if (ContactListView.a(this.a) != null)
    {
      ContactListView.a(this.a).setVisibility(8);
      ContactListView.a(this.a).a(ContactListView.a(this.a));
      ContactListView.a(this.a, null);
    }
  }
  
  public void onClick(View paramView)
  {
    b();
    ContactListView.a(this.a, true);
    switch (paramView.getId())
    {
    default: 
      ContactListView.a(this.a, "P_CliOper", "QQwangting", "txl_clk_bluebar", "clk_bluebar");
      a();
      return;
    }
    ContactListView.a(this.a, "P_CliOper", "QQwangting", "txl_close_bluebar", "close_bluebar");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gpw
 * JD-Core Version:    0.7.0.1
 */