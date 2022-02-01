import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;

public class hea
  implements QQPlayerService.QQPlayerCallback
{
  public hea(QQMusicWidget paramQQMusicWidget) {}
  
  public String getToken()
  {
    return QQPlayerService.a(6, "");
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.runOnUiThread(new hec(this, paramSongInfo));
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.runOnUiThread(new heb(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hea
 * JD-Core Version:    0.7.0.1
 */