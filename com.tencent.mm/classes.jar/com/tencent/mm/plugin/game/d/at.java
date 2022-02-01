package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class at
  extends com.tencent.mm.bw.a
{
  public co uso;
  public co usp;
  public co usq;
  public dq usr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41741);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uso != null)
      {
        paramVarArgs.lJ(1, this.uso.computeSize());
        this.uso.writeFields(paramVarArgs);
      }
      if (this.usp != null)
      {
        paramVarArgs.lJ(2, this.usp.computeSize());
        this.usp.writeFields(paramVarArgs);
      }
      if (this.usq != null)
      {
        paramVarArgs.lJ(3, this.usq.computeSize());
        this.usq.writeFields(paramVarArgs);
      }
      if (this.usr != null)
      {
        paramVarArgs.lJ(4, this.usr.computeSize());
        this.usr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41741);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uso == null) {
        break label774;
      }
    }
    label774:
    for (int i = f.a.a.a.lI(1, this.uso.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.usp != null) {
        paramInt = i + f.a.a.a.lI(2, this.usp.computeSize());
      }
      i = paramInt;
      if (this.usq != null) {
        i = paramInt + f.a.a.a.lI(3, this.usq.computeSize());
      }
      paramInt = i;
      if (this.usr != null) {
        paramInt = i + f.a.a.a.lI(4, this.usr.computeSize());
      }
      AppMethodBeat.o(41741);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41741);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        at localat = (at)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41741);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localat.uso = ((co)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localat.usp = ((co)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localat.usq = ((co)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localat.usr = ((dq)localObject1);
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
 * Qualified Name:     com.tencent.mm.plugin.game.d.at
 * JD-Core Version:    0.7.0.1
 */