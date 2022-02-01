import android.text.format.Time;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;

public class ixy
  implements SeekBar.OnSeekBarChangeListener
{
  public ixy(LocalMusicFileView paramLocalMusicFileView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((LocalMusicFileView.a(this.a) == null) || (!LocalMusicFileView.a(this.a).b(LocalMusicFileView.a(this.a)))) {}
    while (!paramBoolean) {
      return;
    }
    LocalMusicFileView.a(this.a).a(paramInt);
    paramSeekBar = new Time();
    paramSeekBar.set(paramInt);
    paramSeekBar = paramSeekBar.format("%M:%S");
    LocalMusicFileView.a(this.a).setText(paramSeekBar);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((LocalMusicFileView.a(this.a) == null) || (!LocalMusicFileView.a(this.a).b(LocalMusicFileView.a(this.a)))) {
      return;
    }
    LocalMusicFileView.a(this.a).d();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((LocalMusicFileView.a(this.a) == null) || (!LocalMusicFileView.a(this.a).b(LocalMusicFileView.a(this.a)))) {
      return;
    }
    LocalMusicFileView.a(this.a).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ixy
 * JD-Core Version:    0.7.0.1
 */