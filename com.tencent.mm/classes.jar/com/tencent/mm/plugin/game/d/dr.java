package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dr
  extends com.tencent.mm.bw.a
{
  public String thP;
  public ds tlR;
  public ad tlS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41846);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tlR != null)
      {
        paramVarArgs.ln(1, this.tlR.computeSize());
        this.tlR.writeFields(paramVarArgs);
      }
      if (this.tlS != null)
      {
        paramVarArgs.ln(2, this.tlS.computeSize());
        this.tlS.writeFields(paramVarArgs);
      }
      if (this.thP != null) {
        paramVarArgs.d(3, this.thP);
      }
      AppMethodBeat.o(41846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlR == null) {
        break label526;
      }
    }
    label526:
    for (int i = f.a.a.a.lm(1, this.tlR.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tlS != null) {
        paramInt = i + f.a.a.a.lm(2, this.tlS.computeSize());
      }
      i = paramInt;
      if (this.thP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thP);
      }
      AppMethodBeat.o(41846);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41846);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dr localdr = (dr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41846);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ds();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ds)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdr.tlR = ((ds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41846);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ad();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ad)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdr.tlS = ((ad)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41846);
          return 0;
        }
        localdr.thP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41846);
        return 0;
      }
      AppMethodBeat.o(41846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dr
 * JD-Core Version:    0.7.0.1
 */