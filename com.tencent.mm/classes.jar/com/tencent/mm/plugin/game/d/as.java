package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class as
  extends com.tencent.mm.bx.a
{
  public String rZW;
  public f rZp;
  public String rZt;
  public LinkedList<at> sbt;
  
  public as()
  {
    AppMethodBeat.i(41748);
    this.sbt = new LinkedList();
    AppMethodBeat.o(41748);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41749);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rZp == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41749);
        throw paramVarArgs;
      }
      if (this.rZp != null)
      {
        paramVarArgs.kX(1, this.rZp.computeSize());
        this.rZp.writeFields(paramVarArgs);
      }
      if (this.rZt != null) {
        paramVarArgs.d(2, this.rZt);
      }
      paramVarArgs.e(3, 8, this.sbt);
      if (this.rZW != null) {
        paramVarArgs.d(4, this.rZW);
      }
      AppMethodBeat.o(41749);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rZp == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = f.a.a.a.kW(1, this.rZp.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rZt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.rZt);
      }
      i += f.a.a.a.c(3, 8, this.sbt);
      paramInt = i;
      if (this.rZW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rZW);
      }
      AppMethodBeat.o(41749);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sbt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.rZp == null)
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
        as localas = (as)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41749);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localas.rZp = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        case 2: 
          localas.rZt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41749);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new at();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((at)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localas.sbt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        }
        localas.rZW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41749);
        return 0;
      }
      AppMethodBeat.o(41749);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.as
 * JD-Core Version:    0.7.0.1
 */