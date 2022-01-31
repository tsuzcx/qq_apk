package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.s.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a<CONTEXT extends e>
  extends d<c>
{
  public abstract View a(CONTEXT paramCONTEXT, JSONObject paramJSONObject);
  
  public void a(c paramc, final JSONObject paramJSONObject, int paramInt)
  {
    final e locale = ((f)paramc.i(f.class)).a(paramc);
    if (locale == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      paramc.C(paramInt, h("fail:ComponentView is null.", null));
      return;
    }
    ai.d(new Runnable()
    {
      public final void run()
      {
        if (!locale.isRunning()) {
          return;
        }
        View localView = a.this.a(locale, paramJSONObject);
        if (localView == null)
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
          this.gkW.tT(a.this.h("inflate view failed", null));
          return;
        }
        int i;
        try
        {
          i = a.this.p(paramJSONObject);
          if (locale.agW().mf(i))
          {
            com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", new Object[] { Integer.valueOf(i) });
            this.gkW.tT(a.this.h("fail:the view has already exist", null));
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          this.gkW.tT(a.this.h("fail:invalid view id", null));
          return;
        }
        int j = paramJSONObject.optInt("parentId", 0);
        for (;;)
        {
          try
          {
            localObject1 = a.q(paramJSONObject);
            int k = a.r(paramJSONObject);
            localObject2 = a.s(paramJSONObject);
            localObject3 = locale.agW();
            if ((localObject2 == null) || (!((Boolean)localObject2).booleanValue())) {
              continue;
            }
            bool = true;
            bool = ((com.tencent.mm.plugin.appbrand.page.y)localObject3).a(localJSONException1, i, j, (float[])localObject1, k, bool);
          }
          catch (JSONException localJSONException2)
          {
            Object localObject1;
            Object localObject2;
            Object localObject3;
            u.b localb;
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", new Object[] { localJSONException2 });
            boolean bool = false;
            continue;
            str.setOnTouchListener(new b.a((c)localObject2, localb));
            continue;
            String str = "fail:insert view fail";
            continue;
          }
          if (bool)
          {
            localObject1 = a.this;
            localObject2 = locale;
            localObject3 = paramJSONObject;
            if (((a)localObject1).aii())
            {
              localb = ((e)localObject2).agW().F(i, true);
              localb.w("disableScroll", ((JSONObject)localObject3).optBoolean("disableScroll", false));
              localb.w("enableLongClick", ((a)localObject1).aij());
              localb.S("data", ((JSONObject)localObject3).optString("data"));
              if (((JSONObject)localObject3).optBoolean("gesture", false))
              {
                if ((localObject2 != null) && (localJSONException1 != null) && (localb != null)) {
                  continue;
                }
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ViewMotionHelper", "setOnTouchListener failed, page or view or keyValueSet is null.");
              }
            }
            a.this.a(locale, i, localJSONException1, paramJSONObject);
          }
          localObject3 = a.this;
          localObject1 = locale;
          localObject2 = ((e)localObject1).agW().F(i, true);
          if ((e.c)((u.b)localObject2).get("baseViewDestroyListener", null) == null)
          {
            localObject3 = new a.2((a)localObject3, (e)localObject1, i, (u.b)localObject2);
            ((u.b)localObject2).h("baseViewDestroyListener", localObject3);
            ((e)localObject1).a((e.c)localObject3);
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localJSONException1.hashCode()), Boolean.valueOf(bool) });
          localObject1 = this.gkW;
          localObject2 = a.this;
          if (!bool) {
            continue;
          }
          str = "ok";
          ((g)localObject1).tT(((i)localObject2).h(str, null));
          return;
          bool = false;
        }
      }
    });
  }
  
  public void a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject) {}
  
  public boolean aii()
  {
    return false;
  }
  
  public boolean aij()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.a
 * JD-Core Version:    0.7.0.1
 */