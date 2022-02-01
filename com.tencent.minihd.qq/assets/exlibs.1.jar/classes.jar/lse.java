import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.HorizontalListView;

public class lse
  extends GestureDetector.SimpleOnGestureListener
{
  public lse(HorizontalListView paramHorizontalListView) {}
  
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
        if (HorizontalListView.a(this.a) != null) {
          HorizontalListView.a(this.a).a(this.a, localView, HorizontalListView.a(this.a) + 1 + i, this.a.a.getItemId(i + (HorizontalListView.a(this.a) + 1)));
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
        if (HorizontalListView.a(this.a) != null) {
          HorizontalListView.a(this.a).a(this.a, localView, HorizontalListView.a(this.a) + 1 + i, this.a.a.getItemId(HorizontalListView.a(this.a) + 1 + i));
        }
        if (HorizontalListView.a(this.a) != null) {
          HorizontalListView.a(this.a).b(this.a, localView, HorizontalListView.a(this.a) + 1 + i, this.a.a.getItemId(HorizontalListView.a(this.a) + 1 + i));
        }
      }
      return true;
      label155:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lse
 * JD-Core Version:    0.7.0.1
 */