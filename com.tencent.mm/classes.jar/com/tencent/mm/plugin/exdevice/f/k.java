package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends i
{
  public com.tencent.mm.bx.b mAx;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23493);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAx == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(23493);
        throw paramVarArgs;
      }
      if (this.oXL != null)
      {
        paramVarArgs.kX(1, this.oXL.computeSize());
        this.oXL.writeFields(paramVarArgs);
      }
      if (this.mAx != null) {
        paramVarArgs.c(2, this.mAx);
      }
      paramVarArgs.aR(3, this.mBH);
      AppMethodBeat.o(23493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oXL == null) {
        break label475;
      }
    }
    label475:
    for (paramInt = f.a.a.a.kW(1, this.oXL.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mAx != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.mAx);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.mBH);
      AppMethodBeat.o(23493);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.mAx == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, i.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.oXL = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23493);
          return 0;
        case 2: 
          localk.mAx = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(23493);
          return 0;
        }
        localk.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(23493);
        return 0;
      }
      AppMethodBeat.o(23493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.k
 * JD-Core Version:    0.7.0.1
 */