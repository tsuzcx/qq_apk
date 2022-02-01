package com.google.d;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public abstract class bg
  extends a
  implements Serializable
{
  public static boolean alwaysUseFieldBuilders = false;
  private static final long serialVersionUID = 1L;
  public dn unknownFields;
  
  protected bg()
  {
    this.unknownFields = dn.ajF();
  }
  
  protected bg(a<?> parama)
  {
    this.unknownFields = parama.getUnknownFields();
  }
  
  protected static boolean canUseUnsafe()
  {
    return (ds.ajO()) && (ds.ajP());
  }
  
  private static <MessageType extends d<MessageType>, T> ap<MessageType, T> checkNotLite(aq<MessageType, T> paramaq)
  {
    if (aq.ahD()) {
      throw new IllegalArgumentException("Expected non-lite extension.");
    }
    return (ap)paramaq;
  }
  
  protected static int computeStringSize(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return k.h(paramInt, (String)paramObject);
    }
    return k.c(paramInt, (h)paramObject);
  }
  
  protected static int computeStringSizeNoTag(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return k.dU((String)paramObject);
    }
    return k.b((h)paramObject);
  }
  
  protected static bj.a emptyBooleanList()
  {
    return f.ZS();
  }
  
  protected static bj.b emptyDoubleList()
  {
    return an.ahv();
  }
  
  protected static bj.f emptyFloatList()
  {
    return bb.ahU();
  }
  
  protected static bj.g emptyIntList()
  {
    return bi.aih();
  }
  
  protected static bj.h emptyLongList()
  {
    return br.aiy();
  }
  
  static void enableAlwaysUseFieldBuildersForTesting()
  {
    alwaysUseFieldBuilders = true;
  }
  
  private Map<am.f, Object> getAllFieldsMutable(boolean paramBoolean)
  {
    TreeMap localTreeMap = new TreeMap();
    List localList = e.a(internalGetFieldAccessorTable()).getFields();
    int i = 0;
    if (i < localList.size())
    {
      am.f localf = (am.f)localList.get(i);
      Object localObject = localf.dOG;
      int j;
      if (localObject != null)
      {
        i += ((am.j)localObject).dPD - 1;
        j = i;
        if (hasOneof((am.j)localObject))
        {
          localf = getOneofFieldDescriptor((am.j)localObject);
          label88:
          if ((!paramBoolean) || (localf.dOE.dPm != am.f.a.dOO)) {
            break label189;
          }
          localTreeMap.put(localf, getFieldRaw(localf));
          j = i;
        }
      }
      for (;;)
      {
        i = j + 1;
        break;
        if (localf.ahl())
        {
          localObject = (List)getField(localf);
          j = i;
          if (!((List)localObject).isEmpty())
          {
            localTreeMap.put(localf, localObject);
            j = i;
          }
        }
        else
        {
          j = i;
          if (hasField(localf))
          {
            break label88;
            label189:
            localTreeMap.put(localf, getField(localf));
            j = i;
          }
        }
      }
    }
    return localTreeMap;
  }
  
  private static Method getMethodOrDie(Class paramClass, String paramString, Class... paramVarArgs)
  {
    try
    {
      paramVarArgs = paramClass.getMethod(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (NoSuchMethodException paramVarArgs)
    {
      throw new RuntimeException("Generated message class \"" + paramClass.getName() + "\" missing method \"" + paramString + "\".", paramVarArgs);
    }
  }
  
  private static Object invokeOrDie(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (IllegalAccessException paramMethod)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", paramMethod);
    }
    catch (InvocationTargetException paramMethod)
    {
      paramMethod = paramMethod.getCause();
      if ((paramMethod instanceof RuntimeException)) {
        throw ((RuntimeException)paramMethod);
      }
      if ((paramMethod instanceof Error)) {
        throw ((Error)paramMethod);
      }
      throw new RuntimeException("Unexpected exception thrown by generated accessor method.", paramMethod);
    }
  }
  
  private static <V> void maybeSerializeBooleanEntryTo(k paramk, Map<Boolean, V> paramMap, bt<Boolean, V> parambt, int paramInt, boolean paramBoolean)
  {
    if (paramMap.containsKey(Boolean.valueOf(paramBoolean))) {
      paramk.a(paramInt, parambt.aiA().by(Boolean.valueOf(paramBoolean)).bz(paramMap.get(Boolean.valueOf(paramBoolean))).aiD());
    }
  }
  
  protected static bj.a mutableCopy(bj.a parama)
  {
    int i = parama.size();
    if (i == 0) {
      i = 10;
    }
    for (;;)
    {
      return parama.jF(i);
      i *= 2;
    }
  }
  
  protected static bj.b mutableCopy(bj.b paramb)
  {
    int i = paramb.size();
    if (i == 0) {
      i = 10;
    }
    for (;;)
    {
      return paramb.le(i);
      i *= 2;
    }
  }
  
  protected static bj.f mutableCopy(bj.f paramf)
  {
    int i = paramf.size();
    if (i == 0) {
      i = 10;
    }
    for (;;)
    {
      return paramf.lh(i);
      i *= 2;
    }
  }
  
  protected static bj.g mutableCopy(bj.g paramg)
  {
    int i = paramg.size();
    if (i == 0) {
      i = 10;
    }
    for (;;)
    {
      return paramg.li(i);
      i *= 2;
    }
  }
  
  protected static bj.h mutableCopy(bj.h paramh)
  {
    int i = paramh.size();
    if (i == 0) {
      i = 10;
    }
    for (;;)
    {
      return paramh.lk(i);
      i *= 2;
    }
  }
  
  protected static bj.a newBooleanList()
  {
    return new f();
  }
  
  protected static bj.b newDoubleList()
  {
    return new an();
  }
  
  protected static bj.f newFloatList()
  {
    return new bb();
  }
  
  protected static bj.g newIntList()
  {
    return new bi();
  }
  
  protected static bj.h newLongList()
  {
    return new br();
  }
  
  public static <M extends cb> M parseDelimitedWithIOException(cs<M> paramcs, InputStream paramInputStream)
  {
    try
    {
      paramcs = (cb)paramcs.parseDelimitedFrom(paramInputStream);
      return paramcs;
    }
    catch (bk paramcs)
    {
      throw paramcs.aii();
    }
  }
  
  public static <M extends cb> M parseDelimitedWithIOException(cs<M> paramcs, InputStream paramInputStream, at paramat)
  {
    try
    {
      paramcs = (cb)paramcs.parseDelimitedFrom(paramInputStream, paramat);
      return paramcs;
    }
    catch (bk paramcs)
    {
      throw paramcs.aii();
    }
  }
  
  public static <M extends cb> M parseWithIOException(cs<M> paramcs, i parami)
  {
    try
    {
      paramcs = (cb)paramcs.parseFrom(parami);
      return paramcs;
    }
    catch (bk paramcs)
    {
      throw paramcs.aii();
    }
  }
  
  public static <M extends cb> M parseWithIOException(cs<M> paramcs, i parami, at paramat)
  {
    try
    {
      paramcs = (cb)paramcs.parseFrom(parami, paramat);
      return paramcs;
    }
    catch (bk paramcs)
    {
      throw paramcs.aii();
    }
  }
  
  public static <M extends cb> M parseWithIOException(cs<M> paramcs, InputStream paramInputStream)
  {
    try
    {
      paramcs = (cb)paramcs.parseFrom(paramInputStream);
      return paramcs;
    }
    catch (bk paramcs)
    {
      throw paramcs.aii();
    }
  }
  
  public static <M extends cb> M parseWithIOException(cs<M> paramcs, InputStream paramInputStream, at paramat)
  {
    try
    {
      paramcs = (cb)paramcs.parseFrom(paramInputStream, paramat);
      return paramcs;
    }
    catch (bk paramcs)
    {
      throw paramcs.aii();
    }
  }
  
  protected static <V> void serializeBooleanMapTo(k paramk, bv<Boolean, V> parambv, bt<Boolean, V> parambt, int paramInt)
  {
    parambv = parambv.aiG();
    if (!paramk.dJo)
    {
      serializeMapTo(paramk, parambv, parambt, paramInt);
      return;
    }
    maybeSerializeBooleanEntryTo(paramk, parambv, parambt, paramInt, false);
    maybeSerializeBooleanEntryTo(paramk, parambv, parambt, paramInt, true);
  }
  
  protected static <V> void serializeIntegerMapTo(k paramk, bv<Integer, V> parambv, bt<Integer, V> parambt, int paramInt)
  {
    int j = 0;
    parambv = parambv.aiG();
    if (!paramk.dJo) {
      serializeMapTo(paramk, parambv, parambt, paramInt);
    }
    for (;;)
    {
      return;
      int[] arrayOfInt = new int[parambv.size()];
      Iterator localIterator = parambv.keySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        arrayOfInt[i] = ((Integer)localIterator.next()).intValue();
        i += 1;
      }
      Arrays.sort(arrayOfInt);
      int k = arrayOfInt.length;
      i = j;
      while (i < k)
      {
        j = arrayOfInt[i];
        paramk.a(paramInt, parambt.aiA().by(Integer.valueOf(j)).bz(parambv.get(Integer.valueOf(j))).aiD());
        i += 1;
      }
    }
  }
  
  protected static <V> void serializeLongMapTo(k paramk, bv<Long, V> parambv, bt<Long, V> parambt, int paramInt)
  {
    int j = 0;
    parambv = parambv.aiG();
    if (!paramk.dJo) {
      serializeMapTo(paramk, parambv, parambt, paramInt);
    }
    for (;;)
    {
      return;
      long[] arrayOfLong = new long[parambv.size()];
      Iterator localIterator = parambv.keySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        arrayOfLong[i] = ((Long)localIterator.next()).longValue();
        i += 1;
      }
      Arrays.sort(arrayOfLong);
      int k = arrayOfLong.length;
      i = j;
      while (i < k)
      {
        long l = arrayOfLong[i];
        paramk.a(paramInt, parambt.aiA().by(Long.valueOf(l)).bz(parambv.get(Long.valueOf(l))).aiD());
        i += 1;
      }
    }
  }
  
  private static <K, V> void serializeMapTo(k paramk, Map<K, V> paramMap, bt<K, V> parambt, int paramInt)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramk.a(paramInt, parambt.aiA().by(localEntry.getKey()).bz(localEntry.getValue()).aiD());
    }
  }
  
  protected static <V> void serializeStringMapTo(k paramk, bv<String, V> parambv, bt<String, V> parambt, int paramInt)
  {
    parambv = parambv.aiG();
    if (!paramk.dJo) {
      serializeMapTo(paramk, parambv, parambt, paramInt);
    }
    for (;;)
    {
      return;
      String[] arrayOfString = new String[parambv.size()];
      arrayOfString = (String[])parambv.keySet().toArray(arrayOfString);
      Arrays.sort(arrayOfString);
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        paramk.a(paramInt, parambt.aiA().by(str).bz(parambv.get(str)).aiD());
        i += 1;
      }
    }
  }
  
  protected static void writeString(k paramk, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramk.g(paramInt, (String)paramObject);
      return;
    }
    paramk.a(paramInt, (h)paramObject);
  }
  
  protected static void writeStringNoTag(k paramk, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramk.dT((String)paramObject);
      return;
    }
    paramk.a((h)paramObject);
  }
  
  public Map<am.f, Object> getAllFields()
  {
    return Collections.unmodifiableMap(getAllFieldsMutable(false));
  }
  
  Map<am.f, Object> getAllFieldsRaw()
  {
    return Collections.unmodifiableMap(getAllFieldsMutable(true));
  }
  
  public am.a getDescriptorForType()
  {
    return e.a(internalGetFieldAccessorTable());
  }
  
  public Object getField(am.f paramf)
  {
    return e.a(internalGetFieldAccessorTable(), paramf).a(this);
  }
  
  Object getFieldRaw(am.f paramf)
  {
    return e.a(internalGetFieldAccessorTable(), paramf).b(this);
  }
  
  public am.f getOneofFieldDescriptor(am.j paramj)
  {
    paramj = e.a(internalGetFieldAccessorTable(), paramj);
    int i = ((bj.c)invokeOrDie(paramj.dSh, this, new Object[0])).getNumber();
    if (i > 0) {
      return paramj.dJB.lb(i);
    }
    return null;
  }
  
  public cs<? extends bg> getParserForType()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public Object getRepeatedField(am.f paramf, int paramInt)
  {
    return e.a(internalGetFieldAccessorTable(), paramf).a(this, paramInt);
  }
  
  public int getRepeatedFieldCount(am.f paramf)
  {
    return e.a(internalGetFieldAccessorTable(), paramf).d(this);
  }
  
  public int getSerializedSize()
  {
    int i = this.memoizedSize;
    if (i != -1) {
      return i;
    }
    this.memoizedSize = ci.b(this, getAllFieldsRaw());
    return this.memoizedSize;
  }
  
  public dn getUnknownFields()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
  
  public boolean hasField(am.f paramf)
  {
    return e.a(internalGetFieldAccessorTable(), paramf).c(this);
  }
  
  public boolean hasOneof(am.j paramj)
  {
    return ((bj.c)invokeOrDie(e.a(internalGetFieldAccessorTable(), paramj).dSh, this, new Object[0])).getNumber() != 0;
  }
  
  protected abstract e internalGetFieldAccessorTable();
  
  protected bv internalGetMapField(int paramInt)
  {
    throw new RuntimeException("No map fields found in " + getClass().getName());
  }
  
  public boolean isInitialized()
  {
    Iterator localIterator = getDescriptorForType().getFields().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject = (am.f)localIterator.next();
        if ((((am.f)localObject).ahj()) && (!hasField((am.f)localObject))) {
          return false;
        }
        if (((am.f)localObject).dOE.dPm == am.f.a.dOR)
        {
          if (((am.f)localObject).ahl())
          {
            localObject = ((List)getField((am.f)localObject)).iterator();
            if (!((Iterator)localObject).hasNext()) {
              continue;
            }
            if (((cb)((Iterator)localObject).next()).isInitialized()) {
              break;
            }
            return false;
          }
          if ((hasField((am.f)localObject)) && (!((cb)getField((am.f)localObject)).isInitialized())) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  protected void makeExtensionsImmutable() {}
  
  protected cb.a newBuilderForType(final a.b paramb)
  {
    newBuilderForType(new b()
    {
      public final void ZN()
      {
        paramb.ZN();
      }
    });
  }
  
  protected abstract cb.a newBuilderForType(b paramb);
  
  protected Object newInstance(f paramf)
  {
    throw new UnsupportedOperationException("This method must be overridden by the subclass.");
  }
  
  protected boolean parseUnknownField(i parami, dn.a parama, at paramat, int paramInt)
  {
    if (parami.dIV) {
      return parami.jN(paramInt);
    }
    return parama.a(paramInt, parami);
  }
  
  protected boolean parseUnknownFieldProto3(i parami, dn.a parama, at paramat, int paramInt)
  {
    return parseUnknownField(parami, parama, paramat, paramInt);
  }
  
  protected Object writeReplace()
  {
    return new be.d(this);
  }
  
  public void writeTo(k paramk)
  {
    ci.a(this, getAllFieldsRaw(), paramk);
  }
  
  public static abstract class a<BuilderType extends a<BuilderType>>
    extends a.a<BuilderType>
  {
    private bg.b builderParent;
    private boolean isClean;
    private a<BuilderType>.a meAsParent;
    private dn unknownFields = dn.ajF();
    
    protected a()
    {
      this(null);
    }
    
    protected a(bg.b paramb)
    {
      this.builderParent = paramb;
    }
    
    private Map<am.f, Object> getAllFieldsMutable()
    {
      TreeMap localTreeMap = new TreeMap();
      List localList = bg.e.a(internalGetFieldAccessorTable()).getFields();
      int i = 0;
      if (i < localList.size())
      {
        am.f localf = (am.f)localList.get(i);
        Object localObject = localf.dOG;
        int j;
        if (localObject != null)
        {
          i += ((am.j)localObject).dPD - 1;
          j = i;
          if (hasOneof((am.j)localObject)) {
            localf = getOneofFieldDescriptor((am.j)localObject);
          }
        }
        for (;;)
        {
          localTreeMap.put(localf, getField(localf));
          j = i;
          label149:
          do
          {
            for (;;)
            {
              i = j + 1;
              break;
              if (!localf.ahl()) {
                break label149;
              }
              localObject = (List)getField(localf);
              j = i;
              if (!((List)localObject).isEmpty())
              {
                localTreeMap.put(localf, localObject);
                j = i;
              }
            }
            j = i;
          } while (!hasField(localf));
        }
      }
      return localTreeMap;
    }
    
    private BuilderType setUnknownFieldsInternal(dn paramdn)
    {
      this.unknownFields = paramdn;
      onChanged();
      return this;
    }
    
    public BuilderType addRepeatedField(am.f paramf, Object paramObject)
    {
      bg.e.a(internalGetFieldAccessorTable(), paramf).b(this, paramObject);
      return this;
    }
    
    public BuilderType clear()
    {
      this.unknownFields = dn.ajF();
      onChanged();
      return this;
    }
    
    public BuilderType clearField(am.f paramf)
    {
      bg.e.a(internalGetFieldAccessorTable(), paramf).d(this);
      return this;
    }
    
    public BuilderType clearOneof(am.j paramj)
    {
      bg.invokeOrDie(bg.e.a(internalGetFieldAccessorTable(), paramj).dSj, this, new Object[0]);
      return this;
    }
    
    public BuilderType clone()
    {
      a locala = (a)getDefaultInstanceForType().newBuilderForType();
      locala.mergeFrom(buildPartial());
      return locala;
    }
    
    void dispose()
    {
      this.builderParent = null;
    }
    
    public Map<am.f, Object> getAllFields()
    {
      return Collections.unmodifiableMap(getAllFieldsMutable());
    }
    
    public am.a getDescriptorForType()
    {
      return bg.e.a(internalGetFieldAccessorTable());
    }
    
    public Object getField(am.f paramf)
    {
      Object localObject2 = bg.e.a(internalGetFieldAccessorTable(), paramf).a(this);
      Object localObject1 = localObject2;
      if (paramf.ahl()) {
        localObject1 = Collections.unmodifiableList((List)localObject2);
      }
      return localObject1;
    }
    
    public cb.a getFieldBuilder(am.f paramf)
    {
      return bg.e.a(internalGetFieldAccessorTable(), paramf).e(this);
    }
    
    public am.f getOneofFieldDescriptor(am.j paramj)
    {
      paramj = bg.e.a(internalGetFieldAccessorTable(), paramj);
      int i = ((bj.c)bg.invokeOrDie(paramj.dSi, this, new Object[0])).getNumber();
      if (i > 0) {
        return paramj.dJB.lb(i);
      }
      return null;
    }
    
    protected bg.b getParentForChildren()
    {
      if (this.meAsParent == null) {
        this.meAsParent = new a((byte)0);
      }
      return this.meAsParent;
    }
    
    public Object getRepeatedField(am.f paramf, int paramInt)
    {
      return bg.e.a(internalGetFieldAccessorTable(), paramf).a(this, paramInt);
    }
    
    public cb.a getRepeatedFieldBuilder(am.f paramf, int paramInt)
    {
      return bg.e.a(internalGetFieldAccessorTable(), paramf).b(this, paramInt);
    }
    
    public int getRepeatedFieldCount(am.f paramf)
    {
      return bg.e.a(internalGetFieldAccessorTable(), paramf).c(this);
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public boolean hasField(am.f paramf)
    {
      return bg.e.a(internalGetFieldAccessorTable(), paramf).b(this);
    }
    
    public boolean hasOneof(am.j paramj)
    {
      return ((bj.c)bg.invokeOrDie(bg.e.a(internalGetFieldAccessorTable(), paramj).dSi, this, new Object[0])).getNumber() != 0;
    }
    
    protected abstract bg.e internalGetFieldAccessorTable();
    
    protected bv internalGetMapField(int paramInt)
    {
      throw new RuntimeException("No map fields found in " + getClass().getName());
    }
    
    protected bv internalGetMutableMapField(int paramInt)
    {
      throw new RuntimeException("No map fields found in " + getClass().getName());
    }
    
    protected boolean isClean()
    {
      return this.isClean;
    }
    
    public boolean isInitialized()
    {
      Iterator localIterator = getDescriptorForType().getFields().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = (am.f)localIterator.next();
          if ((((am.f)localObject).ahj()) && (!hasField((am.f)localObject))) {
            return false;
          }
          if (((am.f)localObject).dOE.dPm == am.f.a.dOR)
          {
            if (((am.f)localObject).ahl())
            {
              localObject = ((List)getField((am.f)localObject)).iterator();
              if (!((Iterator)localObject).hasNext()) {
                continue;
              }
              if (((cb)((Iterator)localObject).next()).isInitialized()) {
                break;
              }
              return false;
            }
            if ((hasField((am.f)localObject)) && (!((cb)getField((am.f)localObject)).isInitialized())) {
              return false;
            }
          }
        }
      }
      return true;
    }
    
    protected void markClean()
    {
      this.isClean = true;
    }
    
    public BuilderType mergeUnknownFields(dn paramdn)
    {
      return setUnknownFields(dn.Y(this.unknownFields).aa(paramdn).ajH());
    }
    
    public cb.a newBuilderForField(am.f paramf)
    {
      return bg.e.a(internalGetFieldAccessorTable(), paramf).aig();
    }
    
    protected void onBuilt()
    {
      if (this.builderParent != null) {
        markClean();
      }
    }
    
    protected final void onChanged()
    {
      if ((this.isClean) && (this.builderParent != null))
      {
        this.builderParent.ZN();
        this.isClean = false;
      }
    }
    
    public BuilderType setField(am.f paramf, Object paramObject)
    {
      bg.e.a(internalGetFieldAccessorTable(), paramf).a(this, paramObject);
      return this;
    }
    
    public BuilderType setRepeatedField(am.f paramf, int paramInt, Object paramObject)
    {
      bg.e.a(internalGetFieldAccessorTable(), paramf).a(this, paramInt, paramObject);
      return this;
    }
    
    public BuilderType setUnknownFields(dn paramdn)
    {
      return setUnknownFieldsInternal(paramdn);
    }
    
    protected BuilderType setUnknownFieldsProto3(dn paramdn)
    {
      return setUnknownFieldsInternal(paramdn);
    }
    
    class a
      implements bg.b
    {
      private a() {}
      
      public final void ZN()
      {
        bg.a.this.onChanged();
      }
    }
  }
  
  public static abstract interface b
    extends a.b
  {}
  
  public static abstract class c<MessageType extends bg.d, BuilderType extends c<MessageType, BuilderType>>
    extends bg.a<BuilderType>
    implements bh<MessageType>
  {
    private az<am.f> dRL = az.ahR();
    
    protected c() {}
    
    protected c(bg.b paramb)
    {
      super();
    }
    
    private void D(am.f paramf)
    {
      if (paramf.dOe != getDescriptorForType()) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
    }
    
    private void aib()
    {
      if (this.dRL.bRu) {
        this.dRL = this.dRL.ahS();
      }
    }
    
    protected final void a(bg.d paramd)
    {
      aib();
      this.dRL.a(bg.d.b(paramd));
      onChanged();
    }
    
    public BuilderType adc()
    {
      this.dRL = az.ahR();
      return (c)super.clear();
    }
    
    protected final boolean aic()
    {
      return this.dRL.isInitialized();
    }
    
    public BuilderType g(am.f paramf, int paramInt, Object paramObject)
    {
      if (paramf.dOB.adB())
      {
        D(paramf);
        aib();
        Object localObject = this.dRL;
        if (!paramf.ahl()) {
          throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        localObject = ((az)localObject).b(paramf);
        if (localObject == null) {
          throw new IndexOutOfBoundsException();
        }
        az.a(paramf.ahg(), paramObject);
        ((List)localObject).set(paramInt, paramObject);
        onChanged();
        return this;
      }
      return (c)super.setRepeatedField(paramf, paramInt, paramObject);
    }
    
    public Map<am.f, Object> getAllFields()
    {
      Map localMap = super.getAllFieldsMutable();
      localMap.putAll(this.dRL.getAllFields());
      return Collections.unmodifiableMap(localMap);
    }
    
    public Object getField(am.f paramf)
    {
      if (paramf.dOB.adB())
      {
        D(paramf);
        Object localObject2 = this.dRL.b(paramf);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (paramf.dOE.dPm == am.f.a.dOR) {
            localObject1 = ao.d(paramf.ahq());
          }
        }
        else {
          return localObject1;
        }
        return paramf.aho();
      }
      return super.getField(paramf);
    }
    
    public Object getRepeatedField(am.f paramf, int paramInt)
    {
      if (paramf.dOB.adB())
      {
        D(paramf);
        return this.dRL.a(paramf, paramInt);
      }
      return super.getRepeatedField(paramf, paramInt);
    }
    
    public int getRepeatedFieldCount(am.f paramf)
    {
      if (paramf.dOB.adB())
      {
        D(paramf);
        return this.dRL.d(paramf);
      }
      return super.getRepeatedFieldCount(paramf);
    }
    
    public boolean hasField(am.f paramf)
    {
      if (paramf.dOB.adB())
      {
        D(paramf);
        return this.dRL.a(paramf);
      }
      return super.hasField(paramf);
    }
    
    public boolean isInitialized()
    {
      return (super.isInitialized()) && (this.dRL.isInitialized());
    }
    
    public BuilderType j(am.f paramf)
    {
      if (paramf.dOB.adB())
      {
        D(paramf);
        aib();
        this.dRL.c(paramf);
        onChanged();
        return this;
      }
      return (c)super.clearField(paramf);
    }
    
    public BuilderType m(am.f paramf, Object paramObject)
    {
      if (paramf.dOB.adB())
      {
        D(paramf);
        aib();
        this.dRL.b(paramf, paramObject);
        onChanged();
        return this;
      }
      return (c)super.addRepeatedField(paramf, paramObject);
    }
    
    public BuilderType n(am.f paramf, Object paramObject)
    {
      if (paramf.dOB.adB())
      {
        D(paramf);
        aib();
        this.dRL.a(paramf, paramObject);
        onChanged();
        return this;
      }
      return (c)super.setField(paramf, paramObject);
    }
    
    public cb.a newBuilderForField(am.f paramf)
    {
      if (paramf.dOB.adB()) {
        return ao.e(paramf.ahq());
      }
      return super.newBuilderForField(paramf);
    }
  }
  
  public static abstract class d<MessageType extends d>
    extends bg
    implements bh<MessageType>
  {
    final az<am.f> dRL;
    
    protected d()
    {
      this.dRL = az.ahQ();
    }
    
    protected d(bg.c<MessageType, ?> paramc)
    {
      super();
      this.dRL = bg.c.a(paramc);
    }
    
    private void D(am.f paramf)
    {
      if (paramf.dOe != getDescriptorForType()) {
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      }
    }
    
    protected final boolean aic()
    {
      return this.dRL.isInitialized();
    }
    
    protected final d<MessageType>.a aid()
    {
      return new a((byte)0);
    }
    
    protected final int aie()
    {
      return this.dRL.getSerializedSize();
    }
    
    protected final Map<am.f, Object> aif()
    {
      return this.dRL.getAllFields();
    }
    
    public Map<am.f, Object> getAllFields()
    {
      Map localMap = super.getAllFieldsMutable(false);
      localMap.putAll(this.dRL.getAllFields());
      return Collections.unmodifiableMap(localMap);
    }
    
    public Map<am.f, Object> getAllFieldsRaw()
    {
      Map localMap = super.getAllFieldsMutable(false);
      localMap.putAll(this.dRL.getAllFields());
      return Collections.unmodifiableMap(localMap);
    }
    
    public Object getField(am.f paramf)
    {
      if (paramf.dOB.adB())
      {
        D(paramf);
        Object localObject2 = this.dRL.b(paramf);
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
      return super.getField(paramf);
    }
    
    public Object getRepeatedField(am.f paramf, int paramInt)
    {
      if (paramf.dOB.adB())
      {
        D(paramf);
        return this.dRL.a(paramf, paramInt);
      }
      return super.getRepeatedField(paramf, paramInt);
    }
    
    public int getRepeatedFieldCount(am.f paramf)
    {
      if (paramf.dOB.adB())
      {
        D(paramf);
        return this.dRL.d(paramf);
      }
      return super.getRepeatedFieldCount(paramf);
    }
    
    public boolean hasField(am.f paramf)
    {
      if (paramf.dOB.adB())
      {
        D(paramf);
        return this.dRL.a(paramf);
      }
      return super.hasField(paramf);
    }
    
    public boolean isInitialized()
    {
      return (super.isInitialized()) && (this.dRL.isInitialized());
    }
    
    protected void makeExtensionsImmutable()
    {
      this.dRL.ZP();
    }
    
    protected boolean parseUnknownField(i parami, dn.a parama, at paramat, int paramInt)
    {
      if (parami.dIV) {
        parama = null;
      }
      for (;;)
      {
        return ci.a(parami, parama, paramat, getDescriptorForType(), new ci.b(this.dRL), paramInt);
      }
    }
    
    protected boolean parseUnknownFieldProto3(i parami, dn.a parama, at paramat, int paramInt)
    {
      return parseUnknownField(parami, parama, paramat, paramInt);
    }
    
    protected final class a
    {
      private Map.Entry<am.f, Object> ats;
      private final Iterator<Map.Entry<am.f, Object>> dRZ = bg.d.b(bg.d.this).iterator();
      private final boolean dSa;
      
      private a()
      {
        if (this.dRZ.hasNext()) {
          this.ats = ((Map.Entry)this.dRZ.next());
        }
        this.dSa = false;
      }
      
      public final void a(k paramk)
      {
        while ((this.ats != null) && (((am.f)this.ats.getKey()).dOB.dLq < 536870912))
        {
          am.f localf = (am.f)this.ats.getKey();
          if ((this.dSa) && (localf.ahg().dWY == du.b.dXj) && (!localf.ahl())) {
            if ((this.ats instanceof bm.a)) {
              paramk.b(localf.dOB.dLq, ((bm.a)this.ats).ait().toByteString());
            }
          }
          for (;;)
          {
            if (!this.dRZ.hasNext()) {
              break label178;
            }
            this.ats = ((Map.Entry)this.dRZ.next());
            break;
            paramk.b(localf.dOB.dLq, (cb)this.ats.getValue());
            continue;
            az.a(localf, this.ats.getValue(), paramk);
          }
          label178:
          this.ats = null;
        }
      }
    }
  }
  
  public static final class e
  {
    private final am.a dJB;
    private final a[] dSc;
    private String[] dSd;
    private final c[] dSe;
    private volatile boolean initialized;
    
    public e(am.a parama, String[] paramArrayOfString)
    {
      this.dJB = parama;
      this.dSd = paramArrayOfString;
      this.dSc = new a[parama.getFields().size()];
      this.dSe = new c[parama.aha().size()];
      this.initialized = false;
    }
    
    public final e b(Class<? extends bg> paramClass, Class<? extends bg.a> paramClass1)
    {
      if (this.initialized) {
        return this;
      }
      try
      {
        if (this.initialized) {
          return this;
        }
      }
      finally {}
      int j = this.dSc.length;
      int i = 0;
      for (;;)
      {
        am.f localf;
        if (i < j)
        {
          localf = (am.f)this.dJB.getFields().get(i);
          if (localf.dOG == null) {
            break label441;
          }
        }
        label441:
        for (String str = this.dSd[(localf.dOG.index + j)];; str = null)
        {
          if (localf.ahl())
          {
            if (localf.dOE.dPm == am.f.a.dOR)
            {
              if (localf.ahi())
              {
                this.dSc[i] = new b(localf, paramClass);
                break;
              }
              this.dSc[i] = new f(this.dSd[i], paramClass, paramClass1);
              break;
            }
            if (localf.dOE.dPm == am.f.a.dOQ)
            {
              this.dSc[i] = new d(localf, this.dSd[i], paramClass, paramClass1);
              break;
            }
            this.dSc[i] = new e(this.dSd[i], paramClass, paramClass1);
            break;
          }
          if (localf.dOE.dPm == am.f.a.dOR)
          {
            this.dSc[i] = new i(localf, this.dSd[i], paramClass, paramClass1, str);
            break;
          }
          if (localf.dOE.dPm == am.f.a.dOQ)
          {
            this.dSc[i] = new g(localf, this.dSd[i], paramClass, paramClass1, str);
            break;
          }
          if (localf.dOE.dPm == am.f.a.dOO)
          {
            this.dSc[i] = new j(localf, this.dSd[i], paramClass, paramClass1, str);
            break;
          }
          this.dSc[i] = new h(localf, this.dSd[i], paramClass, paramClass1, str);
          break;
          int k = this.dSe.length;
          i = 0;
          while (i < k)
          {
            this.dSe[i] = new c(this.dJB, this.dSd[(i + j)], paramClass, paramClass1);
            i += 1;
          }
          this.initialized = true;
          this.dSd = null;
          return this;
        }
        i += 1;
      }
    }
    
    static abstract interface a
    {
      public abstract Object a(bg.a parama);
      
      public abstract Object a(bg.a parama, int paramInt);
      
      public abstract Object a(bg parambg);
      
      public abstract Object a(bg parambg, int paramInt);
      
      public abstract void a(bg.a parama, int paramInt, Object paramObject);
      
      public abstract void a(bg.a parama, Object paramObject);
      
      public abstract cb.a aig();
      
      public abstract cb.a b(bg.a parama, int paramInt);
      
      public abstract Object b(bg parambg);
      
      public abstract void b(bg.a parama, Object paramObject);
      
      public abstract boolean b(bg.a parama);
      
      public abstract int c(bg.a parama);
      
      public abstract boolean c(bg parambg);
      
      public abstract int d(bg parambg);
      
      public abstract void d(bg.a parama);
      
      public abstract cb.a e(bg.a parama);
    }
    
    static final class b
      implements bg.e.a
    {
      private final am.f dSf;
      private final cb dSg;
      
      b(am.f paramf, Class<? extends bg> paramClass)
      {
        this.dSf = paramf;
        this.dSg = e((bg)bg.invokeOrDie(bg.access$1000(paramClass, "getDefaultInstance", new Class[0]), null, new Object[0])).dTH.aiM();
      }
      
      private bv<?, ?> e(bg parambg)
      {
        return parambg.internalGetMapField(this.dSf.dOB.dLq);
      }
      
      private bv<?, ?> f(bg.a parama)
      {
        return parama.internalGetMapField(this.dSf.dOB.dLq);
      }
      
      private bv<?, ?> g(bg.a parama)
      {
        return parama.internalGetMutableMapField(this.dSf.dOB.dLq);
      }
      
      private cb z(cb paramcb)
      {
        cb localcb;
        if (paramcb == null) {
          localcb = null;
        }
        do
        {
          return localcb;
          localcb = paramcb;
        } while (this.dSg.getClass().isInstance(paramcb));
        return this.dSg.toBuilder().mergeFrom(paramcb).build();
      }
      
      public final Object a(bg.a parama)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < c(parama))
        {
          localArrayList.add(a(parama, i));
          i += 1;
        }
        return Collections.unmodifiableList(localArrayList);
      }
      
      public final Object a(bg.a parama, int paramInt)
      {
        return f(parama).aiJ().get(paramInt);
      }
      
      public final Object a(bg parambg)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < d(parambg))
        {
          localArrayList.add(a(parambg, i));
          i += 1;
        }
        return Collections.unmodifiableList(localArrayList);
      }
      
      public final Object a(bg parambg, int paramInt)
      {
        return e(parambg).aiJ().get(paramInt);
      }
      
      public final void a(bg.a parama, int paramInt, Object paramObject)
      {
        g(parama).aiK().set(paramInt, z((cb)paramObject));
      }
      
      public final void a(bg.a parama, Object paramObject)
      {
        d(parama);
        paramObject = ((List)paramObject).iterator();
        while (paramObject.hasNext()) {
          b(parama, paramObject.next());
        }
      }
      
      public final cb.a aig()
      {
        return this.dSg.newBuilderForType();
      }
      
      public final cb.a b(bg.a parama, int paramInt)
      {
        throw new UnsupportedOperationException("Nested builder not supported for map fields.");
      }
      
      public final Object b(bg parambg)
      {
        return a(parambg);
      }
      
      public final void b(bg.a parama, Object paramObject)
      {
        g(parama).aiK().add(z((cb)paramObject));
      }
      
      public final boolean b(bg.a parama)
      {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
      }
      
      public final int c(bg.a parama)
      {
        return f(parama).aiJ().size();
      }
      
      public final boolean c(bg parambg)
      {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
      }
      
      public final int d(bg parambg)
      {
        return e(parambg).aiJ().size();
      }
      
      public final void d(bg.a parama)
      {
        g(parama).aiK().clear();
      }
      
      public final cb.a e(bg.a parama)
      {
        throw new UnsupportedOperationException("Nested builder not supported for map fields.");
      }
    }
    
    static final class c
    {
      final am.a dJB;
      final Method dSh;
      final Method dSi;
      final Method dSj;
      
      c(am.a parama, String paramString, Class<? extends bg> paramClass, Class<? extends bg.a> paramClass1)
      {
        this.dJB = parama;
        this.dSh = bg.getMethodOrDie(paramClass, "get" + paramString + "Case", new Class[0]);
        this.dSi = bg.getMethodOrDie(paramClass1, "get" + paramString + "Case", new Class[0]);
        this.dSj = bg.getMethodOrDie(paramClass1, "clear".concat(String.valueOf(paramString)), new Class[0]);
      }
    }
    
    static final class d
      extends bg.e.e
    {
      private am.d dSk;
      private final Method dSl;
      private final Method dSm;
      private boolean dSn;
      private Method dSo;
      private Method dSp;
      private Method dSq;
      private Method dSr;
      
      d(am.f paramf, String paramString, Class<? extends bg> paramClass, Class<? extends bg.a> paramClass1)
      {
        super(paramClass, paramClass1);
        this.dSk = paramf.ahr();
        this.dSl = bg.getMethodOrDie(this.dSs, "valueOf", new Class[] { am.e.class });
        this.dSm = bg.getMethodOrDie(this.dSs, "getValueDescriptor", new Class[0]);
        this.dSn = paramf.dOd.ahu();
        if (this.dSn)
        {
          this.dSo = bg.getMethodOrDie(paramClass, "get" + paramString + "Value", new Class[] { Integer.TYPE });
          this.dSp = bg.getMethodOrDie(paramClass1, "get" + paramString + "Value", new Class[] { Integer.TYPE });
          this.dSq = bg.getMethodOrDie(paramClass1, "set" + paramString + "Value", new Class[] { Integer.TYPE, Integer.TYPE });
          this.dSr = bg.getMethodOrDie(paramClass1, "add" + paramString + "Value", new Class[] { Integer.TYPE });
        }
      }
      
      public final Object a(bg.a parama)
      {
        ArrayList localArrayList = new ArrayList();
        int j = c(parama);
        int i = 0;
        while (i < j)
        {
          localArrayList.add(a(parama, i));
          i += 1;
        }
        return Collections.unmodifiableList(localArrayList);
      }
      
      public final Object a(bg.a parama, int paramInt)
      {
        if (this.dSn)
        {
          paramInt = ((Integer)bg.invokeOrDie(this.dSp, parama, new Object[] { Integer.valueOf(paramInt) })).intValue();
          return this.dSk.ld(paramInt);
        }
        return bg.invokeOrDie(this.dSm, super.a(parama, paramInt), new Object[0]);
      }
      
      public final Object a(bg parambg)
      {
        ArrayList localArrayList = new ArrayList();
        int j = d(parambg);
        int i = 0;
        while (i < j)
        {
          localArrayList.add(a(parambg, i));
          i += 1;
        }
        return Collections.unmodifiableList(localArrayList);
      }
      
      public final Object a(bg parambg, int paramInt)
      {
        if (this.dSn)
        {
          paramInt = ((Integer)bg.invokeOrDie(this.dSo, parambg, new Object[] { Integer.valueOf(paramInt) })).intValue();
          return this.dSk.ld(paramInt);
        }
        return bg.invokeOrDie(this.dSm, super.a(parambg, paramInt), new Object[0]);
      }
      
      public final void a(bg.a parama, int paramInt, Object paramObject)
      {
        if (this.dSn)
        {
          bg.invokeOrDie(this.dSq, parama, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(((am.e)paramObject).dOy.dLq) });
          return;
        }
        super.a(parama, paramInt, bg.invokeOrDie(this.dSl, null, new Object[] { paramObject }));
      }
      
      public final void b(bg.a parama, Object paramObject)
      {
        if (this.dSn)
        {
          bg.invokeOrDie(this.dSr, parama, new Object[] { Integer.valueOf(((am.e)paramObject).dOy.dLq) });
          return;
        }
        super.b(parama, bg.invokeOrDie(this.dSl, null, new Object[] { paramObject }));
      }
    }
    
    static class e
      implements bg.e.a
    {
      protected final Method dSA;
      protected final Method dSj;
      protected final Class dSs;
      protected final Method dSt;
      protected final Method dSu;
      protected final Method dSv;
      protected final Method dSw;
      protected final Method dSx;
      protected final Method dSy;
      protected final Method dSz;
      
      e(String paramString, Class<? extends bg> paramClass, Class<? extends bg.a> paramClass1)
      {
        this.dSt = bg.getMethodOrDie(paramClass, "get" + paramString + "List", new Class[0]);
        this.dSu = bg.getMethodOrDie(paramClass1, "get" + paramString + "List", new Class[0]);
        this.dSv = bg.getMethodOrDie(paramClass, "get".concat(String.valueOf(paramString)), new Class[] { Integer.TYPE });
        this.dSw = bg.getMethodOrDie(paramClass1, "get".concat(String.valueOf(paramString)), new Class[] { Integer.TYPE });
        this.dSs = this.dSv.getReturnType();
        this.dSx = bg.getMethodOrDie(paramClass1, "set".concat(String.valueOf(paramString)), new Class[] { Integer.TYPE, this.dSs });
        this.dSy = bg.getMethodOrDie(paramClass1, "add".concat(String.valueOf(paramString)), new Class[] { this.dSs });
        this.dSz = bg.getMethodOrDie(paramClass, "get" + paramString + "Count", new Class[0]);
        this.dSA = bg.getMethodOrDie(paramClass1, "get" + paramString + "Count", new Class[0]);
        this.dSj = bg.getMethodOrDie(paramClass1, "clear".concat(String.valueOf(paramString)), new Class[0]);
      }
      
      public Object a(bg.a parama)
      {
        return bg.invokeOrDie(this.dSu, parama, new Object[0]);
      }
      
      public Object a(bg.a parama, int paramInt)
      {
        return bg.invokeOrDie(this.dSw, parama, new Object[] { Integer.valueOf(paramInt) });
      }
      
      public Object a(bg parambg)
      {
        return bg.invokeOrDie(this.dSt, parambg, new Object[0]);
      }
      
      public Object a(bg parambg, int paramInt)
      {
        return bg.invokeOrDie(this.dSv, parambg, new Object[] { Integer.valueOf(paramInt) });
      }
      
      public void a(bg.a parama, int paramInt, Object paramObject)
      {
        bg.invokeOrDie(this.dSx, parama, new Object[] { Integer.valueOf(paramInt), paramObject });
      }
      
      public final void a(bg.a parama, Object paramObject)
      {
        d(parama);
        paramObject = ((List)paramObject).iterator();
        while (paramObject.hasNext()) {
          b(parama, paramObject.next());
        }
      }
      
      public cb.a aig()
      {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }
      
      public cb.a b(bg.a parama, int paramInt)
      {
        throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
      }
      
      public final Object b(bg parambg)
      {
        return a(parambg);
      }
      
      public void b(bg.a parama, Object paramObject)
      {
        bg.invokeOrDie(this.dSy, parama, new Object[] { paramObject });
      }
      
      public final boolean b(bg.a parama)
      {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
      }
      
      public final int c(bg.a parama)
      {
        return ((Integer)bg.invokeOrDie(this.dSA, parama, new Object[0])).intValue();
      }
      
      public final boolean c(bg parambg)
      {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
      }
      
      public final int d(bg parambg)
      {
        return ((Integer)bg.invokeOrDie(this.dSz, parambg, new Object[0])).intValue();
      }
      
      public final void d(bg.a parama)
      {
        bg.invokeOrDie(this.dSj, parama, new Object[0]);
      }
      
      public final cb.a e(bg.a parama)
      {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
      }
    }
    
    static final class f
      extends bg.e.e
    {
      private final Method dSB = bg.getMethodOrDie(this.dSs, "newBuilder", new Class[0]);
      private final Method dSC;
      
      f(String paramString, Class<? extends bg> paramClass, Class<? extends bg.a> paramClass1)
      {
        super(paramClass, paramClass1);
        this.dSC = bg.getMethodOrDie(paramClass1, "get" + paramString + "Builder", new Class[] { Integer.TYPE });
      }
      
      private Object bw(Object paramObject)
      {
        if (this.dSs.isInstance(paramObject)) {
          return paramObject;
        }
        return ((cb.a)bg.invokeOrDie(this.dSB, null, new Object[0])).mergeFrom((cb)paramObject).build();
      }
      
      public final void a(bg.a parama, int paramInt, Object paramObject)
      {
        super.a(parama, paramInt, bw(paramObject));
      }
      
      public final cb.a aig()
      {
        return (cb.a)bg.invokeOrDie(this.dSB, null, new Object[0]);
      }
      
      public final cb.a b(bg.a parama, int paramInt)
      {
        return (cb.a)bg.invokeOrDie(this.dSC, parama, new Object[] { Integer.valueOf(paramInt) });
      }
      
      public final void b(bg.a parama, Object paramObject)
      {
        super.b(parama, bw(paramObject));
      }
    }
    
    static final class g
      extends bg.e.h
    {
      private Method dSD;
      private Method dSE;
      private Method dSF;
      private am.d dSk;
      private Method dSl;
      private Method dSm;
      private boolean dSn;
      
      g(am.f paramf, String paramString1, Class<? extends bg> paramClass, Class<? extends bg.a> paramClass1, String paramString2)
      {
        super(paramString1, paramClass, paramClass1, paramString2);
        this.dSk = paramf.ahr();
        this.dSl = bg.getMethodOrDie(this.dSs, "valueOf", new Class[] { am.e.class });
        this.dSm = bg.getMethodOrDie(this.dSs, "getValueDescriptor", new Class[0]);
        this.dSn = paramf.dOd.ahu();
        if (this.dSn)
        {
          this.dSD = bg.getMethodOrDie(paramClass, "get" + paramString1 + "Value", new Class[0]);
          this.dSE = bg.getMethodOrDie(paramClass1, "get" + paramString1 + "Value", new Class[0]);
          this.dSF = bg.getMethodOrDie(paramClass1, "set" + paramString1 + "Value", new Class[] { Integer.TYPE });
        }
      }
      
      public final Object a(bg.a parama)
      {
        if (this.dSn)
        {
          int i = ((Integer)bg.invokeOrDie(this.dSE, parama, new Object[0])).intValue();
          return this.dSk.ld(i);
        }
        return bg.invokeOrDie(this.dSm, super.a(parama), new Object[0]);
      }
      
      public final Object a(bg parambg)
      {
        if (this.dSn)
        {
          int i = ((Integer)bg.invokeOrDie(this.dSD, parambg, new Object[0])).intValue();
          return this.dSk.ld(i);
        }
        return bg.invokeOrDie(this.dSm, super.a(parambg), new Object[0]);
      }
      
      public final void a(bg.a parama, Object paramObject)
      {
        if (this.dSn)
        {
          bg.invokeOrDie(this.dSF, parama, new Object[] { Integer.valueOf(((am.e)paramObject).dOy.dLq) });
          return;
        }
        super.a(parama, bg.invokeOrDie(this.dSl, null, new Object[] { paramObject }));
      }
    }
    
    static class h
      implements bg.e.a
    {
      protected final Method dSG;
      protected final Method dSH;
      protected final Method dSI;
      protected final boolean dSJ;
      protected final boolean dSK;
      protected final am.f dSf;
      protected final Method dSh;
      protected final Method dSi;
      protected final Method dSj;
      protected final Class<?> dSs;
      protected final Method dSt;
      protected final Method dSu;
      
      h(am.f paramf, String paramString1, Class<? extends bg> paramClass, Class<? extends bg.a> paramClass1, String paramString2)
      {
        this.dSf = paramf;
        boolean bool;
        if (paramf.dOG != null)
        {
          bool = true;
          this.dSJ = bool;
          if ((!bg.e.c(paramf.dOd)) && ((this.dSJ) || (paramf.dOE.dPm != am.f.a.dOR))) {
            break label330;
          }
          bool = true;
          label61:
          this.dSK = bool;
          this.dSt = bg.getMethodOrDie(paramClass, "get".concat(String.valueOf(paramString1)), new Class[0]);
          this.dSu = bg.getMethodOrDie(paramClass1, "get".concat(String.valueOf(paramString1)), new Class[0]);
          this.dSs = this.dSt.getReturnType();
          this.dSG = bg.getMethodOrDie(paramClass1, "set".concat(String.valueOf(paramString1)), new Class[] { this.dSs });
          if (!this.dSK) {
            break label336;
          }
          paramf = bg.getMethodOrDie(paramClass, "has".concat(String.valueOf(paramString1)), new Class[0]);
          label175:
          this.dSH = paramf;
          if (!this.dSK) {
            break label341;
          }
          paramf = bg.getMethodOrDie(paramClass1, "has".concat(String.valueOf(paramString1)), new Class[0]);
          label206:
          this.dSI = paramf;
          this.dSj = bg.getMethodOrDie(paramClass1, "clear".concat(String.valueOf(paramString1)), new Class[0]);
          if (!this.dSJ) {
            break label346;
          }
        }
        label330:
        label336:
        label341:
        label346:
        for (paramf = bg.getMethodOrDie(paramClass, "get" + paramString2 + "Case", new Class[0]);; paramf = null)
        {
          this.dSh = paramf;
          paramf = localObject;
          if (this.dSJ) {
            paramf = bg.getMethodOrDie(paramClass1, "get" + paramString2 + "Case", new Class[0]);
          }
          this.dSi = paramf;
          return;
          bool = false;
          break;
          bool = false;
          break label61;
          paramf = null;
          break label175;
          paramf = null;
          break label206;
        }
      }
      
      public Object a(bg.a parama)
      {
        return bg.invokeOrDie(this.dSu, parama, new Object[0]);
      }
      
      public final Object a(bg.a parama, int paramInt)
      {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
      }
      
      public Object a(bg parambg)
      {
        return bg.invokeOrDie(this.dSt, parambg, new Object[0]);
      }
      
      public final Object a(bg parambg, int paramInt)
      {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
      }
      
      public final void a(bg.a parama, int paramInt, Object paramObject)
      {
        throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
      }
      
      public void a(bg.a parama, Object paramObject)
      {
        bg.invokeOrDie(this.dSG, parama, new Object[] { paramObject });
      }
      
      public cb.a aig()
      {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }
      
      public final cb.a b(bg.a parama, int paramInt)
      {
        throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
      }
      
      public Object b(bg parambg)
      {
        return a(parambg);
      }
      
      public final void b(bg.a parama, Object paramObject)
      {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
      }
      
      public final boolean b(bg.a parama)
      {
        if (!this.dSK)
        {
          if (this.dSJ) {
            return ((bj.c)bg.invokeOrDie(this.dSi, parama, new Object[0])).getNumber() == this.dSf.dOB.dLq;
          }
          return !a(parama).equals(this.dSf.aho());
        }
        return ((Boolean)bg.invokeOrDie(this.dSI, parama, new Object[0])).booleanValue();
      }
      
      public final int c(bg.a parama)
      {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
      }
      
      public final boolean c(bg parambg)
      {
        if (!this.dSK)
        {
          if (this.dSJ) {
            return ((bj.c)bg.invokeOrDie(this.dSh, parambg, new Object[0])).getNumber() == this.dSf.dOB.dLq;
          }
          return !a(parambg).equals(this.dSf.aho());
        }
        return ((Boolean)bg.invokeOrDie(this.dSH, parambg, new Object[0])).booleanValue();
      }
      
      public final int d(bg parambg)
      {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
      }
      
      public final void d(bg.a parama)
      {
        bg.invokeOrDie(this.dSj, parama, new Object[0]);
      }
      
      public cb.a e(bg.a parama)
      {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
      }
    }
    
    static final class i
      extends bg.e.h
    {
      private final Method dSB = bg.getMethodOrDie(this.dSs, "newBuilder", new Class[0]);
      private final Method dSC;
      
      i(am.f paramf, String paramString1, Class<? extends bg> paramClass, Class<? extends bg.a> paramClass1, String paramString2)
      {
        super(paramString1, paramClass, paramClass1, paramString2);
        this.dSC = bg.getMethodOrDie(paramClass1, "get" + paramString1 + "Builder", new Class[0]);
      }
      
      public final void a(bg.a parama, Object paramObject)
      {
        if (this.dSs.isInstance(paramObject)) {}
        for (;;)
        {
          super.a(parama, paramObject);
          return;
          paramObject = ((cb.a)bg.invokeOrDie(this.dSB, null, new Object[0])).mergeFrom((cb)paramObject).buildPartial();
        }
      }
      
      public final cb.a aig()
      {
        return (cb.a)bg.invokeOrDie(this.dSB, null, new Object[0]);
      }
      
      public final cb.a e(bg.a parama)
      {
        return (cb.a)bg.invokeOrDie(this.dSC, parama, new Object[0]);
      }
    }
    
    static final class j
      extends bg.e.h
    {
      private final Method dSL;
      private final Method dSM;
      private final Method dSN;
      
      j(am.f paramf, String paramString1, Class<? extends bg> paramClass, Class<? extends bg.a> paramClass1, String paramString2)
      {
        super(paramString1, paramClass, paramClass1, paramString2);
        this.dSL = bg.getMethodOrDie(paramClass, "get" + paramString1 + "Bytes", new Class[0]);
        this.dSM = bg.getMethodOrDie(paramClass1, "get" + paramString1 + "Bytes", new Class[0]);
        this.dSN = bg.getMethodOrDie(paramClass1, "set" + paramString1 + "Bytes", new Class[] { h.class });
      }
      
      public final void a(bg.a parama, Object paramObject)
      {
        if ((paramObject instanceof h))
        {
          bg.invokeOrDie(this.dSN, parama, new Object[] { paramObject });
          return;
        }
        super.a(parama, paramObject);
      }
      
      public final Object b(bg parambg)
      {
        return bg.invokeOrDie(this.dSL, parambg, new Object[0]);
      }
    }
  }
  
  public static final class f
  {
    static final f dSO = new f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bg
 * JD-Core Version:    0.7.0.1
 */