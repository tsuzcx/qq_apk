package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public e npS;
  public b npV;
  public String npW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111544);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jKs);
      if (this.npS != null)
      {
        paramVarArgs.iQ(2, this.npS.computeSize());
        this.npS.writeFields(paramVarArgs);
      }
      if (this.npV != null)
      {
        paramVarArgs.iQ(3, this.npV.computeSize());
        this.npV.writeFields(paramVarArgs);
      }
      if (this.npW != null) {
        paramVarArgs.e(4, this.npW);
      }
      AppMethodBeat.o(111544);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.jKs) + 0;
      paramInt = i;
      if (this.npS != null) {
        paramInt = i + e.a.a.a.iP(2, this.npS.computeSize());
      }
      i = paramInt;
      if (this.npV != null) {
        i = paramInt + e.a.a.a.iP(3, this.npV.computeSize());
      }
      paramInt = i;
      if (this.npW != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.npW);
      }
      AppMethodBeat.o(111544);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(111544);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(111544);
        return -1;
      case 1: 
        localc.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(111544);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localc.npS = ((e)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111544);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localc.npV = ((b)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111544);
        return 0;
      }
      localc.npW = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(111544);
      return 0;
    }
    AppMethodBeat.o(111544);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.c
 * JD-Core Version:    0.7.0.1
 */