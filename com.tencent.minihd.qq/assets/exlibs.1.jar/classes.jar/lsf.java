import android.database.DataSetObserver;
import com.tencent.widget.HorizontalListView;

public class lsf
  extends DataSetObserver
{
  public lsf(HorizontalListView paramHorizontalListView) {}
  
  public void onChanged()
  {
    synchronized (this.a)
    {
      HorizontalListView.a(this.a, true);
      this.a.invalidate();
      this.a.requestLayout();
      return;
    }
  }
  
  public void onInvalidated()
  {
    HorizontalListView.a(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lsf
 * JD-Core Version:    0.7.0.1
 */