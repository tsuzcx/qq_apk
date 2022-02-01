package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
  implements com.tencent.mm.ipcinvoker.extension.a
{
  public final void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(146403);
    paramObject = (b)paramObject;
    com.tencent.mm.ipcinvoker.extension.c.a(paramObject.hvr.hvw, paramParcel);
    if (ai.ciE()) {
      com.tencent.mm.ipcinvoker.extension.c.a(paramObject.hvs.hvw, paramParcel);
    }
    for (;;)
    {
      paramParcel.writeString(paramObject.getUri());
      paramParcel.writeInt(paramObject.getType());
      paramParcel.writeInt(paramObject.hvr.cmdId);
      paramParcel.writeInt(paramObject.hvs.cmdId);
      paramParcel.writeInt(paramObject.getTimeOut());
      AppMethodBeat.o(146403);
      return;
      paramParcel.writeString(paramObject.hvs.hvw.getClass().getName());
    }
  }
  
  public final boolean be(Object paramObject)
  {
    return paramObject instanceof b;
  }
  
  public final Object c(Parcel paramParcel)
  {
    AppMethodBeat.i(146404);
    b.a locala1 = new b.a();
    locala1.hvt = ((com.tencent.mm.bw.a)com.tencent.mm.ipcinvoker.extension.c.a(c.class.getName(), paramParcel));
    String str;
    if (ai.ciE()) {
      str = paramParcel.readString();
    }
    for (;;)
    {
      try
      {
        locala1.hvu = ((com.tencent.mm.bw.a)Class.forName(str).newInstance());
        locala1.uri = paramParcel.readString();
        locala1.funcId = paramParcel.readInt();
        locala1.reqCmdId = paramParcel.readInt();
        locala1.respCmdId = paramParcel.readInt();
        locala1.timeout = paramParcel.readInt();
        paramParcel = locala1.aAz();
        AppMethodBeat.o(146404);
        return paramParcel;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", new Object[] { localException });
        locala1.hvu = new com.tencent.mm.bw.a();
        continue;
      }
      com.tencent.mm.bw.a locala = (com.tencent.mm.bw.a)com.tencent.mm.ipcinvoker.extension.c.a(c.class.getName(), paramParcel);
      Object localObject = locala;
      if (locala == null) {
        localObject = new com.tencent.mm.bw.a();
      }
      locala1.hvu = ((com.tencent.mm.bw.a)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a
 * JD-Core Version:    0.7.0.1
 */