package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class c$a
  extends FilterInputStream
{
  private long gwZ = 0L;
  
  c$a(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      AppMethodBeat.i(197276);
      try
      {
        this.gwZ = ((FileInputStream)this.in).getChannel().position();
        AppMethodBeat.o(197276);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("Luggage.ViewAttributeHelper", localIOException, "fail to mark position.");
          this.gwZ = -1L;
          AppMethodBeat.o(197276);
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
      AppMethodBeat.i(197277);
      if (this.gwZ < 0L)
      {
        IOException localIOException = new IOException("Illegal marked position: " + this.gwZ);
        AppMethodBeat.o(197277);
        throw localIOException;
      }
    }
    finally {}
    ((FileInputStream)this.in).getChannel().position(this.gwZ);
    AppMethodBeat.o(197277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.c.a
 * JD-Core Version:    0.7.0.1
 */