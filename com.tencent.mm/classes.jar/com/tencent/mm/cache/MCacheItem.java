package com.tencent.mm.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class MCacheItem
  implements Parcelable
{
  public static final Parcelable.Creator<MCacheItem> CREATOR;
  private c ecx;
  
  static
  {
    AppMethodBeat.i(57848);
    CREATOR = new MCacheItem.1();
    AppMethodBeat.o(57848);
  }
  
  public MCacheItem(Parcel paramParcel)
  {
    AppMethodBeat.i(57845);
    this.ecx = c(paramParcel);
    AppMethodBeat.o(57845);
  }
  
  public MCacheItem(c paramc)
  {
    this.ecx = paramc;
  }
  
  /* Error */
  private c c(Parcel paramParcel)
  {
    // Byte code:
    //   0: ldc 46
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 52	android/os/Parcel:readString	()Ljava/lang/String;
    //   9: invokestatic 58	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   12: astore 4
    //   14: aload_0
    //   15: aload 4
    //   17: invokevirtual 62	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   20: checkcast 64	com/tencent/mm/sdk/e/c
    //   23: putfield 42	com/tencent/mm/cache/MCacheItem:ecx	Lcom/tencent/mm/sdk/e/c;
    //   26: aload 4
    //   28: invokestatic 68	com/tencent/mm/sdk/e/c:getValidFields	(Ljava/lang/Class;)[Ljava/lang/reflect/Field;
    //   31: astore 4
    //   33: aload 4
    //   35: arraylength
    //   36: istore_3
    //   37: iconst_0
    //   38: istore_2
    //   39: iload_2
    //   40: iload_3
    //   41: if_icmpge +116 -> 157
    //   44: aload 4
    //   46: iload_2
    //   47: aaload
    //   48: astore 5
    //   50: getstatic 72	com/tencent/mm/cache/MCacheItem$a:ecz	Ljava/util/Map;
    //   53: aload 5
    //   55: invokevirtual 78	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   58: invokeinterface 84 2 0
    //   63: checkcast 86	java/lang/reflect/Method
    //   66: astore 6
    //   68: aload 6
    //   70: ifnull +30 -> 100
    //   73: aload 6
    //   75: aconst_null
    //   76: iconst_3
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload_1
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: aload 5
    //   88: aastore
    //   89: dup
    //   90: iconst_2
    //   91: aload_0
    //   92: getfield 42	com/tencent/mm/cache/MCacheItem:ecx	Lcom/tencent/mm/sdk/e/c;
    //   95: aastore
    //   96: invokevirtual 90	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   99: pop
    //   100: iload_2
    //   101: iconst_1
    //   102: iadd
    //   103: istore_2
    //   104: goto -65 -> 39
    //   107: astore 5
    //   109: ldc 92
    //   111: ldc 94
    //   113: iconst_1
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload 5
    //   121: invokestatic 100	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   124: aastore
    //   125: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: goto -28 -> 100
    //   131: astore_1
    //   132: ldc 92
    //   134: ldc 94
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: aload_1
    //   143: invokestatic 100	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   146: aastore
    //   147: invokestatic 106	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: ldc 46
    //   152: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aconst_null
    //   156: areturn
    //   157: aload_0
    //   158: getfield 42	com/tencent/mm/cache/MCacheItem:ecx	Lcom/tencent/mm/sdk/e/c;
    //   161: astore_1
    //   162: ldc 46
    //   164: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_1
    //   168: areturn
    //   169: astore 5
    //   171: goto -145 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	MCacheItem
    //   0	174	1	paramParcel	Parcel
    //   38	66	2	i	int
    //   36	6	3	j	int
    //   12	33	4	localObject1	Object
    //   48	39	5	localObject2	Object
    //   107	13	5	localException1	Exception
    //   169	1	5	localException2	Exception
    //   66	8	6	localMethod	Method
    // Exception table:
    //   from	to	target	type
    //   73	100	107	java/lang/Exception
    //   5	14	131	java/lang/Exception
    //   26	37	131	java/lang/Exception
    //   50	68	131	java/lang/Exception
    //   109	128	131	java/lang/Exception
    //   157	162	131	java/lang/Exception
    //   14	26	169	java/lang/Exception
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(57847);
    paramParcel.writeString(this.ecx.getClass().getName());
    Field[] arrayOfField = c.getValidFields(this.ecx.getClass());
    int i = arrayOfField.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt < i)
      {
        Field localField = arrayOfField[paramInt];
        Method localMethod = (Method)MCacheItem.a.ecy.get(localField.getType());
        if (localMethod != null) {}
        try
        {
          localMethod.invoke(null, new Object[] { paramParcel, localField, this.ecx });
          paramInt += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(57847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cache.MCacheItem
 * JD-Core Version:    0.7.0.1
 */