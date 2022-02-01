package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public int nJA;
  public g uqg;
  public c uqm;
  public String uqn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41709);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nJA);
      if (this.uqg != null)
      {
        paramVarArgs.lJ(2, this.uqg.computeSize());
        this.uqg.writeFields(paramVarArgs);
      }
      if (this.uqm != null)
      {
        paramVarArgs.lJ(3, this.uqm.computeSize());
        this.uqm.writeFields(paramVarArgs);
      }
      if (this.uqn != null) {
        paramVarArgs.d(4, this.uqn);
      }
      AppMethodBeat.o(41709);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nJA) + 0;
      paramInt = i;
      if (this.uqg != null) {
        paramInt = i + f.a.a.a.lI(2, this.uqg.computeSize());
      }
      i = paramInt;
      if (this.uqm != null) {
        i = paramInt + f.a.a.a.lI(3, this.uqm.computeSize());
      }
      paramInt = i;
      if (this.uqn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uqn);
      }
      AppMethodBeat.o(41709);
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
      AppMethodBeat.o(41709);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41709);
        return -1;
      case 1: 
        locale.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(41709);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.uqg = ((g)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41709);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.uqm = ((c)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41709);
        return 0;
      }
      locale.uqn = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(41709);
      return 0;
    }
    AppMethodBeat.o(41709);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.e
 * JD-Core Version:    0.7.0.1
 */