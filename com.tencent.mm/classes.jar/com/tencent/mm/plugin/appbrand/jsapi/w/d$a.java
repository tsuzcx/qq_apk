package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.support.v4.view.t;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
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
  private static volatile View kWM;
  private c ccU;
  private y.b ggi;
  private Map<Integer, e.f> kWN;
  private boolean kWO;
  private boolean kWP;
  private e.f kWQ;
  private Runnable kWR;
  private int kWS;
  private float kWT;
  private MotionEvent kWU;
  private MotionEvent kWV;
  private e.f kWW;
  private e.f kWX;
  private View mView;
  
  public d$a(final c paramc, y.b paramb)
  {
    AppMethodBeat.i(140679);
    this.kWN = new HashMap();
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramb);
    this.ggi = paramb;
    this.kWS = paramc.aUT();
    this.ccU = paramc;
    this.kWT = ViewConfiguration.get(paramc.getContext()).getScaledTouchSlop();
    this.kWW = new e.f();
    this.kWX = new e.f();
    this.kWR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140678);
        if (!d.a.a(d.a.this))
        {
          ac.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
          AppMethodBeat.o(140678);
          return;
        }
        if (!t.aC(d.a.b(d.a.this)))
        {
          ac.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, view removed");
          if ((d.a.blj() != null) && (d.a.blj().equals(d.a.b(d.a.this)))) {
            d.a.blk();
          }
          AppMethodBeat.o(140678);
          return;
        }
        Object localObject = e.cD(d.a.b(d.a.this));
        if ((Math.abs(d.a.c(d.a.this).x - ((e.f)localObject).x) > 1.0F) || (Math.abs(d.a.c(d.a.this).y - ((e.f)localObject).y) > 1.0F))
        {
          ac.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
          AppMethodBeat.o(140678);
          return;
        }
        if (d.a.d(d.a.this).size() != 1)
        {
          ac.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
          AppMethodBeat.o(140678);
          return;
        }
        if ((Math.abs(d.a.e(d.a.this).x - d.a.f(d.a.this).x) > d.a.g(d.a.this)) || (Math.abs(d.a.e(d.a.this).y - d.a.f(d.a.this).y) > d.a.g(d.a.this)))
        {
          ac.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", new Object[] { Float.valueOf(d.a.e(d.a.this).x), Float.valueOf(d.a.f(d.a.this).x), Float.valueOf(d.a.e(d.a.this).y), Float.valueOf(d.a.f(d.a.this).y) });
          AppMethodBeat.o(140678);
          return;
        }
        ac.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", new Object[] { Float.valueOf(d.a.e(d.a.this).x), Float.valueOf(d.a.f(d.a.this).x), Float.valueOf(d.a.e(d.a.this).y), Float.valueOf(d.a.f(d.a.this).y) });
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
  
  private static void a(c paramc, ar paramar, String paramString)
  {
    AppMethodBeat.i(140683);
    paramc.b(paramar.getName(), paramString, null);
    AppMethodBeat.o(140683);
  }
  
  private static void a(c paramc, e.f paramf, ar paramar, String paramString)
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
      a(paramc, paramar, localJSONObject.toString());
      AppMethodBeat.o(140682);
      return;
    }
    catch (JSONException paramf)
    {
      break label45;
    }
  }
  
  private void l(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(140681);
    this.mView = paramView;
    this.kWO = paramBoolean;
    if (!paramBoolean)
    {
      this.ggi.G("fakeDownEvent", false);
      this.ggi.G("onLongClick", false);
      this.mView.removeCallbacks(this.kWR);
      this.kWW.b(-1, 0.0F, 0.0F);
      this.kWU = null;
    }
    AppMethodBeat.o(140681);
  }
  
  private e.f[] x(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(140684);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      int k = paramMotionEvent.getPointerId(i);
      e.f localf = (e.f)this.kWN.get(Integer.valueOf(k));
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
    if ((kWM != null) && (!kWM.equals(paramView)))
    {
      ac.v("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
      AppMethodBeat.o(140680);
      return false;
    }
    this.kWV = paramMotionEvent;
    int k = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    if ((k != 0) && (!this.ggi.xK("isTouching")) && (!t.aC(paramView)) && (k != 3))
    {
      AppMethodBeat.o(140680);
      return false;
    }
    String str = this.ggi.getString("data", "");
    boolean bool5 = this.ggi.getBoolean("disableScroll", false);
    boolean bool2 = this.ggi.getBoolean("fakeDownEvent", false);
    boolean bool3 = this.ggi.getBoolean("onLongClick", false);
    this.kWP = this.ggi.getBoolean("enableLongClick", false);
    this.kWX.b(j, f1, f2);
    boolean bool1 = bool5 | bool3;
    boolean bool4 = bool1;
    switch (k)
    {
    default: 
      bool4 = bool1;
    }
    for (;;)
    {
      AppMethodBeat.o(140680);
      return bool4;
      i = 0;
      Object localObject;
      if (i < paramMotionEvent.getPointerCount())
      {
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        j = paramMotionEvent.getPointerId(i);
        localObject = (e.f)this.kWN.get(Integer.valueOf(j));
        if ((localObject != null) && ((f1 != ((e.f)localObject).x) || (f2 != ((e.f)localObject).y)))
        {
          i = 1;
          label352:
          bool4 = bool1;
          if (i == 0) {
            continue;
          }
          if ((this.kWN.size() == 1) && (this.kWO) && ((Math.abs(this.kWW.x - this.kWX.x) > this.kWT) || (Math.abs(this.kWW.y - this.kWX.y) > this.kWT))) {
            l(paramView, false);
          }
          paramView = new JSONObject();
          localObject = new JSONArray();
        }
      }
      try
      {
        paramView.put("data", str);
        paramView.put("touches", localObject);
        paramMotionEvent = x(paramMotionEvent);
        if (paramMotionEvent.length > 0)
        {
          i = 0;
          for (;;)
          {
            if (i < paramMotionEvent.length)
            {
              ((JSONArray)localObject).put(paramMotionEvent[i].toJSONObject());
              i += 1;
              continue;
              i += 1;
              break;
              i = 0;
              break label352;
            }
          }
        }
        bool4 = bool1;
        if (this.kWN.size() == 0) {
          continue;
        }
        a(this.ccU, new e.d(), paramView.toString());
        bool4 = bool1;
        continue;
        if ((this.kWU != null) && (paramMotionEvent.getDownTime() != this.kWU.getDownTime()))
        {
          this.ggi.G("fakeDownEvent", false);
          ac.v("MicroMsg.OnTouchListenerImpl", "try to handle fake event failed");
          bool2 = false;
          if ((bool5) || (bool2))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(true);
            paramView.setDuplicateParentStateEnabled(false);
            ac.i("MicroMsg.OnTouchListenerImpl", "onLongClick fake down event.");
            label653:
            if (!bool2) {
              break label905;
            }
            bool3 = true;
            bool1 = true;
            this.ggi.G("fakeDownEvent", false);
            this.ggi.G("onLongClick", true);
            label686:
            this.ggi.G("isTouching", true);
            if ((this.kWP) && (!bool3) && (!this.kWN.containsKey(Integer.valueOf(j)))) {
              paramView.postDelayed(this.kWR, ViewConfiguration.getLongPressTimeout());
            }
            if ((f1 < 0.0F) || (f2 < 0.0F) || (f1 > paramView.getWidth()) || (f2 > paramView.getHeight())) {
              break label932;
            }
            i = 1;
            label777:
            bool4 = bool1;
            if (i == 0) {
              continue;
            }
            paramMotionEvent = new e.f(j, f1, f2);
            if ((k != 0) || (bool3)) {
              break label938;
            }
          }
          label905:
          label932:
          label938:
          for (bool3 = true;; bool3 = false)
          {
            l(paramView, bool3);
            if (!this.kWN.containsKey(Integer.valueOf(j))) {
              break label1291;
            }
            i = 1;
            this.kWN.put(Integer.valueOf(j), paramMotionEvent);
            bool4 = bool1;
            if (bool2) {
              break;
            }
            bool4 = bool1;
            if (i != 0) {
              break;
            }
            a(this.ccU, paramMotionEvent, new e.c(), str);
            bool4 = bool1;
            break;
            paramView.setDuplicateParentStateEnabled(true);
            break label653;
            kWM = paramView;
            this.kWQ = e.cD(paramView);
            this.kWW.b(j, f1, f2);
            break label686;
            i = 0;
            break label777;
          }
          if ((bool5) || (bool3)) {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
          }
          for (;;)
          {
            kWM = null;
            this.ggi.G("isTouching", false);
            if (this.ggi.containsKey("disableScroll-nextState")) {
              this.ggi.G("disableScroll", this.ggi.getBoolean("disableScroll-nextState", bool5));
            }
            paramMotionEvent = (e.f)this.kWN.remove(Integer.valueOf(j));
            bool4 = bool1;
            if (paramMotionEvent == null) {
              break;
            }
            l(paramView, false);
            a(this.ccU, paramMotionEvent, new e.e(), str);
            bool4 = bool1;
            break;
            paramView.setDuplicateParentStateEnabled(false);
          }
          kWM = null;
          l(paramView, false);
          if ((bool5) || (bool3))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
            this.ggi.G("isTouching", false);
            if (this.ggi.containsKey("disableScroll-nextState")) {
              this.ggi.G("disableScroll", this.ggi.getBoolean("disableScroll-nextState", bool5));
            }
            if (!t.aC(paramView)) {
              break label1265;
            }
            paramView = new JSONObject();
            localObject = new JSONArray();
          }
          try
          {
            paramView.put("data", str);
            paramView.put("touches", localObject);
            label1201:
            paramMotionEvent = x(paramMotionEvent);
            i = 0;
            for (;;)
            {
              if (i < paramMotionEvent.length)
              {
                ((JSONArray)localObject).put(paramMotionEvent[i].toJSONObject());
                i += 1;
                continue;
                paramView.setDuplicateParentStateEnabled(false);
                break;
              }
            }
            a(this.ccU, new e.b(), paramView.toString());
            label1265:
            this.kWN.clear();
            bool4 = bool1;
          }
          catch (JSONException localJSONException1)
          {
            break label1201;
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          continue;
          label1291:
          i = 0;
          continue;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.d.a
 * JD-Core Version:    0.7.0.1
 */