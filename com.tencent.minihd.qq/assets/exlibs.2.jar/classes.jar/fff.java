import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.SelectableTextView;

public class fff
  extends Handler
{
  public fff(TextPreviewActivity paramTextPreviewActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      if (this.a.a != null) {
        TextPreviewActivity.a(this.a).setText(this.a.a);
      }
      TextPreviewActivity.a(this.a).a.setMovementMethod(LinkMovementMethod.getInstance());
      return;
    }
    TextPreviewActivity.a(this.a).setImageDrawable(TextPreviewActivity.a(this.a).a(this.a.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fff
 * JD-Core Version:    0.7.0.1
 */