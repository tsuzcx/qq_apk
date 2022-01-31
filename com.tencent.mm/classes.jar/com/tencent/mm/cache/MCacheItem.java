package com.tencent.mm.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class MCacheItem
  implements Parcelable
{
  public static final Parcelable.Creator<MCacheItem> CREATOR = new MCacheItem.1();
  private c dlb;
  
  public MCacheItem(Parcel paramParcel)
  {
    this.dlb = b(paramParcel);
  }
  
  public MCacheItem(c paramc)
  {
    this.dlb = paramc;
  }
  
  /* Error */
  private c b(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 40	android/os/Parcel:readString	()Ljava/lang/String;
    //   4: invokestatic 46	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   7: astore 4
    //   9: aload_0
    //   10: aload 4
    //   12: invokevirtual 50	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   15: checkcast 52	com/tencent/mm/sdk/e/c
    //   18: putfield 31	com/tencent/mm/cache/MCacheItem:dlb	Lcom/tencent/mm/sdk/e/c;
    //   21: aload 4
    //   23: invokestatic 56	com/tencent/mm/sdk/e/c:V	(Ljava/lang/Class;)Lcom/tencent/mm/sdk/e/c$a;
    //   26: getfield 62	com/tencent/mm/sdk/e/c$a:ujL	[Ljava/lang/reflect/Field;
    //   29: astore 4
    //   31: aload 4
    //   33: arraylength
    //   34: istore_3
    //   35: iconst_0
    //   36: istore_2
    //   37: iload_2
    //   38: iload_3
    //   39: if_icmpge +111 -> 150
    //   42: aload 4
    //   44: iload_2
    //   45: aaload
    //   46: astore 5
    //   48: getstatic 66	com/tencent/mm/cache/MCacheItem$a:dld	Ljava/util/Map;
    //   51: aload 5
    //   53: invokevirtual 72	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   56: invokeinterface 78 2 0
    //   61: checkcast 80	java/lang/reflect/Method
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +30 -> 98
    //   71: aload 6
    //   73: aconst_null
    //   74: iconst_3
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload_1
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload 5
    //   86: aastore
    //   87: dup
    //   88: iconst_2
    //   89: aload_0
    //   90: getfield 31	com/tencent/mm/cache/MCacheItem:dlb	Lcom/tencent/mm/sdk/e/c;
    //   93: aastore
    //   94: invokevirtual 84	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: iload_2
    //   99: iconst_1
    //   100: iadd
    //   101: istore_2
    //   102: goto -65 -> 37
    //   105: astore 5
    //   107: ldc 86
    //   109: ldc 88
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload 5
    //   119: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 100	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: goto -28 -> 98
    //   129: astore_1
    //   130: ldc 86
    //   132: ldc 88
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_1
    //   141: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   144: aastore
    //   145: invokestatic 100	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aconst_null
    //   149: areturn
    //   150: aload_0
    //   151: getfield 31	com/tencent/mm/cache/MCacheItem:dlb	Lcom/tencent/mm/sdk/e/c;
    //   154: astore_1
    //   155: aload_1
    //   156: areturn
    //   157: astore 5
    //   159: goto -138 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	MCacheItem
    //   0	162	1	paramParcel	Parcel
    //   36	66	2	i	int
    //   34	6	3	j	int
    //   7	36	4	localObject1	Object
    //   46	39	5	localObject2	Object
    //   105	13	5	localException1	Exception
    //   157	1	5	localException2	Exception
    //   64	8	6	localMethod	Method
    // Exception table:
    //   from	to	target	type
    //   71	98	105	java/lang/Exception
    //   0	9	129	java/lang/Exception
    //   21	35	129	java/lang/Exception
    //   48	66	129	java/lang/Exception
    //   107	126	129	java/lang/Exception
    //   150	155	129	java/lang/Exception
    //   9	21	157	java/lang/Exception
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.dlb.getClass().getName());
    Field[] arrayOfField = c.V(this.dlb.getClass()).ujL;
    int i = arrayOfField.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt < i)
      {
        Field localField = arrayOfField[paramInt];
        Method localMethod = (Method)MCacheItem.a.dlc.get(localField.getType());
        if (localMethod != null) {}
        try
        {
          localMethod.invoke(null, new Object[] { paramParcel, localField, this.dlb });
          paramInt += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(localException) });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cache.MCacheItem
 * JD-Core Version:    0.7.0.1
 */