package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public static void a(ViewGroup paramViewGroup, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140690);
    int j = paramViewGroup.getChildCount();
    int i = paramMotionEvent.getActionIndex();
    if (paramViewGroup.isMotionEventSplittingEnabled())
    {
      i = 1 << paramMotionEvent.getPointerId(i);
      j -= 1;
    }
    for (;;)
    {
      if (j < 0) {
        break label142;
      }
      View localView = paramViewGroup.getChildAt(j);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((AppBrandViewMotionCompat.dh(localView)) && (AppBrandViewMotionCompat.a(paramViewGroup, f1, f2, localView)) && (localView.isDuplicateParentStateEnabled()))
      {
        a(paramViewGroup, paramMotionEvent, localView, i);
        if (((localView instanceof f)) && (((f)localView).bQC()))
        {
          AppMethodBeat.o(140690);
          return;
          i = -1;
          break;
        }
      }
      j -= 1;
    }
    label142:
    AppMethodBeat.o(140690);
  }
  
  public static boolean a(ViewGroup paramViewGroup, MotionEvent paramMotionEvent, View paramView, int paramInt)
  {
    AppMethodBeat.i(140691);
    if (paramView == null)
    {
      Log.v("MicroMsg.ViewMotionHelper", "child is null.");
      AppMethodBeat.o(140691);
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i == 3)
    {
      paramMotionEvent.setAction(3);
      bool = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.setAction(i);
      AppMethodBeat.o(140691);
      return bool;
    }
    i = AppBrandViewMotionCompat.K(paramMotionEvent);
    paramInt = i & paramInt;
    if (paramInt == 0)
    {
      Log.v("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
      AppMethodBeat.o(140691);
      return false;
    }
    boolean bool = AppBrandViewMotionCompat.di(paramView);
    Object localObject;
    if (paramInt == i)
    {
      if (bool)
      {
        float f1 = paramViewGroup.getScrollX() - paramView.getLeft();
        float f2 = paramViewGroup.getScrollY() - paramView.getTop();
        paramMotionEvent.offsetLocation(f1, f2);
        bool = paramView.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.offsetLocation(-f1, -f2);
        AppMethodBeat.o(140691);
        return bool;
      }
      localObject = MotionEvent.obtain(paramMotionEvent);
    }
    for (;;)
    {
      ((MotionEvent)localObject).offsetLocation(paramViewGroup.getScrollX() - paramView.getLeft(), paramViewGroup.getScrollY() - paramView.getTop());
      if (!bool) {
        ((MotionEvent)localObject).transform(AppBrandViewMotionCompat.dj(paramView));
      }
      bool = paramView.dispatchTouchEvent((MotionEvent)localObject);
      ((MotionEvent)localObject).recycle();
      AppMethodBeat.o(140691);
      return bool;
      MotionEvent localMotionEvent = AppBrandViewMotionCompat.g(paramMotionEvent, paramInt);
      localObject = localMotionEvent;
      if (localMotionEvent == null) {
        localObject = MotionEvent.obtain(paramMotionEvent);
      }
    }
  }
  
  public static f cO(View paramView)
  {
    AppMethodBeat.i(140689);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = new f(0, arrayOfInt[0], arrayOfInt[1]);
    AppMethodBeat.o(140689);
    return paramView;
  }
  
  public static final class a
    extends az
  {
    private static final int CTRL_INDEX = 137;
    public static final String NAME = "onLongPress";
  }
  
  public static final class b
    extends az
  {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "onTouchCancel";
  }
  
  public static final class c
    extends az
  {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "onTouchStart";
  }
  
  public static final class d
    extends az
  {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "onTouchMove";
  }
  
  public static final class e
    extends az
  {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "onTouchEnd";
  }
  
  public static final class f
  {
    public int id;
    public float x;
    public float y;
    
    public f() {}
    
    public f(int paramInt, float paramFloat1, float paramFloat2)
    {
      this.id = paramInt;
      this.x = paramFloat1;
      this.y = paramFloat2;
    }
    
    public final void b(int paramInt, float paramFloat1, float paramFloat2)
    {
      this.id = paramInt;
      this.x = paramFloat1;
      this.y = paramFloat2;
    }
    
    public final JSONObject toJSONObject()
    {
      AppMethodBeat.i(140687);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("id", this.id);
        localJSONObject.put("x", g.aT(this.x));
        localJSONObject.put("y", g.aT(this.y));
        label54:
        AppMethodBeat.o(140687);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        break label54;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(140688);
      String str = toJSONObject().toString();
      AppMethodBeat.o(140688);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.e
 * JD-Core Version:    0.7.0.1
 */