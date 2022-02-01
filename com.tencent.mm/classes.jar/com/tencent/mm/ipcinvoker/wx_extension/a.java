package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  implements com.tencent.mm.ipcinvoker.extension.a
{
  public final void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(146403);
    paramObject = (com.tencent.mm.am.c)paramObject;
    com.tencent.mm.ipcinvoker.extension.c.a(c.b.b(paramObject.otB), paramParcel);
    if (MMApplicationContext.isMMProcess()) {
      com.tencent.mm.ipcinvoker.extension.c.a(c.c.b(paramObject.otC), paramParcel);
    }
    for (;;)
    {
      paramParcel.writeString(paramObject.getUri());
      paramParcel.writeInt(paramObject.getType());
      paramParcel.writeInt(c.b.a(paramObject.otB));
      paramParcel.writeInt(c.c.a(paramObject.otC));
      paramParcel.writeInt(paramObject.getTimeOut());
      AppMethodBeat.o(146403);
      return;
      paramParcel.writeString(c.c.b(paramObject.otC).getClass().getName());
    }
  }
  
  public final boolean cJ(Object paramObject)
  {
    return paramObject instanceof com.tencent.mm.am.c;
  }
  
  public final Object f(Parcel paramParcel)
  {
    AppMethodBeat.i(146404);
    c.a locala1 = new c.a();
    locala1.otE = ((com.tencent.mm.bx.a)com.tencent.mm.ipcinvoker.extension.c.a(c.class.getName(), paramParcel));
    String str;
    if (MMApplicationContext.isMMProcess()) {
      str = paramParcel.readString();
    }
    for (;;)
    {
      try
      {
        locala1.otF = ((com.tencent.mm.bx.a)Class.forName(str).newInstance());
        locala1.uri = paramParcel.readString();
        locala1.funcId = paramParcel.readInt();
        locala1.otG = paramParcel.readInt();
        locala1.respCmdId = paramParcel.readInt();
        locala1.timeout = paramParcel.readInt();
        paramParcel = locala1.bEF();
        AppMethodBeat.o(146404);
        return paramParcel;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", new Object[] { localException });
        locala1.otF = new com.tencent.mm.bx.a();
        continue;
      }
      com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)com.tencent.mm.ipcinvoker.extension.c.a(c.class.getName(), paramParcel);
      Object localObject = locala;
      if (locala == null) {
        localObject = new com.tencent.mm.bx.a();
      }
      locala1.otF = ((com.tencent.mm.bx.a)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a
 * JD-Core Version:    0.7.0.1
 */