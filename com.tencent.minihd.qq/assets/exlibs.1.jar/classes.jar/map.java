import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import cooperation.qwallet.virtual.QChongLotteryBrowser;

public class map
  implements View.OnClickListener
{
  public map(QChongLotteryBrowser paramQChongLotteryBrowser) {}
  
  public void onClick(View paramView)
  {
    QChongLotteryBrowser.b(this.a).loadUrl(this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     map
 * JD-Core Version:    0.7.0.1
 */