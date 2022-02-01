package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class f
  extends i
{
  public b qen;
  public b qeo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23490);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qeB != null)
      {
        paramVarArgs.lC(1, this.qeB.computeSize());
        this.qeB.writeFields(paramVarArgs);
      }
      if (this.qen != null) {
        paramVarArgs.c(2, this.qen);
      }
      if (this.qeo != null) {
        paramVarArgs.c(3, this.qeo);
      }
      AppMethodBeat.o(23490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qeB == null) {
        break label439;
      }
    }
    label439:
    for (int i = f.a.a.a.lB(1, this.qeB.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qen != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.qen);
      }
      i = paramInt;
      if (this.qeo != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.qeo);
      }
      AppMethodBeat.o(23490);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, i.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.qeB = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23490);
          return 0;
        case 2: 
          localf.qen = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(23490);
          return 0;
        }
        localf.qeo = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(23490);
        return 0;
      }
      AppMethodBeat.o(23490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.f
 * JD-Core Version:    0.7.0.1
 */