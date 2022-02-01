package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class v
  extends com.tencent.mm.bx.a
{
  public ef ugh;
  public boolean ugi;
  public boolean ugj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199576);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ugh != null)
      {
        paramVarArgs.lC(1, this.ugh.computeSize());
        this.ugh.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(2, this.ugi);
      paramVarArgs.bt(4, this.ugj);
      AppMethodBeat.o(199576);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ugh == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.a.lB(1, this.ugh.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.alV(2);
      int j = f.a.a.b.b.a.alV(4);
      AppMethodBeat.o(199576);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(199576);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(199576);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ef();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ef)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localv.ugh = ((ef)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(199576);
          return 0;
        case 2: 
          localv.ugi = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(199576);
          return 0;
        }
        localv.ugj = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(199576);
        return 0;
      }
      AppMethodBeat.o(199576);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.v
 * JD-Core Version:    0.7.0.1
 */