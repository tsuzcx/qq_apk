package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class al
  extends com.tencent.mm.bw.a
{
  public cb tiW;
  public cb tiX;
  public cb tiY;
  public da tiZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41741);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tiW != null)
      {
        paramVarArgs.ln(1, this.tiW.computeSize());
        this.tiW.writeFields(paramVarArgs);
      }
      if (this.tiX != null)
      {
        paramVarArgs.ln(2, this.tiX.computeSize());
        this.tiX.writeFields(paramVarArgs);
      }
      if (this.tiY != null)
      {
        paramVarArgs.ln(3, this.tiY.computeSize());
        this.tiY.writeFields(paramVarArgs);
      }
      if (this.tiZ != null)
      {
        paramVarArgs.ln(4, this.tiZ.computeSize());
        this.tiZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41741);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tiW == null) {
        break label774;
      }
    }
    label774:
    for (int i = f.a.a.a.lm(1, this.tiW.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tiX != null) {
        paramInt = i + f.a.a.a.lm(2, this.tiX.computeSize());
      }
      i = paramInt;
      if (this.tiY != null) {
        i = paramInt + f.a.a.a.lm(3, this.tiY.computeSize());
      }
      paramInt = i;
      if (this.tiZ != null) {
        paramInt = i + f.a.a.a.lm(4, this.tiZ.computeSize());
      }
      AppMethodBeat.o(41741);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41741);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        al localal = (al)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41741);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localal.tiW = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localal.tiX = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localal.tiY = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new da();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((da)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localal.tiZ = ((da)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41741);
        return 0;
      }
      AppMethodBeat.o(41741);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.al
 * JD-Core Version:    0.7.0.1
 */