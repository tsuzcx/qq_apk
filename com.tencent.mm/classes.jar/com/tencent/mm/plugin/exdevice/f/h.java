package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b nCV;
  public int nEf;
  public c qeA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23492);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qeA == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BasePush");
        AppMethodBeat.o(23492);
        throw paramVarArgs;
      }
      if (this.nCV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(23492);
        throw paramVarArgs;
      }
      if (this.qeA != null)
      {
        paramVarArgs.lC(1, this.qeA.computeSize());
        this.qeA.writeFields(paramVarArgs);
      }
      if (this.nCV != null) {
        paramVarArgs.c(2, this.nCV);
      }
      paramVarArgs.aS(3, this.nEf);
      AppMethodBeat.o(23492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qeA == null) {
        break label523;
      }
    }
    label523:
    for (paramInt = f.a.a.a.lB(1, this.qeA.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nCV != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.nCV);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.nEf);
      AppMethodBeat.o(23492);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.qeA == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BasePush");
          AppMethodBeat.o(23492);
          throw paramVarArgs;
        }
        if (this.nCV == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(23492);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23492);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.qeA = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23492);
          return 0;
        case 2: 
          localh.nCV = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(23492);
          return 0;
        }
        localh.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(23492);
        return 0;
      }
      AppMethodBeat.o(23492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.h
 * JD-Core Version:    0.7.0.1
 */