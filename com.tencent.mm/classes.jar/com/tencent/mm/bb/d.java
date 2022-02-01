package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public String appId;
  public String jgH;
  public String jgI;
  public o jgJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(223634);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.e(1, this.appId);
      }
      if (this.jgH != null) {
        paramVarArgs.e(2, this.jgH);
      }
      if (this.jgI != null) {
        paramVarArgs.e(3, this.jgI);
      }
      if (this.jgJ != null)
      {
        paramVarArgs.ni(4, this.jgJ.computeSize());
        this.jgJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(223634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label490;
      }
    }
    label490:
    for (int i = g.a.a.b.b.a.f(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jgH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jgH);
      }
      i = paramInt;
      if (this.jgI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.jgI);
      }
      paramInt = i;
      if (this.jgJ != null) {
        paramInt = i + g.a.a.a.nh(4, this.jgJ.computeSize());
      }
      AppMethodBeat.o(223634);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(223634);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(223634);
          return -1;
        case 1: 
          locald.appId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(223634);
          return 0;
        case 2: 
          locald.jgH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(223634);
          return 0;
        case 3: 
          locald.jgI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(223634);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locald.jgJ = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(223634);
        return 0;
      }
      AppMethodBeat.o(223634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bb.d
 * JD-Core Version:    0.7.0.1
 */