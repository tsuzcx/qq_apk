package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.cd.a
{
  public i ufV;
  public i ufW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153068);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ufV != null)
      {
        paramVarArgs.oE(1, this.ufV.computeSize());
        this.ufV.writeFields(paramVarArgs);
      }
      if (this.ufW != null)
      {
        paramVarArgs.oE(2, this.ufW.computeSize());
        this.ufW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153068);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufV == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.a.oD(1, this.ufV.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ufW != null) {
        i = paramInt + g.a.a.a.oD(2, this.ufW.computeSize());
      }
      AppMethodBeat.o(153068);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153068);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        i locali;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153068);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            locali = new i();
            if ((localObject != null) && (localObject.length > 0)) {
              locali.parseFrom((byte[])localObject);
            }
            localh.ufV = locali;
            paramInt += 1;
          }
          AppMethodBeat.o(153068);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          locali = new i();
          if ((localObject != null) && (localObject.length > 0)) {
            locali.parseFrom((byte[])localObject);
          }
          localh.ufW = locali;
          paramInt += 1;
        }
        AppMethodBeat.o(153068);
        return 0;
      }
      AppMethodBeat.o(153068);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.h
 * JD-Core Version:    0.7.0.1
 */