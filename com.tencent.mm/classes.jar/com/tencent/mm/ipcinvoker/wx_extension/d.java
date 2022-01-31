package com.tencent.mm.ipcinvoker.wx_extension;

import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import org.apache.commons.b.g;

public final class d
  implements com.tencent.mm.ipcinvoker.extension.a
{
  private static final as eEU;
  
  static
  {
    AppMethodBeat.i(101704);
    eEU = as.eu("MicroMsg.XIPC.MMProtoBufTransfer", 2);
    AppMethodBeat.o(101704);
  }
  
  public final void a(Object paramObject, Parcel paramParcel)
  {
    int i = 1;
    AppMethodBeat.i(101702);
    if (paramObject == null)
    {
      paramParcel.writeString(null);
      AppMethodBeat.o(101702);
      return;
    }
    Object localObject = (com.tencent.mm.bv.a)paramObject;
    paramParcel.writeString(localObject.getClass().getName());
    try
    {
      localObject = ((com.tencent.mm.bv.a)localObject).toByteArray();
      if ((localObject.length > 102400) && (eEU != null))
      {
        paramObject = g.b(new String[] { ah.getProcessName(), paramObject.getClass().getName(), paramObject.hashCode(), bo.yB() }, "$");
        eEU.putString(paramObject, Base64.encodeToString((byte[])localObject, 0)).commit();
        if (eEU.getString(paramObject, null) != null)
        {
          paramParcel.writeString(paramObject);
          if (i == 0)
          {
            paramParcel.writeString(null);
            paramParcel.writeInt(localObject.length);
            paramParcel.writeByteArray((byte[])localObject);
          }
          AppMethodBeat.o(101702);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.XIPC.MMProtoBufTransfer", "writeToParcel, e = %s", new Object[] { localException });
        byte[] arrayOfByte = new byte[0];
        continue;
        i = 0;
      }
    }
  }
  
  public final boolean af(Object paramObject)
  {
    return paramObject instanceof com.tencent.mm.bv.a;
  }
  
  public final Object d(Parcel paramParcel)
  {
    AppMethodBeat.i(101703);
    String str = paramParcel.readString();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(101703);
      return null;
    }
    Object localObject = paramParcel.readString();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      if (eEU == null)
      {
        paramParcel = null;
        if (TextUtils.isEmpty(paramParcel)) {
          break label101;
        }
      }
    }
    for (paramParcel = Base64.decode(paramParcel, 0);; paramParcel = (Parcel)localObject)
    {
      try
      {
        localObject = (com.tencent.mm.bv.a)org.a.a.ba(org.a.a.forName(str)).erv().object;
        ((com.tencent.mm.bv.a)localObject).parseFrom(paramParcel);
        paramParcel = (Parcel)localObject;
      }
      catch (Exception paramParcel)
      {
        for (;;)
        {
          label101:
          ab.e("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel, e = %s", new Object[] { paramParcel });
          paramParcel = null;
        }
      }
      AppMethodBeat.o(101703);
      return paramParcel;
      paramParcel = eEU.getString((String)localObject, null);
      break;
      ab.e("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel, NULL base64, gProtoBufXProcessStore[%s]", new Object[] { eEU });
      AppMethodBeat.o(101703);
      return null;
      localObject = new byte[paramParcel.readInt()];
      paramParcel.readByteArray((byte[])localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.d
 * JD-Core Version:    0.7.0.1
 */