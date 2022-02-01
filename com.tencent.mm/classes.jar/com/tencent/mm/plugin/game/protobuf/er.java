package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class er
  extends com.tencent.mm.cd.a
{
  public String CNA;
  public String CNj;
  public String CQz;
  public int CSb;
  public String CqK;
  public String UserName;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41847);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lVG == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(41847);
        throw paramVarArgs;
      }
      if (this.lVG != null) {
        paramVarArgs.f(1, this.lVG);
      }
      if (this.CQz != null) {
        paramVarArgs.f(2, this.CQz);
      }
      if (this.CNj != null) {
        paramVarArgs.f(3, this.CNj);
      }
      if (this.UserName != null) {
        paramVarArgs.f(4, this.UserName);
      }
      if (this.CqK != null) {
        paramVarArgs.f(5, this.CqK);
      }
      paramVarArgs.aY(6, this.CSb);
      if (this.CNA != null) {
        paramVarArgs.f(7, this.CNA);
      }
      AppMethodBeat.o(41847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lVG == null) {
        break label610;
      }
    }
    label610:
    for (int i = g.a.a.b.b.a.g(1, this.lVG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CQz != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CQz);
      }
      i = paramInt;
      if (this.CNj != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CNj);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UserName);
      }
      i = paramInt;
      if (this.CqK != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CqK);
      }
      i += g.a.a.b.b.a.bM(6, this.CSb);
      paramInt = i;
      if (this.CNA != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.CNA);
      }
      AppMethodBeat.o(41847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.lVG == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(41847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41847);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        er localer = (er)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41847);
          return -1;
        case 1: 
          localer.lVG = locala.abFh.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 2: 
          localer.CQz = locala.abFh.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 3: 
          localer.CNj = locala.abFh.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 4: 
          localer.UserName = locala.abFh.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 5: 
          localer.CqK = locala.abFh.readString();
          AppMethodBeat.o(41847);
          return 0;
        case 6: 
          localer.CSb = locala.abFh.AK();
          AppMethodBeat.o(41847);
          return 0;
        }
        localer.CNA = locala.abFh.readString();
        AppMethodBeat.o(41847);
        return 0;
      }
      AppMethodBeat.o(41847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.er
 * JD-Core Version:    0.7.0.1
 */