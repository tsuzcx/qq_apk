package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ct
  extends com.tencent.mm.bw.a
{
  public dr tlo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41825);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tlo == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppInfo");
        AppMethodBeat.o(41825);
        throw paramVarArgs;
      }
      if (this.tlo != null)
      {
        paramVarArgs.ln(1, this.tlo.computeSize());
        this.tlo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlo == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.a.lm(1, this.tlo.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(41825);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.tlo == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ct localct = (ct)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41825);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localct.tlo = ((dr)localObject1);
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
 * Qualified Name:     com.tencent.mm.plugin.game.d.ct
 * JD-Core Version:    0.7.0.1
 */