import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddRequestActivity;

public class dfm
  extends Handler
{
  public dfm(AddRequestActivity paramAddRequestActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if ((AddRequestActivity.a(this.a) != null) && (AddRequestActivity.a(this.a).isShowing()))
      {
        AddRequestActivity.a(this.a).setText(this.a.getString(2131366996));
        AddRequestActivity.a(this.a).setVisibility(8);
        AddRequestActivity.a(this.a).setVisibility(0);
        AddRequestActivity.a(this.a).setImageResource(2130838252);
        postDelayed(new dfn(this), 1500L);
        return;
      }
      this.a.finish();
      return;
      this.a.a(true);
    } while ((AddRequestActivity.a(this.a) == null) || (!AddRequestActivity.a(this.a).isShowing()));
    AddRequestActivity.a(this.a).setText(this.a.getString(2131366997));
    AddRequestActivity.a(this.a).setVisibility(8);
    AddRequestActivity.a(this.a).setVisibility(0);
    AddRequestActivity.a(this.a).setImageResource(2130838242);
    postDelayed(new dfo(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dfm
 * JD-Core Version:    0.7.0.1
 */