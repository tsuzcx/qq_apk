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
  private static Object fnq;
  private static g fpD;
  private String fnn;
  private boolean fpE;
  private boolean isInit;
  private FileOutputStream outputStream;
  
  static
  {
    AppMethodBeat.i(136876);
    fnq = new Object();
    AppMethodBeat.o(136876);
  }
  
  private g()
  {
    AppMethodBeat.i(136875);
    this.isInit = false;
    this.fpE = true;
    if (!this.isInit)
    {
      this.isInit = true;
      this.fnn = aeo();
      b.i("MicroMsg.Mix.ExportMixAudioPcmFile", "outFile:%s", new Object[] { this.fnn });
      new File(this.fnn).delete();
      try
      {
        this.outputStream = new FileOutputStream(a.ih(this.fnn));
        AppMethodBeat.o(136875);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", localFileNotFoundException, "new FileOutputStream", new Object[0]);
        AppMethodBeat.o(136875);
        return;
      }
      catch (Exception localException)
      {
        b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", localException, "new FileOutputStream", new Object[0]);
      }
    }
    AppMethodBeat.o(136875);
  }
  
  private static g aen()
  {
    AppMethodBeat.i(136872);
    if (fpD == null) {}
    synchronized (fnq)
    {
      if (fpD == null) {
        fpD = new g();
      }
      ??? = fpD;
      AppMethodBeat.o(136872);
      return ???;
    }
  }
  
  private static String aeo()
  {
    AppMethodBeat.i(136873);
    Object localObject = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = localObject + File.separator + "mix_audio_pcm.pcm";
    AppMethodBeat.o(136873);
    return localObject;
  }
  
  public static void aep()
  {
    AppMethodBeat.i(136874);
    new File(aeo()).delete();
    g localg = aen();
    if (localg.isInit) {
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
      localg.isInit = false;
      AppMethodBeat.o(136874);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.g
 * JD-Core Version:    0.7.0.1
 */