package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.support.v4.view.t;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
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
  private static volatile View ieV;
  private c bDN;
  private v.b eGu;
  private Map<Integer, d.f> ieW;
  private boolean ieX;
  private boolean ieY;
  private d.f ieZ;
  private Runnable ifa;
  private int ifb;
  private float ifc;
  private MotionEvent ifd;
  private MotionEvent ife;
  private d.f iff;
  private d.f ifg;
  private View mView;
  
  public c$a(c paramc, v.b paramb)
  {
    AppMethodBeat.i(91068);
    this.ieW = new HashMap();
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramb);
    this.eGu = paramb;
    this.ifb = paramc.aAN();
    this.bDN = paramc;
    this.ifc = ViewConfiguration.get(paramc.getContext()).getScaledTouchSlop();
    this.iff = new d.f();
    this.ifg = new d.f();
    this.ifa = new c.a.1(this, paramc);
    AppMethodBeat.o(91068);
  }
  
  private static void a(c paramc, ai paramai, String paramString)
  {
    AppMethodBeat.i(91072);
    paramc.b(paramai.getName(), paramString, null);
    AppMethodBeat.o(91072);
  }
  
  private static void a(c paramc, d.f paramf, ai paramai, String paramString)
  {
    AppMethodBeat.i(91071);
    if (paramf == null)
    {
      AppMethodBeat.o(91071);
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", paramString);
      localJSONObject.put("touch", paramf.toJSONObject());
      label45:
      a(paramc, paramai, localJSONObject.toString());
      AppMethodBeat.o(91071);
      return;
    }
    catch (JSONException paramf)
    {
      break label45;
    }
  }
  
  private void l(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(91070);
    this.mView = paramView;
    this.ieX = paramBoolean;
    if (!paramBoolean)
    {
      this.eGu.A("fakeDownEvent", false);
      this.eGu.A("onLongClick", false);
      this.mView.removeCallbacks(this.ifa);
      this.iff.b(-1, 0.0F, 0.0F);
      this.ifd = null;
    }
    AppMethodBeat.o(91070);
  }
  
  private d.f[] y(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(91073);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMotionEvent.getPointerCount())
    {
      int k = paramMotionEvent.getPointerId(i);
      d.f localf = (d.f)this.ieW.get(Integer.valueOf(k));
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
    AppMethodBeat.o(91073);
    return paramMotionEvent;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(91069);
    if ((ieV != null) && (!ieV.equals(paramView)))
    {
      ab.v("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
      AppMethodBeat.o(91069);
      return false;
    }
    this.ife = paramMotionEvent;
    int k = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getPointerId(i);
    float f1 = paramMotionEvent.getX(i);
    float f2 = paramMotionEvent.getY(i);
    if ((k != 0) && (!this.eGu.oR("isTouching")) && (!t.aw(paramView)) && (k != 3))
    {
      AppMethodBeat.o(91069);
      return false;
    }
    String str = this.eGu.getString("data", "");
    boolean bool5 = this.eGu.getBoolean("disableScroll", false);
    boolean bool2 = this.eGu.getBoolean("fakeDownEvent", false);
    boolean bool3 = this.eGu.getBoolean("onLongClick", false);
    this.ieY = this.eGu.getBoolean("enableLongClick", false);
    this.ifg.b(j, f1, f2);
    boolean bool1 = bool5 | bool3;
    boolean bool4 = bool1;
    switch (k)
    {
    default: 
      bool4 = bool1;
    }
    for (;;)
    {
      AppMethodBeat.o(91069);
      return bool4;
      i = 0;
      Object localObject;
      if (i < paramMotionEvent.getPointerCount())
      {
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        j = paramMotionEvent.getPointerId(i);
        localObject = (d.f)this.ieW.get(Integer.valueOf(j));
        if ((localObject != null) && ((f1 != ((d.f)localObject).x) || (f2 != ((d.f)localObject).y)))
        {
          i = 1;
          label352:
          bool4 = bool1;
          if (i == 0) {
            continue;
          }
          if ((this.ieW.size() == 1) && (this.ieX) && ((Math.abs(this.iff.x - this.ifg.x) > this.ifc) || (Math.abs(this.iff.y - this.ifg.y) > this.ifc))) {
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
        paramMotionEvent = y(paramMotionEvent);
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
        if (this.ieW.size() == 0) {
          continue;
        }
        a(this.bDN, new d.d(), paramView.toString());
        bool4 = bool1;
        continue;
        if ((this.ifd != null) && (paramMotionEvent.getDownTime() != this.ifd.getDownTime()))
        {
          this.eGu.A("fakeDownEvent", false);
          ab.v("MicroMsg.OnTouchListenerImpl", "try to handle fake event failed");
          bool2 = false;
          if ((bool5) || (bool2))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(true);
            paramView.setDuplicateParentStateEnabled(false);
            ab.i("MicroMsg.OnTouchListenerImpl", "onLongClick fake down event.");
            label653:
            if (!bool2) {
              break label905;
            }
            bool3 = true;
            bool1 = true;
            this.eGu.A("fakeDownEvent", false);
            this.eGu.A("onLongClick", true);
            label686:
            this.eGu.A("isTouching", true);
            if ((this.ieY) && (!bool3) && (!this.ieW.containsKey(Integer.valueOf(j)))) {
              paramView.postDelayed(this.ifa, ViewConfiguration.getLongPressTimeout());
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
            if (!this.ieW.containsKey(Integer.valueOf(j))) {
              break label1291;
            }
            i = 1;
            this.ieW.put(Integer.valueOf(j), paramMotionEvent);
            bool4 = bool1;
            if (bool2) {
              break;
            }
            bool4 = bool1;
            if (i != 0) {
              break;
            }
            a(this.bDN, paramMotionEvent, new d.c(), str);
            bool4 = bool1;
            break;
            paramView.setDuplicateParentStateEnabled(true);
            break label653;
            ieV = paramView;
            this.ieZ = d.cr(paramView);
            this.iff.b(j, f1, f2);
            break label686;
            i = 0;
            break label777;
          }
          if ((bool5) || (bool3)) {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
          }
          for (;;)
          {
            ieV = null;
            this.eGu.A("isTouching", false);
            if (this.eGu.containsKey("disableScroll-nextState")) {
              this.eGu.A("disableScroll", this.eGu.getBoolean("disableScroll-nextState", bool5));
            }
            paramMotionEvent = (d.f)this.ieW.remove(Integer.valueOf(j));
            bool4 = bool1;
            if (paramMotionEvent == null) {
              break;
            }
            l(paramView, false);
            a(this.bDN, paramMotionEvent, new d.e(), str);
            bool4 = bool1;
            break;
            paramView.setDuplicateParentStateEnabled(false);
          }
          ieV = null;
          l(paramView, false);
          if ((bool5) || (bool3))
          {
            paramView.getParent().requestDisallowInterceptTouchEvent(false);
            this.eGu.A("isTouching", false);
            if (this.eGu.containsKey("disableScroll-nextState")) {
              this.eGu.A("disableScroll", this.eGu.getBoolean("disableScroll-nextState", bool5));
            }
            if (!t.aw(paramView)) {
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
            paramMotionEvent = y(paramMotionEvent);
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
            a(this.bDN, new d.b(), paramView.toString());
            label1265:
            this.ieW.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.c.a
 * JD-Core Version:    0.7.0.1
 */