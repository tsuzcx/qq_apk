package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mm.model.u.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class b$a$1
  implements Runnable
{
  b$a$1(b.a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc) {}
  
  public final void run()
  {
    if (!b.a.a(this.gFZ))
    {
      y.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
      return;
    }
    Object localObject = c.bU(b.a.b(this.gFZ));
    if ((Math.abs(b.a.c(this.gFZ).x - ((c.f)localObject).x) > 1.0F) || (Math.abs(b.a.c(this.gFZ).y - ((c.f)localObject).y) > 1.0F))
    {
      y.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
      return;
    }
    if (b.a.d(this.gFZ).size() != 1)
    {
      y.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
      return;
    }
    if ((Math.abs(b.a.e(this.gFZ).x - b.a.f(this.gFZ).x) > b.a.g(this.gFZ)) || (Math.abs(b.a.e(this.gFZ).y - b.a.f(this.gFZ).y) > b.a.g(this.gFZ)))
    {
      y.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", new Object[] { Float.valueOf(b.a.e(this.gFZ).x), Float.valueOf(b.a.f(this.gFZ).x), Float.valueOf(b.a.e(this.gFZ).y), Float.valueOf(b.a.f(this.gFZ).y) });
      return;
    }
    y.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", new Object[] { Float.valueOf(b.a.e(this.gFZ).x), Float.valueOf(b.a.f(this.gFZ).x), Float.valueOf(b.a.e(this.gFZ).y), Float.valueOf(b.a.f(this.gFZ).y) });
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("data", b.a.h(this.gFZ).getString("data", ""));
      ((JSONObject)localObject).put("touch", b.a.e(this.gFZ).rB());
      label374:
      if (!b.a.h(this.gFZ).getBoolean("disableScroll", false))
      {
        b.a.a(this.gFZ, MotionEvent.obtain(b.a.i(this.gFZ)));
        b.a.j(this.gFZ).setAction(0);
        b.a.h(this.gFZ).w("fakeDownEvent", true);
        b.a.b(this.gFZ).getParent().requestDisallowInterceptTouchEvent(true);
        b.a.b(this.gFZ).setDuplicateParentStateEnabled(false);
        b.a.a(b.a.b(this.gFZ), MotionEvent.obtain(b.a.j(this.gFZ)));
      }
      b.a.b(this.ggE, new c.a(), ((JSONObject)localObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      break label374;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b.a.1
 * JD-Core Version:    0.7.0.1
 */