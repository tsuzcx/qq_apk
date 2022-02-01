package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends i
{
  public com.tencent.mm.bw.b oTm;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23493);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oTm == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(23493);
        throw paramVarArgs;
      }
      if (this.rCb != null)
      {
        paramVarArgs.ni(1, this.rCb.computeSize());
        this.rCb.writeFields(paramVarArgs);
      }
      if (this.oTm != null) {
        paramVarArgs.c(2, this.oTm);
      }
      paramVarArgs.aM(3, this.oUv);
      AppMethodBeat.o(23493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rCb == null) {
        break label475;
      }
    }
    label475:
    for (paramInt = g.a.a.a.nh(1, this.rCb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oTm != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.oTm);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.oUv);
      AppMethodBeat.o(23493);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.oTm == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(23493);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23493);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23493);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, i.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localk.rCb = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23493);
          return 0;
        case 2: 
          localk.oTm = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(23493);
          return 0;
        }
        localk.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(23493);
        return 0;
      }
      AppMethodBeat.o(23493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.k
 * JD-Core Version:    0.7.0.1
 */