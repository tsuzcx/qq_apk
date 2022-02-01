import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.util.DesUtils;
import java.io.UnsupportedEncodingException;

public class erb
  extends Thread
{
  public erb(QQBrowserActivity paramQQBrowserActivity, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    Object localObject = null;
    label31:
    do
    {
      byte[] arrayOfByte2;
      try
      {
        byte[] arrayOfByte1 = "65dRa93L".getBytes("utf-8");
        if (arrayOfByte1 == null) {
          return;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          arrayOfByte2 = null;
        }
      }
      try
      {
        byte[] arrayOfByte3 = "mqq|icon|13".getBytes("utf-8");
        localObject = arrayOfByte3;
      }
      catch (Exception localException)
      {
        break label31;
      }
    } while (localObject == null);
    arrayOfByte2 = DesUtils.a(arrayOfByte2, localObject, 1);
    QQBrowserActivity.a(this.a, "https://p.mb.qq.com/sdk", arrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     erb
 * JD-Core Version:    0.7.0.1
 */