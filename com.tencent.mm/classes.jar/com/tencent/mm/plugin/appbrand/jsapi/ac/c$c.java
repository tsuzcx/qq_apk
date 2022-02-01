package com.tencent.mm.plugin.appbrand.jsapi.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class c$c
  extends FilterInputStream
{
  private long hjN = 0L;
  
  c$c(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      AppMethodBeat.i(193725);
      try
      {
        this.hjN = ((FileInputStream)this.in).getChannel().position();
        AppMethodBeat.o(193725);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("Luggage.ViewAttributeHelper", localIOException, "fail to mark position.");
          this.hjN = -1L;
          AppMethodBeat.o(193725);
        }
      }
      return;
    }
    finally {}
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(193726);
      if (this.hjN < 0L)
      {
        IOException localIOException = new IOException("Illegal marked position: " + this.hjN);
        AppMethodBeat.o(193726);
        throw localIOException;
      }
    }
    finally {}
    ((FileInputStream)this.in).getChannel().position(this.hjN);
    AppMethodBeat.o(193726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.c.c
 * JD-Core Version:    0.7.0.1
 */