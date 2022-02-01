package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cd
  extends com.tencent.mm.bx.a
{
  public f rZp;
  public String sda;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41804);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rZp == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41804);
        throw paramVarArgs;
      }
      if (this.sda == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rank");
        AppMethodBeat.o(41804);
        throw paramVarArgs;
      }
      if (this.rZp != null)
      {
        paramVarArgs.kX(1, this.rZp.computeSize());
        this.rZp.writeFields(paramVarArgs);
      }
      if (this.sda != null) {
        paramVarArgs.d(2, this.sda);
      }
      AppMethodBeat.o(41804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rZp == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.kW(1, this.rZp.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sda != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sda);
      }
      AppMethodBeat.o(41804);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.rZp == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41804);
          throw paramVarArgs;
        }
        if (this.sda == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rank");
          AppMethodBeat.o(41804);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41804);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cd localcd = (cd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41804);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcd.rZp = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41804);
          return 0;
        }
        localcd.sda = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41804);
        return 0;
      }
      AppMethodBeat.o(41804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cd
 * JD-Core Version:    0.7.0.1
 */