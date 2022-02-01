package com.tencent.component.network.module.cache.common;

import java.util.LinkedHashMap;

public class LruCache
{
  private int jdField_a_of_type_Int;
  private final LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public LruCache(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.b = paramInt;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(0, 0.75F, true);
  }
  
  private int b(Object paramObject1, Object paramObject2)
  {
    int i = a(paramObject1, paramObject2);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramObject1 + "=" + paramObject2);
    }
    return i;
  }
  
  public final int a()
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a(Object paramObject1, Object paramObject2)
  {
    return 1;
  }
  
  public final Object a(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject1;
    try
    {
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramObject);
      if (localObject1 != null)
      {
        this.f += 1;
        return localObject1;
      }
      this.g += 1;
      localObject1 = c(paramObject);
      if (localObject1 == null) {
        return null;
      }
    }
    finally {}
    try
    {
      this.d += 1;
      Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramObject, localObject1);
      if (localObject2 != null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramObject, localObject2);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break;
        }
        a(false, paramObject, localObject1, localObject2);
        return localObject2;
        this.jdField_a_of_type_Int += b(paramObject, localObject1);
      }
      a(this.b);
    }
    finally {}
    return localObject1;
  }
  
  public final Object a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.c += 1;
      this.jdField_a_of_type_Int += b(paramObject1, paramObject2);
      Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramObject1, paramObject2);
      if (localObject != null) {
        this.jdField_a_of_type_Int -= b(paramObject1, localObject);
      }
      if (localObject != null) {
        a(false, paramObject1, localObject, paramObject2);
      }
      a(this.b);
      return localObject;
    }
    finally {}
  }
  
  public final void a()
  {
    a(-1);
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/tencent/component/network/module/cache/common/LruCache:jdField_a_of_type_Int	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 35	com/tencent/component/network/module/cache/common/LruCache:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 99	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 63	com/tencent/component/network/module/cache/common/LruCache:jdField_a_of_type_Int	I
    //   23: ifeq +41 -> 64
    //   26: new 41	java/lang/IllegalStateException
    //   29: dup
    //   30: new 43	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 103	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 108	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 110
    //   49: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 60	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 63	com/tencent/component/network/module/cache/common/LruCache:jdField_a_of_type_Int	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 35	com/tencent/component/network/module/cache/common/LruCache:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 99	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 35	com/tencent/component/network/module/cache/common/LruCache:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 114	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 120 1 0
    //   97: invokeinterface 126 1 0
    //   102: checkcast 128	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 131 1 0
    //   112: astore_2
    //   113: aload_3
    //   114: invokeinterface 134 1 0
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 35	com/tencent/component/network/module/cache/common/LruCache:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   124: aload_2
    //   125: invokevirtual 137	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 63	com/tencent/component/network/module/cache/common/LruCache:jdField_a_of_type_Int	I
    //   134: aload_0
    //   135: aload_2
    //   136: aload_3
    //   137: invokespecial 89	com/tencent/component/network/module/cache/common/LruCache:b	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   140: isub
    //   141: putfield 63	com/tencent/component/network/module/cache/common/LruCache:jdField_a_of_type_Int	I
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 139	com/tencent/component/network/module/cache/common/LruCache:e	I
    //   149: iconst_1
    //   150: iadd
    //   151: putfield 139	com/tencent/component/network/module/cache/common/LruCache:e	I
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_0
    //   157: iconst_1
    //   158: aload_2
    //   159: aload_3
    //   160: aconst_null
    //   161: invokevirtual 87	com/tencent/component/network/module/cache/common/LruCache:a	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   164: goto -164 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	LruCache
    //   0	167	1	paramInt	int
    //   59	4	2	localObject1	Object
    //   112	47	2	localObject2	Object
    //   105	55	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	59	59	finally
    //   60	62	59	finally
    //   64	82	59	finally
    //   82	84	59	finally
    //   85	156	59	finally
  }
  
  public void a(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3) {}
  
  public final int b()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Object b(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramObject);
      if (localObject != null) {
        this.jdField_a_of_type_Int -= b(paramObject, localObject);
      }
      if (localObject != null) {
        a(false, paramObject, localObject, null);
      }
      return localObject;
    }
    finally {}
  }
  
  protected Object c(Object paramObject)
  {
    return null;
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.f + this.g;
      if (j != 0) {
        i = this.f * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.cache.common.LruCache
 * JD-Core Version:    0.7.0.1
 */