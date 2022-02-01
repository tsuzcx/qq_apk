package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import java.util.Map;
import org.json.JSONObject;

public abstract class e<Service extends c>
  extends a.a<Service>
{
  public e(Service paramService)
  {
    super(paramService);
  }
  
  protected void BD() {}
  
  protected abstract void BE();
  
  protected abstract void BF();
  
  public abstract boolean Bl();
  
  protected i Bm()
  {
    return null;
  }
  
  protected void Bn() {}
  
  protected void Bo() {}
  
  protected void Bp() {}
  
  public void By() {}
  
  public void Bz() {}
  
  public final com.tencent.luggage.sdk.d.c CO()
  {
    if (CM() == null) {
      return null;
    }
    return ((c)CM()).CO();
  }
  
  protected Map<String, m> Ch()
  {
    return null;
  }
  
  public final void Dj()
  {
    ((c)CM()).Dj();
  }
  
  public final <T> T Q(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((c)CM()).aSt());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.Q(paramClass);
  }
  
  protected abstract void bY(String paramString);
  
  protected abstract void c(AppBrandRuntime paramAppBrandRuntime);
  
  public void c(JSONObject paramJSONObject) {}
  
  public String cl(String paramString)
  {
    return null;
  }
  
  public boolean d(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public final String getAppId()
  {
    return ((c)CM()).getAppId();
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