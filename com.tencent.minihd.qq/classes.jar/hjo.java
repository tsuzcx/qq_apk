import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameActivity;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabHost.OnTabSelectionListener;

public class hjo
  implements QQTabHost.OnTabSelectionListener
{
  public hjo(FrameActivity paramFrameActivity) {}
  
  public void a(int paramInt1, int paramInt2, QQTabHost paramQQTabHost)
  {
    if (paramInt1 == paramInt2)
    {
      paramQQTabHost = this.a.b();
      if (paramQQTabHost != null) {
        paramQQTabHost.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hjo
 * JD-Core Version:    0.7.0.1
 */