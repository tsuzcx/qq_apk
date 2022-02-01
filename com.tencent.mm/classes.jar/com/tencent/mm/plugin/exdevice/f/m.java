package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bw.a
{
  public c rCa;
  public int rCd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23495);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rCa == null)
      {
        paramVarArgs = new b("Not all required fields were included: BasePush");
        AppMethodBeat.o(23495);
        throw paramVarArgs;
      }
      if (this.rCa != null)
      {
        paramVarArgs.ni(1, this.rCa.computeSize());
        this.rCa.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.rCd);
      AppMethodBeat.o(23495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rCa == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = g.a.a.a.nh(1, this.rCa.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.rCd);
      AppMethodBeat.o(23495);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.rCa == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23495);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localm.rCa = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23495);
          return 0;
        }
        localm.rCd = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(23495);
        return 0;
      }
      AppMethodBeat.o(23495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.m
 * JD-Core Version:    0.7.0.1
 */