package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class du
  extends com.tencent.mm.bx.a
{
  public long nEq;
  public long nEr;
  public dp ugr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199591);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ugr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(199591);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.nEq);
      paramVarArgs.aY(2, this.nEr);
      if (this.ugr != null)
      {
        paramVarArgs.lC(3, this.ugr.computeSize());
        this.ugr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(199591);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.nEq) + 0 + f.a.a.b.b.a.p(2, this.nEr);
      paramInt = i;
      if (this.ugr != null) {
        paramInt = i + f.a.a.a.lB(3, this.ugr.computeSize());
      }
      AppMethodBeat.o(199591);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.ugr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(199591);
        throw paramVarArgs;
      }
      AppMethodBeat.o(199591);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      du localdu = (du)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(199591);
        return -1;
      case 1: 
        localdu.nEq = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(199591);
        return 0;
      case 2: 
        localdu.nEr = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(199591);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dp();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdu.ugr = ((dp)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(199591);
      return 0;
    }
    AppMethodBeat.o(199591);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.du
 * JD-Core Version:    0.7.0.1
 */