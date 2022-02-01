package com.tencent.midas.comm.log.util.compressor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public class GzipCompressorOutputStream
  extends OutputStream
{
  private final byte[] _header;
  private boolean closed;
  private final CRC32 crc;
  private final byte[] deflateBuffer;
  private final Deflater deflater;
  private final OutputStream out;
  
  public GzipCompressorOutputStream(OutputStream paramOutputStream)
  {
    AppMethodBeat.i(254102);
    this.deflateBuffer = new byte[512];
    this.crc = new CRC32();
    this._header = new byte[] { 31, -117, 8, 0, 0, 0, 0, 0, 0, 0 };
    this.out = paramOutputStream;
    this.deflater = new Deflater(-1, true);
    AppMethodBeat.o(254102);
  }
  
  private void deflate()
  {
    AppMethodBeat.i(254110);
    int i = this.deflater.deflate(this.deflateBuffer, 0, this.deflateBuffer.length);
    if (i > 0) {
      this.out.write(this.deflateBuffer, 0, i);
    }
    AppMethodBeat.o(254110);
  }
  
  private void writeTrailer()
  {
    AppMethodBeat.i(254104);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putInt((int)this.crc.getValue());
    localByteBuffer.putInt(this.deflater.getTotalIn());
    this.out.write(localByteBuffer.array());
    AppMethodBeat.o(254104);
  }
  
  public void close()
  {
    AppMethodBeat.i(254115);
    if (!this.closed)
    {
      finish();
      this.deflater.end();
      this.out.close();
      this.closed = true;
    }
    AppMethodBeat.o(254115);
  }
  
  public void continued()
  {
    AppMethodBeat.i(254113);
    this.crc.reset();
    this.deflater.reset();
    AppMethodBeat.o(254113);
  }
  
  public void finish()
  {
    AppMethodBeat.i(254112);
    if (!this.deflater.finished())
    {
      this.deflater.finish();
      while (!this.deflater.finished()) {
        deflate();
      }
      writeTrailer();
    }
    AppMethodBeat.o(254112);
  }
  
  public void flush()
  {
    AppMethodBeat.i(254114);
    this.out.flush();
    AppMethodBeat.o(254114);
  }
  
  public void write(int paramInt)
  {
    AppMethodBeat.i(254105);
    write(new byte[] { (byte)(paramInt & 0xFF) }, 0, 1);
    AppMethodBeat.o(254105);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(254107);
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(254107);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254108);
    if (this.deflater.finished())
    {
      paramArrayOfByte = new IOException("Cannot write more data, the end of the compressed data stream has been reached");
      AppMethodBeat.o(254108);
      throw paramArrayOfByte;
    }
    if (paramInt2 > 0)
    {
      this.deflater.setInput(paramArrayOfByte, paramInt1, paramInt2);
      while (!this.deflater.needsInput()) {
        deflate();
      }
      this.crc.update(paramArrayOfByte, paramInt1, paramInt2);
    }
    AppMethodBeat.o(254108);
  }
  
  public void writeHeader()
  {
    AppMethodBeat.i(254103);
    this.out.write(this._header);
    AppMethodBeat.o(254103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.comm.log.util.compressor.GzipCompressorOutputStream
 * JD-Core Version:    0.7.0.1
 */