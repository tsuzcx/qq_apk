package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aps;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"safeParseFrom", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "byteArray", "", "plugin-finder_release"})
public final class o
{
  public static final aps a(aps paramaps, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(255044);
    p.h(paramaps, "$this$safeParseFrom");
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(255044);
      return paramaps;
    }
    try
    {
      paramaps.parseFrom(paramArrayOfByte);
      label28:
      AppMethodBeat.o(255044);
      return paramaps;
    }
    catch (Exception paramArrayOfByte)
    {
      break label28;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.o
 * JD-Core Version:    0.7.0.1
 */