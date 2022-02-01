package midas.x;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class hb
  extends mb
{
  public zb b;
  
  public hb(zb paramzb)
  {
    this.b = paramzb;
  }
  
  public static boolean a(String paramString)
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
  
  public gb a(fb paramfb, gb paramgb)
  {
    if (paramfb == null) {
      return paramgb;
    }
    try
    {
      boolean bool = paramfb instanceof qb;
      if (!bool) {
        return paramgb;
      }
      if (!((qb)paramfb).x)
      {
        ya.c("EndGetKey", "Request set no need end get key");
        return paramgb;
      }
      Object localObject = this.b;
      if (localObject == null) {
        return paramgb;
      }
      bool = this.b.a(paramfb);
      if (bool) {
        return paramgb;
      }
      localObject = this.b.c();
      if (localObject == null) {
        return paramgb;
      }
      int i = rb.b(paramgb);
      if (i != 0)
      {
        if ((i == 1094) || (i == 1099) || (i == 1105))
        {
          mb.a(this.b, paramfb);
          paramfb = a((qb)paramfb, paramgb);
          return paramfb;
        }
      }
      else if (a(paramgb.b))
      {
        mb.a(this.b, (qb)localObject);
        paramfb = new a();
        this.b.a((qb)localObject, paramfb);
      }
      return paramgb;
    }
    finally {}
  }
  
  public final gb a(qb paramqb, gb paramgb)
  {
    synchronized (mb.a)
    {
      if (this.b == null) {
        return paramgb;
      }
      gb localgb = a(this.b);
      if (rb.d(localgb))
      {
        this.b.a(localgb);
        ya.a("EndGetKey", "Get key success after 1094 1099 1105!");
        paramgb = this.b.a(paramqb);
        int i = rb.b(paramgb);
        if ((i == 1099) || (i == 1094) || (i == 1105)) {
          mb.a(this.b, paramqb);
        }
        return paramgb;
      }
      mb.a(this.b, localgb);
      return paramgb;
    }
  }
  
  public class a
    implements ra
  {
    public a() {}
    
    public void a(gb paramgb)
    {
      if (rb.d(paramgb))
      {
        hb.a(hb.this).a(paramgb);
        return;
      }
      mb.a(hb.a(hb.this), paramgb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.hb
 * JD-Core Version:    0.7.0.1
 */