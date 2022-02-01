package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cd
  extends com.tencent.mm.bw.a
{
  public int nJA;
  public cu uqJ;
  public String uqf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221890);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nJA);
      if (this.uqf != null) {
        paramVarArgs.d(2, this.uqf);
      }
      if (this.uqJ != null)
      {
        paramVarArgs.lJ(3, this.uqJ.computeSize());
        this.uqJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(221890);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nJA) + 0;
      paramInt = i;
      if (this.uqf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uqf);
      }
      i = paramInt;
      if (this.uqJ != null) {
        i = paramInt + f.a.a.a.lI(3, this.uqJ.computeSize());
      }
      AppMethodBeat.o(221890);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(221890);
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
        AppMethodBeat.o(221890);
        return -1;
      case 1: 
        localcd.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(221890);
        return 0;
      case 2: 
        localcd.uqf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(221890);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cu();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcd.uqJ = ((cu)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(221890);
      return 0;
    }
    AppMethodBeat.o(221890);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cd
 * JD-Core Version:    0.7.0.1
 */