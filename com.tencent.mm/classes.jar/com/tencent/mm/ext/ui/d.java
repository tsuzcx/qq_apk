package com.tencent.mm.ext.ui;

import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<WeakReference<a>> jRe;
  
  static
  {
    AppMethodBeat.i(258938);
    jRe = new LinkedList();
    AppMethodBeat.o(258938);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(258934);
    b.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", new Object[] { Integer.valueOf(jRe.size()), parama });
    parama = new WeakReference(parama);
    jRe.add(0, parama);
    AppMethodBeat.o(258934);
  }
  
  public static void ap(float paramFloat)
  {
    AppMethodBeat.i(258936);
    if (jRe.size() <= 0)
    {
      b.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(258936);
      return;
    }
    a locala = (a)((WeakReference)jRe.get(0)).get();
    if (locala == null)
    {
      b.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(258936);
      return;
    }
    locala.onSwipe(paramFloat);
    b.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", new Object[] { Float.valueOf(paramFloat), locala });
    AppMethodBeat.o(258936);
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(258935);
    int j = jRe.size();
    b.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", new Object[] { Integer.valueOf(j), parama });
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    for (;;)
    {
      if (i < jRe.size())
      {
        if (parama == ((WeakReference)jRe.get(i)).get())
        {
          jRe.remove(i);
          b.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        if (localLinkedList.size() != j) {
          break;
        }
        b.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity", new Object[0]);
        AppMethodBeat.o(258935);
        return false;
      }
      localLinkedList.add(0, Integer.valueOf(i));
      i += 1;
    }
    Iterator localIterator = localLinkedList.iterator();
    if (localIterator.hasNext())
    {
      parama = (Integer)localIterator.next();
      parama = (WeakReference)jRe.remove(parama.intValue());
      if (parama != null) {}
      for (parama = parama.get();; parama = "NULL-CALLBACK")
      {
        b.d("MicroMsg.SwipeBackHelper", "popCallback, popup %s", new Object[] { parama });
        break;
      }
    }
    boolean bool = localLinkedList.isEmpty();
    AppMethodBeat.o(258935);
    return bool;
  }
  
  public static void j(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(258937);
    if (jRe.size() <= 0)
    {
      b.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      AppMethodBeat.o(258937);
      return;
    }
    a locala = (a)((WeakReference)jRe.get(0)).get();
    if (locala == null)
    {
      b.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      AppMethodBeat.o(258937);
      return;
    }
    locala.onSettle(paramBoolean, paramInt);
    b.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), locala });
    AppMethodBeat.o(258937);
  }
  
  public static abstract interface a
  {
    public abstract void onSettle(boolean paramBoolean, int paramInt);
    
    public abstract void onSwipe(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ext.ui.d
 * JD-Core Version:    0.7.0.1
 */