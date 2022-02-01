package midas.x;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class la
  extends lf
{
  private lq b;
  
  la(lq paramlq)
  {
    this.b = paramlq;
  }
  
  private kz a(lj paramlj, kz paramkz)
  {
    synchronized (a)
    {
      if (this.b == null) {
        return paramkz;
      }
      kz localkz = a(this.b);
      if (lk.c(localkz))
      {
        this.b.a(localkz);
        ks.b("EndGetKey", "Get key success after 1094 1099 1105!");
        paramkz = this.b.a(paramlj);
        int i = lk.b(paramkz);
        if ((i == 1099) || (i == 1094) || (i == 1105)) {
          a(this.b, paramlj);
        }
        return paramkz;
      }
      a(this.b, localkz);
      return paramkz;
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
  
  public kz a(ky paramky, kz paramkz)
  {
    if (paramky == null) {
      return paramkz;
    }
    try
    {
      boolean bool = paramky instanceof lj;
      if (!bool) {
        return paramkz;
      }
      if (!((lj)paramky).t)
      {
        ks.c("EndGetKey", "Request set no need end get key");
        return paramkz;
      }
      Object localObject = this.b;
      if (localObject == null) {
        return paramkz;
      }
      bool = this.b.a(paramky);
      if (bool) {
        return paramkz;
      }
      localObject = this.b.e();
      if (localObject == null) {
        return paramkz;
      }
      int i = lk.b(paramkz);
      if (i != 0)
      {
        if ((i == 1094) || (i == 1099) || (i == 1105))
        {
          a(this.b, paramky);
          paramky = a((lj)paramky, paramkz);
          return paramky;
        }
      }
      else if (a(paramkz.b))
      {
        a(this.b, (lj)localObject);
        paramky = new kl()
        {
          public void a_(kz paramAnonymouskz)
          {
            if (lk.c(paramAnonymouskz))
            {
              la.a(la.this).a(paramAnonymouskz);
              return;
            }
            lf.a(la.a(la.this), paramAnonymouskz);
          }
        };
        this.b.a((lj)localObject, paramky);
      }
      return paramkz;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.la
 * JD-Core Version:    0.7.0.1
 */