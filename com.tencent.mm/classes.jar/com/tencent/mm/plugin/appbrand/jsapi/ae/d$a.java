package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.sdk.platformtools.Log;
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
  private static volatile View pEx;
  private com.tencent.mm.plugin.appbrand.jsapi.e cyi;
  private ad.b kbe;
  private View mView;
  private boolean pEA;
  private e.f pEB;
  private Runnable pEC;
  private int pED;
  private float pEE;
  private MotionEvent pEF;
  private MotionEvent pEG;
  private e.f pEH;
  private e.f pEI;
  private Map<Integer, e.f> pEy;
  private boolean pEz;
  
  public d$a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, ad.b paramb)
  {
    AppMethodBeat.i(140679);
    this.pEy = new HashMap();
    Assert.assertNotNull(parame);
    Assert.assertNotNull(paramb);
    this.kbe = paramb;
    this.pED = parame.getComponentId();
    this.cyi = parame;
    this.pEE = ViewConfiguration.get(parame.getContext()).getScaledTouchSlop();
    this.pEH = new e.f();
    this.pEI = new e.f();
    this.pEC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140678);
        if (!d.a.a(d.a.this))
        {
          Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
          AppMethodBeat.o(140678);
          return;
        }
        if (!w.al(d.a.b(d.a.this)))
        {
          Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, view removed");
          if ((d.a.bXj() != null) && (d.a.bXj().equals(d.a.b(d.a.this)))) {
            d.a.bXk();
          }
          AppMethodBeat.o(140678);
          return;
        }
        Object localObject = e.cO(d.a.b(d.a.this));
        if ((Math.abs(d.a.c(d.a.this).x - ((e.f)localObject).x) > 1.0F) || (Math.abs(d.a.c(d.a.this).y - ((e.f)localObject).y) > 1.0F))
        {
          Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
          AppMethodBeat.o(140678);
          return;
        }
        if (d.a.d(d.a.this).size() != 1)
        {
          Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
          AppMethodBeat.o(140678);
          return;
        }
        if ((Math.abs(d.a.e(d.a.this).x - d.a.f(d.a.this).x) > d.a.g(d.a.this)) || (Math.abs(d.a.e(d.a.this).y - d.a.f(d.a.this).y) > d.a.g(d.a.this)))
        {
          Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", new Object[] { Float.valueOf(d.a.e(d.a.this).x), Float.valueOf(d.a.f(d.a.this).x), Float.valueOf(d.a.e(d.a.this).y), Float.valueOf(d.a.f(d.a.this).y) });
          AppMethodBeat.o(140678);
          return;
        }
        Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", new Object[] { Float.valueOf(d.a.e(d.a.this).x), Float.valueOf(d.a.f(d.a.this).x), Float.valueOf(d.a.e(d.a.this).y), Float.valueOf(d.a.f(d.a.this).y) });
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
            d.a.h(d.a.this).J("fakeDownEvent", true);
            d.a.b(d.a.this).getParent().requestDisallowInterceptTouchEvent(true);
            d.a.b(d.a.this).setDuplicateParentStateEnabled(false);
            d.a.a(d.a.this, d.a.b(d.a.this), MotionEvent.obtain(d.a.j(d.a.this)));
          }
          d.a.b(parame, new e.a(), ((JSONObject)localObject).toString());
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
  
  private e.f[] A(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(140684);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      int k = paramMotionEvent.getPointerId(i);
      e.f localf = (e.f)this.pEy.get(Integer.valueOf(k));
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
  
  private static void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, e.f paramf, az paramaz, String paramString)
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
      a(parame, paramaz, localJSONObject.toString());
      AppMethodBeat.o(140682);
      return;
    }
    catch (JSONException paramf)
    {
      break label45;
    }
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, az paramaz, String paramString)
  {
    AppMethodBeat.i(140683);
    parame.b(paramaz.getName(), paramString, null);
    AppMethodBeat.o(140683);
  }
  
  private void l(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(140681);
    this.mView = paramView;
    this.pEz = paramBoolean;
    if (!paramBoolean)
    {
      this.kbe.J("fakeDownEvent", false);
      this.kbe.J("onLongClick", false);
      this.mView.removeCallbacks(this.pEC);
      this.pEH.b(-1, 0.0F, 0.0F);
      this.pEF = null;
    }
    AppMethodBeat.o(140681);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140680);
    if ((pEx != null) && (!pEx.equals(paramView)))
    {
      Log.v("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
      AppMethodBeat.o(140680);
      return false;
    }
    this.pEG = paramMotionEvent;
    int k = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    if ((k != 0) && (!this.kbe.Rq("isTouching")) && (!w.al(paramView)) && (k != 3))
    {
      AppMethodBeat.o(140680);
      return false;
    }
    String str = this.kbe.getString("data", "");
    boolean bool5 = this.kbe.getBoolean("disableScroll", false);
    boolean bool2 = this.kbe.getBoolean("fakeDownEvent", false);
    boolean bool3 = this.kbe.getBoolean("onLongClick", false);
    this.pEA = this.kbe.getBoolean("enableLongClick", false);
    this.pEI.b(j, f1, f2);
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
        localObject = (e.f)this.pEy.get(Integer.valueOf(j));
        if ((localObject != null) && ((f1 != ((e.f)localObject).x) || (f2 != ((e.f)localObject).y)))
        {
          i = 1;
          label352:
          bool4 = bool1;
          if (i == 0) {
            continue;
          }
          if ((this.pEy.size() == 1) && (this.pEz) && ((Math.abs(this.pEH.x - this.pEI.x) > this.pEE) || (Math.abs(this.pEH.y - this.pEI.y) > this.pEE))) {
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
        paramMotionEvent = A(paramMotionEvent);
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
        if (this.pEy.size() == 0) {
          continue;
        }
        a(this.cyi, new e.d(), paramView.toString());
        bool4 = bool1;
        continue;
        if ((this.pEF != null) && (paramMotionEvent.getDownTime() != this.pEF.getDownTime()))
        {
          this.kbe.J("fakeDownEvent", false);
          Log.v("MicroMsg.OnTouchListenerImpl", "try to handle fake event failed");
          bool2 = false;
          if ((bool5) || (bool2))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(true);
            paramView.setDuplicateParentStateEnabled(false);
            Log.i("MicroMsg.OnTouchListenerImpl", "onLongClick fake down event.");
            label653:
            if (!bool2) {
              break label906;
            }
            bool3 = true;
            bool1 = true;
            this.kbe.J("fakeDownEvent", false);
            this.kbe.J("onLongClick", true);
            label687:
            this.kbe.J("isTouching", true);
            if ((this.pEA) && (!bool3) && (!this.pEy.containsKey(Integer.valueOf(j)))) {
              paramView.postDelayed(this.pEC, ViewConfiguration.getLongPressTimeout());
            }
            if ((f1 < 0.0F) || (f2 < 0.0F) || (f1 > paramView.getWidth()) || (f2 > paramView.getHeight())) {
              break label933;
            }
            i = 1;
            label778:
            bool4 = bool1;
            if (i == 0) {
              continue;
            }
            paramMotionEvent = new e.f(j, f1, f2);
            if ((k != 0) || (bool3)) {
              break label939;
            }
          }
          label906:
          label933:
          label939:
          for (bool3 = true;; bool3 = false)
          {
            l(paramView, bool3);
            if (!this.pEy.containsKey(Integer.valueOf(j))) {
              break label1292;
            }
            i = 1;
            this.pEy.put(Integer.valueOf(j), paramMotionEvent);
            bool4 = bool1;
            if (bool2) {
              break;
            }
            bool4 = bool1;
            if (i != 0) {
              break;
            }
            a(this.cyi, paramMotionEvent, new e.c(), str);
            bool4 = bool1;
            break;
            paramView.setDuplicateParentStateEnabled(true);
            break label653;
            pEx = paramView;
            this.pEB = e.cO(paramView);
            this.pEH.b(j, f1, f2);
            break label687;
            i = 0;
            break label778;
          }
          if ((bool5) || (bool3)) {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
          }
          for (;;)
          {
            pEx = null;
            this.kbe.J("isTouching", false);
            if (this.kbe.containsKey("disableScroll-nextState")) {
              this.kbe.J("disableScroll", this.kbe.getBoolean("disableScroll-nextState", bool5));
            }
            paramMotionEvent = (e.f)this.pEy.remove(Integer.valueOf(j));
            bool4 = bool1;
            if (paramMotionEvent == null) {
              break;
            }
            l(paramView, false);
            a(this.cyi, paramMotionEvent, new e.e(), str);
            bool4 = bool1;
            break;
            paramView.setDuplicateParentStateEnabled(false);
          }
          pEx = null;
          l(paramView, false);
          if ((bool5) || (bool3))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
            this.kbe.J("isTouching", false);
            if (this.kbe.containsKey("disableScroll-nextState")) {
              this.kbe.J("disableScroll", this.kbe.getBoolean("disableScroll-nextState", bool5));
            }
            if (!w.al(paramView)) {
              break label1266;
            }
            paramView = new JSONObject();
            localObject = new JSONArray();
          }
          try
          {
            paramView.put("data", str);
            paramView.put("touches", localObject);
            label1202:
            paramMotionEvent = A(paramMotionEvent);
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
            a(this.cyi, new e.b(), paramView.toString());
            label1266:
            this.pEy.clear();
            bool4 = bool1;
          }
          catch (JSONException localJSONException1)
          {
            break label1202;
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          continue;
          label1292:
          i = 0;
          continue;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.d.a
 * JD-Core Version:    0.7.0.1
 */