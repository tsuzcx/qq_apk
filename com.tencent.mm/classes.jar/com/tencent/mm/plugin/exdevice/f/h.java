package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b rVk;
  public int rWu;
  public c vhI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23492);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.vhI == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BasePush");
        AppMethodBeat.o(23492);
        throw paramVarArgs;
      }
      if (this.rVk == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(23492);
        throw paramVarArgs;
      }
      if (this.vhI != null)
      {
        paramVarArgs.oE(1, this.vhI.computeSize());
        this.vhI.writeFields(paramVarArgs);
      }
      if (this.rVk != null) {
        paramVarArgs.c(2, this.rVk);
      }
      paramVarArgs.aY(3, this.rWu);
      AppMethodBeat.o(23492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhI == null) {
        break label501;
      }
    }
    label501:
    for (paramInt = g.a.a.a.oD(1, this.vhI.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rVk != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.rVk);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.rWu);
      AppMethodBeat.o(23492);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.vhI == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BasePush");
          AppMethodBeat.o(23492);
          throw paramVarArgs;
        }
        if (this.rVk == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(23492);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23492);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            c localc = new c();
            if ((localObject != null) && (localObject.length > 0)) {
              localc.parseFrom((byte[])localObject);
            }
            localh.vhI = localc;
            paramInt += 1;
          }
          AppMethodBeat.o(23492);
          return 0;
        case 2: 
          localh.rVk = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(23492);
          return 0;
        }
        localh.rWu = ((g.a.a.a.a)localObject).abFh.AK();
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