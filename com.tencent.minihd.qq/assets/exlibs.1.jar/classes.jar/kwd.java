import android.widget.Button;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;

public class kwd
  implements Runnable
{
  public kwd(VipFunCallPreviewActivity paramVipFunCallPreviewActivity) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.setText("已设置");
      this.a.a.setEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kwd
 * JD-Core Version:    0.7.0.1
 */