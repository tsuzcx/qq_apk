import android.widget.ImageView;
import com.tencent.mobileqq.nearpeople.TurnBrandLoadingView;

public class jky
  implements Runnable
{
  public jky(TurnBrandLoadingView paramTurnBrandLoadingView) {}
  
  public void run()
  {
    TurnBrandLoadingView.a(this.a);
    if (TurnBrandLoadingView.a(this.a) != null) {
      TurnBrandLoadingView.a(this.a).startAnimation(TurnBrandLoadingView.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jky
 * JD-Core Version:    0.7.0.1
 */