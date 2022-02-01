package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class an
  extends com.tencent.mm.bx.a
{
  public ch ugR;
  public ch ugS;
  public ch ugT;
  public di ugU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41741);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ugR != null)
      {
        paramVarArgs.lC(1, this.ugR.computeSize());
        this.ugR.writeFields(paramVarArgs);
      }
      if (this.ugS != null)
      {
        paramVarArgs.lC(2, this.ugS.computeSize());
        this.ugS.writeFields(paramVarArgs);
      }
      if (this.ugT != null)
      {
        paramVarArgs.lC(3, this.ugT.computeSize());
        this.ugT.writeFields(paramVarArgs);
      }
      if (this.ugU != null)
      {
        paramVarArgs.lC(4, this.ugU.computeSize());
        this.ugU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41741);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ugR == null) {
        break label774;
      }
    }
    label774:
    for (int i = f.a.a.a.lB(1, this.ugR.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ugS != null) {
        paramInt = i + f.a.a.a.lB(2, this.ugS.computeSize());
      }
      i = paramInt;
      if (this.ugT != null) {
        i = paramInt + f.a.a.a.lB(3, this.ugT.computeSize());
      }
      paramInt = i;
      if (this.ugU != null) {
        paramInt = i + f.a.a.a.lB(4, this.ugU.computeSize());
      }
      AppMethodBeat.o(41741);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41741);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        an localan = (an)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41741);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ch();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ch)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localan.ugR = ((ch)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ch();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ch)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localan.ugS = ((ch)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ch();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ch)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localan.ugT = ((ch)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new di();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((di)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localan.ugU = ((di)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.an
 * JD-Core Version:    0.7.0.1
 */