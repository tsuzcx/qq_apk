package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bx.a
{
  public String ufG;
  public String ufH;
  public int ufI;
  public b ufJ;
  public dk ufK;
  public int ufL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41714);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ufH != null) {
        paramVarArgs.d(1, this.ufH);
      }
      paramVarArgs.aS(2, this.ufI);
      if (this.ufJ != null)
      {
        paramVarArgs.lC(3, this.ufJ.computeSize());
        this.ufJ.writeFields(paramVarArgs);
      }
      if (this.ufK != null)
      {
        paramVarArgs.lC(4, this.ufK.computeSize());
        this.ufK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.ufL);
      if (this.ufG != null) {
        paramVarArgs.d(6, this.ufG);
      }
      AppMethodBeat.o(41714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufH == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.b.b.a.e(1, this.ufH) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ufI);
      paramInt = i;
      if (this.ufJ != null) {
        paramInt = i + f.a.a.a.lB(3, this.ufJ.computeSize());
      }
      i = paramInt;
      if (this.ufK != null) {
        i = paramInt + f.a.a.a.lB(4, this.ufK.computeSize());
      }
      i += f.a.a.b.b.a.bz(5, this.ufL);
      paramInt = i;
      if (this.ufG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ufG);
      }
      AppMethodBeat.o(41714);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41714);
          return -1;
        case 1: 
          localk.ufH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41714);
          return 0;
        case 2: 
          localk.ufI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41714);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.ufJ = ((b)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.ufK = ((dk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41714);
          return 0;
        case 5: 
          localk.ufL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(41714);
          return 0;
        }
        localk.ufG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(41714);
        return 0;
      }
      AppMethodBeat.o(41714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.k
 * JD-Core Version:    0.7.0.1
 */