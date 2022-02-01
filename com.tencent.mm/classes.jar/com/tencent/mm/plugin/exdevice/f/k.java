package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends i
{
  public com.tencent.mm.bw.b ncy;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23493);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncy == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(23493);
        throw paramVarArgs;
      }
      if (this.pAW != null)
      {
        paramVarArgs.ln(1, this.pAW.computeSize());
        this.pAW.writeFields(paramVarArgs);
      }
      if (this.ncy != null) {
        paramVarArgs.c(2, this.ncy);
      }
      paramVarArgs.aR(3, this.ndI);
      AppMethodBeat.o(23493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pAW == null) {
        break label475;
      }
    }
    label475:
    for (paramInt = f.a.a.a.lm(1, this.pAW.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ncy != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.ncy);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.ndI);
      AppMethodBeat.o(23493);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ncy == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(23493);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23493);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23493);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, i.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.pAW = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23493);
          return 0;
        case 2: 
          localk.ncy = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(23493);
          return 0;
        }
        localk.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(23493);
        return 0;
      }
      AppMethodBeat.o(23493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.k
 * JD-Core Version:    0.7.0.1
 */