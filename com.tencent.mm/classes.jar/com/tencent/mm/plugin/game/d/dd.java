package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dd
  extends com.tencent.mm.bw.a
{
  public String urK;
  public de uuN;
  public de uuO;
  public de uuP;
  public de uuQ;
  public de uuR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41817);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuN != null)
      {
        paramVarArgs.lJ(1, this.uuN.computeSize());
        this.uuN.writeFields(paramVarArgs);
      }
      if (this.uuO != null)
      {
        paramVarArgs.lJ(2, this.uuO.computeSize());
        this.uuO.writeFields(paramVarArgs);
      }
      if (this.uuP != null)
      {
        paramVarArgs.lJ(3, this.uuP.computeSize());
        this.uuP.writeFields(paramVarArgs);
      }
      if (this.uuQ != null)
      {
        paramVarArgs.lJ(4, this.uuQ.computeSize());
        this.uuQ.writeFields(paramVarArgs);
      }
      if (this.uuR != null)
      {
        paramVarArgs.lJ(6, this.uuR.computeSize());
        this.uuR.writeFields(paramVarArgs);
      }
      if (this.urK != null) {
        paramVarArgs.d(5, this.urK);
      }
      AppMethodBeat.o(41817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuN == null) {
        break label990;
      }
    }
    label990:
    for (int i = f.a.a.a.lI(1, this.uuN.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uuO != null) {
        paramInt = i + f.a.a.a.lI(2, this.uuO.computeSize());
      }
      i = paramInt;
      if (this.uuP != null) {
        i = paramInt + f.a.a.a.lI(3, this.uuP.computeSize());
      }
      paramInt = i;
      if (this.uuQ != null) {
        paramInt = i + f.a.a.a.lI(4, this.uuQ.computeSize());
      }
      i = paramInt;
      if (this.uuR != null) {
        i = paramInt + f.a.a.a.lI(6, this.uuR.computeSize());
      }
      paramInt = i;
      if (this.urK != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.urK);
      }
      AppMethodBeat.o(41817);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dd localdd = (dd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41817);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdd.uuN = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdd.uuO = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdd.uuP = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdd.uuQ = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdd.uuR = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        }
        localdd.urK = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41817);
        return 0;
      }
      AppMethodBeat.o(41817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dd
 * JD-Core Version:    0.7.0.1
 */