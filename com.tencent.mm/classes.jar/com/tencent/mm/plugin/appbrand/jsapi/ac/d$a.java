package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
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
  private static volatile View mFl;
  private f czm;
  private ad.b hpn;
  private Map<Integer, e.f> mFm;
  private boolean mFn;
  private boolean mFo;
  private e.f mFp;
  private Runnable mFq;
  private int mFr;
  private float mFs;
  private MotionEvent mFt;
  private MotionEvent mFu;
  private e.f mFv;
  private e.f mFw;
  private View mView;
  
  public d$a(final f paramf, ad.b paramb)
  {
    AppMethodBeat.i(140679);
    this.mFm = new HashMap();
    Assert.assertNotNull(paramf);
    Assert.assertNotNull(paramb);
    this.hpn = paramb;
    this.mFr = paramf.getComponentId();
    this.czm = paramf;
    this.mFs = ViewConfiguration.get(paramf.getContext()).getScaledTouchSlop();
    this.mFv = new e.f();
    this.mFw = new e.f();
    this.mFq = new Runnable()
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
        if (!u.aD(d.a.b(d.a.this)))
        {
          Log.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, view removed");
          if ((d.a.bLj() != null) && (d.a.bLj().equals(d.a.b(d.a.this)))) {
            d.a.bLk();
          }
          AppMethodBeat.o(140678);
          return;
        }
        Object localObject = e.cv(d.a.b(d.a.this));
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
            d.a.h(d.a.this).H("fakeDownEvent", true);
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
      localJSONObject.put("touch", paramf1.toJSONObject());
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
  
  private void l(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(140681);
    this.mView = paramView;
    this.mFn = paramBoolean;
    if (!paramBoolean)
    {
      this.hpn.H("fakeDownEvent", false);
      this.hpn.H("onLongClick", false);
      this.mView.removeCallbacks(this.mFq);
      this.mFv.b(-1, 0.0F, 0.0F);
      this.mFt = null;
    }
    AppMethodBeat.o(140681);
  }
  
  private e.f[] z(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(140684);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      int k = paramMotionEvent.getPointerId(i);
      e.f localf = (e.f)this.mFm.get(Integer.valueOf(k));
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
    if ((mFl != null) && (!mFl.equals(paramView)))
    {
      Log.v("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
      AppMethodBeat.o(140680);
      return false;
    }
    this.mFu = paramMotionEvent;
    int k = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    if ((k != 0) && (!this.hpn.JY("isTouching")) && (!u.aD(paramView)) && (k != 3))
    {
      AppMethodBeat.o(140680);
      return false;
    }
    String str = this.hpn.getString("data", "");
    boolean bool5 = this.hpn.getBoolean("disableScroll", false);
    boolean bool2 = this.hpn.getBoolean("fakeDownEvent", false);
    boolean bool3 = this.hpn.getBoolean("onLongClick", false);
    this.mFo = this.hpn.getBoolean("enableLongClick", false);
    this.mFw.b(j, f1, f2);
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
        localObject = (e.f)this.mFm.get(Integer.valueOf(j));
        if ((localObject != null) && ((f1 != ((e.f)localObject).x) || (f2 != ((e.f)localObject).y)))
        {
          i = 1;
          label352:
          bool4 = bool1;
          if (i == 0) {
            continue;
          }
          if ((this.mFm.size() == 1) && (this.mFn) && ((Math.abs(this.mFv.x - this.mFw.x) > this.mFs) || (Math.abs(this.mFv.y - this.mFw.y) > this.mFs))) {
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
        if (this.mFm.size() == 0) {
          continue;
        }
        a(this.czm, new e.d(), paramView.toString());
        bool4 = bool1;
        continue;
        if ((this.mFt != null) && (paramMotionEvent.getDownTime() != this.mFt.getDownTime()))
        {
          this.hpn.H("fakeDownEvent", false);
          Log.v("MicroMsg.OnTouchListenerImpl", "try to handle fake event failed");
          bool2 = false;
          if ((bool5) || (bool2))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(true);
            paramView.setDuplicateParentStateEnabled(false);
            Log.i("MicroMsg.OnTouchListenerImpl", "onLongClick fake down event.");
            label653:
            if (!bool2) {
              break label905;
            }
            bool3 = true;
            bool1 = true;
            this.hpn.H("fakeDownEvent", false);
            this.hpn.H("onLongClick", true);
            label686:
            this.hpn.H("isTouching", true);
            if ((this.mFo) && (!bool3) && (!this.mFm.containsKey(Integer.valueOf(j)))) {
              paramView.postDelayed(this.mFq, ViewConfiguration.getLongPressTimeout());
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
            if (!this.mFm.containsKey(Integer.valueOf(j))) {
              break label1291;
            }
            i = 1;
            this.mFm.put(Integer.valueOf(j), paramMotionEvent);
            bool4 = bool1;
            if (bool2) {
              break;
            }
            bool4 = bool1;
            if (i != 0) {
              break;
            }
            a(this.czm, paramMotionEvent, new e.c(), str);
            bool4 = bool1;
            break;
            paramView.setDuplicateParentStateEnabled(true);
            break label653;
            mFl = paramView;
            this.mFp = e.cv(paramView);
            this.mFv.b(j, f1, f2);
            break label686;
            i = 0;
            break label777;
          }
          if ((bool5) || (bool3)) {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
          }
          for (;;)
          {
            mFl = null;
            this.hpn.H("isTouching", false);
            if (this.hpn.containsKey("disableScroll-nextState")) {
              this.hpn.H("disableScroll", this.hpn.getBoolean("disableScroll-nextState", bool5));
            }
            paramMotionEvent = (e.f)this.mFm.remove(Integer.valueOf(j));
            bool4 = bool1;
            if (paramMotionEvent == null) {
              break;
            }
            l(paramView, false);
            a(this.czm, paramMotionEvent, new e.e(), str);
            bool4 = bool1;
            break;
            paramView.setDuplicateParentStateEnabled(false);
          }
          mFl = null;
          l(paramView, false);
          if ((bool5) || (bool3))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
            this.hpn.H("isTouching", false);
            if (this.hpn.containsKey("disableScroll-nextState")) {
              this.hpn.H("disableScroll", this.hpn.getBoolean("disableScroll-nextState", bool5));
            }
            if (!u.aD(paramView)) {
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
            a(this.czm, new e.b(), paramView.toString());
            label1265:
            this.mFm.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.d.a
 * JD-Core Version:    0.7.0.1
 */