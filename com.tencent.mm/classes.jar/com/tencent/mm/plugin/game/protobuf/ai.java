package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ai
  extends com.tencent.mm.bw.a
{
  public dy xKg;
  public LinkedList<ed> xKh;
  
  public ai()
  {
    AppMethodBeat.i(256633);
    this.xKh = new LinkedList();
    AppMethodBeat.o(256633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256634);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xKg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(256634);
        throw paramVarArgs;
      }
      if (this.xKg != null)
      {
        paramVarArgs.ni(1, this.xKg.computeSize());
        this.xKg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.xKh);
      AppMethodBeat.o(256634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xKg == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = g.a.a.a.nh(1, this.xKg.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.xKh);
      AppMethodBeat.o(256634);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xKh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xKg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Tab");
          AppMethodBeat.o(256634);
          throw paramVarArgs;
        }
        AppMethodBeat.o(256634);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256634);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localai.xKg = ((dy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256634);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ed();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ed)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localai.xKh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256634);
        return 0;
      }
      AppMethodBeat.o(256634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ai
 * JD-Core Version:    0.7.0.1
 */