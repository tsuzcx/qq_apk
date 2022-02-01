package com.tencent.mm.audio.mix.decode;

import android.media.MediaDataSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

public final class g
  extends MediaDataSource
{
  private IDataSource dataSource;
  
  public g(IDataSource paramIDataSource)
  {
    this.dataSource = paramIDataSource;
  }
  
  public final void close()
  {
    AppMethodBeat.i(236217);
    if (this.dataSource != null)
    {
      this.dataSource.close();
      this.dataSource = null;
    }
    AppMethodBeat.o(236217);
  }
  
  public final long getSize()
  {
    AppMethodBeat.i(236215);
    if (this.dataSource != null)
    {
      long l = this.dataSource.getSize();
      AppMethodBeat.o(236215);
      return l;
    }
    AppMethodBeat.o(236215);
    return -1L;
  }
  
  public final int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236213);
    if (this.dataSource != null)
    {
      paramInt1 = this.dataSource.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(236213);
      return paramInt1;
    }
    AppMethodBeat.o(236213);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.g
 * JD-Core Version:    0.7.0.1
 */