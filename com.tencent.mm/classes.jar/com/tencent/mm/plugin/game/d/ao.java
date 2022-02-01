package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ao
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public g uqg;
  public aq usj;
  public ap usk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41733);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uqg == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41733);
        throw paramVarArgs;
      }
      if (this.uqg != null)
      {
        paramVarArgs.lJ(1, this.uqg.computeSize());
        this.uqg.writeFields(paramVarArgs);
      }
      if (this.usj != null)
      {
        paramVarArgs.lJ(2, this.usj.computeSize());
        this.usj.writeFields(paramVarArgs);
      }
      if (this.usk != null)
      {
        paramVarArgs.lJ(3, this.usk.computeSize());
        this.usk.writeFields(paramVarArgs);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      AppMethodBeat.o(41733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uqg == null) {
        break label726;
      }
    }
    label726:
    for (int i = f.a.a.a.lI(1, this.uqg.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.usj != null) {
        paramInt = i + f.a.a.a.lI(2, this.usj.computeSize());
      }
      i = paramInt;
      if (this.usk != null) {
        i = paramInt + f.a.a.a.lI(3, this.usk.computeSize());
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
            paramVarArgs.gCg();
          }
        }
        if (this.uqg == null)
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
        ao localao = (ao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41733);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localao.uqg = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localao.usj = ((aq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ap();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ap)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localao.usk = ((ap)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        }
        localao.Desc = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41733);
        return 0;
      }
      AppMethodBeat.o(41733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ao
 * JD-Core Version:    0.7.0.1
 */