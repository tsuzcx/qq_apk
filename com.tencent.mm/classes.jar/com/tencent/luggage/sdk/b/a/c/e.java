package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.luggage.sdk.d.d;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.m.f;
import java.util.Map;
import org.json.JSONObject;

public abstract class e<Service extends c>
  extends a.a<Service>
  implements f
{
  public e(Service paramService)
  {
    super(paramService);
  }
  
  public abstract boolean CN();
  
  protected i CO()
  {
    return null;
  }
  
  protected void CP() {}
  
  protected void CQ() {}
  
  protected void CR() {}
  
  protected Map<String, m> DJ()
  {
    return null;
  }
  
  public void Da() {}
  
  public void Db() {}
  
  protected void Df() {}
  
  protected abstract void Dg();
  
  protected abstract void Dh();
  
  public final void EK()
  {
    ((c)Eo()).EK();
  }
  
  public final d Eq()
  {
    if (Eo() == null) {
      return null;
    }
    return ((c)Eo()).Eq();
  }
  
  public final <T> T Q(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((c)Eo()).aWe());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.Q(paramClass);
  }
  
  protected abstract void c(AppBrandRuntime paramAppBrandRuntime);
  
  public void c(JSONObject paramJSONObject) {}
  
  public boolean d(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public String dp(String paramString)
  {
    return null;
  }
  
  public final String getAppId()
  {
    return ((c)Eo()).getAppId();
  }
  
  public boolean i(int paramInt, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.e
 * JD-Core Version:    0.7.0.1
 */