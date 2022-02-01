package com.tencent.mm.plugin.appbrand.jsapi.ah;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
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
  private static volatile View sJI;
  private f eqB;
  private ad.b mBj;
  private View mView;
  private Map<Integer, e.f> sJJ;
  private boolean sJK;
  private boolean sJL;
  private e.f sJM;
  private Runnable sJN;
  private int sJO;
  private float sJP;
  private MotionEvent sJQ;
  private MotionEvent sJR;
  private e.f sJS;
  private e.f sJT;
  
  public d$a(final f paramf, ad.b paramb)
  {
    AppMethodBeat.i(140679);
    this.sJJ = new HashMap();
    Assert.assertNotNull(paramf);
    Assert.assertNotNull(paramb);
    this.mBj = paramb;
    this.sJO = paramf.getComponentId();
    this.eqB = paramf;
    this.sJP = ViewConfiguration.get(paramf.getContext()).getScaledTouchSlop();
    this.sJS = new e.f();
    this.sJT = new e.f();
    this.sJN = new Runnable()
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
        if (!z.ay(d.a.b(d.a.this)))
        {
          Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, view removed");
          if ((d.a.cxv() != null) && (d.a.cxv().equals(d.a.b(d.a.this)))) {
            d.a.cxw();
          }
          AppMethodBeat.o(140678);
          return;
        }
        Object localObject = e.dw(d.a.b(d.a.this));
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
          ((JSONObject)localObject).put("touch", d.a.e(d.a.this).aZh());
          label451:
          if (!d.a.h(d.a.this).getBoolean("disableScroll", false))
          {
            d.a.a(d.a.this, MotionEvent.obtain(d.a.i(d.a.this)));
            d.a.j(d.a.this).setAction(0);
            d.a.h(d.a.this).N("fakeDownEvent", true);
            d.a.b(d.a.this).getParent().requestDisallowInterceptTouchEvent(true);
            d.a.b(d.a.this).setDuplicateParentStateEnabled(false);
            d.a.a(d.a.this, d.a.b(d.a.this), MotionEvent.obtain(d.a.j(d.a.this)));
          }
          d.a.b(paramf, new e.a(), ((JSONObject)localObject).toString());
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
      e.f localf = (e.f)this.sJJ.get(Integer.valueOf(k));
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
  
  private static void a(f paramf, e.f paramf1, bc parambc, String paramString)
  {
    AppMethodBeat.i(140682);
    if (paramf1 == null)
    {
      AppMethodBeat.o(140682);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", paramString);
      localJSONObject.put("touch", paramf1.aZh());
      label45:
      a(paramf, parambc, localJSONObject.toString());
      AppMethodBeat.o(140682);
      return;
    }
    catch (JSONException paramf1)
    {
      break label45;
    }
  }
  
  private static void a(f paramf, bc parambc, String paramString)
  {
    AppMethodBeat.i(140683);
    paramf.b(parambc.getName(), paramString, null);
    AppMethodBeat.o(140683);
  }
  
  private void m(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(140681);
    this.mView = paramView;
    this.sJK = paramBoolean;
    if (!paramBoolean)
    {
      this.mBj.N("fakeDownEvent", false);
      this.mBj.N("onLongClick", false);
      this.mView.removeCallbacks(this.sJN);
      this.sJS.c(-1, 0.0F, 0.0F);
      this.sJQ = null;
    }
    AppMethodBeat.o(140681);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140680);
    if ((sJI != null) && (!sJI.equals(paramView)))
    {
      Log.v("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
      AppMethodBeat.o(140680);
      return false;
    }
    this.sJR = paramMotionEvent;
    int k = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    if ((k != 0) && (!this.mBj.Jp("isTouching")) && (!z.ay(paramView)) && (k != 3))
    {
      AppMethodBeat.o(140680);
      return false;
    }
    String str = this.mBj.getString("data", "");
    boolean bool5 = this.mBj.getBoolean("disableScroll", false);
    boolean bool2 = this.mBj.getBoolean("fakeDownEvent", false);
    boolean bool3 = this.mBj.getBoolean("onLongClick", false);
    this.sJL = this.mBj.getBoolean("enableLongClick", false);
    this.sJT.c(j, f1, f2);
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
        localObject = (e.f)this.sJJ.get(Integer.valueOf(j));
        if ((localObject != null) && ((f1 != ((e.f)localObject).x) || (f2 != ((e.f)localObject).y)))
        {
          i = 1;
          label352:
          bool4 = bool1;
          if (i == 0) {
            continue;
          }
          if ((this.sJJ.size() == 1) && (this.sJK) && ((Math.abs(this.sJS.x - this.sJT.x) > this.sJP) || (Math.abs(this.sJS.y - this.sJT.y) > this.sJP))) {
            m(paramView, false);
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
        if ((paramMotionEvent != null) && (paramMotionEvent.length > 0))
        {
          i = 0;
          for (;;)
          {
            if (i < paramMotionEvent.length)
            {
              ((JSONArray)localObject).put(paramMotionEvent[i].aZh());
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
        if (this.sJJ.size() == 0) {
          continue;
        }
        a(this.eqB, new e.d(), paramView.toString());
        bool4 = bool1;
        continue;
        if ((this.sJQ != null) && (paramMotionEvent.getDownTime() != this.sJQ.getDownTime()))
        {
          this.mBj.N("fakeDownEvent", false);
          Log.v("MicroMsg.OnTouchListenerImpl", "try to handle fake event failed");
          bool2 = false;
          if ((bool5) || (bool2))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(true);
            paramView.setDuplicateParentStateEnabled(false);
            Log.i("MicroMsg.OnTouchListenerImpl", "onLongClick fake down event.");
            label657:
            if (!bool2) {
              break label910;
            }
            bool3 = true;
            bool1 = true;
            this.mBj.N("fakeDownEvent", false);
            this.mBj.N("onLongClick", true);
            label691:
            this.mBj.N("isTouching", true);
            if ((this.sJL) && (!bool3) && (!this.sJJ.containsKey(Integer.valueOf(j)))) {
              paramView.postDelayed(this.sJN, ViewConfiguration.getLongPressTimeout());
            }
            if ((f1 < 0.0F) || (f2 < 0.0F) || (f1 > paramView.getWidth()) || (f2 > paramView.getHeight())) {
              break label937;
            }
            i = 1;
            label782:
            bool4 = bool1;
            if (i == 0) {
              continue;
            }
            paramMotionEvent = new e.f(j, f1, f2);
            if ((k != 0) || (bool3)) {
              break label943;
            }
          }
          label910:
          label937:
          label943:
          for (bool3 = true;; bool3 = false)
          {
            m(paramView, bool3);
            if (!this.sJJ.containsKey(Integer.valueOf(j))) {
              break label1296;
            }
            i = 1;
            this.sJJ.put(Integer.valueOf(j), paramMotionEvent);
            bool4 = bool1;
            if (bool2) {
              break;
            }
            bool4 = bool1;
            if (i != 0) {
              break;
            }
            a(this.eqB, paramMotionEvent, new e.c(), str);
            bool4 = bool1;
            break;
            paramView.setDuplicateParentStateEnabled(true);
            break label657;
            sJI = paramView;
            this.sJM = e.dw(paramView);
            this.sJS.c(j, f1, f2);
            break label691;
            i = 0;
            break label782;
          }
          if ((bool5) || (bool3)) {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
          }
          for (;;)
          {
            sJI = null;
            this.mBj.N("isTouching", false);
            if (this.mBj.containsKey("disableScroll-nextState")) {
              this.mBj.N("disableScroll", this.mBj.getBoolean("disableScroll-nextState", bool5));
            }
            paramMotionEvent = (e.f)this.sJJ.remove(Integer.valueOf(j));
            bool4 = bool1;
            if (paramMotionEvent == null) {
              break;
            }
            m(paramView, false);
            a(this.eqB, paramMotionEvent, new e.e(), str);
            bool4 = bool1;
            break;
            paramView.setDuplicateParentStateEnabled(false);
          }
          sJI = null;
          m(paramView, false);
          if ((bool5) || (bool3))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
            this.mBj.N("isTouching", false);
            if (this.mBj.containsKey("disableScroll-nextState")) {
              this.mBj.N("disableScroll", this.mBj.getBoolean("disableScroll-nextState", bool5));
            }
            if (!z.ay(paramView)) {
              break label1270;
            }
            paramView = new JSONObject();
            localObject = new JSONArray();
          }
          try
          {
            paramView.put("data", str);
            paramView.put("touches", localObject);
            label1206:
            paramMotionEvent = A(paramMotionEvent);
            i = 0;
            for (;;)
            {
              if (i < paramMotionEvent.length)
              {
                ((JSONArray)localObject).put(paramMotionEvent[i].aZh());
                i += 1;
                continue;
                paramView.setDuplicateParentStateEnabled(false);
                break;
              }
            }
            a(this.eqB, new e.b(), paramView.toString());
            label1270:
            this.sJJ.clear();
            bool4 = bool1;
          }
          catch (JSONException localJSONException1)
          {
            break label1206;
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          continue;
          label1296:
          i = 0;
          continue;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.d.a
 * JD-Core Version:    0.7.0.1
 */