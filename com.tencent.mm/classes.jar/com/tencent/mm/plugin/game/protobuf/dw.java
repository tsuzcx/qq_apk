package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dw
  extends com.tencent.mm.cd.a
{
  public String CLD;
  public String CRy;
  public String lmL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149418);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lmL != null) {
        paramVarArgs.f(1, this.lmL);
      }
      if (this.CLD != null) {
        paramVarArgs.f(2, this.CLD);
      }
      if (this.CRy != null) {
        paramVarArgs.f(3, this.CRy);
      }
      AppMethodBeat.o(149418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lmL == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.lmL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CLD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CLD);
      }
      i = paramInt;
      if (this.CRy != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CRy);
      }
      AppMethodBeat.o(149418);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(149418);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dw localdw = (dw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149418);
          return -1;
        case 1: 
          localdw.lmL = locala.abFh.readString();
          AppMethodBeat.o(149418);
          return 0;
        case 2: 
          localdw.CLD = locala.abFh.readString();
          AppMethodBeat.o(149418);
          return 0;
        }
        localdw.CRy = locala.abFh.readString();
        AppMethodBeat.o(149418);
        return 0;
      }
      AppMethodBeat.o(149418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dw
 * JD-Core Version:    0.7.0.1
 */