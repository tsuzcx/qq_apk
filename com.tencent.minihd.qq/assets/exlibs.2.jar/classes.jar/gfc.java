import android.os.Message;
import android.os.Process;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.util.WeakReferenceHandler;
import java.util.List;

public class gfc
  implements Runnable
{
  public gfc(SearchResultDialog paramSearchResultDialog) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    List localList = this.a.a(this.a.getContext(), SearchResultDialog.a(this.a), SearchResultDialog.a(this.a));
    Message localMessage = SearchResultDialog.a(this.a).obtainMessage();
    localMessage.what = 1;
    localMessage.obj = localList;
    SearchResultDialog.a(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gfc
 * JD-Core Version:    0.7.0.1
 */