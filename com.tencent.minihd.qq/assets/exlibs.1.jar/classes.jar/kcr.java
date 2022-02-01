import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonListenPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.troop.activity.AudioRecordActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class kcr
  extends Handler
{
  public kcr(AudioRecordActivity paramAudioRecordActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          paramMessage = paramMessage.obj.toString();
          File localFile = new File(paramMessage);
          if (localFile.exists()) {}
          for (long l = localFile.length();; l = 0L)
          {
            AudioRecordActivity.a(this.a).setAudioPath(paramMessage, AudioRecordActivity.a(this.a).a());
            AudioRecordActivity.a(this.a, new AudioInfo(paramMessage, (int)AudioRecordActivity.a(this.a).a(), l));
            AudioRecordActivity.a(this.a).setVisibility(0);
            AudioRecordActivity.a(this.a).setVisibility(8);
            return;
          }
          AudioRecordActivity.a(this.a).setVisibility(8);
          AudioRecordActivity.a(this.a).g();
          AudioRecordActivity.a(this.a).setVisibility(0);
        } while ((this.a.g == null) || (!this.a.g.equals("publish")) || (this.a.h == null));
        TroopBarUtils.a("pub_page", "un_record", "" + this.a.h, this.a.i, "", "");
        return;
        AudioRecordActivity.a(this.a).setVisibility(8);
        paramMessage = new Intent();
        paramMessage.putExtra("audio_info", AudioRecordActivity.a(this.a));
        this.a.setResult(-1, paramMessage);
        this.a.finish();
        return;
      } while ((this.a.g == null) || (!this.a.g.equals("publish")) || (this.a.h == null));
      TroopBarUtils.a("pub_page", "preview_record", this.a.h, this.a.i, "", "");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("AIOAudioPanel", 2, "RECORD_TO_START =============");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kcr
 * JD-Core Version:    0.7.0.1
 */