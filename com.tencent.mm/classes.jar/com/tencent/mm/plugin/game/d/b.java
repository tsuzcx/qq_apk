package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public e npS;
  public String npT;
  public String npU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111543);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npT == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: AdURL");
        AppMethodBeat.o(111543);
        throw paramVarArgs;
      }
      if (this.npS != null)
      {
        paramVarArgs.iQ(1, this.npS.computeSize());
        this.npS.writeFields(paramVarArgs);
      }
      if (this.npT != null) {
        paramVarArgs.e(2, this.npT);
      }
      if (this.npU != null) {
        paramVarArgs.e(3, this.npU);
      }
      AppMethodBeat.o(111543);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npS == null) {
        break label478;
      }
    }
    label478:
    for (int i = e.a.a.a.iP(1, this.npS.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.npT != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.npT);
      }
      i = paramInt;
      if (this.npU != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npU);
      }
      AppMethodBeat.o(111543);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.npT == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: AdURL");
          AppMethodBeat.o(111543);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111543);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111543);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localb.npS = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111543);
          return 0;
        case 2: 
          localb.npT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111543);
          return 0;
        }
        localb.npU = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111543);
        return 0;
      }
      AppMethodBeat.o(111543);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.b
 * JD-Core Version:    0.7.0.1
 */