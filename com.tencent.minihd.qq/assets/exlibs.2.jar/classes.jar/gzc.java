import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;

public class gzc
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public gzc(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onGlobalLayout()
  {
    ShortVideoPlayActivity.a(this.a, ShortVideoPlayActivity.a(this.a).getWidth());
    ShortVideoPlayActivity.b(this.a, ShortVideoPlayActivity.a(this.a).getHeight());
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onGlobalLayout,mSurfaceViewWidth:" + ShortVideoPlayActivity.b(this.a) + ",mSurfaceViewHeight:" + ShortVideoPlayActivity.c(this.a));
    }
    ShortVideoPlayActivity.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gzc
 * JD-Core Version:    0.7.0.1
 */