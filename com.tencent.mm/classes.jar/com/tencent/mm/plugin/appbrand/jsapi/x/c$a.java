package com.tencent.mm.plugin.appbrand.jsapi.x;

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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c$a
  implements View.OnTouchListener
{
  private static volatile View kvy;
  private c cfX;
  private y.b gbC;
  private boolean kvA;
  private boolean kvB;
  private d.f kvC;
  private Runnable kvD;
  private int kvE;
  private float kvF;
  private MotionEvent kvG;
  private MotionEvent kvH;
  private d.f kvI;
  private d.f kvJ;
  private Map<Integer, d.f> kvz;
  private View mView;
  
  public c$a(final c paramc, y.b paramb)
  {
    AppMethodBeat.i(140679);
    this.kvz = new HashMap();
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramb);
    this.gbC = paramb;
    this.kvE = paramc.aOd();
    this.cfX = paramc;
    this.kvF = ViewConfiguration.get(paramc.getContext()).getScaledTouchSlop();
    this.kvI = new d.f();
    this.kvJ = new d.f();
    this.kvD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140678);
        if (!c.a.a(c.a.this))
        {
          ad.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
          AppMethodBeat.o(140678);
          return;
        }
        if (!t.aC(c.a.b(c.a.this)))
        {
          ad.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, view removed");
          if ((c.a.bep() != null) && (c.a.bep().equals(c.a.b(c.a.this)))) {
            c.a.beq();
          }
          AppMethodBeat.o(140678);
          return;
        }
        Object localObject = d.cB(c.a.b(c.a.this));
        if ((Math.abs(c.a.c(c.a.this).x - ((d.f)localObject).x) > 1.0F) || (Math.abs(c.a.c(c.a.this).y - ((d.f)localObject).y) > 1.0F))
        {
          ad.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
          AppMethodBeat.o(140678);
          return;
        }
        if (c.a.d(c.a.this).size() != 1)
        {
          ad.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
          AppMethodBeat.o(140678);
          return;
        }
        if ((Math.abs(c.a.e(c.a.this).x - c.a.f(c.a.this).x) > c.a.g(c.a.this)) || (Math.abs(c.a.e(c.a.this).y - c.a.f(c.a.this).y) > c.a.g(c.a.this)))
        {
          ad.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", new Object[] { Float.valueOf(c.a.e(c.a.this).x), Float.valueOf(c.a.f(c.a.this).x), Float.valueOf(c.a.e(c.a.this).y), Float.valueOf(c.a.f(c.a.this).y) });
          AppMethodBeat.o(140678);
          return;
        }
        ad.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", new Object[] { Float.valueOf(c.a.e(c.a.this).x), Float.valueOf(c.a.f(c.a.this).x), Float.valueOf(c.a.e(c.a.this).y), Float.valueOf(c.a.f(c.a.this).y) });
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("data", c.a.h(c.a.this).getString("data", ""));
          ((JSONObject)localObject).put("touch", c.a.e(c.a.this).toJSONObject());
          label451:
          if (!c.a.h(c.a.this).getBoolean("disableScroll", false))
          {
            c.a.a(c.a.this, MotionEvent.obtain(c.a.i(c.a.this)));
            c.a.j(c.a.this).setAction(0);
            c.a.h(c.a.this).F("fakeDownEvent", true);
            c.a.b(c.a.this).getParent().requestDisallowInterceptTouchEvent(true);
            c.a.b(c.a.this).setDuplicateParentStateEnabled(false);
            c.a.a(c.a.b(c.a.this), MotionEvent.obtain(c.a.j(c.a.this)));
          }
          c.a.b(paramc, new d.a(), ((JSONObject)localObject).toString());
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
  
  private static void a(c paramc, d.f paramf, ar paramar, String paramString)
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
    this.kvA = paramBoolean;
    if (!paramBoolean)
    {
      this.gbC.F("fakeDownEvent", false);
      this.gbC.F("onLongClick", false);
      this.mView.removeCallbacks(this.kvD);
      this.kvI.b(-1, 0.0F, 0.0F);
      this.kvG = null;
    }
    AppMethodBeat.o(140681);
  }
  
  private d.f[] z(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(140684);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      int k = paramMotionEvent.getPointerId(i);
      d.f localf = (d.f)this.kvz.get(Integer.valueOf(k));
      if (localf != null)
      {
        localf.x = paramMotionEvent.getX(i);
        localf.y = paramMotionEvent.getY(i);
        localArrayList.add(localf);
      }
      i += 1;
    }
    paramMotionEvent = new d.f[localArrayList.size()];
    i = j;
    while (i < localArrayList.size())
    {
      paramMotionEvent[i] = ((d.f)localArrayList.get(i));
      i += 1;
    }
    AppMethodBeat.o(140684);
    return paramMotionEvent;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140680);
    if ((kvy != null) && (!kvy.equals(paramView)))
    {
      ad.v("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
      AppMethodBeat.o(140680);
      return false;
    }
    this.kvH = paramMotionEvent;
    int k = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    if ((k != 0) && (!this.gbC.tE("isTouching")) && (!t.aC(paramView)) && (k != 3))
    {
      AppMethodBeat.o(140680);
      return false;
    }
    String str = this.gbC.getString("data", "");
    boolean bool5 = this.gbC.getBoolean("disableScroll", false);
    boolean bool2 = this.gbC.getBoolean("fakeDownEvent", false);
    boolean bool3 = this.gbC.getBoolean("onLongClick", false);
    this.kvB = this.gbC.getBoolean("enableLongClick", false);
    this.kvJ.b(j, f1, f2);
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
        localObject = (d.f)this.kvz.get(Integer.valueOf(j));
        if ((localObject != null) && ((f1 != ((d.f)localObject).x) || (f2 != ((d.f)localObject).y)))
        {
          i = 1;
          label352:
          bool4 = bool1;
          if (i == 0) {
            continue;
          }
          if ((this.kvz.size() == 1) && (this.kvA) && ((Math.abs(this.kvI.x - this.kvJ.x) > this.kvF) || (Math.abs(this.kvI.y - this.kvJ.y) > this.kvF))) {
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
        paramMotionEvent = z(paramMotionEvent);
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
        if (this.kvz.size() == 0) {
          continue;
        }
        a(this.cfX, new d.d(), paramView.toString());
        bool4 = bool1;
        continue;
        if ((this.kvG != null) && (paramMotionEvent.getDownTime() != this.kvG.getDownTime()))
        {
          this.gbC.F("fakeDownEvent", false);
          ad.v("MicroMsg.OnTouchListenerImpl", "try to handle fake event failed");
          bool2 = false;
          if ((bool5) || (bool2))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(true);
            paramView.setDuplicateParentStateEnabled(false);
            ad.i("MicroMsg.OnTouchListenerImpl", "onLongClick fake down event.");
            label653:
            if (!bool2) {
              break label905;
            }
            bool3 = true;
            bool1 = true;
            this.gbC.F("fakeDownEvent", false);
            this.gbC.F("onLongClick", true);
            label686:
            this.gbC.F("isTouching", true);
            if ((this.kvB) && (!bool3) && (!this.kvz.containsKey(Integer.valueOf(j)))) {
              paramView.postDelayed(this.kvD, ViewConfiguration.getLongPressTimeout());
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
            paramMotionEvent = new d.f(j, f1, f2);
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
            if (!this.kvz.containsKey(Integer.valueOf(j))) {
              break label1291;
            }
            i = 1;
            this.kvz.put(Integer.valueOf(j), paramMotionEvent);
            bool4 = bool1;
            if (bool2) {
              break;
            }
            bool4 = bool1;
            if (i != 0) {
              break;
            }
            a(this.cfX, paramMotionEvent, new d.c(), str);
            bool4 = bool1;
            break;
            paramView.setDuplicateParentStateEnabled(true);
            break label653;
            kvy = paramView;
            this.kvC = d.cB(paramView);
            this.kvI.b(j, f1, f2);
            break label686;
            i = 0;
            break label777;
          }
          if ((bool5) || (bool3)) {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
          }
          for (;;)
          {
            kvy = null;
            this.gbC.F("isTouching", false);
            if (this.gbC.containsKey("disableScroll-nextState")) {
              this.gbC.F("disableScroll", this.gbC.getBoolean("disableScroll-nextState", bool5));
            }
            paramMotionEvent = (d.f)this.kvz.remove(Integer.valueOf(j));
            bool4 = bool1;
            if (paramMotionEvent == null) {
              break;
            }
            l(paramView, false);
            a(this.cfX, paramMotionEvent, new d.e(), str);
            bool4 = bool1;
            break;
            paramView.setDuplicateParentStateEnabled(false);
          }
          kvy = null;
          l(paramView, false);
          if ((bool5) || (bool3))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
            this.gbC.F("isTouching", false);
            if (this.gbC.containsKey("disableScroll-nextState")) {
              this.gbC.F("disableScroll", this.gbC.getBoolean("disableScroll-nextState", bool5));
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
            paramMotionEvent = z(paramMotionEvent);
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
            a(this.cfX, new d.b(), paramView.toString());
            label1265:
            this.kvz.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.c.a
 * JD-Core Version:    0.7.0.1
 */