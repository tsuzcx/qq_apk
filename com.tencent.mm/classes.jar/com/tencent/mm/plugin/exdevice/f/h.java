package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b oTm;
  public int oUv;
  public c rCa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23492);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rCa == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BasePush");
        AppMethodBeat.o(23492);
        throw paramVarArgs;
      }
      if (this.oTm == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(23492);
        throw paramVarArgs;
      }
      if (this.rCa != null)
      {
        paramVarArgs.ni(1, this.rCa.computeSize());
        this.rCa.writeFields(paramVarArgs);
      }
      if (this.oTm != null) {
        paramVarArgs.c(2, this.oTm);
      }
      paramVarArgs.aM(3, this.oUv);
      AppMethodBeat.o(23492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rCa == null) {
        break label523;
      }
    }
    label523:
    for (paramInt = g.a.a.a.nh(1, this.rCa.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oTm != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.oTm);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.oUv);
      AppMethodBeat.o(23492);
      return i + paramInt;
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BasePush");
          AppMethodBeat.o(23492);
          throw paramVarArgs;
        }
        if (this.oTm == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(23492);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23492);
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
            localh.rCa = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23492);
          return 0;
        case 2: 
          localh.oTm = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(23492);
          return 0;
        }
        localh.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(23492);
        return 0;
      }
      AppMethodBeat.o(23492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.h
 * JD-Core Version:    0.7.0.1
 */