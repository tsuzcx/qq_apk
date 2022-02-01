import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class cwv
{
  public String a = "";
  public String b = "";
  
  public boolean a(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    if (paramString == null) {}
    Object localObject2;
    label139:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while (!paramString.startsWith("https://iot.qq.com/add"));
            paramString = paramString.substring(paramString.indexOf("?") + 1);
          } while (TextUtils.isEmpty(paramString));
          String[] arrayOfString1 = paramString.split("&");
          if (arrayOfString1 != null)
          {
            int i = 0;
            paramString = null;
            localObject3 = localObject1;
            localObject2 = paramString;
            if (i < arrayOfString1.length)
            {
              String[] arrayOfString2 = arrayOfString1[i].split("=");
              localObject2 = localObject1;
              localObject3 = paramString;
              if (arrayOfString2 != null)
              {
                localObject2 = localObject1;
                localObject3 = paramString;
                if (arrayOfString2.length == 2)
                {
                  if (!arrayOfString2[0].equals("pid")) {
                    break label139;
                  }
                  localObject3 = arrayOfString2[1];
                  localObject2 = localObject1;
                }
              }
              for (;;)
              {
                i += 1;
                localObject1 = localObject2;
                paramString = (String)localObject3;
                break;
                localObject2 = localObject1;
                localObject3 = paramString;
                if (arrayOfString2[0].equals("sn"))
                {
                  localObject2 = arrayOfString2[1];
                  localObject3 = paramString;
                }
              }
            }
          }
          else
          {
            localObject2 = null;
          }
        } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)));
        if (((String)localObject3).length() == 16) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("smartdevice::DeviceScanner", 2, "device qrcode sn: " + (String)localObject3 + " is invalid, length:" + ((String)localObject3).length());
      return false;
    } while (Integer.parseInt((String)localObject2) < 1000000000);
    this.b = ((String)localObject3);
    this.a = ((String)localObject2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cwv
 * JD-Core Version:    0.7.0.1
 */