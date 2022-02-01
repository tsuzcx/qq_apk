import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class bg
  implements View.OnTouchListener
{
  public bg(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      LiteActivity.b(this.a);
      if ((LiteActivity.a(this.a) != null) && (LiteActivity.a(this.a).size() == 0) && (QLog.isColorLevel()))
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        int k = paramView.getScrollY();
        int m = ((AbsListView)paramView).getChildCount();
        int n = ((AbsListView)paramView).a(i, j + k);
        QLog.d(LiteActivity.a, 2, "x: " + i + " y: " + j + " scrolly:" + k + " motionPosition: " + n + " childCount: " + m);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bg
 * JD-Core Version:    0.7.0.1
 */