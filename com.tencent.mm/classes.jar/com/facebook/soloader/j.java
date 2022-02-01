package com.facebook.soloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public final class j
  implements Closeable
{
  private final FileOutputStream cCP;
  private final FileLock cCQ;
  
  private j(File paramFile)
  {
    AppMethodBeat.i(208093);
    this.cCP = new FileOutputStream(paramFile);
    try
    {
      paramFile = this.cCP.getChannel().lock();
      if (paramFile == null) {
        this.cCP.close();
      }
      this.cCQ = paramFile;
      AppMethodBeat.o(208093);
      return;
    }
    finally
    {
      this.cCP.close();
      AppMethodBeat.o(208093);
    }
  }
  
  public static j t(File paramFile)
  {
    AppMethodBeat.i(208078);
    paramFile = new j(paramFile);
    AppMethodBeat.o(208078);
    return paramFile;
  }
  
  public final void close()
  {
    AppMethodBeat.i(208104);
    try
    {
      if (this.cCQ != null) {
        this.cCQ.release();
      }
      return;
    }
    finally
    {
      this.cCP.close();
      AppMethodBeat.o(208104);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.soloader.j
 * JD-Core Version:    0.7.0.1
 */