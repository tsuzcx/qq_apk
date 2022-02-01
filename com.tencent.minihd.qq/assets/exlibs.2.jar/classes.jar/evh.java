import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QzoneWrapperActivity;
import com.test.QzoneTestActivity;

public class evh
  implements View.OnClickListener
{
  public evh(QzoneWrapperActivity paramQzoneWrapperActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QzoneTestActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evh
 * JD-Core Version:    0.7.0.1
 */