import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.test.QzoneTestActivity;

public class lup
  implements View.OnClickListener
{
  public lup(QzoneTestActivity paramQzoneTestActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new QQProgressDialog(this.a);
    paramView.a(this.a.getString(2131365938));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lup
 * JD-Core Version:    0.7.0.1
 */