import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;
import com.tencent.mobileqq.troop.activity.VideoRecordActivity;
import com.tencent.mobileqq.widget.QQToast;

public class kim
  implements MediaRecorder.OnInfoListener
{
  public kim(VideoRecordActivity paramVideoRecordActivity) {}
  
  public void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 801: 
      QQToast.a(this.a, 2131364096, 1).a();
      VideoRecordActivity.c(this.a);
      return;
    }
    QQToast.a(this.a, 2131364097, 1).a();
    VideoRecordActivity.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kim
 * JD-Core Version:    0.7.0.1
 */