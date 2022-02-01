import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.MayKnowAdapter;
import java.lang.ref.WeakReference;
import java.util.List;

public class gfv
  extends Handler
{
  private WeakReference a;
  
  public gfv(AddContactsView paramAddContactsView)
  {
    this.a = new WeakReference(paramAddContactsView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    AddContactsView localAddContactsView = (AddContactsView)this.a.get();
    if (localAddContactsView == null) {}
    do
    {
      return;
      List localList;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        localList = (List)paramMessage.obj;
        AddContactsView.a(localAddContactsView).b(localList);
        AddContactsView.a(localAddContactsView, paramMessage.arg1);
        AddContactsView.a(localAddContactsView).notifyDataSetChanged();
        return;
      case 2: 
        localList = (List)paramMessage.obj;
        AddContactsView.a(localAddContactsView).a(localList);
        AddContactsView.a(localAddContactsView, paramMessage.arg1);
        AddContactsView.a(localAddContactsView).notifyDataSetChanged();
        return;
      case 3: 
        AddContactsView.a(localAddContactsView, paramMessage.arg1);
        AddContactsView.a(localAddContactsView).notifyDataSetChanged();
        return;
      }
    } while (AddContactsView.a(localAddContactsView) == 2);
    boolean bool1;
    if (paramMessage.arg1 < AddContactsView.a())
    {
      bool1 = true;
      if (paramMessage.arg2 != 1) {
        break label196;
      }
    }
    for (;;)
    {
      AddContactsView.a(localAddContactsView, bool1, bool2, null);
      return;
      bool1 = false;
      break;
      label196:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gfv
 * JD-Core Version:    0.7.0.1
 */