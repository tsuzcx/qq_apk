package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class es
  extends com.tencent.mm.cd.a
{
  public String CNT;
  public String CSc;
  public String CSd;
  public String CSe;
  public String CSf;
  public int CSg;
  public String CSh;
  public String CSi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41848);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNT != null) {
        paramVarArgs.f(1, this.CNT);
      }
      if (this.CSc != null) {
        paramVarArgs.f(2, this.CSc);
      }
      if (this.CSd != null) {
        paramVarArgs.f(3, this.CSd);
      }
      if (this.CSe != null) {
        paramVarArgs.f(4, this.CSe);
      }
      if (this.CSf != null) {
        paramVarArgs.f(5, this.CSf);
      }
      paramVarArgs.aY(6, this.CSg);
      if (this.CSh != null) {
        paramVarArgs.f(7, this.CSh);
      }
      if (this.CSi != null) {
        paramVarArgs.f(8, this.CSi);
      }
      AppMethodBeat.o(41848);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNT == null) {
        break label626;
      }
    }
    label626:
    for (int i = g.a.a.b.b.a.g(1, this.CNT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CSc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CSc);
      }
      i = paramInt;
      if (this.CSd != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CSd);
      }
      paramInt = i;
      if (this.CSe != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CSe);
      }
      i = paramInt;
      if (this.CSf != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CSf);
      }
      i += g.a.a.b.b.a.bM(6, this.CSg);
      paramInt = i;
      if (this.CSh != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.CSh);
      }
      i = paramInt;
      if (this.CSi != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.CSi);
      }
      AppMethodBeat.o(41848);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41848);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        es locales = (es)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41848);
          return -1;
        case 1: 
          locales.CNT = locala.abFh.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 2: 
          locales.CSc = locala.abFh.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 3: 
          locales.CSd = locala.abFh.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 4: 
          locales.CSe = locala.abFh.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 5: 
          locales.CSf = locala.abFh.readString();
          AppMethodBeat.o(41848);
          return 0;
        case 6: 
          locales.CSg = locala.abFh.AK();
          AppMethodBeat.o(41848);
          return 0;
        case 7: 
          locales.CSh = locala.abFh.readString();
          AppMethodBeat.o(41848);
          return 0;
        }
        locales.CSi = locala.abFh.readString();
        AppMethodBeat.o(41848);
        return 0;
      }
      AppMethodBeat.o(41848);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.es
 * JD-Core Version:    0.7.0.1
 */