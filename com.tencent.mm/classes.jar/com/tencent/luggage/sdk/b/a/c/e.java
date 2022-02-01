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
  
  public abstract boolean BH();
  
  protected i BI()
  {
    return null;
  }
  
  protected void BJ() {}
  
  protected void BK() {}
  
  protected void BL() {}
  
  public void BU() {}
  
  public void BV() {}
  
  protected void BZ() {}
  
  protected Map<String, m> CD()
  {
    return null;
  }
  
  protected abstract void Ca();
  
  protected abstract void Cb();
  
  public final void DG()
  {
    ((c)Dj()).DG();
  }
  
  public final com.tencent.luggage.sdk.d.c Dl()
  {
    if (Dj() == null) {
      return null;
    }
    return ((c)Dj()).Dl();
  }
  
  public final <T> T Q(Class<T> paramClass)
  {
    if (ICommLibReader.class.equals(paramClass)) {
      return paramClass.cast(((c)Dj()).aLC());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.Q(paramClass);
  }
  
  protected abstract void c(AppBrandRuntime paramAppBrandRuntime);
  
  public void c(JSONObject paramJSONObject) {}
  
  protected abstract void ci(String paramString);
  
  public String cw(String paramString)
  {
    return null;
  }
  
  public boolean d(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public final String getAppId()
  {
    return ((c)Dj()).getAppId();
  }
  
  public boolean i(int paramInt, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.e
 * JD-Core Version:    0.7.0.1
 */