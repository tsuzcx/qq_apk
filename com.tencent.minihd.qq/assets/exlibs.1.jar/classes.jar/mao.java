import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import cooperation.qwallet.virtual.QChongLotteryBrowser;

public class mao
  implements View.OnClickListener
{
  public mao(QChongLotteryBrowser paramQChongLotteryBrowser) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.d == null) || (this.a.d.equals("")))
    {
      QChongLotteryBrowser.a(this.a);
      return;
    }
    QChongLotteryBrowser.a(this.a).loadUrl(this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mao
 * JD-Core Version:    0.7.0.1
 */