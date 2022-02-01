package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderLogUtil;", "", "()V", "logInfo", "", "Lcom/tencent/mm/protocal/protobuf/GameRankSwitch;", "TAG", "", "Lcom/tencent/mm/protocal/protobuf/GameRankSwitchInfo;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
{
  public static final x GgW;
  
  static
  {
    AppMethodBeat.i(333706);
    GgW = new x();
    AppMethodBeat.o(333706);
  }
  
  public static void a(cbw paramcbw, String paramString)
  {
    AppMethodBeat.i(333699);
    s.u(paramcbw, "<this>");
    s.u(paramString, "TAG");
    paramcbw = paramcbw.aalh;
    if (paramcbw != null)
    {
      paramcbw = ((Iterable)paramcbw).iterator();
      while (paramcbw.hasNext())
      {
        cbv localcbv = (cbv)paramcbw.next();
        if (localcbv != null)
        {
          s.u(localcbv, "<this>");
          s.u(paramString, "TAG");
          Log.i(paramString, "GameRankSwitch appid:" + localcbv.ZGM + ", name:" + localcbv.aale + ", enable:" + localcbv.aalf);
        }
      }
    }
    AppMethodBeat.o(333699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.x
 * JD-Core Version:    0.7.0.1
 */