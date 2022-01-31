package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bv.a
{
  public String jJs;
  public LinkedList<Long> jKO;
  public LinkedList<String> jKP;
  public LinkedList<String> jKQ;
  
  public ag()
  {
    AppMethodBeat.i(18083);
    this.jKO = new LinkedList();
    this.jKP = new LinkedList();
    this.jKQ = new LinkedList();
    AppMethodBeat.o(18083);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18084);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJs == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(18084);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 3, this.jKO);
      paramVarArgs.e(2, 1, this.jKP);
      paramVarArgs.e(3, 1, this.jKQ);
      if (this.jJs != null) {
        paramVarArgs.e(4, this.jJs);
      }
      AppMethodBeat.o(18084);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.a.c(1, 3, this.jKO) + 0 + e.a.a.a.c(2, 1, this.jKP) + e.a.a.a.c(3, 1, this.jKQ);
      paramInt = i;
      if (this.jJs != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.jJs);
      }
      AppMethodBeat.o(18084);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.jKO.clear();
      this.jKP.clear();
      this.jKQ.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.jJs == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(18084);
        throw paramVarArgs;
      }
      AppMethodBeat.o(18084);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ag localag = (ag)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(18084);
        return -1;
      case 1: 
        localag.jKO.add(Long.valueOf(locala.CLY.sm()));
        AppMethodBeat.o(18084);
        return 0;
      case 2: 
        localag.jKP.add(locala.CLY.readString());
        AppMethodBeat.o(18084);
        return 0;
      case 3: 
        localag.jKQ.add(locala.CLY.readString());
        AppMethodBeat.o(18084);
        return 0;
      }
      localag.jJs = locala.CLY.readString();
      AppMethodBeat.o(18084);
      return 0;
    }
    AppMethodBeat.o(18084);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ag
 * JD-Core Version:    0.7.0.1
 */