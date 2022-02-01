package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cj
  extends com.tencent.mm.bx.a
{
  public f ueZ;
  public String ujb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41804);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ueZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41804);
        throw paramVarArgs;
      }
      if (this.ujb == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rank");
        AppMethodBeat.o(41804);
        throw paramVarArgs;
      }
      if (this.ueZ != null)
      {
        paramVarArgs.lC(1, this.ueZ.computeSize());
        this.ueZ.writeFields(paramVarArgs);
      }
      if (this.ujb != null) {
        paramVarArgs.d(2, this.ujb);
      }
      AppMethodBeat.o(41804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ueZ == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.lB(1, this.ueZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ujb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ujb);
      }
      AppMethodBeat.o(41804);
      return i;
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
          AppMethodBeat.o(41804);
          throw paramVarArgs;
        }
        if (this.ujb == null)
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
        cj localcj = (cj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41804);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcj.ueZ = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41804);
          return 0;
        }
        localcj.ujb = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41804);
        return 0;
      }
      AppMethodBeat.o(41804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cj
 * JD-Core Version:    0.7.0.1
 */