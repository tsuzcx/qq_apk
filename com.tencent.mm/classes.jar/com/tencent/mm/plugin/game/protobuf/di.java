package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class di
  extends com.tencent.mm.bw.a
{
  public ep xMW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41825);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xMW == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppInfo");
        AppMethodBeat.o(41825);
        throw paramVarArgs;
      }
      if (this.xMW != null)
      {
        paramVarArgs.ni(1, this.xMW.computeSize());
        this.xMW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xMW == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = g.a.a.a.nh(1, this.xMW.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(41825);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xMW == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppInfo");
          AppMethodBeat.o(41825);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41825);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        di localdi = (di)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41825);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ep();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ep)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdi.xMW = ((ep)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41825);
        return 0;
      }
      AppMethodBeat.o(41825);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.di
 * JD-Core Version:    0.7.0.1
 */