package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class au
  extends com.tencent.mm.bw.a
{
  public co xKG;
  public co xKH;
  public co xKI;
  public dq xKJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41741);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xKG != null)
      {
        paramVarArgs.ni(1, this.xKG.computeSize());
        this.xKG.writeFields(paramVarArgs);
      }
      if (this.xKH != null)
      {
        paramVarArgs.ni(2, this.xKH.computeSize());
        this.xKH.writeFields(paramVarArgs);
      }
      if (this.xKI != null)
      {
        paramVarArgs.ni(3, this.xKI.computeSize());
        this.xKI.writeFields(paramVarArgs);
      }
      if (this.xKJ != null)
      {
        paramVarArgs.ni(4, this.xKJ.computeSize());
        this.xKJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41741);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xKG == null) {
        break label774;
      }
    }
    label774:
    for (int i = g.a.a.a.nh(1, this.xKG.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xKH != null) {
        paramInt = i + g.a.a.a.nh(2, this.xKH.computeSize());
      }
      i = paramInt;
      if (this.xKI != null) {
        i = paramInt + g.a.a.a.nh(3, this.xKI.computeSize());
      }
      paramInt = i;
      if (this.xKJ != null) {
        paramInt = i + g.a.a.a.nh(4, this.xKJ.computeSize());
      }
      AppMethodBeat.o(41741);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41741);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        au localau = (au)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41741);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localau.xKG = ((co)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localau.xKH = ((co)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localau.xKI = ((co)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localau.xKJ = ((dq)localObject1);
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
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.au
 * JD-Core Version:    0.7.0.1
 */