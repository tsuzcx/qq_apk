package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
  implements com.tencent.mm.ipcinvoker.extension.a
{
  public final void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(146403);
    paramObject = (b)paramObject;
    com.tencent.mm.ipcinvoker.extension.c.a(paramObject.hNK.hNQ, paramParcel);
    if (aj.cnC()) {
      com.tencent.mm.ipcinvoker.extension.c.a(paramObject.hNL.hNQ, paramParcel);
    }
    for (;;)
    {
      paramParcel.writeString(paramObject.getUri());
      paramParcel.writeInt(paramObject.getType());
      paramParcel.writeInt(paramObject.hNK.cmdId);
      paramParcel.writeInt(paramObject.hNL.cmdId);
      paramParcel.writeInt(paramObject.getTimeOut());
      AppMethodBeat.o(146403);
      return;
      paramParcel.writeString(paramObject.hNL.hNQ.getClass().getName());
    }
  }
  
  public final boolean bg(Object paramObject)
  {
    return paramObject instanceof b;
  }
  
  public final Object c(Parcel paramParcel)
  {
    AppMethodBeat.i(146404);
    b.a locala1 = new b.a();
    locala1.hNM = ((com.tencent.mm.bx.a)com.tencent.mm.ipcinvoker.extension.c.a(c.class.getName(), paramParcel));
    String str;
    if (aj.cnC()) {
      str = paramParcel.readString();
    }
    for (;;)
    {
      try
      {
        locala1.hNN = ((com.tencent.mm.bx.a)Class.forName(str).newInstance());
        locala1.uri = paramParcel.readString();
        locala1.funcId = paramParcel.readInt();
        locala1.hNO = paramParcel.readInt();
        locala1.respCmdId = paramParcel.readInt();
        locala1.timeout = paramParcel.readInt();
        paramParcel = locala1.aDC();
        AppMethodBeat.o(146404);
        return paramParcel;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", new Object[] { localException });
        locala1.hNN = new com.tencent.mm.bx.a();
        continue;
      }
      com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)com.tencent.mm.ipcinvoker.extension.c.a(c.class.getName(), paramParcel);
      Object localObject = locala;
      if (locala == null) {
        localObject = new com.tencent.mm.bx.a();
      }
      locala1.hNN = ((com.tencent.mm.bx.a)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a
 * JD-Core Version:    0.7.0.1
 */