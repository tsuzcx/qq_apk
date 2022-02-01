package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b<CONTEXT extends com.tencent.mm.plugin.appbrand.jsapi.e>
  extends e<c>
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
    final com.tencent.mm.plugin.appbrand.jsapi.e locale = ((g)paramc.K(g.class)).c(paramc, paramJSONObject);
    if (locale == null)
    {
      ae.w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      paramc.h(paramInt, e("fail:ComponentView is null.", null));
      return;
    }
    locale.K(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140651);
        if ((!locale.aXO()) && (!locale.isRunning()))
        {
          ae.w("MicroMsg.BaseInsertViewJsApi", "fail, component is not running");
          AppMethodBeat.o(140651);
          return;
        }
        if (locale.aYC() == null)
        {
          ae.w("MicroMsg.BaseInsertViewJsApi", "fail, component custom view container is null");
          this.kFt.PZ(b.this.e("fail:insert view failed", null));
          AppMethodBeat.o(140651);
          return;
        }
        try
        {
          i = b.this.A(paramJSONObject);
          View localView = b.this.a(locale, paramJSONObject, i);
          if (localView == null)
          {
            ae.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
            this.kFt.PZ(b.this.e("fail:inflate view failed", null));
            AppMethodBeat.o(140651);
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          this.kFt.PZ(b.this.e("fail:invalid view id", null));
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
        if (locale.fF(bool4).sH(i))
        {
          ae.w("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", new Object[] { Integer.valueOf(i) });
          this.kFt.PZ(b.this.e("fail:the view has already exist", null));
          AppMethodBeat.o(140651);
          return;
        }
        int j = paramJSONObject.optInt("parentId", 0);
        for (;;)
        {
          try
          {
            localObject1 = b.E(paramJSONObject);
            int k = b.F(paramJSONObject);
            localObject2 = b.G(paramJSONObject);
            localObject3 = b.H(paramJSONObject);
            Boolean localBoolean = b.this.B(paramJSONObject);
            e.a locala = locale.fF(bool4);
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
            ae.e("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", new Object[] { localJSONException2 });
            bool1 = false;
            continue;
            b.this.a(locale, i, str, paramJSONObject);
            continue;
            String str = "fail:insert view fail";
            continue;
          }
          bool2 = b.this.bjF();
          if (bool1)
          {
            b.a(b.this, locale, i, localJSONException1, paramJSONObject, bool4);
            if (!bool2) {
              continue;
            }
            b.this.a(locale, i, localJSONException1, paramJSONObject, this.kFt);
          }
          localObject3 = b.this;
          localObject1 = locale;
          localObject2 = ((com.tencent.mm.plugin.appbrand.jsapi.e)localObject1).fF(bool4).H(i, true);
          if ((f.c)((z.b)localObject2).get("baseViewDestroyListener", null) == null)
          {
            localObject3 = new b.2((b)localObject3, (com.tencent.mm.plugin.appbrand.jsapi.e)localObject1, bool4, i, (z.b)localObject2);
            ((z.b)localObject2).k("baseViewDestroyListener", localObject3);
            ((com.tencent.mm.plugin.appbrand.jsapi.e)localObject1).a((f.c)localObject3);
          }
          ae.i("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localJSONException1.hashCode()), Boolean.valueOf(bool1) });
          if (!bool2)
          {
            localObject1 = this.kFt;
            localObject2 = b.this;
            if (!bool1) {
              continue;
            }
            str = "ok";
            ((i)localObject1).PZ(((m)localObject2).e(str, null));
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
  
  protected void a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject, i parami) {}
  
  protected boolean bjF()
  {
    return false;
  }
  
  protected boolean bjG()
  {
    return false;
  }
  
  protected boolean bjH()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.b
 * JD-Core Version:    0.7.0.1
 */