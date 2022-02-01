import android.database.DataSetObserver;
import com.tencent.widget.XCursorAdapter;

public class lti
  extends DataSetObserver
{
  private lti(XCursorAdapter paramXCursorAdapter) {}
  
  public void onChanged()
  {
    this.a.a = true;
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.a = false;
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lti
 * JD-Core Version:    0.7.0.1
 */