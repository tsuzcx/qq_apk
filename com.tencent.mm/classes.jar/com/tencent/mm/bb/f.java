package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bw.a
{
  public double bNT;
  public LinkedList<d> ilQ;
  
  public f()
  {
    AppMethodBeat.i(150797);
    this.ilQ = new LinkedList();
    AppMethodBeat.o(150797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150798);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ilQ);
      paramVarArgs.e(2, this.bNT);
      AppMethodBeat.o(150798);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.ilQ);
      i = f.a.a.b.b.a.amD(2);
      AppMethodBeat.o(150798);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ilQ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(150798);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(150798);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localf.ilQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(150798);
        return 0;
      }
      localf.bNT = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
      AppMethodBeat.o(150798);
      return 0;
    }
    AppMethodBeat.o(150798);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.f
 * JD-Core Version:    0.7.0.1
 */