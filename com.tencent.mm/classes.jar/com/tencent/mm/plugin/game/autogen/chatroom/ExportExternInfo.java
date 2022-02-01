package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExportExternInfo
  extends com.tencent.mm.cd.a
{
  public long sourceid;
  public long ssid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194691);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.sourceid);
      paramVarArgs.bm(2, this.ssid);
      AppMethodBeat.o(194691);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.sourceid);
      int i = g.a.a.b.b.a.p(2, this.ssid);
      AppMethodBeat.o(194691);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(194691);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ExportExternInfo localExportExternInfo = (ExportExternInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(194691);
        return -1;
      case 1: 
        localExportExternInfo.sourceid = locala.abFh.AN();
        AppMethodBeat.o(194691);
        return 0;
      }
      localExportExternInfo.ssid = locala.abFh.AN();
      AppMethodBeat.o(194691);
      return 0;
    }
    AppMethodBeat.o(194691);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ExportExternInfo
 * JD-Core Version:    0.7.0.1
 */