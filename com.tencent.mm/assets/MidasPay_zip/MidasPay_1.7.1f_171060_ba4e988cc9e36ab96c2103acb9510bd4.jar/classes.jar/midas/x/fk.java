package midas.x;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.EditText;

public class fk
  extends Handler
{
  private iw a;
  
  public fk(iw paramiw)
  {
    this.a = paramiw;
  }
  
  private String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      int i;
      int n;
      try
      {
        if (paramString.length() > 8)
        {
          localObject1 = localObject2;
          if (paramString.contains("消费Q币验证码"))
          {
            i = 0;
            if (!paramString.startsWith("【腾讯科技】")) {
              break label110;
            }
            i = "【腾讯科技】".length();
            break label110;
            if (j < paramString.length())
            {
              n = paramString.charAt(j);
              if (n > 57) {
                break label118;
              }
              k = m;
              if (n >= 48) {
                break label158;
              }
              break label118;
            }
            localObject1 = localObject2;
            if (m != -1) {
              localObject1 = paramString.substring(i, m);
            }
          }
        }
        return localObject1;
      }
      catch (Exception paramString)
      {
        return null;
      }
      label110:
      int j = i;
      int m = -1;
      continue;
      label118:
      int k = m;
      if (m == -1)
      {
        if ((j != i + 6) && (j != i + 8)) {
          return null;
        }
        if (n != 65288) {
          return null;
        }
        k = j;
      }
      label158:
      if (k != -1)
      {
        if (((j == k + 1) || (k + 2 == j)) && (n != 81)) {
          return null;
        }
        if (((j == k + 3) || (j == k + 4)) && (n < 48) && (n > 57)) {
          return null;
        }
      }
      j += 1;
      m = k;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (String)paramMessage.obj;
    if (!TextUtils.isEmpty(paramMessage))
    {
      paramMessage = a(paramMessage);
      if (paramMessage != null)
      {
        this.a.a.setText(paramMessage);
        this.a.a.setSelection(paramMessage.length());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.fk
 * JD-Core Version:    0.7.0.1
 */