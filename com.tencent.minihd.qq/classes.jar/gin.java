import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class gin
  extends Handler
{
  public gin(SystemMsgListView paramSystemMsgListView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (SystemMsgListView.a(this.a) == null);
        this.a.j();
        SystemMsgListView.a(this.a).notifyDataSetChanged();
        return;
      } while (SystemMsgListView.a(this.a).m() <= 0);
      SystemMsgListView.a(this.a).a(this.a.e);
      return;
    } while (SystemMsgListView.a(this.a) == null);
    SystemMsgListView.a(this.a).a(this.a.e);
    this.a.e.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gin
 * JD-Core Version:    0.7.0.1
 */