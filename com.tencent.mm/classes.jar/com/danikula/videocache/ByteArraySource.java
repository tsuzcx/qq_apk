package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;

public class ByteArraySource
  implements Source
{
  private ByteArrayInputStream arrayInputStream;
  private final byte[] data;
  
  public ByteArraySource(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  public void close() {}
  
  public long length()
  {
    return this.data.length;
  }
  
  public void open(long paramLong)
  {
    AppMethodBeat.i(190270);
    this.arrayInputStream = new ByteArrayInputStream(this.data);
    this.arrayInputStream.skip(paramLong);
    AppMethodBeat.o(190270);
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190269);
    int i = this.arrayInputStream.read(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(190269);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.danikula.videocache.ByteArraySource
 * JD-Core Version:    0.7.0.1
 */