package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bv.a
{
  public LinkedList<aq> nqs;
  public String nqt;
  
  public h()
  {
    AppMethodBeat.i(111547);
    this.nqs = new LinkedList();
    AppMethodBeat.o(111547);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111548);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.nqs);
      if (this.nqt != null) {
        paramVarArgs.e(2, this.nqt);
      }
      AppMethodBeat.o(111548);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.nqs) + 0;
      paramInt = i;
      if (this.nqt != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nqt);
      }
      AppMethodBeat.o(111548);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nqs.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(111548);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(111548);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aq();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localh.nqs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111548);
        return 0;
      }
      localh.nqt = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(111548);
      return 0;
    }
    AppMethodBeat.o(111548);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.h
 * JD-Core Version:    0.7.0.1
 */