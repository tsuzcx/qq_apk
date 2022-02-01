package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ai
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public f ueZ;
  public ak ugM;
  public aj ugN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41733);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ueZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41733);
        throw paramVarArgs;
      }
      if (this.ueZ != null)
      {
        paramVarArgs.lC(1, this.ueZ.computeSize());
        this.ueZ.writeFields(paramVarArgs);
      }
      if (this.ugM != null)
      {
        paramVarArgs.lC(2, this.ugM.computeSize());
        this.ugM.writeFields(paramVarArgs);
      }
      if (this.ugN != null)
      {
        paramVarArgs.lC(3, this.ugN.computeSize());
        this.ugN.writeFields(paramVarArgs);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      AppMethodBeat.o(41733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ueZ == null) {
        break label726;
      }
    }
    label726:
    for (int i = f.a.a.a.lB(1, this.ueZ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ugM != null) {
        paramInt = i + f.a.a.a.lB(2, this.ugM.computeSize());
      }
      i = paramInt;
      if (this.ugN != null) {
        i = paramInt + f.a.a.a.lB(3, this.ugN.computeSize());
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
            paramVarArgs.gxE();
          }
        }
        if (this.ueZ == null)
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
        ai localai = (ai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41733);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localai.ueZ = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ak();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ak)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localai.ugM = ((ak)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localai.ugN = ((aj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41733);
          return 0;
        }
        localai.Desc = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41733);
        return 0;
      }
      AppMethodBeat.o(41733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ai
 * JD-Core Version:    0.7.0.1
 */