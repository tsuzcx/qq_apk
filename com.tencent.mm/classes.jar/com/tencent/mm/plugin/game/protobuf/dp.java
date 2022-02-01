package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dp
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CMC;
  public String CMD;
  public String CNA;
  public String CQz;
  public String fwr;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41829);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CQz == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppName");
        AppMethodBeat.o(41829);
        throw paramVarArgs;
      }
      if (this.CQz != null) {
        paramVarArgs.f(1, this.CQz);
      }
      if (this.CMC != null) {
        paramVarArgs.f(2, this.CMC);
      }
      if (this.fwr != null) {
        paramVarArgs.f(3, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(4, this.CMB);
      }
      if (this.CNA != null) {
        paramVarArgs.f(5, this.CNA);
      }
      if (this.CMD != null) {
        paramVarArgs.f(6, this.CMD);
      }
      if (this.lVG != null) {
        paramVarArgs.f(7, this.lVG);
      }
      AppMethodBeat.o(41829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CQz == null) {
        break label626;
      }
    }
    label626:
    for (int i = g.a.a.b.b.a.g(1, this.CQz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMC != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMC);
      }
      i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fwr);
      }
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMB);
      }
      i = paramInt;
      if (this.CNA != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CNA);
      }
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CMD);
      }
      i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.lVG);
      }
      AppMethodBeat.o(41829);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CQz == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppName");
          AppMethodBeat.o(41829);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41829);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dp localdp = (dp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41829);
          return -1;
        case 1: 
          localdp.CQz = locala.abFh.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 2: 
          localdp.CMC = locala.abFh.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 3: 
          localdp.fwr = locala.abFh.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 4: 
          localdp.CMB = locala.abFh.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 5: 
          localdp.CNA = locala.abFh.readString();
          AppMethodBeat.o(41829);
          return 0;
        case 6: 
          localdp.CMD = locala.abFh.readString();
          AppMethodBeat.o(41829);
          return 0;
        }
        localdp.lVG = locala.abFh.readString();
        AppMethodBeat.o(41829);
        return 0;
      }
      AppMethodBeat.o(41829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dp
 * JD-Core Version:    0.7.0.1
 */