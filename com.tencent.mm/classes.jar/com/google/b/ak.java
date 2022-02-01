package com.google.b;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ak
  extends a
{
  private int bOZ = -1;
  final aj.a bVT;
  final av<aj.f> bVU;
  final aj.f[] bVV;
  final da bVW;
  
  ak(aj.a parama, av<aj.f> paramav, aj.f[] paramArrayOff, da paramda)
  {
    this.bVT = parama;
    this.bVU = paramav;
    this.bVV = paramArrayOff;
    this.bVW = paramda;
  }
  
  private a HA()
  {
    return new a(this.bVT, (byte)0);
  }
  
  static boolean a(aj.a parama, av<aj.f> paramav)
  {
    parama = parama.getFields().iterator();
    while (parama.hasNext())
    {
      aj.f localf = (aj.f)parama.next();
      if ((localf.Hn()) && (!paramav.a(localf))) {
        return false;
      }
    }
    return paramav.isInitialized();
  }
  
  public static ak c(aj.a parama)
  {
    aj.f[] arrayOff = new aj.f[parama.bUp.Ci()];
    return new ak(parama, av.HP(), arrayOff, da.Jk());
  }
  
  public static a d(aj.a parama)
  {
    return new a(parama, (byte)0);
  }
  
  private void g(aj.f paramf)
  {
    if (paramf.bUr != this.bVT) {
      throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }
  }
  
  public final int Ad()
  {
    int i = this.bOZ;
    if (i != -1) {
      return i;
    }
    if (this.bVT.bUp.Ck().bTs)
    {
      Object localObject = this.bVU;
      int j = 0;
      int k;
      for (i = 0; j < ((av)localObject).bWz.IX(); i = k + i)
      {
        k = av.d(((av)localObject).bWz.hD(j));
        j += 1;
      }
      localObject = ((av)localObject).bWz.IY().iterator();
      while (((Iterator)localObject).hasNext()) {
        i += av.d((Map.Entry)((Iterator)localObject).next());
      }
    }
    for (i = this.bVW.Jl() + i;; i = this.bVU.Ad() + this.bVW.Ad())
    {
      this.bOZ = i;
      return i;
    }
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  public final ci<ak> Co()
  {
    new c()
    {
      private ak C(h paramAnonymoush, ap paramAnonymousap)
      {
        ak.a locala = ak.d(ak.this.bVT);
        try
        {
          locala.a(paramAnonymoush, paramAnonymousap);
          return locala.HC();
        }
        catch (bf paramAnonymoush)
        {
          paramAnonymoush.bZj = locala.HC();
          throw paramAnonymoush;
        }
        catch (IOException paramAnonymoush)
        {
          paramAnonymoush = new bf(paramAnonymoush);
          paramAnonymoush.bZj = locala.HC();
          throw paramAnonymoush;
        }
      }
    };
  }
  
  public final aj.a Cv()
  {
    return this.bVT;
  }
  
  public final Map<aj.f, Object> Hz()
  {
    return this.bVU.Hz();
  }
  
  public final void a(i parami)
  {
    int i = 0;
    if (this.bVT.bUp.Ck().bTs)
    {
      localObject = this.bVU;
      while (i < ((av)localObject).bWz.IX())
      {
        av.a(((av)localObject).bWz.hD(i), parami);
        i += 1;
      }
      localObject = ((av)localObject).bWz.IY().iterator();
      while (((Iterator)localObject).hasNext()) {
        av.a((Map.Entry)((Iterator)localObject).next(), parami);
      }
      this.bVW.c(parami);
      return;
    }
    Object localObject = this.bVU;
    i = 0;
    Map.Entry localEntry;
    while (i < ((av)localObject).bWz.IX())
    {
      localEntry = ((av)localObject).bWz.hD(i);
      av.a((av.a)localEntry.getKey(), localEntry.getValue(), parami);
      i += 1;
    }
    localObject = ((av)localObject).bWz.IY().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      av.a((av.a)localEntry.getKey(), localEntry.getValue(), parami);
    }
    this.bVW.a(parami);
  }
  
  public final boolean e(aj.f paramf)
  {
    g(paramf);
    return this.bVU.a(paramf);
  }
  
  public final Object f(aj.f paramf)
  {
    g(paramf);
    Object localObject2 = this.bVU.b(paramf);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (paramf.Hp()) {
        localObject1 = Collections.emptyList();
      }
    }
    else {
      return localObject1;
    }
    if (paramf.bUR.bVz == aj.f.a.bVe) {
      return c(paramf.Hu());
    }
    return paramf.Hs();
  }
  
  public final boolean isInitialized()
  {
    return a(this.bVT, this.bVU);
  }
  
  public static final class a
    extends a.a<a>
  {
    private final aj.a bVT;
    private av<aj.f> bVU;
    private final aj.f[] bVV;
    private da bVW;
    
    private a(aj.a parama)
    {
      this.bVT = parama;
      this.bVU = av.HO();
      this.bVW = da.Jk();
      this.bVV = new aj.f[parama.bUp.Ci()];
      if (parama.bUp.Ck().bTu)
      {
        parama = this.bVT.getFields().iterator();
        while (parama.hasNext())
        {
          aj.f localf = (aj.f)parama.next();
          if (localf.bUR.bVz == aj.f.a.bVe) {
            this.bVU.a(localf, ak.c(localf.Hu()));
          } else {
            this.bVU.a(localf, localf.Hs());
          }
        }
      }
    }
    
    private void Am()
    {
      if (this.bVU.bWA) {
        this.bVU = this.bVU.HQ();
      }
    }
    
    private ak HB()
    {
      if (!isInitialized()) {
        throw b(new ak(this.bVT, this.bVU, (aj.f[])Arrays.copyOf(this.bVV, this.bVV.length), this.bVW));
      }
      return HC();
    }
    
    private a HD()
    {
      a locala = new a(this.bVT);
      locala.bVU.a(this.bVU);
      locala.aa(this.bVW);
      System.arraycopy(this.bVV, 0, locala.bVV, 0, this.bVV.length);
      return locala;
    }
    
    private a aa(da paramda)
    {
      this.bVW = da.ac(this.bVW).ae(paramda).Jm();
      return this;
    }
    
    private static void al(Object paramObject)
    {
      be.checkNotNull(paramObject);
      if (!(paramObject instanceof aj.e)) {
        throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
      }
    }
    
    private void d(aj.j paramj)
    {
      if (paramj.bUr != this.bVT) {
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
      }
    }
    
    private void g(aj.f paramf)
    {
      if (paramf.bUr != this.bVT) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
    }
    
    public final a B(bt parambt)
    {
      if ((parambt instanceof ak))
      {
        ak localak = (ak)parambt;
        if (localak.bVT != this.bVT) {
          throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }
        Am();
        this.bVU.a(localak.bVU);
        aa(localak.bVW);
        int i = 0;
        parambt = this;
        if (i < this.bVV.length)
        {
          if (this.bVV[i] == null) {
            this.bVV[i] = localak.bVV[i];
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localak.bVV[i] != null) && (this.bVV[i] != localak.bVV[i]))
            {
              this.bVU.c(this.bVV[i]);
              this.bVV[i] = localak.bVV[i];
            }
          }
        }
      }
      else
      {
        parambt = (a)super.a(parambt);
      }
      return parambt;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    public final aj.a Cv()
    {
      return this.bVT;
    }
    
    public final ak HC()
    {
      this.bVU.Al();
      return new ak(this.bVT, this.bVU, (aj.f[])Arrays.copyOf(this.bVV, this.bVV.length), this.bVW);
    }
    
    public final Map<aj.f, Object> Hz()
    {
      return this.bVU.Hz();
    }
    
    public final boolean a(aj.j paramj)
    {
      d(paramj);
      return this.bVV[paramj.index] != null;
    }
    
    public final aj.f b(aj.j paramj)
    {
      d(paramj);
      return this.bVV[paramj.index];
    }
    
    public final boolean e(aj.f paramf)
    {
      g(paramf);
      return this.bVU.a(paramf);
    }
    
    public final Object f(aj.f paramf)
    {
      g(paramf);
      Object localObject2 = this.bVU.b(paramf);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (paramf.Hp()) {
          localObject1 = Collections.emptyList();
        }
      }
      else {
        return localObject1;
      }
      if (paramf.bUR.bVz == aj.f.a.bVe) {
        return ak.c(paramf.Hu());
      }
      return paramf.Hs();
    }
    
    public final boolean isInitialized()
    {
      return ak.a(this.bVT, this.bVU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.ak
 * JD-Core Version:    0.7.0.1
 */