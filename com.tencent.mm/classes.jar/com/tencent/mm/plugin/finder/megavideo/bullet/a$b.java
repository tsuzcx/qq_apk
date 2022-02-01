package com.tencent.mm.plugin.finder.megavideo.bullet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.l.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$Companion$1", "Lcom/tencent/mm/danmaku/inject/VideoDanmakuConfig$ILogger;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "w", "plugin-finder_release"})
public final class a$b
  implements l.a
{
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(277713);
    Log.d(paramString1, paramString2);
    AppMethodBeat.o(277713);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(277709);
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(277709);
  }
  
  public final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(277711);
    Log.e(paramString1, paramString2, new Object[] { paramThrowable });
    AppMethodBeat.o(277711);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(277704);
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(277704);
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(277707);
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(277707);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(277705);
    Log.w(paramString1, paramString2);
    AppMethodBeat.o(277705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.bullet.a.b
 * JD-Core Version:    0.7.0.1
 */