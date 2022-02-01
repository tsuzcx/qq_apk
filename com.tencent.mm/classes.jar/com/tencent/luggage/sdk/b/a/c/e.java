package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.b.a.a.a;
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
  
  public abstract boolean CK();
  
  protected i CL()
  {
    return null;
  }
  
  protected void CM() {}
  
  protected void CN() {}
  
  protected void CO() {}
  
  public void CX() {}
  
  public void CY() {}
  
  protected Map<String, m> DG()
  {
    return null;
  }
  
  protected void Dc() {}
  
  protected abstract void Dd();
  
  protected abstract void De();
  
  public final void EI()
  {
    ((c)El()).EI();
  }
  
  public final com.tencent.luggage.sdk.d.c En()
  {
    if (El() == null) {
      return null;
    }
    return ((c)El()).En();
  }
  
  public final <T> T Q(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((c)El()).aVF());
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
  
  public String dn(String paramString)
  {
    return null;
  }
  
  public final String getAppId()
  {
    return ((c)El()).getAppId();
  }
  
  public boolean i(int paramInt, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.e
 * JD-Core Version:    0.7.0.1
 */