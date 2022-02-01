package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bw.a
{
  public i oHg;
  public i oHh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153068);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oHg != null)
      {
        paramVarArgs.ln(1, this.oHg.computeSize());
        this.oHg.writeFields(paramVarArgs);
      }
      if (this.oHh != null)
      {
        paramVarArgs.ln(2, this.oHh.computeSize());
        this.oHh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153068);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oHg == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.lm(1, this.oHg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oHh != null) {
        i = paramInt + f.a.a.a.lm(2, this.oHh.computeSize());
      }
      AppMethodBeat.o(153068);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153068);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153068);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.oHg = ((i)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153068);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.oHh = ((i)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.h
 * JD-Core Version:    0.7.0.1
 */