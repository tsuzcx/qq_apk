package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.avo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"safeParseFrom", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "byteArray", "", "plugin-finder_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class x
{
  public static final avo a(avo paramavo, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(344307);
    s.u(paramavo, "<this>");
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(344307);
      return paramavo;
    }
    try
    {
      paramavo.parseFrom(paramArrayOfByte);
      label28:
      AppMethodBeat.o(344307);
      return paramavo;
    }
    catch (Exception paramArrayOfByte)
    {
      break label28;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.x
 * JD-Core Version:    0.7.0.1
 */