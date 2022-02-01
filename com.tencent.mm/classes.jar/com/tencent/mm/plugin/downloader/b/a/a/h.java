package com.tencent.mm.plugin.downloader.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bx.a
{
  public d xkZ;
  public String xla;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153049);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.xkZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_info");
        AppMethodBeat.o(153049);
        throw paramVarArgs;
      }
      if (this.xkZ != null)
      {
        paramVarArgs.qD(1, this.xkZ.computeSize());
        this.xkZ.writeFields(paramVarArgs);
      }
      if (this.xla != null) {
        paramVarArgs.g(2, this.xla);
      }
      AppMethodBeat.o(153049);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xkZ == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.a.qC(1, this.xkZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xla != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.xla);
      }
      AppMethodBeat.o(153049);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.xkZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: app_info");
          AppMethodBeat.o(153049);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153049);
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
          AppMethodBeat.o(153049);
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
            localh.xkZ = locald;
            paramInt += 1;
          }
          AppMethodBeat.o(153049);
          return 0;
        }
        localh.xla = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153049);
        return 0;
      }
      AppMethodBeat.o(153049);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a.a.h
 * JD-Core Version:    0.7.0.1
 */