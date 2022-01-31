package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.d;
import com.tencent.liteav.network.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.net.InetAddress;

final class a$1
  implements com.tencent.liteav.network.a.c
{
  public final e[] a(b paramb, d paramd)
  {
    AppMethodBeat.i(67638);
    InetAddress[] arrayOfInetAddress2 = a.b();
    InetAddress[] arrayOfInetAddress1 = arrayOfInetAddress2;
    if (arrayOfInetAddress2 == null) {
      arrayOfInetAddress1 = a.a();
    }
    if (arrayOfInetAddress1 == null)
    {
      paramb = new IOException("cant get local dns server");
      AppMethodBeat.o(67638);
      throw paramb;
    }
    paramb = new c(arrayOfInetAddress1[0]).a(paramb, paramd);
    AppMethodBeat.o(67638);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */