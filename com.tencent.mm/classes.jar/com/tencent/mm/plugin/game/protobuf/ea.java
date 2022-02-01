package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ea
  extends com.tencent.mm.bx.a
{
  public String IFK;
  public String ILO;
  public String nRQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149418);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nRQ != null) {
        paramVarArgs.g(1, this.nRQ);
      }
      if (this.IFK != null) {
        paramVarArgs.g(2, this.IFK);
      }
      if (this.ILO != null) {
        paramVarArgs.g(3, this.ILO);
      }
      AppMethodBeat.o(149418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nRQ == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.nRQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IFK != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IFK);
      }
      i = paramInt;
      if (this.ILO != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ILO);
      }
      AppMethodBeat.o(149418);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(149418);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ea localea = (ea)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149418);
          return -1;
        case 1: 
          localea.nRQ = locala.ajGk.readString();
          AppMethodBeat.o(149418);
          return 0;
        case 2: 
          localea.IFK = locala.ajGk.readString();
          AppMethodBeat.o(149418);
          return 0;
        }
        localea.ILO = locala.ajGk.readString();
        AppMethodBeat.o(149418);
        return 0;
      }
      AppMethodBeat.o(149418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ea
 * JD-Core Version:    0.7.0.1
 */