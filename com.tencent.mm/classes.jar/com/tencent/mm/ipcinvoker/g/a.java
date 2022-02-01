package com.tencent.mm.ipcinvoker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.b;
import java.lang.reflect.Field;

public final class a<FieldType>
{
  private Class<?> cNV;
  private String cNW;
  private Field mField;
  private boolean mInited;
  
  public a(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(158827);
    if (paramString.length() == 0)
    {
      paramClass = new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
      AppMethodBeat.o(158827);
      throw paramClass;
    }
    this.cNV = paramClass;
    this.cNW = paramString;
    AppMethodBeat.o(158827);
  }
  
  private FieldType ahG()
  {
    Object localObject1 = null;
    try
    {
      AppMethodBeat.i(158829);
      prepare();
      if (this.mField == null)
      {
        b.w("SDK.ReflectStaticFieldSmith", "Field %s is no exists.", new Object[] { this.cNW });
        AppMethodBeat.o(158829);
        return localObject1;
      }
    }
    finally
    {
      try
      {
        localObject1 = this.mField.get(null);
        AppMethodBeat.o(158829);
      }
      catch (ClassCastException localClassCastException)
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("unable to cast object");
        AppMethodBeat.o(158829);
        throw localIllegalArgumentException;
      }
      localObject2 = finally;
    }
  }
  
  private void prepare()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(158828);
        if (this.mInited)
        {
          AppMethodBeat.o(158828);
          return;
        }
        localClass1 = this.cNV;
        if (localClass1 == null) {}
      }
      finally
      {
        try
        {
          Class localClass1;
          Field localField = localClass1.getDeclaredField(this.cNW);
          localField.setAccessible(true);
          this.mField = localField;
          this.mInited = true;
          AppMethodBeat.o(158828);
        }
        catch (Exception localException)
        {
          Class localClass2 = localObject.getSuperclass();
        }
        localObject = finally;
      }
    }
  }
  
  /* Error */
  public final FieldType ahH()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 103
    //   4: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_0
    //   10: invokespecial 105	com/tencent/mm/ipcinvoker/g/a:ahG	()Ljava/lang/Object;
    //   13: astore_2
    //   14: aload_2
    //   15: astore_1
    //   16: ldc 103
    //   18: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: astore_2
    //   26: ldc 61
    //   28: ldc 107
    //   30: iconst_1
    //   31: anewarray 5	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_2
    //   37: aastore
    //   38: invokestatic 109	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: goto -25 -> 16
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    //   49: astore_2
    //   50: ldc 61
    //   52: ldc 107
    //   54: iconst_1
    //   55: anewarray 5	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_2
    //   61: aastore
    //   62: invokestatic 109	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: goto -49 -> 16
    //   68: astore_2
    //   69: ldc 61
    //   71: ldc 107
    //   73: iconst_1
    //   74: anewarray 5	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_2
    //   80: aastore
    //   81: invokestatic 109	com/tencent/mm/ipcinvoker/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: goto -68 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	a
    //   8	16	1	localObject1	Object
    //   44	4	1	localObject2	Object
    //   13	2	2	localObject3	Object
    //   25	12	2	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   49	12	2	localIllegalAccessException	java.lang.IllegalAccessException
    //   68	12	2	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   9	14	25	java/lang/NoSuchFieldException
    //   2	7	44	finally
    //   9	14	44	finally
    //   16	21	44	finally
    //   26	41	44	finally
    //   50	65	44	finally
    //   69	84	44	finally
    //   9	14	49	java/lang/IllegalAccessException
    //   9	14	68	java/lang/IllegalArgumentException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.g.a
 * JD-Core Version:    0.7.0.1
 */