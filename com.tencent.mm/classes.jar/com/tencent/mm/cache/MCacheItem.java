package com.tencent.mm.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MCacheItem
  implements Parcelable
{
  public static final Parcelable.Creator<MCacheItem> CREATOR;
  private c fqh;
  
  static
  {
    AppMethodBeat.i(131969);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(131969);
  }
  
  public MCacheItem(Parcel paramParcel)
  {
    AppMethodBeat.i(131966);
    this.fqh = b(paramParcel);
    AppMethodBeat.o(131966);
  }
  
  public MCacheItem(c paramc)
  {
    this.fqh = paramc;
  }
  
  /* Error */
  private c b(Parcel paramParcel)
  {
    // Byte code:
    //   0: ldc 47
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 53	android/os/Parcel:readString	()Ljava/lang/String;
    //   9: invokestatic 59	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   12: astore 4
    //   14: aload_0
    //   15: aload 4
    //   17: invokevirtual 63	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   20: checkcast 65	com/tencent/mm/sdk/e/c
    //   23: putfield 43	com/tencent/mm/cache/MCacheItem:fqh	Lcom/tencent/mm/sdk/e/c;
    //   26: aload 4
    //   28: invokestatic 69	com/tencent/mm/sdk/e/c:getValidFields	(Ljava/lang/Class;)[Ljava/lang/reflect/Field;
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
    //   50: getstatic 73	com/tencent/mm/cache/MCacheItem$a:fqj	Ljava/util/Map;
    //   53: aload 5
    //   55: invokevirtual 79	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   58: invokeinterface 85 2 0
    //   63: checkcast 87	java/lang/reflect/Method
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
    //   92: getfield 43	com/tencent/mm/cache/MCacheItem:fqh	Lcom/tencent/mm/sdk/e/c;
    //   95: aastore
    //   96: invokevirtual 91	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   99: pop
    //   100: iload_2
    //   101: iconst_1
    //   102: iadd
    //   103: istore_2
    //   104: goto -65 -> 39
    //   107: astore 5
    //   109: ldc 93
    //   111: ldc 95
    //   113: iconst_1
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload 5
    //   121: invokestatic 101	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   124: aastore
    //   125: invokestatic 107	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: goto -28 -> 100
    //   131: astore_1
    //   132: ldc 93
    //   134: ldc 95
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: aload_1
    //   143: invokestatic 101	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   146: aastore
    //   147: invokestatic 107	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: ldc 47
    //   152: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aconst_null
    //   156: areturn
    //   157: aload_0
    //   158: getfield 43	com/tencent/mm/cache/MCacheItem:fqh	Lcom/tencent/mm/sdk/e/c;
    //   161: astore_1
    //   162: ldc 47
    //   164: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(131968);
    paramParcel.writeString(this.fqh.getClass().getName());
    Field[] arrayOfField = c.getValidFields(this.fqh.getClass());
    int i = arrayOfField.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt < i)
      {
        Field localField = arrayOfField[paramInt];
        Method localMethod = (Method)a.fqi.get(localField.getType());
        if (localMethod != null) {}
        try
        {
          localMethod.invoke(null, new Object[] { paramParcel, localField, this.fqh });
          paramInt += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(localException) });
          }
        }
      }
    }
    AppMethodBeat.o(131968);
  }
  
  static class a
  {
    public static Map<Class<?>, Method> fqi;
    public static Map<Class<?>, Method> fqj;
    
    static
    {
      AppMethodBeat.i(131965);
      fqi = new HashMap();
      fqj = new HashMap();
      try
      {
        fqi.put([B.class, a.class.getMethod("keep_writeByteArray", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(Short.TYPE, a.class.getMethod("keep_writeShort", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(Short.class, a.class.getMethod("keep_writeShort", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(Boolean.TYPE, a.class.getMethod("keep_writeBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(Boolean.class, a.class.getMethod("keep_writeBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(Integer.TYPE, a.class.getMethod("keep_writeInt", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(Integer.class, a.class.getMethod("keep_writeInt", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(Float.TYPE, a.class.getMethod("keep_writeFloat", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(Float.class, a.class.getMethod("keep_writeFloat", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(Double.TYPE, a.class.getMethod("keep_writeDouble", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(Double.class, a.class.getMethod("keep_writeDouble", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(Long.TYPE, a.class.getMethod("keep_writeLong", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(Long.class, a.class.getMethod("keep_writeLong", new Class[] { Parcel.class, Field.class, Object.class }));
        fqi.put(String.class, a.class.getMethod("keep_writeString", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put([B.class, a.class.getMethod("keep_readByteArray", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(Short.TYPE, a.class.getMethod("keep_readShort", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(Short.class, a.class.getMethod("keep_readShort", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(Boolean.TYPE, a.class.getMethod("keep_readBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(Boolean.class, a.class.getMethod("keep_readBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(Integer.TYPE, a.class.getMethod("keep_readInt", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(Integer.class, a.class.getMethod("keep_readInt", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(Float.TYPE, a.class.getMethod("keep_readFloat", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(Float.class, a.class.getMethod("keep_readFloat", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(Double.TYPE, a.class.getMethod("keep_readDouble", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(Double.class, a.class.getMethod("keep_readDouble", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(Long.TYPE, a.class.getMethod("keep_readLong", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(Long.class, a.class.getMethod("keep_readLong", new Class[] { Parcel.class, Field.class, Object.class }));
        fqj.put(String.class, a.class.getMethod("keep_readString", new Class[] { Parcel.class, Field.class, Object.class }));
        AppMethodBeat.o(131965);
        return;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(localException) });
        AppMethodBeat.o(131965);
      }
    }
    
    public static void keep_readBoolean(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131959);
      try
      {
        if (paramParcel.readInt() != 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramField.setBoolean(paramObject, bool);
          AppMethodBeat.o(131959);
          return;
        }
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131959);
      }
    }
    
    public static void keep_readByteArray(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131957);
      try
      {
        paramField.set(paramObject, paramParcel.createByteArray());
        AppMethodBeat.o(131957);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131957);
      }
    }
    
    public static void keep_readDouble(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131962);
      try
      {
        paramField.setDouble(paramObject, paramParcel.readDouble());
        AppMethodBeat.o(131962);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131962);
      }
    }
    
    public static void keep_readFloat(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131961);
      try
      {
        paramField.setFloat(paramObject, paramParcel.readFloat());
        AppMethodBeat.o(131961);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131961);
      }
    }
    
    public static void keep_readInt(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131960);
      try
      {
        paramField.setInt(paramObject, paramParcel.readInt());
        AppMethodBeat.o(131960);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131960);
      }
    }
    
    public static void keep_readLong(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131963);
      try
      {
        paramField.set(paramObject, Long.valueOf(paramParcel.readLong()));
        AppMethodBeat.o(131963);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131963);
      }
    }
    
    public static void keep_readShort(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131958);
      try
      {
        paramField.setShort(paramObject, (short)paramParcel.readInt());
        AppMethodBeat.o(131958);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131958);
      }
    }
    
    public static void keep_readString(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131964);
      try
      {
        paramField.set(paramObject, paramParcel.readString());
        AppMethodBeat.o(131964);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131964);
      }
    }
    
    public static void keep_writeBoolean(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131951);
      try
      {
        if (paramField.getBoolean(paramObject)) {}
        for (int i = 1;; i = 0)
        {
          paramParcel.writeInt(i);
          AppMethodBeat.o(131951);
          return;
        }
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131951);
      }
    }
    
    public static void keep_writeByteArray(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131949);
      try
      {
        paramParcel.writeByteArray((byte[])paramField.get(paramObject));
        AppMethodBeat.o(131949);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131949);
      }
    }
    
    public static void keep_writeDouble(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131954);
      try
      {
        paramParcel.writeDouble(paramField.getDouble(paramObject));
        AppMethodBeat.o(131954);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131954);
      }
    }
    
    public static void keep_writeFloat(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131953);
      try
      {
        paramParcel.writeFloat(paramField.getFloat(paramObject));
        AppMethodBeat.o(131953);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131953);
      }
    }
    
    public static void keep_writeInt(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131952);
      try
      {
        paramParcel.writeInt(paramField.getInt(paramObject));
        AppMethodBeat.o(131952);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131952);
      }
    }
    
    public static void keep_writeLong(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131955);
      try
      {
        paramParcel.writeLong(paramField.getLong(paramObject));
        AppMethodBeat.o(131955);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131955);
      }
    }
    
    public static void keep_writeShort(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131950);
      try
      {
        paramParcel.writeInt(paramField.getShort(paramObject));
        AppMethodBeat.o(131950);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131950);
      }
    }
    
    public static void keep_writeString(Parcel paramParcel, Field paramField, Object paramObject)
    {
      AppMethodBeat.i(131956);
      try
      {
        paramParcel.writeString((String)paramField.get(paramObject));
        AppMethodBeat.o(131956);
        return;
      }
      catch (Exception paramParcel)
      {
        ac.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bs.m(paramParcel) });
        AppMethodBeat.o(131956);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.cache.MCacheItem
 * JD-Core Version:    0.7.0.1
 */