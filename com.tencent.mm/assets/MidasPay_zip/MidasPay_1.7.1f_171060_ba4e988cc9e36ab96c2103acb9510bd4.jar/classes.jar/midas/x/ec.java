package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.io.PrintStream;
import java.util.HashMap;

public class ec
  implements Cloneable
{
  public APBaseRequest a = null;
  public ek b = null;
  public ee c = null;
  public eq d = null;
  public er e = null;
  private String f = "";
  
  public ec(APBaseRequest paramAPBaseRequest)
  {
    this.a = paramAPBaseRequest;
    if ((paramAPBaseRequest.saveType == 0) && (paramAPBaseRequest.acctType.equals("qb")))
    {
      paramAPBaseRequest.saveType = 3;
      if (TextUtils.isEmpty(paramAPBaseRequest.saveValue)) {
        paramAPBaseRequest.saveValue = "10";
      }
    }
    if (a(paramAPBaseRequest)) {
      a(b(paramAPBaseRequest));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveType:");
    localStringBuilder.append(paramAPBaseRequest.saveType);
    APLog.i("APOrderInfo", localStringBuilder.toString());
    switch (paramAPBaseRequest.saveType)
    {
    default: 
      break;
    case 5: 
      e();
      break;
    case 4: 
      f();
      break;
    case 3: 
      g();
      break;
    case 2: 
      h();
      break;
    case 1: 
      d();
      break;
    case 0: 
      c();
    }
    this.d = new eq();
    this.e = new er();
    this.e.g = paramAPBaseRequest.saveValue;
  }
  
  private boolean a(APBaseRequest paramAPBaseRequest)
  {
    if (!TextUtils.isEmpty(paramAPBaseRequest.reserv))
    {
      paramAPBaseRequest = APTools.b(paramAPBaseRequest.reserv);
      if ((paramAPBaseRequest != null) && (!TextUtils.isEmpty((CharSequence)paramAPBaseRequest.get("orderid")))) {
        return true;
      }
    }
    return false;
  }
  
  private String b(APBaseRequest paramAPBaseRequest)
  {
    if (a(paramAPBaseRequest)) {
      return (String)APTools.b(paramAPBaseRequest.reserv).get("orderid");
    }
    return "";
  }
  
  private void c()
  {
    this.b = new el();
    this.c = new ef();
  }
  
  private void d()
  {
    this.b = new em();
    this.c = new eg();
  }
  
  private void e()
  {
    this.b = new en();
    this.c = new ej();
    this.b.b = ((APSubscribeRequest)this.a).serviceName;
    fs.a().c(((APSubscribeRequest)this.a).productId);
    ((en)this.b).l = ((APSubscribeRequest)this.a).serviceType;
    ((en)this.b).k = ((APSubscribeRequest)this.a).productId;
    if (((APSubscribeRequest)this.a).serviceType == 4)
    {
      HashMap localHashMap = APTools.c(this.a.reserv);
      fs.a().d((String)localHashMap.get("provide_uin"));
    }
    if (((APMonthRequest)this.a).autoPay)
    {
      ((en)this.b).n = "1";
      return;
    }
    ((en)this.b).n = "0";
  }
  
  private void f()
  {
    this.b = new en();
    this.c = new eh();
    this.b.b = ((APMonthRequest)this.a).serviceName;
    ((en)this.b).l = ((APMonthRequest)this.a).serviceType;
    if (((APMonthRequest)this.a).serviceType == 4)
    {
      HashMap localHashMap = APTools.c(this.a.reserv);
      fs.a().d((String)localHashMap.get("provide_uin"));
    }
    if (((APMonthRequest)this.a).autoPay)
    {
      ((en)this.b).n = "1";
      return;
    }
    ((en)this.b).n = "0";
  }
  
  private void g()
  {
    this.b = new eo();
    this.c = new ei();
  }
  
  private void h()
  {
    this.b = new ep();
    this.c = new ei();
  }
  
  public void a()
  {
    this.c = null;
  }
  
  public void a(String paramString)
  {
    APLog.i("OrderId", paramString);
    this.f = paramString;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    Object localObject;
    try
    {
      ec localec = (ec)super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      System.out.println(localCloneNotSupportedException.toString());
      localObject = null;
    }
    localObject.a = ((APBaseRequest)this.a.clone());
    localObject.b = ((ek)this.b.clone());
    localObject.c = ((ee)this.c.clone());
    localObject.d = ((eq)this.d.clone());
    localObject.e = ((er)this.e.clone());
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ec
 * JD-Core Version:    0.7.0.1
 */