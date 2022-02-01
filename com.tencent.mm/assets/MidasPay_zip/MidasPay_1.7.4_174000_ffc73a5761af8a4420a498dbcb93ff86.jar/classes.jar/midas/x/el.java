package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.io.PrintStream;
import java.util.HashMap;

public class el
  implements Cloneable
{
  public APBaseRequest a = null;
  public et b = null;
  public en c = null;
  public ez d = null;
  public fa e = null;
  private String f = "";
  
  public el(APBaseRequest paramAPBaseRequest)
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
    this.d = new ez();
    this.e = new fa();
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
    this.b = new eu();
    this.c = new eo();
  }
  
  private void d()
  {
    this.b = new ev();
    this.c = new ep();
  }
  
  private void e()
  {
    this.b = new ew();
    this.c = new es();
    this.b.b = ((APSubscribeRequest)this.a).serviceName;
    gc.a().c(((APSubscribeRequest)this.a).productId);
    ((ew)this.b).l = ((APSubscribeRequest)this.a).serviceType;
    ((ew)this.b).k = ((APSubscribeRequest)this.a).productId;
    if (((APSubscribeRequest)this.a).serviceType == 4)
    {
      HashMap localHashMap = APTools.c(this.a.reserv);
      gc.a().d((String)localHashMap.get("provide_uin"));
    }
    if (((APMonthRequest)this.a).autoPay)
    {
      ((ew)this.b).n = "1";
      return;
    }
    ((ew)this.b).n = "0";
  }
  
  private void f()
  {
    this.b = new ew();
    this.c = new eq();
    this.b.b = ((APMonthRequest)this.a).serviceName;
    ((ew)this.b).l = ((APMonthRequest)this.a).serviceType;
    if (((APMonthRequest)this.a).serviceType == 4)
    {
      HashMap localHashMap = APTools.c(this.a.reserv);
      gc.a().d((String)localHashMap.get("provide_uin"));
    }
    if (((APMonthRequest)this.a).autoPay)
    {
      ((ew)this.b).n = "1";
      return;
    }
    ((ew)this.b).n = "0";
  }
  
  private void g()
  {
    this.b = new ex();
    this.c = new er();
  }
  
  private void h()
  {
    this.b = new ey();
    this.c = new er();
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
      el localel = (el)super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      System.out.println(localCloneNotSupportedException.toString());
      localObject = null;
    }
    localObject.a = ((APBaseRequest)this.a.clone());
    localObject.b = ((et)this.b.clone());
    localObject.c = ((en)this.c.clone());
    localObject.d = ((ez)this.d.clone());
    localObject.e = ((fa)this.e.clone());
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.el
 * JD-Core Version:    0.7.0.1
 */