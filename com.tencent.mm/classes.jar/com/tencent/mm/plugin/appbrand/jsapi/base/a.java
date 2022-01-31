package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a<CONTEXT extends e>
  extends d<c>
{
  protected View a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    throw new IllegalStateException("inflateView must be inflated");
  }
  
  protected View a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    return a(paramCONTEXT, paramJSONObject);
  }
  
  public void a(c paramc, final JSONObject paramJSONObject, int paramInt)
  {
    final e locale = ((f)paramc.q(f.class)).d(paramc);
    if (locale == null)
    {
      ab.w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      paramc.h(paramInt, j("fail:ComponentView is null.", null));
      return;
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(91043);
        if (!locale.isRunning())
        {
          AppMethodBeat.o(91043);
          return;
        }
        try
        {
          i = a.this.w(paramJSONObject);
          View localView = a.this.a(locale, paramJSONObject, i);
          if (localView == null)
          {
            ab.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
            this.hEM.BS(a.this.j("inflate view failed", null));
            AppMethodBeat.o(91043);
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          this.hEM.BS(a.this.j("fail:invalid view id", null));
          AppMethodBeat.o(91043);
          return;
        }
        if (locale.vC().pi(i))
        {
          ab.w("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", new Object[] { Integer.valueOf(i) });
          this.hEM.BS(a.this.j("fail:the view has already exist", null));
          AppMethodBeat.o(91043);
          return;
        }
        int j = paramJSONObject.optInt("parentId", 0);
        for (;;)
        {
          try
          {
            localObject1 = a.x(paramJSONObject);
            int k = a.y(paramJSONObject);
            localObject2 = a.z(paramJSONObject);
            localObject3 = a.A(paramJSONObject);
            af localaf = locale.vC();
            if ((localObject2 == null) || (!((Boolean)localObject2).booleanValue())) {
              continue;
            }
            bool1 = true;
            if ((localObject3 == null) || (!((Boolean)localObject3).booleanValue())) {
              continue;
            }
            bool2 = true;
            bool1 = localaf.a(localJSONException1, i, j, (float[])localObject1, k, bool1, bool2);
          }
          catch (JSONException localJSONException2)
          {
            Object localObject1;
            Object localObject2;
            Object localObject3;
            boolean bool2;
            ab.e("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", new Object[] { localJSONException2 });
            boolean bool1 = false;
            continue;
            a.this.a(locale, i, str, paramJSONObject);
            continue;
            String str = "fail:insert view fail";
            continue;
          }
          bool2 = a.this.aCb();
          if (bool1)
          {
            a.a(a.this, locale, i, localJSONException1, paramJSONObject);
            if (!bool2) {
              continue;
            }
            a.this.a(locale, i, localJSONException1, paramJSONObject, this.hEM);
          }
          localObject3 = a.this;
          localObject1 = locale;
          localObject2 = ((e)localObject1).vC().J(i, true);
          if ((f.c)((v.b)localObject2).get("baseViewDestroyListener", null) == null)
          {
            localObject3 = new a.2((a)localObject3, (e)localObject1, i, (v.b)localObject2);
            ((v.b)localObject2).i("baseViewDestroyListener", localObject3);
            ((e)localObject1).a((f.c)localObject3);
          }
          ab.i("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localJSONException1.hashCode()), Boolean.valueOf(bool1) });
          if (!bool2)
          {
            localObject1 = this.hEM;
            localObject2 = a.this;
            if (!bool1) {
              continue;
            }
            str = "ok";
            ((g)localObject1).BS(((m)localObject2).j(str, null));
          }
          AppMethodBeat.o(91043);
          return;
          bool1 = false;
          continue;
          bool2 = false;
        }
      }
    });
  }
  
  protected void a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject) {}
  
  protected void a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject, g paramg) {}
  
  protected boolean aCb()
  {
    return false;
  }
  
  protected boolean aCc()
  {
    return false;
  }
  
  protected boolean aCd()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.a
 * JD-Core Version:    0.7.0.1
 */