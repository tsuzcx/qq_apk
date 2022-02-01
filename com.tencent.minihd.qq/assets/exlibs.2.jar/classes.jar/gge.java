import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.PublicView;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;

public class gge
  extends Handler
{
  private WeakReference a;
  
  public gge(PublicView paramPublicView)
  {
    this.a = new WeakReference(paramPublicView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    PublicView localPublicView = (PublicView)this.a.get();
    if (localPublicView == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      PublicView.a(localPublicView).B();
      return;
    case 2: 
      PublicView.a(localPublicView).B();
      PublicView.a(localPublicView, 1, 2131366939);
      return;
    case 3: 
      PublicView.a(localPublicView, true);
      return;
    }
    PublicView.b(localPublicView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gge
 * JD-Core Version:    0.7.0.1
 */