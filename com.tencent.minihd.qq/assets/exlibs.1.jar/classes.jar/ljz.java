import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.av.opengl.ui.GLVideoView;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qav.ui.C2CVideoLayer;
import com.tencent.qav.ui.C2CVideoView;

public class ljz
  extends GestureDetector.SimpleOnGestureListener
{
  public ljz(C2CVideoLayer paramC2CVideoLayer) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    C2CVideoView localC2CVideoView2;
    C2CVideoView localC2CVideoView1;
    if (C2CVideoLayer.a(this.a))
    {
      localC2CVideoView2 = C2CVideoLayer.a(this.a);
      localC2CVideoView1 = C2CVideoLayer.b(this.a);
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if (!localC2CVideoView2.getBounds().contains(i, j)) {
        break label87;
      }
      C2CVideoLayer.a(this.a, localC2CVideoView2, localC2CVideoView1);
    }
    for (;;)
    {
      return true;
      localC2CVideoView2 = C2CVideoLayer.b(this.a);
      localC2CVideoView1 = C2CVideoLayer.a(this.a);
      break;
      label87:
      if (C2CVideoLayer.a(this.a) != null) {
        C2CVideoLayer.a(this.a).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljz
 * JD-Core Version:    0.7.0.1
 */