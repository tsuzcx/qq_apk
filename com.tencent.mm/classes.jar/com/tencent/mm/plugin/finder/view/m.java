package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aml;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"safeParseFrom", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "byteArray", "", "plugin-finder_release"})
public final class m
{
  public static final aml a(aml paramaml, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(205904);
    p.h(paramaml, "$this$safeParseFrom");
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(205904);
      return paramaml;
    }
    try
    {
      paramaml.parseFrom(paramArrayOfByte);
      label28:
      AppMethodBeat.o(205904);
      return paramaml;
    }
    catch (Exception paramArrayOfByte)
    {
      break label28;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.m
 * JD-Core Version:    0.7.0.1
 */