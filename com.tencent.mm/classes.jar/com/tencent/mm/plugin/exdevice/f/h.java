package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b mAx;
  public int mBH;
  public c oXK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23492);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oXK == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BasePush");
        AppMethodBeat.o(23492);
        throw paramVarArgs;
      }
      if (this.mAx == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(23492);
        throw paramVarArgs;
      }
      if (this.oXK != null)
      {
        paramVarArgs.kX(1, this.oXK.computeSize());
        this.oXK.writeFields(paramVarArgs);
      }
      if (this.mAx != null) {
        paramVarArgs.c(2, this.mAx);
      }
      paramVarArgs.aR(3, this.mBH);
      AppMethodBeat.o(23492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oXK == null) {
        break label523;
      }
    }
    label523:
    for (paramInt = f.a.a.a.kW(1, this.oXK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mAx != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.mAx);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.mBH);
      AppMethodBeat.o(23492);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.oXK == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BasePush");
          AppMethodBeat.o(23492);
          throw paramVarArgs;
        }
        if (this.mAx == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(23492);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23492);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.oXK = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(23492);
          return 0;
        case 2: 
          localh.mAx = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(23492);
          return 0;
        }
        localh.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(23492);
        return 0;
      }
      AppMethodBeat.o(23492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.h
 * JD-Core Version:    0.7.0.1
 */