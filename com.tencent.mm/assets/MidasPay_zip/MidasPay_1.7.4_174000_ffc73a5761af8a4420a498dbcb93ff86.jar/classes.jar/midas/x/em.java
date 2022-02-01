package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APSubscribeRequest;
import com.tencent.midas.comm.APLog;
import java.util.Stack;

public class em
{
  private static volatile em a;
  private final int b = 5;
  private Stack<el> c = new Stack();
  
  public static int a()
  {
    Object localObject = b();
    if (localObject == null) {
      return -1;
    }
    localObject = ((em)localObject).n();
    if (localObject == null) {
      return -1;
    }
    localObject = ((el)localObject).a;
    if (localObject == null) {
      return -1;
    }
    return ((APBaseRequest)localObject).saveType;
  }
  
  public static em b()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new em();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(int paramInt)
  {
    Object localObject = n();
    if (localObject == null) {
      return;
    }
    localObject = ((el)localObject).a;
    if (localObject == null) {
      return;
    }
    ((APBaseRequest)localObject).saveType = paramInt;
  }
  
  public void a(el paramel)
  {
    try
    {
      APLog.i("APOrderManager", "putOrder enter");
      if (a.c.size() >= 5) {
        a.c.remove(0);
      }
      a.c.add(paramel);
      paramel = new StringBuilder();
      paramel.append("putOrder size:");
      paramel.append(a.c.size());
      APLog.i("APOrderManager", paramel.toString());
      return;
    }
    finally {}
  }
  
  public boolean c()
  {
    Object localObject = n();
    if (localObject == null)
    {
      APLog.e("OrderManager", "Is subscribe and empty service name fail, null order info");
      return false;
    }
    localObject = ((el)localObject).a;
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
  
  public String d()
  {
    Object localObject = n();
    if (localObject == null) {
      return "";
    }
    localObject = ((el)localObject).a;
    if (localObject == null) {
      return "";
    }
    return ((APBaseRequest)localObject).saveValue;
  }
  
  public String e()
  {
    try
    {
      Object localObject1 = n();
      if (localObject1 == null) {
        return "";
      }
      localObject1 = ((el)localObject1).a;
      if (localObject1 == null) {
        return "";
      }
      localObject1 = ((APBaseRequest)localObject1).openId;
      return localObject1;
    }
    finally {}
  }
  
  public String f()
  {
    try
    {
      Object localObject1 = n();
      if (localObject1 == null) {
        return "";
      }
      localObject1 = ((el)localObject1).a;
      if (localObject1 == null) {
        return "";
      }
      localObject1 = ((APBaseRequest)localObject1).offerId;
      return localObject1;
    }
    finally {}
  }
  
  public int g()
  {
    try
    {
      Object localObject1 = n();
      if (localObject1 == null) {
        return -1;
      }
      localObject1 = ((el)localObject1).a;
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
    Object localObject = n();
    if (localObject == null)
    {
      APLog.e("OrderManager", "Cannot get reserve, null order info!");
      return "";
    }
    localObject = ((el)localObject).a;
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
  
  public boolean i()
  {
    Object localObject = n();
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((el)localObject).a;
    if (localObject == null) {
      return false;
    }
    if (((APBaseRequest)localObject).saveType == 4) {
      bool = true;
    }
    return bool;
  }
  
  public boolean j()
  {
    Object localObject = n();
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((el)localObject).a;
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
  
  public boolean k()
  {
    Object localObject = n();
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((el)localObject).a;
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
  
  public boolean l()
  {
    Object localObject = n();
    if (localObject == null)
    {
      APLog.e("OrderManager", "Is goods req fail, null order info!");
      return false;
    }
    localObject = ((el)localObject).a;
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
  
  public String m()
  {
    Object localObject = n();
    if (localObject == null) {
      return "";
    }
    localObject = ((el)localObject).a;
    if (localObject == null) {
      return "";
    }
    if (!(localObject instanceof APGoodsRequest)) {
      return "";
    }
    return ((APGoodsRequest)localObject).goodsTokenUrl;
  }
  
  public el n()
  {
    try
    {
      if (a.c.size() > 0)
      {
        el localel = (el)a.c.peek();
        return localel;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String o()
  {
    Object localObject = n();
    if (localObject == null) {
      return "";
    }
    localObject = ((el)localObject).a;
    if (localObject == null) {
      return "";
    }
    localObject = ((APBaseRequest)localObject).mpInfo;
    if (localObject == null) {
      return "";
    }
    return ((APBaseRequest.APMPInfo)localObject).discoutId;
  }
  
  public void p()
  {
    try
    {
      if (a.c.size() > 0) {
        a.c.pop();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.em
 * JD-Core Version:    0.7.0.1
 */