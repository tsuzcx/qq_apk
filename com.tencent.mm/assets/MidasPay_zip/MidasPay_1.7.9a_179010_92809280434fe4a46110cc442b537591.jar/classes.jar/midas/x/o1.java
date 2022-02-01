package midas.x;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

public class o1
  implements IUiListener
{
  public l1 a;
  public boolean b = false;
  
  public o1(l1 paraml1)
  {
    this.a = paraml1;
  }
  
  public final void onCancel()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.a.b();
  }
  
  public final void onComplete(Object paramObject)
  {
    if (this.b) {
      return;
    }
    this.b = true;
    if (paramObject == null)
    {
      this.a.a(-1, "opensdk response is null");
      return;
    }
    Object localObject = (JSONObject)paramObject;
    if (((JSONObject)localObject).length() == 0)
    {
      this.a.a(-1, "length of opensdk response is 0");
      return;
    }
    try
    {
      paramObject = ((JSONObject)localObject).getString("openid");
      localObject = ((JSONObject)localObject).getString("pay_token");
      this.a.b(paramObject, (String)localObject, "1");
      return;
    }
    catch (JSONException paramObject)
    {
      paramObject.printStackTrace();
      this.a.a(-2, " bad response");
    }
  }
  
  public final void onError(UiError paramUiError)
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.a.a(paramUiError.errorCode, paramUiError.errorDetail);
  }
  
  public void onWarning(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.o1
 * JD-Core Version:    0.7.0.1
 */