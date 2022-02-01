package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
      if ((localh.uLz != null) && (localh.uLz.intValue() < 0)) {
        localh.uLz = Integer.valueOf(0);
      }
      if ((localh.uLA != null) && (localh.uLA.intValue() < 0)) {
        localh.uLA = Integer.valueOf(0);
      }
      String str = paramJSONObject.optString("data", null);
      if (str != null) {
        ax(i, str);
      }
      au.a(paramJSONObject, localh);
      com.tencent.mm.plugin.appbrand.af.o.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136291);
          Object localObject1 = j.a.cRb();
          ad localad = paramad;
          int i = i;
          Object localObject2 = localh;
          localObject1 = com.tencent.mm.plugin.appbrand.widget.input.e.a(localad, new j.1((j)localObject1, i));
          if ((localObject1 instanceof c))
          {
            localObject1 = (c)localObject1;
            if (localObject1 == null) {
              break label204;
            }
            if (((h)localObject2).defaultValue != null) {
              ((c)localObject1).agZ(((h)localObject2).defaultValue);
            }
            ((c)localObject1).a((h)localObject2);
            localObject2 = ((c)localObject1).cQB();
            if (localObject2 != null)
            {
              localad = (ad)((c)localObject1).uEU.get();
              if ((localad != null) && (localad.tti != null)) {
                break label149;
              }
            }
          }
          label112:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label209;
            }
            paramad.callback(paramInt, i.this.ZP("ok"));
            AppMethodBeat.o(136291);
            return;
            localObject1 = null;
            break;
            g localg = (g)localad.cEy();
            if (localg == null) {
              break label112;
            }
            localObject1 = ((c)localObject1).cQC();
            if (localObject1 == null) {
              break label112;
            }
            localg.c(localad.tti, (View)localObject2, ((Rect)localObject1).width(), ((Rect)localObject1).height(), ((Rect)localObject1).left, ((Rect)localObject1).top);
            break label112;
          }
          label149:
          label204:
          label209:
          localObject1 = com.tencent.mm.plugin.appbrand.widget.input.o.a(paramad, i);
          if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.widget.input.i))
          {
            localObject1 = (com.tencent.mm.plugin.appbrand.widget.input.i)localObject1;
            localObject2 = localh;
            if ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFL == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFN == null)) {}
            do
            {
              paramad.callback(paramInt, i.this.ZP("ok"));
              AppMethodBeat.o(136291);
              return;
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFL.a((f)localObject2);
            } while ((!((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFL.uLw) && ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFL.uLA == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFL.uLA.intValue() <= 0)));
            ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFN.setWillNotDraw(true);
            ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).cQW();
            if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFL.defaultValue != null) {
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFN.T(Util.nullAsNil(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFL.defaultValue));
            }
            if (!an.o(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFL.uLR)) {
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).b(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFN, ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFL);
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFN.setWillNotDraw(false);
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFN.invalidate();
              break;
              localObject2 = new com.tencent.mm.plugin.appbrand.widget.input.i.1((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1);
              if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFN.getLayout() == null) {
                ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).uFN.post((Runnable)localObject2);
              } else {
                ((Runnable)localObject2).run();
              }
            }
          }
          Log.e("MicroMsg.AppBrand.JsApiUpdateInput", String.format(Locale.US, "AppBrandInputInvokeHandler with inputID(%d) 404", new Object[] { Integer.valueOf(i) }));
          paramad.callback(paramInt, i.this.ZP(String.format(Locale.US, "fail found no input with %d", new Object[] { Integer.valueOf(i) })));
          AppMethodBeat.o(136291);
        }
      });
      AppMethodBeat.o(136292);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramad.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(136292);
    }
  }
  
  protected final boolean csl()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.i
 * JD-Core Version:    0.7.0.1
 */