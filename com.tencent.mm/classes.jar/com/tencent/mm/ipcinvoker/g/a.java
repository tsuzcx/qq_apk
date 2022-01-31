package com.tencent.mm.ipcinvoker.g;

import java.lang.reflect.Field;

public final class a<FieldType>
{
  private Class<?> dHl;
  private String dHm;
  private Field mField;
  private boolean mInited;
  
  public a(Class<?> paramClass, String paramString)
  {
    if (paramString.length() == 0) {
      throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
    }
    this.dHl = paramClass;
    this.dHm = paramString;
  }
  
  /* Error */
  private FieldType Cc()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 46	com/tencent/mm/ipcinvoker/g/a:prepare	()V
    //   8: aload_0
    //   9: getfield 48	com/tencent/mm/ipcinvoker/g/a:mField	Ljava/lang/reflect/Field;
    //   12: ifnonnull +25 -> 37
    //   15: ldc 50
    //   17: ldc 52
    //   19: iconst_1
    //   20: anewarray 5	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 36	com/tencent/mm/ipcinvoker/g/a:dHm	Ljava/lang/String;
    //   29: aastore
    //   30: invokestatic 58	com/tencent/mm/ipcinvoker/h/b:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: aload_0
    //   38: getfield 48	com/tencent/mm/ipcinvoker/g/a:mField	Ljava/lang/reflect/Field;
    //   41: aconst_null
    //   42: invokevirtual 64	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: astore_1
    //   46: goto -13 -> 33
    //   49: astore_1
    //   50: new 27	java/lang/IllegalArgumentException
    //   53: dup
    //   54: ldc 66
    //   56: invokespecial 32	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	a
    //   1	45	1	localObject1	Object
    //   49	1	1	localClassCastException	java.lang.ClassCastException
    //   60	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   37	46	49	java/lang/ClassCastException
    //   4	33	60	finally
    //   37	46	60	finally
    //   50	60	60	finally
  }
  
  private void prepare()
  {
    try
    {
      boolean bool = this.mInited;
      if (!bool) {
        break label14;
      }
    }
    finally
    {
      try
      {
        label14:
        Class localClass1;
        Field localField = localClass1.getDeclaredField(this.dHm);
        localField.setAccessible(true);
        this.mField = localField;
        this.mInited = true;
      }
      catch (Exception localException)
      {
        Class localClass2 = localObject.getSuperclass();
      }
      localObject = finally;
    }
    return;
    localClass1 = this.dHl;
    for (;;)
    {
      if (localClass1 == null) {}
    }
  }
  
  /* Error */
  public final FieldType Cd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 92	com/tencent/mm/ipcinvoker/g/a:Cc	()Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: areturn
    //   15: astore_2
    //   16: ldc 50
    //   18: ldc 94
    //   20: iconst_1
    //   21: anewarray 5	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_2
    //   27: aastore
    //   28: invokestatic 97	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: goto -20 -> 11
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    //   39: astore_2
    //   40: ldc 50
    //   42: ldc 94
    //   44: iconst_1
    //   45: anewarray 5	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_2
    //   51: aastore
    //   52: invokestatic 97	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: goto -44 -> 11
    //   58: astore_2
    //   59: ldc 50
    //   61: ldc 94
    //   63: iconst_1
    //   64: anewarray 5	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_2
    //   70: aastore
    //   71: invokestatic 97	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: goto -63 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	a
    //   3	11	1	localObject1	Object
    //   34	4	1	localObject2	Object
    //   8	2	2	localObject3	Object
    //   15	12	2	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   39	12	2	localIllegalAccessException	java.lang.IllegalAccessException
    //   58	12	2	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   4	9	15	java/lang/NoSuchFieldException
    //   4	9	34	finally
    //   16	31	34	finally
    //   40	55	34	finally
    //   59	74	34	finally
    //   4	9	39	java/lang/IllegalAccessException
    //   4	9	58	java/lang/IllegalArgumentException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.g.a
 * JD-Core Version:    0.7.0.1
 */