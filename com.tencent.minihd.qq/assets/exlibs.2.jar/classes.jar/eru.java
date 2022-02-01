import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.SlipEdgeLayout.SlipEdgeCallBack;

public class eru
  implements SlipEdgeLayout.SlipEdgeCallBack
{
  public eru(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void a()
  {
    if (this.a.isNewTaskFullScreen())
    {
      this.a.setNewTaskFullScreen(false);
      this.a.j();
      this.a.h();
    }
  }
  
  public void b()
  {
    if (!this.a.isNewTaskFullScreen())
    {
      this.a.setNewTaskFullScreen(true);
      this.a.j();
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eru
 * JD-Core Version:    0.7.0.1
 */