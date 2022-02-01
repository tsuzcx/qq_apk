package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class al
  extends com.tencent.mm.bx.a
{
  public cb sbc;
  public cb sbd;
  public cb sbe;
  public da sbf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41741);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sbc != null)
      {
        paramVarArgs.kX(1, this.sbc.computeSize());
        this.sbc.writeFields(paramVarArgs);
      }
      if (this.sbd != null)
      {
        paramVarArgs.kX(2, this.sbd.computeSize());
        this.sbd.writeFields(paramVarArgs);
      }
      if (this.sbe != null)
      {
        paramVarArgs.kX(3, this.sbe.computeSize());
        this.sbe.writeFields(paramVarArgs);
      }
      if (this.sbf != null)
      {
        paramVarArgs.kX(4, this.sbf.computeSize());
        this.sbf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41741);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sbc == null) {
        break label774;
      }
    }
    label774:
    for (int i = f.a.a.a.kW(1, this.sbc.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sbd != null) {
        paramInt = i + f.a.a.a.kW(2, this.sbd.computeSize());
      }
      i = paramInt;
      if (this.sbe != null) {
        i = paramInt + f.a.a.a.kW(3, this.sbe.computeSize());
      }
      paramInt = i;
      if (this.sbf != null) {
        paramInt = i + f.a.a.a.kW(4, this.sbf.computeSize());
      }
      AppMethodBeat.o(41741);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41741);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        al localal = (al)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41741);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localal.sbc = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localal.sbd = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localal.sbe = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41741);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new da();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((da)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localal.sbf = ((da)localObject1);
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
 * Qualified Name:     com.tencent.mm.plugin.game.d.al
 * JD-Core Version:    0.7.0.1
 */