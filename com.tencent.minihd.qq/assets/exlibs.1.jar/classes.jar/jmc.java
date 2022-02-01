import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PresendPicMgr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class jmc
  extends Handler
{
  private final WeakReference a;
  
  public jmc(Looper paramLooper, PresendPicMgr paramPresendPicMgr)
  {
    super(paramLooper);
    this.a = new WeakReference(paramPresendPicMgr);
  }
  
  public void handleMessage(Message paramMessage)
  {
    PresendPicMgr localPresendPicMgr = (PresendPicMgr)this.a.get();
    if (localPresendPicMgr != null)
    {
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
        return;
      case 1: 
        localPresendPicMgr.a = paramMessage.replyTo;
        paramMessage = Message.obtain(null, 2);
        ArrayList localArrayList = new ArrayList();
        Object localObject = PresendPicMgr.a(localPresendPicMgr).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(((jmd)((Iterator)localObject).next()).a);
        }
        localObject = new Bundle();
        ((Bundle)localObject).putParcelableArrayList("flag_compressinfolist", localArrayList);
        paramMessage.setData((Bundle)localObject);
        try
        {
          localPresendPicMgr.a.send(paramMessage);
          localPresendPicMgr.a = null;
          PresendPicMgr.a(localPresendPicMgr);
          localPresendPicMgr.c();
          return;
        }
        catch (RemoteException paramMessage)
        {
          for (;;)
          {
            localPresendPicMgr.a = null;
            paramMessage.printStackTrace();
          }
        }
      }
      localPresendPicMgr.a = null;
      return;
    }
    Logger.b("PresendPicMgr", "handleMessage", "PresendPicMgr == null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jmc
 * JD-Core Version:    0.7.0.1
 */