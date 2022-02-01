package com.tencent.mm.cache;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class MCacheItem$a
{
  public static Map<Class<?>, Method> GET_METHODS;
  public static Map<Class<?>, Method> SET_METHODS;
  
  static
  {
    AppMethodBeat.i(131965);
    SET_METHODS = new HashMap();
    GET_METHODS = new HashMap();
    try
    {
      SET_METHODS.put([B.class, a.class.getMethod("keep_writeByteArray", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(Short.TYPE, a.class.getMethod("keep_writeShort", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(Short.class, a.class.getMethod("keep_writeShort", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(Boolean.TYPE, a.class.getMethod("keep_writeBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(Boolean.class, a.class.getMethod("keep_writeBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(Integer.TYPE, a.class.getMethod("keep_writeInt", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(Integer.class, a.class.getMethod("keep_writeInt", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(Float.TYPE, a.class.getMethod("keep_writeFloat", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(Float.class, a.class.getMethod("keep_writeFloat", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(Double.TYPE, a.class.getMethod("keep_writeDouble", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(Double.class, a.class.getMethod("keep_writeDouble", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(Long.TYPE, a.class.getMethod("keep_writeLong", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(Long.class, a.class.getMethod("keep_writeLong", new Class[] { Parcel.class, Field.class, Object.class }));
      SET_METHODS.put(String.class, a.class.getMethod("keep_writeString", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put([B.class, a.class.getMethod("keep_readByteArray", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(Short.TYPE, a.class.getMethod("keep_readShort", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(Short.class, a.class.getMethod("keep_readShort", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(Boolean.TYPE, a.class.getMethod("keep_readBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(Boolean.class, a.class.getMethod("keep_readBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(Integer.TYPE, a.class.getMethod("keep_readInt", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(Integer.class, a.class.getMethod("keep_readInt", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(Float.TYPE, a.class.getMethod("keep_readFloat", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(Float.class, a.class.getMethod("keep_readFloat", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(Double.TYPE, a.class.getMethod("keep_readDouble", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(Double.class, a.class.getMethod("keep_readDouble", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(Long.TYPE, a.class.getMethod("keep_readLong", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(Long.class, a.class.getMethod("keep_readLong", new Class[] { Parcel.class, Field.class, Object.class }));
      GET_METHODS.put(String.class, a.class.getMethod("keep_readString", new Class[] { Parcel.class, Field.class, Object.class }));
      AppMethodBeat.o(131965);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
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
      Log.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { Util.stackTraceToString(paramParcel) });
      AppMethodBeat.o(131956);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cache.MCacheItem.a
 * JD-Core Version:    0.7.0.1
 */