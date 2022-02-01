package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends a<h>
{
  private static final int CTRL_INDEX = 112;
  private static final String NAME = "updateInput";
  
  public void a(final aa paramaa, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(136292);
    final h localh = new h();
    if (!a(localh, paramJSONObject, paramaa, paramInt))
    {
      AppMethodBeat.o(136292);
      return;
    }
    try
    {
      final int i = paramJSONObject.getInt("inputId");
      if ((localh.mgz != null) && (localh.mgz.intValue() < 0)) {
        localh.mgz = Integer.valueOf(0);
      }
      if ((localh.mgA != null) && (localh.mgA.intValue() < 0)) {
        localh.mgA = Integer.valueOf(0);
      }
      paramJSONObject = paramJSONObject.optString("data", null);
      if (paramJSONObject != null) {
        af(i, paramJSONObject);
      }
      l.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(136291);
          Object localObject1 = j.a.bth();
          aa localaa = paramaa;
          int i = i;
          Object localObject2 = localh;
          localObject1 = com.tencent.mm.plugin.appbrand.widget.input.e.a(localaa, new j.1((j)localObject1, i));
          if ((localObject1 instanceof c))
          {
            localObject1 = (c)localObject1;
            if (localObject1 == null) {
              break label201;
            }
            if (((h)localObject2).mgy != null) {
              ((c)localObject1).NK(((h)localObject2).mgy);
            }
            ((c)localObject1).a((h)localObject2);
            localObject2 = ((c)localObject1).bsJ();
            if (localObject2 != null)
            {
              localaa = (aa)((c)localObject1).mar.get();
              if ((localaa != null) && (localaa.kWU != null)) {
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
            paramaa.h(paramInt, i.this.e("ok", null));
            AppMethodBeat.o(136291);
            return;
            localObject1 = null;
            break;
            g localg = (g)localaa.bjD();
            if (localg == null) {
              break label112;
            }
            localObject1 = ((c)localObject1).bsK();
            localg.c(localaa.kWU, (View)localObject2, ((Rect)localObject1).width(), ((Rect)localObject1).height(), ((Rect)localObject1).left, ((Rect)localObject1).top);
            break label112;
          }
          label150:
          label201:
          label206:
          localObject1 = o.a(paramaa, i);
          if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.widget.input.i))
          {
            localObject1 = (com.tencent.mm.plugin.appbrand.widget.input.i)localObject1;
            localObject2 = localh;
            if ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDN == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDP == null)) {}
            do
            {
              paramaa.h(paramInt, i.this.e("ok", null));
              AppMethodBeat.o(136291);
              return;
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDN.a((f)localObject2);
            } while ((!((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDN.mgw) && ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDN.mgA == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDN.mgA.intValue() <= 0)));
            ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDP.setWillNotDraw(true);
            ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).fRb();
            if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDN.mgy != null) {
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDP.D(bt.nullAsNil(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDN.mgy));
            }
            if (!aj.g(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDN.mgR)) {
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).b(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDP, ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDN);
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDP.setWillNotDraw(false);
              ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDP.invalidate();
              break;
              localObject2 = new com.tencent.mm.plugin.appbrand.widget.input.i.1((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1);
              if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDP.getLayout() == null) {
                ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).KDP.post((Runnable)localObject2);
              } else {
                ((Runnable)localObject2).run();
              }
            }
          }
          ad.e("MicroMsg.AppBrand.JsApiUpdateInput", String.format(Locale.US, "AppBrandInputInvokeHandler with inputID(%d) 404", new Object[] { Integer.valueOf(i) }));
          paramaa.h(paramInt, i.this.e(String.format(Locale.US, "fail found no input with %d", new Object[] { Integer.valueOf(i) }), null));
          AppMethodBeat.o(136291);
        }
      });
      AppMethodBeat.o(136292);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramaa.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(136292);
    }
  }
  
  protected final boolean aZV()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.i
 * JD-Core Version:    0.7.0.1
 */