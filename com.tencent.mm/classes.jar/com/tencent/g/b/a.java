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
  private static final h<a> ZRy;
  public final Map<Integer, Set<b>> ZRw;
  private final Map<Integer, Set<Object>> ZRx;
  
  static
  {
    AppMethodBeat.i(208622);
    ZRy = new h() {};
    AppMethodBeat.o(208622);
  }
  
  public a()
  {
    AppMethodBeat.i(208614);
    this.ZRw = new HashMap();
    this.ZRx = new HashMap();
    AppMethodBeat.o(208614);
  }
  
  public static Object c(Class<?> paramClass, String paramString, Object paramObject)
  {
    AppMethodBeat.i(208617);
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass = paramClass.get(paramObject);
      AppMethodBeat.o(208617);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      AppMethodBeat.o(208617);
    }
    return null;
  }
  
  public static a itx()
  {
    AppMethodBeat.i(208615);
    a locala = (a)ZRy.get();
    AppMethodBeat.o(208615);
    return locala;
  }
  
  public static Object jh(View paramView)
  {
    AppMethodBeat.i(208619);
    try
    {
      Method localMethod = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
      localMethod.setAccessible(true);
      paramView = localMethod.invoke(paramView, new Object[0]);
      AppMethodBeat.o(208619);
      return paramView;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(208619);
    }
    return null;
  }
  
  public final class a
    implements View.OnTouchListener
  {
    private final View.OnTouchListener nbI;
    
    public a(View.OnTouchListener paramOnTouchListener)
    {
      this.nbI = paramOnTouchListener;
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(207788);
      if ((a.a(a.this) != null) && (!a.a(a.this).isEmpty()))
      {
        Iterator localIterator = ((Set)a.a(a.this).get(Integer.valueOf(paramView.hashCode()))).iterator();
        while (localIterator.hasNext()) {
          ((b)localIterator.next()).onTouch(paramView, paramMotionEvent);
        }
      }
      if (this.nbI != null)
      {
        boolean bool = this.nbI.onTouch(paramView, paramMotionEvent);
        AppMethodBeat.o(207788);
        return bool;
      }
      AppMethodBeat.o(207788);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.b.a
 * JD-Core Version:    0.7.0.1
 */