package com.tencent.g.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public Object umJ = new Object();
  public HashMap<String, Object> xcl = new HashMap();
  c xcm;
  
  public final void a(d paramd, String[] paramArrayOfString)
  {
    if ((paramd == null) || (paramArrayOfString == null)) {
      return;
    }
    for (;;)
    {
      int i;
      Object localObject2;
      Object localObject3;
      synchronized (this.umJ)
      {
        int j = paramArrayOfString.length;
        i = 0;
        if (i >= j) {
          break label178;
        }
        localObject2 = paramArrayOfString[i];
        if (localObject2 == null) {
          break label182;
        }
        localObject3 = this.xcl.get(localObject2);
        if (localObject3 == null)
        {
          this.xcl.put(localObject2, paramd);
          break label182;
        }
        if (!(localObject3 instanceof d)) {
          break label140;
        }
        localObject3 = (d)localObject3;
        if (localObject3 == paramd) {
          return;
        }
      }
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localObject3);
      localLinkedList.add(paramd);
      this.xcl.put(localObject2, localLinkedList);
      break label182;
      label140:
      if ((localObject3 instanceof List))
      {
        localObject2 = (LinkedList)localObject3;
        if (((LinkedList)localObject2).indexOf(paramd) >= 0) {
          return;
        }
        ((LinkedList)localObject2).add(paramd);
        break label182;
        label178:
        return;
      }
      label182:
      i += 1;
    }
  }
  
  public final void c(String arg1, int paramInt, Object paramObject)
  {
    Object localObject2 = this.xcm;
    Object localObject1 = ((com.tencent.g.d)localObject2).cRf();
    if (localObject1 == null)
    {
      localObject1 = ((com.tencent.g.d)localObject2).cRe();
      localObject1 = (e)localObject1;
      ((e)localObject1).bSM = ???;
      ((e)localObject1).xco = paramInt;
      ((e)localObject1).arg1 = 0;
      ((e)localObject1).arg2 = 0;
      ((e)localObject1).obj = paramObject;
      if ((localObject1 != null) && (((e)localObject1).bSM != null))
      {
        System.currentTimeMillis();
        localObject2 = ((e)localObject1).bSM;
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.umJ)
        {
          ??? = this.xcl.get(localObject2);
          if (??? == null) {
            break label279;
          }
          if ((??? instanceof d))
          {
            ??? = (d)???;
            paramObject = null;
            if (??? != null) {
              ???.dX((String)localObject2, ((e)localObject1).xco);
            }
            if (paramObject == null) {
              break label224;
            }
            ??? = paramObject.iterator();
            if (!???.hasNext()) {
              break label224;
            }
            ((d)???.next()).dX((String)localObject2, ((e)localObject1).xco);
            continue;
            ((com.tencent.g.e)localObject1).reset();
            break;
          }
          if (!(??? instanceof List)) {
            break label279;
          }
          paramObject = (LinkedList)((LinkedList)???).clone();
          ??? = null;
        }
        label224:
        paramObject = this.xcm;
        synchronized (paramObject.mLock)
        {
          paramInt = paramObject.xbX.length;
          if (paramObject.ofu < paramInt)
          {
            paramObject.xbX[paramObject.ofu] = localObject1;
            paramObject.ofu += 1;
          }
          return;
        }
        label279:
        ??? = null;
        paramObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.g.a.a
 * JD-Core Version:    0.7.0.1
 */