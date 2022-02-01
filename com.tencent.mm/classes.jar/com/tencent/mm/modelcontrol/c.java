package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static boolean baV()
  {
    AppMethodBeat.i(201781);
    boolean bool = ((b)g.af(b.class)).a(b.a.sow, true);
    Log.i("MicroMsg.MediaExptUtil", "MediaExptUtil isFFmpegReplaceMp4v2: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(201781);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.c
 * JD-Core Version:    0.7.0.1
 */