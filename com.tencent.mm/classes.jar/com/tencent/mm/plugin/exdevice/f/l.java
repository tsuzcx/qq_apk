package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends j
{
  public com.tencent.mm.bw.b nIq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qlh == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23494);
        throw paramVarArgs;
      }
      if (this.qlh != null)
      {
        paramVarArgs.lJ(1, this.qlh.computeSize());
        this.qlh.writeFields(paramVarArgs);
      }
      if (this.nIq != null) {
        paramVarArgs.c(2, this.nIq);
      }
      AppMethodBeat.o(23494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qlh == null) {
        break label430;
      }
    }
    label430:
    for (paramInt = f.a.a.a.lI(1, this.qlh.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nIq != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.nIq);
      }
      AppMethodBeat.o(23494);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.qlh == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(23494);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23494);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23494);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, j.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locall.qlh = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23494);
          return 0;
        }
        locall.nIq = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(23494);
        return 0;
      }
      AppMethodBeat.o(23494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.l
 * JD-Core Version:    0.7.0.1
 */