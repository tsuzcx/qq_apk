package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends j
{
  public com.tencent.mm.bw.b pAE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23486);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pAX == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(23486);
        throw paramVarArgs;
      }
      if (this.pAE == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: AesSessionKey");
        AppMethodBeat.o(23486);
        throw paramVarArgs;
      }
      if (this.pAX != null)
      {
        paramVarArgs.ln(1, this.pAX.computeSize());
        this.pAX.writeFields(paramVarArgs);
      }
      if (this.pAE != null) {
        paramVarArgs.c(2, this.pAE);
      }
      AppMethodBeat.o(23486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pAX == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = f.a.a.a.lm(1, this.pAX.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pAE != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.pAE);
      }
      AppMethodBeat.o(23486);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.pAX == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(23486);
          throw paramVarArgs;
        }
        if (this.pAE == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: AesSessionKey");
          AppMethodBeat.o(23486);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23486);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23486);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, j.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.pAX = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23486);
          return 0;
        }
        localb.pAE = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(23486);
        return 0;
      }
      AppMethodBeat.o(23486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b
 * JD-Core Version:    0.7.0.1
 */