package com.tencent.midas.comm.log.processor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.compressor.CachedByteArrayStream;
import com.tencent.midas.comm.log.util.compressor.GzipCompressorOutputStream;
import java.io.IOException;

public class APLogCompressor
{
  private GzipCompressorOutputStream gziper = null;
  private CachedByteArrayStream out = null;
  
  public static APLogCompressor create()
  {
    AppMethodBeat.i(193428);
    APLogCompressor localAPLogCompressor = new APLogCompressor();
    try
    {
      localAPLogCompressor.out = new CachedByteArrayStream(512);
      localAPLogCompressor.gziper = new GzipCompressorOutputStream(localAPLogCompressor.out);
      AppMethodBeat.o(193428);
      return localAPLogCompressor;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(193428);
    }
    return null;
  }
  
  public void close()
  {
    AppMethodBeat.i(193430);
    if (this.gziper != null) {
      this.gziper.close();
    }
    if (this.out != null) {
      this.out.close();
    }
    AppMethodBeat.o(193430);
  }
  
  public byte[] compress(byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(193429);
      this.gziper.continued();
      this.out.reset();
      this.gziper.writeHeader();
      this.gziper.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      this.gziper.finish();
      this.gziper.flush();
      paramArrayOfByte = this.out.toByteArray();
      AppMethodBeat.o(193429);
      return paramArrayOfByte;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.comm.log.processor.APLogCompressor
 * JD-Core Version:    0.7.0.1
 */