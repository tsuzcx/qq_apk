package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.a;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class b
{
  protected String dus;
  protected String dut;
  public InputStream inputStream;
  
  public b(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(198104);
    if (paramBoolean) {
      this.dut = a.S(paramString2, paramString1);
    }
    for (;;)
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioConvertCacheReader", "cacheFile:%s", new Object[] { this.dut });
      try
      {
        this.inputStream = s.ao(a.hs(this.dut));
        this.dus = paramString1;
        AppMethodBeat.o(198104);
        return;
        this.dut = a.hr(paramString1);
      }
      catch (FileNotFoundException paramString2)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioConvertCacheReader", paramString2, "VFSFileOp.openRead", new Object[0]);
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioConvertCacheReader", paramString2, "VFSFileOp.openRead", new Object[0]);
        }
      }
    }
  }
  
  public final byte[] YO()
  {
    AppMethodBeat.i(198105);
    if (this.inputStream == null)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioConvertCacheReader", "readPcmDataTrack, inputStream is null");
      AppMethodBeat.o(198105);
      return null;
    }
    byte[] arrayOfByte = new byte[3536];
    try
    {
      int i = this.inputStream.read(arrayOfByte, 0, 3536);
      if (i > 0)
      {
        AppMethodBeat.o(198105);
        return arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.i.b.printErrStackTrace("MicroMsg.Mix.AudioConvertCacheReader", localException, "readPcmDataTrack", new Object[0]);
      AppMethodBeat.o(198105);
      return null;
    }
    AppMethodBeat.o(198105);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.b
 * JD-Core Version:    0.7.0.1
 */