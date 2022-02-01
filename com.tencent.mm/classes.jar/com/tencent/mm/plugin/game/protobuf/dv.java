package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dv
  extends com.tencent.mm.bw.a
{
  public String ixw;
  public String xHA;
  public String xNo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149418);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ixw != null) {
        paramVarArgs.e(1, this.ixw);
      }
      if (this.xHA != null) {
        paramVarArgs.e(2, this.xHA);
      }
      if (this.xNo != null) {
        paramVarArgs.e(3, this.xNo);
      }
      AppMethodBeat.o(149418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ixw == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.ixw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xHA != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xHA);
      }
      i = paramInt;
      if (this.xNo != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNo);
      }
      AppMethodBeat.o(149418);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(149418);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dv localdv = (dv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149418);
          return -1;
        case 1: 
          localdv.ixw = locala.UbS.readString();
          AppMethodBeat.o(149418);
          return 0;
        case 2: 
          localdv.xHA = locala.UbS.readString();
          AppMethodBeat.o(149418);
          return 0;
        }
        localdv.xNo = locala.UbS.readString();
        AppMethodBeat.o(149418);
        return 0;
      }
      AppMethodBeat.o(149418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dv
 * JD-Core Version:    0.7.0.1
 */