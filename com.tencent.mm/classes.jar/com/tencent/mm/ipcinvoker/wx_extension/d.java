package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  implements com.tencent.mm.ipcinvoker.extension.a
{
  public final boolean X(Object paramObject)
  {
    return paramObject instanceof com.tencent.mm.bv.a;
  }
  
  public final void a(Object paramObject, Parcel paramParcel)
  {
    if (paramObject == null)
    {
      paramParcel.writeString(null);
      return;
    }
    paramObject = (com.tencent.mm.bv.a)paramObject;
    paramParcel.writeString(paramObject.getClass().getName());
    try
    {
      paramObject = paramObject.toByteArray();
      paramParcel.writeInt(paramObject.length);
      paramParcel.writeByteArray(paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        y.e("MicroMsg.XIPC.MMProtoBufTransfer", "writeToParcel, e = %s", new Object[] { paramObject });
        paramObject = new byte[0];
      }
    }
  }
  
  public final Object c(Parcel paramParcel)
  {
    String str = paramParcel.readString();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    try
    {
      paramParcel = (com.tencent.mm.bv.a)Class.forName(str).newInstance();
      paramParcel.aH(arrayOfByte);
      return paramParcel;
    }
    catch (Exception paramParcel)
    {
      for (;;)
      {
        y.e("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel, e = %s", new Object[] { paramParcel });
        paramParcel = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.d
 * JD-Core Version:    0.7.0.1
 */