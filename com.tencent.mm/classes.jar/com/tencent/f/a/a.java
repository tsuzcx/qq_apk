package com.tencent.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private Object acBH;
  private HashMap<String, Object> ahVf;
  c ahVg;
  
  public a()
  {
    AppMethodBeat.i(62812);
    this.ahVf = new HashMap();
    this.acBH = new Object();
    AppMethodBeat.o(62812);
  }
  
  private void a(e parame)
  {
    AppMethodBeat.i(62815);
    String str;
    if ((parame != null) && (parame.topic != null))
    {
      System.currentTimeMillis();
      str = parame.topic;
    }
    for (;;)
    {
      synchronized (this.acBH)
      {
        localObject1 = this.ahVf.get(str);
        if (localObject1 == null) {
          break label171;
        }
        if ((localObject1 instanceof d))
        {
          locald = (d)localObject1;
          localObject1 = null;
          if (locald != null) {
            locald.jD(str, parame.ahVi);
          }
          if (localObject1 != null)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              ((d)((Iterator)localObject1).next()).jD(str, parame.ahVi);
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
      this.ahVg.a(parame);
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
      synchronized (this.acBH)
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
        localObject3 = this.ahVf.get(localObject2);
        if (localObject3 == null)
        {
          this.ahVf.put(localObject2, paramd);
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
          this.ahVf.put(localObject2, localLinkedList);
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
    e locale = (e)this.ahVg.kcL();
    locale.topic = paramString;
    locale.ahVi = paramInt;
    locale.ahVj = 0;
    locale.OyS = 0;
    locale.obj = paramObject;
    a(locale);
    AppMethodBeat.o(62814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.f.a.a
 * JD-Core Version:    0.7.0.1
 */