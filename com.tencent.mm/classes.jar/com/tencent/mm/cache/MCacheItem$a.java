package com.tencent.mm.cache;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class MCacheItem$a
{
  public static Map<Class<?>, Method> ecy;
  public static Map<Class<?>, Method> ecz;
  
  static
  {
    AppMethodBeat.i(57844);
    ecy = new HashMap();
    ecz = new HashMap();
    try
    {
      ecy.put([B.class, a.class.getMethod("keep_writeByteArray", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(Short.TYPE, a.class.getMethod("keep_writeShort", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(Short.class, a.class.getMethod("keep_writeShort", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(Boolean.TYPE, a.class.getMethod("keep_writeBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(Boolean.class, a.class.getMethod("keep_writeBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(Integer.TYPE, a.class.getMethod("keep_writeInt", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(Integer.class, a.class.getMethod("keep_writeInt", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(Float.TYPE, a.class.getMethod("keep_writeFloat", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(Float.class, a.class.getMethod("keep_writeFloat", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(Double.TYPE, a.class.getMethod("keep_writeDouble", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(Double.class, a.class.getMethod("keep_writeDouble", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(Long.TYPE, a.class.getMethod("keep_writeLong", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(Long.class, a.class.getMethod("keep_writeLong", new Class[] { Parcel.class, Field.class, Object.class }));
      ecy.put(String.class, a.class.getMethod("keep_writeString", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put([B.class, a.class.getMethod("keep_readByteArray", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(Short.TYPE, a.class.getMethod("keep_readShort", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(Short.class, a.class.getMethod("keep_readShort", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(Boolean.TYPE, a.class.getMethod("keep_readBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(Boolean.class, a.class.getMethod("keep_readBoolean", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(Integer.TYPE, a.class.getMethod("keep_readInt", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(Integer.class, a.class.getMethod("keep_readInt", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(Float.TYPE, a.class.getMethod("keep_readFloat", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(Float.class, a.class.getMethod("keep_readFloat", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(Double.TYPE, a.class.getMethod("keep_readDouble", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(Double.class, a.class.getMethod("keep_readDouble", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(Long.TYPE, a.class.getMethod("keep_readLong", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(Long.class, a.class.getMethod("keep_readLong", new Class[] { Parcel.class, Field.class, Object.class }));
      ecz.put(String.class, a.class.getMethod("keep_readString", new Class[] { Parcel.class, Field.class, Object.class }));
      AppMethodBeat.o(57844);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(57844);
    }
  }
  
  public static void keep_readBoolean(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57838);
    try
    {
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramField.setBoolean(paramObject, bool);
        AppMethodBeat.o(57838);
        return;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57838);
    }
  }
  
  public static void keep_readByteArray(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57836);
    try
    {
      paramField.set(paramObject, paramParcel.createByteArray());
      AppMethodBeat.o(57836);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57836);
    }
  }
  
  public static void keep_readDouble(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57841);
    try
    {
      paramField.setDouble(paramObject, paramParcel.readDouble());
      AppMethodBeat.o(57841);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57841);
    }
  }
  
  public static void keep_readFloat(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57840);
    try
    {
      paramField.setFloat(paramObject, paramParcel.readFloat());
      AppMethodBeat.o(57840);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57840);
    }
  }
  
  public static void keep_readInt(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57839);
    try
    {
      paramField.setInt(paramObject, paramParcel.readInt());
      AppMethodBeat.o(57839);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57839);
    }
  }
  
  public static void keep_readLong(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57842);
    try
    {
      paramField.set(paramObject, Long.valueOf(paramParcel.readLong()));
      AppMethodBeat.o(57842);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57842);
    }
  }
  
  public static void keep_readShort(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57837);
    try
    {
      paramField.setShort(paramObject, (short)paramParcel.readInt());
      AppMethodBeat.o(57837);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57837);
    }
  }
  
  public static void keep_readString(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57843);
    try
    {
      paramField.set(paramObject, paramParcel.readString());
      AppMethodBeat.o(57843);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57843);
    }
  }
  
  public static void keep_writeBoolean(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57830);
    try
    {
      if (paramField.getBoolean(paramObject)) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeInt(i);
        AppMethodBeat.o(57830);
        return;
      }
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57830);
    }
  }
  
  public static void keep_writeByteArray(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57828);
    try
    {
      paramParcel.writeByteArray((byte[])paramField.get(paramObject));
      AppMethodBeat.o(57828);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57828);
    }
  }
  
  public static void keep_writeDouble(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57833);
    try
    {
      paramParcel.writeDouble(paramField.getDouble(paramObject));
      AppMethodBeat.o(57833);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57833);
    }
  }
  
  public static void keep_writeFloat(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57832);
    try
    {
      paramParcel.writeFloat(paramField.getFloat(paramObject));
      AppMethodBeat.o(57832);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57832);
    }
  }
  
  public static void keep_writeInt(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57831);
    try
    {
      paramParcel.writeInt(paramField.getInt(paramObject));
      AppMethodBeat.o(57831);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57831);
    }
  }
  
  public static void keep_writeLong(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57834);
    try
    {
      paramParcel.writeLong(paramField.getLong(paramObject));
      AppMethodBeat.o(57834);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57834);
    }
  }
  
  public static void keep_writeShort(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57829);
    try
    {
      paramParcel.writeInt(paramField.getShort(paramObject));
      AppMethodBeat.o(57829);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57829);
    }
  }
  
  public static void keep_writeString(Parcel paramParcel, Field paramField, Object paramObject)
  {
    AppMethodBeat.i(57835);
    try
    {
      paramParcel.writeString((String)paramField.get(paramObject));
      AppMethodBeat.o(57835);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.e("MicroMsg.MCacheItem", "exception:%s", new Object[] { bo.l(paramParcel) });
      AppMethodBeat.o(57835);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.cache.MCacheItem.a
 * JD-Core Version:    0.7.0.1
 */