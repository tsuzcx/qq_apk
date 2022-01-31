package com.github.henryye.nativeiv.b;

import com.tencent.magicbrush.a.d.f;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.nio.channels.FileChannel;

public final class b
  extends FilterInputStream
{
  private long asE = 0L;
  
  public b(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      this.asE = ((FileInputStream)this.in).getChannel().position();
      return;
    }
    catch (Exception localException)
    {
      d.f.a("MicroMsg.FileSeekingInputStream", localException, "Failed seeking FileChannel.", new Object[0]);
    }
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final void reset()
  {
    ((FileInputStream)this.in).getChannel().position(this.asE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.b
 * JD-Core Version:    0.7.0.1
 */