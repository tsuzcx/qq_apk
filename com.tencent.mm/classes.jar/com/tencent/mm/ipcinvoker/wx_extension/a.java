package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  implements com.tencent.mm.ipcinvoker.extension.a
{
  public final void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(146403);
    paramObject = (d)paramObject;
    com.tencent.mm.ipcinvoker.extension.c.a(d.b.b(paramObject.lBR), paramParcel);
    if (MMApplicationContext.isMMProcess()) {
      com.tencent.mm.ipcinvoker.extension.c.a(d.c.b(paramObject.lBS), paramParcel);
    }
    for (;;)
    {
      paramParcel.writeString(paramObject.getUri());
      paramParcel.writeInt(paramObject.getType());
      paramParcel.writeInt(d.b.a(paramObject.lBR));
      paramParcel.writeInt(d.c.a(paramObject.lBS));
      paramParcel.writeInt(paramObject.getTimeOut());
      AppMethodBeat.o(146403);
      return;
      paramParcel.writeString(d.c.b(paramObject.lBS).getClass().getName());
    }
  }
  
  public final boolean bp(Object paramObject)
  {
    return paramObject instanceof d;
  }
  
  public final Object d(Parcel paramParcel)
  {
    AppMethodBeat.i(146404);
    d.a locala1 = new d.a();
    locala1.lBU = ((com.tencent.mm.cd.a)com.tencent.mm.ipcinvoker.extension.c.a(c.class.getName(), paramParcel));
    String str;
    if (MMApplicationContext.isMMProcess()) {
      str = paramParcel.readString();
    }
    for (;;)
    {
      try
      {
        locala1.lBV = ((com.tencent.mm.cd.a)Class.forName(str).newInstance());
        locala1.uri = paramParcel.readString();
        locala1.funcId = paramParcel.readInt();
        locala1.lBW = paramParcel.readInt();
        locala1.respCmdId = paramParcel.readInt();
        locala1.timeout = paramParcel.readInt();
        paramParcel = locala1.bgN();
        AppMethodBeat.o(146404);
        return paramParcel;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", new Object[] { localException });
        locala1.lBV = new com.tencent.mm.cd.a();
        continue;
      }
      com.tencent.mm.cd.a locala = (com.tencent.mm.cd.a)com.tencent.mm.ipcinvoker.extension.c.a(c.class.getName(), paramParcel);
      Object localObject = locala;
      if (locala == null) {
        localObject = new com.tencent.mm.cd.a();
      }
      locala1.lBV = ((com.tencent.mm.cd.a)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a
 * JD-Core Version:    0.7.0.1
 */