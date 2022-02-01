import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import cooperation.qwallet.virtual.QChongLotteryBrowser;

public class maq
  implements View.OnClickListener
{
  public maq(QChongLotteryBrowser paramQChongLotteryBrowser) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.e == null) || (this.a.e.equals("")))
    {
      QChongLotteryBrowser.b(this.a);
      return;
    }
    QChongLotteryBrowser.c(this.a).loadUrl(this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     maq
 * JD-Core Version:    0.7.0.1
 */