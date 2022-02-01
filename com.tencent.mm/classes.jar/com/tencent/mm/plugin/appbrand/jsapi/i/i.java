package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.ac;
import com.tencent.mm.plugin.appbrand.widget.input.an;
import com.tencent.mm.plugin.appbrand.widget.input.au;
import com.tencent.mm.plugin.appbrand.widget.input.c;
import com.tencent.mm.plugin.appbrand.widget.input.e.f;
import com.tencent.mm.plugin.appbrand.widget.input.e.h;
import com.tencent.mm.plugin.appbrand.widget.input.g;
import com.tencent.mm.plugin.appbrand.widget.input.j;
import com.tencent.mm.plugin.appbrand.widget.input.j.1;
import com.tencent.mm.plugin.appbrand.widget.input.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends a<h>
{
  private static final int CTRL_INDEX = 112;
  private static final String NAME = "updateInput";
  
  public void a(final ad paramad, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(136292);
    final h localh = new h();
    if (!a(localh, paramJSONObject, paramad, paramInt))
    {
      AppMethodBeat.o(136292);
      return;
    }
    try
    {
      final int i = paramJSONObject.getInt("inputId");
      if ((localh.rAj != null) && (localh.rAj.intValue() < 0)) {
        localh.rAj = Integer.valueOf(0);
      }
      if ((localh.rAk != null) && (localh.rAk.intValue() < 0)) {
        localh.rAk = Integer.valueOf(0);
      }
      String str = paramJSONObject.optString("data", null);
      if (str != null) {
        an(i, str);
      }
      au.a(paramJSONObject, localh);
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136291);
          Object localObject1 = j.a.coz();
          ad localad = paramad;
          int i = i;
          Object localObject2 = localh;
          localObject1 = com.tencent.mm.plugin.appbrand.widget.input.e.a(localad, new j.1((j)localObject1, i));
          if ((localObject1 instanceof c))
          {
            localObject1 = (c)localObject1;
            if (localObject1 == null) {
              break label205;
            }
            if (((h)localObject2).rAi != null) {
              ((c)localObject1).anC(((h)localObject2).rAi);
            }
            ((c)localObject1).a((h)localObject2);
            localObject2 = ((c)localObject1).cnZ();
            if (localObject2 != null)
            {
              localad = (ad)((c)localObject1).rtP.get();
              if ((localad != null) && (localad.qoF != null)) {
                break label150;
              }
            }
          }
          label112:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label210;
            }
            paramad.j(paramInt, i.this.h("ok", null));
            AppMethodBeat.o(136291);
            return;
            localObject1 = null;
            break;
            g localg = (g)localad.cdU();
            if (localg == null) {
              break label112;
            }
            localObject1 = ((c)localObject1).coa();
            if (localObject1 == null) {
              break label112;
            }
            localg.c(localad.qoF, (View)localObject2, ((Rect)localObject1).width(), ((Rect)localObject1).height(), ((Rect)localObject1).left, ((Rect)localObject1).top);
            break label112;
          }
          label150:
          label205:
          label210:
          localObject1 = com.tencent.mm.plugin.appbrand.widget.input.o.a(paramad, i);
          if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.widget.input.i))
          {
            localObject1 = (com.tencent.mm.plugin.appbrand.widget.input.i)localObject1;
            localObject2 = localh;
            if ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tTZ == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).xvc == null)) {}
            do
            {
              paramad.j(paramInt, i.this.h("ok", null));
              AppMethodBeat.o(136291);
              return;
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tTZ.a((f)localObject2);
            } while ((!((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tTZ.rAf) && ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tTZ.rAk == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tTZ.rAk.intValue() <= 0)));
            ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).xvc.setWillNotDraw(true);
            ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).cor();
            if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tTZ.rAi != null) {
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).xvc.P(Util.nullAsNil(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tTZ.rAi));
            }
            if (!an.m(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tTZ.rAB)) {
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).b(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).xvc, ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tTZ);
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).xvc.setWillNotDraw(false);
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).xvc.invalidate();
              break;
              localObject2 = new com.tencent.mm.plugin.appbrand.widget.input.i.1((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1);
              if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).xvc.getLayout() == null) {
                ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).xvc.post((Runnable)localObject2);
              } else {
                ((Runnable)localObject2).run();
              }
            }
          }
          Log.e("MicroMsg.AppBrand.JsApiUpdateInput", String.format(Locale.US, "AppBrandInputInvokeHandler with inputID(%d) 404", new Object[] { Integer.valueOf(i) }));
          paramad.j(paramInt, i.this.h(String.format(Locale.US, "fail found no input with %d", new Object[] { Integer.valueOf(i) }), null));
          AppMethodBeat.o(136291);
        }
      });
      AppMethodBeat.o(136292);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramad.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(136292);
    }
  }
  
  protected final boolean bSg()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.i
 * JD-Core Version:    0.7.0.1
 */