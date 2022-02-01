import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;

public class iyk
  implements View.OnClickListener
{
  public iyk(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void onClick(View paramView)
  {
    if (LocalVideoFileView.b(this.a).getRequestedOrientation() != 0)
    {
      LocalVideoFileView.b(this.a).setRequestedOrientation(0);
      LocalVideoFileView.a(this.a).setBackgroundResource(2130839715);
      return;
    }
    LocalVideoFileView.b(this.a).setRequestedOrientation(1);
    LocalVideoFileView.a(this.a).setBackgroundResource(2130839718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyk
 * JD-Core Version:    0.7.0.1
 */