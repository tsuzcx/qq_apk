package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
  implements com.tencent.mm.ipcinvoker.extension.a
{
  public final void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(146403);
    paramObject = (b)paramObject;
    com.tencent.mm.ipcinvoker.extension.c.a(paramObject.hQD.hQJ, paramParcel);
    if (ak.cpe()) {
      com.tencent.mm.ipcinvoker.extension.c.a(paramObject.hQE.hQJ, paramParcel);
    }
    for (;;)
    {
      paramParcel.writeString(paramObject.getUri());
      paramParcel.writeInt(paramObject.getType());
      paramParcel.writeInt(paramObject.hQD.cmdId);
      paramParcel.writeInt(paramObject.hQE.cmdId);
      paramParcel.writeInt(paramObject.getTimeOut());
      AppMethodBeat.o(146403);
      return;
      paramParcel.writeString(paramObject.hQE.hQJ.getClass().getName());
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
    locala1.hQF = ((com.tencent.mm.bw.a)com.tencent.mm.ipcinvoker.extension.c.a(c.class.getName(), paramParcel));
    String str;
    if (ak.cpe()) {
      str = paramParcel.readString();
    }
    for (;;)
    {
      try
      {
        locala1.hQG = ((com.tencent.mm.bw.a)Class.forName(str).newInstance());
        locala1.uri = paramParcel.readString();
        locala1.funcId = paramParcel.readInt();
        locala1.hQH = paramParcel.readInt();
        locala1.respCmdId = paramParcel.readInt();
        locala1.timeout = paramParcel.readInt();
        paramParcel = locala1.aDS();
        AppMethodBeat.o(146404);
        return paramParcel;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", new Object[] { localException });
        locala1.hQG = new com.tencent.mm.bw.a();
        continue;
      }
      com.tencent.mm.bw.a locala = (com.tencent.mm.bw.a)com.tencent.mm.ipcinvoker.extension.c.a(c.class.getName(), paramParcel);
      Object localObject = locala;
      if (locala == null) {
        localObject = new com.tencent.mm.bw.a();
      }
      locala1.hQG = ((com.tencent.mm.bw.a)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a
 * JD-Core Version:    0.7.0.1
 */