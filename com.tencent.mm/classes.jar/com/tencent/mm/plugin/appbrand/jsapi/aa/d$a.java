package com.tencent.mm.plugin.appbrand.jsapi.aa;

import android.support.v4.view.t;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d$a
  implements View.OnTouchListener
{
  private static volatile View lyk;
  private c cnn;
  private z.b gCz;
  private Map<Integer, e.f> lyl;
  private boolean lym;
  private boolean lyn;
  private e.f lyo;
  private Runnable lyp;
  private int lyq;
  private float lyr;
  private MotionEvent lys;
  private MotionEvent lyt;
  private e.f lyu;
  private e.f lyv;
  private View mView;
  
  public d$a(final c paramc, z.b paramb)
  {
    AppMethodBeat.i(140679);
    this.lyl = new HashMap();
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramb);
    this.gCz = paramb;
    this.lyq = paramc.aXX();
    this.cnn = paramc;
    this.lyr = ViewConfiguration.get(paramc.getContext()).getScaledTouchSlop();
    this.lyu = new e.f();
    this.lyv = new e.f();
    this.lyp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140678);
        if (!d.a.a(d.a.this))
        {
          ae.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
          AppMethodBeat.o(140678);
          return;
        }
        if (!t.aC(d.a.b(d.a.this)))
        {
          ae.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, view removed");
          if ((d.a.bpE() != null) && (d.a.bpE().equals(d.a.b(d.a.this)))) {
            d.a.bpF();
          }
          AppMethodBeat.o(140678);
          return;
        }
        Object localObject = e.cF(d.a.b(d.a.this));
        if ((Math.abs(d.a.c(d.a.this).x - ((e.f)localObject).x) > 1.0F) || (Math.abs(d.a.c(d.a.this).y - ((e.f)localObject).y) > 1.0F))
        {
          ae.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
          AppMethodBeat.o(140678);
          return;
        }
        if (d.a.d(d.a.this).size() != 1)
        {
          ae.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
          AppMethodBeat.o(140678);
          return;
        }
        if ((Math.abs(d.a.e(d.a.this).x - d.a.f(d.a.this).x) > d.a.g(d.a.this)) || (Math.abs(d.a.e(d.a.this).y - d.a.f(d.a.this).y) > d.a.g(d.a.this)))
        {
          ae.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", new Object[] { Float.valueOf(d.a.e(d.a.this).x), Float.valueOf(d.a.f(d.a.this).x), Float.valueOf(d.a.e(d.a.this).y), Float.valueOf(d.a.f(d.a.this).y) });
          AppMethodBeat.o(140678);
          return;
        }
        ae.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", new Object[] { Float.valueOf(d.a.e(d.a.this).x), Float.valueOf(d.a.f(d.a.this).x), Float.valueOf(d.a.e(d.a.this).y), Float.valueOf(d.a.f(d.a.this).y) });
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("data", d.a.h(d.a.this).getString("data", ""));
          ((JSONObject)localObject).put("touch", d.a.e(d.a.this).toJSONObject());
          label451:
          if (!d.a.h(d.a.this).getBoolean("disableScroll", false))
          {
            d.a.a(d.a.this, MotionEvent.obtain(d.a.i(d.a.this)));
            d.a.j(d.a.this).setAction(0);
            d.a.h(d.a.this).G("fakeDownEvent", true);
            d.a.b(d.a.this).getParent().requestDisallowInterceptTouchEvent(true);
            d.a.b(d.a.this).setDuplicateParentStateEnabled(false);
            d.a.a(d.a.b(d.a.this), MotionEvent.obtain(d.a.j(d.a.this)));
          }
          d.a.b(paramc, new e.a(), ((JSONObject)localObject).toString());
          AppMethodBeat.o(140678);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label451;
        }
      }
    };
    AppMethodBeat.o(140679);
  }
  
  private static void a(c paramc, e.f paramf, at paramat, String paramString)
  {
    AppMethodBeat.i(140682);
    if (paramf == null)
    {
      AppMethodBeat.o(140682);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", paramString);
      localJSONObject.put("touch", paramf.toJSONObject());
      label45:
      a(paramc, paramat, localJSONObject.toString());
      AppMethodBeat.o(140682);
      return;
    }
    catch (JSONException paramf)
    {
      break label45;
    }
  }
  
  private static void a(c paramc, at paramat, String paramString)
  {
    AppMethodBeat.i(140683);
    paramc.b(paramat.getName(), paramString, null);
    AppMethodBeat.o(140683);
  }
  
  private void l(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(140681);
    this.mView = paramView;
    this.lym = paramBoolean;
    if (!paramBoolean)
    {
      this.gCz.G("fakeDownEvent", false);
      this.gCz.G("onLongClick", false);
      this.mView.removeCallbacks(this.lyp);
      this.lyu.b(-1, 0.0F, 0.0F);
      this.lys = null;
    }
    AppMethodBeat.o(140681);
  }
  
  private e.f[] v(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(140684);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      int k = paramMotionEvent.getPointerId(i);
      e.f localf = (e.f)this.lyl.get(Integer.valueOf(k));
      if (localf != null)
      {
        localf.x = paramMotionEvent.getX(i);
        localf.y = paramMotionEvent.getY(i);
        localArrayList.add(localf);
      }
      i += 1;
    }
    paramMotionEvent = new e.f[localArrayList.size()];
    i = j;
    while (i < localArrayList.size())
    {
      paramMotionEvent[i] = ((e.f)localArrayList.get(i));
      i += 1;
    }
    AppMethodBeat.o(140684);
    return paramMotionEvent;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140680);
    Object localObject1 = new b();
    ((b)localObject1).bd(paramView);
    ((b)localObject1).bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/appbrand/jsapi/view/ViewMotionFactory$CanvasOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject1).ahF());
    if ((lyk != null) && (!lyk.equals(paramView)))
    {
      ae.v("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
      a.a(false, this, "com/tencent/mm/plugin/appbrand/jsapi/view/ViewMotionFactory$CanvasOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(140680);
      return false;
    }
    this.lyt = paramMotionEvent;
    int k = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    if ((k != 0) && (!this.gCz.Bs("isTouching")) && (!t.aC(paramView)) && (k != 3))
    {
      a.a(false, this, "com/tencent/mm/plugin/appbrand/jsapi/view/ViewMotionFactory$CanvasOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(140680);
      return false;
    }
    localObject1 = this.gCz.getString("data", "");
    boolean bool5 = this.gCz.getBoolean("disableScroll", false);
    boolean bool4 = this.gCz.getBoolean("fakeDownEvent", false);
    boolean bool3 = this.gCz.getBoolean("onLongClick", false);
    this.lyn = this.gCz.getBoolean("enableLongClick", false);
    this.lyv.b(j, f1, f2);
    boolean bool1 = bool5 | bool3;
    boolean bool2 = bool1;
    switch (k)
    {
    default: 
      bool2 = bool1;
    }
    for (;;)
    {
      bool1 = bool2;
      label340:
      a.a(bool1, this, "com/tencent/mm/plugin/appbrand/jsapi/view/ViewMotionFactory$CanvasOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(140680);
      return bool1;
      i = 0;
      Object localObject2;
      if (i < paramMotionEvent.getPointerCount())
      {
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        j = paramMotionEvent.getPointerId(i);
        localObject2 = (e.f)this.lyl.get(Integer.valueOf(j));
        if ((localObject2 != null) && ((f1 != ((e.f)localObject2).x) || (f2 != ((e.f)localObject2).y)))
        {
          i = 1;
          label450:
          bool2 = bool1;
          if (i == 0) {
            continue;
          }
          if ((this.lyl.size() == 1) && (this.lym) && ((Math.abs(this.lyu.x - this.lyv.x) > this.lyr) || (Math.abs(this.lyu.y - this.lyv.y) > this.lyr))) {
            l(paramView, false);
          }
          paramView = new JSONObject();
          localObject2 = new JSONArray();
        }
      }
      try
      {
        paramView.put("data", localObject1);
        paramView.put("touches", localObject2);
        paramMotionEvent = v(paramMotionEvent);
        if (paramMotionEvent.length > 0)
        {
          i = 0;
          for (;;)
          {
            if (i < paramMotionEvent.length)
            {
              ((JSONArray)localObject2).put(paramMotionEvent[i].toJSONObject());
              i += 1;
              continue;
              i += 1;
              break;
              i = 0;
              break label450;
            }
          }
        }
        bool2 = bool1;
        if (this.lyl.size() == 0) {
          continue;
        }
        a(this.cnn, new e.d(), paramView.toString());
        break label340;
        if ((this.lys != null) && (paramMotionEvent.getDownTime() != this.lys.getDownTime()))
        {
          this.gCz.G("fakeDownEvent", false);
          ae.v("MicroMsg.OnTouchListenerImpl", "try to handle fake event failed");
          bool2 = false;
          if ((bool5) || (bool2))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(true);
            paramView.setDuplicateParentStateEnabled(false);
            ae.i("MicroMsg.OnTouchListenerImpl", "onLongClick fake down event.");
            label747:
            if (!bool2) {
              break label999;
            }
            bool3 = true;
            bool1 = true;
            this.gCz.G("fakeDownEvent", false);
            this.gCz.G("onLongClick", true);
            label780:
            this.gCz.G("isTouching", true);
            if ((this.lyn) && (!bool3) && (!this.lyl.containsKey(Integer.valueOf(j)))) {
              paramView.postDelayed(this.lyp, ViewConfiguration.getLongPressTimeout());
            }
            bool4 = bool2;
            if ((f1 < 0.0F) || (f2 < 0.0F) || (f1 > paramView.getWidth()) || (f2 > paramView.getHeight())) {
              break label1026;
            }
            i = 1;
            label875:
            bool2 = bool1;
            if (i == 0) {
              continue;
            }
            paramMotionEvent = new e.f(j, f1, f2);
            if ((k != 0) || (bool3)) {
              break label1032;
            }
          }
          label1026:
          label1032:
          for (bool2 = true;; bool2 = false)
          {
            l(paramView, bool2);
            if (!this.lyl.containsKey(Integer.valueOf(j))) {
              break label1381;
            }
            i = 1;
            this.lyl.put(Integer.valueOf(j), paramMotionEvent);
            bool2 = bool1;
            if (bool4) {
              break;
            }
            bool2 = bool1;
            if (i != 0) {
              break;
            }
            a(this.cnn, paramMotionEvent, new e.c(), (String)localObject1);
            break label340;
            paramView.setDuplicateParentStateEnabled(true);
            break label747;
            label999:
            lyk = paramView;
            this.lyo = e.cF(paramView);
            this.lyu.b(j, f1, f2);
            break label780;
            i = 0;
            break label875;
          }
          if ((bool5) || (bool3)) {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
          }
          for (;;)
          {
            lyk = null;
            this.gCz.G("isTouching", false);
            if (this.gCz.containsKey("disableScroll-nextState")) {
              this.gCz.G("disableScroll", this.gCz.getBoolean("disableScroll-nextState", bool5));
            }
            paramMotionEvent = (e.f)this.lyl.remove(Integer.valueOf(j));
            bool2 = bool1;
            if (paramMotionEvent == null) {
              break;
            }
            l(paramView, false);
            a(this.cnn, paramMotionEvent, new e.e(), (String)localObject1);
            break label340;
            paramView.setDuplicateParentStateEnabled(false);
          }
          lyk = null;
          l(paramView, false);
          if ((bool5) || (bool3))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
            this.gCz.G("isTouching", false);
            if (this.gCz.containsKey("disableScroll-nextState")) {
              this.gCz.G("disableScroll", this.gCz.getBoolean("disableScroll-nextState", bool5));
            }
            if (!t.aC(paramView)) {
              break label1355;
            }
            paramView = new JSONObject();
            localObject2 = new JSONArray();
          }
          try
          {
            paramView.put("data", localObject1);
            paramView.put("touches", localObject2);
            label1291:
            paramMotionEvent = v(paramMotionEvent);
            i = 0;
            for (;;)
            {
              if (i < paramMotionEvent.length)
              {
                ((JSONArray)localObject2).put(paramMotionEvent[i].toJSONObject());
                i += 1;
                continue;
                paramView.setDuplicateParentStateEnabled(false);
                break;
              }
            }
            a(this.cnn, new e.b(), paramView.toString());
            label1355:
            this.lyl.clear();
            bool2 = bool1;
          }
          catch (JSONException localJSONException1)
          {
            break label1291;
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          continue;
          label1381:
          i = 0;
          continue;
          bool2 = bool4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.d.a
 * JD-Core Version:    0.7.0.1
 */