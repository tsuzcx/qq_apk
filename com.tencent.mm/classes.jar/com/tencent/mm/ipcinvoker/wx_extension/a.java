package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  implements com.tencent.mm.ipcinvoker.extension.a
{
  public final boolean X(Object paramObject)
  {
    return paramObject instanceof b;
  }
  
  public final void a(Object paramObject, Parcel paramParcel)
  {
    paramObject = (b)paramObject;
    c.a(paramObject.ecE.ecN, paramParcel);
    if (ae.cqV()) {
      c.a(paramObject.ecF.ecN, paramParcel);
    }
    for (;;)
    {
      paramParcel.writeString(paramObject.uri);
      paramParcel.writeInt(paramObject.ecG);
      paramParcel.writeInt(paramObject.ecE.cmdId);
      paramParcel.writeInt(paramObject.ecF.cmdId);
      paramParcel.writeInt(paramObject.dEk);
      return;
      paramParcel.writeString(paramObject.ecF.ecN.getClass().getName());
    }
  }
  
  public final Object c(Parcel paramParcel)
  {
    b.a locala1 = new b.a();
    locala1.ecH = ((com.tencent.mm.bv.a)c.a(d.class.getName(), paramParcel));
    String str;
    if (ae.cqV()) {
      str = paramParcel.readString();
    }
    for (;;)
    {
      try
      {
        locala1.ecI = ((com.tencent.mm.bv.a)Class.forName(str).newInstance());
        locala1.uri = paramParcel.readString();
        locala1.ecG = paramParcel.readInt();
        locala1.ecJ = paramParcel.readInt();
        locala1.ecK = paramParcel.readInt();
        locala1.dEk = paramParcel.readInt();
        return locala1.Kt();
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", new Object[] { localException });
        locala1.ecI = new com.tencent.mm.bv.a();
        continue;
      }
      com.tencent.mm.bv.a locala = (com.tencent.mm.bv.a)c.a(d.class.getName(), paramParcel);
      Object localObject = locala;
      if (locala == null) {
        localObject = new com.tencent.mm.bv.a();
      }
      locala1.ecI = ((com.tencent.mm.bv.a)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a
 * JD-Core Version:    0.7.0.1
 */