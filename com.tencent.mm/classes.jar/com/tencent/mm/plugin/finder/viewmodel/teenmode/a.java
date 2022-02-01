package com.tencent.mm.plugin.finder.viewmodel.teenmode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/teenmode/FinderAuthorizationTimeout;", "Lcom/tencent/mm/plugin/teenmode/api/BaseAuthorizationTimeout;", "()V", "isAuthorizationExpired", "", "authorizationTime", "", "svrTime", "isRequestExpired", "requestTime", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b
{
  public final boolean aD(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(337337);
    if (!Util.isSameDay(paramLong1, paramLong2))
    {
      AppMethodBeat.o(337337);
      return true;
    }
    AppMethodBeat.o(337337);
    return false;
  }
  
  public final boolean aE(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(337346);
    if (!Util.isSameDay(paramLong1, paramLong2))
    {
      AppMethodBeat.o(337346);
      return true;
    }
    AppMethodBeat.o(337346);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.teenmode.a
 * JD-Core Version:    0.7.0.1
 */