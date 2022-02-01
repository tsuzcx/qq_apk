package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arg;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"safeParseFrom", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "byteArray", "", "plugin-finder_release"})
public final class u
{
  public static final arg a(arg paramarg, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(221475);
    p.k(paramarg, "$this$safeParseFrom");
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(221475);
      return paramarg;
    }
    try
    {
      paramarg.parseFrom(paramArrayOfByte);
      label28:
      AppMethodBeat.o(221475);
      return paramarg;
    }
    catch (Exception paramArrayOfByte)
    {
      break label28;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.u
 * JD-Core Version:    0.7.0.1
 */