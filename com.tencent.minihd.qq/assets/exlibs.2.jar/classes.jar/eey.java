import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class eey
  implements View.OnClickListener
{
  public eey(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  public void onClick(View paramView)
  {
    ChatBackground.b(this.a, this.a.app.getAccount(), null, "null");
    QQToast.a(this.a, 2131367510, 0).a();
    ((TextView)this.a.findViewById(2131297125)).setText(2131370018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eey
 * JD-Core Version:    0.7.0.1
 */