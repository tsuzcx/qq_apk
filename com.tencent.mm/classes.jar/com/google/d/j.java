package com.google.d;

import java.util.List;
import java.util.Map;

final class j
  implements cz
{
  private final i dJi;
  private int dJj;
  private int dJk = 0;
  private int tag;
  
  j(i parami)
  {
    this.dJi = ((i)bj.c(parami, "input"));
    this.dJi.dIU = this;
  }
  
  private Object a(du.a parama, Class<?> paramClass, at paramat)
  {
    switch (1.dJl[parama.ordinal()])
    {
    default: 
      throw new RuntimeException("unsupported field type.");
    case 1: 
      return Boolean.valueOf(aai());
    case 2: 
      return aak();
    case 3: 
      return Double.valueOf(readDouble());
    case 4: 
      return Integer.valueOf(aam());
    case 5: 
      return Integer.valueOf(aah());
    case 6: 
      return Long.valueOf(aag());
    case 7: 
      return Float.valueOf(readFloat());
    case 8: 
      return Integer.valueOf(aaf());
    case 9: 
      return Long.valueOf(aae());
    case 10: 
      return a(paramClass, paramat);
    case 11: 
      return Integer.valueOf(aan());
    case 12: 
      return Long.valueOf(aao());
    case 13: 
      return Integer.valueOf(aap());
    case 14: 
      return Long.valueOf(aaq());
    case 15: 
      return aaj();
    case 16: 
      return Integer.valueOf(aal());
    }
    return Long.valueOf(aad());
  }
  
  private <T> T a(Class<T> paramClass, at paramat)
  {
    jY(2);
    return c(cv.aja().O(paramClass), paramat);
  }
  
  private <T> T c(dc<T> paramdc, at paramat)
  {
    int i = this.dJi.aal();
    if (this.dJi.dIR >= this.dJi.dIS) {
      throw bk.aip();
    }
    i = this.dJi.jO(i);
    Object localObject = paramdc.aiW();
    i locali = this.dJi;
    locali.dIR += 1;
    paramdc.a(localObject, this, paramat);
    paramdc.bu(localObject);
    this.dJi.jM(0);
    paramdc = this.dJi;
    paramdc.dIR -= 1;
    this.dJi.jP(i);
    return localObject;
  }
  
  private <T> T d(dc<T> paramdc, at paramat)
  {
    int i = this.dJj;
    this.dJj = du.cU(du.lE(this.tag), 4);
    Object localObject;
    try
    {
      localObject = paramdc.aiW();
      paramdc.a(localObject, this, paramat);
      paramdc.bu(localObject);
      if (this.tag != this.dJj) {
        throw bk.air();
      }
    }
    finally
    {
      this.dJj = i;
    }
    this.dJj = i;
    return localObject;
  }
  
  private void d(List<String> paramList, boolean paramBoolean)
  {
    if (du.lD(this.tag) != 2) {
      throw bk.aio();
    }
    int i;
    if (((paramList instanceof bp)) && (!paramBoolean))
    {
      paramList = (bp)paramList;
      do
      {
        paramList.d(aak());
        if (this.dJi.aau()) {
          return;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    label74:
    if (paramBoolean) {}
    for (String str = aaj();; str = readString())
    {
      paramList.add(str);
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
      if (i == this.tag) {
        break label74;
      }
      this.dJk = i;
      return;
    }
  }
  
  private void jY(int paramInt)
  {
    if (du.lD(this.tag) != paramInt) {
      throw bk.aio();
    }
  }
  
  private static void jZ(int paramInt)
  {
    if ((paramInt & 0x7) != 0) {
      throw bk.air();
    }
  }
  
  private static void ka(int paramInt)
  {
    if ((paramInt & 0x3) != 0) {
      throw bk.air();
    }
  }
  
  private void kb(int paramInt)
  {
    if (this.dJi.aav() != paramInt) {
      throw bk.aij();
    }
  }
  
  public final <T> T a(dc<T> paramdc, at paramat)
  {
    jY(2);
    return c(paramdc, paramat);
  }
  
  public final <T> void a(List<T> paramList, dc<T> paramdc, at paramat)
  {
    if (du.lD(this.tag) != 2) {
      throw bk.aio();
    }
    int i = this.tag;
    int j;
    do
    {
      paramList.add(c(paramdc, paramat));
      if ((this.dJi.aau()) || (this.dJk != 0)) {
        return;
      }
      j = this.dJi.aac();
    } while (j == i);
    this.dJk = j;
  }
  
  public final <K, V> void a(Map<K, V> paramMap, bu.a<K, V> parama, at paramat)
  {
    jY(2);
    int i = this.dJi.aal();
    i = this.dJi.jO(i);
    Object localObject1 = parama.dTC;
    Object localObject3 = parama.dOI;
    Object localObject4;
    for (;;)
    {
      localObject4 = localObject1;
      try
      {
        int j = aaD();
        if (j == 2147483647) {
          break;
        }
        boolean bool = this.dJi.aau();
        if (bool) {
          break;
        }
        switch (j)
        {
        default: 
          localObject1 = localObject4;
          try
          {
            if (aaE()) {
              continue;
            }
            throw new bk("Unable to parse map entry.");
          }
          catch (bk.a locala)
          {
            localObject2 = localObject4;
          }
          if (aaE()) {
            continue;
          }
          throw new bk("Unable to parse map entry.");
        }
      }
      finally
      {
        this.dJi.jP(i);
      }
      Object localObject2 = a(parama.dTB, null, null);
      continue;
      localObject2 = a(parama.dTD, parama.dOI.getClass(), paramat);
      localObject3 = localObject2;
      localObject2 = localObject4;
    }
    paramMap.put(localObject4, localObject3);
    this.dJi.jP(i);
  }
  
  public final void aA(List<String> paramList)
  {
    d(paramList, true);
  }
  
  public final void aB(List<h> paramList)
  {
    if (du.lD(this.tag) != 2) {
      throw bk.aio();
    }
    int i;
    do
    {
      paramList.add(aak());
      if (this.dJi.aau()) {
        return;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void aC(List<Integer> paramList)
  {
    int i;
    if ((paramList instanceof bi))
    {
      paramList = (bi)paramList;
      switch (du.lD(this.tag))
      {
      case 1: 
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal() + this.dJi.aav();
        do
        {
          paramList.lj(this.dJi.aal());
        } while (this.dJi.aav() < i);
        kb(i);
        return;
      }
      do
      {
        paramList.lj(this.dJi.aal());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    case 1: 
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal() + this.dJi.aav();
      do
      {
        paramList.add(Integer.valueOf(this.dJi.aal()));
      } while (this.dJi.aav() < i);
      kb(i);
      return;
    }
    do
    {
      paramList.add(Integer.valueOf(this.dJi.aal()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void aD(List<Integer> paramList)
  {
    int i;
    if ((paramList instanceof bi))
    {
      paramList = (bi)paramList;
      switch (du.lD(this.tag))
      {
      case 1: 
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal() + this.dJi.aav();
        do
        {
          paramList.lj(this.dJi.aam());
        } while (this.dJi.aav() < i);
        kb(i);
        return;
      }
      do
      {
        paramList.lj(this.dJi.aam());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    case 1: 
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal() + this.dJi.aav();
      do
      {
        paramList.add(Integer.valueOf(this.dJi.aam()));
      } while (this.dJi.aav() < i);
      kb(i);
      return;
    }
    do
    {
      paramList.add(Integer.valueOf(this.dJi.aam()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void aE(List<Integer> paramList)
  {
    int i;
    int j;
    if ((paramList instanceof bi))
    {
      paramList = (bi)paramList;
      switch (du.lD(this.tag))
      {
      case 3: 
      case 4: 
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal();
        ka(i);
        j = this.dJi.aav();
        do
        {
          paramList.lj(this.dJi.aan());
        } while (this.dJi.aav() < i + j);
        return;
      }
      do
      {
        paramList.lj(this.dJi.aan());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    case 3: 
    case 4: 
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal();
      ka(i);
      j = this.dJi.aav();
      do
      {
        paramList.add(Integer.valueOf(this.dJi.aan()));
      } while (this.dJi.aav() < i + j);
      return;
    }
    do
    {
      paramList.add(Integer.valueOf(this.dJi.aan()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void aF(List<Long> paramList)
  {
    int i;
    int j;
    if ((paramList instanceof br))
    {
      paramList = (br)paramList;
      switch (du.lD(this.tag))
      {
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal();
        jZ(i);
        j = this.dJi.aav();
        do
        {
          paramList.da(this.dJi.aao());
        } while (this.dJi.aav() < i + j);
        return;
      }
      do
      {
        paramList.da(this.dJi.aao());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal();
      jZ(i);
      j = this.dJi.aav();
      do
      {
        paramList.add(Long.valueOf(this.dJi.aao()));
      } while (this.dJi.aav() < i + j);
      return;
    }
    do
    {
      paramList.add(Long.valueOf(this.dJi.aao()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void aG(List<Integer> paramList)
  {
    int i;
    if ((paramList instanceof bi))
    {
      paramList = (bi)paramList;
      switch (du.lD(this.tag))
      {
      case 1: 
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal() + this.dJi.aav();
        do
        {
          paramList.lj(this.dJi.aap());
        } while (this.dJi.aav() < i);
        kb(i);
        return;
      }
      do
      {
        paramList.lj(this.dJi.aap());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    case 1: 
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal() + this.dJi.aav();
      do
      {
        paramList.add(Integer.valueOf(this.dJi.aap()));
      } while (this.dJi.aav() < i);
      kb(i);
      return;
    }
    do
    {
      paramList.add(Integer.valueOf(this.dJi.aap()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void aH(List<Long> paramList)
  {
    int i;
    if ((paramList instanceof br))
    {
      paramList = (br)paramList;
      switch (du.lD(this.tag))
      {
      case 1: 
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal() + this.dJi.aav();
        do
        {
          paramList.da(this.dJi.aaq());
        } while (this.dJi.aav() < i);
        kb(i);
        return;
      }
      do
      {
        paramList.da(this.dJi.aaq());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    case 1: 
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal() + this.dJi.aav();
      do
      {
        paramList.add(Long.valueOf(this.dJi.aaq()));
      } while (this.dJi.aav() < i);
      kb(i);
      return;
    }
    do
    {
      paramList.add(Long.valueOf(this.dJi.aaq()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final boolean aaC()
  {
    return this.dJi.dIV;
  }
  
  public final int aaD()
  {
    if (this.dJk != 0)
    {
      this.tag = this.dJk;
      this.dJk = 0;
    }
    while ((this.tag == 0) || (this.tag == this.dJj))
    {
      return 2147483647;
      this.tag = this.dJi.aac();
    }
    return du.lE(this.tag);
  }
  
  public final boolean aaE()
  {
    if ((this.dJi.aau()) || (this.tag == this.dJj)) {
      return false;
    }
    return this.dJi.jN(this.tag);
  }
  
  public final long aad()
  {
    jY(0);
    return this.dJi.aad();
  }
  
  public final long aae()
  {
    jY(0);
    return this.dJi.aae();
  }
  
  public final int aaf()
  {
    jY(0);
    return this.dJi.aaf();
  }
  
  public final long aag()
  {
    jY(1);
    return this.dJi.aag();
  }
  
  public final int aah()
  {
    jY(5);
    return this.dJi.aah();
  }
  
  public final boolean aai()
  {
    jY(0);
    return this.dJi.aai();
  }
  
  public final String aaj()
  {
    jY(2);
    return this.dJi.aaj();
  }
  
  public final h aak()
  {
    jY(2);
    return this.dJi.aak();
  }
  
  public final int aal()
  {
    jY(0);
    return this.dJi.aal();
  }
  
  public final int aam()
  {
    jY(0);
    return this.dJi.aam();
  }
  
  public final int aan()
  {
    jY(5);
    return this.dJi.aan();
  }
  
  public final long aao()
  {
    jY(1);
    return this.dJi.aao();
  }
  
  public final int aap()
  {
    jY(0);
    return this.dJi.aap();
  }
  
  public final long aaq()
  {
    jY(0);
    return this.dJi.aaq();
  }
  
  public final void ar(List<Double> paramList)
  {
    int i;
    int j;
    if ((paramList instanceof an))
    {
      paramList = (an)paramList;
      switch (du.lD(this.tag))
      {
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal();
        jZ(i);
        j = this.dJi.aav();
        do
        {
          paramList.w(this.dJi.readDouble());
        } while (this.dJi.aav() < i + j);
        return;
      }
      do
      {
        paramList.w(this.dJi.readDouble());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal();
      jZ(i);
      j = this.dJi.aav();
      do
      {
        paramList.add(Double.valueOf(this.dJi.readDouble()));
      } while (this.dJi.aav() < i + j);
      return;
    }
    do
    {
      paramList.add(Double.valueOf(this.dJi.readDouble()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void as(List<Float> paramList)
  {
    int i;
    int j;
    if ((paramList instanceof bb))
    {
      paramList = (bb)paramList;
      switch (du.lD(this.tag))
      {
      case 3: 
      case 4: 
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal();
        ka(i);
        j = this.dJi.aav();
        do
        {
          paramList.be(this.dJi.readFloat());
        } while (this.dJi.aav() < i + j);
        return;
      }
      do
      {
        paramList.be(this.dJi.readFloat());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    case 3: 
    case 4: 
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal();
      ka(i);
      j = this.dJi.aav();
      do
      {
        paramList.add(Float.valueOf(this.dJi.readFloat()));
      } while (this.dJi.aav() < i + j);
      return;
    }
    do
    {
      paramList.add(Float.valueOf(this.dJi.readFloat()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void at(List<Long> paramList)
  {
    int i;
    if ((paramList instanceof br))
    {
      paramList = (br)paramList;
      switch (du.lD(this.tag))
      {
      case 1: 
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal() + this.dJi.aav();
        do
        {
          paramList.da(this.dJi.aad());
        } while (this.dJi.aav() < i);
        kb(i);
        return;
      }
      do
      {
        paramList.da(this.dJi.aad());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    case 1: 
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal() + this.dJi.aav();
      do
      {
        paramList.add(Long.valueOf(this.dJi.aad()));
      } while (this.dJi.aav() < i);
      kb(i);
      return;
    }
    do
    {
      paramList.add(Long.valueOf(this.dJi.aad()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void au(List<Long> paramList)
  {
    int i;
    if ((paramList instanceof br))
    {
      paramList = (br)paramList;
      switch (du.lD(this.tag))
      {
      case 1: 
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal() + this.dJi.aav();
        do
        {
          paramList.da(this.dJi.aae());
        } while (this.dJi.aav() < i);
        kb(i);
        return;
      }
      do
      {
        paramList.da(this.dJi.aae());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    case 1: 
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal() + this.dJi.aav();
      do
      {
        paramList.add(Long.valueOf(this.dJi.aae()));
      } while (this.dJi.aav() < i);
      kb(i);
      return;
    }
    do
    {
      paramList.add(Long.valueOf(this.dJi.aae()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void av(List<Integer> paramList)
  {
    int i;
    if ((paramList instanceof bi))
    {
      paramList = (bi)paramList;
      switch (du.lD(this.tag))
      {
      case 1: 
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal() + this.dJi.aav();
        do
        {
          paramList.lj(this.dJi.aaf());
        } while (this.dJi.aav() < i);
        kb(i);
        return;
      }
      do
      {
        paramList.lj(this.dJi.aaf());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    case 1: 
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal() + this.dJi.aav();
      do
      {
        paramList.add(Integer.valueOf(this.dJi.aaf()));
      } while (this.dJi.aav() < i);
      kb(i);
      return;
    }
    do
    {
      paramList.add(Integer.valueOf(this.dJi.aaf()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void aw(List<Long> paramList)
  {
    int i;
    int j;
    if ((paramList instanceof br))
    {
      paramList = (br)paramList;
      switch (du.lD(this.tag))
      {
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal();
        jZ(i);
        j = this.dJi.aav();
        do
        {
          paramList.da(this.dJi.aag());
        } while (this.dJi.aav() < i + j);
        return;
      }
      do
      {
        paramList.da(this.dJi.aag());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal();
      jZ(i);
      j = this.dJi.aav();
      do
      {
        paramList.add(Long.valueOf(this.dJi.aag()));
      } while (this.dJi.aav() < i + j);
      return;
    }
    do
    {
      paramList.add(Long.valueOf(this.dJi.aag()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void ax(List<Integer> paramList)
  {
    int i;
    int j;
    if ((paramList instanceof bi))
    {
      paramList = (bi)paramList;
      switch (du.lD(this.tag))
      {
      case 3: 
      case 4: 
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal();
        ka(i);
        j = this.dJi.aav();
        do
        {
          paramList.lj(this.dJi.aah());
        } while (this.dJi.aav() < i + j);
        return;
      }
      do
      {
        paramList.lj(this.dJi.aah());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    case 3: 
    case 4: 
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal();
      ka(i);
      j = this.dJi.aav();
      do
      {
        paramList.add(Integer.valueOf(this.dJi.aah()));
      } while (this.dJi.aav() < i + j);
      return;
    }
    do
    {
      paramList.add(Integer.valueOf(this.dJi.aah()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void ay(List<Boolean> paramList)
  {
    int i;
    if ((paramList instanceof f))
    {
      paramList = (f)paramList;
      switch (du.lD(this.tag))
      {
      case 1: 
      default: 
        throw bk.aio();
      case 2: 
        i = this.dJi.aal() + this.dJi.aav();
        do
        {
          paramList.bY(this.dJi.aai());
        } while (this.dJi.aav() < i);
        kb(i);
        return;
      }
      do
      {
        paramList.bY(this.dJi.aai());
        if (this.dJi.aau()) {
          break;
        }
        i = this.dJi.aac();
      } while (i == this.tag);
      this.dJk = i;
      return;
    }
    switch (du.lD(this.tag))
    {
    case 1: 
    default: 
      throw bk.aio();
    case 2: 
      i = this.dJi.aal() + this.dJi.aav();
      do
      {
        paramList.add(Boolean.valueOf(this.dJi.aai()));
      } while (this.dJi.aav() < i);
      kb(i);
      return;
    }
    do
    {
      paramList.add(Boolean.valueOf(this.dJi.aai()));
      if (this.dJi.aau()) {
        break;
      }
      i = this.dJi.aac();
    } while (i == this.tag);
    this.dJk = i;
  }
  
  public final void az(List<String> paramList)
  {
    d(paramList, false);
  }
  
  public final <T> T b(dc<T> paramdc, at paramat)
  {
    jY(3);
    return d(paramdc, paramat);
  }
  
  public final <T> void b(List<T> paramList, dc<T> paramdc, at paramat)
  {
    if (du.lD(this.tag) != 3) {
      throw bk.aio();
    }
    int i = this.tag;
    int j;
    do
    {
      paramList.add(d(paramdc, paramat));
      if ((this.dJi.aau()) || (this.dJk != 0)) {
        return;
      }
      j = this.dJi.aac();
    } while (j == i);
    this.dJk = j;
  }
  
  public final int getTag()
  {
    return this.tag;
  }
  
  public final double readDouble()
  {
    jY(1);
    return this.dJi.readDouble();
  }
  
  public final float readFloat()
  {
    jY(5);
    return this.dJi.readFloat();
  }
  
  public final String readString()
  {
    jY(2);
    return this.dJi.readString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.j
 * JD-Core Version:    0.7.0.1
 */