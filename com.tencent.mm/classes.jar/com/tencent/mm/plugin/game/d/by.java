package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class by
  extends com.tencent.mm.bw.a
{
  public dh tkN;
  public co tkO;
  public w tkP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41797);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tkN != null)
      {
        paramVarArgs.ln(1, this.tkN.computeSize());
        this.tkN.writeFields(paramVarArgs);
      }
      if (this.tkO != null)
      {
        paramVarArgs.ln(2, this.tkO.computeSize());
        this.tkO.writeFields(paramVarArgs);
      }
      if (this.tkP != null)
      {
        paramVarArgs.ln(3, this.tkP.computeSize());
        this.tkP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41797);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tkN == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lm(1, this.tkN.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tkO != null) {
        paramInt = i + f.a.a.a.lm(2, this.tkO.computeSize());
      }
      i = paramInt;
      if (this.tkP != null) {
        i = paramInt + f.a.a.a.lm(3, this.tkP.computeSize());
      }
      AppMethodBeat.o(41797);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41797);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        by localby = (by)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41797);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localby.tkN = ((dh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41797);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localby.tkO = ((co)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41797);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new w();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((w)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localby.tkP = ((w)localObject1);
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
 * Qualified Name:     com.tencent.mm.plugin.game.d.by
 * JD-Core Version:    0.7.0.1
 */