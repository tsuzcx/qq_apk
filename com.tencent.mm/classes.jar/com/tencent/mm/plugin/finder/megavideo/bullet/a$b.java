package com.tencent.mm.plugin.finder.megavideo.bullet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.l.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager$Companion$1", "Lcom/tencent/mm/danmaku/inject/VideoDanmakuConfig$ILogger;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "w", "plugin-finder_release"})
public final class a$b
  implements l.a
{
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(248251);
    Log.d(paramString1, paramString2);
    AppMethodBeat.o(248251);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(248249);
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(248249);
  }
  
  public final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(248250);
    Log.e(paramString1, paramString2, new Object[] { paramThrowable });
    AppMethodBeat.o(248250);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(248246);
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(248246);
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(248248);
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(248248);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(248247);
    Log.w(paramString1, paramString2);
    AppMethodBeat.o(248247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.bullet.a.b
 * JD-Core Version:    0.7.0.1
 */