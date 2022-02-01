import com.tencent.widget.TipsPopupWindow;

public class lsz
  implements Runnable
{
  public lsz(TipsPopupWindow paramTipsPopupWindow) {}
  
  public void run()
  {
    TipsPopupWindow.a(this.a);
    TipsPopupWindow.a(this.a, false);
    TipsPopupWindow.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lsz
 * JD-Core Version:    0.7.0.1
 */