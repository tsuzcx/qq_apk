package midas.x;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

public class bn
  implements IUiListener
{
  private final int a = -1;
  private final int b = -2;
  private bk c;
  private boolean d = false;
  
  public bn(bk parambk)
  {
    this.c = parambk;
  }
  
  public final void onCancel()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.c.b();
  }
  
  public final void onComplete(Object paramObject)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    if (paramObject == null)
    {
      this.c.a(-1, "opensdk response is null");
      return;
    }
    Object localObject = (JSONObject)paramObject;
    if (((JSONObject)localObject).length() == 0)
    {
      this.c.a(-1, "length of opensdk response is 0");
      return;
    }
    try
    {
      paramObject = ((JSONObject)localObject).getString("openid");
      localObject = ((JSONObject)localObject).getString("pay_token");
      this.c.a(paramObject, (String)localObject, "1");
      return;
    }
    catch (JSONException paramObject)
    {
      paramObject.printStackTrace();
      this.c.a(-2, " bad response");
    }
  }
  
  public final void onError(UiError paramUiError)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.c.a(paramUiError.errorCode, paramUiError.errorDetail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.bn
 * JD-Core Version:    0.7.0.1
 */