import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;

public class gux
  extends Handler
{
  public gux(DrawerFrame paramDrawerFrame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        boolean bool = DrawerFrame.a(this.a).computeScrollOffset();
        int i = DrawerFrame.a(this.a).getCurrX();
        int j = DrawerFrame.a(this.a);
        DrawerFrame.a(this.a, DrawerFrame.a(this.a).getCurrX());
        if (DrawerFrame.a(this.a) != null)
        {
          DrawerFrame.a(this.a).offsetLeftAndRight(i - j);
          this.a.a(DrawerFrame.b(this.a), DrawerFrame.a(this.a));
        }
        this.a.postInvalidate();
        if (!bool)
        {
          DrawerFrame.a(this.a, false);
          DrawerFrame.b(this.a, true);
          DrawerFrame.a(this.a).sendEmptyMessage(3);
          return;
        }
        DrawerFrame.a(this.a).sendEmptyMessage(1);
        return;
        bool = DrawerFrame.a(this.a).computeScrollOffset();
        i = DrawerFrame.a(this.a).getCurrX();
        j = DrawerFrame.a(this.a);
        DrawerFrame.a(this.a, DrawerFrame.a(this.a).getCurrX());
        if (DrawerFrame.a(this.a) != null)
        {
          DrawerFrame.a(this.a).offsetLeftAndRight(i - j);
          this.a.a(DrawerFrame.b(this.a), DrawerFrame.a(this.a));
        }
        this.a.postInvalidate();
        if (!bool)
        {
          DrawerFrame.a(this.a, false);
          DrawerFrame.b(this.a, false);
          if (DrawerFrame.b(this.a) != null) {
            DrawerFrame.b(this.a).setVisibility(8);
          }
          if (DrawerFrame.a(this.a) != null) {
            DrawerFrame.a(this.a).setVisibility(8);
          }
          DrawerFrame.a(this.a).sendEmptyMessage(4);
          return;
        }
        DrawerFrame.a(this.a).sendEmptyMessage(2);
        return;
      } while (DrawerFrame.a(this.a));
      if (DrawerFrame.a(this.a) != null) {
        DrawerFrame.a(this.a).b(DrawerFrame.b(this.a), DrawerFrame.c(this.a));
      }
      DrawerFrame.b(this.a, 0);
      DrawerFrame.c(this.a, 0);
      DrawerFrame.a(this.a, DrawerFrame.b(this.a), 1);
      return;
    } while (DrawerFrame.a(this.a));
    if (DrawerFrame.a(this.a) != null) {
      DrawerFrame.a(this.a).a(DrawerFrame.b(this.a), DrawerFrame.c(this.a));
    }
    DrawerFrame.b(this.a, 0);
    DrawerFrame.a(this.a, DrawerFrame.b(this.a), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gux
 * JD-Core Version:    0.7.0.1
 */