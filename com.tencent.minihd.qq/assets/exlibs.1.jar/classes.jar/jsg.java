import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.richstatus.EditActivity;

public class jsg
  implements ViewPager.OnPageChangeListener
{
  public jsg(EditActivity paramEditActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.a.l = paramInt;
    int i = 0;
    for (;;)
    {
      if (i < EditActivity.a(this.a).length - 1)
      {
        if ((paramInt >= EditActivity.a(this.a)[i]) && (paramInt < EditActivity.a(this.a)[(i + 1)])) {
          EditActivity.a(this.a, i);
        }
      }
      else
      {
        if (paramInt == EditActivity.a(this.a)[(EditActivity.a(this.a).length - 1)]) {
          EditActivity.a(this.a, EditActivity.a(this.a).length - 1);
        }
        Message localMessage = this.a.a.obtainMessage(3, Integer.valueOf(paramInt));
        this.a.a.sendMessageDelayed(localMessage, 100L);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jsg
 * JD-Core Version:    0.7.0.1
 */