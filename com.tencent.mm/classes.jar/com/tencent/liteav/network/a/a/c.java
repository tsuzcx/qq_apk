package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.a;
import com.tencent.liteav.network.a.d;
import com.tencent.liteav.network.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public final class c
  implements com.tencent.liteav.network.a.c
{
  private static final Random b;
  final InetAddress a;
  private final int c;
  
  static
  {
    AppMethodBeat.i(67641);
    b = new Random();
    AppMethodBeat.o(67641);
  }
  
  public c(InetAddress paramInetAddress)
  {
    this(paramInetAddress, 10);
  }
  
  public c(InetAddress paramInetAddress, int paramInt)
  {
    this.a = paramInetAddress;
    this.c = paramInt;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67640);
    DatagramSocket localDatagramSocket;
    try
    {
      localDatagramSocket = new DatagramSocket();
      if (localDatagramSocket == null) {
        break label95;
      }
    }
    finally
    {
      try
      {
        paramArrayOfByte = new DatagramPacket(paramArrayOfByte, paramArrayOfByte.length, this.a, 53);
        localDatagramSocket.setSoTimeout(this.c * 1000);
        localDatagramSocket.send(paramArrayOfByte);
        paramArrayOfByte = new DatagramPacket(new byte[1500], 1500);
        localDatagramSocket.receive(paramArrayOfByte);
        paramArrayOfByte = paramArrayOfByte.getData();
        localDatagramSocket.close();
        AppMethodBeat.o(67640);
        return paramArrayOfByte;
      }
      finally {}
      paramArrayOfByte = finally;
      localDatagramSocket = null;
    }
    localDatagramSocket.close();
    label95:
    AppMethodBeat.o(67640);
    throw paramArrayOfByte;
  }
  
  public final e[] a(com.tencent.liteav.network.a.b paramb, d arg2)
  {
    AppMethodBeat.i(67639);
    int i;
    synchronized (b)
    {
      i = b.nextInt() & 0xFF;
      ??? = a(b.a(paramb.a, i));
      if (??? == null)
      {
        paramb = new a(paramb.a, "cant get answer");
        AppMethodBeat.o(67639);
        throw paramb;
      }
    }
    paramb = b.a(???, i, paramb.a);
    AppMethodBeat.o(67639);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.network.a.a.c
 * JD-Core Version:    0.7.0.1
 */