package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bb
  extends com.tencent.mm.bw.a
{
  public ab xKX;
  public ck xKY;
  public dk xKZ;
  public boolean xLa;
  public cb xLb;
  public k xLc;
  public z xLd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256637);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xKX != null)
      {
        paramVarArgs.ni(1, this.xKX.computeSize());
        this.xKX.writeFields(paramVarArgs);
      }
      if (this.xKY != null)
      {
        paramVarArgs.ni(2, this.xKY.computeSize());
        this.xKY.writeFields(paramVarArgs);
      }
      if (this.xKZ != null)
      {
        paramVarArgs.ni(3, this.xKZ.computeSize());
        this.xKZ.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(4, this.xLa);
      if (this.xLb != null)
      {
        paramVarArgs.ni(5, this.xLb.computeSize());
        this.xLb.writeFields(paramVarArgs);
      }
      if (this.xLc != null)
      {
        paramVarArgs.ni(6, this.xLc.computeSize());
        this.xLc.writeFields(paramVarArgs);
      }
      if (this.xLd != null)
      {
        paramVarArgs.ni(7, this.xLd.computeSize());
        this.xLd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(256637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xKX == null) {
        break label1126;
      }
    }
    label1126:
    for (int i = g.a.a.a.nh(1, this.xKX.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xKY != null) {
        paramInt = i + g.a.a.a.nh(2, this.xKY.computeSize());
      }
      i = paramInt;
      if (this.xKZ != null) {
        i = paramInt + g.a.a.a.nh(3, this.xKZ.computeSize());
      }
      i += g.a.a.b.b.a.fS(4) + 1;
      paramInt = i;
      if (this.xLb != null) {
        paramInt = i + g.a.a.a.nh(5, this.xLb.computeSize());
      }
      i = paramInt;
      if (this.xLc != null) {
        i = paramInt + g.a.a.a.nh(6, this.xLc.computeSize());
      }
      paramInt = i;
      if (this.xLd != null) {
        paramInt = i + g.a.a.a.nh(7, this.xLd.computeSize());
      }
      AppMethodBeat.o(256637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256637);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bb localbb = (bb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256637);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ab();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ab)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbb.xKX = ((ab)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256637);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ck();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ck)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbb.xKY = ((ck)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256637);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbb.xKZ = ((dk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256637);
          return 0;
        case 4: 
          localbb.xLa = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(256637);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbb.xLb = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256637);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbb.xLc = ((k)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256637);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new z();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((z)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbb.xLd = ((z)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256637);
        return 0;
      }
      AppMethodBeat.o(256637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bb
 * JD-Core Version:    0.7.0.1
 */