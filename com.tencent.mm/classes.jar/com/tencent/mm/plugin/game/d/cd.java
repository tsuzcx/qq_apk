package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cd
  extends com.tencent.mm.bv.a
{
  public e npS;
  public String ntz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111639);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npS == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(111639);
        throw paramVarArgs;
      }
      if (this.ntz == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rank");
        AppMethodBeat.o(111639);
        throw paramVarArgs;
      }
      if (this.npS != null)
      {
        paramVarArgs.iQ(1, this.npS.computeSize());
        this.npS.writeFields(paramVarArgs);
      }
      if (this.ntz != null) {
        paramVarArgs.e(2, this.ntz);
      }
      AppMethodBeat.o(111639);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npS == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = e.a.a.a.iP(1, this.npS.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ntz != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.ntz);
      }
      AppMethodBeat.o(111639);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.npS == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(111639);
          throw paramVarArgs;
        }
        if (this.ntz == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rank");
          AppMethodBeat.o(111639);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111639);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cd localcd = (cd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111639);
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
            localcd.npS = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111639);
          return 0;
        }
        localcd.ntz = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111639);
        return 0;
      }
      AppMethodBeat.o(111639);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cd
 * JD-Core Version:    0.7.0.1
 */