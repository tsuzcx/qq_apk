package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aa
  extends com.tencent.mm.bw.a
{
  public eo urE;
  public boolean urF;
  public boolean urG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221881);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.urE != null)
      {
        paramVarArgs.lJ(1, this.urE.computeSize());
        this.urE.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(2, this.urF);
      paramVarArgs.bC(4, this.urG);
      AppMethodBeat.o(221881);
      return 0;
    }
    if (paramInt == 1) {
      if (this.urE == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.a.lI(1, this.urE.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.amF(2);
      int j = f.a.a.b.b.a.amF(4);
      AppMethodBeat.o(221881);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(221881);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(221881);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaa.urE = ((eo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(221881);
          return 0;
        case 2: 
          localaa.urF = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(221881);
          return 0;
        }
        localaa.urG = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(221881);
        return 0;
      }
      AppMethodBeat.o(221881);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aa
 * JD-Core Version:    0.7.0.1
 */