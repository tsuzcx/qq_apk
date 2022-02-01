import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingCacheDel;
import com.tencent.mobileqq.dating.DatingCacheMng;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingUserCenterActivity;

public class ice
  implements Handler.Callback
{
  public ice(DatingUserCenterActivity paramDatingUserCenterActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    case 8194: 
    default: 
      return false;
    case 8193: 
      localObject = (DatingManager)this.a.app.getManager(67);
      if ((localObject != null) && ((paramMessage.arg1 == 0) || (paramMessage.arg1 == 1)))
      {
        localObject = ((DatingManager)localObject).a();
        if (paramMessage.arg1 == 0) {
          i = 1;
        }
      }
      break;
    }
    label95:
    for (Object localObject = ((DatingCacheMng)localObject).a(i);; localObject = null)
    {
      Message localMessage = Message.obtain(DatingUserCenterActivity.a(this.a));
      localMessage.obj = localObject;
      localMessage.arg1 = paramMessage.arg1;
      localMessage.what = 4099;
      DatingUserCenterActivity.a(this.a).sendMessage(localMessage);
      return false;
      i = 2;
      break label95;
      DatingUserCenterActivity.b(this.a).removeMessages(8196);
      if (DatingUserCenterActivity.b(this.a) == 0) {
        i = 1;
      }
      for (;;)
      {
        ((DatingManager)this.a.app.getManager(67)).a(DatingUserCenterActivity.a(this.a), 1, i);
        return false;
        if (DatingUserCenterActivity.b(this.a) == 1)
        {
          i = 5;
          continue;
          DatingUserCenterActivity.b(this.a).removeMessages(8197);
          if (DatingUserCenterActivity.b(this.a) == 0) {}
          for (;;)
          {
            ((DatingManager)this.a.app.getManager(67)).a(DatingUserCenterActivity.a(this.a), 2, i);
            return false;
            if (DatingUserCenterActivity.b(this.a) == 1) {
              i = 5;
            }
          }
          paramMessage = (Object[])paramMessage.obj;
          localObject = (DatingManager)this.a.app.getManager(67);
          if (((Integer)paramMessage[2]).intValue() == 0)
          {
            ((DatingManager)localObject).a((String)paramMessage[0], ((Boolean)paramMessage[1]).booleanValue(), 1);
            DatingUserCenterActivity.a(this.a);
            return false;
          }
          ((DatingManager)localObject).a((String)paramMessage[0], ((Boolean)paramMessage[1]).booleanValue(), 2);
          DatingUserCenterActivity.b(this.a);
          return false;
          i = paramMessage.arg1;
          paramMessage = (DatingManager)this.a.app.getManager(67);
          if ((i == 0) && ((paramMessage.a[0] == 0) || (paramMessage.a().a(1, 1))))
          {
            i = DatingUserCenterActivity.a(this.a, "server_stamp_of_published");
            DatingUserCenterActivity.a(this.a).a(i, 0, 20, 0, 4100);
            return false;
          }
          if ((i != 1) || ((paramMessage.a[1] != 0) && (!paramMessage.a().a(2, 1)))) {
            break;
          }
          i = DatingUserCenterActivity.a(this.a, "server_stamp_of_joined");
          this.a.a(new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(4100) });
          return false;
        }
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ice
 * JD-Core Version:    0.7.0.1
 */