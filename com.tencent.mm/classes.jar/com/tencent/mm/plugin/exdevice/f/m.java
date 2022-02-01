package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.cd.a
{
  public c vhI;
  public int vhL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23495);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.vhI == null)
      {
        paramVarArgs = new b("Not all required fields were included: BasePush");
        AppMethodBeat.o(23495);
        throw paramVarArgs;
      }
      if (this.vhI != null)
      {
        paramVarArgs.oE(1, this.vhI.computeSize());
        this.vhI.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.vhL);
      AppMethodBeat.o(23495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhI == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = g.a.a.a.oD(1, this.vhI.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.vhL);
      AppMethodBeat.o(23495);
      return paramInt + i;
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
          paramVarArgs = new b("Not all required fields were included: BasePush");
          AppMethodBeat.o(23495);
          throw paramVarArgs;
        }
        AppMethodBeat.o(23495);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(23495);
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
            localm.vhI = localc;
            paramInt += 1;
          }
          AppMethodBeat.o(23495);
          return 0;
        }
        localm.vhL = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(23495);
        return 0;
      }
      AppMethodBeat.o(23495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.m
 * JD-Core Version:    0.7.0.1
 */