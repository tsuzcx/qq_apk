package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.io.PrintStream;
import java.util.HashMap;

public class o4
  implements Cloneable
{
  public String a = "";
  public APBaseRequest b = null;
  public w4 c = null;
  public q4 d = null;
  public c5 e = null;
  public d5 f = null;
  
  public o4(APBaseRequest paramAPBaseRequest)
  {
    this.b = paramAPBaseRequest;
    if ((paramAPBaseRequest.saveType == 0) && (paramAPBaseRequest.acctType.equals("qb")))
    {
      paramAPBaseRequest.saveType = 3;
      if (TextUtils.isEmpty(paramAPBaseRequest.saveValue)) {
        paramAPBaseRequest.saveValue = "10";
      }
    }
    if (b(paramAPBaseRequest)) {
      a(a(paramAPBaseRequest));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveType:");
    localStringBuilder.append(paramAPBaseRequest.saveType);
    APLog.i("APOrderInfo", localStringBuilder.toString());
    int i = paramAPBaseRequest.saveType;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5) {
                h();
              }
            }
            else {
              d();
            }
          }
          else {
            e();
          }
        }
        else {
          f();
        }
      }
      else {
        c();
      }
    }
    else {
      a();
    }
    this.e = new c5();
    this.f = new d5();
    this.f.f = paramAPBaseRequest.saveValue;
  }
  
  public final String a(APBaseRequest paramAPBaseRequest)
  {
    if (b(paramAPBaseRequest)) {
      return (String)APTools.n(paramAPBaseRequest.reserv).get("orderid");
    }
    return "";
  }
  
  public final void a()
  {
    this.c = new x4();
    this.d = new r4();
  }
  
  public void a(String paramString)
  {
    APLog.i("OrderId", paramString);
    this.a = paramString;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public final boolean b(APBaseRequest paramAPBaseRequest)
  {
    if (!TextUtils.isEmpty(paramAPBaseRequest.reserv))
    {
      paramAPBaseRequest = APTools.n(paramAPBaseRequest.reserv);
      if ((paramAPBaseRequest != null) && (!TextUtils.isEmpty((CharSequence)paramAPBaseRequest.get("orderid")))) {
        return true;
      }
    }
    return false;
  }
  
  public final void c()
  {
    this.c = new y4();
    this.d = new s4();
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    Object localObject;
    try
    {
      o4 localo4 = (o4)super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      System.out.println(localCloneNotSupportedException.toString());
      localObject = null;
    }
    localObject.b = ((APBaseRequest)this.b.clone());
    localObject.c = ((w4)this.c.clone());
    localObject.d = ((q4)this.d.clone());
    localObject.e = ((c5)this.e.clone());
    localObject.f = ((d5)this.f.clone());
    return localObject;
  }
  
  public final void d()
  {
    this.c = new z4();
    this.d = new t4();
    Object localObject = this.c;
    APBaseRequest localAPBaseRequest = this.b;
    ((w4)localObject).b = ((APMonthRequest)localAPBaseRequest).serviceName;
    ((z4)localObject).l = ((APMonthRequest)localAPBaseRequest).serviceType;
    if (((APMonthRequest)localAPBaseRequest).serviceType == 4)
    {
      localObject = APTools.i(localAPBaseRequest.reserv);
      g6.k().d((String)((HashMap)localObject).get("provide_uin"));
    }
    if (((APMonthRequest)this.b).autoPay)
    {
      ((z4)this.c).n = "1";
      return;
    }
    ((z4)this.c).n = "0";
  }
  
  public final void e()
  {
    this.c = new a5();
    this.d = new u4();
  }
  
  public final void f()
  {
    this.c = new b5();
    this.d = new u4();
  }
  
  public void g()
  {
    this.d = null;
  }
  
  public final void h()
  {
    this.c = new z4();
    this.d = new v4();
    this.c.b = ((APSubscribeRequest)this.b).serviceName;
    g6.k().c(((APSubscribeRequest)this.b).productId);
    Object localObject = this.c;
    z4 localz4 = (z4)localObject;
    APBaseRequest localAPBaseRequest = this.b;
    localz4.l = ((APSubscribeRequest)localAPBaseRequest).serviceType;
    ((z4)localObject).k = ((APSubscribeRequest)localAPBaseRequest).productId;
    if (((APSubscribeRequest)localAPBaseRequest).serviceType == 4)
    {
      localObject = APTools.i(localAPBaseRequest.reserv);
      g6.k().d((String)((HashMap)localObject).get("provide_uin"));
    }
    if (((APMonthRequest)this.b).autoPay)
    {
      ((z4)this.c).n = "1";
      return;
    }
    ((z4)this.c).n = "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.o4
 * JD-Core Version:    0.7.0.1
 */