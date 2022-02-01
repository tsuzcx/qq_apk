import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class fsy
  implements Runnable
{
  public fsy(RecordSoundPanel paramRecordSoundPanel) {}
  
  public void run()
  {
    this.a.g();
    QQToast.a(RecordSoundPanel.a(this.a).a(), RecordSoundPanel.a(this.a).a().getString(2131366086), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fsy
 * JD-Core Version:    0.7.0.1
 */