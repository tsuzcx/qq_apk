package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cr
  extends com.tencent.mm.bv.a
{
  public e npS;
  public String npW;
  public boolean nqg;
  public LinkedList<String> nqh;
  
  public cr()
  {
    AppMethodBeat.i(111656);
    this.nqh = new LinkedList();
    AppMethodBeat.o(111656);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111657);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npS == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(111657);
        throw paramVarArgs;
      }
      if (this.npS != null)
      {
        paramVarArgs.iQ(1, this.npS.computeSize());
        this.npS.writeFields(paramVarArgs);
      }
      if (this.npW != null) {
        paramVarArgs.e(2, this.npW);
      }
      paramVarArgs.aS(3, this.nqg);
      paramVarArgs.e(4, 1, this.nqh);
      AppMethodBeat.o(111657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npS == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = e.a.a.a.iP(1, this.npS.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.npW != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.npW);
      }
      paramInt = e.a.a.b.b.a.eW(3);
      int j = e.a.a.a.c(4, 1, this.nqh);
      AppMethodBeat.o(111657);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nqh.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.npS == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(111657);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cr localcr = (cr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111657);
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
            localcr.npS = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111657);
          return 0;
        case 2: 
          localcr.npW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111657);
          return 0;
        case 3: 
          localcr.nqg = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(111657);
          return 0;
        }
        localcr.nqh.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(111657);
        return 0;
      }
      AppMethodBeat.o(111657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cr
 * JD-Core Version:    0.7.0.1
 */