import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.QQAppInterface;

public class dkk
  implements Handler.Callback
{
  public dkk(Call paramCall) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!this.a.app.isLogin()) {}
    do
    {
      do
      {
        do
        {
          return true;
          switch (paramMessage.what)
          {
          case 1023: 
          case 1024: 
          case 1026: 
          case 1028: 
          case 1029: 
          default: 
            return false;
          case 1025: 
            Call.a(this.a);
            return true;
          case 1020: 
            Call.b(this.a);
            return true;
          case 1030: 
            Call.c(this.a);
            return true;
          }
        } while (Call.a(this.a) == null);
        Call.a(this.a).a(paramMessage);
        return true;
      } while (Call.a(this.a) == null);
      Call.a(this.a).i();
      return true;
    } while (this.a.app == null);
    this.a.app.B();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dkk
 * JD-Core Version:    0.7.0.1
 */