import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingUserCenterActivity;
import com.tencent.mobileqq.dating.DatingUserCenterAdapter;
import com.tencent.widget.XListView;
import java.util.List;

public class ica
  implements Handler.Callback
{
  public ica(DatingUserCenterActivity paramDatingUserCenterActivity) {}
  
  public boolean handleMessage(Message paramMessage)
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
          return false;
          DatingUserCenterActivity.a(this.a).sendEmptyMessage(4098);
          return false;
          DatingUserCenterActivity.a(this.a).B();
          return false;
          if (paramMessage.arg1 == 0)
          {
            if (paramMessage.obj != null) {
              DatingUserCenterActivity.a(this.a, (List)paramMessage.obj);
            }
            if ((DatingUserCenterActivity.a(this.a) != null) && (!DatingUserCenterActivity.a(this.a).isEmpty()))
            {
              DatingUserCenterActivity.a(this.a)[0] = 0;
              DatingUserCenterActivity.b(this.a)[0] = 0;
              if (DatingUserCenterActivity.a(this.a) == 0)
              {
                DatingUserCenterActivity.a(this.a, 0, DatingUserCenterActivity.a(this.a), true, false);
                DatingUserCenterActivity.a(this.a);
              }
              if ((System.currentTimeMillis() - DatingUserCenterActivity.a(this.a)[0] >= 180000L) || (System.currentTimeMillis() <= DatingUserCenterActivity.a(this.a)[0]))
              {
                i = DatingUserCenterActivity.a(this.a, "server_stamp_of_published");
                DatingUserCenterActivity.a(this.a).a(i, 0, 20, 0, 4100);
                return false;
              }
              DatingUserCenterActivity.b(this.a).removeMessages(8198);
              DatingUserCenterActivity.b(this.a).sendMessage(DatingUserCenterActivity.b(this.a).obtainMessage(8198, 0, 0));
              return false;
            }
            i = DatingUserCenterActivity.a(this.a, "server_stamp_of_published");
            DatingUserCenterActivity.a(this.a).a(i, 0, 20, 0, 4097);
            return false;
          }
        } while (paramMessage.arg1 != 1);
        if (paramMessage.obj != null) {
          DatingUserCenterActivity.b(this.a, (List)paramMessage.obj);
        }
        if ((DatingUserCenterActivity.b(this.a) != null) && (!DatingUserCenterActivity.b(this.a).isEmpty()))
        {
          DatingUserCenterActivity.a(this.a)[1] = 0;
          DatingUserCenterActivity.b(this.a)[1] = 0;
          if (DatingUserCenterActivity.a(this.a) == 1)
          {
            DatingUserCenterActivity.a(this.a, 1, DatingUserCenterActivity.b(this.a), true, false);
            DatingUserCenterActivity.b(this.a);
          }
          if ((System.currentTimeMillis() - DatingUserCenterActivity.a(this.a)[1] >= 180000L) || (System.currentTimeMillis() <= DatingUserCenterActivity.a(this.a)[1]))
          {
            i = DatingUserCenterActivity.a(this.a, "server_stamp_of_joined");
            this.a.a(new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(4100) });
            return false;
          }
          DatingUserCenterActivity.b(this.a).removeMessages(8198);
          DatingUserCenterActivity.b(this.a).sendMessage(DatingUserCenterActivity.b(this.a).obtainMessage(8198, 1, 0));
          return false;
        }
        int i = DatingUserCenterActivity.a(this.a, "server_stamp_of_joined");
        this.a.a(new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(4097) });
        return false;
        i = paramMessage.arg1;
        DatingUserCenterActivity.a(this.a, i);
        return false;
      } while (DatingUserCenterActivity.a(this.a) == null);
      DatingUserCenterActivity.a(this.a).b((int)(134.0F * this.a.getResources().getDisplayMetrics().density));
      return false;
      DatingUserCenterActivity.a(this.a).removeMessages(4102);
    } while (DatingUserCenterActivity.b(this.a) != 1);
    paramMessage = this.a;
    if (((DatingUserCenterActivity.a(this.a) == 0) && (DatingUserCenterActivity.a(this.a).size() > 0)) || ((DatingUserCenterActivity.a(this.a) == 1) && (DatingUserCenterActivity.b(this.a).size() > 0))) {}
    for (boolean bool = true;; bool = false)
    {
      paramMessage.enableLeftBtn(bool);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ica
 * JD-Core Version:    0.7.0.1
 */