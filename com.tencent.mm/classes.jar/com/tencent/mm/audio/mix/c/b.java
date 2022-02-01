package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.a;
import com.tencent.mm.vfs.u;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class b
{
  public InputStream aFw;
  protected String fna;
  protected String fnb;
  
  public b(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(257470);
    if (paramBoolean) {
      this.fnb = a.X(paramString2, paramString1);
    }
    for (;;)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioConvertCacheReader", "cacheFile:%s", new Object[] { this.fnb });
      try
      {
        this.aFw = u.al(a.ig(this.fnb));
        this.fna = paramString1;
        AppMethodBeat.o(257470);
        return;
        this.fnb = a.jdMethod_if(paramString1);
      }
      catch (FileNotFoundException paramString2)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioConvertCacheReader", paramString2, "VFSFileOp.openRead", new Object[0]);
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioConvertCacheReader", paramString2, "VFSFileOp.openRead", new Object[0]);
        }
      }
    }
  }
  
  public final byte[] adv()
  {
    AppMethodBeat.i(257471);
    if (this.aFw == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioConvertCacheReader", "readPcmDataTrack, inputStream is null");
      AppMethodBeat.o(257471);
      return null;
    }
    byte[] arrayOfByte = new byte[3536];
    try
    {
      int i = this.aFw.read(arrayOfByte, 0, 3536);
      if (i > 0)
      {
        AppMethodBeat.o(257471);
        return arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioConvertCacheReader", localException, "readPcmDataTrack", new Object[0]);
      AppMethodBeat.o(257471);
      return null;
    }
    AppMethodBeat.o(257471);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.b
 * JD-Core Version:    0.7.0.1
 */