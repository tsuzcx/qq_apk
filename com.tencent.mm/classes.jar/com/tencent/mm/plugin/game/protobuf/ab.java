package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ab
  extends com.tencent.mm.bw.a
{
  public eo xJW;
  public boolean xJX;
  public boolean xJY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256632);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xJW != null)
      {
        paramVarArgs.ni(1, this.xJW.computeSize());
        this.xJW.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(2, this.xJX);
      paramVarArgs.cc(4, this.xJY);
      AppMethodBeat.o(256632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJW == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = g.a.a.a.nh(1, this.xJW.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(256632);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256632);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ab localab = (ab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(256632);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localab.xJW = ((eo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256632);
          return 0;
        case 2: 
          localab.xJX = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(256632);
          return 0;
        }
        localab.xJY = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(256632);
        return 0;
      }
      AppMethodBeat.o(256632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ab
 * JD-Core Version:    0.7.0.1
 */