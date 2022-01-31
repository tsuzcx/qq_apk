package com.tencent.mm.app;

import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

final class a$a
  extends Error
{
  LinkedList<Pair<Thread, StackTraceElement[]>> bXc;
  
  private a$a(a.a.a.a parama, LinkedList<Pair<Thread, StackTraceElement[]>> paramLinkedList)
  {
    super("Application Not Responding", parama);
    this.bXc = paramLinkedList;
  }
  
  static a AW()
  {
    AppMethodBeat.i(15354);
    Object localObject2 = Looper.getMainLooper().getThread();
    StackTraceElement[] arrayOfStackTraceElement = ((Thread)localObject2).getStackTrace();
    if (arrayOfStackTraceElement == null) {}
    for (int i = -1;; i = arrayOfStackTraceElement.length)
    {
      ab.i("MicroMsg.ANRError", "summeranr NewMainOnly mainStackTrace size[%d]", new Object[] { Integer.valueOf(i) });
      new TreeMap().put(localObject2, arrayOfStackTraceElement);
      Object localObject1 = new LinkedList();
      ((LinkedList)localObject1).addFirst(new Pair(localObject2, arrayOfStackTraceElement));
      localObject2 = new a(a((Thread)localObject2), arrayOfStackTraceElement, (byte)0);
      localObject2.getClass();
      localObject1 = new a(new a.a.a.a((a)localObject2, null, (byte)0), (LinkedList)localObject1);
      AppMethodBeat.o(15354);
      return localObject1;
    }
  }
  
  private static String a(Thread paramThread)
  {
    AppMethodBeat.i(15355);
    paramThread = paramThread.getName() + " (prio:" + paramThread.getPriority() + " tid:" + paramThread.getId() + " state:" + paramThread.getState() + ")";
    AppMethodBeat.o(15355);
    return paramThread;
  }
  
  static a k(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(15353);
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
      ab.i("MicroMsg.ANRError", "summeranr getAllStackTraces not return mainthread[%s, %d] put in now", new Object[] { ((Thread)localObject1).getName(), Long.valueOf(((Thread)localObject1).getId()) });
      ((Map)localObject2).put(localObject1, ((Thread)localObject1).getStackTrace());
      localLinkedList.addFirst(new Pair(localObject1, ((Thread)localObject1).getStackTrace()));
    }
    localObject1 = ((Map)localObject2).entrySet().iterator();
    for (paramString = null; ((Iterator)localObject1).hasNext(); paramString = new a.a.a.a((a)localObject2, paramString, (byte)0))
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = new a(a((Thread)((Map.Entry)localObject2).getKey()), (StackTraceElement[])((Map.Entry)localObject2).getValue(), (byte)0);
      localObject2.getClass();
    }
    paramString = new a(paramString, localLinkedList);
    AppMethodBeat.o(15353);
    return paramString;
  }
  
  public final Throwable fillInStackTrace()
  {
    AppMethodBeat.i(15352);
    super.fillInStackTrace();
    AppMethodBeat.o(15352);
    return this;
  }
  
  static final class a
    implements Serializable
  {
    final StackTraceElement[] bXe;
    final String name;
    
    private a(String paramString, StackTraceElement[] paramArrayOfStackTraceElement)
    {
      this.name = paramString;
      this.bXe = paramArrayOfStackTraceElement;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.a.a
 * JD-Core Version:    0.7.0.1
 */