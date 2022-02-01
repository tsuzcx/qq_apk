package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ax
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public String CNA;
  public int CNC;
  public String COT;
  public boolean COU;
  public boolean COV;
  public String COW;
  public String COX;
  public int COY;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41742);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41742);
        throw paramVarArgs;
      }
      if (this.COT == null)
      {
        paramVarArgs = new b("Not all required fields were included: NavKey");
        AppMethodBeat.o(41742);
        throw paramVarArgs;
      }
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.COT != null) {
        paramVarArgs.f(2, this.COT);
      }
      if (this.CMD != null) {
        paramVarArgs.f(3, this.CMD);
      }
      paramVarArgs.co(4, this.COU);
      paramVarArgs.co(5, this.COV);
      if (this.COW != null) {
        paramVarArgs.f(6, this.COW);
      }
      if (this.COX != null) {
        paramVarArgs.f(7, this.COX);
      }
      paramVarArgs.aY(8, this.COY);
      paramVarArgs.aY(9, this.CNC);
      if (this.CNA != null) {
        paramVarArgs.f(10, this.CNA);
      }
      AppMethodBeat.o(41742);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label790;
      }
    }
    label790:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.COT != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.COT);
      }
      i = paramInt;
      if (this.CMD != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMD);
      }
      i = i + (g.a.a.b.b.a.gL(4) + 1) + (g.a.a.b.b.a.gL(5) + 1);
      paramInt = i;
      if (this.COW != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.COW);
      }
      i = paramInt;
      if (this.COX != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.COX);
      }
      i = i + g.a.a.b.b.a.bM(8, this.COY) + g.a.a.b.b.a.bM(9, this.CNC);
      paramInt = i;
      if (this.CNA != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.CNA);
      }
      AppMethodBeat.o(41742);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fwr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41742);
          throw paramVarArgs;
        }
        if (this.COT == null)
        {
          paramVarArgs = new b("Not all required fields were included: NavKey");
          AppMethodBeat.o(41742);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41742);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ax localax = (ax)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41742);
          return -1;
        case 1: 
          localax.fwr = locala.abFh.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 2: 
          localax.COT = locala.abFh.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 3: 
          localax.CMD = locala.abFh.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 4: 
          localax.COU = locala.abFh.AB();
          AppMethodBeat.o(41742);
          return 0;
        case 5: 
          localax.COV = locala.abFh.AB();
          AppMethodBeat.o(41742);
          return 0;
        case 6: 
          localax.COW = locala.abFh.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 7: 
          localax.COX = locala.abFh.readString();
          AppMethodBeat.o(41742);
          return 0;
        case 8: 
          localax.COY = locala.abFh.AK();
          AppMethodBeat.o(41742);
          return 0;
        case 9: 
          localax.CNC = locala.abFh.AK();
          AppMethodBeat.o(41742);
          return 0;
        }
        localax.CNA = locala.abFh.readString();
        AppMethodBeat.o(41742);
        return 0;
      }
      AppMethodBeat.o(41742);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ax
 * JD-Core Version:    0.7.0.1
 */