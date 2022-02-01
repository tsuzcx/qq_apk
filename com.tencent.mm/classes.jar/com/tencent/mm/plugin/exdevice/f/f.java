package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class f
  extends i
{
  public b ytx;
  public b yty;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23490);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ytK != null)
      {
        paramVarArgs.qD(1, this.ytK.computeSize());
        this.ytK.writeFields(paramVarArgs);
      }
      if (this.ytx != null) {
        paramVarArgs.d(2, this.ytx);
      }
      if (this.yty != null) {
        paramVarArgs.d(3, this.yty);
      }
      AppMethodBeat.o(23490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ytK == null) {
        break label413;
      }
    }
    label413:
    for (int i = i.a.a.a.qC(1, this.ytK.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ytx != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ytx);
      }
      i = paramInt;
      if (this.yty != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.yty);
      }
      AppMethodBeat.o(23490);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(23490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23490);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            d locald = new d();
            if ((localObject != null) && (localObject.length > 0)) {
              locald.parseFrom((byte[])localObject);
            }
            localf.ytK = locald;
            paramInt += 1;
          }
          AppMethodBeat.o(23490);
          return 0;
        case 2: 
          localf.ytx = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(23490);
          return 0;
        }
        localf.yty = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(23490);
        return 0;
      }
      AppMethodBeat.o(23490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.f
 * JD-Core Version:    0.7.0.1
 */