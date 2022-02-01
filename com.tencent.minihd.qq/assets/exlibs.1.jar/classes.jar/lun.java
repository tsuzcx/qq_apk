import android.database.DataSetObserver;
import com.tencent.widget.widget.WheelView;

public class lun
  extends DataSetObserver
{
  public lun(WheelView paramWheelView) {}
  
  public void onChanged()
  {
    this.a.a(false);
  }
  
  public void onInvalidated()
  {
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lun
 * JD-Core Version:    0.7.0.1
 */