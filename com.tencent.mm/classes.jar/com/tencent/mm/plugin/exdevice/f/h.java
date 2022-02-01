package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b vgA;
  public int vhJ;
  public c ytJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23492);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ytJ == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BasePush");
        AppMethodBeat.o(23492);
        throw paramVarArgs;
      }
      if (this.vgA == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(23492);
        throw paramVarArgs;
      }
      if (this.ytJ != null)
      {
        paramVarArgs.qD(1, this.ytJ.computeSize());
        this.ytJ.writeFields(paramVarArgs);
      }
      if (this.vgA != null) {
        paramVarArgs.d(2, this.vgA);
      }
      paramVarArgs.bS(3, this.vhJ);
      AppMethodBeat.o(23492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ytJ == null) {
        break label497;
      }
    }
    label497:
    for (paramInt = i.a.a.a.qC(1, this.ytJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vgA != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.vgA);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.vhJ);
      AppMethodBeat.o(23492);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ytJ == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BasePush");
          AppMethodBeat.o(23492);
          throw paramVarArgs;
        }
        if (this.vgA == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(23492);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23492);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            c localc = new c();
            if ((localObject != null) && (localObject.length > 0)) {
              localc.parseFrom((byte[])localObject);
            }
            localh.ytJ = localc;
            paramInt += 1;
          }
          AppMethodBeat.o(23492);
          return 0;
        case 2: 
          localh.vgA = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(23492);
          return 0;
        }
        localh.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(23492);
        return 0;
      }
      AppMethodBeat.o(23492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.h
 * JD-Core Version:    0.7.0.1
 */