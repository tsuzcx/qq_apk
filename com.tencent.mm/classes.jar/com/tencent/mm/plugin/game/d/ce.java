package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ce
  extends com.tencent.mm.bx.a
{
  public dv uiU;
  public cv uiV;
  public x uiW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41797);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uiU != null)
      {
        paramVarArgs.lC(1, this.uiU.computeSize());
        this.uiU.writeFields(paramVarArgs);
      }
      if (this.uiV != null)
      {
        paramVarArgs.lC(2, this.uiV.computeSize());
        this.uiV.writeFields(paramVarArgs);
      }
      if (this.uiW != null)
      {
        paramVarArgs.lC(3, this.uiW.computeSize());
        this.uiW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41797);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uiU == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lB(1, this.uiU.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uiV != null) {
        paramInt = i + f.a.a.a.lB(2, this.uiV.computeSize());
      }
      i = paramInt;
      if (this.uiW != null) {
        i = paramInt + f.a.a.a.lB(3, this.uiW.computeSize());
      }
      AppMethodBeat.o(41797);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41797);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ce localce = (ce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41797);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localce.uiU = ((dv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41797);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localce.uiV = ((cv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41797);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new x();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((x)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localce.uiW = ((x)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41797);
        return 0;
      }
      AppMethodBeat.o(41797);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ce
 * JD-Core Version:    0.7.0.1
 */