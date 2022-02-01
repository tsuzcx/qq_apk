package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class rh
{
  public final int a;
  public final int b;
  private final String c;
  private final List<rn> d;
  
  public rh(int paramInt1, int paramInt2, List<rn> paramList)
  {
    AppMethodBeat.i(223134);
    this.c = "_night";
    this.d = new CopyOnWriteArrayList();
    this.a = paramInt1;
    this.b = paramInt2;
    this.d.addAll(paramList);
    Collections.sort(paramList, new Comparator()
    {
      private static int a(rn paramAnonymousrn1, rn paramAnonymousrn2)
      {
        AppMethodBeat.i(225883);
        int i = paramAnonymousrn2.a();
        int j = paramAnonymousrn1.a();
        AppMethodBeat.o(225883);
        return i - j;
      }
    });
    AppMethodBeat.o(223134);
  }
  
  private int a()
  {
    return this.a;
  }
  
  private int b()
  {
    return this.b;
  }
  
  public final Object[] a(fs paramfs, boolean paramBoolean)
  {
    AppMethodBeat.i(223159);
    Object localObject2 = this.d.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject1 = (rn)((Iterator)localObject2).next();
      if (((rn)localObject1).a(paramfs))
      {
        localObject2 = ((rn)localObject1).a(paramBoolean);
        StringBuilder localStringBuilder = new StringBuilder().append(((rn)localObject1).c);
        if (paramBoolean) {}
        for (paramfs = "_night";; paramfs = "")
        {
          paramfs = paramfs;
          if ((!paramBoolean) || (((rn)localObject1).e == null) || (((rn)localObject1).e.length() <= 0)) {
            break;
          }
          localObject1 = ((rn)localObject1).e;
          AppMethodBeat.o(223159);
          return new Object[] { paramfs, localObject1, localObject2 };
        }
        localObject1 = ((rn)localObject1).d;
        AppMethodBeat.o(223159);
        return new Object[] { paramfs, localObject1, localObject2 };
      }
    }
    AppMethodBeat.o(223159);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rh
 * JD-Core Version:    0.7.0.1
 */