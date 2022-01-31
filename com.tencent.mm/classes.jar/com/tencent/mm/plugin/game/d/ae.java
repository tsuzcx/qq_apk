package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ae
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public e npS;
  public ag nru;
  public af nrv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111568);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npS == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(111568);
        throw paramVarArgs;
      }
      if (this.npS != null)
      {
        paramVarArgs.iQ(1, this.npS.computeSize());
        this.npS.writeFields(paramVarArgs);
      }
      if (this.nru != null)
      {
        paramVarArgs.iQ(2, this.nru.computeSize());
        this.nru.writeFields(paramVarArgs);
      }
      if (this.nrv != null)
      {
        paramVarArgs.iQ(3, this.nrv.computeSize());
        this.nrv.writeFields(paramVarArgs);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      AppMethodBeat.o(111568);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npS == null) {
        break label726;
      }
    }
    label726:
    for (int i = e.a.a.a.iP(1, this.npS.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nru != null) {
        paramInt = i + e.a.a.a.iP(2, this.nru.computeSize());
      }
      i = paramInt;
      if (this.nrv != null) {
        i = paramInt + e.a.a.a.iP(3, this.nrv.computeSize());
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Desc);
      }
      AppMethodBeat.o(111568);
      return paramInt;
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
          AppMethodBeat.o(111568);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111568);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111568);
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
            localae.npS = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111568);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ag();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ag)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localae.nru = ((ag)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111568);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new af();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((af)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localae.nrv = ((af)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111568);
          return 0;
        }
        localae.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111568);
        return 0;
      }
      AppMethodBeat.o(111568);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ae
 * JD-Core Version:    0.7.0.1
 */