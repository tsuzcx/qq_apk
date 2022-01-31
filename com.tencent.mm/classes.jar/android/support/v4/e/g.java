package android.support.v4.e;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class g<K, V>
{
  private int createCount;
  private int evictionCount;
  private int hitCount;
  private final LinkedHashMap<K, V> map;
  private int maxSize;
  private int missCount;
  private int putCount;
  private int size;
  
  public g(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.maxSize = paramInt;
    this.map = new LinkedHashMap(0, 0.75F, true);
  }
  
  private int safeSizeOf(K paramK, V paramV)
  {
    int i = sizeOf(paramK, paramV);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    }
    return i;
  }
  
  protected V create(K paramK)
  {
    return null;
  }
  
  public final int createCount()
  {
    try
    {
      int i = this.createCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void entryRemoved(boolean paramBoolean, K paramK, V paramV1, V paramV2) {}
  
  public final void evictAll()
  {
    trimToSize(-1);
  }
  
  public final int evictionCount()
  {
    try
    {
      int i = this.evictionCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject1;
    try
    {
      localObject1 = this.map.get(paramK);
      if (localObject1 != null)
      {
        this.hitCount += 1;
        return localObject1;
      }
      this.missCount += 1;
      localObject1 = create(paramK);
      if (localObject1 == null) {
        return null;
      }
    }
    finally {}
    try
    {
      this.createCount += 1;
      Object localObject2 = this.map.put(paramK, localObject1);
      if (localObject2 != null) {
        this.map.put(paramK, localObject2);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break;
        }
        entryRemoved(false, paramK, localObject1, localObject2);
        return localObject2;
        this.size += safeSizeOf(paramK, localObject1);
      }
      trimToSize(this.maxSize);
    }
    finally {}
    return localObject1;
  }
  
  public final int hitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int maxSize()
  {
    try
    {
      int i = this.maxSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int missCount()
  {
    try
    {
      int i = this.missCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.putCount += 1;
      this.size += safeSizeOf(paramK, paramV);
      Object localObject = this.map.put(paramK, paramV);
      if (localObject != null) {
        this.size -= safeSizeOf(paramK, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramK, localObject, paramV);
      }
      trimToSize(this.maxSize);
      return localObject;
    }
    finally {}
  }
  
  public final int putCount()
  {
    try
    {
      int i = this.putCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final V remove(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      Object localObject = this.map.remove(paramK);
      if (localObject != null) {
        this.size -= safeSizeOf(paramK, localObject);
      }
      if (localObject != null) {
        entryRemoved(false, paramK, localObject, null);
      }
      return localObject;
    }
    finally {}
  }
  
  public void resize(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    try
    {
      this.maxSize = paramInt;
      trimToSize(paramInt);
      return;
    }
    finally {}
  }
  
  public final int size()
  {
    try
    {
      int i = this.size;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return 1;
  }
  
  public final Map<K, V> snapshot()
  {
    try
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.map);
      return localLinkedHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.hitCount + this.missCount;
      if (j != 0) {
        i = this.hitCount * 100 / j;
      }
      String str = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
  
  /* Error */
  public void trimToSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 104	android/support/v4/e/g:size	I
    //   6: iflt +20 -> 26
    //   9: aload_0
    //   10: getfield 38	android/support/v4/e/g:map	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 145	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +48 -> 64
    //   19: aload_0
    //   20: getfield 104	android/support/v4/e/g:size	I
    //   23: ifeq +41 -> 64
    //   26: new 46	java/lang/IllegalStateException
    //   29: dup
    //   30: new 48	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 150	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 155	java/lang/Class:getName	()Ljava/lang/String;
    //   44: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 157
    //   49: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 65	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: aload_0
    //   65: getfield 104	android/support/v4/e/g:size	I
    //   68: iload_1
    //   69: if_icmple +13 -> 82
    //   72: aload_0
    //   73: getfield 38	android/support/v4/e/g:map	Ljava/util/LinkedHashMap;
    //   76: invokevirtual 145	java/util/LinkedHashMap:isEmpty	()Z
    //   79: ifeq +6 -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: getfield 38	android/support/v4/e/g:map	Ljava/util/LinkedHashMap;
    //   89: invokevirtual 161	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   92: invokeinterface 167 1 0
    //   97: invokeinterface 173 1 0
    //   102: checkcast 175	java/util/Map$Entry
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 178 1 0
    //   112: astore_2
    //   113: aload_3
    //   114: invokeinterface 181 1 0
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 38	android/support/v4/e/g:map	Ljava/util/LinkedHashMap;
    //   124: aload_2
    //   125: invokevirtual 114	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 104	android/support/v4/e/g:size	I
    //   134: aload_0
    //   135: aload_2
    //   136: aload_3
    //   137: invokespecial 106	android/support/v4/e/g:safeSizeOf	(Ljava/lang/Object;Ljava/lang/Object;)I
    //   140: isub
    //   141: putfield 104	android/support/v4/e/g:size	I
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 82	android/support/v4/e/g:evictionCount	I
    //   149: iconst_1
    //   150: iadd
    //   151: putfield 82	android/support/v4/e/g:evictionCount	I
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_0
    //   157: iconst_1
    //   158: aload_2
    //   159: aload_3
    //   160: aconst_null
    //   161: invokevirtual 102	android/support/v4/e/g:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   164: goto -164 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	g
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.g
 * JD-Core Version:    0.7.0.1
 */