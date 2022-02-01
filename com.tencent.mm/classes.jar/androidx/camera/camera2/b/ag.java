package androidx.camera.camera2.b;

import androidx.camera.camera2.b.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ag
{
  int CT;
  final Object mLock;
  private final h zI;
  
  ag(h paramh)
  {
    AppMethodBeat.i(197418);
    this.mLock = new Object();
    this.zI = paramh;
    this.CT = 0;
    AppMethodBeat.o(197418);
  }
  
  public final int hs()
  {
    synchronized (this.mLock)
    {
      int i = this.CT;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.ag
 * JD-Core Version:    0.7.0.1
 */