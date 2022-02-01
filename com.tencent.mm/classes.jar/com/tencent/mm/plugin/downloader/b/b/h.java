package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bx.a
{
  public i xmb;
  public i xmc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153068);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.xmb != null)
      {
        paramVarArgs.qD(1, this.xmb.computeSize());
        this.xmb.writeFields(paramVarArgs);
      }
      if (this.xmc != null)
      {
        paramVarArgs.qD(2, this.xmc.computeSize());
        this.xmc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153068);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xmb == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.xmb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xmc != null) {
        i = paramInt + i.a.a.a.qC(2, this.xmc.computeSize());
      }
      AppMethodBeat.o(153068);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153068);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        i locali;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153068);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            locali = new i();
            if ((localObject != null) && (localObject.length > 0)) {
              locali.parseFrom((byte[])localObject);
            }
            localh.xmb = locali;
            paramInt += 1;
          }
          AppMethodBeat.o(153068);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          locali = new i();
          if ((localObject != null) && (localObject.length > 0)) {
            locali.parseFrom((byte[])localObject);
          }
          localh.xmc = locali;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.h
 * JD-Core Version:    0.7.0.1
 */