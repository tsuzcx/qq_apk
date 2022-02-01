package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bu
  extends com.tencent.mm.bx.a
{
  public bw uiH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199580);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uiH != null)
      {
        paramVarArgs.lC(1, this.uiH.computeSize());
        this.uiH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(199580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uiH == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = f.a.a.a.lB(1, this.uiH.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(199580);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(199580);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bu localbu = (bu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199580);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbu.uiH = ((bw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(199580);
        return 0;
      }
      AppMethodBeat.o(199580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bu
 * JD-Core Version:    0.7.0.1
 */