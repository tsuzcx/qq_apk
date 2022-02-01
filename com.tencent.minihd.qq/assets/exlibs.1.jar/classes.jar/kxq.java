import android.os.Handler;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;

public class kxq
  implements Runnable
{
  public kxq(CustomHorizontalScrollView paramCustomHorizontalScrollView) {}
  
  public void run()
  {
    int i = this.a.getScrollX();
    if (i == CustomHorizontalScrollView.a(this.a))
    {
      int j = i % (CustomHorizontalScrollView.b(this.a) + CustomHorizontalScrollView.c(this.a));
      if (CustomHorizontalScrollView.d(this.a) + i >= CustomHorizontalScrollView.e(this.a)) {
        return;
      }
      if (j < CustomHorizontalScrollView.b(this.a) / 2) {
        this.a.smoothScrollBy(-j, 0);
      }
      for (;;)
      {
        CustomHorizontalScrollView.a(this.a, i);
        return;
        if (j >= CustomHorizontalScrollView.b(this.a) / 2)
        {
          int k = CustomHorizontalScrollView.b(this.a);
          int m = CustomHorizontalScrollView.c(this.a);
          this.a.smoothScrollBy(k + m - j, 0);
        }
      }
    }
    CustomHorizontalScrollView.a(this.a, i);
    CustomHorizontalScrollView.a(this.a).postDelayed(CustomHorizontalScrollView.a(this.a), 5L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kxq
 * JD-Core Version:    0.7.0.1
 */