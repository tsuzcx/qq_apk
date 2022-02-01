package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public int nEf;
  public f ueZ;
  public c ufc;
  public String ufd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41709);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEf);
      if (this.ueZ != null)
      {
        paramVarArgs.lC(2, this.ueZ.computeSize());
        this.ueZ.writeFields(paramVarArgs);
      }
      if (this.ufc != null)
      {
        paramVarArgs.lC(3, this.ufc.computeSize());
        this.ufc.writeFields(paramVarArgs);
      }
      if (this.ufd != null) {
        paramVarArgs.d(4, this.ufd);
      }
      AppMethodBeat.o(41709);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nEf) + 0;
      paramInt = i;
      if (this.ueZ != null) {
        paramInt = i + f.a.a.a.lB(2, this.ueZ.computeSize());
      }
      i = paramInt;
      if (this.ufc != null) {
        i = paramInt + f.a.a.a.lB(3, this.ufc.computeSize());
      }
      paramInt = i;
      if (this.ufd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ufd);
      }
      AppMethodBeat.o(41709);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(41709);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41709);
        return -1;
      case 1: 
        locald.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(41709);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.ueZ = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41709);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.ufc = ((c)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41709);
        return 0;
      }
      locald.ufd = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(41709);
      return 0;
    }
    AppMethodBeat.o(41709);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.d
 * JD-Core Version:    0.7.0.1
 */