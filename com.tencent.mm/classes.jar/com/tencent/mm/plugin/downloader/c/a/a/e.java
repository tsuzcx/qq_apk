package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bv.a
{
  public LinkedList<g> kVT;
  public long kVU;
  
  public e()
  {
    AppMethodBeat.i(35512);
    this.kVT = new LinkedList();
    AppMethodBeat.o(35512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35513);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.kVT);
      paramVarArgs.am(2, this.kVU);
      AppMethodBeat.o(35513);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 8, this.kVT);
      i = e.a.a.b.b.a.p(2, this.kVU);
      AppMethodBeat.o(35513);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.kVT.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(35513);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(35513);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locale.kVT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(35513);
        return 0;
      }
      locale.kVU = ((e.a.a.a.a)localObject1).CLY.sm();
      AppMethodBeat.o(35513);
      return 0;
    }
    AppMethodBeat.o(35513);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.e
 * JD-Core Version:    0.7.0.1
 */