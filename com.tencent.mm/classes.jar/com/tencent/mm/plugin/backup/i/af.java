package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class af
  extends com.tencent.mm.cd.a
{
  public String rVv;
  public LinkedList<Long> rWQ;
  public LinkedList<String> rWR;
  public LinkedList<String> rWS;
  
  public af()
  {
    AppMethodBeat.i(22138);
    this.rWQ = new LinkedList();
    this.rWR = new LinkedList();
    this.rWS = new LinkedList();
    AppMethodBeat.o(22138);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22139);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rVv == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22139);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 3, this.rWQ);
      paramVarArgs.e(2, 1, this.rWR);
      paramVarArgs.e(3, 1, this.rWS);
      if (this.rVv != null) {
        paramVarArgs.f(4, this.rVv);
      }
      AppMethodBeat.o(22139);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.a.c(1, 3, this.rWQ) + 0 + g.a.a.a.c(2, 1, this.rWR) + g.a.a.a.c(3, 1, this.rWS);
      paramInt = i;
      if (this.rVv != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.rVv);
      }
      AppMethodBeat.o(22139);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rWQ.clear();
      this.rWR.clear();
      this.rWS.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.rVv == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22139);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22139);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      af localaf = (af)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22139);
        return -1;
      case 1: 
        localaf.rWQ.add(Long.valueOf(locala.abFh.AN()));
        AppMethodBeat.o(22139);
        return 0;
      case 2: 
        localaf.rWR.add(locala.abFh.readString());
        AppMethodBeat.o(22139);
        return 0;
      case 3: 
        localaf.rWS.add(locala.abFh.readString());
        AppMethodBeat.o(22139);
        return 0;
      }
      localaf.rVv = locala.abFh.readString();
      AppMethodBeat.o(22139);
      return 0;
    }
    AppMethodBeat.o(22139);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.af
 * JD-Core Version:    0.7.0.1
 */