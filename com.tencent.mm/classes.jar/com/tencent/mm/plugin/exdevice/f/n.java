package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bw.a
{
  public c pAV;
  public int pAZ;
  public int pBa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23496);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pAV == null)
      {
        paramVarArgs = new b("Not all required fields were included: BasePush");
        AppMethodBeat.o(23496);
        throw paramVarArgs;
      }
      if (this.pAV != null)
      {
        paramVarArgs.ln(1, this.pAV.computeSize());
        this.pAV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.pAZ);
      paramVarArgs.aR(3, this.pBa);
      AppMethodBeat.o(23496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pAV == null) {
        break label459;
      }
    }
    label459:
    for (paramInt = f.a.a.a.lm(1, this.pAV.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.pAZ);
      int j = f.a.a.b.b.a.bx(3, this.pBa);
      AppMethodBeat.o(23496);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.pAV == null)
        {
          paramVarArgs = new b("Not all required fields were included: BasePush");
          AppMethodBeat.o(23496);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23496);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localn.pAV = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23496);
          return 0;
        case 2: 
          localn.pAZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(23496);
          return 0;
        }
        localn.pBa = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(23496);
        return 0;
      }
      AppMethodBeat.o(23496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.n
 * JD-Core Version:    0.7.0.1
 */