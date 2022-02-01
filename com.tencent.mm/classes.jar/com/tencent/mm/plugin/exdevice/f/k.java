package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends i
{
  public com.tencent.mm.bx.b vgA;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23493);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgA == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(23493);
        throw paramVarArgs;
      }
      if (this.ytK != null)
      {
        paramVarArgs.qD(1, this.ytK.computeSize());
        this.ytK.writeFields(paramVarArgs);
      }
      if (this.vgA != null) {
        paramVarArgs.d(2, this.vgA);
      }
      paramVarArgs.bS(3, this.vhJ);
      AppMethodBeat.o(23493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ytK == null) {
        break label449;
      }
    }
    label449:
    for (paramInt = i.a.a.a.qC(1, this.ytK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vgA != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.vgA);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.vhJ);
      AppMethodBeat.o(23493);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = i.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.vgA == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(23493);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23493);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23493);
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
            localk.ytK = locald;
            paramInt += 1;
          }
          AppMethodBeat.o(23493);
          return 0;
        case 2: 
          localk.vgA = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(23493);
          return 0;
        }
        localk.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(23493);
        return 0;
      }
      AppMethodBeat.o(23493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.k
 * JD-Core Version:    0.7.0.1
 */