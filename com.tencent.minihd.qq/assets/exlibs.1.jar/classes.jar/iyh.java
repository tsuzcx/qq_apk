import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;

public class iyh
  implements SeekBar.OnSeekBarChangeListener
{
  public iyh(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    LocalVideoFileView.a(this.a, paramInt);
    if (paramBoolean)
    {
      paramSeekBar = LocalVideoFileView.a(this.a, paramInt);
      LocalVideoFileView.a(this.a).setText(paramSeekBar);
      if ((LocalVideoFileView.a(this.a) != null) && (LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a)))) {}
    }
    else
    {
      return;
    }
    LocalVideoFileView.a(this.a).a(paramInt);
  }
  
  @TargetApi(16)
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((LocalVideoFileView.a(this.a) == null) || (!LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a)))) {
      return;
    }
    LocalVideoFileView.a(this.a).d();
    if (Build.VERSION.SDK_INT > 16)
    {
      LocalVideoFileView.a(this.a).setBackground(null);
      return;
    }
    LocalVideoFileView.a(this.a).setBackgroundDrawable(null);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((LocalVideoFileView.a(this.a) == null) || (!LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a)))) {
      return;
    }
    LocalVideoFileView.a(this.a).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyh
 * JD-Core Version:    0.7.0.1
 */