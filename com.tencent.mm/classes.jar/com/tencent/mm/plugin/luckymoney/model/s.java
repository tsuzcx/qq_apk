package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class s
  extends com.tencent.mm.bw.a
{
  public LinkedList<t> vAC;
  public int vAt;
  public int vBm;
  public long vBn;
  public int vBo;
  public long vBp;
  public int vBq;
  
  public s()
  {
    AppMethodBeat.i(91255);
    this.vAC = new LinkedList();
    AppMethodBeat.o(91255);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91256);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.vBm);
      paramVarArgs.aZ(2, this.vBn);
      paramVarArgs.aS(3, this.vBo);
      paramVarArgs.aZ(4, this.vBp);
      paramVarArgs.aS(5, this.vBq);
      paramVarArgs.aS(6, this.vAt);
      paramVarArgs.e(7, 8, this.vAC);
      AppMethodBeat.o(91256);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.vBm);
      i = f.a.a.b.b.a.p(2, this.vBn);
      int j = f.a.a.b.b.a.bz(3, this.vBo);
      int k = f.a.a.b.b.a.p(4, this.vBp);
      int m = f.a.a.b.b.a.bz(5, this.vBq);
      int n = f.a.a.b.b.a.bz(6, this.vAt);
      int i1 = f.a.a.a.c(7, 8, this.vAC);
      AppMethodBeat.o(91256);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.vAC.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        locals.vBm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91256);
        return 0;
      case 2: 
        locals.vBn = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91256);
        return 0;
      case 3: 
        locals.vBo = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91256);
        return 0;
      case 4: 
        locals.vBp = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91256);
        return 0;
      case 5: 
        locals.vBq = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91256);
        return 0;
      case 6: 
        locals.vAt = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91256);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        locals.vAC.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91256);
      return 0;
    }
    AppMethodBeat.o(91256);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.s
 * JD-Core Version:    0.7.0.1
 */