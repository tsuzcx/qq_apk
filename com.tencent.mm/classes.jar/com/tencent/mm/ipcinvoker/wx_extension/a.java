package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
  implements com.tencent.mm.ipcinvoker.extension.a
{
  public final void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(126194);
    paramObject = (b)paramObject;
    c.a(paramObject.fsV.fta, paramParcel);
    if (ah.brt()) {
      c.a(paramObject.fsW.fta, paramParcel);
    }
    for (;;)
    {
      paramParcel.writeString(paramObject.getUri());
      paramParcel.writeInt(paramObject.getType());
      paramParcel.writeInt(paramObject.fsV.cmdId);
      paramParcel.writeInt(paramObject.fsW.cmdId);
      paramParcel.writeInt(paramObject.getTimeOut());
      AppMethodBeat.o(126194);
      return;
      paramParcel.writeString(paramObject.fsW.fta.getClass().getName());
    }
  }
  
  public final boolean af(Object paramObject)
  {
    return paramObject instanceof b;
  }
  
  public final Object d(Parcel paramParcel)
  {
    AppMethodBeat.i(126195);
    b.a locala1 = new b.a();
    locala1.fsX = ((com.tencent.mm.bv.a)c.a(d.class.getName(), paramParcel));
    String str;
    if (ah.brt()) {
      str = paramParcel.readString();
    }
    for (;;)
    {
      try
      {
        locala1.fsY = ((com.tencent.mm.bv.a)Class.forName(str).newInstance());
        locala1.uri = paramParcel.readString();
        locala1.funcId = paramParcel.readInt();
        locala1.reqCmdId = paramParcel.readInt();
        locala1.respCmdId = paramParcel.readInt();
        locala1.eBM = paramParcel.readInt();
        paramParcel = locala1.ado();
        AppMethodBeat.o(126195);
        return paramParcel;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", new Object[] { localException });
        locala1.fsY = new com.tencent.mm.bv.a();
        continue;
      }
      com.tencent.mm.bv.a locala = (com.tencent.mm.bv.a)c.a(d.class.getName(), paramParcel);
      Object localObject = locala;
      if (locala == null) {
        localObject = new com.tencent.mm.bv.a();
      }
      locala1.fsY = ((com.tencent.mm.bv.a)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a
 * JD-Core Version:    0.7.0.1
 */