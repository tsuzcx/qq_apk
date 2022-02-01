package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.input.aj;
import com.tencent.mm.plugin.appbrand.widget.input.c;
import com.tencent.mm.plugin.appbrand.widget.input.d.f;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.plugin.appbrand.widget.input.g;
import com.tencent.mm.plugin.appbrand.widget.input.j;
import com.tencent.mm.plugin.appbrand.widget.input.j.1;
import com.tencent.mm.plugin.appbrand.widget.input.j.a;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.plugin.appbrand.widget.input.y;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends a<h>
{
  private static final int CTRL_INDEX = 112;
  private static final String NAME = "updateInput";
  
  public void a(final z paramz, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(136292);
    final h localh = new h();
    if (!a(localh, paramJSONObject, paramz, paramInt))
    {
      AppMethodBeat.o(136292);
      return;
    }
    try
    {
      final int i = paramJSONObject.getInt("inputId");
      if ((localh.noe != null) && (localh.noe.intValue() < 0)) {
        localh.noe = Integer.valueOf(0);
      }
      if ((localh.nof != null) && (localh.nof.intValue() < 0)) {
        localh.nof = Integer.valueOf(0);
      }
      paramJSONObject = paramJSONObject.optString("data", null);
      if (paramJSONObject != null) {
        ai(i, paramJSONObject);
      }
      com.tencent.mm.plugin.appbrand.y.m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136291);
          Object localObject1 = j.a.bFb();
          z localz = paramz;
          int i = i;
          Object localObject2 = localh;
          localObject1 = com.tencent.mm.plugin.appbrand.widget.input.e.a(localz, new j.1((j)localObject1, i));
          if ((localObject1 instanceof c))
          {
            localObject1 = (c)localObject1;
            if (localObject1 == null) {
              break label201;
            }
            if (((h)localObject2).nod != null) {
              ((c)localObject1).Wc(((h)localObject2).nod);
            }
            ((c)localObject1).a((h)localObject2);
            localObject2 = ((c)localObject1).bEE();
            if (localObject2 != null)
            {
              localz = (z)((c)localObject1).nhZ.get();
              if ((localz != null) && (localz.mcJ != null)) {
                break label150;
              }
            }
          }
          label112:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label206;
            }
            paramz.h(paramInt, i.this.e("ok", null));
            AppMethodBeat.o(136291);
            return;
            localObject1 = null;
            break;
            g localg = (g)localz.bve();
            if (localg == null) {
              break label112;
            }
            localObject1 = ((c)localObject1).bEF();
            localg.c(localz.mcJ, (View)localObject2, ((Rect)localObject1).width(), ((Rect)localObject1).height(), ((Rect)localObject1).left, ((Rect)localObject1).top);
            break label112;
          }
          label150:
          label201:
          label206:
          localObject1 = o.a(paramz, i);
          if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.widget.input.i))
          {
            localObject1 = (com.tencent.mm.plugin.appbrand.widget.input.i)localObject1;
            localObject2 = localh;
            if ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niK == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niM == null)) {}
            do
            {
              paramz.h(paramInt, i.this.e("ok", null));
              AppMethodBeat.o(136291);
              return;
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niK.a((f)localObject2);
            } while ((!((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niK.nob) && ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niK.nof == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niK.nof.intValue() <= 0)));
            ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niM.setWillNotDraw(true);
            ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).bET();
            if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niK.nod != null) {
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niM.C(bu.nullAsNil(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niK.nod));
            }
            if (!aj.i(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niK.now)) {
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).b(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niM, ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niK);
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niM.setWillNotDraw(false);
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niM.invalidate();
              break;
              localObject2 = new com.tencent.mm.plugin.appbrand.widget.input.i.1((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1);
              if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niM.getLayout() == null) {
                ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).niM.post((Runnable)localObject2);
              } else {
                ((Runnable)localObject2).run();
              }
            }
          }
          ae.e("MicroMsg.AppBrand.JsApiUpdateInput", String.format(Locale.US, "AppBrandInputInvokeHandler with inputID(%d) 404", new Object[] { Integer.valueOf(i) }));
          paramz.h(paramInt, i.this.e(String.format(Locale.US, "fail found no input with %d", new Object[] { Integer.valueOf(i) }), null));
          AppMethodBeat.o(136291);
        }
      });
      AppMethodBeat.o(136292);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramz.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(136292);
    }
  }
  
  protected final boolean bld()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.i
 * JD-Core Version:    0.7.0.1
 */