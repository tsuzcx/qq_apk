package com.tencent.matrix.resource.d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a$c
  extends d
{
  public a$c(a parama)
  {
    super(null);
  }
  
  public final void XJ()
  {
    Object localObject1 = this.ddk.dcX.entrySet();
    HashMap localHashMap = new HashMap();
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      com.tencent.matrix.resource.d.a.b localb1 = (com.tencent.matrix.resource.d.a.b)((Map.Entry)localObject2).getKey();
      localObject2 = (byte[])((Map.Entry)localObject2).getValue();
      if (this.ddk.dcW.contains(localb1))
      {
        localObject2 = com.tencent.matrix.resource.a.a.a.getMD5String((byte[])localObject2);
        com.tencent.matrix.resource.d.a.b localb2 = (com.tencent.matrix.resource.d.a.b)localHashMap.get(localObject2);
        if (localb2 == null)
        {
          localHashMap.put(localObject2, localb1);
        }
        else
        {
          this.ddk.dcY.put(localb2, localb2);
          this.ddk.dcY.put(localb1, localb2);
        }
      }
    }
    this.ddk.dcX.clear();
  }
  
  public final b b(int paramInt1, int paramInt2, long paramLong)
  {
    return new a.c.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.d.a.c
 * JD-Core Version:    0.7.0.1
 */