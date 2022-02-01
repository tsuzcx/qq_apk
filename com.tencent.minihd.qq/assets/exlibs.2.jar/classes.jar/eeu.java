import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.widget.ADViewIndividuation;

public class eeu
  implements URLDrawableDownListener
{
  public eeu(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    View localView = (View)paramView.getTag();
    if ((localView != null) && ((localView instanceof ProgressBar))) {
      localView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      float f = paramURLDrawable.getIntrinsicHeight() / paramURLDrawable.getIntrinsicWidth();
      paramURLDrawable = new DisplayMetrics();
      this.a.getWindowManager().getDefaultDisplay().getMetrics(paramURLDrawable);
      paramView.height = ((int)(f * paramURLDrawable.widthPixels + 0.5F));
      return;
      if ((localView != null) && ((localView instanceof ADViewIndividuation))) {
        ((ADViewIndividuation)localView).setNavVisible(1, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eeu
 * JD-Core Version:    0.7.0.1
 */