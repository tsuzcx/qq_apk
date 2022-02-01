package com.tencent.mm.audio.mix.e;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.a;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;

public final class g
{
  private static Object dcK;
  private static g deF;
  private boolean cAX;
  private String dcH;
  private boolean deG;
  private OutputStream outputStream;
  
  static
  {
    AppMethodBeat.i(136876);
    dcK = new Object();
    AppMethodBeat.o(136876);
  }
  
  private g()
  {
    AppMethodBeat.i(136875);
    this.cAX = false;
    this.deG = true;
    if (!this.cAX)
    {
      this.cAX = true;
      this.dcH = Pn();
      b.i("MicroMsg.Mix.ExportMixAudioPcmFile", "outFile:%s", new Object[] { this.dcH });
      i.deleteFile(this.dcH);
      try
      {
        this.outputStream = i.cX(q.B(a.gw(this.dcH).mUri), false);
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
  
  private static g Pm()
  {
    AppMethodBeat.i(136872);
    if (deF == null) {}
    synchronized (dcK)
    {
      if (deF == null) {
        deF = new g();
      }
      ??? = deF;
      AppMethodBeat.o(136872);
      return ???;
    }
  }
  
  private static String Pn()
  {
    AppMethodBeat.i(136873);
    Object localObject = new e(Environment.getExternalStorageDirectory().getAbsolutePath());
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    localObject = localObject + "/mix_audio_pcm.pcm";
    AppMethodBeat.o(136873);
    return localObject;
  }
  
  public static void Po()
  {
    AppMethodBeat.i(136874);
    new e(Pn()).delete();
    g localg = Pm();
    if (localg.cAX) {
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
      localg.cAX = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.g
 * JD-Core Version:    0.7.0.1
 */