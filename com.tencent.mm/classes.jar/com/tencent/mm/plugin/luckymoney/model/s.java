package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class s
  extends com.tencent.mm.bx.a
{
  public LinkedList<t> tdC;
  public int tdt;
  public int tem;
  public long ten;
  public int teo;
  public long tep;
  public int teq;
  
  public s()
  {
    AppMethodBeat.i(91255);
    this.tdC = new LinkedList();
    AppMethodBeat.o(91255);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91256);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.tem);
      paramVarArgs.aG(2, this.ten);
      paramVarArgs.aR(3, this.teo);
      paramVarArgs.aG(4, this.tep);
      paramVarArgs.aR(5, this.teq);
      paramVarArgs.aR(6, this.tdt);
      paramVarArgs.e(7, 8, this.tdC);
      AppMethodBeat.o(91256);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.tem);
      i = f.a.a.b.b.a.q(2, this.ten);
      int j = f.a.a.b.b.a.bA(3, this.teo);
      int k = f.a.a.b.b.a.q(4, this.tep);
      int m = f.a.a.b.b.a.bA(5, this.teq);
      int n = f.a.a.b.b.a.bA(6, this.tdt);
      int i1 = f.a.a.a.c(7, 8, this.tdC);
      AppMethodBeat.o(91256);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tdC.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        locals.tem = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91256);
        return 0;
      case 2: 
        locals.ten = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(91256);
        return 0;
      case 3: 
        locals.teo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91256);
        return 0;
      case 4: 
        locals.tep = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(91256);
        return 0;
      case 5: 
        locals.teq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91256);
        return 0;
      case 6: 
        locals.tdt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91256);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        locals.tdC.add(localObject1);
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