package com.tencent.mm.app;

import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

final class a$a
  extends Error
{
  LinkedList<Pair<Thread, StackTraceElement[]>> bvR;
  
  private a$a(a.a.a.a parama, LinkedList<Pair<Thread, StackTraceElement[]>> paramLinkedList)
  {
    super("Application Not Responding", parama);
    this.bvR = paramLinkedList;
  }
  
  private static String a(Thread paramThread)
  {
    return paramThread.getName() + " (prio:" + paramThread.getPriority() + " tid:" + paramThread.getId() + " state:" + paramThread.getState() + ")";
  }
  
  static a i(String paramString, boolean paramBoolean)
  {
    Object localObject1 = Looper.getMainLooper().getThread();
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = new TreeMap(new a.a.1((Thread)localObject1));
    Iterator localIterator = Thread.getAllStackTraces().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((localEntry.getKey() == localObject1) || ((((Thread)localEntry.getKey()).getName().startsWith(paramString)) && ((paramBoolean) || (((StackTraceElement[])localEntry.getValue()).length > 0)))) && (localEntry.getValue() != null) && (((StackTraceElement[])localEntry.getValue()).length > 0))
      {
        ((Map)localObject2).put(localEntry.getKey(), localEntry.getValue());
        if (localEntry.getKey() == localObject1) {
          localLinkedList.addFirst(new Pair(localObject1, localEntry.getValue()));
        } else {
          localLinkedList.addLast(new Pair(localEntry.getKey(), localEntry.getValue()));
        }
      }
    }
    if (!((Map)localObject2).containsKey(localObject1))
    {
      y.i("MicroMsg.ANRError", "summeranr getAllStackTraces not return mainthread[%s, %d] put in now", new Object[] { ((Thread)localObject1).getName(), Long.valueOf(((Thread)localObject1).getId()) });
      ((Map)localObject2).put(localObject1, ((Thread)localObject1).getStackTrace());
      localLinkedList.addFirst(new Pair(localObject1, ((Thread)localObject1).getStackTrace()));
    }
    localObject1 = ((Map)localObject2).entrySet().iterator();
    for (paramString = null; ((Iterator)localObject1).hasNext(); paramString = new a.a.a.a((a.a.a)localObject2, paramString, (byte)0))
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = new a.a.a(a((Thread)((Map.Entry)localObject2).getKey()), (StackTraceElement[])((Map.Entry)localObject2).getValue(), (byte)0);
      localObject2.getClass();
    }
    return new a(paramString, localLinkedList);
  }
  
  static a sF()
  {
    Object localObject = Looper.getMainLooper().getThread();
    StackTraceElement[] arrayOfStackTraceElement = ((Thread)localObject).getStackTrace();
    if (arrayOfStackTraceElement == null) {}
    for (int i = -1;; i = arrayOfStackTraceElement.length)
    {
      y.i("MicroMsg.ANRError", "summeranr NewMainOnly mainStackTrace size[%d]", new Object[] { Integer.valueOf(i) });
      new TreeMap().put(localObject, arrayOfStackTraceElement);
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addFirst(new Pair(localObject, arrayOfStackTraceElement));
      localObject = new a.a.a(a((Thread)localObject), arrayOfStackTraceElement, (byte)0);
      localObject.getClass();
      return new a(new a.a.a.a((a.a.a)localObject, null, (byte)0), localLinkedList);
    }
  }
  
  public final Throwable fillInStackTrace()
  {
    super.fillInStackTrace();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.a.a
 * JD-Core Version:    0.7.0.1
 */