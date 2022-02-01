package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public f ueZ;
  public String ufa;
  public String ufb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41708);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ufa == null)
      {
        paramVarArgs = new b("Not all required fields were included: AdURL");
        AppMethodBeat.o(41708);
        throw paramVarArgs;
      }
      if (this.ueZ != null)
      {
        paramVarArgs.lC(1, this.ueZ.computeSize());
        this.ueZ.writeFields(paramVarArgs);
      }
      if (this.ufa != null) {
        paramVarArgs.d(2, this.ufa);
      }
      if (this.ufb != null) {
        paramVarArgs.d(3, this.ufb);
      }
      AppMethodBeat.o(41708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ueZ == null) {
        break label478;
      }
    }
    label478:
    for (int i = f.a.a.a.lB(1, this.ueZ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufa != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ufa);
      }
      i = paramInt;
      if (this.ufb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ufb);
      }
      AppMethodBeat.o(41708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ufa == null)
        {
          paramVarArgs = new b("Not all required fields were included: AdURL");
          AppMethodBeat.o(41708);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41708);
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
            localc.ueZ = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41708);
          return 0;
        case 2: 
          localc.ufa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41708);
          return 0;
        }
        localc.ufb = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41708);
        return 0;
      }
      AppMethodBeat.o(41708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.c
 * JD-Core Version:    0.7.0.1
 */