package com.tencent.mm.plugin.appbrand.jsapi.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class c$c
  extends FilterInputStream
{
  private long jVw = 0L;
  
  c$c(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      AppMethodBeat.i(206000);
      try
      {
        this.jVw = ((FileInputStream)this.in).getChannel().position();
        AppMethodBeat.o(206000);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("Luggage.ViewAttributeHelper", localIOException, "fail to mark position.");
          this.jVw = -1L;
          AppMethodBeat.o(206000);
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
      AppMethodBeat.i(206001);
      if (this.jVw < 0L)
      {
        IOException localIOException = new IOException("Illegal marked position: " + this.jVw);
        AppMethodBeat.o(206001);
        throw localIOException;
      }
    }
    finally {}
    ((FileInputStream)this.in).getChannel().position(this.jVw);
    AppMethodBeat.o(206001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.c.c
 * JD-Core Version:    0.7.0.1
 */