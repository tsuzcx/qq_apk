import com.tencent.mobileqq.activity.BookShareAdviceEditActivity;
import com.tencent.mobileqq.activity.book.ResizeLayout;
import com.tencent.mobileqq.activity.book.ResizeLayout.OnResizeListener;

public class dki
  implements ResizeLayout.OnResizeListener
{
  public dki(BookShareAdviceEditActivity paramBookShareAdviceEditActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Math.abs(paramInt2 - paramInt4) < BookShareAdviceEditActivity.a(this.a, this.a, 100.0F)) {}
    do
    {
      return;
      if (paramInt2 - paramInt4 < 0)
      {
        this.a.a(true);
        return;
      }
    } while (paramInt2 - paramInt4 <= 0);
    this.a.a(false);
    this.a.a.post(new dkj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dki
 * JD-Core Version:    0.7.0.1
 */