package com.tencent.mm.cache;

import android.os.Parcel;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class MCacheItem$a
{
  public static Map<Class<?>, Method> dlc = new HashMap();
  public static Map<Class<?>, Method> dld = new HashMap();
  
  static
  {
    try
    {
      dlc.put([B.class, a.class.getMethod("keep_writeByteArray", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(Short.TYPE, a.class.getMethod("keep_writeShort", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(Short.class, a.class.getMethod("keep_writeShort", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(Boolean.TYPE, a.class.getMethod("keep_writeBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(Boolean.class, a.class.getMethod("keep_writeBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(Integer.TYPE, a.class.getMethod("keep_writeInt", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(Integer.class, a.class.getMethod("keep_writeInt", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(Float.TYPE, a.class.getMethod("keep_writeFloat", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(Float.class, a.class.getMethod("keep_writeFloat", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(Double.TYPE, a.class.getMethod("keep_writeDouble", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(Double.class, a.class.getMethod("keep_writeDouble", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(Long.TYPE, a.class.getMethod("keep_writeLong", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(Long.class, a.class.getMethod("keep_writeLong", new Class[] { Parcel.class, Field.class, Object.class }));
      dlc.put(String.class, a.class.getMethod("keep_writeString", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put([B.class, a.class.getMethod("keep_readByteArray", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(Short.TYPE, a.class.getMethod("keep_readShort", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(Short.class, a.class.getMethod("keep_readShort", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(Boolean.TYPE, a.class.getMethod("keep_readBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(Boolean.class, a.class.getMethod("keep_readBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(Integer.TYPE, a.class.getMethod("keep_readInt", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(Integer.class, a.class.getMethod("keep_readInt", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(Float.TYPE, a.class.getMethod("keep_readFloat", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(Float.class, a.class.getMethod("keep_readFloat", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(Double.TYPE, a.class.getMethod("keep_readDouble", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(Double.class, a.class.getMethod("keep_readDouble", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(Long.TYPE, a.class.getMethod("keep_readLong", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(Long.class, a.class.getMethod("keep_readLong", new Class[] { Parcel.class, Field.class, Object.class }));
      dld.put(String.class, a.class.getMethod("keep_readString", new Class[] { Parcel.class, Field.class, Object.class }));
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public static void keep_readBoolean(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramField.setBoolean(paramObject, bool);
        return;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_readByteArray(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramField.set(paramObject, paramParcel.createByteArray());
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_readDouble(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramField.setDouble(paramObject, paramParcel.readDouble());
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_readFloat(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramField.setFloat(paramObject, paramParcel.readFloat());
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_readInt(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramField.setInt(paramObject, paramParcel.readInt());
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_readLong(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramField.set(paramObject, Long.valueOf(paramParcel.readLong()));
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_readShort(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramField.setShort(paramObject, (short)paramParcel.readInt());
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_readString(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramField.set(paramObject, paramParcel.readString());
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_writeBoolean(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      if (paramField.getBoolean(paramObject)) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeInt(i);
        return;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_writeByteArray(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramParcel.writeByteArray((byte[])paramField.get(paramObject));
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_writeDouble(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramParcel.writeDouble(paramField.getDouble(paramObject));
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_writeFloat(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramParcel.writeFloat(paramField.getFloat(paramObject));
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_writeInt(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramParcel.writeInt(paramField.getInt(paramObject));
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_writeLong(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramParcel.writeLong(paramField.getLong(paramObject));
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_writeShort(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramParcel.writeInt(paramField.getShort(paramObject));
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
  
  public static void keep_writeString(Parcel paramParcel, Field paramField, Object paramObject)
  {
    try
    {
      paramParcel.writeString((String)paramField.get(paramObject));
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bk.j(paramParcel) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.cache.MCacheItem.a
 * JD-Core Version:    0.7.0.1
 */