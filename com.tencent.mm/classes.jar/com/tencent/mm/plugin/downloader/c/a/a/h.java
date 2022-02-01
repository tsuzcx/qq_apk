package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.cd.a
{
  public d ueY;
  public String ueZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153049);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ueY == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_info");
        AppMethodBeat.o(153049);
        throw paramVarArgs;
      }
      if (this.ueY != null)
      {
        paramVarArgs.oE(1, this.ueY.computeSize());
        this.ueY.writeFields(paramVarArgs);
      }
      if (this.ueZ != null) {
        paramVarArgs.f(2, this.ueZ);
      }
      AppMethodBeat.o(153049);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ueY == null) {
        break label396;
      }
    }
    label396:
    for (paramInt = g.a.a.a.oD(1, this.ueY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ueZ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.ueZ);
      }
      AppMethodBeat.o(153049);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.ueY == null)
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
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153049);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            d locald = new d();
            if ((localObject != null) && (localObject.length > 0)) {
              locald.parseFrom((byte[])localObject);
            }
            localh.ueY = locald;
            paramInt += 1;
          }
          AppMethodBeat.o(153049);
          return 0;
        }
        localh.ueZ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153049);
        return 0;
      }
      AppMethodBeat.o(153049);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.h
 * JD-Core Version:    0.7.0.1
 */