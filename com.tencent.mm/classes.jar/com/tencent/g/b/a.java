package com.tencent.g.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.g.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a
{
  private static final h<a> ahVU;
  public final Map<Integer, Set<b>> ahVS;
  private final Map<Integer, Set<Object>> ahVT;
  
  static
  {
    AppMethodBeat.i(212101);
    ahVU = new h() {};
    AppMethodBeat.o(212101);
  }
  
  public a()
  {
    AppMethodBeat.i(212064);
    this.ahVS = new HashMap();
    this.ahVT = new HashMap();
    AppMethodBeat.o(212064);
  }
  
  public static Object b(Class<?> paramClass, String paramString, Object paramObject)
  {
    AppMethodBeat.i(212081);
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass = paramClass.get(paramObject);
      return paramClass;
    }
    finally
    {
      AppMethodBeat.o(212081);
    }
    return null;
  }
  
  public static a kcP()
  {
    AppMethodBeat.i(212069);
    a locala = (a)ahVU.get();
    AppMethodBeat.o(212069);
    return locala;
  }
  
  public static Object mL(View paramView)
  {
    AppMethodBeat.i(212090);
    try
    {
      Method localMethod = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
      localMethod.setAccessible(true);
      paramView = localMethod.invoke(paramView, new Object[0]);
      return paramView;
    }
    finally
    {
      AppMethodBeat.o(212090);
    }
    return null;
  }
  
  public final class a
    implements View.OnTouchListener
  {
    private final View.OnTouchListener pYP;
    
    public a(View.OnTouchListener paramOnTouchListener)
    {
      this.pYP = paramOnTouchListener;
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(212071);
      if ((a.a(a.this) != null) && (!a.a(a.this).isEmpty()))
      {
        Iterator localIterator = ((Set)a.a(a.this).get(Integer.valueOf(paramView.hashCode()))).iterator();
        while (localIterator.hasNext()) {
          ((b)localIterator.next()).onTouch(paramView, paramMotionEvent);
        }
      }
      if (this.pYP != null)
      {
        boolean bool = this.pYP.onTouch(paramView, paramMotionEvent);
        AppMethodBeat.o(212071);
        return bool;
      }
      AppMethodBeat.o(212071);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.g.b.a
 * JD-Core Version:    0.7.0.1
 */