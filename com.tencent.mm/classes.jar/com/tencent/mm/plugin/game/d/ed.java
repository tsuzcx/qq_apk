package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ed
  extends com.tencent.mm.bw.a
{
  public long nJL;
  public long nJM;
  public dy urO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221903);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.urO == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(221903);
        throw paramVarArgs;
      }
      paramVarArgs.aZ(1, this.nJL);
      paramVarArgs.aZ(2, this.nJM);
      if (this.urO != null)
      {
        paramVarArgs.lJ(3, this.urO.computeSize());
        this.urO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(221903);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.nJL) + 0 + f.a.a.b.b.a.p(2, this.nJM);
      paramInt = i;
      if (this.urO != null) {
        paramInt = i + f.a.a.a.lI(3, this.urO.computeSize());
      }
      AppMethodBeat.o(221903);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.urO == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(221903);
        throw paramVarArgs;
      }
      AppMethodBeat.o(221903);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ed localed = (ed)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(221903);
        return -1;
      case 1: 
        localed.nJL = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(221903);
        return 0;
      case 2: 
        localed.nJM = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(221903);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dy();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localed.urO = ((dy)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(221903);
      return 0;
    }
    AppMethodBeat.o(221903);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ed
 * JD-Core Version:    0.7.0.1
 */