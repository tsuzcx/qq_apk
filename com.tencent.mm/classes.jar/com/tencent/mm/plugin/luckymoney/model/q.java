package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class q
  extends com.tencent.mm.bv.a
{
  public int nao;
  public int onC;
  public LinkedList<r> onL;
  public int ooj;
  public long ook;
  public int ool;
  public long oom;
  
  public q()
  {
    AppMethodBeat.i(56612);
    this.onL = new LinkedList();
    AppMethodBeat.o(56612);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56613);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.ooj);
      paramVarArgs.am(2, this.ook);
      paramVarArgs.aO(3, this.ool);
      paramVarArgs.am(4, this.oom);
      paramVarArgs.aO(5, this.nao);
      paramVarArgs.aO(6, this.onC);
      paramVarArgs.e(7, 8, this.onL);
      AppMethodBeat.o(56613);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.ooj);
      i = e.a.a.b.b.a.p(2, this.ook);
      int j = e.a.a.b.b.a.bl(3, this.ool);
      int k = e.a.a.b.b.a.p(4, this.oom);
      int m = e.a.a.b.b.a.bl(5, this.nao);
      int n = e.a.a.b.b.a.bl(6, this.onC);
      int i1 = e.a.a.a.c(7, 8, this.onL);
      AppMethodBeat.o(56613);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.onL.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56613);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      q localq = (q)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56613);
        return -1;
      case 1: 
        localq.ooj = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56613);
        return 0;
      case 2: 
        localq.ook = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56613);
        return 0;
      case 3: 
        localq.ool = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56613);
        return 0;
      case 4: 
        localq.oom = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56613);
        return 0;
      case 5: 
        localq.nao = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56613);
        return 0;
      case 6: 
        localq.onC = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56613);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new r();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localq.onL.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(56613);
      return 0;
    }
    AppMethodBeat.o(56613);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.q
 * JD-Core Version:    0.7.0.1
 */