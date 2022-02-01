package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public f thi;
  public ai tiR;
  public ah tiS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41733);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.thi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41733);
        throw paramVarArgs;
      }
      if (this.thi != null)
      {
        paramVarArgs.ln(1, this.thi.computeSize());
        this.thi.writeFields(paramVarArgs);
      }
      if (this.tiR != null)
      {
        paramVarArgs.ln(2, this.tiR.computeSize());
        this.tiR.writeFields(paramVarArgs);
      }
      if (this.tiS != null)
      {
        paramVarArgs.ln(3, this.tiS.computeSize());
        this.tiS.writeFields(paramVarArgs);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      AppMethodBeat.o(41733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thi == null) {
        break label726;
      }
    }
    label726:
    for (int i = f.a.a.a.lm(1, this.thi.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tiR != null) {
        paramInt = i + f.a.a.a.lm(2, this.tiR.computeSize());
      }
      i = paramInt;
      if (this.tiS != null) {
        i = paramInt + f.a.a.a.lm(3, this.tiS.computeSize());
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      AppMethodBeat.o(41733);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.thi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41733);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41733);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ag localag = (ag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41733);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localag.thi = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ai();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localag.tiR = ((ai)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ah();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ah)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localag.tiS = ((ah)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        }
        localag.Desc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(41733);
        return 0;
      }
      AppMethodBeat.o(41733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ag
 * JD-Core Version:    0.7.0.1
 */