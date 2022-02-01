import android.database.DataSetObserver;
import com.tencent.mobileqq.filemanager.widget.QfileHorizontalListView;

public class jbs
  extends DataSetObserver
{
  public jbs(QfileHorizontalListView paramQfileHorizontalListView) {}
  
  public void onChanged()
  {
    synchronized (this.a)
    {
      QfileHorizontalListView.a(this.a, true);
      this.a.invalidate();
      this.a.requestLayout();
      return;
    }
  }
  
  public void onInvalidated()
  {
    QfileHorizontalListView.a(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jbs
 * JD-Core Version:    0.7.0.1
 */