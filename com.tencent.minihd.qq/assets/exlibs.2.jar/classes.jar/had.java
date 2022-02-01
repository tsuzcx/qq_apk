import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity;

public class had
  extends Handler
{
  public had(QvipSpecialSoundActivity paramQvipSpecialSoundActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      do
      {
        return;
        QvipSpecialSoundActivity.b(this.a);
        QvipSpecialSoundActivity.a(this.a).removeMessages(2);
      } while (((Boolean)paramMessage.obj).booleanValue());
      QvipSpecialSoundActivity.a(this.a, this.a.getString(2131369147));
      return;
    case 1: 
      QvipSpecialSoundActivity.a(this.a).setText(this.a.getString(2131369137));
      return;
    }
    QvipSpecialSoundActivity.c(this.a);
    QvipSpecialSoundActivity.a(this.a, this.a.getString(2131369150));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     had
 * JD-Core Version:    0.7.0.1
 */