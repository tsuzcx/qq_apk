package com.google.d;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class a
  extends b
  implements cb
{
  protected int memoizedSize = -1;
  
  private static boolean compareBytes(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof byte[])) && ((paramObject2 instanceof byte[]))) {
      return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
    }
    return toByteString(paramObject1).equals(toByteString(paramObject2));
  }
  
  static boolean compareFields(Map<am.f, Object> paramMap1, Map<am.f, Object> paramMap2)
  {
    if (paramMap1.size() != paramMap2.size()) {
      return false;
    }
    Iterator localIterator = paramMap1.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject2 = (am.f)localIterator.next();
        if (!paramMap2.containsKey(localObject2)) {
          break;
        }
        Object localObject3 = paramMap1.get(localObject2);
        Object localObject1 = paramMap2.get(localObject2);
        if (((am.f)localObject2).dOE == am.f.b.dPf)
        {
          if (((am.f)localObject2).ahl())
          {
            localObject2 = (List)localObject3;
            localObject1 = (List)localObject1;
            if (((List)localObject2).size() != ((List)localObject1).size()) {
              break;
            }
            int i = 0;
            for (;;)
            {
              if (i >= ((List)localObject2).size()) {
                break label170;
              }
              if (!compareBytes(((List)localObject2).get(i), ((List)localObject1).get(i))) {
                break;
              }
              i += 1;
            }
            label170:
            continue;
          }
          if (compareBytes(localObject3, localObject1)) {
            continue;
          }
          return false;
        }
        if (((am.f)localObject2).ahi())
        {
          if (!compareMapField(localObject3, localObject1)) {
            return false;
          }
        }
        else if (!localObject3.equals(localObject1)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private static boolean compareMapField(Object paramObject1, Object paramObject2)
  {
    return bw.b(convertMapEntryListToMap((List)paramObject1), convertMapEntryListToMap((List)paramObject2));
  }
  
  private static Map convertMapEntryListToMap(List paramList)
  {
    if (paramList.isEmpty()) {
      return Collections.emptyMap();
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    cb localcb = (cb)localIterator.next();
    paramList = localcb.getDescriptorForType();
    am.f localf1 = paramList.eb("key");
    am.f localf2 = paramList.eb("value");
    Object localObject = localcb.getField(localf2);
    paramList = localObject;
    if ((localObject instanceof am.e)) {
      paramList = Integer.valueOf(((am.e)localObject).dOy.dLq);
    }
    localHashMap.put(localcb.getField(localf1), paramList);
    while (localIterator.hasNext())
    {
      localcb = (cb)localIterator.next();
      localObject = localcb.getField(localf2);
      paramList = localObject;
      if ((localObject instanceof am.e)) {
        paramList = Integer.valueOf(((am.e)localObject).dOy.dLq);
      }
      localHashMap.put(localcb.getField(localf1), paramList);
    }
    return localHashMap;
  }
  
  @Deprecated
  protected static int hashBoolean(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  @Deprecated
  protected static int hashEnum(bj.c paramc)
  {
    return paramc.getNumber();
  }
  
  @Deprecated
  protected static int hashEnumList(List<? extends bj.c> paramList)
  {
    paramList = paramList.iterator();
    for (int i = 1; paramList.hasNext(); i = hashEnum((bj.c)paramList.next()) + i * 31) {}
    return i;
  }
  
  protected static int hashFields(int paramInt, Map<am.f, Object> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      am.f localf = (am.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      paramInt = paramInt * 37 + localf.dOB.dLq;
      if (localf.ahi()) {
        paramInt = paramInt * 53 + hashMapField(localObject);
      } else if (localf.dOE != am.f.b.dPh) {
        paramInt = paramInt * 53 + localObject.hashCode();
      } else if (localf.ahl()) {
        paramInt = paramInt * 53 + bj.hashEnumList((List)localObject);
      } else {
        paramInt = paramInt * 53 + bj.hashEnum((bj.c)localObject);
      }
    }
    return paramInt;
  }
  
  @Deprecated
  protected static int hashLong(long paramLong)
  {
    return (int)(paramLong >>> 32 ^ paramLong);
  }
  
  private static int hashMapField(Object paramObject)
  {
    return bw.f(convertMapEntryListToMap((List)paramObject));
  }
  
  private static h toByteString(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return h.z((byte[])paramObject);
    }
    return (h)paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof cb)) {
        return false;
      }
      paramObject = (cb)paramObject;
      if (getDescriptorForType() != paramObject.getDescriptorForType()) {
        return false;
      }
    } while ((compareFields(getAllFields(), paramObject.getAllFields())) && (getUnknownFields().equals(paramObject.getUnknownFields())));
    return false;
  }
  
  public List<String> findInitializationErrors()
  {
    return ci.a(this);
  }
  
  public String getInitializationErrorString()
  {
    return ci.aJ(findInitializationErrors());
  }
  
  int getMemoizedSerializedSize()
  {
    return this.memoizedSize;
  }
  
  public am.f getOneofFieldDescriptor(am.j paramj)
  {
    throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    this.memoizedSize = ci.b(this, getAllFields());
    return this.memoizedSize;
  }
  
  public boolean hasOneof(am.j paramj)
  {
    throw new UnsupportedOperationException("hasOneof() is not implemented.");
  }
  
  public int hashCode()
  {
    int j = this.memoizedHashCode;
    int i = j;
    if (j == 0)
    {
      i = hashFields(getDescriptorForType().hashCode() + 779, getAllFields()) * 29 + getUnknownFields().hashCode();
      this.memoizedHashCode = i;
    }
    return i;
  }
  
  public boolean isInitialized()
  {
    Iterator localIterator = getDescriptorForType().getFields().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (am.f)localIterator.next();
      if ((((am.f)localObject).ahj()) && (!hasField((am.f)localObject))) {
        return false;
      }
    }
    localIterator = getAllFields().entrySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        am.f localf = (am.f)((Map.Entry)localObject).getKey();
        if (localf.dOE.dPm == am.f.a.dOR)
        {
          if (localf.ahl())
          {
            localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
            if (!((Iterator)localObject).hasNext()) {
              continue;
            }
            if (((cb)((Iterator)localObject).next()).isInitialized()) {
              break;
            }
            return false;
          }
          if (!((cb)((Map.Entry)localObject).getValue()).isInitialized()) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  protected cb.a newBuilderForType(b paramb)
  {
    throw new UnsupportedOperationException("Nested builder is not supported for this type.");
  }
  
  dl newUninitializedMessageException()
  {
    return a.newUninitializedMessageException(this);
  }
  
  void setMemoizedSerializedSize(int paramInt)
  {
    this.memoizedSize = paramInt;
  }
  
  public final String toString()
  {
    return di.b(this);
  }
  
  public void writeTo(k paramk)
  {
    ci.a(this, getAllFields(), paramk);
  }
  
  public static abstract class a<BuilderType extends a<BuilderType>>
    extends b.a
    implements cb.a
  {
    protected static dl newUninitializedMessageException(cb paramcb)
    {
      return new dl(ci.a(paramcb));
    }
    
    public BuilderType clear()
    {
      Iterator localIterator = getAllFields().entrySet().iterator();
      while (localIterator.hasNext()) {
        clearField((am.f)((Map.Entry)localIterator.next()).getKey());
      }
      return this;
    }
    
    public BuilderType clearOneof(am.j paramj)
    {
      throw new UnsupportedOperationException("clearOneof() is not implemented.");
    }
    
    public BuilderType clone()
    {
      throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
    }
    
    void dispose()
    {
      throw new IllegalStateException("Should be overridden by subclasses.");
    }
    
    public List<String> findInitializationErrors()
    {
      return ci.a(this);
    }
    
    public cb.a getFieldBuilder(am.f paramf)
    {
      throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
    }
    
    public String getInitializationErrorString()
    {
      return ci.aJ(findInitializationErrors());
    }
    
    public am.f getOneofFieldDescriptor(am.j paramj)
    {
      throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }
    
    public cb.a getRepeatedFieldBuilder(am.f paramf, int paramInt)
    {
      throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on an unsupported message type.");
    }
    
    public boolean hasOneof(am.j paramj)
    {
      throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }
    
    protected BuilderType internalMergeFrom(b paramb)
    {
      return mergeFrom((cb)paramb);
    }
    
    void markClean()
    {
      throw new IllegalStateException("Should be overridden by subclasses.");
    }
    
    public boolean mergeDelimitedFrom(InputStream paramInputStream)
    {
      return super.mergeDelimitedFrom(paramInputStream);
    }
    
    public boolean mergeDelimitedFrom(InputStream paramInputStream, at paramat)
    {
      return super.mergeDelimitedFrom(paramInputStream, paramat);
    }
    
    public BuilderType mergeFrom(cb paramcb)
    {
      return mergeFrom(paramcb, paramcb.getAllFields());
    }
    
    BuilderType mergeFrom(cb paramcb, Map<am.f, Object> paramMap)
    {
      if (paramcb.getDescriptorForType() != getDescriptorForType()) {
        throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        am.f localf = (am.f)((Map.Entry)localObject).getKey();
        if (localf.ahl())
        {
          localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
          while (((Iterator)localObject).hasNext()) {
            addRepeatedField(localf, ((Iterator)localObject).next());
          }
        }
        else if (localf.dOE.dPm == am.f.a.dOR)
        {
          cb localcb = (cb)getField(localf);
          if (localcb == localcb.getDefaultInstanceForType()) {
            setField(localf, ((Map.Entry)localObject).getValue());
          } else {
            setField(localf, localcb.newBuilderForType().mergeFrom(localcb).mergeFrom((cb)((Map.Entry)localObject).getValue()).build());
          }
        }
        else
        {
          setField(localf, ((Map.Entry)localObject).getValue());
        }
      }
      mergeUnknownFields(paramcb.getUnknownFields());
      return this;
    }
    
    public BuilderType mergeFrom(h paramh)
    {
      return (a)super.mergeFrom(paramh);
    }
    
    public BuilderType mergeFrom(h paramh, at paramat)
    {
      return (a)super.mergeFrom(paramh, paramat);
    }
    
    public BuilderType mergeFrom(i parami)
    {
      return mergeFrom(parami, ar.ahE());
    }
    
    public BuilderType mergeFrom(i parami, at paramat)
    {
      dn.a locala;
      if (parami.dIV) {
        locala = null;
      }
      for (;;)
      {
        int i = parami.aac();
        if (i != 0)
        {
          ci.a locala1 = new ci.a(this);
          if (ci.a(parami, locala, paramat, getDescriptorForType(), locala1, i)) {}
        }
        else
        {
          if (locala != null) {
            setUnknownFields(locala.ajH());
          }
          return this;
          locala = dn.Y(getUnknownFields());
        }
      }
    }
    
    public BuilderType mergeFrom(InputStream paramInputStream)
    {
      return (a)super.mergeFrom(paramInputStream);
    }
    
    public BuilderType mergeFrom(InputStream paramInputStream, at paramat)
    {
      return (a)super.mergeFrom(paramInputStream, paramat);
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte)
    {
      return (a)super.mergeFrom(paramArrayOfByte);
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      return (a)super.mergeFrom(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, at paramat)
    {
      return (a)super.mergeFrom(paramArrayOfByte, paramInt1, paramInt2, paramat);
    }
    
    public BuilderType mergeFrom(byte[] paramArrayOfByte, at paramat)
    {
      return (a)super.mergeFrom(paramArrayOfByte, paramat);
    }
    
    public BuilderType mergeUnknownFields(dn paramdn)
    {
      setUnknownFields(dn.Y(getUnknownFields()).aa(paramdn).ajH());
      return this;
    }
    
    public String toString()
    {
      return di.b(this);
    }
  }
  
  public static abstract interface b
  {
    public abstract void ZN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.a
 * JD-Core Version:    0.7.0.1
 */