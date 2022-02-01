import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class dxk
  implements TabBarView.OnTabChangeListener
{
  public dxk(EmosmActivity paramEmosmActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    if (paramInt2 == 0) {
      this.a.h = 1;
    }
    for (;;)
    {
      this.a.c = false;
      this.a.runOnUiThread(this.a.a);
      return;
      if (paramInt2 == 1) {
        this.a.h = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dxk
 * JD-Core Version:    0.7.0.1
 */