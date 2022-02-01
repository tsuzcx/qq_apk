package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class f
  extends i
{
  public b qkS;
  public b qkT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23490);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qlg != null)
      {
        paramVarArgs.lJ(1, this.qlg.computeSize());
        this.qlg.writeFields(paramVarArgs);
      }
      if (this.qkS != null) {
        paramVarArgs.c(2, this.qkS);
      }
      if (this.qkT != null) {
        paramVarArgs.c(3, this.qkT);
      }
      AppMethodBeat.o(23490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qlg == null) {
        break label439;
      }
    }
    label439:
    for (int i = f.a.a.a.lI(1, this.qlg.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qkS != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.qkS);
      }
      i = paramInt;
      if (this.qkT != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.qkT);
      }
      AppMethodBeat.o(23490);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(23490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23490);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, i.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.qlg = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23490);
          return 0;
        case 2: 
          localf.qkS = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(23490);
          return 0;
        }
        localf.qkT = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(23490);
        return 0;
      }
      AppMethodBeat.o(23490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.f
 * JD-Core Version:    0.7.0.1
 */