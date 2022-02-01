package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a<CONTEXT extends e>
  extends d<c>
{
  protected View a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    throw new IllegalStateException("inflateView must be inflated.".concat(String.valueOf(this)));
  }
  
  protected View a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    return a(paramCONTEXT, paramJSONObject);
  }
  
  public void a(c paramc, final JSONObject paramJSONObject, int paramInt)
  {
    final e locale = ((f)paramc.K(f.class)).c(paramc, paramJSONObject);
    if (locale == null)
    {
      ac.w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      paramc.h(paramInt, e("fail:ComponentView is null.", null));
      return;
    }
    locale.N(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140651);
        if ((!locale.aUk()) && (!locale.isRunning()))
        {
          ac.w("MicroMsg.BaseInsertViewJsApi", "fail, component is not running");
          AppMethodBeat.o(140651);
          return;
        }
        try
        {
          i = a.this.A(paramJSONObject);
          View localView = a.this.a(locale, paramJSONObject, i);
          if (localView == null)
          {
            ac.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
            this.khn.LV(a.this.e("fail:inflate view failed", null));
            AppMethodBeat.o(140651);
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          this.khn.LV(a.this.e("fail:invalid view id", null));
          AppMethodBeat.o(140651);
          return;
        }
        boolean bool4 = paramJSONObject.optBoolean("independent", false);
        if (((localJSONException1 instanceof CoverViewContainer)) && (paramJSONObject.has("draggable")))
        {
          bool1 = paramJSONObject.optBoolean("draggable", false);
          ((CoverViewContainer)localJSONException1).a(bool1, i, paramJSONObject.optString("data"));
          ((CoverViewContainer)localJSONException1).setDragConfig(paramJSONObject.optString("dragConfig"));
        }
        if (locale.fC(bool4).sc(i))
        {
          ac.w("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", new Object[] { Integer.valueOf(i) });
          this.khn.LV(a.this.e("fail:the view has already exist", null));
          AppMethodBeat.o(140651);
          return;
        }
        int j = paramJSONObject.optInt("parentId", 0);
        for (;;)
        {
          try
          {
            localObject1 = a.E(paramJSONObject);
            int k = a.F(paramJSONObject);
            localObject2 = a.G(paramJSONObject);
            localObject3 = a.H(paramJSONObject);
            Boolean localBoolean = a.this.B(paramJSONObject);
            e.a locala = locale.fC(bool4);
            if ((localObject2 == null) || (!((Boolean)localObject2).booleanValue())) {
              continue;
            }
            bool1 = true;
            if ((localObject3 == null) || (!((Boolean)localObject3).booleanValue())) {
              continue;
            }
            bool2 = true;
            if ((localBoolean == null) || (!localBoolean.booleanValue())) {
              continue;
            }
            bool3 = true;
            bool1 = locala.a(localJSONException1, i, j, (float[])localObject1, k, bool1, bool2, bool3);
          }
          catch (JSONException localJSONException2)
          {
            Object localObject1;
            Object localObject2;
            Object localObject3;
            boolean bool2;
            boolean bool3;
            ac.e("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", new Object[] { localJSONException2 });
            bool1 = false;
            continue;
            a.this.a(locale, i, str, paramJSONObject);
            continue;
            String str = "fail:insert view fail";
            continue;
          }
          bool2 = a.this.bft();
          if (bool1)
          {
            a.a(a.this, locale, i, localJSONException1, paramJSONObject, bool4);
            if (!bool2) {
              continue;
            }
            a.this.a(locale, i, localJSONException1, paramJSONObject, this.khn);
          }
          localObject3 = a.this;
          localObject1 = locale;
          localObject2 = ((e)localObject1).fC(bool4).H(i, true);
          if ((f.c)((y.b)localObject2).get("baseViewDestroyListener", null) == null)
          {
            localObject3 = new a.2((a)localObject3, (e)localObject1, bool4, i, (y.b)localObject2);
            ((y.b)localObject2).l("baseViewDestroyListener", localObject3);
            ((e)localObject1).a((f.c)localObject3);
          }
          ac.i("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localJSONException1.hashCode()), Boolean.valueOf(bool1) });
          if (!bool2)
          {
            localObject1 = this.khn;
            localObject2 = a.this;
            if (!bool1) {
              continue;
            }
            str = "ok";
            ((g)localObject1).LV(((m)localObject2).e(str, null));
          }
          AppMethodBeat.o(140651);
          return;
          bool1 = false;
          continue;
          bool2 = false;
          continue;
          bool3 = false;
        }
      }
    });
  }
  
  protected void a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject) {}
  
  protected void a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject, g paramg) {}
  
  protected boolean bft()
  {
    return false;
  }
  
  protected boolean bfu()
  {
    return false;
  }
  
  protected boolean bfv()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.a
 * JD-Core Version:    0.7.0.1
 */