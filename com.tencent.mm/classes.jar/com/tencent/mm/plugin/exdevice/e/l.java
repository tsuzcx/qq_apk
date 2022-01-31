package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends j
{
  public com.tencent.mm.bv.b jJh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19427);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.lHb == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(19427);
        throw paramVarArgs;
      }
      if (this.lHb != null)
      {
        paramVarArgs.iQ(1, this.lHb.computeSize());
        this.lHb.writeFields(paramVarArgs);
      }
      if (this.jJh != null) {
        paramVarArgs.c(2, this.jJh);
      }
      AppMethodBeat.o(19427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lHb == null) {
        break label430;
      }
    }
    label430:
    for (paramInt = e.a.a.a.iP(1, this.lHb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jJh != null) {
        i = paramInt + e.a.a.b.b.a.b(2, this.jJh);
      }
      AppMethodBeat.o(19427);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = j.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.lHb == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(19427);
          throw paramVarArgs;
        }
        AppMethodBeat.o(19427);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(19427);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, j.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locall.lHb = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(19427);
          return 0;
        }
        locall.jJh = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(19427);
        return 0;
      }
      AppMethodBeat.o(19427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.l
 * JD-Core Version:    0.7.0.1
 */