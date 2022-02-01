package com.tencent.mm.plugin.cast.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/transportclient/writer/RemoteWriter;", "Lcom/tencent/mm/plugin/cast/transportclient/writer/RemoteWriterImp;", "()V", "connectSocket", "Ljava/net/Socket;", "getConnectSocket", "()Ljava/net/Socket;", "setConnectSocket", "(Ljava/net/Socket;)V", "isWriting", "", "outStream", "Ljava/io/OutputStream;", "createWriter", "", "socket", "destroyWriter", "stopCommand", "", "send", "", "data", "", "Companion", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b
{
  public static final a.a wNT;
  private Socket wNH;
  private boolean wNU;
  private OutputStream wNV;
  
  static
  {
    AppMethodBeat.i(274281);
    wNT = new a.a((byte)0);
    AppMethodBeat.o(274281);
  }
  
  public final void alI(String paramString)
  {
    AppMethodBeat.i(274308);
    s.u(paramString, "stopCommand");
    this.wNU = false;
    AppMethodBeat.o(274308);
  }
  
  public final int bt(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(274289);
    s.u(paramArrayOfByte, "data");
    try
    {
      if (this.wNU)
      {
        if (this.wNH == null) {
          break label75;
        }
        Object localObject = this.wNH;
        s.checkNotNull(localObject);
        if (!((Socket)localObject).isConnected()) {
          break label75;
        }
        localObject = this.wNV;
        if (localObject != null) {
          ((OutputStream)localObject).write(paramArrayOfByte);
        }
        paramArrayOfByte = this.wNV;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.flush();
        }
      }
      AppMethodBeat.o(274289);
      return 0;
      label75:
      Log.e("MicroMsg.RemoteWriter", "socket not connected");
      AppMethodBeat.o(274289);
      return -1;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.RemoteWriter", "error happened in send data");
      AppMethodBeat.o(274289);
    }
    return -1;
  }
  
  public final void d(Socket paramSocket)
  {
    AppMethodBeat.i(274299);
    s.u(paramSocket, "socket");
    this.wNV = paramSocket.getOutputStream();
    this.wNH = paramSocket;
    this.wNU = true;
    AppMethodBeat.o(274299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.g.c.a
 * JD-Core Version:    0.7.0.1
 */