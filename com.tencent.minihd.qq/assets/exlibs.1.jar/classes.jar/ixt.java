import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class ixt
  implements View.OnClickListener
{
  public ixt(FileBrowserActivity paramFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.bActivityToFragment)
    {
      this.a.f();
      return;
    }
    this.a.setResult(-1);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ixt
 * JD-Core Version:    0.7.0.1
 */