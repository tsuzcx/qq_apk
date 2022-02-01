package com.github.henryye.nativeiv.c;

import com.github.henryye.nativeiv.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.nio.channels.FileChannel;

public final class c
  extends FilterInputStream
{
  private long mMarkPosition = 0L;
  
  public c(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  public final void mark(int paramInt)
  {
    AppMethodBeat.i(127395);
    try
    {
      this.mMarkPosition = ((FileInputStream)this.in).getChannel().position();
      AppMethodBeat.o(127395);
      return;
    }
    catch (Exception localException)
    {
      b.printStackTrace("MicroMsg.FileSeekingInputStream", localException, "Failed seeking FileChannel.", new Object[0]);
      AppMethodBeat.o(127395);
    }
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(127396);
    ((FileInputStream)this.in).getChannel().position(this.mMarkPosition);
    AppMethodBeat.o(127396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.c.c
 * JD-Core Version:    0.7.0.1
 */