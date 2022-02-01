package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cl
  extends com.tencent.mm.bw.a
{
  public ee xMt;
  public dd xMu;
  public ad xMv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41797);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xMt != null)
      {
        paramVarArgs.ni(1, this.xMt.computeSize());
        this.xMt.writeFields(paramVarArgs);
      }
      if (this.xMu != null)
      {
        paramVarArgs.ni(2, this.xMu.computeSize());
        this.xMu.writeFields(paramVarArgs);
      }
      if (this.xMv != null)
      {
        paramVarArgs.ni(3, this.xMv.computeSize());
        this.xMv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41797);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xMt == null) {
        break label618;
      }
    }
    label618:
    for (int i = g.a.a.a.nh(1, this.xMt.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xMu != null) {
        paramInt = i + g.a.a.a.nh(2, this.xMu.computeSize());
      }
      i = paramInt;
      if (this.xMv != null) {
        i = paramInt + g.a.a.a.nh(3, this.xMv.computeSize());
      }
      AppMethodBeat.o(41797);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41797);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cl localcl = (cl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41797);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ee();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ee)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcl.xMt = ((ee)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41797);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcl.xMu = ((dd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41797);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ad();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ad)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcl.xMv = ((ad)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cl
 * JD-Core Version:    0.7.0.1
 */