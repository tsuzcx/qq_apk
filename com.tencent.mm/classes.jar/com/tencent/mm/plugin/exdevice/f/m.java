package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bw.a
{
  public c qlf;
  public int qli;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23495);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qlf == null)
      {
        paramVarArgs = new b("Not all required fields were included: BasePush");
        AppMethodBeat.o(23495);
        throw paramVarArgs;
      }
      if (this.qlf != null)
      {
        paramVarArgs.lJ(1, this.qlf.computeSize());
        this.qlf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.qli);
      AppMethodBeat.o(23495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qlf == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.a.lI(1, this.qlf.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.qli);
      AppMethodBeat.o(23495);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.qlf == null)
        {
          paramVarArgs = new b("Not all required fields were included: BasePush");
          AppMethodBeat.o(23495);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23495);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23495);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localm.qlf = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23495);
          return 0;
        }
        localm.qli = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(23495);
        return 0;
      }
      AppMethodBeat.o(23495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.m
 * JD-Core Version:    0.7.0.1
 */