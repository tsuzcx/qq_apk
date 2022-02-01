package com.google.a;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class m
  extends a
{
  private int bNa = -1;
  final l.a bTT;
  final x<l.f> bTU;
  final l.f[] bTV;
  final cc bTW;
  
  m(l.a parama, x<l.f> paramx, l.f[] paramArrayOff, cc paramcc)
  {
    this.bTT = parama;
    this.bTU = paramx;
    this.bTV = paramArrayOff;
    this.bTW = paramcc;
  }
  
  private a FT()
  {
    return new a(this.bTT, (byte)0);
  }
  
  private a FU()
  {
    return FT().B(this);
  }
  
  static boolean a(l.a parama, x<l.f> paramx)
  {
    parama = parama.getFields().iterator();
    while (parama.hasNext())
    {
      l.f localf = (l.f)parama.next();
      if ((localf.FH()) && (!paramx.a(localf))) {
        return false;
      }
    }
    return paramx.isInitialized();
  }
  
  public static m c(l.a parama)
  {
    l.f[] arrayOff = new l.f[parama.bSq.AE()];
    return new m(parama, x.Gj(), arrayOff, cc.HK());
  }
  
  public static a d(l.a parama)
  {
    return new a(parama, (byte)0);
  }
  
  private void g(l.f paramf)
  {
    if (paramf.bSs != this.bTT) {
      throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }
  }
  
  public final bj<m> AK()
  {
    new c()
    {
      private m C(h paramAnonymoush, r paramAnonymousr)
      {
        m.a locala = m.d(m.this.bTT);
        try
        {
          locala.a(paramAnonymoush, paramAnonymousr);
          return locala.FW();
        }
        catch (af paramAnonymoush)
        {
          paramAnonymoush.bXr = locala.FW();
          throw paramAnonymoush;
        }
        catch (IOException paramAnonymoush)
        {
          paramAnonymoush = new af(paramAnonymoush);
          paramAnonymoush.bXr = locala.FW();
          throw paramAnonymoush;
        }
      }
    };
  }
  
  public final l.a AS()
  {
    return this.bTT;
  }
  
  public final cc Ax()
  {
    return this.bTW;
  }
  
  public final Map<l.f, Object> FS()
  {
    return this.bTU.FS();
  }
  
  public final void a(i parami)
  {
    int i = 0;
    if (this.bTT.bSq.AG().bRt)
    {
      localObject = this.bTU;
      while (i < ((x)localObject).bUB.Hx())
      {
        x.a(((x)localObject).bUB.gM(i), parami);
        i += 1;
      }
      localObject = ((x)localObject).bUB.Hy().iterator();
      while (((Iterator)localObject).hasNext()) {
        x.a((Map.Entry)((Iterator)localObject).next(), parami);
      }
      this.bTW.c(parami);
      return;
    }
    Object localObject = this.bTU;
    i = 0;
    Map.Entry localEntry;
    while (i < ((x)localObject).bUB.Hx())
    {
      localEntry = ((x)localObject).bUB.gM(i);
      x.a((x.a)localEntry.getKey(), localEntry.getValue(), parami);
      i += 1;
    }
    localObject = ((x)localObject).bUB.Hy().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      x.a((x.a)localEntry.getKey(), localEntry.getValue(), parami);
    }
    this.bTW.a(parami);
  }
  
  public final boolean e(l.f paramf)
  {
    g(paramf);
    return this.bTU.a(paramf);
  }
  
  public final Object f(l.f paramf)
  {
    g(paramf);
    Object localObject2 = this.bTU.b(paramf);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (paramf.FJ()) {
        localObject1 = Collections.emptyList();
      }
    }
    else {
      return localObject1;
    }
    if (paramf.bSS.bTz == l.f.a.bTe) {
      return c(paramf.FN());
    }
    return paramf.getDefaultValue();
  }
  
  public final boolean isInitialized()
  {
    return a(this.bTT, this.bTU);
  }
  
  public final int yC()
  {
    int i = this.bNa;
    if (i != -1) {
      return i;
    }
    if (this.bTT.bSq.AG().bRt)
    {
      Object localObject = this.bTU;
      int j = 0;
      int k;
      for (i = 0; j < ((x)localObject).bUB.Hx(); i = k + i)
      {
        k = x.c(((x)localObject).bUB.gM(j));
        j += 1;
      }
      localObject = ((x)localObject).bUB.Hy().iterator();
      while (((Iterator)localObject).hasNext()) {
        i += x.c((Map.Entry)((Iterator)localObject).next());
      }
    }
    for (i = this.bTW.HL() + i;; i = this.bTU.yC() + this.bTW.yC())
    {
      this.bNa = i;
      return i;
    }
  }
  
  public static final class a
    extends a.a<a>
  {
    private final l.a bTT;
    private x<l.f> bTU;
    private final l.f[] bTV;
    private cc bTW;
    
    private a(l.a parama)
    {
      this.bTT = parama;
      this.bTU = x.Gi();
      this.bTW = cc.HK();
      this.bTV = new l.f[parama.bSq.AE()];
      if (parama.bSq.AG().bRv)
      {
        parama = this.bTT.getFields().iterator();
        while (parama.hasNext())
        {
          l.f localf = (l.f)parama.next();
          if (localf.bSS.bTz == l.f.a.bTe) {
            this.bTU.a(localf, m.c(localf.FN()));
          } else {
            this.bTU.a(localf, localf.getDefaultValue());
          }
        }
      }
    }
    
    private m FV()
    {
      if (!isInitialized()) {
        throw b(new m(this.bTT, this.bTU, (l.f[])Arrays.copyOf(this.bTV, this.bTV.length), this.bTW));
      }
      return FW();
    }
    
    private a FX()
    {
      a locala = new a(this.bTT);
      locala.bTU.a(this.bTU);
      locala.aa(this.bTW);
      System.arraycopy(this.bTV, 0, locala.bTV, 0, this.bTV.length);
      return locala;
    }
    
    private a aa(cc paramcc)
    {
      this.bTW = cc.ac(this.bTW).ae(paramcc).HM();
      return this;
    }
    
    private static void am(Object paramObject)
    {
      ae.checkNotNull(paramObject);
      if (!(paramObject instanceof l.e)) {
        throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
      }
    }
    
    private void d(l.j paramj)
    {
      if (paramj.bSs != this.bTT) {
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
      }
    }
    
    private void g(l.f paramf)
    {
      if (paramf.bSs != this.bTT) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
    }
    
    private void yL()
    {
      if (this.bTU.bUC) {
        this.bTU = this.bTU.Gk();
      }
    }
    
    public final l.a AS()
    {
      return this.bTT;
    }
    
    public final cc Ax()
    {
      return this.bTW;
    }
    
    public final a B(at paramat)
    {
      if ((paramat instanceof m))
      {
        m localm = (m)paramat;
        if (localm.bTT != this.bTT) {
          throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }
        yL();
        this.bTU.a(localm.bTU);
        aa(localm.bTW);
        int i = 0;
        paramat = this;
        if (i < this.bTV.length)
        {
          if (this.bTV[i] == null) {
            this.bTV[i] = localm.bTV[i];
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localm.bTV[i] != null) && (this.bTV[i] != localm.bTV[i]))
            {
              this.bTU.c(this.bTV[i]);
              this.bTV[i] = localm.bTV[i];
            }
          }
        }
      }
      else
      {
        paramat = (a)super.a(paramat);
      }
      return paramat;
    }
    
    public final Map<l.f, Object> FS()
    {
      return this.bTU.FS();
    }
    
    public final m FW()
    {
      this.bTU.yK();
      return new m(this.bTT, this.bTU, (l.f[])Arrays.copyOf(this.bTV, this.bTV.length), this.bTW);
    }
    
    public final boolean a(l.j paramj)
    {
      d(paramj);
      return this.bTV[paramj.index] != null;
    }
    
    public final l.f b(l.j paramj)
    {
      d(paramj);
      return this.bTV[paramj.index];
    }
    
    public final boolean e(l.f paramf)
    {
      g(paramf);
      return this.bTU.a(paramf);
    }
    
    public final Object f(l.f paramf)
    {
      g(paramf);
      Object localObject2 = this.bTU.b(paramf);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (paramf.FJ()) {
          localObject1 = Collections.emptyList();
        }
      }
      else {
        return localObject1;
      }
      if (paramf.bSS.bTz == l.f.a.bTe) {
        return m.c(paramf.FN());
      }
      return paramf.getDefaultValue();
    }
    
    public final boolean isInitialized()
    {
      return m.a(this.bTT, this.bTU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.m
 * JD-Core Version:    0.7.0.1
 */