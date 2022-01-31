package com.tencent.mm.audio.mix.e;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.a;
import com.tencent.mm.audio.mix.h.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public final class g
{
  private static Object ceY;
  private static g cgW;
  private boolean bRB;
  private String ceV;
  private boolean cgX;
  private FileOutputStream outputStream;
  
  static
  {
    AppMethodBeat.i(137127);
    ceY = new Object();
    AppMethodBeat.o(137127);
  }
  
  private g()
  {
    AppMethodBeat.i(137126);
    this.bRB = false;
    this.cgX = true;
    if (!this.bRB)
    {
      this.bRB = true;
      this.ceV = DX();
      b.i("MicroMsg.Mix.ExportMixAudioPcmFile", "outFile:%s", new Object[] { this.ceV });
      new File(this.ceV).delete();
      try
      {
        this.outputStream = new FileOutputStream(a.eE(this.ceV));
        AppMethodBeat.o(137126);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", localFileNotFoundException, "new FileOutputStream", new Object[0]);
        AppMethodBeat.o(137126);
        return;
      }
      catch (Exception localException)
      {
        b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", localException, "new FileOutputStream", new Object[0]);
      }
    }
    AppMethodBeat.o(137126);
  }
  
  private static g DW()
  {
    AppMethodBeat.i(137123);
    if (cgW == null) {}
    synchronized (ceY)
    {
      if (cgW == null) {
        cgW = new g();
      }
      ??? = cgW;
      AppMethodBeat.o(137123);
      return ???;
    }
  }
  
  private static String DX()
  {
    AppMethodBeat.i(137124);
    Object localObject = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = localObject + File.separator + "mix_audio_pcm.pcm";
    AppMethodBeat.o(137124);
    return localObject;
  }
  
  public static void DY()
  {
    AppMethodBeat.i(137125);
    new File(DX()).delete();
    g localg = DW();
    if (localg.bRB) {
      b.i("MicroMsg.Mix.ExportMixAudioPcmFile", "finishProcess");
    }
    try
    {
      if (localg.outputStream != null)
      {
        localg.outputStream.flush();
        localg.outputStream.close();
        localg.outputStream = null;
      }
      localg.bRB = false;
      AppMethodBeat.o(137125);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", localException, "finishProcess", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.g
 * JD-Core Version:    0.7.0.1
 */