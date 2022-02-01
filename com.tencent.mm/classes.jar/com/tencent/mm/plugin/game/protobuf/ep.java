package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ep
  extends com.tencent.mm.bw.a
{
  public String xJt;
  public eq xNP;
  public am xNQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41846);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xNP != null)
      {
        paramVarArgs.ni(1, this.xNP.computeSize());
        this.xNP.writeFields(paramVarArgs);
      }
      if (this.xNQ != null)
      {
        paramVarArgs.ni(2, this.xNQ.computeSize());
        this.xNQ.writeFields(paramVarArgs);
      }
      if (this.xJt != null) {
        paramVarArgs.e(3, this.xJt);
      }
      AppMethodBeat.o(41846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xNP == null) {
        break label526;
      }
    }
    label526:
    for (int i = g.a.a.a.nh(1, this.xNP.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xNQ != null) {
        paramInt = i + g.a.a.a.nh(2, this.xNQ.computeSize());
      }
      i = paramInt;
      if (this.xJt != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xJt);
      }
      AppMethodBeat.o(41846);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41846);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ep localep = (ep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41846);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localep.xNP = ((eq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41846);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new am();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((am)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localep.xNQ = ((am)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41846);
          return 0;
        }
        localep.xJt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41846);
        return 0;
      }
      AppMethodBeat.o(41846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ep
 * JD-Core Version:    0.7.0.1
 */