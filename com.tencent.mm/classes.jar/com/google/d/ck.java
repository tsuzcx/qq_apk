package com.google.d;

import java.util.Iterator;
import java.util.Map.Entry;

final class ck<T>
  implements dc<T>
{
  private final ce dUe;
  private final boolean dUf;
  private final dm<?, ?> dUo;
  private final au<?> dUp;
  
  private ck(dm<?, ?> paramdm, au<?> paramau, ce paramce)
  {
    this.dUo = paramdm;
    this.dUf = paramau.d(paramce);
    this.dUp = paramau;
    this.dUe = paramce;
  }
  
  static <T> ck<T> a(dm<?, ?> paramdm, au<?> paramau, ce paramce)
  {
    return new ck(paramdm, paramau, paramce);
  }
  
  public final void a(T paramT, cz paramcz, at paramat)
  {
    dm localdm = this.dUo;
    au localau = this.dUp;
    Object localObject2 = localdm.bM(paramT);
    localau.bt(paramT);
    label284:
    for (;;)
    {
      int i;
      Object localObject1;
      try
      {
        i = paramcz.aaD();
        if (i == 2147483647) {
          return;
        }
        i = paramcz.getTag();
        if (i == du.dWC) {
          break label284;
        }
        if (du.lD(i) == 2)
        {
          if (localau.a(paramat, this.dUe, du.lE(i)) != null)
          {
            localau.ahL();
            bool = true;
            if (bool) {
              continue;
            }
            return;
          }
          bool = localdm.a(localObject2, paramcz);
          continue;
        }
        boolean bool = paramcz.aaE();
        continue;
        if (paramcz.aaD() == 2147483647) {
          break label244;
        }
        int j = paramcz.getTag();
        if (j == du.dWE)
        {
          i = paramcz.aal();
          localObject1 = localau.a(paramat, this.dUe, i);
          continue;
        }
        if (j != du.dWF) {
          break label235;
        }
        if (localObject1 != null)
        {
          localau.ahL();
          continue;
        }
        localh = paramcz.aak();
      }
      finally
      {
        localdm.u(paramT, localObject2);
      }
      h localh;
      continue;
      label235:
      if (!paramcz.aaE())
      {
        label244:
        if (paramcz.getTag() != du.dWD) {
          throw bk.ain();
        }
        if ((localh != null) && (localObject1 == null))
        {
          localdm.a(localObject2, i, localh);
          continue;
          i = 0;
          localObject1 = null;
          localh = null;
        }
      }
    }
  }
  
  public final void a(T paramT, dv paramdv)
  {
    Object localObject = this.dUp.bs(paramT).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      az.a locala = (az.a)localEntry.getKey();
      if ((locala.ahf() != du.b.dXj) || (locala.ahl()) || (locala.ahm())) {
        throw new IllegalStateException("Found invalid MessageSet item.");
      }
      if ((localEntry instanceof bm.a)) {
        paramdv.x(locala.getNumber(), ((bm.a)localEntry).ait().toByteString());
      } else {
        paramdv.x(locala.getNumber(), localEntry.getValue());
      }
    }
    localObject = this.dUo;
    ((dm)localObject).c(((dm)localObject).bL(paramT), paramdv);
  }
  
  public final T aiW()
  {
    return this.dUe.newBuilderForType().buildPartial();
  }
  
  public final int bH(T paramT)
  {
    dm localdm = this.dUo;
    int j = localdm.bN(localdm.bL(paramT)) + 0;
    int i = j;
    if (this.dUf) {
      i = j + this.dUp.bs(paramT).ahT();
    }
    return i;
  }
  
  public final boolean bI(T paramT)
  {
    return this.dUp.bs(paramT).isInitialized();
  }
  
  public final void bu(T paramT)
  {
    this.dUo.bu(paramT);
    this.dUp.bu(paramT);
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    if (!this.dUo.bL(paramT1).equals(this.dUo.bL(paramT2))) {
      return false;
    }
    if (this.dUf) {
      return this.dUp.bs(paramT1).equals(this.dUp.bs(paramT2));
    }
    return true;
  }
  
  public final int hashCode(T paramT)
  {
    int j = this.dUo.bL(paramT).hashCode();
    int i = j;
    if (this.dUf) {
      i = j * 53 + this.dUp.bs(paramT).hashCode();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.ck
 * JD-Core Version:    0.7.0.1
 */