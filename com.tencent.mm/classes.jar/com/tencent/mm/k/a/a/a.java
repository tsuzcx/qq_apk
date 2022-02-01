package com.tencent.mm.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bw.a
{
  public int cSx;
  public int dTg;
  public LinkedList<b> gCs;
  public String gCt;
  public int gCu;
  public int maxCount;
  public int status;
  public int type;
  
  public a()
  {
    AppMethodBeat.i(42660);
    this.gCs = new LinkedList();
    AppMethodBeat.o(42660);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42661);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.gCs);
      paramVarArgs.aM(2, this.cSx);
      paramVarArgs.aM(3, this.type);
      paramVarArgs.aM(4, this.status);
      paramVarArgs.aM(5, this.maxCount);
      if (this.gCt != null) {
        paramVarArgs.e(6, this.gCt);
      }
      paramVarArgs.aM(7, this.dTg);
      paramVarArgs.aM(8, this.gCu);
      AppMethodBeat.o(42661);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.gCs) + 0 + g.a.a.b.b.a.bu(2, this.cSx) + g.a.a.b.b.a.bu(3, this.type) + g.a.a.b.b.a.bu(4, this.status) + g.a.a.b.b.a.bu(5, this.maxCount);
      paramInt = i;
      if (this.gCt != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.gCt);
      }
      i = g.a.a.b.b.a.bu(7, this.dTg);
      int j = g.a.a.b.b.a.bu(8, this.gCu);
      AppMethodBeat.o(42661);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.gCs.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(42661);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      a locala = (a)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(42661);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locala.gCs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(42661);
        return 0;
      case 2: 
        locala.cSx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(42661);
        return 0;
      case 3: 
        locala.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(42661);
        return 0;
      case 4: 
        locala.status = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(42661);
        return 0;
      case 5: 
        locala.maxCount = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(42661);
        return 0;
      case 6: 
        locala.gCt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(42661);
        return 0;
      case 7: 
        locala.dTg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(42661);
        return 0;
      }
      locala.gCu = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(42661);
      return 0;
    }
    AppMethodBeat.o(42661);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.k.a.a.a
 * JD-Core Version:    0.7.0.1
 */