import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.fling.ContentWrapView;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.fling.TopLayout;
import java.lang.ref.WeakReference;

public class gnk
  implements Runnable
{
  public gnk(FlingTrackerHandler paramFlingTrackerHandler) {}
  
  public void run()
  {
    Object localObject1 = (Activity)this.a.a.get();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      Object localObject2;
      if (!ScreenCapture.hasSnapFile((Context)localObject1))
      {
        if (FlingTrackerHandler.a(this.a) > 5) {
          FlingTrackerHandler.a(this.a, 0);
        }
      }
      else
      {
        localObject2 = (ViewGroup)((Activity)localObject1).getWindow().getDecorView();
        if (FlingTrackerHandler.a(this.a) != null) {
          break label303;
        }
        FlingTrackerHandler.a(this.a, ((ViewGroup)localObject2).getChildAt(0));
        View localView = FlingTrackerHandler.a(this.a);
        FlingTrackerHandler.a(this.a, new TopLayout((Context)localObject1));
        FlingTrackerHandler.a(this.a).setBackgroundColor(-16777216);
        TopLayout localTopLayout = FlingTrackerHandler.a(this.a);
        localTopLayout.setOnDraggingListener(this.a);
        ((ViewGroup)localObject2).addView(localTopLayout);
        ((ViewGroup)localObject2).removeView(localView);
        FlingTrackerHandler.a(this.a, new ContentWrapView((Context)localObject1));
        localObject2 = FlingTrackerHandler.a(this.a);
        ((ContentWrapView)localObject2).addView(localView);
        localTopLayout.setContent((ContentWrapView)localObject2);
        FlingTrackerHandler.a(this.a, new ImageView((Context)localObject1));
        FlingTrackerHandler.a(this.a).setScaleType(ImageView.ScaleType.FIT_START);
        localObject1 = FlingTrackerHandler.a(this.a);
        ((ImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        localTopLayout.setBehind((View)localObject1);
      }
      while ((this.a.a()) && (FlingTrackerHandler.a(this.a) != null) && (FlingTrackerHandler.a(this.a).getDrawable() == null))
      {
        FlingTrackerHandler.a(this.a);
        return;
        FlingTrackerHandler.b(this.a);
        FlingTrackerHandler.a(this.a).postDelayed(this, 100L);
        return;
        label303:
        if (!this.a.a())
        {
          ((ViewGroup)localObject2).addView(FlingTrackerHandler.a(this.a));
          ((ViewGroup)localObject2).removeView(FlingTrackerHandler.a(this.a));
          FlingTrackerHandler.a(this.a).addView(FlingTrackerHandler.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gnk
 * JD-Core Version:    0.7.0.1
 */