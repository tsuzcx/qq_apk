package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class s
  extends com.tencent.mm.bw.a
{
  public int ulI;
  public LinkedList<t> ulR;
  public int umB;
  public long umC;
  public int umD;
  public long umE;
  public int umF;
  
  public s()
  {
    AppMethodBeat.i(91255);
    this.ulR = new LinkedList();
    AppMethodBeat.o(91255);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91256);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.umB);
      paramVarArgs.aO(2, this.umC);
      paramVarArgs.aR(3, this.umD);
      paramVarArgs.aO(4, this.umE);
      paramVarArgs.aR(5, this.umF);
      paramVarArgs.aR(6, this.ulI);
      paramVarArgs.e(7, 8, this.ulR);
      AppMethodBeat.o(91256);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.umB);
      i = f.a.a.b.b.a.p(2, this.umC);
      int j = f.a.a.b.b.a.bx(3, this.umD);
      int k = f.a.a.b.b.a.p(4, this.umE);
      int m = f.a.a.b.b.a.bx(5, this.umF);
      int n = f.a.a.b.b.a.bx(6, this.ulI);
      int i1 = f.a.a.a.c(7, 8, this.ulR);
      AppMethodBeat.o(91256);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ulR.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91256);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91256);
        return -1;
      case 1: 
        locals.umB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91256);
        return 0;
      case 2: 
        locals.umC = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91256);
        return 0;
      case 3: 
        locals.umD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91256);
        return 0;
      case 4: 
        locals.umE = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91256);
        return 0;
      case 5: 
        locals.umF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91256);
        return 0;
      case 6: 
        locals.ulI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91256);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        locals.ulR.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.s
 * JD-Core Version:    0.7.0.1
 */