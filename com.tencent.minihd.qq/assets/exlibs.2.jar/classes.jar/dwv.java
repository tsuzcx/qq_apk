import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

class dwv
  implements Runnable
{
  dwv(dwu paramdwu) {}
  
  public void run()
  {
    this.a.a.a.setText(this.a.a.b);
    this.a.a.a.setTextColor(Color.rgb(119, 119, 119));
    EditInfoActivity.b(this.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dwv
 * JD-Core Version:    0.7.0.1
 */