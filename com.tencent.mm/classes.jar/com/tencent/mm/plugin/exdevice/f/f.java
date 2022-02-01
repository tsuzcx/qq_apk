package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class f
  extends i
{
  public b rBN;
  public b rBO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23490);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rCb != null)
      {
        paramVarArgs.ni(1, this.rCb.computeSize());
        this.rCb.writeFields(paramVarArgs);
      }
      if (this.rBN != null) {
        paramVarArgs.c(2, this.rBN);
      }
      if (this.rBO != null) {
        paramVarArgs.c(3, this.rBO);
      }
      AppMethodBeat.o(23490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rCb == null) {
        break label439;
      }
    }
    label439:
    for (int i = g.a.a.a.nh(1, this.rCb.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rBN != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.rBN);
      }
      i = paramInt;
      if (this.rBO != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.rBO);
      }
      AppMethodBeat.o(23490);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(23490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23490);
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
            localf.rCb = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23490);
          return 0;
        case 2: 
          localf.rBN = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(23490);
          return 0;
        }
        localf.rBO = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(23490);
        return 0;
      }
      AppMethodBeat.o(23490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.f
 * JD-Core Version:    0.7.0.1
 */