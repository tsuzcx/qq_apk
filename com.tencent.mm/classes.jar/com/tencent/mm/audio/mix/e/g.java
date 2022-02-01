package com.tencent.mm.audio.mix.e;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.a;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;

public final class g
{
  private static Object ddM;
  private static g dfH;
  private boolean cBE;
  private String ddJ;
  private boolean dfI;
  private OutputStream outputStream;
  
  static
  {
    AppMethodBeat.i(136876);
    ddM = new Object();
    AppMethodBeat.o(136876);
  }
  
  private g()
  {
    AppMethodBeat.i(136875);
    this.cBE = false;
    this.dfI = true;
    if (!this.cBE)
    {
      this.cBE = true;
      this.ddJ = Pl();
      b.i("MicroMsg.Mix.ExportMixAudioPcmFile", "outFile:%s", new Object[] { this.ddJ });
      o.deleteFile(this.ddJ);
      try
      {
        this.outputStream = o.db(w.B(a.gC(this.ddJ).mUri), false);
        AppMethodBeat.o(136875);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", localFileNotFoundException, "VFSFileOp.openWrite", new Object[0]);
        AppMethodBeat.o(136875);
        return;
      }
      catch (Exception localException)
      {
        b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", localException, "VFSFileOp.openWrite", new Object[0]);
      }
    }
    AppMethodBeat.o(136875);
  }
  
  private static g Pk()
  {
    AppMethodBeat.i(136872);
    if (dfH == null) {}
    synchronized (ddM)
    {
      if (dfH == null) {
        dfH = new g();
      }
      ??? = dfH;
      AppMethodBeat.o(136872);
      return ???;
    }
  }
  
  private static String Pl()
  {
    AppMethodBeat.i(136873);
    Object localObject = new k(Environment.getExternalStorageDirectory().getAbsolutePath());
    if (!((k)localObject).exists()) {
      ((k)localObject).mkdirs();
    }
    localObject = localObject + "/mix_audio_pcm.pcm";
    AppMethodBeat.o(136873);
    return localObject;
  }
  
  public static void Pm()
  {
    AppMethodBeat.i(136874);
    new k(Pl()).delete();
    g localg = Pk();
    if (localg.cBE) {
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
      localg.cBE = false;
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