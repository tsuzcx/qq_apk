package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class co
  extends com.tencent.mm.bw.a
{
  public String tiu;
  public cp tlg;
  public cp tlh;
  public cp tli;
  public cp tlj;
  public cp tlk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41817);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tlg != null)
      {
        paramVarArgs.ln(1, this.tlg.computeSize());
        this.tlg.writeFields(paramVarArgs);
      }
      if (this.tlh != null)
      {
        paramVarArgs.ln(2, this.tlh.computeSize());
        this.tlh.writeFields(paramVarArgs);
      }
      if (this.tli != null)
      {
        paramVarArgs.ln(3, this.tli.computeSize());
        this.tli.writeFields(paramVarArgs);
      }
      if (this.tlj != null)
      {
        paramVarArgs.ln(4, this.tlj.computeSize());
        this.tlj.writeFields(paramVarArgs);
      }
      if (this.tlk != null)
      {
        paramVarArgs.ln(6, this.tlk.computeSize());
        this.tlk.writeFields(paramVarArgs);
      }
      if (this.tiu != null) {
        paramVarArgs.d(5, this.tiu);
      }
      AppMethodBeat.o(41817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlg == null) {
        break label990;
      }
    }
    label990:
    for (int i = f.a.a.a.lm(1, this.tlg.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tlh != null) {
        paramInt = i + f.a.a.a.lm(2, this.tlh.computeSize());
      }
      i = paramInt;
      if (this.tli != null) {
        i = paramInt + f.a.a.a.lm(3, this.tli.computeSize());
      }
      paramInt = i;
      if (this.tlj != null) {
        paramInt = i + f.a.a.a.lm(4, this.tlj.computeSize());
      }
      i = paramInt;
      if (this.tlk != null) {
        i = paramInt + f.a.a.a.lm(6, this.tlk.computeSize());
      }
      paramInt = i;
      if (this.tiu != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.tiu);
      }
      AppMethodBeat.o(41817);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        co localco = (co)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41817);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localco.tlg = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localco.tlh = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localco.tli = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localco.tlj = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localco.tlk = ((cp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41817);
          return 0;
        }
        localco.tiu = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41817);
        return 0;
      }
      AppMethodBeat.o(41817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.co
 * JD-Core Version:    0.7.0.1
 */