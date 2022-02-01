package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends j
{
  public com.tencent.mm.bx.b mAx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oXM == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23494);
        throw paramVarArgs;
      }
      if (this.oXM != null)
      {
        paramVarArgs.kX(1, this.oXM.computeSize());
        this.oXM.writeFields(paramVarArgs);
      }
      if (this.mAx != null) {
        paramVarArgs.c(2, this.mAx);
      }
      AppMethodBeat.o(23494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oXM == null) {
        break label430;
      }
    }
    label430:
    for (paramInt = f.a.a.a.kW(1, this.oXM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mAx != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.mAx);
      }
      AppMethodBeat.o(23494);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.oXM == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, j.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locall.oXM = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23494);
          return 0;
        }
        locall.mAx = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(23494);
        return 0;
      }
      AppMethodBeat.o(23494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.l
 * JD-Core Version:    0.7.0.1
 */