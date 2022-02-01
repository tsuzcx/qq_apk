package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dd
  extends com.tencent.mm.bw.a
{
  public String xKc;
  public de xMO;
  public de xMP;
  public de xMQ;
  public de xMR;
  public de xMS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41817);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xMO != null)
      {
        paramVarArgs.ni(1, this.xMO.computeSize());
        this.xMO.writeFields(paramVarArgs);
      }
      if (this.xMP != null)
      {
        paramVarArgs.ni(2, this.xMP.computeSize());
        this.xMP.writeFields(paramVarArgs);
      }
      if (this.xMQ != null)
      {
        paramVarArgs.ni(3, this.xMQ.computeSize());
        this.xMQ.writeFields(paramVarArgs);
      }
      if (this.xMR != null)
      {
        paramVarArgs.ni(4, this.xMR.computeSize());
        this.xMR.writeFields(paramVarArgs);
      }
      if (this.xMS != null)
      {
        paramVarArgs.ni(6, this.xMS.computeSize());
        this.xMS.writeFields(paramVarArgs);
      }
      if (this.xKc != null) {
        paramVarArgs.e(5, this.xKc);
      }
      AppMethodBeat.o(41817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xMO == null) {
        break label990;
      }
    }
    label990:
    for (int i = g.a.a.a.nh(1, this.xMO.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xMP != null) {
        paramInt = i + g.a.a.a.nh(2, this.xMP.computeSize());
      }
      i = paramInt;
      if (this.xMQ != null) {
        i = paramInt + g.a.a.a.nh(3, this.xMQ.computeSize());
      }
      paramInt = i;
      if (this.xMR != null) {
        paramInt = i + g.a.a.a.nh(4, this.xMR.computeSize());
      }
      i = paramInt;
      if (this.xMS != null) {
        i = paramInt + g.a.a.a.nh(6, this.xMS.computeSize());
      }
      paramInt = i;
      if (this.xKc != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.xKc);
      }
      AppMethodBeat.o(41817);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdd.xMO = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdd.xMP = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdd.xMQ = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdd.xMR = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdd.xMS = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        }
        localdd.xKc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41817);
        return 0;
      }
      AppMethodBeat.o(41817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dd
 * JD-Core Version:    0.7.0.1
 */