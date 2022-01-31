package com.tencent.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private HashMap<String, Object> ByR;
  c ByS;
  private Object ywp;
  
  public a()
  {
    AppMethodBeat.i(127742);
    this.ByR = new HashMap();
    this.ywp = new Object();
    AppMethodBeat.o(127742);
  }
  
  private void a(e parame)
  {
    AppMethodBeat.i(127745);
    String str;
    if ((parame != null) && (parame.cAr != null))
    {
      System.currentTimeMillis();
      str = parame.cAr;
    }
    for (;;)
    {
      synchronized (this.ywp)
      {
        localObject1 = this.ByR.get(str);
        if (localObject1 == null) {
          break label171;
        }
        if ((localObject1 instanceof d))
        {
          locald = (d)localObject1;
          localObject1 = null;
          if (locald != null) {
            locald.fg(str, parame.ByU);
          }
          if (localObject1 != null)
          {
            localObject1 = ((LinkedList)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              ((d)((Iterator)localObject1).next()).fg(str, parame.ByU);
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
      this.ByS.a(parame);
      AppMethodBeat.o(127745);
      return;
      label171:
      Object localObject1 = null;
      d locald = null;
    }
  }
  
  public final void a(d paramd, String[] paramArrayOfString)
  {
    AppMethodBeat.i(127743);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(127743);
      return;
    }
    for (;;)
    {
      int i;
      Object localObject2;
      Object localObject3;
      synchronized (this.ywp)
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
        localObject3 = this.ByR.get(localObject2);
        if (localObject3 == null)
        {
          this.ByR.put(localObject2, paramd);
        }
        else if ((localObject3 instanceof d))
        {
          localObject3 = (d)localObject3;
          if (localObject3 == paramd)
          {
            AppMethodBeat.o(127743);
            return;
          }
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(localObject3);
          localLinkedList.add(paramd);
          this.ByR.put(localObject2, localLinkedList);
        }
      }
      if ((localObject3 instanceof List))
      {
        localObject2 = (LinkedList)localObject3;
        if (((LinkedList)localObject2).indexOf(paramd) >= 0)
        {
          AppMethodBeat.o(127743);
          return;
        }
        ((LinkedList)localObject2).add(paramd);
        break label208;
        label199:
        AppMethodBeat.o(127743);
        return;
      }
      label208:
      i += 1;
    }
  }
  
  public final void b(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(127744);
    e locale = (e)this.ByS.dWU();
    locale.cAr = paramString;
    locale.ByU = paramInt;
    locale.arg1 = 0;
    locale.arg2 = 0;
    locale.obj = paramObject;
    a(locale);
    AppMethodBeat.o(127744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.h.a.a
 * JD-Core Version:    0.7.0.1
 */