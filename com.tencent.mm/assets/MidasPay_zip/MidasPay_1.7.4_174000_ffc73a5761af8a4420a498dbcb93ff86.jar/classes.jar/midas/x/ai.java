package midas.x;

import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

public class ai
  extends HandlerThread
  implements Handler.Callback
{
  public ai(String paramString)
  {
    super(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ai
 * JD-Core Version:    0.7.0.1
 */