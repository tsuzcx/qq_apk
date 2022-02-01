import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class jpl
  implements AdapterView.OnItemClickListener
{
  public jpl(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = PhoneContactManagerImp.a(((TextView)paramView.findViewById(2131299811)).getText().toString());
    paramLong = System.currentTimeMillis() / 1000L;
    paramView = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramAdapterView));
    this.a.startActivity(paramView);
    paramView = QCallDetailActivity.a(this.a);
    if (QCallDetailActivity.a(this.a) == 56938) {}
    for (;;)
    {
      paramView.a(paramAdapterView, QCallDetailActivity.a(this.a), QCallDetailActivity.b(this.a), paramLong);
      return;
      paramAdapterView = QCallDetailActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jpl
 * JD-Core Version:    0.7.0.1
 */