package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class av
  extends com.tencent.mm.bx.a
{
  public f ueZ;
  public String ufG;
  public String ufd;
  public LinkedList<aw> uhn;
  
  public av()
  {
    AppMethodBeat.i(41748);
    this.uhn = new LinkedList();
    AppMethodBeat.o(41748);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41749);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ueZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41749);
        throw paramVarArgs;
      }
      if (this.ueZ != null)
      {
        paramVarArgs.lC(1, this.ueZ.computeSize());
        this.ueZ.writeFields(paramVarArgs);
      }
      if (this.ufd != null) {
        paramVarArgs.d(2, this.ufd);
      }
      paramVarArgs.e(3, 8, this.uhn);
      if (this.ufG != null) {
        paramVarArgs.d(4, this.ufG);
      }
      AppMethodBeat.o(41749);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ueZ == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = f.a.a.a.lB(1, this.ueZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ufd != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ufd);
      }
      i += f.a.a.a.c(3, 8, this.uhn);
      paramInt = i;
      if (this.ufG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ufG);
      }
      AppMethodBeat.o(41749);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uhn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ueZ == null)
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
        av localav = (av)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41749);
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
            localav.ueZ = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        case 2: 
          localav.ufd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41749);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localav.uhn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41749);
          return 0;
        }
        localav.ufG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41749);
        return 0;
      }
      AppMethodBeat.o(41749);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.av
 * JD-Core Version:    0.7.0.1
 */