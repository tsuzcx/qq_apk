package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class as
  extends com.tencent.mm.bv.a
{
  public String Title;
  public LinkedList<y> nqs;
  public String nrQ;
  public String nrx;
  
  public as()
  {
    AppMethodBeat.i(111587);
    this.nqs = new LinkedList();
    AppMethodBeat.o(111587);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111588);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.nqs);
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.nrx != null) {
        paramVarArgs.e(3, this.nrx);
      }
      if (this.nrQ != null) {
        paramVarArgs.e(4, this.nrQ);
      }
      AppMethodBeat.o(111588);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.nqs) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.nrx != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nrx);
      }
      paramInt = i;
      if (this.nrQ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nrQ);
      }
      AppMethodBeat.o(111588);
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
      AppMethodBeat.o(111588);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      as localas = (as)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(111588);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new y();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((y)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localas.nqs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111588);
        return 0;
      case 2: 
        localas.Title = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111588);
        return 0;
      case 3: 
        localas.nrx = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111588);
        return 0;
      }
      localas.nrQ = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(111588);
      return 0;
    }
    AppMethodBeat.o(111588);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.as
 * JD-Core Version:    0.7.0.1
 */