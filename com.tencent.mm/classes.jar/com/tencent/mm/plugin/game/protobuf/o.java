package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class o
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CMD;
  public String CNA;
  public int CNC;
  public String CNj;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41715);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNj == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.CMD == null)
      {
        paramVarArgs = new b("Not all required fields were included: JumpUrl");
        AppMethodBeat.o(41715);
        throw paramVarArgs;
      }
      if (this.CNj != null) {
        paramVarArgs.f(1, this.CNj);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(3, this.CMB);
      }
      if (this.CMD != null) {
        paramVarArgs.f(4, this.CMD);
      }
      paramVarArgs.aY(5, this.CNC);
      if (this.CNA != null) {
        paramVarArgs.f(6, this.CNA);
      }
      AppMethodBeat.o(41715);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNj == null) {
        break label646;
      }
    }
    label646:
    for (int i = g.a.a.b.b.a.g(1, this.CNj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.CMB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMB);
      }
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMD);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.CNC);
      paramInt = i;
      if (this.CNA != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CNA);
      }
      AppMethodBeat.o(41715);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CNj == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(41715);
          throw paramVarArgs;
        }
        if (this.fwr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41715);
          throw paramVarArgs;
        }
        if (this.CMD == null)
        {
          paramVarArgs = new b("Not all required fields were included: JumpUrl");
          AppMethodBeat.o(41715);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41715);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41715);
          return -1;
        case 1: 
          localo.CNj = locala.abFh.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 2: 
          localo.fwr = locala.abFh.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 3: 
          localo.CMB = locala.abFh.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 4: 
          localo.CMD = locala.abFh.readString();
          AppMethodBeat.o(41715);
          return 0;
        case 5: 
          localo.CNC = locala.abFh.AK();
          AppMethodBeat.o(41715);
          return 0;
        }
        localo.CNA = locala.abFh.readString();
        AppMethodBeat.o(41715);
        return 0;
      }
      AppMethodBeat.o(41715);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.o
 * JD-Core Version:    0.7.0.1
 */