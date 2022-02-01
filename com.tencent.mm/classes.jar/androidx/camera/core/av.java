package androidx.camera.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class av
  extends aa
{
  private boolean mClosed = false;
  
  av(ag paramag)
  {
    super(paramag);
  }
  
  public final void close()
  {
    try
    {
      AppMethodBeat.i(198290);
      if (!this.mClosed)
      {
        this.mClosed = true;
        super.close();
      }
      AppMethodBeat.o(198290);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.av
 * JD-Core Version:    0.7.0.1
 */