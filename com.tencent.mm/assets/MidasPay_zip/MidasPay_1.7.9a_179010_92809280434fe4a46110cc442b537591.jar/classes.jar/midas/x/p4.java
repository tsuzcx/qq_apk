package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.tencent.midas.comm.APLog;
import java.util.Stack;

public class p4
{
  public static volatile p4 b;
  public Stack<o4> a = new Stack();
  
  public static int o()
  {
    Object localObject = p();
    if (localObject == null) {
      return -1;
    }
    localObject = ((p4)localObject).e();
    if (localObject == null) {
      return -1;
    }
    localObject = ((o4)localObject).b;
    if (localObject == null) {
      return -1;
    }
    return ((APBaseRequest)localObject).saveType;
  }
  
  public static p4 p()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new p4();
        }
      }
      finally {}
    }
    return b;
  }
  
  public String a()
  {
    Object localObject = e();
    if (localObject == null) {
      return "";
    }
    localObject = ((o4)localObject).b;
    if (localObject == null) {
      return "";
    }
    localObject = ((APBaseRequest)localObject).mpInfo;
    if (localObject == null) {
      return "";
    }
    return ((APBaseRequest.APMPInfo)localObject).discoutId;
  }
  
  public void a(int paramInt)
  {
    Object localObject = e();
    if (localObject == null) {
      return;
    }
    localObject = ((o4)localObject).b;
    if (localObject == null) {
      return;
    }
    ((APBaseRequest)localObject).saveType = paramInt;
  }
  
  public void a(o4 paramo4)
  {
    try
    {
      APLog.i("APOrderManager", "putOrder enter");
      if (b.a.size() >= 5) {
        b.a.remove(0);
      }
      b.a.add(paramo4);
      paramo4 = new StringBuilder();
      paramo4.append("putOrder size:");
      paramo4.append(b.a.size());
      APLog.i("APOrderManager", paramo4.toString());
      return;
    }
    finally {}
  }
  
  public String b()
  {
    Object localObject = e();
    if (localObject == null) {
      return "";
    }
    localObject = ((o4)localObject).b;
    if (localObject == null) {
      return "";
    }
    if (!(localObject instanceof APGoodsRequest)) {
      return "";
    }
    return ((APGoodsRequest)localObject).goodsTokenUrl;
  }
  
  public String c()
  {
    try
    {
      Object localObject1 = e();
      if (localObject1 == null) {
        return "";
      }
      localObject1 = ((o4)localObject1).b;
      if (localObject1 == null) {
        return "";
      }
      localObject1 = ((APBaseRequest)localObject1).offerId;
      return localObject1;
    }
    finally {}
  }
  
  public String d()
  {
    try
    {
      Object localObject1 = e();
      if (localObject1 == null) {
        return "";
      }
      localObject1 = ((o4)localObject1).b;
      if (localObject1 == null) {
        return "";
      }
      localObject1 = ((APBaseRequest)localObject1).openId;
      return localObject1;
    }
    finally {}
  }
  
  public o4 e()
  {
    try
    {
      if (b.a.size() > 0)
      {
        o4 localo4 = (o4)b.a.peek();
        return localo4;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String f()
  {
    Object localObject = e();
    if (localObject == null)
    {
      APLog.e("OrderManager", "Cannot get reserve, null order info!");
      return "";
    }
    localObject = ((o4)localObject).b;
    if (localObject == null)
    {
      APLog.e("OrderManager", "Cannot get reserve, null request!");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Get reserve = ");
    localStringBuilder.append(((APBaseRequest)localObject).reserv);
    APLog.d("OrderManager", localStringBuilder.toString());
    return ((APBaseRequest)localObject).reserv;
  }
  
  public int g()
  {
    try
    {
      Object localObject1 = e();
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((o4)localObject1).b;
      if (localObject1 == null) {
        return -1;
      }
      int i = ((APBaseRequest)localObject1).saveType;
      return i;
    }
    finally {}
  }
  
  public String h()
  {
    Object localObject = e();
    if (localObject == null) {
      return "";
    }
    localObject = ((o4)localObject).b;
    if (localObject == null) {
      return "";
    }
    return ((APBaseRequest)localObject).saveValue;
  }
  
  public boolean i()
  {
    Object localObject = e();
    if (localObject == null)
    {
      APLog.e("OrderManager", "Is goods req fail, null order info!");
      return false;
    }
    localObject = ((o4)localObject).b;
    if (localObject == null)
    {
      APLog.e("OrderManager", "Is goods req fail, null request");
      return false;
    }
    if (!(localObject instanceof APGoodsRequest))
    {
      APLog.d("OrderManager", "Is goods req false, not goods req");
      return false;
    }
    APLog.d("OrderManager", "Is goods req true!");
    return true;
  }
  
  public boolean j()
  {
    Object localObject = e();
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((o4)localObject).b;
    if (localObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((localObject instanceof APGoodsRequest))
    {
      bool1 = bool2;
      if (((APGoodsRequest)localObject).tokenType == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean k()
  {
    Object localObject = e();
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((o4)localObject).b;
    if (localObject == null) {
      return false;
    }
    if (((APBaseRequest)localObject).saveType == 4) {
      bool = true;
    }
    return bool;
  }
  
  public boolean l()
  {
    Object localObject = e();
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((o4)localObject).b;
    if (localObject == null) {
      return false;
    }
    localObject = ((APBaseRequest)localObject).saveValue;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Current save value = ");
    localStringBuilder1.append((String)localObject);
    APLog.d("QRCodePay", localStringBuilder1.toString());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    int i;
    try
    {
      i = Integer.parseInt((String)localObject);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      i = 0;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("String save value = ");
    localStringBuilder2.append((String)localObject);
    localStringBuilder2.append(" int save value = ");
    localStringBuilder2.append(i);
    APLog.d("QRCodePay", localStringBuilder2.toString());
    if (i > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean m()
  {
    Object localObject = e();
    if (localObject == null)
    {
      APLog.e("OrderManager", "Is subscribe and empty service name fail, null order info");
      return false;
    }
    localObject = ((o4)localObject).b;
    if (localObject == null)
    {
      APLog.e("OrderManager", "Is subscribe and empty service name fail, null request");
      return false;
    }
    if (!(localObject instanceof APSubscribeRequest))
    {
      APLog.e("OrderManager", "Is subscribe and empty service name false, not subs request");
      return false;
    }
    if (TextUtils.isEmpty(((APSubscribeRequest)localObject).serviceName))
    {
      APLog.e("OrderManager", "Is subscribe and empty service name true");
      return true;
    }
    APLog.d("OrderManager", "Is subscribe and empty service name false, subs request with not empty service name");
    return false;
  }
  
  public void n()
  {
    try
    {
      if (b.a.size() > 0) {
        b.a.pop();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.p4
 * JD-Core Version:    0.7.0.1
 */