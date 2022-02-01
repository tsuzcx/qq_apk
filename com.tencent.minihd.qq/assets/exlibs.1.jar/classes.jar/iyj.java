import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;

class iyj
  implements Runnable
{
  iyj(iyi paramiyi) {}
  
  public void run()
  {
    LocalVideoFileView.a(this.a.a).setVisibility(8);
    if ((LocalVideoFileView.a(this.a.a) != null) && (LocalVideoFileView.b(this.a.a) != null))
    {
      LocalVideoFileView.a(this.a.a).setVisibility(8);
      LocalVideoFileView.b(this.a.a).setVisibility(8);
    }
    if (LocalVideoFileView.a(this.a.a) != null) {
      LocalVideoFileView.b(this.a.a).c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyj
 * JD-Core Version:    0.7.0.1
 */