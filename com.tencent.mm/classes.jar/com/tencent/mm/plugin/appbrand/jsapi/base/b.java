package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b<CONTEXT extends h>
  extends e<f>
{
  private void a(final CONTEXT paramCONTEXT, final o paramo, final JSONObject paramJSONObject, final i parami)
  {
    paramCONTEXT.V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140651);
        if (!paramCONTEXT.a(b.this.getName(), paramo))
        {
          Log.w("MicroMsg.BaseInsertViewJsApi", "fail, component is not running");
          AppMethodBeat.o(140651);
          return;
        }
        if (paramCONTEXT.getCustomViewContainer() == null)
        {
          Log.w("MicroMsg.BaseInsertViewJsApi", "fail, component custom view container is null");
          parami.aal(b.this.ZP("fail:insert view failed"));
          AppMethodBeat.o(140651);
          return;
        }
        try
        {
          i = b.this.V(paramJSONObject);
          View localView = b.this.a(paramCONTEXT, paramJSONObject, i);
          if (localView == null)
          {
            Log.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
            parami.aal(b.this.ZP("fail:inflate view failed"));
            AppMethodBeat.o(140651);
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          parami.aal(b.this.ZP("fail:invalid view id"));
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
        if (paramCONTEXT.ic(bool4).Ak(i))
        {
          Log.w("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", new Object[] { Integer.valueOf(i) });
          parami.aal(b.this.ZP("fail:the view has already exist"));
          AppMethodBeat.o(140651);
          return;
        }
        int j = paramJSONObject.optInt("parentId", 0);
        for (;;)
        {
          try
          {
            localObject1 = b.aa(paramJSONObject);
            int k = b.ab(paramJSONObject);
            localObject2 = b.ac(paramJSONObject);
            localObject3 = b.ad(paramJSONObject);
            Boolean localBoolean = b.this.W(paramJSONObject);
            h.a locala = paramCONTEXT.ic(bool4);
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
            Log.e("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", new Object[] { localJSONException2 });
            bool1 = false;
            continue;
            b.this.a(paramCONTEXT, i, str, paramJSONObject);
            continue;
            String str = "fail:insert view fail";
            continue;
          }
          bool2 = b.this.cqw();
          if (bool1)
          {
            b.a(b.this, paramCONTEXT, i, localJSONException1, paramJSONObject, bool4);
            if (!bool2) {
              continue;
            }
            b.this.a(paramCONTEXT, i, localJSONException1, paramJSONObject, parami);
          }
          localObject3 = b.this;
          localObject1 = paramCONTEXT;
          localObject2 = ((h)localObject1).ic(bool4).ac(i, true);
          if ((i.c)((ad.b)localObject2).get("baseViewDestroyListener", null) == null)
          {
            localObject3 = new b.2((b)localObject3, (h)localObject1, bool4, i, (ad.b)localObject2);
            ((ad.b)localObject2).q("baseViewDestroyListener", localObject3);
            ((h)localObject1).a((i.c)localObject3);
          }
          Log.i("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localJSONException1.hashCode()), Boolean.valueOf(bool1) });
          if (!bool2)
          {
            localObject1 = parami;
            localObject2 = b.this;
            if (!bool1) {
              continue;
            }
            str = "ok";
            ((i)localObject1).aal(((b)localObject2).ZP(str));
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
  
  private static h d(f paramf, JSONObject paramJSONObject)
  {
    g localg = (g)paramf.T(g.class);
    if (localg == null)
    {
      Log.e("MicroMsg.BaseInsertViewJsApi", "getComponentView NULL IComponentConverter");
      return null;
    }
    return localg.c(paramf, paramJSONObject);
  }
  
  protected View a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    throw new IllegalStateException("inflateView must be inflated.".concat(String.valueOf(this)));
  }
  
  protected View a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    return a(paramCONTEXT, paramJSONObject);
  }
  
  public void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    a(paramf, paramJSONObject, paramInt, paramf.getJsRuntime());
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    h localh = d(paramf, paramJSONObject);
    if (localh == null)
    {
      Log.w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      paramf.callback(paramInt, ZP("fail:ComponentView is null."));
      return;
    }
    a(localh, paramo, paramJSONObject, new i(paramf, paramInt));
  }
  
  protected void a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject) {}
  
  protected void a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject, i parami) {}
  
  protected boolean cqw()
  {
    return false;
  }
  
  protected boolean cqx()
  {
    return false;
  }
  
  protected boolean cqy()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.b
 * JD-Core Version:    0.7.0.1
 */