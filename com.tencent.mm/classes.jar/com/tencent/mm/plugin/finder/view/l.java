package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.alz;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"safeParseFrom", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "byteArray", "", "plugin-finder_release"})
public final class l
{
  public static final alz a(alz paramalz, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(205262);
    p.h(paramalz, "$this$safeParseFrom");
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(205262);
      return paramalz;
    }
    try
    {
      paramalz.parseFrom(paramArrayOfByte);
      label28:
      AppMethodBeat.o(205262);
      return paramalz;
    }
    catch (Exception paramArrayOfByte)
    {
      break label28;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.l
 * JD-Core Version:    0.7.0.1
 */