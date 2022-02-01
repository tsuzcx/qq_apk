package com.tencent.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private Object GzG;
  private HashMap<String, Object> Kuf;
  c Kug;
  
  public a()
  {
    AppMethodBeat.i(62812);
    this.Kuf = new HashMap();
    this.GzG = new Object();
    AppMethodBeat.o(62812);
  }
  
  private void a(e parame)
  {
    AppMethodBeat.i(62815);
    String str;
    if ((parame != null) && (parame.dol != null))
    {
      System.currentTimeMillis();
      str = parame.dol;
    }
    for (;;)
    {
      synchronized (this.GzG)
      {
        localObject1 = this.Kuf.get(str);
        if (localObject1 == null) {
          break label171;
        }
        if ((localObject1 instanceof d))
        {
          locald = (d)localObject1;
          localObject1 = null;
          if (locald != null) {
            locald.gF(str, parame.Kui);
          }
          if (localObject1 != null)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              ((d)((Iterator)localObject1).next()).gF(str, parame.Kui);
              continue;
            }
          }
        }
        else
        {
          if (!(localObject1 instanceof List)) {
            break label171;
          }
          localObject1 = (LinkedList)((LinkedList)localObject1).clone();
          locald = null;
        }
      }
      this.Kug.a(parame);
      AppMethodBeat.o(62815);
      return;
      label171:
      Object localObject1 = null;
      d locald = null;
    }
  }
  
  public final void a(d paramd, String[] paramArrayOfString)
  {
    AppMethodBeat.i(62813);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(62813);
      return;
    }
    for (;;)
    {
      int i;
      Object localObject2;
      Object localObject3;
      synchronized (this.GzG)
      {
        int j = paramArrayOfString.length;
        i = 0;
        if (i >= j) {
          break label199;
        }
        localObject2 = paramArrayOfString[i];
        if (localObject2 == null) {
          break label208;
        }
        localObject3 = this.Kuf.get(localObject2);
        if (localObject3 == null)
        {
          this.Kuf.put(localObject2, paramd);
        }
        else if ((localObject3 instanceof d))
        {
          localObject3 = (d)localObject3;
          if (localObject3 == paramd)
          {
            AppMethodBeat.o(62813);
            return;
          }
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(localObject3);
          localLinkedList.add(paramd);
          this.Kuf.put(localObject2, localLinkedList);
        }
      }
      if ((localObject3 instanceof List))
      {
        localObject2 = (LinkedList)localObject3;
        if (((LinkedList)localObject2).indexOf(paramd) >= 0)
        {
          AppMethodBeat.o(62813);
          return;
        }
        ((LinkedList)localObject2).add(paramd);
        break label208;
        label199:
        AppMethodBeat.o(62813);
        return;
      }
      label208:
      i += 1;
    }
  }
  
  public final void b(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(62814);
    e locale = (e)this.Kug.fHw();
    locale.dol = paramString;
    locale.Kui = paramInt;
    locale.arg1 = 0;
    locale.arg2 = 0;
    locale.obj = paramObject;
    a(locale);
    AppMethodBeat.o(62814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.f.a.a
 * JD-Core Version:    0.7.0.1
 */