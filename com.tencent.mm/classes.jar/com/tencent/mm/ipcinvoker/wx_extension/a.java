package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  implements com.tencent.mm.ipcinvoker.extension.a
{
  public final void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(146403);
    paramObject = (d)paramObject;
    com.tencent.mm.ipcinvoker.extension.c.a(paramObject.iLK.iLR, paramParcel);
    if (MMApplicationContext.isMMProcess()) {
      com.tencent.mm.ipcinvoker.extension.c.a(paramObject.iLL.iLR, paramParcel);
    }
    for (;;)
    {
      paramParcel.writeString(paramObject.getUri());
      paramParcel.writeInt(paramObject.getType());
      paramParcel.writeInt(paramObject.iLK.cmdId);
      paramParcel.writeInt(paramObject.iLL.cmdId);
      paramParcel.writeInt(paramObject.getTimeOut());
      AppMethodBeat.o(146403);
      return;
      paramParcel.writeString(paramObject.iLL.iLR.getClass().getName());
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
    locala1.iLN = ((com.tencent.mm.bw.a)com.tencent.mm.ipcinvoker.extension.c.a(c.class.getName(), paramParcel));
    String str;
    if (MMApplicationContext.isMMProcess()) {
      str = paramParcel.readString();
    }
    for (;;)
    {
      try
      {
        locala1.iLO = ((com.tencent.mm.bw.a)Class.forName(str).newInstance());
        locala1.uri = paramParcel.readString();
        locala1.funcId = paramParcel.readInt();
        locala1.iLP = paramParcel.readInt();
        locala1.respCmdId = paramParcel.readInt();
        locala1.timeout = paramParcel.readInt();
        paramParcel = locala1.aXF();
        AppMethodBeat.o(146404);
        return paramParcel;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", new Object[] { localException });
        locala1.iLO = new com.tencent.mm.bw.a();
        continue;
      }
      com.tencent.mm.bw.a locala = (com.tencent.mm.bw.a)com.tencent.mm.ipcinvoker.extension.c.a(c.class.getName(), paramParcel);
      Object localObject = locala;
      if (locala == null) {
        localObject = new com.tencent.mm.bw.a();
      }
      locala1.iLO = ((com.tencent.mm.bw.a)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a
 * JD-Core Version:    0.7.0.1
 */