package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aq
  extends com.tencent.mm.bv.a
{
  public e npS;
  public String npW;
  public String nqt;
  public LinkedList<ar> nrO;
  
  public aq()
  {
    AppMethodBeat.i(111583);
    this.nrO = new LinkedList();
    AppMethodBeat.o(111583);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111584);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npS == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(111584);
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
      paramVarArgs.e(3, 8, this.nrO);
      if (this.nqt != null) {
        paramVarArgs.e(4, this.nqt);
      }
      AppMethodBeat.o(111584);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npS == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = e.a.a.a.iP(1, this.npS.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.npW != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.npW);
      }
      i += e.a.a.a.c(3, 8, this.nrO);
      paramInt = i;
      if (this.nqt != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nqt);
      }
      AppMethodBeat.o(111584);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nrO.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.npS == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(111584);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111584);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aq localaq = (aq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111584);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaq.npS = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111584);
          return 0;
        case 2: 
          localaq.npW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111584);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ar();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ar)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaq.nrO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111584);
          return 0;
        }
        localaq.nqt = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111584);
        return 0;
      }
      AppMethodBeat.o(111584);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aq
 * JD-Core Version:    0.7.0.1
 */