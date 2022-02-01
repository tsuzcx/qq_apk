package com.tencent.mm.ext.ui;

import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static LinkedList<WeakReference<a>> mqo;
  
  static
  {
    AppMethodBeat.i(235361);
    mqo = new LinkedList();
    AppMethodBeat.o(235361);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(235335);
    b.d("MicroMsg.SwipeBackHelper", "pushCallback size %d, %s", new Object[] { Integer.valueOf(mqo.size()), parama });
    parama = new WeakReference(parama);
    mqo.add(0, parama);
    AppMethodBeat.o(235335);
  }
  
  public static boolean b(a parama)
  {
    AppMethodBeat.i(235343);
    int j = mqo.size();
    b.d("MicroMsg.SwipeBackHelper", "popCallback size %d, %s", new Object[] { Integer.valueOf(j), parama });
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    for (;;)
    {
      if (i < mqo.size())
      {
        if (parama == ((WeakReference)mqo.get(i)).get())
        {
          mqo.remove(i);
          b.d("MicroMsg.SwipeBackHelper", "popCallback directly, index %d", new Object[] { Integer.valueOf(i) });
        }
      }
      else
      {
        if ((parama.forceRemoveNoMatchOnPath()) || (localLinkedList.size() != j)) {
          break;
        }
        b.d("MicroMsg.SwipeBackHelper", "popCallback Fail! Maybe Top Activity", new Object[0]);
        AppMethodBeat.o(235343);
        return false;
      }
      localLinkedList.add(0, Integer.valueOf(i));
      i += 1;
    }
    Iterator localIterator = localLinkedList.iterator();
    if (localIterator.hasNext())
    {
      parama = (Integer)localIterator.next();
      parama = (WeakReference)mqo.remove(parama.intValue());
      if (parama != null) {}
      for (parama = parama.get();; parama = "NULL-CALLBACK")
      {
        b.d("MicroMsg.SwipeBackHelper", "popCallback, popup %s", new Object[] { parama });
        break;
      }
    }
    boolean bool = localLinkedList.isEmpty();
    AppMethodBeat.o(235343);
    return bool;
  }
  
  public static void bk(float paramFloat)
  {
    AppMethodBeat.i(235347);
    if (mqo.size() <= 0)
    {
      b.w("MicroMsg.SwipeBackHelper", "notifySwipe callback stack empty!, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(235347);
      return;
    }
    a locala = (a)((WeakReference)mqo.get(0)).get();
    if (locala == null)
    {
      b.w("MicroMsg.SwipeBackHelper", "notifySwipe null, scrollParent:%f", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(235347);
      return;
    }
    locala.onSwipe(paramFloat);
    b.v("MicroMsg.SwipeBackHelper", "notifySwipe scrollParent:%f, callback:%s ", new Object[] { Float.valueOf(paramFloat), locala });
    AppMethodBeat.o(235347);
  }
  
  public static void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(235356);
    if (mqo.size() <= 0)
    {
      b.w("MicroMsg.SwipeBackHelper", "notifySettle callback stack empty!, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      AppMethodBeat.o(235356);
      return;
    }
    a locala = (a)((WeakReference)mqo.get(0)).get();
    if (locala == null)
    {
      b.w("MicroMsg.SwipeBackHelper", "notifySettle null, open:%B, speed:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      AppMethodBeat.o(235356);
      return;
    }
    locala.onSettle(paramBoolean, paramInt);
    b.v("MicroMsg.SwipeBackHelper", "notifySettle, open:%B speed:%d callback:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), locala });
    AppMethodBeat.o(235356);
  }
  
  public static abstract interface a
  {
    public abstract boolean forceRemoveNoMatchOnPath();
    
    public abstract void onSettle(boolean paramBoolean, int paramInt);
    
    public abstract void onSwipe(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ext.ui.d
 * JD-Core Version:    0.7.0.1
 */