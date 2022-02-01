package com.google.d;

import java.io.IOException;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class bt<K, V>
  extends a
{
  final b<K, V> dTv;
  private volatile int dTw = -1;
  public final K key;
  public final V value;
  
  private bt(am.a parama, du.a parama1, K paramK, du.a parama2, V paramV)
  {
    this.key = paramK;
    this.value = paramV;
    this.dTv = new b(parama, this, parama1, parama2);
  }
  
  private bt(b<K, V> paramb, i parami, at paramat)
  {
    try
    {
      this.dTv = paramb;
      Object localObject1 = paramb.dTC;
      Object localObject2 = paramb.dOI;
      int i;
      do
      {
        for (;;)
        {
          i = parami.aac();
          if (i == 0) {
            break label110;
          }
          if (i == du.cU(1, paramb.dTB.dWZ))
          {
            localObject1 = bu.a(parami, paramat, paramb.dTB, localObject1);
          }
          else
          {
            if (i != du.cU(2, paramb.dTD.dWZ)) {
              break;
            }
            localObject2 = bu.a(parami, paramat, paramb.dTD, localObject2);
          }
        }
      } while (parami.jN(i));
      label110:
      paramb = new AbstractMap.SimpleImmutableEntry(localObject1, localObject2);
      this.key = paramb.getKey();
      this.value = paramb.getValue();
      return;
    }
    catch (bk paramb)
    {
      paramb.dST = this;
      throw paramb;
    }
    catch (IOException paramb)
    {
      paramb = new bk(paramb);
      paramb.dST = this;
      throw paramb;
    }
  }
  
  private bt(b paramb, K paramK, V paramV)
  {
    this.key = paramK;
    this.value = paramV;
    this.dTv = paramb;
  }
  
  private void F(am.f paramf)
  {
    if (paramf.dOe != this.dTv.dJB) {
      throw new RuntimeException("Wrong FieldDescriptor \"" + paramf.fullName + "\" used in message \"" + this.dTv.dJB.fullName);
    }
  }
  
  public static <K, V> bt<K, V> a(am.a parama, du.a parama1, K paramK, du.a parama2, V paramV)
  {
    return new bt(parama, parama1, paramK, parama2, paramV);
  }
  
  private static <V> boolean a(b paramb, V paramV)
  {
    if (paramb.dTD.dWY == du.b.dXj) {
      return ((ce)paramV).isInitialized();
    }
    return true;
  }
  
  private a<K, V> aiB()
  {
    return new a(this.dTv, this.key, this.value);
  }
  
  private bt<K, V> aiC()
  {
    return new bt(this.dTv, this.dTv.dTC, this.dTv.dOI);
  }
  
  public final a<K, V> aiA()
  {
    return new a(this.dTv, (byte)0);
  }
  
  public final Map<am.f, Object> getAllFields()
  {
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator = this.dTv.dJB.getFields().iterator();
    while (localIterator.hasNext())
    {
      am.f localf = (am.f)localIterator.next();
      if (hasField(localf)) {
        localTreeMap.put(localf, getField(localf));
      }
    }
    return Collections.unmodifiableMap(localTreeMap);
  }
  
  public final am.a getDescriptorForType()
  {
    return this.dTv.dJB;
  }
  
  public final Object getField(am.f paramf)
  {
    F(paramf);
    if (paramf.dOB.dLq == 1) {}
    for (Object localObject1 = this.key;; localObject1 = this.value)
    {
      Object localObject2 = localObject1;
      if (paramf.dOE == am.f.b.dPh) {
        localObject2 = paramf.ahr().ld(((Integer)localObject1).intValue());
      }
      return localObject2;
    }
  }
  
  public final cs<bt<K, V>> getParserForType()
  {
    return this.dTv.dTz;
  }
  
  public final int getSerializedSize()
  {
    if (this.dTw != -1) {
      return this.dTw;
    }
    int i = bu.a(this.dTv, this.key, this.value);
    this.dTw = i;
    return i;
  }
  
  public final dn getUnknownFields()
  {
    return dn.ajF();
  }
  
  public final boolean hasField(am.f paramf)
  {
    F(paramf);
    return true;
  }
  
  public final boolean isInitialized()
  {
    return a(this.dTv, this.value);
  }
  
  public final void writeTo(k paramk)
  {
    bu.a(paramk, this.dTv, this.key, this.value);
  }
  
  public static final class a<K, V>
    extends a.a<a<K, V>>
  {
    private final bt.b<K, V> dTv;
    private boolean dTx;
    private boolean dTy;
    private K key;
    private V value;
    
    private a(bt.b<K, V> paramb)
    {
      this(paramb, paramb.dTC, paramb.dOI, false, false);
    }
    
    private a(bt.b<K, V> paramb, K paramK, V paramV, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.dTv = paramb;
      this.key = paramK;
      this.value = paramV;
      this.dTx = paramBoolean1;
      this.dTy = paramBoolean2;
    }
    
    private void F(am.f paramf)
    {
      if (paramf.dOe != this.dTv.dJB) {
        throw new RuntimeException("Wrong FieldDescriptor \"" + paramf.fullName + "\" used in message \"" + this.dTv.dJB.fullName);
      }
    }
    
    private bt<K, V> aiC()
    {
      return new bt(this.dTv, this.dTv.dTC, this.dTv.dOI, (byte)0);
    }
    
    private a<K, V> aiF()
    {
      return new a(this.dTv, this.key, this.value, this.dTx, this.dTy);
    }
    
    public final bt<K, V> aiD()
    {
      bt localbt = aiE();
      if (!localbt.isInitialized()) {
        throw newUninitializedMessageException(localbt);
      }
      return localbt;
    }
    
    public final bt<K, V> aiE()
    {
      return new bt(this.dTv, this.key, this.value, (byte)0);
    }
    
    public final a<K, V> by(K paramK)
    {
      this.key = paramK;
      this.dTx = true;
      return this;
    }
    
    public final a<K, V> bz(V paramV)
    {
      this.value = paramV;
      this.dTy = true;
      return this;
    }
    
    public final Map<am.f, Object> getAllFields()
    {
      TreeMap localTreeMap = new TreeMap();
      Iterator localIterator = this.dTv.dJB.getFields().iterator();
      while (localIterator.hasNext())
      {
        am.f localf = (am.f)localIterator.next();
        if (hasField(localf)) {
          localTreeMap.put(localf, getField(localf));
        }
      }
      return Collections.unmodifiableMap(localTreeMap);
    }
    
    public final am.a getDescriptorForType()
    {
      return this.dTv.dJB;
    }
    
    public final Object getField(am.f paramf)
    {
      F(paramf);
      if (paramf.dOB.dLq == 1) {}
      for (Object localObject1 = this.key;; localObject1 = this.value)
      {
        Object localObject2 = localObject1;
        if (paramf.dOE == am.f.b.dPh) {
          localObject2 = paramf.ahr().ld(((Integer)localObject1).intValue());
        }
        return localObject2;
      }
    }
    
    public final dn getUnknownFields()
    {
      return dn.ajF();
    }
    
    public final boolean hasField(am.f paramf)
    {
      F(paramf);
      if (paramf.dOB.dLq == 1) {
        return this.dTx;
      }
      return this.dTy;
    }
    
    public final boolean isInitialized()
    {
      return bt.b(this.dTv, this.value);
    }
    
    public final cb.a newBuilderForField(am.f paramf)
    {
      F(paramf);
      if ((paramf.dOB.dLq != 2) || (paramf.dOE.dPm != am.f.a.dOR)) {
        throw new RuntimeException("\"" + paramf.fullName + "\" is not a message value field.");
      }
      return ((cb)this.value).newBuilderForType();
    }
  }
  
  static final class b<K, V>
    extends bu.a<K, V>
  {
    public final am.a dJB;
    public final cs<bt<K, V>> dTz;
    
    public b(am.a parama, bt<K, V> parambt, du.a parama1, du.a parama2)
    {
      super(bt.a(parambt), parama2, bt.b(parambt));
      this.dJB = parama;
      this.dTz = new c() {};
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bt
 * JD-Core Version:    0.7.0.1
 */