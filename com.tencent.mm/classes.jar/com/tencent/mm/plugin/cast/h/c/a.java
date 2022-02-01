package com.tencent.mm.plugin.cast.h.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/transportclient/writer/RemoteWriter;", "Lcom/tencent/mm/plugin/cast/transportclient/writer/RemoteWriterImp;", "()V", "connectSocket", "Ljava/net/Socket;", "getConnectSocket", "()Ljava/net/Socket;", "setConnectSocket", "(Ljava/net/Socket;)V", "isWriting", "", "outStream", "Ljava/io/OutputStream;", "createWriter", "", "socket", "destroyWriter", "stopCommand", "", "send", "", "data", "", "Companion", "plugin-cast_release"})
public final class a
  implements b
{
  public static final a.a tKC;
  private boolean tKA;
  private OutputStream tKB;
  private Socket tKo;
  
  static
  {
    AppMethodBeat.i(190631);
    tKC = new a.a((byte)0);
    AppMethodBeat.o(190631);
  }
  
  public final void ase(String paramString)
  {
    AppMethodBeat.i(190627);
    p.k(paramString, "stopCommand");
    this.tKA = false;
    AppMethodBeat.o(190627);
  }
  
  public final int bt(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190620);
    p.k(paramArrayOfByte, "data");
    try
    {
      if (this.tKA)
      {
        if (this.tKo == null) {
          break label78;
        }
        Object localObject = this.tKo;
        if (localObject == null) {
          p.iCn();
        }
        if (!((Socket)localObject).isConnected()) {
          break label78;
        }
        localObject = this.tKB;
        if (localObject != null) {
          ((OutputStream)localObject).write(paramArrayOfByte);
        }
        paramArrayOfByte = this.tKB;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.flush();
        }
      }
      AppMethodBeat.o(190620);
      return 0;
      label78:
      Log.e("MicroMsg.RemoteWriter", "socket not connected");
      AppMethodBeat.o(190620);
      return -1;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.RemoteWriter", "error happened in send data");
      AppMethodBeat.o(190620);
    }
    return -1;
  }
  
  public final void d(Socket paramSocket)
  {
    AppMethodBeat.i(190624);
    p.k(paramSocket, "socket");
    this.tKB = paramSocket.getOutputStream();
    this.tKo = paramSocket;
    this.tKA = true;
    AppMethodBeat.o(190624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.h.c.a
 * JD-Core Version:    0.7.0.1
 */