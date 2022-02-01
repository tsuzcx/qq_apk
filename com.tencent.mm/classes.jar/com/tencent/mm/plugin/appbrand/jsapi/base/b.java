package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b<CONTEXT extends h>
  extends e<f>
{
  protected View a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    throw new IllegalStateException("inflateView must be inflated.".concat(String.valueOf(this)));
  }
  
  protected View a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    return a(paramCONTEXT, paramJSONObject);
  }
  
  public void a(f paramf, final JSONObject paramJSONObject, int paramInt)
  {
    Object localObject = (g)paramf.M(g.class);
    if (localObject == null) {
      Log.e("MicroMsg.BaseInsertViewJsApi", "getComponentView NULL IComponentConverter");
    }
    for (localObject = null; localObject == null; localObject = ((g)localObject).c(paramf, paramJSONObject))
    {
      Log.w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      paramf.i(paramInt, h("fail:ComponentView is null.", null));
      return;
    }
    ((h)localObject).P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140651);
        if ((!this.lJT.bsV()) && (!this.lJT.isRunning()))
        {
          Log.w("MicroMsg.BaseInsertViewJsApi", "fail, component is not running");
          AppMethodBeat.o(140651);
          return;
        }
        if (this.lJT.getCustomViewContainer() == null)
        {
          Log.w("MicroMsg.BaseInsertViewJsApi", "fail, component custom view container is null");
          this.lJU.ZA(b.this.h("fail:insert view failed", null));
          AppMethodBeat.o(140651);
          return;
        }
        try
        {
          i = b.this.H(paramJSONObject);
          View localView = b.this.a(this.lJT, paramJSONObject, i);
          if (localView == null)
          {
            Log.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
            this.lJU.ZA(b.this.h("fail:inflate view failed", null));
            AppMethodBeat.o(140651);
            return;
          }
        }
        catch (JSONException localJSONException1)
        {
          this.lJU.ZA(b.this.h("fail:invalid view id", null));
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
        if (this.lJT.gA(bool4).wD(i))
        {
          Log.w("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", new Object[] { Integer.valueOf(i) });
          this.lJU.ZA(b.this.h("fail:the view has already exist", null));
          AppMethodBeat.o(140651);
          return;
        }
        int j = paramJSONObject.optInt("parentId", 0);
        for (;;)
        {
          try
          {
            localObject1 = b.L(paramJSONObject);
            int k = b.M(paramJSONObject);
            localObject2 = b.N(paramJSONObject);
            localObject3 = b.O(paramJSONObject);
            Boolean localBoolean = b.this.I(paramJSONObject);
            h.a locala = this.lJT.gA(bool4);
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
            b.this.a(this.lJT, i, str, paramJSONObject);
            continue;
            String str = "fail:insert view fail";
            continue;
          }
          bool2 = b.this.bEV();
          if (bool1)
          {
            b.a(b.this, this.lJT, i, localJSONException1, paramJSONObject, bool4);
            if (!bool2) {
              continue;
            }
            b.this.a(this.lJT, i, localJSONException1, paramJSONObject, this.lJU);
          }
          localObject3 = b.this;
          localObject1 = this.lJT;
          localObject2 = ((h)localObject1).gA(bool4).L(i, true);
          if ((i.c)((ad.b)localObject2).get("baseViewDestroyListener", null) == null)
          {
            localObject3 = new b.2((b)localObject3, (h)localObject1, bool4, i, (ad.b)localObject2);
            ((ad.b)localObject2).l("baseViewDestroyListener", localObject3);
            ((h)localObject1).a((i.c)localObject3);
          }
          Log.i("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localJSONException1.hashCode()), Boolean.valueOf(bool1) });
          if (!bool2)
          {
            localObject1 = this.lJU;
            localObject2 = b.this;
            if (!bool1) {
              continue;
            }
            str = "ok";
            ((i)localObject1).ZA(((p)localObject2).h(str, null));
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
  
  protected boolean bEV()
  {
    return false;
  }
  
  protected boolean bEW()
  {
    return false;
  }
  
  protected boolean bEX()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.b
 * JD-Core Version:    0.7.0.1
 */