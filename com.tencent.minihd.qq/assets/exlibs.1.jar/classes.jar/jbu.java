import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.filemanager.widget.QfileHorizontalListView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class jbu
  extends GestureDetector.SimpleOnGestureListener
{
  public jbu(QfileHorizontalListView paramQfileHorizontalListView) {}
  
  private boolean a(MotionEvent paramMotionEvent, View paramView)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = paramView.getWidth();
    int k = arrayOfInt[1];
    localRect.set(i, k, j + i, paramView.getHeight() + k);
    return localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return this.a.a(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return this.a.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    int j = this.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        View localView = this.a.getChildAt(i);
        if (!a(paramMotionEvent, localView)) {
          break label99;
        }
        if (QfileHorizontalListView.a(this.a) != null) {
          QfileHorizontalListView.a(this.a).a(this.a, localView, QfileHorizontalListView.a(this.a) + 1 + i, this.a.a.getItemId(i + (QfileHorizontalListView.a(this.a) + 1)));
        }
      }
      return;
      label99:
      i += 1;
    }
  }
  
  public boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      paramMotionEvent2 = this.a;
      paramMotionEvent2.b += (int)paramFloat1;
      this.a.requestLayout();
      return true;
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.a.getChildCount())
      {
        View localView = this.a.getChildAt(i);
        if (!a(paramMotionEvent, localView)) {
          break label155;
        }
        if (QfileHorizontalListView.a(this.a) != null) {
          QfileHorizontalListView.a(this.a).a(this.a, localView, QfileHorizontalListView.a(this.a) + 1 + i, this.a.a.getItemId(QfileHorizontalListView.a(this.a) + 1 + i));
        }
        if (QfileHorizontalListView.a(this.a) != null) {
          QfileHorizontalListView.a(this.a).b(this.a, localView, QfileHorizontalListView.a(this.a) + 1 + i, this.a.a.getItemId(QfileHorizontalListView.a(this.a) + 1 + i));
        }
      }
      return true;
      label155:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jbu
 * JD-Core Version:    0.7.0.1
 */