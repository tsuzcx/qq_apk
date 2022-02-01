import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;

class djp
  implements Runnable
{
  djp(djo paramdjo) {}
  
  public void run()
  {
    if ((BaseChatPie.b(this.a.a.a) != null) && (BaseChatPie.b(this.a.a.a).getParent() != null)) {
      ((ViewGroup)BaseChatPie.b(this.a.a.a).getParent()).removeView(BaseChatPie.b(this.a.a.a));
    }
    BaseChatPie.b(this.a.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     djp
 * JD-Core Version:    0.7.0.1
 */