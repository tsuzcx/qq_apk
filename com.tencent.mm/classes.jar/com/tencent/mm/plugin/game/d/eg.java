package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eg
  extends com.tencent.mm.bx.a
{
  public String ufG;
  public eh ukr;
  public af uks;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41846);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ukr != null)
      {
        paramVarArgs.lC(1, this.ukr.computeSize());
        this.ukr.writeFields(paramVarArgs);
      }
      if (this.uks != null)
      {
        paramVarArgs.lC(2, this.uks.computeSize());
        this.uks.writeFields(paramVarArgs);
      }
      if (this.ufG != null) {
        paramVarArgs.d(3, this.ufG);
      }
      AppMethodBeat.o(41846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ukr == null) {
        break label526;
      }
    }
    label526:
    for (int i = f.a.a.a.lB(1, this.ukr.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uks != null) {
        paramInt = i + f.a.a.a.lB(2, this.uks.computeSize());
      }
      i = paramInt;
      if (this.ufG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ufG);
      }
      AppMethodBeat.o(41846);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41846);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eg localeg = (eg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41846);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeg.ukr = ((eh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41846);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new af();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((af)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeg.uks = ((af)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41846);
          return 0;
        }
        localeg.ufG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41846);
        return 0;
      }
      AppMethodBeat.o(41846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.eg
 * JD-Core Version:    0.7.0.1
 */