package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public f rZp;
  public ai saX;
  public ah saY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41733);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rZp == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41733);
        throw paramVarArgs;
      }
      if (this.rZp != null)
      {
        paramVarArgs.kX(1, this.rZp.computeSize());
        this.rZp.writeFields(paramVarArgs);
      }
      if (this.saX != null)
      {
        paramVarArgs.kX(2, this.saX.computeSize());
        this.saX.writeFields(paramVarArgs);
      }
      if (this.saY != null)
      {
        paramVarArgs.kX(3, this.saY.computeSize());
        this.saY.writeFields(paramVarArgs);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      AppMethodBeat.o(41733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rZp == null) {
        break label726;
      }
    }
    label726:
    for (int i = f.a.a.a.kW(1, this.rZp.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.saX != null) {
        paramInt = i + f.a.a.a.kW(2, this.saX.computeSize());
      }
      i = paramInt;
      if (this.saY != null) {
        i = paramInt + f.a.a.a.kW(3, this.saY.computeSize());
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
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.rZp == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localag.rZp = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ai();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localag.saX = ((ai)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ah();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ah)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localag.saY = ((ah)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        }
        localag.Desc = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41733);
        return 0;
      }
      AppMethodBeat.o(41733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ag
 * JD-Core Version:    0.7.0.1
 */