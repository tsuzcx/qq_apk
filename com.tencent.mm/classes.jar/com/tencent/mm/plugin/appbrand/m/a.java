package com.tencent.mm.plugin.appbrand.m;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public final class a
{
  public static InputStream Q(InputStream paramInputStream)
  {
    AppMethodBeat.i(317204);
    if (paramInputStream.markSupported())
    {
      AppMethodBeat.o(317204);
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream))
    {
      paramInputStream = new a((FileInputStream)paramInputStream);
      AppMethodBeat.o(317204);
      return paramInputStream;
    }
    paramInputStream = new BufferedInputStream(paramInputStream);
    AppMethodBeat.o(317204);
    return paramInputStream;
  }
  
  public static int getCompatibleRewindBufferSize()
  {
    AppMethodBeat.i(317199);
    if ("HUAWEI".equals(Build.MANUFACTURER))
    {
      AppMethodBeat.o(317199);
      return 8388608;
    }
    AppMethodBeat.o(317199);
    return 8388608;
  }
  
  static final class a
    extends FilterInputStream
  {
    private long mvq = 0L;
    
    a(FileInputStream paramFileInputStream)
    {
      super();
    }
    
    public final void mark(int paramInt)
    {
      try
      {
        AppMethodBeat.i(317212);
        try
        {
          this.mvq = ((FileInputStream)this.in).getChannel().position();
          AppMethodBeat.o(317212);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.e("Luggage.ViewAttributeHelper", localIOException, "fail to mark position.");
            this.mvq = -1L;
            AppMethodBeat.o(317212);
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
        AppMethodBeat.i(317214);
        if (this.mvq < 0L)
        {
          IOException localIOException = new IOException("Illegal marked position: " + this.mvq);
          AppMethodBeat.o(317214);
          throw localIOException;
        }
      }
      finally {}
      ((FileInputStream)this.in).getChannel().position(this.mvq);
      AppMethodBeat.o(317214);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.a
 * JD-Core Version:    0.7.0.1
 */