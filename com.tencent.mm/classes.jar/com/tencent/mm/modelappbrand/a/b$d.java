package com.tencent.mm.modelappbrand.a;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b$d
{
  private final ah eav;
  final Map<String, List<b.d.a>> eaw = new HashMap();
  final Map<String, Boolean> eax = new HashMap();
  
  private b$d(ah paramah)
  {
    this.eav = paramah;
  }
  
  final void a(String paramString, b.d.a parama)
  {
    if ((bk.bl(paramString)) || (parama == null)) {}
    do
    {
      return;
      paramString = (List)this.eaw.get(paramString);
    } while (paramString == null);
    paramString.remove(parama);
  }
  
  final void f(Runnable paramRunnable)
  {
    this.eav.post(paramRunnable);
  }
  
  final void jL(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return;
      paramString = (List)this.eaw.remove(paramString);
      if (!bk.dk(paramString))
      {
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          ((b.d.a)paramString.next()).JI();
        }
      }
    }
  }
  
  public final boolean jM(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return this.eax.containsKey(paramString);
  }
  
  final void jN(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    this.eax.remove(paramString);
  }
  
  final void jO(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return;
      paramString = (List)this.eaw.remove(paramString);
    } while (bk.dk(paramString));
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext()) {
      ((b.d.a)localIterator.next()).JJ();
    }
    paramString.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.d
 * JD-Core Version:    0.7.0.1
 */