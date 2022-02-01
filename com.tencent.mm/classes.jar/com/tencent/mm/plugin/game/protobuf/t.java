package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CMD;
  public String CMP;
  public String CNM;
  public int CNN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41718);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNM != null) {
        paramVarArgs.f(1, this.CNM);
      }
      if (this.CMP != null) {
        paramVarArgs.f(2, this.CMP);
      }
      if (this.CMB != null) {
        paramVarArgs.f(3, this.CMB);
      }
      if (this.CMD != null) {
        paramVarArgs.f(4, this.CMD);
      }
      paramVarArgs.aY(5, this.CNN);
      AppMethodBeat.o(41718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNM == null) {
        break label438;
      }
    }
    label438:
    for (int i = g.a.a.b.b.a.g(1, this.CNM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMP);
      }
      i = paramInt;
      if (this.CMB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMB);
      }
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMD);
      }
      i = g.a.a.b.b.a.bM(5, this.CNN);
      AppMethodBeat.o(41718);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41718);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41718);
          return -1;
        case 1: 
          localt.CNM = locala.abFh.readString();
          AppMethodBeat.o(41718);
          return 0;
        case 2: 
          localt.CMP = locala.abFh.readString();
          AppMethodBeat.o(41718);
          return 0;
        case 3: 
          localt.CMB = locala.abFh.readString();
          AppMethodBeat.o(41718);
          return 0;
        case 4: 
          localt.CMD = locala.abFh.readString();
          AppMethodBeat.o(41718);
          return 0;
        }
        localt.CNN = locala.abFh.AK();
        AppMethodBeat.o(41718);
        return 0;
      }
      AppMethodBeat.o(41718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.t
 * JD-Core Version:    0.7.0.1
 */