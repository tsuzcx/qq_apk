import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.widget.XCursorAdapter;

public class lth
  extends ContentObserver
{
  public lth(XCursorAdapter paramXCursorAdapter)
  {
    super(new Handler());
  }
  
  public boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lth
 * JD-Core Version:    0.7.0.1
 */