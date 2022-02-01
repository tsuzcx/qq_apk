package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class r
  extends com.tencent.mm.cd.a
{
  public String CMG;
  public String CMO;
  public String CMP;
  public int CNK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41717);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      if (this.CMO == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.CNK);
      if (this.CMP != null) {
        paramVarArgs.f(2, this.CMP);
      }
      if (this.CMO != null) {
        paramVarArgs.f(3, this.CMO);
      }
      if (this.CMG != null) {
        paramVarArgs.f(4, this.CMG);
      }
      AppMethodBeat.o(41717);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CNK) + 0;
      paramInt = i;
      if (this.CMP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMP);
      }
      i = paramInt;
      if (this.CMO != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMO);
      }
      paramInt = i;
      if (this.CMG != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMG);
      }
      AppMethodBeat.o(41717);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.CMP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      if (this.CMO == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41717);
        throw paramVarArgs;
      }
      AppMethodBeat.o(41717);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      r localr = (r)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41717);
        return -1;
      case 1: 
        localr.CNK = locala.abFh.AK();
        AppMethodBeat.o(41717);
        return 0;
      case 2: 
        localr.CMP = locala.abFh.readString();
        AppMethodBeat.o(41717);
        return 0;
      case 3: 
        localr.CMO = locala.abFh.readString();
        AppMethodBeat.o(41717);
        return 0;
      }
      localr.CMG = locala.abFh.readString();
      AppMethodBeat.o(41717);
      return 0;
    }
    AppMethodBeat.o(41717);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.r
 * JD-Core Version:    0.7.0.1
 */