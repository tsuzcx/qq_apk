package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e
  implements u.c
{
  private final List<Format> aDA;
  private final int flags;
  
  public e()
  {
    this((byte)0);
  }
  
  public e(byte paramByte)
  {
    this(0, Collections.emptyList());
  }
  
  public e(int paramInt, List<Format> paramList)
  {
    this.flags = paramInt;
    Object localObject = paramList;
    if (!isSet(32))
    {
      localObject = paramList;
      if (paramList.isEmpty()) {
        localObject = Collections.singletonList(Format.ah("application/cea-608"));
      }
    }
    this.aDA = ((List)localObject);
  }
  
  private r a(u.b paramb)
  {
    if (isSet(32)) {
      return new r(this.aDA);
    }
    com.google.android.exoplayer2.i.j localj = new com.google.android.exoplayer2.i.j(paramb.aFD);
    paramb = this.aDA;
    while (localj.oe() > 0)
    {
      int i = localj.readUnsignedByte();
      int k = localj.readUnsignedByte();
      int m = localj.position;
      if (i == 134)
      {
        ArrayList localArrayList = new ArrayList();
        int n = localj.readUnsignedByte();
        i = 0;
        if (i < (n & 0x1F))
        {
          String str = localj.readString(3);
          int i1 = localj.readUnsignedByte();
          if ((i1 & 0x80) != 0)
          {
            j = 1;
            label127:
            if (j == 0) {
              break label175;
            }
            paramb = "application/cea-708";
          }
          for (int j = i1 & 0x3F;; j = 1)
          {
            localArrayList.add(Format.a(null, paramb, 0, str, j));
            localj.dB(2);
            i += 1;
            break;
            j = 0;
            break label127;
            label175:
            paramb = "application/cea-608";
          }
        }
        paramb = localArrayList;
      }
      localj.setPosition(m + k);
    }
    return new r(paramb);
  }
  
  private boolean isSet(int paramInt)
  {
    return (this.flags & paramInt) != 0;
  }
  
  public final u a(int paramInt, u.b paramb)
  {
    switch (paramInt)
    {
    default: 
    case 3: 
    case 4: 
    case 15: 
    case 129: 
    case 135: 
    case 130: 
    case 138: 
    case 2: 
    case 27: 
    case 36: 
    case 134: 
      do
      {
        do
        {
          do
          {
            return null;
            return new o(new m(paramb.auI));
          } while (isSet(2));
          return new o(new d(false, paramb.auI));
          return new o(new b(paramb.auI));
          return new o(new f(paramb.auI));
          return new o(new i());
        } while (isSet(4));
        return new o(new j(a(paramb), isSet(1), isSet(8)));
        return new o(new k(a(paramb)));
      } while (isSet(16));
      return new q(new s());
    case 21: 
      return new o(new l());
    }
    return new o(new g(paramb.aFC));
  }
  
  public final SparseArray<u> mb()
  {
    return new SparseArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.e
 * JD-Core Version:    0.7.0.1
 */