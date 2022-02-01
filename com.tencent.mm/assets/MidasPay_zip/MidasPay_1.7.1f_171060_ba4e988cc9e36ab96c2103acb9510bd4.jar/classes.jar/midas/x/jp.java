package midas.x;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class jp
  extends ju
{
  private kf b;
  
  jp(kf paramkf)
  {
    this.b = paramkf;
  }
  
  private jo a(jy paramjy, jo paramjo)
  {
    synchronized (a)
    {
      if (this.b == null) {
        return paramjo;
      }
      jo localjo = a(this.b);
      if (jz.c(localjo))
      {
        this.b.a(localjo);
        jh.b("EndGetKey", "Get key success after 1094 1099 1105!");
        paramjo = this.b.a(paramjy);
        int i = jz.b(paramjo);
        if ((i == 1099) || (i == 1094) || (i == 1105)) {
          a(this.b, paramjy);
        }
        return paramjo;
      }
      a(this.b, localjo);
      return paramjo;
    }
  }
  
  private static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = null;
    try
    {
      paramString = new JSONObject(paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = localObject;
    }
    if (paramString == null) {
      return false;
    }
    return paramString.optInt("need_change_key") == 1;
  }
  
  public jo a(jn paramjn, jo paramjo)
  {
    if (paramjn == null) {
      return paramjo;
    }
    try
    {
      boolean bool = paramjn instanceof jy;
      if (!bool) {
        return paramjo;
      }
      if (!((jy)paramjn).t)
      {
        jh.c("EndGetKey", "Request set no need end get key");
        return paramjo;
      }
      Object localObject = this.b;
      if (localObject == null) {
        return paramjo;
      }
      bool = this.b.a(paramjn);
      if (bool) {
        return paramjo;
      }
      localObject = this.b.e();
      if (localObject == null) {
        return paramjo;
      }
      int i = jz.b(paramjo);
      if (i != 0)
      {
        if ((i == 1094) || (i == 1099) || (i == 1105))
        {
          a(this.b, paramjn);
          paramjn = a((jy)paramjn, paramjo);
          return paramjn;
        }
      }
      else if (a(paramjo.b))
      {
        a(this.b, (jy)localObject);
        paramjn = new ja()
        {
          public void a_(jo paramAnonymousjo)
          {
            if (jz.c(paramAnonymousjo))
            {
              jp.a(jp.this).a(paramAnonymousjo);
              return;
            }
            ju.a(jp.a(jp.this), paramAnonymousjo);
          }
        };
        this.b.a((jy)localObject, paramjn);
      }
      return paramjo;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.jp
 * JD-Core Version:    0.7.0.1
 */