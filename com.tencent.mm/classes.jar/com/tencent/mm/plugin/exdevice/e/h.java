package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b jJh;
  public int jKs;
  public c lGZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19425);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.lGZ == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BasePush");
        AppMethodBeat.o(19425);
        throw paramVarArgs;
      }
      if (this.jJh == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(19425);
        throw paramVarArgs;
      }
      if (this.lGZ != null)
      {
        paramVarArgs.iQ(1, this.lGZ.computeSize());
        this.lGZ.writeFields(paramVarArgs);
      }
      if (this.jJh != null) {
        paramVarArgs.c(2, this.jJh);
      }
      paramVarArgs.aO(3, this.jKs);
      AppMethodBeat.o(19425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lGZ == null) {
        break label523;
      }
    }
    label523:
    for (paramInt = e.a.a.a.iP(1, this.lGZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jJh != null) {
        i = paramInt + e.a.a.b.b.a.b(2, this.jJh);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.jKs);
      AppMethodBeat.o(19425);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.lGZ == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: BasePush");
          AppMethodBeat.o(19425);
          throw paramVarArgs;
        }
        if (this.jJh == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(19425);
          throw paramVarArgs;
        }
        AppMethodBeat.o(19425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(19425);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localh.lGZ = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(19425);
          return 0;
        case 2: 
          localh.jJh = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(19425);
          return 0;
        }
        localh.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(19425);
        return 0;
      }
      AppMethodBeat.o(19425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.h
 * JD-Core Version:    0.7.0.1
 */