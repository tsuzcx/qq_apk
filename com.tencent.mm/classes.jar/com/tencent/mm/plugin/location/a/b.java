package com.tencent.mm.plugin.location.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public LinkedList<a> nZS;
  public String nZT;
  
  public b()
  {
    AppMethodBeat.i(113291);
    this.nZS = new LinkedList();
    AppMethodBeat.o(113291);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113292);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.nZS);
      if (this.nZT != null) {
        paramVarArgs.e(2, this.nZT);
      }
      AppMethodBeat.o(113292);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.nZS) + 0;
      paramInt = i;
      if (this.nZT != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nZT);
      }
      AppMethodBeat.o(113292);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nZS.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(113292);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113292);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localb.nZS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113292);
        return 0;
      }
      localb.nZT = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(113292);
      return 0;
    }
    AppMethodBeat.o(113292);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.a.b
 * JD-Core Version:    0.7.0.1
 */