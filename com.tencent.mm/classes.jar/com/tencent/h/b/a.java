package com.tencent.h.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.h.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a
{
  private static final g<a> SpT;
  public final Map<Integer, Set<b>> SpR;
  private final Map<Integer, Set<Object>> SpS;
  
  static
  {
    AppMethodBeat.i(214613);
    SpT = new g() {};
    AppMethodBeat.o(214613);
  }
  
  public a()
  {
    AppMethodBeat.i(214609);
    this.SpR = new HashMap();
    this.SpS = new HashMap();
    AppMethodBeat.o(214609);
  }
  
  public static Object c(Class<?> paramClass, String paramString, Object paramObject)
  {
    AppMethodBeat.i(214611);
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass = paramClass.get(paramObject);
      AppMethodBeat.o(214611);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      AppMethodBeat.o(214611);
    }
    return null;
  }
  
  public static Object hO(View paramView)
  {
    AppMethodBeat.i(214612);
    try
    {
      Method localMethod = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
      localMethod.setAccessible(true);
      paramView = localMethod.invoke(paramView, new Object[0]);
      AppMethodBeat.o(214612);
      return paramView;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(214612);
    }
    return null;
  }
  
  public static a hpS()
  {
    AppMethodBeat.i(214610);
    a locala = (a)SpT.get();
    AppMethodBeat.o(214610);
    return locala;
  }
  
  public final class a
    implements View.OnTouchListener
  {
    private final View.OnTouchListener kjS;
    
    public a(View.OnTouchListener paramOnTouchListener)
    {
      this.kjS = paramOnTouchListener;
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(214608);
      if ((a.a(a.this) != null) && (!a.a(a.this).isEmpty()))
      {
        Iterator localIterator = ((Set)a.a(a.this).get(Integer.valueOf(paramView.hashCode()))).iterator();
        while (localIterator.hasNext()) {
          ((b)localIterator.next()).onTouch(paramView, paramMotionEvent);
        }
      }
      if (this.kjS != null)
      {
        boolean bool = this.kjS.onTouch(paramView, paramMotionEvent);
        AppMethodBeat.o(214608);
        return bool;
      }
      AppMethodBeat.o(214608);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.h.b.a
 * JD-Core Version:    0.7.0.1
 */