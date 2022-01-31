package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class MMVideoView$1
  implements ap.a
{
  MMVideoView$1(MMVideoView paramMMVideoView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(50629);
    if (MMVideoView.a(this.fVy) == null)
    {
      AppMethodBeat.o(50629);
      return false;
    }
    boolean bool2 = this.fVy.isPlaying();
    if (bool2) {
      MMVideoView.b(this.fVy);
    }
    try
    {
      int i = MMVideoView.c(this.fVy).getCurrentPosition() / 1000;
      MMVideoView.a(this.fVy, i);
      bool1 = this.fVy.mj(i);
      ab.d(MMVideoView.f(this.fVy), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.g(this.fVy), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      MMVideoView.als();
      if ((bool1) && (bool2))
      {
        AppMethodBeat.o(50629);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e(MMVideoView.d(this.fVy), "%s online video timer check error [%s] ", new Object[] { MMVideoView.e(this.fVy), localException.toString() });
        boolean bool1 = false;
      }
      AppMethodBeat.o(50629);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.MMVideoView.1
 * JD-Core Version:    0.7.0.1
 */