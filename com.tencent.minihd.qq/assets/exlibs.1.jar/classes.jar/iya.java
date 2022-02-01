import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;

public class iya
  implements View.OnClickListener
{
  public iya(LocalMusicFileView paramLocalMusicFileView) {}
  
  public void onClick(View paramView)
  {
    FileManagerReporter.a("0X8004BE3");
    if (LocalMusicFileView.a(this.a) != null) {
      LocalMusicFileView.b(this.a).a(LocalMusicFileView.a(this.a));
    }
    LocalMusicFileView.a(this.a).setProgress(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iya
 * JD-Core Version:    0.7.0.1
 */