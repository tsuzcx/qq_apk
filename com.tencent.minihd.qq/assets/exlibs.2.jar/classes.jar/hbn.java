import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;

public class hbn
  extends Handler
{
  public hbn(VipSpecialCareHandler paramVipSpecialCareHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    VipSpecialCareHandler.access$000(this.a, "-->request timeout");
    VipSpecialCareHandler.access$100(this.a, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hbn
 * JD-Core Version:    0.7.0.1
 */