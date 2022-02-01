package com.tencent.component.network.utils.a.b;

import java.util.concurrent.TimeUnit;

public abstract class f
{
  private final long jdField_a_of_type_Long;
  private final Object jdField_a_of_type_JavaLangObject;
  private final String jdField_a_of_type_JavaLangString;
  private final long jdField_b_of_type_Long;
  private final Object jdField_b_of_type_JavaLangObject;
  private long jdField_c_of_type_Long;
  private volatile Object jdField_c_of_type_JavaLangObject;
  private long d;
  
  public f(String paramString, Object paramObject1, Object paramObject2, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramObject1 == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (paramObject2 == null) {
      throw new IllegalArgumentException("Connection may not be null");
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("Time unit may not be null");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangObject = paramObject1;
    this.jdField_b_of_type_JavaLangObject = paramObject2;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (this.jdField_b_of_type_Long = (this.jdField_a_of_type_Long + paramTimeUnit.toMillis(paramLong));; this.jdField_b_of_type_Long = 9223372036854775807L)
    {
      this.d = this.jdField_b_of_type_Long;
      return;
    }
  }
  
  public long a()
  {
    try
    {
      long l = this.jdField_c_of_type_Long;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public abstract void a();
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit == null) {
      try
      {
        throw new IllegalArgumentException("Time unit may not be null");
      }
      finally {}
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (paramLong = this.jdField_c_of_type_Long + paramTimeUnit.toMillis(paramLong);; paramLong = 9223372036854775807L)
    {
      this.d = Math.min(paramLong, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    this.jdField_c_of_type_JavaLangObject = paramObject;
  }
  
  public abstract boolean a();
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/tencent/component/network/utils/a/b/f:d	J
    //   6: lstore_3
    //   7: lload_1
    //   8: lload_3
    //   9: lcmp
    //   10: iflt +11 -> 21
    //   13: iconst_1
    //   14: istore 5
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 5
    //   20: ireturn
    //   21: iconst_0
    //   22: istore 5
    //   24: goto -8 -> 16
    //   27: astore 6
    //   29: aload_0
    //   30: monitorexit
    //   31: aload 6
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	f
    //   0	34	1	paramLong	long
    //   6	3	3	l	long
    //   14	9	5	bool	boolean
    //   27	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
  }
  
  public Object b()
  {
    return this.jdField_b_of_type_JavaLangObject;
  }
  
  public Object c()
  {
    return this.jdField_c_of_type_JavaLangObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("][route:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangObject);
    localStringBuilder.append("][state:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangObject);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.b.f
 * JD-Core Version:    0.7.0.1
 */