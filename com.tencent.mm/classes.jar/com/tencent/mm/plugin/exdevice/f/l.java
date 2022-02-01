package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends j
{
  public com.tencent.mm.bw.b oTm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23494);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rCc == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23494);
        throw paramVarArgs;
      }
      if (this.rCc != null)
      {
        paramVarArgs.ni(1, this.rCc.computeSize());
        this.rCc.writeFields(paramVarArgs);
      }
      if (this.oTm != null) {
        paramVarArgs.c(2, this.oTm);
      }
      AppMethodBeat.o(23494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rCc == null) {
        break label430;
      }
    }
    label430:
    for (paramInt = g.a.a.a.nh(1, this.rCc.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oTm != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.oTm);
      }
      AppMethodBeat.o(23494);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.rCc == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(23494);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23494);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23494);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, j.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locall.rCc = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23494);
          return 0;
        }
        locall.oTm = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(23494);
        return 0;
      }
      AppMethodBeat.o(23494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.l
 * JD-Core Version:    0.7.0.1
 */