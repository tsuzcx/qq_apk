package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.g.a;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.regex.Pattern;

final class c$6
  implements g.a
{
  c$6(c paramc) {}
  
  public final String[] Ph(String paramString)
  {
    AppMethodBeat.i(136745);
    paramString = c.a.mRc.split(paramString, 2);
    AppMethodBeat.o(136745);
    return paramString;
  }
  
  public final String[] split(String paramString)
  {
    AppMethodBeat.i(136744);
    if (((PluginFTS)g.G(PluginFTS.class)).getFTSIndexDB().mPB)
    {
      paramString = bo.er(c.Pm(paramString));
      AppMethodBeat.o(136744);
      return paramString;
    }
    paramString = c.a.mRc.split(paramString);
    AppMethodBeat.o(136744);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.6
 * JD-Core Version:    0.7.0.1
 */