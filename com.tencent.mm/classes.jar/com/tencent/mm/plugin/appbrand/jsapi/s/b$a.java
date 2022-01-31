package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.support.v4.view.q;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$a
  implements View.OnTouchListener
{
  private static volatile View gFN;
  private u.b dIV;
  private com.tencent.mm.plugin.appbrand.jsapi.c fLx;
  private Map<Integer, c.f> gFO = new HashMap();
  private boolean gFP;
  private boolean gFQ;
  private c.f gFR;
  private Runnable gFS;
  private int gFT;
  private float gFU;
  private MotionEvent gFV;
  private MotionEvent gFW;
  private c.f gFX;
  private c.f gFY;
  private View mView;
  
  public b$a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, u.b paramb)
  {
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramb);
    this.dIV = paramb;
    this.gFT = paramc.ahJ();
    this.fLx = paramc;
    this.gFU = ViewConfiguration.get(paramc.getContext()).getScaledTouchSlop();
    this.gFX = new c.f();
    this.gFY = new c.f();
    this.gFS = new b.a.1(this, paramc);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, ac paramac, String paramString)
  {
    paramc.a(paramac.getName(), paramString, null);
  }
  
  private static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, c.f paramf, ac paramac, String paramString)
  {
    if (paramf == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", paramString);
      localJSONObject.put("touch", paramf.rB());
      label35:
      a(paramc, paramac, localJSONObject.toString());
      return;
    }
    catch (JSONException paramf)
    {
      break label35;
    }
  }
  
  private void h(View paramView, boolean paramBoolean)
  {
    this.mView = paramView;
    this.gFP = paramBoolean;
    if (!paramBoolean)
    {
      this.dIV.w("fakeDownEvent", false);
      this.dIV.w("onLongClick", false);
      this.mView.removeCallbacks(this.gFS);
      this.gFX.a(-1, 0.0F, 0.0F);
      this.gFV = null;
    }
  }
  
  private c.f[] u(MotionEvent paramMotionEvent)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      int k = paramMotionEvent.getPointerId(i);
      c.f localf = (c.f)this.gFO.get(Integer.valueOf(k));
      if (localf != null)
      {
        localf.x = paramMotionEvent.getX(i);
        localf.y = paramMotionEvent.getY(i);
        localArrayList.add(localf);
      }
      i += 1;
    }
    paramMotionEvent = new c.f[localArrayList.size()];
    i = j;
    while (i < localArrayList.size())
    {
      paramMotionEvent[i] = ((c.f)localArrayList.get(i));
      i += 1;
    }
    return paramMotionEvent;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if ((gFN != null) && (!gFN.equals(paramView)))
    {
      y.v("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
      bool2 = false;
      return bool2;
    }
    this.gFW = paramMotionEvent;
    int k = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    if ((k != 0) && (!this.dIV.ik("isTouching")) && (!q.ao(paramView)) && (k != 3)) {
      return false;
    }
    String str = this.dIV.getString("data", "");
    boolean bool5 = this.dIV.getBoolean("disableScroll", false);
    boolean bool4 = this.dIV.getBoolean("fakeDownEvent", false);
    boolean bool3 = this.dIV.getBoolean("onLongClick", false);
    this.gFQ = this.dIV.getBoolean("enableLongClick", false);
    this.gFY.a(j, f1, f2);
    boolean bool1 = bool5 | bool3;
    switch (k)
    {
    case 4: 
    default: 
      return bool1;
    case 0: 
      if ((this.gFV != null) && (paramMotionEvent.getDownTime() != this.gFV.getDownTime()))
      {
        this.dIV.w("fakeDownEvent", false);
        y.v("MicroMsg.OnTouchListenerImpl", "try to handle fake event failed");
        bool2 = false;
        label288:
        if ((bool5) || (bool2))
        {
          paramView.getParent().requestDisallowInterceptTouchEvent(true);
          paramView.setDuplicateParentStateEnabled(false);
          y.i("MicroMsg.OnTouchListenerImpl", "onLongClick fake down event.");
          label322:
          if (!bool2) {
            break label875;
          }
          bool3 = true;
          bool1 = true;
          this.dIV.w("fakeDownEvent", false);
          this.dIV.w("onLongClick", true);
          label355:
          this.dIV.w("isTouching", true);
          if ((this.gFQ) && (!bool3) && (!this.gFO.containsKey(Integer.valueOf(j)))) {
            paramView.postDelayed(this.gFS, ViewConfiguration.getLongPressTimeout());
          }
          bool4 = bool2;
        }
      }
      break;
    }
    for (;;)
    {
      if ((f1 >= 0.0F) && (f2 >= 0.0F) && (f1 <= paramView.getWidth()) && (f2 <= paramView.getHeight()))
      {
        i = 1;
        label450:
        bool2 = bool1;
        if (i == 0) {
          break;
        }
        paramMotionEvent = new c.f(j, f1, f2);
        if ((k != 0) || (bool3)) {
          break label908;
        }
        bool2 = true;
        label485:
        h(paramView, bool2);
        if (!this.gFO.containsKey(Integer.valueOf(j))) {
          break label1253;
        }
      }
      label649:
      label908:
      label1167:
      label1253:
      for (i = 1;; i = 0) {
        for (;;)
        {
          this.gFO.put(Integer.valueOf(j), paramMotionEvent);
          bool2 = bool1;
          if (bool4) {
            break;
          }
          bool2 = bool1;
          if (i != 0) {
            break;
          }
          a(this.fLx, paramMotionEvent, new c.c(), str);
          return bool1;
          i = 0;
          Object localObject;
          if (i < paramMotionEvent.getPointerCount())
          {
            f1 = paramMotionEvent.getX(i);
            f2 = paramMotionEvent.getY(i);
            j = paramMotionEvent.getPointerId(i);
            localObject = (c.f)this.gFO.get(Integer.valueOf(j));
            if ((localObject != null) && ((f1 != ((c.f)localObject).x) || (f2 != ((c.f)localObject).y)))
            {
              i = 1;
              bool2 = bool1;
              if (i == 0) {
                break;
              }
              if ((this.gFO.size() == 1) && (this.gFP) && ((Math.abs(this.gFX.x - this.gFY.x) > this.gFU) || (Math.abs(this.gFX.y - this.gFY.y) > this.gFU))) {
                h(paramView, false);
              }
              paramView = new JSONObject();
              localObject = new JSONArray();
            }
          }
          try
          {
            paramView.put("data", str);
            paramView.put("touches", localObject);
            paramMotionEvent = u(paramMotionEvent);
            if (paramMotionEvent.length > 0)
            {
              i = 0;
              for (;;)
              {
                if (i < paramMotionEvent.length)
                {
                  ((JSONArray)localObject).put(paramMotionEvent[i].rB());
                  i += 1;
                  continue;
                  i += 1;
                  break;
                  i = 0;
                  break label649;
                }
              }
            }
            bool2 = bool1;
            if (this.gFO.size() == 0) {
              break;
            }
            a(this.fLx, new c.d(), paramView.toString());
            return bool1;
            paramView.setDuplicateParentStateEnabled(true);
            break label322;
            label875:
            gFN = paramView;
            this.gFR = c.bU(paramView);
            this.gFX.a(j, f1, f2);
            break label355;
            i = 0;
            break label450;
            bool2 = false;
            break label485;
            if ((bool5) || (bool3)) {
              paramView.getParent().requestDisallowInterceptTouchEvent(false);
            }
            for (;;)
            {
              gFN = null;
              this.dIV.w("isTouching", false);
              if (this.dIV.containsKey("disableScroll-nextState")) {
                this.dIV.w("disableScroll", this.dIV.getBoolean("disableScroll-nextState", bool5));
              }
              paramMotionEvent = (c.f)this.gFO.remove(Integer.valueOf(j));
              bool2 = bool1;
              if (paramMotionEvent == null) {
                break;
              }
              h(paramView, false);
              a(this.fLx, paramMotionEvent, new c.e(), str);
              return bool1;
              paramView.setDuplicateParentStateEnabled(false);
            }
            gFN = null;
            h(paramView, false);
            if ((bool5) || (bool3)) {
              paramView.getParent().requestDisallowInterceptTouchEvent(false);
            }
            for (;;)
            {
              this.dIV.w("isTouching", false);
              if (this.dIV.containsKey("disableScroll-nextState")) {
                this.dIV.w("disableScroll", this.dIV.getBoolean("disableScroll-nextState", bool5));
              }
              if (q.ao(paramView))
              {
                paramView = new JSONObject();
                localObject = new JSONArray();
              }
              try
              {
                paramView.put("data", str);
                paramView.put("touches", localObject);
                paramMotionEvent = u(paramMotionEvent);
                i = 0;
                for (;;)
                {
                  if (i < paramMotionEvent.length)
                  {
                    ((JSONArray)localObject).put(paramMotionEvent[i].rB());
                    i += 1;
                    continue;
                    paramView.setDuplicateParentStateEnabled(false);
                    break;
                  }
                }
                a(this.fLx, new c.b(), paramView.toString());
                this.gFO.clear();
                return bool1;
              }
              catch (JSONException localJSONException1)
              {
                break label1167;
              }
            }
          }
          catch (JSONException localJSONException2)
          {
            break label772;
          }
        }
      }
      label772:
      bool2 = bool4;
      break label288;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b.a
 * JD-Core Version:    0.7.0.1
 */