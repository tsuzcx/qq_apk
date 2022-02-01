package com.google.android.exoplayer2.c.g;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e
  implements v.c
{
  private final List<Format> bfK;
  private final int flags;
  
  public e()
  {
    this(0);
  }
  
  public e(int paramInt)
  {
    this(paramInt, Collections.emptyList());
    AppMethodBeat.i(92220);
    AppMethodBeat.o(92220);
  }
  
  public e(int paramInt, List<Format> paramList)
  {
    AppMethodBeat.i(92221);
    this.flags = paramInt;
    Object localObject = paramList;
    if (!isSet(32))
    {
      localObject = paramList;
      if (paramList.isEmpty()) {
        localObject = Collections.singletonList(Format.h(null, "application/cea-608"));
      }
    }
    this.bfK = ((List)localObject);
    AppMethodBeat.o(92221);
  }
  
  private s a(v.b paramb)
  {
    AppMethodBeat.i(92224);
    if (isSet(32))
    {
      paramb = new s(this.bfK);
      AppMethodBeat.o(92224);
      return paramb;
    }
    com.google.android.exoplayer2.i.m localm = new com.google.android.exoplayer2.i.m(paramb.bhQ);
    paramb = this.bfK;
    while (localm.vJ() > 0)
    {
      int i = localm.readUnsignedByte();
      int k = localm.readUnsignedByte();
      int m = localm.position;
      if (i == 134)
      {
        ArrayList localArrayList = new ArrayList();
        int n = localm.readUnsignedByte();
        i = 0;
        if (i < (n & 0x1F))
        {
          String str = localm.readString(3);
          int i1 = localm.readUnsignedByte();
          if ((i1 & 0x80) != 0)
          {
            j = 1;
            label139:
            if (j == 0) {
              break label187;
            }
            paramb = "application/cea-708";
          }
          for (int j = i1 & 0x3F;; j = 1)
          {
            localArrayList.add(Format.a(null, paramb, 0, str, j));
            localm.fl(2);
            i += 1;
            break;
            j = 0;
            break label139;
            label187:
            paramb = "application/cea-608";
          }
        }
        paramb = localArrayList;
      }
      localm.setPosition(m + k);
    }
    paramb = new s(paramb);
    AppMethodBeat.o(92224);
    return paramb;
  }
  
  private boolean isSet(int paramInt)
  {
    return (this.flags & paramInt) != 0;
  }
  
  public final v a(int paramInt, v.b paramb)
  {
    AppMethodBeat.i(92223);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(92223);
      return null;
    case 3: 
    case 4: 
      paramb = new o(new m(paramb.aSt));
      AppMethodBeat.o(92223);
      return paramb;
    case 15: 
      if (isSet(2))
      {
        AppMethodBeat.o(92223);
        return null;
      }
      paramb = new o(new d(false, paramb.aSt));
      AppMethodBeat.o(92223);
      return paramb;
    case 129: 
    case 135: 
      paramb = new o(new b(paramb.aSt));
      AppMethodBeat.o(92223);
      return paramb;
    case 130: 
    case 138: 
      paramb = new o(new f(paramb.aSt));
      AppMethodBeat.o(92223);
      return paramb;
    case 2: 
      paramb = new o(new i());
      AppMethodBeat.o(92223);
      return paramb;
    case 27: 
      if (isSet(4))
      {
        AppMethodBeat.o(92223);
        return null;
      }
      paramb = new o(new j(a(paramb), isSet(1), isSet(8)));
      AppMethodBeat.o(92223);
      return paramb;
    case 36: 
      paramb = new o(new k(a(paramb)));
      AppMethodBeat.o(92223);
      return paramb;
    case 134: 
      if (isSet(16))
      {
        AppMethodBeat.o(92223);
        return null;
      }
      paramb = new r(new t());
      AppMethodBeat.o(92223);
      return paramb;
    case 21: 
      paramb = new o(new l());
      AppMethodBeat.o(92223);
      return paramb;
    }
    paramb = new o(new g(paramb.bhP));
    AppMethodBeat.o(92223);
    return paramb;
  }
  
  public final SparseArray<v> tf()
  {
    AppMethodBeat.i(92222);
    SparseArray localSparseArray = new SparseArray();
    AppMethodBeat.o(92222);
    return localSparseArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.e
 * JD-Core Version:    0.7.0.1
 */