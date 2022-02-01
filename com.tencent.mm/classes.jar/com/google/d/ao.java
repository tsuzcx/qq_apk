package com.google.d;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ao
  extends a
{
  private final am.a dPI;
  private final az<am.f> dPJ;
  private final am.f[] dPK;
  private int memoizedSize = -1;
  private final dn unknownFields;
  
  ao(am.a parama, az<am.f> paramaz, am.f[] paramArrayOff, dn paramdn)
  {
    this.dPI = parama;
    this.dPJ = paramaz;
    this.dPK = paramArrayOff;
    this.unknownFields = paramdn;
  }
  
  private void B(am.j paramj)
  {
    if (paramj.dOe != this.dPI) {
      throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }
  }
  
  private void D(am.f paramf)
  {
    if (paramf.dOe != this.dPI) {
      throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }
  }
  
  static boolean a(am.a parama, az<am.f> paramaz)
  {
    parama = parama.getFields().iterator();
    while (parama.hasNext())
    {
      am.f localf = (am.f)parama.next();
      if ((localf.ahj()) && (!paramaz.a(localf))) {
        return false;
      }
    }
    return paramaz.isInitialized();
  }
  
  private a ahw()
  {
    return new a(this.dPI, (byte)0);
  }
  
  private a ahx()
  {
    return ahw().y(this);
  }
  
  public static ao d(am.a parama)
  {
    am.f[] arrayOff = new am.f[parama.dOc.abS()];
    return new ao(parama, az.ahR(), arrayOff, dn.ajF());
  }
  
  public static a e(am.a parama)
  {
    return new a(parama, (byte)0);
  }
  
  public final Map<am.f, Object> getAllFields()
  {
    return this.dPJ.getAllFields();
  }
  
  public final am.a getDescriptorForType()
  {
    return this.dPI;
  }
  
  public final Object getField(am.f paramf)
  {
    D(paramf);
    Object localObject2 = this.dPJ.b(paramf);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (paramf.ahl()) {
        localObject1 = Collections.emptyList();
      }
    }
    else {
      return localObject1;
    }
    if (paramf.dOE.dPm == am.f.a.dOR) {
      return d(paramf.ahq());
    }
    return paramf.aho();
  }
  
  public final am.f getOneofFieldDescriptor(am.j paramj)
  {
    B(paramj);
    return this.dPK[paramj.index];
  }
  
  public final cs<ao> getParserForType()
  {
    new c()
    {
      private ao y(i paramAnonymousi, at paramAnonymousat)
      {
        ao.a locala = ao.e(ao.a(ao.this));
        try
        {
          locala.mergeFrom(paramAnonymousi, paramAnonymousat);
          return locala.ahB();
        }
        catch (bk paramAnonymousi)
        {
          paramAnonymousi.dST = locala.ahB();
          throw paramAnonymousi;
        }
        catch (IOException paramAnonymousi)
        {
          paramAnonymousi = new bk(paramAnonymousi);
          paramAnonymousi.dST = locala.ahB();
          throw paramAnonymousi;
        }
      }
    };
  }
  
  public final int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    if (this.dPI.dOc.abU().dNf) {}
    for (i = this.dPJ.ahT() + this.unknownFields.ajG();; i = this.dPJ.getSerializedSize() + this.unknownFields.getSerializedSize())
    {
      this.memoizedSize = i;
      return i;
    }
  }
  
  public final dn getUnknownFields()
  {
    return this.unknownFields;
  }
  
  public final boolean hasField(am.f paramf)
  {
    D(paramf);
    return this.dPJ.a(paramf);
  }
  
  public final boolean hasOneof(am.j paramj)
  {
    B(paramj);
    return this.dPK[paramj.index] != null;
  }
  
  public final boolean isInitialized()
  {
    return a(this.dPI, this.dPJ);
  }
  
  public final void writeTo(k paramk)
  {
    int i = 0;
    if (this.dPI.dOc.abU().dNf)
    {
      localObject = this.dPJ;
      while (i < ((az)localObject).dQn.ajq())
      {
        az.a(((az)localObject).dQn.lt(i), paramk);
        i += 1;
      }
      localObject = ((az)localObject).dQn.ajr().iterator();
      while (((Iterator)localObject).hasNext()) {
        az.a((Map.Entry)((Iterator)localObject).next(), paramk);
      }
      this.unknownFields.b(paramk);
      return;
    }
    Object localObject = this.dPJ;
    i = 0;
    Map.Entry localEntry;
    while (i < ((az)localObject).dQn.ajq())
    {
      localEntry = ((az)localObject).dQn.lt(i);
      az.a((az.a)localEntry.getKey(), localEntry.getValue(), paramk);
      i += 1;
    }
    localObject = ((az)localObject).dQn.ajr().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      az.a((az.a)localEntry.getKey(), localEntry.getValue(), paramk);
    }
    this.unknownFields.writeTo(paramk);
  }
  
  public static final class a
    extends a.a<a>
  {
    private final am.a dPI;
    private az<am.f> dPJ;
    private final am.f[] dPK;
    private dn unknownFields;
    
    private a(am.a parama)
    {
      this.dPI = parama;
      this.dPJ = az.ahQ();
      this.unknownFields = dn.ajF();
      this.dPK = new am.f[parama.dOc.abS()];
      if (parama.dOc.abU().dNh) {
        ahy();
      }
    }
    
    private void B(am.j paramj)
    {
      if (paramj.dOe != this.dPI) {
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
      }
    }
    
    private a C(am.j paramj)
    {
      B(paramj);
      paramj = this.dPK[paramj.index];
      if (paramj != null) {
        E(paramj);
      }
      return this;
    }
    
    private void D(am.f paramf)
    {
      if (paramf.dOe != this.dPI) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
    }
    
    private a E(am.f paramf)
    {
      D(paramf);
      ZQ();
      am.j localj = paramf.dOG;
      if (localj != null)
      {
        int i = localj.index;
        if (this.dPK[i] == paramf) {
          this.dPK[i] = null;
        }
      }
      this.dPJ.c(paramf);
      return this;
    }
    
    private a W(dn paramdn)
    {
      this.unknownFields = dn.Y(this.unknownFields).aa(paramdn).ajH();
      return this;
    }
    
    private void ZQ()
    {
      if (this.dPJ.bRu) {
        this.dPJ = this.dPJ.ahS();
      }
    }
    
    private ao ahA()
    {
      if (!isInitialized()) {
        throw newUninitializedMessageException(new ao(this.dPI, this.dPJ, (am.f[])Arrays.copyOf(this.dPK, this.dPK.length), this.unknownFields));
      }
      return ahB();
    }
    
    private a ahC()
    {
      a locala = new a(this.dPI);
      locala.dPJ.a(this.dPJ);
      locala.W(this.unknownFields);
      System.arraycopy(this.dPK, 0, locala.dPK, 0, this.dPK.length);
      return locala;
    }
    
    private void ahy()
    {
      Iterator localIterator = this.dPI.getFields().iterator();
      while (localIterator.hasNext())
      {
        am.f localf = (am.f)localIterator.next();
        if (localf.dOE.dPm == am.f.a.dOR) {
          this.dPJ.a(localf, ao.d(localf.ahq()));
        } else {
          this.dPJ.a(localf, localf.aho());
        }
      }
    }
    
    private a ahz()
    {
      if (this.dPJ.bRu) {
        this.dPJ = az.ahQ();
      }
      for (;;)
      {
        if (this.dPI.dOc.abU().dNh) {
          ahy();
        }
        this.unknownFields = dn.ajF();
        return this;
        az localaz = this.dPJ;
        localaz.dQn.clear();
        localaz.dQo = false;
      }
    }
    
    private static void br(Object paramObject)
    {
      bj.checkNotNull(paramObject);
      if (!(paramObject instanceof am.e)) {
        throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
      }
    }
    
    public final ao ahB()
    {
      this.dPJ.ZP();
      return new ao(this.dPI, this.dPJ, (am.f[])Arrays.copyOf(this.dPK, this.dPK.length), this.unknownFields);
    }
    
    public final Map<am.f, Object> getAllFields()
    {
      return this.dPJ.getAllFields();
    }
    
    public final am.a getDescriptorForType()
    {
      return this.dPI;
    }
    
    public final Object getField(am.f paramf)
    {
      D(paramf);
      Object localObject2 = this.dPJ.b(paramf);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (paramf.ahl()) {
          localObject1 = Collections.emptyList();
        }
      }
      else {
        return localObject1;
      }
      if (paramf.dOE.dPm == am.f.a.dOR) {
        return ao.d(paramf.ahq());
      }
      return paramf.aho();
    }
    
    public final cb.a getFieldBuilder(am.f paramf)
    {
      throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
    }
    
    public final am.f getOneofFieldDescriptor(am.j paramj)
    {
      B(paramj);
      return this.dPK[paramj.index];
    }
    
    public final cb.a getRepeatedFieldBuilder(am.f paramf, int paramInt)
    {
      throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final boolean hasField(am.f paramf)
    {
      D(paramf);
      return this.dPJ.a(paramf);
    }
    
    public final boolean hasOneof(am.j paramj)
    {
      B(paramj);
      return this.dPK[paramj.index] != null;
    }
    
    public final boolean isInitialized()
    {
      return ao.a(this.dPI, this.dPJ);
    }
    
    public final a y(cb paramcb)
    {
      if ((paramcb instanceof ao))
      {
        ao localao = (ao)paramcb;
        if (ao.a(localao) != this.dPI) {
          throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }
        ZQ();
        this.dPJ.a(ao.b(localao));
        W(ao.c(localao));
        int i = 0;
        paramcb = this;
        if (i < this.dPK.length)
        {
          if (this.dPK[i] == null) {
            this.dPK[i] = ao.d(localao)[i];
          }
          for (;;)
          {
            i += 1;
            break;
            if ((ao.d(localao)[i] != null) && (this.dPK[i] != ao.d(localao)[i]))
            {
              this.dPJ.c(this.dPK[i]);
              this.dPK[i] = ao.d(localao)[i];
            }
          }
        }
      }
      else
      {
        paramcb = (a)super.mergeFrom(paramcb);
      }
      return paramcb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.ao
 * JD-Core Version:    0.7.0.1
 */