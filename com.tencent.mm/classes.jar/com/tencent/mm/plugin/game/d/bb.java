package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bb
  extends com.tencent.mm.bw.a
{
  public g uqg;
  public String uqn;
  public String ura;
  public LinkedList<bc> usL;
  
  public bb()
  {
    AppMethodBeat.i(41748);
    this.usL = new LinkedList();
    AppMethodBeat.o(41748);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41749);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uqg == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41749);
        throw paramVarArgs;
      }
      if (this.uqg != null)
      {
        paramVarArgs.lJ(1, this.uqg.computeSize());
        this.uqg.writeFields(paramVarArgs);
      }
      if (this.uqn != null) {
        paramVarArgs.d(2, this.uqn);
      }
      paramVarArgs.e(3, 8, this.usL);
      if (this.ura != null) {
        paramVarArgs.d(4, this.ura);
      }
      AppMethodBeat.o(41749);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uqg == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = f.a.a.a.lI(1, this.uqg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uqn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uqn);
      }
      i += f.a.a.a.c(3, 8, this.usL);
      paramInt = i;
      if (this.ura != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ura);
      }
      AppMethodBeat.o(41749);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.usL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.uqg == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41749);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41749);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bb localbb = (bb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41749);
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
            localbb.uqg = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        case 2: 
          localbb.uqn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41749);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbb.usL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        }
        localbb.ura = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41749);
        return 0;
      }
      AppMethodBeat.o(41749);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bb
 * JD-Core Version:    0.7.0.1
 */