package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.ui.MMActivity;
import java.util.Queue;
import org.json.JSONObject;

abstract class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  protected static MMActivity a(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    if ((paramf instanceof o)) {}
    for (paramf = ((o)paramf).F(Activity.class); (paramf == null) || (!(paramf instanceof MMActivity)); paramf = paramf.getContext()) {
      return null;
    }
    return (MMActivity)paramf;
  }
  
  public void a(com.tencent.mm.plugin.appbrand.jsapi.f arg1, JSONObject paramJSONObject, int paramInt)
  {
    a locala = a.p(???.getRuntime());
    paramJSONObject = new c.1(this, ???, locala, paramJSONObject, paramInt);
    if (!locala.aid()) {}
    synchronized (locala.hln)
    {
      locala.hln.offer(paramJSONObject);
      locala.Ff(1);
      return;
    }
  }
  
  protected abstract void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt, b paramb);
  
  final void b(com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt, String paramString)
  {
    paramf.C(paramInt, h(paramString, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.c
 * JD-Core Version:    0.7.0.1
 */