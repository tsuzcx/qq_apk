package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class x
  extends com.tencent.mm.bw.a
{
  public int yVn;
  public LinkedList<y> yVw;
  public int yWi;
  public long yWj;
  public int yWk;
  public long yWl;
  public int yWm;
  
  public x()
  {
    AppMethodBeat.i(91255);
    this.yVw = new LinkedList();
    AppMethodBeat.o(91255);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91256);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.yWi);
      paramVarArgs.bb(2, this.yWj);
      paramVarArgs.aM(3, this.yWk);
      paramVarArgs.bb(4, this.yWl);
      paramVarArgs.aM(5, this.yWm);
      paramVarArgs.aM(6, this.yVn);
      paramVarArgs.e(7, 8, this.yVw);
      AppMethodBeat.o(91256);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.yWi);
      i = g.a.a.b.b.a.r(2, this.yWj);
      int j = g.a.a.b.b.a.bu(3, this.yWk);
      int k = g.a.a.b.b.a.r(4, this.yWl);
      int m = g.a.a.b.b.a.bu(5, this.yWm);
      int n = g.a.a.b.b.a.bu(6, this.yVn);
      int i1 = g.a.a.a.c(7, 8, this.yVw);
      AppMethodBeat.o(91256);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.yVw.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91256);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      x localx = (x)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91256);
        return -1;
      case 1: 
        localx.yWi = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91256);
        return 0;
      case 2: 
        localx.yWj = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91256);
        return 0;
      case 3: 
        localx.yWk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91256);
        return 0;
      case 4: 
        localx.yWl = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91256);
        return 0;
      case 5: 
        localx.yWm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91256);
        return 0;
      case 6: 
        localx.yVn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91256);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new y();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((y)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localx.yVw.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91256);
      return 0;
    }
    AppMethodBeat.o(91256);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.x
 * JD-Core Version:    0.7.0.1
 */