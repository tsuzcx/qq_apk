package com.tencent.mm.modelvideo;

import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class MMVideoView$1
  implements am.a
{
  MMVideoView$1(MMVideoView paramMMVideoView) {}
  
  public final boolean tC()
  {
    if (MMVideoView.a(this.eFH) == null) {}
    for (;;)
    {
      return false;
      boolean bool2 = this.eFH.isPlaying();
      if (bool2) {
        MMVideoView.b(this.eFH);
      }
      try
      {
        int i = MMVideoView.c(this.eFH).getCurrentPosition() / 1000;
        MMVideoView.a(this.eFH, i);
        bool1 = this.eFH.jr(i);
        y.d(MMVideoView.f(this.eFH), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.g(this.eFH), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!bool1) || (!bool2)) {
          continue;
        }
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e(MMVideoView.d(this.eFH), "%s online video timer check error [%s] ", new Object[] { MMVideoView.e(this.eFH), localException.toString() });
          boolean bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.MMVideoView.1
 * JD-Core Version:    0.7.0.1
 */