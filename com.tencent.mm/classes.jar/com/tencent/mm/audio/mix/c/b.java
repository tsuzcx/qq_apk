package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.a;
import com.tencent.mm.vfs.y;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class b
{
  protected String hrl;
  protected String hrm;
  public InputStream inputStream;
  
  public b(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(236199);
    if (paramBoolean) {
      this.hrm = a.ac(paramString2, paramString1);
    }
    for (;;)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioConvertCacheReader", "cacheFile:%s", new Object[] { this.hrm });
      try
      {
        this.inputStream = y.ao(a.jH(this.hrm));
        this.hrl = paramString1;
        AppMethodBeat.o(236199);
        return;
        this.hrm = a.jG(paramString1);
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
  
  public final byte[] aFu()
  {
    AppMethodBeat.i(236200);
    if (this.inputStream == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioConvertCacheReader", "readPcmDataTrack, inputStream is null");
      AppMethodBeat.o(236200);
      return null;
    }
    byte[] arrayOfByte = new byte[3536];
    try
    {
      int i = this.inputStream.read(arrayOfByte, 0, 3536);
      if (i > 0)
      {
        AppMethodBeat.o(236200);
        return arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioConvertCacheReader", localException, "readPcmDataTrack", new Object[0]);
      AppMethodBeat.o(236200);
      return null;
    }
    AppMethodBeat.o(236200);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.b
 * JD-Core Version:    0.7.0.1
 */